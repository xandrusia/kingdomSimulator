public class TreasureRoomGuardsman implements TreasureRoomDoor{

    TreasureRoom treasureRoom;

    public TreasureRoomGuardsman(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
    }


    @Override
    public void releaseRead(String actor)
    {

        if(actor == "Accountant")
        {
            Logger.getInstance().addAction("Guardian released read access from : " + actor);
            treasureRoom.releaseRead(actor);
        }

    }

    @Override
    public void acquireRead(String actor)
    {
        if(actor == "King" || actor == "ValuableTransporter")
        {
            Logger.getInstance().addAction("");
        }
    }

    @Override
    public void acquireWrite(String actor)
    {
        if(actor == "King" || actor == "ValuableTransporter")
        {
            treasureRoom.acquireWrite(actor);
            Logger.getInstance().addAction(" Guardian handed over write access to treasure room to : " + actor);

        }
    }

    @Override
    public void releaseWrite(String actor)
    {
        if(actor == "King" || actor == "ValuableTransporter")
        {
            treasureRoom.releaseWrite(actor);
            Logger.getInstance().addAction(" Guardian released write access from : " + actor);

        }
    }

    @Override
    public void addValuablesToTheTreasureRoom(String actor, Valuables valuables)
    {
        if(actor == "King" || actor == "ValuableTransporter")
        {
            Logger.getInstance().addAction(" Guardian gave a permission to : " + actor + " to add valuables to the treasure room" );
           // treasureRoom.addValuablesToTheTreasureRoom(actor, valuables);
        }
    }
}
