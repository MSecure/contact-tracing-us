package e.h.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import e.h.a.i.d;
import e.h.a.i.g;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class b extends View {
    public int[] b;
    public int c;

    /* renamed from: d */
    public Context f1469d;

    /* renamed from: e */
    public g f1470e;

    /* renamed from: f */
    public String f1471f;

    /* renamed from: g */
    public String f1472g;

    /* renamed from: h */
    public View[] f1473h;

    /* renamed from: i */
    public HashMap<Integer, String> f1474i;

    public b(Context context) {
        super(context);
        this.b = new int[32];
        this.f1473h = null;
        this.f1474i = new HashMap<>();
        this.f1469d = context;
        i(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[32];
        this.f1473h = null;
        this.f1474i = new HashMap<>();
        this.f1469d = context;
        i(attributeSet);
    }

    public final void c(String str) {
        if (str != null && str.length() != 0 && this.f1469d != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            ConstraintLayout constraintLayout2 = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
            int i2 = 0;
            if (isInEditMode() && constraintLayout2 != null) {
                Object c = constraintLayout2.c(0, trim);
                if (c instanceof Integer) {
                    i2 = ((Integer) c).intValue();
                }
            }
            if (i2 == 0 && constraintLayout2 != null) {
                i2 = h(constraintLayout2, trim);
            }
            if (i2 == 0) {
                try {
                    i2 = R$id.class.getField(trim).getInt(null);
                } catch (Exception unused) {
                }
            }
            if (i2 == 0) {
                i2 = this.f1469d.getResources().getIdentifier(trim, "id", this.f1469d.getPackageName());
            }
            if (i2 != 0) {
                this.f1474i.put(Integer.valueOf(i2), trim);
                d(i2);
            }
        }
    }

    public final void d(int i2) {
        if (i2 != getId()) {
            int i3 = this.c + 1;
            int[] iArr = this.b;
            if (i3 > iArr.length) {
                this.b = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.b;
            int i4 = this.c;
            iArr2[i4] = i2;
            this.c = i4 + 1;
        }
    }

    public final void e(String str) {
        if (!(str == null || str.length() == 0 || this.f1469d == null)) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout != null) {
                int childCount = constraintLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = constraintLayout.getChildAt(i2);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if ((layoutParams instanceof ConstraintLayout.a) && trim.equals(((ConstraintLayout.a) layoutParams).X)) {
                        if (childAt.getId() == -1) {
                            childAt.getClass().getSimpleName();
                        } else {
                            d(childAt.getId());
                        }
                    }
                }
            }
        }
    }

    public void f(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.c; i2++) {
            View d2 = constraintLayout.d(this.b[i2]);
            if (d2 != null) {
                d2.setVisibility(visibility);
                if (elevation > 0.0f) {
                    d2.setTranslationZ(d2.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.b, this.c);
    }

    public final int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1469d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1471f = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1472g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void j(d dVar, boolean z) {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
        if (this.f1470e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).p0 = (d) this.f1470e;
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1471f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1472g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f1471f = str;
        if (str != null) {
            int i2 = 0;
            this.c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    c(str.substring(i2));
                    return;
                } else {
                    c(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1472g = str;
        if (str != null) {
            int i2 = 0;
            this.c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    e(str.substring(i2));
                    return;
                } else {
                    e(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1471f = null;
        this.c = 0;
        for (int i2 : iArr) {
            d(i2);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f1471f == null) {
            d(i2);
        }
    }
}
