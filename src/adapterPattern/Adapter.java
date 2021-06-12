package adapterPattern;

public class Adapter<T> {


ArrayList<T> arrayList;

public Adapter(ArrayList<T> arrayList)
{
    this.arrayList = arrayList;
}

    public void put(T x) throws InterruptedException {

     arrayList.add(x);

    }
    public boolean isFull()
    {
        return arrayList.isFull();
    }


}
