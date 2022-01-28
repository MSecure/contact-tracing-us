package f.b.f.a;

import java.io.Serializable;

public class j implements Serializable {
    public int b = 0;
    public long c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3580d;

    /* renamed from: e  reason: collision with root package name */
    public String f3581e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f3582f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3583g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3584h;

    /* renamed from: i  reason: collision with root package name */
    public int f3585i = 1;

    /* renamed from: j  reason: collision with root package name */
    public String f3586j = "";

    /* renamed from: k  reason: collision with root package name */
    public boolean f3587k;

    /* renamed from: l  reason: collision with root package name */
    public a f3588l = a.UNSPECIFIED;
    public boolean m;
    public String n = "";

    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar != null && (this == jVar || (this.b == jVar.b && this.c == jVar.c && this.f3581e.equals(jVar.f3581e) && this.f3583g == jVar.f3583g && this.f3585i == jVar.f3585i && this.f3586j.equals(jVar.f3586j) && this.f3588l == jVar.f3588l && this.n.equals(jVar.n) && this.m == jVar.m))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f3581e.hashCode() + ((Long.valueOf(this.c).hashCode() + ((this.b + 2173) * 53)) * 53)) * 53;
        int i2 = 1237;
        int i3 = this.f3583g ? 1231 : 1237;
        int hashCode2 = this.f3586j.hashCode();
        int hashCode3 = (this.n.hashCode() + ((this.f3588l.hashCode() + ((hashCode2 + ((((hashCode + i3) * 53) + this.f3585i) * 53)) * 53)) * 53)) * 53;
        if (this.m) {
            i2 = 1231;
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Country Code: ");
        h2.append(this.b);
        h2.append(" National Number: ");
        h2.append(this.c);
        if (this.f3582f && this.f3583g) {
            h2.append(" Leading Zero(s): true");
        }
        if (this.f3584h) {
            h2.append(" Number of leading zeros: ");
            h2.append(this.f3585i);
        }
        if (this.f3580d) {
            h2.append(" Extension: ");
            h2.append(this.f3581e);
        }
        if (this.f3587k) {
            h2.append(" Country Code Source: ");
            h2.append(this.f3588l);
        }
        if (this.m) {
            h2.append(" Preferred Domestic Carrier Code: ");
            h2.append(this.n);
        }
        return h2.toString();
    }
}
