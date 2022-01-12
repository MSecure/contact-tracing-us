package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.savedstate.Recreator;
import com.android.tools.r8.GeneratedOutlineSupport;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    public boolean mAllowingSavingState = true;
    public SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap<>();
    public Recreator.SavedStateProvider mRecreatorProvider;
    public boolean mRestored;
    public Bundle mRestoredState;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        if (this.mAllowingSavingState) {
            if (this.mRecreatorProvider == null) {
                this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider = this.mRecreatorProvider;
                savedStateProvider.mClasses.add(cls.getName());
            } catch (NoSuchMethodException e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Class");
                outline17.append(cls.getSimpleName());
                outline17.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(outline17.toString(), e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
