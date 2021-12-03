package f.b.a.b.i;

import f.a.a.a.a;
import f.b.a.b.b;
import java.util.Arrays;
import java.util.Objects;

public final class e {
    public final b a;
    public final byte[] b;

    public e(b bVar, byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = bVar;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.a.equals(eVar.a)) {
            return false;
        }
        return Arrays.equals(this.b, eVar.b);
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder i2 = a.i("EncodedPayload{encoding=");
        i2.append(this.a);
        i2.append(", bytes=[...]}");
        return i2.toString();
    }
}
