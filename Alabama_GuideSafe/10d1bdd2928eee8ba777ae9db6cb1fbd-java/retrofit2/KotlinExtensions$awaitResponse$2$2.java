package retrofit2;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    public final /* synthetic */ CancellableContinuation $continuation;

    public KotlinExtensions$awaitResponse$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(th, "t");
        this.$continuation.resumeWith(MoreExecutors.createFailure(th));
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(response, "response");
        this.$continuation.resumeWith(response);
    }
}
