package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.runtime.R$id;
import e.a.e.d;
import e.a.e.e;
import e.a.e.f.a;
import e.b.a.m;
import e.i.a.b;
import e.i.a.h;
import e.p.f0;
import e.p.g;
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.p.j;
import e.p.l;
import e.p.m;
import e.p.x;
import e.p.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends h implements l, h0, g, e.u.c, e.a.c, d {
    public final e.a.d.a c = new e.a.d.a();

    /* renamed from: d  reason: collision with root package name */
    public final m f1d;

    /* renamed from: e  reason: collision with root package name */
    public final e.u.b f2e;

    /* renamed from: f  reason: collision with root package name */
    public g0 f3f;

    /* renamed from: g  reason: collision with root package name */
    public f0.b f4g;

    /* renamed from: h  reason: collision with root package name */
    public final OnBackPressedDispatcher f5h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f6i;

    /* renamed from: j  reason: collision with root package name */
    public ActivityResultRegistry f7j;

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

    public class b extends ActivityResultRegistry {

        public class a implements Runnable {
            public final /* synthetic */ int b;
            public final /* synthetic */ a.C0011a c;

            public a(int i2, a.C0011a aVar) {
                this.b = i2;
                this.c = aVar;
            }

            public void run() {
                e.a.e.b<O> bVar;
                b bVar2 = b.this;
                int i2 = this.b;
                T t = this.c.a;
                String str = bVar2.b.get(Integer.valueOf(i2));
                if (str != null) {
                    ActivityResultRegistry.c<?> cVar = bVar2.f15e.get(str);
                    if (cVar == null || (bVar = cVar.a) == null) {
                        bVar2.f17g.remove(str);
                        bVar2.f16f.put(str, t);
                        return;
                    }
                    bVar.a(t);
                }
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        public class RunnableC0000b implements Runnable {
            public final /* synthetic */ int b;
            public final /* synthetic */ IntentSender.SendIntentException c;

            public RunnableC0000b(int i2, IntentSender.SendIntentException sendIntentException) {
                this.b = i2;
                this.c = sendIntentException;
            }

            public void run() {
                b.this.a(this.b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.c));
            }
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void b(int i2, e.a.e.f.a<I, O> aVar, I i3, e.i.a.c cVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0011a<O> b = aVar.b(componentActivity, i3);
            if (b != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, b));
                return;
            }
            Intent a2 = aVar.a(componentActivity, i3);
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else if (cVar == null) {
                bundle = null;
            } else {
                throw null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : stringArrayExtra) {
                        if (ComponentActivity.this.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                            arrayList.add(str);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                        int i4 = e.i.a.b.b;
                        for (String str2 : strArr) {
                            if (TextUtils.isEmpty(str2)) {
                                throw new IllegalArgumentException(f.a.a.a.a.f(f.a.a.a.a.i("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (componentActivity instanceof b.AbstractC0029b) {
                                ((b.AbstractC0029b) componentActivity).b(i2);
                            }
                            componentActivity.requestPermissions(strArr, i2);
                        } else if (componentActivity instanceof b.a) {
                            new Handler(Looper.getMainLooper()).post(new e.i.a.a(strArr, componentActivity, i2));
                        }
                    }
                }
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                e eVar = (e) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = eVar.b;
                    Intent intent = eVar.c;
                    int i5 = eVar.f643d;
                    int i6 = eVar.f644e;
                    int i7 = e.i.a.b.b;
                    componentActivity.startIntentSenderForResult(intentSender, i2, intent, i5, i6, 0, bundle);
                } catch (IntentSender.SendIntentException e2) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0000b(i2, e2));
                }
            } else {
                int i8 = e.i.a.b.b;
                componentActivity.startActivityForResult(a2, i2, bundle);
            }
        }
    }

    public static final class c {
        public g0 a;
    }

    public ComponentActivity() {
        m mVar = new m(this);
        this.f1d = mVar;
        this.f2e = new e.u.b(this);
        this.f5h = new OnBackPressedDispatcher(new a());
        this.f6i = new AtomicInteger();
        this.f7j = new b();
        if (mVar != null) {
            int i2 = Build.VERSION.SDK_INT;
            mVar.a(new j() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // e.p.j
                public void d(l lVar, h.a aVar) {
                    if (aVar == h.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
            mVar.a(new j() {
                /* class androidx.activity.ComponentActivity.AnonymousClass4 */

                @Override // e.p.j
                public void d(l lVar, h.a aVar) {
                    if (aVar == h.a.ON_DESTROY) {
                        ComponentActivity.this.c.b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.i().a();
                        }
                    }
                }
            });
            mVar.a(new j() {
                /* class androidx.activity.ComponentActivity.AnonymousClass5 */

                @Override // e.p.j
                public void d(l lVar, h.a aVar) {
                    ComponentActivity.this.n();
                    m mVar = ComponentActivity.this.f1d;
                    mVar.d("removeObserver");
                    mVar.a.l(this);
                }
            });
            if (i2 <= 23) {
                mVar.a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // e.p.l
    public e.p.h a() {
        return this.f1d;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o();
        super.addContentView(view, layoutParams);
    }

    @Override // e.a.c
    public final OnBackPressedDispatcher c() {
        return this.f5h;
    }

    @Override // e.u.c
    public final e.u.a d() {
        return this.f2e.b;
    }

    @Override // e.a.e.d
    public final ActivityResultRegistry f() {
        return this.f7j;
    }

    @Override // e.p.h0
    public g0 i() {
        if (getApplication() != null) {
            n();
            return this.f3f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // e.p.g
    public f0.b l() {
        if (getApplication() != null) {
            if (this.f4g == null) {
                this.f4g = new z(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.f4g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void n() {
        if (this.f3f == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.f3f = cVar.a;
            }
            if (this.f3f == null) {
                this.f3f = new g0();
            }
        }
    }

    public final void o() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.f7j.a(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        this.f5h.b();
    }

    @Override // e.i.a.h
    public void onCreate(Bundle bundle) {
        this.f2e.a(bundle);
        e.a.d.a aVar = this.c;
        aVar.b = this;
        for (e.a.d.b bVar : aVar.a) {
            bVar.a(this);
        }
        super.onCreate(bundle);
        ActivityResultRegistry activityResultRegistry = this.f7j;
        Objects.requireNonNull(activityResultRegistry);
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (!(stringArrayList == null || integerArrayList == null)) {
                int size = stringArrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int intValue = integerArrayList.get(i2).intValue();
                    String str = stringArrayList.get(i2);
                    activityResultRegistry.b.put(Integer.valueOf(intValue), str);
                    activityResultRegistry.c.put(str, Integer.valueOf(intValue));
                }
                activityResultRegistry.a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                activityResultRegistry.f17g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
        x.c(this);
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.f7j.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        g0 g0Var = this.f3f;
        if (g0Var == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            g0Var = cVar.a;
        }
        if (g0Var == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.a = g0Var;
        return cVar2;
    }

    @Override // e.i.a.h
    public void onSaveInstanceState(Bundle bundle) {
        m mVar = this.f1d;
        if (mVar instanceof m) {
            h.b bVar = h.b.CREATED;
            mVar.d("setCurrentState");
            mVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.f2e.b(bundle);
        ActivityResultRegistry activityResultRegistry = this.f7j;
        Objects.requireNonNull(activityResultRegistry);
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.b.values()));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.f17g.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.a);
    }

    public void reportFullyDrawn() {
        try {
            if (m.h.B0()) {
                Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        o();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        o();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o();
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
