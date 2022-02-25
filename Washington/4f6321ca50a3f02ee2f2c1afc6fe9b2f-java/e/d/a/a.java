package e.d.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

public class a extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1156i = {16842801};

    /* renamed from: j  reason: collision with root package name */
    public static final d f1157j = new b();
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public int f1158d;

    /* renamed from: e  reason: collision with root package name */
    public int f1159e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f1160f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f1161g;

    /* renamed from: h  reason: collision with root package name */
    public final c f1162h;

    /* renamed from: e.d.a.a$a  reason: collision with other inner class name */
    public class C0024a implements c {
        public Drawable a;

        public C0024a() {
        }

        public boolean a() {
            return a.this.getPreventCornerOverlap();
        }

        public void b(int i2, int i3, int i4, int i5) {
            a.this.f1161g.set(i2, i3, i4, i5);
            a aVar = a.this;
            Rect rect = aVar.f1160f;
            a.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        int i3;
        Resources resources;
        Rect rect = new Rect();
        this.f1160f = rect;
        this.f1161g = new Rect();
        C0024a aVar = new C0024a();
        this.f1162h = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        int i4 = R$styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1156i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = R$color.cardview_light_background;
            } else {
                resources = getResources();
                i3 = R$color.cardview_dark_background;
            }
            colorStateList = ColorStateList.valueOf(resources.getColor(i3));
        }
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.b = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.c = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1158d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f1159e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        e eVar = new e(colorStateList, dimension);
        C0024a aVar2 = aVar;
        aVar2.a = eVar;
        a.this.setBackgroundDrawable(eVar);
        a aVar3 = a.this;
        aVar3.setClipToOutline(true);
        aVar3.setElevation(dimension2);
        ((b) f1157j).b(aVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((e) ((C0024a) this.f1162h).a).f1167h;
    }

    public float getCardElevation() {
        return a.this.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1160f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1160f.left;
    }

    public int getContentPaddingRight() {
        return this.f1160f.right;
    }

    public int getContentPaddingTop() {
        return this.f1160f.top;
    }

    public float getMaxCardElevation() {
        return ((e) ((C0024a) this.f1162h).a).f1164e;
    }

    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return ((e) ((C0024a) this.f1162h).a).a;
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        c cVar = this.f1162h;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        e eVar = (e) ((C0024a) cVar).a;
        eVar.b(valueOf);
        eVar.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        a.this.setElevation(f2);
    }

    public void setMaxCardElevation(float f2) {
        ((b) f1157j).b(this.f1162h, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f1159e = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f1158d = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.c) {
            this.c = z;
            d dVar = f1157j;
            c cVar = this.f1162h;
            b bVar = (b) dVar;
            bVar.b(cVar, bVar.a(cVar).f1164e);
        }
    }

    public void setRadius(float f2) {
        e eVar = (e) ((C0024a) this.f1162h).a;
        if (f2 != eVar.a) {
            eVar.a = f2;
            eVar.c(null);
            eVar.invalidateSelf();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            d dVar = f1157j;
            c cVar = this.f1162h;
            b bVar = (b) dVar;
            bVar.b(cVar, bVar.a(cVar).f1164e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        e eVar = (e) ((C0024a) this.f1162h).a;
        eVar.b(colorStateList);
        eVar.invalidateSelf();
    }
}
