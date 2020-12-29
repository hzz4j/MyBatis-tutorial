package edu.cau;

public enum Level {
    LOW(1),
    MEDIUM(2),
    HIGHT(3);

    private final int val;
    private Level(int val){this.val = val;}

    public int getVal(){
        return val;
    }
}
