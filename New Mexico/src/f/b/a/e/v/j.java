package f.b.a.e.v;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;
import java.util.Objects;
/* loaded from: classes.dex */
public class j {
    public d a;
    public d b;
    public d c;

    /* renamed from: d */
    public d f3086d;

    /* renamed from: e */
    public c f3087e;

    /* renamed from: f */
    public c f3088f;

    /* renamed from: g */
    public c f3089g;

    /* renamed from: h */
    public c f3090h;

    /* renamed from: i */
    public f f3091i;

    /* renamed from: j */
    public f f3092j;

    /* renamed from: k */
    public f f3093k;

    /* renamed from: l */
    public f f3094l;

    public j() {
        this.a = new i();
        this.b = new i();
        this.c = new i();
        this.f3086d = new i();
        this.f3087e = new a(0.0f);
        this.f3088f = new a(0.0f);
        this.f3089g = new a(0.0f);
        this.f3090h = new a(0.0f);
        this.f3091i = new f();
        this.f3092j = new f();
        this.f3093k = new f();
        this.f3094l = new f();
    }

    public static b a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            context = new ContextThemeWrapper(context, i2);
            i2 = i3;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c c = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            c c2 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, c);
            c c3 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, c);
            c c4 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, c);
            c c5 = c(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, c);
            b bVar = new b();
            d L = f.b.a.c.b.o.b.L(i5);
            bVar.a = L;
            b.b(L);
            bVar.f3096e = c2;
            d L2 = f.b.a.c.b.o.b.L(i6);
            bVar.b = L2;
            b.b(L2);
            bVar.f3097f = c3;
            d L3 = f.b.a.c.b.o.b.L(i7);
            bVar.c = L3;
            b.b(L3);
            bVar.f3098g = c4;
            d L4 = f.b.a.c.b.o.b.L(i8);
            bVar.f3095d = L4;
            b.b(L4);
            bVar.f3099h = c5;
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
        boolean z = this.f3094l.getClass().equals(f.class) && this.f3092j.getClass().equals(f.class) && this.f3091i.getClass().equals(f.class) && this.f3093k.getClass().equals(f.class);
        float a2 = this.f3087e.a(rectF);
        return z && ((this.f3088f.a(rectF) > a2 ? 1 : (this.f3088f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f3090h.a(rectF) > a2 ? 1 : (this.f3090h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f3089g.a(rectF) > a2 ? 1 : (this.f3089g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof i) && (this.a instanceof i) && (this.c instanceof i) && (this.f3086d instanceof i));
    }

    public j e(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    /* loaded from: classes.dex */
    public static final class b {
        public d a;
        public d b;
        public d c;

        /* renamed from: d */
        public d f3095d;

        /* renamed from: e */
        public c f3096e;

        /* renamed from: f */
        public c f3097f;

        /* renamed from: g */
        public c f3098g;

        /* renamed from: h */
        public c f3099h;

        /* renamed from: i */
        public f f3100i;

        /* renamed from: j */
        public f f3101j;

        /* renamed from: k */
        public f f3102k;

        /* renamed from: l */
        public f f3103l;

        public b() {
            this.a = new i();
            this.b = new i();
            this.c = new i();
            this.f3095d = new i();
            this.f3096e = new a(0.0f);
            this.f3097f = new a(0.0f);
            this.f3098g = new a(0.0f);
            this.f3099h = new a(0.0f);
            this.f3100i = new f();
            this.f3101j = new f();
            this.f3102k = new f();
            this.f3103l = new f();
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
            this.f3096e = new a(f2);
            this.f3097f = new a(f2);
            this.f3098g = new a(f2);
            this.f3099h = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f3099h = new a(f2);
            return this;
        }

        public b e(float f2) {
            this.f3098g = new a(f2);
            return this;
        }

        public b f(float f2) {
            this.f3096e = new a(f2);
            return this;
        }

        public b g(float f2) {
            this.f3097f = new a(f2);
            return this;
        }

        public b(j jVar) {
            this.a = new i();
            this.b = new i();
            this.c = new i();
            this.f3095d = new i();
            this.f3096e = new a(0.0f);
            this.f3097f = new a(0.0f);
            this.f3098g = new a(0.0f);
            this.f3099h = new a(0.0f);
            this.f3100i = new f();
            this.f3101j = new f();
            this.f3102k = new f();
            this.f3103l = new f();
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.f3095d = jVar.f3086d;
            this.f3096e = jVar.f3087e;
            this.f3097f = jVar.f3088f;
            this.f3098g = jVar.f3089g;
            this.f3099h = jVar.f3090h;
            this.f3100i = jVar.f3091i;
            this.f3101j = jVar.f3092j;
            this.f3102k = jVar.f3093k;
            this.f3103l = jVar.f3094l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f3086d = bVar.f3095d;
        this.f3087e = bVar.f3096e;
        this.f3088f = bVar.f3097f;
        this.f3089g = bVar.f3098g;
        this.f3090h = bVar.f3099h;
        this.f3091i = bVar.f3100i;
        this.f3092j = bVar.f3101j;
        this.f3093k = bVar.f3102k;
        this.f3094l = bVar.f3103l;
    }
}
