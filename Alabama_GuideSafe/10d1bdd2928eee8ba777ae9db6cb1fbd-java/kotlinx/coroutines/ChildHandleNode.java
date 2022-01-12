package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;

/* compiled from: JobSupport.kt */
public final class ChildHandleNode extends JobCancellingNode<JobSupport> implements ChildHandle {
    public final ChildJob childJob;

    public ChildHandleNode(JobSupport jobSupport, ChildJob childJob2) {
        super(jobSupport);
        this.childJob = childJob2;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(Throwable th) {
        JobSupport jobSupport = (JobSupport) this.job;
        if (jobSupport == null) {
            throw null;
        } else if (th instanceof CancellationException) {
            return true;
        } else {
            return jobSupport.cancelImpl$kotlinx_coroutines_core(th);
        }
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
        this.childJob.parentCancelled((ParentJob) this.job);
    }
}
