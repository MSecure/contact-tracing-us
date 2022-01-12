package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: JobSupport.kt */
public class JobSupport implements Job, ChildJob, ParentJob {
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* compiled from: JobSupport.kt */
    public static final class ChildCompletion extends JobNode<Job> {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            super(childHandleNode.childJob);
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(Throwable th) {
            JobSupport jobSupport = this.parent;
            Finishing finishing = this.state;
            ChildHandleNode childHandleNode = this.child;
            Object obj = this.proposedUpdate;
            if (jobSupport != null) {
                if (DebugKt.ASSERTIONS_ENABLED) {
                    if (!(jobSupport.getState$kotlinx_coroutines_core() == finishing)) {
                        throw new AssertionError();
                    }
                }
                ChildHandleNode nextChild = jobSupport.nextChild(childHandleNode);
                if (nextChild == null || !jobSupport.tryWaitForChild(finishing, nextChild, obj)) {
                    jobSupport.afterCompletion(jobSupport.finalizeFinishingState(finishing, obj));
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class Finishing implements Incomplete {
        public volatile Object _exceptionsHolder = null;
        public volatile int _isCompleting;
        public volatile Object _rootCause;
        public final NodeList list;

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void addExceptionLocked(Throwable th) {
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
            } else if (th != th2) {
                ?? r0 = this._exceptionsHolder;
                if (r0 == 0) {
                    this._exceptionsHolder = th;
                } else if (r0 instanceof Throwable) {
                    if (th != r0) {
                        ArrayList<Throwable> allocateList = allocateList();
                        allocateList.add(r0);
                        allocateList.add(th);
                        this._exceptionsHolder = allocateList;
                    }
                } else if (r0 instanceof ArrayList) {
                    ((ArrayList) r0).add(th);
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline9("State is ", r0).toString());
                }
            }
        }

        public final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return ((Throwable) this._rootCause) == null;
        }

        public final boolean isCancelling() {
            return ((Throwable) this._rootCause) != null;
        }

        public final boolean isSealed() {
            return this._exceptionsHolder == JobSupportKt.SEALED;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final List<Throwable> sealLocked(Throwable th) {
            ArrayList<Throwable> arrayList;
            ?? r0 = this._exceptionsHolder;
            if (r0 == 0) {
                arrayList = allocateList();
            } else if (r0 instanceof Throwable) {
                ArrayList<Throwable> allocateList = allocateList();
                allocateList.add(r0);
                arrayList = allocateList;
            } else if (r0 instanceof ArrayList) {
                arrayList = (ArrayList) r0;
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline9("State is ", r0).toString());
            }
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 != null) {
                arrayList.add(0, th2);
            }
            if (th != null && (!Intrinsics.areEqual(th, th2))) {
                arrayList.add(th);
            }
            this._exceptionsHolder = JobSupportKt.SEALED;
            return arrayList;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.StringBuilder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Finishing[cancelling=");
            outline17.append(isCancelling());
            outline17.append(", completing=");
            outline17.append((boolean) this._isCompleting);
            outline17.append(", rootCause=");
            outline17.append((Throwable) this._rootCause);
            outline17.append(", exceptions=");
            outline17.append(this._exceptionsHolder);
            outline17.append(", list=");
            outline17.append(this.list);
            outline17.append(']');
            return outline17.toString();
        }
    }

    public JobSupport(boolean z) {
        Empty empty;
        if (z) {
            empty = JobSupportKt.EMPTY_ACTIVE;
        } else {
            empty = JobSupportKt.EMPTY_NEW;
        }
        this._state = empty;
        this._parentHandle = null;
    }

    public final boolean addLastAtomic(Object obj, NodeList nodeList, JobNode<?> jobNode) {
        boolean z;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, jobNode, this, obj);
        do {
            LockFreeLinkedListNode prevNode = nodeList.getPrevNode();
            LockFreeLinkedListNode._prev$FU.lazySet(jobNode, prevNode);
            LockFreeLinkedListNode._next$FU.lazySet(jobNode, nodeList);
            jobSupport$addLastAtomic$$inlined$addLastIf$1.oldNext = nodeList;
            if (!LockFreeLinkedListNode._next$FU.compareAndSet(prevNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1)) {
                z = false;
            } else {
                z = jobSupport$addLastAtomic$$inlined$addLastIf$1.perform(prevNode) == null ? true : true;
            }
            if (z) {
                return true;
            }
        } while (!z);
        return false;
    }

    public final void addSuppressedExceptions(Throwable th, List<? extends Throwable> list) {
        Throwable th2;
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            if (!DebugKt.RECOVER_STACK_TRACES) {
                th2 = th;
            } else {
                th2 = StackTraceRecoveryKt.unwrapImpl(th);
            }
            for (Throwable th3 : list) {
                if (DebugKt.RECOVER_STACK_TRACES) {
                    th3 = StackTraceRecoveryKt.unwrapImpl(th3);
                }
                if (th3 != th && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                    MoreExecutors.addSuppressed(th, th3);
                }
            }
        }
    }

    public void afterCompletion(Object obj) {
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob childJob) {
        DisposableHandle invokeOnCompletion$default = MoreExecutors.invokeOnCompletion$default(this, true, false, new ChildHandleNode(this, childJob), 2, null);
        if (invokeOnCompletion$default != null) {
            return (ChildHandle) invokeOnCompletion$default;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d0, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00a5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0008 A[SYNTHETIC] */
    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Symbol symbol;
        boolean z;
        Symbol symbol2 = JobSupportKt.COMPLETING_ALREADY;
        if (symbol2 == symbol2) {
            Throwable th = null;
            Throwable th2 = null;
            while (true) {
                Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
                    if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                        symbol = JobSupportKt.TOO_LATE_TO_CANCEL;
                        break;
                    }
                    if (th2 == null) {
                        th2 = createCauseException(obj);
                    }
                    Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                    if (!incomplete.isActive()) {
                        Object tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(th2, false, 2));
                        if (tryMakeCompleting != JobSupportKt.COMPLETING_ALREADY) {
                            if (tryMakeCompleting != JobSupportKt.COMPLETING_RETRY) {
                                symbol2 = tryMakeCompleting;
                                break;
                            }
                        } else {
                            throw new IllegalStateException(GeneratedOutlineSupport.outline9("Cannot happen in ", state$kotlinx_coroutines_core).toString());
                        }
                    } else if (DebugKt.ASSERTIONS_ENABLED && !(!(incomplete instanceof Finishing))) {
                        throw new AssertionError();
                    } else if (!DebugKt.ASSERTIONS_ENABLED || incomplete.isActive()) {
                        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                        if (orPromoteCancellingList != null) {
                            if (_state$FU.compareAndSet(this, incomplete, new Finishing(orPromoteCancellingList, false, th2))) {
                                notifyCancelling(orPromoteCancellingList, th2);
                                z = true;
                                if (!z) {
                                    symbol = JobSupportKt.COMPLETING_ALREADY;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    synchronized (state$kotlinx_coroutines_core) {
                        if (((Finishing) state$kotlinx_coroutines_core).isSealed()) {
                            symbol = JobSupportKt.TOO_LATE_TO_CANCEL;
                        } else {
                            boolean isCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                            if (obj != null || !isCancelling) {
                                if (th2 == null) {
                                    th2 = createCauseException(obj);
                                }
                                ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(th2);
                            }
                            Throwable th3 = (Throwable) ((Finishing) state$kotlinx_coroutines_core)._rootCause;
                            if (!isCancelling) {
                                th = th3;
                            }
                            if (th != null) {
                                notifyCancelling(((Finishing) state$kotlinx_coroutines_core).list, th);
                            }
                            symbol = JobSupportKt.COMPLETING_ALREADY;
                        }
                    }
                }
            }
        }
        if (!(symbol2 == JobSupportKt.COMPLETING_ALREADY || symbol2 == JobSupportKt.COMPLETING_WAITING_CHILDREN)) {
            if (symbol2 == JobSupportKt.TOO_LATE_TO_CANCEL) {
                return false;
            }
            afterCompletion(symbol2);
        }
        return true;
    }

    public final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) this._parentHandle;
        if (childHandle == null || childHandle == NonDisposableHandle.INSTANCE) {
            return z;
        }
        if (childHandle.childCancelled(th) || z) {
            return true;
        }
        return false;
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) {
        ChildHandle childHandle = (ChildHandle) this._parentHandle;
        if (childHandle != null) {
            childHandle.dispose();
            this._parentHandle = NonDisposableHandle.INSTANCE;
        }
        CompletionHandlerException completionHandlerException = null;
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                Object next = list.getNext();
                if (next != null) {
                    for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                        if (lockFreeLinkedListNode instanceof JobNode) {
                            JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                            try {
                                jobNode.invoke(th);
                            } catch (Throwable th3) {
                                if (completionHandlerException != null) {
                                    MoreExecutors.addSuppressed(completionHandlerException, th3);
                                } else {
                                    completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                                }
                            }
                        }
                    }
                    if (completionHandlerException != null) {
                        handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            if (obj != null) {
                return (Throwable) obj;
            }
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        } else if (obj != null) {
            return ((ParentJob) obj).getChildJobCancellationCause();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) {
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(getState$kotlinx_coroutines_core() == finishing)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.ASSERTIONS_ENABLED && !(!finishing.isSealed())) {
            throw new AssertionError();
        } else if (!DebugKt.ASSERTIONS_ENABLED || finishing._isCompleting != 0) {
            Throwable th = null;
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
            Throwable th2 = completedExceptionally != null ? completedExceptionally.cause : null;
            synchronized (finishing) {
                finishing.isCancelling();
                List<Throwable> sealLocked = finishing.sealLocked(th2);
                if (!sealLocked.isEmpty()) {
                    Iterator<T> it = sealLocked.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (!(next instanceof CancellationException)) {
                            th = next;
                            break;
                        }
                    }
                    th = th;
                    if (th == null) {
                        th = sealLocked.get(0);
                    }
                } else if (finishing.isCancelling()) {
                    th = new JobCancellationException(cancellationExceptionMessage(), null, this);
                }
                if (th != null) {
                    addSuppressedExceptions(th, sealLocked);
                }
            }
            if (!(th == null || th == th2)) {
                obj = new CompletedExceptionally(th, false, 2);
            }
            if (th != null) {
                if (cancelParent(th) || handleJobException(th)) {
                    if (obj != null) {
                        CompletedExceptionally._handled$FU.compareAndSet((CompletedExceptionally) obj, 0, 1);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            onCompletionInternal(obj);
            boolean compareAndSet = _state$FU.compareAndSet(this, finishing, obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj);
            if (!DebugKt.ASSERTIONS_ENABLED || compareAndSet) {
                completeStateFinalization(finishing, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable th = (Throwable) ((Finishing) state$kotlinx_coroutines_core)._rootCause;
            if (th != null) {
                return toCancellationException(th, getClass().getSimpleName() + " is cancelling");
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null);
        } else {
            return new JobCancellationException(getClass().getSimpleName() + " has completed normally", null, this);
        }
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th = (Throwable) ((Finishing) state$kotlinx_coroutines_core)._rootCause;
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(GeneratedOutlineSupport.outline9("Cannot be cancelling child in this state: ", state$kotlinx_coroutines_core).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Parent job is ");
        outline17.append(stateString(state$kotlinx_coroutines_core));
        return new JobCancellationException(outline17.toString(), th, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        Throwable th;
        Throwable th2 = null;
        JobNode<?> jobNode = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive) {
                    if (jobNode == null) {
                        jobNode = makeNode(function1, z);
                    }
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                        return jobNode;
                    }
                } else {
                    NodeList nodeList = new NodeList();
                    if (!empty.isActive) {
                        nodeList = new InactiveNodeList(nodeList);
                    }
                    _state$FU.compareAndSet(this, empty, nodeList);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (!z || !(state$kotlinx_coroutines_core instanceof Finishing)) {
                        th = null;
                    } else {
                        synchronized (state$kotlinx_coroutines_core) {
                            th = (Throwable) ((Finishing) state$kotlinx_coroutines_core)._rootCause;
                            if (th == null || ((function1 instanceof ChildHandleNode) && ((Finishing) state$kotlinx_coroutines_core)._isCompleting == 0)) {
                                if (jobNode == null) {
                                    jobNode = makeNode(function1, z);
                                }
                                if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                                    if (th == null) {
                                        return jobNode;
                                    }
                                    disposableHandle = jobNode;
                                }
                            }
                        }
                    }
                    if (th != null) {
                        if (z2) {
                            function1.invoke(th);
                        }
                        return disposableHandle;
                    }
                    if (jobNode == null) {
                        jobNode = makeNode(function1, z);
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                        return jobNode;
                    }
                } else if (state$kotlinx_coroutines_core != null) {
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                }
            } else {
                if (z2) {
                    if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                        state$kotlinx_coroutines_core = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
                    if (completedExceptionally != null) {
                        th2 = completedExceptionally.cause;
                    }
                    function1.invoke(th2);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, " + "but is being completed with " + obj;
                Throwable th = null;
                if (!(obj instanceof CompletedExceptionally)) {
                    obj = null;
                }
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                throw new IllegalStateException(str, th);
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }

    public final JobNode<?> makeNode(Function1<? super Throwable, Unit> function1, boolean z) {
        boolean z2 = true;
        JobCancellingNode jobCancellingNode = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobCancellingNode = function1;
            }
            JobCancellingNode jobCancellingNode2 = jobCancellingNode;
            if (jobCancellingNode2 == null) {
                return new InvokeOnCancelling(this, function1);
            }
            if (!DebugKt.ASSERTIONS_ENABLED) {
                return jobCancellingNode2;
            }
            if (jobCancellingNode2.job != this) {
                z2 = false;
            }
            if (z2) {
                return jobCancellingNode2;
            }
            throw new AssertionError();
        }
        if (function1 instanceof JobNode) {
            jobCancellingNode = function1;
        }
        JobNode<?> jobNode = jobCancellingNode;
        if (jobNode == null) {
            return new InvokeOnCompletion(this, function1);
        }
        if (!DebugKt.ASSERTIONS_ENABLED) {
            return jobNode;
        }
        if (jobNode.job != this || (jobNode instanceof JobCancellingNode)) {
            z2 = false;
        }
        if (z2) {
            return jobNode;
        }
        throw new AssertionError();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return getClass().getSimpleName();
    }

    public final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        Object next = nodeList.getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            MoreExecutors.addSuppressed(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
            }
            cancelParent(th);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public void onCompletionInternal(Object obj) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    public final void promoteSingleToNodeList(JobNode<?> jobNode) {
        NodeList nodeList = new NodeList();
        LockFreeLinkedListNode._prev$FU.lazySet(nodeList, jobNode);
        LockFreeLinkedListNode._next$FU.lazySet(nodeList, jobNode);
        while (true) {
            if (jobNode.getNext() == jobNode) {
                if (LockFreeLinkedListNode._next$FU.compareAndSet(jobNode, jobNode, nodeList)) {
                    nodeList.finishAdd(jobNode);
                    break;
                }
            } else {
                break;
            }
        }
        _state$FU.compareAndSet(this, jobNode, jobNode.getNextNode());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[ADDED_TO_REGION, LOOP:0: B:0:0x0000->B:15:0x003c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC] */
    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        char c;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            c = 65535;
            if (state$kotlinx_coroutines_core instanceof Empty) {
                if (!((Empty) state$kotlinx_coroutines_core).isActive) {
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, JobSupportKt.EMPTY_ACTIVE)) {
                        onStartInternal$kotlinx_coroutines_core();
                    }
                    if (c == 0) {
                        return false;
                    }
                }
                c = 0;
                if (c == 0) {
                }
            } else {
                if (state$kotlinx_coroutines_core instanceof InactiveNodeList) {
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, ((InactiveNodeList) state$kotlinx_coroutines_core).list)) {
                        onStartInternal$kotlinx_coroutines_core();
                    }
                    if (c == 0) {
                    }
                }
                c = 0;
                if (c == 0) {
                }
            }
            c = 1;
            if (c == 0) {
            }
        } while (c != 1);
        return true;
    }

    public final String stateString(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing._isCompleting != 0) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        } else {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
    }

    public final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}');
        sb.append('@');
        sb.append(MoreExecutors.getHexAddress(this));
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return finalizeFinishingState(r3, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00cb, code lost:
        if (r5 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00cd, code lost:
        notifyCancelling(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00d2, code lost:
        if ((r7 instanceof kotlinx.coroutines.ChildHandleNode) != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00d4, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00d6, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00d7, code lost:
        r0 = (kotlinx.coroutines.ChildHandleNode) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d9, code lost:
        if (r0 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00db, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00dd, code lost:
        r7 = r7.getList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00e1, code lost:
        if (r7 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00e3, code lost:
        r4 = nextChild(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00e7, code lost:
        if (r4 == null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00ed, code lost:
        if (tryWaitForChild(r3, r4, r8) == false) goto L_0x00f2;
     */
    public final Object tryMakeCompleting(Object obj, Object obj2) {
        boolean z;
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.COMPLETING_ALREADY;
        }
        boolean z2 = true;
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !((z = obj2 instanceof CompletedExceptionally))) {
            Incomplete incomplete = (Incomplete) obj;
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
                    throw new AssertionError();
                }
            }
            if (!DebugKt.ASSERTIONS_ENABLED || (!z)) {
                if (!_state$FU.compareAndSet(this, incomplete, obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2)) {
                    z2 = false;
                } else {
                    onCompletionInternal(obj2);
                    completeStateFinalization(incomplete, obj2);
                }
                if (z2) {
                    return obj2;
                }
                return JobSupportKt.COMPLETING_RETRY;
            }
            throw new AssertionError();
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete2);
        if (orPromoteCancellingList == null) {
            return JobSupportKt.COMPLETING_RETRY;
        }
        ChildHandleNode childHandleNode = null;
        Finishing finishing = (Finishing) (!(incomplete2 instanceof Finishing) ? null : incomplete2);
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, false, null);
        }
        synchronized (finishing) {
            if (finishing._isCompleting != 0) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            finishing._isCompleting = 1;
            if (finishing != incomplete2 && !_state$FU.compareAndSet(this, incomplete2, finishing)) {
                return JobSupportKt.COMPLETING_RETRY;
            }
            if (!DebugKt.ASSERTIONS_ENABLED || (!finishing.isSealed())) {
                boolean isCancelling = finishing.isCancelling();
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj2 instanceof CompletedExceptionally) ? null : obj2);
                if (completedExceptionally != null) {
                    finishing.addExceptionLocked(completedExceptionally.cause);
                }
                Throwable th = (Throwable) finishing._rootCause;
                if (!(true ^ isCancelling)) {
                    th = null;
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    public final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (MoreExecutors.invokeOnCompletion$default(childHandleNode.childJob, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, null) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }
}
