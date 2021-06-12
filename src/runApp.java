public class runApp {

    public static void main(String[] args) {



        Deposit deposit = new Deposit();

        TreasureRoom treasureRoom = new TreasureRoom();


        Mine mine = new Mine();

        Thread m1  = new Thread(new Miner(deposit, mine));
        //Thread m2  = new Thread(new Miner(monitorProdCons, deposit, mine));


        Thread t1  = new Thread(new ValuableTransporter(deposit, treasureRoom));
       // Thread t2  = new Thread(new ValuableTransporter(deposit, treasureRoom));



        m1.setName(" Miner 1");
       //m2.setName(" Miner 2");


        t1.setName(" ValuableTransporter number 1");
       // t2.setName(" ValuableTransporter number 2");



        m1.start();
       // m2.start();


        t1.start();
       // t2.start();




        Thread king = new Thread(new King(treasureRoom));

        Thread accountant = new Thread(new Accountant(treasureRoom));


        king.setName(" King ");
        accountant.setName(" Accountant ");
        king.start();
        accountant.start();





    }

}
