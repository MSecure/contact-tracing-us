package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: Job.kt */
public interface Job extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: Job.kt */
    public static final class Key implements CoroutineContext.Key<Job> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();

        static {
            CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        }
    }

    ChildHandle attachChild(ChildJob childJob);

    CancellationException getCancellationException();

    DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean start();
}
