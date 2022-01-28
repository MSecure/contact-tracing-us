package c.b.a.a.c.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import b.b.k.i;
import java.util.Arrays;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2459a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static h f2460b;

    public static final class a {
        public static final Uri f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a  reason: collision with root package name */
        public final String f2461a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2462b;

        /* renamed from: c  reason: collision with root package name */
        public final ComponentName f2463c = null;

        /* renamed from: d  reason: collision with root package name */
        public final int f2464d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f2465e;

        public a(String str, String str2, int i, boolean z) {
            i.j.n(str);
            this.f2461a = str;
            i.j.n(str2);
            this.f2462b = str2;
            this.f2464d = i;
            this.f2465e = z;
        }

        public final Intent a(Context context) {
            Bundle bundle;
            if (this.f2461a == null) {
                return new Intent().setComponent(this.f2463c);
            }
            Intent intent = null;
            if (this.f2465e) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", this.f2461a);
                try {
                    bundle = context.getContentResolver().call(f, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e2) {
                    String.valueOf(e2).length();
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf = String.valueOf(this.f2461a);
                    if (valueOf.length() != 0) {
                        "Dynamic lookup for intent failed for action: ".concat(valueOf);
                    } else {
                        new String("Dynamic lookup for intent failed for action: ");
                    }
                }
            }
            return intent == null ? new Intent(this.f2461a).setPackage(this.f2462b) : intent;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return i.j.X(this.f2461a, aVar.f2461a) && i.j.X(this.f2462b, aVar.f2462b) && i.j.X(this.f2463c, aVar.f2463c) && this.f2464d == aVar.f2464d && this.f2465e == aVar.f2465e;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f2461a, this.f2462b, this.f2463c, Integer.valueOf(this.f2464d), Boolean.valueOf(this.f2465e)});
        }

        public final String toString() {
            String str = this.f2461a;
            if (str != null) {
                return str;
            }
            i.j.s(this.f2463c);
            return this.f2463c.flattenToString();
        }
    }

    public static int a() {
        return 129;
    }

    public static h b(Context context) {
        synchronized (f2459a) {
            if (f2460b == null) {
                f2460b = new d0(context.getApplicationContext());
            }
        }
        return f2460b;
    }

    public final void c(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        a aVar = new a(str, str2, i, z);
        d0 d0Var = (d0) this;
        i.j.t(serviceConnection, "ServiceConnection must not be null");
        synchronized (d0Var.f2448c) {
            c0 c0Var = d0Var.f2448c.get(aVar);
            if (c0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (c0Var.f2442a.containsKey(serviceConnection)) {
                c.b.a.a.c.m.a aVar2 = c0Var.g.f;
                c0Var.f2442a.remove(serviceConnection);
                if (c0Var.f2442a.isEmpty()) {
                    d0Var.f2450e.sendMessageDelayed(d0Var.f2450e.obtainMessage(0, aVar), d0Var.g);
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
