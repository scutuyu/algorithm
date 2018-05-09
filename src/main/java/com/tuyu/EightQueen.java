package com.tuyu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 八皇后问题
 * <p>递归回溯法</p>
 */
public class EightQueen {

    private static final Logger logger = LoggerFactory.getLogger(EightQueen.class);

    private static final int row = 8; //行数
    private static final int col = 8; //列数
    private static int[][] chess = new int[row][col];

    public static void main( String[] args ){
        // 从第0行开始，一直递归到最后一行
        mySettleQueen(0);
        printChess();
        printIndex();
    }

    private static void printIndex(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (chess[i][j] == 1){
                    System.out.print("[" + i + ", " + j + "]");
                }
            }
        }
        System.out.println("\n");
    }

    private static void printChess(){
        System.out.print("  0 1 2 3 4 5 6 7 \n");
        for (int i = 0; i < row; i++){
            System.out.print(i + " ");
            for (int j = 0; j < col; j++){
                if (chess[i][j] == 1){
                    System.out.print("■ ");
                }else {
                    System.out.print("□ ");
                }
            }
            System.out.print("\n");
        }
    }

    private static void clearRow(int index){
        // 当前行数据清空
        for (int n = 0; n < col; n++){
            chess[index][n] = 0;
        }
    }

    private static boolean mySettleQueen(int r){
        if (r == row){ // 为最后一行设置Queen时返回true，因为这行的结果不会影响其他的行
            return true;
        }
        for (int index = 0; index < col; index++){ // 从第一列遍历到最后一列
            // 当前行元素都清零,为回溯做铺垫
            clearRow(r);
            if (myCheck(r, index)){
                chess[r][index] = 1;
                if (mySettleQueen(r + 1)){// 递归,如果返回false则回溯
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean myCheck(int i, int j){
        int sum = i + j; // 同一条斜线上的元素的索引的和相等
        int sub = i - j; // 或者 同一条斜线上的元素的索引的差相等
        for (int m = sum >= row ? row - 1 : sum; m >= 0 && sum - m < col; m--){
             if (chess[m][sum - m] == 1){
                 return false;
             }
        }
        for (int m = sub <= 0 ? 0 : sub; m < row && m - sub < row; m++){
             if (chess[m][m - sub] == 1){
                 return false;
             }
        }
        for (int m = 0; m < row; m++){
             if (chess[m][j] == 1){
                 return false;
             }
        }
        return true;
    }
}
