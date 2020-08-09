package com.ginkgo.datastruct;

/**
 * 稀疏数组
 * <p>
 * 二维数组转稀疏数组的的思路
 * <p>
 * 1. 遍历原始的二维数组，得到有效数据的个数sum
 * 2. 根据sum就可以创建稀疏数组SparseArr int[sum+1][3]
 * 3. 将二维数组的有效数据存入到稀疏数组中去
 * <p>
 * <p>
 * 稀疏数组转二维数组的思路
 * 1. 先读取稀疏数组的第一行，创建原始的二维数组 chessArr2 = int[11][11]
 * 2. 再读取稀疏数组中后面每行的数据，插入到原始数据中去
 */
public class SparseArray {
    public int[][] convertArr2ToSparseArr2(int[][] arr2) {
        // 统计有多少个非零的值
        int sum = 0;
        for (int[] ints : arr2) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = arr2.length;
        sparseArr[0][1] = arr2[0].length;
        sparseArr[0][2] = sum;

        int count = 1;

        // 重新遍历原二维数组，同时给稀疏数组赋值
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr2[i][j];
                    count++;
                }
            }
        }

        return sparseArr;
    }

    public int[][] convertSparseArrToArr2(int[][] sparseArr) {
        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i <= sparseArr[0][2]; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        return arr2;
    }

    public static void outputArr2(int[][] arr2) {
        for (int[] row : arr2) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
