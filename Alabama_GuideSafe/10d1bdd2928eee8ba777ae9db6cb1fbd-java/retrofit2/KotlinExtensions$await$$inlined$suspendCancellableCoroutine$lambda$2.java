package retrofit2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_await$inlined.cancel();
        return Unit.INSTANCE;
    }
}
