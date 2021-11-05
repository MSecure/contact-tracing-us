package c.b.a.a.c.k.o;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import b.e.a;
import b.l.d.d;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class i1 extends Fragment implements j {

    /* renamed from: e  reason: collision with root package name */
    public static WeakHashMap<d, WeakReference<i1>> f2367e = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, LifecycleCallback> f2368b = new a();

    /* renamed from: c  reason: collision with root package name */
    public int f2369c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f2370d;

    @Override // c.b.a.a.c.k.o.j
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f2368b.containsKey(str)) {
            this.f2368b.put(str, lifecycleCallback);
            if (this.f2369c > 0) {
                new c.b.a.a.e.b.d(Looper.getMainLooper()).post(new j1(this, lifecycleCallback, str));
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
        return cls.cast(this.f2368b.get(str));
    }

    @Override // c.b.a.a.c.k.o.j
    public final /* synthetic */ Activity c() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            lifecycleCallback.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            lifecycleCallback.c(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2369c = 1;
        this.f2370d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f2368b.entrySet()) {
            entry.getValue().d(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f2369c = 5;
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f2369c = 3;
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            lifecycleCallback.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.f2368b.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().f(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f2369c = 2;
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f2369c = 4;
        for (LifecycleCallback lifecycleCallback : this.f2368b.values()) {
            lifecycleCallback.h();
        }
    }
}
