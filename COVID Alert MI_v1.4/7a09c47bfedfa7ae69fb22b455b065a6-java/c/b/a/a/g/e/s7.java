package c.b.a.a.g.e;

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

    /* renamed from: g  reason: collision with root package name */
    public static final WeakHashMap<Activity, s7> f3714g = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3715a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Activity> f3716b;

    /* renamed from: c  reason: collision with root package name */
    public final NfcAdapter f3717c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3718d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3719e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3720f;

    public s7(Activity activity) {
        this.f3715a = activity.getApplicationContext();
        this.f3716b = new WeakReference<>(activity);
        this.f3717c = NfcAdapter.getDefaultAdapter(this.f3715a);
        activity.getApplication().registerActivityLifecycleCallbacks(new u7(this, this.f3716b));
    }

    public static synchronized s7 a(Activity activity) {
        s7 s7Var;
        synchronized (s7.class) {
            if (!f3714g.containsKey(activity)) {
                f3714g.put(activity, new s7(activity));
            }
            s7Var = f3714g.get(activity);
        }
        return s7Var;
    }

    public final void b() {
        Activity activity;
        NfcAdapter nfcAdapter;
        boolean z = false;
        if (!this.f3718d || !this.f3719e) {
            if (this.f3720f) {
                Activity activity2 = this.f3716b.get();
                if (activity2 != null) {
                    this.f3717c.disableReaderMode(activity2);
                }
                this.f3720f = false;
            }
        } else if (!this.f3720f) {
            if (this.f3715a.getPackageManager().hasSystemFeature("android.hardware.nfc") && a.a(this.f3715a, "android.permission.NFC") == 0 && (nfcAdapter = this.f3717c) != null && nfcAdapter.isEnabled()) {
                z = true;
            }
            if (z && (activity = this.f3716b.get()) != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("presence", 100);
                this.f3717c.enableReaderMode(activity, new v7(this), 385, bundle);
                this.f3720f = true;
            }
        }
    }
}
