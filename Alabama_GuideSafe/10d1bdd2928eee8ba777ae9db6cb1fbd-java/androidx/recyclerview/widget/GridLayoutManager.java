package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public int[] mCachedBorders;
    public final Rect mDecorInsets = new Rect();
    public boolean mPendingSpanCountChange = false;
    public final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    public final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    public View[] mSet;
    public int mSpanCount = -1;
    public SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
    }

    public static abstract class SpanSizeLookup {
        public boolean mCacheSpanGroupIndices = false;
        public boolean mCacheSpanIndices = false;
        public final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        public final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return i % i2;
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = i % i2;
            this.mSpanIndexCache.put(i, i4);
            return i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (this.mCacheSpanGroupIndices) {
                SparseIntArray sparseIntArray = this.mSpanGroupIndexCache;
                int size = sparseIntArray.size() - 1;
                int i6 = 0;
                while (i6 <= size) {
                    int i7 = (i6 + size) >>> 1;
                    if (sparseIntArray.keyAt(i7) < i) {
                        i6 = i7 + 1;
                    } else {
                        size = i7 - 1;
                    }
                }
                int i8 = i6 - 1;
                int keyAt = (i8 < 0 || i8 >= sparseIntArray.size()) ? -1 : sparseIntArray.keyAt(i8);
                if (keyAt != -1) {
                    i4 = this.mSpanGroupIndexCache.get(keyAt);
                    i3 = keyAt + 1;
                    i5 = getCachedSpanIndex(keyAt, i2) + 1;
                    if (i5 == i2) {
                        i4++;
                        i5 = 0;
                    }
                    while (i3 < i) {
                        i5++;
                        if (i5 == i2) {
                            i4++;
                            i5 = 0;
                        } else if (i5 > i2) {
                            i4++;
                            i5 = 1;
                        }
                        i3++;
                    }
                    return i5 + 1 <= i2 ? i4 + 1 : i4;
                }
            }
            i5 = 0;
            i4 = 0;
            i3 = 0;
            while (i3 < i) {
            }
            if (i5 + 1 <= i2) {
            }
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    public final void calculateItemBorders(int i) {
        int i2;
        int[] iArr = this.mCachedBorders;
        int i3 = this.mSpanCount;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.mCachedBorders = iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i2++) {
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(layoutState.mCurrentPosition, Math.max(0, layoutState.mScrollingOffset));
            if (((DefaultSpanSizeLookup) this.mSpanSizeLookup) != null) {
                i--;
                layoutState.mCurrentPosition += layoutState.mItemDirection;
            } else {
                throw null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
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
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i3 = this.mSpanCount;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.mInPreLayout) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    public final int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.mInPreLayout) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (state.mInPreLayout) {
            int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            if (recycler.convertPreLayoutPositionToPostLayout(i) == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 1;
            } else if (((DefaultSpanSizeLookup) this.mSpanSizeLookup) != null) {
                return 1;
            } else {
                throw null;
            }
        } else if (((DefaultSpanSizeLookup) this.mSpanSizeLookup) != null) {
            return 1;
        } else {
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: androidx.recyclerview.widget.GridLayoutManager */
    /* JADX DEBUG: Multi-variable search result rejected for r13v9, resolved type: android.graphics.Rect */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v27, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        ?? r11;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z = modeInOther != 1073741824;
        int i17 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z) {
            updateMeasurements();
        }
        boolean z2 = layoutState.mItemDirection == 1;
        int i18 = this.mSpanCount;
        if (!z2) {
            i18 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        int i19 = 0;
        while (i19 < this.mSpanCount && layoutState.hasMore(state) && i18 > 0) {
            int i20 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i20);
            if (spanSize <= this.mSpanCount) {
                i18 -= spanSize;
                if (i18 < 0 || (next = layoutState.next(recycler)) == null) {
                    break;
                }
                this.mSet[i19] = next;
                i19++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(i20);
                sb.append(" requires ");
                sb.append(spanSize);
                sb.append(" spans but GridLayoutManager has only ");
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline13(sb, this.mSpanCount, " spans."));
            }
        }
        if (i19 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        if (z2) {
            i = 1;
            i2 = i19;
            i3 = 0;
        } else {
            i3 = i19 - 1;
            i2 = -1;
            i = -1;
        }
        int i21 = 0;
        while (i3 != i2) {
            View view = this.mSet[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize2 = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize2;
            layoutParams.mSpanIndex = i21;
            i21 += spanSize2;
            i3 += i;
        }
        float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int i22 = 0;
        for (int i23 = 0; i23 < i19; i23++) {
            View view2 = this.mSet[i23];
            if (layoutState.mScrapList != null) {
                r11 = 0;
                r11 = 0;
                if (z2) {
                    addViewInt(view2, -1, true);
                } else {
                    addViewInt(view2, 0, true);
                }
            } else if (z2) {
                addView(view2);
                r11 = 0;
            } else {
                r11 = 0;
                addViewInt(view2, 0, false);
            }
            Rect rect = this.mDecorInsets;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                int i24 = r11 == true ? 1 : 0;
                int i25 = r11 == true ? 1 : 0;
                int i26 = r11 == true ? 1 : 0;
                int i27 = r11 == true ? 1 : 0;
                int i28 = r11 == true ? 1 : 0;
                rect.set(i24, r11, r11, r11);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view2));
            }
            measureChild(view2, modeInOther, r11);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i22) {
                i22 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view2)) * 1.0f) / ((float) ((LayoutParams) view2.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
        }
        if (z) {
            calculateItemBorders(Math.max(Math.round(f * ((float) this.mSpanCount)), i17));
            i22 = 0;
            for (int i29 = 0; i29 < i19; i29++) {
                View view3 = this.mSet[i29];
                measureChild(view3, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i22) {
                    i22 = decoratedMeasurement2;
                }
            }
        }
        for (int i30 = 0; i30 < i19; i30++) {
            View view4 = this.mSet[i30];
            if (this.mOrientationHelper.getDecoratedMeasurement(view4) != i22) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect2 = layoutParams2.mDecorInsets;
                int i31 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i32 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams2.mSpanIndex, layoutParams2.mSpanSize);
                if (this.mOrientation == 1) {
                    i16 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i32, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false);
                    i15 = View.MeasureSpec.makeMeasureSpec(i22 - i31, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i32, 1073741824);
                    i15 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i31, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false);
                    i16 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view4, i16, i15, true);
            }
        }
        layoutChunkResult.mConsumed = i22;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                i14 = layoutState.mOffset;
                i13 = i14 - i22;
            } else {
                int i33 = layoutState.mOffset;
                i13 = i33;
                i14 = i22 + i33;
            }
            i6 = i13;
            i5 = 0;
            i4 = i14;
            i7 = 0;
        } else {
            if (layoutState.mLayoutDirection == -1) {
                i7 = layoutState.mOffset;
                i12 = i7 - i22;
            } else {
                int i34 = layoutState.mOffset;
                i12 = i34;
                i7 = i22 + i34;
            }
            i5 = i12;
            i6 = 0;
            i4 = 0;
        }
        int i35 = 0;
        while (i35 < i19) {
            View view5 = this.mSet[i35];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.mOrientation != 1) {
                i6 = getPaddingTop() + this.mCachedBorders[layoutParams3.mSpanIndex];
                i4 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + i6;
            } else if (isLayoutRTL()) {
                i7 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams3.mSpanIndex];
                i5 = i7 - this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
            } else {
                int paddingLeft = getPaddingLeft() + this.mCachedBorders[layoutParams3.mSpanIndex];
                i9 = paddingLeft;
                i10 = i6;
                i8 = i4;
                i11 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + paddingLeft;
                layoutDecoratedWithMargins(view5, i9, i10, i11, i8);
                if (!layoutParams3.isItemRemoved() || layoutParams3.isItemChanged()) {
                    layoutChunkResult.mIgnoreConsumed = true;
                }
                layoutChunkResult.mFocusable |= view5.hasFocusable();
                i35++;
                i7 = i11;
                i6 = i10;
                i5 = i9;
                i4 = i8;
            }
            i10 = i6;
            i9 = i5;
            i8 = i4;
            i11 = i7;
            layoutDecoratedWithMargins(view5, i9, i10, i11, i8);
            if (!layoutParams3.isItemRemoved()) {
            }
            layoutChunkResult.mIgnoreConsumed = true;
            layoutChunkResult.mFocusable |= view5.hasFocusable();
            i35++;
            i7 = i11;
            i6 = i10;
            i5 = i9;
            i4 = i8;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    public final void measureChild(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), this.mHeightMode, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), this.mWidthMode, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i2, i3, z);
    }

    public final void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.mInPreLayout) {
            boolean z = i == 1;
            int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            if (z) {
                while (spanIndex > 0) {
                    int i2 = anchorInfo.mPosition;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    anchorInfo.mPosition = i3;
                    spanIndex = getSpanIndex(recycler, state, i3);
                }
            } else {
                int itemCount = state.getItemCount() - 1;
                int i4 = anchorInfo.mPosition;
                while (i4 < itemCount) {
                    int i5 = i4 + 1;
                    int spanIndex2 = getSpanIndex(recycler, state, i5);
                    if (spanIndex2 <= spanIndex) {
                        break;
                    }
                    i4 = i5;
                    spanIndex = spanIndex2;
                }
                anchorInfo.mPosition = i4;
            }
        }
        ensureViewSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ce, code lost:
        if (r13 == (r2 > r15)) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e7, code lost:
        if (r13 == (r2 > r9)) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        int i5;
        View view2;
        View view3;
        boolean z;
        boolean z2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i6 = layoutParams.mSpanIndex;
        int i7 = layoutParams.mSpanSize + i6;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            i4 = getChildCount() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = getChildCount();
            i2 = 1;
            i4 = 0;
        }
        boolean z3 = this.mOrientation == 1 && isLayoutRTL();
        int spanGroupIndex = getSpanGroupIndex(recycler2, state2, i4);
        int i8 = -1;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = i4;
        View view5 = null;
        while (i12 != i3) {
            int spanGroupIndex2 = getSpanGroupIndex(recycler2, state2, i12);
            View childAt = getChildAt(i12);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i13 = layoutParams2.mSpanIndex;
                view2 = findContainingItemView;
                int i14 = layoutParams2.mSpanSize + i13;
                if (childAt.hasFocusable() && i13 == i6 && i14 == i7) {
                    return childAt;
                }
                if ((!childAt.hasFocusable() || view4 != null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i14, i7) - Math.max(i13, i6);
                    if (childAt.hasFocusable()) {
                        if (min <= i10) {
                            if (min == i10) {
                            }
                        }
                    } else if (view4 == null) {
                        i5 = i10;
                        z2 = false;
                        if (isViewPartiallyVisible(childAt, false)) {
                            if (min <= i11) {
                                if (min == i11) {
                                }
                            }
                            z = true;
                            if (z) {
                                if (childAt.hasFocusable()) {
                                    int i15 = layoutParams2.mSpanIndex;
                                    i5 = Math.min(i14, i7) - Math.max(i13, i6);
                                    i9 = i15;
                                    view5 = view3;
                                    view4 = childAt;
                                } else {
                                    int i16 = layoutParams2.mSpanIndex;
                                    i11 = Math.min(i14, i7) - Math.max(i13, i6);
                                    i8 = i16;
                                    view5 = childAt;
                                }
                                i12 += i2;
                                recycler2 = recycler;
                                state2 = state;
                                i3 = i3;
                                findContainingItemView = view2;
                                i10 = i5;
                            }
                        }
                        z = z2;
                        if (z) {
                        }
                    }
                    i5 = i10;
                    z2 = false;
                    z = z2;
                    if (z) {
                    }
                } else {
                    view3 = view5;
                }
                i5 = i10;
                z = true;
                if (z) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = findContainingItemView;
                view3 = view5;
                i5 = i10;
            }
            view5 = view3;
            i12 += i2;
            recycler2 = recycler;
            state2 = state;
            i3 = i3;
            findContainingItemView = view2;
            i10 = i5;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.mSpanIndex, layoutParams2.mSpanSize, spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.mSpanIndex, layoutParams2.mSpanSize, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.mSpanIndexCache.clear();
        this.mSpanSizeLookup.mSpanGroupIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.mSpanIndexCache.clear();
        this.mSpanSizeLookup.mSpanGroupIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.mSpanIndexCache.clear();
        this.mSpanSizeLookup.mSpanGroupIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.mSpanIndexCache.clear();
        this.mSpanSizeLookup.mSpanGroupIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.mSpanIndexCache.clear();
        this.mSpanSizeLookup.mSpanGroupIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.mInPreLayout) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.mSpanSize);
                this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.mSpanIndex);
            }
        }
        super.onLayoutChildren(recycler, state);
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = RecyclerView.UNDEFINED_DURATION;
        this.mAnchorInfo.reset();
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i3 = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        this.mRecyclerView.setMeasuredDimension(i3, i4);
    }

    public void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i >= 1) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.mSpanIndexCache.clear();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Span count should be at least 1. Provided ", i));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            assertNotInLayoutOrScroll(null);
            if (this.mStackFromEnd) {
                this.mStackFromEnd = false;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public final void updateMeasurements() {
        int i;
        int i2;
        if (this.mOrientation == 1) {
            i2 = this.mWidth - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = this.mHeight - getPaddingBottom();
            i = getPaddingTop();
        }
        calculateItemBorders(i2 - i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public int mSpanIndex = -1;
        public int mSpanSize = 0;

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

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        setSpanCount(i);
    }
}
