package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackTraceRecovery.kt */
public final class StackTraceRecoveryKt {
    public static final String baseContinuationImplClassName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str;
        String str2;
        String str3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        String str4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        try {
            str = Class.forName(str4).getCanonicalName();
        } catch (Throwable th) {
            str = MoreExecutors.createFailure(th);
        }
        if (Result.m10exceptionOrNullimpl(str) == null) {
            str4 = str;
        }
        baseContinuationImplClassName = str4;
        try {
            str2 = Class.forName(str3).getCanonicalName();
        } catch (Throwable th2) {
            str2 = MoreExecutors.createFailure(th2);
        }
        if (Result.m10exceptionOrNullimpl(str2) == null) {
            str3 = str2;
        }
    }

    public static final Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        Pair pair;
        Throwable tryCopyException;
        Pair pair2;
        boolean z;
        Throwable cause = th.getCause();
        int i = 0;
        if (cause == null || !Intrinsics.areEqual(cause.getClass(), th.getClass())) {
            pair2 = new Pair(th, new StackTraceElement[0]);
        } else {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (isArtificial(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                pair = new Pair(cause, stackTrace);
                A a = pair.first;
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.second;
                tryCopyException = ExceptionsConstuctorKt.tryCopyException(a);
                if (tryCopyException == null && !(!Intrinsics.areEqual(tryCopyException.getMessage(), a.getMessage()))) {
                    ArrayDeque arrayDeque = new ArrayDeque();
                    StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
                    if (stackTraceElement != null) {
                        arrayDeque.add(stackTraceElement);
                    }
                    while (true) {
                        coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                        if (coroutineStackFrame == null) {
                            break;
                        }
                        StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
                        if (stackTraceElement2 != null) {
                            arrayDeque.add(stackTraceElement2);
                        }
                    }
                    if (arrayDeque.isEmpty()) {
                        return th;
                    }
                    if (a != th) {
                        int length2 = stackTraceElementArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                i3 = -1;
                                break;
                            } else if (isArtificial(stackTraceElementArr[i3])) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        int i4 = i3 + 1;
                        int length3 = stackTraceElementArr.length - 1;
                        if (length3 >= i4) {
                            while (true) {
                                StackTraceElement stackTraceElement3 = stackTraceElementArr[length3];
                                StackTraceElement stackTraceElement4 = (StackTraceElement) arrayDeque.getLast();
                                if (stackTraceElement3.getLineNumber() == stackTraceElement4.getLineNumber() && Intrinsics.areEqual(stackTraceElement3.getMethodName(), stackTraceElement4.getMethodName()) && Intrinsics.areEqual(stackTraceElement3.getFileName(), stackTraceElement4.getFileName()) && Intrinsics.areEqual(stackTraceElement3.getClassName(), stackTraceElement4.getClassName())) {
                                    arrayDeque.removeLast();
                                }
                                arrayDeque.addFirst(stackTraceElementArr[length3]);
                                if (length3 == i4) {
                                    break;
                                }
                                length3--;
                            }
                        }
                    }
                    arrayDeque.addFirst(new StackTraceElement("\b\b\b(Coroutine boundary", "\b", "\b", -1));
                    StackTraceElement[] stackTrace2 = a.getStackTrace();
                    String str = baseContinuationImplClassName;
                    int length4 = stackTrace2.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length4) {
                            i5 = -1;
                            break;
                        } else if (Intrinsics.areEqual(str, stackTrace2[i5].getClassName())) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i5 == -1) {
                        Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
                        if (array != null) {
                            tryCopyException.setStackTrace((StackTraceElement[]) array);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[(arrayDeque.size() + i5)];
                        for (int i6 = 0; i6 < i5; i6++) {
                            stackTraceElementArr2[i6] = stackTrace2[i6];
                        }
                        Iterator it = arrayDeque.iterator();
                        while (it.hasNext()) {
                            stackTraceElementArr2[i5 + i] = (StackTraceElement) it.next();
                            i++;
                        }
                        tryCopyException.setStackTrace(stackTraceElementArr2);
                    }
                    return tryCopyException;
                }
            }
            pair2 = new Pair(th, new StackTraceElement[0]);
        }
        pair = pair2;
        A a2 = pair.first;
        StackTraceElement[] stackTraceElementArr3 = (StackTraceElement[]) pair.second;
        tryCopyException = ExceptionsConstuctorKt.tryCopyException(a2);
        return tryCopyException == null ? th : th;
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return MoreExecutors.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2);
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (isArtificial(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }
}
