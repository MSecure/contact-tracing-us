package e.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
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
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
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
import android.view.ContextThemeWrapper;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.appcompat.R$color;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import com.google.android.gms.common.api.Status;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.s;
import e.b.a.v;
import e.b.e.a;
import e.b.e.e;
import e.b.e.i.e;
import e.b.e.i.g;
import e.b.e.i.m;
import e.b.f.b1;
import e.b.f.c0;
import e.b.f.d1;
import e.b.f.e1;
import e.b.f.f1;
import e.b.f.n0;
import e.b.f.o;
import e.b.f.y0;
import e.g.b.b;
import e.g.b.h.d;
import e.g.b.h.l.n;
import e.i.a.g;
import e.i.b.b.h;
import e.i.g.b;
import e.i.i.e;
import e.i.i.s;
import e.i.i.u;
import e.m.a.m;
import e.p.b0;
import e.p.d0;
import e.p.h;
import e.p.q;
import e.t.g;
import e.z.d;
import f.a.b.b;
import f.a.b.t;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.p;
import f.b.a.a.a.p.w;
import f.b.a.a.a.s.a5;
import f.b.a.a.a.s.x5;
import f.b.a.a.a.u.r;
import f.b.a.a.a.v.d;
import f.b.a.b.h.e;
import f.b.a.d.a.d0;
import f.b.b.f.a.l;
import gov.co.cdphe.exposurenotifications.R;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class m extends l implements g.a, LayoutInflater.Factory2 {
    public static final e.e.h<String, Integer> Z = new e.e.h<>();
    public static final int[] a0 = {16842836};
    public static final boolean b0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean c0 = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public j[] F;
    public j G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M = -100;
    public int N;
    public boolean O;
    public boolean P;
    public f Q;
    public f R;
    public boolean S;
    public int T;
    public final Runnable U = new a();
    public boolean V;
    public Rect W;
    public Rect X;
    public s Y;

    /* renamed from: d  reason: collision with root package name */
    public final Object f648d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f649e;

    /* renamed from: f  reason: collision with root package name */
    public Window f650f;

    /* renamed from: g  reason: collision with root package name */
    public d f651g;

    /* renamed from: h  reason: collision with root package name */
    public final k f652h;

    /* renamed from: i  reason: collision with root package name */
    public a f653i;

    /* renamed from: j  reason: collision with root package name */
    public MenuInflater f654j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f655k;

    /* renamed from: l  reason: collision with root package name */
    public c0 f656l;
    public b m;
    public k n;
    public e.b.e.a o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public s s = null;
    public boolean t;
    public ViewGroup u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            m mVar = m.this;
            if ((mVar.T & 1) != 0) {
                mVar.I(0);
            }
            m mVar2 = m.this;
            if ((mVar2.T & 4096) != 0) {
                mVar2.I(108);
            }
            m mVar3 = m.this;
            mVar3.S = false;
            mVar3.T = 0;
        }
    }

    public final class b implements m.a {
        public b() {
        }

        @Override // e.b.e.i.m.a
        public void b(e.b.e.i.g gVar, boolean z) {
            m.this.E(gVar);
        }

        @Override // e.b.e.i.m.a
        public boolean c(e.b.e.i.g gVar) {
            Window.Callback P = m.this.P();
            if (P == null) {
                return true;
            }
            P.onMenuOpened(108, gVar);
            return true;
        }
    }

    public class c implements a.AbstractC0016a {
        public a.AbstractC0016a a;

        public class a extends u {
            public a() {
            }

            @Override // e.i.i.t
            public void a(View view) {
                m.this.p.setVisibility(8);
                m mVar = m.this;
                PopupWindow popupWindow = mVar.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (mVar.p.getParent() instanceof View) {
                    AtomicInteger atomicInteger = e.i.i.m.a;
                    ((View) m.this.p.getParent()).requestApplyInsets();
                }
                m.this.p.removeAllViews();
                m.this.s.d(null);
                m mVar2 = m.this;
                mVar2.s = null;
                ViewGroup viewGroup = mVar2.u;
                AtomicInteger atomicInteger2 = e.i.i.m.a;
                viewGroup.requestApplyInsets();
            }
        }

        public c(a.AbstractC0016a aVar) {
            this.a = aVar;
        }

        @Override // e.b.e.a.AbstractC0016a
        public boolean a(e.b.e.a aVar, Menu menu) {
            ViewGroup viewGroup = m.this.u;
            AtomicInteger atomicInteger = e.i.i.m.a;
            viewGroup.requestApplyInsets();
            return this.a.a(aVar, menu);
        }

        @Override // e.b.e.a.AbstractC0016a
        public boolean b(e.b.e.a aVar, MenuItem menuItem) {
            return this.a.b(aVar, menuItem);
        }

        @Override // e.b.e.a.AbstractC0016a
        public boolean c(e.b.e.a aVar, Menu menu) {
            return this.a.c(aVar, menu);
        }

        @Override // e.b.e.a.AbstractC0016a
        public void d(e.b.e.a aVar) {
            this.a.d(aVar);
            m mVar = m.this;
            if (mVar.q != null) {
                mVar.f650f.getDecorView().removeCallbacks(m.this.r);
            }
            m mVar2 = m.this;
            if (mVar2.p != null) {
                mVar2.J();
                m mVar3 = m.this;
                s b2 = e.i.i.m.b(mVar3.p);
                b2.a(0.0f);
                mVar3.s = b2;
                s sVar = m.this.s;
                a aVar2 = new a();
                View view = sVar.a.get();
                if (view != null) {
                    sVar.e(view, aVar2);
                }
            }
            m mVar4 = m.this;
            k kVar = mVar4.f652h;
            if (kVar != null) {
                kVar.j(mVar4.o);
            }
            m mVar5 = m.this;
            mVar5.o = null;
            ViewGroup viewGroup = mVar5.u;
            AtomicInteger atomicInteger = e.i.i.m.a;
            viewGroup.requestApplyInsets();
        }
    }

    public class e extends f {
        public final PowerManager c;

        public e(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // e.b.a.m.f
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // e.b.a.m.f
        public int c() {
            return this.c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // e.b.a.m.f
        public void d() {
            m.this.A();
        }
    }

    public abstract class f {
        public BroadcastReceiver a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                f.this.d();
            }
        }

        public f() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    m.this.f649e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.a == null) {
                    this.a = new a();
                }
                m.this.f649e.registerReceiver(this.a, b2);
            }
        }
    }

    public class g extends f {
        public final v c;

        public g(v vVar) {
            super();
            this.c = vVar;
        }

        @Override // e.b.a.m.f
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00fb A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        @Override // e.b.a.m.f
        public int c() {
            boolean z;
            Location location;
            long j2;
            v vVar = this.c;
            v.a aVar = vVar.c;
            boolean z2 = false;
            if (!(aVar.b > System.currentTimeMillis())) {
                Location location2 = null;
                if (h.q(vVar.a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (vVar.b.isProviderEnabled("network")) {
                            location = vVar.b.getLastKnownLocation("network");
                            if (h.q(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                try {
                                    if (vVar.b.isProviderEnabled("gps")) {
                                        location2 = vVar.b.getLastKnownLocation("gps");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                                location = location2;
                            }
                            if (location == null) {
                                v.a aVar2 = vVar.c;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (u.f687d == null) {
                                    u.f687d = new u();
                                }
                                u uVar = u.f687d;
                                uVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                                uVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                                if (uVar.c == 1) {
                                    z2 = true;
                                }
                                long j3 = uVar.b;
                                long j4 = uVar.a;
                                uVar.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                                long j5 = uVar.b;
                                if (j3 == -1 || j4 == -1) {
                                    j2 = 43200000 + currentTimeMillis;
                                } else {
                                    j2 = (currentTimeMillis > j4 ? j5 + 0 : currentTimeMillis > j3 ? j4 + 0 : j3 + 0) + 60000;
                                }
                                aVar2.a = z2;
                                aVar2.b = j2;
                            } else {
                                int i2 = Calendar.getInstance().get(11);
                                if (i2 < 6 || i2 >= 22) {
                                    z2 = true;
                                }
                                z = z2;
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
                if (h.q(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            z = aVar.a;
            if (!z) {
            }
        }

        @Override // e.b.a.m.f
        public void d() {
            m.this.A();
        }
    }

    public static class h {
        public static Field a;
        public static boolean b;
        public static Class<?> c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f659d;

        /* renamed from: e  reason: collision with root package name */
        public static Field f660e;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f661f;

        /* renamed from: g  reason: collision with root package name */
        public static Field f662g;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f663h;

        /* renamed from: i  reason: collision with root package name */
        public static Method f664i;

        /* renamed from: j  reason: collision with root package name */
        public static boolean f665j;

        /* renamed from: k  reason: collision with root package name */
        public static Method f666k;

        /* renamed from: l  reason: collision with root package name */
        public static boolean f667l;
        public static Field m;
        public static boolean n;
        public static Method o;
        public static boolean p;
        public static Field q;
        public static boolean r;
        public static long s;
        public static Method t;

        @RecentlyNonNull
        public static Bundle A(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            Bundle readBundle = parcel.readBundle();
            parcel.setDataPosition(dataPosition + b1);
            return readBundle;
        }

        public static boolean A0(h0 h0Var) {
            return (h0Var != null ? h0Var.e() : -1) > 0;
        }

        public static boolean A1(d.a aVar, d.a aVar2, d.a aVar3, d.a aVar4) {
            d.a aVar5 = d.a.MATCH_PARENT;
            d.a aVar6 = d.a.WRAP_CONTENT;
            d.a aVar7 = d.a.FIXED;
            return (aVar3 == aVar7 || aVar3 == aVar6 || (aVar3 == aVar5 && aVar != aVar6)) || (aVar4 == aVar7 || aVar4 == aVar6 || (aVar4 == aVar5 && aVar2 != aVar6));
        }

        @RecentlyNonNull
        public static byte[] B(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            parcel.setDataPosition(dataPosition + b1);
            return createByteArray;
        }

        public static boolean B0() {
            try {
                if (t == null) {
                    return Trace.isEnabled();
                }
            } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            }
            try {
                if (t == null) {
                    s = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    t = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) t.invoke(null, Long.valueOf(s))).booleanValue();
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

        @RecentlyNonNull
        public static int B1(@RecentlyNonNull Parcel parcel) {
            int readInt = parcel.readInt();
            int b1 = b1(parcel, readInt);
            int dataPosition = parcel.dataPosition();
            if ((65535 & readInt) != 20293) {
                String valueOf = String.valueOf(Integer.toHexString(readInt));
                throw new f.b.a.c.b.m.n.b(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
            }
            int i2 = b1 + dataPosition;
            if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
                return i2;
            }
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i2);
            throw new f.b.a.c.b.m.n.b(sb.toString(), parcel);
        }

        @RecentlyNonNull
        public static ArrayList<Double> C(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            ArrayList<Double> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                arrayList.add(Double.valueOf(parcel.readDouble()));
            }
            parcel.setDataPosition(dataPosition + b1);
            return arrayList;
        }

        public static boolean C0(Context context) {
            if (context.getResources().getBoolean(R.bool.enx_enableTextMessageVerification) && !TextUtils.isEmpty(context.getString(R.string.enx_testVerificationNotificationBody))) {
                p pVar = p.V2;
                if (pVar.equals(pVar)) {
                    return true;
                }
            }
            return false;
        }

        public static Drawable C1(Drawable drawable) {
            return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof e.i.c.l.a)) ? new e.i.c.l.d(drawable) : drawable;
        }

        public static ColorStateList D(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
            int next;
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return E(resources, xmlPullParser, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static void D0(Context context) {
            Intent L = L(context);
            if (L != null) {
                context.startActivity(L);
                return;
            }
            throw new UnsupportedOperationException("This device does not support storage management");
        }

        public static ActionMode.Callback D1(TextView textView, ActionMode.Callback callback) {
            int i2 = Build.VERSION.SDK_INT;
            return (i2 < 26 || i2 > 27 || (callback instanceof e.i.j.e)) ? callback : new e.i.j.e(callback, textView);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
            if (r8.hasValue(r12) != false) goto L_0x006d;
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static ColorStateList E(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            int depth;
            String name = xmlPullParser.getName();
            if (name.equals("selector")) {
                int i2 = 1;
                int depth2 = xmlPullParser.getDepth() + 1;
                int[][] iArr = new int[20][];
                int[] iArr2 = new int[20];
                int i3 = 0;
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == i2 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                        int[] iArr3 = new int[i3];
                        int[][] iArr4 = new int[i3][];
                        System.arraycopy(iArr2, 0, iArr3, 0, i3);
                        System.arraycopy(iArr, 0, iArr4, 0, i3);
                    } else {
                        if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                            int[] iArr5 = R$styleable.ColorStateListItem;
                            TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr5) : theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                            int color = obtainAttributes.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                            float f2 = 1.0f;
                            int i4 = R$styleable.ColorStateListItem_android_alpha;
                            if (!obtainAttributes.hasValue(i4)) {
                                i4 = R$styleable.ColorStateListItem_alpha;
                            }
                            f2 = obtainAttributes.getFloat(i4, 1.0f);
                            obtainAttributes.recycle();
                            int attributeCount = attributeSet.getAttributeCount();
                            int[] iArr6 = new int[attributeCount];
                            int i5 = 0;
                            for (int i6 = 0; i6 < attributeCount; i6++) {
                                int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                                if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R$attr.alpha)) {
                                    int i7 = i5 + 1;
                                    if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                                        attributeNameResource = -attributeNameResource;
                                    }
                                    iArr6[i5] = attributeNameResource;
                                    i5 = i7;
                                }
                            }
                            int[] trimStateSet = StateSet.trimStateSet(iArr6, i5);
                            int round = (Math.round(((float) Color.alpha(color)) * f2) << 24) | (color & 16777215);
                            int i8 = i3 + 1;
                            int i9 = 8;
                            if (i8 > iArr2.length) {
                                int[] iArr7 = new int[(i3 <= 4 ? 8 : i3 * 2)];
                                System.arraycopy(iArr2, 0, iArr7, 0, i3);
                                iArr2 = iArr7;
                            }
                            iArr2[i3] = round;
                            if (i8 > iArr.length) {
                                Class<?> componentType = iArr.getClass().getComponentType();
                                if (i3 > 4) {
                                    i9 = i3 * 2;
                                }
                                ?? r8 = (Object[]) Array.newInstance(componentType, i9);
                                System.arraycopy(iArr, 0, r8, 0, i3);
                                iArr = r8;
                            }
                            iArr[i3] = trimStateSet;
                            iArr = iArr;
                            i3 = i8;
                        }
                        i2 = 1;
                    }
                }
                int[] iArr32 = new int[i3];
                int[][] iArr42 = new int[i3][];
                System.arraycopy(iArr2, 0, iArr32, 0, i3);
                System.arraycopy(iArr, 0, iArr42, 0, i3);
                return new ColorStateList(iArr42, iArr32);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }

        public static e.m.a.v E0(Context context, e.m.a.m mVar, boolean z) {
            int i2;
            m.d dVar = mVar.I;
            boolean z2 = false;
            int i3 = dVar == null ? 0 : dVar.f1460d;
            int t2 = mVar.t();
            mVar.w0(0);
            ViewGroup viewGroup = mVar.E;
            if (viewGroup != null) {
                int i4 = R$id.visible_removing_fragment_view_tag;
                if (viewGroup.getTag(i4) != null) {
                    mVar.E.setTag(i4, null);
                }
            }
            ViewGroup viewGroup2 = mVar.E;
            if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
                return null;
            }
            Animation N = mVar.N();
            if (N != null) {
                return new e.m.a.v(N);
            }
            Animator O = mVar.O();
            if (O != null) {
                return new e.m.a.v(O);
            }
            if (t2 == 0 && i3 != 0) {
                if (i3 == 4097) {
                    i2 = z ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
                } else if (i3 == 4099) {
                    i2 = z ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
                } else if (i3 != 8194) {
                    t2 = -1;
                } else {
                    i2 = z ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
                }
                t2 = i2;
            }
            if (t2 != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(t2));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, t2);
                        if (loadAnimation != null) {
                            return new e.m.a.v(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, t2);
                        if (loadAnimator != null) {
                            return new e.m.a.v(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, t2);
                            if (loadAnimation2 != null) {
                                return new e.m.a.v(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            return null;
        }

        public static void E1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Bundle bundle, @RecentlyNonNull boolean z) {
            if (bundle != null) {
                int O1 = O1(parcel, i2);
                parcel.writeBundle(bundle);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static int[] F(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            int[] createIntArray = parcel.createIntArray();
            parcel.setDataPosition(dataPosition + b1);
            return createIntArray;
        }

        public static int F0(int i2, Rect rect, Rect rect2) {
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

        public static void F1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z) {
            if (bArr != null) {
                int O1 = O1(parcel, i2);
                parcel.writeByteArray(bArr);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static ArrayList<Integer> G(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            parcel.setDataPosition(dataPosition + b1);
            return arrayList;
        }

        public static <X, Y> LiveData<Y> G0(LiveData<X> liveData, e.c.a.c.a<X, Y> aVar) {
            q qVar = new q();
            qVar.m(liveData, new b0(qVar, aVar));
            return qVar;
        }

        public static void G1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<Double> list, @RecentlyNonNull boolean z) {
            int O1 = O1(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeDouble(list.get(i3).doubleValue());
            }
            T1(parcel, O1);
        }

        public static Snackbar H(View view, int i2) {
            Snackbar j2 = Snackbar.j(view, view.getContext().getString(i2), 0);
            ((TextView) j2.c.findViewById(R.id.snackbar_text)).setMaxLines(5);
            return j2;
        }

        public static void H0(Context context, View view) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        public static void H1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z) {
            if (iBinder != null) {
                int O1 = O1(parcel, i2);
                parcel.writeStrongBinder(iBinder);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
            if (r13 == false) goto L_0x008d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ NumberFormatException -> 0x00ba }, LOOP:3: B:25:0x006d->B:45:0x0098, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d7 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0097 A[SYNTHETIC] */
        public static e.i.c.c[] I(String str) {
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
                        trim = str.substring(i4, i3).trim();
                        if (trim.length() > 0) {
                            if (trim.charAt(i2) == 'z' || trim.charAt(i2) == 'Z') {
                                fArr = new float[i2];
                            } else {
                                try {
                                    float[] fArr2 = new float[trim.length()];
                                    int length = trim.length();
                                    int i5 = 1;
                                    int i6 = 0;
                                    while (i5 < length) {
                                        boolean z = false;
                                        boolean z2 = false;
                                        boolean z3 = false;
                                        boolean z4 = false;
                                        int i7 = i5;
                                        while (true) {
                                            if (i7 < trim.length()) {
                                                char charAt2 = trim.charAt(i7);
                                                if (charAt2 != ' ') {
                                                    if (charAt2 == 'E' || charAt2 == 'e') {
                                                        z4 = true;
                                                        if (!z) {
                                                            i7++;
                                                        }
                                                    } else {
                                                        switch (charAt2) {
                                                            case '-':
                                                                if (i7 != i5) {
                                                                }
                                                                break;
                                                            case '.':
                                                                if (!z3) {
                                                                    z3 = true;
                                                                    break;
                                                                }
                                                                z2 = true;
                                                                break;
                                                        }
                                                        z4 = false;
                                                        if (!z) {
                                                        }
                                                    }
                                                }
                                                z = true;
                                                z4 = false;
                                                if (!z) {
                                                }
                                            }
                                        }
                                        if (i5 < i7) {
                                            fArr2[i6] = Float.parseFloat(trim.substring(i5, i7));
                                            i6++;
                                        }
                                        if (!z2) {
                                            i7++;
                                        }
                                        i5 = i7;
                                        i2 = 0;
                                    }
                                    fArr = x(fArr2, i2, i6);
                                    i2 = 0;
                                } catch (NumberFormatException e2) {
                                    throw new RuntimeException(f.a.a.a.a.d("error in parsing \"", trim, "\""), e2);
                                }
                            }
                            arrayList.add(new e.i.c.c(trim.charAt(i2), fArr));
                        }
                        i4 = i3;
                        i3++;
                        i2 = 0;
                    }
                    i3++;
                }
                trim = str.substring(i4, i3).trim();
                if (trim.length() > 0) {
                }
                i4 = i3;
                i3++;
                i2 = 0;
            }
            if (i3 - i4 == 1 && i4 < str.length()) {
                arrayList.add(new e.i.c.c(str.charAt(i4), new float[0]));
            }
            return (e.i.c.c[]) arrayList.toArray(new e.i.c.c[arrayList.size()]);
        }

        public static void I0(View view, String str) {
            if (view != null && !TextUtils.isEmpty(str)) {
                Snackbar.j(view, str, 0).l();
            }
        }

        public static void I1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z) {
            if (iArr != null) {
                int O1 = O1(parcel, i2);
                parcel.writeIntArray(iArr);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static <T extends Parcelable> T J(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            T createFromParcel = creator.createFromParcel(parcel);
            parcel.setDataPosition(dataPosition + b1);
            return createFromParcel;
        }

        public static int J0(int i2, Rect rect, Rect rect2) {
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

        public static void J1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<Integer> list, @RecentlyNonNull boolean z) {
            int O1 = O1(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            T1(parcel, O1);
        }

        public static Path K(String str) {
            Path path = new Path();
            e.i.c.c[] I = I(str);
            if (I == null) {
                return null;
            }
            try {
                e.i.c.c.b(I, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException(f.a.a.a.a.c("Error in parsing ", str), e2);
            }
        }

        public static ByteBuffer K0(Context context, CancellationSignal cancellationSignal, Uri uri) {
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

        public static void K1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i3, @RecentlyNonNull boolean z) {
            if (parcelable != null) {
                int O1 = O1(parcel, i2);
                parcelable.writeToParcel(parcel, i3);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        public static Intent L(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 25) {
                Intent intent = new Intent("android.os.storage.action.MANAGE_STORAGE");
                if (intent.resolveActivity(packageManager) != null) {
                    return intent;
                }
            }
            Intent intent2 = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
            if (intent2.resolveActivity(packageManager) != null) {
                return intent2;
            }
            return null;
        }

        public static <T> ObjectAnimator L0(T t2, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path);
        }

        public static void L1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
            if (str != null) {
                int O1 = O1(parcel, i2);
                parcel.writeString(str);
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static String M(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            String readString = parcel.readString();
            parcel.setDataPosition(dataPosition + b1);
            return readString;
        }

        public static InputConnection M0(InputConnection inputConnection, EditorInfo editorInfo, View view) {
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

        public static <T extends Parcelable> void M1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i3, @RecentlyNonNull boolean z) {
            if (tArr != null) {
                int O1 = O1(parcel, i2);
                int length = tArr.length;
                parcel.writeInt(length);
                for (T t2 : tArr) {
                    if (t2 == null) {
                        parcel.writeInt(0);
                    } else {
                        R1(parcel, t2, i3);
                    }
                }
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static <T> T[] N(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            T[] tArr = (T[]) parcel.createTypedArray(creator);
            parcel.setDataPosition(dataPosition + b1);
            return tArr;
        }

        public static e.i.b.b.b N0(XmlPullParser xmlPullParser, Resources resources) {
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
                    TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
                    String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
                    String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
                    String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
                    int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
                    int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
                    int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
                    obtainAttributes.recycle();
                    if (string == null || string2 == null || string3 == null) {
                        ArrayList arrayList = new ArrayList();
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (xmlPullParser.getName().equals("font")) {
                                    TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
                                    int i2 = R$styleable.FontFamilyFont_fontWeight;
                                    if (!obtainAttributes2.hasValue(i2)) {
                                        i2 = R$styleable.FontFamilyFont_android_fontWeight;
                                    }
                                    int i3 = obtainAttributes2.getInt(i2, 400);
                                    int i4 = R$styleable.FontFamilyFont_fontStyle;
                                    if (!obtainAttributes2.hasValue(i4)) {
                                        i4 = R$styleable.FontFamilyFont_android_fontStyle;
                                    }
                                    boolean z = 1 == obtainAttributes2.getInt(i4, 0);
                                    int i5 = R$styleable.FontFamilyFont_ttcIndex;
                                    if (!obtainAttributes2.hasValue(i5)) {
                                        i5 = R$styleable.FontFamilyFont_android_ttcIndex;
                                    }
                                    int i6 = R$styleable.FontFamilyFont_fontVariationSettings;
                                    if (!obtainAttributes2.hasValue(i6)) {
                                        i6 = R$styleable.FontFamilyFont_android_fontVariationSettings;
                                    }
                                    String string4 = obtainAttributes2.getString(i6);
                                    int i7 = obtainAttributes2.getInt(i5, 0);
                                    int i8 = R$styleable.FontFamilyFont_font;
                                    if (!obtainAttributes2.hasValue(i8)) {
                                        i8 = R$styleable.FontFamilyFont_android_font;
                                    }
                                    int resourceId2 = obtainAttributes2.getResourceId(i8, 0);
                                    String string5 = obtainAttributes2.getString(i8);
                                    obtainAttributes2.recycle();
                                    while (xmlPullParser.next() != 3) {
                                        p1(xmlPullParser);
                                    }
                                    arrayList.add(new e.i.b.b.d(string5, i3, z, string4, i7, resourceId2));
                                } else {
                                    p1(xmlPullParser);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new e.i.b.b.c((e.i.b.b.d[]) arrayList.toArray(new e.i.b.b.d[arrayList.size()]));
                    }
                    while (xmlPullParser.next() != 3) {
                        p1(xmlPullParser);
                    }
                    return new e.i.b.b.e(new e.i.f.a(string, string2, string3, W0(resources, resourceId)), integer, integer2);
                }
                p1(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static <T extends Parcelable> void N1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z) {
            if (list != null) {
                int O1 = O1(parcel, i2);
                int size = list.size();
                parcel.writeInt(size);
                for (int i3 = 0; i3 < size; i3++) {
                    T t2 = list.get(i3);
                    if (t2 == null) {
                        parcel.writeInt(0);
                    } else {
                        R1(parcel, t2, 0);
                    }
                }
                T1(parcel, O1);
            } else if (z) {
                S1(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static <T> ArrayList<T> O(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(dataPosition + b1);
            return createTypedArrayList;
        }

        public static b.a O0(f.a.b.k kVar) {
            long j2;
            long j3;
            boolean z;
            long j4;
            long j5;
            long j6;
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> map = kVar.c;
            String str = map.get("Date");
            long Q0 = str != null ? Q0(str) : 0;
            String str2 = map.get("Cache-Control");
            int i2 = 0;
            if (str2 != null) {
                String[] split = str2.split(",", 0);
                int i3 = 0;
                j3 = 0;
                j2 = 0;
                while (i2 < split.length) {
                    String trim = split[i2].trim();
                    if (trim.equals("no-cache") || trim.equals("no-store")) {
                        return null;
                    }
                    if (trim.startsWith("max-age=")) {
                        try {
                            j3 = Long.parseLong(trim.substring(8));
                        } catch (Exception unused) {
                        }
                    } else if (trim.startsWith("stale-while-revalidate=")) {
                        j2 = Long.parseLong(trim.substring(23));
                    } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                        i3 = 1;
                    }
                    i2++;
                }
                i2 = i3;
                z = true;
            } else {
                z = false;
                j3 = 0;
                j2 = 0;
            }
            String str3 = map.get("Expires");
            long Q02 = str3 != null ? Q0(str3) : 0;
            String str4 = map.get("Last-Modified");
            long Q03 = str4 != null ? Q0(str4) : 0;
            String str5 = map.get("ETag");
            if (z) {
                j5 = currentTimeMillis + (j3 * 1000);
                if (i2 != 0) {
                    j6 = j5;
                } else {
                    Long.signum(j2);
                    j6 = (j2 * 1000) + j5;
                }
                j4 = j6;
            } else {
                j4 = 0;
                if (Q0 <= 0 || Q02 < Q0) {
                    j5 = 0;
                } else {
                    j5 = currentTimeMillis + (Q02 - Q0);
                    j4 = j5;
                }
            }
            b.a aVar = new b.a();
            aVar.a = kVar.b;
            aVar.b = str5;
            aVar.f2025e = j5;
            aVar.f2024d = j4;
            aVar.c = Q03;
            aVar.f2026f = map;
            aVar.f2027g = kVar.f2037d;
            return aVar;
        }

        public static int O1(Parcel parcel, int i2) {
            parcel.writeInt(i2 | -65536);
            parcel.writeInt(0);
            return parcel.dataPosition();
        }

        public static void P(String str, String str2, Object obj) {
            s0(str);
            String.format(str2, obj);
        }

        public static String P0(Map<String, String> map, String str) {
            String str2 = map.get("Content-Type");
            if (str2 != null) {
                String[] split = str2.split(";", 0);
                for (int i2 = 1; i2 < split.length; i2++) {
                    String[] split2 = split[i2].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
            return str;
        }

        public static String P1(String str, String str2) {
            int length = str.length() - str2.length();
            if (length < 0 || length > 1) {
                throw new IllegalArgumentException("Invalid input received");
            }
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                sb.append(str.charAt(i2));
                if (str2.length() > i2) {
                    sb.append(str2.charAt(i2));
                }
            }
            return sb.toString();
        }

        public static <T extends e.t.g> g.a<T> Q(Context context, Class<T> cls, String str) {
            if (str.trim().length() != 0) {
                return new g.a<>(context, cls, str);
            }
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }

        public static long Q0(String str) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException unused) {
                f.a.b.v.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
        }

        public static void Q1(Parcel parcel, int i2, int i3) {
            int b1 = b1(parcel, i2);
            if (b1 != i3) {
                String hexString = Integer.toHexString(b1);
                StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
                sb.append("Expected size ");
                sb.append(i3);
                sb.append(" got ");
                sb.append(b1);
                sb.append(" (0x");
                sb.append(hexString);
                sb.append(")");
                throw new f.b.a.c.b.m.n.b(sb.toString(), parcel);
            }
        }

        public static e.i.c.c[] R(e.i.c.c[] cVarArr) {
            if (cVarArr == null) {
                return null;
            }
            e.i.c.c[] cVarArr2 = new e.i.c.c[cVarArr.length];
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                cVarArr2[i2] = new e.i.c.c(cVarArr[i2]);
            }
            return cVarArr2;
        }

        public static ExposureNotificationDatabase R0(f.b.a.a.a.b0.v vVar, Context context) {
            Objects.requireNonNull(vVar);
            g.a Q = Q(context.getApplicationContext(), ExposureNotificationDatabase.class, "exposurenotification");
            Q.a(ExposureNotificationDatabase.t);
            int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
            if (Q.f1716l == null) {
                Q.f1716l = new HashSet(34);
            }
            for (int i2 = 0; i2 < 34; i2++) {
                Q.f1716l.add(Integer.valueOf(iArr[i2]));
            }
            return (ExposureNotificationDatabase) Q.b();
        }

        public static <T extends Parcelable> void R1(Parcel parcel, T t2, int i2) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            t2.writeToParcel(parcel, i2);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }

        public static <X> LiveData<X> S(LiveData<X> liveData) {
            q qVar = new q();
            qVar.m(liveData, new d0(qVar));
            return qVar;
        }

        public static f.b.a.b.f<f.b.a.a.a.v.c> S0(w wVar, Context context) {
            f.b.a.b.f<f.b.a.a.a.v.c> a2;
            synchronized (wVar) {
                f.b.a.b.i.m.b(context);
                a2 = ((f.b.a.b.i.j) f.b.a.b.i.m.a().c(f.b.a.b.h.a.f2470g)).a("1537", f.b.a.a.a.v.c.class, new f.b.a.b.b("proto"), f.b.a.a.a.p.p.a);
            }
            return a2;
        }

        public static void S1(Parcel parcel, int i2, int i3) {
            if (i3 >= 65535) {
                parcel.writeInt(i2 | -65536);
                parcel.writeInt(i3);
                return;
            }
            parcel.writeInt(i2 | (i3 << 16));
        }

        public static void T(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            if (parcel.dataPosition() != i2) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Overread allowed size end=");
                sb.append(i2);
                throw new f.b.a.c.b.m.n.b(sb.toString(), parcel);
            }
        }

        public static f.b.a.a.a.i.f0.a T0(f.b.a.a.a.i.f0.b bVar) {
            Objects.requireNonNull(bVar);
            return new f.b.a.a.a.i.f0.c();
        }

        public static void T1(Parcel parcel, int i2) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i2 - 4);
            parcel.writeInt(dataPosition - i2);
            parcel.setDataPosition(dataPosition);
        }

        @RecentlyNonNull
        public static boolean U(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        public static d0.a U0(r rVar) {
            Objects.requireNonNull(rVar);
            return new f.b.a.a.a.u.f(rVar);
        }

        public static n V(e.g.b.h.d dVar, int i2, ArrayList<n> arrayList, n nVar) {
            e.g.b.h.c cVar;
            int i3;
            int i4 = i2 == 0 ? dVar.j0 : dVar.k0;
            int i5 = 0;
            if (i4 != -1 && (nVar == null || i4 != nVar.b)) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    n nVar2 = arrayList.get(i6);
                    if (nVar2.b == i4) {
                        if (nVar != null) {
                            nVar.d(i2, nVar2);
                            arrayList.remove(nVar);
                        }
                        nVar = nVar2;
                    } else {
                        i6++;
                    }
                }
            } else if (i4 != -1) {
                return nVar;
            }
            if (nVar == null) {
                if (dVar instanceof e.g.b.h.h) {
                    e.g.b.h.h hVar = (e.g.b.h.h) dVar;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= hVar.m0) {
                            i3 = -1;
                            break;
                        }
                        e.g.b.h.d dVar2 = hVar.l0[i7];
                        if ((i2 == 0 && (i3 = dVar2.j0) != -1) || (i2 == 1 && (i3 = dVar2.k0) != -1)) {
                            break;
                        }
                        i7++;
                    }
                    if (i3 != -1) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= arrayList.size()) {
                                break;
                            }
                            n nVar3 = arrayList.get(i8);
                            if (nVar3.b == i3) {
                                nVar = nVar3;
                                break;
                            }
                            i8++;
                        }
                    }
                }
                if (nVar == null) {
                    nVar = new n(i2);
                }
                arrayList.add(nVar);
            }
            if (nVar.a(dVar)) {
                if (dVar instanceof e.g.b.h.f) {
                    e.g.b.h.f fVar = (e.g.b.h.f) dVar;
                    e.g.b.h.c cVar2 = fVar.o0;
                    if (fVar.p0 == 0) {
                        i5 = 1;
                    }
                    cVar2.b(i5, arrayList, nVar);
                }
                if (i2 == 0) {
                    dVar.j0 = nVar.b;
                    dVar.D.b(i2, arrayList, nVar);
                    cVar = dVar.F;
                } else {
                    dVar.k0 = nVar.b;
                    dVar.E.b(i2, arrayList, nVar);
                    dVar.H.b(i2, arrayList, nVar);
                    cVar = dVar.G;
                }
                cVar.b(i2, arrayList, nVar);
                dVar.K.b(i2, arrayList, nVar);
            }
            return nVar;
        }

        @RecentlyNonNull
        public static boolean V0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            Q1(parcel, i2, 4);
            return parcel.readInt() != 0;
        }

        public static n W(ArrayList<n> arrayList, int i2) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                n nVar = arrayList.get(i3);
                if (i2 == nVar.b) {
                    return nVar;
                }
            }
            return null;
        }

        public static List<List<byte[]>> W0(Resources resources, int i2) {
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
                            arrayList.add(s1(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(s1(resources.getStringArray(i2)));
                }
                obtainTypedArray.recycle();
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x001f A[SYNTHETIC] */
        public static NavController X(View view) {
            NavController navController;
            NavController navController2;
            View view2 = view;
            while (true) {
                navController = null;
                if (view2 == null) {
                    break;
                }
                Object tag = view2.getTag(androidx.navigation.R$id.nav_controller_view_tag);
                if (tag instanceof WeakReference) {
                    tag = ((WeakReference) tag).get();
                } else if (!(tag instanceof NavController)) {
                    navController2 = null;
                    if (navController2 == null) {
                        navController = navController2;
                        break;
                    }
                    ViewParent parent = view2.getParent();
                    view2 = parent instanceof View ? (View) parent : null;
                }
                navController2 = (NavController) tag;
                if (navController2 == null) {
                }
            }
            if (navController != null) {
                return navController;
            }
            throw new IllegalStateException("View " + view + " does not have a NavController set");
        }

        @RecentlyNonNull
        public static double X0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            Q1(parcel, i2, 8);
            return parcel.readDouble();
        }

        public static void Y(Object obj) {
            if (!f659d) {
                try {
                    c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException unused) {
                }
                f659d = true;
            }
            Class<?> cls = c;
            if (cls != null) {
                if (!f661f) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        f660e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused2) {
                    }
                    f661f = true;
                }
                Field field = f660e;
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

        @RecentlyNonNull
        public static IBinder Y0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int b1 = b1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (b1 == 0) {
                return null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(dataPosition + b1);
            return readStrongBinder;
        }

        public static long Z(l.b.a.e eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.G();
        }

        @RecentlyNonNull
        public static int Z0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            Q1(parcel, i2, 4);
            return parcel.readInt();
        }

        public static JSONObject a(JSONObject jSONObject) {
            int length = jSONObject.toString().getBytes().length;
            int i2 = 1;
            while (length < 5000) {
                jSONObject.put("padding", f.b.a.a.a.i.b0.c(i2));
                length = jSONObject.toString().getBytes().length;
                i2++;
            }
            return jSONObject;
        }

        public static String a0(h0.c cVar) {
            if (cVar == null) {
                return null;
            }
            return cVar.name();
        }

        @RecentlyNonNull
        public static long a1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            Q1(parcel, i2, 8);
            return parcel.readLong();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:176:0x02d1, code lost:
            if (r3[r17].f1085f.f1083d == r9) goto L_0x02d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0149, code lost:
            if (r4[r2].f1085f.f1083d == r5) goto L_0x014d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:184:0x02ee  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x0353  */
        /* JADX WARNING: Removed duplicated region for block: B:213:0x037b  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x038b  */
        /* JADX WARNING: Removed duplicated region for block: B:250:0x0482 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:271:0x04eb A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:304:0x055c  */
        /* JADX WARNING: Removed duplicated region for block: B:305:0x0569  */
        /* JADX WARNING: Removed duplicated region for block: B:312:0x0582  */
        /* JADX WARNING: Removed duplicated region for block: B:315:0x058c  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x059f  */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x05aa  */
        /* JADX WARNING: Removed duplicated region for block: B:326:0x05b6  */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x05b9  */
        /* JADX WARNING: Removed duplicated region for block: B:331:0x05d7  */
        /* JADX WARNING: Removed duplicated region for block: B:338:0x05eb  */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x05f8  */
        /* JADX WARNING: Removed duplicated region for block: B:367:0x0655  */
        /* JADX WARNING: Removed duplicated region for block: B:368:0x065d  */
        /* JADX WARNING: Removed duplicated region for block: B:371:0x066a  */
        /* JADX WARNING: Removed duplicated region for block: B:372:0x066d  */
        /* JADX WARNING: Removed duplicated region for block: B:387:0x06c9  */
        /* JADX WARNING: Removed duplicated region for block: B:403:0x0726  */
        /* JADX WARNING: Removed duplicated region for block: B:404:0x0729  */
        /* JADX WARNING: Removed duplicated region for block: B:407:0x072f  */
        /* JADX WARNING: Removed duplicated region for block: B:408:0x0732  */
        /* JADX WARNING: Removed duplicated region for block: B:411:0x0738  */
        /* JADX WARNING: Removed duplicated region for block: B:415:0x0747  */
        /* JADX WARNING: Removed duplicated region for block: B:417:0x074a  */
        /* JADX WARNING: Removed duplicated region for block: B:442:0x05d9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x014f  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
        public static void b(e.g.b.h.e eVar, e.g.b.d dVar, ArrayList<e.g.b.h.d> arrayList, int i2) {
            int i3;
            e.g.b.h.b[] bVarArr;
            int i4;
            int i5;
            int i6;
            d.a aVar;
            boolean z;
            int i7;
            boolean z2;
            boolean z3;
            boolean z4;
            e.g.b.h.d dVar2;
            e.g.b.h.d dVar3;
            e.g.b.h.d dVar4;
            e.g.b.h.c cVar;
            int i8;
            e.g.b.h.c cVar2;
            e.g.b.g gVar;
            e.g.b.g gVar2;
            int i9;
            e.g.b.h.d dVar5;
            e.g.b.h.c cVar3;
            int i10;
            e.g.b.h.d dVar6;
            int i11;
            int i12;
            e.g.b.h.d dVar7;
            e.g.b.h.d dVar8;
            e.g.b.g gVar3;
            e.g.b.g gVar4;
            e.g.b.h.c cVar4;
            e.g.b.h.c cVar5;
            e.g.b.h.d dVar9;
            e.g.b.h.d dVar10;
            int d2;
            e.g.b.h.c cVar6;
            e.g.b.g gVar5;
            e.g.b.h.c cVar7;
            e.g.b.g gVar6;
            int i13;
            e.g.b.h.c cVar8;
            int size;
            int i14;
            ArrayList<e.g.b.h.d> arrayList2;
            int i15;
            e.g.b.h.b bVar;
            d.a aVar2;
            e.g.b.g gVar7;
            int i16;
            int i17;
            e.g.b.g gVar8;
            e.g.b.h.d dVar11;
            b.a aVar3;
            int i18;
            e.g.b.h.d dVar12;
            e.g.b.h.d dVar13;
            int i19;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            e.g.b.h.c cVar9;
            e.g.b.h.d dVar14;
            e.g.b.h.e eVar2 = eVar;
            ArrayList<e.g.b.h.d> arrayList3 = arrayList;
            d.a aVar4 = d.a.MATCH_CONSTRAINT;
            if (i2 == 0) {
                i4 = eVar2.t0;
                bVarArr = eVar2.w0;
                i3 = 0;
            } else {
                i4 = eVar2.u0;
                bVarArr = eVar2.v0;
                i3 = 2;
            }
            int i20 = 0;
            while (i20 < i4) {
                e.g.b.h.b bVar2 = bVarArr[i20];
                e.g.b.g gVar9 = null;
                int i21 = 8;
                int i22 = 1;
                if (!bVar2.t) {
                    int i23 = bVar2.o * 2;
                    e.g.b.h.d dVar15 = bVar2.a;
                    e.g.b.h.d dVar16 = dVar15;
                    boolean z9 = false;
                    while (!z9) {
                        bVar2.f1079i += i22;
                        e.g.b.h.d[] dVarArr = dVar15.i0;
                        int i24 = bVar2.o;
                        dVarArr[i24] = null;
                        dVar15.h0[i24] = null;
                        if (dVar15.c0 != i21) {
                            bVar2.f1082l += i22;
                            if (dVar15.k(i24) != aVar4) {
                                int i25 = bVar2.m;
                                int i26 = bVar2.o;
                                bVar2.m = i25 + (i26 == 0 ? dVar15.r() : i26 == i22 ? dVar15.l() : 0);
                            }
                            int d3 = dVar15.L[i23].d() + bVar2.m;
                            bVar2.m = d3;
                            int i27 = i23 + 1;
                            bVar2.m = dVar15.L[i27].d() + d3;
                            int d4 = dVar15.L[i23].d() + bVar2.n;
                            bVar2.n = d4;
                            bVar2.n = dVar15.L[i27].d() + d4;
                            if (bVar2.b == null) {
                                bVar2.b = dVar15;
                            }
                            bVar2.f1074d = dVar15;
                            d.a[] aVarArr = dVar15.O;
                            int i28 = bVar2.o;
                            if (aVarArr[i28] == aVar4) {
                                int[] iArr = dVar15.n;
                                if (iArr[i28] == 0 || iArr[i28] == 3 || iArr[i28] == 2) {
                                    bVar2.f1080j++;
                                    float[] fArr = dVar15.g0;
                                    float f2 = fArr[i28];
                                    if (f2 > 0.0f) {
                                        z8 = z9;
                                        bVar2.f1081k += fArr[i28];
                                    } else {
                                        z8 = z9;
                                    }
                                    if (dVar15.c0 != 8 && aVarArr[i28] == aVar4 && (iArr[i28] == 0 || iArr[i28] == 3)) {
                                        if (f2 < 0.0f) {
                                            bVar2.q = true;
                                        } else {
                                            bVar2.r = true;
                                        }
                                        if (bVar2.f1078h == null) {
                                            bVar2.f1078h = new ArrayList<>();
                                        }
                                        bVar2.f1078h.add(dVar15);
                                    }
                                    if (bVar2.f1076f == null) {
                                        bVar2.f1076f = dVar15;
                                    }
                                    e.g.b.h.d dVar17 = bVar2.f1077g;
                                    if (dVar17 != null) {
                                        dVar17.h0[bVar2.o] = dVar15;
                                    }
                                    bVar2.f1077g = dVar15;
                                } else {
                                    z8 = z9;
                                }
                                int i29 = bVar2.o;
                                if (dVar16 != dVar15) {
                                    dVar16.i0[bVar2.o] = dVar15;
                                }
                                cVar9 = dVar15.L[i23 + 1].f1085f;
                                if (cVar9 != null) {
                                    dVar14 = cVar9.f1083d;
                                    e.g.b.h.c[] cVarArr = dVar14.L;
                                    if (cVarArr[i23].f1085f != null) {
                                    }
                                }
                                dVar14 = null;
                                if (dVar14 == null) {
                                    z9 = z8;
                                } else {
                                    dVar14 = dVar15;
                                    z9 = true;
                                }
                                dVar16 = dVar15;
                                i22 = 1;
                                i21 = 8;
                                dVar15 = dVar14;
                            }
                        }
                        z8 = z9;
                        if (dVar16 != dVar15) {
                        }
                        cVar9 = dVar15.L[i23 + 1].f1085f;
                        if (cVar9 != null) {
                        }
                        dVar14 = null;
                        if (dVar14 == null) {
                        }
                        dVar16 = dVar15;
                        i22 = 1;
                        i21 = 8;
                        dVar15 = dVar14;
                    }
                    e.g.b.h.d dVar18 = bVar2.b;
                    if (dVar18 != null) {
                        bVar2.m -= dVar18.L[i23].d();
                    }
                    e.g.b.h.d dVar19 = bVar2.f1074d;
                    if (dVar19 != null) {
                        bVar2.m -= dVar19.L[i23 + 1].d();
                    }
                    bVar2.c = dVar15;
                    if (bVar2.o != 0 || !bVar2.p) {
                        bVar2.f1075e = bVar2.a;
                    } else {
                        bVar2.f1075e = dVar15;
                    }
                    bVar2.s = bVar2.r && bVar2.q;
                }
                bVar2.t = true;
                if (arrayList3 == null || arrayList3.contains(bVar2.a)) {
                    e.g.b.h.d dVar20 = bVar2.a;
                    e.g.b.h.d dVar21 = bVar2.c;
                    e.g.b.h.d dVar22 = bVar2.b;
                    e.g.b.h.d dVar23 = bVar2.f1074d;
                    e.g.b.h.d dVar24 = bVar2.f1075e;
                    float f3 = bVar2.f1081k;
                    boolean z10 = eVar2.O[i2] == d.a.WRAP_CONTENT;
                    if (i2 == 0) {
                        int i30 = dVar24.e0;
                        boolean z11 = i30 == 0;
                        i7 = i20;
                        z5 = i30 == 1;
                        if (i30 == 2) {
                            z7 = z11;
                        } else {
                            z6 = z11;
                            z = z5;
                            z2 = z6;
                            z3 = false;
                            e.g.b.h.d dVar25 = dVar20;
                            z4 = false;
                            while (!z4) {
                                e.g.b.h.c cVar10 = dVar25.L[i3];
                                int i31 = z3 ? 1 : 4;
                                int d5 = cVar10.d();
                                boolean z12 = dVar25.O[i2] == aVar4 && dVar25.n[i2] == 0;
                                e.g.b.h.c cVar11 = cVar10.f1085f;
                                if (!(cVar11 == null || dVar25 == dVar20)) {
                                    d5 = cVar11.d() + d5;
                                }
                                if (!z3 || dVar25 == dVar20 || dVar25 == dVar22) {
                                    i18 = i4;
                                } else {
                                    i18 = i4;
                                    i31 = 8;
                                }
                                e.g.b.h.c cVar12 = cVar10.f1085f;
                                if (cVar12 != null) {
                                    if (dVar25 == dVar22) {
                                        dVar12 = dVar20;
                                        dVar.f(cVar10.f1088i, cVar12.f1088i, d5, 6);
                                    } else {
                                        dVar12 = dVar20;
                                        dVar.f(cVar10.f1088i, cVar12.f1088i, d5, 8);
                                    }
                                    dVar.d(cVar10.f1088i, cVar10.f1085f.f1088i, d5, (!z12 || z3) ? i31 : 5);
                                } else {
                                    dVar12 = dVar20;
                                }
                                if (z10) {
                                    if (dVar25.c0 == 8 || dVar25.O[i2] != aVar4) {
                                        i19 = 0;
                                    } else {
                                        e.g.b.h.c[] cVarArr2 = dVar25.L;
                                        i19 = 0;
                                        dVar.f(cVarArr2[i3 + 1].f1088i, cVarArr2[i3].f1088i, 0, 5);
                                    }
                                    dVar.f(dVar25.L[i3].f1088i, eVar2.L[i3].f1088i, i19, 8);
                                }
                                e.g.b.h.c cVar13 = dVar25.L[i3 + 1].f1085f;
                                if (cVar13 != null) {
                                    dVar13 = cVar13.f1083d;
                                    e.g.b.h.c[] cVarArr3 = dVar13.L;
                                    if (cVarArr3[i3].f1085f != null) {
                                    }
                                }
                                dVar13 = null;
                                if (dVar13 != null) {
                                    dVar25 = dVar13;
                                    z4 = z4;
                                } else {
                                    z4 = true;
                                }
                                i4 = i18;
                                dVar24 = dVar24;
                                dVar20 = dVar12;
                            }
                            i5 = i4;
                            if (dVar23 != null) {
                                int i32 = i3 + 1;
                                if (dVar21.L[i32].f1085f != null) {
                                    e.g.b.h.c cVar14 = dVar23.L[i32];
                                    if ((dVar23.O[i2] == aVar4 && dVar23.n[i2] == 0) && !z3) {
                                        e.g.b.h.c cVar15 = cVar14.f1085f;
                                        if (cVar15.f1083d == eVar2) {
                                            dVar.d(cVar14.f1088i, cVar15.f1088i, -cVar14.d(), 5);
                                            dVar.g(cVar14.f1088i, dVar21.L[i32].f1085f.f1088i, -cVar14.d(), 6);
                                            if (z10) {
                                                int i33 = i3 + 1;
                                                e.g.b.g gVar10 = eVar2.L[i33].f1088i;
                                                e.g.b.h.c[] cVarArr4 = dVar21.L;
                                                dVar.f(gVar10, cVarArr4[i33].f1088i, cVarArr4[i33].d(), 8);
                                            }
                                            ArrayList<e.g.b.h.d> arrayList4 = bVar2.f1078h;
                                            if (arrayList4 != null && (size = arrayList4.size()) > 1) {
                                                float f4 = (bVar2.q || bVar2.s) ? f3 : (float) bVar2.f1080j;
                                                e.g.b.h.d dVar26 = null;
                                                float f5 = 0.0f;
                                                i14 = 0;
                                                while (i14 < size) {
                                                    e.g.b.h.d dVar27 = arrayList4.get(i14);
                                                    float f6 = dVar27.g0[i2];
                                                    if (f6 < 0.0f) {
                                                        if (bVar2.s) {
                                                            e.g.b.h.c[] cVarArr5 = dVar27.L;
                                                            e.g.b.g gVar11 = cVarArr5[i3 + 1].f1088i;
                                                            gVar8 = cVarArr5[i3].f1088i;
                                                            aVar2 = aVar4;
                                                            gVar7 = gVar11;
                                                            i17 = 0;
                                                            i16 = 4;
                                                            dVar.d(gVar7, gVar8, i17, i16);
                                                            bVar = bVar2;
                                                            arrayList2 = arrayList4;
                                                            i15 = size;
                                                            i14++;
                                                            aVar4 = aVar2;
                                                            bVar2 = bVar;
                                                            size = i15;
                                                            arrayList4 = arrayList2;
                                                        } else {
                                                            f6 = 1.0f;
                                                        }
                                                    }
                                                    int i34 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                                                    if (i34 == 0) {
                                                        e.g.b.h.c[] cVarArr6 = dVar27.L;
                                                        e.g.b.g gVar12 = cVarArr6[i3 + 1].f1088i;
                                                        gVar8 = cVarArr6[i3].f1088i;
                                                        aVar2 = aVar4;
                                                        gVar7 = gVar12;
                                                        i17 = 0;
                                                        i16 = 8;
                                                        dVar.d(gVar7, gVar8, i17, i16);
                                                        bVar = bVar2;
                                                        arrayList2 = arrayList4;
                                                        i15 = size;
                                                        i14++;
                                                        aVar4 = aVar2;
                                                        bVar2 = bVar;
                                                        size = i15;
                                                        arrayList4 = arrayList2;
                                                    } else {
                                                        aVar2 = aVar4;
                                                        if (dVar26 != null) {
                                                            e.g.b.h.c[] cVarArr7 = dVar26.L;
                                                            e.g.b.g gVar13 = cVarArr7[i3].f1088i;
                                                            int i35 = i3 + 1;
                                                            e.g.b.g gVar14 = cVarArr7[i35].f1088i;
                                                            e.g.b.h.c[] cVarArr8 = dVar27.L;
                                                            arrayList2 = arrayList4;
                                                            e.g.b.g gVar15 = cVarArr8[i3].f1088i;
                                                            e.g.b.g gVar16 = cVarArr8[i35].f1088i;
                                                            i15 = size;
                                                            e.g.b.b m2 = dVar.m();
                                                            dVar11 = dVar27;
                                                            m2.b = 0.0f;
                                                            bVar = bVar2;
                                                            float f7 = -1.0f;
                                                            if (f4 == 0.0f || f5 == f6) {
                                                                m2.f1044d.c(gVar13, 1.0f);
                                                                m2.f1044d.c(gVar14, -1.0f);
                                                                m2.f1044d.c(gVar16, 1.0f);
                                                                aVar3 = m2.f1044d;
                                                            } else {
                                                                if (f5 == 0.0f) {
                                                                    m2.f1044d.c(gVar13, 1.0f);
                                                                    m2.f1044d.c(gVar14, -1.0f);
                                                                } else if (i34 == 0) {
                                                                    m2.f1044d.c(gVar15, 1.0f);
                                                                    m2.f1044d.c(gVar16, -1.0f);
                                                                } else {
                                                                    float f8 = (f5 / f4) / (f6 / f4);
                                                                    m2.f1044d.c(gVar13, 1.0f);
                                                                    m2.f1044d.c(gVar14, -1.0f);
                                                                    m2.f1044d.c(gVar16, f8);
                                                                    aVar3 = m2.f1044d;
                                                                    f7 = -f8;
                                                                }
                                                                dVar.c(m2);
                                                            }
                                                            aVar3.c(gVar15, f7);
                                                            dVar.c(m2);
                                                        } else {
                                                            bVar = bVar2;
                                                            arrayList2 = arrayList4;
                                                            i15 = size;
                                                            dVar11 = dVar27;
                                                        }
                                                        f5 = f6;
                                                        dVar26 = dVar11;
                                                        i14++;
                                                        aVar4 = aVar2;
                                                        bVar2 = bVar;
                                                        size = i15;
                                                        arrayList4 = arrayList2;
                                                    }
                                                }
                                            }
                                            aVar = aVar4;
                                            if (dVar22 != null || (dVar22 != dVar23 && !z3)) {
                                                dVar4 = dVar23;
                                                dVar3 = dVar22;
                                                i9 = i7;
                                                if (z2 || dVar3 == null) {
                                                    int i36 = 8;
                                                    if (z && dVar3 != null) {
                                                        int i37 = bVar2.f1080j;
                                                        boolean z13 = i37 <= 0 && bVar2.f1079i == i37;
                                                        e.g.b.h.d dVar28 = dVar3;
                                                        dVar5 = dVar28;
                                                        while (dVar5 != null) {
                                                            e.g.b.h.d dVar29 = dVar5.i0[i2];
                                                            while (dVar29 != null && dVar29.c0 == i36) {
                                                                dVar29 = dVar29.i0[i2];
                                                            }
                                                            if (dVar5 == dVar3 || dVar5 == dVar4 || dVar29 == null) {
                                                                dVar6 = dVar28;
                                                                i11 = i9;
                                                                i12 = 8;
                                                                dVar7 = dVar29;
                                                            } else {
                                                                e.g.b.h.d dVar30 = dVar29 == dVar4 ? null : dVar29;
                                                                e.g.b.h.c cVar16 = dVar5.L[i3];
                                                                e.g.b.g gVar17 = cVar16.f1088i;
                                                                int i38 = i3 + 1;
                                                                e.g.b.g gVar18 = dVar28.L[i38].f1088i;
                                                                int d6 = cVar16.d();
                                                                int d7 = dVar5.L[i38].d();
                                                                if (dVar30 != null) {
                                                                    cVar4 = dVar30.L[i3];
                                                                    gVar3 = cVar4.f1088i;
                                                                    dVar8 = dVar30;
                                                                    cVar5 = cVar4.f1085f;
                                                                    if (cVar5 == null) {
                                                                        gVar4 = null;
                                                                        int d8 = cVar4 == null ? cVar4.d() + d7 : d7;
                                                                        int d9 = dVar28.L[i38].d() + d6;
                                                                        int i39 = !z13 ? 8 : 4;
                                                                        if (gVar17 != null || gVar18 == null || gVar3 == null || gVar4 == null) {
                                                                            dVar6 = dVar28;
                                                                            i11 = i9;
                                                                            i12 = 8;
                                                                        } else {
                                                                            dVar6 = dVar28;
                                                                            i11 = i9;
                                                                            i12 = 8;
                                                                            dVar.b(gVar17, gVar18, d9, 0.5f, gVar3, gVar4, d8, i39);
                                                                        }
                                                                        dVar7 = dVar8;
                                                                    }
                                                                } else {
                                                                    dVar8 = dVar30;
                                                                    cVar4 = dVar4.L[i3];
                                                                    gVar3 = cVar4 != null ? cVar4.f1088i : null;
                                                                    cVar5 = dVar5.L[i38];
                                                                }
                                                                gVar4 = cVar5.f1088i;
                                                                if (cVar4 == null) {
                                                                }
                                                                int d92 = dVar28.L[i38].d() + d6;
                                                                if (!z13) {
                                                                }
                                                                if (gVar17 != null) {
                                                                }
                                                                dVar6 = dVar28;
                                                                i11 = i9;
                                                                i12 = 8;
                                                                dVar7 = dVar8;
                                                            }
                                                            if (dVar5.c0 != i12) {
                                                                dVar6 = dVar5;
                                                            }
                                                            dVar5 = dVar7;
                                                            i9 = i11;
                                                            dVar28 = dVar6;
                                                            i36 = 8;
                                                        }
                                                        i6 = i9;
                                                        e.g.b.h.c cVar17 = dVar3.L[i3];
                                                        cVar3 = dVar20.L[i3].f1085f;
                                                        int i40 = i3 + 1;
                                                        e.g.b.h.c cVar18 = dVar4.L[i40];
                                                        e.g.b.h.c cVar19 = dVar21.L[i40].f1085f;
                                                        if (cVar3 != null) {
                                                            if (dVar3 != dVar4) {
                                                                dVar.d(cVar17.f1088i, cVar3.f1088i, cVar17.d(), 5);
                                                            } else if (cVar19 != null) {
                                                                dVar2 = dVar21;
                                                                i10 = 5;
                                                                dVar.b(cVar17.f1088i, cVar3.f1088i, cVar17.d(), 0.5f, cVar18.f1088i, cVar19.f1088i, cVar18.d(), 5);
                                                                if (!(cVar19 == null || dVar3 == dVar4)) {
                                                                    dVar.d(cVar18.f1088i, cVar19.f1088i, -cVar18.d(), i10);
                                                                }
                                                                if (!(!(z2 || z) || dVar3 == null || dVar3 == dVar4)) {
                                                                    e.g.b.h.c[] cVarArr9 = dVar3.L;
                                                                    cVar = cVarArr9[i3];
                                                                    i8 = i3 + 1;
                                                                    cVar2 = dVar4.L[i8];
                                                                    e.g.b.h.c cVar20 = cVar.f1085f;
                                                                    gVar = cVar20 == null ? cVar20.f1088i : null;
                                                                    e.g.b.h.c cVar21 = cVar2.f1085f;
                                                                    e.g.b.g gVar19 = cVar21 == null ? cVar21.f1088i : null;
                                                                    if (dVar2 == dVar4) {
                                                                        e.g.b.h.c cVar22 = dVar2.L[i8].f1085f;
                                                                        if (cVar22 != null) {
                                                                            gVar9 = cVar22.f1088i;
                                                                        }
                                                                        gVar2 = gVar9;
                                                                    } else {
                                                                        gVar2 = gVar19;
                                                                    }
                                                                    if (dVar3 == dVar4) {
                                                                        cVar = cVarArr9[i3];
                                                                        cVar2 = cVarArr9[i8];
                                                                    }
                                                                    if (!(gVar == null || gVar2 == null)) {
                                                                        dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        dVar2 = dVar21;
                                                        i10 = 5;
                                                        dVar.d(cVar18.f1088i, cVar19.f1088i, -cVar18.d(), i10);
                                                        e.g.b.h.c[] cVarArr92 = dVar3.L;
                                                        cVar = cVarArr92[i3];
                                                        i8 = i3 + 1;
                                                        cVar2 = dVar4.L[i8];
                                                        e.g.b.h.c cVar202 = cVar.f1085f;
                                                        if (cVar202 == null) {
                                                        }
                                                        e.g.b.h.c cVar212 = cVar2.f1085f;
                                                        if (cVar212 == null) {
                                                        }
                                                        if (dVar2 == dVar4) {
                                                        }
                                                        if (dVar3 == dVar4) {
                                                        }
                                                        dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                                                    }
                                                } else {
                                                    int i41 = bVar2.f1080j;
                                                    boolean z14 = i41 > 0 && bVar2.f1079i == i41;
                                                    e.g.b.h.d dVar31 = dVar3;
                                                    for (e.g.b.h.d dVar32 = dVar31; dVar32 != null; dVar32 = dVar9) {
                                                        e.g.b.h.d dVar33 = dVar32.i0[i2];
                                                        while (true) {
                                                            if (dVar33 == null) {
                                                                break;
                                                            }
                                                            if (dVar33.c0 != 8) {
                                                                break;
                                                            }
                                                            dVar33 = dVar33.i0[i2];
                                                        }
                                                        if (dVar33 != null || dVar32 == dVar4) {
                                                            e.g.b.h.c cVar23 = dVar32.L[i3];
                                                            e.g.b.g gVar20 = cVar23.f1088i;
                                                            e.g.b.h.c cVar24 = cVar23.f1085f;
                                                            e.g.b.g gVar21 = cVar24 != null ? cVar24.f1088i : null;
                                                            if (dVar31 != dVar32) {
                                                                cVar8 = dVar31.L[i3 + 1];
                                                            } else {
                                                                if (dVar32 == dVar3 && dVar31 == dVar32) {
                                                                    e.g.b.h.c[] cVarArr10 = dVar20.L;
                                                                    if (cVarArr10[i3].f1085f != null) {
                                                                        cVar8 = cVarArr10[i3].f1085f;
                                                                    } else {
                                                                        gVar21 = null;
                                                                    }
                                                                }
                                                                d2 = cVar23.d();
                                                                int i42 = i3 + 1;
                                                                int d10 = dVar32.L[i42].d();
                                                                if (dVar33 == null) {
                                                                    e.g.b.h.c cVar25 = dVar33.L[i3];
                                                                    gVar5 = cVar25.f1088i;
                                                                    cVar6 = cVar25;
                                                                    cVar7 = dVar32.L[i42];
                                                                } else {
                                                                    e.g.b.h.c cVar26 = dVar21.L[i42].f1085f;
                                                                    if (cVar26 != null) {
                                                                        gVar5 = cVar26.f1088i;
                                                                        cVar6 = cVar26;
                                                                    } else {
                                                                        cVar6 = cVar26;
                                                                        gVar5 = null;
                                                                    }
                                                                    cVar7 = dVar32.L[i42];
                                                                }
                                                                gVar6 = cVar7.f1088i;
                                                                if (cVar6 != null) {
                                                                    d10 += cVar6.d();
                                                                }
                                                                i13 = d10;
                                                                if (dVar31 != null) {
                                                                    d2 += dVar31.L[i42].d();
                                                                }
                                                                if (!(gVar20 == null || gVar21 == null || gVar5 == null || gVar6 == null)) {
                                                                    if (dVar32 == dVar3) {
                                                                        d2 = dVar3.L[i3].d();
                                                                    }
                                                                    if (dVar32 == dVar4) {
                                                                        i13 = dVar4.L[i42].d();
                                                                    }
                                                                    dVar9 = dVar33;
                                                                    dVar10 = dVar31;
                                                                    dVar.b(gVar20, gVar21, d2, 0.5f, gVar5, gVar6, i13, !z14 ? 8 : 5);
                                                                    if (dVar32.c0 != 8) {
                                                                        dVar10 = dVar32;
                                                                    }
                                                                    dVar31 = dVar10;
                                                                }
                                                            }
                                                            gVar21 = cVar8.f1088i;
                                                            d2 = cVar23.d();
                                                            int i422 = i3 + 1;
                                                            int d102 = dVar32.L[i422].d();
                                                            if (dVar33 == null) {
                                                            }
                                                            gVar6 = cVar7.f1088i;
                                                            if (cVar6 != null) {
                                                            }
                                                            i13 = d102;
                                                            if (dVar31 != null) {
                                                            }
                                                            if (dVar32 == dVar3) {
                                                            }
                                                            if (dVar32 == dVar4) {
                                                            }
                                                            dVar9 = dVar33;
                                                            dVar10 = dVar31;
                                                            dVar.b(gVar20, gVar21, d2, 0.5f, gVar5, gVar6, i13, !z14 ? 8 : 5);
                                                            if (dVar32.c0 != 8) {
                                                            }
                                                            dVar31 = dVar10;
                                                        }
                                                        dVar9 = dVar33;
                                                        dVar10 = dVar31;
                                                        if (dVar32.c0 != 8) {
                                                        }
                                                        dVar31 = dVar10;
                                                    }
                                                }
                                            } else {
                                                e.g.b.h.c cVar27 = dVar20.L[i3];
                                                int i43 = i3 + 1;
                                                e.g.b.h.c cVar28 = dVar21.L[i43];
                                                e.g.b.h.c cVar29 = cVar27.f1085f;
                                                e.g.b.g gVar22 = cVar29 != null ? cVar29.f1088i : null;
                                                e.g.b.h.c cVar30 = cVar28.f1085f;
                                                e.g.b.g gVar23 = cVar30 != null ? cVar30.f1088i : null;
                                                e.g.b.h.c cVar31 = dVar22.L[i3];
                                                e.g.b.h.c cVar32 = dVar23.L[i43];
                                                if (gVar22 == null || gVar23 == null) {
                                                    dVar4 = dVar23;
                                                    dVar3 = dVar22;
                                                    i9 = i7;
                                                } else {
                                                    dVar4 = dVar23;
                                                    dVar3 = dVar22;
                                                    i9 = i7;
                                                    dVar.b(cVar31.f1088i, gVar22, cVar31.d(), i2 == 0 ? dVar24.Z : dVar24.a0, gVar23, cVar32.f1088i, cVar32.d(), 7);
                                                }
                                            }
                                            dVar2 = dVar21;
                                            i6 = i9;
                                            e.g.b.h.c[] cVarArr922 = dVar3.L;
                                            cVar = cVarArr922[i3];
                                            i8 = i3 + 1;
                                            cVar2 = dVar4.L[i8];
                                            e.g.b.h.c cVar2022 = cVar.f1085f;
                                            if (cVar2022 == null) {
                                            }
                                            e.g.b.h.c cVar2122 = cVar2.f1085f;
                                            if (cVar2122 == null) {
                                            }
                                            if (dVar2 == dVar4) {
                                            }
                                            if (dVar3 == dVar4) {
                                            }
                                            dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                                        }
                                    }
                                    if (z3) {
                                        e.g.b.h.c cVar33 = cVar14.f1085f;
                                        if (cVar33.f1083d == eVar2) {
                                            dVar.d(cVar14.f1088i, cVar33.f1088i, -cVar14.d(), 4);
                                            dVar.g(cVar14.f1088i, dVar21.L[i32].f1085f.f1088i, -cVar14.d(), 6);
                                            if (z10) {
                                            }
                                            ArrayList<e.g.b.h.d> arrayList42 = bVar2.f1078h;
                                            if (bVar2.q) {
                                            }
                                            e.g.b.h.d dVar262 = null;
                                            float f52 = 0.0f;
                                            i14 = 0;
                                            while (i14 < size) {
                                            }
                                            aVar = aVar4;
                                            if (dVar22 != null) {
                                            }
                                            dVar4 = dVar23;
                                            dVar3 = dVar22;
                                            i9 = i7;
                                            if (z2) {
                                            }
                                            int i362 = 8;
                                            int i372 = bVar2.f1080j;
                                            if (i372 <= 0) {
                                            }
                                            e.g.b.h.d dVar282 = dVar3;
                                            dVar5 = dVar282;
                                            while (dVar5 != null) {
                                            }
                                            i6 = i9;
                                            e.g.b.h.c cVar172 = dVar3.L[i3];
                                            cVar3 = dVar20.L[i3].f1085f;
                                            int i402 = i3 + 1;
                                            e.g.b.h.c cVar182 = dVar4.L[i402];
                                            e.g.b.h.c cVar192 = dVar21.L[i402].f1085f;
                                            if (cVar3 != null) {
                                            }
                                            dVar2 = dVar21;
                                            i10 = 5;
                                            dVar.d(cVar182.f1088i, cVar192.f1088i, -cVar182.d(), i10);
                                            e.g.b.h.c[] cVarArr9222 = dVar3.L;
                                            cVar = cVarArr9222[i3];
                                            i8 = i3 + 1;
                                            cVar2 = dVar4.L[i8];
                                            e.g.b.h.c cVar20222 = cVar.f1085f;
                                            if (cVar20222 == null) {
                                            }
                                            e.g.b.h.c cVar21222 = cVar2.f1085f;
                                            if (cVar21222 == null) {
                                            }
                                            if (dVar2 == dVar4) {
                                            }
                                            if (dVar3 == dVar4) {
                                            }
                                            dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                                        }
                                    }
                                    dVar.g(cVar14.f1088i, dVar21.L[i32].f1085f.f1088i, -cVar14.d(), 6);
                                    if (z10) {
                                    }
                                    ArrayList<e.g.b.h.d> arrayList422 = bVar2.f1078h;
                                    if (bVar2.q) {
                                    }
                                    e.g.b.h.d dVar2622 = null;
                                    float f522 = 0.0f;
                                    i14 = 0;
                                    while (i14 < size) {
                                    }
                                    aVar = aVar4;
                                    if (dVar22 != null) {
                                    }
                                    dVar4 = dVar23;
                                    dVar3 = dVar22;
                                    i9 = i7;
                                    if (z2) {
                                    }
                                    int i3622 = 8;
                                    int i3722 = bVar2.f1080j;
                                    if (i3722 <= 0) {
                                    }
                                    e.g.b.h.d dVar2822 = dVar3;
                                    dVar5 = dVar2822;
                                    while (dVar5 != null) {
                                    }
                                    i6 = i9;
                                    e.g.b.h.c cVar1722 = dVar3.L[i3];
                                    cVar3 = dVar20.L[i3].f1085f;
                                    int i4022 = i3 + 1;
                                    e.g.b.h.c cVar1822 = dVar4.L[i4022];
                                    e.g.b.h.c cVar1922 = dVar21.L[i4022].f1085f;
                                    if (cVar3 != null) {
                                    }
                                    dVar2 = dVar21;
                                    i10 = 5;
                                    dVar.d(cVar1822.f1088i, cVar1922.f1088i, -cVar1822.d(), i10);
                                    e.g.b.h.c[] cVarArr92222 = dVar3.L;
                                    cVar = cVarArr92222[i3];
                                    i8 = i3 + 1;
                                    cVar2 = dVar4.L[i8];
                                    e.g.b.h.c cVar202222 = cVar.f1085f;
                                    if (cVar202222 == null) {
                                    }
                                    e.g.b.h.c cVar212222 = cVar2.f1085f;
                                    if (cVar212222 == null) {
                                    }
                                    if (dVar2 == dVar4) {
                                    }
                                    if (dVar3 == dVar4) {
                                    }
                                    dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                                }
                            }
                            if (z10) {
                            }
                            ArrayList<e.g.b.h.d> arrayList4222 = bVar2.f1078h;
                            if (bVar2.q) {
                            }
                            e.g.b.h.d dVar26222 = null;
                            float f5222 = 0.0f;
                            i14 = 0;
                            while (i14 < size) {
                            }
                            aVar = aVar4;
                            if (dVar22 != null) {
                            }
                            dVar4 = dVar23;
                            dVar3 = dVar22;
                            i9 = i7;
                            if (z2) {
                            }
                            int i36222 = 8;
                            int i37222 = bVar2.f1080j;
                            if (i37222 <= 0) {
                            }
                            e.g.b.h.d dVar28222 = dVar3;
                            dVar5 = dVar28222;
                            while (dVar5 != null) {
                            }
                            i6 = i9;
                            e.g.b.h.c cVar17222 = dVar3.L[i3];
                            cVar3 = dVar20.L[i3].f1085f;
                            int i40222 = i3 + 1;
                            e.g.b.h.c cVar18222 = dVar4.L[i40222];
                            e.g.b.h.c cVar19222 = dVar21.L[i40222].f1085f;
                            if (cVar3 != null) {
                            }
                            dVar2 = dVar21;
                            i10 = 5;
                            dVar.d(cVar18222.f1088i, cVar19222.f1088i, -cVar18222.d(), i10);
                            e.g.b.h.c[] cVarArr922222 = dVar3.L;
                            cVar = cVarArr922222[i3];
                            i8 = i3 + 1;
                            cVar2 = dVar4.L[i8];
                            e.g.b.h.c cVar2022222 = cVar.f1085f;
                            if (cVar2022222 == null) {
                            }
                            e.g.b.h.c cVar2122222 = cVar2.f1085f;
                            if (cVar2122222 == null) {
                            }
                            if (dVar2 == dVar4) {
                            }
                            if (dVar3 == dVar4) {
                            }
                            dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                        }
                    } else {
                        i7 = i20;
                        int i44 = dVar24.f0;
                        boolean z15 = i44 == 0;
                        boolean z16 = i44 == 1;
                        if (i44 == 2) {
                            z7 = z15;
                            z5 = z16;
                        } else {
                            z6 = z15;
                            z5 = z16;
                            z = z5;
                            z2 = z6;
                            z3 = false;
                            e.g.b.h.d dVar252 = dVar20;
                            z4 = false;
                            while (!z4) {
                            }
                            i5 = i4;
                            if (dVar23 != null) {
                            }
                            if (z10) {
                            }
                            ArrayList<e.g.b.h.d> arrayList42222 = bVar2.f1078h;
                            if (bVar2.q) {
                            }
                            e.g.b.h.d dVar262222 = null;
                            float f52222 = 0.0f;
                            i14 = 0;
                            while (i14 < size) {
                            }
                            aVar = aVar4;
                            if (dVar22 != null) {
                            }
                            dVar4 = dVar23;
                            dVar3 = dVar22;
                            i9 = i7;
                            if (z2) {
                            }
                            int i362222 = 8;
                            int i372222 = bVar2.f1080j;
                            if (i372222 <= 0) {
                            }
                            e.g.b.h.d dVar282222 = dVar3;
                            dVar5 = dVar282222;
                            while (dVar5 != null) {
                            }
                            i6 = i9;
                            e.g.b.h.c cVar172222 = dVar3.L[i3];
                            cVar3 = dVar20.L[i3].f1085f;
                            int i402222 = i3 + 1;
                            e.g.b.h.c cVar182222 = dVar4.L[i402222];
                            e.g.b.h.c cVar192222 = dVar21.L[i402222].f1085f;
                            if (cVar3 != null) {
                            }
                            dVar2 = dVar21;
                            i10 = 5;
                            dVar.d(cVar182222.f1088i, cVar192222.f1088i, -cVar182222.d(), i10);
                            e.g.b.h.c[] cVarArr9222222 = dVar3.L;
                            cVar = cVarArr9222222[i3];
                            i8 = i3 + 1;
                            cVar2 = dVar4.L[i8];
                            e.g.b.h.c cVar20222222 = cVar.f1085f;
                            if (cVar20222222 == null) {
                            }
                            e.g.b.h.c cVar21222222 = cVar2.f1085f;
                            if (cVar21222222 == null) {
                            }
                            if (dVar2 == dVar4) {
                            }
                            if (dVar3 == dVar4) {
                            }
                            dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                        }
                    }
                    z = z5;
                    z2 = z7;
                    z3 = true;
                    e.g.b.h.d dVar2522 = dVar20;
                    z4 = false;
                    while (!z4) {
                    }
                    i5 = i4;
                    if (dVar23 != null) {
                    }
                    if (z10) {
                    }
                    ArrayList<e.g.b.h.d> arrayList422222 = bVar2.f1078h;
                    if (bVar2.q) {
                    }
                    e.g.b.h.d dVar2622222 = null;
                    float f522222 = 0.0f;
                    i14 = 0;
                    while (i14 < size) {
                    }
                    aVar = aVar4;
                    if (dVar22 != null) {
                    }
                    dVar4 = dVar23;
                    dVar3 = dVar22;
                    i9 = i7;
                    if (z2) {
                    }
                    int i3622222 = 8;
                    int i3722222 = bVar2.f1080j;
                    if (i3722222 <= 0) {
                    }
                    e.g.b.h.d dVar2822222 = dVar3;
                    dVar5 = dVar2822222;
                    while (dVar5 != null) {
                    }
                    i6 = i9;
                    e.g.b.h.c cVar1722222 = dVar3.L[i3];
                    cVar3 = dVar20.L[i3].f1085f;
                    int i4022222 = i3 + 1;
                    e.g.b.h.c cVar1822222 = dVar4.L[i4022222];
                    e.g.b.h.c cVar1922222 = dVar21.L[i4022222].f1085f;
                    if (cVar3 != null) {
                    }
                    dVar2 = dVar21;
                    i10 = 5;
                    dVar.d(cVar1822222.f1088i, cVar1922222.f1088i, -cVar1822222.d(), i10);
                    e.g.b.h.c[] cVarArr92222222 = dVar3.L;
                    cVar = cVarArr92222222[i3];
                    i8 = i3 + 1;
                    cVar2 = dVar4.L[i8];
                    e.g.b.h.c cVar202222222 = cVar.f1085f;
                    if (cVar202222222 == null) {
                    }
                    e.g.b.h.c cVar212222222 = cVar2.f1085f;
                    if (cVar212222222 == null) {
                    }
                    if (dVar2 == dVar4) {
                    }
                    if (dVar3 == dVar4) {
                    }
                    dVar.b(cVar.f1088i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1088i, dVar4.L[i8].d(), 5);
                } else {
                    i6 = i20;
                    aVar = aVar4;
                    i5 = i4;
                }
                i20 = i6 + 1;
                eVar2 = eVar;
                arrayList3 = arrayList;
                aVar4 = aVar;
                i4 = i5;
            }
        }

        public static String b0(Uri uri) {
            if (uri == null) {
                return null;
            }
            return uri.toString();
        }

        @RecentlyNonNull
        public static int b1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            return (i2 & -65536) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
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
        public static boolean c(int i2, Rect rect, Rect rect2, Rect rect3) {
            int i3;
            int i4;
            boolean d2 = d(i2, rect, rect2);
            if (d(i2, rect, rect3) || !d2) {
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
            int F0 = F0(i2, rect, rect2);
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
            if (F0 < Math.max(1, i4 - i3)) {
                return true;
            }
            return false;
        }

        public static Drawable c0(CompoundButton compoundButton) {
            if (Build.VERSION.SDK_INT >= 23) {
                return compoundButton.getButtonDrawable();
            }
            if (!n) {
                try {
                    Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    m = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                n = true;
            }
            Field field = m;
            if (field != null) {
                try {
                    return (Drawable) field.get(compoundButton);
                } catch (IllegalAccessException unused2) {
                    m = null;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [f.b.a.b.h.e$a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static <TInput, TResult, TException extends Throwable> TResult c1(int i2, TInput tinput, f.b.a.b.h.c<TInput, TResult, TException> cVar, f.b.a.b.i.r.a<TInput, TResult> aVar) {
            TResult tresult;
            if (i2 < 1) {
                return (TResult) cVar.a(tinput);
            }
            do {
                tresult = (TResult) cVar.a(tinput);
                TInput tinput2 = tinput;
                TResult tresult2 = tresult;
                URL url = tresult2.b;
                if (url != null) {
                    P("CctTransportBackend", "Following redirect to: %s", url);
                    tinput = new e.a(tresult2.b, tinput2.b, tinput2.c);
                } else {
                    tinput = null;
                }
                if (tinput == null) {
                    break;
                }
                i2--;
            } while (i2 >= 1);
            return tresult;
        }

        public static boolean d(int i2, Rect rect, Rect rect2) {
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

        public static int d0(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static void d1(TextView textView, int i2) {
            k(i2);
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

        public static void e(Object obj, StringBuilder sb) {
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

        public static JSONObject e0(Throwable th) {
            if (!(th instanceof f.a.b.u)) {
                return new JSONObject();
            }
            f.a.b.u uVar = (f.a.b.u) th;
            f.a.b.k kVar = uVar.b;
            if (kVar == null || kVar.b == null) {
                return new JSONObject();
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(uVar.b.b, StandardCharsets.UTF_8));
                if (jSONObject.has("padding")) {
                    jSONObject.remove("padding");
                }
                return jSONObject;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        public static void e1(TextView textView, int i2) {
            k(i2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
        public static e.z.d f(byte[] bArr) {
            Throwable th;
            ObjectInputStream objectInputStream;
            IOException e2;
            e.z.d dVar = new e.z.d();
            if (bArr == null) {
                return dVar;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        dVar.a.add(new d.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
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

        public static String f0(Throwable th) {
            if (!(th instanceof f.a.b.u)) {
                return "error_code_not_parsed";
            }
            JSONObject e0 = e0((f.a.b.u) th);
            return e0.has("errorCode") ? e0.optString("errorCode") : e0.optString("code", "error_code_not_parsed");
        }

        public static boolean f1(Drawable drawable, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.setLayoutDirection(i2);
            }
            if (!f665j) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f664i = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f665j = true;
            }
            Method method = f664i;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception unused2) {
                    f664i = null;
                }
            }
            return false;
        }

        public static boolean g(e.i.c.c[] cVarArr, e.i.c.c[] cVarArr2) {
            if (cVarArr == null || cVarArr2 == null || cVarArr.length != cVarArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                if (!(cVarArr[i2].a == cVarArr2[i2].a && cVarArr[i2].b.length == cVarArr2[i2].b.length)) {
                    return false;
                }
            }
            return true;
        }

        public static String g0(Throwable th) {
            return !(th instanceof f.a.b.u) ? "Call failed, unknown reason." : e0((f.a.b.u) th).optString("error", "Call failed, unknown reason.");
        }

        public static void g1(TextView textView, int i2) {
            k(i2);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i2 != fontMetricsInt) {
                textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
            }
        }

        public static void h(@RecentlyNonNull boolean z) {
            if (!z) {
                throw new IllegalArgumentException();
            }
        }

        public static <T> f.b.b.f.a.u<T> h0(e.f.a.d<T> dVar) {
            e.f.a.b<T> bVar = new e.f.a.b<>();
            e.f.a.e<T> eVar = new e.f.a.e<>(bVar);
            bVar.b = eVar;
            bVar.a = dVar.getClass();
            try {
                Object a2 = dVar.a(bVar);
                if (a2 != null) {
                    bVar.a = a2;
                }
            } catch (Exception e2) {
                eVar.c.j(e2);
            }
            return eVar;
        }

        public static void h1(PopupWindow popupWindow, boolean z) {
            if (Build.VERSION.SDK_INT >= 23) {
                popupWindow.setOverlapAnchor(z);
                return;
            }
            if (!r) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    q = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                r = true;
            }
            Field field = q;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException unused2) {
                }
            }
        }

        public static void i(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
            if (!z) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }

        public static <T> f.b.b.f.a.u<T> i0(f.b.a.c.i.h<T> hVar, l.b.a.d dVar, ScheduledExecutorService scheduledExecutorService) {
            return l.x(h0(new f.b.a.a.a.i.i(hVar, scheduledExecutorService))).A(dVar.t(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        }

        public static void i1(TextView textView, e.i.g.b bVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                Objects.requireNonNull(bVar);
                textView.setText((CharSequence) null);
                return;
            }
            b.a u0 = u0(textView);
            Objects.requireNonNull(bVar);
            if (u0.a(null)) {
                textView.setText(bVar);
                return;
            }
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }

        public static void j(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
        }

        public static int j0(Throwable th) {
            f.a.b.k kVar;
            if ((th instanceof f.a.b.u) && (kVar = ((f.a.b.u) th).b) != null) {
                return kVar.a;
            }
            return 0;
        }

        public static void j1(TextView textView, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i2);
            } else {
                textView.setTextAppearance(textView.getContext(), i2);
            }
        }

        public static int k(int i2) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException();
        }

        public static int k0(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.getLayoutDirection();
            }
            if (!f667l) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f666k = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f667l = true;
            }
            Method method = f666k;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception unused2) {
                    f666k = null;
                }
            }
            return 0;
        }

        public static void k1(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        public static void l(@RecentlyNonNull Handler handler) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != handler.getLooper()) {
                String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
                String name2 = handler.getLooper().getThread().getName();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 36);
                sb.append("Must be called on ");
                sb.append(name2);
                sb.append(" thread, but got ");
                sb.append(name);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }

        public static d.c l0(Throwable th) {
            if (th == null) {
                return d.c.RESULT_FAILED_UNKNOWN;
            }
            if (th instanceof t) {
                return d.c.RESULT_FAILED_TIMEOUT;
            }
            if (th instanceof f.a.b.m) {
                return d.c.RESULT_FAILED_PARSING;
            }
            if (th instanceof f.a.b.l) {
                return d.c.RESULT_FAILED_NO_CONNECTION;
            }
            if (th instanceof f.a.b.j) {
                return d.c.RESULT_FAILED_NETWORK_ERROR;
            }
            int j0 = j0(th) / 100;
            return j0 == 5 ? d.c.RESULT_FAILED_GENERIC_5XX : j0 == 4 ? d.c.RESULT_FAILED_GENERIC_4XX : d.c.RESULT_FAILED_UNKNOWN;
        }

        public static void l1(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @RecentlyNonNull
        public static String m(@RecentlyNonNull String str) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }

        public static ShareDiagnosisViewModel.b m0(ShareDiagnosisViewModel.b bVar, h0 h0Var, x5 x5Var, boolean z, Context context) {
            return n0(bVar, h0Var, x5Var, z, f.b.b.a.a.b, context);
        }

        public static void m1(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        @RecentlyNonNull
        public static String n(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }

        public static ShareDiagnosisViewModel.b n0(ShareDiagnosisViewModel.b bVar, h0 h0Var, x5 x5Var, boolean z, f.b.b.a.l<Boolean> lVar, Context context) {
            ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.VACCINATION;
            ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.CODE;
            int ordinal = bVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 9) {
                    if (ordinal == 2) {
                        return bVar3;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4 || !lVar.b()) {
                            return null;
                        }
                        if (!lVar.a().booleanValue()) {
                            return ShareDiagnosisViewModel.b.NOT_SHARED;
                        }
                        if (!h0.d.USER_REPORT.equals(h0Var.n()) || !(!TextUtils.isEmpty(context.getString(R.string.self_report_website_url))) || !context.getResources().getBoolean(R.bool.enx_preAuthorizeAfterSelfReport)) {
                            return z ? bVar2 : ShareDiagnosisViewModel.b.SHARED;
                        }
                        return ShareDiagnosisViewModel.b.PRE_AUTH;
                    }
                } else if (z) {
                    return bVar2;
                } else {
                    return null;
                }
            } else if (!z0(h0Var)) {
                return (x5Var != x5.DEEP_LINK && (TextUtils.isEmpty(context.getString(R.string.self_report_website_url)) ^ true) && !A0(h0Var)) ? ShareDiagnosisViewModel.b.IS_CODE_NEEDED : bVar3;
            }
            return ShareDiagnosisViewModel.b.UPLOAD;
        }

        public static void n1(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            b1 b1Var = b1.f846k;
            if (b1Var != null && b1Var.b == view) {
                b1.c(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                b1 b1Var2 = b1.f847l;
                if (b1Var2 != null && b1Var2.b == view) {
                    b1Var2.b();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new b1(view, charSequence);
        }

        public static <T> T o(T t2, Object obj) {
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static Intent o0(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String q0 = q0(activity, activity.getComponentName());
                if (q0 == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, q0);
                try {
                    return q0(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        public static void o1(PopupWindow popupWindow, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                popupWindow.setWindowLayoutType(i2);
                return;
            }
            if (!p) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    o = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                p = true;
            }
            Method method = o;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i2));
                } catch (Exception unused2) {
                }
            }
        }

        @EnsuresNonNull({"#1"})
        public static <T> T p(@RecentlyNonNull T t2, @RecentlyNonNull Object obj) {
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static Intent p0(Context context, ComponentName componentName) {
            String q0 = q0(context, componentName);
            if (q0 == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), q0);
            return q0(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
        }

        public static void p1(XmlPullParser xmlPullParser) {
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

        public static int q(Context context, String str) {
            int myPid = Process.myPid();
            int myUid = Process.myUid();
            String packageName = context.getPackageName();
            if (context.checkPermission(str, myPid, myUid) != -1) {
                int i2 = Build.VERSION.SDK_INT;
                String permissionToOp = i2 >= 23 ? AppOpsManager.permissionToOp(str) : null;
                if (permissionToOp == null) {
                    return 0;
                }
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                if ((i2 >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName) : 1) != 0) {
                    return -2;
                }
                return 0;
            }
            return -1;
        }

        public static String q0(Context context, ComponentName componentName) {
            String string;
            PackageManager packageManager = context.getPackageManager();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 640;
            if (i2 >= 29) {
                i3 = 269222528;
            } else if (i2 >= 24) {
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

        public static void q1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            parcel.setDataPosition(parcel.dataPosition() + b1(parcel, i2));
        }

        public static void r(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
            if (!z) {
                throw new IllegalStateException(String.valueOf(obj));
            }
        }

        public static String r0(@RecentlyNonNull int i2) {
            switch (i2) {
                case -1:
                    return "SUCCESS_CACHE";
                case 0:
                    return "SUCCESS";
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("unknown status code: ");
                    sb.append(i2);
                    return sb.toString();
                case 2:
                    return "SERVICE_VERSION_UPDATE_REQUIRED";
                case 3:
                    return "SERVICE_DISABLED";
                case 4:
                    return "SIGN_IN_REQUIRED";
                case 5:
                    return "INVALID_ACCOUNT";
                case 6:
                    return "RESOLUTION_REQUIRED";
                case 7:
                    return "NETWORK_ERROR";
                case 8:
                    return "INTERNAL_ERROR";
                case 10:
                    return "DEVELOPER_ERROR";
                case 13:
                    return "ERROR";
                case 14:
                    return "INTERRUPTED";
                case 15:
                    return "TIMEOUT";
                case 16:
                    return "CANCELED";
                case 17:
                    return "API_NOT_CONNECTED";
                case 18:
                    return "DEAD_CLIENT";
                case 19:
                    return "REMOTE_EXCEPTION";
                case 20:
                    return "CONNECTION_SUSPENDED_DURING_CALL";
                case 21:
                    return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                case 22:
                    return "RECONNECTION_TIMED_OUT";
            }
        }

        public static int r1(e.z.s sVar) {
            int ordinal = sVar.ordinal();
            if (ordinal == 0) {
                return 0;
            }
            int i2 = 1;
            if (ordinal != 1) {
                i2 = 2;
                if (ordinal != 2) {
                    i2 = 3;
                    if (ordinal != 3) {
                        i2 = 4;
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return 5;
                            }
                            throw new IllegalArgumentException("Could not convert " + sVar + " to int");
                        }
                    }
                }
            }
            return i2;
        }

        public static int s(int i2, int i3, int i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }

        public static String s0(String str) {
            return f.a.a.a.a.c("TransportRuntime.", str);
        }

        public static List<byte[]> s1(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        public static void t(Drawable drawable) {
            DrawableContainer.DrawableContainerState drawableContainerState;
            Drawable a2;
            int i2 = Build.VERSION.SDK_INT;
            drawable.clearColorFilter();
            if (i2 < 23) {
                if (drawable instanceof InsetDrawable) {
                    a2 = ((InsetDrawable) drawable).getDrawable();
                } else if (drawable instanceof e.i.c.l.b) {
                    a2 = ((e.i.c.l.b) drawable).a();
                } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        Drawable child = drawableContainerState.getChild(i3);
                        if (child != null) {
                            t(child);
                        }
                    }
                    return;
                } else {
                    return;
                }
                t(a2);
            }
        }

        public static File t0(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder i2 = f.a.a.a.a.i(".font");
            i2.append(Process.myPid());
            i2.append("-");
            i2.append(Process.myTid());
            i2.append("-");
            String sb = i2.toString();
            for (int i3 = 0; i3 < 100; i3++) {
                File file = new File(cacheDir, f.a.a.a.a.v(sb, i3));
                try {
                    if (file.createNewFile()) {
                        return file;
                    }
                } catch (IOException unused) {
                }
            }
            return null;
        }

        public static h0.b t1(String str) {
            if (str == null) {
                return null;
            }
            return h0.b.valueOf(str);
        }

        public static int u(RecyclerView.y yVar, e.s.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(mVar.S(view) - mVar.S(view2)) + 1;
            }
            return Math.min(rVar.l(), rVar.b(view2) - rVar.e(view));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
            if (r9 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r4 != false) goto L_0x0074;
         */
        public static b.a u0(TextView textView) {
            int i2;
            int i3;
            TextDirectionHeuristic textDirectionHeuristic;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                return new b.a(textView.getTextMetricsParams());
            }
            TextPaint textPaint = new TextPaint(textView.getPaint());
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 23) {
                i3 = 1;
                i2 = 1;
            } else {
                i3 = 0;
                i2 = 0;
            }
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            if (i4 >= 23) {
                i3 = textView.getBreakStrategy();
                i2 = textView.getHyphenationFrequency();
            }
            if (!(textView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                if (i4 < 28 || (textView.getInputType() & 15) != 3) {
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
                    return new b.a(textPaint, textDirectionHeuristic, i3, i2);
                }
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality != 1) {
                }
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
                return new b.a(textPaint, textDirectionHeuristic, i3, i2);
            }
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
            return new b.a(textPaint, textDirectionHeuristic, i3, i2);
        }

        public static l.b.a.f u1(String str) {
            if (str == null) {
                return null;
            }
            l.b.a.f fVar = l.b.a.f.f4292e;
            return l.b.a.f.T(str, l.b.a.v.c.f4371h);
        }

        public static int v(RecyclerView.y yVar, e.s.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z, boolean z2) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            int max = z2 ? Math.max(0, (yVar.b() - Math.max(mVar.S(view), mVar.S(view2))) - 1) : Math.max(0, Math.min(mVar.S(view), mVar.S(view2)));
            if (!z) {
                return max;
            }
            return Math.round((((float) max) * (((float) Math.abs(rVar.b(view2) - rVar.e(view))) / ((float) (Math.abs(mVar.S(view) - mVar.S(view2)) + 1)))) + ((float) (rVar.k() - rVar.e(view))));
        }

        public static e.z.a v0(int i2) {
            if (i2 == 0) {
                return e.z.a.EXPONENTIAL;
            }
            if (i2 == 1) {
                return e.z.a.LINEAR;
            }
            throw new IllegalArgumentException(f.a.a.a.a.w("Could not convert ", i2, " to BackoffPolicy"));
        }

        public static h0.c v1(String str) {
            if (str == null) {
                return null;
            }
            return h0.c.valueOf(str);
        }

        public static int w(RecyclerView.y yVar, e.s.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return yVar.b();
            }
            return (int) ((((float) (rVar.b(view2) - rVar.e(view))) / ((float) (Math.abs(mVar.S(view) - mVar.S(view2)) + 1))) * ((float) yVar.b()));
        }

        public static e.z.m w0(int i2) {
            if (i2 == 0) {
                return e.z.m.NOT_REQUIRED;
            }
            if (i2 == 1) {
                return e.z.m.CONNECTED;
            }
            if (i2 == 2) {
                return e.z.m.UNMETERED;
            }
            if (i2 == 3) {
                return e.z.m.NOT_ROAMING;
            }
            if (i2 == 4) {
                return e.z.m.METERED;
            }
            throw new IllegalArgumentException(f.a.a.a.a.w("Could not convert ", i2, " to NetworkType"));
        }

        public static h0.d w1(String str) {
            if (str == null) {
                return null;
            }
            return h0.d.valueOf(str);
        }

        public static float[] x(float[] fArr, int i2, int i3) {
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

        public static e.z.s x0(int i2) {
            if (i2 == 0) {
                return e.z.s.ENQUEUED;
            }
            if (i2 == 1) {
                return e.z.s.RUNNING;
            }
            if (i2 == 2) {
                return e.z.s.SUCCEEDED;
            }
            if (i2 == 3) {
                return e.z.s.FAILED;
            }
            if (i2 == 4) {
                return e.z.s.BLOCKED;
            }
            if (i2 == 5) {
                return e.z.s.CANCELLED;
            }
            throw new IllegalArgumentException(f.a.a.a.a.w("Could not convert ", i2, " to State"));
        }

        public static h0.e x1(String str) {
            if (str == null) {
                return null;
            }
            return h0.e.valueOf(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
        public static boolean y(File file, Resources resources, int i2) {
            InputStream inputStream;
            Throwable th;
            try {
                inputStream = resources.openRawResource(i2);
                try {
                    boolean z = z(file, inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return z;
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

        public static boolean y0(Rect rect, Rect rect2, int i2) {
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

        @RecentlyNonNull
        public static <ResultT> boolean y1(@RecentlyNonNull Status status, ResultT resultt, @RecentlyNonNull f.b.a.c.i.i<ResultT> iVar) {
            return status.d() ? iVar.b(resultt) : iVar.a(new f.b.a.c.b.l.b(status));
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0039 A[SYNTHETIC, Splitter:B:30:0x0039] */
        public static boolean z(File file, InputStream inputStream) {
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

        public static boolean z0(h0 h0Var) {
            return h0Var.f() && a5.b(h0Var) && h0Var.m() != h0.c.SHARED;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Drawable> T z1(Drawable drawable) {
            return drawable instanceof e.i.c.l.b ? (T) ((e.i.c.l.b) drawable).a() : drawable;
        }
    }

    public class i extends ContentFrameLayout {
        public i(Context context) {
            super(context, null);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return m.this.H(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    m mVar = m.this;
                    mVar.F(mVar.O(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(e.b.b.a.a.b(getContext(), i2));
        }
    }

    public static final class j {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f669d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f670e;

        /* renamed from: f  reason: collision with root package name */
        public View f671f;

        /* renamed from: g  reason: collision with root package name */
        public View f672g;

        /* renamed from: h  reason: collision with root package name */
        public e.b.e.i.g f673h;

        /* renamed from: i  reason: collision with root package name */
        public e.b.e.i.e f674i;

        /* renamed from: j  reason: collision with root package name */
        public Context f675j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f676k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f677l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public j(int i2) {
            this.a = i2;
        }

        public void a(e.b.e.i.g gVar) {
            e.b.e.i.e eVar;
            e.b.e.i.g gVar2 = this.f673h;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.u(this.f674i);
                }
                this.f673h = gVar;
                if (gVar != null && (eVar = this.f674i) != null) {
                    gVar.b(eVar, gVar.a);
                }
            }
        }
    }

    public final class k implements m.a {
        public k() {
        }

        @Override // e.b.e.i.m.a
        public void b(e.b.e.i.g gVar, boolean z) {
            e.b.e.i.g k2 = gVar.k();
            boolean z2 = k2 != gVar;
            m mVar = m.this;
            if (z2) {
                gVar = k2;
            }
            j M = mVar.M(gVar);
            if (M == null) {
                return;
            }
            if (z2) {
                m.this.D(M.a, M, k2);
                m.this.F(M, true);
                return;
            }
            m.this.F(M, z);
        }

        @Override // e.b.e.i.m.a
        public boolean c(e.b.e.i.g gVar) {
            Window.Callback P;
            if (gVar != gVar.k()) {
                return true;
            }
            m mVar = m.this;
            if (!mVar.z || (P = mVar.P()) == null || m.this.L) {
                return true;
            }
            P.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r4 = null;
     */
    public m(Context context, Window window, k kVar, Object obj) {
        e.e.h<String, Integer> hVar;
        Integer orDefault;
        j jVar;
        this.f649e = context;
        this.f652h = kVar;
        this.f648d = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof j)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        jVar = (j) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (jVar != null) {
                this.M = jVar.t().f();
            }
        }
        if (this.M == -100 && (orDefault = (hVar = Z).getOrDefault(this.f648d.getClass().getName(), null)) != null) {
            this.M = orDefault.intValue();
            hVar.remove(this.f648d.getClass().getName());
        }
        if (window != null) {
            C(window);
        }
        e.b.f.j.e();
    }

    public boolean A() {
        return B(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x023e, code lost:
        if (r2 != false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0243, code lost:
        if (r18.K != false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013a, code lost:
        if (r0 != false) goto L_0x013f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0144 A[ADDED_TO_REGION] */
    public final boolean B(boolean z2) {
        boolean z3;
        boolean z4;
        Object obj;
        int i2;
        boolean z5;
        boolean z6 = false;
        if (this.L) {
            return false;
        }
        int i3 = this.M;
        int i4 = -100;
        if (i3 != -100) {
            i4 = i3;
        }
        Map map = null;
        r5 = null;
        r5 = null;
        Object obj2 = null;
        Object obj3 = null;
        Configuration G2 = G(this.f649e, S(this.f649e, i4), null);
        boolean z7 = true;
        if (!this.P && (this.f648d instanceof Activity)) {
            PackageManager packageManager = this.f649e.getPackageManager();
            if (packageManager == null) {
                z3 = false;
                int i5 = this.f649e.getResources().getConfiguration().uiMode & 48;
                int i6 = G2.uiMode & 48;
                if (i5 != i6 && z2 && !z3 && this.I && (b0 || this.J)) {
                    Object obj4 = this.f648d;
                    if ((obj4 instanceof Activity) && !((Activity) obj4).isChild()) {
                        Activity activity = (Activity) this.f648d;
                        int i7 = e.i.a.b.b;
                        i2 = Build.VERSION.SDK_INT;
                        if (i2 < 28) {
                            Class<?> cls = e.i.a.g.a;
                            if (i2 >= 28) {
                                activity.recreate();
                            } else {
                                if ((!e.i.a.g.a() || e.i.a.g.f1211f != null) && !(e.i.a.g.f1210e == null && e.i.a.g.f1209d == null)) {
                                    try {
                                        Object obj5 = e.i.a.g.c.get(activity);
                                        if (obj5 != null) {
                                            Object obj6 = e.i.a.g.b.get(activity);
                                            if (obj6 != null) {
                                                Application application = activity.getApplication();
                                                g.a aVar = new g.a(activity);
                                                application.registerActivityLifecycleCallbacks(aVar);
                                                Handler handler = e.i.a.g.f1212g;
                                                handler.post(new e.i.a.d(aVar, obj5));
                                                try {
                                                    if (e.i.a.g.a()) {
                                                        Method method = e.i.a.g.f1211f;
                                                        Boolean bool = Boolean.FALSE;
                                                        method.invoke(obj6, obj5, null, null, 0, bool, null, null, bool, bool);
                                                    } else {
                                                        activity.recreate();
                                                    }
                                                    handler.post(new e.i.a.e(application, aVar));
                                                } catch (Throwable th) {
                                                    e.i.a.g.f1212g.post(new e.i.a.e(application, aVar));
                                                    throw th;
                                                }
                                            }
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                                z5 = false;
                            }
                            z5 = true;
                        }
                        activity.recreate();
                        z4 = true;
                        if (!z4 || i5 == i6) {
                            z7 = z4;
                        } else {
                            Resources resources = this.f649e.getResources();
                            Configuration configuration = new Configuration(resources.getConfiguration());
                            configuration.uiMode = (resources.getConfiguration().uiMode & -49) | i6;
                            resources.updateConfiguration(configuration, null);
                            int i8 = Build.VERSION.SDK_INT;
                            if (i8 < 26 && i8 < 28) {
                                if (i8 >= 24) {
                                    if (!h.f663h) {
                                        try {
                                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                            h.f662g = declaredField;
                                            declaredField.setAccessible(true);
                                        } catch (NoSuchFieldException unused2) {
                                        }
                                        h.f663h = true;
                                    }
                                    Field field = h.f662g;
                                    if (field != null) {
                                        try {
                                            obj = field.get(resources);
                                        } catch (IllegalAccessException unused3) {
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            if (!h.b) {
                                                try {
                                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                    h.a = declaredField2;
                                                    declaredField2.setAccessible(true);
                                                } catch (NoSuchFieldException unused4) {
                                                }
                                                h.b = true;
                                            }
                                            Field field2 = h.a;
                                            if (field2 != null) {
                                                try {
                                                    obj2 = field2.get(obj);
                                                } catch (IllegalAccessException unused5) {
                                                }
                                            }
                                            if (obj2 != null) {
                                                h.Y(obj2);
                                            }
                                        }
                                    }
                                } else if (i8 >= 23) {
                                    if (!h.b) {
                                        try {
                                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                            h.a = declaredField3;
                                            declaredField3.setAccessible(true);
                                        } catch (NoSuchFieldException unused6) {
                                        }
                                        h.b = true;
                                    }
                                    Field field3 = h.a;
                                    if (field3 != null) {
                                        try {
                                            obj3 = field3.get(resources);
                                        } catch (IllegalAccessException unused7) {
                                        }
                                    }
                                    if (obj3 != null) {
                                        h.Y(obj3);
                                    }
                                } else {
                                    if (!h.b) {
                                        try {
                                            Field declaredField4 = Resources.class.getDeclaredField("mDrawableCache");
                                            h.a = declaredField4;
                                            declaredField4.setAccessible(true);
                                        } catch (NoSuchFieldException unused8) {
                                        }
                                        h.b = true;
                                    }
                                    Field field4 = h.a;
                                    if (field4 != null) {
                                        try {
                                            map = (Map) field4.get(resources);
                                        } catch (IllegalAccessException unused9) {
                                        }
                                        if (map != null) {
                                            map.clear();
                                        }
                                    }
                                }
                            }
                            int i9 = this.N;
                            if (i9 != 0) {
                                this.f649e.setTheme(i9);
                                if (Build.VERSION.SDK_INT >= 23) {
                                    this.f649e.getTheme().applyStyle(this.N, true);
                                }
                            }
                            if (z3) {
                                Object obj7 = this.f648d;
                                if (obj7 instanceof Activity) {
                                    Activity activity2 = (Activity) obj7;
                                    if (activity2 instanceof e.p.l) {
                                        if (((e.p.m) ((e.p.l) activity2).a()).b.compareTo((Enum) h.b.STARTED) >= 0) {
                                            z6 = true;
                                        }
                                    }
                                    activity2.onConfigurationChanged(configuration);
                                }
                            }
                        }
                        if (z7) {
                            Object obj8 = this.f648d;
                            if (obj8 instanceof j) {
                                ((j) obj8).w();
                            }
                        }
                        if (i4 == 0) {
                            N(this.f649e).e();
                        } else {
                            f fVar = this.Q;
                            if (fVar != null) {
                                fVar.a();
                            }
                        }
                        if (i4 == 3) {
                            Context context = this.f649e;
                            if (this.R == null) {
                                this.R = new e(context);
                            }
                            this.R.e();
                        } else {
                            f fVar2 = this.R;
                            if (fVar2 != null) {
                                fVar2.a();
                            }
                        }
                        return z7;
                    }
                }
                z4 = false;
                if (!z4) {
                }
                z7 = z4;
                if (z7) {
                }
                if (i4 == 0) {
                }
                if (i4 == 3) {
                }
                return z7;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f649e, this.f648d.getClass()), i10 >= 29 ? 269221888 : i10 >= 24 ? 786432 : 0);
                this.O = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused10) {
                this.O = false;
            }
        }
        this.P = true;
        z3 = this.O;
        int i52 = this.f649e.getResources().getConfiguration().uiMode & 48;
        int i62 = G2.uiMode & 48;
        Object obj42 = this.f648d;
        Activity activity3 = (Activity) this.f648d;
        int i72 = e.i.a.b.b;
        i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
        }
        activity3.recreate();
        z4 = true;
        if (!z4) {
        }
        z7 = z4;
        if (z7) {
        }
        if (i4 == 0) {
        }
        if (i4 == 3) {
        }
        return z7;
    }

    public final void C(Window window) {
        if (this.f650f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof d)) {
                d dVar = new d(callback);
                this.f651g = dVar;
                window.setCallback(dVar);
                y0 p2 = y0.p(this.f649e, null, a0);
                Drawable h2 = p2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                p2.b.recycle();
                this.f650f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void D(int i2, j jVar, Menu menu) {
        if (menu == null && jVar != null) {
            menu = jVar.f673h;
        }
        if ((jVar == null || jVar.m) && !this.L) {
            this.f651g.b.onPanelClosed(i2, menu);
        }
    }

    public void E(e.b.e.i.g gVar) {
        if (!this.E) {
            this.E = true;
            this.f656l.l();
            Window.Callback P2 = P();
            if (P2 != null && !this.L) {
                P2.onPanelClosed(108, gVar);
            }
            this.E = false;
        }
    }

    public void F(j jVar, boolean z2) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (!z2 || jVar.a != 0 || (c0Var = this.f656l) == null || !c0Var.c()) {
            WindowManager windowManager = (WindowManager) this.f649e.getSystemService("window");
            if (!(windowManager == null || !jVar.m || (viewGroup = jVar.f670e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    D(jVar.a, jVar, null);
                }
            }
            jVar.f676k = false;
            jVar.f677l = false;
            jVar.m = false;
            jVar.f671f = null;
            jVar.o = true;
            if (this.G == jVar) {
                this.G = null;
                return;
            }
            return;
        }
        E(jVar.f673h);
    }

    public final Configuration G(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    public boolean H(KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        AudioManager audioManager;
        boolean z4;
        View decorView;
        Object obj = this.f648d;
        boolean z5 = true;
        if (((obj instanceof e.a) || (obj instanceof r)) && (decorView = this.f650f.getDecorView()) != null && e.i.i.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f651g.b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & 128) == 0) {
                    z5 = false;
                }
                this.H = z5;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                j O2 = O(0);
                if (O2.m) {
                    return true;
                }
                V(O2, keyEvent);
                return true;
            }
        } else if (keyCode == 4) {
            boolean z6 = this.H;
            this.H = false;
            j O3 = O(0);
            if (!O3.m) {
                e.b.e.a aVar = this.o;
                if (aVar != null) {
                    aVar.c();
                } else {
                    Q();
                    a aVar2 = this.f653i;
                    if (aVar2 == null || !aVar2.b()) {
                        z2 = false;
                        if (!z2) {
                            return true;
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                    return false;
                }
            } else if (z6) {
                return true;
            } else {
                F(O3, true);
                return true;
            }
        } else if (keyCode == 82) {
            if (this.o != null) {
                return true;
            }
            j O4 = O(0);
            c0 c0Var = this.f656l;
            if (c0Var == null || !c0Var.g() || ViewConfiguration.get(this.f649e).hasPermanentMenuKey()) {
                boolean z7 = O4.m;
                if (z7 || O4.f677l) {
                    F(O4, true);
                    z3 = z7;
                    if (!z3 && (audioManager = (AudioManager) this.f649e.getApplicationContext().getSystemService("audio")) != null) {
                        audioManager.playSoundEffect(0);
                        return true;
                    }
                } else if (O4.f676k) {
                    if (O4.p) {
                        O4.f676k = false;
                        z4 = V(O4, keyEvent);
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        T(O4, keyEvent);
                        z3 = true;
                        return !z3 ? true : true;
                    }
                }
            } else {
                if (this.f656l.c()) {
                    z3 = this.f656l.d();
                } else if (!this.L && V(O4, keyEvent)) {
                    z3 = this.f656l.e();
                }
                if (!z3) {
                }
            }
            z3 = false;
            if (!z3) {
            }
        }
        return false;
    }

    public void I(int i2) {
        j O2 = O(i2);
        if (O2.f673h != null) {
            Bundle bundle = new Bundle();
            O2.f673h.w(bundle);
            if (bundle.size() > 0) {
                O2.q = bundle;
            }
            O2.f673h.z();
            O2.f673h.clear();
        }
        O2.p = true;
        O2.o = true;
        if ((i2 == 108 || i2 == 0) && this.f656l != null) {
            j O3 = O(0);
            O3.f676k = false;
            V(O3, null);
        }
    }

    public void J() {
        s sVar = this.s;
        if (sVar != null) {
            sVar.b();
        }
    }

    public final void K() {
        ViewGroup viewGroup;
        if (!this.t) {
            TypedArray obtainStyledAttributes = this.f649e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
            int i2 = androidx.appcompat.R$styleable.AppCompatTheme_windowActionBar;
            if (obtainStyledAttributes.hasValue(i2)) {
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowNoTitle, false)) {
                    t(1);
                } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                    t(108);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    t(109);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    t(10);
                }
                this.C = obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                L();
                this.f650f.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.f649e);
                if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(this.B ? R$layout.abc_screen_simple_overlay_action_mode : R$layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.C) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                    this.A = false;
                    this.z = false;
                } else if (this.z) {
                    TypedValue typedValue = new TypedValue();
                    this.f649e.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
                    viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new e.b.e.c(this.f649e, typedValue.resourceId) : this.f649e).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                    c0 c0Var = (c0) viewGroup.findViewById(androidx.appcompat.R$id.decor_content_parent);
                    this.f656l = c0Var;
                    c0Var.setWindowCallback(P());
                    if (this.A) {
                        this.f656l.k(109);
                    }
                    if (this.x) {
                        this.f656l.k(2);
                    }
                    if (this.y) {
                        this.f656l.k(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    e.i.i.m.r(viewGroup, new n(this));
                    if (this.f656l == null) {
                        this.v = (TextView) viewGroup.findViewById(androidx.appcompat.R$id.title);
                    }
                    Method method = e1.a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R$id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f650f.findViewById(16908290);
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
                    this.f650f.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new o(this));
                    this.u = viewGroup;
                    Object obj = this.f648d;
                    CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f655k;
                    if (!TextUtils.isEmpty(title)) {
                        c0 c0Var2 = this.f656l;
                        if (c0Var2 != null) {
                            c0Var2.setWindowTitle(title);
                        } else {
                            a aVar = this.f653i;
                            if (aVar != null) {
                                aVar.q(title);
                            } else {
                                TextView textView = this.v;
                                if (textView != null) {
                                    textView.setText(title);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.u.findViewById(16908290);
                    View decorView = this.f650f.getDecorView();
                    contentFrameLayout2.f82h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    AtomicInteger atomicInteger = e.i.i.m.a;
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.f649e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(androidx.appcompat.R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    int i3 = androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMajor;
                    if (obtainStyledAttributes2.hasValue(i3)) {
                        obtainStyledAttributes2.getValue(i3, contentFrameLayout2.getFixedWidthMajor());
                    }
                    int i4 = androidx.appcompat.R$styleable.AppCompatTheme_windowFixedWidthMinor;
                    if (obtainStyledAttributes2.hasValue(i4)) {
                        obtainStyledAttributes2.getValue(i4, contentFrameLayout2.getFixedWidthMinor());
                    }
                    int i5 = androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMajor;
                    if (obtainStyledAttributes2.hasValue(i5)) {
                        obtainStyledAttributes2.getValue(i5, contentFrameLayout2.getFixedHeightMajor());
                    }
                    int i6 = androidx.appcompat.R$styleable.AppCompatTheme_windowFixedHeightMinor;
                    if (obtainStyledAttributes2.hasValue(i6)) {
                        obtainStyledAttributes2.getValue(i6, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.t = true;
                    j O2 = O(0);
                    if (!this.L && O2.f673h == null) {
                        R(108);
                        return;
                    }
                    return;
                }
                StringBuilder i7 = f.a.a.a.a.i("AppCompat does not support the current theme features: { windowActionBar: ");
                i7.append(this.z);
                i7.append(", windowActionBarOverlay: ");
                i7.append(this.A);
                i7.append(", android:windowIsFloating: ");
                i7.append(this.C);
                i7.append(", windowActionModeOverlay: ");
                i7.append(this.B);
                i7.append(", windowNoTitle: ");
                i7.append(this.D);
                i7.append(" }");
                throw new IllegalArgumentException(i7.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void L() {
        if (this.f650f == null) {
            Object obj = this.f648d;
            if (obj instanceof Activity) {
                C(((Activity) obj).getWindow());
            }
        }
        if (this.f650f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public j M(Menu menu) {
        j[] jVarArr = this.F;
        int length = jVarArr != null ? jVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null && jVar.f673h == menu) {
                return jVar;
            }
        }
        return null;
    }

    public final f N(Context context) {
        if (this.Q == null) {
            if (v.f688d == null) {
                Context applicationContext = context.getApplicationContext();
                v.f688d = new v(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.Q = new g(v.f688d);
        }
        return this.Q;
    }

    public j O(int i2) {
        j[] jVarArr = this.F;
        if (jVarArr == null || jVarArr.length <= i2) {
            j[] jVarArr2 = new j[(i2 + 1)];
            if (jVarArr != null) {
                System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            }
            this.F = jVarArr2;
            jVarArr = jVarArr2;
        }
        j jVar = jVarArr[i2];
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(i2);
        jVarArr[i2] = jVar2;
        return jVar2;
    }

    public final Window.Callback P() {
        return this.f650f.getCallback();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final void Q() {
        a aVar;
        w wVar;
        K();
        if (this.z && this.f653i == null) {
            Object obj = this.f648d;
            if (obj instanceof Activity) {
                wVar = new w((Activity) this.f648d, this.A);
            } else {
                if (obj instanceof Dialog) {
                    wVar = new w((Dialog) this.f648d);
                }
                aVar = this.f653i;
                if (aVar == null) {
                    aVar.l(this.V);
                    return;
                }
                return;
            }
            this.f653i = wVar;
            aVar = this.f653i;
            if (aVar == null) {
            }
        }
    }

    public final void R(int i2) {
        this.T = (1 << i2) | this.T;
        if (!this.S) {
            View decorView = this.f650f.getDecorView();
            Runnable runnable = this.U;
            AtomicInteger atomicInteger = e.i.i.m.a;
            decorView.postOnAnimation(runnable);
            this.S = true;
        }
    }

    public int S(Context context, int i2) {
        f N2;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        if (this.R == null) {
                            this.R = new e(context);
                        }
                        N2 = this.R;
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                return -1;
            } else {
                N2 = N(context);
            }
            return N2.c();
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0151, code lost:
        if (r14 != null) goto L_0x0153;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0158  */
    public final void T(j jVar, KeyEvent keyEvent) {
        int i2;
        boolean z2;
        ViewGroup.LayoutParams layoutParams;
        if (!jVar.m && !this.L) {
            if (jVar.a == 0) {
                if ((this.f649e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback P2 = P();
            if (P2 == null || P2.onMenuOpened(jVar.a, jVar.f673h)) {
                WindowManager windowManager = (WindowManager) this.f649e.getSystemService("window");
                if (windowManager != null && V(jVar, keyEvent)) {
                    ViewGroup viewGroup = jVar.f670e;
                    if (viewGroup == null || jVar.o) {
                        if (viewGroup == null) {
                            Q();
                            a aVar = this.f653i;
                            Context e2 = aVar != null ? aVar.e() : null;
                            if (e2 == null) {
                                e2 = this.f649e;
                            }
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme newTheme = e2.getResources().newTheme();
                            newTheme.setTo(e2.getTheme());
                            newTheme.resolveAttribute(androidx.appcompat.R$attr.actionBarPopupTheme, typedValue, true);
                            int i3 = typedValue.resourceId;
                            if (i3 != 0) {
                                newTheme.applyStyle(i3, true);
                            }
                            newTheme.resolveAttribute(androidx.appcompat.R$attr.panelMenuListTheme, typedValue, true);
                            int i4 = typedValue.resourceId;
                            if (i4 == 0) {
                                i4 = R$style.Theme_AppCompat_CompactMenu;
                            }
                            newTheme.applyStyle(i4, true);
                            e.b.e.c cVar = new e.b.e.c(e2, 0);
                            cVar.getTheme().setTo(newTheme);
                            jVar.f675j = cVar;
                            TypedArray obtainStyledAttributes = cVar.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
                            jVar.b = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_panelBackground, 0);
                            jVar.f669d = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            jVar.f670e = new i(jVar.f675j);
                            jVar.c = 81;
                        } else if (jVar.o && viewGroup.getChildCount() > 0) {
                            jVar.f670e.removeAllViews();
                        }
                        View view = jVar.f672g;
                        if (view != null) {
                            jVar.f671f = view;
                        } else {
                            if (jVar.f673h != null) {
                                if (this.n == null) {
                                    this.n = new k();
                                }
                                k kVar = this.n;
                                if (jVar.f674i == null) {
                                    e.b.e.i.e eVar = new e.b.e.i.e(jVar.f675j, R$layout.abc_list_menu_item_layout);
                                    jVar.f674i = eVar;
                                    eVar.f774g = kVar;
                                    e.b.e.i.g gVar = jVar.f673h;
                                    gVar.b(eVar, gVar.a);
                                }
                                e.b.e.i.e eVar2 = jVar.f674i;
                                ViewGroup viewGroup2 = jVar.f670e;
                                if (eVar2.f772e == null) {
                                    eVar2.f772e = (ExpandedMenuView) eVar2.c.inflate(R$layout.abc_expanded_menu_layout, viewGroup2, false);
                                    if (eVar2.f775h == null) {
                                        eVar2.f775h = new e.a();
                                    }
                                    eVar2.f772e.setAdapter((ListAdapter) eVar2.f775h);
                                    eVar2.f772e.setOnItemClickListener(eVar2);
                                }
                                ExpandedMenuView expandedMenuView = eVar2.f772e;
                                jVar.f671f = expandedMenuView;
                            }
                            z2 = false;
                            if (z2) {
                                if (jVar.f671f != null && (jVar.f672g != null || ((e.a) jVar.f674i.a()).getCount() > 0)) {
                                    ViewGroup.LayoutParams layoutParams2 = jVar.f671f.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                    }
                                    jVar.f670e.setBackgroundResource(jVar.b);
                                    ViewParent parent = jVar.f671f.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(jVar.f671f);
                                    }
                                    jVar.f670e.addView(jVar.f671f, layoutParams2);
                                    if (!jVar.f671f.hasFocus()) {
                                        jVar.f671f.requestFocus();
                                    }
                                }
                            }
                            jVar.o = true;
                            return;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        jVar.o = true;
                        return;
                    }
                    View view2 = jVar.f672g;
                    if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        jVar.f677l = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams3.gravity = jVar.c;
                        layoutParams3.windowAnimations = jVar.f669d;
                        windowManager.addView(jVar.f670e, layoutParams3);
                        jVar.m = true;
                        return;
                    }
                    i2 = -2;
                    jVar.f677l = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams32.gravity = jVar.c;
                    layoutParams32.windowAnimations = jVar.f669d;
                    windowManager.addView(jVar.f670e, layoutParams32);
                    jVar.m = true;
                    return;
                }
                return;
            }
            F(jVar, true);
        }
    }

    public final boolean U(j jVar, int i2, KeyEvent keyEvent, int i3) {
        e.b.e.i.g gVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((jVar.f676k || V(jVar, keyEvent)) && (gVar = jVar.f673h) != null) {
            z2 = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.f656l == null) {
            F(jVar, true);
        }
        return z2;
    }

    public final boolean V(j jVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        Resources.Theme theme;
        c0 c0Var4;
        if (this.L) {
            return false;
        }
        if (jVar.f676k) {
            return true;
        }
        j jVar2 = this.G;
        if (!(jVar2 == null || jVar2 == jVar)) {
            F(jVar2, false);
        }
        Window.Callback P2 = P();
        if (P2 != null) {
            jVar.f672g = P2.onCreatePanelView(jVar.a);
        }
        int i2 = jVar.a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (c0Var4 = this.f656l) != null) {
            c0Var4.f();
        }
        if (jVar.f672g == null && (!z2 || !(this.f653i instanceof t))) {
            e.b.e.i.g gVar = jVar.f673h;
            if (gVar == null || jVar.p) {
                if (gVar == null) {
                    Context context = this.f649e;
                    int i3 = jVar.a;
                    if ((i3 == 0 || i3 == 108) && this.f656l != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
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
                            e.b.e.c cVar = new e.b.e.c(context, 0);
                            cVar.getTheme().setTo(theme);
                            context = cVar;
                        }
                    }
                    e.b.e.i.g gVar2 = new e.b.e.i.g(context);
                    gVar2.f781e = this;
                    jVar.a(gVar2);
                    if (jVar.f673h == null) {
                        return false;
                    }
                }
                if (z2 && (c0Var3 = this.f656l) != null) {
                    if (this.m == null) {
                        this.m = new b();
                    }
                    c0Var3.a(jVar.f673h, this.m);
                }
                jVar.f673h.z();
                if (!P2.onCreatePanelMenu(jVar.a, jVar.f673h)) {
                    jVar.a(null);
                    if (z2 && (c0Var2 = this.f656l) != null) {
                        c0Var2.a(null, this.m);
                    }
                    return false;
                }
                jVar.p = false;
            }
            jVar.f673h.z();
            Bundle bundle = jVar.q;
            if (bundle != null) {
                jVar.f673h.v(bundle);
                jVar.q = null;
            }
            if (!P2.onPreparePanel(0, jVar.f672g, jVar.f673h)) {
                if (z2 && (c0Var = this.f656l) != null) {
                    c0Var.a(null, this.m);
                }
                jVar.f673h.y();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            jVar.n = z3;
            jVar.f673h.setQwertyMode(z3);
            jVar.f673h.y();
        }
        jVar.f676k = true;
        jVar.f677l = false;
        this.G = jVar;
        return true;
    }

    public final boolean W() {
        ViewGroup viewGroup;
        if (this.t && (viewGroup = this.u) != null) {
            AtomicInteger atomicInteger = e.i.i.m.a;
            if (viewGroup.isLaidOut()) {
                return true;
            }
        }
        return false;
    }

    public final void X() {
        if (this.t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int Y(e.i.i.w wVar, Rect rect) {
        boolean z2;
        boolean z3;
        int i2;
        Context context;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int d2 = wVar.d();
        ActionBarContextView actionBarContextView = this.p;
        int i4 = 8;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            boolean z4 = true;
            if (this.p.isShown()) {
                if (this.W == null) {
                    this.W = new Rect();
                    this.X = new Rect();
                }
                Rect rect2 = this.W;
                Rect rect3 = this.X;
                rect2.set(wVar.b(), wVar.d(), wVar.c(), wVar.a());
                ViewGroup viewGroup = this.u;
                Method method = e1.a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception unused) {
                    }
                }
                int i5 = rect2.top;
                int i6 = rect2.left;
                int i7 = rect2.right;
                e.i.i.w j2 = e.i.i.m.j(this.u);
                int b2 = j2 == null ? 0 : j2.b();
                int c2 = j2 == null ? 0 : j2.c();
                if (marginLayoutParams2.topMargin == i5 && marginLayoutParams2.leftMargin == i6 && marginLayoutParams2.rightMargin == i7) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i5;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i7;
                    z3 = true;
                }
                if (i5 <= 0 || this.w != null) {
                    View view = this.w;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i3 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == b2 && marginLayoutParams.rightMargin == c2))) {
                        marginLayoutParams.height = i3;
                        marginLayoutParams.leftMargin = b2;
                        marginLayoutParams.rightMargin = c2;
                        this.w.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f649e);
                    this.w = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = b2;
                    layoutParams.rightMargin = c2;
                    this.u.addView(this.w, -1, layoutParams);
                }
                View view3 = this.w;
                z2 = view3 != null;
                if (z2 && view3.getVisibility() != 0) {
                    View view4 = this.w;
                    AtomicInteger atomicInteger = e.i.i.m.a;
                    if ((view4.getWindowSystemUiVisibility() & 8192) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        context = this.f649e;
                        i2 = R$color.abc_decor_view_status_guard_light;
                    } else {
                        context = this.f649e;
                        i2 = R$color.abc_decor_view_status_guard;
                    }
                    view4.setBackgroundColor(e.i.b.a.b(context, i2));
                }
                if (!this.B && z2) {
                    d2 = 0;
                }
                z4 = z3;
            } else {
                if (marginLayoutParams2.topMargin != 0) {
                    marginLayoutParams2.topMargin = 0;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z4) {
                this.p.setLayoutParams(marginLayoutParams2);
            }
        }
        View view5 = this.w;
        if (view5 != null) {
            if (z2) {
                i4 = 0;
            }
            view5.setVisibility(i4);
        }
        return d2;
    }

    @Override // e.b.e.i.g.a
    public boolean a(e.b.e.i.g gVar, MenuItem menuItem) {
        j M2;
        Window.Callback P2 = P();
        if (P2 == null || this.L || (M2 = M(gVar.k())) == null) {
            return false;
        }
        return P2.onMenuItemSelected(M2.a, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(e.b.e.i.g gVar) {
        c0 c0Var = this.f656l;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.f649e).hasPermanentMenuKey() && !this.f656l.b())) {
            j O2 = O(0);
            O2.o = true;
            F(O2, false);
            T(O2, null);
            return;
        }
        Window.Callback P2 = P();
        if (this.f656l.c()) {
            this.f656l.d();
            if (!this.L) {
                P2.onPanelClosed(108, O(0).f673h);
            }
        } else if (P2 != null && !this.L) {
            if (this.S && (1 & this.T) != 0) {
                this.f650f.getDecorView().removeCallbacks(this.U);
                this.U.run();
            }
            j O3 = O(0);
            e.b.e.i.g gVar2 = O3.f673h;
            if (gVar2 != null && !O3.p && P2.onPreparePanel(0, O3.f672g, gVar2)) {
                P2.onMenuOpened(108, O3.f673h);
                this.f656l.e();
            }
        }
    }

    @Override // e.b.a.l
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ((ViewGroup) this.u.findViewById(16908290)).addView(view, layoutParams);
        this.f651g.b.onContentChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0196  */
    @Override // e.b.a.l
    public Context d(Context context) {
        Configuration configuration;
        boolean z2;
        this.I = true;
        int i2 = this.M;
        if (i2 == -100) {
            i2 = -100;
        }
        int S2 = S(context, i2);
        if (c0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(G(context, S2, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof e.b.e.c) {
            try {
                ((e.b.e.c) context).a(G(context, S2, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!b0) {
            return context;
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                    float f2 = configuration2.fontScale;
                    float f3 = configuration3.fontScale;
                    if (f2 != f3) {
                        configuration.fontScale = f3;
                    }
                    int i3 = configuration2.mcc;
                    int i4 = configuration3.mcc;
                    if (i3 != i4) {
                        configuration.mcc = i4;
                    }
                    int i5 = configuration2.mnc;
                    int i6 = configuration3.mnc;
                    if (i5 != i6) {
                        configuration.mnc = i6;
                    }
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 24) {
                        LocaleList locales = configuration2.getLocales();
                        LocaleList locales2 = configuration3.getLocales();
                        if (!locales.equals(locales2)) {
                            configuration.setLocales(locales2);
                            configuration.locale = configuration3.locale;
                        }
                    } else if (!Objects.equals(configuration2.locale, configuration3.locale)) {
                        configuration.locale = configuration3.locale;
                    }
                    int i8 = configuration2.touchscreen;
                    int i9 = configuration3.touchscreen;
                    if (i8 != i9) {
                        configuration.touchscreen = i9;
                    }
                    int i10 = configuration2.keyboard;
                    int i11 = configuration3.keyboard;
                    if (i10 != i11) {
                        configuration.keyboard = i11;
                    }
                    int i12 = configuration2.keyboardHidden;
                    int i13 = configuration3.keyboardHidden;
                    if (i12 != i13) {
                        configuration.keyboardHidden = i13;
                    }
                    int i14 = configuration2.navigation;
                    int i15 = configuration3.navigation;
                    if (i14 != i15) {
                        configuration.navigation = i15;
                    }
                    int i16 = configuration2.navigationHidden;
                    int i17 = configuration3.navigationHidden;
                    if (i16 != i17) {
                        configuration.navigationHidden = i17;
                    }
                    int i18 = configuration2.orientation;
                    int i19 = configuration3.orientation;
                    if (i18 != i19) {
                        configuration.orientation = i19;
                    }
                    int i20 = configuration2.screenLayout & 15;
                    int i21 = configuration3.screenLayout & 15;
                    if (i20 != i21) {
                        configuration.screenLayout |= i21;
                    }
                    int i22 = configuration2.screenLayout & 192;
                    int i23 = configuration3.screenLayout & 192;
                    if (i22 != i23) {
                        configuration.screenLayout |= i23;
                    }
                    int i24 = configuration2.screenLayout & 48;
                    int i25 = configuration3.screenLayout & 48;
                    if (i24 != i25) {
                        configuration.screenLayout |= i25;
                    }
                    int i26 = configuration2.screenLayout & 768;
                    int i27 = configuration3.screenLayout & 768;
                    if (i26 != i27) {
                        configuration.screenLayout |= i27;
                    }
                    if (i7 >= 26) {
                        int i28 = configuration2.colorMode & 3;
                        int i29 = configuration3.colorMode & 3;
                        if (i28 != i29) {
                            configuration.colorMode |= i29;
                        }
                        int i30 = configuration2.colorMode & 12;
                        int i31 = configuration3.colorMode & 12;
                        if (i30 != i31) {
                            configuration.colorMode |= i31;
                        }
                    }
                    int i32 = configuration2.uiMode & 15;
                    int i33 = configuration3.uiMode & 15;
                    if (i32 != i33) {
                        configuration.uiMode |= i33;
                    }
                    int i34 = configuration2.uiMode & 48;
                    int i35 = configuration3.uiMode & 48;
                    if (i34 != i35) {
                        configuration.uiMode |= i35;
                    }
                    int i36 = configuration2.screenWidthDp;
                    int i37 = configuration3.screenWidthDp;
                    if (i36 != i37) {
                        configuration.screenWidthDp = i37;
                    }
                    int i38 = configuration2.screenHeightDp;
                    int i39 = configuration3.screenHeightDp;
                    if (i38 != i39) {
                        configuration.screenHeightDp = i39;
                    }
                    int i40 = configuration2.smallestScreenWidthDp;
                    int i41 = configuration3.smallestScreenWidthDp;
                    if (i40 != i41) {
                        configuration.smallestScreenWidthDp = i41;
                    }
                    int i42 = configuration2.densityDpi;
                    int i43 = configuration3.densityDpi;
                    if (i42 != i43) {
                        configuration.densityDpi = i43;
                    }
                }
            } else {
                configuration = null;
            }
            Configuration G2 = G(context, S2, configuration);
            e.b.e.c cVar = new e.b.e.c(context, R$style.Theme_AppCompat_Empty);
            cVar.a(G2);
            try {
                if (context.getTheme() != null) {
                    z2 = true;
                    if (z2) {
                        Resources.Theme theme = cVar.getTheme();
                        int i44 = Build.VERSION.SDK_INT;
                        if (i44 >= 29) {
                            theme.rebase();
                        } else if (i44 >= 23) {
                            synchronized (h.a.a) {
                                if (!h.a.c) {
                                    try {
                                        Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                        h.a.b = declaredMethod;
                                        declaredMethod.setAccessible(true);
                                    } catch (NoSuchMethodException unused3) {
                                    }
                                    h.a.c = true;
                                }
                                Method method = h.a.b;
                                if (method != null) {
                                    try {
                                        method.invoke(theme, new Object[0]);
                                    } catch (IllegalAccessException | InvocationTargetException unused4) {
                                        h.a.b = null;
                                    }
                                }
                            }
                        }
                    }
                    return cVar;
                }
            } catch (NullPointerException unused5) {
            }
            z2 = false;
            if (z2) {
            }
            return cVar;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    @Override // e.b.a.l
    public <T extends View> T e(int i2) {
        K();
        return (T) this.f650f.findViewById(i2);
    }

    @Override // e.b.a.l
    public int f() {
        return this.M;
    }

    @Override // e.b.a.l
    public MenuInflater g() {
        if (this.f654j == null) {
            Q();
            a aVar = this.f653i;
            this.f654j = new e.b.e.f(aVar != null ? aVar.e() : this.f649e);
        }
        return this.f654j;
    }

    @Override // e.b.a.l
    public a h() {
        Q();
        return this.f653i;
    }

    @Override // e.b.a.l
    public void i() {
        LayoutInflater from = LayoutInflater.from(this.f649e);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z2 = from.getFactory2() instanceof m;
        }
    }

    @Override // e.b.a.l
    public void j() {
        Q();
        a aVar = this.f653i;
        if (aVar == null || !aVar.f()) {
            R(0);
        }
    }

    @Override // e.b.a.l
    public void k(Configuration configuration) {
        if (this.z && this.t) {
            Q();
            a aVar = this.f653i;
            if (aVar != null) {
                aVar.g(configuration);
            }
        }
        e.b.f.j a2 = e.b.f.j.a();
        Context context = this.f649e;
        synchronized (a2) {
            n0 n0Var = a2.a;
            synchronized (n0Var) {
                e.e.e<WeakReference<Drawable.ConstantState>> eVar = n0Var.f914d.get(context);
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
        B(false);
    }

    @Override // e.b.a.l
    public void l(Bundle bundle) {
        this.I = true;
        B(false);
        L();
        Object obj = this.f648d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = h.q0(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a aVar = this.f653i;
                if (aVar == null) {
                    this.V = true;
                } else {
                    aVar.l(true);
                }
            }
            synchronized (l.c) {
                l.s(this);
                l.b.add(new WeakReference<>(this));
            }
        }
        this.J = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // e.b.a.l
    public void m() {
        a aVar;
        f fVar;
        f fVar2;
        if (this.f648d instanceof Activity) {
            synchronized (l.c) {
                l.s(this);
            }
        }
        if (this.S) {
            this.f650f.getDecorView().removeCallbacks(this.U);
        }
        this.K = false;
        this.L = true;
        if (this.M != -100) {
            Object obj = this.f648d;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                Z.put(this.f648d.getClass().getName(), Integer.valueOf(this.M));
                aVar = this.f653i;
                if (aVar != null) {
                    aVar.h();
                }
                fVar = this.Q;
                if (fVar != null) {
                    fVar.a();
                }
                fVar2 = this.R;
                if (fVar2 == null) {
                    fVar2.a();
                    return;
                }
                return;
            }
        }
        Z.remove(this.f648d.getClass().getName());
        aVar = this.f653i;
        if (aVar != null) {
        }
        fVar = this.Q;
        if (fVar != null) {
        }
        fVar2 = this.R;
        if (fVar2 == null) {
        }
    }

    @Override // e.b.a.l
    public void n(Bundle bundle) {
        K();
    }

    @Override // e.b.a.l
    public void o() {
        Q();
        a aVar = this.f653i;
        if (aVar != null) {
            aVar.o(true);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0177 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, e.b.a.s] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Unknown variable types count: 8 */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        char c2;
        ?? r2;
        e.b.f.f fVar;
        s sVar;
        if (this.Y == null) {
            String string = this.f649e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme).getString(androidx.appcompat.R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                sVar = new s();
            } else {
                try {
                    this.Y = (s) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    sVar = new s();
                }
            }
            this.Y = sVar;
        }
        ?? r7 = this.Y;
        int i2 = d1.a;
        Objects.requireNonNull(r7);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R$styleable.View, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.View_theme, 0);
        obtainStyledAttributes.recycle();
        Context cVar = (resourceId == 0 || ((context instanceof e.b.e.c) && ((e.b.e.c) context).a == resourceId)) ? context : new e.b.e.c(context, resourceId);
        str.hashCode();
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
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
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = '\r';
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
                fVar = new e.b.f.s(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 1:
                fVar = new e.b.f.h(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 2:
                fVar = new o(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 3:
                fVar = r7.e(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 4:
                fVar = new e.b.f.l(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 5:
                fVar = new e.b.f.t(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 6:
                fVar = new e.b.f.w(cVar, attributeSet, androidx.appcompat.R$attr.spinnerStyle);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 7:
                fVar = r7.d(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case '\b':
                fVar = new e.b.f.b0(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case '\t':
                fVar = new e.b.f.n(cVar, attributeSet, 0);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case '\n':
                fVar = r7.a(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case 11:
                fVar = r7.c(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case '\f':
                fVar = new e.b.f.k(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            case '\r':
                fVar = r7.b(cVar, attributeSet);
                r7.h(fVar, str);
                r2 = fVar;
                break;
            default:
                r2 = r7.f();
                break;
        }
        if (r2 == 0 && context != cVar) {
            r2 = 0;
            r2 = 0;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(r2, "class");
            }
            try {
                ?? r9 = r7.a;
                r9[0] = cVar;
                r9[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i3 = 0;
                    while (true) {
                        String[] strArr = s.f678d;
                        if (i3 < strArr.length) {
                            View g2 = r7.g(cVar, str, strArr[i3]);
                            if (g2 != null) {
                                ?? r72 = r7.a;
                                r72[0] = r2;
                                r72[1] = r2;
                                r2 = g2;
                            } else {
                                i3++;
                            }
                        }
                    }
                } else {
                    View g3 = r7.g(cVar, str, r2);
                    ?? r73 = r7.a;
                    r73[0] = r2;
                    r73[1] = r2;
                    r2 = g3;
                }
            } catch (Exception unused2) {
            } finally {
                ?? r74 = r7.a;
                r74[0] = r2;
                r74[1] = r2;
            }
        }
        if (r2 != 0) {
            Context context2 = r2.getContext();
            if (context2 instanceof ContextWrapper) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (r2.hasOnClickListeners()) {
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes((AttributeSet) attributeSet, s.c);
                    String string2 = obtainStyledAttributes2.getString(0);
                    if (string2 != null) {
                        r2.setOnClickListener(new s.a(r2, string2));
                    }
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return r2;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // e.b.a.l
    public void p(Bundle bundle) {
    }

    @Override // e.b.a.l
    public void q() {
        this.K = true;
        A();
    }

    @Override // e.b.a.l
    public void r() {
        this.K = false;
        Q();
        a aVar = this.f653i;
        if (aVar != null) {
            aVar.o(false);
        }
    }

    @Override // e.b.a.l
    public boolean t(int i2) {
        if (i2 == 8) {
            i2 = 108;
        } else if (i2 == 9) {
            i2 = 109;
        }
        if (this.D && i2 == 108) {
            return false;
        }
        if (this.z && i2 == 1) {
            this.z = false;
        }
        if (i2 == 1) {
            X();
            this.D = true;
            return true;
        } else if (i2 == 2) {
            X();
            this.x = true;
            return true;
        } else if (i2 == 5) {
            X();
            this.y = true;
            return true;
        } else if (i2 == 10) {
            X();
            this.B = true;
            return true;
        } else if (i2 == 108) {
            X();
            this.z = true;
            return true;
        } else if (i2 != 109) {
            return this.f650f.requestFeature(i2);
        } else {
            X();
            this.A = true;
            return true;
        }
    }

    @Override // e.b.a.l
    public void u(int i2) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f649e).inflate(i2, viewGroup);
        this.f651g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void v(View view) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f651g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void w(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f651g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void x(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.f648d instanceof Activity) {
            Q();
            a aVar = this.f653i;
            if (!(aVar instanceof w)) {
                this.f654j = null;
                if (aVar != null) {
                    aVar.h();
                }
                if (toolbar != null) {
                    Object obj = this.f648d;
                    t tVar = new t(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : this.f655k, this.f651g);
                    this.f653i = tVar;
                    window = this.f650f;
                    callback = tVar.c;
                } else {
                    this.f653i = null;
                    window = this.f650f;
                    callback = this.f651g;
                }
                window.setCallback(callback);
                j();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // e.b.a.l
    public void y(int i2) {
        this.N = i2;
    }

    @Override // e.b.a.l
    public final void z(CharSequence charSequence) {
        this.f655k = charSequence;
        c0 c0Var = this.f656l;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        a aVar = this.f653i;
        if (aVar != null) {
            aVar.q(charSequence);
            return;
        }
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public class d extends e.b.e.h {
        public d(Window.Callback callback) {
            super(callback);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
        public final ActionMode a(ActionMode.Callback callback) {
            e.b.e.a aVar;
            e.b.e.a aVar2;
            k kVar;
            e.b.e.c cVar;
            k kVar2;
            e.a aVar3 = new e.a(m.this.f649e, callback);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            e.b.e.a aVar4 = mVar.o;
            if (aVar4 != null) {
                aVar4.c();
            }
            c cVar2 = new c(aVar3);
            mVar.Q();
            a aVar5 = mVar.f653i;
            if (aVar5 != null) {
                e.b.e.a r = aVar5.r(cVar2);
                mVar.o = r;
                if (!(r == null || (kVar2 = mVar.f652h) == null)) {
                    kVar2.h(r);
                }
            }
            if (mVar.o == null) {
                mVar.J();
                e.b.e.a aVar6 = mVar.o;
                if (aVar6 != null) {
                    aVar6.c();
                }
                k kVar3 = mVar.f652h;
                if (kVar3 != null && !mVar.L) {
                    try {
                        aVar = kVar3.k(cVar2);
                    } catch (AbstractMethodError unused) {
                    }
                    if (aVar == null) {
                        mVar.o = aVar;
                    } else {
                        boolean z = true;
                        if (mVar.p == null) {
                            if (mVar.C) {
                                TypedValue typedValue = new TypedValue();
                                Resources.Theme theme = mVar.f649e.getTheme();
                                theme.resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = mVar.f649e.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    e.b.e.c cVar3 = new e.b.e.c(mVar.f649e, 0);
                                    cVar3.getTheme().setTo(newTheme);
                                    cVar = cVar3;
                                } else {
                                    cVar = mVar.f649e;
                                }
                                mVar.p = new ActionBarContextView(cVar, null);
                                PopupWindow popupWindow = new PopupWindow(cVar, (AttributeSet) null, androidx.appcompat.R$attr.actionModePopupWindowStyle);
                                mVar.q = popupWindow;
                                h.o1(popupWindow, 2);
                                mVar.q.setContentView(mVar.p);
                                mVar.q.setWidth(-1);
                                cVar.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarSize, typedValue, true);
                                mVar.p.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, cVar.getResources().getDisplayMetrics()));
                                mVar.q.setHeight(-2);
                                mVar.r = new p(mVar);
                            } else {
                                ViewStubCompat viewStubCompat = (ViewStubCompat) mVar.u.findViewById(androidx.appcompat.R$id.action_mode_bar_stub);
                                if (viewStubCompat != null) {
                                    mVar.Q();
                                    a aVar7 = mVar.f653i;
                                    Context e2 = aVar7 != null ? aVar7.e() : null;
                                    if (e2 == null) {
                                        e2 = mVar.f649e;
                                    }
                                    viewStubCompat.setLayoutInflater(LayoutInflater.from(e2));
                                    mVar.p = (ActionBarContextView) viewStubCompat.a();
                                }
                            }
                        }
                        if (mVar.p != null) {
                            mVar.J();
                            mVar.p.h();
                            Context context = mVar.p.getContext();
                            ActionBarContextView actionBarContextView = mVar.p;
                            if (mVar.q != null) {
                                z = false;
                            }
                            e.b.e.d dVar = new e.b.e.d(context, actionBarContextView, cVar2, z);
                            if (cVar2.c(dVar, dVar.f728i)) {
                                dVar.i();
                                mVar.p.f(dVar);
                                mVar.o = dVar;
                                if (mVar.W()) {
                                    mVar.p.setAlpha(0.0f);
                                    e.i.i.s b = e.i.i.m.b(mVar.p);
                                    b.a(1.0f);
                                    mVar.s = b;
                                    q qVar = new q(mVar);
                                    View view = b.a.get();
                                    if (view != null) {
                                        b.e(view, qVar);
                                    }
                                } else {
                                    mVar.p.setAlpha(1.0f);
                                    mVar.p.setVisibility(0);
                                    mVar.p.sendAccessibilityEvent(32);
                                    if (mVar.p.getParent() instanceof View) {
                                        AtomicInteger atomicInteger = e.i.i.m.a;
                                        ((View) mVar.p.getParent()).requestApplyInsets();
                                    }
                                }
                                if (mVar.q != null) {
                                    mVar.f650f.getDecorView().post(mVar.r);
                                }
                            } else {
                                mVar.o = null;
                            }
                        }
                    }
                    aVar2 = mVar.o;
                    if (!(aVar2 == null || (kVar = mVar.f652h) == null)) {
                        kVar.h(aVar2);
                    }
                    mVar.o = mVar.o;
                }
                aVar = null;
                if (aVar == null) {
                }
                aVar2 = mVar.o;
                kVar.h(aVar2);
                mVar.o = mVar.o;
            }
            e.b.e.a aVar8 = mVar.o;
            if (aVar8 != null) {
                return aVar3.e(aVar8);
            }
            return null;
        }

        @Override // e.b.e.h
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return m.this.H(keyEvent) || this.b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // e.b.e.h
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean z;
            if (!this.b.dispatchKeyShortcutEvent(keyEvent)) {
                m mVar = m.this;
                int keyCode = keyEvent.getKeyCode();
                mVar.Q();
                a aVar = mVar.f653i;
                if (aVar == null || !aVar.i(keyCode, keyEvent)) {
                    j jVar = mVar.G;
                    if (jVar == null || !mVar.U(jVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                        if (mVar.G == null) {
                            j O = mVar.O(0);
                            mVar.V(O, keyEvent);
                            boolean U = mVar.U(O, keyEvent.getKeyCode(), keyEvent, 1);
                            O.f676k = false;
                        }
                        z = false;
                        if (!z) {
                            return true;
                        }
                        return false;
                    }
                    j jVar2 = mVar.G;
                    if (jVar2 != null) {
                        jVar2.f677l = true;
                    }
                }
                z = true;
                if (!z) {
                }
            }
            return true;
        }

        @Override // e.b.e.h
        public void onContentChanged() {
        }

        @Override // e.b.e.h
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof e.b.e.i.g)) {
                return this.b.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // e.b.e.h
        public boolean onMenuOpened(int i2, Menu menu) {
            this.b.onMenuOpened(i2, menu);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            if (i2 == 108) {
                mVar.Q();
                a aVar = mVar.f653i;
                if (aVar != null) {
                    aVar.c(true);
                }
            }
            return true;
        }

        @Override // e.b.e.h
        public void onPanelClosed(int i2, Menu menu) {
            this.b.onPanelClosed(i2, menu);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            if (i2 == 108) {
                mVar.Q();
                a aVar = mVar.f653i;
                if (aVar != null) {
                    aVar.c(false);
                }
            } else if (i2 == 0) {
                j O = mVar.O(i2);
                if (O.m) {
                    mVar.F(O, false);
                }
            }
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            e.b.e.i.g gVar = menu instanceof e.b.e.i.g ? (e.b.e.i.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.x = true;
            }
            boolean onPreparePanel = this.b.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.x = false;
            }
            return onPreparePanel;
        }

        @Override // e.b.e.h, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            e.b.e.i.g gVar = m.this.O(0).f673h;
            if (gVar != null) {
                this.b.onProvideKeyboardShortcuts(list, gVar, i2);
            } else {
                this.b.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        @Override // e.b.e.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            Objects.requireNonNull(m.this);
            return a(callback);
        }

        @Override // e.b.e.h
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            Objects.requireNonNull(m.this);
            if (i2 != 0) {
                return this.b.onWindowStartingActionMode(callback, i2);
            }
            return a(callback);
        }
    }
}
