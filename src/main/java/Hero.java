import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hero {
    private String mName;
    private Integer mAge;
    private String mPower;
    private String mWeakness;
    private boolean mCompleted;
    private LocalDateTime mCreatedAt;

public Hero(String name, Integer age, String power, String weakness){
    mName = name;
    mAge = age;
    mPower = power;
    mWeakness = weakness;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
}


public String getName(){return mName;}
public Integer getAge () {return mAge;}
public String getPower() {return mPower;}
public String getWeakness() {return mWeakness;}
public boolean isCompleted (){return mCompleted;}
public LocalDateTime getCreatedAt() {return mCreatedAt;}

}


