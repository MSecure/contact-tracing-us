package f.b.a.c.f;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import f.b.a.c.b.p.b;
import f.b.a.c.e.c.u2;
import java.util.HashMap;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A[SYNTHETIC] */
    public static boolean a(Context context) {
        Object obj;
        String str;
        Boolean bool;
        boolean z = true;
        if (b.a(context).a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = u2.a;
        synchronized (u2.class) {
            u2.a(contentResolver);
            obj = u2.f2688k;
        }
        HashMap<String, Boolean> hashMap = u2.f2684g;
        Boolean bool2 = Boolean.TRUE;
        synchronized (u2.class) {
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
        synchronized (u2.class) {
            u2.a(contentResolver);
            Object obj2 = u2.f2688k;
            if (u2.f2683f.containsKey("gms:nearby:requires_gms_check")) {
                String str2 = u2.f2683f.get("gms:nearby:requires_gms_check");
                if (str2 != null) {
                    str = str2;
                }
            } else {
                int length = u2.f2689l.length;
                Cursor query = contentResolver.query(u2.a, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (query != null) {
                    try {
                        if (!query.moveToFirst()) {
                            u2.b(obj2, "gms:nearby:requires_gms_check", null);
                        } else {
                            String string = query.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            u2.b(obj2, "gms:nearby:requires_gms_check", string);
                            if (string != null) {
                                str = string;
                            }
                        }
                    } finally {
                        query.close();
                    }
                }
            }
        }
        if (str != null && !str.equals("")) {
            if (!u2.c.matcher(str).matches()) {
                if (u2.f2681d.matcher(str).matches()) {
                    bool2 = Boolean.FALSE;
                    z = false;
                }
            }
            synchronized (u2.class) {
                if (obj == u2.f2688k) {
                    hashMap.put("gms:nearby:requires_gms_check", bool2);
                    u2.f2683f.remove("gms:nearby:requires_gms_check");
                }
            }
            return z;
        }
        bool2 = bool3;
        synchronized (u2.class) {
        }
    }
}
