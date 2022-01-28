package b.l.d;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.n.f;
import b.y.a.a;
import java.util.ArrayList;

public abstract class x extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public static final boolean DEBUG = false;
    public static final String TAG = "FragmentStatePagerAdapt";
    public final int mBehavior;
    public z mCurTransaction;
    public Fragment mCurrentPrimaryItem;
    public boolean mExecutingFinishUpdate;
    public final q mFragmentManager;
    public ArrayList<Fragment> mFragments;
    public ArrayList<Fragment.g> mSavedState;

    @Deprecated
    public x(q qVar) {
        this(qVar, 0);
    }

    public x(q qVar, int i) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList<>();
        this.mFragments = new ArrayList<>();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = qVar;
        this.mBehavior = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // b.y.a.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment.g gVar;
        Bundle b2;
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            q qVar = this.mFragmentManager;
            if (qVar != null) {
                this.mCurTransaction = new a(qVar);
            } else {
                throw null;
            }
        }
        while (this.mSavedState.size() <= i) {
            this.mSavedState.add(null);
        }
        ArrayList<Fragment.g> arrayList = this.mSavedState;
        if (fragment.isAdded()) {
            q qVar2 = this.mFragmentManager;
            w wVar = qVar2.f1330c.f1364b.get(fragment.mWho);
            if (wVar == null || !wVar.f1361b.equals(fragment)) {
                qVar2.q0(new IllegalStateException(c.a.a.a.a.n("Fragment ", fragment, " is not currently in the FragmentManager")));
                throw null;
            } else if (wVar.f1361b.mState > -1 && (b2 = wVar.b()) != null) {
                gVar = new Fragment.g(b2);
                arrayList.set(i, gVar);
                this.mFragments.set(i, null);
                this.mCurTransaction.h(fragment);
                if (!fragment.equals(this.mCurrentPrimaryItem)) {
                    this.mCurrentPrimaryItem = null;
                    return;
                }
                return;
            }
        }
        gVar = null;
        arrayList.set(i, gVar);
        this.mFragments.set(i, null);
        this.mCurTransaction.h(fragment);
        if (!fragment.equals(this.mCurrentPrimaryItem)) {
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // b.y.a.a
    public void finishUpdate(ViewGroup viewGroup) {
        z zVar = this.mCurTransaction;
        if (zVar != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    zVar.f();
                    this.mExecutingFinishUpdate = false;
                } catch (Throwable th) {
                    this.mExecutingFinishUpdate = false;
                    throw th;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i);

    @Override // b.y.a.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.g gVar;
        Fragment fragment;
        if (this.mFragments.size() > i && (fragment = this.mFragments.get(i)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            q qVar = this.mFragmentManager;
            if (qVar != null) {
                this.mCurTransaction = new a(qVar);
            } else {
                throw null;
            }
        }
        Fragment item = getItem(i);
        if (this.mSavedState.size() > i && (gVar = this.mSavedState.get(i)) != null) {
            item.setInitialSavedState(gVar);
        }
        while (this.mFragments.size() <= i) {
            this.mFragments.add(null);
        }
        item.setMenuVisibility(false);
        if (this.mBehavior == 0) {
            item.setUserVisibleHint(false);
        }
        this.mFragments.set(i, item);
        this.mCurTransaction.g(viewGroup.getId(), item, null, 1);
        if (this.mBehavior == 1) {
            this.mCurTransaction.j(item, f.b.STARTED);
        }
        return item;
    }

    @Override // b.y.a.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // b.y.a.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.mSavedState.add((Fragment.g) parcelable2);
                }
            }
            for (T t : bundle.keySet()) {
                if (t.startsWith("f")) {
                    int parseInt = Integer.parseInt(t.substring(1));
                    Fragment L = this.mFragmentManager.L(bundle, t);
                    if (L != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        L.setMenuVisibility(false);
                        this.mFragments.set(parseInt, L);
                    }
                }
            }
        }
    }

    @Override // b.y.a.a
    public Parcelable saveState() {
        Bundle bundle;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.g[] gVarArr = new Fragment.g[this.mSavedState.size()];
            this.mSavedState.toArray(gVarArr);
            bundle.putParcelableArray("states", gVarArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.mFragments.size(); i++) {
            Fragment fragment = this.mFragments.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.mFragmentManager.d0(bundle, c.a.a.a.a.l("f", i), fragment);
            }
        }
        return bundle;
    }

    @Override // b.y.a.a
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        q qVar = this.mFragmentManager;
                        if (qVar != null) {
                            this.mCurTransaction = new a(qVar);
                        } else {
                            throw null;
                        }
                    }
                    this.mCurTransaction.j(this.mCurrentPrimaryItem, f.b.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    q qVar2 = this.mFragmentManager;
                    if (qVar2 != null) {
                        this.mCurTransaction = new a(qVar2);
                    } else {
                        throw null;
                    }
                }
                this.mCurTransaction.j(fragment, f.b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // b.y.a.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
