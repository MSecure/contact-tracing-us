package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class ActionProvider {
    public VisibilityListener mVisibilityListener;

    public interface VisibilityListener {
    }

    public ActionProvider(Context context) {
    }

    public boolean isVisible() {
        return true;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return ((MenuItemWrapperICS.ActionProviderWrapper) this).mInner.onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.mVisibilityListener != null) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            outline17.append(getClass().getSimpleName());
            outline17.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", outline17.toString());
        }
        this.mVisibilityListener = visibilityListener;
    }
}
