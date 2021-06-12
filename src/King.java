import adapterPattern.ArrayList;
import adapterPattern.ListADT;

import java.util.Random;

public class King implements Runnable
{

    TreasureRoom treasureRoom;


    public King(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void run()
    {

        try {
            int min = 20;
            int max = 100;

            Random random = new Random();
            int result = random.nextInt(max - min) + min;

            Thread.sleep(5000);

            treasureRoom.acquireWrite("King");
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa result " + result);
            ListADT<Valuables> valuables = treasureRoom.takeValuablesFromTheTreasureRoom("King", result);
            if(valuables != null)

            {
                Logger.getInstance().addAction(" enough valuables, King can throw a party now");
            }
            else
            {
                Logger.getInstance().addAction(" Treasure room is empty, King can't throw a party");
            }
            treasureRoom.releaseWrite("King");

            Thread.sleep(4000);


        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}
