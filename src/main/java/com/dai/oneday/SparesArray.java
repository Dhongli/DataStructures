package com.dai.oneday;


public class SparesArray {
    public static void main(String[] args) {
        // 创建原始的二维数组11*11
        // 0表示没有棋子,1表示白子,2表示黑子
        int[][] chessArray1 = new int[11][11];
        chessArray1[2][3] = 1;
        chessArray1[3][4] = 2;
        chessArray1[4][5] = 2;
        // 打印棋盘
        printOut(chessArray1,"*******打印原始数组*********");

        int[][] sparesArray = getSparesArray(chessArray1);
        printOut(sparesArray, "*******打印稀疏数组*********");

        // 打印还原棋盘
        printOut(toReduce(sparesArray), "*******打印还原数组*********");
    }

    private static void printOut(int[][] array, String log) {
        System.out.println(log);
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    private static int[][] toReduce(int[][] sparesArray) {

        int[][] chessArray = new int[sparesArray[0][0]][sparesArray[0][1]];
        for (int i = 1; i < sparesArray.length; i++) {
            chessArray[sparesArray[i][0]][sparesArray[i][1]] = sparesArray[i][2];
        }
        return chessArray;
    }

    private static int[][] getSparesArray(int[][]chessArray1) {
        int sum = 0;
        // 算出原始数组有多少个不为零的数
        for (int[] row : chessArray1) {
            for (int item : row) {
                if (item != 0){
                    sum++;
                }
            }
        }
        // 创建稀疏数组
        int[][] sparesArray = new int[sum+1][3];
        // 稀疏数组第一行
        sparesArray[0][0] = chessArray1.length; // 原始数组行数
        sparesArray[0][1] = chessArray1[1].length; // 原始数组列数
        sparesArray[0][2] = sum; //原始数组非0的个数
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
               if (chessArray1[i][j] != 0){
                   sparesArray[++count][0] = i;
                   sparesArray[count][1] = j;
                   sparesArray[count][2] = chessArray1[i][j];
               }
            }
        }
        return sparesArray;
    }
}
