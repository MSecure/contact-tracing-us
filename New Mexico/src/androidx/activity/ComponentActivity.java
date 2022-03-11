package androidx.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.runtime.R$id;
import e.a.e.f.a;
import e.b.a.m;
import e.j.a.c;
import e.j.a.g;
import e.r.f0;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.j;
import e.r.l;
import e.r.m;
import e.r.x;
import e.r.z;
import e.w.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ComponentActivity extends g implements l, h0, e.r.g, e.w.c, e.a.c, e.a.e.d {

    /* renamed from: d */
    public final m f1d;

    /* renamed from: e */
    public final e.w.b f2e;

    /* renamed from: f */
    public g0 f3f;

    /* renamed from: g */
    public f0.b f4g;
    public final e.a.d.a c = new e.a.d.a();

    /* renamed from: h */
    public final OnBackPressedDispatcher f5h = new OnBackPressedDispatcher(new a());

    /* renamed from: i */
    public final AtomicInteger f6i = new AtomicInteger();

    /* renamed from: j */
    public final ActivityResultRegistry f7j = new b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            ComponentActivity.this = r1;
        }

        @Override // java.lang.Runnable
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

    /* loaded from: classes.dex */
    public class b extends ActivityResultRegistry {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ int b;
            public final /* synthetic */ a.C0011a c;

            public a(int i2, a.C0011a aVar) {
                b.this = r1;
                this.b = i2;
                this.c = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.a.e.b<?> bVar;
                b bVar2 = b.this;
                int i2 = this.b;
                Object obj = this.c.a;
                String str = bVar2.b.get(Integer.valueOf(i2));
                if (str != null) {
                    bVar2.f15e.remove(str);
                    ActivityResultRegistry.c<?> cVar = bVar2.f16f.get(str);
                    if (cVar == null || (bVar = cVar.a) == null) {
                        bVar2.f18h.remove(str);
                        bVar2.f17g.put(str, obj);
                        return;
                    }
                    bVar.a(obj);
                }
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b */
        /* loaded from: classes.dex */
        public class RunnableC0000b implements Runnable {
            public final /* synthetic */ int b;
            public final /* synthetic */ IntentSender.SendIntentException c;

            public RunnableC0000b(int i2, IntentSender.SendIntentException sendIntentException) {
                b.this = r1;
                this.b = i2;
                this.c = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a(this.b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.c));
            }
        }

        public b() {
            ComponentActivity.this = r1;
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void b(int i2, e.a.e.f.a<I, O> aVar, I i3, e.j.a.d dVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0011a<O> b = aVar.b(componentActivity, i3);
            if (b != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, b));
                return;
            }
            Intent a2 = aVar.a(componentActivity, i3);
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (dVar == null) {
                bundle = null;
            } else {
                throw null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                int i4 = e.j.a.c.b;
                for (String str : stringArrayExtra) {
                    if (TextUtils.isEmpty(str)) {
                        throw new IllegalArgumentException(f.a.a.a.a.e(f.a.a.a.a.h("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                    }
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (componentActivity instanceof c.b) {
                        ((c.b) componentActivity).b(i2);
                    }
                    componentActivity.requestPermissions(stringArrayExtra, i2);
                } else if (componentActivity instanceof c.a) {
                    new Handler(Looper.getMainLooper()).post(new e.j.a.a(stringArrayExtra, componentActivity, i2));
                }
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                e.a.e.e eVar = (e.a.e.e) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = eVar.b;
                    Intent intent = eVar.c;
                    int i5 = eVar.f652d;
                    int i6 = eVar.f653e;
                    int i7 = e.j.a.c.b;
                    componentActivity.startIntentSenderForResult(intentSender, i2, intent, i5, i6, 0, bundle);
                } catch (IntentSender.SendIntentException e2) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0000b(i2, e2));
                }
            } else {
                int i8 = e.j.a.c.b;
                componentActivity.startActivityForResult(a2, i2, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.b {
        public c() {
            ComponentActivity.this = r1;
        }

        @Override // e.w.a.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            ActivityResultRegistry activityResultRegistry = ComponentActivity.this.f7j;
            Objects.requireNonNull(activityResultRegistry);
            bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.c.values()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.c.keySet()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.f15e));
            bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.f18h.clone());
            bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.a);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public class d implements e.a.d.b {
        public d() {
            ComponentActivity.this = r1;
        }

        @Override // e.a.d.b
        public void a(Context context) {
            Bundle a = ComponentActivity.this.f2e.b.a("android:support:activity-result");
            if (a != null) {
                ActivityResultRegistry activityResultRegistry = ComponentActivity.this.f7j;
                Objects.requireNonNull(activityResultRegistry);
                ArrayList<Integer> integerArrayList = a.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                ArrayList<String> stringArrayList = a.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                if (!(stringArrayList == null || integerArrayList == null)) {
                    activityResultRegistry.f15e = a.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    activityResultRegistry.a = (Random) a.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    activityResultRegistry.f18h.putAll(a.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                    for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                        String str = stringArrayList.get(i2);
                        if (activityResultRegistry.c.containsKey(str)) {
                            Integer remove = activityResultRegistry.c.remove(str);
                            if (!activityResultRegistry.f18h.containsKey(str)) {
                                activityResultRegistry.b.remove(remove);
                            }
                        }
                        int intValue = integerArrayList.get(i2).intValue();
                        String str2 = stringArrayList.get(i2);
                        activityResultRegistry.b.put(Integer.valueOf(intValue), str2);
                        activityResultRegistry.c.put(str2, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class e {
        public g0 a;
    }

    public ComponentActivity() {
        m mVar = new m(this);
        this.f1d = mVar;
        e.w.b bVar = new e.w.b(this);
        this.f2e = bVar;
        if (mVar != null) {
            int i2 = Build.VERSION.SDK_INT;
            mVar.a(new j() { // from class: androidx.activity.ComponentActivity.3
                @Override // e.r.j
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
            mVar.a(new j() { // from class: androidx.activity.ComponentActivity.4
                @Override // e.r.j
                public void d(l lVar, h.a aVar) {
                    if (aVar == h.a.ON_DESTROY) {
                        ComponentActivity.this.c.b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.i().a();
                        }
                    }
                }
            });
            mVar.a(new j() { // from class: androidx.activity.ComponentActivity.5
                @Override // e.r.j
                public void d(l lVar, h.a aVar) {
                    ComponentActivity.this.o();
                    m mVar2 = ComponentActivity.this.f1d;
                    mVar2.d("removeObserver");
                    mVar2.a.l(this);
                }
            });
            if (i2 <= 23) {
                mVar.a(new ImmLeaksCleaner(this));
            }
            bVar.b.b("android:support:activity-result", new c());
            n(new d());
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // e.r.l
    public h a() {
        return this.f1d;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        super.addContentView(view, layoutParams);
    }

    @Override // e.a.c
    public final OnBackPressedDispatcher c() {
        return this.f5h;
    }

    @Override // e.w.c
    public final e.w.a d() {
        return this.f2e.b;
    }

    @Override // e.a.e.d
    public final ActivityResultRegistry f() {
        return this.f7j;
    }

    @Override // e.r.h0
    public g0 i() {
        if (getApplication() != null) {
            o();
            return this.f3f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // e.r.g
    public f0.b l() {
        if (getApplication() != null) {
            if (this.f4g == null) {
                this.f4g = new z(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.f4g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final void n(e.a.d.b bVar) {
        e.a.d.a aVar = this.c;
        if (aVar.b != null) {
            bVar.a(aVar.b);
        }
        aVar.a.add(bVar);
    }

    public void o() {
        if (this.f3f == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f3f = eVar.a;
            }
            if (this.f3f == null) {
                this.f3f = new g0();
            }
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.f7j.a(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f5h.b();
    }

    @Override // e.j.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f2e.a(bundle);
        e.a.d.a aVar = this.c;
        aVar.b = this;
        for (e.a.d.b bVar : aVar.a) {
            bVar.a(this);
        }
        super.onCreate(bundle);
        x.c(this);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.f7j.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        g0 g0Var = this.f3f;
        if (g0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            g0Var = eVar.a;
        }
        if (g0Var == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.a = g0Var;
        return eVar2;
    }

    @Override // e.j.a.g, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        m mVar = this.f1d;
        if (mVar instanceof m) {
            h.b bVar = h.b.CREATED;
            mVar.d("setCurrentState");
            mVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.f2e.b(bundle);
    }

    public final void p() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (m.e.P0()) {
                Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        p();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        p();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
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
