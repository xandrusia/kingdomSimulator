import adapterPattern.ArrayList;
import adapterPattern.ListADT;

public class TreasureRoom implements TreasureRoomDoor {

    private boolean activeWriter;

    private int activeReaders;

    private int waitingReaders;

    private int waitingWriters;


    ArrayList <Valuables> valuableList = new ArrayList();


    @Override
    public synchronized void releaseRead(String actor) {
        activeReaders--;
        Logger.getInstance().addAction(actor + " has finished calculating");
        if (activeReaders == 0)
            notifyAll();
    }

    @Override
    public synchronized void acquireRead(String actor)

    {
        waitingReaders++;
        while (activeWriter || waitingWriters > 0) {
            try {
                Logger.getInstance().addAction(" Someone is in the treasure room " + actor + " has to wait");
                wait();
            } catch (InterruptedException e) {
                //
            }
        }

        activeReaders++;
        Logger.getInstance().addAction(actor + " has just started calculating");
    }

    @Override
    public synchronized void acquireWrite(String actor) {
        waitingWriters++;
        while (activeReaders > 0 || activeWriter)
        {
            try
            {
                Logger.getInstance().addAction(" Accountants are reading, " + actor + " has to wait");
                wait();
            } catch (InterruptedException e) {
                //
            }
        }
        waitingWriters--;
        activeWriter = true;
        Logger.getInstance().addAction(actor + " enters the treasure room");
    }

    @Override
    public synchronized void releaseWrite(String actor) {
        activeWriter = false;
        Logger.getInstance().addAction(actor + " goes out of treasure room");
        notifyAll();
    }

    @Override
    public synchronized void addValuablesToTheTreasureRoom(String actor, Valuables valuables) {
        valuableList.add(valuables);
        Logger.getInstance().addAction(actor + " added " + valuables + " to the treasure room. " + " Size of treasure room now :  " + valuableList.size() );
    }

    public synchronized ListADT<Valuables> takeValuablesFromTheTreasureRoom(String actor, int number) {

        ArrayList<Valuables> KingPockets = new ArrayList<>();
        int sum = 0;

        while (sum >= number)
        for (int i = 0; i < valuableList.size(); i++) {

                KingPockets.add(valuableList.get(i));
                sum += valuableList.get(i).getValue();
                valuableList.remove(i);

        }

        return KingPockets;
    }

    public synchronized int countValuables()
    {
        int count = 0;
        for(int i = 0; i < valuableList.size(); i++)
        {
            count = count + 10;
        }
        return count;
    }


}
