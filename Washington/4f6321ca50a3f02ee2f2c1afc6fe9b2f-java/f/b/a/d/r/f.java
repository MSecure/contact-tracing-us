package f.b.a.d.r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import e.l.a.a;
import e.l.a.c;
import e.l.a.d;
import e.l.a.e;

public final class f extends i {
    public static final c<f> t = new a("indicatorLevel");
    public final j o;
    public final e p;
    public final d q;
    public float r;
    public boolean s = false;

    public static class a extends c<f> {
        public a(String str) {
            super(str);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(f fVar) {
            return fVar.r * 10000.0f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(f fVar, float f2) {
            f fVar2 = fVar;
            fVar2.r = f2 / 10000.0f;
            fVar2.invalidateSelf();
        }
    }

    public f(Context context, s sVar) {
        super(context, sVar);
        this.o = sVar.a == 0 ? new m() : new b();
        e eVar = new e();
        this.p = eVar;
        eVar.b = (double) 1.0f;
        eVar.c = false;
        eVar.a(50.0f);
        d dVar = new d(this, t);
        this.q = dVar;
        dVar.r = eVar;
        e(1.0f);
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.o.c(canvas, this.c, this.f2717i);
            s sVar = this.c;
            float f2 = this.f2717i;
            float f3 = ((float) sVar.b) * f2;
            float f4 = f2 * ((float) sVar.c);
            this.o.d(canvas, this.f2720l, sVar.f2737e, 0.0f, 1.0f, f3, f4);
            this.o.d(canvas, this.f2720l, this.f2719k[0], 0.0f, this.r, f3, f4);
            canvas.restore();
        }
    }

    @Override // f.b.a.d.r.i
    public boolean f(boolean z, boolean z2, boolean z3) {
        boolean f2 = super.f(z, z2, z3);
        float a2 = this.f2712d.a(this.b.getContentResolver());
        if (a2 == 0.0f) {
            this.s = true;
        } else {
            this.s = false;
            this.p.a(50.0f / a2);
        }
        return f2;
    }

    public int getIntrinsicHeight() {
        return this.o.b(this.c);
    }

    public int getIntrinsicWidth() {
        return this.o.a(this.c);
    }

    public void jumpToCurrentState() {
        this.q.b();
        this.r = ((float) getLevel()) / 10000.0f;
        invalidateSelf();
    }

    public boolean onLevelChange(int i2) {
        if (this.s) {
            this.q.b();
            this.r = ((float) i2) / 10000.0f;
            invalidateSelf();
        } else {
            d dVar = this.q;
            dVar.b = this.r * 10000.0f;
            dVar.c = true;
            float f2 = (float) i2;
            if (dVar.f1548f) {
                dVar.s = f2;
            } else {
                if (dVar.r == null) {
                    dVar.r = new e(f2);
                }
                e eVar = dVar.r;
                double d2 = (double) f2;
                eVar.f1559i = d2;
                double d3 = (double) ((float) d2);
                if (d3 > ((double) Float.MAX_VALUE)) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                } else if (d3 >= ((double) dVar.f1549g)) {
                    double abs = Math.abs((double) (dVar.f1551i * 0.75f));
                    eVar.f1554d = abs;
                    eVar.f1555e = abs * 62.5d;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        boolean z = dVar.f1548f;
                        if (!z && !z) {
                            dVar.f1548f = true;
                            if (!dVar.c) {
                                dVar.b = dVar.f1547e.a(dVar.f1546d);
                            }
                            float f3 = dVar.b;
                            if (f3 > Float.MAX_VALUE || f3 < dVar.f1549g) {
                                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                            }
                            e.l.a.a a2 = e.l.a.a.a();
                            if (a2.b.size() == 0) {
                                if (a2.f1542d == null) {
                                    a2.f1542d = new a.d(a2.c);
                                }
                                a.d dVar2 = (a.d) a2.f1542d;
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
