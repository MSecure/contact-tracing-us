package f.b.a.d.c;

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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.i.i.l;
import f.b.a.c.b.o.b;
import f.b.a.d.q.i;
import f.b.a.d.q.k;
import f.b.a.d.v.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class a extends Drawable implements i.b {
    public static final int r = R$style.Widget_MaterialComponents_Badge;
    public static final int s = R$attr.badgeStyle;
    public final WeakReference<Context> b;
    public final g c = new g();

    /* renamed from: d  reason: collision with root package name */
    public final i f2572d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2573e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final float f2574f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2575g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2576h;

    /* renamed from: i  reason: collision with root package name */
    public final C0088a f2577i;

    /* renamed from: j  reason: collision with root package name */
    public float f2578j;

    /* renamed from: k  reason: collision with root package name */
    public float f2579k;

    /* renamed from: l  reason: collision with root package name */
    public int f2580l;
    public float m;
    public float n;
    public float o;
    public WeakReference<View> p;
    public WeakReference<ViewGroup> q;

    /* renamed from: f.b.a.d.c.a$a  reason: collision with other inner class name */
    public static final class C0088a implements Parcelable {
        public static final Parcelable.Creator<C0088a> CREATOR = new C0089a();
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f2581d = 255;

        /* renamed from: e  reason: collision with root package name */
        public int f2582e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2583f;

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f2584g;

        /* renamed from: h  reason: collision with root package name */
        public int f2585h;

        /* renamed from: i  reason: collision with root package name */
        public int f2586i;

        /* renamed from: j  reason: collision with root package name */
        public int f2587j;

        /* renamed from: k  reason: collision with root package name */
        public int f2588k;

        /* renamed from: l  reason: collision with root package name */
        public int f2589l;

        /* renamed from: f.b.a.d.c.a$a$a  reason: collision with other inner class name */
        public static class C0089a implements Parcelable.Creator<C0088a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0088a createFromParcel(Parcel parcel) {
                return new C0088a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0088a[] newArray(int i2) {
                return new C0088a[i2];
            }
        }

        public C0088a(Context context) {
            int i2 = R$style.TextAppearance_MaterialComponents_Badge;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
            obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList L0 = b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
            b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
            b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
            int i3 = R$styleable.TextAppearance_fontFamily;
            i3 = !obtainStyledAttributes.hasValue(i3) ? R$styleable.TextAppearance_android_fontFamily : i3;
            obtainStyledAttributes.getResourceId(i3, 0);
            obtainStyledAttributes.getString(i3);
            obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
            int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
            obtainStyledAttributes2.hasValue(i4);
            obtainStyledAttributes2.getFloat(i4, 0.0f);
            obtainStyledAttributes2.recycle();
            this.c = L0.getDefaultColor();
            this.f2584g = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.f2585h = R$plurals.mtrl_badge_content_description;
            this.f2586i = R$string.mtrl_exceed_max_badge_number_content_description;
        }

        public C0088a(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f2581d = parcel.readInt();
            this.f2582e = parcel.readInt();
            this.f2583f = parcel.readInt();
            this.f2584g = parcel.readString();
            this.f2585h = parcel.readInt();
            this.f2587j = parcel.readInt();
            this.f2588k = parcel.readInt();
            this.f2589l = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f2581d);
            parcel.writeInt(this.f2582e);
            parcel.writeInt(this.f2583f);
            parcel.writeString(this.f2584g.toString());
            parcel.writeInt(this.f2585h);
            parcel.writeInt(this.f2587j);
            parcel.writeInt(this.f2588k);
            parcel.writeInt(this.f2589l);
        }
    }

    public a(Context context) {
        f.b.a.d.s.b bVar;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.b = weakReference;
        k.c(context, k.b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.f2574f = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f2576h = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f2575g = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        i iVar = new i(this);
        this.f2572d = iVar;
        iVar.a.setTextAlign(Paint.Align.CENTER);
        this.f2577i = new C0088a(context);
        int i2 = R$style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 != null && iVar.f2701f != (bVar = new f.b.a.d.s.b(context3, i2)) && (context2 = weakReference.get()) != null) {
            iVar.b(bVar, context2);
            e();
        }
    }

    @Override // f.b.a.d.q.i.b
    public void a() {
        invalidateSelf();
    }

    public final String b() {
        if (c() <= this.f2580l) {
            return Integer.toString(c());
        }
        Context context = this.b.get();
        if (context == null) {
            return "";
        }
        return context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f2580l), "+");
    }

    public int c() {
        if (!d()) {
            return 0;
        }
        return this.f2577i.f2582e;
    }

    public boolean d() {
        return this.f2577i.f2582e != -1;
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && this.f2577i.f2581d != 0 && isVisible()) {
            this.c.draw(canvas);
            if (d()) {
                Rect rect = new Rect();
                String b2 = b();
                this.f2572d.a.getTextBounds(b2, 0, b2.length(), rect);
                canvas.drawText(b2, this.f2578j, this.f2579k + ((float) (rect.height() / 2)), this.f2572d.a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ad, code lost:
        if (r1.getLayoutDirection() == 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r1.getLayoutDirection() == 0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r1 = ((((float) r4.right) + r8.n) - ((float) r0)) - ((float) r8.f2577i.f2588k);
     */
    public final void e() {
        int i2;
        float f2;
        Context context = this.b.get();
        WeakReference<View> weakReference = this.p;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f2573e);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<ViewGroup> weakReference2 = this.q;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null) {
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            C0088a aVar = this.f2577i;
            int i3 = aVar.f2587j;
            if (i3 == 8388691 || i3 == 8388693) {
                i2 = rect2.bottom - aVar.f2589l;
            } else {
                i2 = rect2.top + aVar.f2589l;
            }
            this.f2579k = (float) i2;
            if (c() <= 9) {
                f2 = !d() ? this.f2574f : this.f2575g;
                this.m = f2;
                this.o = f2;
            } else {
                float f3 = this.f2575g;
                this.m = f3;
                this.o = f3;
                f2 = (this.f2572d.a(b()) / 2.0f) + this.f2576h;
            }
            this.n = f2;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
            int i4 = this.f2577i.f2587j;
            if (i4 == 8388659 || i4 == 8388691) {
                AtomicInteger atomicInteger = l.a;
            } else {
                AtomicInteger atomicInteger2 = l.a;
            }
            float f4 = (((float) rect2.left) - this.n) + ((float) dimensionPixelSize) + ((float) this.f2577i.f2588k);
            this.f2578j = f4;
            Rect rect3 = this.f2573e;
            float f5 = this.f2579k;
            float f6 = this.n;
            float f7 = this.o;
            rect3.set((int) (f4 - f6), (int) (f5 - f7), (int) (f4 + f6), (int) (f5 + f7));
            g gVar = this.c;
            gVar.b.a = gVar.b.a.e(this.m);
            gVar.invalidateSelf();
            if (!rect.equals(this.f2573e)) {
                this.c.setBounds(this.f2573e);
            }
        }
    }

    public int getAlpha() {
        return this.f2577i.f2581d;
    }

    public int getIntrinsicHeight() {
        return this.f2573e.height();
    }

    public int getIntrinsicWidth() {
        return this.f2573e.width();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return false;
    }

    @Override // f.b.a.d.q.i.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setAlpha(int i2) {
        this.f2577i.f2581d = i2;
        this.f2572d.a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
