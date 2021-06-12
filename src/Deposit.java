import adapterPattern.BlockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;

public class Deposit {

    BlockingQueue<Valuables> depositVal;
    public Deposit() {
        this.depositVal = new BlockingQueue<Valuables>();
    }



    public synchronized void addValuableToTheDeposit(Valuables valuables) throws InterruptedException {

        System.out.println("check deposit");
        System.out.println("valuable : " + valuables);
        depositVal.put(valuables);
        Logger.getInstance().addAction(" Miner added valuables to the deposit");
        System.out.println(depositVal +  " : value of deposit ");
        notifyAll();
    }



    public synchronized Valuables takeValuablesFromTheDeposit() throws InterruptedException {

        while(depositVal.isEmpty())
        {
            try
            {
                wait();
                Logger.getInstance().addAction(" Deposit is empty, Valuable Transporter has nothing to take from the deposit ");

            }
            catch (InterruptedException e)
            {
                //
            }

        }
        Valuables valuables;
        valuables = depositVal.take();
        //treasureRoom.addValuablesToTheTreasureRoom("ValuableTransporter",valuables);
        Logger.getInstance().addAction("Valuable transporter is transporting the valuables");
        return valuables;
    }




}
