package f.b.a.c.f;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import f.b.a.c.b.p.b;
import f.b.a.c.e.c.h2;
import java.util.HashMap;
import java.util.TreeMap;

public final class a {
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (r2 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
        if (r2 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d4, code lost:
        if (r2 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143 A[SYNTHETIC] */
    public static boolean a(Context context) {
        Object obj;
        String str;
        Boolean bool;
        String str2;
        boolean z = true;
        if (b.a(context).a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = h2.a;
        Boolean bool2 = Boolean.TRUE;
        synchronized (h2.class) {
            h2.a(contentResolver);
            obj = h2.f2499k;
        }
        HashMap<String, Boolean> hashMap = h2.f2495g;
        synchronized (h2.class) {
            str = null;
            if (hashMap.containsKey("gms:nearby:requires_gms_check")) {
                bool = hashMap.get("gms:nearby:requires_gms_check");
                if (bool == null) {
                    bool = bool2;
                }
            } else {
                bool = null;
            }
        }
        Boolean bool3 = bool;
        if (bool3 != null) {
            return bool3.booleanValue();
        }
        synchronized (h2.class) {
            h2.a(contentResolver);
            Object obj2 = h2.f2499k;
            if (h2.f2494f.containsKey("gms:nearby:requires_gms_check")) {
                str2 = h2.f2494f.get("gms:nearby:requires_gms_check");
            } else {
                for (String str3 : h2.m) {
                    if ("gms:nearby:requires_gms_check".startsWith(str3)) {
                        if (!h2.f2500l || h2.f2494f.isEmpty()) {
                            String[] strArr = h2.m;
                            HashMap<String, String> hashMap2 = h2.f2494f;
                            Cursor query = contentResolver.query(h2.b, null, null, strArr, null);
                            TreeMap treeMap = new TreeMap();
                            if (query != null) {
                                while (query.moveToNext()) {
                                    try {
                                        treeMap.put(query.getString(0), query.getString(1));
                                    } finally {
                                        query.close();
                                    }
                                }
                            }
                            hashMap2.putAll(treeMap);
                            h2.f2500l = true;
                            if (h2.f2494f.containsKey("gms:nearby:requires_gms_check")) {
                                str2 = h2.f2494f.get("gms:nearby:requires_gms_check");
                            }
                        }
                    }
                }
                Cursor query2 = contentResolver.query(h2.a, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (query2 != null) {
                    try {
                        if (!query2.moveToFirst()) {
                            h2.b(obj2, "gms:nearby:requires_gms_check", null);
                        } else {
                            String string = query2.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            h2.b(obj2, "gms:nearby:requires_gms_check", string);
                            if (string != null) {
                                str = string;
                            }
                        }
                    } catch (Throwable th) {
                        query2.close();
                        throw th;
                    }
                }
                query2.close();
            }
            str = str2;
        }
        if (str != null && !str.equals("")) {
            if (!h2.c.matcher(str).matches()) {
                if (h2.f2492d.matcher(str).matches()) {
                    bool2 = Boolean.FALSE;
                    z = false;
                } else {
                    Log.w("Gservices", "attempt to read gservices key " + "gms:nearby:requires_gms_check" + " (value \"" + str + "\") as boolean");
                }
            }
            HashMap<String, Boolean> hashMap3 = h2.f2495g;
            synchronized (h2.class) {
                if (obj == h2.f2499k) {
                    hashMap3.put("gms:nearby:requires_gms_check", bool2);
                    h2.f2494f.remove("gms:nearby:requires_gms_check");
                }
            }
            return z;
        }
        bool2 = bool3;
        HashMap<String, Boolean> hashMap32 = h2.f2495g;
        synchronized (h2.class) {
        }
    }
}
