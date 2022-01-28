package b.g.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.a.h.d;
import b.g.a.h.h;
import java.util.Arrays;

public abstract class b extends View {

    /* renamed from: b  reason: collision with root package name */
    public int[] f941b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    public int f942c;

    /* renamed from: d  reason: collision with root package name */
    public Context f943d;

    /* renamed from: e  reason: collision with root package name */
    public h f944e;
    public boolean f = false;
    public String g;

    public b(Context context) {
        super(context);
        this.f943d = context;
        b(null);
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    a(str.substring(i));
                    return;
                } else {
                    a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public final void a(String str) {
        int i;
        Object b2;
        if (str != null && this.f943d != null) {
            String trim = str.trim();
            try {
                i = g.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.f943d.getResources().getIdentifier(trim, "id", this.f943d.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (b2 = ((ConstraintLayout) getParent()).b(0, trim)) != null && (b2 instanceof Integer)) {
                i = ((Integer) b2).intValue();
            }
            if (i != 0) {
                setTag(i, null);
            }
        }
    }

    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.g = string;
                    setIds(string);
                }
            }
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.g);
        }
        h hVar = this.f944e;
        if (hVar != null) {
            hVar.k0 = 0;
            for (int i = 0; i < this.f942c; i++) {
                View view = constraintLayout.f109b.get(this.f941b[i]);
                if (view != null) {
                    h hVar2 = this.f944e;
                    d d2 = constraintLayout.d(view);
                    int i2 = hVar2.k0 + 1;
                    d[] dVarArr = hVar2.j0;
                    if (i2 > dVarArr.length) {
                        hVar2.j0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    }
                    d[] dVarArr2 = hVar2.j0;
                    int i3 = hVar2.k0;
                    dVarArr2[i3] = d2;
                    hVar2.k0 = i3 + 1;
                }
            }
        }
    }

    public void f() {
        if (this.f944e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).k0 = this.f944e;
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f941b, this.f942c);
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i, int i2) {
        if (this.f) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f942c = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    public void setTag(int i, Object obj) {
        int i2 = this.f942c + 1;
        int[] iArr = this.f941b;
        if (i2 > iArr.length) {
            this.f941b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f941b;
        int i3 = this.f942c;
        iArr2[i3] = i;
        this.f942c = i3 + 1;
    }
}
