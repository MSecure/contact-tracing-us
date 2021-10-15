package b.l.d;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.a0.a.a;
import b.l.d.i0;
import b.o.f;

@Deprecated
public abstract class e0 extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public static final boolean DEBUG = false;
    public static final String TAG = "FragmentPagerAdapter";
    public final int mBehavior;
    public i0 mCurTransaction;
    public Fragment mCurrentPrimaryItem;
    public boolean mExecutingFinishUpdate;
    public final z mFragmentManager;

    @Deprecated
    public e0(z zVar) {
        this(zVar, 0);
    }

    public e0(z zVar, int i) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = zVar;
        this.mBehavior = i;
    }

    public static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // b.a0.a.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            z zVar = this.mFragmentManager;
            if (zVar != null) {
                this.mCurTransaction = new a(zVar);
            } else {
                throw null;
            }
        }
        a aVar = (a) this.mCurTransaction;
        if (aVar != null) {
            z zVar2 = fragment.mFragmentManager;
            if (zVar2 == null || zVar2 == aVar.r) {
                aVar.b(new i0.a(6, fragment));
                if (fragment.equals(this.mCurrentPrimaryItem)) {
                    this.mCurrentPrimaryItem = null;
                    return;
                }
                return;
            }
            StringBuilder h = c.a.a.a.a.h("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
            h.append(fragment.toString());
            h.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(h.toString());
        }
        throw null;
    }

    /* JADX INFO: finally extract failed */
    @Override // b.a0.a.a
    public void finishUpdate(ViewGroup viewGroup) {
        i0 i0Var = this.mCurTransaction;
        if (i0Var != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    i0Var.f();
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

    public long getItemId(int i) {
        return (long) i;
    }

    @Override // b.a0.a.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            z zVar = this.mFragmentManager;
            if (zVar != null) {
                this.mCurTransaction = new a(zVar);
            } else {
                throw null;
            }
        }
        long itemId = getItemId(i);
        Fragment J = this.mFragmentManager.J(makeFragmentName(viewGroup.getId(), itemId));
        if (J != null) {
            this.mCurTransaction.b(new i0.a(7, J));
        } else {
            J = getItem(i);
            this.mCurTransaction.g(viewGroup.getId(), J, makeFragmentName(viewGroup.getId(), itemId), 1);
        }
        if (J != this.mCurrentPrimaryItem) {
            J.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.i(J, f.b.STARTED);
            } else {
                J.setUserVisibleHint(false);
            }
        }
        return J;
    }

    @Override // b.a0.a.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // b.a0.a.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // b.a0.a.a
    public Parcelable saveState() {
        return null;
    }

    @Override // b.a0.a.a
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        z zVar = this.mFragmentManager;
                        if (zVar != null) {
                            this.mCurTransaction = new a(zVar);
                        } else {
                            throw null;
                        }
                    }
                    this.mCurTransaction.i(this.mCurrentPrimaryItem, f.b.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    z zVar2 = this.mFragmentManager;
                    if (zVar2 != null) {
                        this.mCurTransaction = new a(zVar2);
                    } else {
                        throw null;
                    }
                }
                this.mCurTransaction.i(fragment, f.b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // b.a0.a.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
