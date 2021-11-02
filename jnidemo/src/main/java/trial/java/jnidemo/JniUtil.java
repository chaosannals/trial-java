package trial.java.jnidemo;

public class JniUtil {
    public static native long getpid();
    
    static {
        System.loadLibrary("getpidjni");
    }
}
