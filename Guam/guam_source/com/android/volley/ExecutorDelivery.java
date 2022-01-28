package com.android.volley;

import android.os.Handler;
import com.android.volley.Response;
import java.util.concurrent.Executor;

public class ExecutorDelivery implements ResponseDelivery {
    public final Executor mResponsePoster;

    public static class ResponseDeliveryRunnable implements Runnable {
        public final Request mRequest;
        public final Response mResponse;
        public final Runnable mRunnable;

        public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
            this.mRequest = request;
            this.mResponse = response;
            this.mRunnable = runnable;
        }

        public void run() {
            Response.ErrorListener errorListener;
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("canceled-at-delivery");
                return;
            }
            if (this.mResponse.error == null) {
                this.mRequest.deliverResponse(this.mResponse.result);
            } else {
                Request request = this.mRequest;
                VolleyError volleyError = this.mResponse.error;
                synchronized (request.mLock) {
                    errorListener = request.mErrorListener;
                }
                if (errorListener != null) {
                    errorListener.onErrorResponse(volleyError);
                }
            }
            if (this.mResponse.intermediate) {
                this.mRequest.addMarker("intermediate-response");
            } else {
                this.mRequest.finish("done");
            }
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.mResponsePoster = new Executor(this) {
            /* class com.android.volley.ExecutorDelivery.AnonymousClass1 */

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        synchronized (request.mLock) {
            request.mResponseDelivered = true;
        }
        request.addMarker("post-response");
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(request, response, null));
    }
}
