package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.AsyncTimeout;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    public static final FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat>() {
        /* class androidx.customview.widget.ExploreByTouchHelper.AnonymousClass1 */

        public void obtainBounds(Object obj, Rect rect) {
            ((AccessibilityNodeInfoCompat) obj).mInfo.getBoundsInParent(rect);
        }
    };
    public static final FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
        /* class androidx.customview.widget.ExploreByTouchHelper.AnonymousClass2 */
    };
    public int mAccessibilityFocusedVirtualViewId = RecyclerView.UNDEFINED_DURATION;
    public final View mHost;
    public int mHoveredVirtualViewId = RecyclerView.UNDEFINED_DURATION;
    public int mKeyboardFocusedVirtualViewId = RecyclerView.UNDEFINED_DURATION;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final int[] mTempGlobalRect = new int[2];
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i).mInfo));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i2).mInfo));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            int i3;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (i == -1) {
                return ViewCompat.performAccessibilityAction(exploreByTouchHelper.mHost, i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return exploreByTouchHelper.requestKeyboardFocusForVirtualView(i);
            }
            if (i2 == 2) {
                return exploreByTouchHelper.clearKeyboardFocusForVirtualView(i);
            }
            if (i2 == 64) {
                if (!exploreByTouchHelper.mManager.isEnabled() || !exploreByTouchHelper.mManager.isTouchExplorationEnabled() || (i3 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId) == i) {
                    z = false;
                } else {
                    if (i3 != Integer.MIN_VALUE) {
                        exploreByTouchHelper.clearAccessibilityFocus(i3);
                    }
                    exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = i;
                    exploreByTouchHelper.mHost.invalidate();
                    exploreByTouchHelper.sendEventForVirtualView(i, 32768);
                }
                return z;
            } else if (i2 != 128) {
                return exploreByTouchHelper.onPerformActionForVirtualView(i, i2, bundle);
            } else {
                return exploreByTouchHelper.clearAccessibilityFocus(i);
            }
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = RecyclerView.UNDEFINED_DURATION;
        this.mHost.invalidate();
        sendEventForVirtualView(i, AsyncTimeout.TIMEOUT_WRITE_SIZE);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = RecyclerView.UNDEFINED_DURATION;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (i == 1) {
            Chip chip = Chip.this;
            chip.closeIconFocused = false;
            chip.refreshDrawableState();
        }
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
        accessibilityNodeInfoCompat.mInfo.setEnabled(true);
        accessibilityNodeInfoCompat.mInfo.setFocusable(true);
        accessibilityNodeInfoCompat.mInfo.setClassName("android.view.View");
        accessibilityNodeInfoCompat.mInfo.setBoundsInParent(INVALID_PARENT_BOUNDS);
        accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        accessibilityNodeInfoCompat.setParent(this.mHost);
        onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.getText() == null && accessibilityNodeInfoCompat.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompat.mInfo.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            int actions = accessibilityNodeInfoCompat.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                accessibilityNodeInfoCompat.mInfo.setPackageName(this.mHost.getContext().getPackageName());
                View view = this.mHost;
                accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                accessibilityNodeInfoCompat.mInfo.setSource(view, i);
                boolean z = false;
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    accessibilityNodeInfoCompat.mInfo.setAccessibilityFocused(true);
                    accessibilityNodeInfoCompat.mInfo.addAction(128);
                } else {
                    accessibilityNodeInfoCompat.mInfo.setAccessibilityFocused(false);
                    accessibilityNodeInfoCompat.mInfo.addAction(64);
                }
                boolean z2 = this.mKeyboardFocusedVirtualViewId == i;
                if (z2) {
                    accessibilityNodeInfoCompat.mInfo.addAction(2);
                } else if (accessibilityNodeInfoCompat.isFocusable()) {
                    accessibilityNodeInfoCompat.mInfo.addAction(1);
                }
                accessibilityNodeInfoCompat.mInfo.setFocused(z2);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                accessibilityNodeInfoCompat.mInfo.getBoundsInScreen(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                    accessibilityNodeInfoCompat.mInfo.getBoundsInParent(this.mTempScreenRect);
                    if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                        for (int i2 = accessibilityNodeInfoCompat.mParentVirtualDescendantId; i2 != -1; i2 = accessibilityNodeInfoCompat2.mParentVirtualDescendantId) {
                            View view2 = this.mHost;
                            accessibilityNodeInfoCompat2.mParentVirtualDescendantId = -1;
                            accessibilityNodeInfoCompat2.mInfo.setParent(view2, -1);
                            accessibilityNodeInfoCompat2.mInfo.setBoundsInParent(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i2, accessibilityNodeInfoCompat2);
                            accessibilityNodeInfoCompat2.mInfo.getBoundsInParent(this.mTempParentRect);
                            Rect rect = this.mTempScreenRect;
                            Rect rect2 = this.mTempParentRect;
                            rect.offset(rect2.left, rect2.top);
                        }
                        accessibilityNodeInfoCompat2.mInfo.recycle();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(this.mTempScreenRect);
                        Rect rect3 = this.mTempScreenRect;
                        if (rect3 != null && !rect3.isEmpty() && this.mHost.getWindowVisibility() == 0) {
                            ViewParent parent = this.mHost.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view3 = (View) parent;
                                    if (view3.getAlpha() <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || view3.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view3.getParent();
                                } else if (parent != null) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            accessibilityNodeInfoCompat.mInfo.setVisibleToUser(true);
                        }
                    }
                }
                return accessibilityNodeInfoCompat;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public abstract void getVisibleVirtualViews(List<Integer> list);

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x0138;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0142 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013d  */
    public final boolean moveFocus(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        int i2;
        Object obj;
        boolean z;
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(10);
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            sparseArrayCompat.put(i4, createNodeForChild(i4));
        }
        int i5 = this.mKeyboardFocusedVirtualViewId;
        if (i5 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) sparseArrayCompat.get(i5);
        }
        int i6 = -1;
        if (i == 1 || i == 2) {
            boolean z2 = ViewCompat.getLayoutDirection(this.mHost) == 1;
            FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> focusStrategy$CollectionAdapter = SPARSE_VALUES_ADAPTER;
            FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> focusStrategy$BoundsAdapter = NODE_ADAPTER;
            if (((AnonymousClass2) focusStrategy$CollectionAdapter) != null) {
                int size = sparseArrayCompat.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i7 = 0; i7 < size; i7++) {
                    if (sparseArrayCompat.mGarbage) {
                        sparseArrayCompat.gc();
                    }
                    arrayList2.add((AccessibilityNodeInfoCompat) sparseArrayCompat.mValues[i7]);
                }
                Collections.sort(arrayList2, new FocusStrategy$SequentialComparator(z2, focusStrategy$BoundsAdapter));
                if (i == 1) {
                    int size2 = arrayList2.size();
                    if (accessibilityNodeInfoCompat != null) {
                        size2 = arrayList2.indexOf(accessibilityNodeInfoCompat);
                    }
                    int i8 = size2 - 1;
                    if (i8 >= 0) {
                        obj = arrayList2.get(i8);
                        accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                    }
                } else if (i == 2) {
                    int size3 = arrayList2.size();
                    int lastIndexOf = (accessibilityNodeInfoCompat == null ? -1 : arrayList2.lastIndexOf(accessibilityNodeInfoCompat)) + 1;
                    if (lastIndexOf < size3) {
                        obj = arrayList2.get(lastIndexOf);
                        accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                    }
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                obj = null;
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
            } else {
                throw null;
            }
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i9 = this.mKeyboardFocusedVirtualViewId;
            if (i9 != Integer.MIN_VALUE) {
                obtainAccessibilityNodeInfo(i9).mInfo.getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                View view = this.mHost;
                int width = view.getWidth();
                int height = view.getHeight();
                if (i == 17) {
                    rect2.set(width, 0, width, height);
                } else if (i == 33) {
                    rect2.set(0, height, width, height);
                } else if (i == 66) {
                    rect2.set(-1, 0, -1, height);
                } else if (i == 130) {
                    rect2.set(0, -1, width, -1);
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> focusStrategy$CollectionAdapter2 = SPARSE_VALUES_ADAPTER;
            FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> focusStrategy$BoundsAdapter2 = NODE_ADAPTER;
            Rect rect3 = new Rect(rect2);
            if (i == 17) {
                rect3.offset(rect2.width() + 1, 0);
            } else if (i == 33) {
                rect3.offset(0, rect2.height() + 1);
            } else if (i == 66) {
                rect3.offset(-(rect2.width() + 1), 0);
            } else if (i == 130) {
                rect3.offset(0, -(rect2.height() + 1));
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            if (((AnonymousClass2) focusStrategy$CollectionAdapter2) != null) {
                int size4 = sparseArrayCompat.size();
                Rect rect4 = new Rect();
                accessibilityNodeInfoCompat2 = null;
                for (int i10 = 0; i10 < size4; i10++) {
                    if (sparseArrayCompat.mGarbage) {
                        sparseArrayCompat.gc();
                    }
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = (AccessibilityNodeInfoCompat) sparseArrayCompat.mValues[i10];
                    if (accessibilityNodeInfoCompat3 != accessibilityNodeInfoCompat) {
                        ((AnonymousClass1) focusStrategy$BoundsAdapter2).obtainBounds(accessibilityNodeInfoCompat3, rect4);
                        if (AppCompatDelegateImpl.ConfigurationImplApi17.isCandidate(rect2, rect4, i)) {
                            if (AppCompatDelegateImpl.ConfigurationImplApi17.isCandidate(rect2, rect3, i) && !AppCompatDelegateImpl.ConfigurationImplApi17.beamBeats(i, rect2, rect4, rect3)) {
                                if (!AppCompatDelegateImpl.ConfigurationImplApi17.beamBeats(i, rect2, rect3, rect4)) {
                                    int majorAxisDistance = AppCompatDelegateImpl.ConfigurationImplApi17.majorAxisDistance(i, rect2, rect4);
                                    int minorAxisDistance = AppCompatDelegateImpl.ConfigurationImplApi17.minorAxisDistance(i, rect2, rect4);
                                    int i11 = (minorAxisDistance * minorAxisDistance) + (majorAxisDistance * 13 * majorAxisDistance);
                                    int majorAxisDistance2 = AppCompatDelegateImpl.ConfigurationImplApi17.majorAxisDistance(i, rect2, rect3);
                                    int minorAxisDistance2 = AppCompatDelegateImpl.ConfigurationImplApi17.minorAxisDistance(i, rect2, rect3);
                                }
                            }
                            z = true;
                            if (!z) {
                                rect3.set(rect4);
                                accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat3;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                }
            } else {
                throw null;
            }
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (accessibilityNodeInfoCompat2 == null) {
            i2 = RecyclerView.UNDEFINED_DURATION;
        } else {
            if (sparseArrayCompat.mGarbage) {
                sparseArrayCompat.gc();
            }
            while (true) {
                if (i3 >= sparseArrayCompat.mSize) {
                    break;
                } else if (sparseArrayCompat.mValues[i3] == accessibilityNodeInfoCompat2) {
                    i6 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            i2 = sparseArrayCompat.keyAt(i6);
        }
        return requestKeyboardFocusForVirtualView(i2);
    }

    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i != -1) {
            return createNodeForChild(i);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(this.mHost));
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, accessibilityNodeInfoCompat);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (accessibilityNodeInfoCompat.mInfo.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                accessibilityNodeInfoCompat.mInfo.addChild(this.mHost, ((Integer) arrayList.get(i2)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        accessibilityNodeInfoCompat.mInfo.setCheckable(Chip.this.isCheckable());
        accessibilityNodeInfoCompat.mInfo.setClickable(Chip.this.isClickable());
        if (Chip.this.isCheckable() || Chip.this.isClickable()) {
            accessibilityNodeInfoCompat.mInfo.setClassName(Chip.this.isCheckable() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfoCompat.mInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfoCompat.mInfo.setText(Chip.this.getText());
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (i == 1) {
            Chip chip = Chip.this;
            chip.closeIconFocused = true;
            chip.refreshDrawableState();
        }
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        AccessibilityEvent accessibilityEvent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        if (i != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
            accessibilityEvent.getText().add(obtainAccessibilityNodeInfo.getText());
            accessibilityEvent.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
            accessibilityEvent.setScrollable(obtainAccessibilityNodeInfo.mInfo.isScrollable());
            accessibilityEvent.setPassword(obtainAccessibilityNodeInfo.mInfo.isPassword());
            accessibilityEvent.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
            accessibilityEvent.setChecked(obtainAccessibilityNodeInfo.mInfo.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(obtainAccessibilityNodeInfo.getClassName());
                accessibilityEvent.setSource(this.mHost, i);
                accessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i2);
            this.mHost.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.mHost, accessibilityEvent);
    }

    public final void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 != i) {
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }
}
