package org.spongycastle.util.io.pem;

public class PemHeader {
    public String name;
    public String value;

    public PemHeader(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PemHeader)) {
            return false;
        }
        PemHeader pemHeader = (PemHeader) obj;
        if (pemHeader == this || (isEqual(this.name, pemHeader.name) && isEqual(this.value, pemHeader.value))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.name;
        int i2 = 1;
        if (str == null) {
            i = 1;
        } else {
            i = str.hashCode();
        }
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return (i2 * 31) + i;
    }

    public final boolean isEqual(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
