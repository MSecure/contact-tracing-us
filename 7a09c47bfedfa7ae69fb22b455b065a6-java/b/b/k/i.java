package b.b.k;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
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
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.q;
import b.b.k.t;
import b.b.p.a;
import b.b.p.e;
import b.b.p.i.e;
import b.b.p.i.g;
import b.b.p.i.m;
import b.b.q.b0;
import b.b.q.b1;
import b.b.q.c0;
import b.b.q.d1;
import b.b.q.e1;
import b.b.q.f1;
import b.b.q.n;
import b.b.q.o;
import b.b.q.s;
import b.b.q.w;
import b.b.q.y0;
import b.g.b.h.d;
import b.i.j.b;
import b.i.l.d;
import b.i.l.r;
import b.i.l.t;
import b.i.l.v;
import b.l.d.q;
import b.o.f;
import b.r.d.a0;
import b.s.h;
import c.b.b.e.a.u;
import gov.michigan.MiCovidExposure.otpview.OtpView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h implements g.a, LayoutInflater.Factory2 {
    public static final b.e.h<String, Integer> a0 = new b.e.h<>();
    public static final boolean b0 = false;
    public static final int[] c0 = {16842836};
    public static final boolean d0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean e0 = true;
    public static boolean f0 = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public l[] G;
    public l H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N = -100;
    public int O;
    public boolean P;
    public boolean Q;
    public h R;
    public h S;
    public boolean T;
    public int U;
    public final Runnable V = new b();
    public boolean W;
    public Rect X;
    public Rect Y;
    public q Z;

    /* renamed from: d  reason: collision with root package name */
    public final Object f519d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f520e;

    /* renamed from: f  reason: collision with root package name */
    public Window f521f;

    /* renamed from: g  reason: collision with root package name */
    public f f522g;
    public final g h;
    public a i;
    public MenuInflater j;
    public CharSequence k;
    public c0 l;
    public d m;
    public m n;
    public b.b.p.a o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public r s = null;
    public boolean t = true;
    public boolean u;
    public ViewGroup v;
    public TextView w;
    public View x;
    public boolean y;
    public boolean z;

    public class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f523a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f523a = uncaughtExceptionHandler;
        }

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
                this.f523a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f523a.uncaughtException(thread, th);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            i iVar = i.this;
            if ((iVar.U & 1) != 0) {
                iVar.y(0);
            }
            i iVar2 = i.this;
            if ((iVar2.U & 4096) != 0) {
                iVar2.y(108);
            }
            i iVar3 = i.this;
            iVar3.T = false;
            iVar3.U = 0;
        }
    }

    public class c implements b {
        public c(i iVar) {
        }
    }

    public final class d implements m.a {
        public d() {
        }

        @Override // b.b.p.i.m.a
        public void b(b.b.p.i.g gVar, boolean z) {
            i.this.u(gVar);
        }

        @Override // b.b.p.i.m.a
        public boolean c(b.b.p.i.g gVar) {
            Window.Callback F = i.this.F();
            if (F == null) {
                return true;
            }
            F.onMenuOpened(108, gVar);
            return true;
        }
    }

    public class e implements a.AbstractC0012a {

        /* renamed from: a  reason: collision with root package name */
        public a.AbstractC0012a f526a;

        public class a extends t {
            public a() {
            }

            @Override // b.i.l.s
            public void a(View view) {
                i.this.p.setVisibility(8);
                i iVar = i.this;
                PopupWindow popupWindow = iVar.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (iVar.p.getParent() instanceof View) {
                    b.i.l.m.S((View) i.this.p.getParent());
                }
                i.this.p.removeAllViews();
                i.this.s.d(null);
                i iVar2 = i.this;
                iVar2.s = null;
                b.i.l.m.S(iVar2.v);
            }
        }

        public e(a.AbstractC0012a aVar) {
            this.f526a = aVar;
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean a(b.b.p.a aVar, Menu menu) {
            b.i.l.m.S(i.this.v);
            return this.f526a.a(aVar, menu);
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean b(b.b.p.a aVar, MenuItem menuItem) {
            return this.f526a.b(aVar, menuItem);
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean c(b.b.p.a aVar, Menu menu) {
            return this.f526a.c(aVar, menu);
        }

        @Override // b.b.p.a.AbstractC0012a
        public void d(b.b.p.a aVar) {
            this.f526a.d(aVar);
            i iVar = i.this;
            if (iVar.q != null) {
                iVar.f521f.getDecorView().removeCallbacks(i.this.r);
            }
            i iVar2 = i.this;
            if (iVar2.p != null) {
                iVar2.z();
                i iVar3 = i.this;
                r a2 = b.i.l.m.a(iVar3.p);
                a2.a(0.0f);
                iVar3.s = a2;
                r rVar = i.this.s;
                a aVar2 = new a();
                View view = rVar.f1880a.get();
                if (view != null) {
                    rVar.e(view, aVar2);
                }
            }
            i iVar4 = i.this;
            g gVar = iVar4.h;
            if (gVar != null) {
                gVar.onSupportActionModeFinished(iVar4.o);
            }
            i iVar5 = i.this;
            iVar5.o = null;
            b.i.l.m.S(iVar5.v);
        }
    }

    public class f extends b.b.p.h {
        public f(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            e.a aVar = new e.a(i.this.f520e, callback);
            b.b.p.a p = i.this.p(aVar);
            if (p != null) {
                return aVar.e(p);
            }
            return null;
        }

        @Override // b.b.p.h
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.x(keyEvent) || this.f676b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // b.b.p.h
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean z;
            if (!this.f676b.dispatchKeyShortcutEvent(keyEvent)) {
                i iVar = i.this;
                int keyCode = keyEvent.getKeyCode();
                iVar.G();
                a aVar = iVar.i;
                if (aVar == null || !aVar.i(keyCode, keyEvent)) {
                    l lVar = iVar.H;
                    if (lVar == null || !iVar.K(lVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                        if (iVar.H == null) {
                            l E = iVar.E(0);
                            iVar.L(E, keyEvent);
                            boolean K = iVar.K(E, keyEvent.getKeyCode(), keyEvent, 1);
                            E.k = false;
                        }
                        z = false;
                        if (!z) {
                            return false;
                        }
                    } else {
                        l lVar2 = iVar.H;
                        if (lVar2 != null) {
                            lVar2.l = true;
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
            return true;
        }

        @Override // b.b.p.h
        public void onContentChanged() {
        }

        @Override // b.b.p.h
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof b.b.p.i.g)) {
                return this.f676b.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // b.b.p.h
        public boolean onMenuOpened(int i, Menu menu) {
            this.f676b.onMenuOpened(i, menu);
            i iVar = i.this;
            if (iVar != null) {
                if (i == 108) {
                    iVar.G();
                    a aVar = iVar.i;
                    if (aVar != null) {
                        aVar.c(true);
                    }
                }
                return true;
            }
            throw null;
        }

        @Override // b.b.p.h
        public void onPanelClosed(int i, Menu menu) {
            this.f676b.onPanelClosed(i, menu);
            i iVar = i.this;
            if (iVar == null) {
                throw null;
            } else if (i == 108) {
                iVar.G();
                a aVar = iVar.i;
                if (aVar != null) {
                    aVar.c(false);
                }
            } else if (i == 0) {
                l E = iVar.E(i);
                if (E.m) {
                    iVar.v(E, false);
                }
            }
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            b.b.p.i.g gVar = menu instanceof b.b.p.i.g ? (b.b.p.i.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.y = true;
            }
            boolean onPreparePanel = this.f676b.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.y = false;
            }
            return onPreparePanel;
        }

        @Override // b.b.p.h, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            b.b.p.i.g gVar = i.this.E(0).h;
            if (gVar != null) {
                this.f676b.onProvideKeyboardShortcuts(list, gVar, i);
            } else {
                this.f676b.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // b.b.p.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // b.b.p.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!i.this.t || i != 0) {
                return this.f676b.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    public class g extends h {

        /* renamed from: c  reason: collision with root package name */
        public final PowerManager f530c;

        public g(Context context) {
            super();
            this.f530c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // b.b.k.i.h
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // b.b.k.i.h
        public int c() {
            return this.f530c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // b.b.k.i.h
        public void d() {
            i.this.q();
        }
    }

    public abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f532a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                h.this.d();
            }
        }

        public h() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f532a;
            if (broadcastReceiver != null) {
                try {
                    i.this.f520e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f532a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f532a == null) {
                    this.f532a = new a();
                }
                i.this.f520e.registerReceiver(this.f532a, b2);
            }
        }
    }

    /* renamed from: b.b.k.i$i  reason: collision with other inner class name */
    public class C0009i extends h {

        /* renamed from: c  reason: collision with root package name */
        public final t f535c;

        public C0009i(t tVar) {
            super();
            this.f535c = tVar;
        }

        @Override // b.b.k.i.h
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0111 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
        @Override // b.b.k.i.h
        public int c() {
            boolean z;
            Location location;
            Context context;
            long j;
            t tVar = this.f535c;
            t.a aVar = tVar.f590c;
            if (!(aVar.f592b > System.currentTimeMillis())) {
                Context context2 = tVar.f588a;
                Location location2 = null;
                if (j.i(context2, "android.permission.ACCESS_COARSE_LOCATION", Process.myPid(), Process.myUid(), context2.getPackageName()) == 0) {
                    try {
                        if (tVar.f589b.isProviderEnabled("network")) {
                            location = tVar.f589b.getLastKnownLocation("network");
                            context = tVar.f588a;
                            if (j.i(context, "android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid(), context.getPackageName()) == 0) {
                                try {
                                    if (tVar.f589b.isProviderEnabled("gps")) {
                                        location2 = tVar.f589b.getLastKnownLocation("gps");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                                location = location2;
                            }
                            if (location == null) {
                                t.a aVar2 = tVar.f590c;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (s.f583d == null) {
                                    s.f583d = new s();
                                }
                                s sVar = s.f583d;
                                sVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                                sVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                                boolean z2 = sVar.f586c == 1;
                                long j2 = sVar.f585b;
                                long j3 = sVar.f584a;
                                sVar.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                                long j4 = sVar.f585b;
                                if (j2 == -1 || j3 == -1) {
                                    j = currentTimeMillis + 43200000;
                                } else {
                                    j = (currentTimeMillis > j3 ? j4 + 0 : currentTimeMillis > j2 ? j3 + 0 : j2 + 0) + 60000;
                                }
                                aVar2.f591a = z2;
                                aVar2.f592b = j;
                            } else {
                                int i = Calendar.getInstance().get(11);
                                z = i < 6 || i >= 22;
                                if (!z) {
                                    return 2;
                                }
                                return 1;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                location = null;
                context = tVar.f588a;
                if (j.i(context, "android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid(), context.getPackageName()) == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            z = aVar.f591a;
            if (!z) {
            }
        }

        @Override // b.b.k.i.h
        public void d() {
            i.this.q();
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static Field f537a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f538b;

        /* renamed from: c  reason: collision with root package name */
        public static Class<?> f539c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f540d;

        /* renamed from: e  reason: collision with root package name */
        public static Field f541e;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f542f;

        /* renamed from: g  reason: collision with root package name */
        public static Field f543g;
        public static boolean h;
        public static long i;
        public static Method j;

        public static int A(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
            return !K(xmlPullParser, str) ? i3 : typedArray.getColor(i2, i3);
        }

        public static b.i.e.b.a B(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
            b.i.e.b.a aVar;
            if (K(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i2, typedValue);
                int i4 = typedValue.type;
                if (i4 >= 28 && i4 <= 31) {
                    return new b.i.e.b.a(null, null, typedValue.data);
                }
                try {
                    aVar = b.i.e.b.a.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar != null) {
                    return aVar;
                }
            }
            return new b.i.e.b.a(null, null, i3);
        }

        public static float C(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
            return !K(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
        }

        public static int D(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
            return !K(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
        }

        public static String E(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
            if (!K(xmlPullParser, str)) {
                return null;
            }
            return typedArray.getString(i2);
        }

        public static Intent F(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String H = H(activity, activity.getComponentName());
                if (H == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, H);
                try {
                    return H(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        public static Intent G(Context context, ComponentName componentName) {
            String H = H(context, componentName);
            if (H == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), H);
            return H(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
        }

        public static String H(Context context, ComponentName componentName) {
            String string;
            PackageManager packageManager = context.getPackageManager();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 640;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                i3 = 269222528;
            } else if (i4 >= 24) {
                i3 = 787072;
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i3);
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

        public static File I(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder h2 = c.a.a.a.a.h(".font");
            h2.append(Process.myPid());
            h2.append("-");
            h2.append(Process.myTid());
            h2.append("-");
            String sb = h2.toString();
            for (int i2 = 0; i2 < 100; i2++) {
                File file = new File(cacheDir, c.a.a.a.a.n(sb, i2));
                try {
                    if (file.createNewFile()) {
                        return file;
                    }
                } catch (IOException unused) {
                }
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r7 != 2) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
            if (r5 != false) goto L_0x0069;
         */
        public static b.a J(TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            if (Build.VERSION.SDK_INT >= 28) {
                return new b.a(textView.getTextMetricsParams());
            }
            TextPaint textPaint = new TextPaint(textView.getPaint());
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            int breakStrategy = textView.getBreakStrategy();
            int hyphenationFrequency = textView.getHyphenationFrequency();
            if (!(textView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                boolean z = false;
                if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
                    if (textView.getLayoutDirection() == 1) {
                        z = true;
                    }
                    switch (textView.getTextDirection()) {
                        case 2:
                            textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
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
                    }
                    return new b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
                }
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality != 1) {
                }
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
                return new b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
            }
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
            return new b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
        }

        public static boolean K(XmlPullParser xmlPullParser, String str) {
            return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
        }

        public static boolean L(Rect rect, Rect rect2, int i2) {
            if (i2 == 17) {
                int i3 = rect.right;
                int i4 = rect2.right;
                return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
            } else if (i2 == 33) {
                int i5 = rect.bottom;
                int i6 = rect2.bottom;
                return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
            } else if (i2 == 66) {
                int i7 = rect.left;
                int i8 = rect2.left;
                return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
            } else if (i2 == 130) {
                int i9 = rect.top;
                int i10 = rect2.top;
                return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        @SuppressLint({"NewApi"})
        public static boolean M() {
            try {
                if (j == null) {
                    return Trace.isEnabled();
                }
            } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            }
            try {
                if (j == null) {
                    i = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    j = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) j.invoke(null, Long.valueOf(i))).booleanValue();
            } catch (Exception e2) {
                if (!(e2 instanceof InvocationTargetException)) {
                    return false;
                }
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
        }

        public static q N(Context context, Fragment fragment, boolean z, boolean z2) {
            int i2;
            int nextTransition = fragment.getNextTransition();
            int popEnterAnim = z2 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
            boolean z3 = false;
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            if (!(viewGroup == null || viewGroup.getTag(b.l.b.visible_removing_fragment_view_tag) == null)) {
                fragment.mContainer.setTag(b.l.b.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
                return null;
            }
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, popEnterAnim);
            if (onCreateAnimation != null) {
                return new q(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, popEnterAnim);
            if (onCreateAnimator != null) {
                return new q(onCreateAnimator);
            }
            if (popEnterAnim == 0 && nextTransition != 0) {
                if (nextTransition != 4097) {
                    i2 = nextTransition != 4099 ? nextTransition != 8194 ? -1 : z ? b.l.a.fragment_close_enter : b.l.a.fragment_close_exit : z ? b.l.a.fragment_fade_enter : b.l.a.fragment_fade_exit;
                } else {
                    i2 = z ? b.l.a.fragment_open_enter : b.l.a.fragment_open_exit;
                }
                popEnterAnim = i2;
            }
            if (popEnterAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                        if (loadAnimation != null) {
                            return new q(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                        if (loadAnimator != null) {
                            return new q(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                            if (loadAnimation2 != null) {
                                return new q(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
            if (r17 == null) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            if (r17 != null) goto L_0x0079;
         */
        public static Typeface O(Context context, int i2, TypedValue typedValue, int i3, b.i.e.b.g gVar, Handler handler, boolean z) {
            Resources resources = context.getResources();
            resources.getValue(i2, typedValue, true);
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                String charSequence2 = charSequence.toString();
                Typeface typeface = null;
                if (charSequence2.startsWith("res/")) {
                    Typeface a2 = b.i.f.d.f1752b.a(b.i.f.d.d(resources, i2, i3));
                    if (a2 != null) {
                        if (gVar != null) {
                            gVar.b(a2, handler);
                        }
                        typeface = a2;
                    } else {
                        try {
                            if (charSequence2.toLowerCase().endsWith(".xml")) {
                                b.i.e.b.b Z = Z(resources.getXml(i2), resources);
                                if (Z != null) {
                                    typeface = b.i.f.d.b(context, Z, resources, i2, i3, gVar, handler, z);
                                } else if (gVar != null) {
                                    gVar.a(-3, handler);
                                }
                            } else {
                                Typeface c2 = b.i.f.d.c(context, resources, i2, charSequence2, i3);
                                if (gVar != null) {
                                    if (c2 != null) {
                                        gVar.b(c2, handler);
                                    } else {
                                        gVar.a(-3, handler);
                                    }
                                }
                                typeface = c2;
                            }
                        } catch (IOException | XmlPullParserException unused) {
                        }
                    }
                    if (typeface == null || gVar != null) {
                        return typeface;
                    }
                    StringBuilder h2 = c.a.a.a.a.h("Font resource ID #0x");
                    h2.append(Integer.toHexString(i2));
                    h2.append(" could not be retrieved.");
                    throw new Resources.NotFoundException(h2.toString());
                }
                gVar.a(-3, handler);
                if (typeface == null) {
                }
                return typeface;
            }
            StringBuilder h3 = c.a.a.a.a.h("Resource \"");
            h3.append(resources.getResourceName(i2));
            h3.append("\" (");
            h3.append(Integer.toHexString(i2));
            h3.append(") is not a Font: ");
            h3.append(typedValue);
            throw new Resources.NotFoundException(h3.toString());
        }

        public static int P(int i2, Rect rect, Rect rect2) {
            int i3;
            int i4;
            if (i2 == 17) {
                i4 = rect.left;
                i3 = rect2.right;
            } else if (i2 == 33) {
                i4 = rect.top;
                i3 = rect2.bottom;
            } else if (i2 == 66) {
                i4 = rect2.left;
                i3 = rect.right;
            } else if (i2 == 130) {
                i4 = rect2.top;
                i3 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return Math.max(0, i4 - i3);
        }

        public static int Q(int i2, Rect rect, Rect rect2) {
            int i3;
            int i4;
            int i5;
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                i4 = (rect.width() / 2) + rect.left;
                i5 = rect2.left;
                i3 = rect2.width();
                return Math.abs(i4 - ((i3 / 2) + i5));
            }
            i4 = (rect.height() / 2) + rect.top;
            i5 = rect2.top;
            i3 = rect2.height();
            return Math.abs(i4 - ((i3 / 2) + i5));
        }

        public static ByteBuffer R(Context context, CancellationSignal cancellationSignal, Uri uri) {
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

        public static TypedArray S(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
            return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }

        public static <T> ObjectAnimator T(T t, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }

        public static InputConnection U(InputConnection inputConnection, EditorInfo editorInfo, View view) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof f1) {
                        editorInfo.hintText = ((f1) parent).a();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }

        public static boolean V(ViewParent viewParent, View view, float f2, float f3, boolean z) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError unused) {
                String str = "ViewParent " + viewParent + " does not implement interface method onNestedFling";
                return false;
            }
        }

        public static boolean W(ViewParent viewParent, View view, float f2, float f3) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError unused) {
                String str = "ViewParent " + viewParent + " does not implement interface method onNestedPreFling";
                return false;
            }
        }

        public static void X(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
            if (viewParent instanceof b.i.l.g) {
                ((b.i.l.g) viewParent).j(view, i2, i3, iArr, i4);
            } else if (i4 == 0) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll";
                }
            }
        }

        public static void Y(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (viewParent instanceof b.i.l.h) {
                ((b.i.l.h) viewParent).m(view, i2, i3, i4, i5, i6, iArr);
                return;
            }
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            if (viewParent instanceof b.i.l.g) {
                ((b.i.l.g) viewParent).n(view, i2, i3, i4, i5, i6);
            } else if (i6 == 0) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + viewParent + " does not implement interface method onNestedScroll";
                }
            }
        }

        public static b.i.e.b.b Z(XmlPullParser xmlPullParser, Resources resources) {
            int next;
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                xmlPullParser.require(2, null, "font-family");
                if (xmlPullParser.getName().equals("font-family")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.i.c.FontFamily);
                    String string = obtainAttributes.getString(b.i.c.FontFamily_fontProviderAuthority);
                    String string2 = obtainAttributes.getString(b.i.c.FontFamily_fontProviderPackage);
                    String string3 = obtainAttributes.getString(b.i.c.FontFamily_fontProviderQuery);
                    int resourceId = obtainAttributes.getResourceId(b.i.c.FontFamily_fontProviderCerts, 0);
                    int integer = obtainAttributes.getInteger(b.i.c.FontFamily_fontProviderFetchStrategy, 1);
                    int integer2 = obtainAttributes.getInteger(b.i.c.FontFamily_fontProviderFetchTimeout, OtpView.BLINK);
                    obtainAttributes.recycle();
                    if (string == null || string2 == null || string3 == null) {
                        ArrayList arrayList = new ArrayList();
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (xmlPullParser.getName().equals("font")) {
                                    TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.i.c.FontFamilyFont);
                                    int i2 = obtainAttributes2.getInt(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontWeight) ? b.i.c.FontFamilyFont_fontWeight : b.i.c.FontFamilyFont_android_fontWeight, 400);
                                    boolean z = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontStyle) ? b.i.c.FontFamilyFont_fontStyle : b.i.c.FontFamilyFont_android_fontStyle, 0);
                                    int i3 = obtainAttributes2.hasValue(b.i.c.FontFamilyFont_ttcIndex) ? b.i.c.FontFamilyFont_ttcIndex : b.i.c.FontFamilyFont_android_ttcIndex;
                                    String string4 = obtainAttributes2.getString(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontVariationSettings) ? b.i.c.FontFamilyFont_fontVariationSettings : b.i.c.FontFamilyFont_android_fontVariationSettings);
                                    int i4 = obtainAttributes2.getInt(i3, 0);
                                    int i5 = obtainAttributes2.hasValue(b.i.c.FontFamilyFont_font) ? b.i.c.FontFamilyFont_font : b.i.c.FontFamilyFont_android_font;
                                    int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                                    String string5 = obtainAttributes2.getString(i5);
                                    obtainAttributes2.recycle();
                                    while (xmlPullParser.next() != 3) {
                                        j0(xmlPullParser);
                                    }
                                    arrayList.add(new b.i.e.b.d(string5, i2, z, string4, i4, resourceId2));
                                } else {
                                    j0(xmlPullParser);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new b.i.e.b.c((b.i.e.b.d[]) arrayList.toArray(new b.i.e.b.d[arrayList.size()]));
                    }
                    while (xmlPullParser.next() != 3) {
                        j0(xmlPullParser);
                    }
                    return new b.i.e.b.e(new b.i.i.a(string, string2, string3, a0(resources, resourceId)), integer, integer2);
                }
                j0(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01ef, code lost:
            if (r2.Z == 2) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x02bb, code lost:
            if (r5[r16].f1501c.f1499a == r6) goto L_0x02bf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x013e, code lost:
            if (r4[r2].f1501c.f1499a == r5) goto L_0x0142;
         */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x0200  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x02da  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x033c  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x0363  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x0373  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x0490 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:265:0x04fa A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:298:0x056d  */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x057a  */
        /* JADX WARNING: Removed duplicated region for block: B:306:0x0593  */
        /* JADX WARNING: Removed duplicated region for block: B:309:0x059d  */
        /* JADX WARNING: Removed duplicated region for block: B:315:0x05b0  */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x05bb  */
        /* JADX WARNING: Removed duplicated region for block: B:320:0x05c7  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x05ca  */
        /* JADX WARNING: Removed duplicated region for block: B:325:0x05ec  */
        /* JADX WARNING: Removed duplicated region for block: B:332:0x0602  */
        /* JADX WARNING: Removed duplicated region for block: B:338:0x060f  */
        /* JADX WARNING: Removed duplicated region for block: B:361:0x066c  */
        /* JADX WARNING: Removed duplicated region for block: B:362:0x0674  */
        /* JADX WARNING: Removed duplicated region for block: B:365:0x0681  */
        /* JADX WARNING: Removed duplicated region for block: B:366:0x0684  */
        /* JADX WARNING: Removed duplicated region for block: B:381:0x06da  */
        /* JADX WARNING: Removed duplicated region for block: B:393:0x0728  */
        /* JADX WARNING: Removed duplicated region for block: B:394:0x072b  */
        /* JADX WARNING: Removed duplicated region for block: B:397:0x0731  */
        /* JADX WARNING: Removed duplicated region for block: B:398:0x0734  */
        /* JADX WARNING: Removed duplicated region for block: B:400:0x0738  */
        /* JADX WARNING: Removed duplicated region for block: B:404:0x0747  */
        /* JADX WARNING: Removed duplicated region for block: B:406:0x074a  */
        /* JADX WARNING: Removed duplicated region for block: B:429:0x05ee A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0112  */
        public static void a(b.g.b.h.e eVar, b.g.b.d dVar, int i2) {
            int i3;
            b.g.b.h.b[] bVarArr;
            int i4;
            boolean z;
            boolean z2;
            int i5;
            float f2;
            boolean z3;
            boolean z4;
            boolean z5;
            int i6;
            int i7;
            b.g.b.h.d dVar2;
            b.g.b.h.d dVar3;
            b.g.b.h.c cVar;
            int i8;
            b.g.b.h.c cVar2;
            b.g.b.g gVar;
            b.g.b.g gVar2;
            int i9;
            b.g.b.h.d dVar4;
            b.g.b.h.c cVar3;
            b.g.b.h.c cVar4;
            b.g.b.h.c cVar5;
            b.g.b.h.d dVar5;
            int i10;
            int i11;
            b.g.b.h.d dVar6;
            b.g.b.h.d dVar7;
            b.g.b.g gVar3;
            b.g.b.g gVar4;
            b.g.b.h.c cVar6;
            b.g.b.h.c cVar7;
            int i12;
            b.g.b.h.d dVar8;
            b.g.b.h.d dVar9;
            int b2;
            b.g.b.h.c cVar8;
            b.g.b.g gVar5;
            b.g.b.h.c cVar9;
            b.g.b.g gVar6;
            int i13;
            b.g.b.h.c cVar10;
            int size;
            int i14;
            d.a aVar;
            int i15;
            float f3;
            ArrayList<b.g.b.h.d> arrayList;
            boolean z6;
            char c2;
            float f4;
            b.g.b.h.d dVar10;
            int i16;
            boolean z7;
            b.g.b.h.b[] bVarArr2;
            b.g.b.h.d dVar11;
            b.g.b.h.d dVar12;
            int i17;
            boolean z8;
            boolean z9;
            b.g.b.h.d dVar13;
            boolean z10;
            b.g.b.h.d dVar14;
            b.g.b.h.e eVar2 = eVar;
            d.a aVar2 = d.a.MATCH_CONSTRAINT;
            int i18 = 2;
            if (i2 == 0) {
                i4 = eVar2.l0;
                bVarArr = eVar2.o0;
                i3 = 0;
            } else {
                i4 = eVar2.m0;
                bVarArr = eVar2.n0;
                i3 = 2;
            }
            int i19 = 0;
            while (i19 < i4) {
                b.g.b.h.b bVar = bVarArr[i19];
                b.g.b.g gVar7 = null;
                int i20 = 8;
                int i21 = 1;
                if (!bVar.t) {
                    int i22 = bVar.o * i18;
                    b.g.b.h.d dVar15 = bVar.f1492a;
                    b.g.b.h.d dVar16 = dVar15;
                    boolean z11 = false;
                    while (!z11) {
                        bVar.i += i21;
                        b.g.b.h.d[] dVarArr = dVar15.c0;
                        int i23 = bVar.o;
                        dVarArr[i23] = null;
                        dVar15.b0[i23] = null;
                        if (dVar15.V != i20) {
                            bVar.l += i21;
                            if (dVar15.h(i23) != aVar2) {
                                int i24 = bVar.m;
                                int i25 = bVar.o;
                                bVar.m = i24 + (i25 == 0 ? dVar15.o() : i25 == i21 ? dVar15.i() : 0);
                            }
                            int b3 = dVar15.F[i22].b() + bVar.m;
                            bVar.m = b3;
                            int i26 = i22 + 1;
                            bVar.m = dVar15.F[i26].b() + b3;
                            int b4 = dVar15.F[i22].b() + bVar.n;
                            bVar.n = b4;
                            bVar.n = dVar15.F[i26].b() + b4;
                            if (bVar.f1493b == null) {
                                bVar.f1493b = dVar15;
                            }
                            bVar.f1495d = dVar15;
                            d.a[] aVarArr = dVar15.H;
                            int i27 = bVar.o;
                            if (aVarArr[i27] == aVar2) {
                                int[] iArr = dVar15.l;
                                if (iArr[i27] == 0 || iArr[i27] == 3 || iArr[i27] == i18) {
                                    bVar.j++;
                                    float[] fArr = dVar15.a0;
                                    int i28 = bVar.o;
                                    float f5 = fArr[i28];
                                    if (f5 > 0.0f) {
                                        bVar.k += fArr[i28];
                                    }
                                    int i29 = bVar.o;
                                    if (dVar15.V != 8 && dVar15.H[i29] == aVar2) {
                                        int[] iArr2 = dVar15.l;
                                        if (iArr2[i29] == 0 || iArr2[i29] == 3) {
                                            z10 = true;
                                            if (z10) {
                                                if (f5 < 0.0f) {
                                                    bVar.q = true;
                                                } else {
                                                    bVar.r = true;
                                                }
                                                if (bVar.h == null) {
                                                    bVar.h = new ArrayList<>();
                                                }
                                                bVar.h.add(dVar15);
                                            }
                                            if (bVar.f1497f == null) {
                                                bVar.f1497f = dVar15;
                                            }
                                            dVar14 = bVar.f1498g;
                                            if (dVar14 != null) {
                                                dVar14.b0[bVar.o] = dVar15;
                                            }
                                            bVar.f1498g = dVar15;
                                        }
                                    }
                                    z10 = false;
                                    if (z10) {
                                    }
                                    if (bVar.f1497f == null) {
                                    }
                                    dVar14 = bVar.f1498g;
                                    if (dVar14 != null) {
                                    }
                                    bVar.f1498g = dVar15;
                                }
                                int i30 = bVar.o;
                            }
                        }
                        if (dVar16 != dVar15) {
                            dVar16.c0[bVar.o] = dVar15;
                        }
                        b.g.b.h.c cVar11 = dVar15.F[i22 + 1].f1501c;
                        if (cVar11 != null) {
                            dVar13 = cVar11.f1499a;
                            b.g.b.h.c[] cVarArr = dVar13.F;
                            if (cVarArr[i22].f1501c != null) {
                            }
                        }
                        dVar13 = null;
                        if (dVar13 == null) {
                            dVar13 = dVar15;
                            z11 = true;
                        }
                        dVar16 = dVar15;
                        i21 = 1;
                        i20 = 8;
                        i18 = 2;
                        dVar15 = dVar13;
                    }
                    b.g.b.h.d dVar17 = bVar.f1493b;
                    if (dVar17 != null) {
                        bVar.m -= dVar17.F[i22].b();
                    }
                    b.g.b.h.d dVar18 = bVar.f1495d;
                    if (dVar18 != null) {
                        bVar.m -= dVar18.F[i22 + 1].b();
                    }
                    bVar.f1494c = dVar15;
                    if (bVar.o != 0 || !bVar.p) {
                        bVar.f1496e = bVar.f1492a;
                    } else {
                        bVar.f1496e = dVar15;
                    }
                    bVar.s = bVar.r && bVar.q;
                    z = true;
                } else {
                    z = true;
                }
                bVar.t = z;
                b.g.b.h.d dVar19 = bVar.f1492a;
                b.g.b.h.d dVar20 = bVar.f1494c;
                b.g.b.h.d dVar21 = bVar.f1493b;
                b.g.b.h.d dVar22 = bVar.f1495d;
                b.g.b.h.d dVar23 = bVar.f1496e;
                float f6 = bVar.k;
                boolean z12 = eVar2.H[i2] == d.a.WRAP_CONTENT;
                if (i2 == 0) {
                    z8 = dVar23.Y == 0;
                    f2 = f6;
                    boolean z13 = dVar23.Y == 1;
                    if (dVar23.Y == 2) {
                        z9 = z13;
                        i5 = i19;
                    } else {
                        z9 = z13;
                        i5 = i19;
                        z3 = z9;
                        z2 = z8;
                        z4 = false;
                        b.g.b.h.d dVar24 = dVar19;
                        z5 = false;
                        while (!z5) {
                            b.g.b.h.c cVar12 = dVar24.F[i3];
                            int i31 = z4 ? 1 : 4;
                            int b5 = cVar12.b();
                            if (dVar24.H[i2] == aVar2 && dVar24.l[i2] == 0) {
                                i16 = i4;
                                z7 = true;
                            } else {
                                i16 = i4;
                                z7 = false;
                            }
                            b.g.b.h.c cVar13 = cVar12.f1501c;
                            if (!(cVar13 == null || dVar24 == dVar19)) {
                                b5 = cVar13.b() + b5;
                            }
                            if (!z4 || dVar24 == dVar19 || dVar24 == dVar21) {
                                bVarArr2 = bVarArr;
                            } else {
                                bVarArr2 = bVarArr;
                                i31 = 5;
                            }
                            b.g.b.h.c cVar14 = cVar12.f1501c;
                            if (cVar14 != null) {
                                if (dVar24 == dVar21) {
                                    dVar11 = dVar19;
                                    dVar.f(cVar12.f1504f, cVar14.f1504f, b5, 6);
                                } else {
                                    dVar11 = dVar19;
                                    dVar.f(cVar12.f1504f, cVar14.f1504f, b5, 7);
                                }
                                dVar.d(cVar12.f1504f, cVar12.f1501c.f1504f, b5, (!z7 || z4) ? i31 : 5);
                            } else {
                                dVar11 = dVar19;
                            }
                            if (z12) {
                                if (dVar24.V == 8 || dVar24.H[i2] != aVar2) {
                                    i17 = 0;
                                } else {
                                    b.g.b.h.c[] cVarArr2 = dVar24.F;
                                    i17 = 0;
                                    dVar.f(cVarArr2[i3 + 1].f1504f, cVarArr2[i3].f1504f, 0, 5);
                                }
                                dVar.f(dVar24.F[i3].f1504f, eVar2.F[i3].f1504f, i17, 7);
                            }
                            b.g.b.h.c cVar15 = dVar24.F[i3 + 1].f1501c;
                            if (cVar15 != null) {
                                dVar12 = cVar15.f1499a;
                                b.g.b.h.c[] cVarArr3 = dVar12.F;
                                if (cVarArr3[i3].f1501c != null) {
                                }
                            }
                            dVar12 = null;
                            if (dVar12 != null) {
                                dVar24 = dVar12;
                                z5 = z5;
                            } else {
                                z5 = true;
                            }
                            bVarArr = bVarArr2;
                            i4 = i16;
                            dVar23 = dVar23;
                            dVar19 = dVar11;
                        }
                        if (dVar22 != null) {
                            int i32 = i3 + 1;
                            if (dVar20.F[i32].f1501c != null) {
                                b.g.b.h.c cVar16 = dVar22.F[i32];
                                if ((dVar22.H[i2] == aVar2 && dVar22.l[i2] == 0) && !z4) {
                                    b.g.b.h.c cVar17 = cVar16.f1501c;
                                    if (cVar17.f1499a == eVar2) {
                                        dVar.d(cVar16.f1504f, cVar17.f1504f, -cVar16.b(), 5);
                                        dVar.g(cVar16.f1504f, dVar20.F[i32].f1501c.f1504f, -cVar16.b(), 6);
                                        if (z12) {
                                            int i33 = i3 + 1;
                                            b.g.b.g gVar8 = eVar2.F[i33].f1504f;
                                            b.g.b.h.c[] cVarArr4 = dVar20.F;
                                            dVar.f(gVar8, cVarArr4[i33].f1504f, cVarArr4[i33].b(), 7);
                                        }
                                        ArrayList<b.g.b.h.d> arrayList2 = bVar.h;
                                        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                                            float f7 = (bVar.q || bVar.s) ? f2 : (float) bVar.j;
                                            b.g.b.h.d dVar25 = null;
                                            float f8 = 0.0f;
                                            i14 = 0;
                                            while (i14 < size) {
                                                b.g.b.h.d dVar26 = arrayList2.get(i14);
                                                float f9 = dVar26.a0[i2];
                                                if (f9 >= 0.0f) {
                                                    arrayList = arrayList2;
                                                    f4 = 0.0f;
                                                } else if (bVar.s) {
                                                    b.g.b.h.c[] cVarArr5 = dVar26.F;
                                                    arrayList = arrayList2;
                                                    dVar.d(cVarArr5[i3 + 1].f1504f, cVarArr5[i3].f1504f, 0, 4);
                                                    c2 = 7;
                                                    z6 = false;
                                                    i15 = size;
                                                    f3 = f7;
                                                    aVar = aVar2;
                                                    i14++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i15;
                                                    aVar2 = aVar;
                                                } else {
                                                    arrayList = arrayList2;
                                                    f4 = 0.0f;
                                                    f9 = 1.0f;
                                                }
                                                int i34 = (f9 > f4 ? 1 : (f9 == f4 ? 0 : -1));
                                                if (i34 == 0) {
                                                    b.g.b.h.c[] cVarArr6 = dVar26.F;
                                                    c2 = 7;
                                                    z6 = false;
                                                    dVar.d(cVarArr6[i3 + 1].f1504f, cVarArr6[i3].f1504f, 0, 7);
                                                    i15 = size;
                                                    f3 = f7;
                                                    aVar = aVar2;
                                                    i14++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i15;
                                                    aVar2 = aVar;
                                                } else {
                                                    if (dVar25 != null) {
                                                        b.g.b.h.c[] cVarArr7 = dVar25.F;
                                                        b.g.b.g gVar9 = cVarArr7[i3].f1504f;
                                                        int i35 = i3 + 1;
                                                        b.g.b.g gVar10 = cVarArr7[i35].f1504f;
                                                        b.g.b.h.c[] cVarArr8 = dVar26.F;
                                                        i15 = size;
                                                        b.g.b.g gVar11 = cVarArr8[i3].f1504f;
                                                        b.g.b.g gVar12 = cVarArr8[i35].f1504f;
                                                        dVar10 = dVar26;
                                                        b.g.b.b m = dVar.m();
                                                        aVar = aVar2;
                                                        m.f1459b = 0.0f;
                                                        if (f7 == 0.0f || f8 == f9) {
                                                            f3 = f7;
                                                            m.f1461d.h(gVar9, 1.0f);
                                                            m.f1461d.h(gVar10, -1.0f);
                                                            m.f1461d.h(gVar12, 1.0f);
                                                            m.f1461d.h(gVar11, -1.0f);
                                                        } else {
                                                            if (f8 == 0.0f) {
                                                                m.f1461d.h(gVar9, 1.0f);
                                                                m.f1461d.h(gVar10, -1.0f);
                                                            } else if (i34 == 0) {
                                                                m.f1461d.h(gVar11, 1.0f);
                                                                m.f1461d.h(gVar12, -1.0f);
                                                            } else {
                                                                float f10 = (f8 / f7) / (f9 / f7);
                                                                f3 = f7;
                                                                m.f1461d.h(gVar9, 1.0f);
                                                                m.f1461d.h(gVar10, -1.0f);
                                                                m.f1461d.h(gVar12, f10);
                                                                m.f1461d.h(gVar11, -f10);
                                                            }
                                                            f3 = f7;
                                                        }
                                                        dVar.c(m);
                                                    } else {
                                                        i15 = size;
                                                        dVar10 = dVar26;
                                                        f3 = f7;
                                                        aVar = aVar2;
                                                    }
                                                    f8 = f9;
                                                    dVar25 = dVar10;
                                                    i14++;
                                                    arrayList2 = arrayList;
                                                    f7 = f3;
                                                    size = i15;
                                                    aVar2 = aVar;
                                                }
                                            }
                                        }
                                        int i36 = 7;
                                        int i37 = 4;
                                        if (dVar21 != null || (dVar21 != dVar22 && !z4)) {
                                            dVar3 = dVar22;
                                            dVar2 = dVar21;
                                            i9 = i5;
                                            i7 = 2;
                                            if (z2 || dVar2 == null) {
                                                int i38 = 8;
                                                if (z3 && dVar2 != null) {
                                                    int i39 = bVar.j;
                                                    boolean z14 = i39 <= 0 && bVar.i == i39;
                                                    b.g.b.h.d dVar27 = dVar2;
                                                    dVar4 = dVar27;
                                                    while (dVar4 != null) {
                                                        b.g.b.h.d dVar28 = dVar4.c0[i2];
                                                        while (dVar28 != null && dVar28.V == i38) {
                                                            dVar28 = dVar28.c0[i2];
                                                        }
                                                        if (dVar4 == dVar2 || dVar4 == dVar3 || dVar28 == null) {
                                                            dVar5 = dVar27;
                                                            i10 = i9;
                                                            i11 = i38;
                                                            dVar6 = dVar28;
                                                        } else {
                                                            b.g.b.h.d dVar29 = dVar28 == dVar3 ? null : dVar28;
                                                            b.g.b.h.c cVar18 = dVar4.F[i3];
                                                            b.g.b.g gVar13 = cVar18.f1504f;
                                                            int i40 = i3 + 1;
                                                            b.g.b.g gVar14 = dVar27.F[i40].f1504f;
                                                            int b6 = cVar18.b();
                                                            int b7 = dVar4.F[i40].b();
                                                            if (dVar29 != null) {
                                                                cVar6 = dVar29.F[i3];
                                                                gVar3 = cVar6.f1504f;
                                                                dVar7 = dVar29;
                                                                cVar7 = cVar6.f1501c;
                                                                if (cVar7 == null) {
                                                                    gVar4 = null;
                                                                    int b8 = cVar6 == null ? cVar6.b() + b7 : b7;
                                                                    int b9 = dVar27.F[i40].b() + b6;
                                                                    int i41 = !z14 ? 7 : i37;
                                                                    if (gVar13 != null || gVar14 == null || gVar3 == null || gVar4 == null) {
                                                                        dVar5 = dVar27;
                                                                        i10 = i9;
                                                                        i11 = 8;
                                                                    } else {
                                                                        dVar5 = dVar27;
                                                                        i10 = i9;
                                                                        i11 = 8;
                                                                        dVar.b(gVar13, gVar14, b9, 0.5f, gVar3, gVar4, b8, i41);
                                                                    }
                                                                    dVar6 = dVar7;
                                                                }
                                                            } else {
                                                                dVar7 = dVar29;
                                                                cVar6 = dVar3.F[i3];
                                                                gVar3 = cVar6 != null ? cVar6.f1504f : null;
                                                                cVar7 = dVar4.F[i40];
                                                            }
                                                            gVar4 = cVar7.f1504f;
                                                            if (cVar6 == null) {
                                                            }
                                                            int b92 = dVar27.F[i40].b() + b6;
                                                            if (!z14) {
                                                            }
                                                            if (gVar13 != null) {
                                                            }
                                                            dVar5 = dVar27;
                                                            i10 = i9;
                                                            i11 = 8;
                                                            dVar6 = dVar7;
                                                        }
                                                        if (dVar4.V != i11) {
                                                            dVar5 = dVar4;
                                                        }
                                                        dVar4 = dVar6;
                                                        i38 = i11;
                                                        i9 = i10;
                                                        dVar27 = dVar5;
                                                        i37 = 4;
                                                    }
                                                    i6 = i9;
                                                    b.g.b.h.c cVar19 = dVar2.F[i3];
                                                    cVar3 = dVar19.F[i3].f1501c;
                                                    int i42 = i3 + 1;
                                                    cVar4 = dVar3.F[i42];
                                                    cVar5 = dVar20.F[i42].f1501c;
                                                    if (cVar3 != null) {
                                                        if (dVar2 != dVar3) {
                                                            dVar.d(cVar19.f1504f, cVar3.f1504f, cVar19.b(), 4);
                                                        } else if (cVar5 != null) {
                                                            dVar.b(cVar19.f1504f, cVar3.f1504f, cVar19.b(), 0.5f, cVar4.f1504f, cVar5.f1504f, cVar4.b(), 4);
                                                        }
                                                    }
                                                    if (!(cVar5 == null || dVar2 == dVar3)) {
                                                        dVar.d(cVar4.f1504f, cVar5.f1504f, -cVar4.b(), 4);
                                                    }
                                                    if ((z2 || z3) && dVar2 != null) {
                                                        cVar = dVar2.F[i3];
                                                        i8 = i3 + 1;
                                                        cVar2 = dVar3.F[i8];
                                                        b.g.b.h.c cVar20 = cVar.f1501c;
                                                        gVar = cVar20 != null ? cVar20.f1504f : null;
                                                        b.g.b.h.c cVar21 = cVar2.f1501c;
                                                        b.g.b.g gVar15 = cVar21 != null ? cVar21.f1504f : null;
                                                        if (dVar20 != dVar3) {
                                                            b.g.b.h.c cVar22 = dVar20.F[i8].f1501c;
                                                            if (cVar22 != null) {
                                                                gVar7 = cVar22.f1504f;
                                                            }
                                                            gVar2 = gVar7;
                                                        } else {
                                                            gVar2 = gVar15;
                                                        }
                                                        if (dVar2 == dVar3) {
                                                            b.g.b.h.c[] cVarArr9 = dVar2.F;
                                                            b.g.b.h.c cVar23 = cVarArr9[i3];
                                                            cVar2 = cVarArr9[i8];
                                                            cVar = cVar23;
                                                        }
                                                        if (!(gVar == null || gVar2 == null)) {
                                                            dVar.b(cVar.f1504f, gVar, cVar.b(), 0.5f, gVar2, cVar2.f1504f, dVar3.F[i8].b(), 5);
                                                        }
                                                    }
                                                    i19 = i6 + 1;
                                                    eVar2 = eVar;
                                                    i18 = i7;
                                                    bVarArr = bVarArr;
                                                    i4 = i4;
                                                    aVar2 = aVar2;
                                                }
                                            } else {
                                                int i43 = bVar.j;
                                                boolean z15 = i43 > 0 && bVar.i == i43;
                                                b.g.b.h.d dVar30 = dVar2;
                                                b.g.b.h.d dVar31 = dVar30;
                                                while (dVar31 != null) {
                                                    b.g.b.h.d dVar32 = dVar31.c0[i2];
                                                    while (true) {
                                                        if (dVar32 != null) {
                                                            if (dVar32.V != 8) {
                                                                break;
                                                            }
                                                            dVar32 = dVar32.c0[i2];
                                                        } else {
                                                            break;
                                                        }
                                                    }
                                                    if (dVar32 != null || dVar31 == dVar3) {
                                                        b.g.b.h.c cVar24 = dVar31.F[i3];
                                                        b.g.b.g gVar16 = cVar24.f1504f;
                                                        b.g.b.h.c cVar25 = cVar24.f1501c;
                                                        b.g.b.g gVar17 = cVar25 != null ? cVar25.f1504f : null;
                                                        if (dVar30 != dVar31) {
                                                            cVar10 = dVar30.F[i3 + 1];
                                                        } else {
                                                            if (dVar31 == dVar2 && dVar30 == dVar31) {
                                                                b.g.b.h.c[] cVarArr10 = dVar19.F;
                                                                if (cVarArr10[i3].f1501c != null) {
                                                                    cVar10 = cVarArr10[i3].f1501c;
                                                                } else {
                                                                    gVar17 = null;
                                                                }
                                                            }
                                                            b2 = cVar24.b();
                                                            int i44 = i3 + 1;
                                                            int b10 = dVar31.F[i44].b();
                                                            if (dVar32 == null) {
                                                                b.g.b.h.c cVar26 = dVar32.F[i3];
                                                                gVar5 = cVar26.f1504f;
                                                                cVar8 = cVar26;
                                                                cVar9 = dVar31.F[i44];
                                                            } else {
                                                                b.g.b.h.c cVar27 = dVar20.F[i44].f1501c;
                                                                if (cVar27 != null) {
                                                                    gVar5 = cVar27.f1504f;
                                                                    cVar8 = cVar27;
                                                                } else {
                                                                    cVar8 = cVar27;
                                                                    gVar5 = null;
                                                                }
                                                                cVar9 = dVar31.F[i44];
                                                            }
                                                            gVar6 = cVar9.f1504f;
                                                            if (cVar8 != null) {
                                                                b10 += cVar8.b();
                                                            }
                                                            i13 = b10;
                                                            if (dVar30 != null) {
                                                                b2 += dVar30.F[i44].b();
                                                            }
                                                            if (!(gVar16 == null || gVar17 == null || gVar5 == null || gVar6 == null)) {
                                                                if (dVar31 == dVar2) {
                                                                    b2 = dVar2.F[i3].b();
                                                                }
                                                                if (dVar31 == dVar3) {
                                                                    i13 = dVar3.F[i44].b();
                                                                }
                                                                int i45 = !z15 ? i36 : 5;
                                                                dVar8 = dVar32;
                                                                i12 = i36;
                                                                dVar9 = dVar30;
                                                                dVar.b(gVar16, gVar17, b2, 0.5f, gVar5, gVar6, i13, i45);
                                                                if (dVar31.V != 8) {
                                                                    dVar9 = dVar31;
                                                                }
                                                                dVar30 = dVar9;
                                                                dVar31 = dVar8;
                                                                i36 = i12;
                                                            }
                                                        }
                                                        gVar17 = cVar10.f1504f;
                                                        b2 = cVar24.b();
                                                        int i442 = i3 + 1;
                                                        int b102 = dVar31.F[i442].b();
                                                        if (dVar32 == null) {
                                                        }
                                                        gVar6 = cVar9.f1504f;
                                                        if (cVar8 != null) {
                                                        }
                                                        i13 = b102;
                                                        if (dVar30 != null) {
                                                        }
                                                        if (dVar31 == dVar2) {
                                                        }
                                                        if (dVar31 == dVar3) {
                                                        }
                                                        if (!z15) {
                                                        }
                                                        dVar8 = dVar32;
                                                        i12 = i36;
                                                        dVar9 = dVar30;
                                                        dVar.b(gVar16, gVar17, b2, 0.5f, gVar5, gVar6, i13, i45);
                                                        if (dVar31.V != 8) {
                                                        }
                                                        dVar30 = dVar9;
                                                        dVar31 = dVar8;
                                                        i36 = i12;
                                                    }
                                                    dVar8 = dVar32;
                                                    i12 = i36;
                                                    dVar9 = dVar30;
                                                    if (dVar31.V != 8) {
                                                    }
                                                    dVar30 = dVar9;
                                                    dVar31 = dVar8;
                                                    i36 = i12;
                                                }
                                            }
                                        } else {
                                            b.g.b.h.c cVar28 = dVar19.F[i3];
                                            int i46 = i3 + 1;
                                            b.g.b.h.c cVar29 = dVar20.F[i46];
                                            b.g.b.h.c cVar30 = cVar28.f1501c;
                                            b.g.b.g gVar18 = cVar30 != null ? cVar30.f1504f : null;
                                            b.g.b.h.c cVar31 = cVar29.f1501c;
                                            b.g.b.g gVar19 = cVar31 != null ? cVar31.f1504f : null;
                                            b.g.b.h.c cVar32 = dVar21.F[i3];
                                            b.g.b.h.c cVar33 = dVar22.F[i46];
                                            if (gVar18 == null || gVar19 == null) {
                                                dVar3 = dVar22;
                                                dVar2 = dVar21;
                                                i9 = i5;
                                                i7 = 2;
                                            } else {
                                                dVar3 = dVar22;
                                                dVar2 = dVar21;
                                                i9 = i5;
                                                i7 = 2;
                                                dVar.b(cVar32.f1504f, gVar18, cVar32.b(), i2 == 0 ? dVar23.S : dVar23.T, gVar19, cVar33.f1504f, cVar33.b(), 5);
                                            }
                                        }
                                        i6 = i9;
                                        cVar = dVar2.F[i3];
                                        i8 = i3 + 1;
                                        cVar2 = dVar3.F[i8];
                                        b.g.b.h.c cVar202 = cVar.f1501c;
                                        if (cVar202 != null) {
                                        }
                                        b.g.b.h.c cVar212 = cVar2.f1501c;
                                        if (cVar212 != null) {
                                        }
                                        if (dVar20 != dVar3) {
                                        }
                                        if (dVar2 == dVar3) {
                                        }
                                        dVar.b(cVar.f1504f, gVar, cVar.b(), 0.5f, gVar2, cVar2.f1504f, dVar3.F[i8].b(), 5);
                                        i19 = i6 + 1;
                                        eVar2 = eVar;
                                        i18 = i7;
                                        bVarArr = bVarArr;
                                        i4 = i4;
                                        aVar2 = aVar2;
                                    }
                                }
                                if (z4) {
                                    b.g.b.h.c cVar34 = cVar16.f1501c;
                                    if (cVar34.f1499a == eVar2) {
                                        dVar.d(cVar16.f1504f, cVar34.f1504f, -cVar16.b(), 4);
                                    }
                                }
                                dVar.g(cVar16.f1504f, dVar20.F[i32].f1501c.f1504f, -cVar16.b(), 6);
                                if (z12) {
                                }
                                ArrayList<b.g.b.h.d> arrayList22 = bVar.h;
                                if (bVar.q) {
                                }
                                b.g.b.h.d dVar252 = null;
                                float f82 = 0.0f;
                                i14 = 0;
                                while (i14 < size) {
                                }
                                int i362 = 7;
                                int i372 = 4;
                                if (dVar21 != null) {
                                }
                                dVar3 = dVar22;
                                dVar2 = dVar21;
                                i9 = i5;
                                i7 = 2;
                                if (z2) {
                                }
                                int i382 = 8;
                                int i392 = bVar.j;
                                if (i392 <= 0) {
                                }
                                b.g.b.h.d dVar272 = dVar2;
                                dVar4 = dVar272;
                                while (dVar4 != null) {
                                }
                                i6 = i9;
                                b.g.b.h.c cVar192 = dVar2.F[i3];
                                cVar3 = dVar19.F[i3].f1501c;
                                int i422 = i3 + 1;
                                cVar4 = dVar3.F[i422];
                                cVar5 = dVar20.F[i422].f1501c;
                                if (cVar3 != null) {
                                }
                                dVar.d(cVar4.f1504f, cVar5.f1504f, -cVar4.b(), 4);
                                cVar = dVar2.F[i3];
                                i8 = i3 + 1;
                                cVar2 = dVar3.F[i8];
                                b.g.b.h.c cVar2022 = cVar.f1501c;
                                if (cVar2022 != null) {
                                }
                                b.g.b.h.c cVar2122 = cVar2.f1501c;
                                if (cVar2122 != null) {
                                }
                                if (dVar20 != dVar3) {
                                }
                                if (dVar2 == dVar3) {
                                }
                                dVar.b(cVar.f1504f, gVar, cVar.b(), 0.5f, gVar2, cVar2.f1504f, dVar3.F[i8].b(), 5);
                                i19 = i6 + 1;
                                eVar2 = eVar;
                                i18 = i7;
                                bVarArr = bVarArr;
                                i4 = i4;
                                aVar2 = aVar2;
                            }
                        }
                        if (z12) {
                        }
                        ArrayList<b.g.b.h.d> arrayList222 = bVar.h;
                        if (bVar.q) {
                        }
                        b.g.b.h.d dVar2522 = null;
                        float f822 = 0.0f;
                        i14 = 0;
                        while (i14 < size) {
                        }
                        int i3622 = 7;
                        int i3722 = 4;
                        if (dVar21 != null) {
                        }
                        dVar3 = dVar22;
                        dVar2 = dVar21;
                        i9 = i5;
                        i7 = 2;
                        if (z2) {
                        }
                        int i3822 = 8;
                        int i3922 = bVar.j;
                        if (i3922 <= 0) {
                        }
                        b.g.b.h.d dVar2722 = dVar2;
                        dVar4 = dVar2722;
                        while (dVar4 != null) {
                        }
                        i6 = i9;
                        b.g.b.h.c cVar1922 = dVar2.F[i3];
                        cVar3 = dVar19.F[i3].f1501c;
                        int i4222 = i3 + 1;
                        cVar4 = dVar3.F[i4222];
                        cVar5 = dVar20.F[i4222].f1501c;
                        if (cVar3 != null) {
                        }
                        dVar.d(cVar4.f1504f, cVar5.f1504f, -cVar4.b(), 4);
                        cVar = dVar2.F[i3];
                        i8 = i3 + 1;
                        cVar2 = dVar3.F[i8];
                        b.g.b.h.c cVar20222 = cVar.f1501c;
                        if (cVar20222 != null) {
                        }
                        b.g.b.h.c cVar21222 = cVar2.f1501c;
                        if (cVar21222 != null) {
                        }
                        if (dVar20 != dVar3) {
                        }
                        if (dVar2 == dVar3) {
                        }
                        dVar.b(cVar.f1504f, gVar, cVar.b(), 0.5f, gVar2, cVar2.f1504f, dVar3.F[i8].b(), 5);
                        i19 = i6 + 1;
                        eVar2 = eVar;
                        i18 = i7;
                        bVarArr = bVarArr;
                        i4 = i4;
                        aVar2 = aVar2;
                    }
                } else {
                    f2 = f6;
                    i5 = i19;
                    z8 = dVar23.Z == 0;
                    z9 = dVar23.Z == 1;
                }
                z3 = z9;
                z2 = z8;
                z4 = true;
                b.g.b.h.d dVar242 = dVar19;
                z5 = false;
                while (!z5) {
                }
                if (dVar22 != null) {
                }
                if (z12) {
                }
                ArrayList<b.g.b.h.d> arrayList2222 = bVar.h;
                if (bVar.q) {
                }
                b.g.b.h.d dVar25222 = null;
                float f8222 = 0.0f;
                i14 = 0;
                while (i14 < size) {
                }
                int i36222 = 7;
                int i37222 = 4;
                if (dVar21 != null) {
                }
                dVar3 = dVar22;
                dVar2 = dVar21;
                i9 = i5;
                i7 = 2;
                if (z2) {
                }
                int i38222 = 8;
                int i39222 = bVar.j;
                if (i39222 <= 0) {
                }
                b.g.b.h.d dVar27222 = dVar2;
                dVar4 = dVar27222;
                while (dVar4 != null) {
                }
                i6 = i9;
                b.g.b.h.c cVar19222 = dVar2.F[i3];
                cVar3 = dVar19.F[i3].f1501c;
                int i42222 = i3 + 1;
                cVar4 = dVar3.F[i42222];
                cVar5 = dVar20.F[i42222].f1501c;
                if (cVar3 != null) {
                }
                dVar.d(cVar4.f1504f, cVar5.f1504f, -cVar4.b(), 4);
                cVar = dVar2.F[i3];
                i8 = i3 + 1;
                cVar2 = dVar3.F[i8];
                b.g.b.h.c cVar202222 = cVar.f1501c;
                if (cVar202222 != null) {
                }
                b.g.b.h.c cVar212222 = cVar2.f1501c;
                if (cVar212222 != null) {
                }
                if (dVar20 != dVar3) {
                }
                if (dVar2 == dVar3) {
                }
                dVar.b(cVar.f1504f, gVar, cVar.b(), 0.5f, gVar2, cVar2.f1504f, dVar3.F[i8].b(), 5);
                i19 = i6 + 1;
                eVar2 = eVar;
                i18 = i7;
                bVarArr = bVarArr;
                i4 = i4;
                aVar2 = aVar2;
            }
        }

        public static List<List<byte[]>> a0(Resources resources, int i2) {
            if (i2 == 0) {
                return Collections.emptyList();
            }
            TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
            try {
                if (obtainTypedArray.length() == 0) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                if (obtainTypedArray.getType(0) == 1) {
                    for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                        int resourceId = obtainTypedArray.getResourceId(i3, 0);
                        if (resourceId != 0) {
                            arrayList.add(k0(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(k0(resources.getStringArray(i2)));
                }
                obtainTypedArray.recycle();
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
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
        public static boolean b(int i2, Rect rect, Rect rect2, Rect rect3) {
            int i3;
            int i4;
            boolean c2 = c(i2, rect, rect2);
            if (c(i2, rect, rect3) || !c2) {
                return false;
            }
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
            }
            boolean z = true;
            if (!z || i2 == 17 || i2 == 66) {
                return true;
            }
            int P = P(i2, rect, rect2);
            if (i2 == 17) {
                i4 = rect.left;
                i3 = rect3.left;
            } else if (i2 == 33) {
                i4 = rect.top;
                i3 = rect3.top;
            } else if (i2 == 66) {
                i4 = rect3.right;
                i3 = rect.right;
            } else if (i2 == 130) {
                i4 = rect3.bottom;
                i3 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return P < Math.max(1, i4 - i3);
        }

        public static void b0(TextView textView, int i2) {
            f(i2);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setFirstBaselineToTopHeight(i2);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
            }
        }

        public static boolean c(int i2, Rect rect, Rect rect2) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return rect2.right >= rect.left && rect2.left <= rect.right;
            }
            return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        }

        public static void c0(TextView textView, int i2) {
            f(i2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
            }
        }

        public static void d(Object obj, StringBuilder sb) {
            String str;
            int lastIndexOf;
            if (obj == null) {
                str = "null";
            } else {
                String simpleName = obj.getClass().getSimpleName();
                if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                    simpleName = simpleName.substring(lastIndexOf + 1);
                }
                sb.append(simpleName);
                sb.append('{');
                str = Integer.toHexString(System.identityHashCode(obj));
            }
            sb.append(str);
        }

        public static void d0(TextView textView, int i2) {
            f(i2);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i2 != fontMetricsInt) {
                textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
            }
        }

        public static boolean e(b.i.f.c[] cVarArr, b.i.f.c[] cVarArr2) {
            if (cVarArr == null || cVarArr2 == null || cVarArr.length != cVarArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                if (!(cVarArr[i2].f1749a == cVarArr2[i2].f1749a && cVarArr[i2].f1750b.length == cVarArr2[i2].f1750b.length)) {
                    return false;
                }
            }
            return true;
        }

        public static void e0(TextView textView, b.i.j.b bVar) {
            if (Build.VERSION.SDK_INT < 29) {
                J(textView);
                if (bVar != null) {
                    throw null;
                }
                throw null;
            } else if (bVar != null) {
                textView.setText((CharSequence) null);
            } else {
                throw null;
            }
        }

        public static int f(int i2) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException();
        }

        public static void f0(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        public static <T> T g(T t) {
            if (t != null) {
                return t;
            }
            throw null;
        }

        public static void g0(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static <T> T h(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static void h0(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        public static int i(Context context, String str, int i2, int i3, String str2) {
            if (context.checkPermission(str, i2, i3) == -1) {
                return -1;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp == null) {
                return 0;
            }
            if (str2 == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, str2) != 0) {
                return -2;
            }
            return 0;
        }

        public static void i0(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            b1 b1Var = b1.k;
            if (b1Var != null && b1Var.f796b == view) {
                b1.c(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                b1 b1Var2 = b1.l;
                if (b1Var2 != null && b1Var2.f796b == view) {
                    b1Var2.b();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new b1(view, charSequence);
        }

        public static int j(int i2, int i3, int i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }

        public static void j0(XmlPullParser xmlPullParser) {
            int i2 = 1;
            while (i2 > 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i2++;
                } else if (next == 3) {
                    i2--;
                }
            }
        }

        public static int k(RecyclerView.x xVar, a0 a0Var, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.y() == 0 || xVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(mVar.P(view) - mVar.P(view2)) + 1;
            }
            return Math.min(a0Var.l(), a0Var.b(view2) - a0Var.e(view));
        }

        public static List<byte[]> k0(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        public static int l(RecyclerView.x xVar, a0 a0Var, View view, View view2, RecyclerView.m mVar, boolean z, boolean z2) {
            if (mVar.y() == 0 || xVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            int max = z2 ? Math.max(0, (xVar.b() - Math.max(mVar.P(view), mVar.P(view2))) - 1) : Math.max(0, Math.min(mVar.P(view), mVar.P(view2)));
            if (!z) {
                return max;
            }
            return Math.round((((float) max) * (((float) Math.abs(a0Var.b(view2) - a0Var.e(view))) / ((float) (Math.abs(mVar.P(view) - mVar.P(view2)) + 1)))) + ((float) (a0Var.k() - a0Var.e(view))));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Drawable> T l0(Drawable drawable) {
            return drawable instanceof b.i.f.k.a ? (T) ((b.i.f.k.a) drawable).a() : drawable;
        }

        public static int m(RecyclerView.x xVar, a0 a0Var, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.y() == 0 || xVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return xVar.b();
            }
            return (int) ((((float) (a0Var.b(view2) - a0Var.e(view))) / ((float) (Math.abs(mVar.P(view) - mVar.P(view2)) + 1))) * ((float) xVar.b()));
        }

        public static ActionMode.Callback m0(TextView textView, ActionMode.Callback callback) {
            int i2 = Build.VERSION.SDK_INT;
            return (i2 < 26 || i2 > 27 || (callback instanceof b.i.m.d)) ? callback : new b.i.m.d(callback, textView);
        }

        public static float[] n(float[] fArr, int i2, int i3) {
            if (i2 <= i3) {
                int length = fArr.length;
                if (i2 < 0 || i2 > length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i4 = i3 - i2;
                int min = Math.min(i4, length - i2);
                float[] fArr2 = new float[i4];
                System.arraycopy(fArr, i2, fArr2, 0, min);
                return fArr2;
            }
            throw new IllegalArgumentException();
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
        public static boolean o(File file, Resources resources, int i2) {
            InputStream inputStream;
            Throwable th;
            try {
                inputStream = resources.openRawResource(i2);
                try {
                    boolean p = p(file, inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return p;
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

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0039 A[SYNTHETIC, Splitter:B:30:0x0039] */
        public static boolean p(File file, InputStream inputStream) {
            Throwable th;
            IOException e2;
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
                } catch (IOException e3) {
                    e2 = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e2.getMessage();
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
            } catch (IOException e4) {
                e2 = e4;
                e2.getMessage();
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

        public static ColorStateList q(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
            int next;
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return r(resources, xmlPullParser, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static ColorStateList r(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            int depth;
            int attributeCount;
            int i2;
            int i3;
            int i4;
            String name = xmlPullParser.getName();
            if (name.equals("selector")) {
                int i5 = 1;
                int depth2 = xmlPullParser.getDepth() + 1;
                int[][] iArr = new int[20][];
                int[] iArr2 = new int[20];
                int i6 = 0;
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == i5 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                        int[] iArr3 = new int[i6];
                        int[][] iArr4 = new int[i6][];
                        System.arraycopy(iArr2, 0, iArr3, 0, i6);
                        System.arraycopy(iArr, 0, iArr4, 0, i6);
                    } else {
                        if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                            int[] iArr5 = b.i.c.ColorStateListItem;
                            TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr5) : theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                            int color = obtainAttributes.getColor(b.i.c.ColorStateListItem_android_color, -65281);
                            float f2 = 1.0f;
                            if (obtainAttributes.hasValue(b.i.c.ColorStateListItem_android_alpha)) {
                                i4 = b.i.c.ColorStateListItem_android_alpha;
                            } else {
                                if (obtainAttributes.hasValue(b.i.c.ColorStateListItem_alpha)) {
                                    i4 = b.i.c.ColorStateListItem_alpha;
                                }
                                obtainAttributes.recycle();
                                attributeCount = attributeSet.getAttributeCount();
                                int[] iArr6 = new int[attributeCount];
                                int i7 = 0;
                                for (i2 = 0; i2 < attributeCount; i2++) {
                                    int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                                    if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == b.i.a.alpha)) {
                                        int i8 = i7 + 1;
                                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                            attributeNameResource = -attributeNameResource;
                                        }
                                        iArr6[i7] = attributeNameResource;
                                        i7 = i8;
                                    }
                                }
                                int[] trimStateSet = StateSet.trimStateSet(iArr6, i7);
                                int round = (Math.round(((float) Color.alpha(color)) * f2) << 24) | (color & 16777215);
                                i3 = i6 + 1;
                                int i9 = 8;
                                if (i3 > iArr2.length) {
                                    int[] iArr7 = new int[(i6 <= 4 ? 8 : i6 * 2)];
                                    System.arraycopy(iArr2, 0, iArr7, 0, i6);
                                    iArr2 = iArr7;
                                }
                                iArr2[i6] = round;
                                if (i3 > iArr.length) {
                                    Class<?> componentType = iArr.getClass().getComponentType();
                                    if (i6 > 4) {
                                        i9 = i6 * 2;
                                    }
                                    ?? r8 = (Object[]) Array.newInstance(componentType, i9);
                                    System.arraycopy(iArr, 0, r8, 0, i6);
                                    iArr = r8;
                                }
                                iArr[i6] = trimStateSet;
                                iArr = iArr;
                                i6 = i3;
                            }
                            f2 = obtainAttributes.getFloat(i4, 1.0f);
                            obtainAttributes.recycle();
                            attributeCount = attributeSet.getAttributeCount();
                            int[] iArr62 = new int[attributeCount];
                            int i72 = 0;
                            while (i2 < attributeCount) {
                            }
                            int[] trimStateSet2 = StateSet.trimStateSet(iArr62, i72);
                            int round2 = (Math.round(((float) Color.alpha(color)) * f2) << 24) | (color & 16777215);
                            i3 = i6 + 1;
                            int i92 = 8;
                            if (i3 > iArr2.length) {
                            }
                            iArr2[i6] = round2;
                            if (i3 > iArr.length) {
                            }
                            iArr[i6] = trimStateSet2;
                            iArr = iArr;
                            i6 = i3;
                        }
                        i5 = 1;
                    }
                }
                int[] iArr32 = new int[i6];
                int[][] iArr42 = new int[i6][];
                System.arraycopy(iArr2, 0, iArr32, 0, i6);
                System.arraycopy(iArr, 0, iArr42, 0, i6);
                return new ColorStateList(iArr42, iArr32);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008a, code lost:
            if (r13 == 0) goto L_0x008c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ NumberFormatException -> 0x00bc }, LOOP:3: B:25:0x006c->B:45:0x0097, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0096 A[SYNTHETIC] */
        public static b.i.f.c[] s(String str) {
            String trim;
            float[] fArr;
            if (str == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 1;
            int i4 = 0;
            while (i3 < str.length()) {
                while (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    if ((charAt - 'Z') * (charAt - 'A') > 0) {
                        if ((charAt - 'z') * (charAt - 'a') > 0) {
                            continue;
                            i3++;
                        }
                    }
                    if (!(charAt == 'e' || charAt == 'E')) {
                        trim = str.substring(i2, i3).trim();
                        if (trim.length() > 0) {
                            if (trim.charAt(i4) == 'z' || trim.charAt(i4) == 'Z') {
                                fArr = new float[i4];
                            } else {
                                try {
                                    float[] fArr2 = new float[trim.length()];
                                    int length = trim.length();
                                    int i5 = 1;
                                    int i6 = i4;
                                    while (i5 < length) {
                                        int i7 = i4;
                                        int i8 = i7;
                                        int i9 = i8;
                                        int i10 = i5;
                                        while (true) {
                                            if (i10 < trim.length()) {
                                                char charAt2 = trim.charAt(i10);
                                                if (charAt2 != ' ') {
                                                    if (charAt2 == 'E' || charAt2 == 'e') {
                                                        i9 = 1;
                                                        if (i4 == 0) {
                                                            i10++;
                                                        }
                                                    } else {
                                                        switch (charAt2) {
                                                            case '-':
                                                                if (i10 != i5) {
                                                                }
                                                                break;
                                                            case '.':
                                                                if (i8 == 0) {
                                                                    i8 = 1;
                                                                    break;
                                                                }
                                                                i7 = 1;
                                                                break;
                                                        }
                                                        i9 = 0;
                                                        if (i4 == 0) {
                                                        }
                                                    }
                                                }
                                                i4 = 1;
                                                i9 = 0;
                                                if (i4 == 0) {
                                                }
                                            }
                                        }
                                        if (i5 < i10) {
                                            fArr2[i6] = Float.parseFloat(trim.substring(i5, i10));
                                            i6++;
                                        }
                                        if (i7 == 0) {
                                            i10++;
                                        }
                                        i5 = i10;
                                        i4 = 0;
                                    }
                                    fArr = n(fArr2, i4, i6);
                                    i4 = 0;
                                } catch (NumberFormatException e2) {
                                    throw new RuntimeException(c.a.a.a.a.c("error in parsing \"", trim, "\""), e2);
                                }
                            }
                            arrayList.add(new b.i.f.c(trim.charAt(i4), fArr));
                        }
                        i4 = 0;
                        i3++;
                        i2 = i3;
                    }
                    i3++;
                }
                trim = str.substring(i2, i3).trim();
                if (trim.length() > 0) {
                }
                i4 = 0;
                i3++;
                i2 = i3;
            }
            if (i3 - i2 == 1 && i2 < str.length()) {
                arrayList.add(new b.i.f.c(str.charAt(i2), new float[0]));
            }
            return (b.i.f.c[]) arrayList.toArray(new b.i.f.c[arrayList.size()]);
        }

        public static Path t(String str) {
            Path path = new Path();
            b.i.f.c[] s = s(str);
            if (s == null) {
                return null;
            }
            try {
                b.i.f.c.b(s, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException(c.a.a.a.a.q("Error in parsing ", str), e2);
            }
        }

        public static <T extends b.s.h> h.a<T> u(Context context, Class<T> cls, String str) {
            if (str.trim().length() != 0) {
                return new h.a<>(context, cls, str);
            }
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }

        public static b.i.f.c[] v(b.i.f.c[] cVarArr) {
            if (cVarArr == null) {
                return null;
            }
            b.i.f.c[] cVarArr2 = new b.i.f.c[cVarArr.length];
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                cVarArr2[i2] = new b.i.f.c(cVarArr[i2]);
            }
            return cVarArr2;
        }

        public static b.q.e w(RandomAccessFile randomAccessFile) {
            long length = randomAccessFile.length() - 22;
            long j2 = 0;
            if (length >= 0) {
                long j3 = length - 65536;
                if (j3 >= 0) {
                    j2 = j3;
                }
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        b.q.e eVar = new b.q.e();
                        eVar.f2281b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                        eVar.f2280a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                        return eVar;
                    }
                    length--;
                } while (length >= j2);
                throw new ZipException("End Of Central Directory signature not found");
            }
            StringBuilder h2 = c.a.a.a.a.h("File too short to be a zip file: ");
            h2.append(randomAccessFile.length());
            throw new ZipException(h2.toString());
        }

        public static void x(Object obj) {
            if (!f540d) {
                try {
                    f539c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException unused) {
                }
                f540d = true;
            }
            Class<?> cls = f539c;
            if (cls != null) {
                if (!f542f) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        f541e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused2) {
                    }
                    f542f = true;
                }
                Field field = f541e;
                if (field != null) {
                    LongSparseArray longSparseArray = null;
                    try {
                        longSparseArray = (LongSparseArray) field.get(obj);
                    } catch (IllegalAccessException unused3) {
                    }
                    if (longSparseArray != null) {
                        longSparseArray.clear();
                    }
                }
            }
        }

        public static int y(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static <T> u<T> z(b.f.a.d<T> dVar) {
            b.f.a.b<T> bVar = new b.f.a.b<>();
            b.f.a.e<T> eVar = new b.f.a.e<>(bVar);
            bVar.f1445b = eVar;
            bVar.f1444a = dVar.getClass();
            try {
                Object a2 = dVar.a(bVar);
                if (a2 != null) {
                    bVar.f1444a = a2;
                }
            } catch (Exception e2) {
                eVar.f1449c.l(e2);
            }
            return eVar;
        }
    }

    public class k extends ContentFrameLayout {
        public k(Context context) {
            super(context, null);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.x(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    i iVar = i.this;
                    iVar.v(iVar.E(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(b.b.l.a.a.b(getContext(), i));
        }
    }

    public static final class l {

        /* renamed from: a  reason: collision with root package name */
        public int f544a;

        /* renamed from: b  reason: collision with root package name */
        public int f545b;

        /* renamed from: c  reason: collision with root package name */
        public int f546c;

        /* renamed from: d  reason: collision with root package name */
        public int f547d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f548e;

        /* renamed from: f  reason: collision with root package name */
        public View f549f;

        /* renamed from: g  reason: collision with root package name */
        public View f550g;
        public b.b.p.i.g h;
        public b.b.p.i.e i;
        public Context j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public l(int i2) {
            this.f544a = i2;
        }

        public void a(b.b.p.i.g gVar) {
            b.b.p.i.e eVar;
            b.b.p.i.g gVar2 = this.h;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.u(this.i);
                }
                this.h = gVar;
                if (gVar != null && (eVar = this.i) != null) {
                    gVar.b(eVar, gVar.f722a);
                }
            }
        }
    }

    public final class m implements m.a {
        public m() {
        }

        @Override // b.b.p.i.m.a
        public void b(b.b.p.i.g gVar, boolean z) {
            b.b.p.i.g k = gVar.k();
            boolean z2 = k != gVar;
            i iVar = i.this;
            if (z2) {
                gVar = k;
            }
            l C = iVar.C(gVar);
            if (C == null) {
                return;
            }
            if (z2) {
                i.this.t(C.f544a, C, k);
                i.this.v(C, true);
                return;
            }
            i.this.v(C, z);
        }

        @Override // b.b.p.i.m.a
        public boolean c(b.b.p.i.g gVar) {
            Window.Callback F;
            if (gVar != gVar.k()) {
                return true;
            }
            i iVar = i.this;
            if (!iVar.A || (F = iVar.F()) == null || i.this.M) {
                return true;
            }
            F.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        if (b0 && !f0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    public i(Context context, Window window, g gVar, Object obj) {
        Integer orDefault;
        f fVar;
        this.f520e = context;
        this.h = gVar;
        this.f519d = obj;
        if (this.N == -100 && (obj instanceof Dialog)) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof f)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        fVar = (f) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            fVar = null;
            if (fVar != null) {
                this.N = ((i) fVar.getDelegate()).N;
            }
        }
        if (this.N == -100 && (orDefault = a0.getOrDefault(this.f519d.getClass().getName(), null)) != null) {
            this.N = orDefault.intValue();
            a0.remove(this.f519d.getClass().getName());
        }
        if (window != null) {
            s(window);
        }
        b.b.q.j.e();
    }

    public final void A() {
        ViewGroup viewGroup;
        if (!this.u) {
            TypedArray obtainStyledAttributes = this.f520e.obtainStyledAttributes(b.b.j.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(b.b.j.AppCompatTheme_windowActionBar)) {
                if (obtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowNoTitle, false)) {
                    k(1);
                } else if (obtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionBar, false)) {
                    k(108);
                }
                if (obtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionBarOverlay, false)) {
                    k(109);
                }
                if (obtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionModeOverlay, false)) {
                    k(10);
                }
                this.D = obtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                B();
                this.f521f.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.f520e);
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(this.C ? b.b.g.abc_screen_simple_overlay_action_mode : b.b.g.abc_screen_simple, (ViewGroup) null);
                } else if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(b.b.g.abc_dialog_title_material, (ViewGroup) null);
                    this.B = false;
                    this.A = false;
                } else if (this.A) {
                    TypedValue typedValue = new TypedValue();
                    this.f520e.getTheme().resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                    viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new b.b.p.c(this.f520e, typedValue.resourceId) : this.f520e).inflate(b.b.g.abc_screen_toolbar, (ViewGroup) null);
                    c0 c0Var = (c0) viewGroup.findViewById(b.b.f.decor_content_parent);
                    this.l = c0Var;
                    c0Var.setWindowCallback(F());
                    if (this.B) {
                        this.l.k(109);
                    }
                    if (this.y) {
                        this.l.k(2);
                    }
                    if (this.z) {
                        this.l.k(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    b.i.l.m.c0(viewGroup, new j(this));
                    if (this.l == null) {
                        this.w = (TextView) viewGroup.findViewById(b.b.f.title);
                    }
                    e1.b(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.b.f.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f521f.findViewById(16908290);
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
                    this.f521f.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new l(this));
                    this.v = viewGroup;
                    Object obj = this.f519d;
                    CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.k;
                    if (!TextUtils.isEmpty(title)) {
                        c0 c0Var2 = this.l;
                        if (c0Var2 != null) {
                            c0Var2.setWindowTitle(title);
                        } else {
                            a aVar = this.i;
                            if (aVar != null) {
                                aVar.n(title);
                            } else {
                                TextView textView = this.w;
                                if (textView != null) {
                                    textView.setText(title);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.v.findViewById(16908290);
                    View decorView = this.f521f.getDecorView();
                    contentFrameLayout2.h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.f520e.obtainStyledAttributes(b.b.j.AppCompatTheme);
                    obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedWidthMajor)) {
                        obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedWidthMinor)) {
                        obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedHeightMajor)) {
                        obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedHeightMinor)) {
                        obtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.u = true;
                    l E2 = E(0);
                    if (!this.M && E2.h == null) {
                        H(108);
                        return;
                    }
                    return;
                }
                StringBuilder h2 = c.a.a.a.a.h("AppCompat does not support the current theme features: { windowActionBar: ");
                h2.append(this.A);
                h2.append(", windowActionBarOverlay: ");
                h2.append(this.B);
                h2.append(", android:windowIsFloating: ");
                h2.append(this.D);
                h2.append(", windowActionModeOverlay: ");
                h2.append(this.C);
                h2.append(", windowNoTitle: ");
                h2.append(this.E);
                h2.append(" }");
                throw new IllegalArgumentException(h2.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void B() {
        if (this.f521f == null) {
            Object obj = this.f519d;
            if (obj instanceof Activity) {
                s(((Activity) obj).getWindow());
            }
        }
        if (this.f521f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public l C(Menu menu) {
        l[] lVarArr = this.G;
        int length = lVarArr != null ? lVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            l lVar = lVarArr[i2];
            if (lVar != null && lVar.h == menu) {
                return lVar;
            }
        }
        return null;
    }

    public final h D(Context context) {
        if (this.R == null) {
            if (t.f587d == null) {
                Context applicationContext = context.getApplicationContext();
                t.f587d = new t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.R = new C0009i(t.f587d);
        }
        return this.R;
    }

    public l E(int i2) {
        l[] lVarArr = this.G;
        if (lVarArr == null || lVarArr.length <= i2) {
            l[] lVarArr2 = new l[(i2 + 1)];
            if (lVarArr != null) {
                System.arraycopy(lVarArr, 0, lVarArr2, 0, lVarArr.length);
            }
            this.G = lVarArr2;
            lVarArr = lVarArr2;
        }
        l lVar = lVarArr[i2];
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(i2);
        lVarArr[i2] = lVar2;
        return lVar2;
    }

    public final Window.Callback F() {
        return this.f521f.getCallback();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final void G() {
        a aVar;
        u uVar;
        A();
        if (this.A && this.i == null) {
            Object obj = this.f519d;
            if (obj instanceof Activity) {
                uVar = new u((Activity) this.f519d, this.B);
            } else {
                if (obj instanceof Dialog) {
                    uVar = new u((Dialog) this.f519d);
                }
                aVar = this.i;
                if (aVar == null) {
                    aVar.l(this.W);
                    return;
                }
                return;
            }
            this.i = uVar;
            aVar = this.i;
            if (aVar == null) {
            }
        }
    }

    public final void H(int i2) {
        this.U = (1 << i2) | this.U;
        if (!this.T) {
            b.i.l.m.N(this.f521f.getDecorView(), this.V);
            this.T = true;
        }
    }

    public int I(Context context, int i2) {
        h D2;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        if (this.S == null) {
                            this.S = new g(context);
                        }
                        D2 = this.S;
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                return -1;
            } else {
                D2 = D(context);
            }
            return D2.c();
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0159, code lost:
        if (r3 != null) goto L_0x015b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0160  */
    public final void J(l lVar, KeyEvent keyEvent) {
        int i2;
        boolean z2;
        ViewGroup.LayoutParams layoutParams;
        if (!lVar.m && !this.M) {
            if (lVar.f544a == 0) {
                if ((this.f520e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback F2 = F();
            if (F2 == null || F2.onMenuOpened(lVar.f544a, lVar.h)) {
                WindowManager windowManager = (WindowManager) this.f520e.getSystemService("window");
                if (windowManager != null && L(lVar, keyEvent)) {
                    if (lVar.f548e == null || lVar.o) {
                        ViewGroup viewGroup = lVar.f548e;
                        ExpandedMenuView expandedMenuView = null;
                        if (viewGroup == null) {
                            G();
                            a aVar = this.i;
                            Context e2 = aVar != null ? aVar.e() : null;
                            if (e2 == null) {
                                e2 = this.f520e;
                            }
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme newTheme = e2.getResources().newTheme();
                            newTheme.setTo(e2.getTheme());
                            newTheme.resolveAttribute(b.b.a.actionBarPopupTheme, typedValue, true);
                            int i3 = typedValue.resourceId;
                            if (i3 != 0) {
                                newTheme.applyStyle(i3, true);
                            }
                            newTheme.resolveAttribute(b.b.a.panelMenuListTheme, typedValue, true);
                            int i4 = typedValue.resourceId;
                            if (i4 == 0) {
                                i4 = b.b.i.Theme_AppCompat_CompactMenu;
                            }
                            newTheme.applyStyle(i4, true);
                            b.b.p.c cVar = new b.b.p.c(e2, 0);
                            cVar.getTheme().setTo(newTheme);
                            lVar.j = cVar;
                            TypedArray obtainStyledAttributes = cVar.obtainStyledAttributes(b.b.j.AppCompatTheme);
                            lVar.f545b = obtainStyledAttributes.getResourceId(b.b.j.AppCompatTheme_panelBackground, 0);
                            lVar.f547d = obtainStyledAttributes.getResourceId(b.b.j.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            lVar.f548e = new k(lVar.j);
                            lVar.f546c = 81;
                        } else if (lVar.o && viewGroup.getChildCount() > 0) {
                            lVar.f548e.removeAllViews();
                        }
                        View view = lVar.f550g;
                        if (view != null) {
                            lVar.f549f = view;
                        } else {
                            if (lVar.h != null) {
                                if (this.n == null) {
                                    this.n = new m();
                                }
                                m mVar = this.n;
                                if (lVar.h != null) {
                                    if (lVar.i == null) {
                                        b.b.p.i.e eVar = new b.b.p.i.e(lVar.j, b.b.g.abc_list_menu_item_layout);
                                        lVar.i = eVar;
                                        eVar.i = mVar;
                                        b.b.p.i.g gVar = lVar.h;
                                        gVar.b(eVar, gVar.f722a);
                                    }
                                    b.b.p.i.e eVar2 = lVar.i;
                                    ViewGroup viewGroup2 = lVar.f548e;
                                    if (eVar2.f711e == null) {
                                        eVar2.f711e = (ExpandedMenuView) eVar2.f709c.inflate(b.b.g.abc_expanded_menu_layout, viewGroup2, false);
                                        if (eVar2.j == null) {
                                            eVar2.j = new e.a();
                                        }
                                        eVar2.f711e.setAdapter((ListAdapter) eVar2.j);
                                        eVar2.f711e.setOnItemClickListener(eVar2);
                                    }
                                    expandedMenuView = eVar2.f711e;
                                }
                                lVar.f549f = expandedMenuView;
                            }
                            z2 = false;
                            if (z2) {
                                if (lVar.f549f != null && (lVar.f550g != null || ((e.a) lVar.i.a()).getCount() > 0)) {
                                    ViewGroup.LayoutParams layoutParams2 = lVar.f549f.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                    }
                                    lVar.f548e.setBackgroundResource(lVar.f545b);
                                    ViewParent parent = lVar.f549f.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(lVar.f549f);
                                    }
                                    lVar.f548e.addView(lVar.f549f, layoutParams2);
                                    if (!lVar.f549f.hasFocus()) {
                                        lVar.f549f.requestFocus();
                                    }
                                }
                            }
                            lVar.o = true;
                            return;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        lVar.o = true;
                        return;
                    }
                    View view2 = lVar.f550g;
                    if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        lVar.l = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams3.gravity = lVar.f546c;
                        layoutParams3.windowAnimations = lVar.f547d;
                        windowManager.addView(lVar.f548e, layoutParams3);
                        lVar.m = true;
                        return;
                    }
                    i2 = -2;
                    lVar.l = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams32.gravity = lVar.f546c;
                    layoutParams32.windowAnimations = lVar.f547d;
                    windowManager.addView(lVar.f548e, layoutParams32);
                    lVar.m = true;
                    return;
                }
                return;
            }
            v(lVar, true);
        }
    }

    public final boolean K(l lVar, int i2, KeyEvent keyEvent, int i3) {
        b.b.p.i.g gVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((lVar.k || L(lVar, keyEvent)) && (gVar = lVar.h) != null) {
            z2 = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.l == null) {
            v(lVar, true);
        }
        return z2;
    }

    public final boolean L(l lVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        Resources.Theme theme;
        c0 c0Var3;
        if (this.M) {
            return false;
        }
        if (lVar.k) {
            return true;
        }
        l lVar2 = this.H;
        if (!(lVar2 == null || lVar2 == lVar)) {
            v(lVar2, false);
        }
        Window.Callback F2 = F();
        if (F2 != null) {
            lVar.f550g = F2.onCreatePanelView(lVar.f544a);
        }
        int i2 = lVar.f544a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (c0Var3 = this.l) != null) {
            c0Var3.f();
        }
        if (lVar.f550g == null && (!z2 || !(this.i instanceof r))) {
            if (lVar.h == null || lVar.p) {
                if (lVar.h == null) {
                    Context context = this.f520e;
                    int i3 = lVar.f544a;
                    if ((i3 == 0 || i3 == 108) && this.l != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
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
                            b.b.p.c cVar = new b.b.p.c(context, 0);
                            cVar.getTheme().setTo(theme);
                            context = cVar;
                        }
                    }
                    b.b.p.i.g gVar = new b.b.p.i.g(context);
                    gVar.f726e = this;
                    lVar.a(gVar);
                    if (lVar.h == null) {
                        return false;
                    }
                }
                if (z2 && this.l != null) {
                    if (this.m == null) {
                        this.m = new d();
                    }
                    this.l.a(lVar.h, this.m);
                }
                lVar.h.z();
                if (!F2.onCreatePanelMenu(lVar.f544a, lVar.h)) {
                    lVar.a(null);
                    if (z2 && (c0Var2 = this.l) != null) {
                        c0Var2.a(null, this.m);
                    }
                    return false;
                }
                lVar.p = false;
            }
            lVar.h.z();
            Bundle bundle = lVar.q;
            if (bundle != null) {
                lVar.h.v(bundle);
                lVar.q = null;
            }
            if (!F2.onPreparePanel(0, lVar.f550g, lVar.h)) {
                if (z2 && (c0Var = this.l) != null) {
                    c0Var.a(null, this.m);
                }
                lVar.h.y();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            lVar.n = z3;
            lVar.h.setQwertyMode(z3);
            lVar.h.y();
        }
        lVar.k = true;
        lVar.l = false;
        this.H = lVar;
        return true;
    }

    public final boolean M() {
        ViewGroup viewGroup;
        return this.u && (viewGroup = this.v) != null && b.i.l.m.C(viewGroup);
    }

    public final void N() {
        if (this.u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int O(v vVar, Rect rect) {
        boolean z2;
        boolean z3;
        int i2;
        Context context;
        int i3 = 0;
        int d2 = vVar != null ? vVar.d() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            boolean z4 = true;
            if (this.p.isShown()) {
                if (this.X == null) {
                    this.X = new Rect();
                    this.Y = new Rect();
                }
                Rect rect2 = this.X;
                Rect rect3 = this.Y;
                if (vVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(vVar.b(), vVar.d(), vVar.c(), vVar.a());
                }
                ViewGroup viewGroup = this.v;
                Method method = e1.f829a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception unused) {
                    }
                }
                int i4 = rect2.top;
                int i5 = rect2.left;
                int i6 = rect2.right;
                v u2 = b.i.l.m.u(this.v);
                int b2 = u2.b();
                int c2 = u2.c();
                if (marginLayoutParams.topMargin == i4 && marginLayoutParams.leftMargin == i5 && marginLayoutParams.rightMargin == i6) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i4;
                    marginLayoutParams.leftMargin = i5;
                    marginLayoutParams.rightMargin = i6;
                    z3 = true;
                }
                if (i4 <= 0 || this.x != null) {
                    View view = this.x;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == b2 && marginLayoutParams2.rightMargin == c2)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = b2;
                            marginLayoutParams2.rightMargin = c2;
                            this.x.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f520e);
                    this.x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b2;
                    layoutParams.rightMargin = c2;
                    this.v.addView(this.x, -1, layoutParams);
                }
                z2 = this.x != null;
                if (z2 && this.x.getVisibility() != 0) {
                    View view3 = this.x;
                    if ((view3.getWindowSystemUiVisibility() & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        context = this.f520e;
                        i2 = b.b.c.abc_decor_view_status_guard_light;
                    } else {
                        context = this.f520e;
                        i2 = b.b.c.abc_decor_view_status_guard;
                    }
                    view3.setBackgroundColor(b.i.e.a.b(context, i2));
                }
                if (!this.C && z2) {
                    d2 = 0;
                }
                z4 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.p.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.x;
        if (view4 != null) {
            if (!z2) {
                i3 = 8;
            }
            view4.setVisibility(i3);
        }
        return d2;
    }

    @Override // b.b.p.i.g.a
    public boolean a(b.b.p.i.g gVar, MenuItem menuItem) {
        l C2;
        Window.Callback F2 = F();
        if (F2 == null || this.M || (C2 = C(gVar.k())) == null) {
            return false;
        }
        return F2.onMenuItemSelected(C2.f544a, menuItem);
    }

    @Override // b.b.p.i.g.a
    public void b(b.b.p.i.g gVar) {
        c0 c0Var = this.l;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.f520e).hasPermanentMenuKey() && !this.l.b())) {
            l E2 = E(0);
            E2.o = true;
            v(E2, false);
            J(E2, null);
            return;
        }
        Window.Callback F2 = F();
        if (this.l.c()) {
            this.l.d();
            if (!this.M) {
                F2.onPanelClosed(108, E(0).h);
            }
        } else if (F2 != null && !this.M) {
            if (this.T && (1 & this.U) != 0) {
                this.f521f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            l E3 = E(0);
            b.b.p.i.g gVar2 = E3.h;
            if (gVar2 != null && !E3.p && F2.onPreparePanel(0, E3.f550g, gVar2)) {
                F2.onMenuOpened(108, E3.h);
                this.l.e();
            }
        }
    }

    @Override // b.b.k.h
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        A();
        ((ViewGroup) this.v.findViewById(16908290)).addView(view, layoutParams);
        this.f522g.f676b.onContentChanged();
    }

    @Override // b.b.k.h
    public void f() {
        LayoutInflater from = LayoutInflater.from(this.f520e);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z2 = from.getFactory2() instanceof i;
        }
    }

    @Override // b.b.k.h
    public void g() {
        G();
        a aVar = this.i;
        if (aVar == null || !aVar.f()) {
            H(0);
        }
    }

    @Override // b.b.k.h
    public void h(Bundle bundle) {
        this.J = true;
        r(false);
        B();
        Object obj = this.f519d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = j.H(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a aVar = this.i;
                if (aVar == null) {
                    this.W = true;
                } else {
                    aVar.l(true);
                }
            }
        }
        synchronized (h.f518c) {
            h.j(this);
            h.f517b.add(new WeakReference<>(this));
        }
        this.K = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // b.b.k.h
    public void i() {
        a aVar;
        h hVar;
        h hVar2;
        synchronized (h.f518c) {
            h.j(this);
        }
        if (this.T) {
            this.f521f.getDecorView().removeCallbacks(this.V);
        }
        this.L = false;
        this.M = true;
        if (this.N != -100) {
            Object obj = this.f519d;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                a0.put(this.f519d.getClass().getName(), Integer.valueOf(this.N));
                aVar = this.i;
                if (aVar != null) {
                    aVar.h();
                }
                hVar = this.R;
                if (hVar != null) {
                    hVar.a();
                }
                hVar2 = this.S;
                if (hVar2 == null) {
                    hVar2.a();
                    return;
                }
                return;
            }
        }
        a0.remove(this.f519d.getClass().getName());
        aVar = this.i;
        if (aVar != null) {
        }
        hVar = this.R;
        if (hVar != null) {
        }
        hVar2 = this.S;
        if (hVar2 == null) {
        }
    }

    @Override // b.b.k.h
    public boolean k(int i2) {
        if (i2 == 8) {
            i2 = 108;
        } else if (i2 == 9) {
            i2 = 109;
        }
        if (this.E && i2 == 108) {
            return false;
        }
        if (this.A && i2 == 1) {
            this.A = false;
        }
        if (i2 == 1) {
            N();
            this.E = true;
            return true;
        } else if (i2 == 2) {
            N();
            this.y = true;
            return true;
        } else if (i2 == 5) {
            N();
            this.z = true;
            return true;
        } else if (i2 == 10) {
            N();
            this.C = true;
            return true;
        } else if (i2 == 108) {
            N();
            this.A = true;
            return true;
        } else if (i2 != 109) {
            return this.f521f.requestFeature(i2);
        } else {
            N();
            this.B = true;
            return true;
        }
    }

    @Override // b.b.k.h
    public void l(int i2) {
        A();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f520e).inflate(i2, viewGroup);
        this.f522g.f676b.onContentChanged();
    }

    @Override // b.b.k.h
    public void m(View view) {
        A();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f522g.f676b.onContentChanged();
    }

    @Override // b.b.k.h
    public void n(View view, ViewGroup.LayoutParams layoutParams) {
        A();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f522g.f676b.onContentChanged();
    }

    @Override // b.b.k.h
    public final void o(CharSequence charSequence) {
        this.k = charSequence;
        c0 c0Var = this.l;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.n(charSequence);
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r8v2, types: [b.b.k.q] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c1  */
    /* JADX WARNING: Unknown variable types count: 8 */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        char c2;
        View view2;
        q qVar;
        if (this.Z == null) {
            String string = this.f520e.obtainStyledAttributes(b.b.j.AppCompatTheme).getString(b.b.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                qVar = new q();
            } else {
                try {
                    this.Z = (q) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    qVar = new q();
                }
            }
            this.Z = qVar;
        }
        ?? r8 = this.Z;
        d1.a();
        ?? r1 = 0;
        r1 = 0;
        if (r8 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.j.View, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(b.b.j.View_theme, 0);
            obtainStyledAttributes.recycle();
            Context cVar = (resourceId == 0 || ((context instanceof b.b.p.c) && ((b.b.p.c) context).f636a == resourceId)) ? context : new b.b.p.c(context, resourceId);
            switch (str.hashCode()) {
                case -1946472170:
                    if (str.equals("RatingBar")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1455429095:
                    if (str.equals("CheckedTextView")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1346021293:
                    if (str.equals("MultiAutoCompleteTextView")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -938935918:
                    if (str.equals("TextView")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -937446323:
                    if (str.equals("ImageButton")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -658531749:
                    if (str.equals("SeekBar")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -339785223:
                    if (str.equals("Spinner")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 776382189:
                    if (str.equals("RadioButton")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 799298502:
                    if (str.equals("ToggleButton")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1125864064:
                    if (str.equals("ImageView")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1413872058:
                    if (str.equals("AutoCompleteTextView")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1601505219:
                    if (str.equals("CheckBox")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1666676343:
                    if (str.equals("EditText")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2001146706:
                    if (str.equals("Button")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    view2 = r8.e(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 1:
                    view2 = new n(cVar, attributeSet, 0);
                    r8.h(view2, str);
                    break;
                case 2:
                    view2 = r8.b(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 3:
                    view2 = new b.b.q.k(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 4:
                    view2 = new w(cVar, attributeSet, b.b.a.spinnerStyle);
                    r8.h(view2, str);
                    break;
                case 5:
                    view2 = new b.b.q.l(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 6:
                    view2 = r8.c(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 7:
                    view2 = r8.d(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case '\b':
                    view2 = new b.b.q.h(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case '\t':
                    view2 = r8.a(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case '\n':
                    view2 = new o(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case 11:
                    view2 = new s(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case '\f':
                    view2 = new b.b.q.t(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                case '\r':
                    view2 = new b0(cVar, attributeSet);
                    r8.h(view2, str);
                    break;
                default:
                    view2 = r8.f();
                    break;
            }
            if (view2 == null && context != cVar) {
                if (str.equals("view")) {
                    str = attributeSet.getAttributeValue(r1, "class");
                }
                try {
                    r8.f565a[0] = cVar;
                    r8.f565a[1] = attributeSet;
                    if (-1 == str.indexOf(46)) {
                        for (int i2 = 0; i2 < q.f563d.length; i2++) {
                            view2 = r8.g(cVar, str, q.f563d[i2]);
                            if (view2 == null) {
                            }
                        }
                        ?? r82 = r8.f565a;
                        r82[0] = r1;
                        r82[1] = r1;
                    } else {
                        View g2 = r8.g(cVar, str, r1);
                        ?? r83 = r8.f565a;
                        r83[0] = r1;
                        r83[1] = r1;
                        r1 = g2;
                    }
                } catch (Exception unused2) {
                } finally {
                    ?? r84 = r8.f565a;
                    r84[0] = r1;
                    r84[1] = r1;
                }
                if (r1 != 0) {
                    Context context2 = r1.getContext();
                    if ((context2 instanceof ContextWrapper) && b.i.l.m.y(r1)) {
                        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes((AttributeSet) attributeSet, q.f562c);
                        String string2 = obtainStyledAttributes2.getString(0);
                        if (string2 != null) {
                            r1.setOnClickListener(new q.a(r1, string2));
                        }
                        obtainStyledAttributes2.recycle();
                    }
                }
                return r1;
            }
            r1 = view2;
            if (r1 != 0) {
            }
            return r1;
        }
        throw r1;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    @Override // b.b.k.h
    public b.b.p.a p(a.AbstractC0012a aVar) {
        b.b.p.a aVar2;
        b.b.p.a aVar3;
        g gVar;
        b.b.p.c cVar;
        g gVar2;
        if (aVar != null) {
            b.b.p.a aVar4 = this.o;
            if (aVar4 != null) {
                aVar4.c();
            }
            e eVar = new e(aVar);
            G();
            a aVar5 = this.i;
            if (aVar5 != null) {
                b.b.p.a o2 = aVar5.o(eVar);
                this.o = o2;
                if (!(o2 == null || (gVar2 = this.h) == null)) {
                    gVar2.onSupportActionModeStarted(o2);
                }
            }
            if (this.o == null) {
                z();
                b.b.p.a aVar6 = this.o;
                if (aVar6 != null) {
                    aVar6.c();
                }
                g gVar3 = this.h;
                if (gVar3 != null && !this.M) {
                    try {
                        aVar2 = gVar3.onWindowStartingSupportActionMode(eVar);
                    } catch (AbstractMethodError unused) {
                    }
                    if (aVar2 == null) {
                        this.o = aVar2;
                    } else {
                        boolean z2 = true;
                        if (this.p == null) {
                            if (this.D) {
                                TypedValue typedValue = new TypedValue();
                                Resources.Theme theme = this.f520e.getTheme();
                                theme.resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = this.f520e.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    b.b.p.c cVar2 = new b.b.p.c(this.f520e, 0);
                                    cVar2.getTheme().setTo(newTheme);
                                    cVar = cVar2;
                                } else {
                                    cVar = this.f520e;
                                }
                                this.p = new ActionBarContextView(cVar, null);
                                PopupWindow popupWindow = new PopupWindow(cVar, (AttributeSet) null, b.b.a.actionModePopupWindowStyle);
                                this.q = popupWindow;
                                popupWindow.setWindowLayoutType(2);
                                this.q.setContentView(this.p);
                                this.q.setWidth(-1);
                                cVar.getTheme().resolveAttribute(b.b.a.actionBarSize, typedValue, true);
                                this.p.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, cVar.getResources().getDisplayMetrics()));
                                this.q.setHeight(-2);
                                this.r = new m(this);
                            } else {
                                ViewStubCompat viewStubCompat = (ViewStubCompat) this.v.findViewById(b.b.f.action_mode_bar_stub);
                                if (viewStubCompat != null) {
                                    G();
                                    a aVar7 = this.i;
                                    Context e2 = aVar7 != null ? aVar7.e() : null;
                                    if (e2 == null) {
                                        e2 = this.f520e;
                                    }
                                    viewStubCompat.setLayoutInflater(LayoutInflater.from(e2));
                                    this.p = (ActionBarContextView) viewStubCompat.a();
                                }
                            }
                        }
                        if (this.p != null) {
                            z();
                            this.p.h();
                            Context context = this.p.getContext();
                            ActionBarContextView actionBarContextView = this.p;
                            if (this.q != null) {
                                z2 = false;
                            }
                            b.b.p.d dVar = new b.b.p.d(context, actionBarContextView, eVar, z2);
                            if (eVar.f526a.c(dVar, dVar.i)) {
                                dVar.i();
                                this.p.f(dVar);
                                this.o = dVar;
                                if (M()) {
                                    this.p.setAlpha(0.0f);
                                    r a2 = b.i.l.m.a(this.p);
                                    a2.a(1.0f);
                                    this.s = a2;
                                    n nVar = new n(this);
                                    View view = a2.f1880a.get();
                                    if (view != null) {
                                        a2.e(view, nVar);
                                    }
                                } else {
                                    this.p.setAlpha(1.0f);
                                    this.p.setVisibility(0);
                                    this.p.sendAccessibilityEvent(32);
                                    if (this.p.getParent() instanceof View) {
                                        ((View) this.p.getParent()).requestApplyInsets();
                                    }
                                }
                                if (this.q != null) {
                                    this.f521f.getDecorView().post(this.r);
                                }
                            } else {
                                this.o = null;
                            }
                        }
                    }
                    aVar3 = this.o;
                    if (!(aVar3 == null || (gVar = this.h) == null)) {
                        gVar.onSupportActionModeStarted(aVar3);
                    }
                    this.o = this.o;
                }
                aVar2 = null;
                if (aVar2 == null) {
                }
                aVar3 = this.o;
                gVar.onSupportActionModeStarted(aVar3);
                this.o = this.o;
            }
            return this.o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean q() {
        return r(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x016b, code lost:
        if (r1 != false) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0170, code lost:
        if (r12.L != false) goto L_0x0172;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6 A[ADDED_TO_REGION] */
    public final boolean r(boolean z2) {
        boolean z3;
        boolean z4;
        Object obj;
        boolean z5 = false;
        if (this.M) {
            return false;
        }
        int i2 = this.N;
        if (i2 == -100) {
            i2 = -100;
        }
        int I2 = I(this.f520e, i2);
        Object obj2 = null;
        Configuration w2 = w(this.f520e, I2, null);
        boolean z6 = true;
        if (!this.Q && (this.f519d instanceof Activity)) {
            PackageManager packageManager = this.f520e.getPackageManager();
            if (packageManager == null) {
                z3 = false;
                int i3 = this.f520e.getResources().getConfiguration().uiMode & 48;
                int i4 = w2.uiMode & 48;
                if (i3 != i4 && z2 && !z3 && this.J && (d0 || this.K)) {
                    Object obj3 = this.f519d;
                    if ((obj3 instanceof Activity) && !((Activity) obj3).isChild()) {
                        b.i.d.a.j((Activity) this.f519d);
                        z4 = true;
                        if (!z4 || i3 == i4) {
                            z6 = z4;
                        } else {
                            Resources resources = this.f520e.getResources();
                            Configuration configuration = new Configuration(resources.getConfiguration());
                            configuration.uiMode = i4 | (resources.getConfiguration().uiMode & -49);
                            resources.updateConfiguration(configuration, null);
                            int i5 = Build.VERSION.SDK_INT;
                            if (i5 < 26 && i5 < 28) {
                                if (i5 >= 24) {
                                    if (!j.h) {
                                        try {
                                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                            j.f543g = declaredField;
                                            declaredField.setAccessible(true);
                                        } catch (NoSuchFieldException unused) {
                                        }
                                        j.h = true;
                                    }
                                    Field field = j.f543g;
                                    if (field != null) {
                                        try {
                                            obj = field.get(resources);
                                        } catch (IllegalAccessException unused2) {
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            if (!j.f538b) {
                                                try {
                                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                    j.f537a = declaredField2;
                                                    declaredField2.setAccessible(true);
                                                } catch (NoSuchFieldException unused3) {
                                                }
                                                j.f538b = true;
                                            }
                                            Field field2 = j.f537a;
                                            if (field2 != null) {
                                                try {
                                                    obj2 = field2.get(obj);
                                                } catch (IllegalAccessException unused4) {
                                                }
                                            }
                                            if (obj2 != null) {
                                                j.x(obj2);
                                            }
                                        }
                                    }
                                } else {
                                    if (!j.f538b) {
                                        try {
                                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                            j.f537a = declaredField3;
                                            declaredField3.setAccessible(true);
                                        } catch (NoSuchFieldException unused5) {
                                        }
                                        j.f538b = true;
                                    }
                                    Field field3 = j.f537a;
                                    if (field3 != null) {
                                        try {
                                            obj2 = field3.get(resources);
                                        } catch (IllegalAccessException unused6) {
                                        }
                                    }
                                    if (obj2 != null) {
                                        j.x(obj2);
                                    }
                                }
                            }
                            int i6 = this.O;
                            if (i6 != 0) {
                                this.f520e.setTheme(i6);
                                this.f520e.getTheme().applyStyle(this.O, true);
                            }
                            if (z3) {
                                Object obj4 = this.f519d;
                                if (obj4 instanceof Activity) {
                                    Activity activity = (Activity) obj4;
                                    if (activity instanceof b.o.i) {
                                        if (((b.o.j) ((b.o.i) activity).getLifecycle()).f2221b.compareTo((Enum) f.b.STARTED) >= 0) {
                                            z5 = true;
                                        }
                                    }
                                    activity.onConfigurationChanged(configuration);
                                }
                            }
                        }
                        if (z6) {
                            Object obj5 = this.f519d;
                            if (obj5 instanceof f) {
                                ((f) obj5).onNightModeChanged(I2);
                            }
                        }
                        if (i2 == 0) {
                            D(this.f520e).e();
                        } else {
                            h hVar = this.R;
                            if (hVar != null) {
                                hVar.a();
                            }
                        }
                        if (i2 == 3) {
                            Context context = this.f520e;
                            if (this.S == null) {
                                this.S = new g(context);
                            }
                            this.S.e();
                        } else {
                            h hVar2 = this.S;
                            if (hVar2 != null) {
                                hVar2.a();
                            }
                        }
                        return z6;
                    }
                }
                z4 = false;
                if (!z4) {
                }
                z6 = z4;
                if (z6) {
                }
                if (i2 == 0) {
                }
                if (i2 == 3) {
                }
                return z6;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f520e, this.f519d.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.P = (activityInfo == null || (activityInfo.configChanges & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused7) {
                this.P = false;
            }
        }
        this.Q = true;
        z3 = this.P;
        int i32 = this.f520e.getResources().getConfiguration().uiMode & 48;
        int i42 = w2.uiMode & 48;
        Object obj32 = this.f519d;
        b.i.d.a.j((Activity) this.f519d);
        z4 = true;
        if (!z4) {
        }
        z6 = z4;
        if (z6) {
        }
        if (i2 == 0) {
        }
        if (i2 == 3) {
        }
        return z6;
    }

    public final void s(Window window) {
        if (this.f521f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof f)) {
                f fVar = new f(callback);
                this.f522g = fVar;
                window.setCallback(fVar);
                y0 p2 = y0.p(this.f520e, null, c0);
                Drawable h2 = p2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                p2.f986b.recycle();
                this.f521f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void t(int i2, l lVar, Menu menu) {
        if (menu == null && lVar != null) {
            menu = lVar.h;
        }
        if ((lVar == null || lVar.m) && !this.M) {
            this.f522g.f676b.onPanelClosed(i2, menu);
        }
    }

    public void u(b.b.p.i.g gVar) {
        if (!this.F) {
            this.F = true;
            this.l.l();
            Window.Callback F2 = F();
            if (F2 != null && !this.M) {
                F2.onPanelClosed(108, gVar);
            }
            this.F = false;
        }
    }

    public void v(l lVar, boolean z2) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (!z2 || lVar.f544a != 0 || (c0Var = this.l) == null || !c0Var.c()) {
            WindowManager windowManager = (WindowManager) this.f520e.getSystemService("window");
            if (!(windowManager == null || !lVar.m || (viewGroup = lVar.f548e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    t(lVar.f544a, lVar, null);
                }
            }
            lVar.k = false;
            lVar.l = false;
            lVar.m = false;
            lVar.f549f = null;
            lVar.o = true;
            if (this.H == lVar) {
                this.H = null;
                return;
            }
            return;
        }
        u(lVar.h);
    }

    public final Configuration w(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    public boolean x(KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        AudioManager audioManager;
        boolean z4;
        View decorView;
        Object obj = this.f519d;
        boolean z5 = true;
        if (((obj instanceof d.a) || (obj instanceof o)) && (decorView = this.f521f.getDecorView()) != null && b.i.l.m.e(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f522g.f676b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & RecyclerView.a0.FLAG_IGNORE) == 0) {
                    z5 = false;
                }
                this.I = z5;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                l E2 = E(0);
                if (E2.m) {
                    return true;
                }
                L(E2, keyEvent);
                return true;
            }
        } else if (keyCode == 4) {
            boolean z6 = this.I;
            this.I = false;
            l E3 = E(0);
            if (!E3.m) {
                b.b.p.a aVar = this.o;
                if (aVar != null) {
                    aVar.c();
                } else {
                    G();
                    a aVar2 = this.i;
                    if (aVar2 == null || !aVar2.b()) {
                        z2 = false;
                        if (z2) {
                            return true;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            } else if (z6) {
                return true;
            } else {
                v(E3, true);
                return true;
            }
        } else if (keyCode == 82) {
            if (this.o != null) {
                return true;
            }
            l E4 = E(0);
            c0 c0Var = this.l;
            if (c0Var != null && c0Var.g() && !ViewConfiguration.get(this.f520e).hasPermanentMenuKey()) {
                if (this.l.c()) {
                    z3 = this.l.d();
                } else if (!this.M && L(E4, keyEvent)) {
                    z3 = this.l.e();
                }
                if (!z3) {
                }
            } else if (E4.m || E4.l) {
                z3 = E4.m;
                v(E4, true);
                if (!z3 && (audioManager = (AudioManager) this.f520e.getApplicationContext().getSystemService("audio")) != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
            } else if (E4.k) {
                if (E4.p) {
                    E4.k = false;
                    z4 = L(E4, keyEvent);
                } else {
                    z4 = true;
                }
                if (z4) {
                    J(E4, keyEvent);
                    z3 = true;
                    return !z3 ? true : true;
                }
            }
            z3 = false;
            if (!z3) {
            }
        }
        return false;
    }

    public void y(int i2) {
        l E2 = E(i2);
        if (E2.h != null) {
            Bundle bundle = new Bundle();
            E2.h.w(bundle);
            if (bundle.size() > 0) {
                E2.q = bundle;
            }
            E2.h.z();
            E2.h.clear();
        }
        E2.p = true;
        E2.o = true;
        if ((i2 == 108 || i2 == 0) && this.l != null) {
            l E3 = E(0);
            E3.k = false;
            L(E3, null);
        }
    }

    public void z() {
        r rVar = this.s;
        if (rVar != null) {
            rVar.b();
        }
    }
}
