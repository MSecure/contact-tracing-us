package c.b.a.a.e.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import b.i.e.a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

@TargetApi(19)
public final class s7 {
    public static final WeakHashMap<Activity, s7> g = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final Context f2720a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Activity> f2721b;

    /* renamed from: c  reason: collision with root package name */
    public final NfcAdapter f2722c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2723d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2724e;
    public boolean f;

    public s7(Activity activity) {
        this.f2720a = activity.getApplicationContext();
        this.f2721b = new WeakReference<>(activity);
        this.f2722c = NfcAdapter.getDefaultAdapter(this.f2720a);
        activity.getApplication().registerActivityLifecycleCallbacks(new u7(this, this.f2721b));
    }

    public static synchronized s7 a(Activity activity) {
        s7 s7Var;
        synchronized (s7.class) {
            if (!g.containsKey(activity)) {
                g.put(activity, new s7(activity));
            }
            s7Var = g.get(activity);
        }
        return s7Var;
    }

    public final void b() {
        Activity activity;
        NfcAdapter nfcAdapter;
        boolean z = false;
        if (!this.f2723d || !this.f2724e) {
            if (this.f) {
                Activity activity2 = this.f2721b.get();
                if (activity2 != null) {
                    this.f2722c.disableReaderMode(activity2);
                }
                this.f = false;
            }
        } else if (!this.f) {
            if (this.f2720a.getPackageManager().hasSystemFeature("android.hardware.nfc") && a.a(this.f2720a, "android.permission.NFC") == 0 && (nfcAdapter = this.f2722c) != null && nfcAdapter.isEnabled()) {
                z = true;
            }
            if (z && (activity = this.f2721b.get()) != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("presence", 100);
                this.f2722c.enableReaderMode(activity, new v7(this), 385, bundle);
                this.f = true;
            }
        }
    }
}
