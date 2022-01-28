package f.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import f.d.a.a;
import f.d.b.b;
import f.d.b.k;
import f.d.b.l;
import j.h;
import j.i.d;
import j.k.b.e;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class c {
    public b<k<?>> a;
    public f.d.b.p.a<k<?>> b;
    public b c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<f.d.a.d.a> f3705d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f3706e;

    public final class a extends AsyncTask<String, h, h> {
        public String a;
        public Integer b;
        public Drawable c;

        /* renamed from: d  reason: collision with root package name */
        public Context f3707d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f3708e;

        public a(c cVar, Context context) {
            e.c(context, "ctx");
            this.f3708e = cVar;
            this.f3707d = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x05fd  */
        /* JADX WARNING: Removed duplicated region for block: B:267:0x0703  */
        @Override // android.os.AsyncTask
        public h doInBackground(String[] strArr) {
            a aVar;
            String[] strArr2;
            String[] strArr3;
            c cVar;
            ApplicationInfo applicationInfo;
            PackageInfo packageInfo;
            PackageInfo packageInfo2;
            ArrayList<f.d.a.d.a> arrayList;
            Context context;
            String[] strArr4;
            String[] strArr5;
            boolean z;
            boolean z2;
            Collection collection;
            boolean z3;
            Class<?> cls;
            Field[] fields;
            boolean z4;
            e.c(strArr, "strings");
            if (c.a(this.f3708e).b.length == 0) {
                Context context2 = this.f3707d;
                HashMap<String, String> hashMap = c.a(this.f3708e).s;
                e.c(context2, "$this$getFields");
                String packageName = context2.getPackageName();
                e.b(packageName, "packageName");
                e.c(packageName, "packageName");
                while (true) {
                    try {
                        cls = Class.forName(packageName + ".R$string");
                        break;
                    } catch (ClassNotFoundException unused) {
                        if (j.n.h.a(packageName, ".", false)) {
                            int c2 = j.n.h.c(packageName);
                            e.c(packageName, "$this$lastIndexOf");
                            packageName = packageName.substring(0, packageName.lastIndexOf(46, c2));
                            e.b(packageName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        } else {
                            packageName = "";
                        }
                        if (packageName.length() > 0) {
                            z4 = true;
                            continue;
                        } else {
                            z4 = false;
                            continue;
                        }
                        if (!z4) {
                            cls = null;
                            break;
                        }
                    }
                }
                aVar = new a(context2, (cls == null || (fields = cls.getFields()) == null) ? new String[0] : f.b.a.c.b.o.b.p1(fields), hashMap);
            } else {
                aVar = new a(this.f3707d, c.a(this.f3708e).b, c.a(this.f3708e).s);
            }
            b a2 = c.a(this.f3708e);
            Boolean o0 = f.b.a.c.b.o.b.o0(this.f3707d, Boolean.valueOf(c.a(this.f3708e).f3698f), "aboutLibraries_description_showIcon");
            a2.f3698f = o0 != null ? o0.booleanValue() : false;
            b a3 = c.a(this.f3708e);
            Boolean o02 = f.b.a.c.b.o.b.o0(this.f3707d, Boolean.valueOf(c.a(this.f3708e).f3700h), "aboutLibraries_description_showVersion");
            a3.f3700h = o02 != null ? o02.booleanValue() : false;
            b a4 = c.a(this.f3708e);
            Boolean o03 = f.b.a.c.b.o.b.o0(this.f3707d, Boolean.valueOf(c.a(this.f3708e).f3702j), "aboutLibraries_description_showVersionName");
            a4.f3702j = o03 != null ? o03.booleanValue() : false;
            b a5 = c.a(this.f3708e);
            Boolean o04 = f.b.a.c.b.o.b.o0(this.f3707d, Boolean.valueOf(c.a(this.f3708e).f3703k), "aboutLibraries_description_showVersionCode");
            a5.f3703k = o04 != null ? o04.booleanValue() : false;
            b a6 = c.a(this.f3708e);
            String p0 = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).f3699g, "aboutLibraries_description_name");
            if (p0 == null) {
                p0 = "";
            }
            a6.f3699g = p0;
            b a7 = c.a(this.f3708e);
            String p02 = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).f3701i, "aboutLibraries_description_text");
            if (p02 == null) {
                p02 = "";
            }
            a7.f3701i = p02;
            c.a(this.f3708e).f3704l = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).f3704l, "aboutLibraries_description_special1_name");
            c.a(this.f3708e).m = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).m, "aboutLibraries_description_special1_text");
            c.a(this.f3708e).n = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).n, "aboutLibraries_description_special2_name");
            c.a(this.f3708e).o = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).o, "aboutLibraries_description_special2_text");
            c.a(this.f3708e).p = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).p, "aboutLibraries_description_special3_name");
            c.a(this.f3708e).q = f.b.a.c.b.o.b.p0(this.f3707d, c.a(this.f3708e).q, "aboutLibraries_description_special3_text");
            HashMap<String, HashMap<String, String>> hashMap2 = c.a(this.f3708e).r;
            if (hashMap2 != null) {
                for (Map.Entry<String, HashMap<String, String>> entry : hashMap2.entrySet()) {
                    String key = entry.getKey();
                    HashMap<String, String> value = entry.getValue();
                    e.c(key, "searchTerm");
                    List<f.d.a.d.a> a8 = aVar.a(aVar.d(), key, true, 1);
                    if (((ArrayList) a8).isEmpty()) {
                        e.c(key, "searchTerm");
                        a8 = aVar.a(new ArrayList(aVar.b), key, true, 1);
                    }
                    if (a8.size() == 1) {
                        f.d.a.d.a aVar2 = a8.get(0);
                        for (Map.Entry<String, String> entry2 : value.entrySet()) {
                            String key2 = entry2.getKey();
                            String value2 = entry2.getValue();
                            Locale locale = Locale.US;
                            e.b(locale, "Locale.US");
                            Objects.requireNonNull(key2, "null cannot be cast to non-null type java.lang.String");
                            String upperCase = key2.toUpperCase(locale);
                            e.b(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                            if (e.a(upperCase, a.EnumC0129a.AUTHOR_NAME.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3711f = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.AUTHOR_WEBSITE.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3712g = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_NAME.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3710e = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_DESCRIPTION.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3713h = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_VERSION.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3714i = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_ARTIFACT_ID.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3715j = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_WEBSITE.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.f3716k = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_OPEN_SOURCE.name())) {
                                aVar2.m = Boolean.parseBoolean(value2);
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_REPOSITORY_LINK.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.n = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LIBRARY_CLASSPATH.name())) {
                                Objects.requireNonNull(aVar2);
                                e.c(value2, "<set-?>");
                                aVar2.o = value2;
                            } else if (e.a(upperCase, a.EnumC0129a.LICENSE_NAME.name())) {
                                if (aVar2.a() == null) {
                                    aVar2.c(new f.d.a.d.b("", "", "", "", ""));
                                }
                                f.d.a.d.b a9 = aVar2.a();
                                if (a9 != null) {
                                    e.c(value2, "<set-?>");
                                    a9.b = value2;
                                }
                            } else if (e.a(upperCase, a.EnumC0129a.LICENSE_SHORT_DESCRIPTION.name())) {
                                if (aVar2.a() == null) {
                                    aVar2.c(new f.d.a.d.b("", "", "", "", ""));
                                }
                                f.d.a.d.b a10 = aVar2.a();
                                if (a10 != null) {
                                    e.c(value2, "<set-?>");
                                    a10.f3718d = value2;
                                }
                            } else if (e.a(upperCase, a.EnumC0129a.LICENSE_DESCRIPTION.name())) {
                                if (aVar2.a() == null) {
                                    aVar2.c(new f.d.a.d.b("", "", "", "", ""));
                                }
                                f.d.a.d.b a11 = aVar2.a();
                                if (a11 != null) {
                                    e.c(value2, "<set-?>");
                                    a11.f3719e = value2;
                                }
                            } else if (e.a(upperCase, a.EnumC0129a.LICENSE_WEBSITE.name())) {
                                if (aVar2.a() == null) {
                                    aVar2.c(new f.d.a.d.b("", "", "", "", ""));
                                }
                                f.d.a.d.b a12 = aVar2.a();
                                if (a12 != null) {
                                    e.c(value2, "<set-?>");
                                    a12.c = value2;
                                }
                            }
                        }
                    }
                }
            }
            Objects.requireNonNull(c.a(this.f3708e));
            Objects.requireNonNull(c.a(this.f3708e));
            Objects.requireNonNull(this.f3708e);
            c cVar2 = this.f3708e;
            Context context3 = this.f3707d;
            String[] strArr6 = c.a(cVar2).c;
            String[] strArr7 = c.a(this.f3708e).f3696d;
            Objects.requireNonNull(c.a(this.f3708e));
            Objects.requireNonNull(c.a(this.f3708e));
            e.c(context3, "ctx");
            e.c(strArr6, "internalLibraries");
            e.c(strArr7, "excludeLibraries");
            boolean z5 = !(strArr7.length == 0);
            HashMap hashMap3 = new HashMap();
            ArrayList<f.d.a.d.a> arrayList2 = new ArrayList<>();
            if (!aVar.a) {
                e.c(context3, "ctx");
                e.c(context3, "$this$getPackageInfo");
                try {
                    packageInfo2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0);
                } catch (Exception unused2) {
                    packageInfo2 = null;
                }
                SharedPreferences sharedPreferences = context3.getSharedPreferences("aboutLibraries", 0);
                boolean z6 = packageInfo2 != null && sharedPreferences.getInt("versionCode", -1) == packageInfo2.versionCode;
                if (packageInfo2 == null || !z6) {
                    cVar = cVar2;
                    strArr3 = strArr7;
                } else {
                    String string = sharedPreferences.getString("autoDetectedLibraries", "");
                    cVar = cVar2;
                    if (string != null) {
                        strArr3 = strArr7;
                        List<String> a13 = new j.n.c(";").a(string, 0);
                        if (!a13.isEmpty()) {
                            ListIterator<String> listIterator = a13.listIterator(a13.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    break;
                                }
                                if (listIterator.previous().length() == 0) {
                                    z3 = true;
                                    continue;
                                } else {
                                    z3 = false;
                                    continue;
                                }
                                if (!z3) {
                                    collection = j.i.b.b(a13, listIterator.nextIndex() + 1);
                                    break;
                                }
                            }
                            Object[] array = collection.toArray(new String[0]);
                            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                            strArr5 = (String[]) array;
                        }
                        collection = d.b;
                        Object[] array2 = collection.toArray(new String[0]);
                        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                        strArr5 = (String[]) array2;
                    } else {
                        strArr3 = strArr7;
                        strArr5 = null;
                    }
                    if (strArr5 != null) {
                        if (strArr5.length == 0) {
                            z2 = true;
                            z = true;
                        } else {
                            z2 = true;
                            z = false;
                        }
                        if ((!z) == z2) {
                            arrayList = new ArrayList(strArr5.length);
                            for (String str : strArr5) {
                                f.d.a.d.a e2 = aVar.e(str);
                                if (e2 != null) {
                                    arrayList.add(e2);
                                }
                            }
                            strArr2 = strArr6;
                            arrayList2.addAll(arrayList);
                            if (z5) {
                                for (f.d.a.d.a aVar3 : arrayList) {
                                    hashMap3.put(aVar3.b, aVar3);
                                }
                            }
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(new ArrayList(aVar.b));
                arrayList3.addAll(aVar.d());
                e.c(context3, "mCtx");
                e.c(arrayList3, "libraries");
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    f.d.a.d.a aVar4 = (f.d.a.d.a) it.next();
                    if (aVar4.o.length() > 0) {
                        try {
                            strArr4 = strArr6;
                            try {
                                Context createPackageContext = context3.createPackageContext(context3.getPackageName(), 3);
                                String str2 = aVar4.o;
                                e.b(createPackageContext, "ctx");
                                context = context3;
                                try {
                                    Class.forName(str2, false, createPackageContext.getClassLoader());
                                    arrayList4.add(aVar4);
                                } catch (PackageManager.NameNotFoundException | ClassNotFoundException unused3) {
                                }
                            } catch (PackageManager.NameNotFoundException | ClassNotFoundException unused4) {
                                context = context3;
                            }
                        } catch (PackageManager.NameNotFoundException | ClassNotFoundException unused5) {
                        }
                        it = it;
                        strArr6 = strArr4;
                        context3 = context;
                    }
                    context = context3;
                    strArr4 = strArr6;
                    it = it;
                    strArr6 = strArr4;
                    context3 = context;
                }
                strArr2 = strArr6;
                if (packageInfo2 != null && !z6) {
                    StringBuilder sb = new StringBuilder();
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        sb.append(";");
                        sb.append(((f.d.a.d.a) it2.next()).b);
                    }
                    sharedPreferences.edit().putInt("versionCode", packageInfo2.versionCode).putString("autoDetectedLibraries", sb.toString()).apply();
                }
                arrayList = arrayList4;
                arrayList2.addAll(arrayList);
                if (z5) {
                }
            } else {
                cVar = cVar2;
                strArr2 = strArr6;
                strArr3 = strArr7;
            }
            ArrayList<f.d.a.d.a> d2 = aVar.d();
            arrayList2.addAll(d2);
            if (z5) {
                Iterator<f.d.a.d.a> it3 = d2.iterator();
                while (it3.hasNext()) {
                    f.d.a.d.a next = it3.next();
                    String str3 = next.b;
                    e.b(next, "lib");
                    hashMap3.put(str3, next);
                }
            }
            if (!(strArr2.length == 0)) {
                for (String str4 : strArr2) {
                    f.d.a.d.a e3 = aVar.e(str4);
                    if (e3 != null) {
                        arrayList2.add(e3);
                        hashMap3.put(e3.b, e3);
                    }
                }
            }
            if (z5) {
                for (String str5 : strArr3) {
                    f.d.a.d.a aVar5 = (f.d.a.d.a) hashMap3.get(str5);
                    if (aVar5 != null) {
                        e.b(aVar5, "libraries[excludeLibrary] ?: continue");
                        arrayList2.remove(aVar5);
                    }
                }
            }
            e.c(arrayList2, "$this$sort");
            if (arrayList2.size() > 1) {
                Collections.sort(arrayList2);
            }
            cVar.f3705d = arrayList2;
            Objects.requireNonNull(this.f3708e);
            Objects.requireNonNull(c.a(this.f3708e));
            boolean z7 = c.a(this.f3708e).f3700h || c.a(this.f3708e).f3702j || c.a(this.f3708e).f3703k;
            if (c.a(this.f3708e).f3698f && z7) {
                PackageManager packageManager = this.f3707d.getPackageManager();
                String packageName2 = this.f3707d.getPackageName();
                try {
                    applicationInfo = packageManager.getApplicationInfo(packageName2, 0);
                    try {
                        packageInfo = packageManager.getPackageInfo(packageName2, 0);
                    } catch (Exception unused6) {
                    }
                } catch (Exception unused7) {
                    applicationInfo = null;
                    packageInfo = null;
                    this.c = applicationInfo.loadIcon(packageManager);
                    this.a = null;
                    this.b = null;
                    if (packageInfo != null) {
                    }
                    return h.a;
                }
                if (c.a(this.f3708e).f3698f && applicationInfo != null) {
                    this.c = applicationInfo.loadIcon(packageManager);
                }
                this.a = null;
                this.b = null;
                if (packageInfo != null) {
                    this.a = packageInfo.versionName;
                    this.b = Integer.valueOf(packageInfo.versionCode);
                }
            }
            return h.a;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(h hVar) {
            h hVar2 = hVar;
            e.c(hVar2, "nothing");
            f.d.b.p.a b2 = c.b(this.f3708e);
            l<Item> lVar = b2.f3737g;
            b<Item> bVar = b2.a;
            lVar.d(bVar != null ? bVar.q(b2.b) : 0);
            boolean z = c.a(this.f3708e).f3700h || c.a(this.f3708e).f3702j || c.a(this.f3708e).f3703k;
            if (c.a(this.f3708e).f3698f && z) {
                f.d.b.p.a b3 = c.b(this.f3708e);
                f.d.a.e.b.a aVar = new f.d.a.e.b.a(c.a(this.f3708e));
                aVar.c = this.a;
                aVar.b = this.b;
                aVar.f3720d = this.c;
                b3.e(aVar);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<f.d.a.d.a> it = this.f3708e.f3705d.iterator();
            while (it.hasNext()) {
                f.d.a.d.a next = it.next();
                Objects.requireNonNull(c.a(this.f3708e));
                e.b(next, "library");
                arrayList.add(new f.d.a.e.b.d(next, c.a(this.f3708e)));
            }
            c.b(this.f3708e).d(arrayList);
            super.onPostExecute(hVar2);
        }

        public void onPreExecute() {
        }
    }

    public static final /* synthetic */ b a(c cVar) {
        b bVar = cVar.c;
        if (bVar != null) {
            return bVar;
        }
        e.e("builder");
        throw null;
    }

    public static final /* synthetic */ f.d.b.p.a b(c cVar) {
        f.d.b.p.a<k<?>> aVar = cVar.b;
        if (aVar != null) {
            return aVar;
        }
        e.e("itemAdapter");
        throw null;
    }
}
