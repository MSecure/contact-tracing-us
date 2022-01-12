package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
public class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean handleJobException(Throwable th) {
        MoreExecutors.handleCoroutineException(this.context, th);
        return true;
    }
}
