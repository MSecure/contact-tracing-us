package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ExceptionsConstuctor.kt */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    public final /* synthetic */ Constructor $constructor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Throwable invoke(Throwable th) {
        Object obj;
        Throwable th2 = th;
        try {
            Object newInstance = this.$constructor$inlined.newInstance(th2.getMessage(), th2);
            if (newInstance != null) {
                obj = (Throwable) newInstance;
                if (obj instanceof Result.Failure) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th3) {
            obj = MoreExecutors.createFailure(th3);
        }
    }
}
