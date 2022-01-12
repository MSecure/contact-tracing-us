package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuationImpl.kt */
public final class InvokeOnCancel extends CancelHandler {
    public final Function1<Throwable, Unit> handler;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.handler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("InvokeOnCancel[");
        outline17.append(MoreExecutors.getClassSimpleName(this.handler));
        outline17.append('@');
        outline17.append(MoreExecutors.getHexAddress(this));
        outline17.append(']');
        return outline17.toString();
    }

    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
