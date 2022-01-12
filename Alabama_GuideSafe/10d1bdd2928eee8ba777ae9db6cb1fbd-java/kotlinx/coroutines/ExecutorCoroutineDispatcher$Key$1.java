package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Executors.kt */
public final class ExecutorCoroutineDispatcher$Key$1 extends Lambda implements Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher> {
    public static final ExecutorCoroutineDispatcher$Key$1 INSTANCE = new ExecutorCoroutineDispatcher$Key$1();

    public ExecutorCoroutineDispatcher$Key$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ExecutorCoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof ExecutorCoroutineDispatcher)) {
            element2 = null;
        }
        return (ExecutorCoroutineDispatcher) element2;
    }
}
