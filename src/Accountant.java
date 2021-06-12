import adapterPattern.ArrayList;
import adapterPattern.ListADT;

import java.util.List;

public class Accountant implements Runnable{

    private TreasureRoom treasureRoom;

    public Accountant (TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                treasureRoom.acquireRead("Accountant");
                Thread.sleep(5000);
                int count = treasureRoom.countValuables();
                Logger.getInstance().addAction("Accountant is calculating the total sum of valuables in the treasure room : " + count);
                treasureRoom.releaseRead("Accountant");
            }
            catch (InterruptedException e)
            {
                //
            }
        }
    }

}
