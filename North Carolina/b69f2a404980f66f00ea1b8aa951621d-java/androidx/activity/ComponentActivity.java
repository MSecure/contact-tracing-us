package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import b.i.d.d;
import b.n.a0;
import b.n.e;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.j;
import b.n.s;
import b.n.u;
import b.n.y;
import b.n.z;
import b.s.c;

public class ComponentActivity extends d implements i, a0, e, c, b.a.c {
    public int mContentLayoutId;
    public y.b mDefaultFactory;
    public final j mLifecycleRegistry;
    public final OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final b.s.b mSavedStateRegistryController;
    public z mViewModelStore;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f4a;

        /* renamed from: b  reason: collision with root package name */
        public z f5b;
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new j(this);
        this.mSavedStateRegistryController = new b.s.b(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        if (getLifecycle() != null) {
            getLifecycle().a(new g() {
                /* class androidx.activity.ComponentActivity.AnonymousClass2 */

                @Override // b.n.g
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
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // b.n.g
                public void d(i iVar, f.a aVar) {
                    if (aVar == f.a.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().a();
                    }
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

    @Override // b.n.e
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
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f4a;
        }
        return null;
    }

    @Override // b.n.i, b.i.d.d
    public f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // b.a.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // b.s.c
    public final b.s.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1713b;
    }

    @Override // b.n.a0
    public z getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.mViewModelStore = bVar.f5b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new z();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // b.i.d.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.a(bundle);
        s.c(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        z zVar = this.mViewModelStore;
        if (zVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            zVar = bVar.f5b;
        }
        if (zVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f4a = onRetainCustomNonConfigurationInstance;
        bVar2.f5b = zVar;
        return bVar2;
    }

    @Override // b.i.d.d
    public void onSaveInstanceState(Bundle bundle) {
        f lifecycle = getLifecycle();
        if (lifecycle instanceof j) {
            ((j) lifecycle).f(f.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }
}
