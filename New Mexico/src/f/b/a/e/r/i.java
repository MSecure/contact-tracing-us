package f.b.a.e.r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import e.m.a.a;
import e.m.a.d;
import e.m.a.e;
import f.b.a.c.b.o.b;
import f.b.a.e.r.c;
/* loaded from: classes.dex */
public final class i<S extends c> extends l {
    public static final e.m.a.c<i> r = new a("indicatorLevel");
    public m<S> m;
    public final e n;
    public final d o;
    public float p;
    public boolean q = false;

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public static class a extends e.m.a.c<i> {
        public a(String str) {
            super(str);
        }

        @Override // e.m.a.c
        public float a(i iVar) {
            return iVar.p * 10000.0f;
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            i iVar = (i) obj;
            iVar.p = f2 / 10000.0f;
            iVar.invalidateSelf();
        }
    }

    public i(Context context, c cVar, m<S> mVar) {
        super(context, cVar);
        this.m = mVar;
        mVar.b = this;
        e eVar = new e();
        this.n = eVar;
        eVar.b = (double) 1.0f;
        eVar.c = false;
        eVar.a(50.0f);
        d dVar = new d(this, r);
        this.o = dVar;
        dVar.r = eVar;
        if (this.f3047i != 1.0f) {
            this.f3047i = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.m.e(canvas, c());
            this.m.b(canvas, this.f3048j);
            this.m.a(canvas, this.f3048j, 0.0f, this.p, b.I(this.c.c[0], this.f3049k));
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m.d();
    }

    @Override // f.b.a.e.r.l
    public boolean i(boolean z, boolean z2, boolean z3) {
        boolean i2 = super.i(z, z2, z3);
        float a2 = this.f3042d.a(this.b.getContentResolver());
        if (a2 == 0.0f) {
            this.q = true;
        } else {
            this.q = false;
            this.n.a(50.0f / a2);
        }
        return i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.o.d();
        this.p = ((float) getLevel()) / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        if (this.q) {
            this.o.d();
            this.p = ((float) i2) / 10000.0f;
            invalidateSelf();
        } else {
            d dVar = this.o;
            dVar.b = this.p * 10000.0f;
            dVar.c = true;
            float f2 = (float) i2;
            if (dVar.f1703f) {
                dVar.s = f2;
            } else {
                if (dVar.r == null) {
                    dVar.r = new e(f2);
                }
                e eVar = dVar.r;
                double d2 = (double) f2;
                eVar.f1714i = d2;
                double d3 = (double) ((float) d2);
                if (d3 > ((double) Float.MAX_VALUE)) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                } else if (d3 >= ((double) dVar.f1704g)) {
                    double abs = Math.abs((double) (dVar.f1706i * 0.75f));
                    eVar.f1709d = abs;
                    eVar.f1710e = abs * 62.5d;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        boolean z = dVar.f1703f;
                        if (!z && !z) {
                            dVar.f1703f = true;
                            if (!dVar.c) {
                                dVar.b = dVar.f1702e.a(dVar.f1701d);
                            }
                            float f3 = dVar.b;
                            if (f3 > Float.MAX_VALUE || f3 < dVar.f1704g) {
                                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                            }
                            e.m.a.a a2 = e.m.a.a.a();
                            if (a2.b.size() == 0) {
                                if (a2.f1697d == null) {
                                    a2.f1697d = new a.d(a2.c);
                                }
                                a.d dVar2 = (a.d) a2.f1697d;
                                dVar2.b.postFrameCallback(dVar2.c);
                            }
                            if (!a2.b.contains(dVar)) {
                                a2.b.add(dVar);
                            }
                        }
                    } else {
                        throw new AndroidRuntimeException("Animations may only be started on the main thread");
                    }
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
        }
        return true;
    }
}
