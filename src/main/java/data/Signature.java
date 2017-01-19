package data;

import java.nio.charset.Charset;
import java.util.Arrays;

public class Signature {

    private final byte[] sign;

    public Signature(byte[] sign) {
        this.sign = sign;
    }

    public byte[] getSignature() {
        return sign;
    }

    @Override
    public String toString() {
        return String.format(
                "Signature{option='%s'}",
                new String(this.sign, Charset.forName("UTF-8"))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Signature)) return false;

        Signature signature = (Signature) o;

        return Arrays.equals(sign, signature.sign);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sign);
    }
}
