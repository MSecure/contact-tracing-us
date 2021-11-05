package c.a.b;

import android.text.TextUtils;
import c.a.a.a.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f2820a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2821b;

    public h(String str, String str2) {
        this.f2820a = str;
        this.f2821b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return TextUtils.equals(this.f2820a, hVar.f2820a) && TextUtils.equals(this.f2821b, hVar.f2821b);
    }

    public int hashCode() {
        return this.f2821b.hashCode() + (this.f2820a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder h = a.h("Header[name=");
        h.append(this.f2820a);
        h.append(",value=");
        h.append(this.f2821b);
        h.append("]");
        return h.toString();
    }
}
