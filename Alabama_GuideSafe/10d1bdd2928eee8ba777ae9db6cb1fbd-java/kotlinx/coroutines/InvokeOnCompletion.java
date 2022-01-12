package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: JobSupport.kt */
public final class InvokeOnCompletion extends JobNode<Job> {
    public final Function1<Throwable, Unit> handler;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCompletion(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.handler = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.handler.invoke(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
