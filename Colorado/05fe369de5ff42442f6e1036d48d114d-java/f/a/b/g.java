package f.a.b;

import android.text.TextUtils;
import f.a.a.a.a;

public final class g {
    public final String a;
    public final String b;

    public g(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.a, gVar.a) && TextUtils.equals(this.b, gVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i2 = a.i("Header[name=");
        i2.append(this.a);
        i2.append(",value=");
        return a.f(i2, this.b, "]");
    }
}
