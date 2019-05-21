import java.util.List;
import java.util.ArrayList;

public class Squad {
    private String mName;
    private String mCause;
    private String mMax;
    private static List<Squad> instances = new ArrayList <Squad>();


    public Squad(String name, String cause, String max) {
        mName = name;
        mCause = cause;
        mMax = max;
        instances.add(this);
    }
    public String getName(){return mName;}
    public String getCause(){return mCause;}
    public String getMax(){return mMax;}

    public static List<Squad> all() {return instances;}

}
