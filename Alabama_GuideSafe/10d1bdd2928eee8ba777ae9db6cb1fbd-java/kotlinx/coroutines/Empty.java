package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: JobSupport.kt */
public final class Empty implements Incomplete {
    public final boolean isActive;

    public Empty(boolean z) {
        this.isActive = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Empty{");
        outline17.append(this.isActive ? "Active" : "New");
        outline17.append('}');
        return outline17.toString();
    }
}
