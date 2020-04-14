package trial.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Chain {
    private ArrayList<Block> blocks;

    public Chain() throws NoSuchAlgorithmException {
        Block first = new Block("000000", "00000");
        first.newHash();
        blocks = new ArrayList<>();
        blocks.add(first);
    }

    public void insert(String data) throws NoSuchAlgorithmException {
        Block tail = blocks.get(blocks.size() - 1);
        blocks.add(tail.next(data));
    }

    public boolean validate() throws NoSuchAlgorithmException {
        String target = new String(new char[3]).replace('\0', '0');
        for (int i = 1; i < blocks.size(); ++i) {
            Block current = blocks.get(i);
            Block prevoius = blocks.get(i - 1);
            if (!current.validate()) {
                System.out.println("current hash error");
                return false;
            }
            if (!prevoius.hash.equals(current.previousHash)) {
                System.out.println("prevoius hash error");
                return false;
            }
            if (!current.hash.substring(0, 3).equals(target)) {
                System.out.println("target hash error");
                return false;
            }
        }
        return true;
    }

    public void showHash() {
        for (Block block: blocks) {
            System.out.println(block.hash);
        }
    }
}
