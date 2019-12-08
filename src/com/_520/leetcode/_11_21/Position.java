package com._520.leetcode._11_21;

/**
 * 记录位置
 */
public class Position {
    private int x;
    private int y;
    private boolean canGo = false;

    public Position(int x, int y, boolean canGo) {
        this.x = x;
        this.y = y;
        this.canGo = canGo;
    }

    public boolean isCanGo() {
        return canGo;
    }

    public void setCanGo(boolean canGo) {
        this.canGo = canGo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
