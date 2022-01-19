package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzc extends Fragment implements LifecycleFragment {
    public Map<String, LifecycleCallback> zzb = Collections.synchronizedMap(new ArrayMap());
    public Bundle zzd;

    static {
        new WeakHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            lifecycleCallback.dump();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            lifecycleCallback.onActivityResult();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzd = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
            LifecycleCallback value = entry.getValue();
            if (bundle != null) {
                bundle.getBundle(entry.getKey());
            }
            value.onCreate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.mCalled = true;
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        this.mCalled = true;
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().onSaveInstanceState();
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        this.mCalled = true;
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        this.mCalled = true;
        for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }
}
