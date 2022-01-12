package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: LockFreeLinkedList.kt */
public final class JobSupport$addLastAtomic$$inlined$addLastIf$1 extends LockFreeLinkedListNode.CondAddOp {
    public final /* synthetic */ Object $expect$inlined;
    public final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobSupport$addLastAtomic$$inlined$addLastIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, JobSupport jobSupport, Object obj) {
        super(lockFreeLinkedListNode2);
        this.this$0 = jobSupport;
        this.$expect$inlined = obj;
    }
}
