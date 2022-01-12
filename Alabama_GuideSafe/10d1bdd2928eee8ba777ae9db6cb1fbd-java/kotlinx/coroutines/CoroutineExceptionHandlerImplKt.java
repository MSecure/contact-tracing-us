package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
public final class CoroutineExceptionHandlerImplKt {
    public static final List<CoroutineExceptionHandler> handlers;

    static {
        Iterator it = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullParameter(it, "$this$asSequence");
        SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it);
        Intrinsics.checkNotNullParameter(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1, "$this$constrainOnce");
        ConstrainedOnceSequence<Object> constrainedOnceSequence = sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 instanceof ConstrainedOnceSequence ? (ConstrainedOnceSequence) sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 : new ConstrainedOnceSequence(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
        Intrinsics.checkNotNullParameter(constrainedOnceSequence, "$this$toList");
        Intrinsics.checkNotNullParameter(constrainedOnceSequence, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(constrainedOnceSequence, "$this$toCollection");
        Intrinsics.checkNotNullParameter(arrayList, "destination");
        for (Object obj : constrainedOnceSequence) {
            arrayList.add(obj);
        }
        handlers = MoreExecutors.optimizeReadOnlyList(arrayList);
    }

    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext, Throwable th) {
        Throwable th2;
        for (CoroutineExceptionHandler coroutineExceptionHandler : handlers) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = currentThread.getUncaughtExceptionHandler();
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    MoreExecutors.addSuppressed(th2, th);
                }
                uncaughtExceptionHandler.uncaughtException(currentThread, th2);
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
