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
import b.i.l.w.b;
import b.q.d.a;
import b.q.d.b0;
import b.q.d.e0;
import b.q.d.f;
import b.q.d.f0;
import b.q.d.g0;
import b.q.d.o;
import b.q.d.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecyclerView extends ViewGroup implements b.i.l.e {
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
    public static final Interpolator sQuinticInterpolator = new c();
    public b.q.d.b0 mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public g mAdapter;
    public b.q.d.a mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public j mChildDrawingOrderCallback;
    public b.q.d.f mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public k mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public b.q.d.r mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public s mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public l mItemAnimator;
    public l.b mItemAnimatorListener;
    public Runnable mItemAnimatorRunner;
    public final ArrayList<n> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastTouchX;
    public int mLastTouchY;
    public o mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final x mObserver;
    public List<q> mOnChildAttachStateListeners;
    public r mOnFlingListener;
    public final ArrayList<s> mOnItemTouchListeners;
    public final List<d0> mPendingAccessibilityImportanceChange;
    public y mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public r.b mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final v mRecycler;
    public w mRecyclerListener;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public float mScaledHorizontalScrollFactor;
    public float mScaledVerticalScrollFactor;
    public t mScrollListener;
    public List<t> mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public b.i.l.f mScrollingChildHelper;
    public final a0 mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final c0 mViewFlinger;
    public final g0.b mViewInfoProcessCallback;
    public final g0 mViewInfoStore;

    public class a implements Runnable {
        public a() {
        }

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
    }

    public static class a0 {

        /* renamed from: a  reason: collision with root package name */
        public int f197a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f198b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f199c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f200d = 1;

        /* renamed from: e  reason: collision with root package name */
        public int f201e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;
        public int o;

        public void a(int i2) {
            if ((this.f200d & i2) == 0) {
                StringBuilder g2 = c.a.a.a.a.g("Layout state should be one of ");
                g2.append(Integer.toBinaryString(i2));
                g2.append(" but it is ");
                g2.append(Integer.toBinaryString(this.f200d));
                throw new IllegalStateException(g2.toString());
            }
        }

        public int b() {
            return this.g ? this.f198b - this.f199c : this.f201e;
        }

        public String toString() {
            StringBuilder g2 = c.a.a.a.a.g("State{mTargetPosition=");
            g2.append(this.f197a);
            g2.append(", mData=");
            g2.append((Object) null);
            g2.append(", mItemCount=");
            g2.append(this.f201e);
            g2.append(", mIsMeasuring=");
            g2.append(this.i);
            g2.append(", mPreviousLayoutItemCount=");
            g2.append(this.f198b);
            g2.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            g2.append(this.f199c);
            g2.append(", mStructureChanged=");
            g2.append(this.f);
            g2.append(", mInPreLayout=");
            g2.append(this.g);
            g2.append(", mRunSimpleAnimations=");
            g2.append(this.j);
            g2.append(", mRunPredictiveAnimations=");
            g2.append(this.k);
            g2.append('}');
            return g2.toString();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            l lVar = RecyclerView.this.mItemAnimator;
            if (lVar != null) {
                b.q.d.o oVar = (b.q.d.o) lVar;
                boolean z = !oVar.h.isEmpty();
                boolean z2 = !oVar.j.isEmpty();
                boolean z3 = !oVar.k.isEmpty();
                boolean z4 = !oVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<d0> it = oVar.h.iterator();
                    while (it.hasNext()) {
                        d0 next = it.next();
                        View view = next.itemView;
                        ViewPropertyAnimator animate = view.animate();
                        oVar.q.add(next);
                        animate.setDuration(oVar.f213d).alpha(0.0f).setListener(new b.q.d.j(oVar, next, animate, view)).start();
                    }
                    oVar.h.clear();
                    if (z2) {
                        ArrayList<o.b> arrayList = new ArrayList<>();
                        arrayList.addAll(oVar.j);
                        oVar.m.add(arrayList);
                        oVar.j.clear();
                        b.q.d.g gVar = new b.q.d.g(oVar, arrayList);
                        if (z) {
                            b.i.l.m.N(arrayList.get(0).f1541a.itemView, gVar, oVar.f213d);
                        } else {
                            gVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<o.a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(oVar.k);
                        oVar.n.add(arrayList2);
                        oVar.k.clear();
                        b.q.d.h hVar = new b.q.d.h(oVar, arrayList2);
                        if (z) {
                            b.i.l.m.N(arrayList2.get(0).f1536a.itemView, hVar, oVar.f213d);
                        } else {
                            hVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<d0> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(oVar.i);
                        oVar.l.add(arrayList3);
                        oVar.i.clear();
                        b.q.d.i iVar = new b.q.d.i(oVar, arrayList3);
                        if (z || z2 || z3) {
                            long j = 0;
                            long j2 = z ? oVar.f213d : 0;
                            long j3 = z2 ? oVar.f214e : 0;
                            if (z3) {
                                j = oVar.f;
                            }
                            b.i.l.m.N(arrayList3.get(0).itemView, iVar, Math.max(j3, j) + j2);
                        } else {
                            iVar.run();
                        }
                    }
                }
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    public static abstract class b0 {
    }

    public static class c implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c0 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f203b;

        /* renamed from: c  reason: collision with root package name */
        public int f204c;

        /* renamed from: d  reason: collision with root package name */
        public OverScroller f205d;

        /* renamed from: e  reason: collision with root package name */
        public Interpolator f206e = RecyclerView.sQuinticInterpolator;
        public boolean f = false;
        public boolean g = false;

        public c0() {
            this.f205d = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            b.i.l.m.M(RecyclerView.this, this);
        }

        public void b(int i, int i2, int i3, Interpolator interpolator) {
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
                float f2 = (float) width;
                float f3 = (float) i5;
                float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                if (sqrt > 0) {
                    i4 = Math.round(Math.abs(sin / ((float) sqrt)) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i4 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
                }
                i3 = Math.min(i4, (int) RecyclerView.MAX_SCROLL_DURATION);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f206e != interpolator) {
                this.f206e = interpolator;
                this.f205d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f204c = 0;
            this.f203b = 0;
            RecyclerView.this.setScrollState(2);
            this.f205d.startScroll(0, 0, i, i2, i3);
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.f205d.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                c();
                return;
            }
            this.g = false;
            this.f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f205d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f203b;
                int i4 = currY - this.f204c;
                this.f203b = currX;
                this.f204c = currY;
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
                    z zVar = recyclerView4.mLayout.g;
                    if (zVar != null && !zVar.f249d && zVar.f250e) {
                        int b2 = recyclerView4.mState.b();
                        if (b2 == 0) {
                            zVar.c();
                        } else {
                            if (zVar.f246a >= b2) {
                                zVar.f246a = b2 - 1;
                            }
                            zVar.a(i, i2);
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
                z zVar2 = RecyclerView.this.mLayout.g;
                if ((zVar2 != null && zVar2.f249d) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    b.q.d.r rVar = recyclerView6.mGapWorker;
                    if (rVar != null) {
                        rVar.a(recyclerView6, i, i2);
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
                        r.b bVar = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = bVar.f1580c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.f1581d = 0;
                    }
                }
            }
            z zVar3 = RecyclerView.this.mLayout.g;
            if (zVar3 != null && zVar3.f249d) {
                zVar3.a(0, 0);
            }
            this.f = false;
            if (this.g) {
                RecyclerView.this.removeCallbacks(this);
                b.i.l.m.M(RecyclerView.this, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    public class d implements g0.b {
        public d() {
        }
    }

    public static abstract class d0 {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        public static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
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
        public v mScrapContainer = null;
        public d0 mShadowedHolder = null;
        public d0 mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        public int mWasImportantForAccessibilityBeforeHidden = 0;

        public d0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
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

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && b.i.l.m.z(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
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
            return (this.mFlags & 16) == 0 && !b.i.l.m.z(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
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
                ((p) this.itemView.getLayoutParams()).f231c = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i == -1) {
                i = b.i.l.m.m(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i;
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
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
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.mIsRecyclableCount;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                String str = "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this;
                return;
            }
            if (!z && i3 == 1) {
                i = this.mFlags | 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                i = this.mFlags & -17;
            } else {
                return;
            }
            this.mFlags = i;
        }

        public void setScrapContainer(v vVar, boolean z) {
            this.mScrapContainer = vVar;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
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
            if (needsUpdate()) {
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
                StringBuilder g = c.a.a.a.a.g(" not recyclable(");
                g.append(this.mIsRecyclableCount);
                g.append(")");
                sb.append(g.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.l(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public class e implements f.b {
        public e() {
        }

        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        public int b() {
            return RecyclerView.this.getChildCount();
        }

        public void c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }
    }

    public class f implements a.AbstractC0034a {
        public f() {
        }

        public void a(a.b bVar) {
            int i = bVar.f1449a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.m0(recyclerView, bVar.f1450b, bVar.f1452d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.p0(recyclerView2, bVar.f1450b, bVar.f1452d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.r0(recyclerView3, bVar.f1450b, bVar.f1452d, bVar.f1451c);
            } else if (i == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.o0(recyclerView4, bVar.f1450b, bVar.f1452d, 1);
            }
        }

        public d0 b(int i) {
            d0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.k(findViewHolderForPosition.itemView)) {
                return findViewHolderForPosition;
            }
            return null;
        }

        public void c(int i, int i2, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i2, obj);
            RecyclerView.this.mItemsChanged = true;
        }
    }

    public static abstract class g<VH extends d0> {
        public boolean mHasStableIds = false;
        public final h mObservable = new h();

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            b.i.h.b.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f231c = true;
            }
            Trace.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                b.i.h.b.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                b.i.h.b.b();
                throw th;
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.d(i, 1, null);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.d(i, 1, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.d(i, i2, null);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.d(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.f(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }
    }

    public static class h extends Observable<i> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mState.f = true;
                recyclerView.processDataSetCompletelyChanged(true);
                if (!RecyclerView.this.mAdapterHelper.g()) {
                    RecyclerView.this.requestLayout();
                }
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                b.q.d.a aVar = RecyclerView.this.mAdapterHelper;
                if (aVar != null) {
                    boolean z = false;
                    if (i != i2) {
                        aVar.f1445b.add(aVar.h(8, i, i2, null));
                        aVar.g |= 8;
                        if (aVar.f1445b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        xVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                b.q.d.a aVar = RecyclerView.this.mAdapterHelper;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f1445b.add(aVar.h(4, i, i2, obj));
                        aVar.g |= 4;
                        if (aVar.f1445b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        xVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                b.q.d.a aVar = RecyclerView.this.mAdapterHelper;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f1445b.add(aVar.h(1, i, i2, null));
                        aVar.g |= 1;
                        if (aVar.f1445b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        xVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                b.q.d.a aVar = RecyclerView.this.mAdapterHelper;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f1445b.add(aVar.h(2, i, i2, null));
                        aVar.g |= 2;
                        if (aVar.f1445b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        xVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    public static abstract class i {
    }

    public interface j {
        int a(int i, int i2);
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        public b f210a = null;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f211b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public long f212c = 120;

        /* renamed from: d  reason: collision with root package name */
        public long f213d = 120;

        /* renamed from: e  reason: collision with root package name */
        public long f214e = 250;
        public long f = 250;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f215a;

            /* renamed from: b  reason: collision with root package name */
            public int f216b;
        }

        public static int b(d0 d0Var) {
            int i = d0Var.mFlags & 14;
            if (d0Var.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = d0Var.getOldPosition();
            int adapterPosition = d0Var.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public abstract boolean a(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public boolean c(d0 d0Var, List<Object> list) {
            return !((b.q.d.c0) this).g || d0Var.isInvalid();
        }

        public final void d(d0 d0Var) {
            b bVar = this.f210a;
            if (bVar != null) {
                m mVar = (m) bVar;
                if (mVar != null) {
                    d0Var.setIsRecyclable(true);
                    if (d0Var.mShadowedHolder != null && d0Var.mShadowingHolder == null) {
                        d0Var.mShadowedHolder = null;
                    }
                    d0Var.mShadowingHolder = null;
                    if (!d0Var.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(d0Var.itemView) && d0Var.isTmpDetached()) {
                        RecyclerView.this.removeDetachedView(d0Var.itemView, false);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public final void e() {
            int size = this.f211b.size();
            for (int i = 0; i < size; i++) {
                this.f211b.get(i).a();
            }
            this.f211b.clear();
        }

        public abstract void f(d0 d0Var);

        public abstract void g();

        public abstract boolean h();

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView$a0;Landroidx/recyclerview/widget/RecyclerView$d0;ILjava/util/List<Ljava/lang/Object;>;)Landroidx/recyclerview/widget/RecyclerView$l$c; */
        public c i(d0 d0Var) {
            c cVar = new c();
            View view = d0Var.itemView;
            cVar.f215a = view.getLeft();
            cVar.f216b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }
    }

    public class m implements l.b {
        public m() {
        }
    }

    public static abstract class n {
        public void d(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
        }
    }

    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        public b.q.d.f f218a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f219b;

        /* renamed from: c  reason: collision with root package name */
        public final f0.b f220c = new a();

        /* renamed from: d  reason: collision with root package name */
        public final f0.b f221d = new b();

        /* renamed from: e  reason: collision with root package name */
        public f0 f222e = new f0(this.f220c);
        public f0 f = new f0(this.f221d);
        public z g;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = true;
        public boolean l = true;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        public class a implements f0.b {
            public a() {
            }

            @Override // b.q.d.f0.b
            public View a(int i) {
                return o.this.x(i);
            }

            @Override // b.q.d.f0.b
            public int b() {
                o oVar = o.this;
                return oVar.q - oVar.N();
            }

            @Override // b.q.d.f0.b
            public int c() {
                return o.this.M();
            }

            @Override // b.q.d.f0.b
            public int d(View view) {
                return o.this.F(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // b.q.d.f0.b
            public int e(View view) {
                return o.this.C(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        public class b implements f0.b {
            public b() {
            }

            @Override // b.q.d.f0.b
            public View a(int i) {
                return o.this.x(i);
            }

            @Override // b.q.d.f0.b
            public int b() {
                o oVar = o.this;
                return oVar.r - oVar.L();
            }

            @Override // b.q.d.f0.b
            public int c() {
                return o.this.O();
            }

            @Override // b.q.d.f0.b
            public int d(View view) {
                return o.this.B(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // b.q.d.f0.b
            public int e(View view) {
                return o.this.G(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f225a;

            /* renamed from: b  reason: collision with root package name */
            public int f226b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f227c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f228d;
        }

        public static d Q(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.q.c.RecyclerView, i2, i3);
            dVar.f225a = obtainStyledAttributes.getInt(b.q.c.RecyclerView_android_orientation, 1);
            dVar.f226b = obtainStyledAttributes.getInt(b.q.c.RecyclerView_spanCount, 1);
            dVar.f227c = obtainStyledAttributes.getBoolean(b.q.c.RecyclerView_reverseLayout, false);
            dVar.f228d = obtainStyledAttributes.getBoolean(b.q.c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean W(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public static int h(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        public static int z(int i2, int i3, int i4, int i5, boolean z) {
            int max = Math.max(0, i2 - i4);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 != Integer.MIN_VALUE) {
                            if (i3 != 0) {
                            }
                        }
                        i5 = max;
                        return View.MeasureSpec.makeMeasureSpec(i5, i3);
                    }
                    i3 = 0;
                    i5 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i5, i3);
                }
            } else if (i5 < 0) {
                if (i5 != -1) {
                    if (i5 == -2) {
                        if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                            i5 = max;
                            i3 = Integer.MIN_VALUE;
                        } else {
                            i5 = max;
                            i3 = 0;
                        }
                        return View.MeasureSpec.makeMeasureSpec(i5, i3);
                    }
                    i3 = 0;
                    i5 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i5, i3);
                }
                i5 = max;
                return View.MeasureSpec.makeMeasureSpec(i5, i3);
            }
            i3 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(i5, i3);
        }

        public int A(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null || recyclerView.mAdapter == null || !e()) {
                return 1;
            }
            return this.f219b.mAdapter.getItemCount();
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[ADDED_TO_REGION] */
        public boolean A0(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                i5 = recyclerView.canScrollVertically(1) ? (this.r - O()) - L() : 0;
                if (this.f219b.canScrollHorizontally(1)) {
                    i6 = (this.q - M()) - N();
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.f219b.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            } else if (i2 != 8192) {
                i4 = 0;
                i3 = 0;
                if (i3 != 0 && i4 == 0) {
                    return false;
                }
                this.f219b.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            } else {
                i5 = recyclerView.canScrollVertically(-1) ? -((this.r - O()) - L()) : 0;
                if (this.f219b.canScrollHorizontally(-1)) {
                    i6 = -((this.q - M()) - N());
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.f219b.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            }
            i4 = i6;
            i3 = i5;
            if (i3 != 0) {
            }
            this.f219b.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public int B(View view) {
            return view.getBottom() + ((p) view.getLayoutParams()).f230b.bottom;
        }

        public boolean B0() {
            return false;
        }

        public int C(View view) {
            return view.getLeft() - ((p) view.getLayoutParams()).f230b.left;
        }

        public void C0(v vVar) {
            for (int y = y() - 1; y >= 0; y--) {
                if (!RecyclerView.getChildViewHolderInt(x(y)).shouldIgnore()) {
                    F0(y, vVar);
                }
            }
        }

        public int D(View view) {
            Rect rect = ((p) view.getLayoutParams()).f230b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void D0(v vVar) {
            int size = vVar.f239a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = vVar.f239a.get(i2).itemView;
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f219b.removeDetachedView(view, false);
                    }
                    l lVar = this.f219b.mItemAnimator;
                    if (lVar != null) {
                        lVar.f(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    vVar.i(childViewHolderInt2);
                }
            }
            vVar.f239a.clear();
            ArrayList<d0> arrayList = vVar.f240b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f219b.invalidate();
            }
        }

        public int E(View view) {
            Rect rect = ((p) view.getLayoutParams()).f230b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void E0(View view, v vVar) {
            b.q.d.f fVar = this.f218a;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (fVar.f1492b.f(indexOfChild)) {
                    fVar.l(view);
                }
                ((e) fVar.f1491a).c(indexOfChild);
            }
            vVar.h(view);
        }

        public int F(View view) {
            return view.getRight() + ((p) view.getLayoutParams()).f230b.right;
        }

        public void F0(int i2, v vVar) {
            View x = x(i2);
            G0(i2);
            vVar.h(x);
        }

        public int G(View view) {
            return view.getTop() - ((p) view.getLayoutParams()).f230b.top;
        }

        public void G0(int i2) {
            b.q.d.f fVar;
            int f2;
            View a2;
            if (x(i2) != null && (a2 = ((e) fVar.f1491a).a((f2 = (fVar = this.f218a).f(i2)))) != null) {
                if (fVar.f1492b.f(f2)) {
                    fVar.l(a2);
                }
                ((e) fVar.f1491a).c(f2);
            }
        }

        public View H() {
            View focusedChild;
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f218a.f1493c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b3, code lost:
            if (r14 == false) goto L_0x00ba;
         */
        public boolean H0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            boolean z3;
            int[] iArr = new int[2];
            int M = M();
            int O = O();
            int N = this.q - N();
            int L = this.r - L();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - M;
            int min = Math.min(0, i2);
            int i3 = top - O;
            int min2 = Math.min(0, i3);
            int i4 = width - N;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - L);
            if (I() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (z2) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int M2 = M();
                    int O2 = O();
                    int N2 = this.q - N();
                    int L2 = this.r - L();
                    Rect rect2 = this.f219b.mTempRect;
                    RecyclerView.getDecoratedBoundsWithMarginsInt(focusedChild, rect2);
                    if (rect2.left - i5 < N2 && rect2.right - i5 > M2 && rect2.top - i6 < L2 && rect2.bottom - i6 > O2) {
                        z3 = true;
                    }
                }
                z3 = false;
            }
            if (!(i5 == 0 && i6 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i5, i6);
                } else {
                    recyclerView.smoothScrollBy(i5, i6);
                }
                return true;
            }
            return false;
        }

        public int I() {
            return b.i.l.m.o(this.f219b);
        }

        public void I0() {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int J() {
            return b.i.l.m.p(this.f219b);
        }

        public int J0(int i2, v vVar, a0 a0Var) {
            return 0;
        }

        public int K() {
            return b.i.l.m.q(this.f219b);
        }

        public void K0(int i2) {
        }

        public int L() {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int L0(int i2, v vVar, a0 a0Var) {
            return 0;
        }

        public int M() {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void M0(RecyclerView recyclerView) {
            N0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int N() {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void N0(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.o = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.r = 0;
            }
        }

        public int O() {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void O0(Rect rect, int i2, int i3) {
            int N = N() + M() + rect.width();
            int L = L() + O() + rect.height();
            this.f219b.setMeasuredDimension(h(i2, N, K()), h(i3, L, J()));
        }

        public int P(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public void P0(int i2, int i3) {
            int y = y();
            if (y == 0) {
                this.f219b.defaultOnMeasure(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < y; i8++) {
                View x = x(i8);
                Rect rect = this.f219b.mTempRect;
                RecyclerView.getDecoratedBoundsWithMarginsInt(x, rect);
                int i9 = rect.left;
                if (i9 < i5) {
                    i5 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i6) {
                    i6 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f219b.mTempRect.set(i5, i6, i4, i7);
            O0(this.f219b.mTempRect, i2, i3);
        }

        public void Q0(RecyclerView recyclerView) {
            int i2;
            if (recyclerView == null) {
                this.f219b = null;
                this.f218a = null;
                i2 = 0;
                this.q = 0;
            } else {
                this.f219b = recyclerView;
                this.f218a = recyclerView.mChildHelper;
                this.q = recyclerView.getWidth();
                i2 = recyclerView.getHeight();
            }
            this.r = i2;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int R(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null || recyclerView.mAdapter == null || !f()) {
                return 1;
            }
            return this.f219b.mAdapter.getItemCount();
        }

        public boolean R0(View view, int i2, int i3, p pVar) {
            return view.isLayoutRequested() || !this.k || !W(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) || !W(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        public int S() {
            return 0;
        }

        public boolean S0() {
            return false;
        }

        public void T(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f230b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f219b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f219b.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean T0(View view, int i2, int i3, p pVar) {
            return !this.k || !W(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) || !W(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        public boolean U() {
            return this.j;
        }

        public void U0(RecyclerView recyclerView, a0 a0Var, int i2) {
        }

        public boolean V() {
            return false;
        }

        public void V0(z zVar) {
            z zVar2 = this.g;
            if (!(zVar2 == null || zVar == zVar2 || !zVar2.f250e)) {
                zVar2.c();
            }
            this.g = zVar;
            RecyclerView recyclerView = this.f219b;
            if (zVar != null) {
                recyclerView.mViewFlinger.c();
                if (zVar.h) {
                    zVar.getClass().getSimpleName();
                    zVar.getClass().getSimpleName();
                }
                zVar.f247b = recyclerView;
                zVar.f248c = this;
                int i2 = zVar.f246a;
                if (i2 != -1) {
                    recyclerView.mState.f197a = i2;
                    zVar.f250e = true;
                    zVar.f249d = true;
                    zVar.f = recyclerView.mLayout.t(i2);
                    zVar.f247b.mViewFlinger.a();
                    zVar.h = true;
                    return;
                }
                throw new IllegalArgumentException("Invalid target position");
            }
            throw null;
        }

        public boolean W0() {
            return false;
        }

        public boolean X(View view, boolean z) {
            boolean z2 = this.f222e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z2 : !z2;
        }

        public void Y(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f230b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void Z(int i2) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i2);
            }
        }

        public void a0(int i2) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i2);
            }
        }

        public void b(View view) {
            c(view, -1, false);
        }

        public void b0() {
        }

        public final void c(View view, int i2, boolean z) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.f219b.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.f219b.mViewInfoStore.f(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.f218a.b(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f219b) {
                int j2 = this.f218a.j(view);
                if (i2 == -1) {
                    i2 = this.f218a.e();
                }
                if (j2 == -1) {
                    StringBuilder g2 = c.a.a.a.a.g("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    g2.append(this.f219b.indexOfChild(view));
                    throw new IllegalStateException(c.a.a.a.a.j(this.f219b, g2));
                } else if (j2 != i2) {
                    o oVar = this.f219b.mLayout;
                    View x = oVar.x(j2);
                    if (x != null) {
                        oVar.x(j2);
                        oVar.r(j2);
                        p pVar2 = (p) x.getLayoutParams();
                        d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(x);
                        if (childViewHolderInt2.isRemoved()) {
                            oVar.f219b.mViewInfoStore.a(childViewHolderInt2);
                        } else {
                            oVar.f219b.mViewInfoStore.f(childViewHolderInt2);
                        }
                        oVar.f218a.b(x, i2, pVar2, childViewHolderInt2.isRemoved());
                    } else {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j2 + oVar.f219b.toString());
                    }
                }
            } else {
                this.f218a.a(view, i2, false);
                pVar.f231c = true;
                z zVar = this.g;
                if (zVar != null && zVar.f250e && zVar.f247b.getChildLayoutPosition(view) == zVar.f246a) {
                    zVar.f = view;
                }
            }
            if (pVar.f232d) {
                childViewHolderInt.itemView.invalidate();
                pVar.f232d = false;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList<Landroid/view/View;>;II)Z */
        public boolean c0() {
            return false;
        }

        public void d(String str) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void d0() {
        }

        public boolean e() {
            return false;
        }

        @Deprecated
        public void e0() {
        }

        public boolean f() {
            return false;
        }

        public void f0(RecyclerView recyclerView, v vVar) {
            e0();
        }

        public boolean g(p pVar) {
            return pVar != null;
        }

        public View g0(View view, int i2, v vVar, a0 a0Var) {
            return null;
        }

        public void h0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f219b;
            v vVar = recyclerView.mRecycler;
            a0 a0Var = recyclerView.mState;
            i0(accessibilityEvent);
        }

        public void i(int i2, int i3, a0 a0Var, c cVar) {
        }

        public void i0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f219b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f219b.canScrollVertically(-1) && !this.f219b.canScrollHorizontally(-1) && !this.f219b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                g gVar = this.f219b.mAdapter;
                if (gVar != null) {
                    accessibilityEvent.setItemCount(gVar.getItemCount());
                }
            }
        }

        public void j(int i2, c cVar) {
        }

        public void j0(View view, b.i.l.w.b bVar) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.f218a.k(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.f219b;
                k0(recyclerView.mRecycler, recyclerView.mState, view, bVar);
            }
        }

        public int k(a0 a0Var) {
            return 0;
        }

        public void k0(v vVar, a0 a0Var, View view, b.i.l.w.b bVar) {
            int i2 = 0;
            int P = f() ? P(view) : 0;
            if (e()) {
                i2 = P(view);
            }
            bVar.j(b.c.a(P, 1, i2, 1, false, false));
        }

        public int l(a0 a0Var) {
            return 0;
        }

        public View l0() {
            return null;
        }

        public int m(a0 a0Var) {
            return 0;
        }

        public void m0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int n(a0 a0Var) {
            return 0;
        }

        public void n0(RecyclerView recyclerView) {
        }

        public int o(a0 a0Var) {
            return 0;
        }

        public void o0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int p(a0 a0Var) {
            return 0;
        }

        public void p0(RecyclerView recyclerView, int i2, int i3) {
        }

        public void q(v vVar) {
            int y = y();
            while (true) {
                y--;
                if (y >= 0) {
                    View x = x(y);
                    d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(x);
                    if (!childViewHolderInt.shouldIgnore()) {
                        if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f219b.mAdapter.hasStableIds()) {
                            x(y);
                            r(y);
                            vVar.j(x);
                            this.f219b.mViewInfoStore.f(childViewHolderInt);
                        } else {
                            G0(y);
                            vVar.i(childViewHolderInt);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public void q0() {
        }

        public final void r(int i2) {
            this.f218a.c(i2);
        }

        public void r0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            q0();
        }

        public View s(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f218a.f1493c.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public void s0(v vVar, a0 a0Var) {
        }

        public View t(int i2) {
            int y = y();
            for (int i3 = 0; i3 < y; i3++) {
                View x = x(i3);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(x);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.f219b.mState.g || !childViewHolderInt.isRemoved())) {
                    return x;
                }
            }
            return null;
        }

        public void t0(a0 a0Var) {
        }

        public abstract p u();

        public void u0(int i2, int i3) {
            this.f219b.defaultOnMeasure(i2, i3);
        }

        public p v(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        @Deprecated
        public boolean v0(RecyclerView recyclerView) {
            z zVar = this.g;
            return (zVar != null && zVar.f250e) || recyclerView.isComputingLayout();
        }

        public p w(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean w0(RecyclerView recyclerView, View view, View view2) {
            return v0(recyclerView);
        }

        public View x(int i2) {
            b.q.d.f fVar = this.f218a;
            if (fVar == null) {
                return null;
            }
            return ((e) fVar.f1491a).a(fVar.f(i2));
        }

        public void x0(Parcelable parcelable) {
        }

        public int y() {
            b.q.d.f fVar = this.f218a;
            if (fVar != null) {
                return fVar.e();
            }
            return 0;
        }

        public Parcelable y0() {
            return null;
        }

        public void z0(int i2) {
        }
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public d0 f229a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f230b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public boolean f231c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f232d = false;

        public p(int i, int i2) {
            super(i, i2);
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
        }

        public int a() {
            return this.f229a.getLayoutPosition();
        }

        public boolean b() {
            return this.f229a.isUpdated();
        }

        public boolean c() {
            return this.f229a.isRemoved();
        }
    }

    public interface q {
        void a(View view);

        void b(View view);
    }

    public static abstract class r {
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class u {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f233a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        public int f234b = 0;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList<d0> f235a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            public int f236b = 5;

            /* renamed from: c  reason: collision with root package name */
            public long f237c = 0;

            /* renamed from: d  reason: collision with root package name */
            public long f238d = 0;
        }

        public final a a(int i) {
            a aVar = this.f233a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f233a.put(i, aVar2);
            return aVar2;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class v {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<d0> f239a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<d0> f240b = null;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d0> f241c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final List<d0> f242d = Collections.unmodifiableList(this.f239a);

        /* renamed from: e  reason: collision with root package name */
        public int f243e = 2;
        public int f = 2;
        public u g;

        public v() {
        }

        public void a(d0 d0Var, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(d0Var);
            View view = d0Var.itemView;
            b.q.d.b0 b0Var = RecyclerView.this.mAccessibilityDelegate;
            if (b0Var != null) {
                b0.a aVar = b0Var.f1458e;
                b.i.l.m.T(view, aVar instanceof b0.a ? aVar.f1460e.remove(view) : null);
            }
            if (z) {
                w wVar = RecyclerView.this.mRecyclerListener;
                if (wVar != null) {
                    wVar.a(d0Var);
                }
                g gVar = RecyclerView.this.mAdapter;
                if (gVar != null) {
                    gVar.onViewRecycled(d0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.g(d0Var);
                }
            }
            d0Var.mOwnerRecyclerView = null;
            u d2 = d();
            if (d2 != null) {
                int itemViewType = d0Var.getItemViewType();
                ArrayList<d0> arrayList = d2.a(itemViewType).f235a;
                if (d2.f233a.get(itemViewType).f236b > arrayList.size()) {
                    d0Var.resetInternal();
                    arrayList.add(d0Var);
                    return;
                }
                return;
            }
            throw null;
        }

        public void b() {
            this.f239a.clear();
            f();
        }

        public int c(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.b()) {
                StringBuilder h2 = c.a.a.a.a.h("invalid position ", i, ". State item count is ");
                h2.append(RecyclerView.this.mState.b());
                throw new IndexOutOfBoundsException(c.a.a.a.a.j(RecyclerView.this, h2));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mState.g) {
                return i;
            }
            return recyclerView.mAdapterHelper.f(i, 0);
        }

        public u d() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        public final void e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    e((ViewGroup) childAt, true);
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

        public void f() {
            for (int size = this.f241c.size() - 1; size >= 0; size--) {
                g(size);
            }
            this.f241c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                r.b bVar = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = bVar.f1580c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.f1581d = 0;
            }
        }

        public void g(int i) {
            a(this.f241c.get(i), true);
            this.f241c.remove(i);
        }

        public void h(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            i(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.f(childViewHolderInt);
            }
        }

        public void i(d0 d0Var) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (d0Var.isScrap() || d0Var.itemView.getParent() != null) {
                StringBuilder g2 = c.a.a.a.a.g("Scrapped or attached views may not be recycled. isScrap:");
                g2.append(d0Var.isScrap());
                g2.append(" isAttached:");
                if (d0Var.itemView.getParent() != null) {
                    z3 = true;
                }
                g2.append(z3);
                throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, g2));
            } else if (d0Var.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(d0Var);
                throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, sb));
            } else if (!d0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = d0Var.doesTransientStatePreventRecycling();
                g gVar = RecyclerView.this.mAdapter;
                if ((gVar != null && doesTransientStatePreventRecycling && gVar.onFailedToRecycleView(d0Var)) || d0Var.isRecyclable()) {
                    if (this.f <= 0 || d0Var.hasAnyOfTheFlags(526)) {
                        z2 = false;
                    } else {
                        int size = this.f241c.size();
                        if (size >= this.f && size > 0) {
                            g(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.c(d0Var.mPosition)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.mPrefetchRegistry.c(this.f241c.get(size).mPosition));
                            size++;
                        }
                        this.f241c.add(size, d0Var);
                        z2 = true;
                    }
                    if (!z2) {
                        a(d0Var, true);
                        z3 = true;
                    }
                    z = z3;
                    z3 = z2;
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.g(d0Var);
                if (!z3 && !z && doesTransientStatePreventRecycling) {
                    d0Var.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, c.a.a.a.a.g("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void j(View view) {
            ArrayList<d0> arrayList;
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f240b == null) {
                    this.f240b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                arrayList = this.f240b;
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                arrayList = this.f239a;
            } else {
                throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, c.a.a.a.a.g("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            arrayList.add(childViewHolderInt);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0318, code lost:
            r7 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0323, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0485, code lost:
            if ((r8 == 0 || r8 + r10 < r20) == false) goto L_0x0487;
         */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x041c  */
        /* JADX WARNING: Removed duplicated region for block: B:225:0x046e  */
        /* JADX WARNING: Removed duplicated region for block: B:235:0x04b2  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x04e3  */
        /* JADX WARNING: Removed duplicated region for block: B:254:0x04ec  */
        /* JADX WARNING: Removed duplicated region for block: B:258:0x04f7  */
        /* JADX WARNING: Removed duplicated region for block: B:259:0x04fe  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
        public d0 k(int i, boolean z, long j) {
            d0 d0Var;
            boolean z2;
            boolean z3;
            boolean z4;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            ViewGroup.LayoutParams layoutParams2;
            boolean z5;
            RecyclerView findNestedRecyclerView;
            d0 d0Var2;
            d0 d0Var3;
            d0 d0Var4;
            View view;
            boolean z6;
            int size;
            int f2;
            if (i < 0 || i >= RecyclerView.this.mState.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i);
                sb.append("(");
                sb.append(i);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.mState.b());
                throw new IndexOutOfBoundsException(c.a.a.a.a.j(RecyclerView.this, sb));
            }
            int i2 = 32;
            boolean z7 = false;
            if (RecyclerView.this.mState.g) {
                ArrayList<d0> arrayList = this.f240b;
                if (arrayList != null && (size = arrayList.size()) != 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            d0Var = this.f240b.get(i3);
                            if (!d0Var.wasReturnedFromScrap() && d0Var.getLayoutPosition() == i) {
                                d0Var.addFlags(32);
                                break;
                            }
                            i3++;
                        } else if (RecyclerView.this.mAdapter.hasStableIds() && (f2 = RecyclerView.this.mAdapterHelper.f(i, 0)) > 0 && f2 < RecyclerView.this.mAdapter.getItemCount()) {
                            long itemId = RecyclerView.this.mAdapter.getItemId(f2);
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size) {
                                    break;
                                }
                                d0 d0Var5 = this.f240b.get(i4);
                                if (!d0Var5.wasReturnedFromScrap() && d0Var5.getItemId() == itemId) {
                                    d0Var5.addFlags(32);
                                    d0Var = d0Var5;
                                    break;
                                }
                                i4++;
                            }
                        }
                    }
                    if (d0Var != null) {
                        z2 = true;
                        if (d0Var == null) {
                            int size2 = this.f239a.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 < size2) {
                                    d0Var4 = this.f239a.get(i5);
                                    if (d0Var4.wasReturnedFromScrap() || d0Var4.getLayoutPosition() != i || d0Var4.isInvalid() || (!RecyclerView.this.mState.g && d0Var4.isRemoved())) {
                                        i5++;
                                    }
                                } else {
                                    if (!z) {
                                        b.q.d.f fVar = RecyclerView.this.mChildHelper;
                                        int size3 = fVar.f1493c.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size3) {
                                                view = null;
                                                break;
                                            }
                                            view = fVar.f1493c.get(i6);
                                            if (((e) fVar.f1491a) != null) {
                                                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                                if (!(childViewHolderInt.getLayoutPosition() != i || childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved())) {
                                                    break;
                                                }
                                                i6++;
                                            } else {
                                                throw null;
                                            }
                                        }
                                        if (view != null) {
                                            d0Var = RecyclerView.getChildViewHolderInt(view);
                                            b.q.d.f fVar2 = RecyclerView.this.mChildHelper;
                                            int indexOfChild = RecyclerView.this.indexOfChild(view);
                                            if (indexOfChild < 0) {
                                                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                                            } else if (fVar2.f1492b.d(indexOfChild)) {
                                                fVar2.f1492b.a(indexOfChild);
                                                fVar2.l(view);
                                                int j2 = RecyclerView.this.mChildHelper.j(view);
                                                if (j2 != -1) {
                                                    RecyclerView.this.mChildHelper.c(j2);
                                                    j(view);
                                                    d0Var.addFlags(8224);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("layout index should not be -1 after unhiding a view:");
                                                    sb2.append(d0Var);
                                                    throw new IllegalStateException(c.a.a.a.a.j(RecyclerView.this, sb2));
                                                }
                                            } else {
                                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                                            }
                                        }
                                    }
                                    int size4 = this.f241c.size();
                                    for (int i7 = 0; i7 < size4; i7++) {
                                        d0Var4 = this.f241c.get(i7);
                                        if (!d0Var4.isInvalid() && d0Var4.getLayoutPosition() == i && !d0Var4.isAttachedToTransitionOverlay()) {
                                            if (!z) {
                                                this.f241c.remove(i7);
                                            }
                                        }
                                    }
                                    d0Var = null;
                                }
                            }
                            d0Var4.addFlags(32);
                            d0Var = d0Var4;
                            if (d0Var != null) {
                                if (d0Var.isRemoved()) {
                                    z6 = RecyclerView.this.mState.g;
                                } else {
                                    int i8 = d0Var.mPosition;
                                    if (i8 < 0 || i8 >= RecyclerView.this.mAdapter.getItemCount()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Inconsistency detected. Invalid view holder adapter position");
                                        sb3.append(d0Var);
                                        throw new IndexOutOfBoundsException(c.a.a.a.a.j(RecyclerView.this, sb3));
                                    }
                                    RecyclerView recyclerView = RecyclerView.this;
                                    z6 = (recyclerView.mState.g || recyclerView.mAdapter.getItemViewType(d0Var.mPosition) == d0Var.getItemViewType()) && (!RecyclerView.this.mAdapter.hasStableIds() || d0Var.getItemId() == RecyclerView.this.mAdapter.getItemId(d0Var.mPosition));
                                }
                                if (!z6) {
                                    if (!z) {
                                        d0Var.addFlags(4);
                                        if (d0Var.isScrap()) {
                                            RecyclerView.this.removeDetachedView(d0Var.itemView, false);
                                            d0Var.unScrap();
                                        } else if (d0Var.wasReturnedFromScrap()) {
                                            d0Var.clearReturnedFromScrapFlag();
                                        }
                                        i(d0Var);
                                    }
                                    d0Var = null;
                                } else {
                                    z2 = true;
                                }
                            }
                        }
                        if (d0Var == null) {
                            int f3 = RecyclerView.this.mAdapterHelper.f(i, 0);
                            if (f3 < 0 || f3 >= RecyclerView.this.mAdapter.getItemCount()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Inconsistency detected. Invalid item position ");
                                sb4.append(i);
                                sb4.append("(offset:");
                                sb4.append(f3);
                                sb4.append(").state:");
                                sb4.append(RecyclerView.this.mState.b());
                                throw new IndexOutOfBoundsException(c.a.a.a.a.j(RecyclerView.this, sb4));
                            }
                            int itemViewType = RecyclerView.this.mAdapter.getItemViewType(f3);
                            if (RecyclerView.this.mAdapter.hasStableIds()) {
                                long itemId2 = RecyclerView.this.mAdapter.getItemId(f3);
                                int size5 = this.f239a.size() - 1;
                                while (true) {
                                    if (size5 < 0) {
                                        int size6 = this.f241c.size() - 1;
                                        while (true) {
                                            if (size6 < 0) {
                                                break;
                                            }
                                            d0Var3 = this.f241c.get(size6);
                                            if (d0Var3.getItemId() == itemId2 && !d0Var3.isAttachedToTransitionOverlay()) {
                                                if (itemViewType == d0Var3.getItemViewType()) {
                                                    if (!z) {
                                                        this.f241c.remove(size6);
                                                    }
                                                } else if (!z) {
                                                    g(size6);
                                                    break;
                                                }
                                            }
                                            size6--;
                                        }
                                    } else {
                                        d0Var3 = this.f239a.get(size5);
                                        if (d0Var3.getItemId() == itemId2 && !d0Var3.wasReturnedFromScrap()) {
                                            if (itemViewType == d0Var3.getItemViewType()) {
                                                d0Var3.addFlags(i2);
                                                if (d0Var3.isRemoved() && !RecyclerView.this.mState.g) {
                                                    d0Var3.setFlags(2, 14);
                                                }
                                            } else if (!z) {
                                                this.f239a.remove(size5);
                                                RecyclerView.this.removeDetachedView(d0Var3.itemView, false);
                                                d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(d0Var3.itemView);
                                                childViewHolderInt2.mScrapContainer = null;
                                                childViewHolderInt2.mInChangeScrap = false;
                                                childViewHolderInt2.clearReturnedFromScrapFlag();
                                                i(childViewHolderInt2);
                                            }
                                        }
                                        size5--;
                                        i2 = 32;
                                    }
                                }
                                if (d0Var != null) {
                                    d0Var.mPosition = f3;
                                    z2 = true;
                                }
                            }
                            if (d0Var == null) {
                                u.a aVar = d().f233a.get(itemViewType);
                                if (aVar != null && !aVar.f235a.isEmpty()) {
                                    ArrayList<d0> arrayList2 = aVar.f235a;
                                    int size7 = arrayList2.size() - 1;
                                    while (true) {
                                        if (size7 < 0) {
                                            break;
                                        } else if (!arrayList2.get(size7).isAttachedToTransitionOverlay()) {
                                            d0Var2 = arrayList2.remove(size7);
                                            break;
                                        } else {
                                            size7--;
                                        }
                                    }
                                }
                                d0Var2 = null;
                                if (d0Var2 != null) {
                                    d0Var2.resetInternal();
                                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                        View view2 = d0Var2.itemView;
                                        if (view2 instanceof ViewGroup) {
                                            e((ViewGroup) view2, false);
                                        }
                                    }
                                }
                                d0Var = d0Var2;
                            }
                            if (d0Var == null) {
                                long nanoTime = RecyclerView.this.getNanoTime();
                                if (j != RecyclerView.FOREVER_NS) {
                                    long j3 = this.g.a(itemViewType).f237c;
                                    if (!(j3 == 0 || j3 + nanoTime < j)) {
                                        return null;
                                    }
                                }
                                RecyclerView recyclerView2 = RecyclerView.this;
                                d0 createViewHolder = recyclerView2.mAdapter.createViewHolder(recyclerView2, itemViewType);
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                }
                                long nanoTime2 = RecyclerView.this.getNanoTime();
                                u uVar = this.g;
                                long j4 = nanoTime2 - nanoTime;
                                u.a a2 = uVar.a(itemViewType);
                                a2.f237c = uVar.b(a2.f237c, j4);
                                d0Var = createViewHolder;
                            }
                        }
                        if (z2 && !RecyclerView.this.mState.g && d0Var.hasAnyOfTheFlags(d0.FLAG_BOUNCED_FROM_HIDDEN_LIST)) {
                            d0Var.setFlags(0, d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                            if (RecyclerView.this.mState.j) {
                                l.b(d0Var);
                                RecyclerView recyclerView3 = RecyclerView.this;
                                l lVar = recyclerView3.mItemAnimator;
                                a0 a0Var = recyclerView3.mState;
                                d0Var.getUnmodifiedPayloads();
                                RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(d0Var, lVar.i(d0Var));
                            }
                        }
                        if (!RecyclerView.this.mState.g && d0Var.isBound()) {
                            d0Var.mPreLayoutPosition = i;
                        } else if (!d0Var.isBound() || d0Var.needsUpdate() || d0Var.isInvalid()) {
                            int f4 = RecyclerView.this.mAdapterHelper.f(i, 0);
                            d0Var.mOwnerRecyclerView = RecyclerView.this;
                            int itemViewType2 = d0Var.getItemViewType();
                            long nanoTime3 = RecyclerView.this.getNanoTime();
                            if (j != RecyclerView.FOREVER_NS) {
                                long j5 = this.g.a(itemViewType2).f238d;
                            }
                            RecyclerView.this.mAdapter.bindViewHolder(d0Var, f4);
                            long nanoTime4 = RecyclerView.this.getNanoTime();
                            u uVar2 = this.g;
                            u.a a3 = uVar2.a(d0Var.getItemViewType());
                            a3.f238d = uVar2.b(a3.f238d, nanoTime4 - nanoTime3);
                            if (!RecyclerView.this.isAccessibilityEnabled()) {
                                View view3 = d0Var.itemView;
                                if (b.i.l.m.m(view3) == 0) {
                                    z5 = true;
                                    view3.setImportantForAccessibility(1);
                                } else {
                                    z5 = true;
                                }
                                b.q.d.b0 b0Var = RecyclerView.this.mAccessibilityDelegate;
                                if (b0Var != null) {
                                    b0.a aVar2 = b0Var.f1458e;
                                    if (aVar2 instanceof b0.a) {
                                        if (aVar2 != null) {
                                            b.i.l.a f5 = b.i.l.m.f(view3);
                                            if (!(f5 == null || f5 == aVar2)) {
                                                aVar2.f1460e.put(view3, f5);
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                    b.i.l.m.T(view3, aVar2);
                                }
                                z3 = z5;
                            } else {
                                z3 = true;
                            }
                            if (RecyclerView.this.mState.g) {
                                d0Var.mPreLayoutPosition = i;
                            }
                            z4 = z3;
                            layoutParams = d0Var.itemView.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = RecyclerView.this.generateDefaultLayoutParams();
                            } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                layoutParams2 = RecyclerView.this.generateLayoutParams(layoutParams);
                            } else {
                                pVar = (p) layoutParams;
                                pVar.f229a = d0Var;
                                if (z2 && z3) {
                                    z7 = z4;
                                }
                                pVar.f232d = z7;
                                return d0Var;
                            }
                            pVar = (p) layoutParams2;
                            d0Var.itemView.setLayoutParams(pVar);
                            pVar.f229a = d0Var;
                            z7 = z4;
                            pVar.f232d = z7;
                            return d0Var;
                        }
                        z4 = true;
                        z3 = false;
                        layoutParams = d0Var.itemView.getLayoutParams();
                        if (layoutParams == null) {
                        }
                        pVar = (p) layoutParams2;
                        d0Var.itemView.setLayoutParams(pVar);
                        pVar.f229a = d0Var;
                        z7 = z4;
                        pVar.f232d = z7;
                        return d0Var;
                    }
                }
                d0Var = null;
                if (d0Var != null) {
                }
            } else {
                d0Var = null;
            }
            z2 = false;
            if (d0Var == null) {
            }
            if (d0Var == null) {
            }
            d0Var.setFlags(0, d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (RecyclerView.this.mState.j) {
            }
            if (!RecyclerView.this.mState.g) {
            }
            int f42 = RecyclerView.this.mAdapterHelper.f(i, 0);
            d0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType22 = d0Var.getItemViewType();
            long nanoTime32 = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS) {
            }
            RecyclerView.this.mAdapter.bindViewHolder(d0Var, f42);
            long nanoTime42 = RecyclerView.this.getNanoTime();
            u uVar22 = this.g;
            u.a a32 = uVar22.a(d0Var.getItemViewType());
            a32.f238d = uVar22.b(a32.f238d, nanoTime42 - nanoTime32);
            if (!RecyclerView.this.isAccessibilityEnabled()) {
            }
            if (RecyclerView.this.mState.g) {
            }
            z4 = z3;
            layoutParams = d0Var.itemView.getLayoutParams();
            if (layoutParams == null) {
            }
            pVar = (p) layoutParams2;
            d0Var.itemView.setLayoutParams(pVar);
            pVar.f229a = d0Var;
            z7 = z4;
            pVar.f232d = z7;
            return d0Var;
        }

        public void l(d0 d0Var) {
            (d0Var.mInChangeScrap ? this.f240b : this.f239a).remove(d0Var);
            d0Var.mScrapContainer = null;
            d0Var.mInChangeScrap = false;
            d0Var.clearReturnedFromScrapFlag();
        }

        public void m() {
            o oVar = RecyclerView.this.mLayout;
            this.f = this.f243e + (oVar != null ? oVar.m : 0);
            for (int size = this.f241c.size() - 1; size >= 0 && this.f241c.size() > this.f; size--) {
                g(size);
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    public class x extends i {
        public x() {
        }

        public void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    b.i.l.m.M(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    public static class y extends b.k.a.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public Parcelable f245d;

        public static class a implements Parcelable.ClassLoaderCreator<y> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new y[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }
        }

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f245d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeParcelable(this.f245d, 0);
        }
    }

    public static abstract class z {

        /* renamed from: a  reason: collision with root package name */
        public int f246a = -1;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f247b;

        /* renamed from: c  reason: collision with root package name */
        public o f248c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f249d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f250e;
        public View f;
        public final a g = new a(0, 0);
        public boolean h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f251a;

            /* renamed from: b  reason: collision with root package name */
            public int f252b;

            /* renamed from: c  reason: collision with root package name */
            public int f253c;

            /* renamed from: d  reason: collision with root package name */
            public int f254d = -1;

            /* renamed from: e  reason: collision with root package name */
            public Interpolator f255e;
            public boolean f = false;
            public int g = 0;

            public a(int i, int i2) {
                this.f251a = i;
                this.f252b = i2;
                this.f253c = Integer.MIN_VALUE;
                this.f255e = null;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.f254d;
                if (i >= 0) {
                    this.f254d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                } else if (!this.f) {
                    this.g = 0;
                } else if (this.f255e == null || this.f253c >= 1) {
                    int i2 = this.f253c;
                    if (i2 >= 1) {
                        recyclerView.mViewFlinger.b(this.f251a, this.f252b, i2, this.f255e);
                        this.g++;
                        this.f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.f251a = i;
                this.f252b = i2;
                this.f253c = i3;
                this.f255e = interpolator;
                this.f = true;
            }
        }

        public interface b {
            PointF a(int i);
        }

        public void a(int i, int i2) {
            o oVar;
            RecyclerView recyclerView = this.f247b;
            if (this.f246a == -1 || recyclerView == null) {
                c();
            }
            PointF pointF = null;
            if (this.f249d && this.f == null && (oVar = this.f248c) != null) {
                PointF a2 = oVar instanceof b ? ((b) oVar).a(this.f246a) : null;
                if (!(a2 == null || (a2.x == 0.0f && a2.y == 0.0f))) {
                    recyclerView.scrollStep((int) Math.signum(a2.x), (int) Math.signum(a2.y), null);
                }
            }
            boolean z = false;
            this.f249d = false;
            View view = this.f;
            if (view != null) {
                if (this.f247b.getChildLayoutPosition(view) == this.f246a) {
                    b(this.f, recyclerView.mState, this.g);
                    this.g.a(recyclerView);
                    c();
                } else {
                    this.f = null;
                }
            }
            if (this.f250e) {
                a0 a0Var = recyclerView.mState;
                a aVar = this.g;
                b.q.d.t tVar = (b.q.d.t) this;
                if (tVar.f247b.mLayout.y() == 0) {
                    tVar.c();
                } else {
                    int i3 = tVar.o;
                    int i4 = i3 - i;
                    if (i3 * i4 <= 0) {
                        i4 = 0;
                    }
                    tVar.o = i4;
                    int i5 = tVar.p;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    tVar.p = i6;
                    if (tVar.o == 0 && i6 == 0) {
                        int i7 = tVar.f246a;
                        o oVar2 = tVar.f248c;
                        if (oVar2 instanceof b) {
                            pointF = ((b) oVar2).a(i7);
                        }
                        if (pointF == null || (pointF.x == 0.0f && pointF.y == 0.0f)) {
                            aVar.f254d = tVar.f246a;
                            tVar.c();
                        } else {
                            float f2 = pointF.x;
                            float f3 = pointF.y;
                            float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
                            float f4 = pointF.x / sqrt;
                            pointF.x = f4;
                            float f5 = pointF.y / sqrt;
                            pointF.y = f5;
                            tVar.k = pointF;
                            tVar.o = (int) (f4 * 10000.0f);
                            tVar.p = (int) (f5 * 10000.0f);
                            aVar.b((int) (((float) tVar.o) * 1.2f), (int) (((float) tVar.p) * 1.2f), (int) (((float) tVar.f(10000)) * 1.2f), tVar.i);
                        }
                    }
                }
                if (this.g.f254d >= 0) {
                    z = true;
                }
                this.g.a(recyclerView);
                if (z && this.f250e) {
                    this.f249d = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public abstract void b(View view, a0 a0Var, a aVar);

        public final void c() {
            if (this.f250e) {
                this.f250e = false;
                b.q.d.t tVar = (b.q.d.t) this;
                tVar.p = 0;
                tVar.o = 0;
                tVar.k = null;
                this.f247b.mState.f197a = -1;
                this.f = null;
                this.f246a = -1;
                this.f249d = false;
                o oVar = this.f248c;
                if (oVar.g == this) {
                    oVar.g = null;
                }
                this.f248c = null;
                this.f247b = null;
            }
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.q.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new g0();
        this.mUpdateChildViewsRunnable = new a();
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
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = new b.q.d.o();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new c0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new r.b() : null;
        this.mState = new a0();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = b.i.l.q.b(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : b.i.l.q.a(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f210a = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (b.i.l.m.m(this) == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new b.q.d.b0(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.q.c.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, b.q.c.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(b.q.c.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(b.q.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(b.q.c.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(b.q.c.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(b.q.c.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(b.q.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(b.q.c.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(b.q.c.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i2, 0);
        }
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    private void addAnimatingView(d0 d0Var) {
        View view = d0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.mRecycler.l(getChildViewHolder(view));
        if (d0Var.isTmpDetached()) {
            this.mChildHelper.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        b.q.d.f fVar = this.mChildHelper;
        if (!z2) {
            fVar.a(view, -1, true);
            return;
        }
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild >= 0) {
            fVar.f1492b.h(indexOfChild);
            fVar.i(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    private void animateChange(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.setIsRecyclable(false);
        if (z2) {
            addAnimatingView(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                addAnimatingView(d0Var2);
            }
            d0Var.mShadowedHolder = d0Var2;
            addAnimatingView(d0Var);
            this.mRecycler.l(d0Var);
            d0Var2.setIsRecyclable(false);
            d0Var2.mShadowingHolder = d0Var;
        }
        if (this.mItemAnimator.a(d0Var, d0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.mNestedRecyclerView;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                View view = (View) viewParent;
                while (true) {
                    if (view == null) {
                        d0Var.mNestedRecyclerView = null;
                        return;
                    } else if (view != d0Var.itemView) {
                        viewParent = view.getParent();
                        if (!(viewParent instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e8);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            obtain.setContentChangeTypes(i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        g0 g0Var = this.mViewInfoStore;
        g0Var.f1505a.clear();
        g0Var.f1506b.b();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        a0 a0Var = this.mState;
        a0Var.h = a0Var.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        a0 a0Var2 = this.mState;
        a0Var2.g = a0Var2.k;
        a0Var2.f201e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int e2 = this.mChildHelper.e();
            for (int i2 = 0; i2 < e2; i2++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    l lVar = this.mItemAnimator;
                    l.b(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.c(childViewHolderInt, lVar.i(childViewHolderInt));
                    if (this.mState.h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f1506b.g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            a0 a0Var3 = this.mState;
            boolean z2 = a0Var3.f;
            a0Var3.f = false;
            this.mLayout.s0(this.mRecycler, a0Var3);
            this.mState.f = z2;
            for (int i3 = 0; i3 < this.mChildHelper.e(); i3++) {
                d0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i3));
                if (!childViewHolderInt2.shouldIgnore()) {
                    g0.a orDefault = this.mViewInfoStore.f1505a.getOrDefault(childViewHolderInt2, null);
                    if (!((orDefault == null || (orDefault.f1508a & 4) == 0) ? false : true)) {
                        l.b(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                        l lVar2 = this.mItemAnimator;
                        childViewHolderInt2.getUnmodifiedPayloads();
                        l.c i4 = lVar2.i(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, i4);
                        } else {
                            g0 g0Var2 = this.mViewInfoStore;
                            g0.a orDefault2 = g0Var2.f1505a.getOrDefault(childViewHolderInt2, null);
                            if (orDefault2 == null) {
                                orDefault2 = g0.a.a();
                                g0Var2.f1505a.put(childViewHolderInt2, orDefault2);
                            }
                            orDefault2.f1508a |= 2;
                            orDefault2.f1509b = i4;
                        }
                    }
                }
            }
        }
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f200d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.f201e = this.mAdapter.getItemCount();
        a0 a0Var = this.mState;
        a0Var.f199c = 0;
        a0Var.g = false;
        this.mLayout.s0(this.mRecycler, a0Var);
        a0 a0Var2 = this.mState;
        a0Var2.f = false;
        this.mPendingSavedState = null;
        a0Var2.j = a0Var2.j && this.mItemAnimator != null;
        this.mState.f200d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        boolean z2;
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        a0 a0Var = this.mState;
        a0Var.f200d = 1;
        if (a0Var.j) {
            for (int e2 = this.mChildHelper.e() - 1; e2 >= 0; e2--) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(e2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    if (this.mItemAnimator != null) {
                        l.c cVar = new l.c();
                        View view = childViewHolderInt.itemView;
                        cVar.f215a = view.getLeft();
                        cVar.f216b = view.getTop();
                        view.getRight();
                        view.getBottom();
                        d0 f2 = this.mViewInfoStore.f1506b.f(changedHolderKey, null);
                        if (f2 != null && !f2.shouldIgnore()) {
                            boolean d2 = this.mViewInfoStore.d(f2);
                            boolean d3 = this.mViewInfoStore.d(childViewHolderInt);
                            if (!d2 || f2 != childViewHolderInt) {
                                l.c e3 = this.mViewInfoStore.e(f2, 4);
                                this.mViewInfoStore.b(childViewHolderInt, cVar);
                                l.c e4 = this.mViewInfoStore.e(childViewHolderInt, 8);
                                if (e3 == null) {
                                    handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, f2);
                                } else {
                                    animateChange(f2, childViewHolderInt, e3, e4, d2, d3);
                                }
                            }
                        }
                        this.mViewInfoStore.b(childViewHolderInt, cVar);
                    } else {
                        throw null;
                    }
                }
            }
            g0 g0Var = this.mViewInfoStore;
            g0.b bVar = this.mViewInfoProcessCallback;
            int i2 = g0Var.f1505a.f829d;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                d0 h2 = g0Var.f1505a.h(i2);
                g0.a i3 = g0Var.f1505a.i(i2);
                int i4 = i3.f1508a;
                if ((i4 & 3) != 3) {
                    if ((i4 & 1) != 0) {
                        l.c cVar2 = i3.f1509b;
                        if (cVar2 != null) {
                            l.c cVar3 = i3.f1510c;
                            d dVar = (d) bVar;
                            RecyclerView.this.mRecycler.l(h2);
                            RecyclerView.this.animateDisappearance(h2, cVar2, cVar3);
                        }
                    } else {
                        if ((i4 & 14) != 14) {
                            if ((i4 & 12) == 12) {
                                l.c cVar4 = i3.f1509b;
                                l.c cVar5 = i3.f1510c;
                                d dVar2 = (d) bVar;
                                if (dVar2 != null) {
                                    h2.setIsRecyclable(false);
                                    RecyclerView recyclerView = RecyclerView.this;
                                    boolean z3 = recyclerView.mDataSetHasChangedAfterLayout;
                                    l lVar = recyclerView.mItemAnimator;
                                    if (!z3) {
                                        b.q.d.c0 c0Var = (b.q.d.c0) lVar;
                                        if (c0Var != null) {
                                            if (cVar4.f215a == cVar5.f215a && cVar4.f216b == cVar5.f216b) {
                                                c0Var.d(h2);
                                                z2 = false;
                                            } else {
                                                z2 = c0Var.j(h2, cVar4.f215a, cVar4.f216b, cVar5.f215a, cVar5.f216b);
                                            }
                                            if (!z2) {
                                            }
                                        } else {
                                            throw null;
                                        }
                                    } else if (!lVar.a(h2, h2, cVar4, cVar5)) {
                                    }
                                    RecyclerView.this.postAnimationRunner();
                                } else {
                                    throw null;
                                }
                            } else if ((i4 & 4) != 0) {
                                l.c cVar6 = i3.f1509b;
                                d dVar3 = (d) bVar;
                                RecyclerView.this.mRecycler.l(h2);
                                RecyclerView.this.animateDisappearance(h2, cVar6, null);
                            } else if ((i4 & 8) == 0) {
                            }
                        }
                        RecyclerView.this.animateAppearance(h2, i3.f1509b, i3.f1510c);
                    }
                    g0.a.b(i3);
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.E0(h2.itemView, recyclerView2.mRecycler);
                g0.a.b(i3);
            }
        }
        this.mLayout.D0(this.mRecycler);
        a0 a0Var2 = this.mState;
        a0Var2.f198b = a0Var2.f201e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        a0Var2.j = false;
        a0Var2.k = false;
        this.mLayout.h = false;
        ArrayList<d0> arrayList = this.mRecycler.f240b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.mLayout;
        if (oVar.n) {
            oVar.m = 0;
            oVar.n = false;
            this.mRecycler.m();
        }
        this.mLayout.t0(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        g0 g0Var2 = this.mViewInfoStore;
        g0Var2.f1505a.clear();
        g0Var2.f1506b.b();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        s sVar = this.mInterceptingOnItemTouchListener;
        if (sVar != null) {
            sVar.b(this, motionEvent);
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
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.mOnItemTouchListeners.get(i2);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = sVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int e2 = this.mChildHelper.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < e2; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
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
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        d0 findViewHolderForAdapterPosition;
        int i2 = this.mState.l;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = this.mState.b();
        for (int i3 = i2; i3 < b2; i3++) {
            d0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(b2, i2);
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

    public static d0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f229a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f230b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id;
        loop0:
        while (true) {
            id = view.getId();
            while (true) {
                if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                    return id;
                }
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
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

    private b.i.l.f getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new b.i.l.f(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, d0 d0Var, d0 d0Var2) {
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != d0Var && getChangedHolderKey(childViewHolderInt) == j2) {
                g gVar = this.mAdapter;
                if (gVar == null || !gVar.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(d0Var);
                    throw new IllegalStateException(c.a.a.a.a.j(this, sb));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(d0Var);
                throw new IllegalStateException(c.a.a.a.a.j(this, sb2));
            }
        }
        String str = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + exceptionLabel();
    }

    private boolean hasUpdatedView() {
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || !childViewHolderInt.isUpdated())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (b.i.l.m.n(this) == 0 && Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new b.q.d.f(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
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
        char c2 = 65535;
        int i4 = this.mLayout.I() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        int i6 = this.mTempRect2.left;
        if ((i5 < i6 || rect.right <= i6) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.mTempRect;
            int i7 = rect2.right;
            int i8 = this.mTempRect2.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        Rect rect3 = this.mTempRect;
        int i9 = rect3.top;
        int i10 = this.mTempRect2.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.mTempRect;
            int i11 = rect4.bottom;
            int i12 = this.mTempRect2.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.mTempRect.top <= this.mTempRect2.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid direction: ");
        sb.append(i2);
        throw new IllegalArgumentException(c.a.a.a.a.j(this, sb));
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.W0();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            b.q.d.a aVar = this.mAdapterHelper;
            aVar.l(aVar.f1445b);
            aVar.l(aVar.f1446c);
            aVar.g = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.n0(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.j();
        } else {
            this.mAdapterHelper.c();
        }
        boolean z3 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z3 || this.mLayout.h) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        a0 a0Var = this.mState;
        if (a0Var.j && z3 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z2 = true;
        }
        a0Var.k = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    private void pullGlows(float f2, float f3, float f4, float f5) {
        boolean z2;
        EdgeEffect edgeEffect;
        float width;
        float height;
        boolean z3 = true;
        if (f3 < 0.0f) {
            ensureLeftGlow();
            edgeEffect = this.mLeftGlow;
            width = (-f3) / ((float) getWidth());
            height = 1.0f - (f4 / ((float) getHeight()));
        } else if (f3 > 0.0f) {
            ensureRightGlow();
            edgeEffect = this.mRightGlow;
            width = f3 / ((float) getWidth());
            height = f4 / ((float) getHeight());
        } else {
            z2 = false;
            if (f5 >= 0.0f) {
                ensureTopGlow();
                this.mTopGlow.onPull((-f5) / ((float) getHeight()), f2 / ((float) getWidth()));
            } else if (f5 > 0.0f) {
                ensureBottomGlow();
                this.mBottomGlow.onPull(f5 / ((float) getHeight()), 1.0f - (f2 / ((float) getWidth())));
            } else {
                z3 = z2;
            }
            if (!z3 || f3 != 0.0f || f5 != 0.0f) {
                b.i.l.m.L(this);
            }
            return;
        }
        edgeEffect.onPull(width, height);
        z2 = true;
        if (f5 >= 0.0f) {
        }
        if (!z3) {
        }
        b.i.l.m.L(this);
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.k(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.e() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                d0 findViewHolderForItemId = (this.mState.m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m);
                if (findViewHolderForItemId != null && !this.mChildHelper.k(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.e() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i2 = this.mState.n;
                    if (!(((long) i2) == -1 || (findViewById = view.findViewById(i2)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            b.i.l.m.L(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f231c) {
                Rect rect = pVar.f230b;
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
        this.mLayout.H0(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        a0 a0Var = this.mState;
        a0Var.m = -1;
        a0Var.l = -1;
        a0Var.n = -1;
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
        d0 d0Var = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            d0Var = findContainingViewHolder(focusedChild);
        }
        if (d0Var == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.hasStableIds() ? d0Var.getItemId() : -1;
        this.mState.l = this.mDataSetHasChangedAfterLayout ? -1 : d0Var.isRemoved() ? d0Var.mOldPosition : d0Var.getAdapterPosition();
        this.mState.n = getDeepestFocusedViewWithId(d0Var.itemView);
    }

    private void setAdapterInternal(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.mAdapter;
        if (gVar2 != null) {
            gVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        b.q.d.a aVar = this.mAdapterHelper;
        aVar.l(aVar.f1445b);
        aVar.l(aVar.f1446c);
        aVar.g = 0;
        g gVar3 = this.mAdapter;
        this.mAdapter = gVar;
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.mObserver);
            gVar.onAttachedToRecyclerView(this);
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.b0();
        }
        v vVar = this.mRecycler;
        g gVar4 = this.mAdapter;
        vVar.b();
        u d2 = vVar.d();
        if (d2 != null) {
            if (gVar3 != null) {
                d2.f234b--;
            }
            if (!z2 && d2.f234b == 0) {
                for (int i2 = 0; i2 < d2.f233a.size(); i2++) {
                    d2.f233a.valueAt(i2).f235a.clear();
                }
            }
            if (gVar4 != null) {
                d2.f234b++;
            }
            this.mState.f = true;
            return;
        }
        throw null;
    }

    private void stopScrollersInternal() {
        z zVar;
        this.mViewFlinger.c();
        o oVar = this.mLayout;
        if (oVar != null && (zVar = oVar.g) != null) {
            zVar.c();
        }
    }

    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            b.i.l.m.L(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null || !oVar.c0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(n nVar) {
        addItemDecoration(nVar, -1);
    }

    public void addItemDecoration(n nVar, int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(nVar);
        } else {
            this.mItemDecorations.add(i2, nVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(q qVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(qVar);
    }

    public void addOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.add(sVar);
    }

    public void addOnScrollListener(t tVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(tVar);
    }

    public void animateAppearance(d0 d0Var, l.c cVar, l.c cVar2) {
        boolean z2;
        d0Var.setIsRecyclable(false);
        b.q.d.c0 c0Var = (b.q.d.c0) this.mItemAnimator;
        if (c0Var != null) {
            if (cVar == null || (cVar.f215a == cVar2.f215a && cVar.f216b == cVar2.f216b)) {
                b.q.d.o oVar = (b.q.d.o) c0Var;
                oVar.o(d0Var);
                d0Var.itemView.setAlpha(0.0f);
                oVar.i.add(d0Var);
                z2 = true;
            } else {
                z2 = c0Var.j(d0Var, cVar.f215a, cVar.f216b, cVar2.f215a, cVar2.f216b);
            }
            if (z2) {
                postAnimationRunner();
                return;
            }
            return;
        }
        throw null;
    }

    public void animateDisappearance(d0 d0Var, l.c cVar, l.c cVar2) {
        boolean z2;
        addAnimatingView(d0Var);
        d0Var.setIsRecyclable(false);
        b.q.d.c0 c0Var = (b.q.d.c0) this.mItemAnimator;
        if (c0Var != null) {
            int i2 = cVar.f215a;
            int i3 = cVar.f216b;
            View view = d0Var.itemView;
            int left = cVar2 == null ? view.getLeft() : cVar2.f215a;
            int top = cVar2 == null ? view.getTop() : cVar2.f216b;
            if (d0Var.isRemoved() || (i2 == left && i3 == top)) {
                b.q.d.o oVar = (b.q.d.o) c0Var;
                oVar.o(d0Var);
                oVar.h.add(d0Var);
                z2 = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                z2 = c0Var.j(d0Var, i2, i3, left, top);
            }
            if (z2) {
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
            throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g(str)));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("")));
        }
    }

    public boolean canReuseUpdatedViewHolder(d0 d0Var) {
        l lVar = this.mItemAnimator;
        return lVar == null || lVar.c(d0Var, d0Var.getUnmodifiedPayloads());
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.mLayout.g((p) layoutParams);
    }

    public void clearOldPositions() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        for (int i3 = 0; i3 < size; i3++) {
            vVar.f241c.get(i3).clearOldPosition();
        }
        int size2 = vVar.f239a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            vVar.f239a.get(i4).clearOldPosition();
        }
        ArrayList<d0> arrayList = vVar.f240b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                vVar.f240b.get(i5).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.k(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.l(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.m(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.n(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.o(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.p(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.mLeftGlow.onRelease();
            z2 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            b.i.l.m.L(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            b.i.h.b.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
        } else if (this.mAdapterHelper.g()) {
            boolean z2 = false;
            if ((this.mAdapterHelper.g & 4) != 0) {
                if ((this.mAdapterHelper.g & 11) != 0) {
                    z2 = true;
                }
                if (!z2) {
                    b.i.h.b.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.j();
                    if (!this.mLayoutWasDefered) {
                        if (hasUpdatedView()) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.b();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    Trace.endSection();
                }
            }
            if (this.mAdapterHelper.g()) {
                b.i.h.b.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(o.h(i2, getPaddingRight() + getPaddingLeft(), b.i.l.m.q(this)), o.h(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        g gVar = this.mAdapter;
        if (!(gVar == null || childViewHolderInt == null)) {
            gVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        g gVar = this.mAdapter;
        if (!(gVar == null || childViewHolderInt == null)) {
            gVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter != null && this.mLayout != null) {
            a0 a0Var = this.mState;
            boolean z2 = false;
            a0Var.i = false;
            if (a0Var.f200d == 1) {
                dispatchLayoutStep1();
            } else {
                b.q.d.a aVar = this.mAdapterHelper;
                if (!aVar.f1446c.isEmpty() && !aVar.f1445b.isEmpty()) {
                    z2 = true;
                }
                if (!z2 && this.mLayout.q == getWidth() && this.mLayout.r == getHeight()) {
                    this.mLayout.M0(this);
                    dispatchLayoutStep3();
                }
            }
            this.mLayout.M0(this);
            dispatchLayoutStep2();
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, i4);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr);
    }

    public void dispatchOnScrollStateChanged(int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.z0(i2);
        }
        onScrollStateChanged(i2);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).a(this, i2);
            }
        }
    }

    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).b(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            d0 d0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (d0Var.itemView.getParent() == this && !d0Var.shouldIgnore() && (i2 = d0Var.mPendingAccessibilityState) != -1) {
                b.i.l.m.a0(d0Var.itemView, i2);
                d0Var.mPendingAccessibilityState = -1;
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
        boolean z2;
        float f2;
        float f3;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).e(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
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
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                f3 = (float) (getPaddingRight() + (-getWidth()));
                f2 = (float) (getPaddingBottom() + (-getHeight()));
            } else {
                f3 = (float) (-getWidth());
                f2 = (float) (-getHeight());
            }
            canvas.translate(f3, f2);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.h()) {
            z4 = z2;
        }
        if (z4) {
            b.i.l.m.L(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void ensureBottomGlow() {
        int i2;
        int i3;
        if (this.mBottomGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mBottomGlow = a2;
            if (this.mClipToPadding) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    public void ensureLeftGlow() {
        int i2;
        int i3;
        if (this.mLeftGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mLeftGlow = a2;
            if (this.mClipToPadding) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void ensureRightGlow() {
        int i2;
        int i3;
        if (this.mRightGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mRightGlow = a2;
            if (this.mClipToPadding) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void ensureTopGlow() {
        int i2;
        int i3;
        if (this.mTopGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mTopGlow = a2;
            if (this.mClipToPadding) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    public String exceptionLabel() {
        StringBuilder g2 = c.a.a.a.a.g(" ");
        g2.append(super.toString());
        g2.append(", adapter:");
        g2.append(this.mAdapter);
        g2.append(", layout:");
        g2.append(this.mLayout);
        g2.append(", context:");
        g2.append(getContext());
        return g2.toString();
    }

    public final void fillRemainingScrollValues(a0 a0Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f205d;
            a0Var.o = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        a0Var.o = 0;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int e2 = this.mChildHelper.e() - 1; e2 >= 0; e2--) {
            View d2 = this.mChildHelper.d(e2);
            float translationX = d2.getTranslationX();
            float translationY = d2.getTranslationY();
            if (f2 >= ((float) d2.getLeft()) + translationX && f2 <= ((float) d2.getRight()) + translationX && f3 >= ((float) d2.getTop()) + translationY && f3 <= ((float) d2.getBottom()) + translationY) {
                return d2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public View findContainingItemView(View view) {
        ViewParent parent;
        while (true) {
            parent = view.getParent();
            if (parent != null && parent != this && (parent instanceof View)) {
                view = (View) parent;
            } else if (parent != this) {
                return view;
            } else {
                return null;
            }
        }
        if (parent != this) {
        }
    }

    public d0 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public d0 findViewHolderForAdapterPosition(int i2) {
        d0 d0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int h2 = this.mChildHelper.h();
        for (int i3 = 0; i3 < h2; i3++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForItemId(long j2) {
        g gVar = this.mAdapter;
        d0 d0Var = null;
        if (gVar != null && gVar.hasStableIds()) {
            int h2 = this.mChildHelper.h();
            for (int i2 = 0; i2 < h2; i2++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    d0Var = childViewHolderInt;
                }
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public d0 findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public d0 findViewHolderForPosition(int i2, boolean z2) {
        int h2 = this.mChildHelper.h();
        d0 d0Var = null;
        for (int i3 = 0; i3 < h2; i3++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z2) {
                    if (childViewHolderInt.mPosition != i2) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011d A[RETURN] */
    public boolean fling(int i2, int i3) {
        boolean z2;
        int minFlingVelocity;
        boolean z3;
        e0 e0Var;
        int i4;
        int i5;
        View b2;
        int P;
        PointF a2;
        int i6;
        int i7;
        o oVar = this.mLayout;
        if (oVar == null || this.mLayoutSuppressed) {
            return false;
        }
        boolean e2 = oVar.e();
        boolean f2 = this.mLayout.f();
        int i8 = (!e2 || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
        int i9 = (!f2 || Math.abs(i3) < this.mMinFlingVelocity) ? 0 : i3;
        if (i8 == 0 && i9 == 0) {
            return false;
        }
        float f3 = (float) i8;
        float f4 = (float) i9;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z4 = e2 || f2;
            dispatchNestedFling(f3, f4, z4);
            r rVar = this.mOnFlingListener;
            if (rVar != null) {
                b.q.d.d0 d0Var = (b.q.d.d0) rVar;
                o layoutManager = d0Var.f1481a.getLayoutManager();
                if (!(layoutManager == null || d0Var.f1481a.getAdapter() == null || (Math.abs(i9) <= (minFlingVelocity = d0Var.f1481a.getMinFlingVelocity()) && Math.abs(i8) <= minFlingVelocity))) {
                    boolean z5 = layoutManager instanceof z.b;
                    if (z5) {
                        g gVar = null;
                        if (!z5) {
                            e0Var = null;
                        } else {
                            e0Var = new e0(d0Var, d0Var.f1481a.getContext());
                        }
                        if (e0Var != null) {
                            b.q.d.u uVar = (b.q.d.u) d0Var;
                            if (z5) {
                                RecyclerView recyclerView = layoutManager.f219b;
                                if (recyclerView != null) {
                                    gVar = recyclerView.getAdapter();
                                }
                                int itemCount = gVar != null ? gVar.getItemCount() : 0;
                                if (!(itemCount == 0 || (b2 = uVar.b(layoutManager)) == null || (P = layoutManager.P(b2)) == -1 || (a2 = ((z.b) layoutManager).a(itemCount - 1)) == null)) {
                                    if (layoutManager.e()) {
                                        i6 = uVar.e(layoutManager, uVar.g(layoutManager), i8, 0);
                                        if (a2.x < 0.0f) {
                                            i6 = -i6;
                                        }
                                    } else {
                                        i6 = 0;
                                    }
                                    if (layoutManager.f()) {
                                        i7 = uVar.e(layoutManager, uVar.h(layoutManager), 0, i9);
                                        if (a2.y < 0.0f) {
                                            i7 = -i7;
                                        }
                                    } else {
                                        i7 = 0;
                                    }
                                    if (layoutManager.f()) {
                                        i6 = i7;
                                    }
                                    if (i6 != 0) {
                                        int i10 = P + i6;
                                        if (i10 < 0) {
                                            i10 = 0;
                                        }
                                        if (i10 < itemCount) {
                                            i4 = i10;
                                        }
                                        i5 = -1;
                                        if (i4 != i5) {
                                            e0Var.f246a = i4;
                                            layoutManager.V0(e0Var);
                                            z3 = true;
                                            if (z3) {
                                                z2 = true;
                                                if (z2) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            i5 = -1;
                            i4 = -1;
                            if (i4 != i5) {
                            }
                        }
                    }
                    z3 = false;
                    if (z3) {
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            if (z4) {
                int i11 = e2 ? 1 : 0;
                if (f2) {
                    i11 |= 2;
                }
                startNestedScroll(i11, 1);
                int i12 = this.mMaxFlingVelocity;
                int max = Math.max(-i12, Math.min(i8, i12));
                int i13 = this.mMaxFlingVelocity;
                int max2 = Math.max(-i13, Math.min(i9, i13));
                c0 c0Var = this.mViewFlinger;
                RecyclerView.this.setScrollState(2);
                c0Var.f204c = 0;
                c0Var.f203b = 0;
                Interpolator interpolator = c0Var.f206e;
                Interpolator interpolator2 = sQuinticInterpolator;
                if (interpolator != interpolator2) {
                    c0Var.f206e = interpolator2;
                    c0Var.f205d = new OverScroller(RecyclerView.this.getContext(), sQuinticInterpolator);
                }
                c0Var.f205d.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                c0Var.a();
                return true;
            }
        }
        return false;
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View l0 = this.mLayout.l0();
        if (l0 != null) {
            return l0;
        }
        boolean z3 = true;
        boolean z4 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.g0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.f()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.e()) {
                int i4 = (this.mLayout.I() == 1) ^ (i2 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i4) != null) {
                    z3 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
                z2 = z3;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.g0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.u();
        }
        throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.v(getContext(), attributeSet);
        }
        throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.w(layoutParams);
        }
        throw new IllegalStateException(c.a.a.a.a.j(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(d0 d0Var) {
        if (d0Var.hasAnyOfTheFlags(524) || !d0Var.isBound()) {
            return -1;
        }
        b.q.d.a aVar = this.mAdapterHelper;
        int i2 = d0Var.mPosition;
        int size = aVar.f1445b.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.f1445b.get(i3);
            int i4 = bVar.f1449a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1450b;
                    if (i5 <= i2) {
                        int i6 = bVar.f1452d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1450b;
                    if (i7 == i2) {
                        i2 = bVar.f1452d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f1452d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1450b <= i2) {
                i2 += bVar.f1452d;
            }
        }
        return i2;
    }

    public int getBaseline() {
        o oVar = this.mLayout;
        if (oVar == null) {
            return super.getBaseline();
        }
        if (oVar != null) {
            return -1;
        }
        throw null;
    }

    public long getChangedHolderKey(d0 d0Var) {
        return this.mAdapter.hasStableIds() ? d0Var.getItemId() : (long) d0Var.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.mChildDrawingOrderCallback;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        d0 childViewHolderInt;
        g gVar = this.mAdapter;
        if (gVar == null || !gVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public d0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public b.q.d.b0 getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public l getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f231c) {
            return pVar.f230b;
        }
        if (this.mState.g && (pVar.b() || pVar.f229a.isInvalid())) {
            return pVar.f230b;
        }
        Rect rect = pVar.f230b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            n nVar = this.mItemDecorations.get(i2);
            Rect rect2 = this.mTempRect;
            if (nVar != null) {
                ((p) view.getLayoutParams()).a();
                rect2.set(0, 0, 0, 0);
                int i3 = rect.left;
                Rect rect3 = this.mTempRect;
                rect.left = i3 + rect3.left;
                rect.top += rect3.top;
                rect.right += rect3.right;
                rect.bottom += rect3.bottom;
            } else {
                throw null;
            }
        }
        pVar.f231c = false;
        return rect;
    }

    public n getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public o getLayoutManager() {
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

    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public u getRecycledViewPool() {
        return this.mRecycler.d();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new b.q.d.a(new f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(c.a.a.a.a.j(this, c.a.a.a.a.g("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new b.q.d.q(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(b.q.b.fastscroll_default_thickness), resources.getDimensionPixelSize(b.q.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(b.q.b.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            o oVar = this.mLayout;
            if (oVar != null) {
                oVar.d("Cannot invalidate item decorations during a scroll or layout");
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
        l lVar = this.mItemAnimator;
        return lVar != null && lVar.h();
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
        return getScrollingChildHelper().f1151d;
    }

    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.K0(i2);
            awakenScrollBars();
        }
    }

    public void markItemDecorInsetsDirty() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((p) this.mChildHelper.g(i2).getLayoutParams()).f231c = true;
        }
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) vVar.f241c.get(i3).itemView.getLayoutParams();
            if (pVar != null) {
                pVar.f231c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        for (int i3 = 0; i3 < size; i3++) {
            d0 d0Var = vVar.f241c.get(i3);
            if (d0Var != null) {
                d0Var.addFlags(6);
                d0Var.addChangePayload(null);
            }
        }
        g gVar = RecyclerView.this.mAdapter;
        if (gVar == null || !gVar.hasStableIds()) {
            vVar.f();
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int e2 = this.mChildHelper.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.mChildHelper.d(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int e2 = this.mChildHelper.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.mChildHelper.d(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int h2 = this.mChildHelper.h();
        for (int i4 = 0; i4 < h2; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        for (int i5 = 0; i5 < size; i5++) {
            d0 d0Var = vVar.f241c.get(i5);
            if (d0Var != null && d0Var.mPosition >= i2) {
                d0Var.offsetPosition(i3, true);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int h2 = this.mChildHelper.h();
        int i11 = -1;
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i12 = 0; i12 < h2; i12++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && (i10 = childViewHolderInt.mPosition) >= i6 && i10 <= i5) {
                if (i10 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i4, false);
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i11 = 1;
            i8 = i3;
        }
        int size = vVar.f241c.size();
        for (int i13 = 0; i13 < size; i13++) {
            d0 d0Var = vVar.f241c.get(i13);
            if (d0Var != null && (i9 = d0Var.mPosition) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    d0Var.offsetPosition(i3 - i2, false);
                } else {
                    d0Var.offsetPosition(i11, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.mChildHelper.h();
        for (int i5 = 0; i5 < h2; i5++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        while (true) {
            size--;
            if (size >= 0) {
                d0 d0Var = vVar.f241c.get(size);
                if (d0Var != null) {
                    int i7 = d0Var.mPosition;
                    if (i7 >= i4) {
                        d0Var.offsetPosition(-i3, z2);
                    } else if (i7 >= i2) {
                        d0Var.addFlags(8);
                        vVar.g(size);
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
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.i = true;
            oVar.d0();
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            b.q.d.r rVar = b.q.d.r.f.get();
            this.mGapWorker = rVar;
            if (rVar == null) {
                this.mGapWorker = new b.q.d.r();
                Display j2 = b.i.l.m.j(this);
                float f2 = 60.0f;
                if (!isInEditMode() && j2 != null) {
                    float refreshRate = j2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                b.q.d.r rVar2 = this.mGapWorker;
                rVar2.f1576d = (long) (1.0E9f / f2);
                b.q.d.r.f.set(rVar2);
            }
            this.mGapWorker.f1574b.add(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onDetachedFromWindow() {
        b.q.d.r rVar;
        super.onDetachedFromWindow();
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.g();
        }
        stopScroll();
        this.mIsAttached = false;
        o oVar = this.mLayout;
        if (oVar != null) {
            v vVar = this.mRecycler;
            oVar.i = false;
            oVar.f0(this, vVar);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        if (this.mViewInfoStore != null) {
            do {
            } while (g0.a.f1507d.a() != null);
            if (ALLOW_THREAD_GAP_WORK && (rVar = this.mGapWorker) != null) {
                rVar.f1574b.remove(this);
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
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).d(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.mLayout.f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.e()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.f()) {
                        f3 = -axisValue;
                    } else if (this.mLayout.e()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f3 = 0.0f;
                f2 = 0.0f;
                scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
            }
            f2 = 0.0f;
            scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        boolean e2 = oVar.e();
        boolean f2 = this.mLayout.f();
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
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = e2 ? 1 : 0;
            if (f2) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y3 - this.mInitialTouchY;
                if (!e2 || Math.abs(i3) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.mLastTouchX = x3;
                    z2 = true;
                }
                if (f2 && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b.i.h.b.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    public void onMeasure(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.U()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.u0(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.mAdapter != null) {
                if (this.mState.f200d == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.N0(i2, i3);
                this.mState.i = true;
                dispatchLayoutStep2();
                this.mLayout.P0(i2, i3);
                if (this.mLayout.S0()) {
                    this.mLayout.N0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.i = true;
                    dispatchLayoutStep2();
                    this.mLayout.P0(i2, i3);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.u0(i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                a0 a0Var = this.mState;
                if (a0Var.k) {
                    a0Var.g = true;
                } else {
                    this.mAdapterHelper.c();
                    this.mState.g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.mAdapter;
            if (gVar != null) {
                this.mState.f201e = gVar.getItemCount();
            } else {
                this.mState.f201e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.u0(i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.g = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.mPendingSavedState = yVar;
        super.onRestoreInstanceState(yVar.f1231b);
        o oVar = this.mLayout;
        if (oVar != null && (parcelable2 = this.mPendingSavedState.f245d) != null) {
            oVar.x0(parcelable2);
        }
    }

    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.mPendingSavedState;
        if (yVar2 != null) {
            yVar.f245d = yVar2.f245d;
        } else {
            o oVar = this.mLayout;
            yVar.f245d = oVar != null ? oVar.y0() : null;
        }
        return yVar;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d7  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        boolean e2 = oVar.e();
        boolean f2 = this.mLayout.f();
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
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            int i2 = e2 ? 1 : 0;
            if (f2) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(obtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
            float f3 = e2 ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
            float f4 = f2 ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
            if ((f3 == 0.0f && f4 == 0.0f) || !fling((int) f3, (int) f4)) {
                setScrollState(0);
            }
            resetScroll();
            z3 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i3 = this.mLastTouchX - x3;
            int i4 = this.mLastTouchY - y3;
            if (this.mScrollState != 1) {
                if (e2) {
                    int i5 = this.mTouchSlop;
                    i3 = i3 > 0 ? Math.max(0, i3 - i5) : Math.min(0, i3 + i5);
                    if (i3 != 0) {
                        z2 = true;
                        if (f2) {
                            int i6 = this.mTouchSlop;
                            i4 = i4 > 0 ? Math.max(0, i4 - i6) : Math.min(0, i4 + i6);
                            if (i4 != 0) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                }
                z2 = false;
                if (f2) {
                }
                if (z2) {
                }
            }
            int i7 = i3;
            int i8 = i4;
            if (this.mScrollState == 1) {
                int[] iArr3 = this.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (dispatchNestedPreScroll(e2 ? i7 : 0, f2 ? i8 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                    int[] iArr4 = this.mReusableIntPair;
                    i7 -= iArr4[0];
                    i8 -= iArr4[1];
                    int[] iArr5 = this.mNestedOffsets;
                    int i9 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i9 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int[] iArr7 = this.mScrollOffset;
                this.mLastTouchX = x3 - iArr7[0];
                this.mLastTouchY = y3 - iArr7[1];
                if (scrollByInternal(e2 ? i7 : 0, f2 ? i8 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.mGapWorker == null || (i7 == 0 && i8 == 0))) {
                    this.mGapWorker.a(this, i7, i8);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z3) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            b.i.l.m.M(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(d0 d0Var, l.c cVar) {
        d0Var.setFlags(0, d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        if (this.mState.h && d0Var.isUpdated() && !d0Var.isRemoved() && !d0Var.shouldIgnore()) {
            this.mViewInfoStore.f1506b.g(getChangedHolderKey(d0Var), d0Var);
        }
        this.mViewInfoStore.c(d0Var, cVar);
    }

    public void removeAndRecycleViews() {
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.g();
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.C0(this.mRecycler);
            this.mLayout.D0(this.mRecycler);
        }
        this.mRecycler.b();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        b.q.d.f fVar = this.mChildHelper;
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        boolean z2 = true;
        if (indexOfChild == -1) {
            fVar.l(view);
        } else if (fVar.f1492b.d(indexOfChild)) {
            fVar.f1492b.f(indexOfChild);
            fVar.l(view);
            ((e) fVar.f1491a).c(indexOfChild);
        } else {
            z2 = false;
        }
        if (z2) {
            d0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.l(childViewHolderInt);
            this.mRecycler.i(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z2);
        return z2;
    }

    public void removeDetachedView(View view, boolean z2) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(c.a.a.a.a.j(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(n nVar) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.d("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(nVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeOnChildAttachStateChangeListener(q qVar) {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(qVar);
        }
    }

    public void removeOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.remove(sVar);
        if (this.mInterceptingOnItemTouchListener == sVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(t tVar) {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void repositionShadowingViews() {
        d0 d0Var;
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            View d2 = this.mChildHelper.d(i2);
            d0 childViewHolder = getChildViewHolder(d2);
            if (!(childViewHolder == null || (d0Var = childViewHolder.mShadowingHolder) == null)) {
                View view = d0Var.itemView;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.w0(this, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.H0(this, view, rect, z2, false);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar != null && !this.mLayoutSuppressed) {
            boolean e2 = oVar.e();
            boolean f2 = this.mLayout.f();
            if (e2 || f2) {
                if (!e2) {
                    i2 = 0;
                }
                if (!f2) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, null);
            }
        }
    }

    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i7 = i9;
            i6 = i8;
            i5 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i6, i7, i5, i4, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i10 = i5 - iArr4[0];
        int i11 = i4 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), (float) i10, motionEvent.getY(), (float) i11);
                }
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (!(i6 == 0 && i7 == 0)) {
            dispatchOnScrolled(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i6 == 0 && i7 == 0) ? false : true;
    }

    public void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        b.i.h.b.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int J0 = i2 != 0 ? this.mLayout.J0(i2, this.mRecycler, this.mState) : 0;
        int L0 = i3 != 0 ? this.mLayout.L0(i3, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = J0;
            iArr[1] = L0;
        }
    }

    public void scrollTo(int i2, int i3) {
    }

    public void scrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            o oVar = this.mLayout;
            if (oVar != null) {
                oVar.K0(i2);
                awakenScrollBars();
            }
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(b.q.d.b0 b0Var) {
        this.mAccessibilityDelegate = b0Var;
        b.i.l.m.T(this, b0Var);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = jVar;
            setChildrenDrawingOrderEnabled(jVar != null);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(d0 d0Var, int i2) {
        if (isComputingLayout()) {
            d0Var.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(d0Var);
            return false;
        }
        b.i.l.m.a0(d0Var.itemView, i2);
        return true;
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        if (kVar != null) {
            this.mEdgeEffectFactory = kVar;
            invalidateGlows();
            return;
        }
        throw null;
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.mItemAnimator;
        if (lVar2 != null) {
            lVar2.g();
            this.mItemAnimator.f210a = null;
        }
        this.mItemAnimator = lVar;
        if (lVar != null) {
            lVar.f210a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i2) {
        v vVar = this.mRecycler;
        vVar.f243e = i2;
        vVar.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                l lVar = this.mItemAnimator;
                if (lVar != null) {
                    lVar.g();
                }
                this.mLayout.C0(this.mRecycler);
                this.mLayout.D0(this.mRecycler);
                this.mRecycler.b();
                if (this.mIsAttached) {
                    o oVar2 = this.mLayout;
                    v vVar = this.mRecycler;
                    oVar2.i = false;
                    oVar2.f0(this, vVar);
                }
                this.mLayout.Q0(null);
                this.mLayout = null;
            } else {
                this.mRecycler.b();
            }
            b.q.d.f fVar = this.mChildHelper;
            f.a aVar = fVar.f1492b;
            aVar.f1494a = 0;
            f.a aVar2 = aVar.f1495b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = fVar.f1493c.size();
            while (true) {
                size--;
                if (size >= 0) {
                    f.b bVar = fVar.f1491a;
                    View view = fVar.f1493c.get(size);
                    e eVar = (e) bVar;
                    if (eVar != null) {
                        d0 childViewHolderInt = getChildViewHolderInt(view);
                        if (childViewHolderInt != null) {
                            childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                        }
                        fVar.f1493c.remove(size);
                    } else {
                        throw null;
                    }
                } else {
                    e eVar2 = (e) fVar.f1491a;
                    int b2 = eVar2.b();
                    for (int i2 = 0; i2 < b2; i2++) {
                        View a2 = eVar2.a(i2);
                        RecyclerView.this.dispatchChildDetached(a2);
                        a2.clearAnimation();
                    }
                    RecyclerView.this.removeAllViews();
                    this.mLayout = oVar;
                    if (oVar != null) {
                        if (oVar.f219b == null) {
                            oVar.Q0(this);
                            if (this.mIsAttached) {
                                o oVar3 = this.mLayout;
                                oVar3.i = true;
                                oVar3.d0();
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("LayoutManager ");
                            sb.append(oVar);
                            sb.append(" is already attached to a RecyclerView:");
                            throw new IllegalArgumentException(c.a.a.a.a.j(oVar.f219b, sb));
                        }
                    }
                    this.mRecycler.m();
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

    public void setNestedScrollingEnabled(boolean z2) {
        b.i.l.f scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f1151d) {
            b.i.l.m.f0(scrollingChildHelper.f1150c);
        }
        scrollingChildHelper.f1151d = z2;
    }

    public void setOnFlingListener(r rVar) {
        this.mOnFlingListener = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.mScrollListener = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(u uVar) {
        v vVar = this.mRecycler;
        u uVar2 = vVar.g;
        if (uVar2 != null) {
            uVar2.f234b--;
        }
        vVar.g = uVar;
        if (uVar != null && RecyclerView.this.getAdapter() != null) {
            vVar.g.f234b++;
        }
    }

    public void setRecyclerListener(w wVar) {
        this.mRecyclerListener = wVar;
    }

    public void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = i2 != 1 ? viewConfiguration.getScaledTouchSlop() : viewConfiguration.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
        if (contentChangeTypes != 0) {
            i2 = contentChangeTypes;
        }
        this.mEatenAccessibilityChangeFlags |= i2;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.mLayout;
        if (oVar != null && !this.mLayoutSuppressed) {
            int i5 = 0;
            if (!oVar.e()) {
                i2 = 0;
            }
            if (!this.mLayout.f()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        startNestedScroll(i5, 1);
                    }
                    this.mViewFlinger.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void smoothScrollToPosition(int i2) {
        o oVar;
        if (!this.mLayoutSuppressed && (oVar = this.mLayout) != null) {
            oVar.U0(this, this.mState, i2);
        }
    }

    public void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().h(i2, 0);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().h(i2, i3);
    }

    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().i(i2);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(g gVar, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int h2 = this.mChildHelper.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < h2; i7++) {
            View g2 = this.mChildHelper.g(i7);
            d0 childViewHolderInt = getChildViewHolderInt(g2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i5 = childViewHolderInt.mPosition) >= i2 && i5 < i6) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((p) g2.getLayoutParams()).f231c = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f241c.size();
        while (true) {
            size--;
            if (size >= 0) {
                d0 d0Var = vVar.f241c.get(size);
                if (d0Var != null && (i4 = d0Var.mPosition) >= i2 && i4 < i6) {
                    d0Var.addFlags(2);
                    vVar.g(size);
                }
            } else {
                return;
            }
        }
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, null);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().f(i2) != null;
    }
}
