package data;

import java.nio.charset.Charset;
import java.util.Arrays;

public class IrisScan {

    private final byte[] sign;

    public IrisScan(byte[] sign) {
        this.sign = sign;
    }

    public byte[] getSignature() {
        return sign;
    }

    @Override
    public String toString() {
        return String.format(
                "IrisScan{option='%s'}",
                new String(this.sign, Charset.forName("UTF-8"))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof IrisScan)) return false;

        IrisScan signature = (IrisScan) o;

        return Arrays.equals(sign, signature.sign);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sign);
    }
}
