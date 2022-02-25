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
    public d f2779d;

    /* renamed from: e  reason: collision with root package name */
    public c f2780e;

    /* renamed from: f  reason: collision with root package name */
    public c f2781f;

    /* renamed from: g  reason: collision with root package name */
    public c f2782g;

    /* renamed from: h  reason: collision with root package name */
    public c f2783h;

    /* renamed from: i  reason: collision with root package name */
    public f f2784i;

    /* renamed from: j  reason: collision with root package name */
    public f f2785j;

    /* renamed from: k  reason: collision with root package name */
    public f f2786k;

    /* renamed from: l  reason: collision with root package name */
    public f f2787l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f2779d = new i();
        this.f2780e = new a(0.0f);
        this.f2781f = new a(0.0f);
        this.f2782g = new a(0.0f);
        this.f2783h = new a(0.0f);
        this.f2784i = new f();
        this.f2785j = new f();
        this.f2786k = new f();
        this.f2787l = new f();
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
            bVar.f2789e = c3;
            d Q2 = f.b.a.c.b.o.b.Q(i6);
            bVar.b = Q2;
            b.b(Q2);
            bVar.f2790f = c4;
            d Q3 = f.b.a.c.b.o.b.Q(i7);
            bVar.c = Q3;
            b.b(Q3);
            bVar.f2791g = c5;
            d Q4 = f.b.a.c.b.o.b.Q(i8);
            bVar.f2788d = Q4;
            b.b(Q4);
            bVar.f2792h = c6;
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
        boolean z = this.f2787l.getClass().equals(f.class) && this.f2785j.getClass().equals(f.class) && this.f2784i.getClass().equals(f.class) && this.f2786k.getClass().equals(f.class);
        float a2 = this.f2780e.a(rectF);
        return z && ((this.f2781f.a(rectF) > a2 ? 1 : (this.f2781f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2783h.a(rectF) > a2 ? 1 : (this.f2783h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2782g.a(rectF) > a2 ? 1 : (this.f2782g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f2779d instanceof i));
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
        public d f2788d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f2789e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f2790f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f2791g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f2792h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f2793i = new f();

        /* renamed from: j  reason: collision with root package name */
        public f f2794j = new f();

        /* renamed from: k  reason: collision with root package name */
        public f f2795k = new f();

        /* renamed from: l  reason: collision with root package name */
        public f f2796l = new f();

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
            this.f2789e = new a(f2);
            this.f2790f = new a(f2);
            this.f2791g = new a(f2);
            this.f2792h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f2792h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f2791g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f2789e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f2790f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f2788d = jVar.f2779d;
            this.f2789e = jVar.f2780e;
            this.f2790f = jVar.f2781f;
            this.f2791g = jVar.f2782g;
            this.f2792h = jVar.f2783h;
            this.f2793i = jVar.f2784i;
            this.f2794j = jVar.f2785j;
            this.f2795k = jVar.f2786k;
            this.f2796l = jVar.f2787l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f2779d = bVar.f2788d;
        this.f2780e = bVar.f2789e;
        this.f2781f = bVar.f2790f;
        this.f2782g = bVar.f2791g;
        this.f2783h = bVar.f2792h;
        this.f2784i = bVar.f2793i;
        this.f2785j = bVar.f2794j;
        this.f2786k = bVar.f2795k;
        this.f2787l = bVar.f2796l;
    }
}
