package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.runtime.R$id;
import e.a.e.d;
import e.a.e.e;
import e.i.a.f;
import e.p.b0;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import e.p.t;
import e.p.v;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends f implements j, d0, e.p.f, e.u.c, e.a.c, e {
    public final e.a.d.a c = new e.a.d.a();

    /* renamed from: d  reason: collision with root package name */
    public final k f1d;

    /* renamed from: e  reason: collision with root package name */
    public final e.u.b f2e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f3f;

    /* renamed from: g  reason: collision with root package name */
    public b0.b f4g;

    /* renamed from: h  reason: collision with root package name */
    public final OnBackPressedDispatcher f5h;

    /* renamed from: i  reason: collision with root package name */
    public d f6i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    public class b extends d {
        public b(ComponentActivity componentActivity) {
        }
    }

    public static final class c {
        public c0 a;
    }

    public ComponentActivity() {
        k kVar = new k(this);
        this.f1d = kVar;
        this.f2e = new e.u.b(this);
        this.f5h = new OnBackPressedDispatcher(new a());
        new AtomicInteger();
        this.f6i = new b(this);
        if (kVar != null) {
            int i2 = Build.VERSION.SDK_INT;
            kVar.a(new h() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // e.p.h
                public void d(j jVar, g.a aVar) {
                    if (aVar == g.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
            kVar.a(new h() {
                /* class androidx.activity.ComponentActivity.AnonymousClass4 */

                @Override // e.p.h
                public void d(j jVar, g.a aVar) {
                    if (aVar == g.a.ON_DESTROY) {
                        ComponentActivity.this.c.b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.h().a();
                        }
                    }
                }
            });
            if (i2 <= 23) {
                kVar.a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // e.p.j
    public g a() {
        return this.f1d;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        super.addContentView(view, layoutParams);
    }

    @Override // e.a.c
    public final OnBackPressedDispatcher b() {
        return this.f5h;
    }

    @Override // e.u.c
    public final e.u.a c() {
        return this.f2e.b;
    }

    @Override // e.a.e.e
    public final d e() {
        return this.f6i;
    }

    @Override // e.p.d0
    public c0 h() {
        if (getApplication() != null) {
            if (this.f3f == null) {
                c cVar = (c) getLastNonConfigurationInstance();
                if (cVar != null) {
                    this.f3f = cVar.a;
                }
                if (this.f3f == null) {
                    this.f3f = new c0();
                }
            }
            return this.f3f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // e.p.f
    public b0.b k() {
        if (getApplication() != null) {
            if (this.f4g == null) {
                this.f4g = new v(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.f4g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final void m() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.f6i.a(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        this.f5h.b();
    }

    @Override // e.i.a.f
    public void onCreate(Bundle bundle) {
        this.f2e.a(bundle);
        e.a.d.a aVar = this.c;
        aVar.b = this;
        for (e.a.d.b bVar : aVar.a) {
            bVar.a(this);
        }
        super.onCreate(bundle);
        d dVar = this.f6i;
        Objects.requireNonNull(dVar);
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (!(stringArrayList == null || integerArrayList == null)) {
                int size = stringArrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int intValue = integerArrayList.get(i2).intValue();
                    String str = stringArrayList.get(i2);
                    dVar.b.put(Integer.valueOf(intValue), str);
                    dVar.c.put(str, Integer.valueOf(intValue));
                }
                dVar.a.set(size);
                dVar.f641e.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
        t.c(this);
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.f6i.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        c0 c0Var = this.f3f;
        if (c0Var == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            c0Var = cVar.a;
        }
        if (c0Var == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.a = c0Var;
        return cVar2;
    }

    @Override // e.i.a.f
    public void onSaveInstanceState(Bundle bundle) {
        k kVar = this.f1d;
        if (kVar instanceof k) {
            g.b bVar = g.b.CREATED;
            kVar.d("setCurrentState");
            kVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.f2e.b(bundle);
        d dVar = this.f6i;
        Objects.requireNonNull(dVar);
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(dVar.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(dVar.b.values()));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", dVar.f641e);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        m();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
