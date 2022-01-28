package f.b.f.a;

import java.io.Serializable;

public class j implements Serializable {
    public int b = 0;
    public long c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3517d;

    /* renamed from: e  reason: collision with root package name */
    public String f3518e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f3519f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3520g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3521h;

    /* renamed from: i  reason: collision with root package name */
    public int f3522i = 1;

    /* renamed from: j  reason: collision with root package name */
    public String f3523j = "";

    /* renamed from: k  reason: collision with root package name */
    public boolean f3524k;

    /* renamed from: l  reason: collision with root package name */
    public a f3525l = a.FROM_NUMBER_WITH_PLUS_SIGN;
    public boolean m;
    public String n = "";

    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar != null && (this == jVar || (this.b == jVar.b && this.c == jVar.c && this.f3518e.equals(jVar.f3518e) && this.f3520g == jVar.f3520g && this.f3522i == jVar.f3522i && this.f3523j.equals(jVar.f3523j) && this.f3525l == jVar.f3525l && this.n.equals(jVar.n) && this.m == jVar.m))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f3518e.hashCode() + ((Long.valueOf(this.c).hashCode() + ((this.b + 2173) * 53)) * 53)) * 53;
        int i2 = 1237;
        int i3 = this.f3520g ? 1231 : 1237;
        int hashCode2 = this.f3523j.hashCode();
        int hashCode3 = (this.n.hashCode() + ((this.f3525l.hashCode() + ((hashCode2 + ((((hashCode + i3) * 53) + this.f3522i) * 53)) * 53)) * 53)) * 53;
        if (this.m) {
            i2 = 1231;
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("Country Code: ");
        i2.append(this.b);
        i2.append(" National Number: ");
        i2.append(this.c);
        if (this.f3519f && this.f3520g) {
            i2.append(" Leading Zero(s): true");
        }
        if (this.f3521h) {
            i2.append(" Number of leading zeros: ");
            i2.append(this.f3522i);
        }
        if (this.f3517d) {
            i2.append(" Extension: ");
            i2.append(this.f3518e);
        }
        if (this.f3524k) {
            i2.append(" Country Code Source: ");
            i2.append(this.f3525l);
        }
        if (this.m) {
            i2.append(" Preferred Domestic Carrier Code: ");
            i2.append(this.n);
        }
        return i2.toString();
    }
}
