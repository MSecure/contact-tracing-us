package b.l.d;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.l.c;

public class x implements LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    public final z f2172b;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g0 f2173b;

        public a(g0 g0Var) {
            this.f2173b = g0Var;
        }

        public void onViewAttachedToWindow(View view) {
            g0 g0Var = this.f2173b;
            Fragment fragment = g0Var.f2021c;
            g0Var.k();
            w0.f((ViewGroup) fragment.mView.getParent(), x.this.f2172b).e();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public x(z zVar) {
        this.f2172b = zVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014f  */
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        g0 g0Var;
        View view2;
        StringBuilder sb;
        String str2;
        if (t.class.getName().equals(str)) {
            return new t(context, attributeSet, this.f2172b);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(c.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(c.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !v.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f2172b.I(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f2172b.J(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f2172b.I(id);
        }
        if (fragment == null) {
            fragment = this.f2172b.M().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            z zVar = this.f2172b;
            fragment.mFragmentManager = zVar;
            w<?> wVar = zVar.q;
            fragment.mHost = wVar;
            fragment.onInflate(wVar.f2143c, attributeSet, fragment.mSavedFragmentState);
            g0Var = this.f2172b.a(fragment);
            if (z.P(2)) {
                sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(fragment);
                str2 = " has been inflated via the <fragment> tag: id=0x";
            }
            fragment.mContainer = (ViewGroup) view;
            g0Var.k();
            g0Var.j();
            view2 = fragment.mView;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (fragment.mView.getTag() == null) {
                    fragment.mView.setTag(string);
                }
                fragment.mView.addOnAttachStateChangeListener(new a(g0Var));
                return fragment.mView;
            }
            throw new IllegalStateException(c.a.a.a.a.c("Fragment ", attributeValue, " did not create a view."));
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            z zVar2 = this.f2172b;
            fragment.mFragmentManager = zVar2;
            w<?> wVar2 = zVar2.q;
            fragment.mHost = wVar2;
            fragment.onInflate(wVar2.f2143c, attributeSet, fragment.mSavedFragmentState);
            g0Var = this.f2172b.i(fragment);
            if (z.P(2)) {
                sb = new StringBuilder();
                sb.append("Retained Fragment ");
                sb.append(fragment);
                str2 = " has been re-attached via the <fragment> tag: id=0x";
            }
            fragment.mContainer = (ViewGroup) view;
            g0Var.k();
            g0Var.j();
            view2 = fragment.mView;
            if (view2 != null) {
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        sb.append(str2);
        sb.append(Integer.toHexString(resourceId));
        sb.toString();
        fragment.mContainer = (ViewGroup) view;
        g0Var.k();
        g0Var.j();
        view2 = fragment.mView;
        if (view2 != null) {
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
