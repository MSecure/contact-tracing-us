package f.d.a.d;

import j.k.b.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class a implements Comparable<a> {
    public String b;
    public boolean c;

    /* renamed from: d */
    public boolean f4028d;

    /* renamed from: e */
    public String f4029e;

    /* renamed from: f */
    public String f4030f;

    /* renamed from: g */
    public String f4031g;

    /* renamed from: h */
    public String f4032h;

    /* renamed from: i */
    public String f4033i;

    /* renamed from: j */
    public String f4034j;

    /* renamed from: k */
    public String f4035k;

    /* renamed from: l */
    public Set<b> f4036l;
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
        this.f4028d = z2;
        this.f4029e = str2;
        this.f4030f = str12;
        this.f4031g = str13;
        this.f4032h = str14;
        this.f4033i = str15;
        this.f4034j = str16;
        this.f4035k = str17;
        this.f4036l = null;
        this.m = z3;
        this.n = str18;
        this.o = str11;
    }

    public final b a() {
        Set<b> set = this.f4036l;
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
        this.f4036l = singleton;
    }

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        a aVar2 = aVar;
        e.c(aVar2, "other");
        String str = this.f4029e;
        String str2 = aVar2.f4029e;
        e.c(str, "$this$compareTo");
        e.c(str2, "other");
        return str.compareToIgnoreCase(str2);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return e.a(this.b, aVar.b) && this.c == aVar.c && this.f4028d == aVar.f4028d && e.a(this.f4029e, aVar.f4029e) && e.a(this.f4030f, aVar.f4030f) && e.a(this.f4031g, aVar.f4031g) && e.a(this.f4032h, aVar.f4032h) && e.a(this.f4033i, aVar.f4033i) && e.a(this.f4034j, aVar.f4034j) && e.a(this.f4035k, aVar.f4035k) && e.a(this.f4036l, aVar.f4036l) && this.m == aVar.m && e.a(this.n, aVar.n) && e.a(this.o, aVar.o);
    }

    @Override // java.lang.Object
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
        boolean z2 = this.f4028d;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        String str2 = this.f4029e;
        int hashCode2 = (i11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f4030f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f4031g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f4032h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f4033i;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f4034j;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f4035k;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Set<b> set = this.f4036l;
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

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Library(definedName=");
        h2.append(this.b);
        h2.append(", isInternal=");
        h2.append(this.c);
        h2.append(", isPlugin=");
        h2.append(this.f4028d);
        h2.append(", libraryName=");
        h2.append(this.f4029e);
        h2.append(", author=");
        h2.append(this.f4030f);
        h2.append(", authorWebsite=");
        h2.append(this.f4031g);
        h2.append(", libraryDescription=");
        h2.append(this.f4032h);
        h2.append(", libraryVersion=");
        h2.append(this.f4033i);
        h2.append(", libraryArtifactId=");
        h2.append(this.f4034j);
        h2.append(", libraryWebsite=");
        h2.append(this.f4035k);
        h2.append(", licenses=");
        h2.append(this.f4036l);
        h2.append(", isOpenSource=");
        h2.append(this.m);
        h2.append(", repositoryLink=");
        h2.append(this.n);
        h2.append(", classPath=");
        return f.a.a.a.a.e(h2, this.o, ")");
    }
}
