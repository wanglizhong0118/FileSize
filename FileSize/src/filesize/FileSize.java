/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesize;

import java.io.File;

/**
 *
 * @author allwi
 */
public class FileSize {

    public static String fileName = "E://Database/ver_feature_quarter/publish/";
    
    
    String ver_complete_database_publish = "E://Database/ver_complete/publish/";
    String ver_feature_full_database_publish = "E://Database/ver_feature_full/publish/";
    String ver_feature_half_database_publish = "E://Database/ver_feature_half/publish/";
    String ver_feature_quarter_database_publish = "E://Database/ver_feature_quarter/publish/";

    // 递归方式 计算文件的大小
    private long getTotalSizeOfFilesInDir(final File file) {
        if (file.isFile()) {
            return file.length();
        }
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null) {
            for (final File child : children) {
                total += getTotalSizeOfFilesInDir(child);
            }
        }
        return total;
    }

    public static void main(final String[] args) {
        final long start = System.nanoTime();
        final long total = new FileSize()
                .getTotalSizeOfFilesInDir(new File(fileName));
        final long end = System.nanoTime();
        System.out.println("Total Size: " + total);
        System.out.println("Time taken: " + (end - start) / 1.0e9);
    }

}
