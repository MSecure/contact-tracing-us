package c.b.a.a.g.b;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static final ConcurrentHashMap<Uri, b> h = new ConcurrentHashMap<>();
    public static final String[] i = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f3222a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f3223b;

    /* renamed from: c  reason: collision with root package name */
    public final ContentObserver f3224c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3225d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Map<String, String> f3226e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f3227f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final List<d> f3228g = new ArrayList();

    public b(ContentResolver contentResolver, Uri uri) {
        this.f3222a = contentResolver;
        this.f3223b = uri;
        this.f3224c = new c(this);
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        Cursor query = this.f3222a.query(this.f3223b, i, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), query.getString(1));
                } catch (SQLiteException | SecurityException unused) {
                    return null;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
        }
        return hashMap;
    }
}
