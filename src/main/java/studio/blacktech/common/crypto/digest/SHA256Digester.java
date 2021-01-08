package studio.blacktech.common.crypto.digest;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


@SuppressWarnings("unused")
public class SHA256Digester {


    // =========================================================================


    private Mac mac;


    // =========================================================================


    public SHA256Digester(SecretKey key) {
        try {
            this.mac = Mac.getInstance("HmacSHA256");
            this.mac.init(key);
        } catch (NoSuchAlgorithmException ignored) {

        } catch (InvalidKeyException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Key is invalidate", exception);
        }
    }


    // =========================================================================


    public static SecretKey getSecretKey(String key) {
        return getSecretKey(key.getBytes(StandardCharsets.UTF_8));
    }


    public static SecretKey getSecretKey(byte[] key) {
        return new SecretKeySpec(key, "HmacSHA256");
    }


    // =========================================================================


    public byte[] digest(byte[] message) {
        return this.mac.doFinal(message);
    }


    public String digest(String message) {
        byte[] digest = digest(message.getBytes(StandardCharsets.UTF_8));
        String temp;
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            temp = Integer.toHexString(b & 0XFF);
            if (temp.length() == 1) builder.append('0');
            builder.append(temp);
        }
        return builder.toString();
    }


    public boolean check(byte[] digest, byte[] message) {
        return Arrays.equals(digest(message), digest);
    }


    public boolean check(String digest, String message) {
        return digest(message).equals(digest);
    }


}
