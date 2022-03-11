package f.b.f.a;

import java.io.Serializable;
/* loaded from: classes.dex */
public class j implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public boolean f3835d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3837f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3839h;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3842k;
    public boolean m;
    public int b = 0;
    public long c = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f3836e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f3838g = false;

    /* renamed from: i  reason: collision with root package name */
    public int f3840i = 1;

    /* renamed from: j  reason: collision with root package name */
    public String f3841j = "";
    public String n = "";

    /* renamed from: l  reason: collision with root package name */
    public a f3843l = a.UNSPECIFIED;

    /* loaded from: classes.dex */
    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar != null && (this == jVar || (this.b == jVar.b && this.c == jVar.c && this.f3836e.equals(jVar.f3836e) && this.f3838g == jVar.f3838g && this.f3840i == jVar.f3840i && this.f3841j.equals(jVar.f3841j) && this.f3843l == jVar.f3843l && this.n.equals(jVar.n) && this.m == jVar.m))) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.f3836e.hashCode() + ((Long.valueOf(this.c).hashCode() + ((this.b + 2173) * 53)) * 53)) * 53;
        int i2 = 1237;
        int i3 = this.f3838g ? 1231 : 1237;
        int hashCode2 = this.f3841j.hashCode();
        int hashCode3 = (this.n.hashCode() + ((this.f3843l.hashCode() + ((hashCode2 + ((((hashCode + i3) * 53) + this.f3840i) * 53)) * 53)) * 53)) * 53;
        if (this.m) {
            i2 = 1231;
        }
        return hashCode3 + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Country Code: ");
        h2.append(this.b);
        h2.append(" National Number: ");
        h2.append(this.c);
        if (this.f3837f && this.f3838g) {
            h2.append(" Leading Zero(s): true");
        }
        if (this.f3839h) {
            h2.append(" Number of leading zeros: ");
            h2.append(this.f3840i);
        }
        if (this.f3835d) {
            h2.append(" Extension: ");
            h2.append(this.f3836e);
        }
        if (this.f3842k) {
            h2.append(" Country Code Source: ");
            h2.append(this.f3843l);
        }
        if (this.m) {
            h2.append(" Preferred Domestic Carrier Code: ");
            h2.append(this.n);
        }
        return h2.toString();
    }
}
