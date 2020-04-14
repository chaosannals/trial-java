package trial.blockchain;

import java.security.*;
import java.util.*;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timestamp;
    private long nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = "        ";
        this.nonce = 0;
    }

    public boolean validate() throws NoSuchAlgorithmException {
        String result = applySha256(
                previousHash +
                        Long.toString(timestamp) +
                        Long.toString(nonce) +
                        data
        );
        return result.equals(hash);
    }

    public void newHash() throws NoSuchAlgorithmException {
        String target = new String(new char[3]).replace('\0', '0');
        while (!hash.substring(0, 3).equals(target)) {
            hash = applySha256(
                    previousHash +
                            Long.toString(timestamp) +
                            Long.toString(++nonce) +
                            data
            );
        }
        System.out.println(hash);
    }

    public Block next(String data) throws NoSuchAlgorithmException {
        Block result = new Block(data, hash);
        result.newHash();
        return result;
    }

    public static String applySha256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < hash.length; ++i) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) buffer.append('0');
            buffer.append(hex);
        }
        return buffer.toString();
    }
}
