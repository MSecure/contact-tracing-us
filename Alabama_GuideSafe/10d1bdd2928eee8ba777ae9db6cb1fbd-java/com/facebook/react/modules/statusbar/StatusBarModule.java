package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Map;

@ReactModule(name = StatusBarModule.NAME)
public class StatusBarModule extends NativeStatusBarManagerAndroidSpec {
    public static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
    public static final String HEIGHT_KEY = "HEIGHT";
    public static final String NAME = "StatusBarManager";

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public Map<String, Object> getTypedExportedConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Activity currentActivity = getCurrentActivity();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return AppCompatDelegateImpl.ConfigurationImplApi17.of(HEIGHT_KEY, Float.valueOf(identifier > 0 ? AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), DEFAULT_BACKGROUND_COLOR_KEY, currentActivity != null ? String.format("#%06X", Integer.valueOf(currentActivity.getWindow().getStatusBarColor() & 16777215)) : "black");
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setColor(double d, final boolean z) {
        final int i = (int) d;
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(this, getReactApplicationContext()) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass1 */

                @Override // com.facebook.react.bridge.GuardedRunnable
                @TargetApi(21)
                public void runGuarded() {
                    currentActivity.getWindow().addFlags(RecyclerView.UNDEFINED_DURATION);
                    if (z) {
                        int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(statusBarColor), Integer.valueOf(i));
                        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass1.AnonymousClass1 */

                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                currentActivity.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                        ofObject.setDuration(300L).setStartDelay(0);
                        ofObject.start();
                        return;
                    }
                    currentActivity.getWindow().setStatusBarColor(i);
                }
            });
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass3 */

                public void run() {
                    if (z) {
                        currentActivity.getWindow().addFlags(1024);
                        currentActivity.getWindow().clearFlags(2048);
                        return;
                    }
                    currentActivity.getWindow().addFlags(2048);
                    currentActivity.getWindow().clearFlags(1024);
                }
            });
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass4 */

                @TargetApi(23)
                public void run() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    decorView.setSystemUiVisibility("dark-content".equals(str) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
                }
            });
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(this, getReactApplicationContext()) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass2 */

                @Override // com.facebook.react.bridge.GuardedRunnable
                @TargetApi(21)
                public void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z) {
                        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) {
                            /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass2.AnonymousClass1 */

                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                                return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
                            }
                        });
                    } else {
                        decorView.setOnApplyWindowInsetsListener(null);
                    }
                    ViewCompat.requestApplyInsets(decorView);
                }
            });
        }
    }
}
