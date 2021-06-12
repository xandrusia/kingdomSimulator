import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable {


private Deposit deposit;
private TreasureRoom treasureRoom;

private ArrayList<Valuables> valuables = new ArrayList<>();

    public ValuableTransporter(Deposit deposit, TreasureRoom treasureRoom)
    {
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;

    }


    @Override
    public void run() {
        int max = 200;
        int min = 50;

        Random random = new Random();
        int result = random.nextInt(max - min) + min;
        try {
            while (valuables.size() * 10 <= result) {
                Thread.sleep(3000);
                Valuables v = deposit.takeValuablesFromTheDeposit();
                valuables.add(v);
                Logger.getInstance().addAction("Valuable transporter has just taken valuables from the deposit : " + v.getValue());
                treasureRoom.addValuablesToTheTreasureRoom("ValuableTransporter", v);
                Logger.getInstance().addAction("Valuable Transporter has just put valuable : " + v + " into the treasure room");

            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }













































  /*  public void run()
    {

        int maxVal = 200;
        int minVal = 50;

        Random random = new Random();
        int result = random.nextInt(maxVal-minVal) + minVal;
        System.out.println("kurwa");

        while(getValueOfValuable(valuables) <= result)
        {
            // ArrayList<Valuables> valuables;
            Valuables val = null;
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            try {
                Thread.sleep(2000);
                val = deposit.takeValuablesFromTheDeposit();
                System.out.println(val + " Trnasporter val");
                if(val != null)
                {
                    //treasureRoom.addValuablesToTheTreasureRoom("ValuableTransporter",);
                    valuables.add(val);
                    Logger.getInstance().addAction("Valuable transporter has just taken valuables from the deposit" + val.getValue());
                    //System.out.println("transporting valuables to the treasure room - ValuableTransporter");
                }

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            for(int i = 0; i < valuables.size(); i++)
        {
            treasureRoom.addValuablesToTheTreasureRoom("ValuableTransporter", valuables.get(i));
            Logger.getInstance().addAction("Valuable transporter added valuables : " + valuables.get(i) + " to the Treasure room");
        }
           // valuables.add(val);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        //valuables.clear();

    }

   */

    public static int getValueOfValuable(ArrayList<Valuables> valuables){
        int totalValue=0;
        for (int i=0; i<valuables.size(); i++){
            int totalval= valuables.get(i).getValue();
           totalValue=+ totalval;
        }
        return totalValue;
    }




}
