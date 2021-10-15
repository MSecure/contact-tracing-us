package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
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
import b.r.d.a;
import b.r.d.b0;
import b.r.d.c0;
import b.r.d.d0;
import b.r.d.e0;
import b.r.d.f;
import b.r.d.f0;
import b.r.d.g0;
import b.r.d.h0;
import b.r.d.i0;
import b.r.d.o;
import b.r.d.r;
import com.google.android.gms.nearby.messages.BleSignal;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecyclerView extends ViewGroup implements b.i.l.e {
    public static final boolean A0 = true;
    public static final boolean B0 = true;
    public static final boolean C0 = true;
    public static final Class<?>[] D0;
    public static final Interpolator E0 = new c();
    public static final int[] y0 = {16843830};
    public static final boolean z0 = false;
    public int A;
    public boolean B;
    public final AccessibilityManager C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public i H;
    public EdgeEffect I;
    public EdgeEffect J;
    public EdgeEffect K;
    public EdgeEffect L;
    public j M;
    public int N;
    public int O;
    public VelocityTracker P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public o V;
    public final int W;
    public final int a0;

    /* renamed from: b  reason: collision with root package name */
    public final u f279b;
    public float b0;

    /* renamed from: c  reason: collision with root package name */
    public final s f280c;
    public float c0;

    /* renamed from: d  reason: collision with root package name */
    public v f281d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public b.r.d.a f282e;
    public final z e0;

    /* renamed from: f  reason: collision with root package name */
    public b.r.d.f f283f;
    public b.r.d.r f0;

    /* renamed from: g  reason: collision with root package name */
    public final i0 f284g;
    public r.b g0;
    public boolean h;
    public final x h0;
    public final Runnable i;
    public q i0;
    public final Rect j;
    public List<q> j0;
    public final Rect k;
    public boolean k0;
    public final RectF l;
    public boolean l0;
    public e m;
    public j.b m0;
    public m n;
    public boolean n0;
    public t o;
    public d0 o0;
    public final ArrayList<l> p;
    public h p0;
    public final ArrayList<p> q;
    public final int[] q0;
    public p r;
    public b.i.l.f r0;
    public boolean s;
    public final int[] s0;
    public boolean t;
    public final int[] t0;
    public boolean u;
    public final int[] u0;
    public boolean v;
    public final List<a0> v0;
    public int w;
    public Runnable w0;
    public boolean x;
    public final i0.b x0;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.y) {
                    recyclerView2.x = true;
                } else {
                    recyclerView2.n();
                }
            }
        }
    }

    public static abstract class a0 {
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
        public s mScrapContainer = null;
        public a0 mShadowedHolder = null;
        public a0 mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        public int mWasImportantForAccessibilityBeforeHidden = 0;

        public a0(View view) {
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
            return (this.mFlags & 16) == 0 && b.i.l.m.A(this.itemView);
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
            return recyclerView.H(this);
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
            return (this.mFlags & 16) == 0 && !b.i.l.m.A(this.itemView);
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
                ((n) this.itemView.getLayoutParams()).f312c = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i == -1) {
                i = b.i.l.m.n(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i;
            recyclerView.k0(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.k0(this, this.mWasImportantForAccessibilityBeforeHidden);
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
            RecyclerView.k(this);
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

        public void setScrapContainer(s sVar, boolean z) {
            this.mScrapContainer = sVar;
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
                StringBuilder h = c.a.a.a.a.h(" not recyclable(");
                h.append(this.mIsRecyclableCount);
                h.append(")");
                sb.append(h.toString());
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
            this.mScrapContainer.k(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            j jVar = RecyclerView.this.M;
            if (jVar != null) {
                b.r.d.o oVar = (b.r.d.o) jVar;
                boolean z = !oVar.h.isEmpty();
                boolean z2 = !oVar.j.isEmpty();
                boolean z3 = !oVar.k.isEmpty();
                boolean z4 = !oVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<a0> it = oVar.h.iterator();
                    while (it.hasNext()) {
                        a0 next = it.next();
                        View view = next.itemView;
                        ViewPropertyAnimator animate = view.animate();
                        oVar.q.add(next);
                        animate.setDuration(oVar.f291d).alpha(0.0f).setListener(new b.r.d.j(oVar, next, animate, view)).start();
                    }
                    oVar.h.clear();
                    if (z2) {
                        ArrayList<o.b> arrayList = new ArrayList<>();
                        arrayList.addAll(oVar.j);
                        oVar.m.add(arrayList);
                        oVar.j.clear();
                        b.r.d.g gVar = new b.r.d.g(oVar, arrayList);
                        if (z) {
                            b.i.l.m.O(arrayList.get(0).f2389a.itemView, gVar, oVar.f291d);
                        } else {
                            gVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<o.a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(oVar.k);
                        oVar.n.add(arrayList2);
                        oVar.k.clear();
                        b.r.d.h hVar = new b.r.d.h(oVar, arrayList2);
                        if (z) {
                            b.i.l.m.O(arrayList2.get(0).f2383a.itemView, hVar, oVar.f291d);
                        } else {
                            hVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<a0> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(oVar.i);
                        oVar.l.add(arrayList3);
                        oVar.i.clear();
                        b.r.d.i iVar = new b.r.d.i(oVar, arrayList3);
                        if (z || z2 || z3) {
                            long j = 0;
                            long j2 = z ? oVar.f291d : 0;
                            long j3 = z2 ? oVar.f292e : 0;
                            if (z3) {
                                j = oVar.f293f;
                            }
                            b.i.l.m.O(arrayList3.get(0).itemView, iVar, Math.max(j3, j) + j2);
                        } else {
                            iVar.run();
                        }
                    }
                }
            }
            RecyclerView.this.n0 = false;
        }
    }

    public static class c implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class d implements i0.b {
        public d() {
        }

        public void a(a0 a0Var, j.c cVar, j.c cVar2) {
            boolean z;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView != null) {
                a0Var.setIsRecyclable(false);
                e0 e0Var = (e0) recyclerView.M;
                if (e0Var != null) {
                    if (cVar == null || (cVar.f294a == cVar2.f294a && cVar.f295b == cVar2.f295b)) {
                        b.r.d.o oVar = (b.r.d.o) e0Var;
                        oVar.o(a0Var);
                        a0Var.itemView.setAlpha(0.0f);
                        oVar.i.add(a0Var);
                        z = true;
                    } else {
                        z = e0Var.j(a0Var, cVar.f294a, cVar.f295b, cVar2.f294a, cVar2.f295b);
                    }
                    if (z) {
                        recyclerView.a0();
                        return;
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }

        public void b(a0 a0Var, j.c cVar, j.c cVar2) {
            boolean z;
            RecyclerView.this.f280c.k(a0Var);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(a0Var);
            a0Var.setIsRecyclable(false);
            e0 e0Var = (e0) recyclerView.M;
            if (e0Var != null) {
                int i = cVar.f294a;
                int i2 = cVar.f295b;
                View view = a0Var.itemView;
                int left = cVar2 == null ? view.getLeft() : cVar2.f294a;
                int top = cVar2 == null ? view.getTop() : cVar2.f295b;
                if (a0Var.isRemoved() || (i == left && i2 == top)) {
                    b.r.d.o oVar = (b.r.d.o) e0Var;
                    oVar.o(a0Var);
                    oVar.h.add(a0Var);
                    z = true;
                } else {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                    z = e0Var.j(a0Var, i, i2, left, top);
                }
                if (z) {
                    recyclerView.a0();
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public static abstract class e<VH extends a0> {
        public boolean mHasStableIds = false;
        public final f mObservable = new f();

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            b.i.h.f.a("RV OnBindView");
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof n) {
                ((n) layoutParams).f312c = true;
            }
            Trace.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                b.i.h.f.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                b.i.h.f.b();
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

        public void registerAdapterDataObserver(g gVar) {
            this.mObservable.registerObserver(gVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(g gVar) {
            this.mObservable.unregisterObserver(gVar);
        }
    }

    public static class f extends Observable<g> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                u uVar = (u) ((g) ((Observable) this).mObservers.get(size));
                RecyclerView.this.i(null);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.h0.f348f = true;
                recyclerView.c0(true);
                if (!RecyclerView.this.f282e.g()) {
                    RecyclerView.this.requestLayout();
                }
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                u uVar = (u) ((g) ((Observable) this).mObservers.get(size));
                RecyclerView.this.i(null);
                b.r.d.a aVar = RecyclerView.this.f282e;
                if (aVar != null) {
                    boolean z = false;
                    if (i != i2) {
                        aVar.f2283b.add(aVar.h(8, i, i2, null));
                        aVar.f2288g |= 8;
                        if (aVar.f2283b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        uVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                u uVar = (u) ((g) ((Observable) this).mObservers.get(size));
                RecyclerView.this.i(null);
                b.r.d.a aVar = RecyclerView.this.f282e;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f2283b.add(aVar.h(4, i, i2, obj));
                        aVar.f2288g |= 4;
                        if (aVar.f2283b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        uVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                u uVar = (u) ((g) ((Observable) this).mObservers.get(size));
                RecyclerView.this.i(null);
                b.r.d.a aVar = RecyclerView.this.f282e;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f2283b.add(aVar.h(1, i, i2, null));
                        aVar.f2288g |= 1;
                        if (aVar.f2283b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        uVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                u uVar = (u) ((g) ((Observable) this).mObservers.get(size));
                RecyclerView.this.i(null);
                b.r.d.a aVar = RecyclerView.this.f282e;
                if (aVar != null) {
                    boolean z = false;
                    if (i2 >= 1) {
                        aVar.f2283b.add(aVar.h(2, i, i2, null));
                        aVar.f2288g |= 2;
                        if (aVar.f2283b.size() == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        uVar.a();
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    public static abstract class g {
    }

    public interface h {
        int a(int i, int i2);
    }

    public static class i {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class j {

        /* renamed from: a  reason: collision with root package name */
        public b f288a = null;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f289b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public long f290c = 120;

        /* renamed from: d  reason: collision with root package name */
        public long f291d = 120;

        /* renamed from: e  reason: collision with root package name */
        public long f292e = 250;

        /* renamed from: f  reason: collision with root package name */
        public long f293f = 250;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f294a;

            /* renamed from: b  reason: collision with root package name */
            public int f295b;
        }

        public static int b(a0 a0Var) {
            int i = a0Var.mFlags & 14;
            if (a0Var.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = a0Var.getOldPosition();
            int adapterPosition = a0Var.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public abstract boolean a(a0 a0Var, a0 a0Var2, c cVar, c cVar2);

        public boolean c(a0 a0Var, List<Object> list) {
            return !((e0) this).f2331g || a0Var.isInvalid();
        }

        public final void d(a0 a0Var) {
            b bVar = this.f288a;
            if (bVar != null) {
                k kVar = (k) bVar;
                if (kVar != null) {
                    boolean z = true;
                    a0Var.setIsRecyclable(true);
                    if (a0Var.mShadowedHolder != null && a0Var.mShadowingHolder == null) {
                        a0Var.mShadowedHolder = null;
                    }
                    a0Var.mShadowingHolder = null;
                    if (!a0Var.shouldBeKeptAsChild()) {
                        RecyclerView recyclerView = RecyclerView.this;
                        View view = a0Var.itemView;
                        recyclerView.m0();
                        b.r.d.f fVar = recyclerView.f283f;
                        int indexOfChild = ((b0) fVar.f2332a).f2297a.indexOfChild(view);
                        if (indexOfChild == -1) {
                            fVar.l(view);
                        } else if (fVar.f2333b.d(indexOfChild)) {
                            fVar.f2333b.f(indexOfChild);
                            fVar.l(view);
                            ((b0) fVar.f2332a).c(indexOfChild);
                        } else {
                            z = false;
                        }
                        if (z) {
                            a0 K = RecyclerView.K(view);
                            recyclerView.f280c.k(K);
                            recyclerView.f280c.h(K);
                        }
                        recyclerView.o0(!z);
                        if (!z && a0Var.isTmpDetached()) {
                            RecyclerView.this.removeDetachedView(a0Var.itemView, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public final void e() {
            int size = this.f289b.size();
            for (int i = 0; i < size; i++) {
                this.f289b.get(i).a();
            }
            this.f289b.clear();
        }

        public abstract void f(a0 a0Var);

        public abstract void g();

        public abstract boolean h();

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView$x;Landroidx/recyclerview/widget/RecyclerView$a0;ILjava/util/List<Ljava/lang/Object;>;)Landroidx/recyclerview/widget/RecyclerView$j$c; */
        public c i(a0 a0Var) {
            c cVar = new c();
            View view = a0Var.itemView;
            cVar.f294a = view.getLeft();
            cVar.f295b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }
    }

    public class k implements j.b {
        public k() {
        }
    }

    public static abstract class l {
        public void d(Canvas canvas, RecyclerView recyclerView, x xVar) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, x xVar) {
        }
    }

    public static abstract class m {

        /* renamed from: a  reason: collision with root package name */
        public b.r.d.f f297a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f298b;

        /* renamed from: c  reason: collision with root package name */
        public final h0.b f299c = new a();

        /* renamed from: d  reason: collision with root package name */
        public final h0.b f300d = new b();

        /* renamed from: e  reason: collision with root package name */
        public h0 f301e = new h0(this.f299c);

        /* renamed from: f  reason: collision with root package name */
        public h0 f302f = new h0(this.f300d);

        /* renamed from: g  reason: collision with root package name */
        public w f303g;
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

        public class a implements h0.b {
            public a() {
            }

            @Override // b.r.d.h0.b
            public View a(int i) {
                return m.this.x(i);
            }

            @Override // b.r.d.h0.b
            public int b() {
                m mVar = m.this;
                return mVar.q - mVar.N();
            }

            @Override // b.r.d.h0.b
            public int c() {
                return m.this.M();
            }

            @Override // b.r.d.h0.b
            public int d(View view) {
                return m.this.F(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).rightMargin;
            }

            @Override // b.r.d.h0.b
            public int e(View view) {
                return m.this.C(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).leftMargin;
            }
        }

        public class b implements h0.b {
            public b() {
            }

            @Override // b.r.d.h0.b
            public View a(int i) {
                return m.this.x(i);
            }

            @Override // b.r.d.h0.b
            public int b() {
                m mVar = m.this;
                return mVar.r - mVar.L();
            }

            @Override // b.r.d.h0.b
            public int c() {
                return m.this.O();
            }

            @Override // b.r.d.h0.b
            public int d(View view) {
                return m.this.B(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).bottomMargin;
            }

            @Override // b.r.d.h0.b
            public int e(View view) {
                return m.this.G(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f306a;

            /* renamed from: b  reason: collision with root package name */
            public int f307b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f308c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f309d;
        }

        public static d Q(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.c.RecyclerView, i2, i3);
            dVar.f306a = obtainStyledAttributes.getInt(b.r.c.RecyclerView_android_orientation, 1);
            dVar.f307b = obtainStyledAttributes.getInt(b.r.c.RecyclerView_spanCount, 1);
            dVar.f308c = obtainStyledAttributes.getBoolean(b.r.c.RecyclerView_reverseLayout, false);
            dVar.f309d = obtainStyledAttributes.getBoolean(b.r.c.RecyclerView_stackFromEnd, false);
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

        public int A(s sVar, x xVar) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView == null || recyclerView.m == null || !e()) {
                return 1;
            }
            return this.f298b.m.getItemCount();
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[ADDED_TO_REGION] */
        public boolean A0(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView recyclerView = this.f298b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                i5 = recyclerView.canScrollVertically(1) ? (this.r - O()) - L() : 0;
                if (this.f298b.canScrollHorizontally(1)) {
                    i6 = (this.q - M()) - N();
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.f298b.l0(i4, i3, null, BleSignal.UNKNOWN_TX_POWER, true);
                return true;
            } else if (i2 != 8192) {
                i4 = 0;
                i3 = 0;
                if (i3 != 0 && i4 == 0) {
                    return false;
                }
                this.f298b.l0(i4, i3, null, BleSignal.UNKNOWN_TX_POWER, true);
                return true;
            } else {
                i5 = recyclerView.canScrollVertically(-1) ? -((this.r - O()) - L()) : 0;
                if (this.f298b.canScrollHorizontally(-1)) {
                    i6 = -((this.q - M()) - N());
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.f298b.l0(i4, i3, null, BleSignal.UNKNOWN_TX_POWER, true);
                return true;
            }
            i4 = i6;
            i3 = i5;
            if (i3 != 0) {
            }
            this.f298b.l0(i4, i3, null, BleSignal.UNKNOWN_TX_POWER, true);
            return true;
        }

        public int B(View view) {
            return view.getBottom() + ((n) view.getLayoutParams()).f311b.bottom;
        }

        public boolean B0() {
            return false;
        }

        public int C(View view) {
            return view.getLeft() - ((n) view.getLayoutParams()).f311b.left;
        }

        public void C0(s sVar) {
            for (int y = y() - 1; y >= 0; y--) {
                if (!RecyclerView.K(x(y)).shouldIgnore()) {
                    F0(y, sVar);
                }
            }
        }

        public int D(View view) {
            Rect rect = ((n) view.getLayoutParams()).f311b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void D0(s sVar) {
            int size = sVar.f320a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = sVar.f320a.get(i2).itemView;
                a0 K = RecyclerView.K(view);
                if (!K.shouldIgnore()) {
                    K.setIsRecyclable(false);
                    if (K.isTmpDetached()) {
                        this.f298b.removeDetachedView(view, false);
                    }
                    j jVar = this.f298b.M;
                    if (jVar != null) {
                        jVar.f(K);
                    }
                    K.setIsRecyclable(true);
                    a0 K2 = RecyclerView.K(view);
                    K2.mScrapContainer = null;
                    K2.mInChangeScrap = false;
                    K2.clearReturnedFromScrapFlag();
                    sVar.h(K2);
                }
            }
            sVar.f320a.clear();
            ArrayList<a0> arrayList = sVar.f321b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f298b.invalidate();
            }
        }

        public int E(View view) {
            Rect rect = ((n) view.getLayoutParams()).f311b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void E0(View view, s sVar) {
            b.r.d.f fVar = this.f297a;
            int indexOfChild = ((b0) fVar.f2332a).f2297a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (fVar.f2333b.f(indexOfChild)) {
                    fVar.l(view);
                }
                ((b0) fVar.f2332a).c(indexOfChild);
            }
            sVar.g(view);
        }

        public int F(View view) {
            return view.getRight() + ((n) view.getLayoutParams()).f311b.right;
        }

        public void F0(int i2, s sVar) {
            View x = x(i2);
            G0(i2);
            sVar.g(x);
        }

        public int G(View view) {
            return view.getTop() - ((n) view.getLayoutParams()).f311b.top;
        }

        public void G0(int i2) {
            b.r.d.f fVar;
            int f2;
            View a2;
            if (x(i2) != null && (a2 = ((b0) fVar.f2332a).a((f2 = (fVar = this.f297a).f(i2)))) != null) {
                if (fVar.f2333b.f(f2)) {
                    fVar.l(a2);
                }
                ((b0) fVar.f2332a).c(f2);
            }
        }

        public View H() {
            View focusedChild;
            RecyclerView recyclerView = this.f298b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f297a.f2334c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r1 == false) goto L_0x00bf;
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
                    Rect rect2 = this.f298b.j;
                    RecyclerView.L(focusedChild, rect2);
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
                    recyclerView.l0(i5, i6, null, BleSignal.UNKNOWN_TX_POWER, false);
                }
                return true;
            }
            return false;
        }

        public int I() {
            return b.i.l.m.p(this.f298b);
        }

        public void I0() {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int J() {
            return b.i.l.m.q(this.f298b);
        }

        public int J0(int i2, s sVar, x xVar) {
            return 0;
        }

        public int K() {
            return b.i.l.m.r(this.f298b);
        }

        public void K0(int i2) {
        }

        public int L() {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int L0(int i2, s sVar, x xVar) {
            return 0;
        }

        public int M() {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void M0(RecyclerView recyclerView) {
            N0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int N() {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void N0(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.o = mode;
            if (mode == 0) {
                boolean z = RecyclerView.A0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = mode2;
            if (mode2 == 0) {
                boolean z2 = RecyclerView.A0;
            }
        }

        public int O() {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void O0(Rect rect, int i2, int i3) {
            int N = N() + M() + rect.width();
            int L = L() + O() + rect.height();
            this.f298b.setMeasuredDimension(h(i2, N, K()), h(i3, L, J()));
        }

        public int P(View view) {
            return ((n) view.getLayoutParams()).a();
        }

        public void P0(int i2, int i3) {
            int y = y();
            if (y == 0) {
                this.f298b.o(i2, i3);
                return;
            }
            int i4 = BleSignal.UNKNOWN_TX_POWER;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < y; i8++) {
                View x = x(i8);
                Rect rect = this.f298b.j;
                RecyclerView.L(x, rect);
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
            this.f298b.j.set(i5, i6, i4, i7);
            O0(this.f298b.j, i2, i3);
        }

        public void Q0(RecyclerView recyclerView) {
            int i2;
            if (recyclerView == null) {
                this.f298b = null;
                this.f297a = null;
                i2 = 0;
                this.q = 0;
            } else {
                this.f298b = recyclerView;
                this.f297a = recyclerView.f283f;
                this.q = recyclerView.getWidth();
                i2 = recyclerView.getHeight();
            }
            this.r = i2;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int R(s sVar, x xVar) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView == null || recyclerView.m == null || !f()) {
                return 1;
            }
            return this.f298b.m.getItemCount();
        }

        public boolean R0(View view, int i2, int i3, n nVar) {
            return view.isLayoutRequested() || !this.k || !W(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !W(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
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
                Rect rect2 = ((n) view.getLayoutParams()).f311b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f298b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f298b.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean T0(View view, int i2, int i3, n nVar) {
            return !this.k || !W(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !W(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
        }

        public boolean U() {
            return this.j;
        }

        public void U0(RecyclerView recyclerView, x xVar, int i2) {
        }

        public boolean V() {
            return false;
        }

        public void V0(w wVar) {
            w wVar2 = this.f303g;
            if (!(wVar2 == null || wVar == wVar2 || !wVar2.f333e)) {
                wVar2.d();
            }
            this.f303g = wVar;
            RecyclerView recyclerView = this.f298b;
            if (wVar != null) {
                recyclerView.e0.c();
                if (wVar.h) {
                    wVar.getClass().getSimpleName();
                    wVar.getClass().getSimpleName();
                }
                wVar.f330b = recyclerView;
                wVar.f331c = this;
                int i2 = wVar.f329a;
                if (i2 != -1) {
                    recyclerView.h0.f343a = i2;
                    wVar.f333e = true;
                    wVar.f332d = true;
                    wVar.f334f = recyclerView.n.t(i2);
                    wVar.f330b.e0.a();
                    wVar.h = true;
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
            boolean z2 = this.f301e.b(view, 24579) && this.f302f.b(view, 24579);
            return z ? z2 : !z2;
        }

        public void Y(View view, int i2, int i3, int i4, int i5) {
            n nVar = (n) view.getLayoutParams();
            Rect rect = nVar.f311b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) nVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) nVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) nVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public void Z(int i2) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                int e2 = recyclerView.f283f.e();
                for (int i3 = 0; i3 < e2; i3++) {
                    recyclerView.f283f.d(i3).offsetLeftAndRight(i2);
                }
            }
        }

        public void a0(int i2) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                int e2 = recyclerView.f283f.e();
                for (int i3 = 0; i3 < e2; i3++) {
                    recyclerView.f283f.d(i3).offsetTopAndBottom(i2);
                }
            }
        }

        public void b(View view) {
            c(view, -1, false);
        }

        public void b0() {
        }

        public final void c(View view, int i2, boolean z) {
            a0 K = RecyclerView.K(view);
            if (z || K.isRemoved()) {
                this.f298b.f284g.a(K);
            } else {
                this.f298b.f284g.f(K);
            }
            n nVar = (n) view.getLayoutParams();
            if (K.wasReturnedFromScrap() || K.isScrap()) {
                if (K.isScrap()) {
                    K.unScrap();
                } else {
                    K.clearReturnedFromScrapFlag();
                }
                this.f297a.b(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f298b) {
                int j2 = this.f297a.j(view);
                if (i2 == -1) {
                    i2 = this.f297a.e();
                }
                if (j2 == -1) {
                    StringBuilder h2 = c.a.a.a.a.h("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    h2.append(this.f298b.indexOfChild(view));
                    throw new IllegalStateException(c.a.a.a.a.l(this.f298b, h2));
                } else if (j2 != i2) {
                    m mVar = this.f298b.n;
                    View x = mVar.x(j2);
                    if (x != null) {
                        mVar.x(j2);
                        mVar.r(j2);
                        n nVar2 = (n) x.getLayoutParams();
                        a0 K2 = RecyclerView.K(x);
                        if (K2.isRemoved()) {
                            mVar.f298b.f284g.a(K2);
                        } else {
                            mVar.f298b.f284g.f(K2);
                        }
                        mVar.f297a.b(x, i2, nVar2, K2.isRemoved());
                    } else {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j2 + mVar.f298b.toString());
                    }
                }
            } else {
                this.f297a.a(view, i2, false);
                nVar.f312c = true;
                w wVar = this.f303g;
                if (wVar != null && wVar.f333e && wVar.a(view) == wVar.f329a) {
                    wVar.f334f = view;
                }
            }
            if (nVar.f313d) {
                K.itemView.invalidate();
                nVar.f313d = false;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList<Landroid/view/View;>;II)Z */
        public boolean c0() {
            return false;
        }

        public void d(String str) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null) {
                recyclerView.i(str);
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

        public void f0(RecyclerView recyclerView, s sVar) {
            e0();
        }

        public boolean g(n nVar) {
            return nVar != null;
        }

        public View g0(View view, int i2, s sVar, x xVar) {
            return null;
        }

        public void h0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f298b;
            s sVar = recyclerView.f280c;
            x xVar = recyclerView.h0;
            i0(accessibilityEvent);
        }

        public void i(int i2, int i3, x xVar, c cVar) {
        }

        public void i0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f298b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f298b.canScrollVertically(-1) && !this.f298b.canScrollHorizontally(-1) && !this.f298b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                e eVar = this.f298b.m;
                if (eVar != null) {
                    accessibilityEvent.setItemCount(eVar.getItemCount());
                }
            }
        }

        public void j(int i2, c cVar) {
        }

        public void j0(View view, b.i.l.w.b bVar) {
            a0 K = RecyclerView.K(view);
            if (K != null && !K.isRemoved() && !this.f297a.k(K.itemView)) {
                RecyclerView recyclerView = this.f298b;
                k0(recyclerView.f280c, recyclerView.h0, view, bVar);
            }
        }

        public int k(x xVar) {
            return 0;
        }

        public void k0(s sVar, x xVar, View view, b.i.l.w.b bVar) {
            int i2 = 0;
            int P = f() ? P(view) : 0;
            if (e()) {
                i2 = P(view);
            }
            bVar.j(b.c.a(P, 1, i2, 1, false, false));
        }

        public int l(x xVar) {
            return 0;
        }

        public View l0() {
            return null;
        }

        public int m(x xVar) {
            return 0;
        }

        public void m0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int n(x xVar) {
            return 0;
        }

        public void n0(RecyclerView recyclerView) {
        }

        public int o(x xVar) {
            return 0;
        }

        public void o0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int p(x xVar) {
            return 0;
        }

        public void p0(RecyclerView recyclerView, int i2, int i3) {
        }

        public void q(s sVar) {
            int y = y();
            while (true) {
                y--;
                if (y >= 0) {
                    View x = x(y);
                    a0 K = RecyclerView.K(x);
                    if (!K.shouldIgnore()) {
                        if (!K.isInvalid() || K.isRemoved() || this.f298b.m.hasStableIds()) {
                            x(y);
                            r(y);
                            sVar.i(x);
                            this.f298b.f284g.f(K);
                        } else {
                            G0(y);
                            sVar.h(K);
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
            this.f297a.c(i2);
        }

        public void r0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            q0();
        }

        public View s(View view) {
            View C;
            RecyclerView recyclerView = this.f298b;
            if (recyclerView == null || (C = recyclerView.C(view)) == null || this.f297a.f2334c.contains(C)) {
                return null;
            }
            return C;
        }

        public void s0(s sVar, x xVar) {
        }

        public View t(int i2) {
            int y = y();
            for (int i3 = 0; i3 < y; i3++) {
                View x = x(i3);
                a0 K = RecyclerView.K(x);
                if (K != null && K.getLayoutPosition() == i2 && !K.shouldIgnore() && (this.f298b.h0.f349g || !K.isRemoved())) {
                    return x;
                }
            }
            return null;
        }

        public void t0(x xVar) {
        }

        public abstract n u();

        public void u0(int i2, int i3) {
            this.f298b.o(i2, i3);
        }

        public n v(Context context, AttributeSet attributeSet) {
            return new n(context, attributeSet);
        }

        @Deprecated
        public boolean v0(RecyclerView recyclerView) {
            w wVar = this.f303g;
            return (wVar != null && wVar.f333e) || recyclerView.P();
        }

        public n w(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof n ? new n((n) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new n((ViewGroup.MarginLayoutParams) layoutParams) : new n(layoutParams);
        }

        public boolean w0(RecyclerView recyclerView, View view, View view2) {
            return v0(recyclerView);
        }

        public View x(int i2) {
            b.r.d.f fVar = this.f297a;
            if (fVar == null) {
                return null;
            }
            return ((b0) fVar.f2332a).a(fVar.f(i2));
        }

        public void x0(Parcelable parcelable) {
        }

        public int y() {
            b.r.d.f fVar = this.f297a;
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

    public static class n extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public a0 f310a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f311b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public boolean f312c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f313d = false;

        public n(int i, int i2) {
            super(i, i2);
        }

        public n(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public n(n nVar) {
            super((ViewGroup.LayoutParams) nVar);
        }

        public int a() {
            return this.f310a.getLayoutPosition();
        }

        public boolean b() {
            return this.f310a.isUpdated();
        }

        public boolean c() {
            return this.f310a.isRemoved();
        }
    }

    public static abstract class o {
    }

    public interface p {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    public static abstract class q {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class r {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f314a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        public int f315b = 0;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList<a0> f316a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            public int f317b = 5;

            /* renamed from: c  reason: collision with root package name */
            public long f318c = 0;

            /* renamed from: d  reason: collision with root package name */
            public long f319d = 0;
        }

        public final a a(int i) {
            a aVar = this.f314a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f314a.put(i, aVar2);
            return aVar2;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class s {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<a0> f320a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a0> f321b = null;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<a0> f322c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final List<a0> f323d = Collections.unmodifiableList(this.f320a);

        /* renamed from: e  reason: collision with root package name */
        public int f324e = 2;

        /* renamed from: f  reason: collision with root package name */
        public int f325f = 2;

        /* renamed from: g  reason: collision with root package name */
        public r f326g;

        public s() {
        }

        public void a(a0 a0Var, boolean z) {
            RecyclerView.k(a0Var);
            View view = a0Var.itemView;
            d0 d0Var = RecyclerView.this.o0;
            if (d0Var != null) {
                d0.a aVar = d0Var.f2323e;
                b.i.l.m.U(view, aVar instanceof d0.a ? aVar.f2325e.remove(view) : null);
            }
            if (z) {
                t tVar = RecyclerView.this.o;
                if (tVar != null) {
                    tVar.a(a0Var);
                }
                e eVar = RecyclerView.this.m;
                if (eVar != null) {
                    eVar.onViewRecycled(a0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.h0 != null) {
                    recyclerView.f284g.g(a0Var);
                }
            }
            a0Var.mOwnerRecyclerView = null;
            r d2 = d();
            if (d2 != null) {
                int itemViewType = a0Var.getItemViewType();
                ArrayList<a0> arrayList = d2.a(itemViewType).f316a;
                if (d2.f314a.get(itemViewType).f317b > arrayList.size()) {
                    a0Var.resetInternal();
                    arrayList.add(a0Var);
                    return;
                }
                return;
            }
            throw null;
        }

        public void b() {
            this.f320a.clear();
            e();
        }

        public int c(int i) {
            if (i < 0 || i >= RecyclerView.this.h0.b()) {
                StringBuilder i2 = c.a.a.a.a.i("invalid position ", i, ". State item count is ");
                i2.append(RecyclerView.this.h0.b());
                throw new IndexOutOfBoundsException(c.a.a.a.a.l(RecyclerView.this, i2));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.h0.f349g) {
                return i;
            }
            return recyclerView.f282e.f(i, 0);
        }

        public r d() {
            if (this.f326g == null) {
                this.f326g = new r();
            }
            return this.f326g;
        }

        public void e() {
            for (int size = this.f322c.size() - 1; size >= 0; size--) {
                f(size);
            }
            this.f322c.clear();
            boolean z = RecyclerView.C0;
            r.b bVar = RecyclerView.this.g0;
            int[] iArr = bVar.f2434c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bVar.f2435d = 0;
        }

        public void f(int i) {
            a(this.f322c.get(i), true);
            this.f322c.remove(i);
        }

        public void g(View view) {
            a0 K = RecyclerView.K(view);
            if (K.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (K.isScrap()) {
                K.unScrap();
            } else if (K.wasReturnedFromScrap()) {
                K.clearReturnedFromScrapFlag();
            }
            h(K);
            if (RecyclerView.this.M != null && !K.isRecyclable()) {
                RecyclerView.this.M.f(K);
            }
        }

        public void h(a0 a0Var) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (a0Var.isScrap() || a0Var.itemView.getParent() != null) {
                StringBuilder h2 = c.a.a.a.a.h("Scrapped or attached views may not be recycled. isScrap:");
                h2.append(a0Var.isScrap());
                h2.append(" isAttached:");
                if (a0Var.itemView.getParent() != null) {
                    z3 = true;
                }
                h2.append(z3);
                throw new IllegalArgumentException(c.a.a.a.a.l(RecyclerView.this, h2));
            } else if (a0Var.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(a0Var);
                throw new IllegalArgumentException(c.a.a.a.a.l(RecyclerView.this, sb));
            } else if (!a0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = a0Var.doesTransientStatePreventRecycling();
                e eVar = RecyclerView.this.m;
                if ((eVar != null && doesTransientStatePreventRecycling && eVar.onFailedToRecycleView(a0Var)) || a0Var.isRecyclable()) {
                    if (this.f325f <= 0 || a0Var.hasAnyOfTheFlags(526)) {
                        z2 = false;
                    } else {
                        int size = this.f322c.size();
                        if (size >= this.f325f && size > 0) {
                            f(0);
                            size--;
                        }
                        boolean z4 = RecyclerView.C0;
                        if (size > 0 && !RecyclerView.this.g0.c(a0Var.mPosition)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.g0.c(this.f322c.get(size).mPosition));
                            size++;
                        }
                        this.f322c.add(size, a0Var);
                        z2 = true;
                    }
                    if (!z2) {
                        a(a0Var, true);
                        z3 = true;
                    }
                    z = z3;
                    z3 = z2;
                } else {
                    z = false;
                }
                RecyclerView.this.f284g.g(a0Var);
                if (!z3 && !z && doesTransientStatePreventRecycling) {
                    a0Var.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException(c.a.a.a.a.l(RecyclerView.this, c.a.a.a.a.h("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void i(View view) {
            ArrayList<a0> arrayList;
            a0 K = RecyclerView.K(view);
            if (!K.hasAnyOfTheFlags(12) && K.isUpdated()) {
                j jVar = RecyclerView.this.M;
                if (!(jVar == null || jVar.c(K, K.getUnmodifiedPayloads()))) {
                    if (this.f321b == null) {
                        this.f321b = new ArrayList<>();
                    }
                    K.setScrapContainer(this, true);
                    arrayList = this.f321b;
                    arrayList.add(K);
                    return;
                }
            }
            if (!K.isInvalid() || K.isRemoved() || RecyclerView.this.m.hasStableIds()) {
                K.setScrapContainer(this, false);
                arrayList = this.f320a;
                arrayList.add(K);
                return;
            }
            throw new IllegalArgumentException(c.a.a.a.a.l(RecyclerView.this, c.a.a.a.a.h("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0318, code lost:
            r7 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0323, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x0476, code lost:
            if ((r8 == 0 || r8 + r10 < r20) == false) goto L_0x0478;
         */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x040d  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x045f  */
        /* JADX WARNING: Removed duplicated region for block: B:234:0x04ad  */
        /* JADX WARNING: Removed duplicated region for block: B:250:0x04de  */
        /* JADX WARNING: Removed duplicated region for block: B:253:0x04e7  */
        /* JADX WARNING: Removed duplicated region for block: B:257:0x04f2  */
        /* JADX WARNING: Removed duplicated region for block: B:258:0x04f9  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
        public a0 j(int i, boolean z, long j) {
            a0 a0Var;
            boolean z2;
            boolean z3;
            boolean z4;
            ViewGroup.LayoutParams layoutParams;
            n nVar;
            ViewGroup.LayoutParams layoutParams2;
            AccessibilityManager accessibilityManager;
            boolean z5;
            a0 a0Var2;
            a0 a0Var3;
            a0 a0Var4;
            View view;
            boolean z6;
            int size;
            int f2;
            if (i < 0 || i >= RecyclerView.this.h0.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i);
                sb.append("(");
                sb.append(i);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.h0.b());
                throw new IndexOutOfBoundsException(c.a.a.a.a.l(RecyclerView.this, sb));
            }
            int i2 = 32;
            boolean z7 = false;
            if (RecyclerView.this.h0.f349g) {
                ArrayList<a0> arrayList = this.f321b;
                if (arrayList != null && (size = arrayList.size()) != 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            a0Var = this.f321b.get(i3);
                            if (!a0Var.wasReturnedFromScrap() && a0Var.getLayoutPosition() == i) {
                                a0Var.addFlags(32);
                                break;
                            }
                            i3++;
                        } else if (RecyclerView.this.m.hasStableIds() && (f2 = RecyclerView.this.f282e.f(i, 0)) > 0 && f2 < RecyclerView.this.m.getItemCount()) {
                            long itemId = RecyclerView.this.m.getItemId(f2);
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size) {
                                    break;
                                }
                                a0 a0Var5 = this.f321b.get(i4);
                                if (!a0Var5.wasReturnedFromScrap() && a0Var5.getItemId() == itemId) {
                                    a0Var5.addFlags(32);
                                    a0Var = a0Var5;
                                    break;
                                }
                                i4++;
                            }
                        }
                    }
                    if (a0Var != null) {
                        z2 = true;
                        if (a0Var == null) {
                            int size2 = this.f320a.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 < size2) {
                                    a0Var4 = this.f320a.get(i5);
                                    if (a0Var4.wasReturnedFromScrap() || a0Var4.getLayoutPosition() != i || a0Var4.isInvalid() || (!RecyclerView.this.h0.f349g && a0Var4.isRemoved())) {
                                        i5++;
                                    }
                                } else {
                                    if (!z) {
                                        b.r.d.f fVar = RecyclerView.this.f283f;
                                        int size3 = fVar.f2334c.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size3) {
                                                view = null;
                                                break;
                                            }
                                            view = fVar.f2334c.get(i6);
                                            if (((b0) fVar.f2332a) != null) {
                                                a0 K = RecyclerView.K(view);
                                                if (!(K.getLayoutPosition() != i || K.isInvalid() || K.isRemoved())) {
                                                    break;
                                                }
                                                i6++;
                                            } else {
                                                throw null;
                                            }
                                        }
                                        if (view != null) {
                                            a0Var = RecyclerView.K(view);
                                            b.r.d.f fVar2 = RecyclerView.this.f283f;
                                            int indexOfChild = ((b0) fVar2.f2332a).f2297a.indexOfChild(view);
                                            if (indexOfChild < 0) {
                                                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                                            } else if (fVar2.f2333b.d(indexOfChild)) {
                                                fVar2.f2333b.a(indexOfChild);
                                                fVar2.l(view);
                                                int j2 = RecyclerView.this.f283f.j(view);
                                                if (j2 != -1) {
                                                    RecyclerView.this.f283f.c(j2);
                                                    i(view);
                                                    a0Var.addFlags(8224);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("layout index should not be -1 after unhiding a view:");
                                                    sb2.append(a0Var);
                                                    throw new IllegalStateException(c.a.a.a.a.l(RecyclerView.this, sb2));
                                                }
                                            } else {
                                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                                            }
                                        }
                                    }
                                    int size4 = this.f322c.size();
                                    for (int i7 = 0; i7 < size4; i7++) {
                                        a0Var4 = this.f322c.get(i7);
                                        if (!a0Var4.isInvalid() && a0Var4.getLayoutPosition() == i && !a0Var4.isAttachedToTransitionOverlay()) {
                                            if (!z) {
                                                this.f322c.remove(i7);
                                            }
                                        }
                                    }
                                    a0Var = null;
                                }
                            }
                            a0Var4.addFlags(32);
                            a0Var = a0Var4;
                            if (a0Var != null) {
                                if (a0Var.isRemoved()) {
                                    z6 = RecyclerView.this.h0.f349g;
                                } else {
                                    int i8 = a0Var.mPosition;
                                    if (i8 < 0 || i8 >= RecyclerView.this.m.getItemCount()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Inconsistency detected. Invalid view holder adapter position");
                                        sb3.append(a0Var);
                                        throw new IndexOutOfBoundsException(c.a.a.a.a.l(RecyclerView.this, sb3));
                                    }
                                    RecyclerView recyclerView = RecyclerView.this;
                                    z6 = (recyclerView.h0.f349g || recyclerView.m.getItemViewType(a0Var.mPosition) == a0Var.getItemViewType()) && (!RecyclerView.this.m.hasStableIds() || a0Var.getItemId() == RecyclerView.this.m.getItemId(a0Var.mPosition));
                                }
                                if (!z6) {
                                    if (!z) {
                                        a0Var.addFlags(4);
                                        if (a0Var.isScrap()) {
                                            RecyclerView.this.removeDetachedView(a0Var.itemView, false);
                                            a0Var.unScrap();
                                        } else if (a0Var.wasReturnedFromScrap()) {
                                            a0Var.clearReturnedFromScrapFlag();
                                        }
                                        h(a0Var);
                                    }
                                    a0Var = null;
                                } else {
                                    z2 = true;
                                }
                            }
                        }
                        if (a0Var == null) {
                            int f3 = RecyclerView.this.f282e.f(i, 0);
                            if (f3 < 0 || f3 >= RecyclerView.this.m.getItemCount()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Inconsistency detected. Invalid item position ");
                                sb4.append(i);
                                sb4.append("(offset:");
                                sb4.append(f3);
                                sb4.append(").state:");
                                sb4.append(RecyclerView.this.h0.b());
                                throw new IndexOutOfBoundsException(c.a.a.a.a.l(RecyclerView.this, sb4));
                            }
                            int itemViewType = RecyclerView.this.m.getItemViewType(f3);
                            if (RecyclerView.this.m.hasStableIds()) {
                                long itemId2 = RecyclerView.this.m.getItemId(f3);
                                int size5 = this.f320a.size() - 1;
                                while (true) {
                                    if (size5 < 0) {
                                        int size6 = this.f322c.size() - 1;
                                        while (true) {
                                            if (size6 < 0) {
                                                break;
                                            }
                                            a0Var3 = this.f322c.get(size6);
                                            if (a0Var3.getItemId() == itemId2 && !a0Var3.isAttachedToTransitionOverlay()) {
                                                if (itemViewType == a0Var3.getItemViewType()) {
                                                    if (!z) {
                                                        this.f322c.remove(size6);
                                                    }
                                                } else if (!z) {
                                                    f(size6);
                                                    break;
                                                }
                                            }
                                            size6--;
                                        }
                                    } else {
                                        a0Var3 = this.f320a.get(size5);
                                        if (a0Var3.getItemId() == itemId2 && !a0Var3.wasReturnedFromScrap()) {
                                            if (itemViewType == a0Var3.getItemViewType()) {
                                                a0Var3.addFlags(i2);
                                                if (a0Var3.isRemoved() && !RecyclerView.this.h0.f349g) {
                                                    a0Var3.setFlags(2, 14);
                                                }
                                            } else if (!z) {
                                                this.f320a.remove(size5);
                                                RecyclerView.this.removeDetachedView(a0Var3.itemView, false);
                                                a0 K2 = RecyclerView.K(a0Var3.itemView);
                                                K2.mScrapContainer = null;
                                                K2.mInChangeScrap = false;
                                                K2.clearReturnedFromScrapFlag();
                                                h(K2);
                                            }
                                        }
                                        size5--;
                                        i2 = 32;
                                    }
                                }
                                if (a0Var != null) {
                                    a0Var.mPosition = f3;
                                    z2 = true;
                                }
                            }
                            if (a0Var == null) {
                                r.a aVar = d().f314a.get(itemViewType);
                                if (aVar != null && !aVar.f316a.isEmpty()) {
                                    ArrayList<a0> arrayList2 = aVar.f316a;
                                    int size7 = arrayList2.size() - 1;
                                    while (true) {
                                        if (size7 < 0) {
                                            break;
                                        } else if (!arrayList2.get(size7).isAttachedToTransitionOverlay()) {
                                            a0Var2 = arrayList2.remove(size7);
                                            break;
                                        } else {
                                            size7--;
                                        }
                                    }
                                }
                                a0Var2 = null;
                                if (a0Var2 != null) {
                                    a0Var2.resetInternal();
                                    boolean z8 = RecyclerView.z0;
                                }
                                a0Var = a0Var2;
                            }
                            if (a0Var == null) {
                                long nanoTime = RecyclerView.this.getNanoTime();
                                if (j != Long.MAX_VALUE) {
                                    long j3 = this.f326g.a(itemViewType).f318c;
                                    if (!(j3 == 0 || j3 + nanoTime < j)) {
                                        return null;
                                    }
                                }
                                RecyclerView recyclerView2 = RecyclerView.this;
                                a0 createViewHolder = recyclerView2.m.createViewHolder(recyclerView2, itemViewType);
                                boolean z9 = RecyclerView.C0;
                                RecyclerView F = RecyclerView.F(createViewHolder.itemView);
                                if (F != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference<>(F);
                                }
                                long nanoTime2 = RecyclerView.this.getNanoTime();
                                r rVar = this.f326g;
                                long j4 = nanoTime2 - nanoTime;
                                r.a a2 = rVar.a(itemViewType);
                                a2.f318c = rVar.b(a2.f318c, j4);
                                a0Var = createViewHolder;
                            }
                        }
                        if (z2 && !RecyclerView.this.h0.f349g && a0Var.hasAnyOfTheFlags(a0.FLAG_BOUNCED_FROM_HIDDEN_LIST)) {
                            a0Var.setFlags(0, a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                            if (RecyclerView.this.h0.j) {
                                j.b(a0Var);
                                RecyclerView recyclerView3 = RecyclerView.this;
                                j jVar = recyclerView3.M;
                                x xVar = recyclerView3.h0;
                                a0Var.getUnmodifiedPayloads();
                                RecyclerView.this.d0(a0Var, jVar.i(a0Var));
                            }
                        }
                        if (!RecyclerView.this.h0.f349g && a0Var.isBound()) {
                            a0Var.mPreLayoutPosition = i;
                        } else if (!a0Var.isBound() || a0Var.needsUpdate() || a0Var.isInvalid()) {
                            int f4 = RecyclerView.this.f282e.f(i, 0);
                            a0Var.mOwnerRecyclerView = RecyclerView.this;
                            int itemViewType2 = a0Var.getItemViewType();
                            long nanoTime3 = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE) {
                                long j5 = this.f326g.a(itemViewType2).f319d;
                            }
                            RecyclerView.this.m.bindViewHolder(a0Var, f4);
                            long nanoTime4 = RecyclerView.this.getNanoTime();
                            r rVar2 = this.f326g;
                            r.a a3 = rVar2.a(a0Var.getItemViewType());
                            a3.f319d = rVar2.b(a3.f319d, nanoTime4 - nanoTime3);
                            accessibilityManager = RecyclerView.this.C;
                            if (!(accessibilityManager == null && accessibilityManager.isEnabled())) {
                                View view2 = a0Var.itemView;
                                if (b.i.l.m.n(view2) == 0) {
                                    z5 = true;
                                    view2.setImportantForAccessibility(1);
                                } else {
                                    z5 = true;
                                }
                                d0 d0Var = RecyclerView.this.o0;
                                if (d0Var != null) {
                                    d0.a aVar2 = d0Var.f2323e;
                                    if (aVar2 instanceof d0.a) {
                                        if (aVar2 != null) {
                                            b.i.l.a g2 = b.i.l.m.g(view2);
                                            if (!(g2 == null || g2 == aVar2)) {
                                                aVar2.f2325e.put(view2, g2);
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                    b.i.l.m.U(view2, aVar2);
                                }
                                z3 = z5;
                            } else {
                                z3 = true;
                            }
                            if (RecyclerView.this.h0.f349g) {
                                a0Var.mPreLayoutPosition = i;
                            }
                            z4 = z3;
                            layoutParams = a0Var.itemView.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = RecyclerView.this.generateDefaultLayoutParams();
                            } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                layoutParams2 = RecyclerView.this.generateLayoutParams(layoutParams);
                            } else {
                                nVar = (n) layoutParams;
                                nVar.f310a = a0Var;
                                if (z2 && z3) {
                                    z7 = z4;
                                }
                                nVar.f313d = z7;
                                return a0Var;
                            }
                            nVar = (n) layoutParams2;
                            a0Var.itemView.setLayoutParams(nVar);
                            nVar.f310a = a0Var;
                            z7 = z4;
                            nVar.f313d = z7;
                            return a0Var;
                        }
                        z4 = true;
                        z3 = false;
                        layoutParams = a0Var.itemView.getLayoutParams();
                        if (layoutParams == null) {
                        }
                        nVar = (n) layoutParams2;
                        a0Var.itemView.setLayoutParams(nVar);
                        nVar.f310a = a0Var;
                        z7 = z4;
                        nVar.f313d = z7;
                        return a0Var;
                    }
                }
                a0Var = null;
                if (a0Var != null) {
                }
            } else {
                a0Var = null;
            }
            z2 = false;
            if (a0Var == null) {
            }
            if (a0Var == null) {
            }
            a0Var.setFlags(0, a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (RecyclerView.this.h0.j) {
            }
            if (!RecyclerView.this.h0.f349g) {
            }
            int f42 = RecyclerView.this.f282e.f(i, 0);
            a0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType22 = a0Var.getItemViewType();
            long nanoTime32 = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE) {
            }
            RecyclerView.this.m.bindViewHolder(a0Var, f42);
            long nanoTime42 = RecyclerView.this.getNanoTime();
            r rVar22 = this.f326g;
            r.a a32 = rVar22.a(a0Var.getItemViewType());
            a32.f319d = rVar22.b(a32.f319d, nanoTime42 - nanoTime32);
            accessibilityManager = RecyclerView.this.C;
            if (!(accessibilityManager == null && accessibilityManager.isEnabled())) {
            }
            if (RecyclerView.this.h0.f349g) {
            }
            z4 = z3;
            layoutParams = a0Var.itemView.getLayoutParams();
            if (layoutParams == null) {
            }
            nVar = (n) layoutParams2;
            a0Var.itemView.setLayoutParams(nVar);
            nVar.f310a = a0Var;
            z7 = z4;
            nVar.f313d = z7;
            return a0Var;
        }

        public void k(a0 a0Var) {
            (a0Var.mInChangeScrap ? this.f321b : this.f320a).remove(a0Var);
            a0Var.mScrapContainer = null;
            a0Var.mInChangeScrap = false;
            a0Var.clearReturnedFromScrapFlag();
        }

        public void l() {
            m mVar = RecyclerView.this.n;
            this.f325f = this.f324e + (mVar != null ? mVar.m : 0);
            for (int size = this.f322c.size() - 1; size >= 0 && this.f322c.size() > this.f325f; size--) {
                f(size);
            }
        }
    }

    public interface t {
        void a(a0 a0Var);
    }

    public class u extends g {
        public u() {
        }

        public void a() {
            boolean z = RecyclerView.B0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.t || !recyclerView.s) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.B = true;
                recyclerView2.requestLayout();
                return;
            }
            b.i.l.m.N(recyclerView, recyclerView.i);
        }
    }

    public static class v extends b.k.a.a {
        public static final Parcelable.Creator<v> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public Parcelable f328d;

        public static class a implements Parcelable.ClassLoaderCreator<v> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new v(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new v[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public v createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new v(parcel, classLoader);
            }
        }

        public v(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f328d = parcel.readParcelable(classLoader == null ? m.class.getClassLoader() : classLoader);
        }

        public v(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            parcel.writeParcelable(this.f328d, 0);
        }
    }

    public static abstract class w {

        /* renamed from: a  reason: collision with root package name */
        public int f329a = -1;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f330b;

        /* renamed from: c  reason: collision with root package name */
        public m f331c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f332d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f333e;

        /* renamed from: f  reason: collision with root package name */
        public View f334f;

        /* renamed from: g  reason: collision with root package name */
        public final a f335g = new a(0, 0);
        public boolean h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f336a;

            /* renamed from: b  reason: collision with root package name */
            public int f337b;

            /* renamed from: c  reason: collision with root package name */
            public int f338c;

            /* renamed from: d  reason: collision with root package name */
            public int f339d = -1;

            /* renamed from: e  reason: collision with root package name */
            public Interpolator f340e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f341f = false;

            /* renamed from: g  reason: collision with root package name */
            public int f342g = 0;

            public a(int i, int i2) {
                this.f336a = i;
                this.f337b = i2;
                this.f338c = BleSignal.UNKNOWN_TX_POWER;
                this.f340e = null;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.f339d;
                if (i >= 0) {
                    this.f339d = -1;
                    recyclerView.Q(i);
                    this.f341f = false;
                } else if (!this.f341f) {
                    this.f342g = 0;
                } else if (this.f340e == null || this.f338c >= 1) {
                    int i2 = this.f338c;
                    if (i2 >= 1) {
                        recyclerView.e0.b(this.f336a, this.f337b, i2, this.f340e);
                        this.f342g++;
                        this.f341f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.f336a = i;
                this.f337b = i2;
                this.f338c = i3;
                this.f340e = interpolator;
                this.f341f = true;
            }
        }

        public interface b {
            PointF a(int i);
        }

        public int a(View view) {
            if (this.f330b != null) {
                a0 K = RecyclerView.K(view);
                if (K != null) {
                    return K.getLayoutPosition();
                }
                return -1;
            }
            throw null;
        }

        public void b(int i, int i2) {
            m mVar;
            RecyclerView recyclerView = this.f330b;
            if (this.f329a == -1 || recyclerView == null) {
                d();
            }
            PointF pointF = null;
            if (this.f332d && this.f334f == null && (mVar = this.f331c) != null) {
                PointF a2 = mVar instanceof b ? ((b) mVar).a(this.f329a) : null;
                if (!(a2 == null || (a2.x == 0.0f && a2.y == 0.0f))) {
                    recyclerView.i0((int) Math.signum(a2.x), (int) Math.signum(a2.y), null);
                }
            }
            boolean z = false;
            this.f332d = false;
            View view = this.f334f;
            if (view != null) {
                if (a(view) == this.f329a) {
                    c(this.f334f, recyclerView.h0, this.f335g);
                    this.f335g.a(recyclerView);
                    d();
                } else {
                    this.f334f = null;
                }
            }
            if (this.f333e) {
                x xVar = recyclerView.h0;
                a aVar = this.f335g;
                b.r.d.t tVar = (b.r.d.t) this;
                if (tVar.f330b.n.y() == 0) {
                    tVar.d();
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
                        int i7 = tVar.f329a;
                        m mVar2 = tVar.f331c;
                        if (mVar2 instanceof b) {
                            pointF = ((b) mVar2).a(i7);
                        }
                        if (pointF == null || (pointF.x == 0.0f && pointF.y == 0.0f)) {
                            aVar.f339d = tVar.f329a;
                            tVar.d();
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
                            aVar.b((int) (((float) tVar.o) * 1.2f), (int) (((float) tVar.p) * 1.2f), (int) (((float) tVar.g(10000)) * 1.2f), tVar.i);
                        }
                    }
                }
                if (this.f335g.f339d >= 0) {
                    z = true;
                }
                this.f335g.a(recyclerView);
                if (z && this.f333e) {
                    this.f332d = true;
                    recyclerView.e0.a();
                }
            }
        }

        public abstract void c(View view, x xVar, a aVar);

        public final void d() {
            if (this.f333e) {
                this.f333e = false;
                b.r.d.t tVar = (b.r.d.t) this;
                tVar.p = 0;
                tVar.o = 0;
                tVar.k = null;
                this.f330b.h0.f343a = -1;
                this.f334f = null;
                this.f329a = -1;
                this.f332d = false;
                m mVar = this.f331c;
                if (mVar.f303g == this) {
                    mVar.f303g = null;
                }
                this.f331c = null;
                this.f330b = null;
            }
        }
    }

    public static class x {

        /* renamed from: a  reason: collision with root package name */
        public int f343a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f344b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f345c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f346d = 1;

        /* renamed from: e  reason: collision with root package name */
        public int f347e = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f348f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f349g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;
        public int o;

        public void a(int i2) {
            if ((this.f346d & i2) == 0) {
                StringBuilder h2 = c.a.a.a.a.h("Layout state should be one of ");
                h2.append(Integer.toBinaryString(i2));
                h2.append(" but it is ");
                h2.append(Integer.toBinaryString(this.f346d));
                throw new IllegalStateException(h2.toString());
            }
        }

        public int b() {
            return this.f349g ? this.f344b - this.f345c : this.f347e;
        }

        public String toString() {
            StringBuilder h2 = c.a.a.a.a.h("State{mTargetPosition=");
            h2.append(this.f343a);
            h2.append(", mData=");
            h2.append((Object) null);
            h2.append(", mItemCount=");
            h2.append(this.f347e);
            h2.append(", mIsMeasuring=");
            h2.append(this.i);
            h2.append(", mPreviousLayoutItemCount=");
            h2.append(this.f344b);
            h2.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            h2.append(this.f345c);
            h2.append(", mStructureChanged=");
            h2.append(this.f348f);
            h2.append(", mInPreLayout=");
            h2.append(this.f349g);
            h2.append(", mRunSimpleAnimations=");
            h2.append(this.j);
            h2.append(", mRunPredictiveAnimations=");
            h2.append(this.k);
            h2.append('}');
            return h2.toString();
        }
    }

    public static abstract class y {
    }

    public class z implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f350b;

        /* renamed from: c  reason: collision with root package name */
        public int f351c;

        /* renamed from: d  reason: collision with root package name */
        public OverScroller f352d;

        /* renamed from: e  reason: collision with root package name */
        public Interpolator f353e = RecyclerView.E0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f354f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f355g = false;

        public z() {
            this.f352d = new OverScroller(RecyclerView.this.getContext(), RecyclerView.E0);
        }

        public void a() {
            if (this.f354f) {
                this.f355g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            b.i.l.m.N(RecyclerView.this, this);
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
                i3 = Math.min(i4, 2000);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.E0;
            }
            if (this.f353e != interpolator) {
                this.f353e = interpolator;
                this.f352d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f351c = 0;
            this.f350b = 0;
            RecyclerView.this.setScrollState(2);
            this.f352d.startScroll(0, 0, i, i2, i3);
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.f352d.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.n == null) {
                c();
                return;
            }
            this.f355g = false;
            this.f354f = true;
            recyclerView.n();
            OverScroller overScroller = this.f352d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f350b;
                int i4 = currY - this.f351c;
                this.f350b = currX;
                this.f351c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.u0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.t(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.u0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.m(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.m != null) {
                    int[] iArr3 = recyclerView3.u0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.i0(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.u0;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    w wVar = recyclerView4.n.f303g;
                    if (wVar != null && !wVar.f332d && wVar.f333e) {
                        int b2 = recyclerView4.h0.b();
                        if (b2 == 0) {
                            wVar.d();
                        } else {
                            if (wVar.f329a >= b2) {
                                wVar.f329a = b2 - 1;
                            }
                            wVar.b(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.u0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.u(i, i2, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.u0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    RecyclerView.this.v(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                w wVar2 = RecyclerView.this.n.f303g;
                if ((wVar2 != null && wVar2.f332d) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    b.r.d.r rVar = recyclerView6.f0;
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
                        RecyclerView recyclerView7 = RecyclerView.this;
                        if (recyclerView7 != null) {
                            if (i7 < 0) {
                                recyclerView7.x();
                                if (recyclerView7.I.isFinished()) {
                                    recyclerView7.I.onAbsorb(-i7);
                                }
                            } else if (i7 > 0) {
                                recyclerView7.y();
                                if (recyclerView7.K.isFinished()) {
                                    recyclerView7.K.onAbsorb(i7);
                                }
                            }
                            if (currVelocity < 0) {
                                recyclerView7.z();
                                if (recyclerView7.J.isFinished()) {
                                    recyclerView7.J.onAbsorb(-currVelocity);
                                }
                            } else if (currVelocity > 0) {
                                recyclerView7.w();
                                if (recyclerView7.L.isFinished()) {
                                    recyclerView7.L.onAbsorb(currVelocity);
                                }
                            }
                            if (!(i7 == 0 && currVelocity == 0)) {
                                b.i.l.m.M(recyclerView7);
                            }
                        } else {
                            throw null;
                        }
                    }
                    boolean z2 = RecyclerView.C0;
                    r.b bVar = RecyclerView.this.g0;
                    int[] iArr7 = bVar.f2434c;
                    if (iArr7 != null) {
                        Arrays.fill(iArr7, -1);
                    }
                    bVar.f2435d = 0;
                }
            }
            w wVar3 = RecyclerView.this.n.f303g;
            if (wVar3 != null && wVar3.f332d) {
                wVar3.b(0, 0);
            }
            this.f354f = false;
            if (this.f355g) {
                RecyclerView.this.removeCallbacks(this);
                b.i.l.m.N(RecyclerView.this, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.p0(1);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        D0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.r.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        char c2;
        StringBuilder sb;
        Constructor<? extends U> constructor;
        this.f279b = new u();
        this.f280c = new s();
        this.f284g = new i0();
        this.i = new a();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.w = 0;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = new i();
        this.M = new b.r.d.o();
        this.N = 0;
        this.O = -1;
        this.b0 = Float.MIN_VALUE;
        this.c0 = Float.MIN_VALUE;
        this.d0 = true;
        this.e0 = new z();
        this.g0 = new r.b();
        this.h0 = new x();
        this.k0 = false;
        this.l0 = false;
        this.m0 = new k();
        this.n0 = false;
        this.q0 = new int[2];
        this.s0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new ArrayList();
        this.w0 = new b();
        this.x0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.b0 = b.i.l.q.b(viewConfiguration, context);
        this.c0 = Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : b.i.l.q.a(viewConfiguration, context);
        this.W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.a0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.M.f288a = this.m0;
        this.f282e = new b.r.d.a(new c0(this));
        this.f283f = new b.r.d.f(new b0(this));
        if (b.i.l.m.o(this) == 0 && Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new d0(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.c.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, b.r.c.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(b.r.c.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(b.r.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.h = obtainStyledAttributes.getBoolean(b.r.c.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(b.r.c.RecyclerView_fastScrollEnabled, false);
        this.u = z2;
        if (z2) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(c.a.a.a.a.l(this, c.a.a.a.a.h("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            typedArray = obtainStyledAttributes;
            c2 = 2;
            new b.r.d.q(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(b.r.b.fastscroll_default_thickness), resources.getDimensionPixelSize(b.r.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(b.r.b.fastscroll_margin));
        } else {
            typedArray = obtainStyledAttributes;
            c2 = 2;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(trim);
                    trim = sb.toString();
                } else if (!trim.contains(".")) {
                    sb = new StringBuilder();
                    sb.append(RecyclerView.class.getPackage().getName());
                    sb.append('.');
                    sb.append(trim);
                    trim = sb.toString();
                }
                try {
                    Class<? extends U> asSubclass = Class.forName(trim, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(m.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(D0);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[1] = attributeSet;
                        objArr2[c2] = Integer.valueOf(i2);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((m) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e8);
                }
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, y0, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, y0, attributeSet, obtainStyledAttributes2, i2, 0);
        }
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public static RecyclerView F(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView F2 = F(viewGroup.getChildAt(i2));
            if (F2 != null) {
                return F2;
            }
        }
        return null;
    }

    public static a0 K(View view) {
        if (view == null) {
            return null;
        }
        return ((n) view.getLayoutParams()).f310a;
    }

    public static void L(View view, Rect rect) {
        n nVar = (n) view.getLayoutParams();
        Rect rect2 = nVar.f311b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
    }

    private b.i.l.f getScrollingChildHelper() {
        if (this.r0 == null) {
            this.r0 = new b.i.l.f(this);
        }
        return this.r0;
    }

    public static void k(a0 a0Var) {
        WeakReference<RecyclerView> weakReference = a0Var.mNestedRecyclerView;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                View view = (View) viewParent;
                while (true) {
                    if (view == null) {
                        a0Var.mNestedRecyclerView = null;
                        return;
                    } else if (view != a0Var.itemView) {
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

    public String A() {
        StringBuilder h2 = c.a.a.a.a.h(" ");
        h2.append(super.toString());
        h2.append(", adapter:");
        h2.append(this.m);
        h2.append(", layout:");
        h2.append(this.n);
        h2.append(", context:");
        h2.append(getContext());
        return h2.toString();
    }

    public final void B(x xVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.e0.f352d;
            xVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        xVar.o = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public View C(View view) {
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

    public final boolean D(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.q.get(i2);
            if (pVar.a(this, motionEvent) && action != 3) {
                this.r = pVar;
                return true;
            }
        }
        return false;
    }

    public final void E(int[] iArr) {
        int e2 = this.f283f.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = BleSignal.UNKNOWN_TX_POWER;
        for (int i4 = 0; i4 < e2; i4++) {
            a0 K2 = K(this.f283f.d(i4));
            if (!K2.shouldIgnore()) {
                int layoutPosition = K2.getLayoutPosition();
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

    public a0 G(int i2) {
        a0 a0Var = null;
        if (this.D) {
            return null;
        }
        int h2 = this.f283f.h();
        for (int i3 = 0; i3 < h2; i3++) {
            a0 K2 = K(this.f283f.g(i3));
            if (K2 != null && !K2.isRemoved() && H(K2) == i2) {
                if (!this.f283f.k(K2.itemView)) {
                    return K2;
                }
                a0Var = K2;
            }
        }
        return a0Var;
    }

    public int H(a0 a0Var) {
        if (!a0Var.hasAnyOfTheFlags(524) && a0Var.isBound()) {
            b.r.d.a aVar = this.f282e;
            int i2 = a0Var.mPosition;
            int size = aVar.f2283b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.f2283b.get(i3);
                int i4 = bVar.f2289a;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = bVar.f2290b;
                        if (i5 <= i2) {
                            int i6 = bVar.f2292d;
                            if (i5 + i6 <= i2) {
                                i2 -= i6;
                            }
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = bVar.f2290b;
                        if (i7 == i2) {
                            i2 = bVar.f2292d;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (bVar.f2292d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.f2290b <= i2) {
                    i2 += bVar.f2292d;
                }
            }
            return i2;
        }
        return -1;
    }

    public long I(a0 a0Var) {
        return this.m.hasStableIds() ? a0Var.getItemId() : (long) a0Var.mPosition;
    }

    public a0 J(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return K(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public Rect M(View view) {
        n nVar = (n) view.getLayoutParams();
        if (!nVar.f312c) {
            return nVar.f311b;
        }
        if (this.h0.f349g && (nVar.b() || nVar.f310a.isInvalid())) {
            return nVar.f311b;
        }
        Rect rect = nVar.f311b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.set(0, 0, 0, 0);
            l lVar = this.p.get(i2);
            Rect rect2 = this.j;
            if (lVar != null) {
                ((n) view.getLayoutParams()).a();
                rect2.set(0, 0, 0, 0);
                int i3 = rect.left;
                Rect rect3 = this.j;
                rect.left = i3 + rect3.left;
                rect.top += rect3.top;
                rect.right += rect3.right;
                rect.bottom += rect3.bottom;
            } else {
                throw null;
            }
        }
        nVar.f312c = false;
        return rect;
    }

    public boolean N() {
        return !this.v || this.D || this.f282e.g();
    }

    public void O() {
        this.L = null;
        this.J = null;
        this.K = null;
        this.I = null;
    }

    public boolean P() {
        return this.F > 0;
    }

    public void Q(int i2) {
        if (this.n != null) {
            setScrollState(2);
            this.n.K0(i2);
            awakenScrollBars();
        }
    }

    public void R() {
        int h2 = this.f283f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((n) this.f283f.g(i2).getLayoutParams()).f312c = true;
        }
        s sVar = this.f280c;
        int size = sVar.f322c.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) sVar.f322c.get(i3).itemView.getLayoutParams();
            if (nVar != null) {
                nVar.f312c = true;
            }
        }
    }

    public void S(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.f283f.h();
        for (int i5 = 0; i5 < h2; i5++) {
            a0 K2 = K(this.f283f.g(i5));
            if (K2 != null && !K2.shouldIgnore()) {
                int i6 = K2.mPosition;
                if (i6 >= i4) {
                    K2.offsetPosition(-i3, z2);
                } else if (i6 >= i2) {
                    K2.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                }
                this.h0.f348f = true;
            }
        }
        s sVar = this.f280c;
        int size = sVar.f322c.size();
        while (true) {
            size--;
            if (size >= 0) {
                a0 a0Var = sVar.f322c.get(size);
                if (a0Var != null) {
                    int i7 = a0Var.mPosition;
                    if (i7 >= i4) {
                        a0Var.offsetPosition(-i3, z2);
                    } else if (i7 >= i2) {
                        a0Var.addFlags(8);
                        sVar.f(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void T() {
    }

    public void U() {
    }

    public void V() {
        this.F++;
    }

    public void W(boolean z2) {
        int i2;
        boolean z3 = true;
        int i3 = this.F - 1;
        this.F = i3;
        if (i3 < 1) {
            this.F = 0;
            if (z2) {
                int i4 = this.A;
                this.A = 0;
                if (i4 != 0) {
                    AccessibilityManager accessibilityManager = this.C;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z3 = false;
                    }
                    if (z3) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        obtain.setContentChangeTypes(i4);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.v0.size() - 1; size >= 0; size--) {
                    a0 a0Var = this.v0.get(size);
                    if (a0Var.itemView.getParent() == this && !a0Var.shouldIgnore() && (i2 = a0Var.mPendingAccessibilityState) != -1) {
                        b.i.l.m.b0(a0Var.itemView, i2);
                        a0Var.mPendingAccessibilityState = -1;
                    }
                }
                this.v0.clear();
            }
        }
    }

    public final void X(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.O = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.S = x2;
            this.Q = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.T = y2;
            this.R = y2;
        }
    }

    public void Y() {
    }

    public void Z() {
    }

    public void a0() {
        if (!this.n0 && this.s) {
            b.i.l.m.N(this, this.w0);
            this.n0 = true;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        m mVar = this.n;
        if (mVar == null || !mVar.c0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public final void b0() {
        boolean z2 = false;
        if (this.D) {
            b.r.d.a aVar = this.f282e;
            aVar.l(aVar.f2283b);
            aVar.l(aVar.f2284c);
            aVar.f2288g = 0;
            if (this.E) {
                this.n.n0(this);
            }
        }
        if (this.M != null && this.n.W0()) {
            this.f282e.j();
        } else {
            this.f282e.c();
        }
        boolean z3 = this.k0 || this.l0;
        this.h0.j = this.v && this.M != null && (this.D || z3 || this.n.h) && (!this.D || this.m.hasStableIds());
        x xVar = this.h0;
        if (xVar.j && z3 && !this.D) {
            if (this.M != null && this.n.W0()) {
                z2 = true;
            }
        }
        xVar.k = z2;
    }

    public void c0(boolean z2) {
        this.E = z2 | this.E;
        this.D = true;
        int h2 = this.f283f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            a0 K2 = K(this.f283f.g(i2));
            if (K2 != null && !K2.shouldIgnore()) {
                K2.addFlags(6);
            }
        }
        R();
        s sVar = this.f280c;
        int size = sVar.f322c.size();
        for (int i3 = 0; i3 < size; i3++) {
            a0 a0Var = sVar.f322c.get(i3);
            if (a0Var != null) {
                a0Var.addFlags(6);
                a0Var.addChangePayload(null);
            }
        }
        e eVar = RecyclerView.this.m;
        if (eVar == null || !eVar.hasStableIds()) {
            sVar.e();
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof n) && this.n.g((n) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.k(this.h0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.l(this.h0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.m(this.h0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.n(this.h0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.o(this.h0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.p(this.h0);
        }
        return 0;
    }

    public void d0(a0 a0Var, j.c cVar) {
        a0Var.setFlags(0, a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        if (this.h0.h && a0Var.isUpdated() && !a0Var.isRemoved() && !a0Var.shouldIgnore()) {
            this.f284g.f2356b.g(I(a0Var), a0Var);
        }
        this.f284g.c(a0Var, cVar);
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

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr);
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
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).e(canvas, this, this.h0);
        }
        EdgeEffect edgeEffect = this.I;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.I;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.J;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.K;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                f3 = (float) (getPaddingRight() + (-getWidth()));
                f2 = (float) (getPaddingBottom() + (-getHeight()));
            } else {
                f3 = (float) (-getWidth());
                f2 = (float) (-getHeight());
            }
            canvas.translate(f3, f2);
            EdgeEffect edgeEffect8 = this.L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.M == null || this.p.size() <= 0 || !this.M.h()) {
            z4 = z2;
        }
        if (z4) {
            b.i.l.m.M(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void e0() {
        j jVar = this.M;
        if (jVar != null) {
            jVar.g();
        }
        m mVar = this.n;
        if (mVar != null) {
            mVar.C0(this.f280c);
            this.n.D0(this.f280c);
        }
        this.f280c.b();
    }

    public final void f(a0 a0Var) {
        View view = a0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.f280c.k(J(view));
        if (a0Var.isTmpDetached()) {
            this.f283f.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        b.r.d.f fVar = this.f283f;
        if (!z2) {
            fVar.a(view, -1, true);
            return;
        }
        int indexOfChild = ((b0) fVar.f2332a).f2297a.indexOfChild(view);
        if (indexOfChild >= 0) {
            fVar.f2333b.h(indexOfChild);
            fVar.i(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final void f0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof n) {
            n nVar = (n) layoutParams;
            if (!nVar.f312c) {
                Rect rect = nVar.f311b;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.n.H0(this, view, this.j, !this.v, view2 == null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x018c, code lost:
        if (r8 > 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01a6, code lost:
        if (r2 > 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01a9, code lost:
        if (r8 < 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ac, code lost:
        if (r2 < 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01b4, code lost:
        if ((r2 * r3) < 0) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01bc, code lost:
        if ((r2 * r3) > 0) goto L_0x01bf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0075  */
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View l02 = this.n.l0();
        if (l02 != null) {
            return l02;
        }
        boolean z3 = true;
        int i3 = 0;
        boolean z4 = this.m != null && this.n != null && !P() && !this.y;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                n();
                if (C(view) == null) {
                    return null;
                }
                m0();
                view2 = this.n.g0(view, i2, this.f280c, this.h0);
                o0(false);
            }
        } else {
            if (this.n.f()) {
                if (instance.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                    z2 = true;
                    if (!z2 && this.n.e()) {
                        z2 = instance.findNextFocus(this, view, !((this.n.I() != 1) ^ (i2 != 2)) ? 66 : 17) != null;
                    }
                    if (z2) {
                        n();
                        if (C(view) == null) {
                            return null;
                        }
                        m0();
                        this.n.g0(view, i2, this.f280c, this.h0);
                        o0(false);
                    }
                    view2 = instance.findNextFocus(this, view, i2);
                }
            }
            z2 = false;
            if (instance.findNextFocus(this, view, !((this.n.I() != 1) ^ (i2 != 2)) ? 66 : 17) != null) {
            }
            if (z2) {
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (!(view2 == null || view2 == this)) {
                if (C(view2) == null) {
                    z3 = false;
                } else if (!(view == null || C(view) == null)) {
                    this.j.set(0, 0, view.getWidth(), view.getHeight());
                    this.k.set(0, 0, view2.getWidth(), view2.getHeight());
                    offsetDescendantRectToMyCoords(view, this.j);
                    offsetDescendantRectToMyCoords(view2, this.k);
                    char c2 = 65535;
                    int i4 = this.n.I() == 1 ? -1 : 1;
                    Rect rect = this.j;
                    int i5 = rect.left;
                    int i6 = this.k.left;
                    if ((i5 < i6 || rect.right <= i6) && this.j.right < this.k.right) {
                        i3 = 1;
                    } else {
                        Rect rect2 = this.j;
                        int i7 = rect2.right;
                        int i8 = this.k.right;
                        if ((i7 > i8 || rect2.left >= i8) && this.j.left > this.k.left) {
                            i3 = -1;
                        }
                    }
                    Rect rect3 = this.j;
                    int i9 = rect3.top;
                    int i10 = this.k.top;
                    if ((i9 < i10 || rect3.bottom <= i10) && this.j.bottom < this.k.bottom) {
                        c2 = 1;
                    } else {
                        Rect rect4 = this.j;
                        int i11 = rect4.bottom;
                        int i12 = this.k.bottom;
                        if ((i11 <= i12 && rect4.top < i12) || this.j.top <= this.k.top) {
                            c2 = 0;
                        }
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 17) {
                                if (i2 != 33) {
                                    if (i2 != 66) {
                                        if (i2 != 130) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Invalid direction: ");
                                            sb.append(i2);
                                            throw new IllegalArgumentException(c.a.a.a.a.l(this, sb));
                                        }
                                    }
                                }
                            }
                        } else if (c2 <= 0) {
                            if (c2 == 0) {
                            }
                        }
                    } else if (c2 >= 0) {
                        if (c2 == 0) {
                        }
                    }
                }
                return !z3 ? view2 : super.focusSearch(view, i2);
            }
            z3 = false;
            if (!z3) {
            }
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            f0(view2, null);
            return view;
        }
    }

    public void g(l lVar) {
        m mVar = this.n;
        if (mVar != null) {
            mVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        this.p.add(lVar);
        R();
        requestLayout();
    }

    public final void g0() {
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        p0(0);
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.L.isFinished();
        }
        if (z2) {
            b.i.l.m.M(this);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.u();
        }
        throw new IllegalStateException(c.a.a.a.a.l(this, c.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.v(getContext(), attributeSet);
        }
        throw new IllegalStateException(c.a.a.a.a.l(this, c.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.w(layoutParams);
        }
        throw new IllegalStateException(c.a.a.a.a.l(this, c.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public e getAdapter() {
        return this.m;
    }

    public int getBaseline() {
        m mVar = this.n;
        if (mVar == null) {
            return super.getBaseline();
        }
        if (mVar != null) {
            return -1;
        }
        throw null;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        h hVar = this.p0;
        return hVar == null ? super.getChildDrawingOrder(i2, i3) : hVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public d0 getCompatAccessibilityDelegate() {
        return this.o0;
    }

    public i getEdgeEffectFactory() {
        return this.H;
    }

    public j getItemAnimator() {
        return this.M;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public m getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.a0;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public o getOnFlingListener() {
        return this.V;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.d0;
    }

    public r getRecycledViewPool() {
        return this.f280c.d();
    }

    public int getScrollState() {
        return this.N;
    }

    public void h(q qVar) {
        if (this.j0 == null) {
            this.j0 = new ArrayList();
        }
        this.j0.add(qVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f3  */
    public boolean h0(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        float f2;
        EdgeEffect edgeEffect;
        float f3;
        n();
        if (this.m != null) {
            int[] iArr = this.u0;
            iArr[0] = 0;
            iArr[1] = 0;
            i0(i2, i3, iArr);
            int[] iArr2 = this.u0;
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
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.u0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        u(i6, i7, i5, i4, this.s0, 0, iArr3);
        int[] iArr4 = this.u0;
        int i10 = i5 - iArr4[0];
        int i11 = i4 - iArr4[1];
        boolean z3 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.S;
        int[] iArr5 = this.s0;
        this.S = i12 - iArr5[0];
        this.T -= iArr5[1];
        int[] iArr6 = this.t0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    float x2 = motionEvent.getX();
                    float f4 = (float) i10;
                    float y2 = motionEvent.getY();
                    float f5 = (float) i11;
                    if (f4 < 0.0f) {
                        x();
                        edgeEffect = this.I;
                        f2 = (-f4) / ((float) getWidth());
                        f3 = 1.0f - (y2 / ((float) getHeight()));
                    } else if (f4 > 0.0f) {
                        y();
                        edgeEffect = this.K;
                        f2 = f4 / ((float) getWidth());
                        f3 = y2 / ((float) getHeight());
                    } else {
                        z2 = false;
                        if (f5 >= 0.0f) {
                            z();
                            this.J.onPull((-f5) / ((float) getHeight()), x2 / ((float) getWidth()));
                        } else {
                            if (f5 > 0.0f) {
                                w();
                                this.L.onPull(f5 / ((float) getHeight()), 1.0f - (x2 / ((float) getWidth())));
                            }
                            if (!(!z2 && f4 == 0.0f && f5 == 0.0f)) {
                                b.i.l.m.M(this);
                            }
                        }
                        z2 = true;
                        b.i.l.m.M(this);
                    }
                    edgeEffect.onPull(f2, f3);
                    z2 = true;
                    if (f5 >= 0.0f) {
                    }
                    z2 = true;
                    b.i.l.m.M(this);
                }
            }
            m(i2, i3);
        }
        if (!(i6 == 0 && i7 == 0)) {
            v(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z3 && i6 == 0 && i7 == 0) {
            return false;
        }
        return true;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public void i(String str) {
        if (P()) {
            if (str == null) {
                throw new IllegalStateException(c.a.a.a.a.l(this, c.a.a.a.a.h("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.G > 0) {
            new IllegalStateException(c.a.a.a.a.l(this, c.a.a.a.a.h("")));
        }
    }

    public void i0(int i2, int i3, int[] iArr) {
        a0 a0Var;
        m0();
        V();
        b.i.h.f.a("RV Scroll");
        B(this.h0);
        int J0 = i2 != 0 ? this.n.J0(i2, this.f280c, this.h0) : 0;
        int L0 = i3 != 0 ? this.n.L0(i3, this.f280c, this.h0) : 0;
        Trace.endSection();
        int e2 = this.f283f.e();
        for (int i4 = 0; i4 < e2; i4++) {
            View d2 = this.f283f.d(i4);
            a0 J2 = J(d2);
            if (!(J2 == null || (a0Var = J2.mShadowingHolder) == null)) {
                View view = a0Var.itemView;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        W(true);
        o0(false);
        if (iArr != null) {
            iArr[0] = J0;
            iArr[1] = L0;
        }
    }

    public boolean isAttachedToWindow() {
        return this.s;
    }

    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1859d;
    }

    public final void j() {
        g0();
        setScrollState(0);
    }

    public void j0(int i2) {
        if (!this.y) {
            q0();
            m mVar = this.n;
            if (mVar != null) {
                mVar.K0(i2);
                awakenScrollBars();
            }
        }
    }

    public boolean k0(a0 a0Var, int i2) {
        if (P()) {
            a0Var.mPendingAccessibilityState = i2;
            this.v0.add(a0Var);
            return false;
        }
        b.i.l.m.b0(a0Var.itemView, i2);
        return true;
    }

    public void l() {
        int h2 = this.f283f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            a0 K2 = K(this.f283f.g(i2));
            if (!K2.shouldIgnore()) {
                K2.clearOldPosition();
            }
        }
        s sVar = this.f280c;
        int size = sVar.f322c.size();
        for (int i3 = 0; i3 < size; i3++) {
            sVar.f322c.get(i3).clearOldPosition();
        }
        int size2 = sVar.f320a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            sVar.f320a.get(i4).clearOldPosition();
        }
        ArrayList<a0> arrayList = sVar.f321b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                sVar.f321b.get(i5).clearOldPosition();
            }
        }
    }

    public void l0(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        m mVar = this.n;
        if (mVar != null && !this.y) {
            int i5 = 0;
            if (!mVar.e()) {
                i2 = 0;
            }
            if (!this.n.f()) {
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
                        n0(i5, 1);
                    }
                    this.e0.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void m(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.I.onRelease();
            z2 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.J.onRelease();
            z2 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        if (z2) {
            b.i.l.m.M(this);
        }
    }

    public void m0() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 == 1 && !this.y) {
            this.x = false;
        }
    }

    public void n() {
        if (!this.v || this.D) {
            b.i.h.f.a("RV FullInvalidate");
            q();
            Trace.endSection();
        } else if (this.f282e.g()) {
            boolean z2 = false;
            if ((this.f282e.f2288g & 4) != 0) {
                if (!((this.f282e.f2288g & 11) != 0)) {
                    b.i.h.f.a("RV PartialInvalidate");
                    m0();
                    V();
                    this.f282e.j();
                    if (!this.x) {
                        int e2 = this.f283f.e();
                        int i2 = 0;
                        while (true) {
                            if (i2 < e2) {
                                a0 K2 = K(this.f283f.d(i2));
                                if (K2 != null && !K2.shouldIgnore() && K2.isUpdated()) {
                                    z2 = true;
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            q();
                        } else {
                            this.f282e.b();
                        }
                    }
                    o0(true);
                    W(true);
                    Trace.endSection();
                }
            }
            if (this.f282e.g()) {
                b.i.h.f.a("RV FullInvalidate");
                q();
                Trace.endSection();
            }
        }
    }

    public boolean n0(int i2, int i3) {
        return getScrollingChildHelper().h(i2, i3);
    }

    public void o(int i2, int i3) {
        setMeasuredDimension(m.h(i2, getPaddingRight() + getPaddingLeft(), b.i.l.m.r(this)), m.h(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void o0(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                q();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.F = 0;
        this.s = true;
        this.v = this.v && !isLayoutRequested();
        m mVar = this.n;
        if (mVar != null) {
            mVar.i = true;
            mVar.d0();
        }
        this.n0 = false;
        b.r.d.r rVar = b.r.d.r.f2426f.get();
        this.f0 = rVar;
        if (rVar == null) {
            this.f0 = new b.r.d.r();
            Display k2 = b.i.l.m.k(this);
            float f2 = 60.0f;
            if (!isInEditMode() && k2 != null) {
                float refreshRate = k2.getRefreshRate();
                if (refreshRate >= 30.0f) {
                    f2 = refreshRate;
                }
            }
            b.r.d.r rVar2 = this.f0;
            rVar2.f2430d = (long) (1.0E9f / f2);
            b.r.d.r.f2426f.set(rVar2);
        }
        this.f0.f2428b.add(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.M;
        if (jVar != null) {
            jVar.g();
        }
        q0();
        this.s = false;
        m mVar = this.n;
        if (mVar != null) {
            s sVar = this.f280c;
            mVar.i = false;
            mVar.f0(this, sVar);
        }
        this.v0.clear();
        removeCallbacks(this.w0);
        if (this.f284g != null) {
            do {
            } while (i0.a.f2357d.a() != null);
            b.r.d.r rVar = this.f0;
            if (rVar != null) {
                rVar.f2428b.remove(this);
                this.f0 = null;
                return;
            }
            return;
        }
        throw null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).d(canvas, this, this.h0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.n != null && !this.y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.n.f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.n.e()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        h0((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.n.f()) {
                        f3 = -axisValue;
                    } else if (this.n.e()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        h0((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
                    }
                }
                f3 = 0.0f;
                f2 = 0.0f;
                h0((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
            }
            f2 = 0.0f;
            h0((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        this.r = null;
        if (D(motionEvent)) {
            j();
            return true;
        }
        m mVar = this.n;
        if (mVar == null) {
            return false;
        }
        boolean e2 = mVar.e();
        boolean f2 = this.n.f();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.O = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.S = x2;
            this.Q = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.T = y2;
            this.R = y2;
            if (this.N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                p0(1);
            }
            int[] iArr = this.t0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = e2 ? 1 : 0;
            if (f2) {
                i2 |= 2;
            }
            n0(i2, 0);
        } else if (actionMasked == 1) {
            this.P.clear();
            p0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O);
            if (findPointerIndex < 0) {
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.N != 1) {
                int i3 = x3 - this.Q;
                int i4 = y3 - this.R;
                if (!e2 || Math.abs(i3) <= this.U) {
                    z2 = false;
                } else {
                    this.S = x3;
                    z2 = true;
                }
                if (f2 && Math.abs(i4) > this.U) {
                    this.T = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            j();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x4;
            this.Q = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y4;
            this.R = y4;
        } else if (actionMasked == 6) {
            X(motionEvent);
        }
        return this.N == 1;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b.i.h.f.a("RV OnLayout");
        q();
        Trace.endSection();
        this.v = true;
    }

    public void onMeasure(int i2, int i3) {
        m mVar = this.n;
        if (mVar == null) {
            o(i2, i3);
            return;
        }
        boolean z2 = false;
        if (mVar.U()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.u0(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.m != null) {
                if (this.h0.f346d == 1) {
                    r();
                }
                this.n.N0(i2, i3);
                this.h0.i = true;
                s();
                this.n.P0(i2, i3);
                if (this.n.S0()) {
                    this.n.N0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.h0.i = true;
                    s();
                    this.n.P0(i2, i3);
                }
            }
        } else if (this.t) {
            this.n.u0(i2, i3);
        } else {
            if (this.B) {
                m0();
                V();
                b0();
                W(true);
                x xVar = this.h0;
                if (xVar.k) {
                    xVar.f349g = true;
                } else {
                    this.f282e.c();
                    this.h0.f349g = false;
                }
                this.B = false;
                o0(false);
            } else if (this.h0.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            e eVar = this.m;
            if (eVar != null) {
                this.h0.f347e = eVar.getItemCount();
            } else {
                this.h0.f347e = 0;
            }
            m0();
            this.n.u0(i2, i3);
            o0(false);
            this.h0.f349g = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (P()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof v)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        v vVar = (v) parcelable;
        this.f281d = vVar;
        super.onRestoreInstanceState(vVar.f1952b);
        m mVar = this.n;
        if (mVar != null && (parcelable2 = this.f281d.f328d) != null) {
            mVar.x0(parcelable2);
        }
    }

    public Parcelable onSaveInstanceState() {
        v vVar = new v(super.onSaveInstanceState());
        v vVar2 = this.f281d;
        if (vVar2 != null) {
            vVar.f328d = vVar2.f328d;
        } else {
            m mVar = this.n;
            vVar.f328d = mVar != null ? mVar.y0() : null;
        }
        return vVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            O();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00db */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x02c0, code lost:
        if (r1 == false) goto L_0x02c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f1  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int minFlingVelocity;
        boolean z6;
        g0 g0Var;
        int i2;
        int i3;
        View b2;
        int P2;
        PointF a2;
        float f2;
        int i4;
        int i5;
        int i6;
        Object[] objArr;
        int i7 = 0;
        if (this.y || this.z) {
            return false;
        }
        p pVar = this.r;
        if (pVar == null) {
            z2 = motionEvent.getAction() == 0 ? false : D(motionEvent);
        } else {
            pVar.b(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.r = null;
            }
            z2 = true;
        }
        if (z2) {
            j();
            return true;
        }
        m mVar = this.n;
        if (mVar == null) {
            return false;
        }
        boolean e2 = mVar.e();
        boolean f3 = this.n.f();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.t0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.t0;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.O = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.S = x2;
            this.Q = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.T = y2;
            this.R = y2;
            int i8 = e2 ? 1 : 0;
            if (f3) {
                i8 |= 2;
            }
            z4 = false;
            n0(i8, 0);
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.O);
                if (findPointerIndex < 0) {
                    return false;
                }
                int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int i9 = this.S - x3;
                int i10 = this.T - y3;
                if (this.N != 1) {
                    if (e2) {
                        int i11 = this.U;
                        i9 = i9 > 0 ? Math.max(0, i9 - i11) : Math.min(0, i9 + i11);
                        if (i9 != 0) {
                            objArr = 1;
                            if (f3) {
                                int i12 = this.U;
                                i10 = i10 > 0 ? Math.max(0, i10 - i12) : Math.min(0, i10 + i12);
                                if (i10 != 0) {
                                    objArr = 1;
                                }
                            }
                            if (objArr != null) {
                                setScrollState(1);
                            }
                        }
                    }
                    objArr = null;
                    if (f3) {
                    }
                    if (objArr != null) {
                    }
                }
                if (this.N == 1) {
                    int[] iArr3 = this.u0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    if (getScrollingChildHelper().c(e2 ? i9 : 0, f3 ? i10 : 0, this.u0, this.s0, 0)) {
                        int[] iArr4 = this.u0;
                        i9 -= iArr4[0];
                        i10 -= iArr4[1];
                        int[] iArr5 = this.t0;
                        int i13 = iArr5[0];
                        int[] iArr6 = this.s0;
                        iArr5[0] = i13 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int[] iArr7 = this.s0;
                    this.S = x3 - iArr7[0];
                    this.T = y3 - iArr7[1];
                    if (h0(e2 ? i9 : 0, f3 ? i10 : 0, motionEvent)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (!(this.f0 == null || (i9 == 0 && i10 == 0))) {
                        this.f0.a(this, i9, i10);
                    }
                }
            } else if (actionMasked == 3) {
                j();
            } else if (actionMasked == 5) {
                this.O = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.S = x4;
                this.Q = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.T = y4;
                this.R = y4;
            } else if (actionMasked == 6) {
                X(motionEvent);
            }
            z4 = false;
        } else {
            this.P.addMovement(obtain);
            this.P.computeCurrentVelocity(1000, (float) this.a0);
            float f4 = e2 ? -this.P.getXVelocity(this.O) : 0.0f;
            float f5 = f3 ? -this.P.getYVelocity(this.O) : 0.0f;
            if (!(f4 == 0.0f && f5 == 0.0f)) {
                int i14 = (int) f4;
                int i15 = (int) f5;
                m mVar2 = this.n;
                if (mVar2 != null && !this.y) {
                    boolean e3 = mVar2.e();
                    boolean f6 = this.n.f();
                    if (!e3 || Math.abs(i14) < this.W) {
                        i14 = 0;
                    }
                    if (!f6 || Math.abs(i15) < this.W) {
                        i15 = 0;
                    }
                    if (!(i14 == 0 && i15 == 0)) {
                        float f7 = (float) i14;
                        float f8 = (float) i15;
                        if (!dispatchNestedPreFling(f7, f8)) {
                            boolean z7 = e3 || f6;
                            dispatchNestedFling(f7, f8, z7);
                            o oVar = this.V;
                            if (oVar != null) {
                                f0 f0Var = (f0) oVar;
                                m layoutManager = f0Var.f2337a.getLayoutManager();
                                if (!(layoutManager == null || f0Var.f2337a.getAdapter() == null || (Math.abs(i15) <= (minFlingVelocity = f0Var.f2337a.getMinFlingVelocity()) && Math.abs(i14) <= minFlingVelocity))) {
                                    boolean z8 = layoutManager instanceof w.b;
                                    if (z8) {
                                        if (!z8) {
                                            g0Var = null;
                                        } else {
                                            g0Var = new g0(f0Var, f0Var.f2337a.getContext());
                                        }
                                        if (g0Var != null) {
                                            b.r.d.u uVar = (b.r.d.u) f0Var;
                                            if (z8) {
                                                RecyclerView recyclerView = layoutManager.f298b;
                                                e adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                                                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                                                if (!(itemCount == 0 || (b2 = uVar.b(layoutManager)) == null || (P2 = layoutManager.P(b2)) == -1 || (a2 = ((w.b) layoutManager).a(itemCount - 1)) == null)) {
                                                    if (layoutManager.e()) {
                                                        i4 = uVar.e(layoutManager, uVar.g(layoutManager), i14, 0);
                                                        f2 = 0.0f;
                                                        if (a2.x < 0.0f) {
                                                            i4 = -i4;
                                                        }
                                                    } else {
                                                        f2 = 0.0f;
                                                        i4 = 0;
                                                    }
                                                    if (layoutManager.f()) {
                                                        i5 = i4;
                                                        int e4 = uVar.e(layoutManager, uVar.h(layoutManager), 0, i15);
                                                        i6 = a2.y < f2 ? -e4 : e4;
                                                    } else {
                                                        i5 = i4;
                                                        i6 = 0;
                                                    }
                                                    if (!layoutManager.f()) {
                                                        i6 = i5;
                                                    }
                                                    if (i6 != 0) {
                                                        int i16 = i6 + P2;
                                                        if (i16 < 0) {
                                                            i16 = 0;
                                                        }
                                                        if (i16 < itemCount) {
                                                            i2 = i16;
                                                        }
                                                        i3 = -1;
                                                        if (i2 != i3) {
                                                            g0Var.f329a = i2;
                                                            layoutManager.V0(g0Var);
                                                            z6 = true;
                                                            if (z6) {
                                                                z5 = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i3 = -1;
                                            i2 = -1;
                                            if (i2 != i3) {
                                            }
                                        }
                                    }
                                    z6 = false;
                                    if (z6) {
                                    }
                                }
                                z5 = false;
                            }
                            if (z7) {
                                if (f6) {
                                    boolean z9 = e3 ? 1 : 0;
                                    char c2 = e3 ? 1 : 0;
                                    e3 = z9 | true;
                                }
                                int i17 = e3 ? 1 : 0;
                                int i18 = e3 ? 1 : 0;
                                int i19 = e3 ? 1 : 0;
                                n0(i17, 1);
                                int i20 = this.a0;
                                int max = Math.max(-i20, Math.min(i14, i20));
                                int i21 = this.a0;
                                int max2 = Math.max(-i21, Math.min(i15, i21));
                                z zVar = this.e0;
                                RecyclerView.this.setScrollState(2);
                                zVar.f351c = 0;
                                zVar.f350b = 0;
                                Interpolator interpolator = zVar.f353e;
                                Interpolator interpolator2 = E0;
                                if (interpolator != interpolator2) {
                                    zVar.f353e = interpolator2;
                                    zVar.f352d = new OverScroller(RecyclerView.this.getContext(), E0);
                                }
                                zVar.f352d.fling(0, 0, max, max2, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
                                zVar.a();
                                i7 = 1;
                            }
                        }
                        i7 = 0;
                    }
                }
                if (i7 == 0) {
                    i7 = 0;
                }
                g0();
                z3 = true;
                if (!z3) {
                    this.P.addMovement(obtain);
                }
                obtain.recycle();
                return true;
            }
            setScrollState(i7);
            g0();
            z3 = true;
            if (!z3) {
            }
            obtain.recycle();
            return true;
        }
        z3 = z4;
        if (!z3) {
        }
        obtain.recycle();
        return true;
    }

    public void p(View view) {
        a0 K2 = K(view);
        U();
        e eVar = this.m;
        if (eVar != null && K2 != null) {
            eVar.onViewDetachedFromWindow(K2);
        }
    }

    public void p0(int i2) {
        getScrollingChildHelper().i(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fe, code lost:
        if (r18.f283f.k(getFocusedChild()) == false) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0398, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    public void q() {
        x xVar;
        View view;
        ArrayList<a0> arrayList;
        m mVar;
        a0 a0Var;
        View findViewById;
        View view2;
        a0 a0Var2;
        boolean z2;
        if (!(this.m == null || this.n == null)) {
            x xVar2 = this.h0;
            int i2 = 0;
            xVar2.i = false;
            boolean z3 = true;
            if (xVar2.f346d == 1) {
                r();
            } else {
                b.r.d.a aVar = this.f282e;
                if (!(!aVar.f2284c.isEmpty() && !aVar.f2283b.isEmpty()) && this.n.q == getWidth() && this.n.r == getHeight()) {
                    this.n.M0(this);
                    this.h0.a(4);
                    m0();
                    V();
                    xVar = this.h0;
                    xVar.f346d = 1;
                    view = null;
                    if (xVar.j) {
                        for (int e2 = this.f283f.e() - 1; e2 >= 0; e2--) {
                            a0 K2 = K(this.f283f.d(e2));
                            if (!K2.shouldIgnore()) {
                                long I2 = I(K2);
                                if (this.M != null) {
                                    j.c cVar = new j.c();
                                    View view3 = K2.itemView;
                                    cVar.f294a = view3.getLeft();
                                    cVar.f295b = view3.getTop();
                                    view3.getRight();
                                    view3.getBottom();
                                    a0 f2 = this.f284g.f2356b.f(I2, null);
                                    if (f2 != null && !f2.shouldIgnore()) {
                                        boolean d2 = this.f284g.d(f2);
                                        boolean d3 = this.f284g.d(K2);
                                        if (!d2 || f2 != K2) {
                                            j.c e3 = this.f284g.e(f2, 4);
                                            this.f284g.b(K2, cVar);
                                            j.c e4 = this.f284g.e(K2, 8);
                                            if (e3 == null) {
                                                int e5 = this.f283f.e();
                                                for (int i3 = 0; i3 < e5; i3++) {
                                                    a0 K3 = K(this.f283f.d(i3));
                                                    if (K3 != K2 && I(K3) == I2) {
                                                        e eVar = this.m;
                                                        if (eVar == null || !eVar.hasStableIds()) {
                                                            StringBuilder sb = new StringBuilder();
                                                            sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                                            sb.append(K3);
                                                            sb.append(" \n View Holder 2:");
                                                            sb.append(K2);
                                                            throw new IllegalStateException(c.a.a.a.a.l(this, sb));
                                                        }
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                                        sb2.append(K3);
                                                        sb2.append(" \n View Holder 2:");
                                                        sb2.append(K2);
                                                        throw new IllegalStateException(c.a.a.a.a.l(this, sb2));
                                                    }
                                                }
                                                String str = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + f2 + " cannot be found but it is necessary for " + K2 + A();
                                            } else {
                                                f2.setIsRecyclable(false);
                                                if (d2) {
                                                    f(f2);
                                                }
                                                if (f2 != K2) {
                                                    if (d3) {
                                                        f(K2);
                                                    }
                                                    f2.mShadowedHolder = K2;
                                                    f(f2);
                                                    this.f280c.k(f2);
                                                    K2.setIsRecyclable(false);
                                                    K2.mShadowingHolder = f2;
                                                }
                                                if (this.M.a(f2, K2, e3, e4)) {
                                                    a0();
                                                }
                                            }
                                        }
                                    }
                                    this.f284g.b(K2, cVar);
                                } else {
                                    throw null;
                                }
                            }
                        }
                        i0 i0Var = this.f284g;
                        i0.b bVar = this.x0;
                        for (int i4 = i0Var.f2355a.f1413d - 1; i4 >= 0; i4--) {
                            a0 h2 = i0Var.f2355a.h(i4);
                            i0.a i5 = i0Var.f2355a.i(i4);
                            int i6 = i5.f2358a;
                            if ((i6 & 3) != 3) {
                                if ((i6 & 1) != 0) {
                                    j.c cVar2 = i5.f2359b;
                                    if (cVar2 != null) {
                                        ((d) bVar).b(h2, cVar2, i5.f2360c);
                                    }
                                } else {
                                    if ((i6 & 14) != 14) {
                                        if ((i6 & 12) == 12) {
                                            j.c cVar3 = i5.f2359b;
                                            j.c cVar4 = i5.f2360c;
                                            d dVar = (d) bVar;
                                            if (dVar != null) {
                                                h2.setIsRecyclable(false);
                                                RecyclerView recyclerView = RecyclerView.this;
                                                boolean z4 = recyclerView.D;
                                                j jVar = recyclerView.M;
                                                if (!z4) {
                                                    e0 e0Var = (e0) jVar;
                                                    if (e0Var != null) {
                                                        if (cVar3.f294a == cVar4.f294a && cVar3.f295b == cVar4.f295b) {
                                                            e0Var.d(h2);
                                                            z2 = false;
                                                        } else {
                                                            z2 = e0Var.j(h2, cVar3.f294a, cVar3.f295b, cVar4.f294a, cVar4.f295b);
                                                        }
                                                        if (!z2) {
                                                        }
                                                    } else {
                                                        throw null;
                                                    }
                                                } else if (!jVar.a(h2, h2, cVar3, cVar4)) {
                                                }
                                                RecyclerView.this.a0();
                                            } else {
                                                throw null;
                                            }
                                        } else if ((i6 & 4) != 0) {
                                            ((d) bVar).b(h2, i5.f2359b, null);
                                        } else if ((i6 & 8) == 0) {
                                        }
                                    }
                                    ((d) bVar).a(h2, i5.f2359b, i5.f2360c);
                                }
                                i0.a.b(i5);
                            }
                            RecyclerView recyclerView2 = RecyclerView.this;
                            recyclerView2.n.E0(h2.itemView, recyclerView2.f280c);
                            i0.a.b(i5);
                        }
                    }
                    this.n.D0(this.f280c);
                    x xVar3 = this.h0;
                    xVar3.f344b = xVar3.f347e;
                    this.D = false;
                    this.E = false;
                    xVar3.j = false;
                    xVar3.k = false;
                    this.n.h = false;
                    arrayList = this.f280c.f321b;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    mVar = this.n;
                    if (mVar.n) {
                        mVar.m = 0;
                        mVar.n = false;
                        this.f280c.l();
                    }
                    this.n.t0(this.h0);
                    W(true);
                    o0(false);
                    i0 i0Var2 = this.f284g;
                    i0Var2.f2355a.clear();
                    i0Var2.f2356b.b();
                    int[] iArr = this.q0;
                    int i7 = iArr[0];
                    int i8 = iArr[1];
                    E(iArr);
                    int[] iArr2 = this.q0;
                    if (iArr2[0] == i7 && iArr2[1] == i8) {
                        z3 = false;
                    }
                    if (z3) {
                        v(0, 0);
                    }
                    if (this.d0 && this.m != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
                        if (!isFocused()) {
                        }
                        if (this.h0.m != -1 || !this.m.hasStableIds()) {
                            a0Var = null;
                        } else {
                            long j2 = this.h0.m;
                            e eVar2 = this.m;
                            if (eVar2 == null || !eVar2.hasStableIds()) {
                                a0Var2 = null;
                            } else {
                                int h3 = this.f283f.h();
                                int i9 = 0;
                                a0Var2 = null;
                                while (true) {
                                    if (i9 >= h3) {
                                        break;
                                    }
                                    a0Var = K(this.f283f.g(i9));
                                    if (a0Var != null && !a0Var.isRemoved() && a0Var.getItemId() == j2) {
                                        if (!this.f283f.k(a0Var.itemView)) {
                                            break;
                                        }
                                        a0Var2 = a0Var;
                                    }
                                    i9++;
                                }
                            }
                            a0Var = a0Var2;
                        }
                        if (a0Var == null && !this.f283f.k(a0Var.itemView) && a0Var.itemView.hasFocusable()) {
                            view = a0Var.itemView;
                        } else if (this.f283f.e() > 0) {
                            int i10 = this.h0.l;
                            if (i10 != -1) {
                                i2 = i10;
                            }
                            int b2 = this.h0.b();
                            int i11 = i2;
                            while (true) {
                                if (i11 >= b2) {
                                    break;
                                }
                                a0 G2 = G(i11);
                                if (G2 == null) {
                                    break;
                                } else if (G2.itemView.hasFocusable()) {
                                    view2 = G2.itemView;
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                            int min = Math.min(b2, i2) - 1;
                            while (true) {
                                if (min < 0) {
                                    break;
                                }
                                a0 G3 = G(min);
                                if (G3 == null) {
                                    break;
                                } else if (G3.itemView.hasFocusable()) {
                                    view2 = G3.itemView;
                                    break;
                                } else {
                                    min--;
                                }
                            }
                        }
                        if (view != null) {
                            int i12 = this.h0.n;
                            if (!(((long) i12) == -1 || (findViewById = view.findViewById(i12)) == null || !findViewById.isFocusable())) {
                                view = findViewById;
                            }
                            view.requestFocus();
                        }
                    }
                    x xVar4 = this.h0;
                    xVar4.m = -1;
                    xVar4.l = -1;
                    xVar4.n = -1;
                }
            }
            this.n.M0(this);
            s();
            this.h0.a(4);
            m0();
            V();
            xVar = this.h0;
            xVar.f346d = 1;
            view = null;
            if (xVar.j) {
            }
            this.n.D0(this.f280c);
            x xVar32 = this.h0;
            xVar32.f344b = xVar32.f347e;
            this.D = false;
            this.E = false;
            xVar32.j = false;
            xVar32.k = false;
            this.n.h = false;
            arrayList = this.f280c.f321b;
            if (arrayList != null) {
            }
            mVar = this.n;
            if (mVar.n) {
            }
            this.n.t0(this.h0);
            W(true);
            o0(false);
            i0 i0Var22 = this.f284g;
            i0Var22.f2355a.clear();
            i0Var22.f2356b.b();
            int[] iArr3 = this.q0;
            int i72 = iArr3[0];
            int i82 = iArr3[1];
            E(iArr3);
            int[] iArr22 = this.q0;
            z3 = false;
            if (z3) {
            }
            if (!isFocused()) {
            }
            if (this.h0.m != -1) {
            }
            a0Var = null;
            if (a0Var == null) {
            }
            if (this.f283f.e() > 0) {
            }
            if (view != null) {
            }
            x xVar42 = this.h0;
            xVar42.m = -1;
            xVar42.l = -1;
            xVar42.n = -1;
        }
    }

    public void q0() {
        w wVar;
        setScrollState(0);
        this.e0.c();
        m mVar = this.n;
        if (mVar != null && (wVar = mVar.f303g) != null) {
            wVar.d();
        }
    }

    public final void r() {
        int id;
        View C2;
        this.h0.a(1);
        B(this.h0);
        this.h0.i = false;
        m0();
        i0 i0Var = this.f284g;
        i0Var.f2355a.clear();
        i0Var.f2356b.b();
        V();
        b0();
        View focusedChild = (!this.d0 || !hasFocus() || this.m == null) ? null : getFocusedChild();
        a0 J2 = (focusedChild == null || (C2 = C(focusedChild)) == null) ? null : J(C2);
        long j2 = -1;
        if (J2 == null) {
            x xVar = this.h0;
            xVar.m = -1;
            xVar.l = -1;
            xVar.n = -1;
        } else {
            x xVar2 = this.h0;
            if (this.m.hasStableIds()) {
                j2 = J2.getItemId();
            }
            xVar2.m = j2;
            this.h0.l = this.D ? -1 : J2.isRemoved() ? J2.mOldPosition : J2.getAdapterPosition();
            x xVar3 = this.h0;
            View view = J2.itemView;
            loop0:
            while (true) {
                id = view.getId();
                while (true) {
                    if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                        xVar3.n = id;
                    } else {
                        view = ((ViewGroup) view).getFocusedChild();
                        if (view.getId() != -1) {
                        }
                    }
                }
            }
            xVar3.n = id;
        }
        x xVar4 = this.h0;
        xVar4.h = xVar4.j && this.l0;
        this.l0 = false;
        this.k0 = false;
        x xVar5 = this.h0;
        xVar5.f349g = xVar5.k;
        xVar5.f347e = this.m.getItemCount();
        E(this.q0);
        if (this.h0.j) {
            int e2 = this.f283f.e();
            for (int i2 = 0; i2 < e2; i2++) {
                a0 K2 = K(this.f283f.d(i2));
                if (!K2.shouldIgnore() && (!K2.isInvalid() || this.m.hasStableIds())) {
                    j jVar = this.M;
                    j.b(K2);
                    K2.getUnmodifiedPayloads();
                    this.f284g.c(K2, jVar.i(K2));
                    if (this.h0.h && K2.isUpdated() && !K2.isRemoved() && !K2.shouldIgnore() && !K2.isInvalid()) {
                        this.f284g.f2356b.g(I(K2), K2);
                    }
                }
            }
        }
        if (this.h0.k) {
            int h2 = this.f283f.h();
            for (int i3 = 0; i3 < h2; i3++) {
                a0 K3 = K(this.f283f.g(i3));
                if (!K3.shouldIgnore()) {
                    K3.saveOldPosition();
                }
            }
            x xVar6 = this.h0;
            boolean z2 = xVar6.f348f;
            xVar6.f348f = false;
            this.n.s0(this.f280c, xVar6);
            this.h0.f348f = z2;
            for (int i4 = 0; i4 < this.f283f.e(); i4++) {
                a0 K4 = K(this.f283f.d(i4));
                if (!K4.shouldIgnore()) {
                    i0.a orDefault = this.f284g.f2355a.getOrDefault(K4, null);
                    if (!((orDefault == null || (orDefault.f2358a & 4) == 0) ? false : true)) {
                        j.b(K4);
                        boolean hasAnyOfTheFlags = K4.hasAnyOfTheFlags(a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                        j jVar2 = this.M;
                        K4.getUnmodifiedPayloads();
                        j.c i5 = jVar2.i(K4);
                        if (hasAnyOfTheFlags) {
                            d0(K4, i5);
                        } else {
                            i0 i0Var2 = this.f284g;
                            i0.a orDefault2 = i0Var2.f2355a.getOrDefault(K4, null);
                            if (orDefault2 == null) {
                                orDefault2 = i0.a.a();
                                i0Var2.f2355a.put(K4, orDefault2);
                            }
                            orDefault2.f2358a |= 2;
                            orDefault2.f2359b = i5;
                        }
                    }
                }
            }
        }
        l();
        W(true);
        o0(false);
        this.h0.f346d = 2;
    }

    public void removeDetachedView(View view, boolean z2) {
        a0 K2 = K(view);
        if (K2 != null) {
            if (K2.isTmpDetached()) {
                K2.clearTmpDetachFlag();
            } else if (!K2.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(K2);
                throw new IllegalArgumentException(c.a.a.a.a.l(this, sb));
            }
        }
        view.clearAnimation();
        p(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.w0(this, view, view2) && view2 != null) {
            f0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.H0(this, view, rect, z2, false);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s() {
        m0();
        V();
        this.h0.a(6);
        this.f282e.c();
        this.h0.f347e = this.m.getItemCount();
        x xVar = this.h0;
        xVar.f345c = 0;
        xVar.f349g = false;
        this.n.s0(this.f280c, xVar);
        x xVar2 = this.h0;
        xVar2.f348f = false;
        this.f281d = null;
        xVar2.j = xVar2.j && this.M != null;
        this.h0.f346d = 4;
        W(true);
        o0(false);
    }

    public void scrollBy(int i2, int i3) {
        m mVar = this.n;
        if (mVar != null && !this.y) {
            boolean e2 = mVar.e();
            boolean f2 = this.n.f();
            if (e2 || f2) {
                if (!e2) {
                    i2 = 0;
                }
                if (!f2) {
                    i3 = 0;
                }
                h0(i2, i3, null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (P()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            if (contentChangeTypes != 0) {
                i2 = contentChangeTypes;
            }
            this.A |= i2;
            i2 = 1;
        }
        if (i2 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(d0 d0Var) {
        this.o0 = d0Var;
        b.i.l.m.U(this, d0Var);
    }

    public void setAdapter(e eVar) {
        setLayoutFrozen(false);
        e eVar2 = this.m;
        if (eVar2 != null) {
            eVar2.unregisterAdapterDataObserver(this.f279b);
            this.m.onDetachedFromRecyclerView(this);
        }
        e0();
        b.r.d.a aVar = this.f282e;
        aVar.l(aVar.f2283b);
        aVar.l(aVar.f2284c);
        aVar.f2288g = 0;
        e eVar3 = this.m;
        this.m = eVar;
        if (eVar != null) {
            eVar.registerAdapterDataObserver(this.f279b);
            eVar.onAttachedToRecyclerView(this);
        }
        m mVar = this.n;
        if (mVar != null) {
            mVar.b0();
        }
        s sVar = this.f280c;
        e eVar4 = this.m;
        sVar.b();
        r d2 = sVar.d();
        if (d2 != null) {
            if (eVar3 != null) {
                d2.f315b--;
            }
            if (d2.f315b == 0) {
                for (int i2 = 0; i2 < d2.f314a.size(); i2++) {
                    d2.f314a.valueAt(i2).f316a.clear();
                }
            }
            if (eVar4 != null) {
                d2.f315b++;
            }
            this.h0.f348f = true;
            c0(false);
            requestLayout();
            return;
        }
        throw null;
    }

    public void setChildDrawingOrderCallback(h hVar) {
        if (hVar != this.p0) {
            this.p0 = hVar;
            setChildrenDrawingOrderEnabled(hVar != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.h) {
            O();
        }
        this.h = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(i iVar) {
        if (iVar != null) {
            this.H = iVar;
            O();
            return;
        }
        throw null;
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(j jVar) {
        j jVar2 = this.M;
        if (jVar2 != null) {
            jVar2.g();
            this.M.f288a = null;
        }
        this.M = jVar;
        if (jVar != null) {
            jVar.f288a = this.m0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        s sVar = this.f280c;
        sVar.f324e = i2;
        sVar.l();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(m mVar) {
        if (mVar != this.n) {
            q0();
            if (this.n != null) {
                j jVar = this.M;
                if (jVar != null) {
                    jVar.g();
                }
                this.n.C0(this.f280c);
                this.n.D0(this.f280c);
                this.f280c.b();
                if (this.s) {
                    m mVar2 = this.n;
                    s sVar = this.f280c;
                    mVar2.i = false;
                    mVar2.f0(this, sVar);
                }
                this.n.Q0(null);
                this.n = null;
            } else {
                this.f280c.b();
            }
            b.r.d.f fVar = this.f283f;
            f.a aVar = fVar.f2333b;
            aVar.f2335a = 0;
            f.a aVar2 = aVar.f2336b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = fVar.f2334c.size();
            while (true) {
                size--;
                if (size >= 0) {
                    f.b bVar = fVar.f2332a;
                    View view = fVar.f2334c.get(size);
                    b0 b0Var = (b0) bVar;
                    if (b0Var != null) {
                        a0 K2 = K(view);
                        if (K2 != null) {
                            K2.onLeftHiddenState(b0Var.f2297a);
                        }
                        fVar.f2334c.remove(size);
                    } else {
                        throw null;
                    }
                } else {
                    b0 b0Var2 = (b0) fVar.f2332a;
                    int b2 = b0Var2.b();
                    for (int i2 = 0; i2 < b2; i2++) {
                        View a2 = b0Var2.a(i2);
                        b0Var2.f2297a.p(a2);
                        a2.clearAnimation();
                    }
                    b0Var2.f2297a.removeAllViews();
                    this.n = mVar;
                    if (mVar != null) {
                        if (mVar.f298b == null) {
                            mVar.Q0(this);
                            if (this.s) {
                                m mVar3 = this.n;
                                mVar3.i = true;
                                mVar3.d0();
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("LayoutManager ");
                            sb.append(mVar);
                            sb.append(" is already attached to a RecyclerView:");
                            throw new IllegalArgumentException(c.a.a.a.a.l(mVar.f298b, sb));
                        }
                    }
                    this.f280c.l();
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
        if (scrollingChildHelper.f1859d) {
            b.i.l.m.g0(scrollingChildHelper.f1858c);
        }
        scrollingChildHelper.f1859d = z2;
    }

    public void setOnFlingListener(o oVar) {
        this.V = oVar;
    }

    @Deprecated
    public void setOnScrollListener(q qVar) {
        this.i0 = qVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.d0 = z2;
    }

    public void setRecycledViewPool(r rVar) {
        s sVar = this.f280c;
        r rVar2 = sVar.f326g;
        if (rVar2 != null) {
            rVar2.f315b--;
        }
        sVar.f326g = rVar;
        if (rVar != null && RecyclerView.this.getAdapter() != null) {
            sVar.f326g.f315b++;
        }
    }

    public void setRecyclerListener(t tVar) {
        this.o = tVar;
    }

    public void setScrollState(int i2) {
        w wVar;
        if (i2 != this.N) {
            this.N = i2;
            if (i2 != 2) {
                this.e0.c();
                m mVar = this.n;
                if (!(mVar == null || (wVar = mVar.f303g) == null)) {
                    wVar.d();
                }
            }
            m mVar2 = this.n;
            if (mVar2 != null) {
                mVar2.z0(i2);
            }
            Y();
            q qVar = this.i0;
            if (qVar != null) {
                qVar.a(this, i2);
            }
            List<q> list = this.j0;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        this.j0.get(size).a(this, i2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.U = i2 != 1 ? viewConfiguration.getScaledTouchSlop() : viewConfiguration.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(y yVar) {
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().h(i2, 0);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.y) {
            i("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.y = false;
                if (!(!this.x || this.n == null || this.m == null)) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.y = true;
            this.z = true;
            q0();
        }
    }

    public boolean t(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, null, i4);
    }

    public final void u(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void v(int i2, int i3) {
        this.G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        Z();
        q qVar = this.i0;
        if (qVar != null) {
            qVar.b(this, i2, i3);
        }
        List<q> list = this.j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j0.get(size).b(this, i2, i3);
            }
        }
        this.G--;
    }

    public void w() {
        int i2;
        int i3;
        if (this.L == null) {
            EdgeEffect a2 = this.H.a(this);
            this.L = a2;
            if (this.h) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    public void x() {
        int i2;
        int i3;
        if (this.I == null) {
            EdgeEffect a2 = this.H.a(this);
            this.I = a2;
            if (this.h) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void y() {
        int i2;
        int i3;
        if (this.K == null) {
            EdgeEffect a2 = this.H.a(this);
            this.K = a2;
            if (this.h) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void z() {
        int i2;
        int i3;
        if (this.J == null) {
            EdgeEffect a2 = this.H.a(this);
            this.J = a2;
            if (this.h) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }
}
