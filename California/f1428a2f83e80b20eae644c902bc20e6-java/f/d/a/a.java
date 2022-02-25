package f.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import j.j.b.e;
import j.j.b.f;
import j.l.a;
import j.l.d;
import j.m.h;
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

public final class a {
    public boolean a;
    public final List<f.d.a.d.a> b = new ArrayList();
    public final List<f.d.a.d.a> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<f.d.a.d.b> f3427d = new ArrayList();

    /* renamed from: f.d.a.a$a  reason: collision with other inner class name */
    public enum EnumC0125a {
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

    public static final class b extends f implements j.j.a.b<String, String> {
        public final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3437d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, String str) {
            super(1);
            this.c = context;
            this.f3437d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // j.j.a.b
        public String d(String str) {
            String str2 = str;
            e.c(str2, "it");
            Context context = this.c;
            StringBuilder h2 = f.a.a.a.a.h(str2);
            h2.append(this.f3437d);
            return f.b.a.c.b.o.b.V0(context, h2.toString());
        }
    }

    public static final class c extends f implements j.j.a.b<String, Boolean> {
        public static final c c = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // j.j.a.b
        public Boolean d(String str) {
            String str2 = str;
            e.c(str2, "it");
            return Boolean.valueOf(!h.h(str2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0143, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0144, code lost:
        f.b.a.c.b.o.b.J(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0148, code lost:
        throw r0;
     */
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
                String V0 = f.b.a.c.b.o.b.V0(context, "license_" + m + "_licenseDescription");
                if (h.o(V0, "raw:", false, 2)) {
                    Resources resources = context.getResources();
                    String l2 = h.l(V0, "raw:");
                    e.c(context, "$this$getRawResourceId");
                    e.c(l2, "aString");
                    InputStream openRawResource = resources.openRawResource(context.getResources().getIdentifier(l2, "raw", context.getPackageName()));
                    e.b(openRawResource, "ctx.resources.openRawRes…on.removePrefix(\"raw:\")))");
                    InputStreamReader inputStreamReader = new InputStreamReader(openRawResource, j.m.a.a);
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
                    f.b.a.c.b.o.b.J(bufferedReader, null);
                    str = stringWriter2;
                } else {
                    str = V0;
                }
                String V02 = f.b.a.c.b.o.b.V0(context, "license_" + m + "_licenseName");
                String V03 = f.b.a.c.b.o.b.V0(context, "license_" + m + "_licenseWebsite");
                bVar = new f.d.a.d.b(m, V02, V03, f.b.a.c.b.o.b.V0(context, "license_" + m + "_licenseShortDescription"), str);
            } catch (Exception e2) {
                Log.e("aboutlibraries", "Failed to generateLicense from file: " + e2);
            }
            if (bVar != null) {
                this.f3427d.add(bVar);
            }
            i2 = 4;
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            String str4 = (String) it2.next();
            e.b(str4, "pluginLibraryIdentifier");
            f.d.a.d.a b3 = b(context, str4);
            if (b3 != null) {
                b3.c = false;
                b3.f3451d = true;
                this.c.add(b3);
                this.a = true;
                String str5 = map.get(str4);
                if (!(str5 == null || (b2 = b(context, str5)) == null)) {
                    e.c(b2, "enchantWith");
                    String b4 = b3.b(b2.f3452e);
                    b3.f3452e = b4 == null ? b3.f3452e : b4;
                    String b5 = b3.b(b2.f3453f);
                    b3.f3453f = b5 == null ? b3.f3453f : b5;
                    String b6 = b3.b(b2.f3454g);
                    b3.f3454g = b6 == null ? b3.f3454g : b6;
                    String b7 = b3.b(b2.f3455h);
                    b3.f3455h = b7 == null ? b3.f3455h : b7;
                    String b8 = b3.b(b2.f3456i);
                    b3.f3456i = b8 == null ? b3.f3456i : b8;
                    String b9 = b3.b(b2.f3457j);
                    b3.f3457j = b9 == null ? b3.f3457j : b9;
                    String b10 = b3.b(b2.f3458k);
                    b3.f3458k = b10 == null ? b3.f3458k : b10;
                    Set<f.d.a.d.b> set = b2.f3459l;
                    b3.f3459l = set == null ? b3.f3459l : set;
                    b3.m = b2.m;
                    String b11 = b3.b(b2.n);
                    b3.n = b11 == null ? b3.n : b11;
                }
            }
        }
        if (arrayList4.isEmpty()) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                String str6 = (String) it3.next();
                e.b(str6, "internalIdentifier");
                f.d.a.d.a b12 = b(context, str6);
                if (b12 != null) {
                    b12.c = true;
                    this.b.add(b12);
                }
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                String str7 = (String) it4.next();
                e.b(str7, "externalIdentifier");
                f.d.a.d.a b13 = b(context, str7);
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
            } else if (h.a(aVar.f3452e, str, true) || h.a(aVar.b, str, true)) {
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
        f.d.a.d.b bVar2;
        String m = h.m(str, "-", "_", false, 4);
        try {
            f.d.a.d.a aVar = new f.d.a.d.a(m, false, false, f.b.a.c.b.o.b.V0(context, "library_" + m + "_libraryName"), null, null, null, null, null, null, null, false, null, null, 16374);
            HashMap<String, String> c2 = c(context, m);
            String V0 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_author");
            e.c(V0, "<set-?>");
            aVar.f3453f = V0;
            String V02 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_authorWebsite");
            e.c(V02, "<set-?>");
            aVar.f3454g = V02;
            String f2 = f(f.b.a.c.b.o.b.V0(context, "library_" + m + "_libraryDescription"), c2);
            e.c(f2, "<set-?>");
            aVar.f3455h = f2;
            String V03 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_libraryVersion");
            e.c(V03, "<set-?>");
            aVar.f3456i = V03;
            String V04 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_libraryArtifactId");
            e.c(V04, "<set-?>");
            aVar.f3457j = V04;
            String V05 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_libraryWebsite");
            e.c(V05, "<set-?>");
            aVar.f3458k = V05;
            String V06 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseIds");
            String V07 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseId");
            if (!h.h(V06) || !h.h(V07)) {
                set = new LinkedHashSet<>();
                for (String str2 : h.h(V06) ? f.b.a.c.b.o.b.p1(V07) : h.n(V06, new String[]{","}, false, 0, 6)) {
                    e.c(str2, "licenseName");
                    Iterator it = new ArrayList(this.f3427d).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            bVar = null;
                            break;
                        }
                        bVar2 = (f.d.a.d.b) it.next();
                        if (!h.b(bVar2.b, str2, true)) {
                            if (h.b(bVar2.a, str2, true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    bVar = bVar2;
                    if (bVar != null) {
                        f.d.a.d.b a2 = f.d.a.d.b.a(bVar, null, null, null, null, null, 31);
                        String f3 = f(a2.f3460d, c2);
                        e.c(f3, "<set-?>");
                        a2.f3460d = f3;
                        String f4 = f(a2.f3461e, c2);
                        e.c(f4, "<set-?>");
                        a2.f3461e = f4;
                        set.add(a2);
                    }
                }
            } else {
                set = Collections.singleton(new f.d.a.d.b("", f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseVersion"), f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseLink"), f(f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseContent"), c2), f(f.b.a.c.b.o.b.V0(context, "library_" + m + "_licenseContent"), c2)));
                e.b(set, "java.util.Collections.singleton(element)");
            }
            aVar.f3459l = set;
            Boolean valueOf = Boolean.valueOf(f.b.a.c.b.o.b.V0(context, "library_" + m + "_isOpenSource"));
            e.b(valueOf, "java.lang.Boolean.valueO… name + \"_isOpenSource\"))");
            aVar.m = valueOf.booleanValue();
            String V08 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_repositoryLink");
            e.c(V08, "<set-?>");
            aVar.n = V08;
            String V09 = f.b.a.c.b.o.b.V0(context, "library_" + m + "_classPath");
            e.c(V09, "<set-?>");
            aVar.o = V09;
            if (!h.h(aVar.f3452e) || !h.h(aVar.f3455h)) {
                return aVar;
            }
            return null;
        } catch (Exception e2) {
            Log.e("aboutlibraries", "Failed to generateLibrary from file: " + e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c9  */
    public final HashMap<String, String> c(Context context, String str) {
        Collection collection;
        String[] strArr;
        boolean z;
        e.c(context, "ctx");
        e.c(str, "libraryName");
        HashMap<String, String> hashMap = new HashMap<>();
        String[] strArr2 = {"define_", "define_int_", "define_plu_"};
        e.c(strArr2, "elements");
        e.c(strArr2, "$this$asSequence");
        j.h.a aVar = new j.h.a(strArr2);
        b bVar = new b(context, str);
        e.c(aVar, "$this$map");
        e.c(bVar, "transform");
        d dVar = new d(aVar, bVar);
        c cVar = c.c;
        e.c(dVar, "$this$filter");
        e.c(cVar, "predicate");
        j.l.a aVar2 = new j.l.a(dVar, true, cVar);
        e.c(aVar2, "$this$firstOrNull");
        a.C0148a aVar3 = new a.C0148a(aVar2);
        String str2 = (String) (!aVar3.hasNext() ? null : aVar3.next());
        if (str2 == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            List<String> a2 = new j.m.c(";").a(str2, 0);
            if (!a2.isEmpty()) {
                ListIterator<String> listIterator = a2.listIterator(a2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        collection = j.h.b.b(a2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                Object[] array = collection.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                strArr = (String[]) array;
                if (!(strArr.length != 0)) {
                    for (String str3 : strArr) {
                        String V0 = f.b.a.c.b.o.b.V0(context, "library_" + str + "_" + str3);
                        if (V0.length() > 0) {
                            hashMap.put(str3, V0);
                        }
                    }
                }
            }
            collection = j.h.d.b;
            Object[] array2 = collection.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            strArr = (String[]) array2;
            if (!(strArr.length != 0)) {
            }
        }
        return hashMap;
    }

    public final ArrayList<f.d.a.d.a> d() {
        return new ArrayList<>(this.c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0025  */
    public final f.d.a.d.a e(String str) {
        e.c(str, "libraryName");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(new ArrayList(this.b));
        arrayList.addAll(d());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f.d.a.d.a aVar = (f.d.a.d.a) it.next();
            if (h.b(aVar.f3452e, str, true) || h.b(aVar.b, str, true)) {
                return aVar;
            }
            while (it.hasNext()) {
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
