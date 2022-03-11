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
    public d f2883d;

    /* renamed from: e  reason: collision with root package name */
    public c f2884e;

    /* renamed from: f  reason: collision with root package name */
    public c f2885f;

    /* renamed from: g  reason: collision with root package name */
    public c f2886g;

    /* renamed from: h  reason: collision with root package name */
    public c f2887h;

    /* renamed from: i  reason: collision with root package name */
    public f f2888i;

    /* renamed from: j  reason: collision with root package name */
    public f f2889j;

    /* renamed from: k  reason: collision with root package name */
    public f f2890k;

    /* renamed from: l  reason: collision with root package name */
    public f f2891l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f2883d = new i();
        this.f2884e = new a(0.0f);
        this.f2885f = new a(0.0f);
        this.f2886g = new a(0.0f);
        this.f2887h = new a(0.0f);
        this.f2888i = new f();
        this.f2889j = new f();
        this.f2890k = new f();
        this.f2891l = new f();
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
            bVar.f2893e = c3;
            d Q2 = f.b.a.c.b.o.b.Q(i6);
            bVar.b = Q2;
            b.b(Q2);
            bVar.f2894f = c4;
            d Q3 = f.b.a.c.b.o.b.Q(i7);
            bVar.c = Q3;
            b.b(Q3);
            bVar.f2895g = c5;
            d Q4 = f.b.a.c.b.o.b.Q(i8);
            bVar.f2892d = Q4;
            b.b(Q4);
            bVar.f2896h = c6;
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
        boolean z = this.f2891l.getClass().equals(f.class) && this.f2889j.getClass().equals(f.class) && this.f2888i.getClass().equals(f.class) && this.f2890k.getClass().equals(f.class);
        float a2 = this.f2884e.a(rectF);
        return z && ((this.f2885f.a(rectF) > a2 ? 1 : (this.f2885f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2887h.a(rectF) > a2 ? 1 : (this.f2887h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f2886g.a(rectF) > a2 ? 1 : (this.f2886g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f2883d instanceof i));
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
        public d f2892d = new i();

        /* renamed from: e  reason: collision with root package name */
        public c f2893e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f2894f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f2895g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f2896h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f2897i = new f();

        /* renamed from: j  reason: collision with root package name */
        public f f2898j = new f();

        /* renamed from: k  reason: collision with root package name */
        public f f2899k = new f();

        /* renamed from: l  reason: collision with root package name */
        public f f2900l = new f();

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
            this.f2893e = new a(f2);
            this.f2894f = new a(f2);
            this.f2895g = new a(f2);
            this.f2896h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f2896h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f2895g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f2893e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f2894f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f2892d = jVar.f2883d;
            this.f2893e = jVar.f2884e;
            this.f2894f = jVar.f2885f;
            this.f2895g = jVar.f2886g;
            this.f2896h = jVar.f2887h;
            this.f2897i = jVar.f2888i;
            this.f2898j = jVar.f2889j;
            this.f2899k = jVar.f2890k;
            this.f2900l = jVar.f2891l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f2883d = bVar.f2892d;
        this.f2884e = bVar.f2893e;
        this.f2885f = bVar.f2894f;
        this.f2886g = bVar.f2895g;
        this.f2887h = bVar.f2896h;
        this.f2888i = bVar.f2897i;
        this.f2889j = bVar.f2898j;
        this.f2890k = bVar.f2899k;
        this.f2891l = bVar.f2900l;
    }
}
