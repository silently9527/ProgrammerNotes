package cn.silently9527.map;

import java.awt.*;

public interface TreeNode {
    TreeNode getLeft();

    TreeNode getRight();

    String getValueString();

    default Color getColor() {
        return Color.BLACK;
    }
}
