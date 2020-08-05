package com.ginkgo.datastruct;

import org.junit.Assert;
import org.junit.Test;

public class SparseArrayTest {
    SparseArray sparseArray = new SparseArray();

    @Test
    public void shouldGenerateCorrectSparseArr() {
        int chessArr1[][] = new int[11][12];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        int[][] expectArray = new int[][]{
                {11, 12, 2}, {1, 2, 1}, {2, 4, 2}
        };
        Assert.assertArrayEquals("生成的稀疏数组不正确", expectArray, sparseArray.convertArr2ToSparseArr2(chessArr1));
    }

    @Test
    public void shouldConvertSparseArrToOriginOne() {
        int chessArr1[][] = new int[11][12];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        Assert.assertArrayEquals("无法还原成原数组", chessArr1,
                sparseArray.convertSparseArrToArr2(sparseArray.convertArr2ToSparseArr2(chessArr1)));
    }
}
