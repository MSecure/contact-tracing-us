package e.m.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.R$styleable;
import e.e.h;
import f.a.a.a.a;

public class a0 implements LayoutInflater.Factory2 {
    public final c0 b;

    public a0(c0 c0Var) {
        this.b = c0Var;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        j0 j0Var;
        if (w.class.getName().equals(str)) {
            return new w(context, attributeSet, this.b);
        }
        l lVar = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            ClassLoader classLoader = context.getClassLoader();
            h<String, Class<?>> hVar = y.a;
            int i2 = 0;
            try {
                z = l.class.isAssignableFrom(y.b(classLoader, attributeValue));
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                if (view != null) {
                    i2 = view.getId();
                }
                if (i2 == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                if (resourceId != -1) {
                    lVar = this.b.I(resourceId);
                }
                if (lVar == null && string != null) {
                    lVar = this.b.J(string);
                }
                if (lVar == null && i2 != -1) {
                    lVar = this.b.I(i2);
                }
                if (c0.Q(2)) {
                    StringBuilder h2 = a.h("onCreateView: id=0x");
                    h2.append(Integer.toHexString(resourceId));
                    h2.append(" fname=");
                    h2.append(attributeValue);
                    h2.append(" existing=");
                    h2.append(lVar);
                    h2.toString();
                }
                if (lVar == null) {
                    lVar = this.b.M().a(context.getClassLoader(), attributeValue);
                    lVar.n = true;
                    lVar.w = resourceId != 0 ? resourceId : i2;
                    lVar.x = i2;
                    lVar.y = string;
                    lVar.o = true;
                    c0 c0Var = this.b;
                    lVar.s = c0Var;
                    z<?> zVar = c0Var.q;
                    lVar.t = zVar;
                    lVar.W(zVar.c, attributeSet, lVar.c);
                    j0Var = this.b.i(lVar);
                    this.b.b(lVar);
                } else if (!lVar.o) {
                    lVar.o = true;
                    c0 c0Var2 = this.b;
                    lVar.s = c0Var2;
                    z<?> zVar2 = c0Var2.q;
                    lVar.t = zVar2;
                    lVar.W(zVar2.c, attributeSet, lVar.c);
                    j0Var = this.b.i(lVar);
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + attributeValue);
                }
                j0Var.j();
                j0Var.i();
                View view2 = lVar.F;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (lVar.F.getTag() == null) {
                        lVar.F.setTag(string);
                    }
                    return lVar.F;
                }
                throw new IllegalStateException(a.c("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
