package co.edu.uniquindio.proyecto.segurity;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {
    public Hash() {
    }

    /**
     * Factory method for creating Hash instances.
     *
     * This method is currently empty because the implementation is not yet defined.
     * Please complete the implementation or throw an UnsupportedOperationException.
     */
    public static Hash factory() {
        // TODO: Complete the implementation or throw an UnsupportedOperationException.
        return new Hash();
    }

    public String toSha1(String value){
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            return sha1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
