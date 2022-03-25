package f.b.a.d.r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import e.l.a.a;
import e.l.a.d;
import e.l.a.e;
import f.b.a.c.b.o.b;
import f.b.a.d.r.c;

public final class i<S extends c> extends l {
    public static final e.l.a.c<i> r = new a("indicatorLevel");
    public m<S> m;
    public final e n;
    public final d o;
    public float p;
    public boolean q = false;

    public static class a extends e.l.a.c<i> {
        public a(String str) {
            super(str);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(i iVar) {
            return iVar.p * 10000.0f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(i iVar, float f2) {
            i iVar2 = iVar;
            iVar2.p = f2 / 10000.0f;
            iVar2.invalidateSelf();
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
        if (this.f2836i != 1.0f) {
            this.f2836i = 1.0f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.m.e(canvas, c());
            this.m.b(canvas, this.f2837j);
            this.m.a(canvas, this.f2837j, 0.0f, this.p, b.M(this.c.c[0], this.f2838k));
            canvas.restore();
        }
    }

    public int getIntrinsicHeight() {
        return this.m.c();
    }

    public int getIntrinsicWidth() {
        return this.m.d();
    }

    @Override // f.b.a.d.r.l
    public boolean i(boolean z, boolean z2, boolean z3) {
        boolean i2 = super.i(z, z2, z3);
        float a2 = this.f2831d.a(this.b.getContentResolver());
        if (a2 == 0.0f) {
            this.q = true;
        } else {
            this.q = false;
            this.n.a(50.0f / a2);
        }
        return i2;
    }

    public void jumpToCurrentState() {
        this.o.b();
        this.p = ((float) getLevel()) / 10000.0f;
        invalidateSelf();
    }

    public boolean onLevelChange(int i2) {
        if (this.q) {
            this.o.b();
            this.p = ((float) i2) / 10000.0f;
            invalidateSelf();
        } else {
            d dVar = this.o;
            dVar.b = this.p * 10000.0f;
            dVar.c = true;
            float f2 = (float) i2;
            if (dVar.f1562f) {
                dVar.s = f2;
            } else {
                if (dVar.r == null) {
                    dVar.r = new e(f2);
                }
                e eVar = dVar.r;
                double d2 = (double) f2;
                eVar.f1573i = d2;
                double d3 = (double) ((float) d2);
                if (d3 > ((double) Float.MAX_VALUE)) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                } else if (d3 >= ((double) dVar.f1563g)) {
                    double abs = Math.abs((double) (dVar.f1565i * 0.75f));
                    eVar.f1568d = abs;
                    eVar.f1569e = abs * 62.5d;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        boolean z = dVar.f1562f;
                        if (!z && !z) {
                            dVar.f1562f = true;
                            if (!dVar.c) {
                                dVar.b = dVar.f1561e.a(dVar.f1560d);
                            }
                            float f3 = dVar.b;
                            if (f3 > Float.MAX_VALUE || f3 < dVar.f1563g) {
                                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                            }
                            e.l.a.a a2 = e.l.a.a.a();
                            if (a2.b.size() == 0) {
                                if (a2.f1556d == null) {
                                    a2.f1556d = new a.d(a2.c);
                                }
                                a.d dVar2 = (a.d) a2.f1556d;
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
