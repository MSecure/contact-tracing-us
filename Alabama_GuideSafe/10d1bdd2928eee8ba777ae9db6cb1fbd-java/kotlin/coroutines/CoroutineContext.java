package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContext.kt */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        public static final class DefaultImpls {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return (R) function2.invoke(r, element);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.CoroutineContext$Element */
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Intrinsics.areEqual(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                Intrinsics.checkNotNullParameter(coroutineContext, "context");
                Intrinsics.checkNotNullParameter(coroutineContext, "context");
                return coroutineContext == EmptyCoroutineContext.INSTANCE ? element : (CoroutineContext) coroutineContext.fold(element, CoroutineContext$plus$1.INSTANCE);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
