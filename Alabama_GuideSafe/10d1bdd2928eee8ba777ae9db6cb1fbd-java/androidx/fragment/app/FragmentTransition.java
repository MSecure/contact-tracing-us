package androidx.fragment.app;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FragmentTransition {
    public static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    public interface Callback {
    }

    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;
    }

    static {
        FragmentTransitionImpl fragmentTransitionImpl;
        try {
            fragmentTransitionImpl = (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            fragmentTransitionImpl = null;
        }
        SUPPORT_IMPL = fragmentTransitionImpl;
    }

    public static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int i = arrayMap.mSize - 1; i >= 0; i--) {
            View valueAt = arrayMap.valueAt(i);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0077, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0089, code lost:
        if (r0.mHidden == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008b, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static void addToFirstInLastOut(BackStackRecord backStackRecord, FragmentTransaction.Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        FragmentContainerTransition fragmentContainerTransition;
        FragmentManager fragmentManager;
        boolean z6;
        Fragment fragment = op.mFragment;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            int i2 = z ? INVERSE_OPS[op.mCmd] : op.mCmd;
            boolean z7 = false;
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    z3 = false;
                                    z5 = false;
                                    z4 = false;
                                    fragmentContainerTransition = sparseArray.get(i);
                                    if (z7) {
                                        if (fragmentContainerTransition == null) {
                                            FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
                                            sparseArray.put(i, fragmentContainerTransition2);
                                            fragmentContainerTransition = fragmentContainerTransition2;
                                        }
                                        fragmentContainerTransition.lastIn = fragment;
                                        fragmentContainerTransition.lastInIsPop = z;
                                        fragmentContainerTransition.lastInTransaction = backStackRecord;
                                    }
                                    if (!z2 && z3) {
                                        if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment) {
                                            fragmentContainerTransition.firstOut = null;
                                        }
                                        fragmentManager = backStackRecord.mManager;
                                        if (fragment.mState < 1 && fragmentManager.mCurState >= 1 && !backStackRecord.mReorderingAllowed) {
                                            fragmentManager.makeActive(fragment);
                                            fragmentManager.moveToState(fragment, 1);
                                        }
                                    }
                                    if (z4 && (fragmentContainerTransition == null || fragmentContainerTransition.firstOut == null)) {
                                        if (fragmentContainerTransition == null) {
                                            FragmentContainerTransition fragmentContainerTransition3 = new FragmentContainerTransition();
                                            sparseArray.put(i, fragmentContainerTransition3);
                                            fragmentContainerTransition = fragmentContainerTransition3;
                                        }
                                        fragmentContainerTransition.firstOut = fragment;
                                        fragmentContainerTransition.firstOutIsPop = z;
                                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                                    }
                                    if (z2 && z5 && fragmentContainerTransition != null && fragmentContainerTransition.lastIn == fragment) {
                                        fragmentContainerTransition.lastIn = null;
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else if (z2) {
                            if (fragment.mHiddenChanged) {
                                if (!fragment.mHidden) {
                                }
                            }
                            z6 = false;
                            z5 = false;
                            z4 = false;
                            z7 = z6;
                            z3 = true;
                            fragmentContainerTransition = sparseArray.get(i);
                            if (z7) {
                            }
                            fragmentContainerTransition.firstOut = null;
                            fragmentManager = backStackRecord.mManager;
                            fragmentManager.makeActive(fragment);
                            fragmentManager.moveToState(fragment, 1);
                            if (fragmentContainerTransition == null) {
                            }
                            fragmentContainerTransition.firstOut = fragment;
                            fragmentContainerTransition.firstOutIsPop = z;
                            fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            if (z2) {
                                return;
                            }
                            return;
                        } else {
                            z6 = fragment.mHidden;
                            z5 = false;
                            z4 = false;
                            z7 = z6;
                            z3 = true;
                            fragmentContainerTransition = sparseArray.get(i);
                            if (z7) {
                            }
                            fragmentContainerTransition.firstOut = null;
                            fragmentManager = backStackRecord.mManager;
                            fragmentManager.makeActive(fragment);
                            fragmentManager.moveToState(fragment, 1);
                            if (fragmentContainerTransition == null) {
                            }
                            fragmentContainerTransition.firstOut = fragment;
                            fragmentContainerTransition.firstOutIsPop = z;
                            fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            if (z2) {
                            }
                        }
                    } else if (!z2) {
                        boolean z8 = false;
                        z4 = z8;
                        z3 = false;
                        z5 = true;
                        fragmentContainerTransition = sparseArray.get(i);
                        if (z7) {
                        }
                        fragmentContainerTransition.firstOut = null;
                        fragmentManager = backStackRecord.mManager;
                        fragmentManager.makeActive(fragment);
                        fragmentManager.moveToState(fragment, 1);
                        if (fragmentContainerTransition == null) {
                        }
                        fragmentContainerTransition.firstOut = fragment;
                        fragmentContainerTransition.firstOutIsPop = z;
                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                        if (z2) {
                        }
                    } else {
                        boolean z82 = false;
                        z4 = z82;
                        z3 = false;
                        z5 = true;
                        fragmentContainerTransition = sparseArray.get(i);
                        if (z7) {
                        }
                        fragmentContainerTransition.firstOut = null;
                        fragmentManager = backStackRecord.mManager;
                        fragmentManager.makeActive(fragment);
                        fragmentManager.moveToState(fragment, 1);
                        if (fragmentContainerTransition == null) {
                        }
                        fragmentContainerTransition.firstOut = fragment;
                        fragmentContainerTransition.firstOutIsPop = z;
                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                        if (z2) {
                        }
                    }
                }
                if (!z2) {
                    boolean z822 = false;
                    z4 = z822;
                    z3 = false;
                    z5 = true;
                    fragmentContainerTransition = sparseArray.get(i);
                    if (z7) {
                    }
                    fragmentContainerTransition.firstOut = null;
                    fragmentManager = backStackRecord.mManager;
                    fragmentManager.makeActive(fragment);
                    fragmentManager.moveToState(fragment, 1);
                    if (fragmentContainerTransition == null) {
                    }
                    fragmentContainerTransition.firstOut = fragment;
                    fragmentContainerTransition.firstOutIsPop = z;
                    fragmentContainerTransition.firstOutTransaction = backStackRecord;
                    if (z2) {
                    }
                } else {
                    boolean z8222 = false;
                    z4 = z8222;
                    z3 = false;
                    z5 = true;
                    fragmentContainerTransition = sparseArray.get(i);
                    if (z7) {
                    }
                    fragmentContainerTransition.firstOut = null;
                    fragmentManager = backStackRecord.mManager;
                    fragmentManager.makeActive(fragment);
                    fragmentManager.moveToState(fragment, 1);
                    if (fragmentContainerTransition == null) {
                    }
                    fragmentContainerTransition.firstOut = fragment;
                    fragmentContainerTransition.firstOutIsPop = z;
                    fragmentContainerTransition.firstOutTransaction = backStackRecord;
                    if (z2) {
                    }
                }
            }
            if (z2) {
                z6 = fragment.mIsNewlyAdded;
                z5 = false;
                z4 = false;
                z7 = z6;
                z3 = true;
                fragmentContainerTransition = sparseArray.get(i);
                if (z7) {
                }
                fragmentContainerTransition.firstOut = null;
                fragmentManager = backStackRecord.mManager;
                fragmentManager.makeActive(fragment);
                fragmentManager.moveToState(fragment, 1);
                if (fragmentContainerTransition == null) {
                }
                fragmentContainerTransition.firstOut = fragment;
                fragmentContainerTransition.firstOutIsPop = z;
                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                if (z2) {
                }
            } else {
                if (!fragment.mAdded) {
                }
                z6 = false;
                z5 = false;
                z4 = false;
                z7 = z6;
                z3 = true;
                fragmentContainerTransition = sparseArray.get(i);
                if (z7) {
                }
                fragmentContainerTransition.firstOut = null;
                fragmentManager = backStackRecord.mManager;
                fragmentManager.makeActive(fragment);
                fragmentManager.moveToState(fragment, 1);
                if (fragmentContainerTransition == null) {
                }
                fragmentContainerTransition.firstOut = fragment;
                fragmentContainerTransition.firstOutIsPop = z;
                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                if (z2) {
                }
            }
        }
    }

    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        if (z) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.mView;
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            MapCollections.retainAllHelper(arrayMap2, arrayList);
            MapCollections.retainAllHelper(arrayMap2, arrayMap.values());
        }
        int i = arrayMap.mSize;
        while (true) {
            i--;
            if (i < 0) {
                return arrayMap2;
            }
            if (!arrayMap2.containsKey(arrayMap.valueAt(i))) {
                arrayMap.removeAt(i);
            }
        }
    }

    public static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        if (arrayList != null) {
            MapCollections.retainAllHelper(arrayMap2, arrayList);
        }
        MapCollections.retainAllHelper(arrayMap, arrayMap2.keySet());
        return arrayMap2;
    }

    public static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        Object obj;
        Object obj2;
        Object obj3;
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if (animationInfo == null) {
                obj2 = null;
            } else {
                obj2 = animationInfo.mReturnTransition;
                if (obj2 == Fragment.USE_DEFAULT_TRANSITION) {
                    obj2 = fragment.getEnterTransition();
                }
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
            Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
            if (animationInfo2 == null) {
                obj3 = null;
            } else {
                obj3 = animationInfo2.mSharedElementReturnTransition;
                if (obj3 == Fragment.USE_DEFAULT_TRANSITION) {
                    obj3 = fragment.getSharedElementEnterTransition();
                }
            }
            if (obj3 != null) {
                arrayList.add(obj3);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Fragment.AnimationInfo animationInfo3 = fragment2.mAnimationInfo;
            if (animationInfo3 == null) {
                obj = null;
            } else {
                obj = animationInfo3.mReenterTransition;
                if (obj == Fragment.USE_DEFAULT_TRANSITION) {
                    obj = fragment2.getExitTransition();
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (canHandleAll(PLATFORM_IMPL, arrayList)) {
            return PLATFORM_IMPL;
        }
        FragmentTransitionImpl fragmentTransitionImpl = SUPPORT_IMPL;
        if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
            return SUPPORT_IMPL;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.mView;
        if (view2 != null) {
            fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    public static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj = null;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if (animationInfo != null && (obj = animationInfo.mReenterTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj = fragment.getExitTransition();
            }
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    public static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj = null;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if (animationInfo != null && (obj = animationInfo.mReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj = fragment.getEnterTransition();
            }
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    public static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.mSharedElementSourceNames) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = backStackRecord.mSharedElementSourceNames.get(0);
        } else {
            str = backStackRecord.mSharedElementTargetNames.get(0);
        }
        return arrayMap.get(str);
    }

    public static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (z) {
            Fragment.AnimationInfo animationInfo = fragment2.mAnimationInfo;
            if (animationInfo == null) {
                obj = null;
            } else {
                obj = animationInfo.mSharedElementReturnTransition;
                if (obj == Fragment.USE_DEFAULT_TRANSITION) {
                    obj = fragment2.getSharedElementEnterTransition();
                }
            }
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(obj));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    public static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        Boolean bool;
        Boolean bool2;
        if (!(obj == null || obj2 == null || fragment == null)) {
            if (z) {
                Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                if (!(animationInfo == null || (bool2 = animationInfo.mAllowReturnTransitionOverlap) == null)) {
                    z2 = bool2.booleanValue();
                    if (z2) {
                        return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
                    }
                    return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
                }
            } else {
                Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
                if (!(animationInfo2 == null || (bool = animationInfo2.mAllowEnterTransitionOverlap) == null)) {
                    z2 = bool.booleanValue();
                    if (z2) {
                    }
                }
            }
        }
        z2 = true;
        if (z2) {
        }
    }

    public static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        ArrayList<String> arrayList = backStackRecord.mSharedElementSourceNames;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    public static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x032a, code lost:
        r6 = chooseImpl((r5 = r1.firstOut), (r4 = r1.lastIn));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0113, code lost:
        r6 = r1.lastIn;
        r8 = r1.firstOut;
        r9 = chooseImpl(r8, r6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0458  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0496 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0248 A[ADDED_TO_REGION] */
    public static void startTransitions(FragmentManager fragmentManager, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, Callback callback) {
        SparseArray sparseArray;
        int i3;
        int i4;
        int i5;
        int i6;
        Fragment fragment;
        Fragment fragment2;
        final FragmentTransitionImpl chooseImpl;
        final ArrayList<View> arrayList3;
        final Object obj;
        final ArrayList<View> arrayList4;
        final Fragment fragment3;
        final Fragment fragment4;
        Object obj2;
        Object obj3;
        ArrayMap arrayMap;
        Object mergeTransitions;
        Object obj4;
        final Object obj5;
        final Fragment fragment5;
        final boolean z2;
        final ArrayList<View> arrayList5;
        final Fragment fragment6;
        final Rect rect;
        Fragment fragment7;
        final Fragment fragment8;
        final FragmentTransitionImpl chooseImpl2;
        ArrayList<View> arrayList6;
        ArrayMap arrayMap2;
        Fragment fragment9;
        boolean z3;
        Object obj6;
        Object mergeTransitions2;
        ArrayMap arrayMap3;
        Object obj7;
        final Rect rect2;
        final View view;
        ArrayList<String> arrayList7;
        ArrayList<String> arrayList8;
        FragmentManager fragmentManager2 = fragmentManager;
        ArrayList<BackStackRecord> arrayList9 = arrayList;
        ArrayList<Boolean> arrayList10 = arrayList2;
        int i7 = i2;
        boolean z4 = z;
        if (fragmentManager2.mCurState >= 1) {
            SparseArray sparseArray2 = new SparseArray();
            for (int i8 = i; i8 < i7; i8++) {
                BackStackRecord backStackRecord = arrayList9.get(i8);
                if (!arrayList10.get(i8).booleanValue()) {
                    int size = backStackRecord.mOps.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i9), sparseArray2, false, z4);
                    }
                } else if (backStackRecord.mManager.mContainer.onHasView()) {
                    for (int size2 = backStackRecord.mOps.size() - 1; size2 >= 0; size2--) {
                        addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size2), sparseArray2, true, z4);
                    }
                }
            }
            if (sparseArray2.size() != 0) {
                final View view2 = new View(fragmentManager2.mHost.mContext);
                int size3 = sparseArray2.size();
                int i10 = 0;
                while (i10 < size3) {
                    int keyAt = sparseArray2.keyAt(i10);
                    final ArrayMap arrayMap4 = new ArrayMap();
                    int i11 = i7 - 1;
                    while (i11 >= i) {
                        BackStackRecord backStackRecord2 = arrayList9.get(i11);
                        if (backStackRecord2.interactsWith(keyAt)) {
                            boolean booleanValue = arrayList10.get(i11).booleanValue();
                            ArrayList<String> arrayList11 = backStackRecord2.mSharedElementSourceNames;
                            if (arrayList11 != null) {
                                if (booleanValue) {
                                    arrayList8 = backStackRecord2.mSharedElementSourceNames;
                                    arrayList7 = backStackRecord2.mSharedElementTargetNames;
                                } else {
                                    ArrayList<String> arrayList12 = backStackRecord2.mSharedElementSourceNames;
                                    ArrayList<String> arrayList13 = backStackRecord2.mSharedElementTargetNames;
                                    arrayList7 = arrayList12;
                                    arrayList8 = arrayList13;
                                }
                                int i12 = 0;
                                for (int size4 = arrayList11.size(); i12 < size4; size4 = size4) {
                                    String str = arrayList7.get(i12);
                                    String str2 = arrayList8.get(i12);
                                    String str3 = (String) arrayMap4.remove(str2);
                                    if (str3 != null) {
                                        arrayMap4.put(str, str3);
                                    } else {
                                        arrayMap4.put(str, str2);
                                    }
                                    i12++;
                                }
                            }
                        }
                        i11--;
                        arrayList9 = arrayList;
                        arrayList10 = arrayList2;
                    }
                    final FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray2.valueAt(i10);
                    if (z4) {
                        ViewGroup viewGroup = fragmentManager2.mContainer.onHasView() ? (ViewGroup) fragmentManager2.mContainer.onFindViewById(keyAt) : null;
                        if (viewGroup == null || chooseImpl2 == null) {
                            sparseArray = sparseArray2;
                            i6 = i10;
                            i5 = size3;
                        } else {
                            boolean z5 = fragmentContainerTransition.lastInIsPop;
                            boolean z6 = fragmentContainerTransition.firstOutIsPop;
                            ArrayList<View> arrayList14 = new ArrayList<>();
                            ArrayList<View> arrayList15 = new ArrayList<>();
                            sparseArray = sparseArray2;
                            Object enterTransition = getEnterTransition(chooseImpl2, fragment7, z5);
                            Object exitTransition = getExitTransition(chooseImpl2, fragment8, z6);
                            final Fragment fragment10 = fragmentContainerTransition.lastIn;
                            i6 = i10;
                            final Fragment fragment11 = fragmentContainerTransition.firstOut;
                            i5 = size3;
                            if (fragment10 != null) {
                                fragment10.requireView().setVisibility(0);
                            }
                            if (fragment10 == null || fragment11 == null) {
                                arrayList6 = arrayList14;
                                fragment9 = fragment7;
                                z3 = z5;
                            } else {
                                final boolean z7 = fragmentContainerTransition.lastInIsPop;
                                if (arrayMap4.isEmpty()) {
                                    z3 = z5;
                                    obj7 = null;
                                } else {
                                    obj7 = getSharedElementTransition(chooseImpl2, fragment10, fragment11, z7);
                                    z3 = z5;
                                }
                                ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(chooseImpl2, arrayMap4, obj7, fragmentContainerTransition);
                                fragment9 = fragment7;
                                final ArrayMap<String, View> captureInSharedElements = captureInSharedElements(chooseImpl2, arrayMap4, obj7, fragmentContainerTransition);
                                if (arrayMap4.isEmpty()) {
                                    if (captureOutSharedElements != null) {
                                        captureOutSharedElements.clear();
                                    }
                                    if (captureInSharedElements != null) {
                                        captureInSharedElements.clear();
                                    }
                                    obj6 = null;
                                } else {
                                    addSharedElementsWithMatchingNames(arrayList15, captureOutSharedElements, arrayMap4.keySet());
                                    addSharedElementsWithMatchingNames(arrayList14, captureInSharedElements, arrayMap4.values());
                                    obj6 = obj7;
                                }
                                if (enterTransition == null && exitTransition == null && obj6 == null) {
                                    arrayList6 = arrayList14;
                                } else {
                                    arrayMap2 = arrayMap4;
                                    callSharedElementStartEnd(fragment10, fragment11, z7, captureOutSharedElements, true);
                                    if (obj6 != null) {
                                        arrayList14.add(view2);
                                        chooseImpl2.setSharedElementTargets(obj6, view2, arrayList15);
                                        arrayList6 = arrayList14;
                                        setOutEpicenter(chooseImpl2, obj6, exitTransition, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
                                        Rect rect3 = new Rect();
                                        View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, enterTransition, z7);
                                        if (inEpicenterView != null) {
                                            chooseImpl2.setEpicenter(enterTransition, rect3);
                                        }
                                        view = inEpicenterView;
                                        rect2 = rect3;
                                    } else {
                                        arrayList6 = arrayList14;
                                        view = null;
                                        rect2 = null;
                                    }
                                    OneShotPreDrawListener.add(viewGroup, new Runnable() {
                                        /* class androidx.fragment.app.FragmentTransition.AnonymousClass5 */

                                        public void run() {
                                            FragmentTransition.callSharedElementStartEnd(Fragment.this, fragment11, z7, captureInSharedElements, false);
                                            View view = view;
                                            if (view != null) {
                                                chooseImpl2.getBoundsOnScreen(view, rect2);
                                            }
                                        }
                                    });
                                    if (!(enterTransition == null && obj6 == null && exitTransition == null)) {
                                        final ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl2, exitTransition, fragment8, arrayList15, view2);
                                        ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(chooseImpl2, enterTransition, fragment9, arrayList6, view2);
                                        setViewVisibility(configureEnteringExitingViews2, 4);
                                        mergeTransitions2 = mergeTransitions(chooseImpl2, enterTransition, exitTransition, obj6, fragment9, z3);
                                        if (!(fragment8 == null || configureEnteringExitingViews == null || (configureEnteringExitingViews.size() <= 0 && arrayList15.size() <= 0))) {
                                            final CancellationSignal cancellationSignal = new CancellationSignal();
                                            final FragmentManager.AnonymousClass2 r12 = (FragmentManager.AnonymousClass2) callback;
                                            r12.onStart(fragment8, cancellationSignal);
                                            chooseImpl2.setListenerForTransitionEnd(fragment8, mergeTransitions2, cancellationSignal, new Runnable() {
                                                /* class androidx.fragment.app.FragmentTransition.AnonymousClass1 */

                                                public void run() {
                                                    ((FragmentManager.AnonymousClass2) Callback.this).onComplete(fragment8, cancellationSignal);
                                                }
                                            });
                                        }
                                        if (mergeTransitions2 != null) {
                                            if (fragment8 != null && exitTransition != null && fragment8.mAdded && fragment8.mHidden && fragment8.mHiddenChanged) {
                                                fragment8.setHideReplaced(true);
                                                chooseImpl2.scheduleHideFragmentView(exitTransition, fragment8.mView, configureEnteringExitingViews);
                                                OneShotPreDrawListener.add(fragment8.mContainer, new Runnable() {
                                                    /* class androidx.fragment.app.FragmentTransition.AnonymousClass2 */

                                                    public void run() {
                                                        FragmentTransition.setViewVisibility(configureEnteringExitingViews, 4);
                                                    }
                                                });
                                            }
                                            ArrayList arrayList16 = new ArrayList();
                                            int size5 = arrayList6.size();
                                            for (int i13 = 0; i13 < size5; i13++) {
                                                View view3 = arrayList6.get(i13);
                                                arrayList16.add(ViewCompat.getTransitionName(view3));
                                                view3.setTransitionName(null);
                                            }
                                            chooseImpl2.scheduleRemoveTargets(mergeTransitions2, enterTransition, configureEnteringExitingViews2, exitTransition, configureEnteringExitingViews, obj6, arrayList6);
                                            chooseImpl2.beginDelayedTransition(viewGroup, mergeTransitions2);
                                            int size6 = arrayList6.size();
                                            ArrayList arrayList17 = new ArrayList();
                                            int i14 = 0;
                                            while (i14 < size6) {
                                                View view4 = arrayList15.get(i14);
                                                String transitionName = ViewCompat.getTransitionName(view4);
                                                arrayList17.add(transitionName);
                                                if (transitionName == null) {
                                                    arrayMap3 = arrayMap2;
                                                } else {
                                                    view4.setTransitionName(null);
                                                    arrayMap3 = arrayMap2;
                                                    String str4 = (String) arrayMap3.getOrDefault(transitionName, null);
                                                    int i15 = 0;
                                                    while (true) {
                                                        if (i15 >= size6) {
                                                            break;
                                                        } else if (str4.equals(arrayList16.get(i15))) {
                                                            arrayList6.get(i15).setTransitionName(transitionName);
                                                            break;
                                                        } else {
                                                            i15++;
                                                        }
                                                    }
                                                }
                                                i14++;
                                                arrayMap2 = arrayMap3;
                                            }
                                            OneShotPreDrawListener.add(viewGroup, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02fe: INVOKE  
                                                  (r3v12 'viewGroup' android.view.ViewGroup)
                                                  (wrap: androidx.fragment.app.FragmentTransitionImpl$1 : 0x02fb: CONSTRUCTOR  (r5v14 androidx.fragment.app.FragmentTransitionImpl$1) = 
                                                  (r9v10 'chooseImpl2' androidx.fragment.app.FragmentTransitionImpl)
                                                  (r0v16 'size6' int)
                                                  (r37v0 'arrayList6' java.util.ArrayList<android.view.View>)
                                                  (r8v5 'arrayList16' java.util.ArrayList)
                                                  (r4v13 'arrayList15' java.util.ArrayList<android.view.View>)
                                                  (r1v11 'arrayList17' java.util.ArrayList)
                                                 call: androidx.fragment.app.FragmentTransitionImpl.1.<init>(androidx.fragment.app.FragmentTransitionImpl, int, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):void type: CONSTRUCTOR)
                                                 type: STATIC call: androidx.core.view.OneShotPreDrawListener.add(android.view.View, java.lang.Runnable):androidx.core.view.OneShotPreDrawListener in method: androidx.fragment.app.FragmentTransition.startTransitions(androidx.fragment.app.FragmentManager, java.util.ArrayList<androidx.fragment.app.BackStackRecord>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean, androidx.fragment.app.FragmentTransition$Callback):void, file: classes.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02fb: CONSTRUCTOR  (r5v14 androidx.fragment.app.FragmentTransitionImpl$1) = 
                                                  (r9v10 'chooseImpl2' androidx.fragment.app.FragmentTransitionImpl)
                                                  (r0v16 'size6' int)
                                                  (r37v0 'arrayList6' java.util.ArrayList<android.view.View>)
                                                  (r8v5 'arrayList16' java.util.ArrayList)
                                                  (r4v13 'arrayList15' java.util.ArrayList<android.view.View>)
                                                  (r1v11 'arrayList17' java.util.ArrayList)
                                                 call: androidx.fragment.app.FragmentTransitionImpl.1.<init>(androidx.fragment.app.FragmentTransitionImpl, int, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):void type: CONSTRUCTOR in method: androidx.fragment.app.FragmentTransition.startTransitions(androidx.fragment.app.FragmentManager, java.util.ArrayList<androidx.fragment.app.BackStackRecord>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean, androidx.fragment.app.FragmentTransition$Callback):void, file: classes.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 63 more
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.FragmentTransitionImpl, state: GENERATED_AND_UNLOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	... 69 more
                                                */
                                            /* JADX WARNING: Code restructure failed: missing block: B:125:0x032a, code lost:
                                                r6 = chooseImpl((r5 = r1.firstOut), (r4 = r1.lastIn));
                                             */
                                            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0113, code lost:
                                                r6 = r1.lastIn;
                                                r8 = r1.firstOut;
                                                r9 = chooseImpl(r8, r6);
                                             */
                                            /* JADX WARNING: Removed duplicated region for block: B:167:0x0458  */
                                            /* JADX WARNING: Removed duplicated region for block: B:176:0x0496 A[SYNTHETIC] */
                                            /* JADX WARNING: Removed duplicated region for block: B:94:0x0248 A[ADDED_TO_REGION] */
                                            /*
                                            // Method dump skipped, instructions count: 1195
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.startTransitions(androidx.fragment.app.FragmentManager, java.util.ArrayList, java.util.ArrayList, int, int, boolean, androidx.fragment.app.FragmentTransition$Callback):void");
                                        }
                                    }
