package b.l.d;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import b.n.f;
import c.a.a.a.a;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public final p f1360a;

    /* renamed from: b  reason: collision with root package name */
    public final Fragment f1361b;

    /* renamed from: c  reason: collision with root package name */
    public int f1362c = -1;

    public w(p pVar, Fragment fragment) {
        this.f1360a = pVar;
        this.f1361b = fragment;
    }

    public w(p pVar, Fragment fragment, v vVar) {
        this.f1360a = pVar;
        this.f1361b = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.f1361b;
        fragment3.mTarget = null;
        Bundle bundle = vVar.n;
        fragment3.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    public w(p pVar, ClassLoader classLoader, m mVar, v vVar) {
        this.f1360a = pVar;
        this.f1361b = mVar.a(classLoader, vVar.f1356b);
        Bundle bundle = vVar.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.f1361b.setArguments(vVar.k);
        Fragment fragment = this.f1361b;
        fragment.mWho = vVar.f1357c;
        fragment.mFromLayout = vVar.f1358d;
        fragment.mRestored = true;
        fragment.mFragmentId = vVar.f1359e;
        fragment.mContainerId = vVar.f;
        fragment.mTag = vVar.g;
        fragment.mRetainInstance = vVar.h;
        fragment.mRemoving = vVar.i;
        fragment.mDetached = vVar.j;
        fragment.mHidden = vVar.l;
        fragment.mMaxState = f.b.values()[vVar.m];
        Bundle bundle2 = vVar.n;
        if (bundle2 != null) {
            this.f1361b.mSavedFragmentState = bundle2;
        } else {
            this.f1361b.mSavedFragmentState = new Bundle();
        }
        if (q.P(2)) {
            StringBuilder g = a.g("Instantiated fragment ");
            g.append(this.f1361b);
            g.toString();
        }
    }

    public void a(ClassLoader classLoader) {
        Bundle bundle = this.f1361b.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f1361b;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f1361b;
            fragment2.mTargetWho = fragment2.mSavedFragmentState.getString("android:target_state");
            Fragment fragment3 = this.f1361b;
            if (fragment3.mTargetWho != null) {
                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment4 = this.f1361b;
            Boolean bool = fragment4.mSavedUserVisibleHint;
            if (bool != null) {
                fragment4.mUserVisibleHint = bool.booleanValue();
                this.f1361b.mSavedUserVisibleHint = null;
            } else {
                fragment4.mUserVisibleHint = fragment4.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment5 = this.f1361b;
            if (!fragment5.mUserVisibleHint) {
                fragment5.mDeferStart = true;
            }
        }
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        this.f1361b.performSaveInstanceState(bundle);
        this.f1360a.j(this.f1361b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1361b.mView != null) {
            c();
        }
        if (this.f1361b.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1361b.mSavedViewState);
        }
        if (!this.f1361b.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1361b.mUserVisibleHint);
        }
        return bundle;
    }

    public void c() {
        if (this.f1361b.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f1361b.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f1361b.mSavedViewState = sparseArray;
            }
        }
    }
}
