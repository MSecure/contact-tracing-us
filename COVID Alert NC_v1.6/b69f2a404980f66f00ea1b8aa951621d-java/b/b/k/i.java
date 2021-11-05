package b.b.k;

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
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
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
import android.util.LongSparseArray;
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
import b.b.q.s;
import b.b.q.y0;
import b.g.a.h.c;
import b.g.a.h.d;
import b.i.j.b;
import b.i.l.d;
import b.i.l.r;
import b.i.l.t;
import b.i.l.v;
import b.n.f;
import b.q.d.a0;
import b.r.h;
import b.z.d;
import b.z.n;
import c.a.b.b;
import c.a.b.w;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.l.o;
import c.b.b.e.a.u;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Strategy;
import gov.nc.dhhs.exposurenotification.otpview.OtpView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
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
    public final Object f369d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f370e;
    public Window f;
    public f g;
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
        public final /* synthetic */ Thread.UncaughtExceptionHandler f371a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f371a = uncaughtExceptionHandler;
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
                this.f371a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f371a.uncaughtException(thread, th);
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

    public class e implements a.AbstractC0009a {

        /* renamed from: a  reason: collision with root package name */
        public a.AbstractC0009a f374a;

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
                    b.i.l.m.R((View) i.this.p.getParent());
                }
                i.this.p.removeAllViews();
                i.this.s.d(null);
                i iVar2 = i.this;
                iVar2.s = null;
                b.i.l.m.R(iVar2.v);
            }
        }

        public e(a.AbstractC0009a aVar) {
            this.f374a = aVar;
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean a(b.b.p.a aVar, Menu menu) {
            b.i.l.m.R(i.this.v);
            return this.f374a.a(aVar, menu);
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean b(b.b.p.a aVar, MenuItem menuItem) {
            return this.f374a.b(aVar, menuItem);
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean c(b.b.p.a aVar, Menu menu) {
            return this.f374a.c(aVar, menu);
        }

        @Override // b.b.p.a.AbstractC0009a
        public void d(b.b.p.a aVar) {
            this.f374a.d(aVar);
            i iVar = i.this;
            if (iVar.q != null) {
                iVar.f.getDecorView().removeCallbacks(i.this.r);
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
                View view = rVar.f1171a.get();
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
            b.i.l.m.R(iVar5.v);
        }
    }

    public class f extends b.b.p.h {
        public f(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            e.a aVar = new e.a(i.this.f370e, callback);
            b.b.p.a p = i.this.p(aVar);
            if (p != null) {
                return aVar.e(p);
            }
            return null;
        }

        @Override // b.b.p.h
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.x(keyEvent) || this.f504b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // b.b.p.h
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean z;
            if (!this.f504b.dispatchKeyShortcutEvent(keyEvent)) {
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
                return this.f504b.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // b.b.p.h
        public boolean onMenuOpened(int i, Menu menu) {
            this.f504b.onMenuOpened(i, menu);
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
            this.f504b.onPanelClosed(i, menu);
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
            boolean onPreparePanel = this.f504b.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.y = false;
            }
            return onPreparePanel;
        }

        @Override // b.b.p.h, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            b.b.p.i.g gVar = i.this.E(0).h;
            if (gVar != null) {
                this.f504b.onProvideKeyboardShortcuts(list, gVar, i);
            } else {
                this.f504b.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // b.b.p.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // b.b.p.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!i.this.t || i != 0) {
                return this.f504b.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    public class g extends h {

        /* renamed from: c  reason: collision with root package name */
        public final PowerManager f378c;

        public g(Context context) {
            super();
            this.f378c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // b.b.k.i.h
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // b.b.k.i.h
        public int c() {
            return this.f378c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // b.b.k.i.h
        public void d() {
            i.this.q();
        }
    }

    public abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f380a;

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
            BroadcastReceiver broadcastReceiver = this.f380a;
            if (broadcastReceiver != null) {
                try {
                    i.this.f370e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f380a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f380a == null) {
                    this.f380a = new a();
                }
                i.this.f370e.registerReceiver(this.f380a, b2);
            }
        }
    }

    /* renamed from: b.b.k.i$i  reason: collision with other inner class name */
    public class C0006i extends h {

        /* renamed from: c  reason: collision with root package name */
        public final t f383c;

        public C0006i(t tVar) {
            super();
            this.f383c = tVar;
        }

        @Override // b.b.k.i.h
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00f9 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
        @Override // b.b.k.i.h
        public int c() {
            boolean z;
            Location location;
            long j;
            t tVar = this.f383c;
            t.a aVar = tVar.f432c;
            if (!(aVar.f434b > System.currentTimeMillis())) {
                Location location2 = null;
                if (j.u(tVar.f430a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (tVar.f431b.isProviderEnabled("network")) {
                            location = tVar.f431b.getLastKnownLocation("network");
                            if (j.u(tVar.f430a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                try {
                                    if (tVar.f431b.isProviderEnabled("gps")) {
                                        location2 = tVar.f431b.getLastKnownLocation("gps");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                                location = location2;
                            }
                            if (location == null) {
                                t.a aVar2 = tVar.f432c;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (s.f425d == null) {
                                    s.f425d = new s();
                                }
                                s sVar = s.f425d;
                                sVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                                sVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                                boolean z2 = sVar.f428c == 1;
                                long j2 = sVar.f427b;
                                long j3 = sVar.f426a;
                                sVar.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                                long j4 = sVar.f427b;
                                if (j2 == -1 || j3 == -1) {
                                    j = currentTimeMillis + 43200000;
                                } else {
                                    j = (currentTimeMillis > j3 ? j4 + 0 : currentTimeMillis > j2 ? j3 + 0 : j2 + 0) + 60000;
                                }
                                aVar2.f433a = z2;
                                aVar2.f434b = j;
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
                if (j.u(tVar.f430a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            z = aVar.f433a;
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
        public static Field f385a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f386b;

        /* renamed from: c  reason: collision with root package name */
        public static Class<?> f387c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f388d;

        /* renamed from: e  reason: collision with root package name */
        public static Field f389e;
        public static boolean f;
        public static Field g;
        public static boolean h;

        public static float[] A(float[] fArr, int i, int i2) {
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

        public static int A0(int i, Rect rect, Rect rect2) {
            int i2;
            int i3;
            int i4;
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                i3 = (rect.width() / 2) + rect.left;
                i4 = rect2.left;
                i2 = rect2.width();
                return Math.abs(i3 - ((i2 / 2) + i4));
            }
            i3 = (rect.height() / 2) + rect.top;
            i4 = rect2.top;
            i2 = rect2.height();
            return Math.abs(i3 - ((i2 / 2) + i4));
        }

        public static <T extends Parcelable> void A1(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
            if (tArr != null) {
                int C1 = C1(parcel, i);
                int length = tArr.length;
                parcel.writeInt(length);
                for (T t : tArr) {
                    if (t == null) {
                        parcel.writeInt(0);
                    } else {
                        E1(parcel, t, i2);
                    }
                }
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
        public static boolean B(File file, Resources resources, int i) {
            InputStream inputStream;
            Throwable th;
            try {
                inputStream = resources.openRawResource(i);
                try {
                    boolean C = C(file, inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return C;
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

        public static ByteBuffer B0(Context context, CancellationSignal cancellationSignal, Uri uri) {
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

        public static <T extends Parcelable> void B1(Parcel parcel, int i, List<T> list, boolean z) {
            if (list != null) {
                int C1 = C1(parcel, i);
                int size = list.size();
                parcel.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    T t = list.get(i2);
                    if (t == null) {
                        parcel.writeInt(0);
                    } else {
                        E1(parcel, t, 0);
                    }
                }
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0039 A[SYNTHETIC, Splitter:B:30:0x0039] */
        public static boolean C(File file, InputStream inputStream) {
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

        public static TypedArray C0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
            return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }

        public static int C1(Parcel parcel, int i) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(0);
            return parcel.dataPosition();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r15v16, resolved type: android.animation.AnimatorSet */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x030a  */
        public static Animator D(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f2) {
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
            Resources resources2 = resources;
            Resources.Theme theme2 = theme;
            int depth = xmlPullParser.getDepth();
            ValueAnimator valueAnimator2 = null;
            ArrayList arrayList = null;
            while (true) {
                int next = xmlPullParser.next();
                int i7 = 3;
                i2 = 0;
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    int i8 = 2;
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if (name.equals("objectAnimator")) {
                            valueAnimator = new ObjectAnimator();
                            x0(context, resources, theme, attributeSet, valueAnimator, f2, xmlPullParser);
                        } else if (name.equals("animator")) {
                            valueAnimator = x0(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                        } else {
                            if (name.equals("set")) {
                                AnimatorSet animatorSet2 = new AnimatorSet();
                                TypedArray C0 = C0(resources2, theme2, attributeSet, b.w.a.a.a.h);
                                D(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, h0(C0, xmlPullParser, "ordering", 0, 0), f2);
                                C0.recycle();
                                i3 = depth;
                                valueAnimator2 = animatorSet2;
                            } else {
                                String str2 = "propertyValuesHolder";
                                if (name.equals(str2)) {
                                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                                    ArrayList arrayList2 = null;
                                    i2 = 1;
                                    int i9 = 0;
                                    while (true) {
                                        int eventType = xmlPullParser.getEventType();
                                        if (eventType == i7 || eventType == i2) {
                                            i3 = depth;
                                        } else if (eventType != i8) {
                                            xmlPullParser.next();
                                        } else {
                                            if (xmlPullParser.getName().equals(str2)) {
                                                TypedArray C02 = C0(resources2, theme2, asAttributeSet, b.w.a.a.a.i);
                                                String i0 = i0(C02, xmlPullParser, "propertyName", i7);
                                                int h0 = h0(C02, xmlPullParser, "valueType", i8, 4);
                                                ArrayList arrayList3 = null;
                                                attributeSet2 = asAttributeSet;
                                                int i10 = h0;
                                                while (true) {
                                                    int next2 = xmlPullParser.next();
                                                    if (next2 == i7 || next2 == 1) {
                                                        str = str2;
                                                        i4 = depth;
                                                    } else if (xmlPullParser.getName().equals("keyframe")) {
                                                        if (i10 == 4) {
                                                            TypedArray C03 = C0(resources2, theme2, Xml.asAttributeSet(xmlPullParser), b.w.a.a.a.j);
                                                            TypedValue peekValue = !q0(xmlPullParser, "value") ? null : C03.peekValue(0);
                                                            i10 = (!(peekValue != null) || !v0(peekValue.type)) ? 0 : i7;
                                                            C03.recycle();
                                                        }
                                                        TypedArray C04 = C0(resources2, theme2, Xml.asAttributeSet(xmlPullParser), b.w.a.a.a.j);
                                                        float g0 = g0(C04, xmlPullParser, "fraction", 3, -1.0f);
                                                        TypedValue peekValue2 = !q0(xmlPullParser, "value") ? null : C04.peekValue(0);
                                                        boolean z = peekValue2 != null;
                                                        int i11 = i10 == 4 ? (!z || !v0(peekValue2.type)) ? 0 : 3 : i10;
                                                        Keyframe ofInt = z ? i11 != 0 ? (i11 == 1 || i11 == 3) ? Keyframe.ofInt(g0, h0(C04, xmlPullParser, "value", 0, 0)) : null : Keyframe.ofFloat(g0, g0(C04, xmlPullParser, "value", 0, 0.0f)) : i11 == 0 ? Keyframe.ofFloat(g0) : Keyframe.ofInt(g0);
                                                        int resourceId = !q0(xmlPullParser, "interpolator") ? 0 : C04.getResourceId(1, 0);
                                                        if (resourceId > 0) {
                                                            ofInt.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                                        }
                                                        C04.recycle();
                                                        if (ofInt != null) {
                                                            if (arrayList3 == null) {
                                                                arrayList3 = new ArrayList();
                                                            }
                                                            arrayList3.add(ofInt);
                                                        }
                                                        xmlPullParser.next();
                                                        i7 = 3;
                                                        resources2 = resources;
                                                        theme2 = theme;
                                                        str2 = str2;
                                                        depth = depth;
                                                    } else {
                                                        resources2 = resources;
                                                        theme2 = theme;
                                                        i7 = i7;
                                                    }
                                                }
                                                str = str2;
                                                i4 = depth;
                                                if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                                    i5 = 3;
                                                    i6 = 2;
                                                    propertyValuesHolder = null;
                                                } else {
                                                    Keyframe keyframe = (Keyframe) arrayList3.get(0);
                                                    Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                                    float fraction = keyframe2.getFraction();
                                                    if (fraction < 1.0f) {
                                                        if (fraction < 0.0f) {
                                                            keyframe2.setFraction(1.0f);
                                                        } else {
                                                            arrayList3.add(arrayList3.size(), M(keyframe2, 1.0f));
                                                            size++;
                                                        }
                                                    }
                                                    float fraction2 = keyframe.getFraction();
                                                    if (fraction2 != 0.0f) {
                                                        if (fraction2 < 0.0f) {
                                                            keyframe.setFraction(0.0f);
                                                        } else {
                                                            arrayList3.add(0, M(keyframe, 0.0f));
                                                            size++;
                                                        }
                                                    }
                                                    Keyframe[] keyframeArr = new Keyframe[size];
                                                    arrayList3.toArray(keyframeArr);
                                                    int i12 = 0;
                                                    while (i12 < size) {
                                                        Keyframe keyframe3 = keyframeArr[i12];
                                                        float f3 = 0.0f;
                                                        if (keyframe3.getFraction() < 0.0f) {
                                                            if (i12 != 0) {
                                                                int i13 = size - 1;
                                                                f3 = 1.0f;
                                                                if (i12 != i13) {
                                                                    int i14 = i12 + 1;
                                                                    int i15 = i12;
                                                                    while (i14 < i13 && keyframeArr[i14].getFraction() < 0.0f) {
                                                                        i15 = i14;
                                                                        i14++;
                                                                    }
                                                                    float fraction3 = (keyframeArr[i15 + 1].getFraction() - keyframeArr[i12 - 1].getFraction()) / ((float) ((i15 - i12) + 2));
                                                                    int i16 = i12;
                                                                    while (i16 <= i15) {
                                                                        keyframeArr[i16].setFraction(keyframeArr[i16 - 1].getFraction() + fraction3);
                                                                        i16++;
                                                                        size = size;
                                                                    }
                                                                }
                                                            }
                                                            keyframe3.setFraction(f3);
                                                        }
                                                        i12++;
                                                        size = size;
                                                    }
                                                    i6 = 2;
                                                    propertyValuesHolder = PropertyValuesHolder.ofKeyframe(i0, keyframeArr);
                                                    i5 = 3;
                                                    if (i10 == 3) {
                                                        propertyValuesHolder.setEvaluator(b.w.a.a.d.f1853a);
                                                    }
                                                }
                                                i2 = 1;
                                                if (propertyValuesHolder == null) {
                                                    propertyValuesHolder = j0(C02, h0, 0, 1, i0);
                                                }
                                                if (propertyValuesHolder != null) {
                                                    if (arrayList2 == null) {
                                                        arrayList2 = new ArrayList();
                                                    }
                                                    arrayList2.add(propertyValuesHolder);
                                                }
                                                C02.recycle();
                                                i8 = i6;
                                                i7 = i5;
                                                i9 = 0;
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
                                        while (i9 < size2) {
                                            propertyValuesHolderArr[i9] = (PropertyValuesHolder) arrayList2.get(i9);
                                            i9++;
                                        }
                                    } else {
                                        propertyValuesHolderArr = null;
                                    }
                                    if (propertyValuesHolderArr != null && (valueAnimator2 instanceof ValueAnimator)) {
                                        valueAnimator2.setValues(propertyValuesHolderArr);
                                    }
                                } else {
                                    StringBuilder g2 = c.a.a.a.a.g("Unknown animator name: ");
                                    g2.append(xmlPullParser.getName());
                                    throw new RuntimeException(g2.toString());
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

        public static <T> ObjectAnimator D0(T t, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }

        public static void D1(Parcel parcel, int i, int i2) {
            int T0 = T0(parcel, i);
            if (T0 != i2) {
                String hexString = Integer.toHexString(T0);
                StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
                sb.append("Expected size ");
                sb.append(i2);
                sb.append(" got ");
                sb.append(T0);
                sb.append(" (0x");
                sb.append(hexString);
                sb.append(")");
                throw new c.b.a.a.c.l.s.b(sb.toString(), parcel);
            }
        }

        public static Bundle E(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            Bundle readBundle = parcel.readBundle();
            parcel.setDataPosition(dataPosition + T0);
            return readBundle;
        }

        public static InputConnection E0(InputConnection inputConnection, EditorInfo editorInfo, View view) {
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

        public static <T extends Parcelable> void E1(Parcel parcel, T t, int i) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            t.writeToParcel(parcel, i);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }

        public static byte[] F(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            parcel.setDataPosition(dataPosition + T0);
            return createByteArray;
        }

        public static boolean F0(ViewParent viewParent, View view, float f2, float f3, boolean z) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError unused) {
                String str = "ViewParent " + viewParent + " does not implement interface method onNestedFling";
                return false;
            }
        }

        public static void F1(Parcel parcel, int i) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(dataPosition - i);
            parcel.setDataPosition(dataPosition);
        }

        public static ArrayList<Double> G(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            ArrayList<Double> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Double.valueOf(parcel.readDouble()));
            }
            parcel.setDataPosition(dataPosition + T0);
            return arrayList;
        }

        public static boolean G0(ViewParent viewParent, View view, float f2, float f3) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError unused) {
                String str = "ViewParent " + viewParent + " does not implement interface method onNestedPreFling";
                return false;
            }
        }

        public static void G1(Parcel parcel, int i, int i2) {
            if (i2 >= 65535) {
                parcel.writeInt(i | -65536);
                parcel.writeInt(i2);
                return;
            }
            parcel.writeInt(i | (i2 << 16));
        }

        public static ColorStateList H(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
            int next;
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return I(resources, xmlPullParser, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static void H0(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
            if (viewParent instanceof b.i.l.g) {
                ((b.i.l.g) viewParent).j(view, i, i2, iArr, i3);
            } else if (i3 == 0) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll";
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static ColorStateList I(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            int depth;
            int attributeCount;
            int i;
            int i2;
            int i3;
            String name = xmlPullParser.getName();
            if (name.equals("selector")) {
                int i4 = 1;
                int depth2 = xmlPullParser.getDepth() + 1;
                int[][] iArr = new int[20][];
                int[] iArr2 = new int[20];
                int i5 = 0;
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == i4 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                        int[] iArr3 = new int[i5];
                        int[][] iArr4 = new int[i5][];
                        System.arraycopy(iArr2, 0, iArr3, 0, i5);
                        System.arraycopy(iArr, 0, iArr4, 0, i5);
                    } else {
                        if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                            int[] iArr5 = b.i.c.ColorStateListItem;
                            TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr5) : theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                            int color = obtainAttributes.getColor(b.i.c.ColorStateListItem_android_color, -65281);
                            float f2 = 1.0f;
                            if (obtainAttributes.hasValue(b.i.c.ColorStateListItem_android_alpha)) {
                                i3 = b.i.c.ColorStateListItem_android_alpha;
                            } else {
                                if (obtainAttributes.hasValue(b.i.c.ColorStateListItem_alpha)) {
                                    i3 = b.i.c.ColorStateListItem_alpha;
                                }
                                obtainAttributes.recycle();
                                attributeCount = attributeSet.getAttributeCount();
                                int[] iArr6 = new int[attributeCount];
                                int i6 = 0;
                                for (i = 0; i < attributeCount; i++) {
                                    int attributeNameResource = attributeSet.getAttributeNameResource(i);
                                    if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == b.i.a.alpha)) {
                                        int i7 = i6 + 1;
                                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                                            attributeNameResource = -attributeNameResource;
                                        }
                                        iArr6[i6] = attributeNameResource;
                                        i6 = i7;
                                    }
                                }
                                int[] trimStateSet = StateSet.trimStateSet(iArr6, i6);
                                int round = (Math.round(((float) Color.alpha(color)) * f2) << 24) | (color & 16777215);
                                i2 = i5 + 1;
                                int i8 = 8;
                                if (i2 > iArr2.length) {
                                    int[] iArr7 = new int[(i5 <= 4 ? 8 : i5 * 2)];
                                    System.arraycopy(iArr2, 0, iArr7, 0, i5);
                                    iArr2 = iArr7;
                                }
                                iArr2[i5] = round;
                                if (i2 > iArr.length) {
                                    Class<?> componentType = iArr.getClass().getComponentType();
                                    if (i5 > 4) {
                                        i8 = i5 * 2;
                                    }
                                    ?? r8 = (Object[]) Array.newInstance(componentType, i8);
                                    System.arraycopy(iArr, 0, r8, 0, i5);
                                    iArr = r8;
                                }
                                iArr[i5] = trimStateSet;
                                iArr = iArr;
                                i5 = i2;
                            }
                            f2 = obtainAttributes.getFloat(i3, 1.0f);
                            obtainAttributes.recycle();
                            attributeCount = attributeSet.getAttributeCount();
                            int[] iArr62 = new int[attributeCount];
                            int i62 = 0;
                            while (i < attributeCount) {
                            }
                            int[] trimStateSet2 = StateSet.trimStateSet(iArr62, i62);
                            int round2 = (Math.round(((float) Color.alpha(color)) * f2) << 24) | (color & 16777215);
                            i2 = i5 + 1;
                            int i82 = 8;
                            if (i2 > iArr2.length) {
                            }
                            iArr2[i5] = round2;
                            if (i2 > iArr.length) {
                            }
                            iArr[i5] = trimStateSet2;
                            iArr = iArr;
                            i5 = i2;
                        }
                        i4 = 1;
                    }
                }
                int[] iArr32 = new int[i5];
                int[][] iArr42 = new int[i5][];
                System.arraycopy(iArr2, 0, iArr32, 0, i5);
                System.arraycopy(iArr, 0, iArr42, 0, i5);
                return new ColorStateList(iArr42, iArr32);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }

        public static void I0(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (viewParent instanceof b.i.l.h) {
                ((b.i.l.h) viewParent).m(view, i, i2, i3, i4, i5, iArr);
                return;
            }
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (viewParent instanceof b.i.l.g) {
                ((b.i.l.g) viewParent).n(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + viewParent + " does not implement interface method onNestedScroll";
                }
            }
        }

        public static int[] J(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            int[] createIntArray = parcel.createIntArray();
            parcel.setDataPosition(dataPosition + T0);
            return createIntArray;
        }

        public static b.i.e.b.b J0(XmlPullParser xmlPullParser, Resources resources) {
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
                                    int i = obtainAttributes2.getInt(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontWeight) ? b.i.c.FontFamilyFont_fontWeight : b.i.c.FontFamilyFont_android_fontWeight, 400);
                                    boolean z = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontStyle) ? b.i.c.FontFamilyFont_fontStyle : b.i.c.FontFamilyFont_android_fontStyle, 0);
                                    int i2 = obtainAttributes2.hasValue(b.i.c.FontFamilyFont_ttcIndex) ? b.i.c.FontFamilyFont_ttcIndex : b.i.c.FontFamilyFont_android_ttcIndex;
                                    String string4 = obtainAttributes2.getString(obtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontVariationSettings) ? b.i.c.FontFamilyFont_fontVariationSettings : b.i.c.FontFamilyFont_android_fontVariationSettings);
                                    int i3 = obtainAttributes2.getInt(i2, 0);
                                    int i4 = obtainAttributes2.hasValue(b.i.c.FontFamilyFont_font) ? b.i.c.FontFamilyFont_font : b.i.c.FontFamilyFont_android_font;
                                    int resourceId2 = obtainAttributes2.getResourceId(i4, 0);
                                    String string5 = obtainAttributes2.getString(i4);
                                    obtainAttributes2.recycle();
                                    while (xmlPullParser.next() != 3) {
                                        f1(xmlPullParser);
                                    }
                                    arrayList.add(new b.i.e.b.d(string5, i, z, string4, i3, resourceId2));
                                } else {
                                    f1(xmlPullParser);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new b.i.e.b.c((b.i.e.b.d[]) arrayList.toArray(new b.i.e.b.d[arrayList.size()]));
                    }
                    while (xmlPullParser.next() != 3) {
                        f1(xmlPullParser);
                    }
                    return new b.i.e.b.e(new b.i.i.a(string, string2, string3, O0(resources, resourceId)), integer, integer2);
                }
                f1(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static ArrayList<Integer> K(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            parcel.setDataPosition(dataPosition + T0);
            return arrayList;
        }

        public static b.a K0(c.a.b.l lVar) {
            long j;
            long j2;
            boolean z;
            long j3;
            long j4;
            long j5;
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> map = lVar.f2219c;
            String str = map.get("Date");
            long M0 = str != null ? M0(str) : 0;
            String str2 = map.get("Cache-Control");
            int i = 0;
            if (str2 != null) {
                String[] split = str2.split(",", 0);
                z = false;
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
                        z = true;
                    }
                    i++;
                }
                i = 1;
            } else {
                z = false;
                j2 = 0;
                j = 0;
            }
            String str3 = map.get("Expires");
            long M02 = str3 != null ? M0(str3) : 0;
            String str4 = map.get("Last-Modified");
            long M03 = str4 != null ? M0(str4) : 0;
            String str5 = map.get("ETag");
            if (i != 0) {
                j4 = currentTimeMillis + (j2 * 1000);
                if (z) {
                    j5 = j4;
                } else {
                    Long.signum(j);
                    j5 = (j * 1000) + j4;
                }
                j3 = j5;
            } else {
                j3 = 0;
                if (M0 <= 0 || M02 < M0) {
                    j4 = 0;
                } else {
                    j4 = currentTimeMillis + (M02 - M0);
                    j3 = j4;
                }
            }
            b.a aVar = new b.a();
            aVar.f2189a = lVar.f2218b;
            aVar.f2190b = str5;
            aVar.f = j4;
            aVar.f2193e = j3;
            aVar.f2191c = M0;
            aVar.f2192d = M03;
            aVar.g = map;
            aVar.h = lVar.f2220d;
            return aVar;
        }

        public static <L> k.a<L> L(L l, String str) {
            t(l, "Listener must not be null");
            t(str, "Listener type must not be null");
            o(str, "Listener type must not be empty");
            return new k.a<>(l, str);
        }

        public static String L0(Map<String, String> map, String str) {
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

        public static Keyframe M(Keyframe keyframe, float f2) {
            return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
        }

        public static long M0(String str) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException unused) {
                w.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008a, code lost:
            if (r13 == 0) goto L_0x008c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ NumberFormatException -> 0x00bc }, LOOP:3: B:25:0x006c->B:45:0x0097, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0096 A[SYNTHETIC] */
        public static b.i.f.c[] N(String str) {
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
                                    fArr = A(fArr2, i3, i5);
                                    i3 = 0;
                                } catch (NumberFormatException e2) {
                                    throw new RuntimeException(c.a.a.a.a.p("error in parsing \"", trim, "\""), e2);
                                }
                            }
                            arrayList.add(new b.i.f.c(trim.charAt(i3), fArr));
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
                arrayList.add(new b.i.f.c(str.charAt(i), new float[0]));
            }
            return (b.i.f.c[]) arrayList.toArray(new b.i.f.c[arrayList.size()]);
        }

        public static boolean N0(Parcel parcel, int i) {
            D1(parcel, i, 4);
            return parcel.readInt() != 0;
        }

        public static <T extends Parcelable> T O(Parcel parcel, int i, Parcelable.Creator<T> creator) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            T createFromParcel = creator.createFromParcel(parcel);
            parcel.setDataPosition(dataPosition + T0);
            return createFromParcel;
        }

        public static List<List<byte[]>> O0(Resources resources, int i) {
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
                            arrayList.add(i1(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(i1(resources.getStringArray(i)));
                }
                obtainTypedArray.recycle();
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }

        public static Path P(String str) {
            Path path = new Path();
            b.i.f.c[] N = N(str);
            if (N == null) {
                return null;
            }
            try {
                b.i.f.c.b(N, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException(c.a.a.a.a.o("Error in parsing ", str), e2);
            }
        }

        public static double P0(Parcel parcel, int i) {
            D1(parcel, i, 8);
            return parcel.readDouble();
        }

        public static String Q(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            String readString = parcel.readString();
            parcel.setDataPosition(dataPosition + T0);
            return readString;
        }

        public static IBinder Q0(Parcel parcel, int i) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(dataPosition + T0);
            return readStrongBinder;
        }

        public static <T> T[] R(Parcel parcel, int i, Parcelable.Creator<T> creator) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            T[] tArr = (T[]) parcel.createTypedArray(creator);
            parcel.setDataPosition(dataPosition + T0);
            return tArr;
        }

        public static int R0(Parcel parcel, int i) {
            D1(parcel, i, 4);
            return parcel.readInt();
        }

        public static <T> ArrayList<T> S(Parcel parcel, int i, Parcelable.Creator<T> creator) {
            int T0 = T0(parcel, i);
            int dataPosition = parcel.dataPosition();
            if (T0 == 0) {
                return null;
            }
            ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(dataPosition + T0);
            return createTypedArrayList;
        }

        public static long S0(Parcel parcel, int i) {
            D1(parcel, i, 8);
            return parcel.readLong();
        }

        public static <T extends b.r.h> h.a<T> T(Context context, Class<T> cls, String str) {
            if (str.trim().length() != 0) {
                return new h.a<>(context, cls, str);
            }
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }

        public static int T0(Parcel parcel, int i) {
            return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
        }

        public static b.i.f.c[] U(b.i.f.c[] cVarArr) {
            if (cVarArr == null) {
                return null;
            }
            b.i.f.c[] cVarArr2 = new b.i.f.c[cVarArr.length];
            for (int i = 0; i < cVarArr.length; i++) {
                cVarArr2[i] = new b.i.f.c(cVarArr[i]);
            }
            return cVarArr2;
        }

        public static int U0(b.g.a.h.d dVar) {
            d.a aVar = d.a.MATCH_CONSTRAINT;
            if (dVar.i() == aVar) {
                int h2 = (int) (dVar.H == 0 ? ((float) dVar.h()) * dVar.G : ((float) dVar.h()) / dVar.G);
                dVar.C(h2);
                return h2;
            } else if (dVar.m() != aVar) {
                return -1;
            } else {
                int n = (int) (dVar.H == 1 ? ((float) dVar.n()) * dVar.G : ((float) dVar.n()) / dVar.G);
                dVar.w(n);
                return n;
            }
        }

        public static void V(b.g.a.h.e eVar) {
            d.a aVar = d.a.FIXED;
            d.a aVar2 = d.a.WRAP_CONTENT;
            if ((eVar.B0 & 32) != 32) {
                eVar.v0.clear();
                eVar.v0.add(0, new b.g.a.h.f(eVar.j0));
                return;
            }
            eVar.C0 = true;
            eVar.w0 = false;
            eVar.x0 = false;
            eVar.y0 = false;
            ArrayList<b.g.a.h.d> arrayList = eVar.j0;
            List<b.g.a.h.f> list = eVar.v0;
            boolean z = eVar.i() == aVar2;
            boolean z2 = eVar.m() == aVar2;
            boolean z3 = z || z2;
            list.clear();
            for (b.g.a.h.d dVar : arrayList) {
                dVar.p = null;
                dVar.d0 = false;
                dVar.s();
            }
            for (b.g.a.h.d dVar2 : arrayList) {
                if (dVar2.p == null) {
                    b.g.a.h.f fVar = new b.g.a.h.f(new ArrayList(), true);
                    list.add(fVar);
                    if (!k1(dVar2, fVar, list, z3)) {
                        eVar.v0.clear();
                        eVar.v0.add(0, new b.g.a.h.f(eVar.j0));
                        eVar.C0 = false;
                        return;
                    }
                }
            }
            int i = 0;
            int i2 = 0;
            for (b.g.a.h.f fVar2 : list) {
                i = Math.max(i, c0(fVar2, 0));
                i2 = Math.max(i2, c0(fVar2, 1));
            }
            if (z) {
                eVar.y(aVar);
                eVar.C(i);
                eVar.w0 = true;
                eVar.x0 = true;
                eVar.z0 = i;
            }
            if (z2) {
                eVar.B(aVar);
                eVar.w(i2);
                eVar.w0 = true;
                eVar.y0 = true;
                eVar.A0 = i2;
            }
            Y0(list, 0, eVar.n());
            Y0(list, 1, eVar.h());
        }

        public static void V0(TextView textView, int i) {
            l(i);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setFirstBaselineToTopHeight(i);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
            }
        }

        public static void W(Parcel parcel, int i) {
            if (parcel.dataPosition() != i) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Overread allowed size end=");
                sb.append(i);
                throw new c.b.a.a.c.l.s.b(sb.toString(), parcel);
            }
        }

        public static void W0(TextView textView, int i) {
            l(i);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
            }
        }

        public static boolean X(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        public static void X0(TextView textView, int i) {
            l(i);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i != fontMetricsInt) {
                textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
            }
        }

        public static b.p.e Y(RandomAccessFile randomAccessFile) {
            long length = randomAccessFile.length() - 22;
            long j = 0;
            if (length >= 0) {
                long j2 = length - 65536;
                if (j2 >= 0) {
                    j = j2;
                }
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        b.p.e eVar = new b.p.e();
                        eVar.f1443b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                        eVar.f1442a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                        return eVar;
                    }
                    length--;
                } while (length >= j);
                throw new ZipException("End Of Central Directory signature not found");
            }
            StringBuilder g2 = c.a.a.a.a.g("File too short to be a zip file: ");
            g2.append(randomAccessFile.length());
            throw new ZipException(g2.toString());
        }

        public static void Y0(List<b.g.a.h.f> list, int i, int i2) {
            int j;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b.g.a.h.f fVar = list.get(i3);
                HashSet<b.g.a.h.d> hashSet = null;
                if (fVar != null) {
                    if (i == 0) {
                        hashSet = fVar.h;
                    } else if (i == 1) {
                        hashSet = fVar.i;
                    }
                    for (b.g.a.h.d dVar : hashSet) {
                        if (dVar.b0) {
                            int i4 = i * 2;
                            b.g.a.h.c[] cVarArr = dVar.A;
                            b.g.a.h.c cVar = cVarArr[i4];
                            b.g.a.h.c cVar2 = cVarArr[i4 + 1];
                            if ((cVar.f900d == null || cVar2.f900d == null) ? false : true) {
                                j = cVar.b() + n0(dVar, i);
                            } else if (dVar.G == 0.0f || dVar.g(i) != d.a.MATCH_CONSTRAINT) {
                                int i5 = i2 - (i == 0 ? dVar.K : i == 1 ? dVar.L : 0);
                                j = i5 - dVar.j(i);
                                dVar.v(j, i5, i);
                            } else {
                                int U0 = U0(dVar);
                                int i6 = (int) dVar.A[i4].f897a.g;
                                b.g.a.h.j jVar = cVar2.f897a;
                                jVar.f = cVar.f897a;
                                jVar.g = (float) U0;
                                jVar.f930b = 1;
                                dVar.v(i6, i6 + U0, i);
                            }
                            b.g.a.h.i.b(dVar, i, j);
                        }
                    }
                } else {
                    throw null;
                }
            }
        }

        public static void Z(Object obj) {
            if (!f388d) {
                try {
                    f387c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException unused) {
                }
                f388d = true;
            }
            Class<?> cls = f387c;
            if (cls != null) {
                if (!f) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        f389e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused2) {
                    }
                    f = true;
                }
                Field field = f389e;
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

        public static void Z0(TextView textView, b.i.j.b bVar) {
            if (Build.VERSION.SDK_INT < 29) {
                p0(textView);
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

        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00eb, code lost:
            if (r5[r13].f900d.f898b == r4) goto L_0x00ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0151, code lost:
            if (r14.e0 == 2) goto L_0x016e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0182  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x022f  */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x0231  */
        /* JADX WARNING: Removed duplicated region for block: B:271:0x045f  */
        /* JADX WARNING: Removed duplicated region for block: B:278:0x046f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:282:0x0239 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00bf  */
        public static void a(b.g.a.h.e eVar, b.g.a.e eVar2, int i) {
            int i2;
            b.g.a.h.b[] bVarArr;
            int i3;
            boolean z;
            int i4;
            d.a aVar;
            b.g.a.h.b[] bVarArr2;
            int i5;
            b.g.a.e eVar3;
            b.g.a.h.b bVar;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            b.g.a.h.j jVar;
            float f2;
            boolean z6;
            boolean z7;
            b.g.a.h.d dVar;
            b.g.a.h.d dVar2;
            b.g.a.h.d dVar3;
            boolean z8;
            b.g.a.h.d dVar4;
            b.g.a.e eVar4 = eVar2;
            d.a aVar2 = d.a.MATCH_CONSTRAINT;
            int i6 = 2;
            if (i == 0) {
                i3 = eVar.r0;
                bVarArr = eVar.u0;
                i2 = 0;
            } else {
                i3 = eVar.s0;
                bVarArr = eVar.t0;
                i2 = 2;
            }
            b.g.a.h.e eVar5 = eVar;
            b.g.a.e eVar6 = eVar4;
            int i7 = 0;
            while (i7 < i3) {
                b.g.a.h.b bVar2 = bVarArr[i7];
                b.g.a.h.d dVar5 = null;
                int i8 = 1;
                if (!bVar2.q) {
                    int i9 = bVar2.l * i6;
                    b.g.a.h.d dVar6 = bVar2.f892a;
                    b.g.a.h.d dVar7 = dVar6;
                    boolean z9 = false;
                    while (!z9) {
                        bVar2.i += i8;
                        b.g.a.h.d[] dVarArr = dVar6.i0;
                        int i10 = bVar2.l;
                        dVarArr[i10] = dVar5;
                        dVar6.h0[i10] = dVar5;
                        if (dVar6.Y != 8) {
                            if (bVar2.f893b == null) {
                                bVar2.f893b = dVar6;
                            }
                            bVar2.f895d = dVar6;
                            d.a[] aVarArr = dVar6.C;
                            int i11 = bVar2.l;
                            if (aVarArr[i11] == aVar2) {
                                int[] iArr = dVar6.g;
                                if (iArr[i11] == 0 || iArr[i11] == 3 || iArr[i11] == 2) {
                                    bVar2.j++;
                                    float[] fArr = dVar6.g0;
                                    int i12 = bVar2.l;
                                    float f3 = fArr[i12];
                                    if (f3 > 0.0f) {
                                        bVar2.k += fArr[i12];
                                    }
                                    int i13 = bVar2.l;
                                    if (dVar6.Y != 8 && dVar6.C[i13] == aVar2) {
                                        int[] iArr2 = dVar6.g;
                                        if (iArr2[i13] == 0 || iArr2[i13] == 3) {
                                            z8 = true;
                                            if (z8) {
                                                if (f3 < 0.0f) {
                                                    bVar2.n = true;
                                                } else {
                                                    bVar2.o = true;
                                                }
                                                if (bVar2.h == null) {
                                                    bVar2.h = new ArrayList<>();
                                                }
                                                bVar2.h.add(dVar6);
                                            }
                                            if (bVar2.f == null) {
                                                bVar2.f = dVar6;
                                            }
                                            dVar4 = bVar2.g;
                                            if (dVar4 != null) {
                                                dVar4.h0[bVar2.l] = dVar6;
                                            }
                                            bVar2.g = dVar6;
                                        }
                                    }
                                    z8 = false;
                                    if (z8) {
                                    }
                                    if (bVar2.f == null) {
                                    }
                                    dVar4 = bVar2.g;
                                    if (dVar4 != null) {
                                    }
                                    bVar2.g = dVar6;
                                }
                            }
                        }
                        if (dVar7 != dVar6) {
                            dVar7.i0[bVar2.l] = dVar6;
                        }
                        b.g.a.h.c cVar = dVar6.A[i9 + 1].f900d;
                        if (cVar != null) {
                            dVar3 = cVar.f898b;
                            b.g.a.h.c[] cVarArr = dVar3.A;
                            if (cVarArr[i9].f900d != null) {
                            }
                        }
                        dVar3 = null;
                        if (dVar3 == null) {
                            dVar3 = dVar6;
                            z9 = true;
                        }
                        dVar7 = dVar6;
                        i8 = 1;
                        dVar5 = null;
                        dVar6 = dVar3;
                    }
                    bVar2.f894c = dVar6;
                    if (bVar2.l != 0 || !bVar2.m) {
                        bVar2.f896e = bVar2.f892a;
                    } else {
                        bVar2.f896e = dVar6;
                    }
                    bVar2.p = bVar2.o && bVar2.n;
                    z = true;
                } else {
                    z = true;
                }
                bVar2.q = z;
                if (eVar5.I(4)) {
                    d.a aVar3 = d.a.WRAP_CONTENT;
                    b.g.a.h.d dVar8 = bVar2.f892a;
                    b.g.a.h.d dVar9 = bVar2.f894c;
                    b.g.a.h.d dVar10 = bVar2.f893b;
                    b.g.a.h.d dVar11 = bVar2.f895d;
                    b.g.a.h.d dVar12 = bVar2.f896e;
                    float f4 = bVar2.k;
                    d.a aVar4 = eVar5.C[i];
                    if (i == 0) {
                        i5 = i3;
                        z2 = dVar12.e0 == 0;
                        bVarArr2 = bVarArr;
                        z4 = dVar12.e0 == 1;
                    } else {
                        i5 = i3;
                        bVarArr2 = bVarArr;
                        boolean z10 = dVar12.f0 == 0;
                        boolean z11 = dVar12.f0 == 1;
                        if (dVar12.f0 == 2) {
                            z2 = z10;
                            z4 = z11;
                        } else {
                            z2 = z10;
                            z4 = z11;
                            z3 = false;
                            b.g.a.h.d dVar13 = dVar8;
                            i4 = i7;
                            float f5 = 0.0f;
                            float f6 = 0.0f;
                            int i14 = 0;
                            int i15 = 0;
                            z5 = false;
                            while (true) {
                                if (z5) {
                                    if (dVar13.Y != 8) {
                                        i14++;
                                        f5 += (float) (i == 0 ? dVar13.n() : dVar13.h());
                                        if (dVar13 != dVar10) {
                                            f5 += (float) dVar13.A[i2].b();
                                        }
                                        if (dVar13 != dVar11) {
                                            f5 += (float) dVar13.A[i2 + 1].b();
                                        }
                                        f6 = f6 + ((float) dVar13.A[i2].b()) + ((float) dVar13.A[i2 + 1].b());
                                    }
                                    b.g.a.h.c cVar2 = dVar13.A[i2];
                                    if (dVar13.Y != 8 && dVar13.C[i] == aVar2) {
                                        i15++;
                                        if (i != 0 ? dVar13.f == 0 && dVar13.k == 0 && dVar13.l == 0 : dVar13.f914e == 0 && dVar13.h == 0 && dVar13.i == 0) {
                                            if (dVar13.G != 0.0f) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    b.g.a.h.c cVar3 = dVar13.A[i2 + 1].f900d;
                                    if (cVar3 != null) {
                                        b.g.a.h.d dVar14 = cVar3.f898b;
                                        b.g.a.h.c[] cVarArr2 = dVar14.A;
                                        if (cVarArr2[i2].f900d != null && cVarArr2[i2].f900d.f898b == dVar13) {
                                            dVar2 = dVar14;
                                            if (dVar2 == null) {
                                                dVar13 = dVar2;
                                            } else {
                                                z5 = true;
                                            }
                                            f4 = f4;
                                        }
                                    }
                                    dVar2 = null;
                                    if (dVar2 == null) {
                                    }
                                    f4 = f4;
                                } else {
                                    b.g.a.h.j jVar2 = dVar8.A[i2].f897a;
                                    int i16 = i2 + 1;
                                    b.g.a.h.j jVar3 = dVar9.A[i16].f897a;
                                    aVar = aVar2;
                                    b.g.a.h.j jVar4 = jVar2.f926d;
                                    if (!(jVar4 == null || (jVar = jVar3.f926d) == null)) {
                                        b.g.a.h.d dVar15 = dVar9;
                                        if (jVar4.f930b == 1 && jVar.f930b == 1 && (i15 <= 0 || i15 == i14)) {
                                            if (z3 || z2 || z4) {
                                                f2 = dVar10 != null ? (float) dVar10.A[i2].b() : 0.0f;
                                                if (dVar11 != null) {
                                                    f2 += (float) dVar11.A[i16].b();
                                                }
                                            } else {
                                                f2 = 0.0f;
                                            }
                                            float f7 = jVar2.f926d.g;
                                            float f8 = jVar3.f926d.g;
                                            float f9 = (f7 < f8 ? f8 - f7 : f7 - f8) - f5;
                                            float f10 = -1.0f;
                                            if (i15 <= 0 || i15 != i14) {
                                                eVar3 = eVar2;
                                                if (f9 < 0.0f) {
                                                    z4 = false;
                                                    z3 = true;
                                                    z2 = false;
                                                }
                                                if (z3) {
                                                    float f11 = f9 - f2;
                                                    if (i == 0) {
                                                        dVar = dVar8;
                                                        f10 = dVar.V;
                                                    } else {
                                                        dVar = dVar8;
                                                        if (i == 1) {
                                                            f10 = dVar.W;
                                                        }
                                                    }
                                                    float f12 = (f11 * f10) + f7;
                                                    while (dVar != null) {
                                                        dVar = dVar.i0[i];
                                                        if (dVar != null || dVar == dVar15) {
                                                            int n = i == 0 ? dVar.n() : dVar.h();
                                                            float b2 = f12 + ((float) dVar.A[i2].b());
                                                            dVar.A[i2].f897a.j(jVar2.f, b2);
                                                            float f13 = b2 + ((float) n);
                                                            dVar.A[i16].f897a.j(jVar2.f, f13);
                                                            dVar.A[i2].f897a.e(eVar3);
                                                            dVar.A[i16].f897a.e(eVar3);
                                                            f12 = f13 + ((float) dVar.A[i16].b());
                                                        }
                                                    }
                                                } else {
                                                    b.g.a.h.d dVar16 = dVar8;
                                                    if (z2 || z4) {
                                                        if (z2 || z4) {
                                                            f9 -= f2;
                                                        }
                                                        float f14 = f9 / ((float) (i14 + 1));
                                                        if (z4) {
                                                            f14 = f9 / (i14 > 1 ? (float) (i14 - 1) : 2.0f);
                                                        }
                                                        float f15 = dVar16.Y != 8 ? f7 + f14 : f7;
                                                        if (z4) {
                                                            z6 = true;
                                                            if (i14 > 1) {
                                                                f15 = ((float) dVar10.A[i2].b()) + f7;
                                                            }
                                                        } else {
                                                            z6 = true;
                                                        }
                                                        if (z2 && dVar10 != null) {
                                                            f15 += (float) dVar10.A[i2].b();
                                                        }
                                                        while (true) {
                                                            b.g.a.h.d dVar17 = dVar16;
                                                            while (true) {
                                                                if (dVar17 == null) {
                                                                    break;
                                                                }
                                                                dVar16 = dVar17.i0[i];
                                                                if (dVar16 != null || dVar17 == dVar15) {
                                                                    float n2 = (float) (i == 0 ? dVar17.n() : dVar17.h());
                                                                    if (dVar17 != dVar10) {
                                                                        f15 += (float) dVar17.A[i2].b();
                                                                    }
                                                                    dVar17.A[i2].f897a.j(jVar2.f, f15);
                                                                    dVar17.A[i16].f897a.j(jVar2.f, f15 + n2);
                                                                    dVar17.A[i2].f897a.e(eVar3);
                                                                    dVar17.A[i16].f897a.e(eVar3);
                                                                    float b3 = n2 + ((float) dVar17.A[i16].b()) + f15;
                                                                    if (dVar16 != null) {
                                                                        if (dVar16.Y != 8) {
                                                                            b3 += f14;
                                                                        }
                                                                    }
                                                                    dVar17 = dVar16;
                                                                    f15 = b3;
                                                                }
                                                            }
                                                        }
                                                        z7 = z6;
                                                    }
                                                }
                                                z6 = true;
                                                z7 = z6;
                                            } else {
                                                b.g.a.h.d dVar18 = dVar13.D;
                                                if (dVar18 == null || dVar18.C[i] != aVar3) {
                                                    float f16 = (f9 + f5) - f6;
                                                    float f17 = f7;
                                                    b.g.a.h.d dVar19 = dVar8;
                                                    while (dVar19 != null) {
                                                        b.g.a.h.d dVar20 = dVar19.i0[i];
                                                        if (dVar20 != null || dVar19 == dVar15) {
                                                            float f18 = f16 / ((float) i15);
                                                            if (f4 > 0.0f) {
                                                                float[] fArr2 = dVar19.g0;
                                                                f18 = fArr2[i] == -1.0f ? 0.0f : (fArr2[i] * f16) / f4;
                                                            }
                                                            if (dVar19.Y == 8) {
                                                                f18 = 0.0f;
                                                            }
                                                            float b4 = f17 + ((float) dVar19.A[i2].b());
                                                            dVar19.A[i2].f897a.j(jVar2.f, b4);
                                                            float f19 = b4 + f18;
                                                            dVar19.A[i16].f897a.j(jVar2.f, f19);
                                                            dVar19.A[i2].f897a.e(eVar2);
                                                            dVar19.A[i16].f897a.e(eVar2);
                                                            f17 = f19 + ((float) dVar19.A[i16].b());
                                                        }
                                                        dVar19 = dVar20;
                                                        dVar15 = dVar15;
                                                    }
                                                    eVar3 = eVar2;
                                                    z7 = true;
                                                }
                                            }
                                        }
                                    }
                                    eVar3 = eVar2;
                                }
                            }
                            eVar3 = eVar2;
                            aVar = aVar2;
                            z7 = false;
                            eVar5 = eVar;
                            eVar6 = eVar3;
                            if (z7) {
                                bVar = bVar2;
                            } else {
                                i7 = i4 + 1;
                                eVar4 = eVar3;
                                i3 = i5;
                                bVarArr = bVarArr2;
                                aVar2 = aVar;
                                i6 = 2;
                            }
                        }
                    }
                    z3 = true;
                    b.g.a.h.d dVar132 = dVar8;
                    i4 = i7;
                    float f52 = 0.0f;
                    float f62 = 0.0f;
                    int i142 = 0;
                    int i152 = 0;
                    z5 = false;
                    while (true) {
                        if (z5) {
                        }
                        f4 = f4;
                    }
                    eVar3 = eVar2;
                    aVar = aVar2;
                    z7 = false;
                    eVar5 = eVar;
                    eVar6 = eVar3;
                    if (z7) {
                    }
                } else {
                    eVar3 = eVar4;
                    aVar = aVar2;
                    i5 = i3;
                    bVarArr2 = bVarArr;
                    i4 = i7;
                    bVar = bVar2;
                }
                b(eVar5, eVar6, i, i2, bVar);
                i7 = i4 + 1;
                eVar4 = eVar3;
                i3 = i5;
                bVarArr = bVarArr2;
                aVar2 = aVar;
                i6 = 2;
            }
        }

        public static int a0(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static <TResult> void a1(Status status, TResult tresult, c.b.a.a.g.i<TResult> iVar) {
            if (status.p()) {
                iVar.f2856a.i(tresult);
                return;
            }
            iVar.f2856a.h(new c.b.a.a.c.k.b(status));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v53, resolved type: b.g.a.h.d */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            if (r2.e0 == 2) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            if (r2.f0 == 2) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
            r15 = r14;
            r5 = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x0366  */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x0378  */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x038d  */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x0394  */
        /* JADX WARNING: Removed duplicated region for block: B:197:0x03a7  */
        /* JADX WARNING: Removed duplicated region for block: B:200:0x03b2  */
        /* JADX WARNING: Removed duplicated region for block: B:201:0x03bd  */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x03c1  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x03c4  */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x03e0  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x0406  */
        /* JADX WARNING: Removed duplicated region for block: B:244:0x0462  */
        /* JADX WARNING: Removed duplicated region for block: B:245:0x046a  */
        /* JADX WARNING: Removed duplicated region for block: B:248:0x0477  */
        /* JADX WARNING: Removed duplicated region for block: B:249:0x047a  */
        /* JADX WARNING: Removed duplicated region for block: B:264:0x04c8  */
        /* JADX WARNING: Removed duplicated region for block: B:269:0x04fd  */
        /* JADX WARNING: Removed duplicated region for block: B:278:0x0522  */
        /* JADX WARNING: Removed duplicated region for block: B:279:0x0525  */
        /* JADX WARNING: Removed duplicated region for block: B:282:0x052b  */
        /* JADX WARNING: Removed duplicated region for block: B:283:0x052e  */
        /* JADX WARNING: Removed duplicated region for block: B:285:0x0532  */
        /* JADX WARNING: Removed duplicated region for block: B:289:0x0541  */
        /* JADX WARNING: Removed duplicated region for block: B:291:0x0544  */
        /* JADX WARNING: Removed duplicated region for block: B:303:0x03e1 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x014f  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0187  */
        public static void b(b.g.a.h.e eVar, b.g.a.e eVar2, int i, int i2, b.g.a.h.b bVar) {
            boolean z;
            boolean z2;
            b.g.a.h.d dVar;
            b.g.a.g gVar;
            b.g.a.g gVar2;
            b.g.a.h.d dVar2;
            b.g.a.h.c cVar;
            b.g.a.h.c cVar2;
            b.g.a.h.c cVar3;
            int i3;
            b.g.a.h.d dVar3;
            int i4;
            b.g.a.g gVar3;
            b.g.a.g gVar4;
            b.g.a.h.c cVar4;
            b.g.a.h.d dVar4;
            b.g.a.h.c cVar5;
            int i5;
            int i6;
            b.g.a.h.d dVar5;
            int b2;
            int i7;
            int b3;
            b.g.a.g gVar5;
            b.g.a.g gVar6;
            b.g.a.h.c cVar6;
            b.g.a.h.c cVar7;
            int size;
            int i8;
            float f2;
            int i9;
            float f3;
            ArrayList<b.g.a.h.d> arrayList;
            char c2;
            float f4;
            b.g.a.h.d dVar6;
            float f5;
            b.g.a.a aVar;
            boolean z3;
            boolean z4;
            int i10;
            b.g.a.h.d dVar7;
            boolean z5;
            int i11;
            b.g.a.h.b bVar2 = bVar;
            b.g.a.h.d dVar8 = bVar2.f892a;
            b.g.a.h.d dVar9 = bVar2.f894c;
            b.g.a.h.d dVar10 = bVar2.f893b;
            b.g.a.h.d dVar11 = bVar2.f895d;
            b.g.a.h.d dVar12 = bVar2.f896e;
            float f6 = bVar2.k;
            boolean z6 = eVar.C[i] == d.a.WRAP_CONTENT;
            if (i == 0) {
                z2 = dVar12.e0 == 0;
                z = dVar12.e0 == 1;
            } else {
                z2 = dVar12.f0 == 0;
                z = dVar12.f0 == 1;
            }
            boolean z7 = true;
            boolean z8 = z;
            boolean z9 = z2;
            b.g.a.h.d dVar13 = dVar8;
            boolean z10 = false;
            while (true) {
                dVar = null;
                if (z10) {
                    break;
                }
                b.g.a.h.c cVar8 = dVar13.A[i2];
                int i12 = (z6 || z7) ? 1 : 4;
                int b4 = cVar8.b();
                b.g.a.h.c cVar9 = cVar8.f900d;
                if (!(cVar9 == null || dVar13 == dVar8)) {
                    b4 = cVar9.b() + b4;
                }
                if (z7 && dVar13 != dVar8 && dVar13 != dVar10) {
                    z3 = z10;
                    z4 = z8;
                    i10 = 6;
                } else if (!z9 || !z6) {
                    z3 = z10;
                    i10 = i12;
                    z4 = z8;
                } else {
                    z3 = z10;
                    z4 = z8;
                    i10 = 4;
                }
                b.g.a.h.c cVar10 = cVar8.f900d;
                if (cVar10 != null) {
                    if (dVar13 == dVar10) {
                        z5 = z9;
                        dVar7 = dVar12;
                        eVar2.f(cVar8.i, cVar10.i, b4, 5);
                    } else {
                        dVar7 = dVar12;
                        z5 = z9;
                        eVar2.f(cVar8.i, cVar10.i, b4, 6);
                    }
                    eVar2.d(cVar8.i, cVar8.f900d.i, b4, i10);
                } else {
                    dVar7 = dVar12;
                    z5 = z9;
                }
                if (z6) {
                    if (dVar13.Y == 8 || dVar13.C[i] != d.a.MATCH_CONSTRAINT) {
                        i11 = 0;
                    } else {
                        b.g.a.h.c[] cVarArr = dVar13.A;
                        i11 = 0;
                        eVar2.f(cVarArr[i2 + 1].i, cVarArr[i2].i, 0, 5);
                    }
                    eVar2.f(dVar13.A[i2].i, eVar.A[i2].i, i11, 6);
                }
                b.g.a.h.c cVar11 = dVar13.A[i2 + 1].f900d;
                if (cVar11 != null) {
                    b.g.a.h.d dVar14 = cVar11.f898b;
                    b.g.a.h.c[] cVarArr2 = dVar14.A;
                    if (cVarArr2[i2].f900d != null && cVarArr2[i2].f900d.f898b == dVar13) {
                        dVar = dVar14;
                    }
                }
                if (dVar != null) {
                    dVar13 = dVar;
                    z10 = z3;
                } else {
                    z10 = true;
                }
                z8 = z4;
                f6 = f6;
                z9 = z5;
                dVar12 = dVar7;
            }
            if (dVar11 != null) {
                b.g.a.h.c[] cVarArr3 = dVar9.A;
                int i13 = i2 + 1;
                if (cVarArr3[i13].f900d != null) {
                    b.g.a.h.c cVar12 = dVar11.A[i13];
                    eVar2.g(cVar12.i, cVarArr3[i13].f900d.i, -cVar12.b(), 5);
                    if (z6) {
                        int i14 = i2 + 1;
                        b.g.a.g gVar7 = eVar.A[i14].i;
                        b.g.a.h.c[] cVarArr4 = dVar9.A;
                        eVar2.f(gVar7, cVarArr4[i14].i, cVarArr4[i14].b(), 6);
                    }
                    ArrayList<b.g.a.h.d> arrayList2 = bVar2.h;
                    if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                        float f7 = (bVar2.n || bVar2.p) ? f6 : (float) bVar2.j;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        b.g.a.h.d dVar15 = null;
                        i8 = 0;
                        while (i8 < size) {
                            b.g.a.h.d dVar16 = arrayList2.get(i8);
                            float f10 = dVar16.g0[i];
                            if (f10 >= f8) {
                                arrayList = arrayList2;
                                f4 = 0.0f;
                            } else if (bVar2.p) {
                                b.g.a.h.c[] cVarArr5 = dVar16.A;
                                arrayList = arrayList2;
                                eVar2.d(cVarArr5[i2 + 1].i, cVarArr5[i2].i, 0, 4);
                                c2 = 6;
                                i9 = size;
                                f3 = f7;
                                f2 = 0.0f;
                                i8++;
                                bVar2 = bVar;
                                arrayList2 = arrayList;
                                f7 = f3;
                                size = i9;
                                f8 = f2;
                            } else {
                                arrayList = arrayList2;
                                f4 = 0.0f;
                                f10 = 1.0f;
                            }
                            int i15 = (f10 > f4 ? 1 : (f10 == f4 ? 0 : -1));
                            if (i15 == 0) {
                                b.g.a.h.c[] cVarArr6 = dVar16.A;
                                c2 = 6;
                                eVar2.d(cVarArr6[i2 + 1].i, cVarArr6[i2].i, 0, 6);
                                i9 = size;
                                f3 = f7;
                                f2 = 0.0f;
                                i8++;
                                bVar2 = bVar;
                                arrayList2 = arrayList;
                                f7 = f3;
                                size = i9;
                                f8 = f2;
                            } else {
                                if (dVar15 != null) {
                                    b.g.a.h.c[] cVarArr7 = dVar15.A;
                                    b.g.a.g gVar8 = cVarArr7[i2].i;
                                    int i16 = i2 + 1;
                                    b.g.a.g gVar9 = cVarArr7[i16].i;
                                    b.g.a.h.c[] cVarArr8 = dVar16.A;
                                    i9 = size;
                                    b.g.a.g gVar10 = cVarArr8[i2].i;
                                    b.g.a.g gVar11 = cVarArr8[i16].i;
                                    dVar6 = dVar16;
                                    b.g.a.b m = eVar2.m();
                                    m.f869b = 0.0f;
                                    if (f7 == 0.0f || f9 == f10) {
                                        f3 = f7;
                                        f2 = 0.0f;
                                        m.f871d.h(gVar8, 1.0f);
                                        f5 = -1.0f;
                                        m.f871d.h(gVar9, -1.0f);
                                        m.f871d.h(gVar11, 1.0f);
                                        aVar = m.f871d;
                                    } else {
                                        f2 = 0.0f;
                                        if (f9 == 0.0f) {
                                            m.f871d.h(gVar8, 1.0f);
                                            m.f871d.h(gVar9, -1.0f);
                                        } else if (i15 == 0) {
                                            m.f871d.h(gVar10, 1.0f);
                                            m.f871d.h(gVar11, -1.0f);
                                        } else {
                                            float f11 = (f9 / f7) / (f10 / f7);
                                            f3 = f7;
                                            m.f871d.h(gVar8, 1.0f);
                                            m.f871d.h(gVar9, -1.0f);
                                            m.f871d.h(gVar11, f11);
                                            aVar = m.f871d;
                                            f5 = -f11;
                                        }
                                        f3 = f7;
                                        eVar2.c(m);
                                    }
                                    aVar.h(gVar10, f5);
                                    eVar2.c(m);
                                } else {
                                    i9 = size;
                                    dVar6 = dVar16;
                                    f3 = f7;
                                    f2 = 0.0f;
                                }
                                f9 = f10;
                                dVar15 = dVar6;
                                i8++;
                                bVar2 = bVar;
                                arrayList2 = arrayList;
                                f7 = f3;
                                size = i9;
                                f8 = f2;
                            }
                        }
                    }
                    int i17 = 6;
                    int i18 = 4;
                    if (dVar10 == null && (dVar10 == dVar11 || z7)) {
                        b.g.a.h.c[] cVarArr9 = dVar8.A;
                        b.g.a.h.c cVar13 = cVarArr9[i2];
                        int i19 = i2 + 1;
                        b.g.a.h.c cVar14 = dVar9.A[i19];
                        b.g.a.g gVar12 = cVarArr9[i2].f900d != null ? cVarArr9[i2].f900d.i : null;
                        b.g.a.h.c[] cVarArr10 = dVar9.A;
                        b.g.a.g gVar13 = cVarArr10[i19].f900d != null ? cVarArr10[i19].f900d.i : null;
                        if (dVar10 == dVar11) {
                            b.g.a.h.c[] cVarArr11 = dVar10.A;
                            cVar13 = cVarArr11[i2];
                            cVar14 = cVarArr11[i19];
                        }
                        if (!(gVar12 == null || gVar13 == null)) {
                            eVar2.b(cVar13.i, gVar12, cVar13.b(), i == 0 ? dVar12.V : dVar12.W, gVar13, cVar14.i, cVar14.b(), 5);
                        }
                    } else if (z9 || dVar10 == null) {
                        int i20 = 8;
                        if (z8 && dVar10 != null) {
                            int i21 = bVar.j;
                            boolean z11 = i21 <= 0 && bVar.i == i21;
                            dVar2 = dVar10;
                            b.g.a.h.d dVar17 = dVar2;
                            while (dVar2 != null) {
                                b.g.a.h.d dVar18 = dVar2.i0[i];
                                while (dVar18 != null && dVar18.Y == i20) {
                                    dVar18 = dVar18.i0[i];
                                }
                                if (dVar2 == dVar10 || dVar2 == dVar11 || dVar18 == null) {
                                    dVar3 = dVar17;
                                    i4 = i20;
                                } else {
                                    b.g.a.h.d dVar19 = dVar18 == dVar11 ? null : dVar18;
                                    b.g.a.h.c cVar15 = dVar2.A[i2];
                                    b.g.a.g gVar14 = cVar15.i;
                                    b.g.a.h.c cVar16 = cVar15.f900d;
                                    int i22 = i2 + 1;
                                    b.g.a.g gVar15 = dVar17.A[i22].i;
                                    int b5 = cVar15.b();
                                    int b6 = dVar2.A[i22].b();
                                    if (dVar19 != null) {
                                        cVar4 = dVar19.A[i2];
                                        gVar4 = cVar4.i;
                                        cVar5 = cVar4.f900d;
                                        if (cVar5 == null) {
                                            gVar3 = null;
                                            int b7 = cVar4 == null ? cVar4.b() + b6 : b6;
                                            int b8 = dVar17.A[i22].b() + b5;
                                            int i23 = !z11 ? 6 : 4;
                                            if (gVar14 != null || gVar15 == null || gVar4 == null || gVar3 == null) {
                                                dVar4 = dVar19;
                                                dVar3 = dVar17;
                                                i4 = 8;
                                            } else {
                                                dVar4 = dVar19;
                                                dVar3 = dVar17;
                                                i4 = 8;
                                                eVar2.b(gVar14, gVar15, b8, 0.5f, gVar4, gVar3, b7, i23);
                                            }
                                            dVar18 = dVar4;
                                        }
                                    } else {
                                        cVar4 = dVar2.A[i22].f900d;
                                        gVar4 = cVar4 != null ? cVar4.i : null;
                                        cVar5 = dVar2.A[i22];
                                    }
                                    gVar3 = cVar5.i;
                                    if (cVar4 == null) {
                                    }
                                    int b82 = dVar17.A[i22].b() + b5;
                                    if (!z11) {
                                    }
                                    if (gVar14 != null) {
                                    }
                                    dVar4 = dVar19;
                                    dVar3 = dVar17;
                                    i4 = 8;
                                    dVar18 = dVar4;
                                }
                                if (dVar2.Y == i4) {
                                    dVar2 = dVar3;
                                }
                                i20 = i4;
                                dVar17 = dVar2;
                                dVar2 = dVar18;
                            }
                            b.g.a.h.c cVar17 = dVar10.A[i2];
                            cVar = dVar8.A[i2].f900d;
                            int i24 = i2 + 1;
                            cVar2 = dVar11.A[i24];
                            cVar3 = dVar9.A[i24].f900d;
                            if (cVar != null) {
                                i3 = 5;
                            } else if (dVar10 != dVar11) {
                                i3 = 5;
                                eVar2.d(cVar17.i, cVar.i, cVar17.b(), 5);
                            } else {
                                i3 = 5;
                                if (cVar3 != null) {
                                    eVar2.b(cVar17.i, cVar.i, cVar17.b(), 0.5f, cVar2.i, cVar3.i, cVar2.b(), 5);
                                }
                            }
                            if (!(cVar3 == null || dVar10 == dVar11)) {
                                eVar2.d(cVar2.i, cVar3.i, -cVar2.b(), i3);
                            }
                        }
                    } else {
                        int i25 = bVar.j;
                        boolean z12 = i25 > 0 && bVar.i == i25;
                        b.g.a.h.d dVar20 = dVar10;
                        b.g.a.h.d dVar21 = dVar20;
                        while (dVar20 != null) {
                            b.g.a.h.d dVar22 = dVar20.i0[i];
                            while (true) {
                                if (dVar22 != null) {
                                    if (dVar22.Y != 8) {
                                        break;
                                    }
                                    dVar22 = dVar22.i0[i];
                                } else {
                                    break;
                                }
                            }
                            if (dVar22 != null || dVar20 == dVar11) {
                                b.g.a.h.c cVar18 = dVar20.A[i2];
                                b.g.a.g gVar16 = cVar18.i;
                                b.g.a.h.c cVar19 = cVar18.f900d;
                                b.g.a.g gVar17 = cVar19 != null ? cVar19.i : null;
                                if (dVar21 != dVar20) {
                                    cVar7 = dVar21.A[i2 + 1];
                                } else {
                                    if (dVar20 == dVar10 && dVar21 == dVar20) {
                                        b.g.a.h.c[] cVarArr12 = dVar8.A;
                                        if (cVarArr12[i2].f900d != null) {
                                            cVar7 = cVarArr12[i2].f900d;
                                        } else {
                                            gVar17 = null;
                                        }
                                    }
                                    b2 = cVar18.b();
                                    i7 = i2 + 1;
                                    b3 = dVar20.A[i7].b();
                                    if (dVar22 == null) {
                                        cVar6 = dVar22.A[i2];
                                        b.g.a.g gVar18 = cVar6.i;
                                        gVar5 = dVar20.A[i7].i;
                                        gVar6 = gVar18;
                                    } else {
                                        cVar6 = dVar9.A[i7].f900d;
                                        gVar6 = cVar6 != null ? cVar6.i : null;
                                        gVar5 = dVar20.A[i7].i;
                                    }
                                    if (cVar6 != null) {
                                        b3 += cVar6.b();
                                    }
                                    if (dVar21 != null) {
                                        b2 += dVar21.A[i7].b();
                                    }
                                    if (!(gVar16 == null || gVar17 == null || gVar6 == null || gVar5 == null)) {
                                        if (dVar20 == dVar10) {
                                            b2 = dVar10.A[i2].b();
                                        }
                                        int b9 = dVar20 != dVar11 ? dVar11.A[i7].b() : b3;
                                        int i26 = !z12 ? i17 : i18;
                                        i5 = i17;
                                        i6 = i18;
                                        dVar5 = dVar22;
                                        eVar2.b(gVar16, gVar17, b2, 0.5f, gVar6, gVar5, b9, i26);
                                        if (dVar20.Y != 8) {
                                            dVar21 = dVar20;
                                        }
                                        dVar20 = dVar5;
                                        i18 = i6;
                                        i17 = i5;
                                    }
                                }
                                gVar17 = cVar7.i;
                                b2 = cVar18.b();
                                i7 = i2 + 1;
                                b3 = dVar20.A[i7].b();
                                if (dVar22 == null) {
                                }
                                if (cVar6 != null) {
                                }
                                if (dVar21 != null) {
                                }
                                if (dVar20 == dVar10) {
                                }
                                if (dVar20 != dVar11) {
                                }
                                if (!z12) {
                                }
                                i5 = i17;
                                i6 = i18;
                                dVar5 = dVar22;
                                eVar2.b(gVar16, gVar17, b2, 0.5f, gVar6, gVar5, b9, i26);
                                if (dVar20.Y != 8) {
                                }
                                dVar20 = dVar5;
                                i18 = i6;
                                i17 = i5;
                            }
                            dVar5 = dVar22;
                            i5 = i17;
                            i6 = i18;
                            if (dVar20.Y != 8) {
                            }
                            dVar20 = dVar5;
                            i18 = i6;
                            i17 = i5;
                        }
                    }
                    if ((!z9 || z8) && dVar10 != null) {
                        b.g.a.h.c cVar20 = dVar10.A[i2];
                        int i27 = i2 + 1;
                        b.g.a.h.c cVar21 = dVar11.A[i27];
                        b.g.a.h.c cVar22 = cVar20.f900d;
                        gVar = cVar22 == null ? cVar22.i : null;
                        b.g.a.h.c cVar23 = cVar21.f900d;
                        b.g.a.g gVar19 = cVar23 == null ? cVar23.i : null;
                        if (dVar9 == dVar11) {
                            b.g.a.h.c cVar24 = dVar9.A[i27].f900d;
                            if (cVar24 != null) {
                                dVar = cVar24.i;
                            }
                            gVar2 = dVar;
                        } else {
                            gVar2 = gVar19;
                        }
                        if (dVar10 == dVar11) {
                            b.g.a.h.c[] cVarArr13 = dVar10.A;
                            b.g.a.h.c cVar25 = cVarArr13[i2];
                            cVar21 = cVarArr13[i27];
                            cVar20 = cVar25;
                        }
                        if (gVar != null && gVar2 != null) {
                            eVar2.b(cVar20.i, gVar, cVar20.b(), 0.5f, gVar2, cVar21.i, dVar11.A[i27].b(), 5);
                            return;
                        }
                    }
                    return;
                }
            }
            if (z6) {
            }
            ArrayList<b.g.a.h.d> arrayList22 = bVar2.h;
            if (bVar2.n) {
            }
            float f82 = 0.0f;
            float f92 = 0.0f;
            b.g.a.h.d dVar152 = null;
            i8 = 0;
            while (i8 < size) {
            }
            int i172 = 6;
            int i182 = 4;
            if (dVar10 == null) {
            }
            if (z9) {
            }
            int i202 = 8;
            int i212 = bVar.j;
            if (i212 <= 0) {
            }
            dVar2 = dVar10;
            b.g.a.h.d dVar172 = dVar2;
            while (dVar2 != null) {
            }
            b.g.a.h.c cVar172 = dVar10.A[i2];
            cVar = dVar8.A[i2].f900d;
            int i242 = i2 + 1;
            cVar2 = dVar11.A[i242];
            cVar3 = dVar9.A[i242].f900d;
            if (cVar != null) {
            }
            eVar2.d(cVar2.i, cVar3.i, -cVar2.b(), i3);
            if (!z9) {
            }
            b.g.a.h.c cVar202 = dVar10.A[i2];
            int i272 = i2 + 1;
            b.g.a.h.c cVar212 = dVar11.A[i272];
            b.g.a.h.c cVar222 = cVar202.f900d;
            if (cVar222 == null) {
            }
            b.g.a.h.c cVar232 = cVar212.f900d;
            if (cVar232 == null) {
            }
            if (dVar9 == dVar11) {
            }
            if (dVar10 == dVar11) {
            }
            if (gVar != null) {
            }
        }

        public static <T> u<T> b0(b.f.a.d<T> dVar) {
            b.f.a.b<T> bVar = new b.f.a.b<>();
            b.f.a.e<T> eVar = new b.f.a.e<>(bVar);
            bVar.f858b = eVar;
            bVar.f857a = dVar.getClass();
            try {
                Object a2 = dVar.a(bVar);
                if (a2 != null) {
                    bVar.f857a = a2;
                }
            } catch (Exception e2) {
                eVar.f862c.l(e2);
            }
            return eVar;
        }

        public static void b1(Drawable drawable, int i) {
            drawable.setTint(i);
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
        public static boolean c(int i, Rect rect, Rect rect2, Rect rect3) {
            int i2;
            int i3;
            boolean d2 = d(i, rect, rect2);
            if (d(i, rect, rect3) || !d2) {
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
            int z0 = z0(i, rect, rect2);
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
            return z0 < Math.max(1, i3 - i2);
        }

        public static int c0(b.g.a.h.f fVar, int i) {
            int i2 = i * 2;
            List<b.g.a.h.d> list = null;
            if (fVar != null) {
                if (i == 0) {
                    list = fVar.f;
                } else if (i == 1) {
                    list = fVar.g;
                }
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    b.g.a.h.d dVar = list.get(i4);
                    b.g.a.h.c[] cVarArr = dVar.A;
                    int i5 = i2 + 1;
                    i3 = Math.max(i3, d0(dVar, i, cVarArr[i5].f900d == null || !(cVarArr[i2].f900d == null || cVarArr[i5].f900d == null), 0));
                }
                fVar.f923e[i] = i3;
                return i3;
            }
            throw null;
        }

        public static void c1(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static boolean d(int i, Rect rect, Rect rect2) {
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

        public static int d0(b.g.a.h.d dVar, int i, boolean z, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int n;
            int i8;
            int i9;
            b.g.a.h.d dVar2;
            int i10 = 0;
            if (!dVar.b0) {
                return 0;
            }
            boolean z2 = dVar.w.f900d != null && i == 1;
            if (z) {
                i6 = dVar.Q;
                i5 = dVar.h() - dVar.Q;
                i4 = i * 2;
                i3 = i4 + 1;
            } else {
                int h2 = dVar.h();
                i5 = dVar.Q;
                i6 = h2 - i5;
                i3 = i * 2;
                i4 = i3 + 1;
            }
            b.g.a.h.c[] cVarArr = dVar.A;
            if (cVarArr[i3].f900d == null || cVarArr[i4].f900d != null) {
                i7 = 1;
            } else {
                i7 = -1;
                i3 = i4;
                i4 = i3;
            }
            int i11 = z2 ? i2 - i6 : i2;
            int n0 = n0(dVar, i) + (dVar.A[i4].b() * i7);
            int i12 = i11 + n0;
            int n2 = (i == 0 ? dVar.n() : dVar.h()) * i7;
            Iterator<b.g.a.h.l> it = dVar.A[i4].f897a.f929a.iterator();
            while (it.hasNext()) {
                i10 = Math.max(i10, d0(((b.g.a.h.j) it.next()).f925c.f898b, i, z, i12));
            }
            int i13 = 0;
            for (Iterator<b.g.a.h.l> it2 = dVar.A[i3].f897a.f929a.iterator(); it2.hasNext(); it2 = it2) {
                i13 = Math.max(i13, d0(((b.g.a.h.j) it2.next()).f925c.f898b, i, z, n2 + i12));
            }
            if (z2) {
                i10 -= i6;
                n = i13 + i5;
            } else {
                n = i13 + ((i == 0 ? dVar.n() : dVar.h()) * i7);
            }
            if (i == 1) {
                Iterator<b.g.a.h.l> it3 = dVar.w.f897a.f929a.iterator();
                int i14 = 0;
                while (it3.hasNext()) {
                    i14 = Math.max(i14, d0(((b.g.a.h.j) it3.next()).f925c.f898b, i, z, i7 == 1 ? i6 + i12 : (i5 * i7) + i12));
                    it3 = it3;
                    i3 = i3;
                }
                i8 = i3;
                i9 = (dVar.w.f897a.f929a.size() <= 0 || z2) ? i14 : i7 == 1 ? i14 + i6 : i14 - i5;
            } else {
                i8 = i3;
                i9 = 0;
            }
            int max = Math.max(i10, Math.max(n, i9)) + n0;
            int i15 = n2 + i12;
            if (i7 == -1) {
                i15 = i12;
                i12 = i15;
            }
            if (z) {
                b.g.a.h.i.b(dVar, i, i12);
                dVar.v(i12, i15, i);
            } else {
                dVar.p.a(dVar, i);
                if (i == 0) {
                    dVar.K = i12;
                } else if (i == 1) {
                    dVar.L = i12;
                }
            }
            if (dVar.g(i) == d.a.MATCH_CONSTRAINT && dVar.G != 0.0f) {
                dVar.p.a(dVar, i);
            }
            b.g.a.h.c[] cVarArr2 = dVar.A;
            if (cVarArr2[i4].f900d != null && cVarArr2[i8].f900d != null && cVarArr2[i4].f900d.f898b == (dVar2 = dVar.D) && cVarArr2[i8].f900d.f898b == dVar2) {
                dVar.p.a(dVar, i);
            }
            return max;
        }

        public static void d1(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        public static int e(Parcel parcel) {
            return C1(parcel, 20293);
        }

        public static int e0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            return !q0(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
        }

        public static void e1(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            b1 b1Var = b1.k;
            if (b1Var != null && b1Var.f600b == view) {
                b1.c(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                b1 b1Var2 = b1.l;
                if (b1Var2 != null && b1Var2.f600b == view) {
                    b1Var2.b();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new b1(view, charSequence);
        }

        public static void f(Object obj, StringBuilder sb) {
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

        public static b.i.e.b.a f0(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
            b.i.e.b.a aVar;
            if (q0(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i, typedValue);
                int i3 = typedValue.type;
                if (i3 >= 28 && i3 <= 31) {
                    return new b.i.e.b.a(null, null, typedValue.data);
                }
                try {
                    aVar = b.i.e.b.a.a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar != null) {
                    return aVar;
                }
            }
            return new b.i.e.b.a(null, null, i2);
        }

        public static void f1(XmlPullParser xmlPullParser) {
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

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
        public static b.z.d g(byte[] bArr) {
            Throwable th;
            ObjectInputStream objectInputStream;
            IOException e2;
            b.z.d dVar = new b.z.d();
            if (bArr == null) {
                return dVar;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        dVar.f1908a.add(new d.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    try {
                        e2.printStackTrace();
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return dVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                objectInputStream = null;
                e2 = e7;
                e2.printStackTrace();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                return dVar;
            } catch (Throwable th3) {
                objectInputStream = null;
                th = th3;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
            return dVar;
        }

        public static float g0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f2) {
            return !q0(xmlPullParser, str) ? f2 : typedArray.getFloat(i, f2);
        }

        public static void g1(Parcel parcel, int i) {
            parcel.setDataPosition(parcel.dataPosition() + T0(parcel, i));
        }

        public static boolean h(b.i.f.c[] cVarArr, b.i.f.c[] cVarArr2) {
            if (cVarArr == null || cVarArr2 == null || cVarArr.length != cVarArr2.length) {
                return false;
            }
            for (int i = 0; i < cVarArr.length; i++) {
                if (!(cVarArr[i].f1052a == cVarArr2[i].f1052a && cVarArr[i].f1053b.length == cVarArr2[i].f1053b.length)) {
                    return false;
                }
            }
            return true;
        }

        public static int h0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            return !q0(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
        }

        public static int h1(b.z.u uVar) {
            int ordinal = uVar.ordinal();
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
                            throw new IllegalArgumentException("Could not convert " + uVar + " to int");
                        }
                    }
                }
            }
            return i;
        }

        public static void i(boolean z) {
            if (!z) {
                throw new IllegalArgumentException();
            }
        }

        public static String i0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
            if (!q0(xmlPullParser, str)) {
                return null;
            }
            return typedArray.getString(i);
        }

        public static List<byte[]> i1(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        public static void j(boolean z, String str, Object... objArr) {
            if (!z) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }

        public static PropertyValuesHolder j0(TypedArray typedArray, int i, int i2, int i3, String str) {
            PropertyValuesHolder propertyValuesHolder;
            PropertyValuesHolder propertyValuesHolder2;
            TypedValue peekValue = typedArray.peekValue(i2);
            boolean z = peekValue != null;
            int i4 = z ? peekValue.type : 0;
            TypedValue peekValue2 = typedArray.peekValue(i3);
            boolean z2 = peekValue2 != null;
            int i5 = z2 ? peekValue2.type : 0;
            if (i == 4) {
                i = ((!z || !v0(i4)) && (!z2 || !v0(i5))) ? 0 : 3;
            }
            boolean z3 = i == 0;
            PropertyValuesHolder propertyValuesHolder3 = null;
            if (i == 2) {
                String string = typedArray.getString(i2);
                String string2 = typedArray.getString(i3);
                b.i.f.c[] N = N(string);
                b.i.f.c[] N2 = N(string2);
                if (N == null && N2 == null) {
                    return null;
                }
                if (N != null) {
                    b.w.a.a.c cVar = new b.w.a.a.c();
                    if (N2 == null) {
                        propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, cVar, N);
                    } else if (h(N, N2)) {
                        propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, cVar, N, N2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                    return propertyValuesHolder2;
                } else if (N2 == null) {
                    return null;
                } else {
                    return PropertyValuesHolder.ofObject(str, new b.w.a.a.c(), N2);
                }
            } else {
                b.w.a.a.d dVar = i == 3 ? b.w.a.a.d.f1853a : null;
                if (z3) {
                    if (z) {
                        float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                        if (z2) {
                            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                        } else {
                            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, dimension);
                        }
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                    }
                } else if (z) {
                    int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : v0(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                    if (z2) {
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : v0(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
                    }
                } else {
                    if (z2) {
                        propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : v0(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                    }
                    if (propertyValuesHolder3 == null && dVar != null) {
                        propertyValuesHolder3.setEvaluator(dVar);
                        return propertyValuesHolder3;
                    }
                }
                propertyValuesHolder3 = propertyValuesHolder;
                return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
            }
        }

        public static o j1(Object obj) {
            return new o(obj, null);
        }

        public static void k(boolean z, Object obj) {
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
        }

        public static Intent k0(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String m0 = m0(activity, activity.getComponentName());
                if (m0 == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, m0);
                try {
                    return m0(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        public static boolean k1(b.g.a.h.d dVar, b.g.a.h.f fVar, List<b.g.a.h.f> list, boolean z) {
            b.g.a.h.c cVar;
            b.g.a.h.c cVar2;
            b.g.a.h.c cVar3;
            b.g.a.h.d dVar2;
            b.g.a.h.c cVar4;
            b.g.a.h.c cVar5;
            b.g.a.h.c cVar6;
            b.g.a.h.c cVar7;
            b.g.a.h.d dVar3;
            b.g.a.h.c cVar8;
            d.a aVar = d.a.MATCH_CONSTRAINT;
            if (dVar == null) {
                return true;
            }
            dVar.c0 = false;
            b.g.a.h.e eVar = (b.g.a.h.e) dVar.D;
            b.g.a.h.f fVar2 = dVar.p;
            if (fVar2 == null) {
                dVar.b0 = true;
                fVar.f919a.add(dVar);
                dVar.p = fVar;
                if (dVar.s.f900d == null && dVar.u.f900d == null && dVar.t.f900d == null && dVar.v.f900d == null && dVar.w.f900d == null && dVar.z.f900d == null) {
                    fVar.f922d = false;
                    eVar.C0 = false;
                    dVar.b0 = false;
                    if (z) {
                        return false;
                    }
                }
                if (!(dVar.t.f900d == null || dVar.v.f900d == null)) {
                    eVar.m();
                    if (!z) {
                        b.g.a.h.d dVar4 = dVar.t.f900d.f898b;
                        b.g.a.h.d dVar5 = dVar.D;
                        if (!(dVar4 == dVar5 && dVar.v.f900d.f898b == dVar5)) {
                            fVar.f922d = false;
                            eVar.C0 = false;
                            dVar.b0 = false;
                        }
                    }
                    fVar.f922d = false;
                    eVar.C0 = false;
                    dVar.b0 = false;
                    return false;
                }
                if (!(dVar.s.f900d == null || dVar.u.f900d == null)) {
                    eVar.i();
                    if (!z) {
                        b.g.a.h.d dVar6 = dVar.s.f900d.f898b;
                        b.g.a.h.d dVar7 = dVar.D;
                        if (!(dVar6 == dVar7 && dVar.u.f900d.f898b == dVar7)) {
                            fVar.f922d = false;
                            eVar.C0 = false;
                            dVar.b0 = false;
                        }
                    }
                    fVar.f922d = false;
                    eVar.C0 = false;
                    dVar.b0 = false;
                    return false;
                }
                if (((dVar.i() == aVar) ^ (dVar.m() == aVar)) && dVar.G != 0.0f) {
                    U0(dVar);
                } else if (dVar.i() == aVar || dVar.m() == aVar) {
                    fVar.f922d = false;
                    eVar.C0 = false;
                    dVar.b0 = false;
                    if (z) {
                        return false;
                    }
                }
                if (((dVar.s.f900d == null && dVar.u.f900d == null) || (((cVar5 = dVar.s.f900d) != null && cVar5.f898b == dVar.D && dVar.u.f900d == null) || (((cVar6 = dVar.u.f900d) != null && cVar6.f898b == dVar.D && dVar.s.f900d == null) || ((cVar7 = dVar.s.f900d) != null && cVar7.f898b == (dVar3 = dVar.D) && (cVar8 = dVar.u.f900d) != null && cVar8.f898b == dVar3)))) && dVar.z.f900d == null && !(dVar instanceof b.g.a.h.g) && !(dVar instanceof b.g.a.h.h)) {
                    fVar.f.add(dVar);
                }
                if (((dVar.t.f900d == null && dVar.v.f900d == null) || (((cVar = dVar.t.f900d) != null && cVar.f898b == dVar.D && dVar.v.f900d == null) || (((cVar2 = dVar.v.f900d) != null && cVar2.f898b == dVar.D && dVar.t.f900d == null) || ((cVar3 = dVar.t.f900d) != null && cVar3.f898b == (dVar2 = dVar.D) && (cVar4 = dVar.v.f900d) != null && cVar4.f898b == dVar2)))) && dVar.z.f900d == null && dVar.w.f900d == null && !(dVar instanceof b.g.a.h.g) && !(dVar instanceof b.g.a.h.h)) {
                    fVar.g.add(dVar);
                }
                if (dVar instanceof b.g.a.h.h) {
                    fVar.f922d = false;
                    eVar.C0 = false;
                    dVar.b0 = false;
                    if (z) {
                        return false;
                    }
                    b.g.a.h.h hVar = (b.g.a.h.h) dVar;
                    for (int i = 0; i < hVar.k0; i++) {
                        if (!k1(hVar.j0[i], fVar, list, z)) {
                            return false;
                        }
                    }
                }
                int length = dVar.A.length;
                for (int i2 = 0; i2 < length; i2++) {
                    b.g.a.h.c cVar9 = dVar.A[i2];
                    b.g.a.h.c cVar10 = cVar9.f900d;
                    if (!(cVar10 == null || cVar10.f898b == dVar.D)) {
                        if (cVar9.f899c == c.b.CENTER) {
                            fVar.f922d = false;
                            eVar.C0 = false;
                            dVar.b0 = false;
                            if (z) {
                                return false;
                            }
                        } else {
                            b.g.a.h.j jVar = cVar9.f897a;
                            if (cVar10.f900d != cVar9) {
                                cVar10.f897a.f929a.add(jVar);
                            }
                        }
                        if (!k1(cVar9.f900d.f898b, fVar, list, z)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            if (fVar2 != fVar) {
                fVar.f919a.addAll(fVar2.f919a);
                fVar.f.addAll(dVar.p.f);
                fVar.g.addAll(dVar.p.g);
                if (!dVar.p.f922d) {
                    fVar.f922d = false;
                }
                list.remove(dVar.p);
                for (b.g.a.h.d dVar8 : dVar.p.f919a) {
                    dVar8.p = fVar;
                }
            }
            return true;
        }

        public static int l(int i) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException();
        }

        public static Intent l0(Context context, ComponentName componentName) {
            String m0 = m0(context, componentName);
            if (m0 == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), m0);
            return m0(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Drawable> T l1(Drawable drawable) {
            return drawable instanceof b.i.f.k.a ? (T) ((b.i.f.k.a) drawable).a() : drawable;
        }

        public static void m(Handler handler) {
            String name = Looper.myLooper() != null ? Looper.myLooper().getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 36);
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(".");
            String sb2 = sb.toString();
            if (Looper.myLooper() != handler.getLooper()) {
                throw new IllegalStateException(sb2);
            }
        }

        public static String m0(Context context, ComponentName componentName) {
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

        public static int m1(Parcel parcel) {
            int readInt = parcel.readInt();
            int T0 = T0(parcel, readInt);
            int dataPosition = parcel.dataPosition();
            if ((65535 & readInt) != 20293) {
                String valueOf = String.valueOf(Integer.toHexString(readInt));
                throw new c.b.a.a.c.l.s.b(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
            }
            int i = T0 + dataPosition;
            if (i >= dataPosition && i <= parcel.dataSize()) {
                return i;
            }
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i);
            throw new c.b.a.a.c.l.s.b(sb.toString(), parcel);
        }

        public static String n(String str) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }

        public static int n0(b.g.a.h.d dVar, int i) {
            b.g.a.h.d dVar2;
            b.g.a.h.c cVar;
            int i2 = i * 2;
            b.g.a.h.c[] cVarArr = dVar.A;
            b.g.a.h.c cVar2 = cVarArr[i2];
            b.g.a.h.c cVar3 = cVarArr[i2 + 1];
            b.g.a.h.c cVar4 = cVar2.f900d;
            if (cVar4 == null || cVar4.f898b != (dVar2 = dVar.D) || (cVar = cVar3.f900d) == null || cVar.f898b != dVar2) {
                return 0;
            }
            return (int) (((float) (((dVar2.j(i) - cVar2.b()) - cVar3.b()) - dVar.j(i))) * (i == 0 ? dVar.V : dVar.W));
        }

        public static ActionMode.Callback n1(TextView textView, ActionMode.Callback callback) {
            int i = Build.VERSION.SDK_INT;
            return (i < 26 || i > 27 || (callback instanceof b.i.m.d)) ? callback : new b.i.m.d(callback, textView);
        }

        public static String o(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }

        public static File o0(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder g2 = c.a.a.a.a.g(".font");
            g2.append(Process.myPid());
            g2.append("-");
            g2.append(Process.myTid());
            g2.append("-");
            String sb = g2.toString();
            for (int i = 0; i < 100; i++) {
                File file = new File(cacheDir, c.a.a.a.a.l(sb, i));
                try {
                    if (file.createNewFile()) {
                        return file;
                    }
                } catch (IOException unused) {
                }
            }
            return null;
        }

        public static void o1(Parcel parcel, int i, boolean z) {
            G1(parcel, i, 4);
            parcel.writeInt(z ? 1 : 0);
        }

        public static void p(String str) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                throw new IllegalStateException(str);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r7 != 2) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
            if (r5 != false) goto L_0x0069;
         */
        public static b.a p0(TextView textView) {
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

        public static void p1(Parcel parcel, int i, Bundle bundle, boolean z) {
            if (bundle != null) {
                int C1 = C1(parcel, i);
                parcel.writeBundle(bundle);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static <T> T q(T t) {
            if (t != null) {
                return t;
            }
            throw null;
        }

        public static boolean q0(XmlPullParser xmlPullParser, String str) {
            return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
        }

        public static void q1(Parcel parcel, int i, byte[] bArr, boolean z) {
            if (bArr != null) {
                int C1 = C1(parcel, i);
                parcel.writeByteArray(bArr);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static <T> T r(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static b.z.a r0(int i) {
            if (i == 0) {
                return b.z.a.EXPONENTIAL;
            }
            if (i == 1) {
                return b.z.a.LINEAR;
            }
            throw new IllegalArgumentException(c.a.a.a.a.m("Could not convert ", i, " to BackoffPolicy"));
        }

        public static void r1(Parcel parcel, int i, double d2) {
            G1(parcel, i, 8);
            parcel.writeDouble(d2);
        }

        @EnsuresNonNull({"#1"})
        public static <T> T s(T t) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException("null reference");
        }

        public static n s0(int i) {
            if (i == 0) {
                return n.NOT_REQUIRED;
            }
            if (i == 1) {
                return n.CONNECTED;
            }
            if (i == 2) {
                return n.UNMETERED;
            }
            if (i == 3) {
                return n.NOT_ROAMING;
            }
            if (i == 4) {
                return n.METERED;
            }
            throw new IllegalArgumentException(c.a.a.a.a.m("Could not convert ", i, " to NetworkType"));
        }

        public static void s1(Parcel parcel, int i, List<Double> list, boolean z) {
            if (list != null) {
                int C1 = C1(parcel, i);
                int size = list.size();
                parcel.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    parcel.writeDouble(list.get(i2).doubleValue());
                }
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        @EnsuresNonNull({"#1"})
        public static <T> T t(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static b.z.u t0(int i) {
            if (i == 0) {
                return b.z.u.ENQUEUED;
            }
            if (i == 1) {
                return b.z.u.RUNNING;
            }
            if (i == 2) {
                return b.z.u.SUCCEEDED;
            }
            if (i == 3) {
                return b.z.u.FAILED;
            }
            if (i == 4) {
                return b.z.u.BLOCKED;
            }
            if (i == 5) {
                return b.z.u.CANCELLED;
            }
            throw new IllegalArgumentException(c.a.a.a.a.m("Could not convert ", i, " to State"));
        }

        public static void t1(Parcel parcel, int i, IBinder iBinder, boolean z) {
            if (iBinder != null) {
                int C1 = C1(parcel, i);
                parcel.writeStrongBinder(iBinder);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static int u(Context context, String str) {
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

        public static boolean u0(Rect rect, Rect rect2, int i) {
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

        public static void u1(Parcel parcel, int i, int i2) {
            G1(parcel, i, 4);
            parcel.writeInt(i2);
        }

        public static void v(boolean z, Object obj) {
            if (!z) {
                throw new IllegalStateException(String.valueOf(obj));
            }
        }

        public static boolean v0(int i) {
            return i >= 28 && i <= 31;
        }

        public static void v1(Parcel parcel, int i, int[] iArr, boolean z) {
            if (iArr != null) {
                int C1 = C1(parcel, i);
                parcel.writeIntArray(iArr);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static int w(int i, int i2, int i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }

        public static b.l.d.h w0(Context context, b.l.d.j jVar, Fragment fragment, boolean z) {
            int nextTransition = fragment.getNextTransition();
            int nextAnim = fragment.getNextAnim();
            boolean z2 = false;
            fragment.setNextAnim(0);
            View a2 = jVar.a(fragment.mContainerId);
            if (!(a2 == null || a2.getTag(b.l.b.visible_removing_fragment_view_tag) == null)) {
                a2.setTag(b.l.b.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup = fragment.mContainer;
            if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
                return null;
            }
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
            if (onCreateAnimation != null) {
                return new b.l.d.h(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
            if (onCreateAnimator != null) {
                return new b.l.d.h(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new b.l.d.h(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new b.l.d.h(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                            if (loadAnimation2 != null) {
                                return new b.l.d.h(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            if (nextTransition == 0) {
                return null;
            }
            int i = nextTransition != 4097 ? nextTransition != 4099 ? nextTransition != 8194 ? -1 : z ? b.l.a.fragment_close_enter : b.l.a.fragment_close_exit : z ? b.l.a.fragment_fade_enter : b.l.a.fragment_fade_exit : z ? b.l.a.fragment_open_enter : b.l.a.fragment_open_exit;
            if (i < 0) {
                return null;
            }
            return new b.l.d.h(AnimationUtils.loadAnimation(context, i));
        }

        public static void w1(Parcel parcel, int i, List<Integer> list, boolean z) {
            if (list != null) {
                int C1 = C1(parcel, i);
                int size = list.size();
                parcel.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    parcel.writeInt(list.get(i2).intValue());
                }
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static int x(RecyclerView.a0 a0Var, a0 a0Var2, View view, View view2, RecyclerView.o oVar, boolean z) {
            if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(oVar.P(view) - oVar.P(view2)) + 1;
            }
            return Math.min(a0Var2.l(), a0Var2.b(view2) - a0Var2.e(view));
        }

        public static ValueAnimator x0(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
            TypedArray typedArray;
            ValueAnimator valueAnimator2;
            TypedArray typedArray2;
            ValueAnimator valueAnimator3;
            PropertyValuesHolder propertyValuesHolder;
            TypedArray C0 = C0(resources, theme, attributeSet, b.w.a.a.a.g);
            TypedArray C02 = C0(resources, theme, attributeSet, b.w.a.a.a.k);
            ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
            long h0 = (long) h0(C0, xmlPullParser, "duration", 1, Strategy.TTL_SECONDS_DEFAULT);
            int i = 0;
            long h02 = (long) h0(C0, xmlPullParser, "startOffset", 2, 0);
            int h03 = h0(C0, xmlPullParser, "valueType", 7, 4);
            if (q0(xmlPullParser, "valueFrom") && q0(xmlPullParser, "valueTo")) {
                if (h03 == 4) {
                    TypedValue peekValue = C0.peekValue(5);
                    boolean z = peekValue != null;
                    int i2 = z ? peekValue.type : 0;
                    TypedValue peekValue2 = C0.peekValue(6);
                    boolean z2 = peekValue2 != null;
                    h03 = ((!z || !v0(i2)) && (!z2 || !v0(z2 ? peekValue2.type : 0))) ? 0 : 3;
                }
                PropertyValuesHolder j0 = j0(C0, h03, 5, 6, "");
                if (j0 != null) {
                    valueAnimator4.setValues(j0);
                }
            }
            valueAnimator4.setDuration(h0);
            valueAnimator4.setStartDelay(h02);
            valueAnimator4.setRepeatCount(h0(C0, xmlPullParser, "repeatCount", 3, 0));
            valueAnimator4.setRepeatMode(h0(C0, xmlPullParser, "repeatMode", 4, 1));
            if (C02 != null) {
                ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
                String i0 = i0(C02, xmlPullParser, "pathData", 1);
                if (i0 != null) {
                    String i02 = i0(C02, xmlPullParser, "propertyXName", 2);
                    String i03 = i0(C02, xmlPullParser, "propertyYName", 3);
                    if (i02 == null && i03 == null) {
                        throw new InflateException(C02.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                    }
                    Path P = P(i0);
                    float f3 = 0.5f * f2;
                    PathMeasure pathMeasure = new PathMeasure(P, false);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Float.valueOf(0.0f));
                    float f4 = 0.0f;
                    do {
                        f4 += pathMeasure.getLength();
                        arrayList.add(Float.valueOf(f4));
                    } while (pathMeasure.nextContour());
                    PathMeasure pathMeasure2 = new PathMeasure(P, false);
                    int min = Math.min(100, ((int) (f4 / f3)) + 1);
                    float[] fArr = new float[min];
                    float[] fArr2 = new float[min];
                    float[] fArr3 = new float[2];
                    float f5 = f4 / ((float) (min - 1));
                    valueAnimator2 = valueAnimator4;
                    typedArray = C0;
                    int i3 = 0;
                    float f6 = 0.0f;
                    while (true) {
                        propertyValuesHolder = null;
                        if (i >= min) {
                            break;
                        }
                        pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
                        fArr[i] = fArr3[0];
                        fArr2[i] = fArr3[1];
                        f6 += f5;
                        int i4 = i3 + 1;
                        if (i4 < arrayList.size() && f6 > ((Float) arrayList.get(i4)).floatValue()) {
                            pathMeasure2.nextContour();
                            i3 = i4;
                        }
                        i++;
                        min = min;
                    }
                    PropertyValuesHolder ofFloat = i02 != null ? PropertyValuesHolder.ofFloat(i02, fArr) : null;
                    if (i03 != null) {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(i03, fArr2);
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
                    typedArray = C0;
                    objectAnimator.setPropertyName(i0(C02, xmlPullParser, "propertyName", 0));
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = C0;
            }
            if (!q0(xmlPullParser, "interpolator")) {
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
            if (C02 != null) {
                C02.recycle();
            }
            return valueAnimator3;
        }

        public static void x1(Parcel parcel, int i, long j) {
            G1(parcel, i, 8);
            parcel.writeLong(j);
        }

        public static int y(RecyclerView.a0 a0Var, a0 a0Var2, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
            if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            int max = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.P(view), oVar.P(view2))) - 1) : Math.max(0, Math.min(oVar.P(view), oVar.P(view2)));
            if (!z) {
                return max;
            }
            return Math.round((((float) max) * (((float) Math.abs(a0Var2.b(view2) - a0Var2.e(view))) / ((float) (Math.abs(oVar.P(view) - oVar.P(view2)) + 1)))) + ((float) (a0Var2.k() - a0Var2.e(view))));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
            if (r17 == null) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            if (r17 != null) goto L_0x0079;
         */
        public static Typeface y0(Context context, int i, TypedValue typedValue, int i2, b.i.e.b.g gVar, Handler handler, boolean z) {
            Resources resources = context.getResources();
            resources.getValue(i, typedValue, true);
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                String charSequence2 = charSequence.toString();
                Typeface typeface = null;
                if (charSequence2.startsWith("res/")) {
                    Typeface a2 = b.i.f.d.f1055b.a(b.i.f.d.d(resources, i, i2));
                    if (a2 != null) {
                        if (gVar != null) {
                            gVar.b(a2, handler);
                        }
                        typeface = a2;
                    } else {
                        try {
                            if (charSequence2.toLowerCase().endsWith(".xml")) {
                                b.i.e.b.b J0 = J0(resources.getXml(i), resources);
                                if (J0 != null) {
                                    typeface = b.i.f.d.b(context, J0, resources, i, i2, gVar, handler, z);
                                } else if (gVar != null) {
                                    gVar.a(-3, handler);
                                }
                            } else {
                                Typeface c2 = b.i.f.d.c(context, resources, i, charSequence2, i2);
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
                    StringBuilder g2 = c.a.a.a.a.g("Font resource ID #0x");
                    g2.append(Integer.toHexString(i));
                    g2.append(" could not be retrieved.");
                    throw new Resources.NotFoundException(g2.toString());
                }
                gVar.a(-3, handler);
                if (typeface == null) {
                }
                return typeface;
            }
            StringBuilder g3 = c.a.a.a.a.g("Resource \"");
            g3.append(resources.getResourceName(i));
            g3.append("\" (");
            g3.append(Integer.toHexString(i));
            g3.append(") is not a Font: ");
            g3.append(typedValue);
            throw new Resources.NotFoundException(g3.toString());
        }

        public static void y1(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
            if (parcelable != null) {
                int C1 = C1(parcel, i);
                parcelable.writeToParcel(parcel, i2);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
        }

        public static int z(RecyclerView.a0 a0Var, a0 a0Var2, View view, View view2, RecyclerView.o oVar, boolean z) {
            if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return a0Var.b();
            }
            return (int) ((((float) (a0Var2.b(view2) - a0Var2.e(view))) / ((float) (Math.abs(oVar.P(view) - oVar.P(view2)) + 1))) * ((float) a0Var.b()));
        }

        public static int z0(int i, Rect rect, Rect rect2) {
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

        public static void z1(Parcel parcel, int i, String str, boolean z) {
            if (str != null) {
                int C1 = C1(parcel, i);
                parcel.writeString(str);
                F1(parcel, C1);
            } else if (z) {
                G1(parcel, i, 0);
            }
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
        public int f390a;

        /* renamed from: b  reason: collision with root package name */
        public int f391b;

        /* renamed from: c  reason: collision with root package name */
        public int f392c;

        /* renamed from: d  reason: collision with root package name */
        public int f393d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f394e;
        public View f;
        public View g;
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
            this.f390a = i2;
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
                    gVar.b(eVar, gVar.f540a);
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
                i.this.t(C.f390a, C, k);
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
        this.f370e = context;
        this.h = gVar;
        this.f369d = obj;
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
        if (this.N == -100 && (orDefault = a0.getOrDefault(this.f369d.getClass().getName(), null)) != null) {
            this.N = orDefault.intValue();
            a0.remove(this.f369d.getClass().getName());
        }
        if (window != null) {
            s(window);
        }
        b.b.q.j.e();
    }

    public final void A() {
        ViewGroup viewGroup;
        if (!this.u) {
            TypedArray obtainStyledAttributes = this.f370e.obtainStyledAttributes(b.b.j.AppCompatTheme);
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
                this.f.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.f370e);
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(this.C ? b.b.g.abc_screen_simple_overlay_action_mode : b.b.g.abc_screen_simple, (ViewGroup) null);
                } else if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(b.b.g.abc_dialog_title_material, (ViewGroup) null);
                    this.B = false;
                    this.A = false;
                } else if (this.A) {
                    TypedValue typedValue = new TypedValue();
                    this.f370e.getTheme().resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                    viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new b.b.p.c(this.f370e, typedValue.resourceId) : this.f370e).inflate(b.b.g.abc_screen_toolbar, (ViewGroup) null);
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
                    b.i.l.m.b0(viewGroup, new j(this));
                    if (this.l == null) {
                        this.w = (TextView) viewGroup.findViewById(b.b.f.title);
                    }
                    e1.b(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.b.f.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(16908290);
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
                    this.f.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new l(this));
                    this.v = viewGroup;
                    Object obj = this.f369d;
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
                    View decorView = this.f.getDecorView();
                    contentFrameLayout2.h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.f370e.obtainStyledAttributes(b.b.j.AppCompatTheme);
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
                StringBuilder g2 = c.a.a.a.a.g("AppCompat does not support the current theme features: { windowActionBar: ");
                g2.append(this.A);
                g2.append(", windowActionBarOverlay: ");
                g2.append(this.B);
                g2.append(", android:windowIsFloating: ");
                g2.append(this.D);
                g2.append(", windowActionModeOverlay: ");
                g2.append(this.C);
                g2.append(", windowNoTitle: ");
                g2.append(this.E);
                g2.append(" }");
                throw new IllegalArgumentException(g2.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void B() {
        if (this.f == null) {
            Object obj = this.f369d;
            if (obj instanceof Activity) {
                s(((Activity) obj).getWindow());
            }
        }
        if (this.f == null) {
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
            if (t.f429d == null) {
                Context applicationContext = context.getApplicationContext();
                t.f429d = new t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.R = new C0006i(t.f429d);
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
        return this.f.getCallback();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final void G() {
        a aVar;
        u uVar;
        A();
        if (this.A && this.i == null) {
            Object obj = this.f369d;
            if (obj instanceof Activity) {
                uVar = new u((Activity) this.f369d, this.B);
            } else {
                if (obj instanceof Dialog) {
                    uVar = new u((Dialog) this.f369d);
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
            b.i.l.m.M(this.f.getDecorView(), this.V);
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
            if (lVar.f390a == 0) {
                if ((this.f370e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback F2 = F();
            if (F2 == null || F2.onMenuOpened(lVar.f390a, lVar.h)) {
                WindowManager windowManager = (WindowManager) this.f370e.getSystemService("window");
                if (windowManager != null && L(lVar, keyEvent)) {
                    if (lVar.f394e == null || lVar.o) {
                        ViewGroup viewGroup = lVar.f394e;
                        ExpandedMenuView expandedMenuView = null;
                        if (viewGroup == null) {
                            G();
                            a aVar = this.i;
                            Context e2 = aVar != null ? aVar.e() : null;
                            if (e2 == null) {
                                e2 = this.f370e;
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
                            lVar.f391b = obtainStyledAttributes.getResourceId(b.b.j.AppCompatTheme_panelBackground, 0);
                            lVar.f393d = obtainStyledAttributes.getResourceId(b.b.j.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            lVar.f394e = new k(lVar.j);
                            lVar.f392c = 81;
                        } else if (lVar.o && viewGroup.getChildCount() > 0) {
                            lVar.f394e.removeAllViews();
                        }
                        View view = lVar.g;
                        if (view != null) {
                            lVar.f = view;
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
                                        gVar.b(eVar, gVar.f540a);
                                    }
                                    b.b.p.i.e eVar2 = lVar.i;
                                    ViewGroup viewGroup2 = lVar.f394e;
                                    if (eVar2.f533e == null) {
                                        eVar2.f533e = (ExpandedMenuView) eVar2.f531c.inflate(b.b.g.abc_expanded_menu_layout, viewGroup2, false);
                                        if (eVar2.j == null) {
                                            eVar2.j = new e.a();
                                        }
                                        eVar2.f533e.setAdapter((ListAdapter) eVar2.j);
                                        eVar2.f533e.setOnItemClickListener(eVar2);
                                    }
                                    expandedMenuView = eVar2.f533e;
                                }
                                lVar.f = expandedMenuView;
                            }
                            z2 = false;
                            if (z2) {
                                if (lVar.f != null && (lVar.g != null || ((e.a) lVar.i.a()).getCount() > 0)) {
                                    ViewGroup.LayoutParams layoutParams2 = lVar.f.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                    }
                                    lVar.f394e.setBackgroundResource(lVar.f391b);
                                    ViewParent parent = lVar.f.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(lVar.f);
                                    }
                                    lVar.f394e.addView(lVar.f, layoutParams2);
                                    if (!lVar.f.hasFocus()) {
                                        lVar.f.requestFocus();
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
                    View view2 = lVar.g;
                    if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        lVar.l = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams3.gravity = lVar.f392c;
                        layoutParams3.windowAnimations = lVar.f393d;
                        windowManager.addView(lVar.f394e, layoutParams3);
                        lVar.m = true;
                        return;
                    }
                    i2 = -2;
                    lVar.l = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams32.gravity = lVar.f392c;
                    layoutParams32.windowAnimations = lVar.f393d;
                    windowManager.addView(lVar.f394e, layoutParams32);
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
            lVar.g = F2.onCreatePanelView(lVar.f390a);
        }
        int i2 = lVar.f390a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (c0Var3 = this.l) != null) {
            c0Var3.f();
        }
        if (lVar.g == null && (!z2 || !(this.i instanceof r))) {
            if (lVar.h == null || lVar.p) {
                if (lVar.h == null) {
                    Context context = this.f370e;
                    int i3 = lVar.f390a;
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
                    gVar.f544e = this;
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
                if (!F2.onCreatePanelMenu(lVar.f390a, lVar.h)) {
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
            if (!F2.onPreparePanel(0, lVar.g, lVar.h)) {
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
        return this.u && (viewGroup = this.v) != null && b.i.l.m.B(viewGroup);
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
        int e2 = vVar != null ? vVar.e() : rect != null ? rect.top : 0;
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
                    rect2.set(vVar.c(), vVar.e(), vVar.d(), vVar.b());
                }
                ViewGroup viewGroup = this.v;
                Method method = e1.f628a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception unused) {
                    }
                }
                int i4 = rect2.top;
                int i5 = rect2.left;
                int i6 = rect2.right;
                v t2 = b.i.l.m.t(this.v);
                int c2 = t2.c();
                int d2 = t2.d();
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
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == c2 && marginLayoutParams2.rightMargin == d2)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = c2;
                            marginLayoutParams2.rightMargin = d2;
                            this.x.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f370e);
                    this.x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = c2;
                    layoutParams.rightMargin = d2;
                    this.v.addView(this.x, -1, layoutParams);
                }
                z2 = this.x != null;
                if (z2 && this.x.getVisibility() != 0) {
                    View view3 = this.x;
                    if ((view3.getWindowSystemUiVisibility() & RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        context = this.f370e;
                        i2 = b.b.c.abc_decor_view_status_guard_light;
                    } else {
                        context = this.f370e;
                        i2 = b.b.c.abc_decor_view_status_guard;
                    }
                    view3.setBackgroundColor(b.i.e.a.b(context, i2));
                }
                if (!this.C && z2) {
                    e2 = 0;
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
        return e2;
    }

    @Override // b.b.p.i.g.a
    public boolean a(b.b.p.i.g gVar, MenuItem menuItem) {
        l C2;
        Window.Callback F2 = F();
        if (F2 == null || this.M || (C2 = C(gVar.k())) == null) {
            return false;
        }
        return F2.onMenuItemSelected(C2.f390a, menuItem);
    }

    @Override // b.b.p.i.g.a
    public void b(b.b.p.i.g gVar) {
        c0 c0Var = this.l;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.f370e).hasPermanentMenuKey() && !this.l.b())) {
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
                this.f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            l E3 = E(0);
            b.b.p.i.g gVar2 = E3.h;
            if (gVar2 != null && !E3.p && F2.onPreparePanel(0, E3.g, gVar2)) {
                F2.onMenuOpened(108, E3.h);
                this.l.e();
            }
        }
    }

    @Override // b.b.k.h
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        A();
        ((ViewGroup) this.v.findViewById(16908290)).addView(view, layoutParams);
        this.g.f504b.onContentChanged();
    }

    @Override // b.b.k.h
    public void f() {
        LayoutInflater from = LayoutInflater.from(this.f370e);
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
        Object obj = this.f369d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = j.m0(activity, activity.getComponentName());
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
        synchronized (h.f368c) {
            h.j(this);
            h.f367b.add(new WeakReference<>(this));
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
        synchronized (h.f368c) {
            h.j(this);
        }
        if (this.T) {
            this.f.getDecorView().removeCallbacks(this.V);
        }
        this.L = false;
        this.M = true;
        if (this.N != -100) {
            Object obj = this.f369d;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                a0.put(this.f369d.getClass().getName(), Integer.valueOf(this.N));
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
        a0.remove(this.f369d.getClass().getName());
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
            return this.f.requestFeature(i2);
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
        LayoutInflater.from(this.f370e).inflate(i2, viewGroup);
        this.g.f504b.onContentChanged();
    }

    @Override // b.b.k.h
    public void m(View view) {
        A();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.g.f504b.onContentChanged();
    }

    @Override // b.b.k.h
    public void n(View view, ViewGroup.LayoutParams layoutParams) {
        A();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.g.f504b.onContentChanged();
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
            String string = this.f370e.obtainStyledAttributes(b.b.j.AppCompatTheme).getString(b.b.j.AppCompatTheme_viewInflaterClass);
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
            Context cVar = (resourceId == 0 || ((context instanceof b.b.p.c) && ((b.b.p.c) context).f470a == resourceId)) ? context : new b.b.p.c(context, resourceId);
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
                    view2 = new b.b.q.n(cVar, attributeSet, 0);
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
                    view2 = new b.b.q.w(cVar, attributeSet, b.b.a.spinnerStyle);
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
                    view2 = new b.b.q.o(cVar, attributeSet);
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
                    r8.f409a[0] = cVar;
                    r8.f409a[1] = attributeSet;
                    if (-1 == str.indexOf(46)) {
                        for (int i2 = 0; i2 < q.f407d.length; i2++) {
                            view2 = r8.g(cVar, str, q.f407d[i2]);
                            if (view2 == null) {
                            }
                        }
                        ?? r82 = r8.f409a;
                        r82[0] = r1;
                        r82[1] = r1;
                    } else {
                        View g2 = r8.g(cVar, str, r1);
                        ?? r83 = r8.f409a;
                        r83[0] = r1;
                        r83[1] = r1;
                        r1 = g2;
                    }
                } catch (Exception unused2) {
                } finally {
                    ?? r84 = r8.f409a;
                    r84[0] = r1;
                    r84[1] = r1;
                }
                if (r1 != 0) {
                    Context context2 = r1.getContext();
                    if ((context2 instanceof ContextWrapper) && b.i.l.m.x(r1)) {
                        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes((AttributeSet) attributeSet, q.f406c);
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
    public b.b.p.a p(a.AbstractC0009a aVar) {
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
                                Resources.Theme theme = this.f370e.getTheme();
                                theme.resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = this.f370e.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    b.b.p.c cVar2 = new b.b.p.c(this.f370e, 0);
                                    cVar2.getTheme().setTo(newTheme);
                                    cVar = cVar2;
                                } else {
                                    cVar = this.f370e;
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
                                        e2 = this.f370e;
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
                            if (eVar.f374a.c(dVar, dVar.i)) {
                                dVar.i();
                                this.p.f(dVar);
                                this.o = dVar;
                                if (M()) {
                                    this.p.setAlpha(0.0f);
                                    r a2 = b.i.l.m.a(this.p);
                                    a2.a(1.0f);
                                    this.s = a2;
                                    n nVar = new n(this);
                                    View view = a2.f1171a.get();
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
                                    this.f.getDecorView().post(this.r);
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
        int I2 = I(this.f370e, i2);
        Object obj2 = null;
        Configuration w2 = w(this.f370e, I2, null);
        boolean z6 = true;
        if (!this.Q && (this.f369d instanceof Activity)) {
            PackageManager packageManager = this.f370e.getPackageManager();
            if (packageManager == null) {
                z3 = false;
                int i3 = this.f370e.getResources().getConfiguration().uiMode & 48;
                int i4 = w2.uiMode & 48;
                if (i3 != i4 && z2 && !z3 && this.J && (d0 || this.K)) {
                    Object obj3 = this.f369d;
                    if ((obj3 instanceof Activity) && !((Activity) obj3).isChild()) {
                        b.i.d.a.j((Activity) this.f369d);
                        z4 = true;
                        if (!z4 || i3 == i4) {
                            z6 = z4;
                        } else {
                            Resources resources = this.f370e.getResources();
                            Configuration configuration = new Configuration(resources.getConfiguration());
                            configuration.uiMode = i4 | (resources.getConfiguration().uiMode & -49);
                            resources.updateConfiguration(configuration, null);
                            int i5 = Build.VERSION.SDK_INT;
                            if (i5 < 26 && i5 < 28) {
                                if (i5 >= 24) {
                                    if (!j.h) {
                                        try {
                                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                            j.g = declaredField;
                                            declaredField.setAccessible(true);
                                        } catch (NoSuchFieldException unused) {
                                        }
                                        j.h = true;
                                    }
                                    Field field = j.g;
                                    if (field != null) {
                                        try {
                                            obj = field.get(resources);
                                        } catch (IllegalAccessException unused2) {
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            if (!j.f386b) {
                                                try {
                                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                    j.f385a = declaredField2;
                                                    declaredField2.setAccessible(true);
                                                } catch (NoSuchFieldException unused3) {
                                                }
                                                j.f386b = true;
                                            }
                                            Field field2 = j.f385a;
                                            if (field2 != null) {
                                                try {
                                                    obj2 = field2.get(obj);
                                                } catch (IllegalAccessException unused4) {
                                                }
                                            }
                                            if (obj2 != null) {
                                                j.Z(obj2);
                                            }
                                        }
                                    }
                                } else {
                                    if (!j.f386b) {
                                        try {
                                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                            j.f385a = declaredField3;
                                            declaredField3.setAccessible(true);
                                        } catch (NoSuchFieldException unused5) {
                                        }
                                        j.f386b = true;
                                    }
                                    Field field3 = j.f385a;
                                    if (field3 != null) {
                                        try {
                                            obj2 = field3.get(resources);
                                        } catch (IllegalAccessException unused6) {
                                        }
                                    }
                                    if (obj2 != null) {
                                        j.Z(obj2);
                                    }
                                }
                            }
                            int i6 = this.O;
                            if (i6 != 0) {
                                this.f370e.setTheme(i6);
                                this.f370e.getTheme().applyStyle(this.O, true);
                            }
                            if (z3) {
                                Object obj4 = this.f369d;
                                if (obj4 instanceof Activity) {
                                    Activity activity = (Activity) obj4;
                                    if (activity instanceof b.n.i) {
                                        if (((b.n.j) ((b.n.i) activity).getLifecycle()).f1392b.compareTo((Enum) f.b.STARTED) >= 0) {
                                            z5 = true;
                                        }
                                    }
                                    activity.onConfigurationChanged(configuration);
                                }
                            }
                        }
                        if (z6) {
                            Object obj5 = this.f369d;
                            if (obj5 instanceof f) {
                                ((f) obj5).onNightModeChanged(I2);
                            }
                        }
                        if (i2 == 0) {
                            D(this.f370e).e();
                        } else {
                            h hVar = this.R;
                            if (hVar != null) {
                                hVar.a();
                            }
                        }
                        if (i2 == 3) {
                            Context context = this.f370e;
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
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f370e, this.f369d.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.P = (activityInfo == null || (activityInfo.configChanges & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused7) {
                this.P = false;
            }
        }
        this.Q = true;
        z3 = this.P;
        int i32 = this.f370e.getResources().getConfiguration().uiMode & 48;
        int i42 = w2.uiMode & 48;
        Object obj32 = this.f369d;
        b.i.d.a.j((Activity) this.f369d);
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
        if (this.f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof f)) {
                f fVar = new f(callback);
                this.g = fVar;
                window.setCallback(fVar);
                y0 p2 = y0.p(this.f370e, null, c0);
                Drawable h2 = p2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                p2.f759b.recycle();
                this.f = window;
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
            this.g.f504b.onPanelClosed(i2, menu);
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
        if (!z2 || lVar.f390a != 0 || (c0Var = this.l) == null || !c0Var.c()) {
            WindowManager windowManager = (WindowManager) this.f370e.getSystemService("window");
            if (!(windowManager == null || !lVar.m || (viewGroup = lVar.f394e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    t(lVar.f390a, lVar, null);
                }
            }
            lVar.k = false;
            lVar.l = false;
            lVar.m = false;
            lVar.f = null;
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
        Object obj = this.f369d;
        boolean z5 = true;
        if (((obj instanceof d.a) || (obj instanceof o)) && (decorView = this.f.getDecorView()) != null && b.i.l.m.e(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.g.f504b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & RecyclerView.d0.FLAG_IGNORE) == 0) {
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
            if (c0Var != null && c0Var.g() && !ViewConfiguration.get(this.f370e).hasPermanentMenuKey()) {
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
                if (!z3 && (audioManager = (AudioManager) this.f370e.getApplicationContext().getSystemService("audio")) != null) {
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
