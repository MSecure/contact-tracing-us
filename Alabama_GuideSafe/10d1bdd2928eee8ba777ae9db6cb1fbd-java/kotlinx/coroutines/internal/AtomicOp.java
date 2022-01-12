package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: Atomic.kt */
public abstract class AtomicOp<T> extends OpDescriptor {
    public static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    public volatile Object _consensus = AtomicKt.NO_DECISION;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object obj) {
        Object obj2 = this._consensus;
        boolean z = true;
        if (obj2 == AtomicKt.NO_DECISION) {
            JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = (JobSupport$addLastAtomic$$inlined$addLastIf$1) this;
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            if (jobSupport$addLastAtomic$$inlined$addLastIf$1.this$0.getState$kotlinx_coroutines_core() == jobSupport$addLastAtomic$$inlined$addLastIf$1.$expect$inlined) {
                obj2 = null;
            } else {
                obj2 = LockFreeLinkedListKt.CONDITION_FALSE;
            }
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (!(obj2 != AtomicKt.NO_DECISION)) {
                    throw new AssertionError();
                }
            }
            Object obj3 = this._consensus;
            Object obj4 = AtomicKt.NO_DECISION;
            if (obj3 != obj4) {
                obj2 = obj3;
            } else if (!_consensus$FU.compareAndSet(this, obj4, obj2)) {
                obj2 = this._consensus;
            }
        }
        LockFreeLinkedListNode.CondAddOp condAddOp = (LockFreeLinkedListNode.CondAddOp) this;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
        if (obj2 != null) {
            z = false;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode3 = z ? condAddOp.newNode : condAddOp.oldNext;
        if (lockFreeLinkedListNode3 != null && LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode2, condAddOp, lockFreeLinkedListNode3) && z) {
            LockFreeLinkedListNode lockFreeLinkedListNode4 = condAddOp.newNode;
            LockFreeLinkedListNode lockFreeLinkedListNode5 = condAddOp.oldNext;
            Intrinsics.checkNotNull(lockFreeLinkedListNode5);
            lockFreeLinkedListNode4.finishAdd(lockFreeLinkedListNode5);
        }
        return obj2;
    }
}
