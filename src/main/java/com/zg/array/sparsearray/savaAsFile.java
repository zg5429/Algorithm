package com.zg.array.sparsearray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhuguang
 * @Project_name Algorithm
 * @Package_name com.zg.array.sparsearray
 * @date 2021-01-14-11:41
 */
public class savaAsFile {

    public  static void savaArray(int[][] arr) throws IOException {

        File file = new File("map.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length-1; j++) {
                fileWriter.write(arr[i][j]+",");
            }
            fileWriter.write(arr[i][arr[0].length-1]+"");
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
        
    }


}
