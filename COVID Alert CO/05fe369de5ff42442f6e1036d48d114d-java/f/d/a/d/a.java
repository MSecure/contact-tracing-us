package f.d.a.d;

import j.k.b.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a implements Comparable<a> {
    public String b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3709d;

    /* renamed from: e  reason: collision with root package name */
    public String f3710e;

    /* renamed from: f  reason: collision with root package name */
    public String f3711f;

    /* renamed from: g  reason: collision with root package name */
    public String f3712g;

    /* renamed from: h  reason: collision with root package name */
    public String f3713h;

    /* renamed from: i  reason: collision with root package name */
    public String f3714i;

    /* renamed from: j  reason: collision with root package name */
    public String f3715j;

    /* renamed from: k  reason: collision with root package name */
    public String f3716k;

    /* renamed from: l  reason: collision with root package name */
    public Set<b> f3717l;
    public boolean m;
    public String n;
    public String o;

    public a(String str, boolean z, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Set set, boolean z3, String str9, String str10, int i2) {
        z = (i2 & 2) != 0 ? false : z;
        z2 = (i2 & 4) != 0 ? false : z2;
        String str11 = "";
        String str12 = (i2 & 16) != 0 ? str11 : null;
        String str13 = (i2 & 32) != 0 ? str11 : null;
        String str14 = (i2 & 64) != 0 ? str11 : null;
        String str15 = (i2 & 128) != 0 ? str11 : null;
        String str16 = (i2 & 256) != 0 ? str11 : null;
        String str17 = (i2 & 512) != 0 ? str11 : null;
        int i3 = i2 & 1024;
        z3 = (i2 & 2048) != 0 ? true : z3;
        String str18 = (i2 & 4096) != 0 ? str11 : null;
        str11 = (i2 & 8192) == 0 ? null : str11;
        e.c(str, "definedName");
        e.c(str2, "libraryName");
        e.c(str12, "author");
        e.c(str13, "authorWebsite");
        e.c(str14, "libraryDescription");
        e.c(str15, "libraryVersion");
        e.c(str16, "libraryArtifactId");
        e.c(str17, "libraryWebsite");
        e.c(str18, "repositoryLink");
        e.c(str11, "classPath");
        this.b = str;
        this.c = z;
        this.f3709d = z2;
        this.f3710e = str2;
        this.f3711f = str12;
        this.f3712g = str13;
        this.f3713h = str14;
        this.f3714i = str15;
        this.f3715j = str16;
        this.f3716k = str17;
        this.f3717l = null;
        this.m = z3;
        this.n = str18;
        this.o = str11;
    }

    public final b a() {
        Set<b> set = this.f3717l;
        Object obj = null;
        if (set == null) {
            return null;
        }
        e.c(set, "$this$firstOrNull");
        if (set instanceof List) {
            List list = (List) set;
            if (!list.isEmpty()) {
                obj = list.get(0);
            }
        } else {
            Iterator<T> it = set.iterator();
            if (it.hasNext()) {
                obj = it.next();
            }
        }
        return (b) obj;
    }

    public final String b(String str) {
        if (str.length() == 0) {
            return null;
        }
        return str;
    }

    public final void c(b bVar) {
        Set<b> singleton = Collections.singleton(bVar);
        e.b(singleton, "java.util.Collections.singleton(element)");
        this.f3717l = singleton;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        a aVar2 = aVar;
        e.c(aVar2, "other");
        String str = this.f3710e;
        String str2 = aVar2.f3710e;
        e.c(str, "$this$compareTo");
        e.c(str2, "other");
        return str.compareToIgnoreCase(str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return e.a(this.b, aVar.b) && this.c == aVar.c && this.f3709d == aVar.f3709d && e.a(this.f3710e, aVar.f3710e) && e.a(this.f3711f, aVar.f3711f) && e.a(this.f3712g, aVar.f3712g) && e.a(this.f3713h, aVar.f3713h) && e.a(this.f3714i, aVar.f3714i) && e.a(this.f3715j, aVar.f3715j) && e.a(this.f3716k, aVar.f3716k) && e.a(this.f3717l, aVar.f3717l) && this.m == aVar.m && e.a(this.n, aVar.n) && e.a(this.o, aVar.o);
    }

    public int hashCode() {
        String str = this.b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.c;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode + i4) * 31;
        boolean z2 = this.f3709d;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        String str2 = this.f3710e;
        int hashCode2 = (i11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3711f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3712g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3713h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f3714i;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f3715j;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f3716k;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Set<b> set = this.f3717l;
        int hashCode9 = (hashCode8 + (set != null ? set.hashCode() : 0)) * 31;
        boolean z3 = this.m;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        int i12 = (hashCode9 + i3) * 31;
        String str9 = this.n;
        int hashCode10 = (i12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.o;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode10 + i2;
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("Library(definedName=");
        i2.append(this.b);
        i2.append(", isInternal=");
        i2.append(this.c);
        i2.append(", isPlugin=");
        i2.append(this.f3709d);
        i2.append(", libraryName=");
        i2.append(this.f3710e);
        i2.append(", author=");
        i2.append(this.f3711f);
        i2.append(", authorWebsite=");
        i2.append(this.f3712g);
        i2.append(", libraryDescription=");
        i2.append(this.f3713h);
        i2.append(", libraryVersion=");
        i2.append(this.f3714i);
        i2.append(", libraryArtifactId=");
        i2.append(this.f3715j);
        i2.append(", libraryWebsite=");
        i2.append(this.f3716k);
        i2.append(", licenses=");
        i2.append(this.f3717l);
        i2.append(", isOpenSource=");
        i2.append(this.m);
        i2.append(", repositoryLink=");
        i2.append(this.n);
        i2.append(", classPath=");
        return f.a.a.a.a.f(i2, this.o, ")");
    }
}
