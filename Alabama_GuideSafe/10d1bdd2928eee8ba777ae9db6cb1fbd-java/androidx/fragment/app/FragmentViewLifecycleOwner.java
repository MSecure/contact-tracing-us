package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class FragmentViewLifecycleOwner implements LifecycleOwner {
    public LifecycleRegistry mLifecycleRegistry = null;

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
        }
        return this.mLifecycleRegistry;
    }
}
