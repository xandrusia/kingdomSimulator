import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Valuables {

    public static int getValue() {
        return 10;
    }

    public enum Key
    {

        diamond (10), ruby(10), emerald(10), gold(10), amethyst(10);

        private final int value;

        Key(int value)
        {
            this.value = value;
        }
    }


    private static Map<Key, Valuables> allValuables = new HashMap<>();

    private Key key;
    private int value;

    private Valuables(Key key)
    {

        this.key = key;


    }

    public static Valuables getInstance(Key key)
    {
        Valuables instance = allValuables.get(key);
        //Valuables instance = Valuables.getInstance(getRandomValuable());
        if(instance == null)
        {
            synchronized (allValuables)
            {
                instance = allValuables.get(key);
                if(instance == null)
                {
                    instance = new Valuables(key);
                    allValuables.put(key, instance);
                }
            }
        }
        return instance;
    }

    public static Valuables getRandomValuable()
    {
        int rand = new Random().nextInt(Key.values().length-1);
        System.out.println("invoking getRandomValuables()..." + rand);
        Valuables i = Valuables.getInstance(Key.values()[rand]);
        System.out.println(i.toString() + " valuable");
        return i;

    }

    public int getValue(Valuables valuables)
    {
       // return key.value;
        return 10;
    }

    public String toString()
    {
        return key.name();
    }























  /*  private static Map<String, Valuables> allValuables = new HashMap<>();
    private String key;

    private Valuables(String key)
    {
        this.key = key;
    }

    public static Valuables getInstance(String key)
    {
        Valuables instance = allValuables.get(key);
        if(instance == null)
        {
            synchronized (allValuables) {
                instance = allValuables.get(key);
                if(instance == null)
                {
                    instance = new Valuables(key);
                    allValuables.put(key, instance);
                }
            }
        }
        return instance;
    }

   */

}
