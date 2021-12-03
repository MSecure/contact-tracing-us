package f.b.a.e.u;

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
    public d f2980d;

    /* renamed from: e  reason: collision with root package name */
    public c f2981e;

    /* renamed from: f  reason: collision with root package name */
    public c f2982f;

    /* renamed from: g  reason: collision with root package name */
    public c f2983g;

    /* renamed from: h  reason: collision with root package name */
    public c f2984h;

    /* renamed from: i  reason: collision with root package name */
    public f f2985i;

    /* renamed from: j  reason: collision with root package name */
    public f f2986j;

    /* renamed from: k  reason: collision with root package name */
    public f f2987k;

    /* renamed from: l  reason: collision with root package name */
    public f f2988l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f2980d = new i();
        this.f2981e = new a(0.0f);
        this.f2982f = new a(0.0f);
        this.f2983g = new a(0.0f);
        this.f2984h = new a(0.0f);
        this.f2985i = new f();
        this.f2986j = new f();
        this.f2987k = new f();
        this.f2988l = new f();
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
            bVar.f2990e = c3;
            d K2 = f.b.a.c.b.o.b.K(i6);
            bVar.b = K2;
            b.b(K2);
            bVar.f2991f = c4;
            d K3 = f.b.a.c.b.o.b.K(i7);
            bVar.c = K3;
            b.b(K3);
            bVar.f2992g = c5;
            d K4 = f.b.a.c.b.o.b.K(i8);
            bVar.f2989d = K4;
            b.b(K4);
            bVar.f2993h = c6;
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
        boolean z = this.f2988l.getClass().equals(f.class) && this.f2986j.getClass().equals(f.class) && this.f2985i.getClass().equals(f.class) && this.f2987k.getClass().equals(f.class);
        float a2 = this.f2981e.a(rectF);
        return z && ((this.f2982f.a(rectF) > a2 ? 1 : (this.f2982f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2984h.a(rectF) > a2 ? 1 : (this.f2984h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2983g.a(rectF) > a2 ? 1 : (this.f2983g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f2980d instanceof i));
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
        public d f2989d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f2990e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f2991f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f2992g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f2993h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f2994i = new f();

        /* renamed from: j  reason: collision with root package name */
        public f f2995j = new f();

        /* renamed from: k  reason: collision with root package name */
        public f f2996k = new f();

        /* renamed from: l  reason: collision with root package name */
        public f f2997l = new f();

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
            this.f2990e = new a(f2);
            this.f2991f = new a(f2);
            this.f2992g = new a(f2);
            this.f2993h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f2993h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f2992g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f2990e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f2991f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f2989d = jVar.f2980d;
            this.f2990e = jVar.f2981e;
            this.f2991f = jVar.f2982f;
            this.f2992g = jVar.f2983g;
            this.f2993h = jVar.f2984h;
            this.f2994i = jVar.f2985i;
            this.f2995j = jVar.f2986j;
            this.f2996k = jVar.f2987k;
            this.f2997l = jVar.f2988l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f2980d = bVar.f2989d;
        this.f2981e = bVar.f2990e;
        this.f2982f = bVar.f2991f;
        this.f2983g = bVar.f2992g;
        this.f2984h = bVar.f2993h;
        this.f2985i = bVar.f2994i;
        this.f2986j = bVar.f2995j;
        this.f2987k = bVar.f2996k;
        this.f2988l = bVar.f2997l;
    }
}
