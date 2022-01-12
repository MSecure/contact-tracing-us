package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http1.Http1ExchangeCodec;

public class RecyclerView extends ViewGroup implements NestedScrollingChild {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    public static final boolean ALLOW_THREAD_GAP_WORK = true;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    public static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    public static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    public static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    public static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    public static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION = true;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    public static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    public static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    public static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator = new Interpolator() {
        /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass3 */

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public AdapterHelper mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public ChildDrawingOrderCallback mChildDrawingOrderCallback;
    public ChildHelper mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public EdgeEffectFactory mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public GapWorker mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public OnItemTouchListener mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public ItemAnimator mItemAnimator;
    public ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    public Runnable mItemAnimatorRunner;
    public final ArrayList<ItemDecoration> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastTouchX;
    public int mLastTouchY;
    public LayoutManager mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final RecyclerViewDataObserver mObserver;
    public List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    public OnFlingListener mOnFlingListener;
    public final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    public final List<ViewHolder> mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final Recycler mRecycler;
    public RecyclerListener mRecyclerListener;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public float mScaledHorizontalScrollFactor;
    public float mScaledVerticalScrollFactor;
    public OnScrollListener mScrollListener;
    public List<OnScrollListener> mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public NestedScrollingChildHelper mScrollingChildHelper;
    public final State mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final ViewFlinger mViewFlinger;
    public final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    public final ViewInfoStore mViewInfoStore;

    public static abstract class Adapter<VH extends ViewHolder> {
        public boolean mHasStableIds = false;
        public final AdapterDataObservable mObservable = new AdapterDataObservable();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                RecyclerViewDataObserver recyclerViewDataObserver = (RecyclerViewDataObserver) ((AdapterDataObserver) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mState.mStructureChanged = true;
                recyclerView.processDataSetCompletelyChanged(true);
                if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                    RecyclerView.this.requestLayout();
                }
            }
        }
    }

    public static abstract class AdapterDataObserver {
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public static class EdgeEffectFactory {
        public EdgeEffect createEdgeEffect(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public long mAddDuration = 120;
        public long mChangeDuration = 250;
        public ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        public ItemAnimatorListener mListener = null;
        public long mMoveDuration = 250;
        public long mRemoveDuration = 120;

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
        }

        public static class ItemHolderInfo {
            public int left;
            public int top;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int i2 = viewHolder.mOldPosition;
            int adapterPosition = viewHolder.getAdapterPosition();
            return (i2 == -1 || adapterPosition == -1 || i2 == adapterPosition) ? i : i | 2048;
        }

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return !((SimpleItemAnimator) this).mSupportsChangeAnimations || viewHolder.isInvalid();
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                ItemAnimatorRestoreListener itemAnimatorRestoreListener = (ItemAnimatorRestoreListener) itemAnimatorListener;
                if (itemAnimatorRestoreListener != null) {
                    boolean z = true;
                    viewHolder.setIsRecyclable(true);
                    if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                        viewHolder.mShadowedHolder = null;
                    }
                    viewHolder.mShadowingHolder = null;
                    if ((viewHolder.mFlags & 16) == 0) {
                        z = false;
                    }
                    if (!z && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView$State;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List<Ljava/lang/Object;>;)Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo; */
        public ItemHolderInfo recordPreLayoutInformation(ViewHolder viewHolder) {
            ItemHolderInfo itemHolderInfo = new ItemHolderInfo();
            View view = viewHolder.itemView;
            itemHolderInfo.left = view.getLeft();
            itemHolderInfo.top = view.getTop();
            view.getRight();
            view.getBottom();
            return itemHolderInfo;
        }
    }

    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }
    }

    public static abstract class ItemDecoration {
        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    public static abstract class OnFlingListener {
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class RecycledViewPool {
        public int mAttachCount = 0;
        public SparseArray<ScrapData> mScrap = new SparseArray<>();

        public static class ScrapData {
            public long mBindRunningAverageNs = 0;
            public long mCreateRunningAverageNs = 0;
            public int mMaxScrap = 5;
            public final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
        }

        public final ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.mScrap.put(i, scrapData2);
            return scrapData2;
        }

        public long runningAverage(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class Recycler {
        public final ArrayList<ViewHolder> mAttachedScrap = new ArrayList<>();
        public final ArrayList<ViewHolder> mCachedViews = new ArrayList<>();
        public ArrayList<ViewHolder> mChangedScrap = null;
        public RecycledViewPool mRecyclerPool;
        public int mRequestedCacheMax = 2;
        public final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
        public int mViewCacheMax = 2;

        public Recycler() {
        }

        public void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? itemDelegate.mOriginalItemDelegates.remove(view) : null);
            }
            if (z) {
                RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
                Adapter adapter = RecyclerView.this.mAdapter;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                }
            }
            viewHolder.mOwnerRecyclerView = null;
            RecycledViewPool recycledViewPool = getRecycledViewPool();
            if (recycledViewPool != null) {
                int i = viewHolder.mItemViewType;
                ArrayList<ViewHolder> arrayList = recycledViewPool.getScrapDataForType(i).mScrapHeap;
                if (recycledViewPool.mScrap.get(i).mMaxScrap > arrayList.size()) {
                    viewHolder.resetInternal();
                    arrayList.add(viewHolder);
                    return;
                }
                return;
            }
            throw null;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.getItemCount()) {
                StringBuilder outline18 = GeneratedOutlineSupport.outline18("invalid position ", i, ". State item count is ");
                outline18.append(RecyclerView.this.mState.getItemCount());
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline2(RecyclerView.this, outline18));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mState.mInPreLayout) {
                return i;
            }
            return recyclerView.mAdapterHelper.findPositionOffset(i, 0);
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        public final void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                layoutPrefetchRegistryImpl.mCount = 0;
            }
        }

        public void recycleCachedViewAt(int i) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
            this.mCachedViews.remove(i);
        }

        public void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.mScrapContainer.unscrapView(childViewHolderInt);
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Scrapped or attached views may not be recycled. isScrap:");
                outline17.append(viewHolder.isScrap());
                outline17.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z3 = true;
                }
                outline17.append(z3);
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(RecyclerView.this, outline17));
            } else if (viewHolder.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(viewHolder);
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(RecyclerView.this, sb));
            } else if (!viewHolder.shouldIgnore()) {
                boolean z4 = (viewHolder.mFlags & 16) == 0 && ViewCompat.hasTransientState(viewHolder.itemView);
                Adapter adapter = RecyclerView.this.mAdapter;
                if (adapter == null || !z4 || adapter != null) {
                    if (viewHolder.isRecyclable()) {
                        if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                            z2 = false;
                        } else {
                            int size = this.mCachedViews.size();
                            if (size >= this.mViewCacheMax && size > 0) {
                                recycleCachedViewAt(0);
                                size--;
                            }
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                                do {
                                    size--;
                                    if (size < 0) {
                                        break;
                                    }
                                } while (RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(size).mPosition));
                                size++;
                            }
                            this.mCachedViews.add(size, viewHolder);
                            z2 = true;
                        }
                        if (!z2) {
                            addViewHolderToRecycledViewPool(viewHolder, true);
                            z3 = true;
                        }
                        z = z3;
                        z3 = z2;
                    } else {
                        z = false;
                    }
                    RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                    if (!z3 && !z && z4) {
                        viewHolder.mOwnerRecyclerView = null;
                        return;
                    }
                    return;
                }
                throw null;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(RecyclerView.this, GeneratedOutlineSupport.outline17("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.mScrapContainer = this;
                childViewHolderInt.mInChangeScrap = true;
                this.mChangedScrap.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.mHasStableIds) {
                childViewHolderInt.mScrapContainer = this;
                childViewHolderInt.mInChangeScrap = false;
                this.mAttachedScrap.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(RecyclerView.this, GeneratedOutlineSupport.outline17("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e4, code lost:
            if (r7.mItemViewType != 0) goto L_0x01fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x044e, code lost:
            if (r7.isInvalid() == false) goto L_0x0484;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x0482, code lost:
            if ((r11 == 0 || r11 + r9 < r18) == false) goto L_0x0484;
         */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x0247  */
        /* JADX WARNING: Removed duplicated region for block: B:230:0x0416  */
        /* JADX WARNING: Removed duplicated region for block: B:238:0x0440  */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x046b  */
        /* JADX WARNING: Removed duplicated region for block: B:257:0x048e  */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x052c  */
        /* JADX WARNING: Removed duplicated region for block: B:291:0x053a  */
        /* JADX WARNING: Removed duplicated region for block: B:301:0x055c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
        public ViewHolder tryGetViewHolderForPositionByDeadline(int i, boolean z, long j) {
            ViewHolder viewHolder;
            boolean z2;
            boolean z3;
            boolean z4;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            Adapter adapter;
            RecyclerView findNestedRecyclerView;
            ViewHolder viewHolder2;
            ViewHolder viewHolder3;
            View view;
            boolean z5;
            int size;
            int findPositionOffset;
            if (i < 0 || i >= RecyclerView.this.mState.getItemCount()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i);
                sb.append("(");
                sb.append(i);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.mState.getItemCount());
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline2(RecyclerView.this, sb));
            }
            boolean z6 = false;
            if (RecyclerView.this.mState.mInPreLayout) {
                ArrayList<ViewHolder> arrayList = this.mChangedScrap;
                if (arrayList != null && (size = arrayList.size()) != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            viewHolder = this.mChangedScrap.get(i2);
                            if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                                viewHolder.addFlags(32);
                                break;
                            }
                            i2++;
                        } else {
                            RecyclerView recyclerView = RecyclerView.this;
                            if (recyclerView.mAdapter.mHasStableIds && (findPositionOffset = recyclerView.mAdapterHelper.findPositionOffset(i, 0)) > 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                                long itemId = RecyclerView.this.mAdapter.getItemId(findPositionOffset);
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size) {
                                        break;
                                    }
                                    ViewHolder viewHolder4 = this.mChangedScrap.get(i3);
                                    if (!viewHolder4.wasReturnedFromScrap() && viewHolder4.mItemId == itemId) {
                                        viewHolder4.addFlags(32);
                                        viewHolder = viewHolder4;
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        }
                    }
                    if (viewHolder != null) {
                        z2 = true;
                        if (viewHolder == null) {
                            int size2 = this.mAttachedScrap.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 < size2) {
                                    viewHolder3 = this.mAttachedScrap.get(i4);
                                    if (viewHolder3.wasReturnedFromScrap() || viewHolder3.getLayoutPosition() != i || viewHolder3.isInvalid() || (!RecyclerView.this.mState.mInPreLayout && viewHolder3.isRemoved())) {
                                        i4++;
                                    }
                                } else {
                                    if (!z) {
                                        ChildHelper childHelper = RecyclerView.this.mChildHelper;
                                        int size3 = childHelper.mHiddenViews.size();
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= size3) {
                                                view = null;
                                                break;
                                            }
                                            view = childHelper.mHiddenViews.get(i5);
                                            if (((AnonymousClass5) childHelper.mCallback) != null) {
                                                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                                if (!(childViewHolderInt.getLayoutPosition() != i || childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved())) {
                                                    break;
                                                }
                                                i5++;
                                            } else {
                                                throw null;
                                            }
                                        }
                                        if (view != null) {
                                            viewHolder = RecyclerView.getChildViewHolderInt(view);
                                            ChildHelper childHelper2 = RecyclerView.this.mChildHelper;
                                            int indexOfChild = RecyclerView.this.indexOfChild(view);
                                            if (indexOfChild < 0) {
                                                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                                            } else if (childHelper2.mBucket.get(indexOfChild)) {
                                                childHelper2.mBucket.clear(indexOfChild);
                                                childHelper2.unhideViewInternal(view);
                                                int indexOfChild2 = RecyclerView.this.mChildHelper.indexOfChild(view);
                                                if (indexOfChild2 != -1) {
                                                    RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild2);
                                                    scrapView(view);
                                                    viewHolder.addFlags(8224);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("layout index should not be -1 after unhiding a view:");
                                                    sb2.append(viewHolder);
                                                    throw new IllegalStateException(GeneratedOutlineSupport.outline2(RecyclerView.this, sb2));
                                                }
                                            } else {
                                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                                            }
                                        }
                                    }
                                    int size4 = this.mCachedViews.size();
                                    for (int i6 = 0; i6 < size4; i6++) {
                                        viewHolder3 = this.mCachedViews.get(i6);
                                        if (!viewHolder3.isInvalid() && viewHolder3.getLayoutPosition() == i && !viewHolder3.isAttachedToTransitionOverlay()) {
                                            if (!z) {
                                                this.mCachedViews.remove(i6);
                                            }
                                        }
                                    }
                                    viewHolder = null;
                                }
                            }
                            viewHolder3.addFlags(32);
                            viewHolder = viewHolder3;
                            if (viewHolder != null) {
                                if (viewHolder.isRemoved()) {
                                    z5 = RecyclerView.this.mState.mInPreLayout;
                                } else {
                                    int i7 = viewHolder.mPosition;
                                    if (i7 < 0 || i7 >= RecyclerView.this.mAdapter.getItemCount()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Inconsistency detected. Invalid view holder adapter position");
                                        sb3.append(viewHolder);
                                        throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline2(RecyclerView.this, sb3));
                                    }
                                    RecyclerView recyclerView2 = RecyclerView.this;
                                    if (!recyclerView2.mState.mInPreLayout) {
                                        if (recyclerView2.mAdapter == null) {
                                            throw null;
                                        }
                                    }
                                    Adapter adapter2 = RecyclerView.this.mAdapter;
                                    if (!adapter2.mHasStableIds || viewHolder.mItemId == adapter2.getItemId(viewHolder.mPosition)) {
                                        z5 = true;
                                    }
                                    z5 = false;
                                }
                                if (!z5) {
                                    if (!z) {
                                        viewHolder.addFlags(4);
                                        if (viewHolder.isScrap()) {
                                            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                                            viewHolder.mScrapContainer.unscrapView(viewHolder);
                                        } else if (viewHolder.wasReturnedFromScrap()) {
                                            viewHolder.clearReturnedFromScrapFlag();
                                        }
                                        recycleViewHolderInternal(viewHolder);
                                    }
                                    viewHolder = null;
                                } else {
                                    z2 = true;
                                }
                            }
                        }
                        if (viewHolder == null) {
                            int findPositionOffset2 = RecyclerView.this.mAdapterHelper.findPositionOffset(i, 0);
                            if (findPositionOffset2 < 0 || findPositionOffset2 >= RecyclerView.this.mAdapter.getItemCount()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Inconsistency detected. Invalid item position ");
                                sb4.append(i);
                                sb4.append("(offset:");
                                sb4.append(findPositionOffset2);
                                sb4.append(").state:");
                                sb4.append(RecyclerView.this.mState.getItemCount());
                                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline2(RecyclerView.this, sb4));
                            }
                            Adapter adapter3 = RecyclerView.this.mAdapter;
                            if (adapter3 != null) {
                                if (adapter3.mHasStableIds) {
                                    long itemId2 = adapter3.getItemId(findPositionOffset2);
                                    int size5 = this.mAttachedScrap.size() - 1;
                                    while (true) {
                                        if (size5 >= 0) {
                                            ViewHolder viewHolder5 = this.mAttachedScrap.get(size5);
                                            if (viewHolder5.mItemId == itemId2 && !viewHolder5.wasReturnedFromScrap()) {
                                                if (viewHolder5.mItemViewType == 0) {
                                                    viewHolder5.addFlags(32);
                                                    if (viewHolder5.isRemoved() && !RecyclerView.this.mState.mInPreLayout) {
                                                        viewHolder5.setFlags(2, 14);
                                                    }
                                                    viewHolder = viewHolder5;
                                                } else if (!z) {
                                                    this.mAttachedScrap.remove(size5);
                                                    RecyclerView.this.removeDetachedView(viewHolder5.itemView, false);
                                                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(viewHolder5.itemView);
                                                    childViewHolderInt2.mScrapContainer = null;
                                                    childViewHolderInt2.mInChangeScrap = false;
                                                    childViewHolderInt2.clearReturnedFromScrapFlag();
                                                    recycleViewHolderInternal(childViewHolderInt2);
                                                }
                                            }
                                            size5--;
                                        } else {
                                            int size6 = this.mCachedViews.size() - 1;
                                            while (true) {
                                                if (size6 < 0) {
                                                    break;
                                                }
                                                viewHolder = this.mCachedViews.get(size6);
                                                if (viewHolder.mItemId == itemId2 && !viewHolder.isAttachedToTransitionOverlay()) {
                                                    if (viewHolder.mItemViewType == 0) {
                                                        if (!z) {
                                                            this.mCachedViews.remove(size6);
                                                        }
                                                    } else if (!z) {
                                                        recycleCachedViewAt(size6);
                                                        break;
                                                    }
                                                }
                                                size6--;
                                            }
                                            viewHolder = null;
                                        }
                                    }
                                    if (viewHolder != null) {
                                        viewHolder.mPosition = findPositionOffset2;
                                        z2 = true;
                                    }
                                }
                                if (viewHolder == null) {
                                    RecycledViewPool.ScrapData scrapData = getRecycledViewPool().mScrap.get(0);
                                    if (scrapData != null && !scrapData.mScrapHeap.isEmpty()) {
                                        ArrayList<ViewHolder> arrayList2 = scrapData.mScrapHeap;
                                        int size7 = arrayList2.size() - 1;
                                        while (true) {
                                            if (size7 < 0) {
                                                break;
                                            } else if (!arrayList2.get(size7).isAttachedToTransitionOverlay()) {
                                                viewHolder2 = arrayList2.remove(size7);
                                                break;
                                            } else {
                                                size7--;
                                            }
                                        }
                                    }
                                    viewHolder2 = null;
                                    if (viewHolder2 != null) {
                                        viewHolder2.resetInternal();
                                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                            View view2 = viewHolder2.itemView;
                                            if (view2 instanceof ViewGroup) {
                                                invalidateDisplayListInt((ViewGroup) view2, false);
                                            }
                                        }
                                    }
                                    viewHolder = viewHolder2;
                                }
                                if (viewHolder == null) {
                                    long nanoTime = RecyclerView.this.getNanoTime();
                                    if (j != RecyclerView.FOREVER_NS) {
                                        long j2 = this.mRecyclerPool.getScrapDataForType(0).mCreateRunningAverageNs;
                                        if (!(j2 == 0 || j2 + nanoTime < j)) {
                                            return null;
                                        }
                                    }
                                    RecyclerView recyclerView3 = RecyclerView.this;
                                    Adapter adapter4 = recyclerView3.mAdapter;
                                    if (adapter4 != null) {
                                        try {
                                            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                                            ViewHolder onCreateViewHolder = adapter4.onCreateViewHolder(recyclerView3, 0);
                                            if (onCreateViewHolder.itemView.getParent() == null) {
                                                onCreateViewHolder.mItemViewType = 0;
                                                Trace.endSection();
                                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(onCreateViewHolder.itemView)) != null) {
                                                    onCreateViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                                }
                                                long nanoTime2 = RecyclerView.this.getNanoTime();
                                                RecycledViewPool recycledViewPool = this.mRecyclerPool;
                                                long j3 = nanoTime2 - nanoTime;
                                                RecycledViewPool.ScrapData scrapDataForType = recycledViewPool.getScrapDataForType(0);
                                                scrapDataForType.mCreateRunningAverageNs = recycledViewPool.runningAverage(scrapDataForType.mCreateRunningAverageNs, j3);
                                                viewHolder = onCreateViewHolder;
                                            } else {
                                                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                                            }
                                        } catch (Throwable th) {
                                            TraceCompat.endSection();
                                            throw th;
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                            } else {
                                throw null;
                            }
                        }
                        if (z2 && !RecyclerView.this.mState.mInPreLayout && viewHolder.hasAnyOfTheFlags(8192)) {
                            viewHolder.setFlags(0, 8192);
                            if (RecyclerView.this.mState.mRunSimpleAnimations) {
                                ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder);
                                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                                viewHolder.getUnmodifiedPayloads();
                                RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder, itemAnimator.recordPreLayoutInformation(viewHolder));
                            }
                        }
                        if (RecyclerView.this.mState.mInPreLayout || !viewHolder.isBound()) {
                            if (viewHolder.isBound()) {
                                if (!((viewHolder.mFlags & 2) != 0)) {
                                }
                            }
                            int findPositionOffset3 = RecyclerView.this.mAdapterHelper.findPositionOffset(i, 0);
                            RecyclerView recyclerView4 = RecyclerView.this;
                            viewHolder.mOwnerRecyclerView = recyclerView4;
                            int i8 = viewHolder.mItemViewType;
                            long nanoTime3 = recyclerView4.getNanoTime();
                            if (j != RecyclerView.FOREVER_NS) {
                                long j4 = this.mRecyclerPool.getScrapDataForType(i8).mBindRunningAverageNs;
                            }
                            adapter = RecyclerView.this.mAdapter;
                            if (adapter == null) {
                                viewHolder.mPosition = findPositionOffset3;
                                if (adapter.mHasStableIds) {
                                    viewHolder.mItemId = adapter.getItemId(findPositionOffset3);
                                }
                                viewHolder.setFlags(1, 519);
                                TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
                                viewHolder.getUnmodifiedPayloads();
                                adapter.onBindViewHolder(viewHolder, findPositionOffset3);
                                List<Object> list = viewHolder.mPayloads;
                                if (list != null) {
                                    list.clear();
                                }
                                viewHolder.mFlags &= -1025;
                                ViewGroup.LayoutParams layoutParams3 = viewHolder.itemView.getLayoutParams();
                                if (layoutParams3 instanceof LayoutParams) {
                                    ((LayoutParams) layoutParams3).mInsetsDirty = true;
                                }
                                Trace.endSection();
                                long nanoTime4 = RecyclerView.this.getNanoTime();
                                RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
                                RecycledViewPool.ScrapData scrapDataForType2 = recycledViewPool2.getScrapDataForType(viewHolder.mItemViewType);
                                scrapDataForType2.mBindRunningAverageNs = recycledViewPool2.runningAverage(scrapDataForType2.mBindRunningAverageNs, nanoTime4 - nanoTime3);
                                if (RecyclerView.this.isAccessibilityEnabled()) {
                                    View view3 = viewHolder.itemView;
                                    if (ViewCompat.getImportantForAccessibility(view3) == 0) {
                                        view3.setImportantForAccessibility(1);
                                    }
                                    RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
                                    if (recyclerViewAccessibilityDelegate != null) {
                                        RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                                        if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                                            if (itemDelegate != null) {
                                                AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view3);
                                                if (!(accessibilityDelegate == null || accessibilityDelegate == itemDelegate)) {
                                                    itemDelegate.mOriginalItemDelegates.put(view3, accessibilityDelegate);
                                                }
                                            } else {
                                                throw null;
                                            }
                                        }
                                        ViewCompat.setAccessibilityDelegate(view3, itemDelegate);
                                    }
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (RecyclerView.this.mState.mInPreLayout) {
                                    viewHolder.mPreLayoutPosition = i;
                                }
                                z4 = z3;
                                layoutParams = viewHolder.itemView.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                                    viewHolder.itemView.setLayoutParams(layoutParams2);
                                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                    layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                                    viewHolder.itemView.setLayoutParams(layoutParams2);
                                } else {
                                    layoutParams2 = (LayoutParams) layoutParams;
                                }
                                layoutParams2.mViewHolder = viewHolder;
                                if (z2 && z3) {
                                    z6 = z4;
                                }
                                layoutParams2.mPendingInvalidate = z6;
                                return viewHolder;
                            }
                            throw null;
                        }
                        viewHolder.mPreLayoutPosition = i;
                        z4 = true;
                        z3 = false;
                        layoutParams = viewHolder.itemView.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        layoutParams2.mViewHolder = viewHolder;
                        z6 = z4;
                        layoutParams2.mPendingInvalidate = z6;
                        return viewHolder;
                    }
                }
                viewHolder = null;
                if (viewHolder != null) {
                }
            } else {
                viewHolder = null;
            }
            z2 = false;
            if (viewHolder == null) {
            }
            if (viewHolder == null) {
            }
            viewHolder.setFlags(0, 8192);
            if (RecyclerView.this.mState.mRunSimpleAnimations) {
            }
            if (RecyclerView.this.mState.mInPreLayout) {
            }
            if (viewHolder.isBound()) {
            }
            int findPositionOffset32 = RecyclerView.this.mAdapterHelper.findPositionOffset(i, 0);
            RecyclerView recyclerView42 = RecyclerView.this;
            viewHolder.mOwnerRecyclerView = recyclerView42;
            int i82 = viewHolder.mItemViewType;
            long nanoTime32 = recyclerView42.getNanoTime();
            if (j != RecyclerView.FOREVER_NS) {
            }
            adapter = RecyclerView.this.mAdapter;
            if (adapter == null) {
            }
        }

        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public void updateViewCacheSize() {
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            this.mViewCacheMax = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }
    }

    public static abstract class SmoothScroller {
        public LayoutManager mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public final Action mRecyclingAction = new Action(0, 0);
        public boolean mRunning;
        public boolean mStarted;
        public int mTargetPosition = -1;
        public View mTargetView;

        public static class Action {
            public boolean mChanged = false;
            public int mConsecutiveUpdates = 0;
            public int mDuration;
            public int mDx;
            public int mDy;
            public Interpolator mInterpolator;
            public int mJumpToPosition = -1;

            public Action(int i, int i2) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = RecyclerView.UNDEFINED_DURATION;
                this.mInterpolator = null;
            }

            public void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                } else if (!this.mChanged) {
                    this.mConsecutiveUpdates = 0;
                } else if (this.mInterpolator == null || this.mDuration >= 1) {
                    int i2 = this.mDuration;
                    if (i2 >= 1) {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, i2, this.mInterpolator);
                        int i3 = this.mConsecutiveUpdates + 1;
                        this.mConsecutiveUpdates = i3;
                        if (i3 > 10) {
                            Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.mChanged = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = this.mLayoutManager;
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            outline17.append(ScrollVectorProvider.class.getCanonicalName());
            Log.w(RecyclerView.TAG, outline17.toString());
            return null;
        }

        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.mPendingInitialRun || this.mTargetView != null || this.mLayoutManager == null || (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) == null || (computeScrollVectorForPosition.x == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && computeScrollVectorForPosition.y == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER))) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (this.mRecyclerView.getChildLayoutPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                State state = recyclerView.mState;
                Action action = this.mRecyclingAction;
                LinearSmoothScroller linearSmoothScroller = (LinearSmoothScroller) this;
                if (linearSmoothScroller.mRecyclerView.mLayout.getChildCount() == 0) {
                    linearSmoothScroller.stop();
                } else {
                    int i3 = linearSmoothScroller.mInterimTargetDx;
                    int i4 = i3 - i;
                    if (i3 * i4 <= 0) {
                        i4 = 0;
                    }
                    linearSmoothScroller.mInterimTargetDx = i4;
                    int i5 = linearSmoothScroller.mInterimTargetDy;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    linearSmoothScroller.mInterimTargetDy = i6;
                    if (linearSmoothScroller.mInterimTargetDx == 0 && i6 == 0) {
                        PointF computeScrollVectorForPosition2 = linearSmoothScroller.computeScrollVectorForPosition(linearSmoothScroller.mTargetPosition);
                        if (computeScrollVectorForPosition2 == null || (computeScrollVectorForPosition2.x == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && computeScrollVectorForPosition2.y == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                            action.mJumpToPosition = linearSmoothScroller.mTargetPosition;
                            linearSmoothScroller.stop();
                        } else {
                            float f = computeScrollVectorForPosition2.x;
                            float f2 = computeScrollVectorForPosition2.y;
                            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
                            float f3 = computeScrollVectorForPosition2.x / sqrt;
                            computeScrollVectorForPosition2.x = f3;
                            float f4 = computeScrollVectorForPosition2.y / sqrt;
                            computeScrollVectorForPosition2.y = f4;
                            linearSmoothScroller.mTargetVector = computeScrollVectorForPosition2;
                            linearSmoothScroller.mInterimTargetDx = (int) (f3 * 10000.0f);
                            linearSmoothScroller.mInterimTargetDy = (int) (f4 * 10000.0f);
                            action.update((int) (((float) linearSmoothScroller.mInterimTargetDx) * 1.2f), (int) (((float) linearSmoothScroller.mInterimTargetDy) * 1.2f), (int) (((float) linearSmoothScroller.calculateTimeForScrolling(10000)) * 1.2f), linearSmoothScroller.mLinearInterpolator);
                        }
                    }
                }
                if (this.mRecyclingAction.mJumpToPosition >= 0) {
                    z = true;
                }
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public abstract void onTargetFound(View view, State state, Action action);

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                LinearSmoothScroller linearSmoothScroller = (LinearSmoothScroller) this;
                linearSmoothScroller.mInterimTargetDy = 0;
                linearSmoothScroller.mInterimTargetDx = 0;
                linearSmoothScroller.mTargetVector = null;
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                LayoutManager layoutManager = this.mLayoutManager;
                if (layoutManager.mSmoothScroller == this) {
                    layoutManager.mSmoothScroller = null;
                }
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class State {
        public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public boolean mInPreLayout = false;
        public boolean mIsMeasuring = false;
        public int mItemCount = 0;
        public int mLayoutStep = 1;
        public int mPreviousLayoutItemCount = 0;
        public int mRemainingScrollHorizontal;
        public boolean mRunPredictiveAnimations = false;
        public boolean mRunSimpleAnimations = false;
        public boolean mStructureChanged = false;
        public int mTargetPosition = -1;
        public boolean mTrackOldChangeHolders = false;

        public void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) == 0) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Layout state should be one of ");
                outline17.append(Integer.toBinaryString(i));
                outline17.append(" but it is ");
                outline17.append(Integer.toBinaryString(this.mLayoutStep));
                throw new IllegalStateException(outline17.toString());
            }
        }

        public int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("State{mTargetPosition=");
            outline17.append(this.mTargetPosition);
            outline17.append(", mData=");
            outline17.append((Object) null);
            outline17.append(", mItemCount=");
            outline17.append(this.mItemCount);
            outline17.append(", mIsMeasuring=");
            outline17.append(this.mIsMeasuring);
            outline17.append(", mPreviousLayoutItemCount=");
            outline17.append(this.mPreviousLayoutItemCount);
            outline17.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            outline17.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            outline17.append(", mStructureChanged=");
            outline17.append(this.mStructureChanged);
            outline17.append(", mInPreLayout=");
            outline17.append(this.mInPreLayout);
            outline17.append(", mRunSimpleAnimations=");
            outline17.append(this.mRunSimpleAnimations);
            outline17.append(", mRunPredictiveAnimations=");
            outline17.append(this.mRunPredictiveAnimations);
            outline17.append('}');
            return outline17.toString();
        }
    }

    public static abstract class ViewCacheExtension {
    }

    public class ViewFlinger implements Runnable {
        public boolean mEatRunOnAnimationRequest = false;
        public Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mReSchedulePostAnimationCallback = false;

        public ViewFlinger() {
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.mLastFlingX;
                int i4 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.mPendingInitialRun && smoothScroller.mRunning) {
                        int itemCount = recyclerView4.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.mTargetPosition >= itemCount) {
                            smoothScroller.mTargetPosition = itemCount - 1;
                            smoothScroller.onAnimation(i, i2);
                        } else {
                            smoothScroller.onAnimation(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i, i2, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 != null && smoothScroller2.mPendingInitialRun) || !z) {
                    postOnAnimation();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView6.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView6, i, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = layoutPrefetchRegistryImpl.mPrefetchArray;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        layoutPrefetchRegistryImpl.mCount = 0;
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.mPendingInitialRun) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        public void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            int i4;
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt((double) 0);
                int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i * i)));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i5 = width / 2;
                float f = (float) width;
                float f2 = (float) i5;
                float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) sqrt2) * 1.0f) / f) - 0.5f) * 0.47123894f))) * f2) + f2;
                if (sqrt > 0) {
                    i4 = Math.round(Math.abs(sin / ((float) sqrt)) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i4 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
                }
                i3 = Math.min(i4, 2000);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i3);
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        public static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public final View itemView;
        public int mFlags;
        public boolean mInChangeScrap = false;
        public int mIsRecyclableCount = 0;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public int mOldPosition = -1;
        public RecyclerView mOwnerRecyclerView;
        public List<Object> mPayloads = null;
        public int mPendingAccessibilityState = -1;
        public int mPosition = -1;
        public int mPreLayoutPosition = -1;
        public Recycler mScrapContainer = null;
        public ViewHolder mShadowedHolder = null;
        public ViewHolder mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        public int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                if (this.mPayloads == null) {
                    ArrayList arrayList = new ArrayList();
                    this.mPayloads = arrayList;
                    this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
                }
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public String toString() {
            StringBuilder outline19 = GeneratedOutlineSupport.outline19(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            outline19.append(Integer.toHexString(hashCode()));
            outline19.append(" position=");
            outline19.append(this.mPosition);
            outline19.append(" id=");
            outline19.append(this.mItemId);
            outline19.append(", oldPos=");
            outline19.append(this.mOldPosition);
            outline19.append(", pLpos:");
            outline19.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(outline19.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            boolean z = true;
            if ((this.mFlags & 2) != 0) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17(" not recyclable(");
                outline17.append(this.mIsRecyclableCount);
                outline17.append(")");
                sb.append(outline17.toString());
            }
            if ((this.mFlags & 512) == 0 && !isInvalid()) {
                z = false;
            }
            if (z) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.addView(view, -1, true);
        } else {
            ChildHelper childHelper = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                childHelper.mBucket.set(indexOfChild);
                childHelper.hideViewInternal(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != viewHolder.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e7);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            obtain.setContentChangeTypes(i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        ViewInfoStore viewInfoStore = this.mViewInfoStore;
        viewInfoStore.mLayoutHolderMap.clear();
        viewInfoStore.mOldChangedHolders.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        state.mTrackOldChangeHolders = state.mRunSimpleAnimations && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State state2 = this.mState;
        state2.mInPreLayout = state2.mRunPredictiveAnimations;
        state2.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.mHasStableIds)) {
                    ItemAnimator itemAnimator = this.mItemAnimator;
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, itemAnimator.recordPreLayoutInformation(childViewHolderInt));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state3 = this.mState;
            boolean z = state3.mStructureChanged;
            state3.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state3);
            this.mState.mStructureChanged = z;
            for (int i2 = 0; i2 < this.mChildHelper.getChildCount(); i2++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (!childViewHolderInt2.shouldIgnore()) {
                    ViewInfoStore.InfoRecord orDefault = this.mViewInfoStore.mLayoutHolderMap.getOrDefault(childViewHolderInt2, null);
                    if (!((orDefault == null || (orDefault.flags & 4) == 0) ? false : true)) {
                        ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        ItemAnimator itemAnimator2 = this.mItemAnimator;
                        childViewHolderInt2.getUnmodifiedPayloads();
                        ItemAnimator.ItemHolderInfo recordPreLayoutInformation = itemAnimator2.recordPreLayoutInformation(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                        } else {
                            ViewInfoStore viewInfoStore2 = this.mViewInfoStore;
                            ViewInfoStore.InfoRecord orDefault2 = viewInfoStore2.mLayoutHolderMap.getOrDefault(childViewHolderInt2, null);
                            if (orDefault2 == null) {
                                orDefault2 = ViewInfoStore.InfoRecord.obtain();
                                viewInfoStore2.mLayoutHolderMap.put(childViewHolderInt2, orDefault2);
                            }
                            orDefault2.flags |= 2;
                            orDefault2.preInfo = recordPreLayoutInformation;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State state = this.mState;
        state.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        this.mPendingSavedState = null;
        state2.mRunSimpleAnimations = state2.mRunSimpleAnimations && this.mItemAnimator != null;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        boolean z;
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    if (this.mItemAnimator != null) {
                        ItemAnimator.ItemHolderInfo itemHolderInfo = new ItemAnimator.ItemHolderInfo();
                        View view = childViewHolderInt.itemView;
                        itemHolderInfo.left = view.getLeft();
                        itemHolderInfo.top = view.getTop();
                        view.getRight();
                        view.getBottom();
                        ViewHolder viewHolder = this.mViewInfoStore.mOldChangedHolders.get(changedHolderKey, null);
                        if (viewHolder == null || viewHolder.shouldIgnore()) {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                        } else {
                            boolean isDisappearing = this.mViewInfoStore.isDisappearing(viewHolder);
                            boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                            if (!isDisappearing || viewHolder != childViewHolderInt) {
                                ItemAnimator.ItemHolderInfo popFromLayoutStep = this.mViewInfoStore.popFromLayoutStep(viewHolder, 4);
                                this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                                ItemAnimator.ItemHolderInfo popFromLayoutStep2 = this.mViewInfoStore.popFromLayoutStep(childViewHolderInt, 8);
                                if (popFromLayoutStep == null) {
                                    handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, viewHolder);
                                } else {
                                    animateChange(viewHolder, childViewHolderInt, popFromLayoutStep, popFromLayoutStep2, isDisappearing, isDisappearing2);
                                }
                            } else {
                                this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                            }
                        }
                    } else {
                        throw null;
                    }
                }
            }
            ViewInfoStore viewInfoStore = this.mViewInfoStore;
            ViewInfoStore.ProcessCallback processCallback = this.mViewInfoProcessCallback;
            int i = viewInfoStore.mLayoutHolderMap.mSize;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                ViewHolder keyAt = viewInfoStore.mLayoutHolderMap.keyAt(i);
                ViewInfoStore.InfoRecord removeAt = viewInfoStore.mLayoutHolderMap.removeAt(i);
                int i2 = removeAt.flags;
                if ((i2 & 3) == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView.mRecycler);
                } else if ((i2 & 1) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo2 = removeAt.preInfo;
                    if (itemHolderInfo2 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView2.mRecycler);
                    } else {
                        ItemAnimator.ItemHolderInfo itemHolderInfo3 = removeAt.postInfo;
                        AnonymousClass4 r8 = (AnonymousClass4) processCallback;
                        RecyclerView.this.mRecycler.unscrapView(keyAt);
                        RecyclerView.this.animateDisappearance(keyAt, itemHolderInfo2, itemHolderInfo3);
                    }
                } else if ((i2 & 14) == 14) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.preInfo, removeAt.postInfo);
                } else if ((i2 & 12) == 12) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo4 = removeAt.preInfo;
                    ItemAnimator.ItemHolderInfo itemHolderInfo5 = removeAt.postInfo;
                    AnonymousClass4 r82 = (AnonymousClass4) processCallback;
                    if (r82 != null) {
                        keyAt.setIsRecyclable(false);
                        RecyclerView recyclerView3 = RecyclerView.this;
                        if (!recyclerView3.mDataSetHasChangedAfterLayout) {
                            SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView3.mItemAnimator;
                            if (simpleItemAnimator != null) {
                                if (itemHolderInfo4.left == itemHolderInfo5.left && itemHolderInfo4.top == itemHolderInfo5.top) {
                                    simpleItemAnimator.dispatchAnimationFinished(keyAt);
                                    z = false;
                                } else {
                                    z = simpleItemAnimator.animateMove(keyAt, itemHolderInfo4.left, itemHolderInfo4.top, itemHolderInfo5.left, itemHolderInfo5.top);
                                }
                                if (z) {
                                    RecyclerView.this.postAnimationRunner();
                                }
                            } else {
                                throw null;
                            }
                        } else if (recyclerView3.mItemAnimator.animateChange(keyAt, keyAt, itemHolderInfo4, itemHolderInfo5)) {
                            RecyclerView.this.postAnimationRunner();
                        }
                    } else {
                        throw null;
                    }
                } else if ((i2 & 4) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo6 = removeAt.preInfo;
                    AnonymousClass4 r6 = (AnonymousClass4) processCallback;
                    RecyclerView.this.mRecycler.unscrapView(keyAt);
                    RecyclerView.this.animateDisappearance(keyAt, itemHolderInfo6, null);
                } else if ((i2 & 8) != 0) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.preInfo, removeAt.postInfo);
                }
                ViewInfoStore.InfoRecord.recycle(removeAt);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        ViewInfoStore viewInfoStore2 = this.mViewInfoStore;
        viewInfoStore2.mLayoutHolderMap.clear();
        viewInfoStore2.mOldChangedHolders.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener != null) {
            onItemTouchListener.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = UNDEFINED_DURATION;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        int i = this.mState.mFocusedItemPosition;
        if (i == -1) {
            i = 0;
        }
        int itemCount = this.mState.getItemCount();
        for (int i2 = i; i2 < itemCount; i2++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.mHasStableIds) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(viewHolder);
                    throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, sb));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(viewHolder);
                throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || !childViewHolderInt.isUpdated())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0 && Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass5 */

            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i4 = rect.left;
        int i5 = this.mTempRect2.left;
        if ((i4 < i5 || rect.right <= i5) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            Rect rect2 = this.mTempRect;
            int i6 = rect2.right;
            int i7 = this.mTempRect2.right;
            i2 = ((i6 > i7 || rect2.left >= i7) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        Rect rect3 = this.mTempRect;
        int i8 = rect3.top;
        int i9 = this.mTempRect2.top;
        if ((i8 < i9 || rect3.bottom <= i9) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else {
            Rect rect4 = this.mTempRect;
            int i10 = rect4.bottom;
            int i11 = this.mTempRect2.bottom;
            if ((i10 <= i11 && rect4.top < i11) || this.mTempRect.top <= this.mTempRect2.top) {
                c = 0;
            }
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c > 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid direction: ");
        sb.append(i);
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(this, sb));
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z = false;
        if (this.mDataSetHasChangedAfterLayout) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
            adapterHelper.mExistingUpdateTypes = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.mRunSimpleAnimations = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.mHasStableIds);
        State state = this.mState;
        if (state.mRunSimpleAnimations && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        state.mRunPredictiveAnimations = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    private void pullGlows(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            ensureLeftGlow();
            this.mLeftGlow.onPull((-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
        } else if (f2 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            ensureRightGlow();
            this.mRightGlow.onPull(f2 / ((float) getWidth()), f3 / ((float) getHeight()));
        } else {
            z = false;
            if (f4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                ensureTopGlow();
                this.mTopGlow.onPull((-f4) / ((float) getHeight()), f / ((float) getWidth()));
            } else if (f4 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                ensureBottomGlow();
                this.mBottomGlow.onPull(f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
            } else {
                z2 = z;
            }
            if (!z2 || f2 != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f4 != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return;
        }
        z = true;
        if (f4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
        }
        if (!z2) {
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.isHidden(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                long j = this.mState.mFocusedItemId;
                View view = null;
                ViewHolder findViewHolderForItemId = (j == -1 || !this.mAdapter.mHasStableIds) ? null : findViewHolderForItemId(j);
                if (findViewHolderForItemId != null && !this.mChildHelper.isHidden(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i = this.mState.mFocusedSubChildId;
                    if (!(((long) i) == -1 || (findViewById = view.findViewById(i)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int i;
        ViewHolder viewHolder = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.mFocusedItemId = this.mAdapter.mHasStableIds ? viewHolder.mItemId : -1;
        State state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (viewHolder.isRemoved()) {
            i = viewHolder.mOldPosition;
        } else {
            i = viewHolder.getAdapterPosition();
        }
        state.mFocusedItemPosition = i;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.mObservable.unregisterObserver(this.mObserver);
            if (this.mAdapter == null) {
                throw null;
            }
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
        adapterHelper.mExistingUpdateTypes = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.mObservable.registerObserver(this.mObserver);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged();
        }
        Recycler recycler = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        recycler.clear();
        RecycledViewPool recycledViewPool = recycler.getRecycledViewPool();
        if (recycledViewPool != null) {
            if (adapter3 != null) {
                recycledViewPool.mAttachCount--;
            }
            if (!z && recycledViewPool.mAttachCount == 0) {
                for (int i = 0; i < recycledViewPool.mScrap.size(); i++) {
                    recycledViewPool.mScrap.valueAt(i).mScrapHeap.clear();
                }
            }
            if (adapter4 != null) {
                recycledViewPool.mAttachCount++;
            }
            this.mState.mStructureChanged = true;
            return;
        }
        throw null;
    }

    private void stopScrollersInternal() {
        SmoothScroller smoothScroller;
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && (smoothScroller = layoutManager.mSmoothScroller) != null) {
            smoothScroller.stop();
        }
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables()) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        boolean z;
        viewHolder.setIsRecyclable(false);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.mItemAnimator;
        if (simpleItemAnimator != null) {
            if (itemHolderInfo == null || (itemHolderInfo.left == itemHolderInfo2.left && itemHolderInfo.top == itemHolderInfo2.top)) {
                DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) simpleItemAnimator;
                defaultItemAnimator.resetAnimation(viewHolder);
                viewHolder.itemView.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                defaultItemAnimator.mPendingAdditions.add(viewHolder);
                z = true;
            } else {
                z = simpleItemAnimator.animateMove(viewHolder, itemHolderInfo.left, itemHolderInfo.top, itemHolderInfo2.left, itemHolderInfo2.top);
            }
            if (z) {
                postAnimationRunner();
                return;
            }
            return;
        }
        throw null;
    }

    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        boolean z;
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.mItemAnimator;
        if (simpleItemAnimator != null) {
            int i = itemHolderInfo.left;
            int i2 = itemHolderInfo.top;
            View view = viewHolder.itemView;
            int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.left;
            int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.top;
            if (viewHolder.isRemoved() || (i == left && i2 == top)) {
                DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) simpleItemAnimator;
                defaultItemAnimator.resetAnimation(viewHolder);
                defaultItemAnimator.mPendingRemovals.add(viewHolder);
                z = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                z = simpleItemAnimator.animateMove(viewHolder, i, i2, left, top);
            }
            if (z) {
                postAnimationRunner();
                return;
            }
            return;
        }
        throw null;
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17(str)));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.mCachedViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            recycler.mCachedViews.get(i2).clearOldPosition();
        }
        int size2 = recycler.mAttachedScrap.size();
        for (int i3 = 0; i3 < size2; i3++) {
            recycler.mAttachedScrap.get(i3).clearOldPosition();
        }
        ArrayList<ViewHolder> arrayList = recycler.mChangedScrap;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                recycler.mChangedScrap.get(i4).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
        } else if (this.mAdapterHelper.hasPendingUpdates()) {
            boolean z = false;
            if ((this.mAdapterHelper.mExistingUpdateTypes & 4) != 0) {
                if ((this.mAdapterHelper.mExistingUpdateTypes & 11) != 0) {
                    z = true;
                }
                if (!z) {
                    TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.preProcess();
                    if (!this.mLayoutWasDefered) {
                        if (hasUpdatedView()) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.consumePostponedUpdates();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    Trace.endSection();
                    return;
                }
            }
            if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingRight() + getPaddingLeft(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter == null || childViewHolderInt == null || adapter != null) {
            List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
                }
                return;
            }
            return;
        }
        throw null;
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter == null || childViewHolderInt == null || adapter != null) {
            List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
                }
                return;
            }
            return;
        }
        throw null;
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            State state = this.mState;
            boolean z = false;
            state.mIsMeasuring = false;
            if (state.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                AdapterHelper adapterHelper = this.mAdapterHelper;
                if (!adapterHelper.mPostponedList.isEmpty() && !adapterHelper.mPendingUpdates.isEmpty()) {
                    z = true;
                }
                if (!z && this.mLayout.mWidth == getWidth() && this.mLayout.mHeight == getHeight()) {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                } else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    dispatchLayoutStep2();
                }
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) (getPaddingRight() + (-getWidth())), (float) (getPaddingBottom() + (-getHeight())));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z3 = z;
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mBottomGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mLeftGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mRightGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mTopGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17(" ");
        outline17.append(super.toString());
        outline17.append(", adapter:");
        outline17.append(this.mAdapter);
        outline17.append(", layout:");
        outline17.append(this.mLayout);
        outline17.append(", context:");
        outline17.append(getContext());
        return outline17.toString();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= ((float) childAt.getLeft()) + translationX && f <= ((float) childAt.getRight()) + translationX && f2 >= ((float) childAt.getTop()) + translationY && f2 <= ((float) childAt.getBottom()) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.mHasStableIds) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i = 0; i < unfilteredChildCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.mItemId == j) {
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0124 A[RETURN] */
    public boolean fling(int i, int i2) {
        boolean z;
        int minFlingVelocity;
        boolean z2;
        SnapHelper.AnonymousClass2 r12;
        int i3;
        int i4;
        View findSnapView;
        int position;
        PointF computeScrollVectorForPosition;
        int i5;
        int i6;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            int i7 = (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) ? 0 : i;
            int i8 = (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
            if (i7 == 0 && i8 == 0) {
                return false;
            }
            float f = (float) i7;
            float f2 = (float) i8;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z3 = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f, f2, z3);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null) {
                    SnapHelper snapHelper = (SnapHelper) onFlingListener;
                    LayoutManager layoutManager2 = snapHelper.mRecyclerView.getLayoutManager();
                    if (!(layoutManager2 == null || snapHelper.mRecyclerView.getAdapter() == null || (Math.abs(i8) <= (minFlingVelocity = snapHelper.mRecyclerView.getMinFlingVelocity()) && Math.abs(i7) <= minFlingVelocity))) {
                        boolean z4 = layoutManager2 instanceof SmoothScroller.ScrollVectorProvider;
                        if (z4) {
                            Adapter adapter = null;
                            if (!z4) {
                                r12 = null;
                            } else {
                                r12 = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0093: CONSTRUCTOR  (r12v2 'r12' androidx.recyclerview.widget.SnapHelper$2) = 
                                      (r6v3 'snapHelper' androidx.recyclerview.widget.SnapHelper)
                                      (wrap: android.content.Context : 0x008f: INVOKE  (r13v10 android.content.Context) = 
                                      (wrap: androidx.recyclerview.widget.RecyclerView : 0x008d: IGET  (r13v9 androidx.recyclerview.widget.RecyclerView) = (r6v3 'snapHelper' androidx.recyclerview.widget.SnapHelper) androidx.recyclerview.widget.SnapHelper.mRecyclerView androidx.recyclerview.widget.RecyclerView)
                                     type: VIRTUAL call: android.view.ViewGroup.getContext():android.content.Context)
                                     call: androidx.recyclerview.widget.SnapHelper.2.<init>(androidx.recyclerview.widget.SnapHelper, android.content.Context):void type: CONSTRUCTOR in method: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.recyclerview.widget.SnapHelper, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 50 more
                                    */
                                /* JADX WARNING: Removed duplicated region for block: B:84:0x0117  */
                                /* JADX WARNING: Removed duplicated region for block: B:86:0x011f  */
                                /* JADX WARNING: Removed duplicated region for block: B:89:0x0124 A[RETURN] */
                                /*
                                // Method dump skipped, instructions count: 389
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
                            }

                            public View focusSearch(View view, int i) {
                                View view2;
                                boolean z;
                                View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch();
                                if (onInterceptFocusSearch != null) {
                                    return onInterceptFocusSearch;
                                }
                                boolean z2 = true;
                                boolean z3 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
                                FocusFinder instance = FocusFinder.getInstance();
                                if (!z3 || !(i == 2 || i == 1)) {
                                    View findNextFocus = instance.findNextFocus(this, view, i);
                                    if (findNextFocus != null || !z3) {
                                        view2 = findNextFocus;
                                    } else {
                                        consumePendingUpdateOperations();
                                        if (findContainingItemView(view) == null) {
                                            return null;
                                        }
                                        startInterceptRequestLayout();
                                        view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                                        stopInterceptRequestLayout(false);
                                    }
                                } else {
                                    if (this.mLayout.canScrollVertically()) {
                                        int i2 = i == 2 ? 130 : 33;
                                        z = instance.findNextFocus(this, view, i2) == null;
                                        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                                            i = i2;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (!z && this.mLayout.canScrollHorizontally()) {
                                        int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                                        if (instance.findNextFocus(this, view, i3) != null) {
                                            z2 = false;
                                        }
                                        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                                            i = i3;
                                        }
                                        z = z2;
                                    }
                                    if (z) {
                                        consumePendingUpdateOperations();
                                        if (findContainingItemView(view) == null) {
                                            return null;
                                        }
                                        startInterceptRequestLayout();
                                        this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                                        stopInterceptRequestLayout(false);
                                    }
                                    view2 = instance.findNextFocus(this, view, i);
                                }
                                if (view2 == null || view2.hasFocusable()) {
                                    return isPreferredNextFocus(view, view2, i) ? view2 : super.focusSearch(view, i);
                                }
                                if (getFocusedChild() == null) {
                                    return super.focusSearch(view, i);
                                }
                                requestChildOnScreen(view2, null);
                                return view;
                            }

                            public ViewGroup.LayoutParams generateDefaultLayoutParams() {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    return layoutManager.generateDefaultLayoutParams();
                                }
                                throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("RecyclerView has no LayoutManager")));
                            }

                            @Override // android.view.ViewGroup
                            public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    return layoutManager.generateLayoutParams(getContext(), attributeSet);
                                }
                                throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("RecyclerView has no LayoutManager")));
                            }

                            public CharSequence getAccessibilityClassName() {
                                return "androidx.recyclerview.widget.RecyclerView";
                            }

                            public Adapter getAdapter() {
                                return this.mAdapter;
                            }

                            public int getAdapterPositionFor(ViewHolder viewHolder) {
                                if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
                                    return -1;
                                }
                                AdapterHelper adapterHelper = this.mAdapterHelper;
                                int i = viewHolder.mPosition;
                                int size = adapterHelper.mPendingUpdates.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    AdapterHelper.UpdateOp updateOp = adapterHelper.mPendingUpdates.get(i2);
                                    int i3 = updateOp.cmd;
                                    if (i3 != 1) {
                                        if (i3 == 2) {
                                            int i4 = updateOp.positionStart;
                                            if (i4 <= i) {
                                                int i5 = updateOp.itemCount;
                                                if (i4 + i5 > i) {
                                                    return -1;
                                                }
                                                i -= i5;
                                            } else {
                                                continue;
                                            }
                                        } else if (i3 == 8) {
                                            int i6 = updateOp.positionStart;
                                            if (i6 == i) {
                                                i = updateOp.itemCount;
                                            } else {
                                                if (i6 < i) {
                                                    i--;
                                                }
                                                if (updateOp.itemCount <= i) {
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (updateOp.positionStart <= i) {
                                        i += updateOp.itemCount;
                                    }
                                }
                                return i;
                            }

                            public int getBaseline() {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager == null) {
                                    return super.getBaseline();
                                }
                                if (layoutManager != null) {
                                    return -1;
                                }
                                throw null;
                            }

                            public long getChangedHolderKey(ViewHolder viewHolder) {
                                if (this.mAdapter.mHasStableIds) {
                                    return viewHolder.mItemId;
                                }
                                return (long) viewHolder.mPosition;
                            }

                            public int getChildAdapterPosition(View view) {
                                ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                                if (childViewHolderInt != null) {
                                    return childViewHolderInt.getAdapterPosition();
                                }
                                return -1;
                            }

                            public int getChildDrawingOrder(int i, int i2) {
                                ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
                                if (childDrawingOrderCallback == null) {
                                    return super.getChildDrawingOrder(i, i2);
                                }
                                return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
                            }

                            public long getChildItemId(View view) {
                                ViewHolder childViewHolderInt;
                                Adapter adapter = this.mAdapter;
                                if (adapter == null || !adapter.mHasStableIds || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
                                    return -1;
                                }
                                return childViewHolderInt.mItemId;
                            }

                            public int getChildLayoutPosition(View view) {
                                ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                                if (childViewHolderInt != null) {
                                    return childViewHolderInt.getLayoutPosition();
                                }
                                return -1;
                            }

                            @Deprecated
                            public int getChildPosition(View view) {
                                return getChildAdapterPosition(view);
                            }

                            public ViewHolder getChildViewHolder(View view) {
                                ViewParent parent = view.getParent();
                                if (parent == null || parent == this) {
                                    return getChildViewHolderInt(view);
                                }
                                throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
                            }

                            public boolean getClipToPadding() {
                                return this.mClipToPadding;
                            }

                            public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
                                return this.mAccessibilityDelegate;
                            }

                            public void getDecoratedBoundsWithMargins(View view, Rect rect) {
                                getDecoratedBoundsWithMarginsInt(view, rect);
                            }

                            public EdgeEffectFactory getEdgeEffectFactory() {
                                return this.mEdgeEffectFactory;
                            }

                            public ItemAnimator getItemAnimator() {
                                return this.mItemAnimator;
                            }

                            public Rect getItemDecorInsetsForChild(View view) {
                                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                if (!layoutParams.mInsetsDirty) {
                                    return layoutParams.mDecorInsets;
                                }
                                if (this.mState.mInPreLayout && (layoutParams.isItemChanged() || layoutParams.mViewHolder.isInvalid())) {
                                    return layoutParams.mDecorInsets;
                                }
                                Rect rect = layoutParams.mDecorInsets;
                                rect.set(0, 0, 0, 0);
                                int size = this.mItemDecorations.size();
                                for (int i = 0; i < size; i++) {
                                    this.mTempRect.set(0, 0, 0, 0);
                                    ItemDecoration itemDecoration = this.mItemDecorations.get(i);
                                    Rect rect2 = this.mTempRect;
                                    if (itemDecoration != null) {
                                        ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                                        rect2.set(0, 0, 0, 0);
                                        int i2 = rect.left;
                                        Rect rect3 = this.mTempRect;
                                        rect.left = i2 + rect3.left;
                                        rect.top += rect3.top;
                                        rect.right += rect3.right;
                                        rect.bottom += rect3.bottom;
                                    } else {
                                        throw null;
                                    }
                                }
                                layoutParams.mInsetsDirty = false;
                                return rect;
                            }

                            public ItemDecoration getItemDecorationAt(int i) {
                                int itemDecorationCount = getItemDecorationCount();
                                if (i >= 0 && i < itemDecorationCount) {
                                    return this.mItemDecorations.get(i);
                                }
                                throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
                            }

                            public int getItemDecorationCount() {
                                return this.mItemDecorations.size();
                            }

                            public LayoutManager getLayoutManager() {
                                return this.mLayout;
                            }

                            public int getMaxFlingVelocity() {
                                return this.mMaxFlingVelocity;
                            }

                            public int getMinFlingVelocity() {
                                return this.mMinFlingVelocity;
                            }

                            public long getNanoTime() {
                                if (ALLOW_THREAD_GAP_WORK) {
                                    return System.nanoTime();
                                }
                                return 0;
                            }

                            public OnFlingListener getOnFlingListener() {
                                return this.mOnFlingListener;
                            }

                            public boolean getPreserveFocusAfterLayout() {
                                return this.mPreserveFocusAfterLayout;
                            }

                            public RecycledViewPool getRecycledViewPool() {
                                return this.mRecycler.getRecycledViewPool();
                            }

                            public int getScrollState() {
                                return this.mScrollState;
                            }

                            public boolean hasFixedSize() {
                                return this.mHasFixedSize;
                            }

                            public boolean hasNestedScrollingParent() {
                                return getScrollingChildHelper().hasNestedScrollingParent(0);
                            }

                            public boolean hasPendingAdapterUpdates() {
                                return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
                            }

                            public void initAdapterManager() {
                                this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
                                    /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass6 */

                                    public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                                        int i = updateOp.cmd;
                                        if (i == 1) {
                                            RecyclerView recyclerView = RecyclerView.this;
                                            recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
                                        } else if (i == 2) {
                                            RecyclerView recyclerView2 = RecyclerView.this;
                                            recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
                                        } else if (i == 4) {
                                            RecyclerView recyclerView3 = RecyclerView.this;
                                            recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                                        } else if (i == 8) {
                                            RecyclerView recyclerView4 = RecyclerView.this;
                                            recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
                                        }
                                    }

                                    public ViewHolder findViewHolder(int i) {
                                        ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                                        if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                                            return findViewHolderForPosition;
                                        }
                                        return null;
                                    }

                                    public void markViewHoldersUpdated(int i, int i2, Object obj) {
                                        RecyclerView.this.viewRangeUpdate(i, i2, obj);
                                        RecyclerView.this.mItemsChanged = true;
                                    }
                                });
                            }

                            public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
                                if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("Trying to set fast scroller without both required drawables.")));
                                }
                                Resources resources = getContext().getResources();
                                new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
                            }

                            public void invalidateGlows() {
                                this.mBottomGlow = null;
                                this.mTopGlow = null;
                                this.mRightGlow = null;
                                this.mLeftGlow = null;
                            }

                            public void invalidateItemDecorations() {
                                if (this.mItemDecorations.size() != 0) {
                                    LayoutManager layoutManager = this.mLayout;
                                    if (layoutManager != null) {
                                        layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
                                    }
                                    markItemDecorInsetsDirty();
                                    requestLayout();
                                }
                            }

                            public boolean isAccessibilityEnabled() {
                                AccessibilityManager accessibilityManager = this.mAccessibilityManager;
                                return accessibilityManager != null && accessibilityManager.isEnabled();
                            }

                            public boolean isAnimating() {
                                ItemAnimator itemAnimator = this.mItemAnimator;
                                return itemAnimator != null && itemAnimator.isRunning();
                            }

                            public boolean isAttachedToWindow() {
                                return this.mIsAttached;
                            }

                            public boolean isComputingLayout() {
                                return this.mLayoutOrScrollCounter > 0;
                            }

                            @Deprecated
                            public boolean isLayoutFrozen() {
                                return isLayoutSuppressed();
                            }

                            public final boolean isLayoutSuppressed() {
                                return this.mLayoutSuppressed;
                            }

                            public boolean isNestedScrollingEnabled() {
                                return getScrollingChildHelper().mIsNestedScrollingEnabled;
                            }

                            public void jumpToPositionForSmoothScroller(int i) {
                                if (this.mLayout != null) {
                                    setScrollState(2);
                                    this.mLayout.scrollToPosition(i);
                                    awakenScrollBars();
                                }
                            }

                            public void markItemDecorInsetsDirty() {
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                for (int i = 0; i < unfilteredChildCount; i++) {
                                    ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
                                }
                                Recycler recycler = this.mRecycler;
                                int size = recycler.mCachedViews.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    LayoutParams layoutParams = (LayoutParams) recycler.mCachedViews.get(i2).itemView.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.mInsetsDirty = true;
                                    }
                                }
                            }

                            public void markKnownViewsInvalid() {
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                for (int i = 0; i < unfilteredChildCount; i++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                                        childViewHolderInt.addFlags(6);
                                    }
                                }
                                markItemDecorInsetsDirty();
                                Recycler recycler = this.mRecycler;
                                int size = recycler.mCachedViews.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    ViewHolder viewHolder = recycler.mCachedViews.get(i2);
                                    if (viewHolder != null) {
                                        viewHolder.addFlags(6);
                                        viewHolder.addChangePayload(null);
                                    }
                                }
                                Adapter adapter = RecyclerView.this.mAdapter;
                                if (adapter == null || !adapter.mHasStableIds) {
                                    recycler.recycleAndClearCachedViews();
                                }
                            }

                            public void offsetChildrenHorizontal(int i) {
                                int childCount = this.mChildHelper.getChildCount();
                                for (int i2 = 0; i2 < childCount; i2++) {
                                    this.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
                                }
                            }

                            public void offsetChildrenVertical(int i) {
                                int childCount = this.mChildHelper.getChildCount();
                                for (int i2 = 0; i2 < childCount; i2++) {
                                    this.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
                                }
                            }

                            public void offsetPositionRecordsForInsert(int i, int i2) {
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
                                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                                        childViewHolderInt.offsetPosition(i2, false);
                                        this.mState.mStructureChanged = true;
                                    }
                                }
                                Recycler recycler = this.mRecycler;
                                int size = recycler.mCachedViews.size();
                                for (int i4 = 0; i4 < size; i4++) {
                                    ViewHolder viewHolder = recycler.mCachedViews.get(i4);
                                    if (viewHolder != null && viewHolder.mPosition >= i) {
                                        viewHolder.offsetPosition(i2, true);
                                    }
                                }
                                requestLayout();
                            }

                            public void offsetPositionRecordsForMove(int i, int i2) {
                                int i3;
                                int i4;
                                int i5;
                                int i6;
                                int i7;
                                int i8;
                                int i9;
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                int i10 = -1;
                                if (i < i2) {
                                    i5 = i;
                                    i4 = i2;
                                    i3 = -1;
                                } else {
                                    i4 = i;
                                    i5 = i2;
                                    i3 = 1;
                                }
                                for (int i11 = 0; i11 < unfilteredChildCount; i11++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i11));
                                    if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i5 && i9 <= i4) {
                                        if (i9 == i) {
                                            childViewHolderInt.offsetPosition(i2 - i, false);
                                        } else {
                                            childViewHolderInt.offsetPosition(i3, false);
                                        }
                                        this.mState.mStructureChanged = true;
                                    }
                                }
                                Recycler recycler = this.mRecycler;
                                if (i < i2) {
                                    i7 = i;
                                    i6 = i2;
                                } else {
                                    i6 = i;
                                    i10 = 1;
                                    i7 = i2;
                                }
                                int size = recycler.mCachedViews.size();
                                for (int i12 = 0; i12 < size; i12++) {
                                    ViewHolder viewHolder = recycler.mCachedViews.get(i12);
                                    if (viewHolder != null && (i8 = viewHolder.mPosition) >= i7 && i8 <= i6) {
                                        if (i8 == i) {
                                            viewHolder.offsetPosition(i2 - i, false);
                                        } else {
                                            viewHolder.offsetPosition(i10, false);
                                        }
                                    }
                                }
                                requestLayout();
                            }

                            public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
                                int i3 = i + i2;
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
                                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                                        int i5 = childViewHolderInt.mPosition;
                                        if (i5 >= i3) {
                                            childViewHolderInt.offsetPosition(-i2, z);
                                            this.mState.mStructureChanged = true;
                                        } else if (i5 >= i) {
                                            childViewHolderInt.addFlags(8);
                                            childViewHolderInt.offsetPosition(-i2, z);
                                            childViewHolderInt.mPosition = i - 1;
                                            this.mState.mStructureChanged = true;
                                        }
                                    }
                                }
                                Recycler recycler = this.mRecycler;
                                int size = recycler.mCachedViews.size();
                                while (true) {
                                    size--;
                                    if (size >= 0) {
                                        ViewHolder viewHolder = recycler.mCachedViews.get(size);
                                        if (viewHolder != null) {
                                            int i6 = viewHolder.mPosition;
                                            if (i6 >= i3) {
                                                viewHolder.offsetPosition(-i2, z);
                                            } else if (i6 >= i) {
                                                viewHolder.addFlags(8);
                                                recycler.recycleCachedViewAt(size);
                                            }
                                        }
                                    } else {
                                        requestLayout();
                                        return;
                                    }
                                }
                            }

                            public void onAttachedToWindow() {
                                super.onAttachedToWindow();
                                this.mLayoutOrScrollCounter = 0;
                                this.mIsAttached = true;
                                this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    layoutManager.mIsAttachedToWindow = true;
                                    layoutManager.onAttachedToWindow();
                                }
                                this.mPostedAnimatorRunner = false;
                                if (ALLOW_THREAD_GAP_WORK) {
                                    GapWorker gapWorker = GapWorker.sGapWorker.get();
                                    this.mGapWorker = gapWorker;
                                    if (gapWorker == null) {
                                        this.mGapWorker = new GapWorker();
                                        Display display = ViewCompat.getDisplay(this);
                                        float f = 60.0f;
                                        if (!isInEditMode() && display != null) {
                                            float refreshRate = display.getRefreshRate();
                                            if (refreshRate >= 30.0f) {
                                                f = refreshRate;
                                            }
                                        }
                                        GapWorker gapWorker2 = this.mGapWorker;
                                        gapWorker2.mFrameIntervalNs = (long) (1.0E9f / f);
                                        GapWorker.sGapWorker.set(gapWorker2);
                                    }
                                    this.mGapWorker.mRecyclerViews.add(this);
                                }
                            }

                            public void onChildAttachedToWindow(View view) {
                            }

                            public void onChildDetachedFromWindow(View view) {
                            }

                            public void onDetachedFromWindow() {
                                GapWorker gapWorker;
                                super.onDetachedFromWindow();
                                ItemAnimator itemAnimator = this.mItemAnimator;
                                if (itemAnimator != null) {
                                    itemAnimator.endAnimations();
                                }
                                stopScroll();
                                this.mIsAttached = false;
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    Recycler recycler = this.mRecycler;
                                    layoutManager.mIsAttachedToWindow = false;
                                    layoutManager.onDetachedFromWindow(this, recycler);
                                }
                                this.mPendingAccessibilityImportanceChange.clear();
                                removeCallbacks(this.mItemAnimatorRunner);
                                if (this.mViewInfoStore != null) {
                                    do {
                                    } while (ViewInfoStore.InfoRecord.sPool.acquire() != null);
                                    if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
                                        gapWorker.mRecyclerViews.remove(this);
                                        this.mGapWorker = null;
                                        return;
                                    }
                                    return;
                                }
                                throw null;
                            }

                            public void onDraw(Canvas canvas) {
                                super.onDraw(canvas);
                                int size = this.mItemDecorations.size();
                                for (int i = 0; i < size; i++) {
                                    this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
                                }
                            }

                            public void onEnterLayoutOrScroll() {
                                this.mLayoutOrScrollCounter++;
                            }

                            public void onExitLayoutOrScroll() {
                                onExitLayoutOrScroll(true);
                            }

                            public boolean onGenericMotionEvent(MotionEvent motionEvent) {
                                float f;
                                float f2;
                                if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
                                    if ((motionEvent.getSource() & 2) != 0) {
                                        f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                                        if (this.mLayout.canScrollHorizontally()) {
                                            f = motionEvent.getAxisValue(10);
                                            if (!(f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                                                scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                                            }
                                        }
                                    } else {
                                        if ((motionEvent.getSource() & 4194304) != 0) {
                                            float axisValue = motionEvent.getAxisValue(26);
                                            if (this.mLayout.canScrollVertically()) {
                                                f2 = -axisValue;
                                            } else if (this.mLayout.canScrollHorizontally()) {
                                                f = axisValue;
                                                f2 = 0.0f;
                                                scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                                            }
                                        }
                                        f2 = 0.0f;
                                        f = 0.0f;
                                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                                    }
                                    f = 0.0f;
                                    scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                                }
                                return false;
                            }

                            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                                boolean z;
                                if (this.mLayoutSuppressed) {
                                    return false;
                                }
                                this.mInterceptingOnItemTouchListener = null;
                                if (findInterceptingOnItemTouchListener(motionEvent)) {
                                    cancelScroll();
                                    return true;
                                }
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager == null) {
                                    return false;
                                }
                                boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                                boolean canScrollVertically = this.mLayout.canScrollVertically();
                                if (this.mVelocityTracker == null) {
                                    this.mVelocityTracker = VelocityTracker.obtain();
                                }
                                this.mVelocityTracker.addMovement(motionEvent);
                                int actionMasked = motionEvent.getActionMasked();
                                int actionIndex = motionEvent.getActionIndex();
                                if (actionMasked == 0) {
                                    if (this.mIgnoreMotionEventTillDown) {
                                        this.mIgnoreMotionEventTillDown = false;
                                    }
                                    this.mScrollPointerId = motionEvent.getPointerId(0);
                                    int x = (int) (motionEvent.getX() + 0.5f);
                                    this.mLastTouchX = x;
                                    this.mInitialTouchX = x;
                                    int y = (int) (motionEvent.getY() + 0.5f);
                                    this.mLastTouchY = y;
                                    this.mInitialTouchY = y;
                                    if (this.mScrollState == 2) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                        setScrollState(1);
                                        stopNestedScroll(1);
                                    }
                                    int[] iArr = this.mNestedOffsets;
                                    iArr[1] = 0;
                                    iArr[0] = 0;
                                    int i = canScrollHorizontally ? 1 : 0;
                                    if (canScrollVertically) {
                                        i |= 2;
                                    }
                                    startNestedScroll(i, 0);
                                } else if (actionMasked == 1) {
                                    this.mVelocityTracker.clear();
                                    stopNestedScroll(0);
                                } else if (actionMasked == 2) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                                    if (findPointerIndex < 0) {
                                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Error processing scroll; pointer index for id ");
                                        outline17.append(this.mScrollPointerId);
                                        outline17.append(" not found. Did any MotionEvents get skipped?");
                                        Log.e(TAG, outline17.toString());
                                        return false;
                                    }
                                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                                    if (this.mScrollState != 1) {
                                        int i2 = x2 - this.mInitialTouchX;
                                        int i3 = y2 - this.mInitialTouchY;
                                        if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                                            z = false;
                                        } else {
                                            this.mLastTouchX = x2;
                                            z = true;
                                        }
                                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                                            this.mLastTouchY = y2;
                                            z = true;
                                        }
                                        if (z) {
                                            setScrollState(1);
                                        }
                                    }
                                } else if (actionMasked == 3) {
                                    cancelScroll();
                                } else if (actionMasked == 5) {
                                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                    this.mLastTouchX = x3;
                                    this.mInitialTouchX = x3;
                                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                    this.mLastTouchY = y3;
                                    this.mInitialTouchY = y3;
                                } else if (actionMasked == 6) {
                                    onPointerUp(motionEvent);
                                }
                                if (this.mScrollState == 1) {
                                    return true;
                                }
                                return false;
                            }

                            public void onLayout(boolean z, int i, int i2, int i3, int i4) {
                                TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
                                dispatchLayout();
                                Trace.endSection();
                                this.mFirstLayoutComplete = true;
                            }

                            public void onMeasure(int i, int i2) {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager == null) {
                                    defaultOnMeasure(i, i2);
                                    return;
                                }
                                boolean z = false;
                                if (layoutManager.isAutoMeasureEnabled()) {
                                    int mode = View.MeasureSpec.getMode(i);
                                    int mode2 = View.MeasureSpec.getMode(i2);
                                    this.mLayout.onMeasure(i, i2);
                                    if (mode == 1073741824 && mode2 == 1073741824) {
                                        z = true;
                                    }
                                    if (!z && this.mAdapter != null) {
                                        if (this.mState.mLayoutStep == 1) {
                                            dispatchLayoutStep1();
                                        }
                                        this.mLayout.setMeasureSpecs(i, i2);
                                        this.mState.mIsMeasuring = true;
                                        dispatchLayoutStep2();
                                        this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                                        if (this.mLayout.shouldMeasureTwice()) {
                                            this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                                            this.mState.mIsMeasuring = true;
                                            dispatchLayoutStep2();
                                            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                                        }
                                    }
                                } else if (this.mHasFixedSize) {
                                    this.mLayout.onMeasure(i, i2);
                                } else {
                                    if (this.mAdapterUpdateDuringMeasure) {
                                        startInterceptRequestLayout();
                                        onEnterLayoutOrScroll();
                                        processAdapterUpdatesAndSetAnimationFlags();
                                        onExitLayoutOrScroll();
                                        State state = this.mState;
                                        if (state.mRunPredictiveAnimations) {
                                            state.mInPreLayout = true;
                                        } else {
                                            this.mAdapterHelper.consumeUpdatesInOnePass();
                                            this.mState.mInPreLayout = false;
                                        }
                                        this.mAdapterUpdateDuringMeasure = false;
                                        stopInterceptRequestLayout(false);
                                    } else if (this.mState.mRunPredictiveAnimations) {
                                        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                                        return;
                                    }
                                    Adapter adapter = this.mAdapter;
                                    if (adapter != null) {
                                        this.mState.mItemCount = adapter.getItemCount();
                                    } else {
                                        this.mState.mItemCount = 0;
                                    }
                                    startInterceptRequestLayout();
                                    this.mLayout.onMeasure(i, i2);
                                    stopInterceptRequestLayout(false);
                                    this.mState.mInPreLayout = false;
                                }
                            }

                            public boolean onRequestFocusInDescendants(int i, Rect rect) {
                                if (isComputingLayout()) {
                                    return false;
                                }
                                return super.onRequestFocusInDescendants(i, rect);
                            }

                            public void onRestoreInstanceState(Parcelable parcelable) {
                                Parcelable parcelable2;
                                if (!(parcelable instanceof SavedState)) {
                                    super.onRestoreInstanceState(parcelable);
                                    return;
                                }
                                SavedState savedState = (SavedState) parcelable;
                                this.mPendingSavedState = savedState;
                                super.onRestoreInstanceState(savedState.mSuperState);
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null && (parcelable2 = this.mPendingSavedState.mLayoutState) != null) {
                                    layoutManager.onRestoreInstanceState(parcelable2);
                                }
                            }

                            public Parcelable onSaveInstanceState() {
                                SavedState savedState = new SavedState(super.onSaveInstanceState());
                                SavedState savedState2 = this.mPendingSavedState;
                                if (savedState2 != null) {
                                    savedState.mLayoutState = savedState2.mLayoutState;
                                } else {
                                    LayoutManager layoutManager = this.mLayout;
                                    if (layoutManager != null) {
                                        savedState.mLayoutState = layoutManager.onSaveInstanceState();
                                    } else {
                                        savedState.mLayoutState = null;
                                    }
                                }
                                return savedState;
                            }

                            public void onScrollStateChanged(int i) {
                            }

                            public void onScrolled(int i, int i2) {
                            }

                            public void onSizeChanged(int i, int i2, int i3, int i4) {
                                super.onSizeChanged(i, i2, i3, i4);
                                if (i != i3 || i2 != i4) {
                                    invalidateGlows();
                                }
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:45:0x00de  */
                            /* JADX WARNING: Removed duplicated region for block: B:51:0x00f4  */
                            public boolean onTouchEvent(MotionEvent motionEvent) {
                                boolean z;
                                boolean z2 = false;
                                if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
                                    return false;
                                }
                                if (dispatchToOnItemTouchListeners(motionEvent)) {
                                    cancelScroll();
                                    return true;
                                }
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager == null) {
                                    return false;
                                }
                                boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                                boolean canScrollVertically = this.mLayout.canScrollVertically();
                                if (this.mVelocityTracker == null) {
                                    this.mVelocityTracker = VelocityTracker.obtain();
                                }
                                int actionMasked = motionEvent.getActionMasked();
                                int actionIndex = motionEvent.getActionIndex();
                                if (actionMasked == 0) {
                                    int[] iArr = this.mNestedOffsets;
                                    iArr[1] = 0;
                                    iArr[0] = 0;
                                }
                                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                                int[] iArr2 = this.mNestedOffsets;
                                obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
                                if (actionMasked == 0) {
                                    this.mScrollPointerId = motionEvent.getPointerId(0);
                                    int x = (int) (motionEvent.getX() + 0.5f);
                                    this.mLastTouchX = x;
                                    this.mInitialTouchX = x;
                                    int y = (int) (motionEvent.getY() + 0.5f);
                                    this.mLastTouchY = y;
                                    this.mInitialTouchY = y;
                                    int i = canScrollHorizontally ? 1 : 0;
                                    if (canScrollVertically) {
                                        i |= 2;
                                    }
                                    startNestedScroll(i, 0);
                                } else if (actionMasked == 1) {
                                    this.mVelocityTracker.addMovement(obtain);
                                    this.mVelocityTracker.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, (float) this.mMaxFlingVelocity);
                                    float f = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                                    float f2 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                                    if ((f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) || !fling((int) f, (int) f2)) {
                                        setScrollState(0);
                                    }
                                    resetScroll();
                                    z2 = true;
                                } else if (actionMasked == 2) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                                    if (findPointerIndex < 0) {
                                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Error processing scroll; pointer index for id ");
                                        outline17.append(this.mScrollPointerId);
                                        outline17.append(" not found. Did any MotionEvents get skipped?");
                                        Log.e(TAG, outline17.toString());
                                        return false;
                                    }
                                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                                    int i2 = this.mLastTouchX - x2;
                                    int i3 = this.mLastTouchY - y2;
                                    if (this.mScrollState != 1) {
                                        if (canScrollHorizontally) {
                                            if (i2 > 0) {
                                                i2 = Math.max(0, i2 - this.mTouchSlop);
                                            } else {
                                                i2 = Math.min(0, i2 + this.mTouchSlop);
                                            }
                                            if (i2 != 0) {
                                                z = true;
                                                if (canScrollVertically) {
                                                    if (i3 > 0) {
                                                        i3 = Math.max(0, i3 - this.mTouchSlop);
                                                    } else {
                                                        i3 = Math.min(0, i3 + this.mTouchSlop);
                                                    }
                                                    if (i3 != 0) {
                                                        z = true;
                                                    }
                                                }
                                                if (z) {
                                                    setScrollState(1);
                                                }
                                            }
                                        }
                                        z = false;
                                        if (canScrollVertically) {
                                        }
                                        if (z) {
                                        }
                                    }
                                    int i4 = i2;
                                    int i5 = i3;
                                    if (this.mScrollState == 1) {
                                        int[] iArr3 = this.mReusableIntPair;
                                        iArr3[0] = 0;
                                        iArr3[1] = 0;
                                        if (dispatchNestedPreScroll(canScrollHorizontally ? i4 : 0, canScrollVertically ? i5 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                                            int[] iArr4 = this.mReusableIntPair;
                                            i4 -= iArr4[0];
                                            i5 -= iArr4[1];
                                            int[] iArr5 = this.mNestedOffsets;
                                            int i6 = iArr5[0];
                                            int[] iArr6 = this.mScrollOffset;
                                            iArr5[0] = i6 + iArr6[0];
                                            iArr5[1] = iArr5[1] + iArr6[1];
                                            getParent().requestDisallowInterceptTouchEvent(true);
                                        }
                                        int[] iArr7 = this.mScrollOffset;
                                        this.mLastTouchX = x2 - iArr7[0];
                                        this.mLastTouchY = y2 - iArr7[1];
                                        if (scrollByInternal(canScrollHorizontally ? i4 : 0, canScrollVertically ? i5 : 0, motionEvent)) {
                                            getParent().requestDisallowInterceptTouchEvent(true);
                                        }
                                        if (!(this.mGapWorker == null || (i4 == 0 && i5 == 0))) {
                                            this.mGapWorker.postFromTraversal(this, i4, i5);
                                        }
                                    }
                                } else if (actionMasked == 3) {
                                    cancelScroll();
                                } else if (actionMasked == 5) {
                                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                    this.mLastTouchX = x3;
                                    this.mInitialTouchX = x3;
                                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                    this.mLastTouchY = y3;
                                    this.mInitialTouchY = y3;
                                } else if (actionMasked == 6) {
                                    onPointerUp(motionEvent);
                                }
                                if (!z2) {
                                    this.mVelocityTracker.addMovement(obtain);
                                }
                                obtain.recycle();
                                return true;
                            }

                            public void postAnimationRunner() {
                                if (!this.mPostedAnimatorRunner && this.mIsAttached) {
                                    ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
                                    this.mPostedAnimatorRunner = true;
                                }
                            }

                            public void processDataSetCompletelyChanged(boolean z) {
                                this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
                                this.mDataSetHasChangedAfterLayout = true;
                                markKnownViewsInvalid();
                            }

                            public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
                                viewHolder.setFlags(0, 8192);
                                if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
                                    this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(viewHolder), viewHolder);
                                }
                                this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
                            }

                            public void removeAndRecycleViews() {
                                ItemAnimator itemAnimator = this.mItemAnimator;
                                if (itemAnimator != null) {
                                    itemAnimator.endAnimations();
                                }
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    layoutManager.removeAndRecycleAllViews(this.mRecycler);
                                    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                                }
                                this.mRecycler.clear();
                            }

                            public boolean removeAnimatingView(View view) {
                                startInterceptRequestLayout();
                                ChildHelper childHelper = this.mChildHelper;
                                int indexOfChild = RecyclerView.this.indexOfChild(view);
                                boolean z = true;
                                if (indexOfChild == -1) {
                                    childHelper.unhideViewInternal(view);
                                } else if (childHelper.mBucket.get(indexOfChild)) {
                                    childHelper.mBucket.remove(indexOfChild);
                                    childHelper.unhideViewInternal(view);
                                    ((AnonymousClass5) childHelper.mCallback).removeViewAt(indexOfChild);
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                                    this.mRecycler.unscrapView(childViewHolderInt);
                                    this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
                                }
                                stopInterceptRequestLayout(!z);
                                return z;
                            }

                            public void removeDetachedView(View view, boolean z) {
                                ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                                if (childViewHolderInt != null) {
                                    if (childViewHolderInt.isTmpDetached()) {
                                        childViewHolderInt.mFlags &= -257;
                                    } else if (!childViewHolderInt.shouldIgnore()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                                        sb.append(childViewHolderInt);
                                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(this, sb));
                                    }
                                }
                                view.clearAnimation();
                                dispatchChildDetached(view);
                                super.removeDetachedView(view, z);
                            }

                            public void removeItemDecoration(ItemDecoration itemDecoration) {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager != null) {
                                    layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
                                }
                                this.mItemDecorations.remove(itemDecoration);
                                if (this.mItemDecorations.isEmpty()) {
                                    setWillNotDraw(getOverScrollMode() == 2);
                                }
                                markItemDecorInsetsDirty();
                                requestLayout();
                            }

                            public void removeItemDecorationAt(int i) {
                                int itemDecorationCount = getItemDecorationCount();
                                if (i < 0 || i >= itemDecorationCount) {
                                    throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
                                }
                                removeItemDecoration(getItemDecorationAt(i));
                            }

                            public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
                                List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
                                if (list != null) {
                                    list.remove(onChildAttachStateChangeListener);
                                }
                            }

                            public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
                                this.mOnItemTouchListeners.remove(onItemTouchListener);
                                if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
                                    this.mInterceptingOnItemTouchListener = null;
                                }
                            }

                            public void removeOnScrollListener(OnScrollListener onScrollListener) {
                                List<OnScrollListener> list = this.mScrollListeners;
                                if (list != null) {
                                    list.remove(onScrollListener);
                                }
                            }

                            public void repositionShadowingViews() {
                                ViewHolder viewHolder;
                                int childCount = this.mChildHelper.getChildCount();
                                for (int i = 0; i < childCount; i++) {
                                    View childAt = this.mChildHelper.getChildAt(i);
                                    ViewHolder childViewHolder = getChildViewHolder(childAt);
                                    if (!(childViewHolder == null || (viewHolder = childViewHolder.mShadowingHolder) == null)) {
                                        View view = viewHolder.itemView;
                                        int left = childAt.getLeft();
                                        int top = childAt.getTop();
                                        if (left != view.getLeft() || top != view.getTop()) {
                                            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                                        }
                                    }
                                }
                            }

                            public void requestChildFocus(View view, View view2) {
                                if (!this.mLayout.onRequestChildFocus1(this, view, view2) && view2 != null) {
                                    requestChildOnScreen(view, view2);
                                }
                                super.requestChildFocus(view, view2);
                            }

                            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                                return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z, false);
                            }

                            public void requestDisallowInterceptTouchEvent(boolean z) {
                                int size = this.mOnItemTouchListeners.size();
                                for (int i = 0; i < size; i++) {
                                    this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
                                }
                                super.requestDisallowInterceptTouchEvent(z);
                            }

                            public void requestLayout() {
                                if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
                                    this.mLayoutWasDefered = true;
                                } else {
                                    super.requestLayout();
                                }
                            }

                            public void saveOldPositions() {
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                for (int i = 0; i < unfilteredChildCount; i++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                                    if (!childViewHolderInt.shouldIgnore() && childViewHolderInt.mOldPosition == -1) {
                                        childViewHolderInt.mOldPosition = childViewHolderInt.mPosition;
                                    }
                                }
                            }

                            public void scrollBy(int i, int i2) {
                                LayoutManager layoutManager = this.mLayout;
                                if (layoutManager == null) {
                                    Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                                } else if (!this.mLayoutSuppressed) {
                                    boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                                    boolean canScrollVertically = this.mLayout.canScrollVertically();
                                    if (canScrollHorizontally || canScrollVertically) {
                                        if (!canScrollHorizontally) {
                                            i = 0;
                                        }
                                        if (!canScrollVertically) {
                                            i2 = 0;
                                        }
                                        scrollByInternal(i, i2, null);
                                    }
                                }
                            }

                            public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
                                int i3;
                                int i4;
                                int i5;
                                int i6;
                                consumePendingUpdateOperations();
                                if (this.mAdapter != null) {
                                    int[] iArr = this.mReusableIntPair;
                                    iArr[0] = 0;
                                    iArr[1] = 0;
                                    scrollStep(i, i2, iArr);
                                    int[] iArr2 = this.mReusableIntPair;
                                    int i7 = iArr2[0];
                                    int i8 = iArr2[1];
                                    i6 = i8;
                                    i5 = i7;
                                    i4 = i - i7;
                                    i3 = i2 - i8;
                                } else {
                                    i6 = 0;
                                    i5 = 0;
                                    i4 = 0;
                                    i3 = 0;
                                }
                                if (!this.mItemDecorations.isEmpty()) {
                                    invalidate();
                                }
                                int[] iArr3 = this.mReusableIntPair;
                                iArr3[0] = 0;
                                iArr3[1] = 0;
                                dispatchNestedScroll(i5, i6, i4, i3, this.mScrollOffset, 0, iArr3);
                                int[] iArr4 = this.mReusableIntPair;
                                int i9 = i4 - iArr4[0];
                                int i10 = i3 - iArr4[1];
                                boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
                                int i11 = this.mLastTouchX;
                                int[] iArr5 = this.mScrollOffset;
                                this.mLastTouchX = i11 - iArr5[0];
                                this.mLastTouchY -= iArr5[1];
                                int[] iArr6 = this.mNestedOffsets;
                                iArr6[0] = iArr6[0] + iArr5[0];
                                iArr6[1] = iArr6[1] + iArr5[1];
                                if (getOverScrollMode() != 2) {
                                    if (motionEvent != null) {
                                        if (!((motionEvent.getSource() & ReactTextInputManager.INPUT_TYPE_KEYBOARD_DECIMAL_PAD) == 8194)) {
                                            pullGlows(motionEvent.getX(), (float) i9, motionEvent.getY(), (float) i10);
                                        }
                                    }
                                    considerReleasingGlowsOnScroll(i, i2);
                                }
                                if (!(i5 == 0 && i6 == 0)) {
                                    dispatchOnScrolled(i5, i6);
                                }
                                if (!awakenScrollBars()) {
                                    invalidate();
                                }
                                return (!z && i5 == 0 && i6 == 0) ? false : true;
                            }

                            public void scrollStep(int i, int i2, int[] iArr) {
                                startInterceptRequestLayout();
                                onEnterLayoutOrScroll();
                                TraceCompat.beginSection(TRACE_SCROLL_TAG);
                                fillRemainingScrollValues(this.mState);
                                int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
                                int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
                                Trace.endSection();
                                repositionShadowingViews();
                                onExitLayoutOrScroll();
                                stopInterceptRequestLayout(false);
                                if (iArr != null) {
                                    iArr[0] = scrollHorizontallyBy;
                                    iArr[1] = scrollVerticallyBy;
                                }
                            }

                            public void scrollTo(int i, int i2) {
                                Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
                            }

                            public void scrollToPosition(int i) {
                                if (!this.mLayoutSuppressed) {
                                    stopScroll();
                                    LayoutManager layoutManager = this.mLayout;
                                    if (layoutManager == null) {
                                        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                                        return;
                                    }
                                    layoutManager.scrollToPosition(i);
                                    awakenScrollBars();
                                }
                            }

                            public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
                                if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
                                    super.sendAccessibilityEventUnchecked(accessibilityEvent);
                                }
                            }

                            public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
                                this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
                                ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
                            }

                            public void setAdapter(Adapter adapter) {
                                setLayoutFrozen(false);
                                setAdapterInternal(adapter, false, true);
                                processDataSetCompletelyChanged(false);
                                requestLayout();
                            }

                            public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
                                if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
                                    this.mChildDrawingOrderCallback = childDrawingOrderCallback;
                                    setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
                                }
                            }

                            public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
                                if (isComputingLayout()) {
                                    viewHolder.mPendingAccessibilityState = i;
                                    this.mPendingAccessibilityImportanceChange.add(viewHolder);
                                    return false;
                                }
                                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                                return true;
                            }

                            public void setClipToPadding(boolean z) {
                                if (z != this.mClipToPadding) {
                                    invalidateGlows();
                                }
                                this.mClipToPadding = z;
                                super.setClipToPadding(z);
                                if (this.mFirstLayoutComplete) {
                                    requestLayout();
                                }
                            }

                            public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
                                if (edgeEffectFactory != null) {
                                    this.mEdgeEffectFactory = edgeEffectFactory;
                                    invalidateGlows();
                                    return;
                                }
                                throw null;
                            }

                            public void setHasFixedSize(boolean z) {
                                this.mHasFixedSize = z;
                            }

                            public void setItemAnimator(ItemAnimator itemAnimator) {
                                ItemAnimator itemAnimator2 = this.mItemAnimator;
                                if (itemAnimator2 != null) {
                                    itemAnimator2.endAnimations();
                                    this.mItemAnimator.mListener = null;
                                }
                                this.mItemAnimator = itemAnimator;
                                if (itemAnimator != null) {
                                    itemAnimator.mListener = this.mItemAnimatorListener;
                                }
                            }

                            public void setItemViewCacheSize(int i) {
                                Recycler recycler = this.mRecycler;
                                recycler.mRequestedCacheMax = i;
                                recycler.updateViewCacheSize();
                            }

                            @Deprecated
                            public void setLayoutFrozen(boolean z) {
                                suppressLayout(z);
                            }

                            public void setLayoutManager(LayoutManager layoutManager) {
                                if (layoutManager != this.mLayout) {
                                    stopScroll();
                                    if (this.mLayout != null) {
                                        ItemAnimator itemAnimator = this.mItemAnimator;
                                        if (itemAnimator != null) {
                                            itemAnimator.endAnimations();
                                        }
                                        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                                        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                                        this.mRecycler.clear();
                                        if (this.mIsAttached) {
                                            LayoutManager layoutManager2 = this.mLayout;
                                            Recycler recycler = this.mRecycler;
                                            layoutManager2.mIsAttachedToWindow = false;
                                            layoutManager2.onDetachedFromWindow(this, recycler);
                                        }
                                        this.mLayout.setRecyclerView(null);
                                        this.mLayout = null;
                                    } else {
                                        this.mRecycler.clear();
                                    }
                                    ChildHelper childHelper = this.mChildHelper;
                                    ChildHelper.Bucket bucket = childHelper.mBucket;
                                    bucket.mData = 0;
                                    ChildHelper.Bucket bucket2 = bucket.mNext;
                                    if (bucket2 != null) {
                                        bucket2.reset();
                                    }
                                    int size = childHelper.mHiddenViews.size();
                                    while (true) {
                                        size--;
                                        if (size >= 0) {
                                            ChildHelper.Callback callback = childHelper.mCallback;
                                            View view = childHelper.mHiddenViews.get(size);
                                            AnonymousClass5 r4 = (AnonymousClass5) callback;
                                            if (r4 != null) {
                                                ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                                                if (childViewHolderInt != null) {
                                                    RecyclerView.this.setChildImportantForAccessibilityInternal(childViewHolderInt, childViewHolderInt.mWasImportantForAccessibilityBeforeHidden);
                                                    childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
                                                }
                                                childHelper.mHiddenViews.remove(size);
                                            } else {
                                                throw null;
                                            }
                                        } else {
                                            AnonymousClass5 r0 = (AnonymousClass5) childHelper.mCallback;
                                            int childCount = r0.getChildCount();
                                            for (int i = 0; i < childCount; i++) {
                                                View childAt = r0.getChildAt(i);
                                                RecyclerView.this.dispatchChildDetached(childAt);
                                                childAt.clearAnimation();
                                            }
                                            RecyclerView.this.removeAllViews();
                                            this.mLayout = layoutManager;
                                            if (layoutManager != null) {
                                                if (layoutManager.mRecyclerView == null) {
                                                    layoutManager.setRecyclerView(this);
                                                    if (this.mIsAttached) {
                                                        LayoutManager layoutManager3 = this.mLayout;
                                                        layoutManager3.mIsAttachedToWindow = true;
                                                        layoutManager3.onAttachedToWindow();
                                                    }
                                                } else {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("LayoutManager ");
                                                    sb.append(layoutManager);
                                                    sb.append(" is already attached to a RecyclerView:");
                                                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline2(layoutManager.mRecyclerView, sb));
                                                }
                                            }
                                            this.mRecycler.updateViewCacheSize();
                                            requestLayout();
                                            return;
                                        }
                                    }
                                }
                            }

                            @Deprecated
                            public void setLayoutTransition(LayoutTransition layoutTransition) {
                                if (layoutTransition == null) {
                                    super.setLayoutTransition(null);
                                    return;
                                }
                                throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
                            }

                            public void setNestedScrollingEnabled(boolean z) {
                                NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
                                if (scrollingChildHelper.mIsNestedScrollingEnabled) {
                                    ViewCompat.stopNestedScroll(scrollingChildHelper.mView);
                                }
                                scrollingChildHelper.mIsNestedScrollingEnabled = z;
                            }

                            public void setOnFlingListener(OnFlingListener onFlingListener) {
                                this.mOnFlingListener = onFlingListener;
                            }

                            @Deprecated
                            public void setOnScrollListener(OnScrollListener onScrollListener) {
                                this.mScrollListener = onScrollListener;
                            }

                            public void setPreserveFocusAfterLayout(boolean z) {
                                this.mPreserveFocusAfterLayout = z;
                            }

                            public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
                                Recycler recycler = this.mRecycler;
                                RecycledViewPool recycledViewPool2 = recycler.mRecyclerPool;
                                if (recycledViewPool2 != null) {
                                    recycledViewPool2.mAttachCount--;
                                }
                                recycler.mRecyclerPool = recycledViewPool;
                                if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                                    recycler.mRecyclerPool.mAttachCount++;
                                }
                            }

                            public void setRecyclerListener(RecyclerListener recyclerListener) {
                                this.mRecyclerListener = recyclerListener;
                            }

                            public void setScrollState(int i) {
                                if (i != this.mScrollState) {
                                    this.mScrollState = i;
                                    if (i != 2) {
                                        stopScrollersInternal();
                                    }
                                    dispatchOnScrollStateChanged(i);
                                }
                            }

                            public void setScrollingTouchSlop(int i) {
                                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                                if (i != 0) {
                                    if (i != 1) {
                                        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                                    } else {
                                        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                                        return;
                                    }
                                }
                                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                            }

                            public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
                            }

                            public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
                                int i = 0;
                                if (!isComputingLayout()) {
                                    return false;
                                }
                                int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
                                if (contentChangeTypes != 0) {
                                    i = contentChangeTypes;
                                }
                                this.mEatenAccessibilityChangeFlags |= i;
                                return true;
                            }

                            public void smoothScrollBy(int i, int i2) {
                                smoothScrollBy(i, i2, null);
                            }

                            public void smoothScrollToPosition(int i) {
                                if (!this.mLayoutSuppressed) {
                                    LayoutManager layoutManager = this.mLayout;
                                    if (layoutManager == null) {
                                        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                                    } else {
                                        layoutManager.smoothScrollToPosition(this, this.mState, i);
                                    }
                                }
                            }

                            public void startInterceptRequestLayout() {
                                int i = this.mInterceptRequestLayoutDepth + 1;
                                this.mInterceptRequestLayoutDepth = i;
                                if (i == 1 && !this.mLayoutSuppressed) {
                                    this.mLayoutWasDefered = false;
                                }
                            }

                            public boolean startNestedScroll(int i) {
                                return getScrollingChildHelper().startNestedScroll(i, 0);
                            }

                            public void stopInterceptRequestLayout(boolean z) {
                                if (this.mInterceptRequestLayoutDepth < 1) {
                                    this.mInterceptRequestLayoutDepth = 1;
                                }
                                if (!z && !this.mLayoutSuppressed) {
                                    this.mLayoutWasDefered = false;
                                }
                                if (this.mInterceptRequestLayoutDepth == 1) {
                                    if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                                        dispatchLayout();
                                    }
                                    if (!this.mLayoutSuppressed) {
                                        this.mLayoutWasDefered = false;
                                    }
                                }
                                this.mInterceptRequestLayoutDepth--;
                            }

                            public void stopNestedScroll() {
                                getScrollingChildHelper().stopNestedScroll(0);
                            }

                            public void stopScroll() {
                                setScrollState(0);
                                stopScrollersInternal();
                            }

                            public final void suppressLayout(boolean z) {
                                if (z != this.mLayoutSuppressed) {
                                    assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
                                    if (!z) {
                                        this.mLayoutSuppressed = false;
                                        if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                                            requestLayout();
                                        }
                                        this.mLayoutWasDefered = false;
                                        return;
                                    }
                                    long uptimeMillis = SystemClock.uptimeMillis();
                                    onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0));
                                    this.mLayoutSuppressed = true;
                                    this.mIgnoreMotionEventTillDown = true;
                                    stopScroll();
                                }
                            }

                            public void swapAdapter(Adapter adapter, boolean z) {
                                setLayoutFrozen(false);
                                setAdapterInternal(adapter, true, z);
                                processDataSetCompletelyChanged(true);
                                requestLayout();
                            }

                            public void viewRangeUpdate(int i, int i2, Object obj) {
                                int i3;
                                int i4;
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                int i5 = i2 + i;
                                for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
                                    View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i6);
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
                                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                                        childViewHolderInt.addFlags(2);
                                        childViewHolderInt.addChangePayload(obj);
                                        ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
                                    }
                                }
                                Recycler recycler = this.mRecycler;
                                int size = recycler.mCachedViews.size();
                                while (true) {
                                    size--;
                                    if (size >= 0) {
                                        ViewHolder viewHolder = recycler.mCachedViews.get(size);
                                        if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i5) {
                                            viewHolder.addFlags(2);
                                            recycler.recycleCachedViewAt(size);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }

                            public RecyclerView(Context context, AttributeSet attributeSet) {
                                this(context, attributeSet, R$attr.recyclerViewStyle);
                            }

                            public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
                                return getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, null);
                            }

                            public ViewHolder findViewHolderForPosition(int i, boolean z) {
                                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                                ViewHolder viewHolder = null;
                                for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
                                    if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                                        if (z) {
                                            if (childViewHolderInt.mPosition != i) {
                                                continue;
                                            }
                                        } else if (childViewHolderInt.getLayoutPosition() != i) {
                                            continue;
                                        }
                                        if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                                            return childViewHolderInt;
                                        }
                                        viewHolder = childViewHolderInt;
                                    }
                                }
                                return viewHolder;
                            }

                            public void onExitLayoutOrScroll(boolean z) {
                                int i = this.mLayoutOrScrollCounter - 1;
                                this.mLayoutOrScrollCounter = i;
                                if (i < 1) {
                                    this.mLayoutOrScrollCounter = 0;
                                    if (z) {
                                        dispatchContentChangedIfNecessary();
                                        dispatchPendingImportantForAccessibilityChanges();
                                    }
                                }
                            }

                            public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
                                smoothScrollBy(i, i2, interpolator, UNDEFINED_DURATION);
                            }

                            public static abstract class LayoutManager {
                                public boolean mAutoMeasure = false;
                                public ChildHelper mChildHelper;
                                public int mHeight;
                                public int mHeightMode;
                                public ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
                                public final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback() {
                                    /* class androidx.recyclerview.widget.RecyclerView.LayoutManager.AnonymousClass1 */

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public View getChildAt(int i) {
                                        return LayoutManager.this.getChildAt(i);
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getChildEnd(View view) {
                                        return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getChildStart(View view) {
                                        return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getParentEnd() {
                                        LayoutManager layoutManager = LayoutManager.this;
                                        return layoutManager.mWidth - layoutManager.getPaddingRight();
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getParentStart() {
                                        return LayoutManager.this.getPaddingLeft();
                                    }
                                };
                                public boolean mIsAttachedToWindow = false;
                                public boolean mItemPrefetchEnabled = true;
                                public boolean mMeasurementCacheEnabled = true;
                                public int mPrefetchMaxCountObserved;
                                public boolean mPrefetchMaxObservedInInitialPrefetch;
                                public RecyclerView mRecyclerView;
                                public boolean mRequestedSimpleAnimations = false;
                                public SmoothScroller mSmoothScroller;
                                public ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
                                public final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback() {
                                    /* class androidx.recyclerview.widget.RecyclerView.LayoutManager.AnonymousClass2 */

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public View getChildAt(int i) {
                                        return LayoutManager.this.getChildAt(i);
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getChildEnd(View view) {
                                        return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getChildStart(View view) {
                                        return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getParentEnd() {
                                        LayoutManager layoutManager = LayoutManager.this;
                                        return layoutManager.mHeight - layoutManager.getPaddingBottom();
                                    }

                                    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                                    public int getParentStart() {
                                        return LayoutManager.this.getPaddingTop();
                                    }
                                };
                                public int mWidth;
                                public int mWidthMode;

                                public interface LayoutPrefetchRegistry {
                                }

                                public static class Properties {
                                    public int orientation;
                                    public boolean reverseLayout;
                                    public int spanCount;
                                    public boolean stackFromEnd;
                                }

                                public static int chooseSize(int i, int i2, int i3) {
                                    int mode = View.MeasureSpec.getMode(i);
                                    int size = View.MeasureSpec.getSize(i);
                                    if (mode != Integer.MIN_VALUE) {
                                        return mode != 1073741824 ? Math.max(i2, i3) : size;
                                    }
                                    return Math.min(size, Math.max(i2, i3));
                                }

                                /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
                                    if (r5 == 1073741824) goto L_0x0020;
                                 */
                                public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
                                    int max = Math.max(0, i - i3);
                                    if (z) {
                                        if (i4 < 0) {
                                            if (i4 == -1) {
                                                if (i2 != Integer.MIN_VALUE) {
                                                    if (i2 != 0) {
                                                    }
                                                }
                                                i4 = max;
                                                return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                            }
                                            i2 = 0;
                                            i4 = 0;
                                            return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                        }
                                    } else if (i4 < 0) {
                                        if (i4 != -1) {
                                            if (i4 == -2) {
                                                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                                    i4 = max;
                                                    i2 = Integer.MIN_VALUE;
                                                } else {
                                                    i4 = max;
                                                    i2 = 0;
                                                }
                                                return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                            }
                                            i2 = 0;
                                            i4 = 0;
                                            return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                        }
                                        i4 = max;
                                        return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                    }
                                    i2 = 1073741824;
                                    return View.MeasureSpec.makeMeasureSpec(i4, i2);
                                }

                                public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
                                    Properties properties = new Properties();
                                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
                                    properties.orientation = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
                                    properties.spanCount = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
                                    properties.reverseLayout = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
                                    properties.stackFromEnd = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
                                    obtainStyledAttributes.recycle();
                                    return properties;
                                }

                                public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
                                    int mode = View.MeasureSpec.getMode(i2);
                                    int size = View.MeasureSpec.getSize(i2);
                                    if (i3 > 0 && i != i3) {
                                        return false;
                                    }
                                    if (mode == Integer.MIN_VALUE) {
                                        return size >= i;
                                    }
                                    if (mode != 0) {
                                        return mode == 1073741824 && size == i;
                                    }
                                    return true;
                                }

                                public void addView(View view) {
                                    addViewInt(view, -1, false);
                                }

                                public final void addViewInt(View view, int i, boolean z) {
                                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                    if (z || childViewHolderInt.isRemoved()) {
                                        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
                                    } else {
                                        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                                    }
                                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                    if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                                        if (childViewHolderInt.isScrap()) {
                                            childViewHolderInt.mScrapContainer.unscrapView(childViewHolderInt);
                                        } else {
                                            childViewHolderInt.clearReturnedFromScrapFlag();
                                        }
                                        this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
                                    } else if (view.getParent() == this.mRecyclerView) {
                                        int indexOfChild = this.mChildHelper.indexOfChild(view);
                                        if (i == -1) {
                                            i = this.mChildHelper.getChildCount();
                                        }
                                        if (indexOfChild == -1) {
                                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                                            outline17.append(this.mRecyclerView.indexOfChild(view));
                                            throw new IllegalStateException(GeneratedOutlineSupport.outline2(this.mRecyclerView, outline17));
                                        } else if (indexOfChild != i) {
                                            LayoutManager layoutManager = this.mRecyclerView.mLayout;
                                            View childAt = layoutManager.getChildAt(indexOfChild);
                                            if (childAt != null) {
                                                layoutManager.getChildAt(indexOfChild);
                                                layoutManager.detachViewInternal(indexOfChild);
                                                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                                                ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(childAt);
                                                if (childViewHolderInt2.isRemoved()) {
                                                    layoutManager.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt2);
                                                } else {
                                                    layoutManager.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt2);
                                                }
                                                layoutManager.mChildHelper.attachViewToParent(childAt, i, layoutParams2, childViewHolderInt2.isRemoved());
                                            } else {
                                                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild + layoutManager.mRecyclerView.toString());
                                            }
                                        }
                                    } else {
                                        this.mChildHelper.addView(view, i, false);
                                        layoutParams.mInsetsDirty = true;
                                        SmoothScroller smoothScroller = this.mSmoothScroller;
                                        if (smoothScroller != null && smoothScroller.mRunning && smoothScroller.mRecyclerView.getChildLayoutPosition(view) == smoothScroller.mTargetPosition) {
                                            smoothScroller.mTargetView = view;
                                        }
                                    }
                                    if (layoutParams.mPendingInvalidate) {
                                        childViewHolderInt.itemView.invalidate();
                                        layoutParams.mPendingInvalidate = false;
                                    }
                                }

                                public void assertNotInLayoutOrScroll(String str) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        recyclerView.assertNotInLayoutOrScroll(str);
                                    }
                                }

                                public boolean canScrollHorizontally() {
                                    return false;
                                }

                                public boolean canScrollVertically() {
                                    return false;
                                }

                                public boolean checkLayoutParams(LayoutParams layoutParams) {
                                    return layoutParams != null;
                                }

                                public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
                                }

                                public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
                                }

                                public int computeHorizontalScrollExtent(State state) {
                                    return 0;
                                }

                                public int computeHorizontalScrollOffset(State state) {
                                    return 0;
                                }

                                public int computeHorizontalScrollRange(State state) {
                                    return 0;
                                }

                                public int computeVerticalScrollExtent(State state) {
                                    return 0;
                                }

                                public int computeVerticalScrollOffset(State state) {
                                    return 0;
                                }

                                public int computeVerticalScrollRange(State state) {
                                    return 0;
                                }

                                public void detachAndScrapAttachedViews(Recycler recycler) {
                                    int childCount = getChildCount();
                                    while (true) {
                                        childCount--;
                                        if (childCount >= 0) {
                                            View childAt = getChildAt(childCount);
                                            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                                            if (!childViewHolderInt.shouldIgnore()) {
                                                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.mHasStableIds) {
                                                    getChildAt(childCount);
                                                    detachViewInternal(childCount);
                                                    recycler.scrapView(childAt);
                                                    this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                                                } else {
                                                    removeViewAt(childCount);
                                                    recycler.recycleViewHolderInternal(childViewHolderInt);
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }

                                public final void detachViewInternal(int i) {
                                    this.mChildHelper.detachViewFromParent(i);
                                }

                                public View findContainingItemView(View view) {
                                    View findContainingItemView;
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.mHiddenViews.contains(findContainingItemView)) {
                                        return null;
                                    }
                                    return findContainingItemView;
                                }

                                public View findViewByPosition(int i) {
                                    int childCount = getChildCount();
                                    for (int i2 = 0; i2 < childCount; i2++) {
                                        View childAt = getChildAt(i2);
                                        ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                                        if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mInPreLayout || !childViewHolderInt.isRemoved())) {
                                            return childAt;
                                        }
                                    }
                                    return null;
                                }

                                public abstract LayoutParams generateDefaultLayoutParams();

                                public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
                                    if (layoutParams instanceof LayoutParams) {
                                        return new LayoutParams((LayoutParams) layoutParams);
                                    }
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                                    }
                                    return new LayoutParams(layoutParams);
                                }

                                public View getChildAt(int i) {
                                    ChildHelper childHelper = this.mChildHelper;
                                    if (childHelper == null) {
                                        return null;
                                    }
                                    return ((AnonymousClass5) childHelper.mCallback).getChildAt(childHelper.getOffset(i));
                                }

                                public int getChildCount() {
                                    ChildHelper childHelper = this.mChildHelper;
                                    if (childHelper != null) {
                                        return childHelper.getChildCount();
                                    }
                                    return 0;
                                }

                                public int getColumnCountForAccessibility(Recycler recycler, State state) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                                        return 1;
                                    }
                                    return this.mRecyclerView.mAdapter.getItemCount();
                                }

                                public int getDecoratedBottom(View view) {
                                    return view.getBottom() + ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
                                }

                                public int getDecoratedLeft(View view) {
                                    return view.getLeft() - ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
                                }

                                public int getDecoratedMeasuredHeight(View view) {
                                    Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                                    return view.getMeasuredHeight() + rect.top + rect.bottom;
                                }

                                public int getDecoratedMeasuredWidth(View view) {
                                    Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                                    return view.getMeasuredWidth() + rect.left + rect.right;
                                }

                                public int getDecoratedRight(View view) {
                                    return view.getRight() + ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
                                }

                                public int getDecoratedTop(View view) {
                                    return view.getTop() - ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
                                }

                                public View getFocusedChild() {
                                    View focusedChild;
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.mHiddenViews.contains(focusedChild)) {
                                        return null;
                                    }
                                    return focusedChild;
                                }

                                public int getLayoutDirection() {
                                    return ViewCompat.getLayoutDirection(this.mRecyclerView);
                                }

                                public int getMinimumHeight() {
                                    return ViewCompat.getMinimumHeight(this.mRecyclerView);
                                }

                                public int getMinimumWidth() {
                                    return ViewCompat.getMinimumWidth(this.mRecyclerView);
                                }

                                public int getPaddingBottom() {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        return recyclerView.getPaddingBottom();
                                    }
                                    return 0;
                                }

                                public int getPaddingLeft() {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        return recyclerView.getPaddingLeft();
                                    }
                                    return 0;
                                }

                                public int getPaddingRight() {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        return recyclerView.getPaddingRight();
                                    }
                                    return 0;
                                }

                                public int getPaddingTop() {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        return recyclerView.getPaddingTop();
                                    }
                                    return 0;
                                }

                                public int getPosition(View view) {
                                    return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                                }

                                public int getRowCountForAccessibility(Recycler recycler, State state) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                                        return 1;
                                    }
                                    return this.mRecyclerView.mAdapter.getItemCount();
                                }

                                public int getSelectionModeForAccessibility() {
                                    return 0;
                                }

                                public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
                                    Matrix matrix;
                                    if (z) {
                                        Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                                        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
                                    } else {
                                        rect.set(0, 0, view.getWidth(), view.getHeight());
                                    }
                                    if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                                        RectF rectF = this.mRecyclerView.mTempRectF;
                                        rectF.set(rect);
                                        matrix.mapRect(rectF);
                                        rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                                    }
                                    rect.offset(view.getLeft(), view.getTop());
                                }

                                public boolean isAutoMeasureEnabled() {
                                    return this.mAutoMeasure;
                                }

                                public boolean isLayoutHierarchical() {
                                    return false;
                                }

                                public boolean isViewPartiallyVisible(View view, boolean z) {
                                    boolean z2 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
                                    return z ? z2 : !z2;
                                }

                                public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
                                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                    Rect rect = layoutParams.mDecorInsets;
                                    view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                                }

                                public void offsetChildrenHorizontal(int i) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        recyclerView.offsetChildrenHorizontal(i);
                                    }
                                }

                                public void offsetChildrenVertical(int i) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        recyclerView.offsetChildrenVertical(i);
                                    }
                                }

                                public void onAdapterChanged() {
                                }

                                /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList<Landroid/view/View;>;II)Z */
                                public boolean onAddFocusables() {
                                    return false;
                                }

                                public void onAttachedToWindow() {
                                }

                                @Deprecated
                                public void onDetachedFromWindow() {
                                }

                                public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
                                    onDetachedFromWindow();
                                }

                                public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
                                    return null;
                                }

                                public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    Recycler recycler = recyclerView.mRecycler;
                                    State state = recyclerView.mState;
                                    onInitializeAccessibilityEvent1(accessibilityEvent);
                                }

                                public void onInitializeAccessibilityEvent1(AccessibilityEvent accessibilityEvent) {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null && accessibilityEvent != null) {
                                        boolean z = true;
                                        if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                                            z = false;
                                        }
                                        accessibilityEvent.setScrollable(z);
                                        Adapter adapter = this.mRecyclerView.mAdapter;
                                        if (adapter != null) {
                                            accessibilityEvent.setItemCount(adapter.getItemCount());
                                        }
                                    }
                                }

                                public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                    if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                                        RecyclerView recyclerView = this.mRecyclerView;
                                        onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
                                    }
                                }

                                public View onInterceptFocusSearch() {
                                    return null;
                                }

                                public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
                                }

                                public void onItemsChanged(RecyclerView recyclerView) {
                                }

                                public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
                                }

                                public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
                                }

                                public void onItemsUpdated() {
                                }

                                public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
                                    onItemsUpdated();
                                }

                                public void onLayoutChildren(Recycler recycler, State state) {
                                    Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
                                }

                                public void onLayoutCompleted(State state) {
                                }

                                public void onMeasure(int i, int i2) {
                                    this.mRecyclerView.defaultOnMeasure(i, i2);
                                }

                                @Deprecated
                                public boolean onRequestChildFocus(RecyclerView recyclerView) {
                                    SmoothScroller smoothScroller = this.mSmoothScroller;
                                    return (smoothScroller != null && smoothScroller.mRunning) || recyclerView.isComputingLayout();
                                }

                                public boolean onRequestChildFocus1(RecyclerView recyclerView, View view, View view2) {
                                    return onRequestChildFocus(recyclerView);
                                }

                                public void onRestoreInstanceState(Parcelable parcelable) {
                                }

                                public Parcelable onSaveInstanceState() {
                                    return null;
                                }

                                public void onScrollStateChanged(int i) {
                                }

                                /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[ADDED_TO_REGION] */
                                public boolean performAccessibilityAction(int i) {
                                    int i2;
                                    int i3;
                                    int i4;
                                    int i5;
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView == null) {
                                        return false;
                                    }
                                    if (i == 4096) {
                                        i4 = recyclerView.canScrollVertically(1) ? (this.mHeight - getPaddingTop()) - getPaddingBottom() : 0;
                                        if (this.mRecyclerView.canScrollHorizontally(1)) {
                                            i5 = (this.mWidth - getPaddingLeft()) - getPaddingRight();
                                        }
                                        i2 = i4;
                                        i3 = 0;
                                        if (i2 != 0) {
                                        }
                                        this.mRecyclerView.smoothScrollBy(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
                                        return true;
                                    } else if (i != 8192) {
                                        i3 = 0;
                                        i2 = 0;
                                        if (i2 != 0 && i3 == 0) {
                                            return false;
                                        }
                                        this.mRecyclerView.smoothScrollBy(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
                                        return true;
                                    } else {
                                        i4 = recyclerView.canScrollVertically(-1) ? -((this.mHeight - getPaddingTop()) - getPaddingBottom()) : 0;
                                        if (this.mRecyclerView.canScrollHorizontally(-1)) {
                                            i5 = -((this.mWidth - getPaddingLeft()) - getPaddingRight());
                                        }
                                        i2 = i4;
                                        i3 = 0;
                                        if (i2 != 0) {
                                        }
                                        this.mRecyclerView.smoothScrollBy(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
                                        return true;
                                    }
                                    i3 = i5;
                                    i2 = i4;
                                    if (i2 != 0) {
                                    }
                                    this.mRecyclerView.smoothScrollBy(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
                                    return true;
                                }

                                public boolean performAccessibilityActionForItem() {
                                    return false;
                                }

                                public void removeAndRecycleAllViews(Recycler recycler) {
                                    for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                                        if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                                            removeAndRecycleViewAt(childCount, recycler);
                                        }
                                    }
                                }

                                public void removeAndRecycleScrapInt(Recycler recycler) {
                                    int size = recycler.mAttachedScrap.size();
                                    for (int i = size - 1; i >= 0; i--) {
                                        View view = recycler.mAttachedScrap.get(i).itemView;
                                        ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                        if (!childViewHolderInt.shouldIgnore()) {
                                            childViewHolderInt.setIsRecyclable(false);
                                            if (childViewHolderInt.isTmpDetached()) {
                                                this.mRecyclerView.removeDetachedView(view, false);
                                            }
                                            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                                            if (itemAnimator != null) {
                                                itemAnimator.endAnimation(childViewHolderInt);
                                            }
                                            childViewHolderInt.setIsRecyclable(true);
                                            ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                                            childViewHolderInt2.mScrapContainer = null;
                                            childViewHolderInt2.mInChangeScrap = false;
                                            childViewHolderInt2.clearReturnedFromScrapFlag();
                                            recycler.recycleViewHolderInternal(childViewHolderInt2);
                                        }
                                    }
                                    recycler.mAttachedScrap.clear();
                                    ArrayList<ViewHolder> arrayList = recycler.mChangedScrap;
                                    if (arrayList != null) {
                                        arrayList.clear();
                                    }
                                    if (size > 0) {
                                        this.mRecyclerView.invalidate();
                                    }
                                }

                                public void removeAndRecycleView(View view, Recycler recycler) {
                                    ChildHelper childHelper = this.mChildHelper;
                                    int indexOfChild = RecyclerView.this.indexOfChild(view);
                                    if (indexOfChild >= 0) {
                                        if (childHelper.mBucket.remove(indexOfChild)) {
                                            childHelper.unhideViewInternal(view);
                                        }
                                        ((AnonymousClass5) childHelper.mCallback).removeViewAt(indexOfChild);
                                    }
                                    recycler.recycleView(view);
                                }

                                public void removeAndRecycleViewAt(int i, Recycler recycler) {
                                    View childAt = getChildAt(i);
                                    removeViewAt(i);
                                    recycler.recycleView(childAt);
                                }

                                public void removeViewAt(int i) {
                                    ChildHelper childHelper;
                                    int offset;
                                    View childAt;
                                    if (getChildAt(i) != null && (childAt = ((AnonymousClass5) childHelper.mCallback).getChildAt((offset = (childHelper = this.mChildHelper).getOffset(i)))) != null) {
                                        if (childHelper.mBucket.remove(offset)) {
                                            childHelper.unhideViewInternal(childAt);
                                        }
                                        ((AnonymousClass5) childHelper.mCallback).removeViewAt(offset);
                                    }
                                }

                                /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b3, code lost:
                                    if (r14 == false) goto L_0x00ba;
                                 */
                                public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                                    boolean z3;
                                    int[] iArr = new int[2];
                                    int paddingLeft = getPaddingLeft();
                                    int paddingTop = getPaddingTop();
                                    int paddingRight = this.mWidth - getPaddingRight();
                                    int paddingBottom = this.mHeight - getPaddingBottom();
                                    int left = (view.getLeft() + rect.left) - view.getScrollX();
                                    int top = (view.getTop() + rect.top) - view.getScrollY();
                                    int width = rect.width() + left;
                                    int height = rect.height() + top;
                                    int i = left - paddingLeft;
                                    int min = Math.min(0, i);
                                    int i2 = top - paddingTop;
                                    int min2 = Math.min(0, i2);
                                    int i3 = width - paddingRight;
                                    int max = Math.max(0, i3);
                                    int max2 = Math.max(0, height - paddingBottom);
                                    if (getLayoutDirection() != 1) {
                                        if (min == 0) {
                                            min = Math.min(i, max);
                                        }
                                        max = min;
                                    } else if (max == 0) {
                                        max = Math.max(min, i3);
                                    }
                                    if (min2 == 0) {
                                        min2 = Math.min(i2, max2);
                                    }
                                    iArr[0] = max;
                                    iArr[1] = min2;
                                    int i4 = iArr[0];
                                    int i5 = iArr[1];
                                    if (z2) {
                                        View focusedChild = recyclerView.getFocusedChild();
                                        if (focusedChild != null) {
                                            int paddingLeft2 = getPaddingLeft();
                                            int paddingTop2 = getPaddingTop();
                                            int paddingRight2 = this.mWidth - getPaddingRight();
                                            int paddingBottom2 = this.mHeight - getPaddingBottom();
                                            Rect rect2 = this.mRecyclerView.mTempRect;
                                            RecyclerView.getDecoratedBoundsWithMarginsInt(focusedChild, rect2);
                                            if (rect2.left - i4 < paddingRight2 && rect2.right - i4 > paddingLeft2 && rect2.top - i5 < paddingBottom2 && rect2.bottom - i5 > paddingTop2) {
                                                z3 = true;
                                            }
                                        }
                                        z3 = false;
                                    }
                                    if (!(i4 == 0 && i5 == 0)) {
                                        if (z) {
                                            recyclerView.scrollBy(i4, i5);
                                        } else {
                                            recyclerView.smoothScrollBy(i4, i5);
                                        }
                                        return true;
                                    }
                                    return false;
                                }

                                public void requestLayout() {
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (recyclerView != null) {
                                        recyclerView.requestLayout();
                                    }
                                }

                                public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
                                    return 0;
                                }

                                public void scrollToPosition(int i) {
                                }

                                public int scrollVerticallyBy(int i, Recycler recycler, State state) {
                                    return 0;
                                }

                                public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
                                    setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
                                }

                                public void setMeasureSpecs(int i, int i2) {
                                    this.mWidth = View.MeasureSpec.getSize(i);
                                    int mode = View.MeasureSpec.getMode(i);
                                    this.mWidthMode = mode;
                                    if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                                        this.mWidth = 0;
                                    }
                                    this.mHeight = View.MeasureSpec.getSize(i2);
                                    int mode2 = View.MeasureSpec.getMode(i2);
                                    this.mHeightMode = mode2;
                                    if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                                        this.mHeight = 0;
                                    }
                                }

                                public void setMeasuredDimension(Rect rect, int i, int i2) {
                                    int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
                                    int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
                                    this.mRecyclerView.setMeasuredDimension(chooseSize(i, paddingRight, getMinimumWidth()), chooseSize(i2, paddingBottom, getMinimumHeight()));
                                }

                                public void setMeasuredDimensionFromChildren(int i, int i2) {
                                    int childCount = getChildCount();
                                    if (childCount == 0) {
                                        this.mRecyclerView.defaultOnMeasure(i, i2);
                                        return;
                                    }
                                    int i3 = RecyclerView.UNDEFINED_DURATION;
                                    int i4 = Integer.MAX_VALUE;
                                    int i5 = Integer.MAX_VALUE;
                                    int i6 = Integer.MIN_VALUE;
                                    for (int i7 = 0; i7 < childCount; i7++) {
                                        View childAt = getChildAt(i7);
                                        Rect rect = this.mRecyclerView.mTempRect;
                                        RecyclerView.getDecoratedBoundsWithMarginsInt(childAt, rect);
                                        int i8 = rect.left;
                                        if (i8 < i4) {
                                            i4 = i8;
                                        }
                                        int i9 = rect.right;
                                        if (i9 > i3) {
                                            i3 = i9;
                                        }
                                        int i10 = rect.top;
                                        if (i10 < i5) {
                                            i5 = i10;
                                        }
                                        int i11 = rect.bottom;
                                        if (i11 > i6) {
                                            i6 = i11;
                                        }
                                    }
                                    this.mRecyclerView.mTempRect.set(i4, i5, i3, i6);
                                    setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
                                }

                                public void setRecyclerView(RecyclerView recyclerView) {
                                    if (recyclerView == null) {
                                        this.mRecyclerView = null;
                                        this.mChildHelper = null;
                                        this.mWidth = 0;
                                        this.mHeight = 0;
                                    } else {
                                        this.mRecyclerView = recyclerView;
                                        this.mChildHelper = recyclerView.mChildHelper;
                                        this.mWidth = recyclerView.getWidth();
                                        this.mHeight = recyclerView.getHeight();
                                    }
                                    this.mWidthMode = 1073741824;
                                    this.mHeightMode = 1073741824;
                                }

                                public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
                                    return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                                }

                                public boolean shouldMeasureTwice() {
                                    return false;
                                }

                                public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
                                    return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                                }

                                public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
                                    Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
                                }

                                public void startSmoothScroll(SmoothScroller smoothScroller) {
                                    SmoothScroller smoothScroller2 = this.mSmoothScroller;
                                    if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.mRunning)) {
                                        smoothScroller2.stop();
                                    }
                                    this.mSmoothScroller = smoothScroller;
                                    RecyclerView recyclerView = this.mRecyclerView;
                                    if (smoothScroller != null) {
                                        recyclerView.mViewFlinger.stop();
                                        if (smoothScroller.mStarted) {
                                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("An instance of ");
                                            outline17.append(smoothScroller.getClass().getSimpleName());
                                            outline17.append(" was started more than once. Each instance of");
                                            outline17.append(smoothScroller.getClass().getSimpleName());
                                            outline17.append(" is intended to only be used once. You should create a new instance for each use.");
                                            Log.w(RecyclerView.TAG, outline17.toString());
                                        }
                                        smoothScroller.mRecyclerView = recyclerView;
                                        smoothScroller.mLayoutManager = this;
                                        int i = smoothScroller.mTargetPosition;
                                        if (i != -1) {
                                            recyclerView.mState.mTargetPosition = i;
                                            smoothScroller.mRunning = true;
                                            smoothScroller.mPendingInitialRun = true;
                                            smoothScroller.mTargetView = recyclerView.mLayout.findViewByPosition(i);
                                            smoothScroller.mRecyclerView.mViewFlinger.postOnAnimation();
                                            smoothScroller.mStarted = true;
                                            return;
                                        }
                                        throw new IllegalArgumentException("Invalid target position");
                                    }
                                    throw null;
                                }

                                public boolean supportsPredictiveItemAnimations() {
                                    return false;
                                }

                                public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                                    int i = 0;
                                    int position = canScrollVertically() ? getPosition(view) : 0;
                                    if (canScrollHorizontally()) {
                                        i = getPosition(view);
                                    }
                                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(position, 1, i, 1, false, false));
                                }

                                public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
                                    return new LayoutParams(context, attributeSet);
                                }
                            }

                            public RecyclerView(Context context, AttributeSet attributeSet, int i) {
                                super(context, attributeSet, i);
                                float f;
                                this.mObserver = new RecyclerViewDataObserver();
                                this.mRecycler = new Recycler();
                                this.mViewInfoStore = new ViewInfoStore();
                                this.mUpdateChildViewsRunnable = new Runnable() {
                                    /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass1 */

                                    public void run() {
                                        RecyclerView recyclerView = RecyclerView.this;
                                        if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                                            RecyclerView recyclerView2 = RecyclerView.this;
                                            if (!recyclerView2.mIsAttached) {
                                                recyclerView2.requestLayout();
                                            } else if (recyclerView2.mLayoutSuppressed) {
                                                recyclerView2.mLayoutWasDefered = true;
                                            } else {
                                                recyclerView2.consumePendingUpdateOperations();
                                            }
                                        }
                                    }
                                };
                                this.mTempRect = new Rect();
                                this.mTempRect2 = new Rect();
                                this.mTempRectF = new RectF();
                                this.mItemDecorations = new ArrayList<>();
                                this.mOnItemTouchListeners = new ArrayList<>();
                                this.mInterceptRequestLayoutDepth = 0;
                                this.mDataSetHasChangedAfterLayout = false;
                                this.mDispatchItemsChangedEvent = false;
                                this.mLayoutOrScrollCounter = 0;
                                this.mDispatchScrollCounter = 0;
                                this.mEdgeEffectFactory = new EdgeEffectFactory();
                                this.mItemAnimator = new DefaultItemAnimator();
                                this.mScrollState = 0;
                                this.mScrollPointerId = -1;
                                this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
                                this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
                                this.mPreserveFocusAfterLayout = true;
                                this.mViewFlinger = new ViewFlinger();
                                this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
                                this.mState = new State();
                                this.mItemsAddedOrRemoved = false;
                                this.mItemsChanged = false;
                                this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
                                this.mPostedAnimatorRunner = false;
                                this.mMinMaxLayoutPositions = new int[2];
                                this.mScrollOffset = new int[2];
                                this.mNestedOffsets = new int[2];
                                this.mReusableIntPair = new int[2];
                                this.mPendingAccessibilityImportanceChange = new ArrayList();
                                this.mItemAnimatorRunner = new Runnable() {
                                    /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass2 */

                                    public void run() {
                                        ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                                        if (itemAnimator != null) {
                                            DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                                            boolean z = !defaultItemAnimator.mPendingRemovals.isEmpty();
                                            boolean z2 = !defaultItemAnimator.mPendingMoves.isEmpty();
                                            boolean z3 = !defaultItemAnimator.mPendingChanges.isEmpty();
                                            boolean z4 = !defaultItemAnimator.mPendingAdditions.isEmpty();
                                            if (z || z2 || z4 || z3) {
                                                Iterator<ViewHolder> it = defaultItemAnimator.mPendingRemovals.iterator();
                                                while (it.hasNext()) {
                                                    ViewHolder next = it.next();
                                                    View view = next.itemView;
                                                    ViewPropertyAnimator animate = view.animate();
                                                    defaultItemAnimator.mRemoveAnimations.add(next);
                                                    animate.setDuration(defaultItemAnimator.mRemoveDuration).alpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER).setListener(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: INVOKE  
                                                          (wrap: android.view.ViewPropertyAnimator : 0x0060: INVOKE  (r7v14 android.view.ViewPropertyAnimator) = 
                                                          (wrap: android.view.ViewPropertyAnimator : 0x0057: INVOKE  (r10v3 android.view.ViewPropertyAnimator) = 
                                                          (wrap: android.view.ViewPropertyAnimator : 0x0052: INVOKE  (r10v2 android.view.ViewPropertyAnimator) = 
                                                          (r9v3 'animate' android.view.ViewPropertyAnimator)
                                                          (wrap: long : 0x0050: IGET  (r10v1 long) = (r0v3 'defaultItemAnimator' androidx.recyclerview.widget.DefaultItemAnimator) androidx.recyclerview.widget.RecyclerView.ItemAnimator.mRemoveDuration long)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.setDuration(long):android.view.ViewPropertyAnimator)
                                                          (wrap: float : ?: SGET   com.facebook.react.uimanager.BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER float)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.alpha(float):android.view.ViewPropertyAnimator)
                                                          (wrap: androidx.recyclerview.widget.DefaultItemAnimator$4 : 0x005d: CONSTRUCTOR  (r11v1 androidx.recyclerview.widget.DefaultItemAnimator$4) = 
                                                          (r0v3 'defaultItemAnimator' androidx.recyclerview.widget.DefaultItemAnimator)
                                                          (r7v13 'next' androidx.recyclerview.widget.RecyclerView$ViewHolder)
                                                          (r9v3 'animate' android.view.ViewPropertyAnimator)
                                                          (r8v2 'view' android.view.View)
                                                         call: androidx.recyclerview.widget.DefaultItemAnimator.4.<init>(androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView$ViewHolder, android.view.ViewPropertyAnimator, android.view.View):void type: CONSTRUCTOR)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.setListener(android.animation.Animator$AnimatorListener):android.view.ViewPropertyAnimator)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.start():void in method: androidx.recyclerview.widget.RecyclerView.2.run():void, file: classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: INVOKE  (r7v14 android.view.ViewPropertyAnimator) = 
                                                          (wrap: android.view.ViewPropertyAnimator : 0x0057: INVOKE  (r10v3 android.view.ViewPropertyAnimator) = 
                                                          (wrap: android.view.ViewPropertyAnimator : 0x0052: INVOKE  (r10v2 android.view.ViewPropertyAnimator) = 
                                                          (r9v3 'animate' android.view.ViewPropertyAnimator)
                                                          (wrap: long : 0x0050: IGET  (r10v1 long) = (r0v3 'defaultItemAnimator' androidx.recyclerview.widget.DefaultItemAnimator) androidx.recyclerview.widget.RecyclerView.ItemAnimator.mRemoveDuration long)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.setDuration(long):android.view.ViewPropertyAnimator)
                                                          (wrap: float : ?: SGET   com.facebook.react.uimanager.BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER float)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.alpha(float):android.view.ViewPropertyAnimator)
                                                          (wrap: androidx.recyclerview.widget.DefaultItemAnimator$4 : 0x005d: CONSTRUCTOR  (r11v1 androidx.recyclerview.widget.DefaultItemAnimator$4) = 
                                                          (r0v3 'defaultItemAnimator' androidx.recyclerview.widget.DefaultItemAnimator)
                                                          (r7v13 'next' androidx.recyclerview.widget.RecyclerView$ViewHolder)
                                                          (r9v3 'animate' android.view.ViewPropertyAnimator)
                                                          (r8v2 'view' android.view.View)
                                                         call: androidx.recyclerview.widget.DefaultItemAnimator.4.<init>(androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView$ViewHolder, android.view.ViewPropertyAnimator, android.view.View):void type: CONSTRUCTOR)
                                                         type: VIRTUAL call: android.view.ViewPropertyAnimator.setListener(android.animation.Animator$AnimatorListener):android.view.ViewPropertyAnimator in method: androidx.recyclerview.widget.RecyclerView.2.run():void, file: classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 29 more
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005d: CONSTRUCTOR  (r11v1 androidx.recyclerview.widget.DefaultItemAnimator$4) = 
                                                          (r0v3 'defaultItemAnimator' androidx.recyclerview.widget.DefaultItemAnimator)
                                                          (r7v13 'next' androidx.recyclerview.widget.RecyclerView$ViewHolder)
                                                          (r9v3 'animate' android.view.ViewPropertyAnimator)
                                                          (r8v2 'view' android.view.View)
                                                         call: androidx.recyclerview.widget.DefaultItemAnimator.4.<init>(androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView$ViewHolder, android.view.ViewPropertyAnimator, android.view.View):void type: CONSTRUCTOR in method: androidx.recyclerview.widget.RecyclerView.2.run():void, file: classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 35 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.recyclerview.widget.DefaultItemAnimator, state: GENERATED_AND_UNLOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 41 more
                                                        */
                                                    /*
                                                    // Method dump skipped, instructions count: 282
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AnonymousClass2.run():void");
                                                }
                                            };
                                            this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
                                                /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass4 */
                                            };
                                            setScrollContainer(true);
                                            setFocusableInTouchMode(true);
                                            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                                            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                                            this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
                                            if (Build.VERSION.SDK_INT >= 26) {
                                                f = viewConfiguration.getScaledVerticalScrollFactor();
                                            } else {
                                                f = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
                                            }
                                            this.mScaledVerticalScrollFactor = f;
                                            this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                                            this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                                            setWillNotDraw(getOverScrollMode() == 2);
                                            this.mItemAnimator.mListener = this.mItemAnimatorListener;
                                            initAdapterManager();
                                            initChildrenHelper();
                                            initAutofill();
                                            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                                                setImportantForAccessibility(1);
                                            }
                                            this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
                                            setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
                                            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, 0);
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                saveAttributeDataForStyleable(context, R$styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
                                            }
                                            String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
                                            if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                                                setDescendantFocusability(Http1ExchangeCodec.HEADER_LIMIT);
                                            }
                                            this.mClipToPadding = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
                                            boolean z = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
                                            this.mEnableFastScroller = z;
                                            if (z) {
                                                initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
                                            }
                                            obtainStyledAttributes.recycle();
                                            createLayoutManager(context, string, attributeSet, i, 0);
                                            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
                                            }
                                            boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
                                            obtainStyledAttributes2.recycle();
                                            setNestedScrollingEnabled(z2);
                                        }

                                        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
                                            return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
                                        }

                                        public boolean hasNestedScrollingParent(int i) {
                                            return getScrollingChildHelper().getNestedScrollingParentForType(i) != null;
                                        }

                                        public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
                                            smoothScrollBy(i, i2, interpolator, i3, false);
                                        }

                                        public boolean startNestedScroll(int i, int i2) {
                                            return getScrollingChildHelper().startNestedScroll(i, i2);
                                        }

                                        public void stopNestedScroll(int i) {
                                            getScrollingChildHelper().stopNestedScroll(i);
                                        }

                                        public static class LayoutParams extends ViewGroup.MarginLayoutParams {
                                            public final Rect mDecorInsets = new Rect();
                                            public boolean mInsetsDirty = true;
                                            public boolean mPendingInvalidate = false;
                                            public ViewHolder mViewHolder;

                                            public LayoutParams(Context context, AttributeSet attributeSet) {
                                                super(context, attributeSet);
                                            }

                                            public int getViewLayoutPosition() {
                                                return this.mViewHolder.getLayoutPosition();
                                            }

                                            public boolean isItemChanged() {
                                                return this.mViewHolder.isUpdated();
                                            }

                                            public boolean isItemRemoved() {
                                                return this.mViewHolder.isRemoved();
                                            }

                                            public LayoutParams(int i, int i2) {
                                                super(i, i2);
                                            }

                                            public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
                                                super(marginLayoutParams);
                                            }

                                            public LayoutParams(ViewGroup.LayoutParams layoutParams) {
                                                super(layoutParams);
                                            }

                                            public LayoutParams(LayoutParams layoutParams) {
                                                super((ViewGroup.LayoutParams) layoutParams);
                                            }
                                        }

                                        public static class SavedState extends AbsSavedState {
                                            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                                                /* class androidx.recyclerview.widget.RecyclerView.SavedState.AnonymousClass1 */

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
                                            public Parcelable mLayoutState;

                                            public SavedState(Parcel parcel, ClassLoader classLoader) {
                                                super(parcel, classLoader);
                                                this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
                                            }

                                            @Override // androidx.customview.view.AbsSavedState
                                            public void writeToParcel(Parcel parcel, int i) {
                                                parcel.writeParcelable(this.mSuperState, i);
                                                parcel.writeParcelable(this.mLayoutState, 0);
                                            }

                                            public SavedState(Parcelable parcelable) {
                                                super(parcelable);
                                            }
                                        }

                                        public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
                                            getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
                                        }

                                        @Override // android.view.ViewGroup
                                        public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
                                            LayoutManager layoutManager = this.mLayout;
                                            if (layoutManager != null) {
                                                return layoutManager.generateLayoutParams(layoutParams);
                                            }
                                            throw new IllegalStateException(GeneratedOutlineSupport.outline2(this, GeneratedOutlineSupport.outline17("RecyclerView has no LayoutManager")));
                                        }

                                        public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
                                            LayoutManager layoutManager = this.mLayout;
                                            if (layoutManager == null) {
                                                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                                            } else if (!this.mLayoutSuppressed) {
                                                int i4 = 0;
                                                if (!layoutManager.canScrollHorizontally()) {
                                                    i = 0;
                                                }
                                                if (!this.mLayout.canScrollVertically()) {
                                                    i2 = 0;
                                                }
                                                if (i != 0 || i2 != 0) {
                                                    if (i3 == Integer.MIN_VALUE || i3 > 0) {
                                                        if (z) {
                                                            if (i != 0) {
                                                                i4 = 1;
                                                            }
                                                            if (i2 != 0) {
                                                                i4 |= 2;
                                                            }
                                                            startNestedScroll(i4, 1);
                                                        }
                                                        this.mViewFlinger.smoothScrollBy(i, i2, i3, interpolator);
                                                        return;
                                                    }
                                                    scrollBy(i, i2);
                                                }
                                            }
                                        }

                                        public void addItemDecoration(ItemDecoration itemDecoration) {
                                            addItemDecoration(itemDecoration, -1);
                                        }
                                    }
