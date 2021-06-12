public interface TreasureRoomDoor {

    void releaseRead(String actor);

    void acquireRead(String actor);

    void acquireWrite(String actor);

    void releaseWrite(String actor);

    void addValuablesToTheTreasureRoom(String actor, Valuables valuables);

}
