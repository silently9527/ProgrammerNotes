package cn.silently9527.map.draw;

import cn.silently9527.map.TreeNode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractTreeDrawable implements Drawable {
    private static final String FONT_STYLE = "Menlo";
    private static final String IMAGE_STYLE = "PNG";
    private static final int FONT_SIZE = 15;
    private int totalLevel = 0;
    private int leftPadding = Integer.MAX_VALUE;
    private int width = 800;
    private int height = 500;

    private BufferedImage bi;
    private Graphics2D g2;

    @Override
    public void draw(String filename) throws IOException {
        initSettings();
        totalLevel = getTotalLevel(getRoot()) - 1;
        java.util.List<TreeNode> nodes = new ArrayList<>();
        nodes.add(getRoot());
        bfsAndPaint(nodes, 0, false);
        ImageIO.write(bi, IMAGE_STYLE, new File(filename));
        this.leftPadding = Integer.MAX_VALUE;
    }

    protected abstract TreeNode getRoot();

    private void initSettings() {
        //得到图片缓冲区
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //得到绘制环境(这张图片的笔)
        g2 = (Graphics2D) bi.getGraphics();
        g2.fillRect(0, 0, width, height);
        g2.setBackground(Color.WHITE);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
    }

    public void bfsAndPaint(java.util.List<TreeNode> nodes, int level, boolean repaint) {
        ArrayList<TreeNode> buff = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i);
            GraphicNode gnode;
            if (null != current) {
                gnode = new GraphicNode(level, i, totalLevel);
                int gnodeX = gnode.getPoint(repaint).x;
                int gnodeY = gnode.getPoint(repaint).y;
                g2.setColor(current.getColor());
                g2.drawString(current.getValueString() + "", gnodeX, gnodeY);
                g2.setColor(Color.BLACK);
                if (gnodeX < leftPadding && !repaint) {
                    leftPadding = gnodeX;
                }
                if (null != current.getLeft()) {
                    int leftIndex = i * 2;
                    GraphicNode gnode_left = new GraphicNode(level + 1, leftIndex, totalLevel);
                    g2.drawLine(gnodeX + 5, gnodeY, gnode_left.getPoint(repaint).x + 5, gnode_left.getPoint(repaint).y - 10);
                }
                buff.add(current.getLeft());
                if (null != current.getRight()) {
                    int rightIndex = i * 2 + 1;
                    GraphicNode gnode_right = new GraphicNode(level + 1, rightIndex, totalLevel);
                    g2.drawLine(gnodeX + 5, gnodeY, gnode_right.getPoint(repaint).x + 5, gnode_right.getPoint(repaint).y - 10);
                }
                buff.add(current.getRight());
            } else {
                buff.add(null);
                buff.add(null);
            }
        }
        if (isBuffEmpty(buff)) {
        } else {
            bfsAndPaint(buff, level + 1, repaint);
        }
    }

    private boolean isBuffEmpty(java.util.List<TreeNode> list) {
        boolean ret = true;
        for (TreeNode node : list) {
            if (null != node) {
                ret = false;
            }
        }
        return ret;
    }

    private int getTotalLevel(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(getTotalLevel(node.getLeft()), getTotalLevel(node.getRight())) + 1;
    }


    private class GraphicNode {
        private Point p;
        private int level;
        private int index;
        public static final int LOWEST_PADDING = 20;// padding of lowest level. first level is 0
        public static final int LEVEL_PADDING = 30;//padding between levels
        private int totalLevel;

        public GraphicNode(int level, int index, int totalLevel) { //total level is equal to lowest level
            this.level = level;
            this.index = index;
            this.totalLevel = totalLevel;
            this.p = computeP(this.level, this.index);
        }

        private Point computeP(int level, int index) {
            int x = 0;
            for (int i = this.totalLevel; i > level; i--) {
                x += getLevelPadding(i) / 2;
            }
            x += getLevelPadding(level) * index;
            int y = LEVEL_PADDING * (level + 1);
            return new Point(x, y);
        }

        public Point getPoint(boolean repaint) {
            if (repaint) {
                return new Point(p.x - leftPadding, p.y);
            }
            return p;
        }

        private int getLevelPadding(int level) {
            return (int) (LOWEST_PADDING * Math.pow(2, this.totalLevel - level));
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }


}