package f.b.a.e.v;

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
    public d f3044d;

    /* renamed from: e  reason: collision with root package name */
    public c f3045e;

    /* renamed from: f  reason: collision with root package name */
    public c f3046f;

    /* renamed from: g  reason: collision with root package name */
    public c f3047g;

    /* renamed from: h  reason: collision with root package name */
    public c f3048h;

    /* renamed from: i  reason: collision with root package name */
    public f f3049i;

    /* renamed from: j  reason: collision with root package name */
    public f f3050j;

    /* renamed from: k  reason: collision with root package name */
    public f f3051k;

    /* renamed from: l  reason: collision with root package name */
    public f f3052l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f3044d = new i();
        this.f3045e = new a(0.0f);
        this.f3046f = new a(0.0f);
        this.f3047g = new a(0.0f);
        this.f3048h = new a(0.0f);
        this.f3049i = new f();
        this.f3050j = new f();
        this.f3051k = new f();
        this.f3052l = new f();
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
            d K = f.b.a.c.b.o.b.K(i5);
            bVar.a = K;
            b.b(K);
            bVar.f3054e = c3;
            d K2 = f.b.a.c.b.o.b.K(i6);
            bVar.b = K2;
            b.b(K2);
            bVar.f3055f = c4;
            d K3 = f.b.a.c.b.o.b.K(i7);
            bVar.c = K3;
            b.b(K3);
            bVar.f3056g = c5;
            d K4 = f.b.a.c.b.o.b.K(i8);
            bVar.f3053d = K4;
            b.b(K4);
            bVar.f3057h = c6;
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
        boolean z = this.f3052l.getClass().equals(f.class) && this.f3050j.getClass().equals(f.class) && this.f3049i.getClass().equals(f.class) && this.f3051k.getClass().equals(f.class);
        float a2 = this.f3045e.a(rectF);
        return z && ((this.f3046f.a(rectF) > a2 ? 1 : (this.f3046f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f3048h.a(rectF) > a2 ? 1 : (this.f3048h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f3047g.a(rectF) > a2 ? 1 : (this.f3047g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f3044d instanceof i));
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
        public d f3053d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f3054e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f3055f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f3056g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f3057h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f3058i = new f();

        /* renamed from: j  reason: collision with root package name */
        public f f3059j = new f();

        /* renamed from: k  reason: collision with root package name */
        public f f3060k = new f();

        /* renamed from: l  reason: collision with root package name */
        public f f3061l = new f();

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
            this.f3054e = new a(f2);
            this.f3055f = new a(f2);
            this.f3056g = new a(f2);
            this.f3057h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f3057h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f3056g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f3054e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f3055f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f3053d = jVar.f3044d;
            this.f3054e = jVar.f3045e;
            this.f3055f = jVar.f3046f;
            this.f3056g = jVar.f3047g;
            this.f3057h = jVar.f3048h;
            this.f3058i = jVar.f3049i;
            this.f3059j = jVar.f3050j;
            this.f3060k = jVar.f3051k;
            this.f3061l = jVar.f3052l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f3044d = bVar.f3053d;
        this.f3045e = bVar.f3054e;
        this.f3046f = bVar.f3055f;
        this.f3047g = bVar.f3056g;
        this.f3048h = bVar.f3057h;
        this.f3049i = bVar.f3058i;
        this.f3050j = bVar.f3059j;
        this.f3051k = bVar.f3060k;
        this.f3052l = bVar.f3061l;
    }
}
