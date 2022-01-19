package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.appcompat.app.AppCompatDelegateImpl;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    public final Activity mActivity;
    public final Context mContext;
    public final FragmentManager mFragmentManager = new FragmentManagerImpl();
    public final Handler mHandler;

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.mActivity = fragmentActivity;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(fragmentActivity, "context == null");
        this.mContext = fragmentActivity;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(handler, "handler == null");
        this.mHandler = handler;
    }
}
