package c.b.a.b.h0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import c.b.a.a.c.n.c;
import c.b.a.b.l;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public d f2994a;

    /* renamed from: b  reason: collision with root package name */
    public d f2995b;

    /* renamed from: c  reason: collision with root package name */
    public d f2996c;

    /* renamed from: d  reason: collision with root package name */
    public d f2997d;

    /* renamed from: e  reason: collision with root package name */
    public c f2998e;
    public c f;
    public c g;
    public c h;
    public f i;
    public f j;
    public f k;
    public f l;

    public j() {
        this.f2994a = new i();
        this.f2995b = new i();
        this.f2996c = new i();
        this.f2997d = new i();
        this.f2998e = new a(0.0f);
        this.f = new a(0.0f);
        this.g = new a(0.0f);
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
            d G = c.G(i5);
            bVar.f2999a = G;
            float b2 = b.b(G);
            if (b2 != -1.0f) {
                bVar.f(b2);
            }
            bVar.f3003e = c3;
            d G2 = c.G(i6);
            bVar.f3000b = G2;
            float b3 = b.b(G2);
            if (b3 != -1.0f) {
                bVar.g(b3);
            }
            bVar.f = c4;
            d G3 = c.G(i7);
            bVar.f3001c = G3;
            float b4 = b.b(G3);
            if (b4 != -1.0f) {
                bVar.e(b4);
            }
            bVar.g = c5;
            d G4 = c.G(i8);
            bVar.f3002d = G4;
            float b5 = b.b(G4);
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
        float a2 = this.f2998e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f2995b instanceof i) && (this.f2994a instanceof i) && (this.f2996c instanceof i) && (this.f2997d instanceof i));
    }

    public j e(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public d f2999a = new i();

        /* renamed from: b  reason: collision with root package name */
        public d f3000b = new i();

        /* renamed from: c  reason: collision with root package name */
        public d f3001c = new i();

        /* renamed from: d  reason: collision with root package name */
        public d f3002d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f3003e = new a(0.0f);
        public c f = new a(0.0f);
        public c g = new a(0.0f);
        public c h = new a(0.0f);
        public f i = new f();
        public f j = new f();
        public f k = new f();
        public f l = new f();

        public b() {
        }

        public static float b(d dVar) {
            if (dVar instanceof i) {
                return ((i) dVar).f2993a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f2981a;
            }
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b c(float f2) {
            this.f3003e = new a(f2);
            this.f = new a(f2);
            this.g = new a(f2);
            this.h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f3003e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.f2999a = jVar.f2994a;
            this.f3000b = jVar.f2995b;
            this.f3001c = jVar.f2996c;
            this.f3002d = jVar.f2997d;
            this.f3003e = jVar.f2998e;
            this.f = jVar.f;
            this.g = jVar.g;
            this.h = jVar.h;
            this.i = jVar.i;
            this.j = jVar.j;
            this.k = jVar.k;
            this.l = jVar.l;
        }
    }

    public j(b bVar, a aVar) {
        this.f2994a = bVar.f2999a;
        this.f2995b = bVar.f3000b;
        this.f2996c = bVar.f3001c;
        this.f2997d = bVar.f3002d;
        this.f2998e = bVar.f3003e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
