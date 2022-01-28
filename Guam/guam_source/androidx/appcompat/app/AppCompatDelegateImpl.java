package androidx.appcompat.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Property;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.InflateException;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.appcompat.widget.WithHint;
import androidx.collection.SimpleArrayMap;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.core.R$styleable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.provider.FontRequest;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat$OreoCallback;
import androidx.fragment.R$anim;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.FragmentContainer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import androidx.work.WorkInfo$State;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$FileDeleteException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.devsupport.FpsView;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.soloader.SoLoader;
import com.facebook.yoga.YogaMeasureMode;
import com.google.common.util.concurrent.ListenableFuture;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static final boolean IS_PRE_LOLLIPOP = false;
    public static final boolean sCanApplyOverrideConfiguration = true;
    public static final boolean sCanReturnDifferentContext = (!"robolectric".equals(Build.FINGERPRINT));
    public static boolean sInstalledExceptionHandler = true;
    public static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap<>();
    public static final int[] sWindowBackgroundStyleable = {16842836};
    public ActionBar mActionBar;
    public ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public boolean mActivityHandlesUiMode;
    public boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoNightModeManager mAutoBatteryNightModeManager;
    public AutoNightModeManager mAutoTimeNightModeManager;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mEnableDefaultActionBarUp;
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHandleNativeActionModes = true;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass2 */

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.mInvalidatePanelMenuFeatures & 4096) != 0) {
                appCompatDelegateImpl2.doInvalidatePanelMenu(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.mInvalidatePanelMenuPosted = false;
            appCompatDelegateImpl3.mInvalidatePanelMenuFeatures = 0;
        }
    };
    public boolean mIsDestroyed;
    public boolean mIsFloating;
    public int mLocalNightMode = -100;
    public boolean mLongPressBackDown;
    public MenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public Runnable mShowActionModePopup;
    public boolean mStarted;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4  reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup$OnFitSystemWindowsListener {
        public final /* synthetic */ AppCompatDelegateImpl this$0;
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback == null) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        public ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.mActionModeView != null) {
                appCompatDelegateImpl2.endOnGoingFadeAnimation();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl3.mActionModeView);
                animate.alpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                appCompatDelegateImpl3.mFadeAnim = animate;
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = AppCompatDelegateImpl.this.mFadeAnim;
                AnonymousClass1 r0 = new ViewPropertyAnimatorListenerAdapter() {
                    /* class androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.AnonymousClass1 */

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.mActionModeView.getParent());
                        }
                        AppCompatDelegateImpl.this.mActionModeView.removeAllViews();
                        AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.mFadeAnim = null;
                        ViewCompat.requestApplyInsets(appCompatDelegateImpl2.mSubDecor);
                    }
                };
                View view = viewPropertyAnimatorCompat.mView.get();
                if (view != null) {
                    viewPropertyAnimatorCompat.setListenerInternal(view, r0);
                }
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.mActionMode = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mSubDecor);
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || this.mWrapped.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean z;
            if (!this.mWrapped.dispatchKeyShortcutEvent(keyEvent)) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                int keyCode = keyEvent.getKeyCode();
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar == null || !actionBar.onKeyShortcut(keyCode, keyEvent)) {
                    PanelFeatureState panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState == null || !appCompatDelegateImpl.performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
                        if (appCompatDelegateImpl.mPreparedPanel == null) {
                            PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(0);
                            appCompatDelegateImpl.preparePanel(panelState, keyEvent);
                            boolean performPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
                            panelState.isPrepared = false;
                        }
                        z = false;
                        if (!z) {
                            return false;
                        }
                    } else {
                        PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.mPreparedPanel;
                        if (panelFeatureState2 != null) {
                            panelFeatureState2.isHandled = true;
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public boolean onMenuOpened(int i, Menu menu) {
            this.mWrapped.onMenuOpened(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl != null) {
                if (i == 108) {
                    appCompatDelegateImpl.initWindowDecorActionBar();
                    ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                    if (actionBar != null) {
                        actionBar.dispatchMenuVisibilityChanged(true);
                    }
                }
                return true;
            }
            throw null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public void onPanelClosed(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl == null) {
                throw null;
            } else if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                }
            } else if (i == 0) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
                if (panelState.isOpen) {
                    appCompatDelegateImpl.closePanel(panelState, false);
                }
            }
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            boolean onPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                this.mWrapped.onProvideKeyboardShortcuts(list, menuBuilder, i);
            } else {
                this.mWrapped.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.mHandleNativeActionModes || i != 0) {
                return this.mWrapped.onWindowStartingActionMode(callback, i);
            }
            return startAsSupportActionMode(callback);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
        public final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            androidx.appcompat.view.ActionMode actionMode;
            androidx.appcompat.view.ActionMode actionMode2;
            AppCompatCallback appCompatCallback;
            ContextThemeWrapper contextThemeWrapper;
            AppCompatCallback appCompatCallback2;
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.mContext, callback);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl != null) {
                androidx.appcompat.view.ActionMode actionMode3 = appCompatDelegateImpl.mActionMode;
                if (actionMode3 != null) {
                    actionMode3.finish();
                }
                ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callbackWrapper);
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    androidx.appcompat.view.ActionMode startActionMode = actionBar.startActionMode(actionModeCallbackWrapperV9);
                    appCompatDelegateImpl.mActionMode = startActionMode;
                    if (!(startActionMode == null || (appCompatCallback2 = appCompatDelegateImpl.mAppCompatCallback) == null)) {
                        appCompatCallback2.onSupportActionModeStarted(startActionMode);
                    }
                }
                if (appCompatDelegateImpl.mActionMode == null) {
                    appCompatDelegateImpl.endOnGoingFadeAnimation();
                    androidx.appcompat.view.ActionMode actionMode4 = appCompatDelegateImpl.mActionMode;
                    if (actionMode4 != null) {
                        actionMode4.finish();
                    }
                    AppCompatCallback appCompatCallback3 = appCompatDelegateImpl.mAppCompatCallback;
                    if (appCompatCallback3 != null && !appCompatDelegateImpl.mIsDestroyed) {
                        try {
                            actionMode = appCompatCallback3.onWindowStartingSupportActionMode(actionModeCallbackWrapperV9);
                        } catch (AbstractMethodError unused) {
                        }
                        if (actionMode == null) {
                            appCompatDelegateImpl.mActionMode = actionMode;
                        } else {
                            boolean z = true;
                            if (appCompatDelegateImpl.mActionModeView == null) {
                                if (appCompatDelegateImpl.mIsFloating) {
                                    TypedValue typedValue = new TypedValue();
                                    Resources.Theme theme = appCompatDelegateImpl.mContext.getTheme();
                                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                                    if (typedValue.resourceId != 0) {
                                        Resources.Theme newTheme = appCompatDelegateImpl.mContext.getResources().newTheme();
                                        newTheme.setTo(theme);
                                        newTheme.applyStyle(typedValue.resourceId, true);
                                        ContextThemeWrapper contextThemeWrapper2 = new ContextThemeWrapper(appCompatDelegateImpl.mContext, 0);
                                        contextThemeWrapper2.getTheme().setTo(newTheme);
                                        contextThemeWrapper = contextThemeWrapper2;
                                    } else {
                                        contextThemeWrapper = appCompatDelegateImpl.mContext;
                                    }
                                    appCompatDelegateImpl.mActionModeView = new ActionBarContextView(contextThemeWrapper, null);
                                    PopupWindow popupWindow = new PopupWindow(contextThemeWrapper, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                                    appCompatDelegateImpl.mActionModePopup = popupWindow;
                                    popupWindow.setWindowLayoutType(2);
                                    appCompatDelegateImpl.mActionModePopup.setContentView(appCompatDelegateImpl.mActionModeView);
                                    appCompatDelegateImpl.mActionModePopup.setWidth(-1);
                                    contextThemeWrapper.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                                    appCompatDelegateImpl.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                                    appCompatDelegateImpl.mActionModePopup.setHeight(-2);
                                    appCompatDelegateImpl.mShowActionModePopup = new Runnable() {
                                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6 */

                                        public void run() {
                                            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                                            appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
                                            AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
                                            if (AppCompatDelegateImpl.this.shouldAnimateActionModeView()) {
                                                AppCompatDelegateImpl.this.mActionModeView.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                                                ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView);
                                                animate.alpha(1.0f);
                                                appCompatDelegateImpl2.mFadeAnim = animate;
                                                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = AppCompatDelegateImpl.this.mFadeAnim;
                                                AnonymousClass1 r1 = new ViewPropertyAnimatorListenerAdapter() {
                                                    /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6.AnonymousClass1 */

                                                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                                                    public void onAnimationEnd(View view) {
                                                        AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                                                        AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                                                        AppCompatDelegateImpl.this.mFadeAnim = null;
                                                    }

                                                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                                    public void onAnimationStart(View view) {
                                                        AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                                                    }
                                                };
                                                View view = viewPropertyAnimatorCompat.mView.get();
                                                if (view != null) {
                                                    viewPropertyAnimatorCompat.setListenerInternal(view, r1);
                                                    return;
                                                }
                                                return;
                                            }
                                            AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                                            AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                                        }
                                    };
                                } else {
                                    ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImpl.mSubDecor.findViewById(R$id.action_mode_bar_stub);
                                    if (viewStubCompat != null) {
                                        appCompatDelegateImpl.initWindowDecorActionBar();
                                        ActionBar actionBar2 = appCompatDelegateImpl.mActionBar;
                                        Context themedContext = actionBar2 != null ? actionBar2.getThemedContext() : null;
                                        if (themedContext == null) {
                                            themedContext = appCompatDelegateImpl.mContext;
                                        }
                                        viewStubCompat.setLayoutInflater(LayoutInflater.from(themedContext));
                                        appCompatDelegateImpl.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                                    }
                                }
                            }
                            if (appCompatDelegateImpl.mActionModeView != null) {
                                appCompatDelegateImpl.endOnGoingFadeAnimation();
                                appCompatDelegateImpl.mActionModeView.killMode();
                                Context context = appCompatDelegateImpl.mActionModeView.getContext();
                                ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
                                if (appCompatDelegateImpl.mActionModePopup != null) {
                                    z = false;
                                }
                                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(context, actionBarContextView, actionModeCallbackWrapperV9, z);
                                if (actionModeCallbackWrapperV9.onCreateActionMode(standaloneActionMode, standaloneActionMode.mMenu)) {
                                    standaloneActionMode.invalidate();
                                    appCompatDelegateImpl.mActionModeView.initForMode(standaloneActionMode);
                                    appCompatDelegateImpl.mActionMode = standaloneActionMode;
                                    if (appCompatDelegateImpl.shouldAnimateActionModeView()) {
                                        appCompatDelegateImpl.mActionModeView.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                        ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
                                        animate.alpha(1.0f);
                                        appCompatDelegateImpl.mFadeAnim = animate;
                                        AnonymousClass7 r3 = new ViewPropertyAnimatorListenerAdapter() {
                                            /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass7 */

                                            @Override // androidx.core.view.ViewPropertyAnimatorListener
                                            public void onAnimationEnd(View view) {
                                                AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                                                AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                                                AppCompatDelegateImpl.this.mFadeAnim = null;
                                            }

                                            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                            public void onAnimationStart(View view) {
                                                AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                                                AppCompatDelegateImpl.this.mActionModeView.sendAccessibilityEvent(32);
                                                if (AppCompatDelegateImpl.this.mActionModeView.getParent() instanceof View) {
                                                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.mActionModeView.getParent());
                                                }
                                            }
                                        };
                                        View view = animate.mView.get();
                                        if (view != null) {
                                            animate.setListenerInternal(view, r3);
                                        }
                                    } else {
                                        appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                                        appCompatDelegateImpl.mActionModeView.setVisibility(0);
                                        appCompatDelegateImpl.mActionModeView.sendAccessibilityEvent(32);
                                        if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                                            ((View) appCompatDelegateImpl.mActionModeView.getParent()).requestApplyInsets();
                                        }
                                    }
                                    if (appCompatDelegateImpl.mActionModePopup != null) {
                                        appCompatDelegateImpl.mWindow.getDecorView().post(appCompatDelegateImpl.mShowActionModePopup);
                                    }
                                } else {
                                    appCompatDelegateImpl.mActionMode = null;
                                }
                            }
                        }
                        actionMode2 = appCompatDelegateImpl.mActionMode;
                        if (!(actionMode2 == null || (appCompatCallback = appCompatDelegateImpl.mAppCompatCallback) == null)) {
                            appCompatCallback.onSupportActionModeStarted(actionMode2);
                        }
                        appCompatDelegateImpl.mActionMode = appCompatDelegateImpl.mActionMode;
                    }
                    actionMode = null;
                    if (actionMode == null) {
                    }
                    actionMode2 = appCompatDelegateImpl.mActionMode;
                    appCompatCallback.onSupportActionModeStarted(actionMode2);
                    appCompatDelegateImpl.mActionMode = appCompatDelegateImpl.mActionMode;
                }
                androidx.appcompat.view.ActionMode actionMode5 = appCompatDelegateImpl.mActionMode;
                if (actionMode5 != null) {
                    return callbackWrapper.getActionModeWrapper(actionMode5);
                }
                return null;
            }
            throw null;
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        public final PowerManager mPowerManager;

        public AutoBatteryNightModeManager(Context context) {
            super();
            this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return this.mPowerManager.isPowerSaveMode() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    public abstract class AutoNightModeManager {
        public BroadcastReceiver mReceiver;

        public AutoNightModeManager() {
        }

        public void cleanup() {
            BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.mContext.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public abstract void onChange();

        public void setup() {
            cleanup();
            IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
            if (createIntentFilterForBroadcastReceiver != null && createIntentFilterForBroadcastReceiver.countActions() != 0) {
                if (this.mReceiver == null) {
                    this.mReceiver = new BroadcastReceiver() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.AnonymousClass1 */

                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.onChange();
                        }
                    };
                }
                AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
            }
        }
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        public final TwilightManager mTwilightManager;

        public AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.mTwilightManager = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00e2  */
        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            boolean z;
            Location location;
            long j;
            TwilightManager twilightManager = this.mTwilightManager;
            TwilightManager.TwilightState twilightState = twilightManager.mTwilightState;
            if (twilightState.nextUpdate > System.currentTimeMillis()) {
                z = twilightState.isNight;
            } else {
                Location location2 = null;
                if (ConfigurationImplApi17.checkSelfPermission(twilightManager.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (twilightManager.mLocationManager.isProviderEnabled("network")) {
                            location = twilightManager.mLocationManager.getLastKnownLocation("network");
                            if (ConfigurationImplApi17.checkSelfPermission(twilightManager.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                try {
                                    if (twilightManager.mLocationManager.isProviderEnabled("gps")) {
                                        location2 = twilightManager.mLocationManager.getLastKnownLocation("gps");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                                location = location2;
                            }
                            if (location == null) {
                                TwilightManager.TwilightState twilightState2 = twilightManager.mTwilightState;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (TwilightCalculator.sInstance == null) {
                                    TwilightCalculator.sInstance = new TwilightCalculator();
                                }
                                TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                                twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                                twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
                                boolean z2 = twilightCalculator.state == 1;
                                long j2 = twilightCalculator.sunrise;
                                long j3 = twilightCalculator.sunset;
                                twilightCalculator.calculateTwilight(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                                long j4 = twilightCalculator.sunrise;
                                if (j2 == -1 || j3 == -1) {
                                    j = currentTimeMillis + 43200000;
                                } else {
                                    j = (currentTimeMillis > j3 ? j4 + 0 : currentTimeMillis > j2 ? j3 + 0 : j2 + 0) + RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
                                }
                                twilightState2.isNight = z2;
                                twilightState2.nextUpdate = j;
                                z = twilightState.isNight;
                            } else {
                                Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                                int i = Calendar.getInstance().get(11);
                                z = i < 6 || i >= 22;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                location = null;
                if (ConfigurationImplApi17.checkSelfPermission(twilightManager.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            if (z) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    public static class ConfigurationImplApi17 {
        public static Field sDrawableCacheField;
        public static boolean sDrawableCacheFieldFetched;
        public static boolean sInitialized;
        public static ScheduledExecutorService sJobStarterExecutor;
        public static Field sResourcesImplField;
        public static boolean sResourcesImplFieldFetched;
        public static DisplayMetrics sScreenDisplayMetrics;
        public static Class<?> sThemedResourceCacheClazz;
        public static boolean sThemedResourceCacheClazzFetched;
        public static Field sThemedResourceCache_mUnthemedEntriesField;
        public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
        public static DisplayMetrics sWindowDisplayMetrics;

        public static int adjustByteCount(int i, int i2, int i3) {
            return Math.min(Math.max(0, i3 - i), i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01ef, code lost:
            if (r2.mVerticalChainStyle == 2) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x02c1, code lost:
            if (r5[r16].mTarget.mOwner == r6) goto L_0x02c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x013e, code lost:
            if (r4[r2].mTarget.mOwner == r5) goto L_0x0142;
         */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x0200  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x0342  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x036a  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x037a  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x0491 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:264:0x04fe A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:323:0x05f8  */
        /* JADX WARNING: Removed duplicated region for block: B:330:0x060f  */
        /* JADX WARNING: Removed duplicated region for block: B:336:0x061c  */
        /* JADX WARNING: Removed duplicated region for block: B:379:0x06e7  */
        /* JADX WARNING: Removed duplicated region for block: B:392:0x0737  */
        /* JADX WARNING: Removed duplicated region for block: B:393:0x073a  */
        /* JADX WARNING: Removed duplicated region for block: B:396:0x0740  */
        /* JADX WARNING: Removed duplicated region for block: B:397:0x0743  */
        /* JADX WARNING: Removed duplicated region for block: B:399:0x0747  */
        /* JADX WARNING: Removed duplicated region for block: B:403:0x0756  */
        /* JADX WARNING: Removed duplicated region for block: B:405:0x0759  */
        /* JADX WARNING: Removed duplicated region for block: B:429:0x05fa A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0112  */
        public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
            int i2;
            ChainHead[] chainHeadArr;
            int i3;
            boolean z;
            boolean z2;
            int i4;
            float f;
            boolean z3;
            boolean z4;
            boolean z5;
            int i5;
            ConstraintWidget constraintWidget;
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor;
            int i6;
            ConstraintAnchor constraintAnchor2;
            SolverVariable solverVariable;
            SolverVariable solverVariable2;
            int i7;
            ConstraintWidget constraintWidget3;
            ConstraintAnchor constraintAnchor3;
            ConstraintAnchor constraintAnchor4;
            ConstraintAnchor constraintAnchor5;
            ConstraintWidget constraintWidget4;
            int i8;
            int i9;
            ConstraintWidget constraintWidget5;
            SolverVariable solverVariable3;
            SolverVariable solverVariable4;
            ConstraintAnchor constraintAnchor6;
            ConstraintWidget constraintWidget6;
            int i10;
            ConstraintWidget constraintWidget7;
            ConstraintWidget constraintWidget8;
            ConstraintAnchor constraintAnchor7;
            SolverVariable solverVariable5;
            SolverVariable solverVariable6;
            float f2;
            int size;
            int i11;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            int i12;
            float f3;
            ArrayList<ConstraintWidget> arrayList;
            boolean z6;
            float f4;
            ConstraintWidget constraintWidget9;
            int i13;
            boolean z7;
            ChainHead[] chainHeadArr2;
            ConstraintWidget constraintWidget10;
            ConstraintWidget constraintWidget11;
            ConstraintWidget constraintWidget12;
            int i14;
            boolean z8;
            boolean z9;
            ConstraintWidget constraintWidget13;
            boolean z10;
            ConstraintWidget constraintWidget14;
            int i15;
            ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            int i16 = 2;
            if (i == 0) {
                i3 = constraintWidgetContainer2.mHorizontalChainsSize;
                chainHeadArr = constraintWidgetContainer2.mHorizontalChainsArray;
                i2 = 0;
            } else {
                i3 = constraintWidgetContainer2.mVerticalChainsSize;
                chainHeadArr = constraintWidgetContainer2.mVerticalChainsArray;
                i2 = 2;
            }
            int i17 = 0;
            while (i17 < i3) {
                ChainHead chainHead = chainHeadArr[i17];
                SolverVariable solverVariable7 = null;
                int i18 = 8;
                int i19 = 1;
                if (!chainHead.mDefined) {
                    int i20 = chainHead.mOrientation * i16;
                    ConstraintWidget constraintWidget15 = chainHead.mFirst;
                    ConstraintWidget constraintWidget16 = constraintWidget15;
                    boolean z11 = false;
                    while (!z11) {
                        chainHead.mWidgetsCount += i19;
                        ConstraintWidget[] constraintWidgetArr = constraintWidget15.mNextChainWidget;
                        int i21 = chainHead.mOrientation;
                        constraintWidgetArr[i21] = null;
                        constraintWidget15.mListNextMatchConstraintsWidget[i21] = null;
                        if (constraintWidget15.mVisibility != i18) {
                            chainHead.mVisibleWidgets += i19;
                            if (constraintWidget15.getDimensionBehaviour(i21) != dimensionBehaviour2) {
                                int i22 = chainHead.mTotalSize;
                                int i23 = chainHead.mOrientation;
                                if (i23 == 0) {
                                    i15 = constraintWidget15.getWidth();
                                } else {
                                    i15 = i23 == i19 ? constraintWidget15.getHeight() : 0;
                                }
                                chainHead.mTotalSize = i22 + i15;
                            }
                            int margin = constraintWidget15.mListAnchors[i20].getMargin() + chainHead.mTotalSize;
                            chainHead.mTotalSize = margin;
                            int i24 = i20 + 1;
                            chainHead.mTotalSize = constraintWidget15.mListAnchors[i24].getMargin() + margin;
                            int margin2 = constraintWidget15.mListAnchors[i20].getMargin() + chainHead.mTotalMargins;
                            chainHead.mTotalMargins = margin2;
                            chainHead.mTotalMargins = constraintWidget15.mListAnchors[i24].getMargin() + margin2;
                            if (chainHead.mFirstVisibleWidget == null) {
                                chainHead.mFirstVisibleWidget = constraintWidget15;
                            }
                            chainHead.mLastVisibleWidget = constraintWidget15;
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget15.mListDimensionBehaviors;
                            int i25 = chainHead.mOrientation;
                            if (dimensionBehaviourArr[i25] == dimensionBehaviour2) {
                                int[] iArr = constraintWidget15.mResolvedMatchConstraintDefault;
                                if (iArr[i25] == 0 || iArr[i25] == 3 || iArr[i25] == i16) {
                                    chainHead.mWidgetsMatchCount++;
                                    float[] fArr = constraintWidget15.mWeight;
                                    int i26 = chainHead.mOrientation;
                                    float f5 = fArr[i26];
                                    if (f5 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                        chainHead.mTotalWeight += fArr[i26];
                                    }
                                    int i27 = chainHead.mOrientation;
                                    if (constraintWidget15.mVisibility != 8 && constraintWidget15.mListDimensionBehaviors[i27] == dimensionBehaviour2) {
                                        int[] iArr2 = constraintWidget15.mResolvedMatchConstraintDefault;
                                        if (iArr2[i27] == 0 || iArr2[i27] == 3) {
                                            z10 = true;
                                            if (z10) {
                                                if (f5 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                    chainHead.mHasUndefinedWeights = true;
                                                } else {
                                                    chainHead.mHasDefinedWeights = true;
                                                }
                                                if (chainHead.mWeightedMatchConstraintsWidgets == null) {
                                                    chainHead.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                                                }
                                                chainHead.mWeightedMatchConstraintsWidgets.add(constraintWidget15);
                                            }
                                            if (chainHead.mFirstMatchConstraintWidget == null) {
                                                chainHead.mFirstMatchConstraintWidget = constraintWidget15;
                                            }
                                            constraintWidget14 = chainHead.mLastMatchConstraintWidget;
                                            if (constraintWidget14 != null) {
                                                constraintWidget14.mListNextMatchConstraintsWidget[chainHead.mOrientation] = constraintWidget15;
                                            }
                                            chainHead.mLastMatchConstraintWidget = constraintWidget15;
                                        }
                                    }
                                    z10 = false;
                                    if (z10) {
                                    }
                                    if (chainHead.mFirstMatchConstraintWidget == null) {
                                    }
                                    constraintWidget14 = chainHead.mLastMatchConstraintWidget;
                                    if (constraintWidget14 != null) {
                                    }
                                    chainHead.mLastMatchConstraintWidget = constraintWidget15;
                                }
                                int i28 = chainHead.mOrientation;
                            }
                        }
                        if (constraintWidget16 != constraintWidget15) {
                            constraintWidget16.mNextChainWidget[chainHead.mOrientation] = constraintWidget15;
                        }
                        ConstraintAnchor constraintAnchor8 = constraintWidget15.mListAnchors[i20 + 1].mTarget;
                        if (constraintAnchor8 != null) {
                            constraintWidget13 = constraintAnchor8.mOwner;
                            ConstraintAnchor[] constraintAnchorArr = constraintWidget13.mListAnchors;
                            if (constraintAnchorArr[i20].mTarget != null) {
                            }
                        }
                        constraintWidget13 = null;
                        if (constraintWidget13 == null) {
                            constraintWidget13 = constraintWidget15;
                            z11 = true;
                        }
                        constraintWidget16 = constraintWidget15;
                        i19 = 1;
                        i18 = 8;
                        i16 = 2;
                        constraintWidget15 = constraintWidget13;
                    }
                    ConstraintWidget constraintWidget17 = chainHead.mFirstVisibleWidget;
                    if (constraintWidget17 != null) {
                        chainHead.mTotalSize -= constraintWidget17.mListAnchors[i20].getMargin();
                    }
                    ConstraintWidget constraintWidget18 = chainHead.mLastVisibleWidget;
                    if (constraintWidget18 != null) {
                        chainHead.mTotalSize -= constraintWidget18.mListAnchors[i20 + 1].getMargin();
                    }
                    chainHead.mLast = constraintWidget15;
                    if (chainHead.mOrientation != 0 || !chainHead.mIsRtl) {
                        chainHead.mHead = chainHead.mFirst;
                    } else {
                        chainHead.mHead = constraintWidget15;
                    }
                    chainHead.mHasComplexMatchWeights = chainHead.mHasDefinedWeights && chainHead.mHasUndefinedWeights;
                    z = true;
                } else {
                    z = true;
                }
                chainHead.mDefined = z;
                ConstraintWidget constraintWidget19 = chainHead.mFirst;
                ConstraintWidget constraintWidget20 = chainHead.mLast;
                ConstraintWidget constraintWidget21 = chainHead.mFirstVisibleWidget;
                ConstraintWidget constraintWidget22 = chainHead.mLastVisibleWidget;
                ConstraintWidget constraintWidget23 = chainHead.mHead;
                float f6 = chainHead.mTotalWeight;
                boolean z12 = constraintWidgetContainer2.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (i == 0) {
                    z8 = constraintWidget23.mHorizontalChainStyle == 0;
                    f = f6;
                    boolean z13 = constraintWidget23.mHorizontalChainStyle == 1;
                    if (constraintWidget23.mHorizontalChainStyle == 2) {
                        z9 = z13;
                        i4 = i17;
                    } else {
                        z9 = z13;
                        i4 = i17;
                        z3 = z9;
                        z2 = z8;
                        z4 = false;
                        ConstraintWidget constraintWidget24 = constraintWidget19;
                        z5 = false;
                        while (!z5) {
                            ConstraintAnchor constraintAnchor9 = constraintWidget24.mListAnchors[i2];
                            int i29 = z4 ? 1 : 4;
                            int margin3 = constraintAnchor9.getMargin();
                            if (constraintWidget24.mListDimensionBehaviors[i] == dimensionBehaviour2 && constraintWidget24.mResolvedMatchConstraintDefault[i] == 0) {
                                i13 = i3;
                                z7 = true;
                            } else {
                                i13 = i3;
                                z7 = false;
                            }
                            ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                            if (!(constraintAnchor10 == null || constraintWidget24 == constraintWidget19)) {
                                margin3 = constraintAnchor10.getMargin() + margin3;
                            }
                            if (!z4 || constraintWidget24 == constraintWidget19 || constraintWidget24 == constraintWidget21) {
                                chainHeadArr2 = chainHeadArr;
                            } else {
                                chainHeadArr2 = chainHeadArr;
                                i29 = 5;
                            }
                            ConstraintAnchor constraintAnchor11 = constraintAnchor9.mTarget;
                            if (constraintAnchor11 != null) {
                                if (constraintWidget24 == constraintWidget21) {
                                    constraintWidget11 = constraintWidget23;
                                    constraintWidget10 = constraintWidget19;
                                    linearSystem.addGreaterThan(constraintAnchor9.mSolverVariable, constraintAnchor11.mSolverVariable, margin3, 6);
                                } else {
                                    constraintWidget11 = constraintWidget23;
                                    constraintWidget10 = constraintWidget19;
                                    linearSystem.addGreaterThan(constraintAnchor9.mSolverVariable, constraintAnchor11.mSolverVariable, margin3, 8);
                                }
                                linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor9.mTarget.mSolverVariable, margin3, (!z7 || z4) ? i29 : 5);
                            } else {
                                constraintWidget11 = constraintWidget23;
                                constraintWidget10 = constraintWidget19;
                            }
                            if (z12) {
                                if (constraintWidget24.mVisibility == 8 || constraintWidget24.mListDimensionBehaviors[i] != dimensionBehaviour2) {
                                    i14 = 0;
                                } else {
                                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget24.mListAnchors;
                                    i14 = 0;
                                    linearSystem.addGreaterThan(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 5);
                                }
                                linearSystem.addGreaterThan(constraintWidget24.mListAnchors[i2].mSolverVariable, constraintWidgetContainer2.mListAnchors[i2].mSolverVariable, i14, 8);
                            }
                            ConstraintAnchor constraintAnchor12 = constraintWidget24.mListAnchors[i2 + 1].mTarget;
                            if (constraintAnchor12 != null) {
                                constraintWidget12 = constraintAnchor12.mOwner;
                                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget12.mListAnchors;
                                if (constraintAnchorArr3[i2].mTarget != null) {
                                }
                            }
                            constraintWidget12 = null;
                            if (constraintWidget12 != null) {
                                constraintWidget24 = constraintWidget12;
                                z5 = z5;
                            } else {
                                z5 = true;
                            }
                            chainHeadArr = chainHeadArr2;
                            i3 = i13;
                            constraintWidget23 = constraintWidget11;
                            constraintWidget19 = constraintWidget10;
                        }
                        if (constraintWidget22 != null) {
                            int i30 = i2 + 1;
                            if (constraintWidget20.mListAnchors[i30].mTarget != null) {
                                ConstraintAnchor constraintAnchor13 = constraintWidget22.mListAnchors[i30];
                                if ((constraintWidget22.mListDimensionBehaviors[i] == dimensionBehaviour2 && constraintWidget22.mResolvedMatchConstraintDefault[i] == 0) && !z4) {
                                    ConstraintAnchor constraintAnchor14 = constraintAnchor13.mTarget;
                                    if (constraintAnchor14.mOwner == constraintWidgetContainer2) {
                                        linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor14.mSolverVariable, -constraintAnchor13.getMargin(), 5);
                                        linearSystem.addLowerThan(constraintAnchor13.mSolverVariable, constraintWidget20.mListAnchors[i30].mTarget.mSolverVariable, -constraintAnchor13.getMargin(), 6);
                                        if (z12) {
                                            int i31 = i2 + 1;
                                            SolverVariable solverVariable8 = constraintWidgetContainer2.mListAnchors[i31].mSolverVariable;
                                            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget20.mListAnchors;
                                            linearSystem.addGreaterThan(solverVariable8, constraintAnchorArr4[i31].mSolverVariable, constraintAnchorArr4[i31].getMargin(), 8);
                                        }
                                        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
                                        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                                            float f7 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f : (float) chainHead.mWidgetsMatchCount;
                                            ConstraintWidget constraintWidget25 = null;
                                            float f8 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                            i11 = 0;
                                            while (i11 < size) {
                                                ConstraintWidget constraintWidget26 = arrayList2.get(i11);
                                                float f9 = constraintWidget26.mWeight[i];
                                                if (f9 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                    arrayList = arrayList2;
                                                    f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                                } else if (chainHead.mHasComplexMatchWeights) {
                                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget26.mListAnchors;
                                                    arrayList = arrayList2;
                                                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 4);
                                                    z6 = false;
                                                    i12 = size;
                                                    f3 = f7;
                                                    dimensionBehaviour = dimensionBehaviour2;
                                                    i11++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i12;
                                                    dimensionBehaviour2 = dimensionBehaviour;
                                                } else {
                                                    arrayList = arrayList2;
                                                    f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                                    f9 = 1.0f;
                                                }
                                                int i32 = (f9 > f4 ? 1 : (f9 == f4 ? 0 : -1));
                                                if (i32 == 0) {
                                                    ConstraintAnchor[] constraintAnchorArr6 = constraintWidget26.mListAnchors;
                                                    z6 = false;
                                                    linearSystem.addEquality(constraintAnchorArr6[i2 + 1].mSolverVariable, constraintAnchorArr6[i2].mSolverVariable, 0, 8);
                                                    i12 = size;
                                                    f3 = f7;
                                                    dimensionBehaviour = dimensionBehaviour2;
                                                    i11++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i12;
                                                    dimensionBehaviour2 = dimensionBehaviour;
                                                } else {
                                                    if (constraintWidget25 != null) {
                                                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget25.mListAnchors;
                                                        SolverVariable solverVariable9 = constraintAnchorArr7[i2].mSolverVariable;
                                                        int i33 = i2 + 1;
                                                        SolverVariable solverVariable10 = constraintAnchorArr7[i33].mSolverVariable;
                                                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget26.mListAnchors;
                                                        i12 = size;
                                                        SolverVariable solverVariable11 = constraintAnchorArr8[i2].mSolverVariable;
                                                        SolverVariable solverVariable12 = constraintAnchorArr8[i33].mSolverVariable;
                                                        constraintWidget9 = constraintWidget26;
                                                        ArrayRow createRow = linearSystem.createRow();
                                                        dimensionBehaviour = dimensionBehaviour2;
                                                        createRow.constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                                        if (f7 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f8 == f9) {
                                                            f3 = f7;
                                                            createRow.variables.put(solverVariable9, 1.0f);
                                                            createRow.variables.put(solverVariable10, -1.0f);
                                                            createRow.variables.put(solverVariable12, 1.0f);
                                                            createRow.variables.put(solverVariable11, -1.0f);
                                                        } else {
                                                            if (f8 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                                createRow.variables.put(solverVariable9, 1.0f);
                                                                createRow.variables.put(solverVariable10, -1.0f);
                                                            } else if (i32 == 0) {
                                                                createRow.variables.put(solverVariable11, 1.0f);
                                                                createRow.variables.put(solverVariable12, -1.0f);
                                                            } else {
                                                                float f10 = (f8 / f7) / (f9 / f7);
                                                                f3 = f7;
                                                                createRow.variables.put(solverVariable9, 1.0f);
                                                                createRow.variables.put(solverVariable10, -1.0f);
                                                                createRow.variables.put(solverVariable12, f10);
                                                                createRow.variables.put(solverVariable11, -f10);
                                                            }
                                                            f3 = f7;
                                                        }
                                                        linearSystem.addConstraint(createRow);
                                                    } else {
                                                        i12 = size;
                                                        constraintWidget9 = constraintWidget26;
                                                        f3 = f7;
                                                        dimensionBehaviour = dimensionBehaviour2;
                                                    }
                                                    f8 = f9;
                                                    constraintWidget25 = constraintWidget9;
                                                    i11++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i12;
                                                    dimensionBehaviour2 = dimensionBehaviour;
                                                }
                                            }
                                        }
                                        int i34 = 4;
                                        if (constraintWidget21 != null || (constraintWidget21 != constraintWidget22 && !z4)) {
                                            constraintWidget2 = constraintWidget22;
                                            constraintWidget = constraintWidget21;
                                            i7 = i4;
                                            i5 = 2;
                                            if (z2 || constraintWidget == null) {
                                                i4 = i7;
                                                int i35 = 8;
                                                if (z3 && constraintWidget != null) {
                                                    int i36 = chainHead.mWidgetsMatchCount;
                                                    boolean z14 = i36 <= 0 && chainHead.mWidgetsCount == i36;
                                                    ConstraintWidget constraintWidget27 = constraintWidget;
                                                    constraintWidget3 = constraintWidget27;
                                                    while (constraintWidget3 != null) {
                                                        ConstraintWidget constraintWidget28 = constraintWidget3.mNextChainWidget[i];
                                                        while (constraintWidget28 != null && constraintWidget28.mVisibility == i35) {
                                                            constraintWidget28 = constraintWidget28.mNextChainWidget[i];
                                                        }
                                                        if (constraintWidget3 == constraintWidget || constraintWidget3 == constraintWidget2 || constraintWidget28 == null) {
                                                            i9 = i35;
                                                            i8 = i34;
                                                            constraintWidget4 = constraintWidget27;
                                                            constraintWidget5 = constraintWidget28;
                                                        } else {
                                                            ConstraintWidget constraintWidget29 = constraintWidget28 == constraintWidget2 ? null : constraintWidget28;
                                                            ConstraintAnchor constraintAnchor15 = constraintWidget3.mListAnchors[i2];
                                                            SolverVariable solverVariable13 = constraintAnchor15.mSolverVariable;
                                                            int i37 = i2 + 1;
                                                            SolverVariable solverVariable14 = constraintWidget27.mListAnchors[i37].mSolverVariable;
                                                            int margin4 = constraintAnchor15.getMargin();
                                                            int margin5 = constraintWidget3.mListAnchors[i37].getMargin();
                                                            if (constraintWidget29 != null) {
                                                                constraintAnchor6 = constraintWidget29.mListAnchors[i2];
                                                                solverVariable4 = constraintAnchor6.mSolverVariable;
                                                                ConstraintAnchor constraintAnchor16 = constraintAnchor6.mTarget;
                                                                solverVariable3 = constraintAnchor16 != null ? constraintAnchor16.mSolverVariable : null;
                                                            } else {
                                                                constraintAnchor6 = constraintWidget2.mListAnchors[i2];
                                                                solverVariable4 = constraintAnchor6 != null ? constraintAnchor6.mSolverVariable : null;
                                                                solverVariable3 = constraintWidget3.mListAnchors[i37].mSolverVariable;
                                                            }
                                                            int margin6 = constraintAnchor6 != null ? constraintAnchor6.getMargin() + margin5 : margin5;
                                                            int margin7 = constraintWidget27.mListAnchors[i37].getMargin() + margin4;
                                                            int i38 = z14 ? 8 : i34;
                                                            if (solverVariable13 == null || solverVariable14 == null || solverVariable4 == null || solverVariable3 == null) {
                                                                constraintWidget6 = constraintWidget29;
                                                                i8 = i34;
                                                                i9 = 8;
                                                                constraintWidget4 = constraintWidget27;
                                                            } else {
                                                                constraintWidget6 = constraintWidget29;
                                                                i8 = i34;
                                                                constraintWidget4 = constraintWidget27;
                                                                i9 = 8;
                                                                linearSystem.addCentering(solverVariable13, solverVariable14, margin7, 0.5f, solverVariable4, solverVariable3, margin6, i38);
                                                            }
                                                            constraintWidget5 = constraintWidget6;
                                                        }
                                                        if (constraintWidget3.mVisibility != i9) {
                                                            constraintWidget4 = constraintWidget3;
                                                        }
                                                        constraintWidget3 = constraintWidget5;
                                                        i35 = i9;
                                                        constraintWidget27 = constraintWidget4;
                                                        i34 = i8;
                                                    }
                                                    ConstraintAnchor constraintAnchor17 = constraintWidget.mListAnchors[i2];
                                                    constraintAnchor3 = constraintWidget19.mListAnchors[i2].mTarget;
                                                    int i39 = i2 + 1;
                                                    constraintAnchor4 = constraintWidget2.mListAnchors[i39];
                                                    constraintAnchor5 = constraintWidget20.mListAnchors[i39].mTarget;
                                                    if (constraintAnchor3 != null) {
                                                        if (constraintWidget != constraintWidget2) {
                                                            linearSystem.addEquality(constraintAnchor17.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor17.getMargin(), 5);
                                                        } else if (constraintAnchor5 != null) {
                                                            linearSystem.addCentering(constraintAnchor17.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor17.getMargin(), 0.5f, constraintAnchor4.mSolverVariable, constraintAnchor5.mSolverVariable, constraintAnchor4.getMargin(), 5);
                                                        }
                                                    }
                                                    if (!(constraintAnchor5 == null || constraintWidget == constraintWidget2)) {
                                                        linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor5.mSolverVariable, -constraintAnchor4.getMargin(), 5);
                                                    }
                                                }
                                                if (!((!z2 && !z3) || constraintWidget == null || constraintWidget == constraintWidget2)) {
                                                    constraintAnchor = constraintWidget.mListAnchors[i2];
                                                    i6 = i2 + 1;
                                                    constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                                                    ConstraintAnchor constraintAnchor18 = constraintAnchor.mTarget;
                                                    solverVariable = constraintAnchor18 == null ? constraintAnchor18.mSolverVariable : null;
                                                    ConstraintAnchor constraintAnchor19 = constraintAnchor2.mTarget;
                                                    SolverVariable solverVariable15 = constraintAnchor19 == null ? constraintAnchor19.mSolverVariable : null;
                                                    if (constraintWidget20 == constraintWidget2) {
                                                        ConstraintAnchor constraintAnchor20 = constraintWidget20.mListAnchors[i6].mTarget;
                                                        if (constraintAnchor20 != null) {
                                                            solverVariable7 = constraintAnchor20.mSolverVariable;
                                                        }
                                                        solverVariable2 = solverVariable7;
                                                    } else {
                                                        solverVariable2 = solverVariable15;
                                                    }
                                                    if (constraintWidget == constraintWidget2) {
                                                        ConstraintAnchor[] constraintAnchorArr9 = constraintWidget.mListAnchors;
                                                        ConstraintAnchor constraintAnchor21 = constraintAnchorArr9[i2];
                                                        constraintAnchor2 = constraintAnchorArr9[i6];
                                                        constraintAnchor = constraintAnchor21;
                                                    }
                                                    if (!(solverVariable == null || solverVariable2 == null)) {
                                                        linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                                                    }
                                                }
                                                i17 = i4 + 1;
                                                constraintWidgetContainer2 = constraintWidgetContainer;
                                                i16 = i5;
                                                chainHeadArr = chainHeadArr;
                                                i3 = i3;
                                                dimensionBehaviour2 = dimensionBehaviour2;
                                            } else {
                                                int i40 = chainHead.mWidgetsMatchCount;
                                                boolean z15 = i40 > 0 && chainHead.mWidgetsCount == i40;
                                                ConstraintWidget constraintWidget30 = constraintWidget;
                                                ConstraintWidget constraintWidget31 = constraintWidget30;
                                                while (constraintWidget31 != null) {
                                                    ConstraintWidget constraintWidget32 = constraintWidget31.mNextChainWidget[i];
                                                    while (true) {
                                                        if (constraintWidget32 != null) {
                                                            if (constraintWidget32.mVisibility != 8) {
                                                                break;
                                                            }
                                                            constraintWidget32 = constraintWidget32.mNextChainWidget[i];
                                                        } else {
                                                            break;
                                                        }
                                                    }
                                                    if (constraintWidget32 != null || constraintWidget31 == constraintWidget2) {
                                                        ConstraintAnchor constraintAnchor22 = constraintWidget31.mListAnchors[i2];
                                                        SolverVariable solverVariable16 = constraintAnchor22.mSolverVariable;
                                                        ConstraintAnchor constraintAnchor23 = constraintAnchor22.mTarget;
                                                        SolverVariable solverVariable17 = constraintAnchor23 != null ? constraintAnchor23.mSolverVariable : null;
                                                        if (constraintWidget30 != constraintWidget31) {
                                                            solverVariable17 = constraintWidget30.mListAnchors[i2 + 1].mSolverVariable;
                                                        } else if (constraintWidget31 == constraintWidget && constraintWidget30 == constraintWidget31) {
                                                            ConstraintAnchor[] constraintAnchorArr10 = constraintWidget19.mListAnchors;
                                                            solverVariable17 = constraintAnchorArr10[i2].mTarget != null ? constraintAnchorArr10[i2].mTarget.mSolverVariable : null;
                                                        }
                                                        int margin8 = constraintAnchor22.getMargin();
                                                        int i41 = i2 + 1;
                                                        int margin9 = constraintWidget31.mListAnchors[i41].getMargin();
                                                        if (constraintWidget32 != null) {
                                                            ConstraintAnchor constraintAnchor24 = constraintWidget32.mListAnchors[i2];
                                                            solverVariable5 = constraintAnchor24.mSolverVariable;
                                                            constraintAnchor7 = constraintAnchor24;
                                                            solverVariable6 = constraintWidget31.mListAnchors[i41].mSolverVariable;
                                                        } else {
                                                            ConstraintAnchor constraintAnchor25 = constraintWidget20.mListAnchors[i41].mTarget;
                                                            if (constraintAnchor25 != null) {
                                                                solverVariable5 = constraintAnchor25.mSolverVariable;
                                                                constraintAnchor7 = constraintAnchor25;
                                                            } else {
                                                                constraintAnchor7 = constraintAnchor25;
                                                                solverVariable5 = null;
                                                            }
                                                            solverVariable6 = constraintWidget31.mListAnchors[i41].mSolverVariable;
                                                        }
                                                        if (constraintAnchor7 != null) {
                                                            margin9 += constraintAnchor7.getMargin();
                                                        }
                                                        if (constraintWidget30 != null) {
                                                            margin8 += constraintWidget30.mListAnchors[i41].getMargin();
                                                        }
                                                        if (!(solverVariable16 == null || solverVariable17 == null || solverVariable5 == null || solverVariable6 == null)) {
                                                            if (constraintWidget31 == constraintWidget) {
                                                                margin8 = constraintWidget.mListAnchors[i2].getMargin();
                                                            }
                                                            constraintWidget8 = constraintWidget32;
                                                            constraintWidget7 = constraintWidget30;
                                                            i10 = i7;
                                                            linearSystem.addCentering(solverVariable16, solverVariable17, margin8, 0.5f, solverVariable5, solverVariable6, constraintWidget31 == constraintWidget2 ? constraintWidget2.mListAnchors[i41].getMargin() : margin9, z15 ? 8 : 5);
                                                            if (constraintWidget31.mVisibility == 8) {
                                                                constraintWidget7 = constraintWidget31;
                                                            }
                                                            constraintWidget31 = constraintWidget8;
                                                            constraintWidget30 = constraintWidget7;
                                                            i7 = i10;
                                                        }
                                                    }
                                                    constraintWidget8 = constraintWidget32;
                                                    constraintWidget7 = constraintWidget30;
                                                    i10 = i7;
                                                    if (constraintWidget31.mVisibility == 8) {
                                                    }
                                                    constraintWidget31 = constraintWidget8;
                                                    constraintWidget30 = constraintWidget7;
                                                    i7 = i10;
                                                }
                                            }
                                        } else {
                                            ConstraintAnchor constraintAnchor26 = constraintWidget19.mListAnchors[i2];
                                            int i42 = i2 + 1;
                                            ConstraintAnchor constraintAnchor27 = constraintWidget20.mListAnchors[i42];
                                            ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
                                            SolverVariable solverVariable18 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                                            ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
                                            SolverVariable solverVariable19 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
                                            ConstraintAnchor constraintAnchor30 = constraintWidget21.mListAnchors[i2];
                                            ConstraintAnchor constraintAnchor31 = constraintWidget22.mListAnchors[i42];
                                            if (solverVariable18 == null || solverVariable19 == null) {
                                                constraintWidget2 = constraintWidget22;
                                                constraintWidget = constraintWidget21;
                                                i7 = i4;
                                                i5 = 2;
                                            } else {
                                                if (i == 0) {
                                                    f2 = constraintWidget23.mHorizontalBiasPercent;
                                                } else {
                                                    f2 = constraintWidget23.mVerticalBiasPercent;
                                                }
                                                constraintWidget2 = constraintWidget22;
                                                constraintWidget = constraintWidget21;
                                                i5 = 2;
                                                linearSystem.addCentering(constraintAnchor30.mSolverVariable, solverVariable18, constraintAnchor30.getMargin(), f2, solverVariable19, constraintAnchor31.mSolverVariable, constraintAnchor31.getMargin(), 7);
                                                constraintAnchor = constraintWidget.mListAnchors[i2];
                                                i6 = i2 + 1;
                                                constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                                                ConstraintAnchor constraintAnchor182 = constraintAnchor.mTarget;
                                                if (constraintAnchor182 == null) {
                                                }
                                                ConstraintAnchor constraintAnchor192 = constraintAnchor2.mTarget;
                                                if (constraintAnchor192 == null) {
                                                }
                                                if (constraintWidget20 == constraintWidget2) {
                                                }
                                                if (constraintWidget == constraintWidget2) {
                                                }
                                                linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                                                i17 = i4 + 1;
                                                constraintWidgetContainer2 = constraintWidgetContainer;
                                                i16 = i5;
                                                chainHeadArr = chainHeadArr;
                                                i3 = i3;
                                                dimensionBehaviour2 = dimensionBehaviour2;
                                            }
                                        }
                                        i4 = i7;
                                        constraintAnchor = constraintWidget.mListAnchors[i2];
                                        i6 = i2 + 1;
                                        constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                                        ConstraintAnchor constraintAnchor1822 = constraintAnchor.mTarget;
                                        if (constraintAnchor1822 == null) {
                                        }
                                        ConstraintAnchor constraintAnchor1922 = constraintAnchor2.mTarget;
                                        if (constraintAnchor1922 == null) {
                                        }
                                        if (constraintWidget20 == constraintWidget2) {
                                        }
                                        if (constraintWidget == constraintWidget2) {
                                        }
                                        linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                                        i17 = i4 + 1;
                                        constraintWidgetContainer2 = constraintWidgetContainer;
                                        i16 = i5;
                                        chainHeadArr = chainHeadArr;
                                        i3 = i3;
                                        dimensionBehaviour2 = dimensionBehaviour2;
                                    }
                                }
                                if (z4) {
                                    ConstraintAnchor constraintAnchor32 = constraintAnchor13.mTarget;
                                    if (constraintAnchor32.mOwner == constraintWidgetContainer2) {
                                        linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor32.mSolverVariable, -constraintAnchor13.getMargin(), 4);
                                    }
                                }
                                linearSystem.addLowerThan(constraintAnchor13.mSolverVariable, constraintWidget20.mListAnchors[i30].mTarget.mSolverVariable, -constraintAnchor13.getMargin(), 6);
                                if (z12) {
                                }
                                ArrayList<ConstraintWidget> arrayList22 = chainHead.mWeightedMatchConstraintsWidgets;
                                if (chainHead.mHasUndefinedWeights) {
                                }
                                ConstraintWidget constraintWidget252 = null;
                                float f82 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                i11 = 0;
                                while (i11 < size) {
                                }
                                int i342 = 4;
                                if (constraintWidget21 != null) {
                                }
                                constraintWidget2 = constraintWidget22;
                                constraintWidget = constraintWidget21;
                                i7 = i4;
                                i5 = 2;
                                if (z2) {
                                }
                                i4 = i7;
                                int i352 = 8;
                                int i362 = chainHead.mWidgetsMatchCount;
                                if (i362 <= 0) {
                                }
                                ConstraintWidget constraintWidget272 = constraintWidget;
                                constraintWidget3 = constraintWidget272;
                                while (constraintWidget3 != null) {
                                }
                                ConstraintAnchor constraintAnchor172 = constraintWidget.mListAnchors[i2];
                                constraintAnchor3 = constraintWidget19.mListAnchors[i2].mTarget;
                                int i392 = i2 + 1;
                                constraintAnchor4 = constraintWidget2.mListAnchors[i392];
                                constraintAnchor5 = constraintWidget20.mListAnchors[i392].mTarget;
                                if (constraintAnchor3 != null) {
                                }
                                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor5.mSolverVariable, -constraintAnchor4.getMargin(), 5);
                                constraintAnchor = constraintWidget.mListAnchors[i2];
                                i6 = i2 + 1;
                                constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                                ConstraintAnchor constraintAnchor18222 = constraintAnchor.mTarget;
                                if (constraintAnchor18222 == null) {
                                }
                                ConstraintAnchor constraintAnchor19222 = constraintAnchor2.mTarget;
                                if (constraintAnchor19222 == null) {
                                }
                                if (constraintWidget20 == constraintWidget2) {
                                }
                                if (constraintWidget == constraintWidget2) {
                                }
                                linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                                i17 = i4 + 1;
                                constraintWidgetContainer2 = constraintWidgetContainer;
                                i16 = i5;
                                chainHeadArr = chainHeadArr;
                                i3 = i3;
                                dimensionBehaviour2 = dimensionBehaviour2;
                            }
                        }
                        if (z12) {
                        }
                        ArrayList<ConstraintWidget> arrayList222 = chainHead.mWeightedMatchConstraintsWidgets;
                        if (chainHead.mHasUndefinedWeights) {
                        }
                        ConstraintWidget constraintWidget2522 = null;
                        float f822 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        i11 = 0;
                        while (i11 < size) {
                        }
                        int i3422 = 4;
                        if (constraintWidget21 != null) {
                        }
                        constraintWidget2 = constraintWidget22;
                        constraintWidget = constraintWidget21;
                        i7 = i4;
                        i5 = 2;
                        if (z2) {
                        }
                        i4 = i7;
                        int i3522 = 8;
                        int i3622 = chainHead.mWidgetsMatchCount;
                        if (i3622 <= 0) {
                        }
                        ConstraintWidget constraintWidget2722 = constraintWidget;
                        constraintWidget3 = constraintWidget2722;
                        while (constraintWidget3 != null) {
                        }
                        ConstraintAnchor constraintAnchor1722 = constraintWidget.mListAnchors[i2];
                        constraintAnchor3 = constraintWidget19.mListAnchors[i2].mTarget;
                        int i3922 = i2 + 1;
                        constraintAnchor4 = constraintWidget2.mListAnchors[i3922];
                        constraintAnchor5 = constraintWidget20.mListAnchors[i3922].mTarget;
                        if (constraintAnchor3 != null) {
                        }
                        linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor5.mSolverVariable, -constraintAnchor4.getMargin(), 5);
                        constraintAnchor = constraintWidget.mListAnchors[i2];
                        i6 = i2 + 1;
                        constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                        ConstraintAnchor constraintAnchor182222 = constraintAnchor.mTarget;
                        if (constraintAnchor182222 == null) {
                        }
                        ConstraintAnchor constraintAnchor192222 = constraintAnchor2.mTarget;
                        if (constraintAnchor192222 == null) {
                        }
                        if (constraintWidget20 == constraintWidget2) {
                        }
                        if (constraintWidget == constraintWidget2) {
                        }
                        linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                        i17 = i4 + 1;
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        i16 = i5;
                        chainHeadArr = chainHeadArr;
                        i3 = i3;
                        dimensionBehaviour2 = dimensionBehaviour2;
                    }
                } else {
                    f = f6;
                    i4 = i17;
                    z8 = constraintWidget23.mVerticalChainStyle == 0;
                    z9 = constraintWidget23.mVerticalChainStyle == 1;
                }
                z3 = z9;
                z2 = z8;
                z4 = true;
                ConstraintWidget constraintWidget242 = constraintWidget19;
                z5 = false;
                while (!z5) {
                }
                if (constraintWidget22 != null) {
                }
                if (z12) {
                }
                ArrayList<ConstraintWidget> arrayList2222 = chainHead.mWeightedMatchConstraintsWidgets;
                if (chainHead.mHasUndefinedWeights) {
                }
                ConstraintWidget constraintWidget25222 = null;
                float f8222 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                i11 = 0;
                while (i11 < size) {
                }
                int i34222 = 4;
                if (constraintWidget21 != null) {
                }
                constraintWidget2 = constraintWidget22;
                constraintWidget = constraintWidget21;
                i7 = i4;
                i5 = 2;
                if (z2) {
                }
                i4 = i7;
                int i35222 = 8;
                int i36222 = chainHead.mWidgetsMatchCount;
                if (i36222 <= 0) {
                }
                ConstraintWidget constraintWidget27222 = constraintWidget;
                constraintWidget3 = constraintWidget27222;
                while (constraintWidget3 != null) {
                }
                ConstraintAnchor constraintAnchor17222 = constraintWidget.mListAnchors[i2];
                constraintAnchor3 = constraintWidget19.mListAnchors[i2].mTarget;
                int i39222 = i2 + 1;
                constraintAnchor4 = constraintWidget2.mListAnchors[i39222];
                constraintAnchor5 = constraintWidget20.mListAnchors[i39222].mTarget;
                if (constraintAnchor3 != null) {
                }
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor5.mSolverVariable, -constraintAnchor4.getMargin(), 5);
                constraintAnchor = constraintWidget.mListAnchors[i2];
                i6 = i2 + 1;
                constraintAnchor2 = constraintWidget2.mListAnchors[i6];
                ConstraintAnchor constraintAnchor1822222 = constraintAnchor.mTarget;
                if (constraintAnchor1822222 == null) {
                }
                ConstraintAnchor constraintAnchor1922222 = constraintAnchor2.mTarget;
                if (constraintAnchor1922222 == null) {
                }
                if (constraintWidget20 == constraintWidget2) {
                }
                if (constraintWidget == constraintWidget2) {
                }
                linearSystem.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintWidget2.mListAnchors[i6].getMargin(), 5);
                i17 = i4 + 1;
                constraintWidgetContainer2 = constraintWidgetContainer;
                i16 = i5;
                chainHeadArr = chainHeadArr;
                i3 = i3;
                dimensionBehaviour2 = dimensionBehaviour2;
            }
        }

        public static byte[] asciiBytes(String str) {
            if (str != null) {
                try {
                    return str.getBytes("ASCII");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("ASCII not found!", e);
                }
            } else {
                throw null;
            }
        }

        public static void assertCondition(boolean z) {
            if (!z) {
                throw new AssertionError();
            }
        }

        public static final void assertExplicitMeasureSpec(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 0 || mode2 == 0) {
                throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
            }
        }

        public static <T> T assertNotNull(T t) {
            if (t != null) {
                return t;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
            if (r10.right <= r12.left) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
            if (r10.top >= r12.bottom) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
            if (r10.left >= r12.right) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r10.bottom <= r12.top) goto L_0x0043;
         */
        public static boolean beamBeats(int i, Rect rect, Rect rect2, Rect rect3) {
            int i2;
            int i3;
            boolean beamsOverlap = beamsOverlap(i, rect, rect2);
            if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
                return false;
            }
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
            }
            boolean z = true;
            if (!z || i == 17 || i == 66) {
                return true;
            }
            int majorAxisDistance = majorAxisDistance(i, rect, rect2);
            if (i == 17) {
                i3 = rect.left;
                i2 = rect3.left;
            } else if (i == 33) {
                i3 = rect.top;
                i2 = rect3.top;
            } else if (i == 66) {
                i3 = rect3.right;
                i2 = rect.right;
            } else if (i == 130) {
                i3 = rect3.bottom;
                i2 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return majorAxisDistance < Math.max(1, i3 - i2);
        }

        public static boolean beamsOverlap(int i, Rect rect, Rect rect2) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return rect2.right >= rect.left && rect2.left <= rect.right;
            }
            return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        }

        public static String buildKeySelection(int i) {
            String[] strArr = new String[i];
            Arrays.fill(strArr, ColorPropConverter.PREFIX_ATTR);
            return GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline15("key IN ("), TextUtils.join(", ", strArr), ")");
        }

        public static void buildShortClassTag(Object obj, StringBuilder sb) {
            int lastIndexOf;
            if (obj == null) {
                sb.append("null");
                return;
            }
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }

        public static <K, V> MapBuilder$Builder<K, V> builder() {
            return new MapBuilder$Builder<>(null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
        public static ContentUriTriggers byteArrayToContentUriTriggers(byte[] bArr) {
            Throwable th;
            ObjectInputStream objectInputStream;
            IOException e;
            ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
            if (bArr == null) {
                return contentUriTriggers;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        contentUriTriggers.mTriggers.add(new ContentUriTriggers.Trigger(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return contentUriTriggers;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                objectInputStream = null;
                e = e6;
                e.printStackTrace();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                return contentUriTriggers;
            } catch (Throwable th3) {
                objectInputStream = null;
                th = th3;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
            return contentUriTriggers;
        }

        public static boolean canMorph(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
            if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length) {
                return false;
            }
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                if (!(pathParser$PathDataNodeArr[i].mType == pathParser$PathDataNodeArr2[i].mType && pathParser$PathDataNodeArr[i].mParams.length == pathParser$PathDataNodeArr2[i].mParams.length)) {
                    return false;
                }
            }
            return true;
        }

        public static void checkArgument(boolean z) {
            if (!z) {
                throw new IllegalArgumentException();
            }
        }

        public static void checkArgument1(boolean z, Object obj) {
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
        }

        public static int checkArgumentNonnegative(int i) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException();
        }

        public static void checkBounds(int i, int i2, int i3, int i4, int i5) {
            boolean z = true;
            checkArgument(i4 >= 0);
            checkArgument(i >= 0);
            checkArgument(i3 >= 0);
            checkArgument(i + i4 <= i5);
            if (i3 + i4 > i2) {
                z = false;
            }
            checkArgument(z);
        }

        public static <T> T checkNotNull(T t) {
            if (t != null) {
                return t;
            }
            throw null;
        }

        public static <T> T checkNotNull1(T t) {
            if (t != null) {
                return t;
            }
            throw null;
        }

        public static int checkSelfPermission(Context context, String str) {
            int myPid = Process.myPid();
            int myUid = Process.myUid();
            String packageName = context.getPackageName();
            if (context.checkPermission(str, myPid, myUid) == -1) {
                return -1;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid == null || packagesForUid.length <= 0) {
                        return -1;
                    }
                    packageName = packagesForUid[0];
                }
                if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName) != 0) {
                    return -2;
                }
            }
            return 0;
        }

        public static void checkState(boolean z) {
            if (!z) {
                throw new IllegalStateException();
            }
        }

        public static int clamp(int i, int i2, int i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }

        public static void close(URLConnection uRLConnection) {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        }

        public static boolean compare(byte[] bArr, String str) {
            if (bArr.length != str.length()) {
                return false;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (str.charAt(i) != bArr[i]) {
                    return false;
                }
            }
            return true;
        }

        public static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
            }
            return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
        }

        public static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
            int i;
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            if (z2) {
                i = Math.max(0, (state.getItemCount() - max) - 1);
            } else {
                i = Math.max(0, min);
            }
            if (!z) {
                return i;
            }
            return Math.round((((float) i) * (((float) Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view))));
        }

        public static int computeScrollRange(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return state.getItemCount();
            }
            return (int) ((((float) (orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.getItemCount()));
        }

        public static byte[] concatByteArrays(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public static <T> boolean containsNullElements(Collection<T> collection) {
            if (collection == null) {
                return true;
            }
            for (T t : collection) {
                if (t == null) {
                    return true;
                }
            }
            return false;
        }

        public static float[] copyOfRange(float[] fArr, int i, int i2) {
            if (i <= i2) {
                int length = fArr.length;
                if (i < 0 || i > length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i3 = i2 - i;
                int min = Math.min(i3, length - i);
                float[] fArr2 = new float[i3];
                System.arraycopy(fArr, i, fArr2, 0, min);
                return fArr2;
            }
            throw new IllegalArgumentException();
        }

        public static void copyProperties(Drawable drawable, Drawable drawable2) {
            if (drawable != null && drawable != drawable2) {
                drawable.setBounds(drawable2.getBounds());
                drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
                drawable.setLevel(drawable2.getLevel());
                drawable.setVisible(drawable2.isVisible(), false);
                drawable.setState(drawable2.getState());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC, Splitter:B:25:0x0047] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A[SYNTHETIC, Splitter:B:31:0x0050] */
        public static boolean copyToFile(File file, InputStream inputStream) {
            Throwable th;
            IOException e;
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                        if (fileOutputStream != null) {
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                return false;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r15v16, resolved type: android.animation.AnimatorSet */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:154:0x030d  */
        public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
            int i2;
            int i3;
            ValueAnimator valueAnimator;
            PropertyValuesHolder[] propertyValuesHolderArr;
            int i4;
            String str;
            AttributeSet attributeSet2;
            int i5;
            PropertyValuesHolder propertyValuesHolder;
            int i6;
            int size;
            TypedValue typedValue;
            Keyframe keyframe;
            int i7;
            TypedValue typedValue2;
            Resources resources2 = resources;
            Resources.Theme theme2 = theme;
            int depth = xmlPullParser.getDepth();
            ValueAnimator valueAnimator2 = null;
            ArrayList arrayList = null;
            while (true) {
                int next = xmlPullParser.next();
                int i8 = 3;
                i2 = 0;
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    int i9 = 2;
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if (name.equals("objectAnimator")) {
                            valueAnimator = new ObjectAnimator();
                            loadAnimator(context, resources, theme, attributeSet, valueAnimator, f, xmlPullParser);
                        } else if (name.equals("animator")) {
                            valueAnimator = loadAnimator(context, resources, theme, attributeSet, null, f, xmlPullParser);
                        } else {
                            if (name.equals("set")) {
                                AnimatorSet animatorSet2 = new AnimatorSet();
                                TypedArray obtainAttributes1 = obtainAttributes1(resources2, theme2, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                                createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, getNamedInt(obtainAttributes1, xmlPullParser, "ordering", 0, 0), f);
                                obtainAttributes1.recycle();
                                i3 = depth;
                                valueAnimator2 = animatorSet2;
                            } else {
                                String str2 = "propertyValuesHolder";
                                if (name.equals(str2)) {
                                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                                    ArrayList arrayList2 = null;
                                    i2 = 1;
                                    int i10 = 0;
                                    while (true) {
                                        int eventType = xmlPullParser.getEventType();
                                        if (eventType == i8 || eventType == i2) {
                                            i3 = depth;
                                        } else if (eventType != i9) {
                                            xmlPullParser.next();
                                        } else {
                                            if (xmlPullParser.getName().equals(str2)) {
                                                TypedArray obtainAttributes12 = obtainAttributes1(resources2, theme2, asAttributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                                                String namedString = getNamedString(obtainAttributes12, xmlPullParser, "propertyName", i8);
                                                int namedInt = getNamedInt(obtainAttributes12, xmlPullParser, "valueType", i9, 4);
                                                ArrayList arrayList3 = null;
                                                attributeSet2 = asAttributeSet;
                                                int i11 = namedInt;
                                                while (true) {
                                                    int next2 = xmlPullParser.next();
                                                    if (next2 == i8 || next2 == 1) {
                                                        str = str2;
                                                        i4 = depth;
                                                    } else if (xmlPullParser.getName().equals("keyframe")) {
                                                        if (i11 == 4) {
                                                            TypedArray obtainAttributes13 = obtainAttributes1(resources2, theme2, Xml.asAttributeSet(xmlPullParser), AndroidResources.STYLEABLE_KEYFRAME);
                                                            if (!hasAttribute(xmlPullParser, "value")) {
                                                                typedValue2 = null;
                                                            } else {
                                                                typedValue2 = obtainAttributes13.peekValue(0);
                                                            }
                                                            i11 = (!(typedValue2 != null) || !isColorType(typedValue2.type)) ? 0 : i8;
                                                            obtainAttributes13.recycle();
                                                        }
                                                        TypedArray obtainAttributes14 = obtainAttributes1(resources2, theme2, Xml.asAttributeSet(xmlPullParser), AndroidResources.STYLEABLE_KEYFRAME);
                                                        float namedFloat = getNamedFloat(obtainAttributes14, xmlPullParser, "fraction", 3, -1.0f);
                                                        if (!hasAttribute(xmlPullParser, "value")) {
                                                            typedValue = null;
                                                        } else {
                                                            typedValue = obtainAttributes14.peekValue(0);
                                                        }
                                                        boolean z = typedValue != null;
                                                        int i12 = i11 == 4 ? (!z || !isColorType(typedValue.type)) ? 0 : 3 : i11;
                                                        if (z) {
                                                            if (i12 == 0) {
                                                                keyframe = Keyframe.ofFloat(namedFloat, getNamedFloat(obtainAttributes14, xmlPullParser, "value", 0, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
                                                            } else if (i12 == 1 || i12 == 3) {
                                                                keyframe = Keyframe.ofInt(namedFloat, getNamedInt(obtainAttributes14, xmlPullParser, "value", 0, 0));
                                                            } else {
                                                                keyframe = null;
                                                            }
                                                        } else if (i12 == 0) {
                                                            keyframe = Keyframe.ofFloat(namedFloat);
                                                        } else {
                                                            keyframe = Keyframe.ofInt(namedFloat);
                                                        }
                                                        if (!hasAttribute(xmlPullParser, "interpolator")) {
                                                            i7 = 0;
                                                        } else {
                                                            i7 = obtainAttributes14.getResourceId(1, 0);
                                                        }
                                                        if (i7 > 0) {
                                                            keyframe.setInterpolator(AnimationUtils.loadInterpolator(context, i7));
                                                        }
                                                        obtainAttributes14.recycle();
                                                        if (keyframe != null) {
                                                            if (arrayList3 == null) {
                                                                arrayList3 = new ArrayList();
                                                            }
                                                            arrayList3.add(keyframe);
                                                        }
                                                        xmlPullParser.next();
                                                        i8 = 3;
                                                        resources2 = resources;
                                                        theme2 = theme;
                                                        str2 = str2;
                                                        depth = depth;
                                                    } else {
                                                        resources2 = resources;
                                                        theme2 = theme;
                                                        i8 = i8;
                                                    }
                                                }
                                                str = str2;
                                                i4 = depth;
                                                if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                                    i5 = 3;
                                                    i6 = 2;
                                                    propertyValuesHolder = null;
                                                } else {
                                                    Keyframe keyframe2 = (Keyframe) arrayList3.get(0);
                                                    Keyframe keyframe3 = (Keyframe) arrayList3.get(size - 1);
                                                    float fraction = keyframe3.getFraction();
                                                    if (fraction < 1.0f) {
                                                        if (fraction < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                            keyframe3.setFraction(1.0f);
                                                        } else {
                                                            arrayList3.add(arrayList3.size(), createNewKeyframe(keyframe3, 1.0f));
                                                            size++;
                                                        }
                                                    }
                                                    float fraction2 = keyframe2.getFraction();
                                                    if (fraction2 != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                        if (fraction2 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                            keyframe2.setFraction(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                                        } else {
                                                            arrayList3.add(0, createNewKeyframe(keyframe2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
                                                            size++;
                                                        }
                                                    }
                                                    Keyframe[] keyframeArr = new Keyframe[size];
                                                    arrayList3.toArray(keyframeArr);
                                                    int i13 = 0;
                                                    while (i13 < size) {
                                                        Keyframe keyframe4 = keyframeArr[i13];
                                                        if (keyframe4.getFraction() < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                            if (i13 == 0) {
                                                                keyframe4.setFraction(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                                            } else {
                                                                int i14 = size - 1;
                                                                if (i13 == i14) {
                                                                    keyframe4.setFraction(1.0f);
                                                                } else {
                                                                    int i15 = i13 + 1;
                                                                    int i16 = i13;
                                                                    while (i15 < i14 && keyframeArr[i15].getFraction() < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                                        i16 = i15;
                                                                        i15++;
                                                                    }
                                                                    float fraction3 = (keyframeArr[i16 + 1].getFraction() - keyframeArr[i13 - 1].getFraction()) / ((float) ((i16 - i13) + 2));
                                                                    int i17 = i13;
                                                                    while (i17 <= i16) {
                                                                        keyframeArr[i17].setFraction(keyframeArr[i17 - 1].getFraction() + fraction3);
                                                                        i17++;
                                                                        size = size;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        i13++;
                                                        size = size;
                                                    }
                                                    i6 = 2;
                                                    propertyValuesHolder = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr);
                                                    i5 = 3;
                                                    if (i11 == 3) {
                                                        propertyValuesHolder.setEvaluator(ArgbEvaluator.sInstance);
                                                    }
                                                }
                                                i2 = 1;
                                                if (propertyValuesHolder == null) {
                                                    propertyValuesHolder = getPVH(obtainAttributes12, namedInt, 0, 1, namedString);
                                                }
                                                if (propertyValuesHolder != null) {
                                                    if (arrayList2 == null) {
                                                        arrayList2 = new ArrayList();
                                                    }
                                                    arrayList2.add(propertyValuesHolder);
                                                }
                                                obtainAttributes12.recycle();
                                                i9 = i6;
                                                i8 = i5;
                                                i10 = 0;
                                            } else {
                                                attributeSet2 = asAttributeSet;
                                                str = str2;
                                                i4 = depth;
                                            }
                                            xmlPullParser.next();
                                            resources2 = resources;
                                            theme2 = theme;
                                            asAttributeSet = attributeSet2;
                                            str2 = str;
                                            depth = i4;
                                        }
                                    }
                                    i3 = depth;
                                    if (arrayList2 != null) {
                                        int size2 = arrayList2.size();
                                        propertyValuesHolderArr = new PropertyValuesHolder[size2];
                                        while (i10 < size2) {
                                            propertyValuesHolderArr[i10] = (PropertyValuesHolder) arrayList2.get(i10);
                                            i10++;
                                        }
                                    } else {
                                        propertyValuesHolderArr = null;
                                    }
                                    if (propertyValuesHolderArr != null && (valueAnimator2 instanceof ValueAnimator)) {
                                        valueAnimator2.setValues(propertyValuesHolderArr);
                                    }
                                } else {
                                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unknown animator name: ");
                                    outline15.append(xmlPullParser.getName());
                                    throw new RuntimeException(outline15.toString());
                                }
                            }
                            if (animatorSet != null && i2 == 0) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(valueAnimator2);
                            }
                            resources2 = resources;
                            theme2 = theme;
                            depth = i3;
                        }
                        valueAnimator2 = valueAnimator;
                        i3 = depth;
                        if (arrayList == null) {
                        }
                        arrayList.add(valueAnimator2);
                        resources2 = resources;
                        theme2 = theme;
                        depth = i3;
                    }
                }
            }
            if (!(animatorSet == null || arrayList == null)) {
                Animator[] animatorArr = new Animator[arrayList.size()];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorArr[i2] = (Animator) it.next();
                    i2++;
                }
                if (i == 0) {
                    animatorSet.playTogether(animatorArr);
                } else {
                    animatorSet.playSequentially(animatorArr);
                }
            }
            return valueAnimator2;
        }

        public static OkHttpClient createClient(Context context) {
            return createClientBuilder().cache(new Cache(new File(context.getCacheDir(), "http-cache"), (long) 10485760)).build();
        }

        public static OkHttpClient.Builder createClientBuilder() {
            OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().connectTimeout(0, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());
            try {
                Security.insertProviderAt((Provider) Class.forName("org.conscrypt.OpenSSLProvider").newInstance(), 1);
            } catch (Exception unused) {
            }
            return cookieJar;
        }

        public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
            int next;
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            int depth;
            TypedArray typedArray;
            String name = xmlPullParser.getName();
            if (name.equals("selector")) {
                int i = 1;
                int depth2 = xmlPullParser.getDepth() + 1;
                int[][] iArr = new int[20][];
                int[] iArr2 = new int[20];
                int i2 = 0;
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                        int[] iArr3 = new int[i2];
                        int[][] iArr4 = new int[i2][];
                        System.arraycopy(iArr2, 0, iArr3, 0, i2);
                        System.arraycopy(iArr, 0, iArr4, 0, i2);
                    } else {
                        if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                            int[] iArr5 = R$styleable.ColorStateListItem;
                            if (theme == null) {
                                typedArray = resources.obtainAttributes(attributeSet, iArr5);
                            } else {
                                typedArray = theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                            }
                            int color = typedArray.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                            float f = 1.0f;
                            if (typedArray.hasValue(R$styleable.ColorStateListItem_android_alpha)) {
                                f = typedArray.getFloat(R$styleable.ColorStateListItem_android_alpha, 1.0f);
                            } else if (typedArray.hasValue(R$styleable.ColorStateListItem_alpha)) {
                                f = typedArray.getFloat(R$styleable.ColorStateListItem_alpha, 1.0f);
                            }
                            typedArray.recycle();
                            int attributeCount = attributeSet.getAttributeCount();
                            int[] iArr6 = new int[attributeCount];
                            int i3 = 0;
                            for (int i4 = 0; i4 < attributeCount; i4++) {
                                int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                                if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == androidx.core.R$attr.alpha)) {
                                    int i5 = i3 + 1;
                                    if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                                        attributeNameResource = -attributeNameResource;
                                    }
                                    iArr6[i3] = attributeNameResource;
                                    i3 = i5;
                                }
                            }
                            int[] trimStateSet = StateSet.trimStateSet(iArr6, i3);
                            int round = (Math.round(((float) Color.alpha(color)) * f) << 24) | (color & 16777215);
                            int i6 = i2 + 1;
                            int i7 = 8;
                            if (i6 > iArr2.length) {
                                int[] iArr7 = new int[(i2 <= 4 ? 8 : i2 * 2)];
                                System.arraycopy(iArr2, 0, iArr7, 0, i2);
                                iArr2 = iArr7;
                            }
                            iArr2[i2] = round;
                            if (i6 > iArr.length) {
                                Class<?> componentType = iArr.getClass().getComponentType();
                                if (i2 > 4) {
                                    i7 = i2 * 2;
                                }
                                ?? r8 = (Object[]) Array.newInstance(componentType, i7);
                                System.arraycopy(iArr, 0, r8, 0, i2);
                                iArr = r8;
                            }
                            iArr[i2] = trimStateSet;
                            iArr = iArr;
                            i2 = i6;
                        }
                        i = 1;
                    }
                }
                int[] iArr32 = new int[i2];
                int[][] iArr42 = new int[i2][];
                System.arraycopy(iArr2, 0, iArr32, 0, i2);
                System.arraycopy(iArr, 0, iArr42, 0, i2);
                return new ColorStateList(iArr42, iArr32);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }

        public static Keyframe createNewKeyframe(Keyframe keyframe, float f) {
            if (keyframe.getType() == Float.TYPE) {
                return Keyframe.ofFloat(f);
            }
            if (keyframe.getType() == Integer.TYPE) {
                return Keyframe.ofInt(f);
            }
            return Keyframe.ofObject(f);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008a, code lost:
            if (r13 == 0) goto L_0x008c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ NumberFormatException -> 0x00bc }, LOOP:3: B:25:0x006c->B:45:0x0097, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0096 A[SYNTHETIC] */
        public static PathParser$PathDataNode[] createNodesFromPathData(String str) {
            String trim;
            float[] fArr;
            if (str == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 1;
            int i3 = 0;
            while (i2 < str.length()) {
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    if ((charAt - 'Z') * (charAt - 'A') > 0) {
                        if ((charAt - 'z') * (charAt - 'a') > 0) {
                            continue;
                            i2++;
                        }
                    }
                    if (!(charAt == 'e' || charAt == 'E')) {
                        trim = str.substring(i, i2).trim();
                        if (trim.length() > 0) {
                            if (trim.charAt(i3) == 'z' || trim.charAt(i3) == 'Z') {
                                fArr = new float[i3];
                            } else {
                                try {
                                    float[] fArr2 = new float[trim.length()];
                                    int length = trim.length();
                                    int i4 = 1;
                                    int i5 = i3;
                                    while (i4 < length) {
                                        int i6 = i3;
                                        int i7 = i6;
                                        int i8 = i7;
                                        int i9 = i4;
                                        while (true) {
                                            if (i9 < trim.length()) {
                                                char charAt2 = trim.charAt(i9);
                                                if (charAt2 != ' ') {
                                                    if (charAt2 == 'E' || charAt2 == 'e') {
                                                        i8 = 1;
                                                        if (i3 == 0) {
                                                            i9++;
                                                        }
                                                    } else {
                                                        switch (charAt2) {
                                                            case '-':
                                                                if (i9 != i4) {
                                                                }
                                                                break;
                                                            case '.':
                                                                if (i7 == 0) {
                                                                    i7 = 1;
                                                                    break;
                                                                }
                                                                i6 = 1;
                                                                break;
                                                        }
                                                        i8 = 0;
                                                        if (i3 == 0) {
                                                        }
                                                    }
                                                }
                                                i3 = 1;
                                                i8 = 0;
                                                if (i3 == 0) {
                                                }
                                            }
                                        }
                                        if (i4 < i9) {
                                            fArr2[i5] = Float.parseFloat(trim.substring(i4, i9));
                                            i5++;
                                        }
                                        if (i6 == 0) {
                                            i9++;
                                        }
                                        i4 = i9;
                                        i3 = 0;
                                    }
                                    fArr = copyOfRange(fArr2, i3, i5);
                                    i3 = 0;
                                } catch (NumberFormatException e) {
                                    throw new RuntimeException(GeneratedOutlineSupport.outline9("error in parsing \"", trim, "\""), e);
                                }
                            }
                            arrayList.add(new PathParser$PathDataNode(trim.charAt(i3), fArr));
                        }
                        i3 = 0;
                        i2++;
                        i = i2;
                    }
                    i2++;
                }
                trim = str.substring(i, i2).trim();
                if (trim.length() > 0) {
                }
                i3 = 0;
                i2++;
                i = i2;
            }
            if (i2 - i == 1 && i < str.length()) {
                arrayList.add(new PathParser$PathDataNode(str.charAt(i), new float[0]));
            }
            return (PathParser$PathDataNode[]) arrayList.toArray(new PathParser$PathDataNode[arrayList.size()]);
        }

        public static Path createPathFromPathData(String str) {
            Path path = new Path();
            PathParser$PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
            if (createNodesFromPathData == null) {
                return null;
            }
            try {
                PathParser$PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException(GeneratedOutlineSupport.outline8("Error in parsing ", str), e);
            }
        }

        public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
            if (pathParser$PathDataNodeArr == null) {
                return null;
            }
            PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = new PathParser$PathDataNode[pathParser$PathDataNodeArr.length];
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                pathParser$PathDataNodeArr2[i] = new PathParser$PathDataNode(pathParser$PathDataNodeArr[i]);
            }
            return pathParser$PathDataNodeArr2;
        }

        public static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
                if (optJSONObject == null || optJSONObject2 == null) {
                    jSONObject.put(next, jSONObject2.get(next));
                } else {
                    deepMergeInto(optJSONObject2, optJSONObject);
                    jSONObject.put(next, optJSONObject2);
                }
            }
        }

        public static boolean deleteContents(File file) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    z &= deleteRecursively(file2);
                }
            }
            return z;
        }

        public static boolean deleteRecursively(File file) {
            if (file.isDirectory()) {
                deleteContents(file);
            }
            return file.delete();
        }

        public static double determinant(double[] dArr) {
            double d = dArr[0];
            double d2 = dArr[1];
            double d3 = dArr[2];
            double d4 = dArr[3];
            double d5 = dArr[4];
            double d6 = dArr[5];
            double d7 = dArr[6];
            double d8 = dArr[7];
            double d9 = dArr[8];
            double d10 = dArr[9];
            double d11 = dArr[10];
            double d12 = dArr[11];
            double d13 = dArr[12];
            double d14 = dArr[13];
            double d15 = dArr[14];
            double d16 = dArr[15];
            double d17 = d4 * d7;
            double d18 = d3 * d8;
            double d19 = d4 * d6;
            double d20 = d2 * d8;
            double d21 = (d20 * d11 * d13) + ((((d17 * d10) * d13) - ((d18 * d10) * d13)) - ((d19 * d11) * d13));
            double d22 = d3 * d6;
            double d23 = (d22 * d12 * d13) + d21;
            double d24 = d2 * d7;
            double d25 = d4 * d5;
            double d26 = d25 * d11 * d14;
            double d27 = d8 * d;
            double d28 = d3 * d5;
            double d29 = ((d26 + (((d18 * d9) * d14) + ((d23 - ((d24 * d12) * d13)) - ((d17 * d9) * d14)))) - ((d27 * d11) * d14)) - ((d28 * d12) * d14);
            double d30 = d7 * d;
            double d31 = d2 * d5;
            double d32 = d * d6;
            return (d32 * d11 * d16) + (((((d28 * d10) * d16) + (((d24 * d9) * d16) + (((((d31 * d12) * d15) + (((d27 * d10) * d15) + (((((d19 * d9) * d15) + (((d30 * d12) * d14) + d29)) - ((d20 * d9) * d15)) - ((d25 * d10) * d15)))) - ((d12 * d32) * d15)) - ((d22 * d9) * d16)))) - ((d30 * d10) * d16)) - ((d31 * d11) * d16));
        }

        public static float determineDownsampleRatio(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage) {
            int i;
            int i2;
            int i3;
            checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
            if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0) {
                return 1.0f;
            }
            encodedImage.parseMetaDataIfNeeded();
            if (encodedImage.mWidth == 0) {
                return 1.0f;
            }
            encodedImage.parseMetaDataIfNeeded();
            if (encodedImage.mHeight == 0) {
                return 1.0f;
            }
            if (!rotationOptions.useImageMetadata()) {
                i = 0;
            } else {
                encodedImage.parseMetaDataIfNeeded();
                i = encodedImage.mRotationAngle;
                checkArgument(i == 0 || i == 90 || i == 180 || i == 270);
            }
            boolean z = i == 90 || i == 270;
            if (z) {
                encodedImage.parseMetaDataIfNeeded();
                i2 = encodedImage.mHeight;
            } else {
                encodedImage.parseMetaDataIfNeeded();
                i2 = encodedImage.mWidth;
            }
            if (z) {
                encodedImage.parseMetaDataIfNeeded();
                i3 = encodedImage.mWidth;
            } else {
                encodedImage.parseMetaDataIfNeeded();
                i3 = encodedImage.mHeight;
            }
            float f = ((float) resizeOptions.width) / ((float) i2);
            float f2 = ((float) resizeOptions.height) / ((float) i3);
            float max = Math.max(f, f2);
            Object[] objArr = {Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max)};
            if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(2)) {
                ((FLogDefaultLoggingDelegate) FLog.sHandler).println(2, "DownsampleUtil", FLog.formatString("Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", objArr));
            }
            return max;
        }

        public static int determineSampleSize(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, int i) {
            int i2 = 1;
            if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
                return 1;
            }
            float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
            encodedImage.parseMetaDataIfNeeded();
            int i3 = 2;
            if (encodedImage.mImageFormat == DefaultImageFormats.JPEG) {
                if (determineDownsampleRatio <= 0.6666667f) {
                    i2 = 2;
                    while (true) {
                        int i4 = i2 * 2;
                        double d = 1.0d / ((double) i4);
                        if ((d * 0.3333333432674408d) + d <= ((double) determineDownsampleRatio)) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } else if (determineDownsampleRatio <= 0.6666667f) {
                while (true) {
                    double d2 = (double) i3;
                    if (((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) + (1.0d / d2) <= ((double) determineDownsampleRatio)) {
                        break;
                    }
                    i3++;
                }
                i2 = i3 - 1;
            }
            encodedImage.parseMetaDataIfNeeded();
            int i5 = encodedImage.mHeight;
            encodedImage.parseMetaDataIfNeeded();
            int max = Math.max(i5, encodedImage.mWidth);
            float f = resizeOptions != null ? resizeOptions.maxBitmapSize : (float) i;
            while (((float) (max / i2)) > f) {
                encodedImage.parseMetaDataIfNeeded();
                i2 = encodedImage.mImageFormat == DefaultImageFormats.JPEG ? i2 * 2 : i2 + 1;
            }
            return i2;
        }

        public static synchronized void ensure() {
            synchronized (ConfigurationImplApi17.class) {
                if (!sInitialized) {
                    SoLoader.loadLibrary("native-imagetranscoder");
                    sInitialized = true;
                }
            }
        }

        public static boolean equal(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        public static boolean floatsEqual(float f, float f2) {
            return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) && Float.isNaN(f2) : Math.abs(f2 - f) < 1.0E-5f;
        }

        public static void flushThemedResourcesCache(Object obj) {
            if (!sThemedResourceCacheClazzFetched) {
                try {
                    sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException e) {
                    Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
                }
                sThemedResourceCacheClazzFetched = true;
            }
            Class<?> cls = sThemedResourceCacheClazz;
            if (cls != null) {
                if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        sThemedResourceCache_mUnthemedEntriesField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e2) {
                        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                    }
                    sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
                }
                Field field = sThemedResourceCache_mUnthemedEntriesField;
                if (field != null) {
                    LongSparseArray longSparseArray = null;
                    try {
                        longSparseArray = (LongSparseArray) field.get(obj);
                    } catch (IllegalAccessException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    }
                    if (longSparseArray != null) {
                        longSparseArray.clear();
                    }
                }
            }
        }

        public static String format(String str, Object... objArr) {
            int indexOf;
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
            int i = 0;
            int i2 = 0;
            while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i2)) != -1) {
                sb.append(valueOf.substring(i2, indexOf));
                sb.append(objArr[i]);
                i2 = indexOf + 2;
                i++;
            }
            sb.append(valueOf.substring(i2));
            if (i < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i]);
                for (int i3 = i + 1; i3 < objArr.length; i3++) {
                    sb.append(", ");
                    sb.append(objArr[i3]);
                }
                sb.append(']');
            }
            return sb.toString();
        }

        public static int get2BytesAsInt(InputStream inputStream) throws IOException {
            return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
        }

        public static int getAcceptableSize(int i) {
            return (int) (((float) i) * 1.3333334f);
        }

        public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof ScaleTypeDrawable) {
                return (ScaleTypeDrawable) drawable;
            }
            if (drawable instanceof DrawableParent) {
                return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
            }
            if (drawable instanceof ArrayDrawable) {
                ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
                int length = arrayDrawable.mLayers.length;
                for (int i = 0; i < length; i++) {
                    ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                    if (activeScaleTypeDrawable != null) {
                        return activeScaleTypeDrawable;
                    }
                }
            }
            return null;
        }

        public static int getAutoRotateAngleFromOrientation(int i) {
            if (i == 3) {
                return 180;
            }
            if (i != 6) {
                return i != 8 ? 0 : 270;
            }
            return 90;
        }

        public static int getColumnIndexOrThrow(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static WritableMap getDBError(String str) {
            return getError(null, "Database Error");
        }

        /* JADX INFO: finally extract failed */
        public static InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
            File createTempFile = File.createTempFile("RequestBodyUtil", "temp", context.getApplicationContext().getCacheDir());
            createTempFile.deleteOnExit();
            InputStream openStream = new URL(uri.toString()).openStream();
            try {
                ReadableByteChannel newChannel = Channels.newChannel(openStream);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    try {
                        fileOutputStream.getChannel().transferFrom(newChannel, 0, RecyclerView.FOREVER_NS);
                        FileInputStream fileInputStream = new FileInputStream(createTempFile);
                        fileOutputStream.close();
                        newChannel.close();
                        return fileInputStream;
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    newChannel.close();
                    throw th2;
                }
            } finally {
                openStream.close();
            }
        }

        public static RequestBody getEmptyBody(String str) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH")) {
                return RequestBody.create((MediaType) null, ByteString.EMPTY);
            }
            return null;
        }

        public static WritableMap getError(String str, String str2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("message", str2);
            if (str != null) {
                createMap.putString("key", str);
            }
            return createMap;
        }

        public static InputStream getFileInputStream(Context context, String str) {
            try {
                Uri parse = Uri.parse(str);
                if (parse.getScheme().startsWith("http")) {
                    return getDownloadFileInputStream(context, parse);
                }
                return context.getContentResolver().openInputStream(parse);
            } catch (Exception e) {
                FLog.e("ReactNative", "Could not retrieve file for contentUri " + str, e);
                return null;
            }
        }

        public static <T> ListenableFuture<T> getFuture(CallbackToFutureAdapter$Resolver<T> callbackToFutureAdapter$Resolver) {
            CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer<>();
            CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture<>(callbackToFutureAdapter$Completer);
            callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
            callbackToFutureAdapter$Completer.tag = callbackToFutureAdapter$Resolver.getClass();
            try {
                Object attachCompleter = callbackToFutureAdapter$Resolver.attachCompleter(callbackToFutureAdapter$Completer);
                if (attachCompleter != null) {
                    callbackToFutureAdapter$Completer.tag = attachCompleter;
                }
            } catch (Exception e) {
                callbackToFutureAdapter$SafeFuture.delegate.setException(e);
            }
            return callbackToFutureAdapter$SafeFuture;
        }

        public static int getInt(InputStream inputStream) throws IOException {
            return ((((byte) inputStream.read()) << 24) & -16777216) | ((((byte) inputStream.read()) << 16) & 16711680) | ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
        }

        public static WritableMap getInvalidKeyError(String str) {
            return getError(null, "Invalid key");
        }

        public static WritableMap getInvalidValueError(String str) {
            return getError(null, "Invalid Value");
        }

        public static Long getLong(Map<String, Object> map, String str) {
            Object obj = map.get(str);
            if (obj == null) {
                obj = null;
            }
            Number number = (Number) obj;
            if (number != null) {
                return Long.valueOf(number.longValue());
            }
            return null;
        }

        public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            if (!hasAttribute(xmlPullParser, str)) {
                return i2;
            }
            return typedArray.getColor(i, i2);
        }

        public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
            ComplexColorCompat complexColorCompat;
            if (hasAttribute(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i, typedValue);
                int i3 = typedValue.type;
                if (i3 >= 28 && i3 <= 31) {
                    return new ComplexColorCompat(null, null, typedValue.data);
                }
                try {
                    complexColorCompat = ComplexColorCompat.createFromXml(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                } catch (Exception e) {
                    Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                    complexColorCompat = null;
                }
                if (complexColorCompat != null) {
                    return complexColorCompat;
                }
            }
            return new ComplexColorCompat(null, null, i2);
        }

        public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
            if (!hasAttribute(xmlPullParser, str)) {
                return f;
            }
            return typedArray.getFloat(i, f);
        }

        public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            if (!hasAttribute(xmlPullParser, str)) {
                return i2;
            }
            return typedArray.getInt(i, i2);
        }

        public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
            if (!hasAttribute(xmlPullParser, str)) {
                return null;
            }
            return typedArray.getString(i);
        }

        public static <T> T getOrThrow(Map<String, Object> map, String str) {
            T t = (T) map.get(str);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Missing required parameter ", str));
        }

        public static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
            PropertyValuesHolder propertyValuesHolder;
            int i4;
            int i5;
            int i6;
            float f;
            float f2;
            float f3;
            PropertyValuesHolder propertyValuesHolder2;
            TypedValue peekValue = typedArray.peekValue(i2);
            boolean z = peekValue != null;
            int i7 = z ? peekValue.type : 0;
            TypedValue peekValue2 = typedArray.peekValue(i3);
            boolean z2 = peekValue2 != null;
            int i8 = z2 ? peekValue2.type : 0;
            if (i == 4) {
                i = ((!z || !isColorType(i7)) && (!z2 || !isColorType(i8))) ? 0 : 3;
            }
            boolean z3 = i == 0;
            PropertyValuesHolder propertyValuesHolder3 = null;
            if (i == 2) {
                String string = typedArray.getString(i2);
                String string2 = typedArray.getString(i3);
                PathParser$PathDataNode[] createNodesFromPathData = createNodesFromPathData(string);
                PathParser$PathDataNode[] createNodesFromPathData2 = createNodesFromPathData(string2);
                if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                    return null;
                }
                if (createNodesFromPathData != null) {
                    AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
                    if (createNodesFromPathData2 == null) {
                        propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, createNodesFromPathData);
                    } else if (canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                    return propertyValuesHolder2;
                } else if (createNodesFromPathData2 == null) {
                    return null;
                } else {
                    return PropertyValuesHolder.ofObject(str, new AnimatorInflaterCompat$PathDataEvaluator(), createNodesFromPathData2);
                }
            } else {
                ArgbEvaluator argbEvaluator = i == 3 ? ArgbEvaluator.sInstance : null;
                if (z3) {
                    if (z) {
                        if (i7 == 5) {
                            f2 = typedArray.getDimension(i2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        } else {
                            f2 = typedArray.getFloat(i2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        }
                        if (z2) {
                            if (i8 == 5) {
                                f3 = typedArray.getDimension(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                            } else {
                                f3 = typedArray.getFloat(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                            }
                            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2, f3);
                        } else {
                            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
                        }
                    } else {
                        if (i8 == 5) {
                            f = typedArray.getDimension(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        } else {
                            f = typedArray.getFloat(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f);
                    }
                } else if (z) {
                    if (i7 == 5) {
                        i5 = (int) typedArray.getDimension(i2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    } else if (isColorType(i7)) {
                        i5 = typedArray.getColor(i2, 0);
                    } else {
                        i5 = typedArray.getInt(i2, 0);
                    }
                    if (z2) {
                        if (i8 == 5) {
                            i6 = (int) typedArray.getDimension(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        } else if (isColorType(i8)) {
                            i6 = typedArray.getColor(i3, 0);
                        } else {
                            i6 = typedArray.getInt(i3, 0);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
                    }
                } else {
                    if (z2) {
                        if (i8 == 5) {
                            i4 = (int) typedArray.getDimension(i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        } else if (isColorType(i8)) {
                            i4 = typedArray.getColor(i3, 0);
                        } else {
                            i4 = typedArray.getInt(i3, 0);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
                    }
                    if (propertyValuesHolder3 == null && argbEvaluator != null) {
                        propertyValuesHolder3.setEvaluator(argbEvaluator);
                        return propertyValuesHolder3;
                    }
                }
                propertyValuesHolder3 = propertyValuesHolder;
                return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
            }
        }

        public static Intent getParentActivityIntent(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String parentActivityName = getParentActivityName(activity, activity.getComponentName());
                if (parentActivityName == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, parentActivityName);
                try {
                    if (getParentActivityName(activity, componentName) == null) {
                        return Intent.makeMainActivity(componentName);
                    }
                    return new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
            String string;
            PackageManager packageManager = context.getPackageManager();
            int i = Build.VERSION.SDK_INT;
            int i2 = 640;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                i2 = 269222528;
            } else if (i3 >= 24) {
                i2 = 787072;
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
            String str = activityInfo.parentActivityName;
            if (str != null) {
                return str;
            }
            Bundle bundle = activityInfo.metaData;
            if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
                return null;
            }
            if (string.charAt(0) != '.') {
                return string;
            }
            return context.getPackageName() + string;
        }

        public static Map<String, Object> getPhysicalPixelsMap(DisplayMetrics displayMetrics, double d) {
            HashMap hashMap = new HashMap();
            hashMap.put(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, Integer.valueOf(displayMetrics.widthPixels));
            hashMap.put(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("scale", Float.valueOf(displayMetrics.density));
            hashMap.put("fontScale", Double.valueOf(d));
            hashMap.put("densityDpi", Integer.valueOf(displayMetrics.densityDpi));
            return hashMap;
        }

        public static WritableNativeMap getPhysicalPixelsNativeMap(DisplayMetrics displayMetrics, double d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, displayMetrics.widthPixels);
            writableNativeMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, displayMetrics.heightPixels);
            writableNativeMap.putDouble("scale", (double) displayMetrics.density);
            writableNativeMap.putDouble("fontScale", d);
            writableNativeMap.putDouble("densityDpi", (double) displayMetrics.densityDpi);
            return writableNativeMap;
        }

        public static List<String> getResourceIds(CacheKey cacheKey) {
            try {
                if (cacheKey instanceof MultiCacheKey) {
                    List<CacheKey> list = ((MultiCacheKey) cacheKey).mCacheKeys;
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i = 0; i < list.size(); i++) {
                        arrayList.add(secureHashKey(list.get(i)));
                    }
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(secureHashKey(cacheKey));
                return arrayList2;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        public static File getTempFile(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder outline15 = GeneratedOutlineSupport.outline15(".font");
            outline15.append(Process.myPid());
            outline15.append("-");
            outline15.append(Process.myTid());
            outline15.append("-");
            String sb = outline15.toString();
            for (int i = 0; i < 100; i++) {
                File file = new File(cacheDir, GeneratedOutlineSupport.outline4(sb, i));
                try {
                    if (file.createNewFile()) {
                        return file;
                    }
                } catch (IOException unused) {
                }
            }
            return null;
        }

        public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            if (Build.VERSION.SDK_INT >= 28) {
                return new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
            }
            TextPaint textPaint = new TextPaint(textView.getPaint());
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            int breakStrategy = textView.getBreakStrategy();
            int hyphenationFrequency = textView.getHyphenationFrequency();
            if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            } else {
                boolean z = false;
                if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
                    if (textView.getLayoutDirection() == 1) {
                        z = true;
                    }
                    switch (textView.getTextDirection()) {
                        case 2:
                            textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                            break;
                        case 3:
                            textDirectionHeuristic = TextDirectionHeuristics.LTR;
                            break;
                        case 4:
                            textDirectionHeuristic = TextDirectionHeuristics.RTL;
                            break;
                        case 5:
                            textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                            break;
                        case 6:
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        case 7:
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        default:
                            if (!z) {
                                textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                                break;
                            } else {
                                textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                                break;
                            }
                    }
                } else {
                    byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                    if (directionality == 1 || directionality == 2) {
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    } else {
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    }
                }
            }
            return new PrecomputedTextCompat.Params(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
        }

        public static Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) throws IOException {
            inputStream.skip(7);
            short read = (short) (inputStream.read() & 255);
            short read2 = (short) (inputStream.read() & 255);
            short read3 = (short) (inputStream.read() & 255);
            if (read == 157 && read2 == 1 && read3 == 42) {
                return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
            }
            return null;
        }

        public static Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) throws IOException {
            getInt(inputStream);
            if (((byte) (inputStream.read() & 255)) != 47) {
                return null;
            }
            int read = ((byte) inputStream.read()) & 255;
            return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
        }

        public static YogaMeasureMode getYogaMeasureMode(float f, float f2) {
            if (f == f2) {
                return YogaMeasureMode.EXACTLY;
            }
            if (Float.isInfinite(f2)) {
                return YogaMeasureMode.UNDEFINED;
            }
            return YogaMeasureMode.AT_MOST;
        }

        public static float getYogaSize(float f, float f2) {
            if (f == f2) {
                return toPixelFromDIP(f2);
            }
            if (Float.isInfinite(f2)) {
                return Float.POSITIVE_INFINITY;
            }
            return toPixelFromDIP(f2);
        }

        public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
            return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
        }

        public static int hashCode(int i, int i2) {
            return ((i + 31) * 31) + i2;
        }

        public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
            SimpleDataSource simpleDataSource = new SimpleDataSource();
            simpleDataSource.setFailure(th);
            return simpleDataSource;
        }

        public static void initDisplayMetricsIfNotInitialized(Context context) {
            if (sScreenDisplayMetrics == null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                sWindowDisplayMetrics = displayMetrics;
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                displayMetrics2.setTo(displayMetrics);
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                assertNotNull(windowManager, "WindowManager is null!");
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics2);
                sScreenDisplayMetrics = displayMetrics2;
            }
        }

        public static BackoffPolicy intToBackoffPolicy(int i) {
            if (i == 0) {
                return BackoffPolicy.EXPONENTIAL;
            }
            if (i == 1) {
                return BackoffPolicy.LINEAR;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Could not convert ", i, " to BackoffPolicy"));
        }

        public static NetworkType intToNetworkType(int i) {
            if (i == 0) {
                return NetworkType.NOT_REQUIRED;
            }
            if (i == 1) {
                return NetworkType.CONNECTED;
            }
            if (i == 2) {
                return NetworkType.UNMETERED;
            }
            if (i == 3) {
                return NetworkType.NOT_ROAMING;
            }
            if (i == 4) {
                return NetworkType.METERED;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Could not convert ", i, " to NetworkType"));
        }

        public static WorkInfo$State intToState(int i) {
            if (i == 0) {
                return WorkInfo$State.ENQUEUED;
            }
            if (i == 1) {
                return WorkInfo$State.RUNNING;
            }
            if (i == 2) {
                return WorkInfo$State.SUCCEEDED;
            }
            if (i == 3) {
                return WorkInfo$State.FAILED;
            }
            if (i == 4) {
                return WorkInfo$State.BLOCKED;
            }
            if (i == 5) {
                return WorkInfo$State.CANCELLED;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Could not convert ", i, " to State"));
        }

        public static double[] inverse(double[] dArr) {
            double determinant = determinant(dArr);
            if (isZero(determinant)) {
                return dArr;
            }
            double d = dArr[0];
            double d2 = dArr[1];
            double d3 = dArr[2];
            double d4 = dArr[3];
            double d5 = dArr[4];
            double d6 = dArr[5];
            double d7 = dArr[6];
            double d8 = dArr[7];
            double d9 = dArr[8];
            double d10 = dArr[9];
            double d11 = dArr[10];
            double d12 = dArr[11];
            double d13 = dArr[12];
            double d14 = dArr[13];
            double d15 = dArr[14];
            double d16 = dArr[15];
            double d17 = d7 * d12;
            double d18 = d8 * d11;
            double d19 = d8 * d10;
            double d20 = (d19 * d15) + ((d17 * d14) - (d18 * d14));
            double d21 = d6 * d12;
            double d22 = d7 * d10;
            double d23 = (d20 - (d21 * d15)) - (d22 * d16);
            double d24 = d6 * d11;
            double d25 = d4 * d11;
            double d26 = d3 * d12;
            double d27 = d4 * d10;
            double d28 = d2 * d12;
            double d29 = (d28 * d15) + (((d25 * d14) - (d26 * d14)) - (d27 * d15));
            double d30 = d3 * d10;
            double d31 = (d30 * d16) + d29;
            double d32 = d2 * d11;
            double d33 = d3 * d8;
            double d34 = d4 * d7;
            double d35 = d4 * d6;
            double d36 = (d35 * d15) + ((d33 * d14) - (d34 * d14));
            double d37 = d2 * d8;
            double d38 = d3 * d6;
            double d39 = (d36 - (d37 * d15)) - (d38 * d16);
            double d40 = d2 * d7;
            double d41 = (d37 * d11) + (((d34 * d10) - (d33 * d10)) - (d35 * d11));
            double d42 = (d18 * d13) - (d17 * d13);
            double d43 = d8 * d9;
            double d44 = d5 * d12;
            double d45 = (d44 * d15) + (d42 - (d43 * d15));
            double d46 = d7 * d9;
            double d47 = (d46 * d16) + d45;
            double d48 = d5 * d11;
            double d49 = (d26 * d13) - (d25 * d13);
            double d50 = d4 * d9;
            double d51 = (d50 * d15) + d49;
            double d52 = d * d12;
            double d53 = d3 * d9;
            double d54 = d * d11;
            double d55 = d4 * d5;
            double d56 = d8 * d;
            double d57 = d3 * d5;
            double d58 = d7 * d;
            double d59 = d6 * d9;
            double d60 = (((d43 * d14) + ((d21 * d13) - (d19 * d13))) - (d44 * d14)) - (d59 * d16);
            double d61 = d5 * d10;
            double d62 = d2 * d9;
            double d63 = d62 * d16;
            double d64 = d63 + (d52 * d14) + (((d27 * d13) - (d28 * d13)) - (d50 * d14));
            double d65 = d * d10;
            double d66 = d2 * d5;
            double d67 = d * d6;
            double d68 = d16 * d67;
            double d69 = d66 * d12;
            double d70 = d59 * d15;
            double d71 = d65 * d15;
            double d72 = d67 * d11;
            return new double[]{((d24 * d16) + d23) / determinant, (d31 - (d32 * d16)) / determinant, ((d40 * d16) + d39) / determinant, (((d38 * d12) + d41) - (d40 * d12)) / determinant, (d47 - (d48 * d16)) / determinant, ((d54 * d16) + ((d51 - (d52 * d15)) - (d53 * d16))) / determinant, (((d57 * d16) + ((d56 * d15) + (((d34 * d13) - (d33 * d13)) - (d55 * d15)))) - (d58 * d16)) / determinant, ((d58 * d12) + ((((d55 * d11) + ((d33 * d9) - (d34 * d9))) - (d56 * d11)) - (d57 * d12))) / determinant, ((d61 * d16) + d60) / determinant, (d64 - (d65 * d16)) / determinant, (d68 + ((((d55 * d14) + ((d37 * d13) - (d35 * d13))) - (d56 * d14)) - (d66 * d16))) / determinant, ((d69 + ((d56 * d10) + (((d35 * d9) - (d37 * d9)) - (d55 * d10)))) - (d12 * d67)) / determinant, ((d70 + ((d48 * d14) + (((d22 * d13) - (d24 * d13)) - (d46 * d14)))) - (d61 * d15)) / determinant, (d71 + ((((d53 * d14) + ((d32 * d13) - (d30 * d13))) - (d54 * d14)) - (d62 * d15))) / determinant, (((d66 * d15) + ((d14 * d58) + (((d38 * d13) - (d13 * d40)) - (d57 * d14)))) - (d15 * d67)) / determinant, (d72 + ((((d57 * d10) + ((d40 * d9) - (d38 * d9))) - (d58 * d10)) - (d66 * d11))) / determinant};
        }

        public static boolean isCandidate(Rect rect, Rect rect2, int i) {
            if (i == 17) {
                int i2 = rect.right;
                int i3 = rect2.right;
                return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
            } else if (i == 33) {
                int i4 = rect.bottom;
                int i5 = rect2.bottom;
                return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
            } else if (i == 66) {
                int i6 = rect.left;
                int i7 = rect2.left;
                return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
            } else if (i == 130) {
                int i8 = rect.top;
                int i9 = rect2.top;
                return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        public static boolean isColorType(int i) {
            return i >= 28 && i <= 31;
        }

        public static boolean isEmpty(CharSequence charSequence) {
            return charSequence == null || charSequence.length() == 0;
        }

        public static boolean isImageBigEnough(int i, int i2, ResizeOptions resizeOptions) {
            return resizeOptions == null ? ((float) getAcceptableSize(i)) >= 2048.0f && getAcceptableSize(i2) >= 2048 : getAcceptableSize(i) >= resizeOptions.width && getAcceptableSize(i2) >= resizeOptions.height;
        }

        public static boolean isZero(double d) {
            if (!Double.isNaN(d) && Math.abs(d) < 1.0E-5d) {
                return true;
            }
            return false;
        }

        public static FragmentAnim$AnimationOrAnimator loadAnimation(Context context, FragmentContainer fragmentContainer, Fragment fragment, boolean z) {
            int i;
            int i2;
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            boolean z2 = false;
            if (animationInfo == null) {
                i = 0;
            } else {
                i = animationInfo.mNextTransition;
            }
            int nextAnim = fragment.getNextAnim();
            fragment.setNextAnim(0);
            View onFindViewById = fragmentContainer.onFindViewById(fragment.mContainerId);
            if (!(onFindViewById == null || onFindViewById.getTag(androidx.fragment.R$id.visible_removing_fragment_view_tag) == null)) {
                onFindViewById.setTag(androidx.fragment.R$id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup = fragment.mContainer;
            if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
                return null;
            }
            Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
            if (onCreateAnimation != null) {
                return new FragmentAnim$AnimationOrAnimator(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator();
            if (onCreateAnimator != null) {
                return new FragmentAnim$AnimationOrAnimator(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new FragmentAnim$AnimationOrAnimator(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new FragmentAnim$AnimationOrAnimator(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                            if (loadAnimation2 != null) {
                                return new FragmentAnim$AnimationOrAnimator(loadAnimation2);
                            }
                        } else {
                            throw e2;
                        }
                    }
                }
            }
            if (i == 0) {
                return null;
            }
            if (i != 4097) {
                i2 = i != 4099 ? i != 8194 ? -1 : z ? R$anim.fragment_close_enter : R$anim.fragment_close_exit : z ? R$anim.fragment_fade_enter : R$anim.fragment_fade_exit;
            } else {
                i2 = z ? R$anim.fragment_open_enter : R$anim.fragment_open_exit;
            }
            if (i2 < 0) {
                return null;
            }
            return new FragmentAnim$AnimationOrAnimator(AnimationUtils.loadAnimation(context, i2));
        }

        public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            TypedArray typedArray;
            ValueAnimator valueAnimator2;
            TypedArray typedArray2;
            ValueAnimator valueAnimator3;
            PropertyValuesHolder propertyValuesHolder;
            TypedArray obtainAttributes1 = obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
            TypedArray obtainAttributes12 = obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
            ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
            long namedInt = (long) getNamedInt(obtainAttributes1, xmlPullParser, "duration", 1, 300);
            int i = 0;
            long namedInt2 = (long) getNamedInt(obtainAttributes1, xmlPullParser, "startOffset", 2, 0);
            int namedInt3 = getNamedInt(obtainAttributes1, xmlPullParser, "valueType", 7, 4);
            if (hasAttribute(xmlPullParser, "valueFrom") && hasAttribute(xmlPullParser, "valueTo")) {
                if (namedInt3 == 4) {
                    TypedValue peekValue = obtainAttributes1.peekValue(5);
                    boolean z = peekValue != null;
                    int i2 = z ? peekValue.type : 0;
                    TypedValue peekValue2 = obtainAttributes1.peekValue(6);
                    boolean z2 = peekValue2 != null;
                    namedInt3 = ((!z || !isColorType(i2)) && (!z2 || !isColorType(z2 ? peekValue2.type : 0))) ? 0 : 3;
                }
                PropertyValuesHolder pvh = getPVH(obtainAttributes1, namedInt3, 5, 6, "");
                if (pvh != null) {
                    valueAnimator4.setValues(pvh);
                }
            }
            valueAnimator4.setDuration(namedInt);
            valueAnimator4.setStartDelay(namedInt2);
            valueAnimator4.setRepeatCount(getNamedInt(obtainAttributes1, xmlPullParser, "repeatCount", 3, 0));
            valueAnimator4.setRepeatMode(getNamedInt(obtainAttributes1, xmlPullParser, "repeatMode", 4, 1));
            if (obtainAttributes12 != null) {
                ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
                String namedString = getNamedString(obtainAttributes12, xmlPullParser, "pathData", 1);
                if (namedString != null) {
                    String namedString2 = getNamedString(obtainAttributes12, xmlPullParser, "propertyXName", 2);
                    String namedString3 = getNamedString(obtainAttributes12, xmlPullParser, "propertyYName", 3);
                    if (namedString2 == null && namedString3 == null) {
                        throw new InflateException(obtainAttributes12.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                    }
                    Path createPathFromPathData = createPathFromPathData(namedString);
                    float f2 = 0.5f * f;
                    PathMeasure pathMeasure = new PathMeasure(createPathFromPathData, false);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Float.valueOf((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
                    float f3 = 0.0f;
                    do {
                        f3 += pathMeasure.getLength();
                        arrayList.add(Float.valueOf(f3));
                    } while (pathMeasure.nextContour());
                    PathMeasure pathMeasure2 = new PathMeasure(createPathFromPathData, false);
                    int min = Math.min(100, ((int) (f3 / f2)) + 1);
                    float[] fArr = new float[min];
                    float[] fArr2 = new float[min];
                    float[] fArr3 = new float[2];
                    float f4 = f3 / ((float) (min - 1));
                    valueAnimator2 = valueAnimator4;
                    typedArray = obtainAttributes1;
                    int i3 = 0;
                    float f5 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    while (true) {
                        propertyValuesHolder = null;
                        if (i >= min) {
                            break;
                        }
                        pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
                        fArr[i] = fArr3[0];
                        fArr2[i] = fArr3[1];
                        f5 += f4;
                        int i4 = i3 + 1;
                        if (i4 < arrayList.size() && f5 > ((Float) arrayList.get(i4)).floatValue()) {
                            pathMeasure2.nextContour();
                            i3 = i4;
                        }
                        i++;
                        min = min;
                    }
                    PropertyValuesHolder ofFloat = namedString2 != null ? PropertyValuesHolder.ofFloat(namedString2, fArr) : null;
                    if (namedString3 != null) {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(namedString3, fArr2);
                    }
                    if (ofFloat == null) {
                        i = 0;
                        objectAnimator.setValues(propertyValuesHolder);
                    } else {
                        i = 0;
                        if (propertyValuesHolder == null) {
                            objectAnimator.setValues(ofFloat);
                        } else {
                            objectAnimator.setValues(ofFloat, propertyValuesHolder);
                        }
                    }
                } else {
                    valueAnimator2 = valueAnimator4;
                    typedArray = obtainAttributes1;
                    objectAnimator.setPropertyName(getNamedString(obtainAttributes12, xmlPullParser, "propertyName", 0));
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = obtainAttributes1;
            }
            if (!hasAttribute(xmlPullParser, "interpolator")) {
                typedArray2 = typedArray;
            } else {
                typedArray2 = typedArray;
                i = typedArray2.getResourceId(i, i);
            }
            if (i > 0) {
                valueAnimator3 = valueAnimator2;
                valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i));
            } else {
                valueAnimator3 = valueAnimator2;
            }
            typedArray2.recycle();
            if (obtainAttributes12 != null) {
                obtainAttributes12.recycle();
            }
            return valueAnimator3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd A[ADDED_TO_REGION] */
        public static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean z, boolean z2) {
            Resources resources = context.getResources();
            resources.getValue(i, typedValue, true);
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                String charSequence2 = charSequence.toString();
                Typeface typeface = null;
                if (charSequence2.startsWith("res/")) {
                    Typeface typeface2 = TypefaceCompat.sTypefaceCache.get(TypefaceCompat.createResourceUid(resources, i, i2));
                    if (typeface2 != null) {
                        if (resourcesCompat$FontCallback != null) {
                            resourcesCompat$FontCallback.callbackSuccessAsync(typeface2, handler);
                        }
                    } else if (!z2) {
                        try {
                            if (charSequence2.toLowerCase().endsWith(".xml")) {
                                FontResourcesParserCompat$FamilyResourceEntry parse = parse(resources.getXml(i), resources);
                                if (parse == null) {
                                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                                    if (resourcesCompat$FontCallback != null) {
                                        resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                                    }
                                } else {
                                    typeface = TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, resourcesCompat$FontCallback, handler, z);
                                }
                            } else {
                                typeface2 = TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, i2);
                                if (resourcesCompat$FontCallback != null) {
                                    if (typeface2 != null) {
                                        resourcesCompat$FontCallback.callbackSuccessAsync(typeface2, handler);
                                    } else {
                                        resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                                    }
                                }
                            }
                        } catch (XmlPullParserException e) {
                            Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence2, e);
                            if (resourcesCompat$FontCallback != null) {
                                resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                            }
                            if (typeface == null) {
                            }
                            return typeface;
                        } catch (IOException e2) {
                            Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence2, e2);
                            if (resourcesCompat$FontCallback != null) {
                            }
                            if (typeface == null) {
                            }
                            return typeface;
                        }
                    }
                    typeface = typeface2;
                } else if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                }
                if (typeface == null || resourcesCompat$FontCallback != null || z2) {
                    return typeface;
                }
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Font resource ID #0x");
                outline15.append(Integer.toHexString(i));
                outline15.append(" could not be retrieved.");
                throw new Resources.NotFoundException(outline15.toString());
            }
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Resource \"");
            outline152.append(resources.getResourceName(i));
            outline152.append("\" (");
            outline152.append(Integer.toHexString(i));
            outline152.append(") is not a Font: ");
            outline152.append(typedValue);
            throw new Resources.NotFoundException(outline152.toString());
        }

        public static int majorAxisDistance(int i, Rect rect, Rect rect2) {
            int i2;
            int i3;
            if (i == 17) {
                i3 = rect.left;
                i2 = rect2.right;
            } else if (i == 33) {
                i3 = rect.top;
                i2 = rect2.bottom;
            } else if (i == 66) {
                i3 = rect2.left;
                i2 = rect.right;
            } else if (i == 130) {
                i3 = rect2.top;
                i2 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return Math.max(0, i3 - i2);
        }

        /* JADX INFO: finally extract failed */
        public static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) throws JSONException {
            String str3;
            Cursor query = sQLiteDatabase.query("catalystLocalStorage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst()) {
                    query.close();
                    str3 = null;
                } else {
                    str3 = query.getString(0);
                    query.close();
                }
                if (str3 != null) {
                    JSONObject jSONObject = new JSONObject(str3);
                    deepMergeInto(jSONObject, new JSONObject(str2));
                    str2 = jSONObject.toString();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("value", str2);
                return -1 != sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, contentValues, 5);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }

        public static int minorAxisDistance(int i, Rect rect, Rect rect2) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
            }
            return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
        }

        public static void mkdirs(File file) throws FileUtils$CreateDirectoryException {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    if (!file.delete()) {
                        throw new FileUtils$CreateDirectoryException(file.getAbsolutePath(), new FileUtils$FileDeleteException(file.getAbsolutePath()));
                    }
                } else {
                    return;
                }
            }
            if (!file.mkdirs() && !file.isDirectory()) {
                throw new FileUtils$CreateDirectoryException(file.getAbsolutePath());
            }
        }

        public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return map;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
                throw th;
            } catch (IOException unused) {
                return null;
            }
        }

        public static int multiplyColorAlpha(int i, int i2) {
            if (i2 == 255) {
                return i;
            }
            if (i2 == 0) {
                return i & 16777215;
            }
            return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
        }

        public static void multiplyVectorByMatrix(double[] dArr, double[] dArr2, double[] dArr3) {
            double d = dArr[0];
            double d2 = dArr[1];
            double d3 = dArr[2];
            double d4 = dArr[3];
            dArr3[0] = (dArr2[12] * d4) + (dArr2[8] * d3) + (dArr2[4] * d2) + (dArr2[0] * d);
            dArr3[1] = (dArr2[13] * d4) + (dArr2[9] * d3) + (dArr2[5] * d2) + (dArr2[1] * d);
            dArr3[2] = (dArr2[14] * d4) + (dArr2[10] * d3) + (dArr2[6] * d2) + (dArr2[2] * d);
            double d5 = d * dArr2[3];
            double d6 = d3 * dArr2[11];
            dArr3[3] = (d4 * dArr2[15]) + d6 + (d2 * dArr2[7]) + d5;
        }

        public static TypedArray obtainAttributes1(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
            if (theme == null) {
                return resources.obtainAttributes(attributeSet, iArr);
            }
            return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }

        public static <K, V> Map<K, V> of(K k, V v) {
            HashMap hashMap = new HashMap();
            hashMap.put(k, v);
            return hashMap;
        }

        public static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }

        public static InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo, View view) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof WithHint) {
                        editorInfo.hintText = ((WithHint) parent).getHint();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }

        public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }

        public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
            } else if (i3 == 0) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                }
            }
        }

        public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent3) {
                ((NestedScrollingParent3) viewParent).onNestedScroll(view, i, i2, i3, i4, i5, iArr);
                return;
            }
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
                }
            }
        }

        public static void onRequestError(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, String str, Throwable th) {
            WritableArray createArray = Arguments.createArray();
            createArray.pushInt(i);
            createArray.pushString(str);
            if (th != null && th.getClass() == SocketTimeoutException.class) {
                createArray.pushBoolean(true);
            }
            if (rCTDeviceEventEmitter != null) {
                rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
            }
        }

        public static void onRequestSuccess(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i) {
            WritableArray createArray = Arguments.createArray();
            createArray.pushInt(i);
            createArray.pushNull();
            if (rCTDeviceEventEmitter != null) {
                rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
            }
        }

        public static FontResourcesParserCompat$FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
            int next;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                xmlPullParser.require(2, null, "font-family");
                if (xmlPullParser.getName().equals("font-family")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
                    String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
                    String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
                    String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
                    int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
                    int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
                    int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, FpsView.UPDATE_INTERVAL_MS);
                    obtainAttributes.recycle();
                    if (string == null || string2 == null || string3 == null) {
                        ArrayList arrayList = new ArrayList();
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (xmlPullParser.getName().equals("font")) {
                                    TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
                                    if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontWeight)) {
                                        i = R$styleable.FontFamilyFont_fontWeight;
                                    } else {
                                        i = R$styleable.FontFamilyFont_android_fontWeight;
                                    }
                                    int i6 = obtainAttributes2.getInt(i, 400);
                                    if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontStyle)) {
                                        i2 = R$styleable.FontFamilyFont_fontStyle;
                                    } else {
                                        i2 = R$styleable.FontFamilyFont_android_fontStyle;
                                    }
                                    boolean z = 1 == obtainAttributes2.getInt(i2, 0);
                                    if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_ttcIndex)) {
                                        i3 = R$styleable.FontFamilyFont_ttcIndex;
                                    } else {
                                        i3 = R$styleable.FontFamilyFont_android_ttcIndex;
                                    }
                                    if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontVariationSettings)) {
                                        i4 = R$styleable.FontFamilyFont_fontVariationSettings;
                                    } else {
                                        i4 = R$styleable.FontFamilyFont_android_fontVariationSettings;
                                    }
                                    String string4 = obtainAttributes2.getString(i4);
                                    int i7 = obtainAttributes2.getInt(i3, 0);
                                    if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_font)) {
                                        i5 = R$styleable.FontFamilyFont_font;
                                    } else {
                                        i5 = R$styleable.FontFamilyFont_android_font;
                                    }
                                    int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                                    String string5 = obtainAttributes2.getString(i5);
                                    obtainAttributes2.recycle();
                                    while (xmlPullParser.next() != 3) {
                                        skip(xmlPullParser);
                                    }
                                    arrayList.add(new FontResourcesParserCompat$FontFileResourceEntry(string5, i6, z, string4, i7, resourceId2));
                                } else {
                                    skip(xmlPullParser);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new FontResourcesParserCompat$FontFamilyFilesResourceEntry((FontResourcesParserCompat$FontFileResourceEntry[]) arrayList.toArray(new FontResourcesParserCompat$FontFileResourceEntry[arrayList.size()]));
                    }
                    while (xmlPullParser.next() != 3) {
                        skip(xmlPullParser);
                    }
                    return new FontResourcesParserCompat$ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
                }
                skip(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
            long j;
            long j2;
            boolean z;
            long j3;
            long j4;
            long j5;
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> map = networkResponse.headers;
            String str = map.get("Date");
            long parseDateAsEpoch = str != null ? parseDateAsEpoch(str) : 0;
            String str2 = map.get("Cache-Control");
            int i = 0;
            if (str2 != null) {
                String[] split = str2.split(",", 0);
                int i2 = 0;
                j2 = 0;
                j = 0;
                while (i < split.length) {
                    String trim = split[i].trim();
                    if (trim.equals("no-cache") || trim.equals("no-store")) {
                        return null;
                    }
                    if (trim.startsWith("max-age=")) {
                        try {
                            j2 = Long.parseLong(trim.substring(8));
                        } catch (Exception unused) {
                        }
                    } else if (trim.startsWith("stale-while-revalidate=")) {
                        j = Long.parseLong(trim.substring(23));
                    } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                        i2 = 1;
                    }
                    i++;
                }
                i = i2;
                z = true;
            } else {
                z = false;
                j2 = 0;
                j = 0;
            }
            String str3 = map.get("Expires");
            long parseDateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0;
            String str4 = map.get("Last-Modified");
            long parseDateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0;
            String str5 = map.get("ETag");
            if (z) {
                j4 = currentTimeMillis + (j2 * 1000);
                if (i != 0) {
                    j5 = j4;
                } else {
                    Long.signum(j);
                    j5 = (j * 1000) + j4;
                }
                j3 = j5;
            } else {
                j3 = 0;
                if (parseDateAsEpoch <= 0 || parseDateAsEpoch2 < parseDateAsEpoch) {
                    j4 = 0;
                } else {
                    j4 = currentTimeMillis + (parseDateAsEpoch2 - parseDateAsEpoch);
                    j3 = j4;
                }
            }
            Cache.Entry entry = new Cache.Entry();
            entry.data = networkResponse.data;
            entry.etag = str5;
            entry.softTtl = j4;
            entry.ttl = j3;
            entry.lastModified = parseDateAsEpoch3;
            entry.responseHeaders = map;
            entry.allResponseHeaders = networkResponse.allHeaders;
            return entry;
        }

        public static String parseCharset(Map<String, String> map, String str) {
            String str2 = map.get("Content-Type");
            if (str2 != null) {
                String[] split = str2.split(";", 0);
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
            return str;
        }

        public static long parseDateAsEpoch(String str) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                Log.e("Volley", VolleyLog.buildMessage("Unable to parse dateStr: %s, falling back to 0", str), e);
                return 0;
            }
        }

        public static void propagateIfPossible(Throwable th) {
            if (Error.class.isInstance(th)) {
                throw ((Throwable) Error.class.cast(th));
            } else if (RuntimeException.class.isInstance(th)) {
                throw ((Throwable) RuntimeException.class.cast(th));
            }
        }

        public static int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = 0;
                while (i3 < i2) {
                    int read = inputStream.read(bArr, i + i3, i2 - i3);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                }
                return i3;
            }
            throw new IndexOutOfBoundsException("len is negative");
        }

        public static int read3Bytes(InputStream inputStream) throws IOException {
            return ((((byte) (inputStream.read() & 255)) << 16) & 16711680) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (((byte) (inputStream.read() & 255)) & 255);
        }

        public static List<List<byte[]>> readCerts(Resources resources, int i) {
            if (i == 0) {
                return Collections.emptyList();
            }
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            try {
                if (obtainTypedArray.length() == 0) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                if (obtainTypedArray.getType(0) == 1) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        int resourceId = obtainTypedArray.getResourceId(i2, 0);
                        if (resourceId != 0) {
                            arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(toByteArrayList(resources.getStringArray(i)));
                }
                obtainTypedArray.recycle();
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }

        public static int readPackedInt(InputStream inputStream, int i, boolean z) throws IOException {
            int i2;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int read = inputStream.read();
                if (read != -1) {
                    if (z) {
                        i2 = (read & 255) << (i4 * 8);
                    } else {
                        i3 <<= 8;
                        i2 = read & 255;
                    }
                    i3 |= i2;
                } else {
                    throw new IOException("no more bytes");
                }
            }
            return i3;
        }

        public static void rename(File file, File file2) throws FileUtils$RenameException {
            Throwable th = null;
            if (file != null) {
                file2.delete();
                if (!file.renameTo(file2)) {
                    if (file2.exists()) {
                        th = new FileUtils$FileDeleteException(file2.getAbsolutePath());
                    } else if (!file.getParentFile().exists()) {
                        th = new FileUtils$ParentDirNotFoundException(file.getAbsolutePath());
                    } else if (!file.exists()) {
                        th = new FileNotFoundException(file.getAbsolutePath());
                    }
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unknown error renaming ");
                    outline15.append(file.getAbsolutePath());
                    outline15.append(" to ");
                    outline15.append(file2.getAbsolutePath());
                    throw new FileUtils$RenameException(outline15.toString(), th);
                }
                return;
            }
            throw null;
        }

        public static void resetIdentityMatrix(double[] dArr) {
            dArr[14] = 0.0d;
            dArr[13] = 0.0d;
            dArr[12] = 0.0d;
            dArr[11] = 0.0d;
            dArr[9] = 0.0d;
            dArr[8] = 0.0d;
            dArr[7] = 0.0d;
            dArr[6] = 0.0d;
            dArr[4] = 0.0d;
            dArr[3] = 0.0d;
            dArr[2] = 0.0d;
            dArr[1] = 0.0d;
            dArr[15] = 1.0d;
            dArr[10] = 1.0d;
            dArr[5] = 1.0d;
            dArr[0] = 1.0d;
        }

        public static double roundTo3Places(double d) {
            return ((double) Math.round(d * 1000.0d)) * 0.001d;
        }

        public static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
            byte[] bytes = cacheKey.getUriString().getBytes("UTF-8");
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(bytes, 0, bytes.length);
                return Base64.encodeToString(instance.digest(), 11);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public static void setCallbacks(Drawable drawable, Drawable.Callback callback, TransformCallback transformCallback) {
            if (drawable != null) {
                drawable.setCallback(callback);
                if (drawable instanceof TransformAwareDrawable) {
                    ((TransformAwareDrawable) drawable).setTransformCallback(transformCallback);
                }
            }
        }

        public static void setDrawableProperties(Drawable drawable, DrawableProperties drawableProperties) {
            if (drawable != null && drawableProperties != null) {
                int i = drawableProperties.mAlpha;
                if (i != -1) {
                    drawable.setAlpha(i);
                }
                if (drawableProperties.mIsSetColorFilter) {
                    drawable.setColorFilter(drawableProperties.mColorFilter);
                }
                int i2 = drawableProperties.mDither;
                boolean z = true;
                if (i2 != -1) {
                    drawable.setDither(i2 != 0);
                }
                int i3 = drawableProperties.mFilterBitmap;
                if (i3 != -1) {
                    if (i3 == 0) {
                        z = false;
                    }
                    drawable.setFilterBitmap(z);
                }
            }
        }

        public static void setFirstBaselineToTopHeight(TextView textView, int i) {
            int i2;
            checkArgumentNonnegative(i);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setFirstBaselineToTopHeight(i);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.top;
            } else {
                i2 = fontMetricsInt.ascent;
            }
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
            }
        }

        public static void setLastBaselineToBottomHeight(TextView textView, int i) {
            int i2;
            checkArgumentNonnegative(i);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.bottom;
            } else {
                i2 = fontMetricsInt.descent;
            }
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
            }
        }

        public static void setLineHeight(TextView textView, int i) {
            checkArgumentNonnegative(i);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i != fontMetricsInt) {
                textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
            }
        }

        public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
            if (Build.VERSION.SDK_INT < 29) {
                getTextMetricsParams(textView);
                if (precomputedTextCompat != null) {
                    throw null;
                }
                throw null;
            } else if (precomputedTextCompat != null) {
                textView.setText((CharSequence) null);
            } else {
                throw null;
            }
        }

        public static void setTint(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        public static void setTooltipText(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            TooltipCompatHandler tooltipCompatHandler = TooltipCompatHandler.sPendingHandler;
            if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
                TooltipCompatHandler.setPendingHandler(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TooltipCompatHandler tooltipCompatHandler2 = TooltipCompatHandler.sActiveHandler;
                if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
                    tooltipCompatHandler2.hide();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new TooltipCompatHandler(view, charSequence);
        }

        public static long skip(InputStream inputStream, long j) throws IOException {
            checkArgument(j >= 0);
            long j2 = j;
            while (j2 > 0) {
                long skip = inputStream.skip(j2);
                if (skip <= 0) {
                    if (inputStream.read() == -1) {
                        return j - j2;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j;
        }

        public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                throw null;
            } else if (bArr2 == null) {
                throw null;
            } else if (bArr2.length > bArr.length) {
                return false;
            } else {
                for (int i = 0; i < bArr2.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }

        public static int stateToInt(WorkInfo$State workInfo$State) {
            int ordinal = workInfo$State.ordinal();
            if (ordinal == 0) {
                return 0;
            }
            int i = 1;
            if (ordinal != 1) {
                i = 2;
                if (ordinal != 2) {
                    i = 3;
                    if (ordinal != 3) {
                        i = 4;
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return 5;
                            }
                            throw new IllegalArgumentException("Could not convert " + workInfo$State + " to int");
                        }
                    }
                }
            }
            return i;
        }

        public static List<byte[]> toByteArrayList(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        public static float toDIPFromPixel(float f) {
            return f / sWindowDisplayMetrics.density;
        }

        public static float toPixelFromDIP(double d) {
            return toPixelFromDIP((float) d);
        }

        public static float toPixelFromSP(float f) {
            return toPixelFromSP(f, Float.NaN);
        }

        public static float toSPFromPixel(float f) {
            return f / sScreenDisplayMetrics.scaledDensity;
        }

        public static Objects$ToStringHelper toStringHelper(Object obj) {
            String replaceAll = obj.getClass().getName().replaceAll("\\$[0-9]+", "\\$");
            int lastIndexOf = replaceAll.lastIndexOf(36);
            if (lastIndexOf == -1) {
                lastIndexOf = replaceAll.lastIndexOf(46);
            }
            return new Objects$ToStringHelper(replaceAll.substring(lastIndexOf + 1), null);
        }

        public static final WritableMap toWritableMap(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "$this$toWritableMap");
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            for (T t : map.entrySet()) {
                String str = (String) t.getKey();
                Object value = t.getValue();
                if (value == null) {
                    writableNativeMap.putNull(str);
                } else if (value instanceof Boolean) {
                    writableNativeMap.putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    writableNativeMap.putInt(str, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    writableNativeMap.putDouble(str, (double) ((Number) value).longValue());
                } else if (value instanceof Number) {
                    writableNativeMap.putDouble(str, ((Number) value).doubleValue());
                } else if (value instanceof String) {
                    writableNativeMap.putString(str, (String) value);
                } else if (value instanceof Map) {
                    writableNativeMap.putMap(str, Arguments.makeNativeMap(TypeIntrinsics.asMutableMap(value)));
                } else if (value instanceof Collection) {
                    Object[] array = ((Collection) value).toArray(new Object[0]);
                    if (array != null) {
                        writableNativeMap.putArray(str, Arguments.makeNativeArray(array));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    throw new IllegalArgumentException("Could not convert " + value + " to native map");
                }
            }
            return writableNativeMap;
        }

        public static double[] transpose(double[] dArr) {
            return new double[]{dArr[0], dArr[4], dArr[8], dArr[12], dArr[1], dArr[5], dArr[9], dArr[13], dArr[2], dArr[6], dArr[10], dArr[14], dArr[3], dArr[7], dArr[11], dArr[15]};
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Drawable> T unwrap(Drawable drawable) {
            return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
        }

        public static double[] v3Combine(double[] dArr, double[] dArr2, double d, double d2) {
            return new double[]{(dArr2[0] * d2) + (dArr[0] * d), (dArr2[1] * d2) + (dArr[1] * d), (d2 * dArr2[2]) + (d * dArr[2])};
        }

        public static double[] v3Cross(double[] dArr, double[] dArr2) {
            return new double[]{(dArr[1] * dArr2[2]) - (dArr[2] * dArr2[1]), (dArr[2] * dArr2[0]) - (dArr[0] * dArr2[2]), (dArr[0] * dArr2[1]) - (dArr[1] * dArr2[0])};
        }

        public static double v3Dot(double[] dArr, double[] dArr2) {
            return (dArr[2] * dArr2[2]) + (dArr[1] * dArr2[1]) + (dArr[0] * dArr2[0]);
        }

        public static double v3Length(double[] dArr) {
            return Math.sqrt((dArr[2] * dArr[2]) + (dArr[1] * dArr[1]) + (dArr[0] * dArr[0]));
        }

        public static double[] v3Normalize(double[] dArr, double d) {
            if (isZero(d)) {
                d = v3Length(dArr);
            }
            double d2 = 1.0d / d;
            return new double[]{dArr[0] * d2, dArr[1] * d2, dArr[2] * d2};
        }

        public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
            fileTreeVisitor.preVisitDirectory(file);
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        walkFileTree(file2, fileTreeVisitor);
                    } else {
                        fileTreeVisitor.visitFile(file2);
                    }
                }
            }
            fileTreeVisitor.postVisitDirectory(file);
        }

        public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
            int i = Build.VERSION.SDK_INT;
            return (i < 26 || i > 27 || (callback instanceof TextViewCompat$OreoCallback)) ? callback : new TextViewCompat$OreoCallback(callback, textView);
        }

        public static void assertCondition(boolean z, String str) {
            if (!z) {
                throw new AssertionError(str);
            }
        }

        public static <T> T assertNotNull(T t, String str) {
            if (t != null) {
                return t;
            }
            throw new AssertionError(str);
        }

        public static <T> T checkNotNull(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static <T> T checkNotNull1(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static void checkState(boolean z, Object obj) {
            if (!z) {
                throw new IllegalStateException(String.valueOf(obj));
            }
        }

        public static float toPixelFromDIP(float f) {
            return TypedValue.applyDimension(1, f, sWindowDisplayMetrics);
        }

        public static float toPixelFromSP(float f, float f2) {
            DisplayMetrics displayMetrics = sWindowDisplayMetrics;
            float f3 = displayMetrics.scaledDensity;
            float f4 = displayMetrics.density;
            float f5 = f3 / f4;
            if (f2 >= 1.0f && f2 < f5) {
                f3 = f4 * f2;
            }
            return f * f3;
        }

        public static <K, V> Map<K, V> of(K k, V v, K k2, V v2) {
            HashMap hashMap = new HashMap();
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            return hashMap;
        }

        public static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            int i = 1;
            while (i > 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
        }

        public static boolean isImageBigEnough(EncodedImage encodedImage, ResizeOptions resizeOptions) {
            if (encodedImage == null) {
                return false;
            }
            int rotationAngle = encodedImage.getRotationAngle();
            if (rotationAngle == 90 || rotationAngle == 270) {
                encodedImage.parseMetaDataIfNeeded();
                int i = encodedImage.mHeight;
                encodedImage.parseMetaDataIfNeeded();
                return isImageBigEnough(i, encodedImage.mWidth, resizeOptions);
            }
            encodedImage.parseMetaDataIfNeeded();
            int i2 = encodedImage.mWidth;
            encodedImage.parseMetaDataIfNeeded();
            return isImageBigEnough(i2, encodedImage.mHeight, resizeOptions);
        }

        public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
            HashMap hashMap = new HashMap();
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            return hashMap;
        }

        public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
            String parentActivityName = getParentActivityName(context, componentName);
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
            if (getParentActivityName(context, componentName2) == null) {
                return Intent.makeMainActivity(componentName2);
            }
            return new Intent().setComponent(componentName2);
        }

        public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
            HashMap hashMap = new HashMap();
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            hashMap.put(k4, v4);
            return hashMap;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
        public static boolean copyToFile(File file, Resources resources, int i) {
            InputStream inputStream;
            Throwable th;
            try {
                inputStream = resources.openRawResource(i);
                try {
                    boolean copyToFile = copyToFile(file, inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return copyToFile;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context, null);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public static final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ViewGroup decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public Context listPresenterContext;
        public MenuBuilder menu;
        public boolean qwertyMode;
        public boolean refreshDecorView = false;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;

        public PanelFeatureState(int i) {
            this.featureId = i;
        }

        public void setMenu(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter2;
            MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter2 = this.listMenuPresenter) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter2, menuBuilder.mContext);
                }
            }
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
            if (findMenuPanel == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                AppCompatDelegateImpl.this.closePanel(findMenuPanel, true);
                return;
            }
            AppCompatDelegateImpl.this.closePanel(findMenuPanel, z);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.mHasActionBar || (windowCallback = appCompatDelegateImpl.getWindowCallback()) == null || AppCompatDelegateImpl.this.mIsDestroyed) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        if (IS_PRE_LOLLIPOP && !sInstalledExceptionHandler) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass1 */

                public void uncaughtException(Thread thread, Throwable th) {
                    String message;
                    boolean z = false;
                    if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                        z = true;
                    }
                    if (z) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        Integer orDefault;
        AppCompatActivity appCompatActivity;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (this.mLocalNightMode == -100 && (obj instanceof Dialog)) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100 && (orDefault = sLocalNightModes.getOrDefault(this.mHost.getClass().getName(), null)) != null) {
            this.mLocalNightMode = orDefault.intValue();
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    public final void attachToWindow(Window window) {
        if (this.mWindow == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.mAppCompatWindowCallback = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.mWrapped.recycle();
                this.mWindow = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null && panelFeatureState != null) {
            menu = panelFeatureState.menu;
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mIsDestroyed) {
            this.mAppCompatWindowCallback.mWrapped.onPanelClosed(i, menu);
        }
    }

    public void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null && !this.mIsDestroyed) {
                windowCallback.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    public void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z || panelFeatureState.featureId != 0 || (decorContentParent = this.mDecorContentParent) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.isOpen || (viewGroup = panelFeatureState.decorView) == null)) {
                windowManager.removeView(viewGroup);
                if (z) {
                    callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
                }
            }
            panelFeatureState.isPrepared = false;
            panelFeatureState.isHandled = false;
            panelFeatureState.isOpen = false;
            panelFeatureState.shownPanelView = null;
            panelFeatureState.refreshDecorView = true;
            if (this.mPreparedPanel == panelFeatureState) {
                this.mPreparedPanel = null;
                return;
            }
            return;
        }
        checkCloseActionMenu(panelFeatureState.menu);
    }

    public final Configuration createOverrideConfigurationForDayNight(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        View decorView;
        Object obj = this.mHost;
        boolean z4 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.mWindow.getDecorView()) != null && ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.mWrapped.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & 128) == 0) {
                    z4 = false;
                }
                this.mLongPressBackDown = z4;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                PanelFeatureState panelState = getPanelState(0);
                if (panelState.isOpen) {
                    return true;
                }
                preparePanel(panelState, keyEvent);
                return true;
            }
        } else if (keyCode == 4) {
            boolean z5 = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            PanelFeatureState panelState2 = getPanelState(0);
            if (!panelState2.isOpen) {
                androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
                if (actionMode != null) {
                    actionMode.finish();
                } else {
                    initWindowDecorActionBar();
                    ActionBar actionBar = this.mActionBar;
                    if (actionBar == null || !actionBar.collapseActionView()) {
                        z = false;
                        if (z) {
                            return true;
                        }
                    }
                }
                z = true;
                if (z) {
                }
            } else if (z5) {
                return true;
            } else {
                closePanel(panelState2, true);
                return true;
            }
        } else if (keyCode == 82) {
            if (this.mActionMode != null) {
                return true;
            }
            PanelFeatureState panelState3 = getPanelState(0);
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && !ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                if (this.mDecorContentParent.isOverflowMenuShowing()) {
                    z2 = this.mDecorContentParent.hideOverflowMenu();
                } else if (!this.mIsDestroyed && preparePanel(panelState3, keyEvent)) {
                    z2 = this.mDecorContentParent.showOverflowMenu();
                }
                if (z2) {
                }
            } else if (panelState3.isOpen || panelState3.isHandled) {
                z2 = panelState3.isOpen;
                closePanel(panelState3, true);
                if (z2) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
            } else if (panelState3.isPrepared) {
                if (panelState3.refreshMenuContent) {
                    panelState3.isPrepared = false;
                    z3 = preparePanel(panelState3, keyEvent);
                } else {
                    z3 = true;
                }
                if (z3) {
                    openPanel(panelState3, keyEvent);
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
        }
        return false;
    }

    public void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.mSubDecorInstalled) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(androidx.appcompat.R$styleable.AppCompatTheme_windowActionBar)) {
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowActionBar, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.mIsFloating = obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                ensureWindow();
                this.mWindow.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (this.mWindowNoTitle) {
                    viewGroup = this.mOverlayActionMode ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.mIsFloating) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                    this.mOverlayActionBar = false;
                    this.mHasActionBar = false;
                } else if (this.mHasActionBar) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                    } else {
                        context = this.mContext;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R$id.decor_content_parent);
                    this.mDecorContentParent = decorContentParent;
                    decorContentParent.setWindowCallback(getWindowCallback());
                    if (this.mOverlayActionBar) {
                        this.mDecorContentParent.initFeature(109);
                    }
                    if (this.mFeatureProgress) {
                        this.mDecorContentParent.initFeature(2);
                    }
                    if (this.mFeatureIndeterminateProgress) {
                        this.mDecorContentParent.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass3 */

                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            int updateStatusGuard = AppCompatDelegateImpl.this.updateStatusGuard(windowInsetsCompat, null);
                            if (systemWindowInsetTop != updateStatusGuard) {
                                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), updateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                        }
                    });
                    if (this.mDecorContentParent == null) {
                        this.mTitleView = (TextView) viewGroup.findViewById(R$id.title);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.mWindow.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass5 */
                    });
                    this.mSubDecor = viewGroup;
                    Object obj = this.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.mTitle;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.mDecorContentParent;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.mActionBar;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.mTitleView;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(16908290);
                    View decorView = this.mWindow.getDecorView();
                    contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
                        obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
                        obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
                        obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
                        obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.mSubDecorInstalled = true;
                    PanelFeatureState panelState = getPanelState(0);
                    if (!this.mIsDestroyed && panelState.menu == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("AppCompat does not support the current theme features: { windowActionBar: ");
                outline15.append(this.mHasActionBar);
                outline15.append(", windowActionBarOverlay: ");
                outline15.append(this.mOverlayActionBar);
                outline15.append(", android:windowIsFloating: ");
                outline15.append(this.mIsFloating);
                outline15.append(", windowActionModeOverlay: ");
                outline15.append(this.mOverlayActionMode);
                outline15.append(", windowNoTitle: ");
                outline15.append(this.mWindowNoTitle);
                outline15.append(" }");
                throw new IllegalArgumentException(outline15.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final AutoNightModeManager getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (TwilightManager.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                TwilightManager.sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    public PanelFeatureState getPanelState(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar == null || !actionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    public int mapNightMode(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (!(i == 1 || i == 2)) {
                    if (i == 3) {
                        if (this.mAutoBatteryNightModeManager == null) {
                            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(context);
                        }
                        return this.mAutoBatteryNightModeManager.getApplyableNightMode();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                return -1;
            } else {
                return getAutoTimeNightModeManager(context).getApplyableNightMode();
            }
        }
        return i;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = ConfigurationImplApi17.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference<>(this));
            }
        }
        this.mCreated = true;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.mAppCompatViewInflater == null) {
            String string = this.mContext.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme).getString(androidx.appcompat.R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        AppCompatViewInflater appCompatViewInflater = this.mAppCompatViewInflater;
        VectorEnabledTintResources.shouldBeUsed();
        return appCompatViewInflater.createView(view, str, context, attributeSet, false, false, true, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        ActionBar actionBar;
        AutoNightModeManager autoNightModeManager;
        AutoNightModeManager autoNightModeManager2;
        if (this.mHost instanceof Activity) {
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
            }
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
                actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.onDestroy();
                }
                autoNightModeManager = this.mAutoTimeNightModeManager;
                if (autoNightModeManager != null) {
                    autoNightModeManager.cleanup();
                }
                autoNightModeManager2 = this.mAutoBatteryNightModeManager;
                if (autoNightModeManager2 == null) {
                    autoNightModeManager2.cleanup();
                    return;
                }
                return;
            }
        }
        sLocalNightModes.remove(this.mHost.getClass().getName());
        actionBar = this.mActionBar;
        if (actionBar != null) {
        }
        autoNightModeManager = this.mAutoTimeNightModeManager;
        if (autoNightModeManager != null) {
        }
        autoNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoNightModeManager2 == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState findMenuPanel;
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback == null || this.mIsDestroyed || (findMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState panelState = getPanelState(0);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing()) {
            this.mDecorContentParent.hideOverflowMenu();
            if (!this.mIsDestroyed) {
                windowCallback.onPanelClosed(108, getPanelState(0).menu);
            }
        } else if (windowCallback != null && !this.mIsDestroyed) {
            if (this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
                this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState panelState2 = getPanelState(0);
            MenuBuilder menuBuilder2 = panelState2.menu;
            if (menuBuilder2 != null && !panelState2.refreshMenuContent && windowCallback.onPreparePanel(0, panelState2.createdPanelView, menuBuilder2)) {
                windowCallback.onMenuOpened(108, panelState2.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015c, code lost:
        if (r3 != null) goto L_0x015e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
    public final void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.isOpen && !this.mIsDestroyed) {
            if (panelFeatureState.featureId == 0) {
                if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback == null || windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.decorView == null || panelFeatureState.refreshDecorView) {
                        ViewGroup viewGroup = panelFeatureState.decorView;
                        ExpandedMenuView expandedMenuView = null;
                        if (viewGroup == null) {
                            initWindowDecorActionBar();
                            ActionBar actionBar = this.mActionBar;
                            Context themedContext = actionBar != null ? actionBar.getThemedContext() : null;
                            if (themedContext == null) {
                                themedContext = this.mContext;
                            }
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme newTheme = themedContext.getResources().newTheme();
                            newTheme.setTo(themedContext.getTheme());
                            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
                            int i2 = typedValue.resourceId;
                            if (i2 != 0) {
                                newTheme.applyStyle(i2, true);
                            }
                            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
                            int i3 = typedValue.resourceId;
                            if (i3 != 0) {
                                newTheme.applyStyle(i3, true);
                            } else {
                                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
                            }
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(themedContext, 0);
                            contextThemeWrapper.getTheme().setTo(newTheme);
                            panelFeatureState.listPresenterContext = contextThemeWrapper;
                            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
                            panelFeatureState.background = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_panelBackground, 0);
                            panelFeatureState.windowAnimations = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
                            panelFeatureState.gravity = 81;
                        } else if (panelFeatureState.refreshDecorView && viewGroup.getChildCount() > 0) {
                            panelFeatureState.decorView.removeAllViews();
                        }
                        View view = panelFeatureState.createdPanelView;
                        if (view != null) {
                            panelFeatureState.shownPanelView = view;
                        } else {
                            if (panelFeatureState.menu != null) {
                                if (this.mPanelMenuPresenterCallback == null) {
                                    this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
                                }
                                PanelMenuPresenterCallback panelMenuPresenterCallback = this.mPanelMenuPresenterCallback;
                                if (panelFeatureState.menu != null) {
                                    if (panelFeatureState.listMenuPresenter == null) {
                                        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(panelFeatureState.listPresenterContext, R$layout.abc_list_menu_item_layout);
                                        panelFeatureState.listMenuPresenter = listMenuPresenter;
                                        listMenuPresenter.mCallback = panelMenuPresenterCallback;
                                        MenuBuilder menuBuilder = panelFeatureState.menu;
                                        menuBuilder.addMenuPresenter(listMenuPresenter, menuBuilder.mContext);
                                    }
                                    ListMenuPresenter listMenuPresenter2 = panelFeatureState.listMenuPresenter;
                                    ViewGroup viewGroup2 = panelFeatureState.decorView;
                                    if (listMenuPresenter2.mMenuView == null) {
                                        listMenuPresenter2.mMenuView = (ExpandedMenuView) listMenuPresenter2.mInflater.inflate(R$layout.abc_expanded_menu_layout, viewGroup2, false);
                                        if (listMenuPresenter2.mAdapter == null) {
                                            listMenuPresenter2.mAdapter = new ListMenuPresenter.MenuAdapter();
                                        }
                                        listMenuPresenter2.mMenuView.setAdapter((ListAdapter) listMenuPresenter2.mAdapter);
                                        listMenuPresenter2.mMenuView.setOnItemClickListener(listMenuPresenter2);
                                    }
                                    expandedMenuView = listMenuPresenter2.mMenuView;
                                }
                                panelFeatureState.shownPanelView = expandedMenuView;
                            }
                            z = false;
                            if (z) {
                                if (panelFeatureState.shownPanelView != null && (panelFeatureState.createdPanelView != null || ((ListMenuPresenter.MenuAdapter) panelFeatureState.listMenuPresenter.getAdapter()).getCount() > 0)) {
                                    ViewGroup.LayoutParams layoutParams2 = panelFeatureState.shownPanelView.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                    }
                                    panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                                    ViewParent parent = panelFeatureState.shownPanelView.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                                    }
                                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams2);
                                    if (!panelFeatureState.shownPanelView.hasFocus()) {
                                        panelFeatureState.shownPanelView.requestFocus();
                                    }
                                }
                            }
                            panelFeatureState.refreshDecorView = true;
                            return;
                        }
                        z = true;
                        if (z) {
                        }
                        panelFeatureState.refreshDecorView = true;
                        return;
                    }
                    View view2 = panelFeatureState.createdPanelView;
                    if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i = -1;
                        panelFeatureState.isHandled = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.gravity;
                        layoutParams3.windowAnimations = panelFeatureState.windowAnimations;
                        windowManager.addView(panelFeatureState.decorView, layoutParams3);
                        panelFeatureState.isOpen = true;
                        return;
                    }
                    i = -2;
                    panelFeatureState.isHandled = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.gravity;
                    layoutParams32.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.decorView, layoutParams32);
                    panelFeatureState.isOpen = true;
                    return;
                }
                return;
            }
            closePanel(panelFeatureState, true);
        }
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            z = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(panelFeatureState, true);
        }
        return z;
    }

    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Resources.Theme theme;
        DecorContentParent decorContentParent3;
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            closePanel(panelFeatureState2, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        int i = panelFeatureState.featureId;
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(this.mActionBar instanceof ToolbarActionBar))) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (panelFeatureState.menu == null) {
                    Context context = this.mContext;
                    int i2 = panelFeatureState.featureId;
                    if ((i2 == 0 || i2 == 108) && this.mDecorContentParent != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(theme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder = new MenuBuilder(context);
                    menuBuilder.mCallback = this;
                    panelFeatureState.setMenu(menuBuilder);
                    if (panelFeatureState.menu == null) {
                        return false;
                    }
                }
                if (z && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                        decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && (decorContentParent = this.mDecorContentParent) != null) {
                    decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z2;
            panelFeatureState.menu.setQwertyMode(z2);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        } else if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        } else if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        } else if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        } else if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        } else if (i != 109) {
            return this.mWindow.requestFeature(i);
        } else {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean shouldAnimateActionModeView() {
        ViewGroup viewGroup;
        return this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && ViewCompat.isLaidOut(viewGroup);
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int updateStatusGuard(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5 = 0;
        if (windowInsetsCompat != null) {
            i = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            boolean z3 = true;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewGroup viewGroup = this.mSubDecor;
                Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception unused) {
                    }
                }
                int i6 = rect2.top;
                int i7 = rect2.left;
                int i8 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.mSubDecor);
                if (rootWindowInsets == null) {
                    i2 = 0;
                } else {
                    i2 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i3 = 0;
                } else {
                    i3 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams.topMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i6;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i8;
                    z2 = true;
                }
                if (i6 <= 0 || this.mStatusGuard != null) {
                    View view = this.mStatusGuard;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == i2 && marginLayoutParams2.rightMargin == i3)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = i2;
                            marginLayoutParams2.rightMargin = i3;
                            this.mStatusGuard.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.mContext);
                    this.mStatusGuard = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.mSubDecor.addView(this.mStatusGuard, -1, layoutParams);
                }
                z = this.mStatusGuard != null;
                if (z && this.mStatusGuard.getVisibility() != 0) {
                    View view3 = this.mStatusGuard;
                    if ((view3.getWindowSystemUiVisibility() & 8192) == 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i4 = ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard_light);
                    } else {
                        i4 = ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard);
                    }
                    view3.setBackgroundColor(i4);
                }
                if (!this.mOverlayActionMode && z) {
                    i = 0;
                }
                z3 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.mStatusGuard;
        if (view4 != null) {
            if (!z) {
                i5 = 8;
            }
            view4.setVisibility(i5);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6 A[ADDED_TO_REGION] */
    public final boolean applyDayNight(boolean z) {
        boolean z2;
        boolean z3;
        Object obj;
        int i;
        boolean z4 = false;
        if (this.mIsDestroyed) {
            return false;
        }
        int i2 = this.mLocalNightMode;
        if (i2 == -100) {
            i2 = -100;
        }
        Object obj2 = null;
        Configuration createOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(this.mContext, mapNightMode(this.mContext, i2), null);
        boolean z5 = true;
        if (!this.mActivityHandlesUiModeChecked && (this.mHost instanceof Activity)) {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                z2 = false;
                int i3 = this.mContext.getResources().getConfiguration().uiMode & 48;
                int i4 = createOverrideConfigurationForDayNight.uiMode & 48;
                if (i3 != i4 && z && !z2 && this.mBaseContextAttached && (sCanReturnDifferentContext || this.mCreated)) {
                    Object obj3 = this.mHost;
                    if ((obj3 instanceof Activity) && !((Activity) obj3).isChild()) {
                        ActivityCompat.recreate((Activity) this.mHost);
                        z3 = true;
                        if (!z3 || i3 == i4) {
                            z5 = z3;
                        } else {
                            Resources resources = this.mContext.getResources();
                            Configuration configuration = new Configuration(resources.getConfiguration());
                            configuration.uiMode = i4 | (resources.getConfiguration().uiMode & -49);
                            resources.updateConfiguration(configuration, null);
                            int i5 = Build.VERSION.SDK_INT;
                            if (i5 < 26 && i5 < 28) {
                                if (i5 >= 24) {
                                    if (!ConfigurationImplApi17.sResourcesImplFieldFetched) {
                                        try {
                                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                            ConfigurationImplApi17.sResourcesImplField = declaredField;
                                            declaredField.setAccessible(true);
                                        } catch (NoSuchFieldException e) {
                                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
                                        }
                                        ConfigurationImplApi17.sResourcesImplFieldFetched = true;
                                    }
                                    Field field = ConfigurationImplApi17.sResourcesImplField;
                                    if (field != null) {
                                        try {
                                            obj = field.get(resources);
                                        } catch (IllegalAccessException e2) {
                                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            if (!ConfigurationImplApi17.sDrawableCacheFieldFetched) {
                                                try {
                                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                    ConfigurationImplApi17.sDrawableCacheField = declaredField2;
                                                    declaredField2.setAccessible(true);
                                                } catch (NoSuchFieldException e3) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                                                }
                                                ConfigurationImplApi17.sDrawableCacheFieldFetched = true;
                                            }
                                            Field field2 = ConfigurationImplApi17.sDrawableCacheField;
                                            if (field2 != null) {
                                                try {
                                                    obj2 = field2.get(obj);
                                                } catch (IllegalAccessException e4) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                                                }
                                            }
                                            if (obj2 != null) {
                                                ConfigurationImplApi17.flushThemedResourcesCache(obj2);
                                            }
                                        }
                                    }
                                } else {
                                    if (!ConfigurationImplApi17.sDrawableCacheFieldFetched) {
                                        try {
                                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                            ConfigurationImplApi17.sDrawableCacheField = declaredField3;
                                            declaredField3.setAccessible(true);
                                        } catch (NoSuchFieldException e5) {
                                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e5);
                                        }
                                        ConfigurationImplApi17.sDrawableCacheFieldFetched = true;
                                    }
                                    Field field3 = ConfigurationImplApi17.sDrawableCacheField;
                                    if (field3 != null) {
                                        try {
                                            obj2 = field3.get(resources);
                                        } catch (IllegalAccessException e6) {
                                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e6);
                                        }
                                    }
                                    if (obj2 != null) {
                                        ConfigurationImplApi17.flushThemedResourcesCache(obj2);
                                    }
                                }
                            }
                            int i6 = this.mThemeResId;
                            if (i6 != 0) {
                                this.mContext.setTheme(i6);
                                this.mContext.getTheme().applyStyle(this.mThemeResId, true);
                            }
                            if (z2) {
                                Object obj4 = this.mHost;
                                if (obj4 instanceof Activity) {
                                    Activity activity = (Activity) obj4;
                                    if (activity instanceof LifecycleOwner) {
                                        if (((LifecycleRegistry) ((LifecycleOwner) activity).getLifecycle()).mState.compareTo((Enum) Lifecycle.State.STARTED) >= 0) {
                                            z4 = true;
                                        }
                                        if (z4) {
                                            activity.onConfigurationChanged(configuration);
                                        }
                                    } else if (this.mStarted) {
                                        activity.onConfigurationChanged(configuration);
                                    }
                                }
                            }
                        }
                        if (z5) {
                            Object obj5 = this.mHost;
                            if (obj5 instanceof AppCompatActivity) {
                                ((AppCompatActivity) obj5).onNightModeChanged();
                            }
                        }
                        if (i2 == 0) {
                            getAutoTimeNightModeManager(this.mContext).setup();
                        } else {
                            AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
                            if (autoNightModeManager != null) {
                                autoNightModeManager.cleanup();
                            }
                        }
                        if (i2 == 3) {
                            Context context = this.mContext;
                            if (this.mAutoBatteryNightModeManager == null) {
                                this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(context);
                            }
                            this.mAutoBatteryNightModeManager.setup();
                        } else {
                            AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
                            if (autoNightModeManager2 != null) {
                                autoNightModeManager2.cleanup();
                            }
                        }
                        return z5;
                    }
                }
                z3 = false;
                if (!z3) {
                }
                z5 = z3;
                if (z5) {
                }
                if (i2 == 0) {
                }
                if (i2 == 3) {
                }
                return z5;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i = 269221888;
                } else {
                    i = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), i);
                this.mActivityHandlesUiMode = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.mActivityHandlesUiMode = false;
            }
        }
        this.mActivityHandlesUiModeChecked = true;
        z2 = this.mActivityHandlesUiMode;
        int i32 = this.mContext.getResources().getConfiguration().uiMode & 48;
        int i42 = createOverrideConfigurationForDayNight.uiMode & 48;
        Object obj32 = this.mHost;
        ActivityCompat.recreate((Activity) this.mHost);
        z3 = true;
        if (!z3) {
        }
        z5 = z3;
        if (z5) {
        }
        if (i2 == 0) {
        }
        if (i2 == 3) {
        }
        return z5;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }
}
