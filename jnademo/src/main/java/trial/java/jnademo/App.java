package trial.java.jnademo;

public class App {

    public static void main(String[] args) {
        int pid = Kernel32.INSTANCE.GetCurrentProcessId();
        System.out.println(pid);
        System.out.println("jna");
    }
}
