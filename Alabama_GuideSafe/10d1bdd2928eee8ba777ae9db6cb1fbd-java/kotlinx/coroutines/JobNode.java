package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Removed;

/* compiled from: JobSupport.kt */
public abstract class JobNode<J extends Job> extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public final J job;

    public JobNode(J j) {
        this.job = j;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        Object state$kotlinx_coroutines_core;
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed;
        J j = this.job;
        if (j != null) {
            JobSupport jobSupport = (JobSupport) j;
            do {
                state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
                if (state$kotlinx_coroutines_core instanceof JobNode) {
                    if (state$kotlinx_coroutines_core != this) {
                        return;
                    }
                } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                    do {
                        next = getNext();
                        if (next instanceof Removed) {
                            LockFreeLinkedListNode lockFreeLinkedListNode2 = ((Removed) next).ref;
                            return;
                        } else if (next == this) {
                            LockFreeLinkedListNode lockFreeLinkedListNode3 = (LockFreeLinkedListNode) next;
                            return;
                        } else if (next != null) {
                            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                            removed = (Removed) lockFreeLinkedListNode._removedRef;
                            if (removed == null) {
                                removed = new Removed(lockFreeLinkedListNode);
                                LockFreeLinkedListNode._removedRef$FU.lazySet(lockFreeLinkedListNode, removed);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    } while (!LockFreeLinkedListNode._next$FU.compareAndSet(this, next, removed));
                    lockFreeLinkedListNode.correctPrev(null);
                    return;
                } else {
                    return;
                }
            } while (!JobSupport._state$FU.compareAndSet(jobSupport, state$kotlinx_coroutines_core, JobSupportKt.EMPTY_ACTIVE));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return getClass().getSimpleName() + '@' + MoreExecutors.getHexAddress(this) + "[job@" + MoreExecutors.getHexAddress(this.job) + ']';
    }
}
