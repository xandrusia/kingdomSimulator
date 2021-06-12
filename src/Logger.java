import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    //private File logFile;
    private static Logger instance;
    private static Lock lock = new ReentrantLock();

    Logger()
    {

    }

    public synchronized static Logger getInstance()
    {
        if(instance == null)
        {
            synchronized (lock) {
                if(instance == null)
                instance = new Logger();
            }
        }
        return instance;
    }


    public void addAction(String text)
    {
        System.out.println(text);
    }




}
