package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: JobSupport.kt */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this;
    }

    public final String getString(String str) {
        StringBuilder outline20 = GeneratedOutlineSupport.outline20("List{", str, "}[");
        Object next = getNext();
        if (next != null) {
            boolean z = true;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    if (z) {
                        z = false;
                    } else {
                        outline20.append(", ");
                    }
                    outline20.append(jobNode);
                }
            }
            outline20.append("]");
            String sb = outline20.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
            return sb;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugKt.DEBUG ? getString("Active") : super.toString();
    }
}
