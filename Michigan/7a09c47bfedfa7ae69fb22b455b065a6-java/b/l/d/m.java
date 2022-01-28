package b.l.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.Fragment;
import b.a.e.d;
import b.b.k.i;
import b.i.d.a;
import b.i.d.o;
import b.o.a0;
import b.o.f;
import b.o.j;
import b.o.z;
import b.t.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class m extends ComponentActivity implements a.AbstractC0028a {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public boolean mCreated;
    public final j mFragmentLifecycleRegistry = new j(this);
    public final u mFragments;
    public boolean mResumed;
    public boolean mStopped = true;

    public class a implements b.AbstractC0050b {
        public a() {
        }

        @Override // b.t.b.AbstractC0050b
        public Bundle a() {
            Bundle bundle = new Bundle();
            m.this.markFragmentsCreated();
            m.this.mFragmentLifecycleRegistry.e(f.a.ON_STOP);
            Parcelable g0 = m.this.mFragments.f2136a.f2145e.g0();
            if (g0 != null) {
                bundle.putParcelable(m.FRAGMENTS_TAG, g0);
            }
            return bundle;
        }
    }

    public class b implements b.a.d.b {
        public b() {
        }

        @Override // b.a.d.b
        public void a(Context context) {
            w<?> wVar = m.this.mFragments.f2136a;
            wVar.f2145e.b(wVar, wVar, null);
            Bundle a2 = m.this.getSavedStateRegistry().a(m.FRAGMENTS_TAG);
            if (a2 != null) {
                Parcelable parcelable = a2.getParcelable(m.FRAGMENTS_TAG);
                w<?> wVar2 = m.this.mFragments.f2136a;
                if (wVar2 instanceof a0) {
                    wVar2.f2145e.f0(parcelable);
                    return;
                }
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
    }

    public class c extends w<m> implements a0, b.a.c, d, d0 {
        public c() {
            super(m.this);
        }

        @Override // b.l.d.d0
        public void a(z zVar, Fragment fragment) {
            m.this.onAttachFragment(fragment);
        }

        @Override // b.l.d.s
        public View b(int i) {
            return m.this.findViewById(i);
        }

        @Override // b.l.d.s
        public boolean c() {
            Window window = m.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // b.a.e.d
        public ActivityResultRegistry getActivityResultRegistry() {
            return m.this.getActivityResultRegistry();
        }

        @Override // b.o.i
        public f getLifecycle() {
            return m.this.mFragmentLifecycleRegistry;
        }

        @Override // b.a.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return m.this.getOnBackPressedDispatcher();
        }

        @Override // b.o.a0
        public z getViewModelStore() {
            return m.this.getViewModelStore();
        }
    }

    public m() {
        c cVar = new c();
        i.j.h(cVar, "callbacks == null");
        this.mFragments = new u(cVar);
        init();
    }

    private void init() {
        getSavedStateRegistry().b(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    public static boolean markState(z zVar, f.b bVar) {
        f.b bVar2 = f.b.STARTED;
        boolean z = false;
        for (Fragment fragment : zVar.f2180c.i()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), bVar);
                }
                u0 u0Var = fragment.mViewLifecycleOwner;
                if (u0Var != null) {
                    if (((j) u0Var.getLifecycle()).f2221b.compareTo(bVar2) >= 0) {
                        j jVar = fragment.mViewLifecycleOwner.f2137b;
                        jVar.d("setCurrentState");
                        jVar.g(bVar);
                        z = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f2221b.compareTo(bVar2) >= 0) {
                    j jVar2 = fragment.mLifecycleRegistry;
                    jVar2.d("setCurrentState");
                    jVar2.g(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f2136a.f2145e.f2183f.onCreateView(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            b.p.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f2136a.f2145e.z(str, fileDescriptor, printWriter, strArr);
    }

    public z getSupportFragmentManager() {
        return this.mFragments.f2136a.f2145e;
    }

    @Deprecated
    public b.p.a.a getSupportLoaderManager() {
        return b.p.a.a.b(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), f.b.CREATED));
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a();
        this.mFragments.f2136a.f2145e.l(configuration);
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.e
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(f.a.ON_CREATE);
        this.mFragments.f2136a.f2145e.n();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        u uVar = this.mFragments;
        return onCreatePanelMenu | uVar.f2136a.f2145e.o(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f2136a.f2145e.p();
        this.mFragmentLifecycleRegistry.e(f.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f2136a.f2145e.q();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.f2136a.f2145e.s(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.f2136a.f2145e.m(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f2136a.f2145e.r(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.a();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.f2136a.f2145e.t(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f2136a.f2145e.x(5);
        this.mFragmentLifecycleRegistry.e(f.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f2136a.f2145e.v(z);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.f2136a.f2145e.w(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // androidx.activity.ComponentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.a();
        this.mFragments.f2136a.f2145e.D(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(f.a.ON_RESUME);
        z zVar = this.mFragments.f2136a.f2145e;
        zVar.D = false;
        zVar.E = false;
        zVar.L.f1999g = false;
        zVar.x(7);
    }

    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            z zVar = this.mFragments.f2136a.f2145e;
            zVar.D = false;
            zVar.E = false;
            zVar.L.f1999g = false;
            zVar.x(4);
        }
        this.mFragments.a();
        this.mFragments.f2136a.f2145e.D(true);
        this.mFragmentLifecycleRegistry.e(f.a.ON_START);
        z zVar2 = this.mFragments.f2136a.f2145e;
        zVar2.D = false;
        zVar2.E = false;
        zVar2.L.f1999g = false;
        zVar2.x(5);
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        z zVar = this.mFragments.f2136a.f2145e;
        zVar.E = true;
        zVar.L.f1999g = true;
        zVar.x(4);
        this.mFragmentLifecycleRegistry.e(f.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(o oVar) {
        b.i.d.a.l(this);
    }

    public void setExitSharedElementCallback(o oVar) {
        b.i.d.a.m(this);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            b.i.d.a.o(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            b.i.d.a.p(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        b.i.d.a.h(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        b.i.d.a.i(this);
    }

    public void supportStartPostponedEnterTransition() {
        b.i.d.a.q(this);
    }

    @Override // b.i.d.a.AbstractC0028a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public m(int i) {
        super(i);
        c cVar = new c();
        i.j.h(cVar, "callbacks == null");
        this.mFragments = new u(cVar);
        init();
    }
}
