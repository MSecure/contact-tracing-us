package c.b.a.a.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final Lock f2889c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static a f2890d;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f2891a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f2892b;

    public a(Context context) {
        this.f2892b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        t.C(context);
        f2889c.lock();
        try {
            if (f2890d == null) {
                f2890d = new a(context.getApplicationContext());
            }
            return f2890d;
        } finally {
            f2889c.unlock();
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
            return GoogleSignInAccount.x(c3);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String c(String str) {
        this.f2891a.lock();
        try {
            return this.f2892b.getString(str, null);
        } finally {
            this.f2891a.unlock();
        }
    }
}
