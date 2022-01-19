package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class ResourcesCompat$FontCallback {
    public final void callbackFailAsync(final int i, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() {
            /* class androidx.core.content.res.ResourcesCompat$FontCallback.AnonymousClass2 */

            public void run() {
                ResourcesCompat$FontCallback.this.onFontRetrievalFailed(i);
            }
        });
    }

    public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() {
            /* class androidx.core.content.res.ResourcesCompat$FontCallback.AnonymousClass1 */

            public void run() {
                ResourcesCompat$FontCallback.this.onFontRetrieved(typeface);
            }
        });
    }

    public abstract void onFontRetrievalFailed(int i);

    public abstract void onFontRetrieved(Typeface typeface);
}
