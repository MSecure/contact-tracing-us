package com.proudcrowd.exposure.datasource;

import android.util.Log;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public abstract class BaseFuturesDataSource<InnerType> extends BaseDataSource<InnerType> {
    private static final String TAG = "BaseFuturesDataSource";

    /* access modifiers changed from: protected */
    public abstract Call<InnerType> CallApi();

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        ExecuteFutureRequest();
    }

    public ListenableFuture<InnerType> ExecuteFutureRequest() {
        return adaptCallToFuture(CallApi());
    }

    private ListenableFuture<InnerType> adaptCallToFuture(Call<InnerType> call) {
        final CallCancelListenableFuture callCancelListenableFuture = new CallCancelListenableFuture(call);
        call.enqueue(new Callback<InnerType>() {
            /* class com.proudcrowd.exposure.datasource.BaseFuturesDataSource.AnonymousClass1 */

            @Override // retrofit2.Callback
            public void onResponse(Call<InnerType> call, Response<InnerType> response) {
                if (response.isSuccessful()) {
                    InnerType body = response.body();
                    String str = BaseFuturesDataSource.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP API returned successfully. Value: ");
                    sb.append(body == null ? "Null" : body.toString());
                    Log.d(str, sb.toString());
                    callCancelListenableFuture.set(body);
                    return;
                }
                String str2 = BaseFuturesDataSource.TAG;
                Log.d(str2, "HTTP API returned error. Message: " + response.message());
                callCancelListenableFuture.setException(new HttpException(response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<InnerType> call, Throwable th) {
                String str = BaseFuturesDataSource.TAG;
                Log.d(str, "HTTP API failed. Message: " + th.getMessage());
                callCancelListenableFuture.setException(th);
            }
        });
        return callCancelListenableFuture;
    }

    /* access modifiers changed from: private */
    public static final class CallCancelListenableFuture<T> extends AbstractFuture<T> {
        private final Call<?> call;

        CallCancelListenableFuture(Call<?> call2) {
            this.call = call2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(T t) {
            return super.set(t);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean setException(Throwable th) {
            return super.setException(th);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void interruptTask() {
            this.call.cancel();
        }
    }
}
