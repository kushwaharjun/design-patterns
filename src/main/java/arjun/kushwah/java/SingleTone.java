package arjun.kushwah.java;
import java.io.Serializable;

public class SingleTone implements Serializable {

    private static volatile SingleTone sSoleInstance;

    //private constructor.
    private SingleTone(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingleTone getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            synchronized (SingleTone.class) {
                if (sSoleInstance == null) sSoleInstance = new SingleTone();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected SingleTone readResolve() {
        return getInstance();
    }
}
