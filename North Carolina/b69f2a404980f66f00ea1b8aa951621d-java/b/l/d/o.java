package b.l.d;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.l.c;
import c.a.a.a.a;

public class o implements LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    public final q f1324b;

    public o(q qVar) {
        this.f1324b = qVar;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (k.class.getName().equals(str)) {
            return new k(context, attributeSet, this.f1324b);
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
        if (attributeValue == null || !m.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f1324b.I(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f1324b.J(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f1324b.I(id);
        }
        if (q.P(2)) {
            StringBuilder g = a.g("onCreateView: id=0x");
            g.append(Integer.toHexString(resourceId));
            g.append(" fname=");
            g.append(attributeValue);
            g.append(" existing=");
            g.append(fragment);
            g.toString();
        }
        if (fragment == null) {
            fragment = this.f1324b.N().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            q qVar = this.f1324b;
            fragment.mFragmentManager = qVar;
            n<?> nVar = qVar.n;
            fragment.mHost = nVar;
            fragment.onInflate(nVar.f1321c, attributeSet, fragment.mSavedFragmentState);
            this.f1324b.b(fragment);
            q qVar2 = this.f1324b;
            qVar2.W(fragment, qVar2.m);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            n<?> nVar2 = this.f1324b.n;
            fragment.mHost = nVar2;
            fragment.onInflate(nVar2.f1321c, attributeSet, fragment.mSavedFragmentState);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        q qVar3 = this.f1324b;
        if (qVar3.m >= 1 || !fragment.mFromLayout) {
            q qVar4 = this.f1324b;
            qVar4.W(fragment, qVar4.m);
        } else {
            qVar3.W(fragment, 1);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException(a.p("Fragment ", attributeValue, " did not create a view."));
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
