package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadState;

/* renamed from: -$$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3D-Lg  reason: invalid class name and default package */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg extends Lambda implements Function2<ThreadState, CoroutineContext.Element, ThreadState> {
    public static final $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg INSTANCE$0 = new $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg(0);
    public static final $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg INSTANCE$1 = new $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg(1);
    public final /* synthetic */ int $id$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public $$LambdaGroup$ks$pwVtDOF2QycU93vtnS_5uF3DLg(int i) {
        super(2);
        this.$id$ = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final ThreadState invoke(ThreadState threadState, CoroutineContext.Element element) {
        int i = this.$id$;
        if (i == 0) {
            ThreadState threadState2 = threadState;
            CoroutineContext.Element element2 = element;
            if (element2 instanceof ThreadContextElement) {
                CoroutineContext coroutineContext = threadState2.context;
                Object[] objArr = threadState2.a;
                int i2 = threadState2.i;
                threadState2.i = i2 + 1;
                ((ThreadContextElement) element2).restoreThreadContext(coroutineContext, objArr[i2]);
            }
            return threadState2;
        } else if (i == 1) {
            ThreadState threadState3 = threadState;
            CoroutineContext.Element element3 = element;
            if (element3 instanceof ThreadContextElement) {
                Object updateThreadContext = ((ThreadContextElement) element3).updateThreadContext(threadState3.context);
                Object[] objArr2 = threadState3.a;
                int i3 = threadState3.i;
                threadState3.i = i3 + 1;
                objArr2[i3] = updateThreadContext;
            }
            return threadState3;
        } else {
            throw null;
        }
    }
}
