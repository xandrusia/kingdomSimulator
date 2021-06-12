public class Miner implements Runnable {

    private Deposit deposit;
    private Mine mine;

    public Miner( Deposit deposit, Mine mine)
    {
        this.deposit = deposit;
        this.mine = mine;
    }



    @Override
    public void run()
    {

        while (true)
        {
            try {

                Valuables v = mine.dig();
                deposit.addValuableToTheDeposit(v);

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }


        }



    }




}
