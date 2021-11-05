package c.b.a.a.c.k.o;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import b.e.a;
import c.b.a.a.e.b.d;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class h1 extends Fragment implements j {

    /* renamed from: e  reason: collision with root package name */
    public static WeakHashMap<Activity, WeakReference<h1>> f2360e = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, LifecycleCallback> f2361b = new a();

    /* renamed from: c  reason: collision with root package name */
    public int f2362c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f2363d;

    @Override // c.b.a.a.c.k.o.j
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f2361b.containsKey(str)) {
            this.f2361b.put(str, lifecycleCallback);
            if (this.f2362c > 0) {
                new d(Looper.getMainLooper()).post(new g1(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // c.b.a.a.c.k.o.j
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f2361b.get(str));
    }

    @Override // c.b.a.a.c.k.o.j
    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            lifecycleCallback.a();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            lifecycleCallback.c(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2362c = 1;
        this.f2363d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f2361b.entrySet()) {
            entry.getValue().d(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f2362c = 5;
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    public final void onResume() {
        super.onResume();
        this.f2362c = 3;
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            lifecycleCallback.e();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.f2361b.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().f(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f2362c = 2;
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            lifecycleCallback.g();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f2362c = 4;
        for (LifecycleCallback lifecycleCallback : this.f2361b.values()) {
            lifecycleCallback.h();
        }
    }
}
