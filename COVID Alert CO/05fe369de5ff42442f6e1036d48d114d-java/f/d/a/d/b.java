package f.d.a.d;

import f.a.a.a.a;
import j.k.b.e;
import java.util.Objects;

public final class b {
    public String a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f3718d;

    /* renamed from: e  reason: collision with root package name */
    public String f3719e;

    public b(String str, String str2, String str3, String str4, String str5) {
        e.c(str, "definedName");
        e.c(str2, "licenseName");
        e.c(str3, "licenseWebsite");
        e.c(str4, "licenseShortDescription");
        e.c(str5, "licenseDescription");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f3718d = str4;
        this.f3719e = str5;
    }

    public static b a(b bVar, String str, String str2, String str3, String str4, String str5, int i2) {
        String str6 = null;
        String str7 = (i2 & 1) != 0 ? bVar.a : null;
        String str8 = (i2 & 2) != 0 ? bVar.b : null;
        String str9 = (i2 & 4) != 0 ? bVar.c : null;
        String str10 = (i2 & 8) != 0 ? bVar.f3718d : null;
        if ((i2 & 16) != 0) {
            str6 = bVar.f3719e;
        }
        Objects.requireNonNull(bVar);
        e.c(str7, "definedName");
        e.c(str8, "licenseName");
        e.c(str9, "licenseWebsite");
        e.c(str10, "licenseShortDescription");
        e.c(str6, "licenseDescription");
        return new b(str7, str8, str9, str10, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return e.a(this.a, bVar.a) && e.a(this.b, bVar.b) && e.a(this.c, bVar.c) && e.a(this.f3718d, bVar.f3718d) && e.a(this.f3719e, bVar.f3719e);
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3718d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3719e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder i2 = a.i("License(definedName=");
        i2.append(this.a);
        i2.append(", licenseName=");
        i2.append(this.b);
        i2.append(", licenseWebsite=");
        i2.append(this.c);
        i2.append(", licenseShortDescription=");
        i2.append(this.f3718d);
        i2.append(", licenseDescription=");
        return a.f(i2, this.f3719e, ")");
    }
}
