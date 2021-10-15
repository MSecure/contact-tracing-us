package c.b.a.b.h0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import b.x.t;
import c.b.a.b.l;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public d f4277a;

    /* renamed from: b  reason: collision with root package name */
    public d f4278b;

    /* renamed from: c  reason: collision with root package name */
    public d f4279c;

    /* renamed from: d  reason: collision with root package name */
    public d f4280d;

    /* renamed from: e  reason: collision with root package name */
    public c f4281e;

    /* renamed from: f  reason: collision with root package name */
    public c f4282f;

    /* renamed from: g  reason: collision with root package name */
    public c f4283g;
    public c h;
    public f i;
    public f j;
    public f k;
    public f l;

    public j() {
        this.f4277a = new i();
        this.f4278b = new i();
        this.f4279c = new i();
        this.f4280d = new i();
        this.f4281e = new a(0.0f);
        this.f4282f = new a(0.0f);
        this.f4283g = new a(0.0f);
        this.h = new a(0.0f);
        this.i = new f();
        this.j = new f();
        this.k = new f();
        this.l = new f();
    }

    public static b a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c c2 = c(obtainStyledAttributes, l.ShapeAppearance_cornerSize, cVar);
            c c3 = c(obtainStyledAttributes, l.ShapeAppearance_cornerSizeTopLeft, c2);
            c c4 = c(obtainStyledAttributes, l.ShapeAppearance_cornerSizeTopRight, c2);
            c c5 = c(obtainStyledAttributes, l.ShapeAppearance_cornerSizeBottomRight, c2);
            c c6 = c(obtainStyledAttributes, l.ShapeAppearance_cornerSizeBottomLeft, c2);
            b bVar = new b();
            d U = t.U(i5);
            bVar.f4284a = U;
            float b2 = b.b(U);
            if (b2 != -1.0f) {
                bVar.f(b2);
            }
            bVar.f4288e = c3;
            d U2 = t.U(i6);
            bVar.f4285b = U2;
            float b3 = b.b(U2);
            if (b3 != -1.0f) {
                bVar.g(b3);
            }
            bVar.f4289f = c4;
            d U3 = t.U(i7);
            bVar.f4286c = U3;
            float b4 = b.b(U3);
            if (b4 != -1.0f) {
                bVar.e(b4);
            }
            bVar.f4290g = c5;
            d U4 = t.U(i8);
            bVar.f4287d = U4;
            float b5 = b.b(U4);
            if (b5 != -1.0f) {
                bVar.d(b5);
            }
            bVar.h = c6;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i2, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        int i3 = peekValue.type;
        return i3 == 5 ? new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i3 == 6 ? new h(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public boolean d(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.f4281e.a(rectF);
        return z && ((this.f4282f.a(rectF) > a2 ? 1 : (this.f4282f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f4283g.a(rectF) > a2 ? 1 : (this.f4283g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f4278b instanceof i) && (this.f4277a instanceof i) && (this.f4279c instanceof i) && (this.f4280d instanceof i));
    }

    public j e(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public d f4284a = new i();

        /* renamed from: b  reason: collision with root package name */
        public d f4285b = new i();

        /* renamed from: c  reason: collision with root package name */
        public d f4286c = new i();

        /* renamed from: d  reason: collision with root package name */
        public d f4287d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f4288e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f4289f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f4290g = new a(0.0f);
        public c h = new a(0.0f);
        public f i = new f();
        public f j = new f();
        public f k = new f();
        public f l = new f();

        public b() {
        }

        public static float b(d dVar) {
            if (dVar instanceof i) {
                return ((i) dVar).f4276a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f4260a;
            }
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b c(float f2) {
            this.f4288e = new a(f2);
            this.f4289f = new a(f2);
            this.f4290g = new a(f2);
            this.h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f4290g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f4288e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f4289f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.f4284a = jVar.f4277a;
            this.f4285b = jVar.f4278b;
            this.f4286c = jVar.f4279c;
            this.f4287d = jVar.f4280d;
            this.f4288e = jVar.f4281e;
            this.f4289f = jVar.f4282f;
            this.f4290g = jVar.f4283g;
            this.h = jVar.h;
            this.i = jVar.i;
            this.j = jVar.j;
            this.k = jVar.k;
            this.l = jVar.l;
        }
    }

    public j(b bVar, a aVar) {
        this.f4277a = bVar.f4284a;
        this.f4278b = bVar.f4285b;
        this.f4279c = bVar.f4286c;
        this.f4280d = bVar.f4287d;
        this.f4281e = bVar.f4288e;
        this.f4282f = bVar.f4289f;
        this.f4283g = bVar.f4290g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
