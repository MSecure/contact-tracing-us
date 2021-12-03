package e.n.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import e.e.h;

public class c0 implements LayoutInflater.Factory2 {
    public final e0 b;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ k0 b;

        public a(k0 k0Var) {
            this.b = k0Var;
        }

        public void onViewAttachedToWindow(View view) {
            k0 k0Var = this.b;
            m mVar = k0Var.c;
            k0Var.k();
            a1.f((ViewGroup) mVar.F.getParent(), c0.this.b).e();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public c0(e0 e0Var) {
        this.b = e0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0158  */
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        k0 k0Var;
        View view2;
        StringBuilder sb;
        String str2;
        if (y.class.getName().equals(str)) {
            return new y(context, attributeSet, this.b);
        }
        m mVar = null;
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
            h<ClassLoader, h<String, Class<?>>> hVar = a0.a;
            int i2 = 0;
            try {
                z = m.class.isAssignableFrom(a0.b(classLoader, attributeValue));
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
                    mVar = this.b.H(resourceId);
                }
                if (mVar == null && string != null) {
                    mVar = this.b.I(string);
                }
                if (mVar == null && i2 != -1) {
                    mVar = this.b.H(i2);
                }
                if (mVar == null) {
                    mVar = this.b.L().a(context.getClassLoader(), attributeValue);
                    mVar.n = true;
                    mVar.w = resourceId != 0 ? resourceId : i2;
                    mVar.x = i2;
                    mVar.y = string;
                    mVar.o = true;
                    e0 e0Var = this.b;
                    mVar.s = e0Var;
                    b0<?> b0Var = e0Var.q;
                    mVar.t = b0Var;
                    mVar.a0(b0Var.c, attributeSet, mVar.c);
                    k0Var = this.b.a(mVar);
                    if (e0.O(2)) {
                        sb = new StringBuilder();
                        sb.append("Fragment ");
                        sb.append(mVar);
                        str2 = " has been inflated via the <fragment> tag: id=0x";
                    }
                    mVar.E = (ViewGroup) view;
                    k0Var.k();
                    k0Var.j();
                    view2 = mVar.F;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (mVar.F.getTag() == null) {
                            mVar.F.setTag(string);
                        }
                        mVar.F.addOnAttachStateChangeListener(new a(k0Var));
                        return mVar.F;
                    }
                    throw new IllegalStateException(f.a.a.a.a.c("Fragment ", attributeValue, " did not create a view."));
                } else if (!mVar.o) {
                    mVar.o = true;
                    e0 e0Var2 = this.b;
                    mVar.s = e0Var2;
                    b0<?> b0Var2 = e0Var2.q;
                    mVar.t = b0Var2;
                    mVar.a0(b0Var2.c, attributeSet, mVar.c);
                    k0Var = this.b.h(mVar);
                    if (e0.O(2)) {
                        sb = new StringBuilder();
                        sb.append("Retained Fragment ");
                        sb.append(mVar);
                        str2 = " has been re-attached via the <fragment> tag: id=0x";
                    }
                    mVar.E = (ViewGroup) view;
                    k0Var.k();
                    k0Var.j();
                    view2 = mVar.F;
                    if (view2 != null) {
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + attributeValue);
                }
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
                sb.toString();
                mVar.E = (ViewGroup) view;
                k0Var.k();
                k0Var.j();
                view2 = mVar.F;
                if (view2 != null) {
                }
            }
        }
        return null;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
