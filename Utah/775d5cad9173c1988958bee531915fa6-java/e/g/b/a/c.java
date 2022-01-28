package e.g.b.a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import e.b.a.m;
import e.g.b.a.d;
import e.g.c.c;
import e.i.i.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class c extends ConstraintLayout implements l {
    public static final /* synthetic */ int W = 0;
    public long A;
    public float B;
    public float C;
    public float D;
    public long E;
    public float F;
    public AbstractC0029c G;
    public int H;
    public a I;
    public long J;
    public boolean K;
    public ArrayList<b> L;
    public ArrayList<b> M;
    public CopyOnWriteArrayList<AbstractC0029c> N;
    public int O;
    public float P;
    public float Q;
    public boolean R;
    public b S;
    public boolean T;
    public d U;
    public boolean V;
    public float v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.S.a();
        }
    }

    public class b {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f1368d = -1;

        public b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            if (r5 == null) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a4, code lost:
            if (r5 == null) goto L_0x00b4;
         */
        public void a() {
            e.g.c.d dVar;
            int i2;
            d dVar2 = d.SETUP;
            int i3 = this.c;
            if (!(i3 == -1 && this.f1368d == -1)) {
                if (i3 == -1) {
                    c.this.w(this.f1368d);
                } else {
                    int i4 = this.f1368d;
                    if (i4 == -1) {
                        c cVar = c.this;
                        cVar.setState(dVar2);
                        cVar.x = i3;
                        cVar.w = -1;
                        cVar.y = -1;
                        e.g.c.c cVar2 = cVar.f119l;
                        if (cVar2 != null) {
                            float f2 = (float) -1;
                            int i5 = cVar2.b;
                            if (i5 == i3) {
                                c.a valueAt = i3 == -1 ? cVar2.f1391d.valueAt(0) : cVar2.f1391d.get(i5);
                                int i6 = cVar2.c;
                                if ((i6 == -1 || !valueAt.b.get(i6).a(f2, f2)) && cVar2.c != (i2 = valueAt.a(f2, f2))) {
                                    dVar = i2 == -1 ? null : valueAt.b.get(i2).f1396f;
                                    if (i2 != -1) {
                                        int i7 = valueAt.b.get(i2).f1395e;
                                    }
                                }
                            } else {
                                cVar2.b = i3;
                                c.a aVar = cVar2.f1391d.get(i3);
                                i2 = aVar.a(f2, f2);
                                dVar = i2 == -1 ? aVar.f1393d : aVar.b.get(i2).f1396f;
                                if (i2 != -1) {
                                    int i8 = aVar.b.get(i2).f1395e;
                                }
                            }
                            cVar2.c = i2;
                            dVar.a(cVar2.a);
                        }
                    } else {
                        c.this.v(i3, i4);
                    }
                }
                c.this.setState(dVar2);
            }
            if (!Float.isNaN(this.b)) {
                c cVar3 = c.this;
                float f3 = this.a;
                float f4 = this.b;
                if (!cVar3.isAttachedToWindow()) {
                    if (cVar3.S == null) {
                        cVar3.S = new b();
                    }
                    b bVar = cVar3.S;
                    bVar.a = f3;
                    bVar.b = f4;
                } else {
                    cVar3.setProgress(f3);
                    cVar3.setState(d.MOVING);
                    cVar3.v = f4;
                }
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.f1368d = -1;
            } else if (!Float.isNaN(this.a)) {
                c.this.setProgress(this.a);
            }
        }
    }

    /* renamed from: e.g.b.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0029c {
        void a(c cVar, int i2, int i3);

        void b(c cVar, int i2, int i3, float f2);
    }

    public enum d {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void dispatchDraw(Canvas canvas) {
        s(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.x;
    }

    public ArrayList<d.a> getDefinedTransitions() {
        return null;
    }

    public a getDesignTool() {
        if (this.I == null) {
            this.I = new a(this);
        }
        return this.I;
    }

    public int getEndState() {
        return this.y;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.D;
    }

    public int getStartState() {
        return this.w;
    }

    public float getTargetPosition() {
        return this.F;
    }

    public Bundle getTransitionState() {
        if (this.S == null) {
            this.S = new b();
        }
        b bVar = this.S;
        c cVar = c.this;
        bVar.f1368d = cVar.y;
        bVar.c = cVar.w;
        bVar.b = cVar.getVelocity();
        bVar.a = c.this.getProgress();
        b bVar2 = this.S;
        Objects.requireNonNull(bVar2);
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", bVar2.a);
        bundle.putFloat("motion.velocity", bVar2.b);
        bundle.putInt("motion.StartState", bVar2.c);
        bundle.putInt("motion.EndState", bVar2.f1368d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        return (long) (this.B * 1000.0f);
    }

    public float getVelocity() {
        return this.v;
    }

    @Override // e.i.i.k
    public void h(View view, View view2, int i2, int i3) {
        this.J = getNanoTime();
    }

    @Override // e.i.i.k
    public void i(View view, int i2) {
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // e.i.i.k
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void k(int i2) {
        this.f119l = null;
    }

    @Override // e.i.i.l
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i2 != 0 || i3 != 0) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
    }

    @Override // e.i.i.k
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // e.i.i.k
    public boolean o(View view, View view2, int i2, int i3) {
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        b bVar = this.S;
        if (bVar == null) {
            return;
        }
        if (this.T) {
            post(new a());
        } else {
            bVar.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.R = true;
        try {
            super.onLayout(z2, i2, i3, i4, i5);
        } finally {
            this.R = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onRtlPropertiesChanged(int i2) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof b) {
            b bVar = (b) view;
            if (this.N == null) {
                this.N = new CopyOnWriteArrayList<>();
            }
            this.N.add(bVar);
            if (bVar.f1365j) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                this.L.add(bVar);
            }
            if (bVar.f1366k) {
                if (this.M == null) {
                    this.M = new ArrayList<>();
                }
                this.M.add(bVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<b> arrayList = this.L;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<b> arrayList2 = this.M;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void requestLayout() {
        int i2 = this.x;
        super.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0110, code lost:
        if (r1 != r2) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x011b, code lost:
        if (r1 != r2) goto L_0x011f;
     */
    public void s(boolean z2) {
        int i2;
        int i3;
        int i4;
        d dVar = d.FINISHED;
        if (this.E == -1) {
            this.E = getNanoTime();
        }
        float f2 = this.D;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.x = -1;
        }
        boolean z3 = true;
        boolean z4 = false;
        if (this.K) {
            float signum = Math.signum(this.F - f2);
            long nanoTime = getNanoTime();
            float f3 = ((((float) (nanoTime - this.E)) * signum) * 1.0E-9f) / this.B;
            float f4 = this.D + f3;
            int i5 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i5 > 0 && f4 >= this.F) || (signum <= 0.0f && f4 <= this.F)) {
                f4 = this.F;
            }
            this.D = f4;
            this.C = f4;
            this.E = nanoTime;
            this.v = f3;
            if (Math.abs(f3) > 1.0E-5f) {
                setState(d.MOVING);
            }
            if ((i5 > 0 && f4 >= this.F) || (signum <= 0.0f && f4 <= this.F)) {
                f4 = this.F;
            }
            int i6 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
            if (i6 >= 0 || f4 <= 0.0f) {
                setState(dVar);
            }
            int childCount = getChildCount();
            this.K = false;
            getNanoTime();
            this.Q = f4;
            if (childCount <= 0) {
                boolean z5 = (i5 > 0 && f4 >= this.F) || (signum <= 0.0f && f4 <= this.F);
                if (!this.K && z5) {
                    setState(dVar);
                }
                boolean z6 = (!z5) | this.K;
                this.K = z6;
                if (f4 <= 0.0f && (i4 = this.w) != -1 && this.x != i4) {
                    this.x = i4;
                    throw null;
                } else if (((double) f4) < 1.0d || this.x == (i3 = this.y)) {
                    if (z6) {
                        invalidate();
                    } else if ((i5 > 0 && i6 == 0) || (signum < 0.0f && f4 == 0.0f)) {
                        setState(dVar);
                    }
                    if (!this.K && (i5 <= 0 || i6 != 0)) {
                        int i7 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
                    }
                } else {
                    this.x = i3;
                    throw null;
                }
            } else {
                getChildAt(0);
                throw null;
            }
        }
        float f5 = this.D;
        if (f5 >= 1.0f) {
            int i8 = this.x;
            i2 = this.y;
        } else {
            if (f5 <= 0.0f) {
                int i9 = this.x;
                i2 = this.w;
            }
            this.V |= z4;
            if (z4 && !this.R) {
                requestLayout();
            }
            this.C = this.D;
        }
        z3 = false;
        this.x = i2;
        z4 = z3;
        this.V |= z4;
        requestLayout();
        this.C = this.D;
    }

    public void setDebugMode(int i2) {
        this.H = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z2) {
        this.T = z2;
    }

    public void setInteractionEnabled(boolean z2) {
        this.z = z2;
    }

    public void setInterpolatedProgress(float f2) {
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<b> arrayList = this.M;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.M.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<b> arrayList = this.L;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.L.get(i2).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        d dVar = d.FINISHED;
        d dVar2 = d.MOVING;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (!isAttachedToWindow()) {
            if (this.S == null) {
                this.S = new b();
            }
            this.S.a = f2;
            return;
        }
        if (i2 <= 0) {
            if (this.D == 1.0f && this.x == this.y) {
                setState(dVar2);
            }
            this.x = this.w;
            if (this.D != 0.0f) {
                return;
            }
        } else if (f2 >= 1.0f) {
            if (this.D == 0.0f && this.x == this.w) {
                setState(dVar2);
            }
            this.x = this.y;
            if (this.D != 1.0f) {
                return;
            }
        } else {
            this.x = -1;
            setState(dVar2);
            return;
        }
        setState(dVar);
    }

    public void setScene(d dVar) {
        g();
        throw null;
    }

    public void setStartState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.S == null) {
                this.S = new b();
            }
            b bVar = this.S;
            bVar.c = i2;
            bVar.f1368d = i2;
            return;
        }
        this.x = i2;
    }

    public void setState(d dVar) {
        d dVar2 = d.FINISHED;
        if (dVar != dVar2 || this.x != -1) {
            d dVar3 = this.U;
            this.U = dVar;
            d dVar4 = d.MOVING;
            if (dVar3 == dVar4 && dVar == dVar4) {
                t();
            }
            int ordinal = dVar3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (dVar == dVar4) {
                    t();
                }
                if (dVar != dVar2) {
                    return;
                }
            } else if (!(ordinal == 2 && dVar == dVar2)) {
                return;
            }
            u();
        }
    }

    public void setTransition(int i2) {
    }

    public void setTransition(d.a aVar) {
        throw null;
    }

    public void setTransitionDuration(int i2) {
    }

    public void setTransitionListener(AbstractC0029c cVar) {
        this.G = cVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.S == null) {
            this.S = new b();
        }
        b bVar = this.S;
        Objects.requireNonNull(bVar);
        bVar.a = bundle.getFloat("motion.progress");
        bVar.b = bundle.getFloat("motion.velocity");
        bVar.c = bundle.getInt("motion.StartState");
        bVar.f1368d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.S.a();
        }
    }

    public final void t() {
        CopyOnWriteArrayList<AbstractC0029c> copyOnWriteArrayList;
        if ((this.G != null || ((copyOnWriteArrayList = this.N) != null && !copyOnWriteArrayList.isEmpty())) && this.P != this.C) {
            if (this.O != -1) {
                AbstractC0029c cVar = this.G;
                if (cVar != null) {
                    cVar.a(this, this.w, this.y);
                }
                CopyOnWriteArrayList<AbstractC0029c> copyOnWriteArrayList2 = this.N;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<AbstractC0029c> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().a(this, this.w, this.y);
                    }
                }
            }
            this.O = -1;
            float f2 = this.C;
            this.P = f2;
            AbstractC0029c cVar2 = this.G;
            if (cVar2 != null) {
                cVar2.b(this, this.w, this.y, f2);
            }
            CopyOnWriteArrayList<AbstractC0029c> copyOnWriteArrayList3 = this.N;
            if (copyOnWriteArrayList3 != null) {
                Iterator<AbstractC0029c> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this, this.w, this.y, this.C);
                }
            }
        }
    }

    public String toString() {
        Context context = getContext();
        return m.e.q0(context, this.w) + "->" + m.e.q0(context, this.y) + " (pos:" + this.D + " Dpos/Dt:" + this.v;
    }

    public void u() {
        CopyOnWriteArrayList<AbstractC0029c> copyOnWriteArrayList;
        CopyOnWriteArrayList<AbstractC0029c> copyOnWriteArrayList2;
        if ((this.G != null || ((copyOnWriteArrayList2 = this.N) != null && !copyOnWriteArrayList2.isEmpty())) && this.O == -1) {
            this.O = this.x;
            throw null;
        } else if (this.G != null || ((copyOnWriteArrayList = this.N) != null && !copyOnWriteArrayList.isEmpty())) {
            throw null;
        }
    }

    public void v(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.S == null) {
                this.S = new b();
            }
            b bVar = this.S;
            bVar.c = i2;
            bVar.f1368d = i3;
        }
    }

    public void w(int i2) {
        if (!isAttachedToWindow()) {
            if (this.S == null) {
                this.S = new b();
            }
            this.S.f1368d = i2;
            return;
        }
        int i3 = this.x;
        if (i3 != i2 && this.w != i2 && this.y != i2) {
            this.y = i2;
            if (i3 != -1) {
                v(i3, i2);
                this.D = 0.0f;
                return;
            }
            this.F = 1.0f;
            this.C = 0.0f;
            this.D = 0.0f;
            this.E = getNanoTime();
            this.A = getNanoTime();
            throw null;
        }
    }
}
