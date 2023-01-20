package work2;

import java.io.*;

public class workTest {
    public static void main(String[] args) {
        File file1 = new File("./source/test01");
        File file2 = new File("./source/test02");
        File file1o = new File("./copy/test01");
        File file2o = new File("./copy/test02");
//        try {
//            copyFile(file1, file1o);
//            copyFile(file2, file2o);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        MyThread thread1 = new MyThread("thread1", file1, file1o);
        MyThread thread2 = new MyThread("thread2", file2, file2o);
        thread1.start();
        thread2.start();
    }
    public static void copyFile(File source, File dest) throws IOException {
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }
}

