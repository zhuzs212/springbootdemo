package com.zhuzs.admin.zhuzsdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 多线程复制文件
 */
public class FileCopyUtil {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/zhuzs/zhuzs/1.代码评审记录.txt");
        // 创建线程池，核心线程数为CPU核心数
        int corePoolSizse = Runtime.getRuntime().availableProcessors();
        startThread(corePoolSizse + 2, file.length(), "/Users/zhuzs/zhuzs/1.代码评审记录.txt",
                "/Users/zhuzs/zhuzs/1.代码评审记录01.txt");
    }

    /**
     * 开启多线程复制
     *
     * @param threadNum      线程数
     * @param fileLength     文件大小（用于确认每个线程下载多少东西）
     * @param sourceFilePath 源文件目录
     * @param desFilePath    目标文件目录
     */
    public static void startThread(int threadNum, long fileLength, String sourceFilePath, String desFilePath) {
        long modLength = fileLength % threadNum;
        long desLength = fileLength / threadNum;
        System.out.println("desLength:" + desLength);
        for (int i = 0; i < threadNum; i++) {
            System.out.println((desLength * i) + "-----" + (desLength * (i + 1)));
            new FileWriteThread((desLength * i), (desLength * (i + 1)), sourceFilePath, desFilePath).start();
        }
        if (modLength != 0) {
            System.out.println("最后的文件写入");
            System.out.println((desLength * threadNum) + "-----" + (desLength * threadNum + modLength));
            new FileWriteThread((desLength * threadNum), desLength * threadNum + modLength + 1, sourceFilePath,
                    desFilePath).start();
        }
    }

    /**
     * 写线程：指定文件开始位置、目标位置、源文件、目标文件，
     */
    static class FileWriteThread extends Thread {
        // 文件开始位置
        private long begin;
        // 文件结束位置
        private long end;
        // 源文件
        private RandomAccessFile sourceFile;
        // 目标文件
        private RandomAccessFile desFile;

        public FileWriteThread(long begin, long end, String sourceFilePath, String desFilePath) {
            this.begin = begin;
            this.end = end;
            try {
                this.sourceFile = new RandomAccessFile(sourceFilePath, "rw");
                this.desFile = new RandomAccessFile(desFilePath, "rw");
            } catch (FileNotFoundException e) {
            }
        }

        @Override
        public void run() {
            try {
                sourceFile.seek(begin);
                desFile.seek(begin);
                int hasRead = 0;
                byte[] buffer = new byte[1];
                while (begin < end && -1 != (hasRead = sourceFile.read(buffer))) {
                    begin += hasRead;
                    desFile.write(buffer, 0, hasRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    sourceFile.close();
                    desFile.close();
                } catch (Exception e) {
                }
            }
        }
    }
}