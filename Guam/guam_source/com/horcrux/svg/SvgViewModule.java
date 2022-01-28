package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class SvgViewModule extends ReactContextBaseJavaModule {
    public SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void toDataURL(final int i, final ReadableMap readableMap, final Callback callback, final int i2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.horcrux.svg.SvgViewModule.AnonymousClass1 */

            public void run() {
                SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(i);
                if (svgViewByTag == null) {
                    SvgViewManager.runWhenViewIsAvailable(i, new Runnable() {
                        /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(i);
                            if (svgViewByTag != null) {
                                svgViewByTag.setToDataUrlTask(new Runnable() {
                                    /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        AnonymousClass1 r0 = AnonymousClass1.this;
                                        SvgViewModule.toDataURL(i, readableMap, callback, i2 + 1);
                                    }
                                });
                            }
                        }
                    });
                } else if (svgViewByTag.notRendered()) {
                    svgViewByTag.setToDataUrlTask(new Runnable() {
                        /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            SvgViewModule.toDataURL(i, readableMap, callback, i2 + 1);
                        }
                    });
                } else {
                    ReadableMap readableMap = readableMap;
                    if (readableMap != null) {
                        callback.invoke(svgViewByTag.toDataURL(readableMap.getInt(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH), readableMap.getInt(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)));
                        return;
                    }
                    callback.invoke(svgViewByTag.toDataURL());
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSVGSvgViewManager";
    }

    @ReactMethod
    public void toDataURL(int i, ReadableMap readableMap, Callback callback) {
        toDataURL(i, readableMap, callback, 0);
    }
}
