package c.a.b;

import android.text.TextUtils;
import c.a.a.a.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f2211a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2212b;

    public h(String str, String str2) {
        this.f2211a = str;
        this.f2212b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return TextUtils.equals(this.f2211a, hVar.f2211a) && TextUtils.equals(this.f2212b, hVar.f2212b);
    }

    public int hashCode() {
        return this.f2212b.hashCode() + (this.f2211a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder g = a.g("Header[name=");
        g.append(this.f2211a);
        g.append(",value=");
        g.append(this.f2212b);
        g.append("]");
        return g.toString();
    }
}
