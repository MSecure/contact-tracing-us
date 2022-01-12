package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class GapWorker implements Runnable {
    public static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    public static Comparator<Task> sTaskComparator = new Comparator<Task>() {
        /* class androidx.recyclerview.widget.GapWorker.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r6.view == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (r0 != false) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return -1;
         */
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            Task task3 = task;
            Task task4 = task2;
            if ((task3.view == null) == (task4.view == null)) {
                boolean z = task3.immediate;
                if (z == task4.immediate) {
                    int i = task4.viewVelocity - task3.viewVelocity;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = task3.distanceToItem - task4.distanceToItem;
                    if (i2 != 0) {
                        return i2;
                    }
                    return 0;
                }
            }
            return 1;
        }
    };
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    public ArrayList<Task> mTasks = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        public int mCount;
        public int[] mPrefetchArray;
        public int mPrefetchDx;
        public int mPrefetchDy;

        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.mCount * 2;
                int[] iArr = this.mPrefetchArray;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.mPrefetchArray = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.mPrefetchArray = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.mPrefetchArray;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.mCount++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.mItemPrefetchEnabled) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i = this.mCount;
                if (i > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public boolean lastPrefetchIncludedPosition(int i) {
            if (this.mPrefetchArray != null) {
                int i2 = this.mCount * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.mPrefetchArray[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;
    }

    public void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.mPrefetchDx = i;
        layoutPrefetchRegistryImpl.mPrefetchDy = i2;
    }

    public void prefetch(long j) {
        RecyclerView recyclerView;
        Task task;
        int size = this.mRecyclerViews.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i2);
            if (recyclerView2.getWindowVisibility() == 0) {
                recyclerView2.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView2, false);
                i += recyclerView2.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = this.mRecyclerViews.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView3.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx);
                for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.mCount * 2; i5 += 2) {
                    if (i3 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i3);
                    }
                    int i6 = layoutPrefetchRegistryImpl.mPrefetchArray[i5 + 1];
                    task.immediate = i6 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i6;
                    task.view = recyclerView3;
                    task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
        for (int i7 = 0; i7 < this.mTasks.size(); i7++) {
            Task task2 = this.mTasks.get(i7);
            if (task2.view != null) {
                RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task2.view, task2.position, task2.immediate ? RecyclerView.FOREVER_NS : j);
                if (!(prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.mNestedRecyclerView == null || !prefetchPositionWithDeadline.isBound() || prefetchPositionWithDeadline.isInvalid() || (recyclerView = prefetchPositionWithDeadline.mNestedRecyclerView.get()) == null)) {
                    if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                        recyclerView.removeAndRecycleViews();
                    }
                    LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView.mPrefetchRegistry;
                    layoutPrefetchRegistryImpl2.collectPrefetchPositionsFromView(recyclerView, true);
                    if (layoutPrefetchRegistryImpl2.mCount != 0) {
                        try {
                            TraceCompat.beginSection(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                            RecyclerView.State state = recyclerView.mState;
                            RecyclerView.Adapter adapter = recyclerView.mAdapter;
                            state.mLayoutStep = 1;
                            state.mItemCount = adapter.getItemCount();
                            state.mInPreLayout = false;
                            state.mTrackOldChangeHolders = false;
                            state.mIsMeasuring = false;
                            for (int i8 = 0; i8 < layoutPrefetchRegistryImpl2.mCount * 2; i8 += 2) {
                                prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl2.mPrefetchArray[i8], j);
                            }
                            Trace.endSection();
                        } catch (Throwable th) {
                            TraceCompat.endSection();
                            throw th;
                        }
                    }
                }
                task2.immediate = false;
                task2.viewVelocity = 0;
                task2.distanceToItem = 0;
                task2.view = null;
                task2.position = 0;
            } else {
                return;
            }
        }
    }

    public final RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= unfilteredChildCount) {
                z = false;
                break;
            }
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i, false, j);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (!tryGetViewHolderForPositionByDeadline.isBound() || tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                } else {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void run() {
        try {
            TraceCompat.beginSection(RecyclerView.TRACE_PREFETCH_TAG);
            if (this.mRecyclerViews.isEmpty()) {
                this.mPostTimeNs = 0;
                Trace.endSection();
                return;
            }
            int size = this.mRecyclerViews.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.mRecyclerViews.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.mPostTimeNs = 0;
                Trace.endSection();
                return;
            }
            prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
            this.mPostTimeNs = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.mPostTimeNs = 0;
            TraceCompat.endSection();
            throw th;
        }
    }
}
