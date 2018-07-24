package test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author ji.xie
 * @Filename EightQueenTest.java
 * @description 8皇后问题
 * 8*8棋盘摆放8个互不干扰的皇后
 * 解决思路：
 * 以行为基点，来放皇后，然后标记不可走路段
 * 第二行……依次类推
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/26 10:30</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class EightQueenTest {
    /**
     * 棋盘
     */
    private static int[][] CHESSBOARD = new int[8][8];

    /**
     * @Description 解法
     * @Params
     * @Return
     * @Exceptions
     */
    @Test
    public void deal() {
        for (int i = 0; i < CHESSBOARD.length; i++) {
            for (int j = 0; j < CHESSBOARD[i].length; j++) {
                if (judge(i, j)) {
                    //放置皇后
                    CHESSBOARD[i][j] = 1;
                    System.out.println("皇后坐标:" + "(" + i + "," + j + ")");
                }
            }
        }
    }

    /**
     * 判断此坐标是否可放皇后
     */
    private boolean judge(int row, int col) {
        //1.判断横坐标是否有皇后
        for (int c = 0; c < CHESSBOARD.length; c++) {
            if (CHESSBOARD[row][c] == 1) {
                return false;
            }
        }
        //2.判断纵坐标是否有皇后
        for (int r = 0; r < CHESSBOARD.length; r++) {
            if (CHESSBOARD[r][col] == 1) {
                return false;
            }
        }
        //3.判断斜线是否有皇后
        for (int x = 0; x < CHESSBOARD.length; x++) {
            int row_t = row;
            int col_t = col;
            if (6 >= row_t && 6 >= col_t) {
                ++row_t;
                ++col_t;
                if (CHESSBOARD[row_t][col_t] == 1) {
                    return false;
                }
            }

            int row_minus = row;
            int col_minus = col;
            if (1 <= row_minus && 1 <= col_minus) {
                --row_minus;
                --col_minus;
                if (CHESSBOARD[row_minus][col_minus] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}