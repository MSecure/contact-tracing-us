package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final AnchorInfo mAnchorInfo;
    public final Runnable mCheckForGapsRunnable;
    public int mFullSizeSpec;
    public int mGapStrategy;
    public boolean mLaidOutInvalidFullSpan;
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    public final LayoutState mLayoutState;
    public LazySpanLookup mLazySpanLookup;
    public int mOrientation;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public int[] mPrefetchDistances;
    public OrientationHelper mPrimaryOrientation;
    public BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public OrientationHelper mSecondaryOrientation;
    public boolean mShouldReverseLayout;
    public int mSizePerSpan;
    public boolean mSmoothScrollbarEnabled;
    public int mSpanCount = -1;
    public Span[] mSpans;
    public final Rect mTmpRect;

    public class AnchorInfo {
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            int i;
            if (this.mLayoutFromEnd) {
                i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = i;
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = RecyclerView.UNDEFINED_DURATION;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public boolean mFullSpan;
        public Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    public class Span {
        public int mCachedEnd = RecyclerView.UNDEFINED_DURATION;
        public int mCachedStart = RecyclerView.UNDEFINED_DURATION;
        public int mDeletedSize = 0;
        public final int mIndex;
        public ArrayList<View> mViews = new ArrayList<>();

        public Span(int i) {
            this.mIndex = i;
        }

        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = RecyclerView.UNDEFINED_DURATION;
            if (this.mViews.size() == 1) {
                this.mCachedStart = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }

        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.mViews;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                int i = this.mCachedEnd;
                int i2 = this.mIndex;
                int[] iArr = fullSpanItem.mGapPerSpan;
                this.mCachedEnd = i + (iArr == null ? 0 : iArr[i2]);
            }
        }

        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            int i = 0;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                int i2 = this.mCachedStart;
                int i3 = this.mIndex;
                int[] iArr = fullSpanItem.mGapPerSpan;
                if (iArr != null) {
                    i = iArr[i3];
                }
                this.mCachedStart = i2 - i;
            }
        }

        public void clear() {
            this.mViews.clear();
            this.mCachedStart = RecyclerView.UNDEFINED_DURATION;
            this.mCachedEnd = RecyclerView.UNDEFINED_DURATION;
            this.mDeletedSize = 0;
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findOnePartiallyVisibleChild(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.mViews.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z2 = false;
                boolean z3 = !z ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding;
                if (!z ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z2 = true;
                }
                if (z3 && z2 && (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding)) {
                    return StaggeredGridLayoutManager.this.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        public int getEndLine(int i) {
            int i2 = this.mCachedEnd;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.mViews.size() - 1;
                while (size >= 0) {
                    View view2 = this.mViews.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.mViews.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.mViews.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int getStartLine(int i) {
            int i2 = this.mCachedStart;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void popEnd() {
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = RecyclerView.UNDEFINED_DURATION;
            }
            this.mCachedEnd = RecyclerView.UNDEFINED_DURATION;
        }

        public void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = RecyclerView.UNDEFINED_DURATION;
        }

        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = RecyclerView.UNDEFINED_DURATION;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = RecyclerView.UNDEFINED_DURATION;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() {
            /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.AnonymousClass1 */

            public void run() {
                StaggeredGridLayoutManager.this.checkForGaps();
            }
        };
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 == 0 || i3 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i3 != this.mOrientation) {
                this.mOrientation = i3;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
            }
            int i4 = properties.spanCount;
            assertNotInLayoutOrScroll(null);
            if (i4 != this.mSpanCount) {
                this.mLazySpanLookup.clear();
                requestLayout();
                this.mSpanCount = i4;
                this.mRemainingSpans = new BitSet(this.mSpanCount);
                this.mSpans = new Span[this.mSpanCount];
                for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                    this.mSpans[i5] = new Span(i5);
                }
                requestLayout();
            }
            boolean z = properties.reverseLayout;
            assertNotInLayoutOrScroll(null);
            SavedState savedState = this.mPendingSavedState;
            if (!(savedState == null || savedState.mReverseLayout == z)) {
                savedState.mReverseLayout = z;
            }
            this.mReverseLayout = z;
            requestLayout();
            this.mLayoutState = new LayoutState();
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        RecyclerView recyclerView;
        if (this.mPendingSavedState == null && (recyclerView = this.mRecyclerView) != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public final int calculateScrollDirectionForPosition(int i) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? 1 : -1;
        }
        return (i < getFirstChildPosition()) != this.mShouldReverseLayout ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !this.mIsAttachedToWindow) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i2 = getLastChildPosition();
            i = getFirstChildPosition();
        } else {
            i2 = getFirstChildPosition();
            i = getLastChildPosition();
        }
        if (i2 == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            this.mRequestedSimpleAnimations = true;
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            int i3 = this.mShouldReverseLayout ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(i2, i4, i3, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(i2, firstFullSpanItemInRange.mPosition, i3 * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
            }
            this.mRequestedSimpleAnimations = true;
            requestLayout();
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        int i4;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (!(getChildCount() == 0 || i == 0)) {
            prepareLayoutStateForDelta(i, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                LayoutState layoutState = this.mLayoutState;
                if (layoutState.mItemDirection == -1) {
                    i4 = layoutState.mStartLine;
                    i3 = this.mSpans[i6].getStartLine(i4);
                } else {
                    i4 = this.mSpans[i6].getEndLine(layoutState.mEndLine);
                    i3 = this.mLayoutState.mEndLine;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.mPrefetchDistances[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.mPrefetchDistances, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = this.mLayoutState.mCurrentPosition;
                if (i9 >= 0 && i9 < state.getItemCount()) {
                    ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i8]);
                    LayoutState layoutState2 = this.mLayoutState;
                    layoutState2.mCurrentPosition += layoutState2.mItemDirection;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        } else {
            pointF.x = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            pointF.y = (float) calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0363  */
    public final int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        Span span;
        int i4;
        int i5;
        int i6;
        int i7;
        LayoutParams layoutParams;
        boolean z;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        boolean z4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        RecyclerView.Recycler recycler2 = recycler;
        boolean z5 = false;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite) {
            i = layoutState.mLayoutDirection == 1 ? Integer.MAX_VALUE : RecyclerView.UNDEFINED_DURATION;
        } else {
            if (layoutState.mLayoutDirection == 1) {
                i15 = layoutState.mEndLine + layoutState.mAvailable;
            } else {
                i15 = layoutState.mStartLine - layoutState.mAvailable;
            }
            i = i15;
        }
        updateAllRemainingSpans(layoutState.mLayoutDirection, i);
        if (this.mShouldReverseLayout) {
            i2 = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            i2 = this.mPrimaryOrientation.getStartAfterPadding();
        }
        Object[] objArr = null;
        while (true) {
            int i16 = layoutState.mCurrentPosition;
            if (((i16 < 0 || i16 >= state.getItemCount()) ? z5 : true) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
                View view = recycler2.tryGetViewHolderForPositionByDeadline(layoutState.mCurrentPosition, z5, RecyclerView.FOREVER_NS).itemView;
                layoutState.mCurrentPosition += layoutState.mItemDirection;
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                int viewLayoutPosition = layoutParams2.getViewLayoutPosition();
                int[] iArr = this.mLazySpanLookup.mData;
                int i17 = (iArr == null || viewLayoutPosition >= iArr.length) ? -1 : iArr[viewLayoutPosition];
                boolean z6 = i17 == -1 ? true : z5;
                if (z6) {
                    if (layoutParams2.mFullSpan) {
                        Span[] spanArr = this.mSpans;
                        char c = z5 ? 1 : 0;
                        char c2 = z5 ? 1 : 0;
                        char c3 = z5 ? 1 : 0;
                        span = spanArr[c];
                    } else {
                        if (preferLastSpan(layoutState.mLayoutDirection)) {
                            i14 = this.mSpanCount - 1;
                            i13 = -1;
                            i12 = -1;
                        } else {
                            i13 = this.mSpanCount;
                            int i18 = z5 ? 1 : 0;
                            Object[] objArr2 = z5 ? 1 : 0;
                            Object[] objArr3 = z5 ? 1 : 0;
                            i14 = i18;
                            i12 = 1;
                        }
                        Span span2 = null;
                        if (layoutState.mLayoutDirection == 1) {
                            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                            int i19 = Integer.MAX_VALUE;
                            while (i14 != i13) {
                                Span span3 = this.mSpans[i14];
                                int endLine = span3.getEndLine(startAfterPadding);
                                if (endLine < i19) {
                                    span2 = span3;
                                    i19 = endLine;
                                }
                                i14 += i12;
                            }
                        } else {
                            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                            int i20 = RecyclerView.UNDEFINED_DURATION;
                            while (i14 != i13) {
                                Span span4 = this.mSpans[i14];
                                int startLine = span4.getStartLine(endAfterPadding);
                                if (startLine > i20) {
                                    span2 = span4;
                                    i20 = startLine;
                                }
                                i14 += i12;
                            }
                        }
                        span = span2;
                    }
                    LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
                    lazySpanLookup.ensureSize(viewLayoutPosition);
                    lazySpanLookup.mData[viewLayoutPosition] = span.mIndex;
                } else {
                    span = this.mSpans[i17];
                }
                layoutParams2.mSpan = span;
                if (layoutState.mLayoutDirection == 1) {
                    addViewInt(view, -1, false);
                } else {
                    addViewInt(view, 0, false);
                }
                if (layoutParams2.mFullSpan) {
                    if (this.mOrientation == 1) {
                        measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(this.mHeight, this.mHeightMode, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true), false);
                    } else {
                        measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mWidth, this.mWidthMode, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), this.mFullSizeSpec, false);
                    }
                } else if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, this.mWidthMode, 0, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(this.mHeight, this.mHeightMode, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true), false);
                } else {
                    measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mWidth, this.mWidthMode, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, this.mHeightMode, 0, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false), false);
                }
                if (layoutState.mLayoutDirection == 1) {
                    if (layoutParams2.mFullSpan) {
                        i11 = getMaxEnd(i2);
                    } else {
                        i11 = span.getEndLine(i2);
                    }
                    int decoratedMeasurement = this.mPrimaryOrientation.getDecoratedMeasurement(view) + i11;
                    if (z6 && layoutParams2.mFullSpan) {
                        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
                        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
                        for (int i21 = 0; i21 < this.mSpanCount; i21++) {
                            fullSpanItem.mGapPerSpan[i21] = i11 - this.mSpans[i21].getEndLine(i11);
                        }
                        fullSpanItem.mGapDir = -1;
                        fullSpanItem.mPosition = viewLayoutPosition;
                        this.mLazySpanLookup.addFullSpanItem(fullSpanItem);
                    }
                    i5 = i11;
                    i4 = decoratedMeasurement;
                } else {
                    if (layoutParams2.mFullSpan) {
                        i10 = getMinStart(i2);
                    } else {
                        i10 = span.getStartLine(i2);
                    }
                    int decoratedMeasurement2 = i10 - this.mPrimaryOrientation.getDecoratedMeasurement(view);
                    if (z6 && layoutParams2.mFullSpan) {
                        LazySpanLookup.FullSpanItem fullSpanItem2 = new LazySpanLookup.FullSpanItem();
                        fullSpanItem2.mGapPerSpan = new int[this.mSpanCount];
                        for (int i22 = 0; i22 < this.mSpanCount; i22++) {
                            fullSpanItem2.mGapPerSpan[i22] = this.mSpans[i22].getStartLine(i10) - i10;
                        }
                        fullSpanItem2.mGapDir = 1;
                        fullSpanItem2.mPosition = viewLayoutPosition;
                        this.mLazySpanLookup.addFullSpanItem(fullSpanItem2);
                    }
                    i4 = i10;
                    i5 = decoratedMeasurement2;
                }
                if (layoutParams2.mFullSpan && layoutState.mItemDirection == -1) {
                    if (z6) {
                        this.mLaidOutInvalidFullSpan = true;
                    } else {
                        if (layoutState.mLayoutDirection == 1) {
                            int endLine2 = this.mSpans[0].getEndLine(RecyclerView.UNDEFINED_DURATION);
                            int i23 = 1;
                            while (true) {
                                if (i23 >= this.mSpanCount) {
                                    z4 = true;
                                    break;
                                } else if (this.mSpans[i23].getEndLine(RecyclerView.UNDEFINED_DURATION) != endLine2) {
                                    z4 = false;
                                    break;
                                } else {
                                    i23++;
                                }
                            }
                            z2 = !z4;
                        } else {
                            int startLine2 = this.mSpans[0].getStartLine(RecyclerView.UNDEFINED_DURATION);
                            int i24 = 1;
                            while (true) {
                                if (i24 >= this.mSpanCount) {
                                    z3 = true;
                                    break;
                                } else if (this.mSpans[i24].getStartLine(RecyclerView.UNDEFINED_DURATION) != startLine2) {
                                    z3 = false;
                                    break;
                                } else {
                                    i24++;
                                }
                            }
                            z2 = !z3;
                        }
                        if (z2) {
                            LazySpanLookup.FullSpanItem fullSpanItem3 = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                            if (fullSpanItem3 != null) {
                                fullSpanItem3.mHasUnwantedGapAfter = true;
                            }
                            this.mLaidOutInvalidFullSpan = true;
                        }
                        if (layoutState.mLayoutDirection != 1) {
                            if (layoutParams2.mFullSpan) {
                                int i25 = this.mSpanCount;
                                while (true) {
                                    i25--;
                                    if (i25 < 0) {
                                        break;
                                    }
                                    this.mSpans[i25].appendToSpan(view);
                                }
                            } else {
                                layoutParams2.mSpan.appendToSpan(view);
                            }
                        } else if (layoutParams2.mFullSpan) {
                            int i26 = this.mSpanCount;
                            while (true) {
                                i26--;
                                if (i26 < 0) {
                                    break;
                                }
                                this.mSpans[i26].prependToSpan(view);
                            }
                        } else {
                            layoutParams2.mSpan.prependToSpan(view);
                        }
                        if (isLayoutRTL() || this.mOrientation != 1) {
                            if (!layoutParams2.mFullSpan) {
                                i8 = this.mSecondaryOrientation.getStartAfterPadding();
                            } else {
                                i8 = (span.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                            }
                            i7 = i8;
                            i6 = this.mSecondaryOrientation.getDecoratedMeasurement(view) + i8;
                        } else {
                            if (layoutParams2.mFullSpan) {
                                i9 = this.mSecondaryOrientation.getEndAfterPadding();
                            } else {
                                i9 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span.mIndex) * this.mSizePerSpan);
                            }
                            i6 = i9;
                            i7 = i9 - this.mSecondaryOrientation.getDecoratedMeasurement(view);
                        }
                        if (this.mOrientation != 1) {
                            layoutDecoratedWithMargins(view, i7, i5, i6, i4);
                            layoutParams = layoutParams2;
                        } else {
                            layoutParams = layoutParams2;
                            layoutDecoratedWithMargins(view, i5, i7, i4, i6);
                        }
                        if (!layoutParams.mFullSpan) {
                            updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
                        } else {
                            updateRemainingSpans(span, this.mLayoutState.mLayoutDirection, i);
                        }
                        recycle(recycler, this.mLayoutState);
                        if (this.mLayoutState.mStopInFocusable && view.hasFocusable()) {
                            if (!layoutParams.mFullSpan) {
                                this.mRemainingSpans.clear();
                            } else {
                                z = false;
                                this.mRemainingSpans.set(span.mIndex, false);
                                recycler2 = recycler;
                                z5 = z;
                                objArr = 1;
                            }
                        }
                        z = false;
                        recycler2 = recycler;
                        z5 = z;
                        objArr = 1;
                    }
                }
                if (layoutState.mLayoutDirection != 1) {
                }
                if (isLayoutRTL()) {
                }
                if (!layoutParams2.mFullSpan) {
                }
                i7 = i8;
                i6 = this.mSecondaryOrientation.getDecoratedMeasurement(view) + i8;
                if (this.mOrientation != 1) {
                }
                if (!layoutParams.mFullSpan) {
                }
                recycle(recycler, this.mLayoutState);
                if (!layoutParams.mFullSpan) {
                }
            }
        }
        if (objArr == null) {
            recycle(recycler2, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            i3 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            i3 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (i3 > 0) {
            return Math.min(layoutState.mAvailable, i3);
        }
        int i27 = z5 ? 1 : 0;
        int i28 = z5 ? 1 : 0;
        int i29 = z5 ? 1 : 0;
        return i27;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(RecyclerView.UNDEFINED_DURATION);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.mPrimaryOrientation.offsetChildren(i);
            }
        }
    }

    public final void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    public final int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    public final void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int lastChildPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 != 8) {
            i5 = i + i2;
        } else if (i < i2) {
            i5 = i2 + 1;
        } else {
            i5 = i + 1;
            i4 = i2;
            this.mLazySpanLookup.invalidateAfter(i4);
            if (i3 != 1) {
                this.mLazySpanLookup.offsetForAddition(i, i2);
            } else if (i3 == 2) {
                this.mLazySpanLookup.offsetForRemoval(i, i2);
            } else if (i3 == 8) {
                this.mLazySpanLookup.offsetForRemoval(i, 1);
                this.mLazySpanLookup.offsetForAddition(i2, 1);
            }
            if (i5 <= lastChildPosition) {
                if (i4 <= (this.mShouldReverseLayout ? getFirstChildPosition() : getLastChildPosition())) {
                    requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        i4 = i;
        this.mLazySpanLookup.invalidateAfter(i4);
        if (i3 != 1) {
        }
        if (i5 <= lastChildPosition) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0099 A[SYNTHETIC] */
    public View hasGapsToFix() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        char c = (this.mOrientation != 1 || !isLayoutRTL()) ? (char) 65535 : 1;
        if (this.mShouldReverseLayout) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i3 = childCount < i ? 1 : -1;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                Span span = layoutParams.mSpan;
                if (this.mShouldReverseLayout) {
                    int i4 = span.mCachedEnd;
                    if (i4 == Integer.MIN_VALUE) {
                        span.calculateCachedEnd();
                        i4 = span.mCachedEnd;
                    }
                    if (i4 < this.mPrimaryOrientation.getEndAfterPadding()) {
                        ArrayList<View> arrayList = span.mViews;
                        z2 = span.getLayoutParams(arrayList.get(arrayList.size() - 1)).mFullSpan;
                    }
                    z = false;
                    if (z) {
                        return childAt;
                    }
                    bitSet.clear(layoutParams.mSpan.mIndex);
                } else {
                    int i5 = span.mCachedStart;
                    if (i5 == Integer.MIN_VALUE) {
                        span.calculateCachedStart();
                        i5 = span.mCachedStart;
                    }
                    if (i5 > this.mPrimaryOrientation.getStartAfterPadding()) {
                        z2 = span.getLayoutParams(span.mViews.get(0)).mFullSpan;
                    }
                    z = false;
                    if (z) {
                    }
                }
                z = !z2;
                if (z) {
                }
            }
            if (!layoutParams.mFullSpan && (i2 = childCount + i3) != i) {
                View childAt2 = getChildAt(i2);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                }
                boolean z3 = true;
                if (!z3) {
                    continue;
                } else {
                    if ((layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) != (c < 0)) {
                        return childAt;
                    }
                }
            }
            childCount += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean z2;
        Rect rect = this.mTmpRect;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i, i3 + rect2.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect2.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect3 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, i4 + rect3.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect3.bottom);
        if (z) {
            z2 = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (z2) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i);
        }
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i);
        }
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        onDetachedFromWindow();
        Runnable runnable = this.mCheckForGapsRunnable;
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        if (r9.mOrientation == 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r9.mOrientation == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (isLayoutRTL() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (isLayoutRTL() == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        if (i == 1) {
            if (this.mOrientation != 1) {
            }
            i2 = -1;
            if (i2 == Integer.MIN_VALUE) {
            }
        } else if (i != 2) {
            if (i != 17) {
                if (i != 33) {
                    if (i == 66) {
                    }
                }
            }
            i2 = Integer.MIN_VALUE;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
            boolean z = layoutParams.mFullSpan;
            Span span = layoutParams.mSpan;
            if (i2 == 1) {
                i3 = getLastChildPosition();
            } else {
                i3 = getFirstChildPosition();
            }
            updateLayoutState(i3, state);
            setLayoutStateDirection(i2);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = layoutState.mItemDirection + i3;
            layoutState.mAvailable = (int) (((float) this.mPrimaryOrientation.getTotalSpace()) * 0.33333334f);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mStopInFocusable = true;
            layoutState2.mRecycle = false;
            fill(recycler, layoutState2, state);
            this.mLastLayoutFromEnd = this.mShouldReverseLayout;
            if (!(z || (focusableViewAfter = span.getFocusableViewAfter(i3, i2)) == null || focusableViewAfter == findContainingItemView)) {
                return focusableViewAfter;
            }
            if (preferLastSpan(i2)) {
                for (int i7 = this.mSpanCount - 1; i7 >= 0; i7--) {
                    View focusableViewAfter2 = this.mSpans[i7].getFocusableViewAfter(i3, i2);
                    if (!(focusableViewAfter2 == null || focusableViewAfter2 == findContainingItemView)) {
                        return focusableViewAfter2;
                    }
                }
            } else {
                for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                    View focusableViewAfter3 = this.mSpans[i8].getFocusableViewAfter(i3, i2);
                    if (!(focusableViewAfter3 == null || focusableViewAfter3 == findContainingItemView)) {
                        return focusableViewAfter3;
                    }
                }
            }
            boolean z2 = (this.mReverseLayout ^ true) == (i2 == -1);
            if (!z) {
                if (z2) {
                    i6 = span.findFirstPartiallyVisibleItemPosition();
                } else {
                    i6 = span.findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition = findViewByPosition(i6);
                if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                    return findViewByPosition;
                }
            }
            if (preferLastSpan(i2)) {
                for (int i9 = this.mSpanCount - 1; i9 >= 0; i9--) {
                    if (i9 != span.mIndex) {
                        if (z2) {
                            i5 = this.mSpans[i9].findFirstPartiallyVisibleItemPosition();
                        } else {
                            i5 = this.mSpans[i9].findLastPartiallyVisibleItemPosition();
                        }
                        View findViewByPosition2 = findViewByPosition(i5);
                        if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                            return findViewByPosition2;
                        }
                    }
                }
            } else {
                for (int i10 = 0; i10 < this.mSpanCount; i10++) {
                    if (z2) {
                        i4 = this.mSpans[i10].findFirstPartiallyVisibleItemPosition();
                    } else {
                        i4 = this.mSpans[i10].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition3 = findViewByPosition(i4);
                    if (!(findViewByPosition3 == null || findViewByPosition3 == findContainingItemView)) {
                        return findViewByPosition3;
                    }
                }
            }
            return null;
        } else if (this.mOrientation != 1) {
        }
        i2 = 1;
        if (i2 == Integer.MIN_VALUE) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        RecyclerView.Recycler recycler = this.mRecyclerView.mRecycler;
        onInitializeAccessibilityEvent1(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i = 1;
        int i2 = -1;
        if (this.mOrientation == 0) {
            Span span = layoutParams2.mSpan;
            if (span != null) {
                i2 = span.mIndex;
            }
            if (layoutParams2.mFullSpan) {
                i = this.mSpanCount;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i2, i, -1, -1, false, false));
            return;
        }
        Span span2 = layoutParams2.mSpan;
        if (span2 != null) {
            i2 = span2.mIndex;
        }
        if (layoutParams2.mFullSpan) {
            i = this.mSpanCount;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, i2, i, false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = RecyclerView.UNDEFINED_DURATION;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int i;
        View view;
        int i2;
        int i3;
        int[] iArr;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.mReverseLayout = this.mReverseLayout;
        savedState2.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState2.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.mData) == null) {
            savedState2.mSpanLookupSize = 0;
        } else {
            savedState2.mSpanLookup = iArr;
            savedState2.mSpanLookupSize = iArr.length;
            savedState2.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        }
        int i4 = -1;
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                i = getLastChildPosition();
            } else {
                i = getFirstChildPosition();
            }
            savedState2.mAnchorPosition = i;
            if (this.mShouldReverseLayout) {
                view = findFirstVisibleItemClosestToEnd(true);
            } else {
                view = findFirstVisibleItemClosestToStart(true);
            }
            if (view != null) {
                i4 = getPosition(view);
            }
            savedState2.mVisibleAnchorPosition = i4;
            int i5 = this.mSpanCount;
            savedState2.mSpanOffsetsSize = i5;
            savedState2.mSpanOffsets = new int[i5];
            for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                if (this.mLastLayoutFromEnd) {
                    i2 = this.mSpans[i6].getEndLine(RecyclerView.UNDEFINED_DURATION);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.mPrimaryOrientation.getEndAfterPadding();
                    } else {
                        savedState2.mSpanOffsets[i6] = i2;
                    }
                } else {
                    i2 = this.mSpans[i6].getStartLine(RecyclerView.UNDEFINED_DURATION);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.mPrimaryOrientation.getStartAfterPadding();
                    } else {
                        savedState2.mSpanOffsets[i6] = i2;
                    }
                }
                i2 -= i3;
                savedState2.mSpanOffsets[i6] = i2;
            }
        } else {
            savedState2.mAnchorPosition = -1;
            savedState2.mVisibleAnchorPosition = -1;
            savedState2.mSpanOffsetsSize = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public final boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.mShouldReverseLayout;
        }
        return ((i == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    public void prepareLayoutStateForDelta(int i, RecyclerView.State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = getLastChildPosition();
            i2 = 1;
        } else {
            i2 = -1;
            i3 = getFirstChildPosition();
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(i3, state);
        setLayoutStateDirection(i2);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i3 + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i);
    }

    public final void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int i;
        int i2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable != 0) {
                int i3 = 1;
                if (layoutState.mLayoutDirection == -1) {
                    int i4 = layoutState.mStartLine;
                    int startLine = this.mSpans[0].getStartLine(i4);
                    while (i3 < this.mSpanCount) {
                        int startLine2 = this.mSpans[i3].getStartLine(i4);
                        if (startLine2 > startLine) {
                            startLine = startLine2;
                        }
                        i3++;
                    }
                    int i5 = i4 - startLine;
                    if (i5 < 0) {
                        i2 = layoutState.mEndLine;
                    } else {
                        i2 = layoutState.mEndLine - Math.min(i5, layoutState.mAvailable);
                    }
                    recycleFromEnd(recycler, i2);
                    return;
                }
                int i6 = layoutState.mEndLine;
                int endLine = this.mSpans[0].getEndLine(i6);
                while (i3 < this.mSpanCount) {
                    int endLine2 = this.mSpans[i3].getEndLine(i6);
                    if (endLine2 < endLine) {
                        endLine = endLine2;
                    }
                    i3++;
                }
                int i7 = endLine - layoutState.mEndLine;
                if (i7 < 0) {
                    i = layoutState.mStartLine;
                } else {
                    i = Math.min(i7, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, i);
            } else if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(recycler, layoutState.mEndLine);
            } else {
                recycleFromStart(recycler, layoutState.mStartLine);
            }
        }
    }

    public final void recycleFromEnd(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                        if (this.mSpans[i2].mViews.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                        this.mSpans[i3].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void recycleFromStart(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                        if (this.mSpans[i2].mViews.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                        this.mSpans[i3].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= fill) {
            i = i < 0 ? -fill : fill;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i)) {
            savedState.mSpanOffsets = null;
            savedState.mSpanOffsetsSize = 0;
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = RecyclerView.UNDEFINED_DURATION;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public final void setLayoutStateDirection(int i) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i;
        int i2 = 1;
        if (this.mShouldReverseLayout != (i == -1)) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            i3 = RecyclerView.LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        this.mRecyclerView.setMeasuredDimension(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.mTargetPosition = i;
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public final void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    public final void updateLayoutState(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        LayoutState layoutState = this.mLayoutState;
        boolean z = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i;
        RecyclerView.SmoothScroller smoothScroller = this.mSmoothScroller;
        if (!(smoothScroller != null && smoothScroller.mRunning) || (i4 = state.mTargetPosition) == -1) {
            i3 = 0;
            i2 = 0;
        } else {
            if (this.mShouldReverseLayout == (i4 < i)) {
                i3 = this.mPrimaryOrientation.getTotalSpace();
                i2 = 0;
            } else {
                i2 = this.mPrimaryOrientation.getTotalSpace();
                i3 = 0;
            }
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && recyclerView.mClipToPadding) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i2;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i3;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i3;
            this.mLayoutState.mStartLine = -i2;
        }
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = false;
        layoutState2.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z = true;
        }
        layoutState2.mInfinite = z;
    }

    public final void updateRemainingSpans(Span span, int i, int i2) {
        int i3 = span.mDeletedSize;
        if (i == -1) {
            int i4 = span.mCachedStart;
            if (i4 == Integer.MIN_VALUE) {
                span.calculateCachedStart();
                i4 = span.mCachedStart;
            }
            if (i4 + i3 <= i2) {
                this.mRemainingSpans.set(span.mIndex, false);
                return;
            }
            return;
        }
        int i5 = span.mCachedEnd;
        if (i5 == Integer.MIN_VALUE) {
            span.calculateCachedEnd();
            i5 = span.mCachedEnd;
        }
        if (i5 - i3 >= i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    public final int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:242:0x041c, code lost:
        if (checkForGaps() != false) goto L_0x0420;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bb  */
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        SavedState savedState;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            anchorInfo.reset();
            return;
        }
        boolean z3 = true;
        boolean z4 = (anchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) ? false : true;
        if (z4) {
            anchorInfo.reset();
            SavedState savedState2 = this.mPendingSavedState;
            if (savedState2 != null) {
                int i7 = savedState2.mSpanOffsetsSize;
                if (i7 > 0) {
                    if (i7 == this.mSpanCount) {
                        for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                            this.mSpans[i8].clear();
                            SavedState savedState3 = this.mPendingSavedState;
                            int i9 = savedState3.mSpanOffsets[i8];
                            if (i9 != Integer.MIN_VALUE) {
                                if (savedState3.mAnchorLayoutFromEnd) {
                                    i6 = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    i6 = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                i9 += i6;
                            }
                            Span span = this.mSpans[i8];
                            span.mCachedStart = i9;
                            span.mCachedEnd = i9;
                        }
                    } else {
                        savedState2.mSpanOffsets = null;
                        savedState2.mSpanOffsetsSize = 0;
                        savedState2.mSpanLookupSize = 0;
                        savedState2.mSpanLookup = null;
                        savedState2.mFullSpanItems = null;
                        savedState2.mAnchorPosition = savedState2.mVisibleAnchorPosition;
                    }
                }
                SavedState savedState4 = this.mPendingSavedState;
                this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
                boolean z5 = savedState4.mReverseLayout;
                assertNotInLayoutOrScroll(null);
                SavedState savedState5 = this.mPendingSavedState;
                if (!(savedState5 == null || savedState5.mReverseLayout == z5)) {
                    savedState5.mReverseLayout = z5;
                }
                this.mReverseLayout = z5;
                requestLayout();
                resolveShouldLayoutReverse();
                SavedState savedState6 = this.mPendingSavedState;
                int i10 = savedState6.mAnchorPosition;
                if (i10 != -1) {
                    this.mPendingScrollPosition = i10;
                    anchorInfo.mLayoutFromEnd = savedState6.mAnchorLayoutFromEnd;
                } else {
                    anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                }
                SavedState savedState7 = this.mPendingSavedState;
                if (savedState7.mSpanLookupSize > 1) {
                    LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
                    lazySpanLookup.mData = savedState7.mSpanLookup;
                    lazySpanLookup.mFullSpanItems = savedState7.mFullSpanItems;
                }
            } else {
                resolveShouldLayoutReverse();
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            if (!state.mInPreLayout && (i3 = this.mPendingScrollPosition) != -1) {
                if (i3 < 0 || i3 >= state.getItemCount()) {
                    this.mPendingScrollPosition = -1;
                    this.mPendingScrollPositionOffset = RecyclerView.UNDEFINED_DURATION;
                } else {
                    SavedState savedState8 = this.mPendingSavedState;
                    if (savedState8 == null || savedState8.mAnchorPosition == -1 || savedState8.mSpanOffsetsSize < 1) {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mShouldReverseLayout) {
                                i4 = getLastChildPosition();
                            } else {
                                i4 = getFirstChildPosition();
                            }
                            anchorInfo.mPosition = i4;
                            if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                } else {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                                }
                            } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    i5 = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    i5 = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                anchorInfo.mOffset = i5;
                            } else {
                                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                                if (decoratedStart < 0) {
                                    anchorInfo.mOffset = -decoratedStart;
                                } else {
                                    int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                    if (endAfterPadding < 0) {
                                        anchorInfo.mOffset = endAfterPadding;
                                    } else {
                                        anchorInfo.mOffset = RecyclerView.UNDEFINED_DURATION;
                                    }
                                }
                            }
                        } else {
                            int i11 = this.mPendingScrollPosition;
                            anchorInfo.mPosition = i11;
                            int i12 = this.mPendingScrollPositionOffset;
                            if (i12 == Integer.MIN_VALUE) {
                                anchorInfo.mLayoutFromEnd = calculateScrollDirectionForPosition(i11) == 1;
                                anchorInfo.assignCoordinateFromPadding();
                            } else if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i12;
                            } else {
                                anchorInfo.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i12;
                            }
                            anchorInfo.mInvalidateOffsets = true;
                        }
                    } else {
                        anchorInfo.mOffset = RecyclerView.UNDEFINED_DURATION;
                        anchorInfo.mPosition = this.mPendingScrollPosition;
                    }
                    z2 = true;
                    if (!z2) {
                        if (this.mLastLayoutFromEnd) {
                            int itemCount = state.getItemCount();
                            int childCount = getChildCount();
                            while (true) {
                                childCount--;
                                if (childCount < 0) {
                                    break;
                                }
                                i2 = getPosition(getChildAt(childCount));
                                if (i2 >= 0 && i2 < itemCount) {
                                    break;
                                }
                            }
                        } else {
                            int itemCount2 = state.getItemCount();
                            int childCount2 = getChildCount();
                            int i13 = 0;
                            while (true) {
                                if (i13 >= childCount2) {
                                    break;
                                }
                                int position = getPosition(getChildAt(i13));
                                if (position >= 0 && position < itemCount2) {
                                    i2 = position;
                                    break;
                                }
                                i13++;
                            }
                            anchorInfo.mPosition = i2;
                            anchorInfo.mOffset = RecyclerView.UNDEFINED_DURATION;
                        }
                        i2 = 0;
                        anchorInfo.mPosition = i2;
                        anchorInfo.mOffset = RecyclerView.UNDEFINED_DURATION;
                    }
                    anchorInfo.mValid = true;
                }
            }
            z2 = false;
            if (!z2) {
            }
            anchorInfo.mValid = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && !(anchorInfo.mLayoutFromEnd == this.mLastLayoutFromEnd && isLayoutRTL() == this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            anchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
            if (anchorInfo.mInvalidateOffsets) {
                for (int i14 = 0; i14 < this.mSpanCount; i14++) {
                    this.mSpans[i14].clear();
                    int i15 = anchorInfo.mOffset;
                    if (i15 != Integer.MIN_VALUE) {
                        Span span2 = this.mSpans[i14];
                        span2.mCachedStart = i15;
                        span2.mCachedEnd = i15;
                    }
                }
            } else if (z4 || this.mAnchorInfo.mSpanReferenceLines == null) {
                for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                    Span span3 = this.mSpans[i16];
                    boolean z6 = this.mShouldReverseLayout;
                    int i17 = anchorInfo.mOffset;
                    if (z6) {
                        i = span3.getEndLine(RecyclerView.UNDEFINED_DURATION);
                    } else {
                        i = span3.getStartLine(RecyclerView.UNDEFINED_DURATION);
                    }
                    span3.clear();
                    if (i != Integer.MIN_VALUE && ((!z6 || i >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) && (z6 || i <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()))) {
                        if (i17 != Integer.MIN_VALUE) {
                            i += i17;
                        }
                        span3.mCachedEnd = i;
                        span3.mCachedStart = i;
                    }
                }
                AnchorInfo anchorInfo2 = this.mAnchorInfo;
                Span[] spanArr = this.mSpans;
                if (anchorInfo2 != null) {
                    int length = spanArr.length;
                    int[] iArr = anchorInfo2.mSpanReferenceLines;
                    if (iArr == null || iArr.length < length) {
                        anchorInfo2.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
                    }
                    for (int i18 = 0; i18 < length; i18++) {
                        anchorInfo2.mSpanReferenceLines[i18] = spanArr[i18].getStartLine(RecyclerView.UNDEFINED_DURATION);
                    }
                } else {
                    throw null;
                }
            } else {
                for (int i19 = 0; i19 < this.mSpanCount; i19++) {
                    Span span4 = this.mSpans[i19];
                    span4.clear();
                    int i20 = this.mAnchorInfo.mSpanReferenceLines[i19];
                    span4.mCachedStart = i20;
                    span4.mCachedEnd = i20;
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        int totalSpace = this.mSecondaryOrientation.getTotalSpace();
        this.mSizePerSpan = totalSpace / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(totalSpace, this.mSecondaryOrientation.getMode());
        updateLayoutState(anchorInfo.mPosition, state);
        if (anchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(1);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        } else {
            setLayoutStateDirection(1);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(-1);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition = anchorInfo.mPosition + layoutState2.mItemDirection;
            fill(recycler, layoutState2, state);
        }
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            int childCount3 = getChildCount();
            for (int i21 = 0; i21 < childCount3; i21++) {
                View childAt = getChildAt(i21);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f) {
                    if (((LayoutParams) childAt.getLayoutParams()) != null) {
                        f = Math.max(f, decoratedMeasurement);
                    } else {
                        throw null;
                    }
                }
            }
            int i22 = this.mSizePerSpan;
            int round = Math.round(f * ((float) this.mSpanCount));
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            this.mSizePerSpan = round / this.mSpanCount;
            this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(round, this.mSecondaryOrientation.getMode());
            if (this.mSizePerSpan != i22) {
                for (int i23 = 0; i23 < childCount3; i23++) {
                    View childAt2 = getChildAt(i23);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (!isLayoutRTL() || this.mOrientation != 1) {
                            int i24 = layoutParams.mSpan.mIndex;
                            int i25 = this.mSizePerSpan * i24;
                            int i26 = i24 * i22;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i25 - i26);
                            } else {
                                childAt2.offsetTopAndBottom(i25 - i26);
                            }
                        } else {
                            int i27 = this.mSpanCount;
                            int i28 = layoutParams.mSpan.mIndex;
                            childAt2.offsetLeftAndRight(((-((i27 - 1) - i28)) * this.mSizePerSpan) - ((-((i27 - 1) - i28)) * i22));
                        }
                    }
                }
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recycler, state, true);
                fixStartGap(recycler, state, false);
            } else {
                fixStartGap(recycler, state, true);
                fixEndGap(recycler, state, false);
            }
        }
        if (z && !state.mInPreLayout) {
            if (this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
                Runnable runnable = this.mCheckForGapsRunnable;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.removeCallbacks(runnable);
                }
            }
        }
        z3 = false;
        if (state.mInPreLayout) {
            this.mAnchorInfo.reset();
        }
        this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (z3) {
            this.mAnchorInfo.reset();
            onLayoutChildren(recycler, state, false);
        }
    }

    public static class LazySpanLookup {
        public int[] mData;
        public List<FullSpanItem> mFullSpanItems;

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        public void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        public void ensureSize(int i) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int forceInvalidateAfter(int i) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i4);
                int i5 = fullSpanItem.mPosition;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        public int invalidateAfter(int i) {
            int i2;
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            if (this.mFullSpanItems != null) {
                FullSpanItem fullSpanItem = getFullSpanItem(i);
                if (fullSpanItem != null) {
                    this.mFullSpanItems.remove(fullSpanItem);
                }
                int size = this.mFullSpanItems.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = -1;
                        break;
                    } else if (this.mFullSpanItems.get(i3).mPosition >= i) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    this.mFullSpanItems.remove(i3);
                    i2 = this.mFullSpanItems.get(i3).mPosition;
                    if (i2 != -1) {
                        int[] iArr2 = this.mData;
                        Arrays.fill(iArr2, i, iArr2.length, -1);
                        return this.mData.length;
                    }
                    int i4 = i2 + 1;
                    Arrays.fill(this.mData, i, i4, -1);
                    return i4;
                }
            }
            i2 = -1;
            if (i2 != -1) {
            }
        }

        public void offsetForAddition(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, i, i3, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int i4 = fullSpanItem.mPosition;
                        if (i4 >= i) {
                            fullSpanItem.mPosition = i4 + i2;
                        }
                    }
                }
            }
        }

        public void offsetForRemoval(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int i4 = fullSpanItem.mPosition;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.mFullSpanItems.remove(size);
                            } else {
                                fullSpanItem.mPosition = i4 - i2;
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            public int mGapDir;
            public int[] mGapPerSpan;
            public boolean mHasUnwantedGapAfter;
            public int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("FullSpanItem{mPosition=");
                outline15.append(this.mPosition);
                outline15.append(", mGapDir=");
                outline15.append(this.mGapDir);
                outline15.append(", mHasUnwantedGapAfter=");
                outline15.append(this.mHasUnwantedGapAfter);
                outline15.append(", mGapPerSpan=");
                outline15.append(Arrays.toString(this.mGapPerSpan));
                outline15.append('}');
                return outline15.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }
    }
}
