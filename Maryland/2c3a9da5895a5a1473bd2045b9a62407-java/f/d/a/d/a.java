package f.d.a.d;

import j.j.b.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a implements Comparable<a> {
    public String b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3555d;

    /* renamed from: e  reason: collision with root package name */
    public String f3556e;

    /* renamed from: f  reason: collision with root package name */
    public String f3557f;

    /* renamed from: g  reason: collision with root package name */
    public String f3558g;

    /* renamed from: h  reason: collision with root package name */
    public String f3559h;

    /* renamed from: i  reason: collision with root package name */
    public String f3560i;

    /* renamed from: j  reason: collision with root package name */
    public String f3561j;

    /* renamed from: k  reason: collision with root package name */
    public String f3562k;

    /* renamed from: l  reason: collision with root package name */
    public Set<b> f3563l;
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
        this.f3555d = z2;
        this.f3556e = str2;
        this.f3557f = str12;
        this.f3558g = str13;
        this.f3559h = str14;
        this.f3560i = str15;
        this.f3561j = str16;
        this.f3562k = str17;
        this.f3563l = null;
        this.m = z3;
        this.n = str18;
        this.o = str11;
    }

    public final b a() {
        Set<b> set = this.f3563l;
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
        this.f3563l = singleton;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        a aVar2 = aVar;
        e.c(aVar2, "other");
        String str = this.f3556e;
        String str2 = aVar2.f3556e;
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
        return e.a(this.b, aVar.b) && this.c == aVar.c && this.f3555d == aVar.f3555d && e.a(this.f3556e, aVar.f3556e) && e.a(this.f3557f, aVar.f3557f) && e.a(this.f3558g, aVar.f3558g) && e.a(this.f3559h, aVar.f3559h) && e.a(this.f3560i, aVar.f3560i) && e.a(this.f3561j, aVar.f3561j) && e.a(this.f3562k, aVar.f3562k) && e.a(this.f3563l, aVar.f3563l) && this.m == aVar.m && e.a(this.n, aVar.n) && e.a(this.o, aVar.o);
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
        boolean z2 = this.f3555d;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        String str2 = this.f3556e;
        int hashCode2 = (i11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3557f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3558g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3559h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f3560i;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f3561j;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f3562k;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Set<b> set = this.f3563l;
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
        StringBuilder h2 = f.a.a.a.a.h("Library(definedName=");
        h2.append(this.b);
        h2.append(", isInternal=");
        h2.append(this.c);
        h2.append(", isPlugin=");
        h2.append(this.f3555d);
        h2.append(", libraryName=");
        h2.append(this.f3556e);
        h2.append(", author=");
        h2.append(this.f3557f);
        h2.append(", authorWebsite=");
        h2.append(this.f3558g);
        h2.append(", libraryDescription=");
        h2.append(this.f3559h);
        h2.append(", libraryVersion=");
        h2.append(this.f3560i);
        h2.append(", libraryArtifactId=");
        h2.append(this.f3561j);
        h2.append(", libraryWebsite=");
        h2.append(this.f3562k);
        h2.append(", licenses=");
        h2.append(this.f3563l);
        h2.append(", isOpenSource=");
        h2.append(this.m);
        h2.append(", repositoryLink=");
        h2.append(this.n);
        h2.append(", classPath=");
        return f.a.a.a.a.e(h2, this.o, ")");
    }
}
