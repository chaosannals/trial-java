package trial.blockchain;

public class Main {
    public static void main(String[] arguments) {
        try {
            Chain chain = new Chain();
            chain.insert("111111111");
            chain.insert("222222222");
            chain.insert("333333333");
            System.out.println("validate:" + chain.validate());
            chain.showHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
