package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ExceptionsConstuctor.kt */
public final class ExceptionsConstuctorKt {
    public static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();
    public static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    public static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "$this$kotlin");
        if (Reflection.factory != null) {
            new ClassReference(cls);
            int i2 = 0;
            while (true) {
                try {
                    Field[] declaredFields = cls.getDeclaredFields();
                    int length = declaredFields.length;
                    int i3 = 0;
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                            i3++;
                        }
                    }
                    i2 += i3;
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        break;
                    }
                } catch (Throwable th) {
                    obj = MoreExecutors.createFailure(th);
                }
            }
            obj = Integer.valueOf(i2);
            Object valueOf = Integer.valueOf(i);
            if (obj instanceof Result.Failure) {
                obj = valueOf;
            }
            return ((Number) obj).intValue();
        }
        throw null;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r9) {
        /*
        // Method dump skipped, instructions count: 393
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }
}
