package com.facebook.react.devsupport;

import com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;

@ReactModule(name = JSCHeapCapture.TAG, needsEagerInit = true)
public class JSCHeapCapture extends NativeJSCHeapCaptureSpec {
    public static final String TAG = "JSCHeapCapture";
    public CaptureCallback mCaptureInProgress = null;

    public interface CaptureCallback {
        void onFailure(CaptureException captureException);

        void onSuccess(File file);
    }

    public static class CaptureException extends Exception {
        public CaptureException(String str) {
            super(str);
        }

        public CaptureException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface HeapCapture extends JavaScriptModule {
        void captureHeap(String str);
    }

    public JSCHeapCapture(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec
    public synchronized void captureComplete(String str, String str2) {
        if (this.mCaptureInProgress != null) {
            if (str2 == null) {
                this.mCaptureInProgress.onSuccess(new File(str));
            } else {
                this.mCaptureInProgress.onFailure(new CaptureException(str2));
            }
            this.mCaptureInProgress = null;
        }
    }

    public synchronized void captureHeap(String str, CaptureCallback captureCallback) {
        if (this.mCaptureInProgress != null) {
            captureCallback.onFailure(new CaptureException("Heap capture already in progress."));
            return;
        }
        File file = new File(str + "/capture.json");
        file.delete();
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            HeapCapture heapCapture = (HeapCapture) reactApplicationContextIfActiveOrWarn.getJSModule(HeapCapture.class);
            if (heapCapture == null) {
                captureCallback.onFailure(new CaptureException("Heap capture js module not registered."));
            } else {
                this.mCaptureInProgress = captureCallback;
                heapCapture.captureHeap(file.getPath());
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }
}
