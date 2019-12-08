package com._520.leetcode._11_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迷宫类
 */
public class Maze {

    private static Stack<Position> stack = new Stack<>();
    private static List<Position> list = new ArrayList<>();
    public static void canGo(int[][] m){
//        if (m[0][0] == 0)
//            list.add(new Position(0,0,true));
        for (int i = 0; i < 5;) {
            for (int j = 0; j < 5;) {

                if (m[i][j] == 0){
                    list.add(new Position(i,j,true));
                    j++;
                }else{
                    j--;
                    i++;
                }

            }
        }
    }
    public static void main(String[] args) {
        int[][] mize = {
            {0,1,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,1,0}
        };
        canGo(mize);
        System.out.println(list);
    }
}
