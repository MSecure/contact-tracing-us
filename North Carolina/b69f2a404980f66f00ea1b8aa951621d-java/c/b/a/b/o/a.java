package c.b.a.b.o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.c0.h;
import c.b.a.b.d;
import c.b.a.b.h0.g;
import c.b.a.b.i;
import c.b.a.b.j;
import c.b.a.b.k;
import c.b.a.b.l;
import java.lang.ref.WeakReference;

public class a extends Drawable implements h.b {
    public static final int r = k.Widget_MaterialComponents_Badge;
    public static final int s = b.badgeStyle;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f3167b;

    /* renamed from: c  reason: collision with root package name */
    public final g f3168c = new g();

    /* renamed from: d  reason: collision with root package name */
    public final h f3169d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f3170e = new Rect();
    public final float f;
    public final float g;
    public final float h;
    public final C0068a i;
    public float j;
    public float k;
    public int l;
    public float m;
    public float n;
    public float o;
    public WeakReference<View> p;
    public WeakReference<ViewGroup> q;

    /* renamed from: c.b.a.b.o.a$a  reason: collision with other inner class name */
    public static final class C0068a implements Parcelable {
        public static final Parcelable.Creator<C0068a> CREATOR = new C0069a();

        /* renamed from: b  reason: collision with root package name */
        public int f3171b;

        /* renamed from: c  reason: collision with root package name */
        public int f3172c;

        /* renamed from: d  reason: collision with root package name */
        public int f3173d = 255;

        /* renamed from: e  reason: collision with root package name */
        public int f3174e = -1;
        public int f;
        public CharSequence g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;

        /* renamed from: c.b.a.b.o.a$a$a  reason: collision with other inner class name */
        public static class C0069a implements Parcelable.Creator<C0068a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0068a createFromParcel(Parcel parcel) {
                return new C0068a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0068a[] newArray(int i) {
                return new C0068a[i];
            }
        }

        public C0068a(Context context) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(k.TextAppearance_MaterialComponents_Badge, l.TextAppearance);
            obtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f);
            ColorStateList Z0 = c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColor);
            c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColorHint);
            c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
            int i2 = l.TextAppearance_fontFamily;
            i2 = !obtainStyledAttributes.hasValue(i2) ? l.TextAppearance_android_fontFamily : i2;
            obtainStyledAttributes.getResourceId(i2, 0);
            obtainStyledAttributes.getString(i2);
            obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
            c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            this.f3172c = Z0.getDefaultColor();
            this.g = context.getString(j.mtrl_badge_numberless_content_description);
            this.h = i.mtrl_badge_content_description;
            this.i = j.mtrl_exceed_max_badge_number_content_description;
        }

        public C0068a(Parcel parcel) {
            this.f3171b = parcel.readInt();
            this.f3172c = parcel.readInt();
            this.f3173d = parcel.readInt();
            this.f3174e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readString();
            this.h = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3171b);
            parcel.writeInt(this.f3172c);
            parcel.writeInt(this.f3173d);
            parcel.writeInt(this.f3174e);
            parcel.writeInt(this.f);
            parcel.writeString(this.g.toString());
            parcel.writeInt(this.h);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
        }
    }

    public a(Context context) {
        c.b.a.b.e0.b bVar;
        Context context2;
        this.f3167b = new WeakReference<>(context);
        c.b.a.b.c0.i.c(context, c.b.a.b.c0.i.f2952b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.f = (float) resources.getDimensionPixelSize(d.mtrl_badge_radius);
        this.h = (float) resources.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding);
        this.g = (float) resources.getDimensionPixelSize(d.mtrl_badge_with_text_radius);
        h hVar = new h(this);
        this.f3169d = hVar;
        hVar.f2945a.setTextAlign(Paint.Align.CENTER);
        this.i = new C0068a(context);
        int i2 = k.TextAppearance_MaterialComponents_Badge;
        Context context3 = this.f3167b.get();
        if (context3 != null && this.f3169d.f != (bVar = new c.b.a.b.e0.b(context3, i2)) && (context2 = this.f3167b.get()) != null) {
            this.f3169d.b(bVar, context2);
            e();
        }
    }

    @Override // c.b.a.b.c0.h.b
    public void a() {
        invalidateSelf();
    }

    public final String b() {
        if (c() <= this.l) {
            return Integer.toString(c());
        }
        Context context = this.f3167b.get();
        if (context == null) {
            return "";
        }
        return context.getString(j.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.l), "+");
    }

    public int c() {
        if (!d()) {
            return 0;
        }
        return this.i.f3174e;
    }

    public boolean d() {
        return this.i.f3174e != -1;
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && this.i.f3173d != 0 && isVisible()) {
            this.f3168c.draw(canvas);
            if (d()) {
                Rect rect = new Rect();
                String b2 = b();
                this.f3169d.f2945a.getTextBounds(b2, 0, b2.length(), rect);
                canvas.drawText(b2, this.j, this.k + ((float) (rect.height() / 2)), this.f3169d.f2945a);
            }
        }
    }

    public final void e() {
        float f2;
        float f3;
        float f4;
        Context context = this.f3167b.get();
        WeakReference<View> weakReference = this.p;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f3170e);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<ViewGroup> weakReference2 = this.q;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null) {
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            C0068a aVar = this.i;
            int i2 = aVar.j;
            if (i2 == 8388691 || i2 == 8388693) {
                f2 = (float) (rect2.bottom - this.i.l);
            } else {
                f2 = (float) (rect2.top + aVar.l);
            }
            this.k = f2;
            if (c() <= 9) {
                f3 = !d() ? this.f : this.g;
                this.m = f3;
                this.o = f3;
            } else {
                float f5 = this.g;
                this.m = f5;
                this.o = f5;
                f3 = (this.f3169d.a(b()) / 2.0f) + this.h;
            }
            this.n = f3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d() ? d.mtrl_badge_text_horizontal_edge_offset : d.mtrl_badge_horizontal_edge_offset);
            int i3 = this.i.j;
            if (i3 == 8388659 || i3 == 8388691 ? m.o(view) != 0 : m.o(view) == 0) {
                f4 = ((((float) rect2.right) + this.n) - ((float) dimensionPixelSize)) - ((float) this.i.k);
            } else {
                f4 = (((float) rect2.left) - this.n) + ((float) dimensionPixelSize) + ((float) this.i.k);
            }
            this.j = f4;
            Rect rect3 = this.f3170e;
            float f6 = this.k;
            float f7 = this.n;
            float f8 = this.o;
            rect3.set((int) (f4 - f7), (int) (f6 - f8), (int) (f4 + f7), (int) (f6 + f8));
            g gVar = this.f3168c;
            gVar.f2982b.f2987a = gVar.f2982b.f2987a.e(this.m);
            gVar.invalidateSelf();
            if (!rect.equals(this.f3170e)) {
                this.f3168c.setBounds(this.f3170e);
            }
        }
    }

    public int getAlpha() {
        return this.i.f3173d;
    }

    public int getIntrinsicHeight() {
        return this.f3170e.height();
    }

    public int getIntrinsicWidth() {
        return this.f3170e.width();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return false;
    }

    @Override // c.b.a.b.c0.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setAlpha(int i2) {
        this.i.f3173d = i2;
        this.f3169d.f2945a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
