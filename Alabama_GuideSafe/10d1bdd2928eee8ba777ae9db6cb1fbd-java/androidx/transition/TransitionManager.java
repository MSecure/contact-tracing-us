package androidx.transition;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    public static Transition sDefaultTransition = new AutoTransition();
    public static ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public ViewGroup mSceneRoot;
        public Transition mTransition;

        public MultiListener(Transition transition, ViewGroup viewGroup) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x02b5  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
        public boolean onPreDraw() {
            ArrayList arrayList;
            Transition transition;
            Transition.AnimationInfo orDefault;
            TransitionValuesMaps transitionValuesMaps;
            TransitionValues transitionValues;
            View view;
            View view2;
            TransitionValuesMaps transitionValuesMaps2;
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
            int i = 1;
            if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = TransitionManager.getRunningTransitions();
            ArrayList<Transition> arrayList2 = runningTransitions.get(this.mSceneRoot);
            boolean z = false;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                runningTransitions.put(this.mSceneRoot, arrayList2);
            } else if (arrayList2.size() > 0) {
                arrayList = new ArrayList(arrayList2);
                arrayList2.add(this.mTransition);
                this.mTransition.addListener(new TransitionListenerAdapter() {
                    /* class androidx.transition.TransitionManager.MultiListener.AnonymousClass1 */

                    @Override // androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition);
                        transition.removeListener(this);
                    }
                });
                int i2 = 0;
                this.mTransition.captureValues(this.mSceneRoot, false);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).resume(this.mSceneRoot);
                    }
                }
                transition = this.mTransition;
                ViewGroup viewGroup = this.mSceneRoot;
                if (transition == null) {
                    transition.mStartValuesList = new ArrayList<>();
                    transition.mEndValuesList = new ArrayList<>();
                    TransitionValuesMaps transitionValuesMaps3 = transition.mStartValues;
                    TransitionValuesMaps transitionValuesMaps4 = transition.mEndValues;
                    ArrayMap arrayMap = new ArrayMap(transitionValuesMaps3.mViewValues);
                    ArrayMap arrayMap2 = new ArrayMap(transitionValuesMaps4.mViewValues);
                    int i3 = 0;
                    while (true) {
                        int[] iArr = transition.mMatchOrder;
                        if (i3 >= iArr.length) {
                            break;
                        }
                        int i4 = iArr[i3];
                        if (i4 == i) {
                            transitionValuesMaps = transitionValuesMaps3;
                            int i5 = arrayMap.mSize;
                            while (true) {
                                i5--;
                                if (i5 < 0) {
                                    break;
                                }
                                View view3 = (View) arrayMap.keyAt(i5);
                                if (view3 != null && transition.isValidTarget(view3) && (transitionValues = (TransitionValues) arrayMap2.remove(view3)) != null && transition.isValidTarget(transitionValues.view)) {
                                    transition.mStartValuesList.add((TransitionValues) arrayMap.removeAt(i5));
                                    transition.mEndValuesList.add(transitionValues);
                                }
                            }
                        } else if (i4 == 2) {
                            transitionValuesMaps = transitionValuesMaps3;
                            ArrayMap<String, View> arrayMap3 = transitionValuesMaps.mNameValues;
                            ArrayMap<String, View> arrayMap4 = transitionValuesMaps4.mNameValues;
                            int i6 = arrayMap3.mSize;
                            for (int i7 = 0; i7 < i6; i7++) {
                                View valueAt = arrayMap3.valueAt(i7);
                                if (valueAt != null && transition.isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i7))) != null && transition.isValidTarget(view)) {
                                    TransitionValues transitionValues2 = (TransitionValues) arrayMap.getOrDefault(valueAt, null);
                                    TransitionValues transitionValues3 = (TransitionValues) arrayMap2.getOrDefault(view, null);
                                    if (!(transitionValues2 == null || transitionValues3 == null)) {
                                        transition.mStartValuesList.add(transitionValues2);
                                        transition.mEndValuesList.add(transitionValues3);
                                        arrayMap.remove(valueAt);
                                        arrayMap2.remove(view);
                                    }
                                }
                            }
                        } else if (i4 != 3) {
                            if (i4 == 4) {
                                LongSparseArray<View> longSparseArray = transitionValuesMaps3.mItemIdValues;
                                LongSparseArray<View> longSparseArray2 = transitionValuesMaps4.mItemIdValues;
                                int size = longSparseArray.size();
                                int i8 = i2;
                                while (i8 < size) {
                                    View valueAt2 = longSparseArray.valueAt(i8);
                                    if (valueAt2 == null || !transition.isValidTarget(valueAt2)) {
                                        transitionValuesMaps2 = transitionValuesMaps3;
                                    } else {
                                        if (longSparseArray.mGarbage) {
                                            longSparseArray.gc();
                                        }
                                        transitionValuesMaps2 = transitionValuesMaps3;
                                        View view4 = longSparseArray2.get(longSparseArray.mKeys[i8]);
                                        if (view4 != null && transition.isValidTarget(view4)) {
                                            TransitionValues transitionValues4 = (TransitionValues) arrayMap.getOrDefault(valueAt2, z);
                                            TransitionValues transitionValues5 = (TransitionValues) arrayMap2.getOrDefault(view4, z);
                                            if (!(transitionValues4 == null || transitionValues5 == null)) {
                                                transition.mStartValuesList.add(transitionValues4);
                                                transition.mEndValuesList.add(transitionValues5);
                                                arrayMap.remove(valueAt2);
                                                arrayMap2.remove(view4);
                                            }
                                        }
                                    }
                                    i8++;
                                    transitionValuesMaps3 = transitionValuesMaps2;
                                    z = false;
                                }
                            }
                            transitionValuesMaps = transitionValuesMaps3;
                        } else {
                            transitionValuesMaps = transitionValuesMaps3;
                            SparseArray<View> sparseArray = transitionValuesMaps.mIdValues;
                            SparseArray<View> sparseArray2 = transitionValuesMaps4.mIdValues;
                            int size2 = sparseArray.size();
                            for (int i9 = 0; i9 < size2; i9++) {
                                View valueAt3 = sparseArray.valueAt(i9);
                                if (valueAt3 != null && transition.isValidTarget(valueAt3) && (view2 = sparseArray2.get(sparseArray.keyAt(i9))) != null && transition.isValidTarget(view2)) {
                                    TransitionValues transitionValues6 = (TransitionValues) arrayMap.getOrDefault(valueAt3, null);
                                    TransitionValues transitionValues7 = (TransitionValues) arrayMap2.getOrDefault(view2, null);
                                    if (!(transitionValues6 == null || transitionValues7 == null)) {
                                        transition.mStartValuesList.add(transitionValues6);
                                        transition.mEndValuesList.add(transitionValues7);
                                        arrayMap.remove(valueAt3);
                                        arrayMap2.remove(view2);
                                    }
                                }
                            }
                        }
                        i3++;
                        transitionValuesMaps3 = transitionValuesMaps;
                        i = 1;
                        z = false;
                        i2 = 0;
                    }
                    for (int i10 = 0; i10 < arrayMap.mSize; i10++) {
                        TransitionValues transitionValues8 = (TransitionValues) arrayMap.valueAt(i10);
                        if (transition.isValidTarget(transitionValues8.view)) {
                            transition.mStartValuesList.add(transitionValues8);
                            transition.mEndValuesList.add(null);
                        }
                    }
                    for (int i11 = 0; i11 < arrayMap2.mSize; i11++) {
                        TransitionValues transitionValues9 = (TransitionValues) arrayMap2.valueAt(i11);
                        if (transition.isValidTarget(transitionValues9.view)) {
                            transition.mEndValuesList.add(transitionValues9);
                            transition.mStartValuesList.add(null);
                        }
                    }
                    ArrayMap<Animator, Transition.AnimationInfo> runningAnimators = Transition.getRunningAnimators();
                    int i12 = runningAnimators.mSize;
                    WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
                    for (int i13 = i12 - 1; i13 >= 0; i13--) {
                        Animator keyAt = runningAnimators.keyAt(i13);
                        if (!(keyAt == null || (orDefault = runningAnimators.getOrDefault(keyAt, null)) == null || orDefault.mView == null || !windowId.equals(orDefault.mWindowId))) {
                            TransitionValues transitionValues10 = orDefault.mValues;
                            View view5 = orDefault.mView;
                            TransitionValues transitionValues11 = transition.getTransitionValues(view5, true);
                            TransitionValues matchedTransitionValues = transition.getMatchedTransitionValues(view5, true);
                            if (transitionValues11 == null && matchedTransitionValues == null) {
                                matchedTransitionValues = transition.mEndValues.mViewValues.get(view5);
                            }
                            if (!(transitionValues11 == null && matchedTransitionValues == null) && orDefault.mTransition.isTransitionRequired(transitionValues10, matchedTransitionValues)) {
                                if (keyAt.isRunning() || keyAt.isStarted()) {
                                    keyAt.cancel();
                                } else {
                                    runningAnimators.remove(keyAt);
                                }
                            }
                        }
                    }
                    transition.createAnimators(viewGroup, transition.mStartValues, transition.mEndValues, transition.mStartValuesList, transition.mEndValuesList);
                    transition.runAnimators();
                    return true;
                }
                throw null;
            }
            arrayList = null;
            arrayList2.add(this.mTransition);
            this.mTransition.addListener(new TransitionListenerAdapter() {
                /* class androidx.transition.TransitionManager.MultiListener.AnonymousClass1 */

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition);
                    transition.removeListener(this);
                }
            });
            int i22 = 0;
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList != null) {
            }
            transition = this.mTransition;
            ViewGroup viewGroup2 = this.mSceneRoot;
            if (transition == null) {
            }
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<Transition> arrayList = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = sRunningTransitions.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        sRunningTransitions.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }
}
