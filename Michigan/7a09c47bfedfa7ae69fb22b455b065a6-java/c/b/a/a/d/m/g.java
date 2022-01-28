package c.b.a.a.d.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import java.util.Arrays;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3115a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static g f3116b;

    public static final class a {

        /* renamed from: f  reason: collision with root package name */
        public static final Uri f3117f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a  reason: collision with root package name */
        public final String f3118a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3119b;

        /* renamed from: c  reason: collision with root package name */
        public final ComponentName f3120c = null;

        /* renamed from: d  reason: collision with root package name */
        public final int f3121d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3122e;

        public a(String str, String str2, int i, boolean z) {
            t.z(str);
            this.f3118a = str;
            t.z(str2);
            this.f3119b = str2;
            this.f3121d = i;
            this.f3122e = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.j1(this.f3118a, aVar.f3118a) && t.j1(this.f3119b, aVar.f3119b) && t.j1(this.f3120c, aVar.f3120c) && this.f3121d == aVar.f3121d && this.f3122e == aVar.f3122e;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f3118a, this.f3119b, this.f3120c, Integer.valueOf(this.f3121d), Boolean.valueOf(this.f3122e)});
        }

        public final String toString() {
            String str = this.f3118a;
            if (str != null) {
                return str;
            }
            t.C(this.f3120c);
            return this.f3120c.flattenToString();
        }
    }

    @RecentlyNonNull
    public static int a() {
        return 4225;
    }

    @RecentlyNonNull
    public static g b(@RecentlyNonNull Context context) {
        synchronized (f3115a) {
            if (f3116b == null) {
                f3116b = new f0(context.getApplicationContext());
            }
        }
        return f3116b;
    }

    public final void c(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, @RecentlyNonNull boolean z) {
        a aVar = new a(str, str2, i, z);
        f0 f0Var = (f0) this;
        t.D(serviceConnection, "ServiceConnection must not be null");
        synchronized (f0Var.f3110c) {
            h0 h0Var = f0Var.f3110c.get(aVar);
            if (h0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (h0Var.f3124a.containsKey(serviceConnection)) {
                h0Var.f3124a.remove(serviceConnection);
                if (h0Var.f3124a.isEmpty()) {
                    f0Var.f3112e.sendMessageDelayed(f0Var.f3112e.obtainMessage(0, aVar), f0Var.f3114g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public abstract boolean d(a aVar, ServiceConnection serviceConnection, String str);
}
