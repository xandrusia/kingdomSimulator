import adapterPattern.BlockingQueue;

public class Mine
{

    private Valuables valuables;


    BlockingQueue<Valuables> depositVal;
    public Mine() {
        this.depositVal = new BlockingQueue<Valuables>();
    }



    public Valuables getNewValuable()
    {
        return Valuables.getRandomValuable();
    }

    public synchronized Valuables dig() throws InterruptedException {
        Valuables val = null;


        val = Valuables.getRandomValuable();
        System.out.println(val.toString());

        System.out.println(Thread.currentThread().getName() + " digging valuables .. " + Valuables.getRandomValuable() + " worth: " + Valuables.getValue());
        return val;

    }

}
