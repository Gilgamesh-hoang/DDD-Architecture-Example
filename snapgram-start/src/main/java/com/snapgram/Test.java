package com.snapgram;

import java.io.File;

public class Test {
    public static void printDirectoryTree(File folder, String indent) {
        if (folder == null || !folder.exists()) return;

        String name = folder.getName();

        // Bỏ qua một số thư mục không cần thiết
        if (name.equalsIgnoreCase("build") || name.equalsIgnoreCase(".gradle") || name.equalsIgnoreCase(".idea")) {
            return;
        }

        System.out.println(indent + "|_" + name);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    printDirectoryTree(file, indent + "   ");
                }
            }
        }
    }

    public static void main(String[] args) {
        File root = new File("E:\\spingboot\\Snapgram-DDD");
        printDirectoryTree(root, "");
    }
}
