package adapterPattern;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private ListADT<T> list = new ArrayList<>();


    public synchronized void put(T element) throws InterruptedException
    {

        if(element == null)
            throw new IllegalArgumentException("Tried to add null element");

            while(list.isFull())
            {
               // System.out.println("BLOCKINGQUEUE, PUT METHOD - LIST IS FULL");
                wait();
            }
            list.add(element);
      //  System.out.println("BLOCKINGQUEUE, PUT METHOD - ADDING : " + element + " TO THE LIST");
             notifyAll();
             Thread.sleep(1000);

        }


    public synchronized T take() throws InterruptedException
    {
       while (list.isEmpty())
       {
           System.out.println("if list is empty");
           wait();
       }
       T value = list.remove(list.size()-1);
       notifyAll();
       Thread.sleep(1000);
        System.out.println(value);
       return value;
    }

    public synchronized boolean isFull()
    {
        return list.isFull();
    }

    public synchronized boolean isEmpty()
    {
        return list.isEmpty();
    }

    public synchronized int size()
    {
        return list.size();
    }
}
