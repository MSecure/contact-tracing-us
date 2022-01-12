package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.PromiseImpl;

public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, PromiseImpl.STACK_FRAME_KEY_CLASS);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.mFragmentManager.findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.mFragmentManager.findFragmentByTag(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.mFragmentManager.findFragmentById(id);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("onCreateView: id=0x");
            outline17.append(Integer.toHexString(resourceId));
            outline17.append(" fname=");
            outline17.append(attributeValue);
            outline17.append(" existing=");
            outline17.append(fragment);
            outline17.toString();
        }
        if (fragment == null) {
            fragment = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            fragment.mFragmentManager = fragmentManager;
            FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
            fragment.mHost = fragmentHostCallback;
            Context context2 = fragmentHostCallback.mContext;
            fragment.onInflate(attributeSet, fragment.mSavedFragmentState);
            this.mFragmentManager.addFragment(fragment);
            FragmentManager fragmentManager2 = this.mFragmentManager;
            fragmentManager2.moveToState(fragment, fragmentManager2.mCurState);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentHostCallback<?> fragmentHostCallback2 = this.mFragmentManager.mHost;
            fragment.mHost = fragmentHostCallback2;
            Context context3 = fragmentHostCallback2.mContext;
            fragment.onInflate(attributeSet, fragment.mSavedFragmentState);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        FragmentManager fragmentManager3 = this.mFragmentManager;
        if (fragmentManager3.mCurState >= 1 || !fragment.mFromLayout) {
            FragmentManager fragmentManager4 = this.mFragmentManager;
            fragmentManager4.moveToState(fragment, fragmentManager4.mCurState);
        } else {
            fragmentManager3.moveToState(fragment, 1);
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
        throw new IllegalStateException(GeneratedOutlineSupport.outline11("Fragment ", attributeValue, " did not create a view."));
    }
}
