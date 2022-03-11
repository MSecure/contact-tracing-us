package f.d.a;

import android.content.Context;
import android.content.res.Resources;
import g.b.a.c.c.d;
import j.k.b.e;
import j.k.b.f;
import j.m.a;
import j.n.h;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {
    public boolean a;
    public final List<f.d.a.d.a> b = new ArrayList();
    public final List<f.d.a.d.a> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<f.d.a.d.b> f4004d = new ArrayList();

    /* renamed from: f.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0131a {
        AUTHOR_NAME,
        AUTHOR_WEBSITE,
        LIBRARY_NAME,
        LIBRARY_DESCRIPTION,
        LIBRARY_VERSION,
        LIBRARY_ARTIFACT_ID,
        LIBRARY_WEBSITE,
        LIBRARY_OPEN_SOURCE,
        LIBRARY_REPOSITORY_LINK,
        LIBRARY_CLASSPATH,
        LICENSE_NAME,
        LICENSE_SHORT_DESCRIPTION,
        LICENSE_DESCRIPTION,
        LICENSE_WEBSITE
    }

    /* loaded from: classes.dex */
    public static final class b extends f implements j.k.a.b<String, String> {
        public final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4014d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, String str) {
            super(1);
            this.c = context;
            this.f4014d = str;
        }

        @Override // j.k.a.b
        public String d(String str) {
            String str2 = str;
            e.c(str2, "it");
            Context context = this.c;
            StringBuilder h2 = f.a.a.a.a.h(str2);
            h2.append(this.f4014d);
            return f.b.a.c.b.o.b.J0(context, h2.toString());
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends f implements j.k.a.b<String, Boolean> {
        public static final c c = new c();

        public c() {
            super(1);
        }

        @Override // j.k.a.b
        public Boolean d(String str) {
            String str2 = str;
            e.c(str2, "it");
            return Boolean.valueOf(!h.h(str2));
        }
    }

    public a(Context context, String[] strArr, Map<String, String> map) {
        int i2;
        f.d.a.d.a b2;
        String str;
        e.c(context, "context");
        e.c(strArr, "fields");
        e.c(map, "libraryEnchantments");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            i2 = 4;
            if (i3 >= length) {
                break;
            }
            String str2 = strArr[i3];
            if (h.o(str2, "define_license_", false, 2)) {
                arrayList.add(h.m(str2, "define_license_", "", false, 4));
            } else if (h.o(str2, "define_int_", false, 2)) {
                arrayList2.add(h.m(str2, "define_int_", "", false, 4));
            } else if (h.o(str2, "define_plu_", false, 2)) {
                arrayList4.add(h.m(str2, "define_plu_", "", false, 4));
            } else if (h.o(str2, "define_", false, 2)) {
                arrayList3.add(h.m(str2, "define_", "", false, 4));
            }
            i3++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            e.b(str3, "licenseIdentifier");
            String m = h.m(str3, "-", "_", false, i2);
            f.d.a.d.b bVar = null;
            try {
                String J0 = f.b.a.c.b.o.b.J0(context, "license_" + m + "_licenseDescription");
                if (h.o(J0, "raw:", false, 2)) {
                    Resources resources = context.getResources();
                    String l2 = h.l(J0, "raw:");
                    e.c(context, "$this$getRawResourceId");
                    e.c(l2, "aString");
                    InputStream openRawResource = resources.openRawResource(context.getResources().getIdentifier(l2, "raw", context.getPackageName()));
                    e.b(openRawResource, "ctx.resources.openRawRes…on.removePrefix(\"raw:\")))");
                    InputStreamReader inputStreamReader = new InputStreamReader(openRawResource, j.n.a.a);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    e.c(bufferedReader, "$this$readText");
                    StringWriter stringWriter = new StringWriter();
                    e.c(bufferedReader, "$this$copyTo");
                    e.c(stringWriter, "out");
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read < 0) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    String stringWriter2 = stringWriter.toString();
                    e.b(stringWriter2, "buffer.toString()");
                    d.c(bufferedReader, null);
                    str = stringWriter2;
                } else {
                    str = J0;
                }
                bVar = new f.d.a.d.b(m, f.b.a.c.b.o.b.J0(context, "license_" + m + "_licenseName"), f.b.a.c.b.o.b.J0(context, "license_" + m + "_licenseWebsite"), f.b.a.c.b.o.b.J0(context, "license_" + m + "_licenseShortDescription"), str);
            } catch (Exception e2) {
                String str4 = "Failed to generateLicense from file: " + e2;
            }
            if (bVar != null) {
                this.f4004d.add(bVar);
            }
            i2 = 4;
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            String str5 = (String) it2.next();
            e.b(str5, "pluginLibraryIdentifier");
            f.d.a.d.a b3 = b(context, str5);
            if (b3 != null) {
                b3.c = false;
                b3.f4028d = true;
                this.c.add(b3);
                this.a = true;
                String str6 = map.get(str5);
                if (!(str6 == null || (b2 = b(context, str6)) == null)) {
                    e.c(b2, "enchantWith");
                    String b4 = b3.b(b2.f4029e);
                    b3.f4029e = b4 == null ? b3.f4029e : b4;
                    String b5 = b3.b(b2.f4030f);
                    b3.f4030f = b5 == null ? b3.f4030f : b5;
                    String b6 = b3.b(b2.f4031g);
                    b3.f4031g = b6 == null ? b3.f4031g : b6;
                    String b7 = b3.b(b2.f4032h);
                    b3.f4032h = b7 == null ? b3.f4032h : b7;
                    String b8 = b3.b(b2.f4033i);
                    b3.f4033i = b8 == null ? b3.f4033i : b8;
                    String b9 = b3.b(b2.f4034j);
                    b3.f4034j = b9 == null ? b3.f4034j : b9;
                    String b10 = b3.b(b2.f4035k);
                    b3.f4035k = b10 == null ? b3.f4035k : b10;
                    Set<f.d.a.d.b> set = b2.f4036l;
                    b3.f4036l = set == null ? b3.f4036l : set;
                    b3.m = b2.m;
                    String b11 = b3.b(b2.n);
                    b3.n = b11 == null ? b3.n : b11;
                }
            }
        }
        if (arrayList4.isEmpty()) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                String str7 = (String) it3.next();
                e.b(str7, "internalIdentifier");
                f.d.a.d.a b12 = b(context, str7);
                if (b12 != null) {
                    b12.c = true;
                    this.b.add(b12);
                }
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                String str8 = (String) it4.next();
                e.b(str8, "externalIdentifier");
                f.d.a.d.a b13 = b(context, str8);
                if (b13 != null) {
                    b13.c = false;
                    this.c.add(b13);
                }
            }
        }
    }

    public final List<f.d.a.d.a> a(List<f.d.a.d.a> list, String str, boolean z, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (f.d.a.d.a aVar : list) {
            if (z) {
                if (h.a(aVar.b, str, true)) {
                    arrayList.add(aVar);
                    i3++;
                    if (i2 != -1 && i2 < i3) {
                        break;
                    }
                } else {
                    continue;
                }
            } else if (h.a(aVar.f4029e, str, true) || h.a(aVar.b, str, true)) {
                arrayList.add(aVar);
                i3++;
                if (i2 != -1 && i2 < i3) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final f.d.a.d.a b(Context context, String str) {
        Set<f.d.a.d.b> set;
        f.d.a.d.b bVar;
        String m = h.m(str, "-", "_", false, 4);
        try {
            f.d.a.d.a aVar = new f.d.a.d.a(m, false, false, f.b.a.c.b.o.b.J0(context, "library_" + m + "_libraryName"), null, null, null, null, null, null, null, false, null, null, 16374);
            HashMap<String, String> c2 = c(context, m);
            String J0 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_author");
            e.c(J0, "<set-?>");
            aVar.f4030f = J0;
            String J02 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_authorWebsite");
            e.c(J02, "<set-?>");
            aVar.f4031g = J02;
            String f2 = f(f.b.a.c.b.o.b.J0(context, "library_" + m + "_libraryDescription"), c2);
            e.c(f2, "<set-?>");
            aVar.f4032h = f2;
            String J03 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_libraryVersion");
            e.c(J03, "<set-?>");
            aVar.f4033i = J03;
            String J04 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_libraryArtifactId");
            e.c(J04, "<set-?>");
            aVar.f4034j = J04;
            String J05 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_libraryWebsite");
            e.c(J05, "<set-?>");
            aVar.f4035k = J05;
            String J06 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseIds");
            String J07 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseId");
            if (!h.h(J06) || !h.h(J07)) {
                set = new LinkedHashSet<>();
                for (String str2 : h.h(J06) ? d.p(J07) : h.n(J06, new String[]{","}, false, 0, 6)) {
                    e.c(str2, "licenseName");
                    Iterator it = new ArrayList(this.f4004d).iterator();
                    while (it.hasNext()) {
                        f.d.a.d.b bVar2 = (f.d.a.d.b) it.next();
                        if (!h.b(bVar2.b, str2, true)) {
                            if (h.b(bVar2.a, str2, true)) {
                            }
                        }
                        bVar = bVar2;
                    }
                    bVar = null;
                    if (bVar != null) {
                        f.d.a.d.b a = f.d.a.d.b.a(bVar, null, null, null, null, null, 31);
                        String f3 = f(a.f4037d, c2);
                        e.c(f3, "<set-?>");
                        a.f4037d = f3;
                        String f4 = f(a.f4038e, c2);
                        e.c(f4, "<set-?>");
                        a.f4038e = f4;
                        set.add(a);
                    }
                }
            } else {
                set = Collections.singleton(new f.d.a.d.b("", f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseVersion"), f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseLink"), f(f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseContent"), c2), f(f.b.a.c.b.o.b.J0(context, "library_" + m + "_licenseContent"), c2)));
                e.b(set, "java.util.Collections.singleton(element)");
            }
            aVar.f4036l = set;
            Boolean valueOf = Boolean.valueOf(f.b.a.c.b.o.b.J0(context, "library_" + m + "_isOpenSource"));
            e.b(valueOf, "java.lang.Boolean.valueO… name + \"_isOpenSource\"))");
            aVar.m = valueOf.booleanValue();
            String J08 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_repositoryLink");
            e.c(J08, "<set-?>");
            aVar.n = J08;
            String J09 = f.b.a.c.b.o.b.J0(context, "library_" + m + "_classPath");
            e.c(J09, "<set-?>");
            aVar.o = J09;
            if (h.h(aVar.f4029e)) {
                if (h.h(aVar.f4032h)) {
                    return null;
                }
            }
            return aVar;
        } catch (Exception e2) {
            String str3 = "Failed to generateLibrary from file: " + e2;
            return null;
        }
    }

    public final HashMap<String, String> c(Context context, String str) {
        Collection collection;
        boolean z;
        e.c(context, "ctx");
        e.c(str, "libraryName");
        HashMap<String, String> hashMap = new HashMap<>();
        String[] strArr = {"define_", "define_int_", "define_plu_"};
        e.c(strArr, "elements");
        e.c(strArr, "$this$asSequence");
        j.i.a aVar = new j.i.a(strArr);
        b bVar = new b(context, str);
        e.c(aVar, "$this$map");
        e.c(bVar, "transform");
        j.m.d dVar = new j.m.d(aVar, bVar);
        c cVar = c.c;
        e.c(dVar, "$this$filter");
        e.c(cVar, "predicate");
        j.m.a aVar2 = new j.m.a(dVar, true, cVar);
        e.c(aVar2, "$this$firstOrNull");
        a.C0155a aVar3 = new a.C0155a();
        String str2 = (String) (!aVar3.hasNext() ? null : aVar3.next());
        if (str2 == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            List<String> a = new j.n.c(";").a(str2, 0);
            if (!a.isEmpty()) {
                ListIterator<String> listIterator = a.listIterator(a.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        collection = j.i.b.b(a, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            collection = j.i.d.b;
            Object[] array = collection.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr2 = (String[]) array;
            if (!(strArr2.length == 0)) {
                for (String str3 : strArr2) {
                    String J0 = f.b.a.c.b.o.b.J0(context, "library_" + str + "_" + str3);
                    if (J0.length() > 0) {
                        hashMap.put(str3, J0);
                    }
                }
            }
        }
        return hashMap;
    }

    public final ArrayList<f.d.a.d.a> d() {
        return new ArrayList<>(this.c);
    }

    public final f.d.a.d.a e(String str) {
        e.c(str, "libraryName");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(new ArrayList(this.b));
        arrayList.addAll(d());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f.d.a.d.a aVar = (f.d.a.d.a) it.next();
            if (h.b(aVar.f4029e, str, true)) {
                return aVar;
            }
            if (h.b(aVar.b, str, true)) {
                return aVar;
            }
        }
        return null;
    }

    public final String f(String str, HashMap<String, String> hashMap) {
        e.c(str, "insertIntoVar");
        e.c(hashMap, "variables");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.length() > 0) {
                StringBuilder h2 = f.a.a.a.a.h("<<<");
                Locale locale = Locale.US;
                e.b(locale, "Locale.US");
                Objects.requireNonNull(key, "null cannot be cast to non-null type java.lang.String");
                String upperCase = key.toUpperCase(locale);
                e.b(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                h2.append(upperCase);
                h2.append(">>>");
                str = h.m(str, h2.toString(), value, false, 4);
            }
        }
        return h.m(h.m(str, "<<<", "", false, 4), ">>>", "", false, 4);
    }
}
