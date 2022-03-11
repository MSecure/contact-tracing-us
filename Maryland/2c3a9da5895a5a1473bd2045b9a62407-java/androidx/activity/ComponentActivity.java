package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.runtime.R$id;
import e.a.e.d;
import e.a.e.e;
import e.a.e.f.a;
import e.i.a.b;
import e.i.a.h;
import e.p.b0;
import e.p.c0;
import e.p.d0;
import e.p.f;
import e.p.g;
import e.p.j;
import e.p.k;
import e.p.t;
import e.p.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends h implements j, d0, f, e.u.c, e.a.c, d {
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
                ActivityResultRegistry.c<?> cVar;
                e.a.e.b<O> bVar;
                b bVar2 = b.this;
                int i2 = this.b;
                T t = this.c.a;
                String str = bVar2.b.get(Integer.valueOf(i2));
                if (str != null && (cVar = bVar2.f14d.get(str)) != null && (bVar = cVar.a) != null) {
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
                                throw new IllegalArgumentException(f.a.a.a.a.e(f.a.a.a.a.h("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (componentActivity instanceof b.AbstractC0034b) {
                                ((b.AbstractC0034b) componentActivity).b(i2);
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
                    int i5 = eVar.f641d;
                    int i6 = eVar.f642e;
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
        public c0 a;
    }

    public ComponentActivity() {
        k kVar = new k(this);
        this.f1d = kVar;
        this.f2e = new e.u.b(this);
        this.f5h = new OnBackPressedDispatcher(new a());
        this.f6i = new AtomicInteger();
        this.f7j = new b();
        if (kVar != null) {
            int i2 = Build.VERSION.SDK_INT;
            kVar.a(new e.p.h() {
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
            kVar.a(new e.p.h() {
                /* class androidx.activity.ComponentActivity.AnonymousClass4 */

                @Override // e.p.h
                public void d(j jVar, g.a aVar) {
                    if (aVar == g.a.ON_DESTROY) {
                        ComponentActivity.this.c.b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.i().a();
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
        n();
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

    @Override // e.p.d0
    public c0 i() {
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
    public b0.b l() {
        if (getApplication() != null) {
            if (this.f4g == null) {
                this.f4g = new v(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.f4g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final void n() {
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
                activityResultRegistry.a.set(size);
                activityResultRegistry.f15e.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
        t.c(this);
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.f7j.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
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

    @Override // e.i.a.h
    public void onSaveInstanceState(Bundle bundle) {
        k kVar = this.f1d;
        if (kVar instanceof k) {
            g.b bVar = g.b.CREATED;
            kVar.d("setCurrentState");
            kVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.f2e.b(bundle);
        ActivityResultRegistry activityResultRegistry = this.f7j;
        Objects.requireNonNull(activityResultRegistry);
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.b.values()));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", activityResultRegistry.f15e);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        n();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        n();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n();
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
