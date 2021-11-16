package trial.util;

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;

public class HashUtil {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";

    public static final char[] HEX_CHARSET = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F', };

    public static byte[] hash(String algorithm, byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return md.digest();
    }

    public static String hash(String algorithm, String data) throws NoSuchAlgorithmException {
        return toHex(hash(algorithm, data.getBytes()));
    }

    public static byte[] hashFrom(String algorithm, String path) throws IOException, NoSuchAlgorithmException {
        byte[] data = FileUtil.readAllBytes(path);
        return hash(algorithm, data);
    }

    public static String hashHexFrom(String algorithm, String path) throws NoSuchAlgorithmException, IOException {
        byte[] b = hashFrom(algorithm, path);
        // return toHex(b);
        BigInteger bi = new BigInteger(1, b);
        return bi.toString(16);
    }

    public static String toHex(byte[] bytes) {
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; ++i) {
            int j = i * 2;
            byte b = bytes[i];
            chars[j] = HEX_CHARSET[(b >>> 4)& 0xf];
            chars[j + 1] = HEX_CHARSET[b & 0xf];
        }
        return new String(chars);
    }
}
