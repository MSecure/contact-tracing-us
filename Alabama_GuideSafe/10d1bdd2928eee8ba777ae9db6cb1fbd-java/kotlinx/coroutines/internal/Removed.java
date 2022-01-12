package kotlinx.coroutines.internal;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: LockFreeLinkedList.kt */
public final class Removed {
    public final LockFreeLinkedListNode ref;

    public Removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.ref = lockFreeLinkedListNode;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Removed[");
        outline17.append(this.ref);
        outline17.append(']');
        return outline17.toString();
    }
}
