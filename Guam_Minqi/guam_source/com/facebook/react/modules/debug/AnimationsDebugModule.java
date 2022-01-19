package com.facebook.react.modules.debug;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@ReactModule(name = AnimationsDebugModule.NAME)
public class AnimationsDebugModule extends NativeAnimationsDebugModuleSpec {
    public static final String NAME = "AnimationsDebugModule";
    public final DeveloperSettings mCatalystSettings;
    public FpsDebugFrameCallback mFrameCallback;

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, DeveloperSettings developerSettings) {
        super(reactApplicationContext);
        this.mCatalystSettings = developerSettings;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            this.mFrameCallback = null;
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec
    public void startRecordingFps() {
        DeveloperSettings developerSettings = this.mCatalystSettings;
        if (developerSettings != null && developerSettings.isAnimationFpsDebugEnabled()) {
            if (this.mFrameCallback == null) {
                FpsDebugFrameCallback fpsDebugFrameCallback = new FpsDebugFrameCallback(getReactApplicationContext());
                this.mFrameCallback = fpsDebugFrameCallback;
                if (fpsDebugFrameCallback != null) {
                    fpsDebugFrameCallback.mTimeToFps = new TreeMap<>();
                    fpsDebugFrameCallback.mIsRecordingFpsInfoAtEachFrame = true;
                    fpsDebugFrameCallback.start();
                    return;
                }
                throw null;
            }
            throw new JSApplicationCausedNativeException("Already recording FPS!");
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec
    public void stopRecordingFps(double d) {
        FpsDebugFrameCallback.FpsInfo fpsInfo;
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            FpsDebugFrameCallback fpsDebugFrameCallback2 = this.mFrameCallback;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(fpsDebugFrameCallback2.mTimeToFps, "FPS was not recorded at each frame!");
            Map.Entry<Long, FpsDebugFrameCallback.FpsInfo> floorEntry = fpsDebugFrameCallback2.mTimeToFps.floorEntry(Long.valueOf((long) d));
            if (floorEntry == null) {
                fpsInfo = null;
            } else {
                fpsInfo = floorEntry.getValue();
            }
            if (fpsInfo == null) {
                Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
            } else {
                String str = String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", Double.valueOf(fpsInfo.fps), Integer.valueOf(fpsInfo.totalFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)) + "\n" + String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", Double.valueOf(fpsInfo.jsFps), Integer.valueOf(fpsInfo.totalJsFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)) + "\nTotal Time MS: " + String.format(Locale.US, "%d", Integer.valueOf(fpsInfo.totalTimeMs));
                FLog.d("ReactNative", str);
                Toast.makeText(getReactApplicationContext(), str, 1).show();
            }
            this.mFrameCallback = null;
        }
    }
}
