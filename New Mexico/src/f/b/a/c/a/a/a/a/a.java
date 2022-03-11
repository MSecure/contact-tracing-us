package f.b.a.c.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: classes.dex */
public class a {
    public static final Lock c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static a f2665d;
    public final Lock a = new ReentrantLock();
    public final SharedPreferences b;

    public a(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        Lock lock = c;
        lock.lock();
        try {
            if (f2665d == null) {
                f2665d = new a(context.getApplicationContext());
            }
            a aVar = f2665d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            c.unlock();
            throw th;
        }
    }

    @RecentlyNullable
    public GoogleSignInAccount b() {
        String c2 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 20);
        sb.append("googleSignInAccount");
        sb.append(":");
        sb.append(c2);
        String c3 = c(sb.toString());
        if (c3 == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.g(c3);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String c(String str) {
        this.a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.a.unlock();
        }
    }
}
