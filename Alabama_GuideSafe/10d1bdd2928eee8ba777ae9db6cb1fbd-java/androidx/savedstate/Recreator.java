package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements LifecycleEventObserver {
    public final SavedStateRegistryOwner mOwner;

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        public final Set<String> mClasses = new HashSet();

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            if (savedStateRegistry.mComponents.putIfAbsent("androidx.savedstate.Restarter", this) != null) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.mClasses));
            return bundle;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Class cls;
        if (event == Lifecycle.Event.ON_CREATE) {
            ((LifecycleRegistry) lifecycleOwner.getLifecycle()).mObserverMap.remove(this);
            SavedStateRegistry savedStateRegistry = this.mOwner.getSavedStateRegistry();
            if (savedStateRegistry.mRestored) {
                Bundle bundle = savedStateRegistry.mRestoredState;
                Bundle bundle2 = null;
                if (bundle != null) {
                    Bundle bundle3 = bundle.getBundle("androidx.savedstate.Restarter");
                    savedStateRegistry.mRestoredState.remove("androidx.savedstate.Restarter");
                    if (savedStateRegistry.mRestoredState.isEmpty()) {
                        savedStateRegistry.mRestoredState = null;
                    }
                    bundle2 = bundle3;
                }
                if (bundle2 != null) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("classes_to_restore");
                    if (stringArrayList != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            try {
                                try {
                                    Constructor<? extends U> declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class).getDeclaredConstructor(new Class[0]);
                                    declaredConstructor.setAccessible(true);
                                    try {
                                        ((SavedStateRegistry.AutoRecreated) declaredConstructor.newInstance(new Object[0])).onRecreated(this.mOwner);
                                    } catch (Exception e) {
                                        throw new RuntimeException(GeneratedOutlineSupport.outline10("Failed to instantiate ", next), e);
                                    }
                                } catch (NoSuchMethodException e2) {
                                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Class");
                                    outline17.append(cls.getSimpleName());
                                    outline17.append(" must have default constructor in order to be automatically recreated");
                                    throw new IllegalStateException(outline17.toString(), e2);
                                }
                            } catch (ClassNotFoundException e3) {
                                throw new RuntimeException(GeneratedOutlineSupport.outline11("Class ", next, " wasn't found"), e3);
                            }
                        }
                        return;
                    }
                    throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                return;
            }
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
