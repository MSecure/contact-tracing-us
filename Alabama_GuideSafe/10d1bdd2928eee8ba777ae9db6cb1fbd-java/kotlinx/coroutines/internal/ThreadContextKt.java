package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
public final class ThreadContextKt {
    public static final Symbol ZERO = new Symbol("ZERO");
    public static final Function2<Object, CoroutineContext.Element, Object> countAll = ThreadContextKt$countAll$1.INSTANCE;
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = ThreadContextKt$findOne$1.INSTANCE;
    public static final Function2<ThreadState, CoroutineContext.Element, ThreadState> restoreState = $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg.INSTANCE$0;
    public static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg.INSTANCE$1;

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj != ZERO) {
            if (obj instanceof ThreadState) {
                ((ThreadState) obj).i = 0;
                coroutineContext.fold(obj, restoreState);
                return;
            }
            Object fold = coroutineContext.fold(null, findOne);
            if (fold != null) {
                ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, countAll);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
