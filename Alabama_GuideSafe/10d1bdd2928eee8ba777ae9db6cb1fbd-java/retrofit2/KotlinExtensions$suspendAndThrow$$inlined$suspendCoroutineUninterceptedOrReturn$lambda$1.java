package retrofit2;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.coroutines.Continuation;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    public final /* synthetic */ Continuation $continuation;
    public final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    public KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(Continuation continuation, Exception exc) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        MoreExecutors.intercepted(this.$continuation).resumeWith(MoreExecutors.createFailure(this.$this_suspendAndThrow$inlined));
    }
}
