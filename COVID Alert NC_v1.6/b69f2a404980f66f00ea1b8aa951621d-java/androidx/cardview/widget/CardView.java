package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import b.d.d;
import b.d.e.b;
import b.d.e.c;

public class CardView extends FrameLayout {
    public static final int[] i = {16842801};
    public static final c j = new b.d.e.a();

    /* renamed from: b  reason: collision with root package name */
    public boolean f103b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f104c;

    /* renamed from: d  reason: collision with root package name */
    public int f105d;

    /* renamed from: e  reason: collision with root package name */
    public int f106e;
    public final Rect f;
    public final Rect g;
    public final b h;

    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f107a;

        public a() {
        }

        public boolean a() {
            return CardView.this.getPreventCornerOverlap();
        }

        public void b(int i, int i2, int i3, int i4) {
            CardView.this.g.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.d.a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        Resources resources;
        int i3;
        this.f = new Rect();
        this.g = new Rect();
        this.h = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i2, b.d.c.CardView);
        if (obtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = b.d.b.cardview_light_background;
            } else {
                resources = getResources();
                i3 = b.d.b.cardview_dark_background;
            }
            colorStateList = ColorStateList.valueOf(resources.getColor(i3));
        }
        float dimension = obtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.f103b = obtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.f104c = obtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        this.f.left = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f.top = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        this.f.right = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        this.f.bottom = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f105d = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.f106e = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        c cVar = j;
        b bVar = this.h;
        b.d.e.d dVar = new b.d.e.d(colorStateList, dimension);
        a aVar = (a) bVar;
        aVar.f107a = dVar;
        CardView.this.setBackgroundDrawable(dVar);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        ((b.d.e.a) cVar).d(bVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((b.d.e.a) j).a(this.h).h;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f.left;
    }

    public int getContentPaddingRight() {
        return this.f.right;
    }

    public int getContentPaddingTop() {
        return this.f.top;
    }

    public float getMaxCardElevation() {
        return ((b.d.e.a) j).b(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f104c;
    }

    public float getRadius() {
        return ((b.d.e.a) j).c(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.f103b;
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        c cVar = j;
        b bVar = this.h;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        b.d.e.d a2 = ((b.d.e.a) cVar).a(bVar);
        a2.b(valueOf);
        a2.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        CardView.this.setElevation(f2);
    }

    public void setMaxCardElevation(float f2) {
        ((b.d.e.a) j).d(this.h, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f106e = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f105d = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f104c) {
            this.f104c = z;
            c cVar = j;
            b bVar = this.h;
            b.d.e.a aVar = (b.d.e.a) cVar;
            aVar.d(bVar, aVar.a(bVar).f792e);
        }
    }

    public void setRadius(float f2) {
        b.d.e.d a2 = ((b.d.e.a) j).a(this.h);
        if (f2 != a2.f788a) {
            a2.f788a = f2;
            a2.c(null);
            a2.invalidateSelf();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f103b != z) {
            this.f103b = z;
            c cVar = j;
            b bVar = this.h;
            b.d.e.a aVar = (b.d.e.a) cVar;
            aVar.d(bVar, aVar.a(bVar).f792e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        b.d.e.d a2 = ((b.d.e.a) j).a(this.h);
        a2.b(colorStateList);
        a2.invalidateSelf();
    }
}
