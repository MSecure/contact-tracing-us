package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.views.viewpager.ReactViewPager;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import okhttp3.internal.http1.Http1ExchangeCodec;

public class ViewPager extends ViewGroup {
    public static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    public static final int[] LAYOUT_ATTRS = {16842931};
    public static final Interpolator sInterpolator = new Interpolator() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass2 */

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    public int mActivePointerId = -1;
    public PagerAdapter mAdapter;
    public int mBottomPageBounds;
    public boolean mCalledSuper;
    public int mChildHeightMeasureSpec;
    public int mCloseEnough;
    public int mCurItem;
    public int mDecorChildCount;
    public int mDefaultGutterSize;
    public ArrayList<View> mDrawingOrderedChildren;
    public final Runnable mEndScrollRunnable = new Runnable() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass3 */

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager viewPager = ViewPager.this;
            viewPager.populate(viewPager.mCurItem);
        }
    };
    public int mExpectedAdapterCount;
    public boolean mFirstLayout = true;
    public float mFirstOffset = -3.4028235E38f;
    public int mFlingDistance;
    public int mGutterSize;
    public boolean mInLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsBeingDragged;
    public boolean mIsScrollStarted;
    public boolean mIsUnableToDrag;
    public final ArrayList<ItemInfo> mItems = new ArrayList<>();
    public float mLastMotionX;
    public float mLastMotionY;
    public float mLastOffset = Float.MAX_VALUE;
    public EdgeEffect mLeftEdge;
    public Drawable mMarginDrawable;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public PagerObserver mObserver;
    public int mOffscreenPageLimit = 1;
    public OnPageChangeListener mOnPageChangeListener;
    public int mPageMargin;
    public boolean mPopulatePending;
    public Parcelable mRestoredAdapterState = null;
    public ClassLoader mRestoredClassLoader = null;
    public int mRestoredCurItem = -1;
    public EdgeEffect mRightEdge;
    public int mScrollState = 0;
    public Scroller mScroller;
    public boolean mScrollingCacheEnabled;
    public final ItemInfo mTempItem = new ItemInfo();
    public final Rect mTempRect = new Rect();
    public int mTopPageBounds;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {
        public Object object;
        public float offset;
        public int position;
        public boolean scrolling;
        public float widthFactor;
    }

    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        public MyAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            PagerAdapter pagerAdapter2 = ViewPager.this.mAdapter;
            boolean z = true;
            if (pagerAdapter2 == null || pagerAdapter2.getCount() <= 1) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.mAdapter) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            accessibilityNodeInfoCompat.mInfo.setClassName(ViewPager.class.getName());
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            accessibilityNodeInfoCompat.mInfo.setScrollable(pagerAdapter != null && pagerAdapter.getCount() > 1);
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.mInfo.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.mInfo.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
                return true;
            }
        }
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public class PagerObserver extends DataSetObserver {
        public PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.viewpager.widget.ViewPager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("FragmentPager.SavedState{");
            outline17.append(Integer.toHexString(System.identityHashCode(this)));
            outline17.append(" position=");
            return GeneratedOutlineSupport.outline13(outline17, this.position, "}");
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z != layoutParams2.isDecor) {
                return z ? 1 : -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }

    public ViewPager(Context context) {
        super(context);
        setWillNotDraw(false);
        setDescendantFocusability(Http1ExchangeCodec.HEADER_LIMIT);
        setFocusable(true);
        Context context2 = getContext();
        this.mScroller = new Scroller(context2, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context2);
        this.mRightEdge = new EdgeEffect(context2);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            /* class androidx.viewpager.widget.ViewPager.AnonymousClass4 */
            public final Rect mTempRect = new Rect();

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.isConsumed()) {
                    return onApplyWindowInsets;
                }
                Rect rect = this.mTempRect;
                rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                    rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        ReactViewPager.Adapter adapter = (ReactViewPager.Adapter) this.mAdapter;
        View view = adapter.mViews.get(i);
        addView(view, 0, ReactViewPager.this.generateDefaultLayoutParams());
        itemInfo.object = view;
        if (this.mAdapter != null) {
            itemInfo.widthFactor = 1.0f;
            if (i2 < 0 || i2 >= this.mItems.size()) {
                this.mItems.add(itemInfo);
            } else {
                this.mItems.add(i2, itemInfo);
            }
            return itemInfo;
        }
        throw null;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.isDecor | (view.getClass().getAnnotation(DecorView.class) != null);
        layoutParams2.isDecor = z;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (!z) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ca  */
    public boolean arrowScroll(int i) {
        View findNextFocus;
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("arrowScroll tried to find focus based on non-child current focused view ");
                    outline17.append(sb.toString());
                    Log.e("ViewPager", outline17.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i == 17) {
                    int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i3 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus == null || i2 < i3) {
                        requestFocus = findNextFocus.requestFocus();
                    } else {
                        requestFocus = pageLeft();
                    }
                } else if (i == 66) {
                    int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i5 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus == null || i4 > i5) {
                        requestFocus = findNextFocus.requestFocus();
                    } else {
                        requestFocus = pageRight();
                    }
                }
                z2 = requestFocus;
            } else if (i != 17 || i == 1) {
                z2 = pageLeft();
            } else if (i == 66 || i == 2) {
                z2 = pageRight();
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null) {
        }
        if (i != 17) {
        }
        z2 = pageLeft();
        if (z2) {
        }
        return z2;
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public final void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z2 = true;
            }
        }
        if (!z2) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i2);
            PagerAdapter pagerAdapter = this.mAdapter;
            Object obj = itemInfo.object;
            ReactViewPager.Adapter adapter = (ReactViewPager.Adapter) pagerAdapter;
            int indexOf = (adapter.mIsViewPagerInIntentionallyInconsistentState || !adapter.mViews.contains(obj)) ? -2 : adapter.mViews.indexOf(obj);
            if (indexOf != -1) {
                if (indexOf == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        if (this.mAdapter != null) {
                            z2 = true;
                        } else {
                            throw null;
                        }
                    }
                    PagerAdapter pagerAdapter2 = this.mAdapter;
                    Object obj2 = itemInfo.object;
                    if (((ReactViewPager.Adapter) pagerAdapter2) != null) {
                        removeView((View) obj2);
                        int i3 = this.mCurItem;
                        if (i3 == itemInfo.position) {
                            i = Math.max(0, Math.min(i3, count - 1));
                        }
                    } else {
                        throw null;
                    }
                } else {
                    int i4 = itemInfo.position;
                    if (i4 != indexOf) {
                        if (i4 == this.mCurItem) {
                            i = indexOf;
                        }
                        itemInfo.position = indexOf;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (!z2 || this.mAdapter != null) {
            Collections.sort(this.mItems, COMPARATOR);
            if (z) {
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                    if (!layoutParams.isDecor) {
                        layoutParams.widthFactor = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    }
                }
                setCurrentItemInternal(i, false, true, 0);
                requestLayout();
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    z = keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
                } else if (keyCode == 22) {
                    z = keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
                } else if (keyCode == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        z = arrowScroll(2);
                    } else if (keyEvent.hasModifiers(1)) {
                        z = arrowScroll(1);
                    }
                }
                if (!z) {
                    return false;
                }
            }
            z = false;
            if (!z) {
            }
        }
        return true;
    }

    public final void dispatchOnPageSelected(int i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) (getPaddingTop() + (-height)), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getChildDrawingOrder(int i, int i2) {
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
    }

    public final Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            PagerAdapter pagerAdapter = this.mAdapter;
            Object obj = itemInfo.object;
            if (((ReactViewPager.Adapter) pagerAdapter) != null) {
                if (view == obj) {
                    return itemInfo;
                }
            } else {
                throw null;
            }
        }
        return null;
    }

    public final ItemInfo infoForCurrentScrollPosition() {
        int i;
        int clientWidth = getClientWidth();
        float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        int i2 = 0;
        ItemInfo itemInfo = null;
        int i3 = -1;
        boolean z = true;
        float f3 = 0.0f;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i2);
            if (!z && itemInfo2.position != (i = i3 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f + f3 + f2;
                itemInfo2.position = i;
                if (this.mAdapter != null) {
                    itemInfo2.widthFactor = 1.0f;
                    i2--;
                } else {
                    throw null;
                }
            }
            f = itemInfo2.offset;
            float f4 = itemInfo2.widthFactor + f + f2;
            if (!z && scrollX < f) {
                return itemInfo;
            }
            if (scrollX < f4 || i2 == this.mItems.size() - 1) {
                return itemInfo2;
            }
            i3 = itemInfo2.position;
            f3 = itemInfo2.widthFactor;
            i2++;
            z = false;
            itemInfo = itemInfo2;
        }
        return itemInfo;
    }

    public ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f3 = (float) width;
            float f4 = ((float) this.mPageMargin) / f3;
            int i = 0;
            ItemInfo itemInfo = this.mItems.get(0);
            float f5 = itemInfo.offset;
            int size = this.mItems.size();
            int i2 = itemInfo.position;
            int i3 = this.mItems.get(size - 1).position;
            while (i2 < i3) {
                while (i2 > itemInfo.position && i < size) {
                    i++;
                    itemInfo = this.mItems.get(i);
                }
                if (i2 == itemInfo.position) {
                    float f6 = itemInfo.offset;
                    float f7 = itemInfo.widthFactor;
                    f = (f6 + f7) * f3;
                    f5 = f6 + f7 + f4;
                } else if (this.mAdapter != null) {
                    f = (f5 + 1.0f) * f3;
                    f5 = 1.0f + f4 + f5;
                } else {
                    throw null;
                }
                if (((float) this.mPageMargin) + f > ((float) scrollX)) {
                    f2 = f4;
                    this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f2 = f4;
                }
                if (f <= ((float) (scrollX + width))) {
                    i2++;
                    f4 = f2;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate(this.mCurItem);
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(findPointerIndex);
                float f = x2 - this.mLastMotionX;
                float abs = Math.abs(f);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                int i2 = (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 1 : (f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 0 : -1));
                if (i2 != 0) {
                    float f2 = this.mLastMotionX;
                    if (!((f2 < ((float) this.mGutterSize) && i2 > 0) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) && canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                if (abs > ((float) this.mTouchSlop) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f3 = this.mInitialMotionX;
                    float f4 = (float) this.mTouchSlop;
                    this.mLastMotionX = i2 > 0 ? f3 + f4 : f3 - f4;
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.mTouchSlop)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ItemInfo infoForChild;
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        int i9 = i3 - i;
        int i10 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i13 = layoutParams.gravity;
                    int i14 = i13 & 7;
                    int i15 = i13 & 112;
                    if (i14 != 1) {
                        if (i14 == 3) {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i14 != 5) {
                            i5 = paddingLeft;
                        } else {
                            i8 = (i9 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i15 == 16) {
                            if (i15 == 48) {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i15 != 80) {
                                i6 = paddingTop;
                            } else {
                                i7 = (i10 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i16 = paddingLeft + scrollX;
                            childAt.layout(i16, paddingTop, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + paddingTop);
                            i11++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        } else {
                            i7 = Math.max((i10 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        i6 = paddingTop;
                        paddingTop = i7;
                        int i162 = paddingLeft + scrollX;
                        childAt.layout(i162, paddingTop, childAt.getMeasuredWidth() + i162, childAt.getMeasuredHeight() + paddingTop);
                        i11++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    } else {
                        i8 = Math.max((i9 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    i5 = paddingLeft;
                    paddingLeft = i8;
                    if (i15 == 16) {
                    }
                    i6 = paddingTop;
                    paddingTop = i7;
                    int i1622 = paddingLeft + scrollX;
                    childAt.layout(i1622, paddingTop, childAt.getMeasuredWidth() + i1622, childAt.getMeasuredHeight() + paddingTop);
                    i11++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i17 = (i9 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    float f = (float) i17;
                    int i19 = ((int) (infoForChild.offset * f)) + paddingLeft;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i10 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i10 - paddingBottom;
        this.mDecorChildCount = i11;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.isDecor)) {
                int i6 = layoutParams2.gravity;
                int i7 = i6 & 7;
                int i8 = i6 & 112;
                boolean z2 = i8 == 48 || i8 == 80;
                if (!(i7 == 3 || i7 == 5)) {
                    z = false;
                }
                int i9 = RecyclerView.UNDEFINED_DURATION;
                if (z2) {
                    i3 = Integer.MIN_VALUE;
                    i9 = 1073741824;
                } else {
                    i3 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i10 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i10 != -2) {
                    if (i10 == -1) {
                        i10 = paddingLeft;
                    }
                    i9 = 1073741824;
                } else {
                    i10 = paddingLeft;
                }
                int i11 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i11 == -2) {
                    i11 = measuredHeight;
                    i5 = i3;
                } else if (i11 == -1) {
                    i11 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec(i11, i5));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate(this.mCurItem);
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    public void onPageScrolled(int i, float f, int i2) {
        int i3;
        int left;
        int i4;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i6 = layoutParams.gravity & 7;
                    if (i6 != 1) {
                        if (i6 == 3) {
                            i3 = childAt.getWidth() + paddingLeft;
                        } else if (i6 != 5) {
                            i3 = paddingLeft;
                        } else {
                            i4 = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i3;
                    } else {
                        i4 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    i3 = paddingLeft;
                    paddingLeft = i4;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i3;
                }
            }
        }
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        this.mCalledSuper = true;
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        if (this.mAdapter != null) {
            setCurrentItemInternal(savedState.position, false, true, 0);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            if (pagerAdapter != null) {
                savedState.adapterState = null;
            } else {
                throw null;
            }
        }
        return savedState;
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i5, i5);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate(this.mCurItem);
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z = resetTouch();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f = this.mInitialMotionX;
                            this.mLastMotionX = x2 - f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f + ((float) this.mTouchSlop) : f - ((float) this.mTouchSlop);
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f2 = (float) clientWidth;
            float f3 = ((float) this.mPageMargin) / f2;
            int i = infoForCurrentScrollPosition.position;
            float f4 = ((((float) scrollX) / f2) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f3);
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)) <= this.mFlingDistance || Math.abs(xVelocity) <= this.mMinimumVelocity) {
                i += (int) (f4 + (i >= this.mCurItem ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                i++;
            }
            if (this.mItems.size() > 0) {
                ArrayList<ItemInfo> arrayList = this.mItems;
                i = Math.max(this.mItems.get(0).position, Math.min(i, arrayList.get(arrayList.size() - 1).position));
            }
            setCurrentItemInternal(i, true, true, xVelocity);
            z = resetTouch();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public final boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin;
            int i3 = clientWidth + i2;
            float f = (float) clientWidth;
            int i4 = infoForCurrentScrollPosition.position;
            float f2 = ((((float) i) / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) i2) / f));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, (int) (((float) i3) * f2));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public final boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mLastMotionX = (scrollX - ((float) i)) + this.mLastMotionX;
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0281, code lost:
        r7 = r7 - (r8.widthFactor + r4);
        r8.offset = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0287, code lost:
        if (r10 != 0) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0289, code lost:
        r14.mFirstOffset = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x028b, code lost:
        r3 = r3 - 1;
        r9 = r9 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02b3, code lost:
        if (r8 != r15) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02b5, code lost:
        r14.mLastOffset = (r7.widthFactor + r3) - 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r6 == r7) goto L_0x005c;
     */
    public void populate(int i) {
        ItemInfo itemInfo;
        String str;
        ItemInfo itemInfo2;
        ItemInfo infoForChild;
        float f;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        ItemInfo itemInfo5;
        float f2;
        int i2 = this.mCurItem;
        ItemInfo itemInfo6 = null;
        if (i2 != i) {
            itemInfo = infoForPosition(i2);
            this.mCurItem = i;
        } else {
            itemInfo = null;
        }
        if (!(this.mAdapter == null || this.mPopulatePending || getWindowToken() == null)) {
            if (this.mAdapter != null) {
                int i3 = this.mOffscreenPageLimit;
                int i4 = 0;
                int max = Math.max(0, this.mCurItem - i3);
                int count = this.mAdapter.getCount();
                int min = Math.min(count - 1, this.mCurItem + i3);
                if (count == this.mExpectedAdapterCount) {
                    while (true) {
                        if (i4 >= this.mItems.size()) {
                            break;
                        }
                        itemInfo2 = this.mItems.get(i4);
                        int i5 = itemInfo2.position;
                        int i6 = this.mCurItem;
                        if (i5 < i6) {
                            i4++;
                        }
                    }
                    itemInfo2 = null;
                    if (itemInfo2 == null && count > 0) {
                        itemInfo2 = addNewItem(this.mCurItem, i4);
                    }
                    if (itemInfo2 != null) {
                        int i7 = i4 - 1;
                        ItemInfo itemInfo7 = i7 >= 0 ? this.mItems.get(i7) : null;
                        int clientWidth = getClientWidth();
                        if (clientWidth <= 0) {
                            f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        } else {
                            f = (2.0f - itemInfo2.widthFactor) + (((float) getPaddingLeft()) / ((float) clientWidth));
                        }
                        float f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        for (int i8 = this.mCurItem - 1; i8 >= 0; i8--) {
                            if (f3 < f || i8 >= max) {
                                if (itemInfo7 == null || i8 != itemInfo7.position) {
                                    f3 += addNewItem(i8, i7 + 1).widthFactor;
                                    i4++;
                                    if (i7 >= 0) {
                                        itemInfo7 = this.mItems.get(i7);
                                    }
                                } else {
                                    f3 += itemInfo7.widthFactor;
                                    i7--;
                                    if (i7 >= 0) {
                                        itemInfo7 = this.mItems.get(i7);
                                    }
                                }
                            } else if (itemInfo7 == null) {
                                break;
                            } else {
                                if (i8 == itemInfo7.position && !itemInfo7.scrolling) {
                                    this.mItems.remove(i7);
                                    PagerAdapter pagerAdapter = this.mAdapter;
                                    Object obj = itemInfo7.object;
                                    if (((ReactViewPager.Adapter) pagerAdapter) != null) {
                                        removeView((View) obj);
                                        i7--;
                                        i4--;
                                        if (i7 >= 0) {
                                            itemInfo7 = this.mItems.get(i7);
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                            }
                            itemInfo7 = null;
                        }
                        float f4 = itemInfo2.widthFactor;
                        int i9 = i4 + 1;
                        if (f4 < 2.0f) {
                            ItemInfo itemInfo8 = i9 < this.mItems.size() ? this.mItems.get(i9) : null;
                            if (clientWidth <= 0) {
                                f2 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                            } else {
                                f2 = (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                            }
                            int i10 = i9;
                            for (int i11 = this.mCurItem + 1; i11 < count; i11++) {
                                if (f4 < f2 || i11 <= min) {
                                    if (itemInfo8 == null || i11 != itemInfo8.position) {
                                        ItemInfo addNewItem = addNewItem(i11, i10);
                                        i10++;
                                        f4 += addNewItem.widthFactor;
                                        if (i10 < this.mItems.size()) {
                                            itemInfo8 = this.mItems.get(i10);
                                        }
                                    } else {
                                        f4 += itemInfo8.widthFactor;
                                        i10++;
                                        if (i10 < this.mItems.size()) {
                                            itemInfo8 = this.mItems.get(i10);
                                        }
                                    }
                                } else if (itemInfo8 == null) {
                                    break;
                                } else {
                                    if (i11 == itemInfo8.position && !itemInfo8.scrolling) {
                                        this.mItems.remove(i10);
                                        PagerAdapter pagerAdapter2 = this.mAdapter;
                                        Object obj2 = itemInfo8.object;
                                        if (((ReactViewPager.Adapter) pagerAdapter2) != null) {
                                            removeView((View) obj2);
                                            if (i10 < this.mItems.size()) {
                                                itemInfo8 = this.mItems.get(i10);
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                }
                                itemInfo8 = null;
                            }
                        }
                        int count2 = this.mAdapter.getCount();
                        int clientWidth2 = getClientWidth();
                        float f5 = clientWidth2 > 0 ? ((float) this.mPageMargin) / ((float) clientWidth2) : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        if (itemInfo != null) {
                            int i12 = itemInfo.position;
                            int i13 = itemInfo2.position;
                            if (i12 < i13) {
                                float f6 = itemInfo.offset + itemInfo.widthFactor + f5;
                                int i14 = 0;
                                while (true) {
                                    i12++;
                                    if (i12 > itemInfo2.position || i14 >= this.mItems.size()) {
                                        break;
                                    }
                                    ItemInfo itemInfo9 = this.mItems.get(i14);
                                    while (true) {
                                        itemInfo5 = itemInfo9;
                                        if (i12 > itemInfo5.position && i14 < this.mItems.size() - 1) {
                                            i14++;
                                            itemInfo9 = this.mItems.get(i14);
                                        }
                                    }
                                    while (i12 < itemInfo5.position) {
                                        if (this.mAdapter != null) {
                                            f6 += 1.0f + f5;
                                            i12++;
                                        } else {
                                            throw null;
                                        }
                                    }
                                    itemInfo5.offset = f6;
                                    f6 += itemInfo5.widthFactor + f5;
                                }
                            } else if (i12 > i13) {
                                int size = this.mItems.size() - 1;
                                float f7 = itemInfo.offset;
                                while (true) {
                                    i12--;
                                    if (i12 < itemInfo2.position || size < 0) {
                                        break;
                                    }
                                    ItemInfo itemInfo10 = this.mItems.get(size);
                                    while (true) {
                                        itemInfo4 = itemInfo10;
                                        if (i12 < itemInfo4.position && size > 0) {
                                            size--;
                                            itemInfo10 = this.mItems.get(size);
                                        }
                                    }
                                    while (i12 > itemInfo4.position) {
                                        if (this.mAdapter != null) {
                                            f7 -= 1.0f + f5;
                                            i12--;
                                        } else {
                                            throw null;
                                        }
                                    }
                                    f7 -= itemInfo4.widthFactor + f5;
                                    itemInfo4.offset = f7;
                                }
                            }
                        }
                        int size2 = this.mItems.size();
                        float f8 = itemInfo2.offset;
                        int i15 = itemInfo2.position;
                        int i16 = i15 - 1;
                        this.mFirstOffset = i15 == 0 ? f8 : -3.4028235E38f;
                        int i17 = count2 - 1;
                        this.mLastOffset = itemInfo2.position == i17 ? (itemInfo2.offset + itemInfo2.widthFactor) - 1.0f : Float.MAX_VALUE;
                        int i18 = i4 - 1;
                        while (i18 >= 0) {
                            ItemInfo itemInfo11 = this.mItems.get(i18);
                            while (true) {
                                int i19 = itemInfo11.position;
                                if (i16 <= i19) {
                                    break;
                                }
                                i16--;
                                if (this.mAdapter != null) {
                                    f8 -= 1.0f + f5;
                                } else {
                                    throw null;
                                }
                            }
                        }
                        float f9 = itemInfo2.offset + itemInfo2.widthFactor + f5;
                        int i20 = itemInfo2.position;
                        while (true) {
                            i20++;
                            if (i9 < size2) {
                                itemInfo3 = this.mItems.get(i9);
                                while (true) {
                                    int i21 = itemInfo3.position;
                                    if (i20 >= i21) {
                                        break;
                                    }
                                    i20++;
                                    if (this.mAdapter != null) {
                                        f9 += 1.0f + f5;
                                    } else {
                                        throw null;
                                    }
                                }
                            } else if (this.mAdapter == null) {
                                throw null;
                            }
                            itemInfo3.offset = f9;
                            f9 += itemInfo3.widthFactor + f5;
                            i9++;
                        }
                    }
                    if (this.mAdapter != null) {
                        int childCount = getChildCount();
                        for (int i22 = 0; i22 < childCount; i22++) {
                            View childAt = getChildAt(i22);
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            layoutParams.childIndex = i22;
                            if (!layoutParams.isDecor && layoutParams.widthFactor == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && (infoForChild = infoForChild(childAt)) != null) {
                                layoutParams.widthFactor = infoForChild.widthFactor;
                                layoutParams.position = infoForChild.position;
                            }
                        }
                        if (hasFocus()) {
                            View findFocus = findFocus();
                            if (findFocus != null) {
                                while (true) {
                                    ViewParent parent = findFocus.getParent();
                                    if (parent == this) {
                                        itemInfo6 = infoForChild(findFocus);
                                        break;
                                    }
                                    if (parent == null || !(parent instanceof View)) {
                                        break;
                                    }
                                    findFocus = (View) parent;
                                }
                            }
                            if (itemInfo6 == null || itemInfo6.position != this.mCurItem) {
                                for (int i23 = 0; i23 < getChildCount(); i23++) {
                                    View childAt2 = getChildAt(i23);
                                    ItemInfo infoForChild2 = infoForChild(childAt2);
                                    if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(2)) {
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw null;
                }
                try {
                    str = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException unused) {
                    str = Integer.toHexString(getId());
                }
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
                outline17.append(this.mExpectedAdapterCount);
                outline17.append(", found: ");
                outline17.append(count);
                outline17.append(" Pager id: ");
                outline17.append(str);
                outline17.append(" Pager class: ");
                outline17.append(getClass());
                outline17.append(" Problematic adapter: ");
                outline17.append(this.mAdapter.getClass());
                throw new IllegalStateException(outline17.toString());
            }
            throw null;
        }
    }

    public final void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final boolean resetTouch() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() || this.mRightEdge.isFinished()) {
            return true;
        }
        return false;
    }

    public final void scrollToItem(int i, boolean z, int i2, boolean z2) {
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        int i3;
        int i4;
        ItemInfo infoForPosition = infoForPosition(i);
        int max = infoForPosition != null ? (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * ((float) getClientWidth())) : 0;
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.mScroller;
                if (scroller != null && !scroller.isFinished()) {
                    i3 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
                    this.mScroller.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                int i5 = max - i3;
                int i6 = 0 - scrollY;
                if (i5 == 0 && i6 == 0) {
                    completeScroll(false);
                    populate(this.mCurItem);
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i7 = clientWidth / 2;
                    float f = (float) clientWidth;
                    float f2 = (float) i7;
                    float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f) - 0.5f) * 0.47123894f))) * f2) + f2;
                    int abs = Math.abs(i2);
                    if (abs > 0) {
                        i4 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
                    } else if (this.mAdapter != null) {
                        i4 = (int) (((((float) Math.abs(i5)) / ((f * 1.0f) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
                    } else {
                        throw null;
                    }
                    int min = Math.min(i4, 600);
                    this.mIsScrollStarted = false;
                    this.mScroller.startScroll(i3, scrollY, i5, i6, min);
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
            if (z2 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                onPageChangeListener2.onPageSelected(i);
                return;
            }
            return;
        }
        if (z2 && (onPageChangeListener = this.mOnPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(i);
        }
        completeScroll(false);
        scrollTo(max, 0);
        pageScrolled(max);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            synchronized (pagerAdapter2) {
                pagerAdapter2.mViewPagerObserver = null;
            }
            if (this.mAdapter != null) {
                for (int i = 0; i < this.mItems.size(); i++) {
                    ItemInfo itemInfo = this.mItems.get(i);
                    PagerAdapter pagerAdapter3 = this.mAdapter;
                    int i2 = itemInfo.position;
                    Object obj = itemInfo.object;
                    if (((ReactViewPager.Adapter) pagerAdapter3) != null) {
                        removeView((View) obj);
                    } else {
                        throw null;
                    }
                }
                if (this.mAdapter != null) {
                    this.mItems.clear();
                    int i3 = 0;
                    while (i3 < getChildCount()) {
                        if (!((LayoutParams) getChildAt(i3).getLayoutParams()).isDecor) {
                            removeViewAt(i3);
                            i3--;
                        }
                        i3++;
                    }
                    this.mCurItem = 0;
                    scrollTo(0, 0);
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            PagerAdapter pagerAdapter4 = this.mAdapter;
            PagerObserver pagerObserver = this.mObserver;
            synchronized (pagerAdapter4) {
                pagerAdapter4.mViewPagerObserver = pagerObserver;
            }
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            int i4 = this.mRestoredCurItem;
            if (i4 >= 0) {
                if (this.mAdapter != null) {
                    setCurrentItemInternal(i4, false, true, 0);
                    this.mRestoredCurItem = -1;
                    this.mRestoredAdapterState = null;
                    this.mRestoredClassLoader = null;
                    return;
                }
                throw null;
            } else if (!z) {
                populate(this.mCurItem);
            } else {
                requestLayout();
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false, 0);
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean z3 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            int i4 = this.mCurItem;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).scrolling = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate(this.mCurItem);
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int childIndex;
        public int gravity;
        public boolean isDecor;
        public boolean needsMeasure;
        public int position;
        public float widthFactor = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false, 0);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }
}
