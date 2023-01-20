package work2;

import java.io.File;
import java.io.IOException;

public class MyThread extends Thread{
    private File file1;
    private File file2;

    public MyThread(String Threadname, File _file1, File _file2) {
        super(Threadname);
        this.file1 = _file1;
        this.file2 = _file2;
    }

    @Override
    public void run() {
        try {
            workTest.copyFile(file1, file2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
