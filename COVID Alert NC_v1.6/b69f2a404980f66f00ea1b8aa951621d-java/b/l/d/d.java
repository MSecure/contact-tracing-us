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
import androidx.fragment.app.Fragment;
import b.a.c;
import b.b.k.i;
import b.e.i;
import b.i.d.a;
import b.i.d.n;
import b.n.a0;
import b.n.f;
import b.n.j;
import b.n.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class d extends ComponentActivity implements a.b {
    public static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    public static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    public static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    public static final String TAG = "FragmentActivity";
    public boolean mCreated;
    public final j mFragmentLifecycleRegistry = new j(this);
    public final l mFragments;
    public int mNextCandidateRequestIndex;
    public i<String> mPendingFragmentActivityResults;
    public boolean mRequestedPermissionsFromFragment;
    public boolean mResumed;
    public boolean mStartedActivityFromFragment;
    public boolean mStartedIntentSenderFromFragment;
    public boolean mStopped = true;

    public class a extends n<d> implements a0, c {
        public a() {
            super(d.this);
        }

        @Override // b.l.d.j
        public View a(int i) {
            return d.this.findViewById(i);
        }

        @Override // b.l.d.j
        public boolean b() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // b.n.i
        public f getLifecycle() {
            return d.this.mFragmentLifecycleRegistry;
        }

        @Override // b.a.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return d.this.getOnBackPressedDispatcher();
        }

        @Override // b.n.a0
        public z getViewModelStore() {
            return d.this.getViewModelStore();
        }
    }

    public d() {
        a aVar = new a();
        i.j.r(aVar, "callbacks == null");
        this.mFragments = new l(aVar);
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.i() < 65534) {
            while (true) {
                b.e.i<String> iVar = this.mPendingFragmentActivityResults;
                int i = this.mNextCandidateRequestIndex;
                if (iVar.f830b) {
                    iVar.c();
                }
                if (b.e.d.a(iVar.f831c, iVar.f833e, i) >= 0) {
                    this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
                } else {
                    int i2 = this.mNextCandidateRequestIndex;
                    this.mPendingFragmentActivityResults.g(i2, fragment.mWho);
                    this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
                    return i2;
                }
            }
        } else {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
    }

    public static void checkForValidRequestCode(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), f.b.CREATED));
    }

    public static boolean markState(q qVar, f.b bVar) {
        boolean z = false;
        for (Fragment fragment : qVar.f1330c.g()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), bVar);
                }
                if (((j) fragment.getLifecycle()).f1392b.compareTo(f.b.STARTED) >= 0) {
                    fragment.mLifecycleRegistry.f(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f1317a.f1323e.f.onCreateView(view, str, context, attributeSet);
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
            b.o.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f1317a.f1323e.z(str, fileDescriptor, printWriter, strArr);
    }

    public q getSupportFragmentManager() {
        return this.mFragments.f1317a.f1323e;
    }

    @Deprecated
    public b.o.a.a getSupportLoaderManager() {
        return b.o.a.a.b(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Fragment K;
        this.mFragments.a();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String d2 = this.mPendingFragmentActivityResults.d(i4);
            this.mPendingFragmentActivityResults.h(i4);
            if (d2 != null && (K = this.mFragments.f1317a.f1323e.K(d2)) != null) {
                K.onActivityResult(i & 65535, i2, intent);
                return;
            }
            return;
        }
        b.i.d.a.h();
        super.onActivityResult(i, i2, intent);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a();
        this.mFragments.f1317a.f1323e.l(configuration);
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.d
    public void onCreate(Bundle bundle) {
        n<?> nVar = this.mFragments.f1317a;
        nVar.f1323e.d(nVar, nVar, null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            n<?> nVar2 = this.mFragments.f1317a;
            if (nVar2 instanceof a0) {
                nVar2.f1323e.h0(parcelable);
                if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                    this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                    int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                    String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                    if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                        this.mPendingFragmentActivityResults = new b.e.i<>(intArray.length);
                        for (int i = 0; i < intArray.length; i++) {
                            this.mPendingFragmentActivityResults.g(intArray[i], stringArray[i]);
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new b.e.i<>(10);
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.d(f.a.ON_CREATE);
        this.mFragments.f1317a.f1323e.n();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        l lVar = this.mFragments;
        return onCreatePanelMenu | lVar.f1317a.f1323e.o(menu, getMenuInflater());
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
        this.mFragments.f1317a.f1323e.p();
        this.mFragmentLifecycleRegistry.d(f.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f1317a.f1323e.q();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.f1317a.f1323e.s(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.f1317a.f1323e.m(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f1317a.f1323e.r(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.a();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.f1317a.f1323e.t(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f1317a.f1323e.x(3);
        this.mFragmentLifecycleRegistry.d(f.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f1317a.f1323e.v(z);
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
            return onPrepareOptionsPanel(view, menu) | this.mFragments.f1317a.f1323e.w(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Fragment K;
        this.mFragments.a();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String d2 = this.mPendingFragmentActivityResults.d(i3);
            this.mPendingFragmentActivityResults.h(i3);
            if (d2 != null && (K = this.mFragments.f1317a.f1323e.K(d2)) != null) {
                K.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.a();
        this.mFragments.f1317a.f1323e.D(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.d(f.a.ON_RESUME);
        q qVar = this.mFragments.f1317a.f1323e;
        qVar.u = false;
        qVar.v = false;
        qVar.x(4);
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.d(f.a.ON_STOP);
        Parcelable i0 = this.mFragments.f1317a.f1323e.i0();
        if (i0 != null) {
            bundle.putParcelable(FRAGMENTS_TAG, i0);
        }
        if (this.mPendingFragmentActivityResults.i() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.i()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.i()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.i(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.f(i);
                strArr[i] = this.mPendingFragmentActivityResults.j(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            q qVar = this.mFragments.f1317a.f1323e;
            qVar.u = false;
            qVar.v = false;
            qVar.x(2);
        }
        this.mFragments.a();
        this.mFragments.f1317a.f1323e.D(true);
        this.mFragmentLifecycleRegistry.d(f.a.ON_START);
        q qVar2 = this.mFragments.f1317a.f1323e;
        qVar2.u = false;
        qVar2.v = false;
        qVar2.x(3);
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        q qVar = this.mFragments.f1317a.f1323e;
        qVar.v = true;
        qVar.x(2);
        this.mFragmentLifecycleRegistry.d(f.a.ON_STOP);
    }

    /* JADX INFO: finally extract failed */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            b.i.d.a.k(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            b.i.d.a.k(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    public void setEnterSharedElementCallback(n nVar) {
        b.i.d.a.l(this);
    }

    public void setExitSharedElementCallback(n nVar) {
        b.i.d.a.m(this);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                b.i.d.a.o(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            b.i.d.a.o(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        if (i == -1) {
            try {
                b.i.d.a.p(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            b.i.d.a.p(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        b.i.d.a.g(this);
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

    @Override // b.i.d.a.b
    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }

    public d(int i) {
        super(i);
        a aVar = new a();
        i.j.r(aVar, "callbacks == null");
        this.mFragments = new l(aVar);
    }
}
