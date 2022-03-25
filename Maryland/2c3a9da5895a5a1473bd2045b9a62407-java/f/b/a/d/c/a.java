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
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.i.i.m;
import f.b.a.c.b.o.b;
import f.b.a.d.q.i;
import f.b.a.d.q.k;
import f.b.a.d.v.g;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class a extends Drawable implements i.b {
    public static final int r = R$style.Widget_MaterialComponents_Badge;
    public static final int s = R$attr.badgeStyle;
    public final WeakReference<Context> b;
    public final g c = new g();

    /* renamed from: d  reason: collision with root package name */
    public final i f2672d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2673e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final float f2674f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2675g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2676h;

    /* renamed from: i  reason: collision with root package name */
    public final C0091a f2677i;

    /* renamed from: j  reason: collision with root package name */
    public float f2678j;

    /* renamed from: k  reason: collision with root package name */
    public float f2679k;

    /* renamed from: l  reason: collision with root package name */
    public int f2680l;
    public float m;
    public float n;
    public float o;
    public WeakReference<View> p;
    public WeakReference<FrameLayout> q;

    /* renamed from: f.b.a.d.c.a$a  reason: collision with other inner class name */
    public static final class C0091a implements Parcelable {
        public static final Parcelable.Creator<C0091a> CREATOR = new C0092a();
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f2681d = 255;

        /* renamed from: e  reason: collision with root package name */
        public int f2682e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2683f;

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f2684g;

        /* renamed from: h  reason: collision with root package name */
        public int f2685h;

        /* renamed from: i  reason: collision with root package name */
        public int f2686i;

        /* renamed from: j  reason: collision with root package name */
        public int f2687j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f2688k;

        /* renamed from: l  reason: collision with root package name */
        public int f2689l;
        public int m;

        /* renamed from: f.b.a.d.c.a$a$a  reason: collision with other inner class name */
        public static class C0092a implements Parcelable.Creator<C0091a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0091a createFromParcel(Parcel parcel) {
                return new C0091a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public C0091a[] newArray(int i2) {
                return new C0091a[i2];
            }
        }

        public C0091a(Context context) {
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
            this.f2684g = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.f2685h = R$plurals.mtrl_badge_content_description;
            this.f2686i = R$string.mtrl_exceed_max_badge_number_content_description;
            this.f2688k = true;
        }

        public C0091a(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f2681d = parcel.readInt();
            this.f2682e = parcel.readInt();
            this.f2683f = parcel.readInt();
            this.f2684g = parcel.readString();
            this.f2685h = parcel.readInt();
            this.f2687j = parcel.readInt();
            this.f2689l = parcel.readInt();
            this.m = parcel.readInt();
            this.f2688k = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f2681d);
            parcel.writeInt(this.f2682e);
            parcel.writeInt(this.f2683f);
            parcel.writeString(this.f2684g.toString());
            parcel.writeInt(this.f2685h);
            parcel.writeInt(this.f2687j);
            parcel.writeInt(this.f2689l);
            parcel.writeInt(this.m);
            parcel.writeInt(this.f2688k ? 1 : 0);
        }
    }

    public a(Context context) {
        f.b.a.d.s.b bVar;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.b = weakReference;
        k.c(context, k.b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.f2674f = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f2676h = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f2675g = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        i iVar = new i(this);
        this.f2672d = iVar;
        iVar.a.setTextAlign(Paint.Align.CENTER);
        this.f2677i = new C0091a(context);
        int i2 = R$style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 != null && iVar.f2801f != (bVar = new f.b.a.d.s.b(context3, i2)) && (context2 = weakReference.get()) != null) {
            iVar.b(bVar, context2);
            g();
        }
    }

    @Override // f.b.a.d.q.i.b
    public void a() {
        invalidateSelf();
    }

    public final String b() {
        if (d() <= this.f2680l) {
            return NumberFormat.getInstance().format((long) d());
        }
        Context context = this.b.get();
        if (context == null) {
            return "";
        }
        return context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f2680l), "+");
    }

    public FrameLayout c() {
        WeakReference<FrameLayout> weakReference = this.q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int d() {
        if (!e()) {
            return 0;
        }
        return this.f2677i.f2682e;
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && this.f2677i.f2681d != 0 && isVisible()) {
            this.c.draw(canvas);
            if (e()) {
                Rect rect = new Rect();
                String b2 = b();
                this.f2672d.a.getTextBounds(b2, 0, b2.length(), rect);
                canvas.drawText(b2, this.f2678j, this.f2679k + ((float) (rect.height() / 2)), this.f2672d.a);
            }
        }
    }

    public boolean e() {
        return this.f2677i.f2682e != -1;
    }

    public void f(View view, FrameLayout frameLayout) {
        this.p = new WeakReference<>(view);
        this.q = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        g();
        invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ad, code lost:
        if (r1.getLayoutDirection() == 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r1.getLayoutDirection() == 0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r1 = ((((float) r4.right) + r8.n) - ((float) r0)) - ((float) r8.f2677i.f2689l);
     */
    public final void g() {
        int i2;
        float f2;
        Context context = this.b.get();
        WeakReference<View> weakReference = this.p;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f2673e);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.q;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null) {
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            C0091a aVar = this.f2677i;
            int i3 = aVar.f2687j;
            if (i3 == 8388691 || i3 == 8388693) {
                i2 = rect2.bottom - aVar.m;
            } else {
                i2 = rect2.top + aVar.m;
            }
            this.f2679k = (float) i2;
            if (d() <= 9) {
                f2 = !e() ? this.f2674f : this.f2675g;
                this.m = f2;
                this.o = f2;
            } else {
                float f3 = this.f2675g;
                this.m = f3;
                this.o = f3;
                f2 = (this.f2672d.a(b()) / 2.0f) + this.f2676h;
            }
            this.n = f2;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(e() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
            int i4 = this.f2677i.f2687j;
            if (i4 == 8388659 || i4 == 8388691) {
                AtomicInteger atomicInteger = m.a;
            } else {
                AtomicInteger atomicInteger2 = m.a;
            }
            float f4 = (((float) rect2.left) - this.n) + ((float) dimensionPixelSize) + ((float) this.f2677i.f2689l);
            this.f2678j = f4;
            Rect rect3 = this.f2673e;
            float f5 = this.f2679k;
            float f6 = this.n;
            float f7 = this.o;
            rect3.set((int) (f4 - f6), (int) (f5 - f7), (int) (f4 + f6), (int) (f5 + f7));
            g gVar = this.c;
            gVar.b.a = gVar.b.a.e(this.m);
            gVar.invalidateSelf();
            if (!rect.equals(this.f2673e)) {
                this.c.setBounds(this.f2673e);
            }
        }
    }

    public int getAlpha() {
        return this.f2677i.f2681d;
    }

    public int getIntrinsicHeight() {
        return this.f2673e.height();
    }

    public int getIntrinsicWidth() {
        return this.f2673e.width();
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
        this.f2677i.f2681d = i2;
        this.f2672d.a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
