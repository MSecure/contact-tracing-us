package f.b.a.d.v;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;
import java.util.Objects;

public class j {
    public d a;
    public d b;
    public d c;

    /* renamed from: d  reason: collision with root package name */
    public d f2787d;

    /* renamed from: e  reason: collision with root package name */
    public c f2788e;

    /* renamed from: f  reason: collision with root package name */
    public c f2789f;

    /* renamed from: g  reason: collision with root package name */
    public c f2790g;

    /* renamed from: h  reason: collision with root package name */
    public c f2791h;

    /* renamed from: i  reason: collision with root package name */
    public f f2792i;

    /* renamed from: j  reason: collision with root package name */
    public f f2793j;

    /* renamed from: k  reason: collision with root package name */
    public f f2794k;

    /* renamed from: l  reason: collision with root package name */
    public f f2795l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f2787d = new i();
        this.f2788e = new a(0.0f);
        this.f2789f = new a(0.0f);
        this.f2790g = new a(0.0f);
        this.f2791h = new a(0.0f);
        this.f2792i = new f();
        this.f2793j = new f();
        this.f2794k = new f();
        this.f2795l = new f();
    }

    public static b a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c c2 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            c c3 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, c2);
            c c4 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, c2);
            c c5 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, c2);
            c c6 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, c2);
            b bVar = new b();
            d Q = f.b.a.c.b.o.b.Q(i5);
            bVar.a = Q;
            b.b(Q);
            bVar.f2797e = c3;
            d Q2 = f.b.a.c.b.o.b.Q(i6);
            bVar.b = Q2;
            b.b(Q2);
            bVar.f2798f = c4;
            d Q3 = f.b.a.c.b.o.b.Q(i7);
            bVar.c = Q3;
            b.b(Q3);
            bVar.f2799g = c5;
            d Q4 = f.b.a.c.b.o.b.Q(i8);
            bVar.f2796d = Q4;
            b.b(Q4);
            bVar.f2800h = c6;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
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
        boolean z = this.f2795l.getClass().equals(f.class) && this.f2793j.getClass().equals(f.class) && this.f2792i.getClass().equals(f.class) && this.f2794k.getClass().equals(f.class);
        float a2 = this.f2788e.a(rectF);
        return z && ((this.f2789f.a(rectF) > a2 ? 1 : (this.f2789f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2791h.a(rectF) > a2 ? 1 : (this.f2791h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2790g.a(rectF) > a2 ? 1 : (this.f2790g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f2787d instanceof i));
    }

    public j e(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    public static final class b {
        public d a = new i();
        public d b = new i();
        public d c = new i();

        /* renamed from: d  reason: collision with root package name */
        public d f2796d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f2797e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f2798f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f2799g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f2800h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f2801i = new f();

        /* renamed from: j  reason: collision with root package name */
        public f f2802j = new f();

        /* renamed from: k  reason: collision with root package name */
        public f f2803k = new f();

        /* renamed from: l  reason: collision with root package name */
        public f f2804l = new f();

        public b() {
        }

        public static float b(d dVar) {
            Object obj;
            if (dVar instanceof i) {
                obj = (i) dVar;
            } else if (!(dVar instanceof e)) {
                return -1.0f;
            } else {
                obj = (e) dVar;
            }
            Objects.requireNonNull(obj);
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b c(float f2) {
            this.f2797e = new a(f2);
            this.f2798f = new a(f2);
            this.f2799g = new a(f2);
            this.f2800h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f2800h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f2799g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f2797e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f2798f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f2796d = jVar.f2787d;
            this.f2797e = jVar.f2788e;
            this.f2798f = jVar.f2789f;
            this.f2799g = jVar.f2790g;
            this.f2800h = jVar.f2791h;
            this.f2801i = jVar.f2792i;
            this.f2802j = jVar.f2793j;
            this.f2803k = jVar.f2794k;
            this.f2804l = jVar.f2795l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f2787d = bVar.f2796d;
        this.f2788e = bVar.f2797e;
        this.f2789f = bVar.f2798f;
        this.f2790g = bVar.f2799g;
        this.f2791h = bVar.f2800h;
        this.f2792i = bVar.f2801i;
        this.f2793j = bVar.f2802j;
        this.f2794k = bVar.f2803k;
        this.f2795l = bVar.f2804l;
    }
}
