package com.zg.array.sparsearray;

import java.io.IOException;

import static com.zg.array.sparsearray.savaAsFile.savaArray;

/**
 * @author zhuguang
 * @Project_name Algorithm
 * @Package_name com.zg.array.sparseaArrsy
 * @date 2021-01-14-10:44
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        将二维数组转化为稀疏数组
//        1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

//        2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
//        给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

//        遍历二维数组 将非0的值存到sparaseArray
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

//        输出稀疏数组
        System.out.println("稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);

        }
        System.out.println();


//        将稀疏数组转化为原始二维数组
//      1.  先读取稀疏数组的第一行 根据第一行的数据创建二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


      savaArray(chessArr1);


    }

}
