package b.g.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.h.d;
import b.g.b.h.g;
import java.util.Arrays;
import java.util.HashMap;

public abstract class b extends View {

    /* renamed from: b  reason: collision with root package name */
    public int[] f1582b;

    /* renamed from: c  reason: collision with root package name */
    public int f1583c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1584d;

    /* renamed from: e  reason: collision with root package name */
    public g f1585e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1586f;

    /* renamed from: g  reason: collision with root package name */
    public String f1587g;
    public HashMap<Integer, String> h;

    public b(Context context) {
        super(context);
        this.f1582b = new int[32];
        this.f1586f = false;
        this.h = new HashMap<>();
        this.f1584d = context;
        e(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1582b = new int[32];
        this.f1586f = false;
        this.h = new HashMap<>();
        this.f1584d = context;
        e(attributeSet);
    }

    public final void a(String str) {
        Object d2;
        if (str != null && str.length() != 0 && this.f1584d != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            int i = 0;
            if (isInEditMode() && constraintLayout != null && (d2 = constraintLayout.d(0, trim)) != null && (d2 instanceof Integer)) {
                i = ((Integer) d2).intValue();
            }
            if (i == 0 && constraintLayout != null) {
                i = d(constraintLayout, trim);
            }
            if (i == 0) {
                i = this.f1584d.getResources().getIdentifier(trim, "id", this.f1584d.getPackageName());
            }
            if (i != 0) {
                this.h.put(Integer.valueOf(i), trim);
                b(i);
            }
        }
    }

    public final void b(int i) {
        int i2 = this.f1583c + 1;
        int[] iArr = this.f1582b;
        if (i2 > iArr.length) {
            this.f1582b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1582b;
        int i3 = this.f1583c;
        iArr2[i3] = i;
        this.f1583c = i3 + 1;
    }

    public void c() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            String str = this.f1587g;
            if (str != null) {
                setIds(str);
            }
            for (int i = 0; i < this.f1583c; i++) {
                View e2 = constraintLayout.e(this.f1582b[i]);
                if (e2 != null) {
                    e2.setVisibility(visibility);
                    if (elevation > 0.0f) {
                        e2.setTranslationZ(e2.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
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

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == i.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1587g = string;
                    setIds(string);
                }
            }
        }
    }

    public void f() {
    }

    public void g() {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1582b, this.f1583c);
    }

    public void h() {
    }

    public void i() {
        if (this.f1585e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).m0 = (d) this.f1585e;
            }
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i, int i2) {
        if (this.f1586f) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.f1587g = str;
        if (str != null) {
            int i = 0;
            this.f1583c = 0;
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

    public void setReferencedIds(int[] iArr) {
        this.f1587g = null;
        this.f1583c = 0;
        for (int i : iArr) {
            b(i);
        }
    }
}
