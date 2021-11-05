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
    public final Context f758a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f759b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f760c;

    public y0(Context context, TypedArray typedArray) {
        this.f758a = context;
        this.f759b = typedArray;
    }

    public static y0 p(Context context, AttributeSet attributeSet, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static y0 q(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f759b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f759b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList a2;
        return (!this.f759b.hasValue(i) || (resourceId = this.f759b.getResourceId(i, 0)) == 0 || (a2 = a.a(this.f758a, resourceId)) == null) ? this.f759b.getColorStateList(i) : a2;
    }

    public float d(int i, float f) {
        return this.f759b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f759b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f759b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f759b.hasValue(i) || (resourceId = this.f759b.getResourceId(i, 0)) == 0) ? this.f759b.getDrawable(i) : a.b(this.f758a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        Drawable g;
        if (!this.f759b.hasValue(i) || (resourceId = this.f759b.getResourceId(i, 0)) == 0) {
            return null;
        }
        j a2 = j.a();
        Context context = this.f758a;
        synchronized (a2) {
            g = a2.f661a.g(context, resourceId, true);
        }
        return g;
    }

    public Typeface i(int i, int i2, g gVar) {
        int resourceId = this.f759b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f760c == null) {
            this.f760c = new TypedValue();
        }
        Context context = this.f758a;
        TypedValue typedValue = this.f760c;
        if (context.isRestricted()) {
            return null;
        }
        return i.j.y0(context, resourceId, typedValue, i2, gVar, null, true);
    }

    public int j(int i, int i2) {
        return this.f759b.getInt(i, i2);
    }

    public int k(int i, int i2) {
        return this.f759b.getLayoutDimension(i, i2);
    }

    public int l(int i, int i2) {
        return this.f759b.getResourceId(i, i2);
    }

    public String m(int i) {
        return this.f759b.getString(i);
    }

    public CharSequence n(int i) {
        return this.f759b.getText(i);
    }

    public boolean o(int i) {
        return this.f759b.hasValue(i);
    }
}
