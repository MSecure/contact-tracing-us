package androidx.activity;

import android.annotation.SuppressLint;
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
import b.a.e.f.a;
import b.b.k.i;
import b.i.d.e;
import b.o.a0;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.j;
import b.o.s;
import b.o.u;
import b.o.y;
import b.o.z;
import b.t.d;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends e implements i, a0, b.o.e, d, b.a.c, b.a.e.d {
    public final ActivityResultRegistry mActivityResultRegistry;
    public int mContentLayoutId;
    public final b.a.d.a mContextAwareHelper;
    public y.b mDefaultFactory;
    public final j mLifecycleRegistry;
    public final AtomicInteger mNextLocalRequestCode;
    public final OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final b.t.c mSavedStateRegistryController;
    public z mViewModelStore;

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

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f5b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.C0007a f6c;

            public a(int i, a.C0007a aVar) {
                this.f5b = i;
                this.f6c = aVar;
            }

            public void run() {
                b.a.e.b<O> bVar;
                b bVar2 = b.this;
                int i = this.f5b;
                T t = this.f6c.f506a;
                String str = bVar2.f27b.get(Integer.valueOf(i));
                if (str != null) {
                    bVar2.f30e.remove(str);
                    ActivityResultRegistry.c<?> cVar = bVar2.f31f.get(str);
                    if (cVar == null || (bVar = cVar.f45a) == null) {
                        bVar2.h.remove(str);
                        bVar2.f32g.put(str, t);
                        return;
                    }
                    bVar.a(t);
                }
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        public class RunnableC0002b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f8b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f9c;

            public RunnableC0002b(int i, IntentSender.SendIntentException sendIntentException) {
                this.f8b = i;
                this.f9c = sendIntentException;
            }

            public void run() {
                b.this.a(this.f8b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f9c));
            }
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void b(int i2, b.a.e.f.a<I, O> aVar, I i3, b.i.d.b bVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0007a<O> b2 = aVar.b(componentActivity, i3);
            if (b2 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, b2));
                return;
            }
            Intent a2 = aVar.a(componentActivity, i3);
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else if (bVar == null) {
                bundle = null;
            } else {
                throw null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                b.i.d.a.k(componentActivity, stringArrayExtra, i2);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                b.a.e.e eVar = (b.a.e.e) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    b.i.d.a.p(componentActivity, eVar.f502b, i2, eVar.f503c, eVar.f504d, eVar.f505e, 0, bundle);
                } catch (IntentSender.SendIntentException e2) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0002b(i2, e2));
                }
            } else {
                b.i.d.a.o(componentActivity, a2, i2, bundle);
            }
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Object f11a;

        /* renamed from: b  reason: collision with root package name */
        public z f12b;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new b.a.d.a();
        this.mLifecycleRegistry = new j(this);
        this.mSavedStateRegistryController = new b.t.c(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() != null) {
            getLifecycle().a(new g() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // b.o.g
                public void d(i iVar, f.a aVar) {
                    if (aVar == f.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
            getLifecycle().a(new g() {
                /* class androidx.activity.ComponentActivity.AnonymousClass4 */

                @Override // b.o.g
                public void d(i iVar, f.a aVar) {
                    if (aVar == f.a.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.f499b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new g() {
                /* class androidx.activity.ComponentActivity.AnonymousClass5 */

                @Override // b.o.g
                public void d(i iVar, f.a aVar) {
                    ComponentActivity.this.ensureViewModelStore();
                    j jVar = (j) ComponentActivity.this.getLifecycle();
                    jVar.d("removeObserver");
                    jVar.f2220a.h(this);
                }
            });
            if (Build.VERSION.SDK_INT <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }

    private void initViewTreeOwners() {
        getWindow().getDecorView().setTag(b.o.b0.a.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(b.o.c0.a.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(b.t.a.view_tree_saved_state_registry_owner, this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(b.a.d.b bVar) {
        b.a.d.a aVar = this.mContextAwareHelper;
        if (aVar.f499b != null) {
            bVar.a(aVar.f499b);
        }
        aVar.f498a.add(bVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.mViewModelStore = cVar.f12b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new z();
            }
        }
    }

    @Override // b.a.e.d
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // b.o.e
    public y.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new u(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.f11a;
        }
        return null;
    }

    @Override // b.o.i, b.i.d.e
    public f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // b.a.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // b.t.d
    public final b.t.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f2585b;
    }

    @Override // b.o.a0
    public z getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.mActivityResultRegistry.a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // b.i.d.e
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        b.a.d.a aVar = this.mContextAwareHelper;
        aVar.f499b = this;
        for (b.a.d.b bVar : aVar.f498a) {
            bVar.a(this);
        }
        super.onCreate(bundle);
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        if (activityResultRegistry != null) {
            if (bundle != null) {
                ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                if (!(stringArrayList == null || integerArrayList == null)) {
                    int size = stringArrayList.size();
                    for (int i = 0; i < size; i++) {
                        int intValue = integerArrayList.get(i).intValue();
                        String str = stringArrayList.get(i);
                        activityResultRegistry.f27b.put(Integer.valueOf(intValue), str);
                        activityResultRegistry.f28c.put(str, Integer.valueOf(intValue));
                    }
                    activityResultRegistry.f30e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    activityResultRegistry.f26a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    activityResultRegistry.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                }
            }
            s.c(this);
            int i2 = this.mContentLayoutId;
            if (i2 != 0) {
                setContentView(i2);
                return;
            }
            return;
        }
        throw null;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        z zVar = this.mViewModelStore;
        if (zVar == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            zVar = cVar.f12b;
        }
        if (zVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.f11a = onRetainCustomNonConfigurationInstance;
        cVar2.f12b = zVar;
        return cVar2;
    }

    @Override // b.i.d.e
    public void onSaveInstanceState(Bundle bundle) {
        f lifecycle = getLifecycle();
        if (lifecycle instanceof j) {
            j jVar = (j) lifecycle;
            f.b bVar = f.b.CREATED;
            jVar.d("setCurrentState");
            jVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        if (activityResultRegistry != null) {
            bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.f27b.keySet()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.f27b.values()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.f30e));
            bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.h.clone());
            bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.f26a);
            return;
        }
        throw null;
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f499b;
    }

    public final <I, O> b.a.e.c<I> registerForActivityResult(b.a.e.f.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, b.a.e.b<O> bVar) {
        StringBuilder h = c.a.a.a.a.h("activity_rq#");
        h.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry.d(h.toString(), this, aVar, bVar);
    }

    public final <I, O> b.a.e.c<I> registerForActivityResult(b.a.e.f.a<I, O> aVar, b.a.e.b<O> bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    public final void removeOnContextAvailableListener(b.a.d.b bVar) {
        this.mContextAwareHelper.f498a.remove(bVar);
    }

    public void reportFullyDrawn() {
        try {
            if (i.j.M()) {
                Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
