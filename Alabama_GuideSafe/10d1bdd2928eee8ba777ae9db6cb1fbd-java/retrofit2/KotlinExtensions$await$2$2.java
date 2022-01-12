package retrofit2;

import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    public final /* synthetic */ CancellableContinuation $continuation;

    public KotlinExtensions$await$2$2(CancellableContinuation cancellableContinuation) {
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
        if (response.isSuccessful()) {
            T t = response.body;
            if (t == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag != null) {
                    Intrinsics.checkExpressionValueIsNotNull(tag, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((Invocation) tag).method;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    Intrinsics.checkExpressionValueIsNotNull(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    this.$continuation.resumeWith(MoreExecutors.createFailure(new KotlinNullPointerException(sb.toString())));
                    return;
                }
                Intrinsics.throwNpe();
                throw null;
            }
            this.$continuation.resumeWith(t);
            return;
        }
        this.$continuation.resumeWith(MoreExecutors.createFailure(new HttpException(response)));
    }
}
