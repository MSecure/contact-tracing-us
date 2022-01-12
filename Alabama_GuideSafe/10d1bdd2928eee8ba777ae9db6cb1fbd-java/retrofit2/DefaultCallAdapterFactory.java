package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    public final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        public final Executor callbackExecutor;
        public final Call<T> delegate;

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // java.lang.Object, retrofit2.Call
        public Object clone() throws CloneNotSupportedException {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // retrofit2.Call
        public void enqueue(final Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                /* class retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 */

                public /* synthetic */ void lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Throwable th) {
                    callback.onFailure(ExecutorCallbackCall.this, th);
                }

                public /* synthetic */ void lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Response response) {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        callback.onResponse(ExecutorCallbackCall.this, response);
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<T> call, Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(callback, th) {
                        /* class retrofit2.$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$7JZMXmGMmuA6QMd5UmiN1rIhtW0 */
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Throwable f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
                        }
                    });
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<T> call, Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(callback, response) {
                        /* class retrofit2.$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$3wC8FyV4pyjrzrYL5U0mlYiviZw */
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Response f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // java.lang.Object, retrofit2.Call
        /* renamed from: clone  reason: collision with other method in class */
        public Call<T> m31clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (Utils.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>(this) {
                /* class retrofit2.DefaultCallAdapterFactory.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [retrofit2.Call] */
                @Override // retrofit2.CallAdapter
                public Call<?> adapt(Call<Object> call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }

                @Override // retrofit2.CallAdapter
                public Type responseType() {
                    return parameterUpperBound;
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
