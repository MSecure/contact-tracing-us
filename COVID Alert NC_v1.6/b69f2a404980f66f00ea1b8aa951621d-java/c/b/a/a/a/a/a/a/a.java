package c.b.a.a.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b.b.k.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final Lock f2276c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static a f2277d;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f2278a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f2279b;

    public a(Context context) {
        this.f2279b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        i.j.s(context);
        f2276c.lock();
        try {
            if (f2277d == null) {
                f2277d = new a(context.getApplicationContext());
            }
            return f2277d;
        } finally {
            f2276c.unlock();
        }
    }

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
            return GoogleSignInAccount.q(c3);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String c(String str) {
        this.f2278a.lock();
        try {
            return this.f2279b.getString(str, null);
        } finally {
            this.f2278a.unlock();
        }
    }
}
