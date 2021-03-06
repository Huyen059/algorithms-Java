package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) {
        File basedir = new File("basedir");
        Test test = new Test();
        test.findDeepestFile(basedir);
        System.out.println(test.name);
    }



    public static String findDirWithMaxNumberOfFiles(String path) {
        File basedir = new File(path);
        var dirs = basedir.listFiles();
        if (dirs == null) {
            return "";
        }

        int max = 0;
        String result = "";
        for (File dir: dirs) {
            int num = getNumberOfFilesInADir(dir);
            if (num > max) {
                max = num;
                result = dir.getName();
            }
        }
        return result + " " + max;
    }
    public static int getNumberOfFilesInADir(File dir) {
        var subdirs = dir.listFiles();
        if (subdirs == null) {
            return 0;
        }
        int count = 0;
        for (File subdir: subdirs) {
            if (subdir.isFile()) {
                count++;
                continue;
            }

            count += getNumberOfFilesInADir(subdir);
        }
        return count;
    }

    public static String findEmptySubdir(String path) {
        File file = new File(path);
        StringBuilder out = new StringBuilder();
        var dirs = file.listFiles();
        if (dirs != null) {
            for (File dir: dirs) {
                File[] subdirs = dir.listFiles();
                if (subdirs != null) {
                    for (File subdir : subdirs) {
                        if (!isOrContainsFile(subdir)) {
                            out.append(subdir.getName() + " ");
                        }
                    }
                }

            }
        }

        return out.toString();
    }
    public static boolean isOrContainsFile(File file) {
        if (file.isFile()) {
            return true;
        }
        var files = file.listFiles();

        for (File fi: files) {
            boolean result = isOrContainsFile(fi);
            if (result) {
                return true;
            }
        }

        return false;
    }
}

class Test {
    int level = 0;
    int deepestLevel = 0;
    String name = "";


    public void findDeepestFile(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            if (level > deepestLevel) {
                deepestLevel = level;
                name = file.getName();
                level--;
            }
        } else {
            level++;
            for (var subFile: files) {
                findDeepestFile(subFile);
            }
            level--;
        }
    }
}
