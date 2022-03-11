package f.b.a.c.f;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import f.b.a.c.b.p.b;
import f.b.a.c.e.c.m2;
import java.util.HashMap;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc A[SYNTHETIC] */
    public static boolean a(@RecentlyNonNull Context context) {
        Object obj;
        String str;
        Boolean bool;
        boolean z = true;
        if (b.a(context).a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = m2.a;
        synchronized (m2.class) {
            m2.a(contentResolver);
            obj = m2.f2587k;
        }
        HashMap<String, Boolean> hashMap = m2.f2583g;
        Boolean bool2 = Boolean.TRUE;
        synchronized (m2.class) {
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
        synchronized (m2.class) {
            m2.a(contentResolver);
            Object obj2 = m2.f2587k;
            if (m2.f2582f.containsKey("gms:nearby:requires_gms_check")) {
                String str2 = m2.f2582f.get("gms:nearby:requires_gms_check");
                if (str2 != null) {
                    str = str2;
                }
            } else {
                int length = m2.f2588l.length;
                Cursor query = contentResolver.query(m2.a, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (query != null) {
                    try {
                        if (!query.moveToFirst()) {
                            m2.b(obj2, "gms:nearby:requires_gms_check", null);
                        } else {
                            String string = query.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            m2.b(obj2, "gms:nearby:requires_gms_check", string);
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
            if (!m2.c.matcher(str).matches()) {
                if (m2.f2580d.matcher(str).matches()) {
                    bool2 = Boolean.FALSE;
                    z = false;
                } else {
                    Log.w("Gservices", "attempt to read gservices key gms:nearby:requires_gms_check (value \"" + str + "\") as boolean");
                }
            }
            synchronized (m2.class) {
                if (obj == m2.f2587k) {
                    hashMap.put("gms:nearby:requires_gms_check", bool2);
                    m2.f2582f.remove("gms:nearby:requires_gms_check");
                }
            }
            return z;
        }
        bool2 = bool3;
        synchronized (m2.class) {
        }
    }
}
