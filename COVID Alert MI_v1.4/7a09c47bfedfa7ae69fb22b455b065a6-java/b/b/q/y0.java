package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.b.k.i;
import b.b.l.a.a;
import b.i.e.b.g;

public class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f985a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f986b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f987c;

    public y0(Context context, TypedArray typedArray) {
        this.f985a = context;
        this.f986b = typedArray;
    }

    public static y0 p(Context context, AttributeSet attributeSet, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static y0 q(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f986b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f986b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList a2;
        return (!this.f986b.hasValue(i) || (resourceId = this.f986b.getResourceId(i, 0)) == 0 || (a2 = a.a(this.f985a, resourceId)) == null) ? this.f986b.getColorStateList(i) : a2;
    }

    public float d(int i, float f2) {
        return this.f986b.getDimension(i, f2);
    }

    public int e(int i, int i2) {
        return this.f986b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f986b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f986b.hasValue(i) || (resourceId = this.f986b.getResourceId(i, 0)) == 0) ? this.f986b.getDrawable(i) : a.b(this.f985a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        Drawable g2;
        if (!this.f986b.hasValue(i) || (resourceId = this.f986b.getResourceId(i, 0)) == 0) {
            return null;
        }
        j a2 = j.a();
        Context context = this.f985a;
        synchronized (a2) {
            g2 = a2.f869a.g(context, resourceId, true);
        }
        return g2;
    }

    public Typeface i(int i, int i2, g gVar) {
        int resourceId = this.f986b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f987c == null) {
            this.f987c = new TypedValue();
        }
        Context context = this.f985a;
        TypedValue typedValue = this.f987c;
        if (context.isRestricted()) {
            return null;
        }
        return i.j.O(context, resourceId, typedValue, i2, gVar, null, true);
    }

    public int j(int i, int i2) {
        return this.f986b.getInt(i, i2);
    }

    public int k(int i, int i2) {
        return this.f986b.getLayoutDimension(i, i2);
    }

    public int l(int i, int i2) {
        return this.f986b.getResourceId(i, i2);
    }

    public String m(int i) {
        return this.f986b.getString(i);
    }

    public CharSequence n(int i) {
        return this.f986b.getText(i);
    }

    public boolean o(int i) {
        return this.f986b.hasValue(i);
    }
}
