package e.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
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
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
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
import android.util.SparseArray;
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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.R$styleable;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.gms.common.api.Status;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.s;
import e.b.a.t;
import e.b.a.v;
import e.b.e.a;
import e.b.e.e;
import e.b.e.i.e;
import e.b.e.i.g;
import e.b.e.i.m;
import e.b.f.c1;
import e.b.f.f0;
import e.b.f.f1;
import e.b.f.g0;
import e.b.f.h1;
import e.b.f.i1;
import e.b.f.j1;
import e.b.f.r0;
import e.b.f.w;
import e.b0.e;
import e.b0.o;
import e.b0.r;
import e.g.a.b;
import e.g.a.i.d;
import e.g.a.i.l.n;
import e.i.b.b.h;
import e.i.g.b;
import e.i.i.h;
import e.i.i.v;
import e.i.i.x;
import e.i.i.z;
import e.n.a.m;
import e.q.b0;
import e.q.d0;
import e.q.h;
import e.q.q;
import e.u.g;
import f.a.b.b;
import f.a.b.t;
import f.a.b.u;
import f.b.a.a.a.d0.a5;
import f.b.a.a.a.d0.w5;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.p;
import f.b.a.b.h.e;
import f.b.a.d.a.d0;
import gov.ut.covid19.exposurenotifications.R;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class m extends l implements g.a, LayoutInflater.Factory2 {
    public static final e.e.h<String, Integer> a0 = new e.e.h<>();
    public static final int[] b0 = {16842836};
    public static final boolean c0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean d0 = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public k[] G;
    public k H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public Configuration M;
    public int N = -100;
    public int O;
    public boolean P;
    public boolean Q;
    public h R;
    public h S;
    public boolean T;
    public int U;
    public final Runnable V = new a();
    public boolean W;
    public Rect X;
    public Rect Y;
    public s Z;

    /* renamed from: d  reason: collision with root package name */
    public final Object f651d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f652e;

    /* renamed from: f  reason: collision with root package name */
    public Window f653f;

    /* renamed from: g  reason: collision with root package name */
    public f f654g;

    /* renamed from: h  reason: collision with root package name */
    public final k f655h;

    /* renamed from: i  reason: collision with root package name */
    public a f656i;

    /* renamed from: j  reason: collision with root package name */
    public MenuInflater f657j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f658k;

    /* renamed from: l  reason: collision with root package name */
    public g0 f659l;
    public c m;
    public l n;
    public e.b.e.a o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public x s = null;
    public boolean t = true;
    public boolean u;
    public ViewGroup v;
    public TextView w;
    public View x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            m mVar = m.this;
            if ((mVar.U & 1) != 0) {
                mVar.I(0);
            }
            m mVar2 = m.this;
            if ((mVar2.U & 4096) != 0) {
                mVar2.I(108);
            }
            m mVar3 = m.this;
            mVar3.T = false;
            mVar3.U = 0;
        }
    }

    public interface b {
    }

    public final class c implements m.a {
        public c() {
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

    public class d implements a.AbstractC0015a {
        public a.AbstractC0015a a;

        public class a extends z {
            public a() {
            }

            @Override // e.i.i.y
            public void a(View view) {
                m.this.p.setVisibility(8);
                m mVar = m.this;
                PopupWindow popupWindow = mVar.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (mVar.p.getParent() instanceof View) {
                    AtomicInteger atomicInteger = v.a;
                    v.h.c((View) m.this.p.getParent());
                }
                m.this.p.h();
                m.this.s.d(null);
                m mVar2 = m.this;
                mVar2.s = null;
                ViewGroup viewGroup = mVar2.v;
                AtomicInteger atomicInteger2 = v.a;
                v.h.c(viewGroup);
            }
        }

        public d(a.AbstractC0015a aVar) {
            this.a = aVar;
        }

        @Override // e.b.e.a.AbstractC0015a
        public boolean a(e.b.e.a aVar, Menu menu) {
            ViewGroup viewGroup = m.this.v;
            AtomicInteger atomicInteger = v.a;
            v.h.c(viewGroup);
            return this.a.a(aVar, menu);
        }

        @Override // e.b.e.a.AbstractC0015a
        public boolean b(e.b.e.a aVar, MenuItem menuItem) {
            return this.a.b(aVar, menuItem);
        }

        @Override // e.b.e.a.AbstractC0015a
        public boolean c(e.b.e.a aVar, Menu menu) {
            return this.a.c(aVar, menu);
        }

        @Override // e.b.e.a.AbstractC0015a
        public void d(e.b.e.a aVar) {
            this.a.d(aVar);
            m mVar = m.this;
            if (mVar.q != null) {
                mVar.f653f.getDecorView().removeCallbacks(m.this.r);
            }
            m mVar2 = m.this;
            if (mVar2.p != null) {
                mVar2.J();
                m mVar3 = m.this;
                x b2 = v.b(mVar3.p);
                b2.a(0.0f);
                mVar3.s = b2;
                x xVar = m.this.s;
                a aVar2 = new a();
                View view = xVar.a.get();
                if (view != null) {
                    xVar.e(view, aVar2);
                }
            }
            m mVar4 = m.this;
            k kVar = mVar4.f655h;
            if (kVar != null) {
                kVar.j(mVar4.o);
            }
            m mVar5 = m.this;
            mVar5.o = null;
            ViewGroup viewGroup = mVar5.v;
            AtomicInteger atomicInteger = v.a;
            v.h.c(viewGroup);
        }
    }

    public static class e {
        public static Field a;
        public static boolean b;
        public static Class<?> c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f660d;

        /* renamed from: e  reason: collision with root package name */
        public static Field f661e;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f662f;

        /* renamed from: g  reason: collision with root package name */
        public static Field f663g;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f664h;

        /* renamed from: i  reason: collision with root package name */
        public static Method f665i;

        /* renamed from: j  reason: collision with root package name */
        public static boolean f666j;

        /* renamed from: k  reason: collision with root package name */
        public static Method f667k;

        /* renamed from: l  reason: collision with root package name */
        public static boolean f668l;
        public static Field m;
        public static boolean n;
        public static Method o;
        public static boolean p;
        public static Field q;
        public static boolean r;
        public static long s;
        public static Method t;

        public static float[] A(float[] fArr, int i2, int i3) {
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

        public static String A0(String str) {
            return f.a.a.a.a.w("TransportRuntime.", str);
        }

        public static void A1(PopupWindow popupWindow, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                e.i.j.e.d(popupWindow, i2);
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

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
        public static boolean B(File file, Resources resources, int i2) {
            InputStream inputStream;
            Throwable th;
            try {
                inputStream = resources.openRawResource(i2);
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

        public static File B0(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder h2 = f.a.a.a.a.h(".font");
            h2.append(Process.myPid());
            h2.append("-");
            h2.append(Process.myTid());
            h2.append("-");
            String sb = h2.toString();
            for (int i2 = 0; i2 < 100; i2++) {
                File file = new File(cacheDir, f.a.a.a.a.t(sb, i2));
                try {
                    if (file.createNewFile()) {
                        return file;
                    }
                } catch (IOException unused) {
                }
            }
            return null;
        }

        public static void B1(XmlPullParser xmlPullParser) {
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

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
            if (r9 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r4 != false) goto L_0x0074;
         */
        public static b.a C0(TextView textView) {
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

        public static void C1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            parcel.setDataPosition(parcel.dataPosition() + n1(parcel, i2));
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        public static e.m.a.j D(Context context) {
            ProviderInfo providerInfo;
            e.i.f.e eVar;
            ApplicationInfo applicationInfo;
            e.m.a.b dVar = Build.VERSION.SDK_INT > 28 ? new e.m.a.d() : new e.m.a.c();
            PackageManager packageManager = context.getPackageManager();
            q(packageManager, "Package manager required to locate emoji font provider");
            Iterator<ResolveInfo> it = dVar.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    providerInfo = null;
                    break;
                }
                providerInfo = dVar.a(it.next());
                boolean z = true;
                if (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (providerInfo != null) {
                try {
                    String str = providerInfo.authority;
                    String str2 = providerInfo.packageName;
                    Signature[] b2 = dVar.b(packageManager, str2);
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : b2) {
                        arrayList.add(signature.toByteArray());
                    }
                    eVar = new e.i.f.e(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (eVar != null) {
                    return null;
                }
                return new e.m.a.j(context, eVar);
            }
            eVar = null;
            if (eVar != null) {
            }
        }

        public static boolean D0(XmlPullParser xmlPullParser, String str) {
            return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
        }

        public static int D1(e.b0.v vVar) {
            int ordinal = vVar.ordinal();
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
                            throw new IllegalArgumentException("Could not convert " + vVar + " to int");
                        }
                    }
                }
            }
            return i2;
        }

        @RecentlyNonNull
        public static Bundle E(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            Bundle readBundle = parcel.readBundle();
            parcel.setDataPosition(dataPosition + n1);
            return readBundle;
        }

        public static e.b0.a E0(int i2) {
            if (i2 == 0) {
                return e.b0.a.EXPONENTIAL;
            }
            if (i2 == 1) {
                return e.b0.a.LINEAR;
            }
            throw new IllegalArgumentException(f.a.a.a.a.u("Could not convert ", i2, " to BackoffPolicy"));
        }

        public static List<byte[]> E1(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        @RecentlyNonNull
        public static byte[] F(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            byte[] createByteArray = parcel.createByteArray();
            parcel.setDataPosition(dataPosition + n1);
            return createByteArray;
        }

        public static o F0(int i2) {
            if (i2 == 0) {
                return o.NOT_REQUIRED;
            }
            if (i2 == 1) {
                return o.CONNECTED;
            }
            if (i2 == 2) {
                return o.UNMETERED;
            }
            if (i2 == 3) {
                return o.NOT_ROAMING;
            }
            if (i2 == 4) {
                return o.METERED;
            }
            if (Build.VERSION.SDK_INT >= 30 && i2 == 5) {
                return o.TEMPORARILY_UNMETERED;
            }
            throw new IllegalArgumentException(f.a.a.a.a.u("Could not convert ", i2, " to NetworkType"));
        }

        public static h0.b F1(String str) {
            if (str == null) {
                return null;
            }
            return h0.b.valueOf(str);
        }

        @RecentlyNonNull
        public static ArrayList<Double> G(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            ArrayList<Double> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                arrayList.add(Double.valueOf(parcel.readDouble()));
            }
            parcel.setDataPosition(dataPosition + n1);
            return arrayList;
        }

        public static r G0(int i2) {
            if (i2 == 0) {
                return r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
            }
            if (i2 == 1) {
                return r.DROP_WORK_REQUEST;
            }
            throw new IllegalArgumentException(f.a.a.a.a.u("Could not convert ", i2, " to OutOfQuotaPolicy"));
        }

        public static l.b.a.f G1(String str) {
            if (str == null) {
                return null;
            }
            l.b.a.f fVar = l.b.a.f.f4357e;
            return l.b.a.f.T(str, l.b.a.v.c.f4436h);
        }

        @RecentlyNonNull
        public static int[] H(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            int[] createIntArray = parcel.createIntArray();
            parcel.setDataPosition(dataPosition + n1);
            return createIntArray;
        }

        public static e.b0.v H0(int i2) {
            if (i2 == 0) {
                return e.b0.v.ENQUEUED;
            }
            if (i2 == 1) {
                return e.b0.v.RUNNING;
            }
            if (i2 == 2) {
                return e.b0.v.SUCCEEDED;
            }
            if (i2 == 3) {
                return e.b0.v.FAILED;
            }
            if (i2 == 4) {
                return e.b0.v.BLOCKED;
            }
            if (i2 == 5) {
                return e.b0.v.CANCELLED;
            }
            throw new IllegalArgumentException(f.a.a.a.a.u("Could not convert ", i2, " to State"));
        }

        public static h0.c H1(String str) {
            if (str == null) {
                return null;
            }
            return h0.c.valueOf(str);
        }

        @RecentlyNonNull
        public static ArrayList<Integer> I(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            int readInt = parcel.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            parcel.setDataPosition(dataPosition + n1);
            return arrayList;
        }

        public static boolean I0() {
            if (Build.VERSION.SDK_INT < 31) {
                String str = Build.VERSION.CODENAME;
                return !"REL".equals(str) && str.compareTo("S") >= 0;
            }
        }

        public static h0.d I1(String str) {
            if (str == null) {
                return null;
            }
            return h0.d.valueOf(str);
        }

        public static Snackbar J(View view, int i2) {
            Snackbar j2 = Snackbar.j(view, view.getContext().getString(i2), 0);
            ((TextView) j2.c.findViewById(R.id.snackbar_text)).setMaxLines(5);
            return j2;
        }

        public static boolean J0(Rect rect, Rect rect2, int i2) {
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

        public static h0.e J1(String str) {
            if (str == null) {
                return null;
            }
            return h0.e.valueOf(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
            if (r13 == false) goto L_0x008d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ NumberFormatException -> 0x00ba }, LOOP:3: B:25:0x006d->B:45:0x0098, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d7 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0097 A[SYNTHETIC] */
        public static e.i.c.d[] K(String str) {
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
                                    fArr = A(fArr2, i2, i6);
                                    i2 = 0;
                                } catch (NumberFormatException e2) {
                                    throw new RuntimeException(f.a.a.a.a.c("error in parsing \"", trim, "\""), e2);
                                }
                            }
                            arrayList.add(new e.i.c.d(trim.charAt(i2), fArr));
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
                arrayList.add(new e.i.c.d(str.charAt(i4), new float[0]));
            }
            return (e.i.c.d[]) arrayList.toArray(new e.i.c.d[arrayList.size()]);
        }

        public static boolean K0(h0 h0Var) {
            return h0Var.f() && a5.b(h0Var) && h0Var.m() != h0.c.SHARED;
        }

        @RecentlyNonNull
        public static <ResultT> boolean K1(@RecentlyNonNull Status status, ResultT resultt, @RecentlyNonNull f.b.a.c.i.i<ResultT> iVar) {
            return status.d() ? iVar.b(resultt) : iVar.a(new f.b.a.c.b.l.b(status));
        }

        @RecentlyNonNull
        public static <T extends Parcelable> T L(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            T createFromParcel = creator.createFromParcel(parcel);
            parcel.setDataPosition(dataPosition + n1);
            return createFromParcel;
        }

        public static boolean L0(h0 h0Var) {
            return (h0Var != null ? h0Var.e() : -1) > 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Drawable> T L1(Drawable drawable) {
            return drawable instanceof e.i.c.m.b ? (T) ((e.i.c.m.b) drawable).a() : drawable;
        }

        public static Path M(String str) {
            Path path = new Path();
            e.i.c.d[] K = K(str);
            if (K == null) {
                return null;
            }
            try {
                e.i.c.d.b(K, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException(f.a.a.a.a.w("Error in parsing ", str), e2);
            }
        }

        public static boolean M0() {
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

        public static ActionMode.Callback M1(ActionMode.Callback callback) {
            return (!(callback instanceof e.i.j.f) || Build.VERSION.SDK_INT < 26) ? callback : ((e.i.j.f) callback).a;
        }

        public static Intent N(Context context) {
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

        public static boolean N0(Context context) {
            return context.getResources().getBoolean(R.bool.enx_enableTextMessageVerification) && !TextUtils.isEmpty(context.getString(R.string.enx_testVerificationNotificationBody));
        }

        public static boolean N1(d.a aVar, d.a aVar2, d.a aVar3, d.a aVar4) {
            d.a aVar5 = d.a.MATCH_PARENT;
            d.a aVar6 = d.a.WRAP_CONTENT;
            d.a aVar7 = d.a.FIXED;
            return (aVar3 == aVar7 || aVar3 == aVar6 || (aVar3 == aVar5 && aVar != aVar6)) || (aVar4 == aVar7 || aVar4 == aVar6 || (aVar4 == aVar5 && aVar2 != aVar6));
        }

        @RecentlyNonNull
        public static String O(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            String readString = parcel.readString();
            parcel.setDataPosition(dataPosition + n1);
            return readString;
        }

        public static void O0(Context context) {
            Intent N = N(context);
            if (N != null) {
                context.startActivity(N);
                return;
            }
            throw new UnsupportedOperationException("This device does not support storage management");
        }

        @RecentlyNonNull
        public static int O1(@RecentlyNonNull Parcel parcel) {
            int readInt = parcel.readInt();
            int n1 = n1(parcel, readInt);
            int dataPosition = parcel.dataPosition();
            if ((65535 & readInt) != 20293) {
                String valueOf = String.valueOf(Integer.toHexString(readInt));
                throw new f.b.a.c.b.m.n.b(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
            }
            int i2 = n1 + dataPosition;
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
        public static <T> T[] P(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            T[] tArr = (T[]) parcel.createTypedArray(creator);
            parcel.setDataPosition(dataPosition + n1);
            return tArr;
        }

        public static e.n.a.v P0(Context context, e.n.a.m mVar, boolean z, boolean z2) {
            int i2;
            m.d dVar = mVar.I;
            boolean z3 = false;
            int i3 = dVar == null ? 0 : dVar.f1737h;
            int x = z2 ? z ? mVar.x() : mVar.y() : z ? mVar.k() : mVar.o();
            mVar.w0(0, 0, 0, 0);
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
            Animation R = mVar.R();
            if (R != null) {
                return new e.n.a.v(R);
            }
            Animator S = mVar.S();
            if (S != null) {
                return new e.n.a.v(S);
            }
            if (x == 0 && i3 != 0) {
                if (i3 == 4097) {
                    i2 = z ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
                } else if (i3 == 4099) {
                    i2 = z ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
                } else if (i3 != 8194) {
                    x = -1;
                } else {
                    i2 = z ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
                }
                x = i2;
            }
            if (x != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(x));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, x);
                        if (loadAnimation != null) {
                            return new e.n.a.v(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, x);
                        if (loadAnimator != null) {
                            return new e.n.a.v(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, x);
                            if (loadAnimation2 != null) {
                                return new e.n.a.v(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            return null;
        }

        public static Drawable P1(Drawable drawable) {
            return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof e.i.c.m.a)) ? new e.i.c.m.d(drawable) : drawable;
        }

        @RecentlyNonNull
        public static <T> ArrayList<T> Q(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(dataPosition + n1);
            return createTypedArrayList;
        }

        public static int Q0(int i2, Rect rect, Rect rect2) {
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

        public static ActionMode.Callback Q1(TextView textView, ActionMode.Callback callback) {
            int i2 = Build.VERSION.SDK_INT;
            return (i2 < 26 || i2 > 27 || (callback instanceof e.i.j.f) || callback == null) ? callback : new e.i.j.f(callback, textView);
        }

        public static void R(String str, String str2, Object obj) {
            A0(str);
            String.format(str2, obj);
        }

        public static <X, Y> LiveData<Y> R0(LiveData<X> liveData, e.c.a.c.a<X, Y> aVar) {
            q qVar = new q();
            qVar.m(liveData, new b0(qVar, aVar));
            return qVar;
        }

        public static void R1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Bundle bundle, @RecentlyNonNull boolean z) {
            if (bundle != null) {
                int b2 = b2(parcel, i2);
                parcel.writeBundle(bundle);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        public static <T extends e.u.g> g.a<T> S(Context context, Class<T> cls, String str) {
            if (str.trim().length() != 0) {
                return new g.a<>(context, cls, str);
            }
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }

        public static void S0(Context context, View view) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        public static void S1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z) {
            if (bArr != null) {
                int b2 = b2(parcel, i2);
                parcel.writeByteArray(bArr);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        public static e.i.c.d[] T(e.i.c.d[] dVarArr) {
            if (dVarArr == null) {
                return null;
            }
            e.i.c.d[] dVarArr2 = new e.i.c.d[dVarArr.length];
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                dVarArr2[i2] = new e.i.c.d(dVarArr[i2]);
            }
            return dVarArr2;
        }

        public static void T0(View view, String str) {
            if (view != null && !TextUtils.isEmpty(str)) {
                Snackbar.j(view, str, 0).l();
            }
        }

        public static void T1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<Double> list, @RecentlyNonNull boolean z) {
            int b2 = b2(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeDouble(list.get(i3).doubleValue());
            }
            g2(parcel, b2);
        }

        public static <X> LiveData<X> U(LiveData<X> liveData) {
            q qVar = new q();
            qVar.m(liveData, new d0(qVar));
            return qVar;
        }

        public static int U0(int i2, Rect rect, Rect rect2) {
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

        public static void U1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z) {
            if (iBinder != null) {
                int b2 = b2(parcel, i2);
                parcel.writeStrongBinder(iBinder);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        public static void V(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            if (parcel.dataPosition() != i2) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Overread allowed size end=");
                sb.append(i2);
                throw new f.b.a.c.b.m.n.b(sb.toString(), parcel);
            }
        }

        public static ByteBuffer V0(Context context, CancellationSignal cancellationSignal, Uri uri) {
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

        public static void V1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z) {
            if (iArr != null) {
                int b2 = b2(parcel, i2);
                parcel.writeIntArray(iArr);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        @RecentlyNonNull
        public static boolean W(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        public static TypedArray W0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
            return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }

        public static void W1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<Integer> list, @RecentlyNonNull boolean z) {
            int b2 = b2(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            g2(parcel, b2);
        }

        public static n X(e.g.a.i.d dVar, int i2, ArrayList<n> arrayList, n nVar) {
            e.g.a.i.c cVar;
            int i3;
            int i4 = i2 == 0 ? dVar.o0 : dVar.p0;
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
                if (dVar instanceof e.g.a.i.h) {
                    e.g.a.i.h hVar = (e.g.a.i.h) dVar;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= hVar.r0) {
                            i3 = -1;
                            break;
                        }
                        e.g.a.i.d dVar2 = hVar.q0[i7];
                        if ((i2 == 0 && (i3 = dVar2.o0) != -1) || (i2 == 1 && (i3 = dVar2.p0) != -1)) {
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
                if (dVar instanceof e.g.a.i.f) {
                    e.g.a.i.f fVar = (e.g.a.i.f) dVar;
                    e.g.a.i.c cVar2 = fVar.t0;
                    if (fVar.u0 == 0) {
                        i5 = 1;
                    }
                    cVar2.b(i5, arrayList, nVar);
                }
                if (i2 == 0) {
                    dVar.o0 = nVar.b;
                    dVar.I.b(i2, arrayList, nVar);
                    cVar = dVar.K;
                } else {
                    dVar.p0 = nVar.b;
                    dVar.J.b(i2, arrayList, nVar);
                    dVar.M.b(i2, arrayList, nVar);
                    cVar = dVar.L;
                }
                cVar.b(i2, arrayList, nVar);
                dVar.P.b(i2, arrayList, nVar);
            }
            return nVar;
        }

        public static <T> ObjectAnimator X0(T t2, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path);
        }

        public static void X1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i3, @RecentlyNonNull boolean z) {
            if (parcelable != null) {
                int b2 = b2(parcel, i2);
                parcelable.writeToParcel(parcel, i3);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        public static n Y(ArrayList<n> arrayList, int i2) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                n nVar = arrayList.get(i3);
                if (i2 == nVar.b) {
                    return nVar;
                }
            }
            return null;
        }

        public static InputConnection Y0(InputConnection inputConnection, EditorInfo editorInfo, View view) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof j1) {
                        editorInfo.hintText = ((j1) parent).a();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }

        public static void Y1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
            if (str != null) {
                int b2 = b2(parcel, i2);
                parcel.writeString(str);
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x001f A[SYNTHETIC] */
        public static NavController Z(View view) {
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

        public static e.i.b.b.c Z0(XmlPullParser xmlPullParser, Resources resources) {
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
                    String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
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
                                    String string5 = obtainAttributes2.getString(i6);
                                    int i7 = obtainAttributes2.getInt(i5, 0);
                                    int i8 = R$styleable.FontFamilyFont_font;
                                    if (!obtainAttributes2.hasValue(i8)) {
                                        i8 = R$styleable.FontFamilyFont_android_font;
                                    }
                                    int resourceId2 = obtainAttributes2.getResourceId(i8, 0);
                                    String string6 = obtainAttributes2.getString(i8);
                                    obtainAttributes2.recycle();
                                    while (xmlPullParser.next() != 3) {
                                        B1(xmlPullParser);
                                    }
                                    arrayList.add(new e.i.b.b.e(string6, i3, z, string5, i7, resourceId2));
                                } else {
                                    B1(xmlPullParser);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new e.i.b.b.d((e.i.b.b.e[]) arrayList.toArray(new e.i.b.b.e[arrayList.size()]));
                    }
                    while (xmlPullParser.next() != 3) {
                        B1(xmlPullParser);
                    }
                    return new e.i.b.b.f(new e.i.f.e(string, string2, string3, i1(resources, resourceId)), integer, integer2, string4);
                }
                B1(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        public static <T extends Parcelable> void Z1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i3, @RecentlyNonNull boolean z) {
            if (tArr != null) {
                int b2 = b2(parcel, i2);
                int length = tArr.length;
                parcel.writeInt(length);
                for (T t2 : tArr) {
                    if (t2 == null) {
                        parcel.writeInt(0);
                    } else {
                        e2(parcel, t2, i3);
                    }
                }
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        public static JSONObject a(JSONObject jSONObject) {
            int length = jSONObject.toString().getBytes().length;
            int i2 = 1;
            while (length < 5000) {
                jSONObject.put("padding", a0.c(i2));
                length = jSONObject.toString().getBytes().length;
                i2++;
            }
            return jSONObject;
        }

        public static void a0(Object obj) {
            if (!f660d) {
                try {
                    c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException unused) {
                }
                f660d = true;
            }
            Class<?> cls = c;
            if (cls != null) {
                if (!f662f) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        f661e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused2) {
                    }
                    f662f = true;
                }
                Field field = f661e;
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

        public static b.a a1(f.a.b.k kVar) {
            long j2;
            long j3;
            boolean z;
            long j4;
            long j5;
            long j6;
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> map = kVar.c;
            String str = map.get("Date");
            long c1 = str != null ? c1(str) : 0;
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
            long c12 = str3 != null ? c1(str3) : 0;
            String str4 = map.get("Last-Modified");
            long c13 = str4 != null ? c1(str4) : 0;
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
                if (c1 <= 0 || c12 < c1) {
                    j5 = 0;
                } else {
                    j5 = currentTimeMillis + (c12 - c1);
                    j4 = j5;
                }
            }
            b.a aVar = new b.a();
            aVar.a = kVar.b;
            aVar.b = str5;
            aVar.f2124e = j5;
            aVar.f2123d = j4;
            aVar.c = c13;
            aVar.f2125f = map;
            aVar.f2126g = kVar.f2136d;
            return aVar;
        }

        public static <T extends Parcelable> void a2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z) {
            if (list != null) {
                int b2 = b2(parcel, i2);
                int size = list.size();
                parcel.writeInt(size);
                for (int i3 = 0; i3 < size; i3++) {
                    T t2 = list.get(i3);
                    if (t2 == null) {
                        parcel.writeInt(0);
                    } else {
                        e2(parcel, t2, 0);
                    }
                }
                g2(parcel, b2);
            } else if (z) {
                f2(parcel, i2, 0);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:181:0x02dd, code lost:
            if (r3[r17].f1295f.f1293d == r9) goto L_0x02e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0149, code lost:
            if (r4[r2].f1295f.f1293d == r5) goto L_0x014d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x02fa  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x035f  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x0387  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x0397  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x048e A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:278:0x04f9 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:311:0x056c  */
        /* JADX WARNING: Removed duplicated region for block: B:312:0x0571  */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x058a  */
        /* JADX WARNING: Removed duplicated region for block: B:325:0x05a2  */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x05ad  */
        /* JADX WARNING: Removed duplicated region for block: B:328:0x05b8  */
        /* JADX WARNING: Removed duplicated region for block: B:330:0x05bc  */
        /* JADX WARNING: Removed duplicated region for block: B:331:0x05bf  */
        /* JADX WARNING: Removed duplicated region for block: B:335:0x05dd  */
        /* JADX WARNING: Removed duplicated region for block: B:336:0x05df  */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x05f9  */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0606  */
        /* JADX WARNING: Removed duplicated region for block: B:373:0x065e  */
        /* JADX WARNING: Removed duplicated region for block: B:374:0x0666  */
        /* JADX WARNING: Removed duplicated region for block: B:377:0x0673  */
        /* JADX WARNING: Removed duplicated region for block: B:378:0x0676  */
        /* JADX WARNING: Removed duplicated region for block: B:394:0x06c6  */
        /* JADX WARNING: Removed duplicated region for block: B:407:0x070e  */
        /* JADX WARNING: Removed duplicated region for block: B:408:0x0710  */
        /* JADX WARNING: Removed duplicated region for block: B:411:0x071b  */
        /* JADX WARNING: Removed duplicated region for block: B:412:0x071e  */
        /* JADX WARNING: Removed duplicated region for block: B:415:0x0724  */
        /* JADX WARNING: Removed duplicated region for block: B:416:0x0727  */
        /* JADX WARNING: Removed duplicated region for block: B:418:0x072b  */
        /* JADX WARNING: Removed duplicated region for block: B:422:0x073a  */
        /* JADX WARNING: Removed duplicated region for block: B:424:0x073d  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x014f  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
        public static void b(e.g.a.i.e eVar, e.g.a.d dVar, ArrayList<e.g.a.i.d> arrayList, int i2) {
            int i3;
            e.g.a.i.b[] bVarArr;
            int i4;
            int i5;
            int i6;
            d.a aVar;
            boolean z;
            int i7;
            boolean z2;
            boolean z3;
            boolean z4;
            e.g.a.i.d dVar2;
            e.g.a.i.d dVar3;
            e.g.a.i.c cVar;
            e.g.a.i.d dVar4;
            int i8;
            e.g.a.i.c cVar2;
            e.g.a.g gVar;
            e.g.a.g gVar2;
            int i9;
            e.g.a.i.d dVar5;
            e.g.a.i.c cVar3;
            e.g.a.i.c cVar4;
            e.g.a.i.c cVar5;
            e.g.a.i.d dVar6;
            e.g.a.i.d dVar7;
            e.g.a.g gVar3;
            e.g.a.g gVar4;
            e.g.a.i.c cVar6;
            e.g.a.i.d dVar8;
            e.g.a.i.c cVar7;
            int i10;
            e.g.a.i.d dVar9;
            e.g.a.i.d dVar10;
            int i11;
            e.g.a.g gVar5;
            e.g.a.i.c cVar8;
            e.g.a.g gVar6;
            int d2;
            e.g.a.i.c cVar9;
            int size;
            int i12;
            ArrayList<e.g.a.i.d> arrayList2;
            int i13;
            e.g.a.i.b bVar;
            d.a aVar2;
            e.g.a.g gVar7;
            int i14;
            int i15;
            e.g.a.g gVar8;
            e.g.a.i.d dVar11;
            b.a aVar3;
            int i16;
            e.g.a.i.d dVar12;
            e.g.a.i.d dVar13;
            int i17;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            e.g.a.i.c cVar10;
            e.g.a.i.d dVar14;
            e.g.a.i.e eVar2 = eVar;
            ArrayList<e.g.a.i.d> arrayList3 = arrayList;
            d.a aVar4 = d.a.MATCH_CONSTRAINT;
            if (i2 == 0) {
                i4 = eVar2.z0;
                bVarArr = eVar2.C0;
                i3 = 0;
            } else {
                i4 = eVar2.A0;
                bVarArr = eVar2.B0;
                i3 = 2;
            }
            int i18 = 0;
            while (i18 < i4) {
                e.g.a.i.b bVar2 = bVarArr[i18];
                e.g.a.g gVar9 = null;
                int i19 = 8;
                int i20 = 1;
                if (!bVar2.t) {
                    int i21 = bVar2.o * 2;
                    e.g.a.i.d dVar15 = bVar2.a;
                    e.g.a.i.d dVar16 = dVar15;
                    boolean z9 = false;
                    while (!z9) {
                        bVar2.f1289i += i20;
                        e.g.a.i.d[] dVarArr = dVar15.n0;
                        int i22 = bVar2.o;
                        dVarArr[i22] = null;
                        dVar15.m0[i22] = null;
                        if (dVar15.h0 != i19) {
                            bVar2.f1292l += i20;
                            if (dVar15.k(i22) != aVar4) {
                                int i23 = bVar2.m;
                                int i24 = bVar2.o;
                                bVar2.m = i23 + (i24 == 0 ? dVar15.r() : i24 == i20 ? dVar15.l() : 0);
                            }
                            int d3 = dVar15.Q[i21].d() + bVar2.m;
                            bVar2.m = d3;
                            int i25 = i21 + 1;
                            bVar2.m = dVar15.Q[i25].d() + d3;
                            int d4 = dVar15.Q[i21].d() + bVar2.n;
                            bVar2.n = d4;
                            bVar2.n = dVar15.Q[i25].d() + d4;
                            if (bVar2.b == null) {
                                bVar2.b = dVar15;
                            }
                            bVar2.f1284d = dVar15;
                            d.a[] aVarArr = dVar15.T;
                            int i26 = bVar2.o;
                            if (aVarArr[i26] == aVar4) {
                                int[] iArr = dVar15.s;
                                if (iArr[i26] == 0 || iArr[i26] == 3 || iArr[i26] == 2) {
                                    bVar2.f1290j++;
                                    float[] fArr = dVar15.l0;
                                    float f2 = fArr[i26];
                                    if (f2 > 0.0f) {
                                        z8 = z9;
                                        bVar2.f1291k += fArr[i26];
                                    } else {
                                        z8 = z9;
                                    }
                                    if (dVar15.h0 != 8 && aVarArr[i26] == aVar4 && (iArr[i26] == 0 || iArr[i26] == 3)) {
                                        if (f2 < 0.0f) {
                                            bVar2.q = true;
                                        } else {
                                            bVar2.r = true;
                                        }
                                        if (bVar2.f1288h == null) {
                                            bVar2.f1288h = new ArrayList<>();
                                        }
                                        bVar2.f1288h.add(dVar15);
                                    }
                                    if (bVar2.f1286f == null) {
                                        bVar2.f1286f = dVar15;
                                    }
                                    e.g.a.i.d dVar17 = bVar2.f1287g;
                                    if (dVar17 != null) {
                                        dVar17.m0[bVar2.o] = dVar15;
                                    }
                                    bVar2.f1287g = dVar15;
                                } else {
                                    z8 = z9;
                                }
                                int i27 = bVar2.o;
                                if (dVar16 != dVar15) {
                                    dVar16.n0[bVar2.o] = dVar15;
                                }
                                cVar10 = dVar15.Q[i21 + 1].f1295f;
                                if (cVar10 != null) {
                                    dVar14 = cVar10.f1293d;
                                    e.g.a.i.c[] cVarArr = dVar14.Q;
                                    if (cVarArr[i21].f1295f != null) {
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
                                i20 = 1;
                                i19 = 8;
                                dVar15 = dVar14;
                            }
                        }
                        z8 = z9;
                        if (dVar16 != dVar15) {
                        }
                        cVar10 = dVar15.Q[i21 + 1].f1295f;
                        if (cVar10 != null) {
                        }
                        dVar14 = null;
                        if (dVar14 == null) {
                        }
                        dVar16 = dVar15;
                        i20 = 1;
                        i19 = 8;
                        dVar15 = dVar14;
                    }
                    e.g.a.i.d dVar18 = bVar2.b;
                    if (dVar18 != null) {
                        bVar2.m -= dVar18.Q[i21].d();
                    }
                    e.g.a.i.d dVar19 = bVar2.f1284d;
                    if (dVar19 != null) {
                        bVar2.m -= dVar19.Q[i21 + 1].d();
                    }
                    bVar2.c = dVar15;
                    if (bVar2.o != 0 || !bVar2.p) {
                        bVar2.f1285e = bVar2.a;
                    } else {
                        bVar2.f1285e = dVar15;
                    }
                    bVar2.s = bVar2.r && bVar2.q;
                }
                bVar2.t = true;
                if (arrayList3 == null || arrayList3.contains(bVar2.a)) {
                    e.g.a.i.d dVar20 = bVar2.a;
                    e.g.a.i.d dVar21 = bVar2.c;
                    e.g.a.i.d dVar22 = bVar2.b;
                    e.g.a.i.d dVar23 = bVar2.f1284d;
                    e.g.a.i.d dVar24 = bVar2.f1285e;
                    float f3 = bVar2.f1291k;
                    boolean z10 = eVar2.T[i2] == d.a.WRAP_CONTENT;
                    if (i2 == 0) {
                        int i28 = dVar24.j0;
                        boolean z11 = i28 == 0;
                        i7 = i18;
                        z5 = i28 == 1;
                        if (i28 == 2) {
                            z7 = z11;
                        } else {
                            z6 = z11;
                            z = z5;
                            z2 = z6;
                            z3 = false;
                            e.g.a.i.d dVar25 = dVar20;
                            z4 = false;
                            while (!z4) {
                                e.g.a.i.c cVar11 = dVar25.Q[i3];
                                int i29 = z3 ? 1 : 4;
                                int d5 = cVar11.d();
                                boolean z12 = dVar25.T[i2] == aVar4 && dVar25.s[i2] == 0;
                                e.g.a.i.c cVar12 = cVar11.f1295f;
                                if (!(cVar12 == null || dVar25 == dVar20)) {
                                    d5 = cVar12.d() + d5;
                                }
                                if (!z3 || dVar25 == dVar20 || dVar25 == dVar22) {
                                    i16 = i4;
                                } else {
                                    i16 = i4;
                                    i29 = 8;
                                }
                                e.g.a.i.c cVar13 = cVar11.f1295f;
                                if (cVar13 != null) {
                                    if (dVar25 == dVar22) {
                                        dVar12 = dVar20;
                                        dVar.f(cVar11.f1298i, cVar13.f1298i, d5, 6);
                                    } else {
                                        dVar12 = dVar20;
                                        dVar.f(cVar11.f1298i, cVar13.f1298i, d5, 8);
                                    }
                                    if (z12 && !z3) {
                                        i29 = 5;
                                    }
                                    dVar.d(cVar11.f1298i, cVar11.f1295f.f1298i, d5, (dVar25 != dVar22 || !z3 || !dVar25.S[i2]) ? i29 : 5);
                                } else {
                                    dVar12 = dVar20;
                                }
                                if (z10) {
                                    if (dVar25.h0 == 8 || dVar25.T[i2] != aVar4) {
                                        i17 = 0;
                                    } else {
                                        e.g.a.i.c[] cVarArr2 = dVar25.Q;
                                        i17 = 0;
                                        dVar.f(cVarArr2[i3 + 1].f1298i, cVarArr2[i3].f1298i, 0, 5);
                                    }
                                    dVar.f(dVar25.Q[i3].f1298i, eVar2.Q[i3].f1298i, i17, 8);
                                }
                                e.g.a.i.c cVar14 = dVar25.Q[i3 + 1].f1295f;
                                if (cVar14 != null) {
                                    dVar13 = cVar14.f1293d;
                                    e.g.a.i.c[] cVarArr3 = dVar13.Q;
                                    if (cVarArr3[i3].f1295f != null) {
                                    }
                                }
                                dVar13 = null;
                                if (dVar13 != null) {
                                    dVar25 = dVar13;
                                    z4 = z4;
                                } else {
                                    z4 = true;
                                }
                                i4 = i16;
                                dVar24 = dVar24;
                                dVar20 = dVar12;
                            }
                            i5 = i4;
                            if (dVar23 != null) {
                                int i30 = i3 + 1;
                                if (dVar21.Q[i30].f1295f != null) {
                                    e.g.a.i.c cVar15 = dVar23.Q[i30];
                                    if ((dVar23.T[i2] == aVar4 && dVar23.s[i2] == 0) && !z3) {
                                        e.g.a.i.c cVar16 = cVar15.f1295f;
                                        if (cVar16.f1293d == eVar2) {
                                            dVar.d(cVar15.f1298i, cVar16.f1298i, -cVar15.d(), 5);
                                            dVar.g(cVar15.f1298i, dVar21.Q[i30].f1295f.f1298i, -cVar15.d(), 6);
                                            if (z10) {
                                                int i31 = i3 + 1;
                                                e.g.a.g gVar10 = eVar2.Q[i31].f1298i;
                                                e.g.a.i.c[] cVarArr4 = dVar21.Q;
                                                dVar.f(gVar10, cVarArr4[i31].f1298i, cVarArr4[i31].d(), 8);
                                            }
                                            ArrayList<e.g.a.i.d> arrayList4 = bVar2.f1288h;
                                            if (arrayList4 != null && (size = arrayList4.size()) > 1) {
                                                float f4 = (bVar2.q || bVar2.s) ? f3 : (float) bVar2.f1290j;
                                                e.g.a.i.d dVar26 = null;
                                                float f5 = 0.0f;
                                                i12 = 0;
                                                while (i12 < size) {
                                                    e.g.a.i.d dVar27 = arrayList4.get(i12);
                                                    float f6 = dVar27.l0[i2];
                                                    if (f6 < 0.0f) {
                                                        if (bVar2.s) {
                                                            e.g.a.i.c[] cVarArr5 = dVar27.Q;
                                                            e.g.a.g gVar11 = cVarArr5[i3 + 1].f1298i;
                                                            gVar8 = cVarArr5[i3].f1298i;
                                                            aVar2 = aVar4;
                                                            gVar7 = gVar11;
                                                            i15 = 0;
                                                            i14 = 4;
                                                            dVar.d(gVar7, gVar8, i15, i14);
                                                            bVar = bVar2;
                                                            arrayList2 = arrayList4;
                                                            i13 = size;
                                                            i12++;
                                                            aVar4 = aVar2;
                                                            bVar2 = bVar;
                                                            size = i13;
                                                            arrayList4 = arrayList2;
                                                        } else {
                                                            f6 = 1.0f;
                                                        }
                                                    }
                                                    int i32 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                                                    if (i32 == 0) {
                                                        e.g.a.i.c[] cVarArr6 = dVar27.Q;
                                                        e.g.a.g gVar12 = cVarArr6[i3 + 1].f1298i;
                                                        gVar8 = cVarArr6[i3].f1298i;
                                                        aVar2 = aVar4;
                                                        gVar7 = gVar12;
                                                        i15 = 0;
                                                        i14 = 8;
                                                        dVar.d(gVar7, gVar8, i15, i14);
                                                        bVar = bVar2;
                                                        arrayList2 = arrayList4;
                                                        i13 = size;
                                                        i12++;
                                                        aVar4 = aVar2;
                                                        bVar2 = bVar;
                                                        size = i13;
                                                        arrayList4 = arrayList2;
                                                    } else {
                                                        aVar2 = aVar4;
                                                        if (dVar26 != null) {
                                                            e.g.a.i.c[] cVarArr7 = dVar26.Q;
                                                            e.g.a.g gVar13 = cVarArr7[i3].f1298i;
                                                            int i33 = i3 + 1;
                                                            e.g.a.g gVar14 = cVarArr7[i33].f1298i;
                                                            e.g.a.i.c[] cVarArr8 = dVar27.Q;
                                                            arrayList2 = arrayList4;
                                                            e.g.a.g gVar15 = cVarArr8[i3].f1298i;
                                                            e.g.a.g gVar16 = cVarArr8[i33].f1298i;
                                                            i13 = size;
                                                            e.g.a.b m2 = dVar.m();
                                                            dVar11 = dVar27;
                                                            m2.b = 0.0f;
                                                            bVar = bVar2;
                                                            float f7 = -1.0f;
                                                            if (f4 == 0.0f || f5 == f6) {
                                                                m2.f1254d.f(gVar13, 1.0f);
                                                                m2.f1254d.f(gVar14, -1.0f);
                                                                m2.f1254d.f(gVar16, 1.0f);
                                                                aVar3 = m2.f1254d;
                                                            } else {
                                                                if (f5 == 0.0f) {
                                                                    m2.f1254d.f(gVar13, 1.0f);
                                                                    m2.f1254d.f(gVar14, -1.0f);
                                                                } else if (i32 == 0) {
                                                                    m2.f1254d.f(gVar15, 1.0f);
                                                                    m2.f1254d.f(gVar16, -1.0f);
                                                                } else {
                                                                    float f8 = (f5 / f4) / (f6 / f4);
                                                                    m2.f1254d.f(gVar13, 1.0f);
                                                                    m2.f1254d.f(gVar14, -1.0f);
                                                                    m2.f1254d.f(gVar16, f8);
                                                                    aVar3 = m2.f1254d;
                                                                    f7 = -f8;
                                                                }
                                                                dVar.c(m2);
                                                            }
                                                            aVar3.f(gVar15, f7);
                                                            dVar.c(m2);
                                                        } else {
                                                            bVar = bVar2;
                                                            arrayList2 = arrayList4;
                                                            i13 = size;
                                                            dVar11 = dVar27;
                                                        }
                                                        f5 = f6;
                                                        dVar26 = dVar11;
                                                        i12++;
                                                        aVar4 = aVar2;
                                                        bVar2 = bVar;
                                                        size = i13;
                                                        arrayList4 = arrayList2;
                                                    }
                                                }
                                            }
                                            aVar = aVar4;
                                            if (dVar22 != null || (dVar22 != dVar23 && !z3)) {
                                                dVar3 = dVar23;
                                                dVar2 = dVar22;
                                                i9 = i7;
                                                if (z2 || dVar2 == null) {
                                                    i6 = i9;
                                                    int i34 = 8;
                                                    if (z && dVar2 != null) {
                                                        int i35 = bVar2.f1290j;
                                                        boolean z13 = i35 <= 0 && bVar2.f1289i == i35;
                                                        e.g.a.i.d dVar28 = dVar2;
                                                        dVar5 = dVar28;
                                                        while (dVar5 != null) {
                                                            e.g.a.i.d dVar29 = dVar5.n0[i2];
                                                            while (dVar29 != null && dVar29.h0 == i34) {
                                                                dVar29 = dVar29.n0[i2];
                                                            }
                                                            if (dVar5 == dVar2 || dVar5 == dVar3 || dVar29 == null) {
                                                                dVar6 = dVar28;
                                                                dVar7 = dVar29;
                                                            } else {
                                                                e.g.a.i.d dVar30 = dVar29 == dVar3 ? null : dVar29;
                                                                e.g.a.i.c cVar17 = dVar5.Q[i3];
                                                                e.g.a.g gVar17 = cVar17.f1298i;
                                                                int i36 = i3 + 1;
                                                                e.g.a.g gVar18 = dVar28.Q[i36].f1298i;
                                                                int d6 = cVar17.d();
                                                                int d7 = dVar5.Q[i36].d();
                                                                if (dVar30 != null) {
                                                                    cVar6 = dVar30.Q[i3];
                                                                    gVar4 = cVar6.f1298i;
                                                                    cVar7 = cVar6.f1295f;
                                                                    if (cVar7 == null) {
                                                                        gVar3 = null;
                                                                        int d8 = cVar6 == null ? cVar6.d() + d7 : d7;
                                                                        int d9 = dVar28.Q[i36].d() + d6;
                                                                        int i37 = !z13 ? 8 : 4;
                                                                        if (gVar17 != null || gVar18 == null || gVar4 == null || gVar3 == null) {
                                                                            dVar8 = dVar30;
                                                                            dVar6 = dVar28;
                                                                        } else {
                                                                            dVar8 = dVar30;
                                                                            dVar6 = dVar28;
                                                                            dVar.b(gVar17, gVar18, d9, 0.5f, gVar4, gVar3, d8, i37);
                                                                        }
                                                                        dVar7 = dVar8;
                                                                    }
                                                                } else {
                                                                    cVar6 = dVar3.Q[i3];
                                                                    gVar4 = cVar6 != null ? cVar6.f1298i : null;
                                                                    cVar7 = dVar5.Q[i36];
                                                                }
                                                                gVar3 = cVar7.f1298i;
                                                                if (cVar6 == null) {
                                                                }
                                                                int d92 = dVar28.Q[i36].d() + d6;
                                                                if (!z13) {
                                                                }
                                                                if (gVar17 != null) {
                                                                }
                                                                dVar8 = dVar30;
                                                                dVar6 = dVar28;
                                                                dVar7 = dVar8;
                                                            }
                                                            dVar28 = dVar5.h0 != 8 ? dVar5 : dVar6;
                                                            dVar5 = dVar7;
                                                            i34 = 8;
                                                        }
                                                        e.g.a.i.c cVar18 = dVar2.Q[i3];
                                                        cVar3 = dVar20.Q[i3].f1295f;
                                                        int i38 = i3 + 1;
                                                        cVar4 = dVar3.Q[i38];
                                                        cVar5 = dVar21.Q[i38].f1295f;
                                                        if (cVar3 != null) {
                                                            if (dVar2 != dVar3) {
                                                                dVar.d(cVar18.f1298i, cVar3.f1298i, cVar18.d(), 5);
                                                            } else if (cVar5 != null) {
                                                                dVar.b(cVar18.f1298i, cVar3.f1298i, cVar18.d(), 0.5f, cVar4.f1298i, cVar5.f1298i, cVar4.d(), 5);
                                                            }
                                                        }
                                                        if (!(cVar5 == null || dVar2 == dVar3)) {
                                                            dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                                                        }
                                                    }
                                                    if (!((!z2 && !z) || dVar2 == null || dVar2 == dVar3)) {
                                                        e.g.a.i.c[] cVarArr9 = dVar2.Q;
                                                        cVar = cVarArr9[i3];
                                                        dVar4 = dVar3 == null ? dVar2 : dVar3;
                                                        i8 = i3 + 1;
                                                        cVar2 = dVar4.Q[i8];
                                                        e.g.a.i.c cVar19 = cVar.f1295f;
                                                        gVar = cVar19 != null ? cVar19.f1298i : null;
                                                        e.g.a.i.c cVar20 = cVar2.f1295f;
                                                        e.g.a.g gVar19 = cVar20 != null ? cVar20.f1298i : null;
                                                        if (dVar21 != dVar4) {
                                                            e.g.a.i.c cVar21 = dVar21.Q[i8].f1295f;
                                                            if (cVar21 != null) {
                                                                gVar9 = cVar21.f1298i;
                                                            }
                                                            gVar2 = gVar9;
                                                        } else {
                                                            gVar2 = gVar19;
                                                        }
                                                        if (dVar2 == dVar4) {
                                                            cVar = cVarArr9[i3];
                                                            cVar2 = cVarArr9[i8];
                                                        }
                                                        if (!(gVar == null || gVar2 == null)) {
                                                            dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                                                        }
                                                    }
                                                } else {
                                                    int i39 = bVar2.f1290j;
                                                    boolean z14 = i39 > 0 && bVar2.f1289i == i39;
                                                    e.g.a.i.d dVar31 = dVar2;
                                                    e.g.a.i.d dVar32 = dVar31;
                                                    while (dVar32 != null) {
                                                        e.g.a.i.d dVar33 = dVar32.n0[i2];
                                                        while (true) {
                                                            if (dVar33 != null) {
                                                                if (dVar33.h0 != 8) {
                                                                    break;
                                                                }
                                                                dVar33 = dVar33.n0[i2];
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                        if (dVar33 != null || dVar32 == dVar3) {
                                                            e.g.a.i.c cVar22 = dVar32.Q[i3];
                                                            e.g.a.g gVar20 = cVar22.f1298i;
                                                            e.g.a.i.c cVar23 = cVar22.f1295f;
                                                            e.g.a.g gVar21 = cVar23 != null ? cVar23.f1298i : null;
                                                            if (dVar31 != dVar32) {
                                                                cVar9 = dVar31.Q[i3 + 1];
                                                            } else {
                                                                if (dVar32 == dVar2) {
                                                                    e.g.a.i.c[] cVarArr10 = dVar20.Q;
                                                                    if (cVarArr10[i3].f1295f != null) {
                                                                        cVar9 = cVarArr10[i3].f1295f;
                                                                    } else {
                                                                        gVar21 = null;
                                                                    }
                                                                }
                                                                int d10 = cVar22.d();
                                                                int i40 = i3 + 1;
                                                                int d11 = dVar32.Q[i40].d();
                                                                if (dVar33 == null) {
                                                                    cVar8 = dVar33.Q[i3];
                                                                } else {
                                                                    cVar8 = dVar21.Q[i40].f1295f;
                                                                    if (cVar8 == null) {
                                                                        dVar10 = dVar33;
                                                                        gVar5 = null;
                                                                        gVar6 = dVar32.Q[i40].f1298i;
                                                                        if (cVar8 != null) {
                                                                            d11 += cVar8.d();
                                                                        }
                                                                        d2 = dVar31.Q[i40].d() + d10;
                                                                        if (!(gVar20 == null || gVar21 == null || gVar5 == null || gVar6 == null)) {
                                                                            if (dVar32 == dVar2) {
                                                                                d2 = dVar2.Q[i3].d();
                                                                            }
                                                                            i10 = i9;
                                                                            i11 = 8;
                                                                            dVar9 = dVar31;
                                                                            dVar.b(gVar20, gVar21, d2, 0.5f, gVar5, gVar6, dVar32 == dVar3 ? dVar3.Q[i40].d() : d11, z14 ? 8 : 5);
                                                                            dVar31 = dVar32.h0 == i11 ? dVar32 : dVar9;
                                                                            dVar32 = dVar10;
                                                                            i9 = i10;
                                                                        }
                                                                    }
                                                                }
                                                                gVar5 = cVar8.f1298i;
                                                                dVar10 = dVar33;
                                                                gVar6 = dVar32.Q[i40].f1298i;
                                                                if (cVar8 != null) {
                                                                }
                                                                d2 = dVar31.Q[i40].d() + d10;
                                                                if (dVar32 == dVar2) {
                                                                }
                                                                i10 = i9;
                                                                i11 = 8;
                                                                dVar9 = dVar31;
                                                                dVar.b(gVar20, gVar21, d2, 0.5f, gVar5, gVar6, dVar32 == dVar3 ? dVar3.Q[i40].d() : d11, z14 ? 8 : 5);
                                                                if (dVar32.h0 == i11) {
                                                                }
                                                                dVar32 = dVar10;
                                                                i9 = i10;
                                                            }
                                                            gVar21 = cVar9.f1298i;
                                                            int d102 = cVar22.d();
                                                            int i402 = i3 + 1;
                                                            int d112 = dVar32.Q[i402].d();
                                                            if (dVar33 == null) {
                                                            }
                                                            gVar5 = cVar8.f1298i;
                                                            dVar10 = dVar33;
                                                            gVar6 = dVar32.Q[i402].f1298i;
                                                            if (cVar8 != null) {
                                                            }
                                                            d2 = dVar31.Q[i402].d() + d102;
                                                            if (dVar32 == dVar2) {
                                                            }
                                                            i10 = i9;
                                                            i11 = 8;
                                                            dVar9 = dVar31;
                                                            dVar.b(gVar20, gVar21, d2, 0.5f, gVar5, gVar6, dVar32 == dVar3 ? dVar3.Q[i402].d() : d112, z14 ? 8 : 5);
                                                            if (dVar32.h0 == i11) {
                                                            }
                                                            dVar32 = dVar10;
                                                            i9 = i10;
                                                        } else {
                                                            dVar10 = dVar33;
                                                        }
                                                        dVar9 = dVar31;
                                                        i10 = i9;
                                                        i11 = 8;
                                                        if (dVar32.h0 == i11) {
                                                        }
                                                        dVar32 = dVar10;
                                                        i9 = i10;
                                                    }
                                                }
                                            } else {
                                                e.g.a.i.c cVar24 = dVar20.Q[i3];
                                                int i41 = i3 + 1;
                                                e.g.a.i.c cVar25 = dVar21.Q[i41];
                                                e.g.a.i.c cVar26 = cVar24.f1295f;
                                                e.g.a.g gVar22 = cVar26 != null ? cVar26.f1298i : null;
                                                e.g.a.i.c cVar27 = cVar25.f1295f;
                                                e.g.a.g gVar23 = cVar27 != null ? cVar27.f1298i : null;
                                                e.g.a.i.c cVar28 = dVar22.Q[i3];
                                                if (dVar23 != null) {
                                                    cVar25 = dVar23.Q[i41];
                                                }
                                                if (gVar22 == null || gVar23 == null) {
                                                    dVar3 = dVar23;
                                                    dVar2 = dVar22;
                                                    i9 = i7;
                                                } else {
                                                    dVar3 = dVar23;
                                                    dVar2 = dVar22;
                                                    i9 = i7;
                                                    dVar.b(cVar28.f1298i, gVar22, cVar28.d(), i2 == 0 ? dVar24.e0 : dVar24.f0, gVar23, cVar25.f1298i, cVar25.d(), 7);
                                                }
                                            }
                                            i6 = i9;
                                            e.g.a.i.c[] cVarArr92 = dVar2.Q;
                                            cVar = cVarArr92[i3];
                                            if (dVar3 == null) {
                                            }
                                            i8 = i3 + 1;
                                            cVar2 = dVar4.Q[i8];
                                            e.g.a.i.c cVar192 = cVar.f1295f;
                                            if (cVar192 != null) {
                                            }
                                            e.g.a.i.c cVar202 = cVar2.f1295f;
                                            if (cVar202 != null) {
                                            }
                                            if (dVar21 != dVar4) {
                                            }
                                            if (dVar2 == dVar4) {
                                            }
                                            dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                                        }
                                    }
                                    if (z3) {
                                        e.g.a.i.c cVar29 = cVar15.f1295f;
                                        if (cVar29.f1293d == eVar2) {
                                            dVar.d(cVar15.f1298i, cVar29.f1298i, -cVar15.d(), 4);
                                            dVar.g(cVar15.f1298i, dVar21.Q[i30].f1295f.f1298i, -cVar15.d(), 6);
                                            if (z10) {
                                            }
                                            ArrayList<e.g.a.i.d> arrayList42 = bVar2.f1288h;
                                            if (bVar2.q) {
                                            }
                                            e.g.a.i.d dVar262 = null;
                                            float f52 = 0.0f;
                                            i12 = 0;
                                            while (i12 < size) {
                                            }
                                            aVar = aVar4;
                                            if (dVar22 != null) {
                                            }
                                            dVar3 = dVar23;
                                            dVar2 = dVar22;
                                            i9 = i7;
                                            if (z2) {
                                            }
                                            i6 = i9;
                                            int i342 = 8;
                                            int i352 = bVar2.f1290j;
                                            if (i352 <= 0) {
                                            }
                                            e.g.a.i.d dVar282 = dVar2;
                                            dVar5 = dVar282;
                                            while (dVar5 != null) {
                                            }
                                            e.g.a.i.c cVar182 = dVar2.Q[i3];
                                            cVar3 = dVar20.Q[i3].f1295f;
                                            int i382 = i3 + 1;
                                            cVar4 = dVar3.Q[i382];
                                            cVar5 = dVar21.Q[i382].f1295f;
                                            if (cVar3 != null) {
                                            }
                                            dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                                            e.g.a.i.c[] cVarArr922 = dVar2.Q;
                                            cVar = cVarArr922[i3];
                                            if (dVar3 == null) {
                                            }
                                            i8 = i3 + 1;
                                            cVar2 = dVar4.Q[i8];
                                            e.g.a.i.c cVar1922 = cVar.f1295f;
                                            if (cVar1922 != null) {
                                            }
                                            e.g.a.i.c cVar2022 = cVar2.f1295f;
                                            if (cVar2022 != null) {
                                            }
                                            if (dVar21 != dVar4) {
                                            }
                                            if (dVar2 == dVar4) {
                                            }
                                            dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                                        }
                                    }
                                    dVar.g(cVar15.f1298i, dVar21.Q[i30].f1295f.f1298i, -cVar15.d(), 6);
                                    if (z10) {
                                    }
                                    ArrayList<e.g.a.i.d> arrayList422 = bVar2.f1288h;
                                    if (bVar2.q) {
                                    }
                                    e.g.a.i.d dVar2622 = null;
                                    float f522 = 0.0f;
                                    i12 = 0;
                                    while (i12 < size) {
                                    }
                                    aVar = aVar4;
                                    if (dVar22 != null) {
                                    }
                                    dVar3 = dVar23;
                                    dVar2 = dVar22;
                                    i9 = i7;
                                    if (z2) {
                                    }
                                    i6 = i9;
                                    int i3422 = 8;
                                    int i3522 = bVar2.f1290j;
                                    if (i3522 <= 0) {
                                    }
                                    e.g.a.i.d dVar2822 = dVar2;
                                    dVar5 = dVar2822;
                                    while (dVar5 != null) {
                                    }
                                    e.g.a.i.c cVar1822 = dVar2.Q[i3];
                                    cVar3 = dVar20.Q[i3].f1295f;
                                    int i3822 = i3 + 1;
                                    cVar4 = dVar3.Q[i3822];
                                    cVar5 = dVar21.Q[i3822].f1295f;
                                    if (cVar3 != null) {
                                    }
                                    dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                                    e.g.a.i.c[] cVarArr9222 = dVar2.Q;
                                    cVar = cVarArr9222[i3];
                                    if (dVar3 == null) {
                                    }
                                    i8 = i3 + 1;
                                    cVar2 = dVar4.Q[i8];
                                    e.g.a.i.c cVar19222 = cVar.f1295f;
                                    if (cVar19222 != null) {
                                    }
                                    e.g.a.i.c cVar20222 = cVar2.f1295f;
                                    if (cVar20222 != null) {
                                    }
                                    if (dVar21 != dVar4) {
                                    }
                                    if (dVar2 == dVar4) {
                                    }
                                    dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                                }
                            }
                            if (z10) {
                            }
                            ArrayList<e.g.a.i.d> arrayList4222 = bVar2.f1288h;
                            if (bVar2.q) {
                            }
                            e.g.a.i.d dVar26222 = null;
                            float f5222 = 0.0f;
                            i12 = 0;
                            while (i12 < size) {
                            }
                            aVar = aVar4;
                            if (dVar22 != null) {
                            }
                            dVar3 = dVar23;
                            dVar2 = dVar22;
                            i9 = i7;
                            if (z2) {
                            }
                            i6 = i9;
                            int i34222 = 8;
                            int i35222 = bVar2.f1290j;
                            if (i35222 <= 0) {
                            }
                            e.g.a.i.d dVar28222 = dVar2;
                            dVar5 = dVar28222;
                            while (dVar5 != null) {
                            }
                            e.g.a.i.c cVar18222 = dVar2.Q[i3];
                            cVar3 = dVar20.Q[i3].f1295f;
                            int i38222 = i3 + 1;
                            cVar4 = dVar3.Q[i38222];
                            cVar5 = dVar21.Q[i38222].f1295f;
                            if (cVar3 != null) {
                            }
                            dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                            e.g.a.i.c[] cVarArr92222 = dVar2.Q;
                            cVar = cVarArr92222[i3];
                            if (dVar3 == null) {
                            }
                            i8 = i3 + 1;
                            cVar2 = dVar4.Q[i8];
                            e.g.a.i.c cVar192222 = cVar.f1295f;
                            if (cVar192222 != null) {
                            }
                            e.g.a.i.c cVar202222 = cVar2.f1295f;
                            if (cVar202222 != null) {
                            }
                            if (dVar21 != dVar4) {
                            }
                            if (dVar2 == dVar4) {
                            }
                            dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                        }
                    } else {
                        i7 = i18;
                        int i42 = dVar24.k0;
                        boolean z15 = i42 == 0;
                        boolean z16 = i42 == 1;
                        if (i42 == 2) {
                            z7 = z15;
                            z5 = z16;
                        } else {
                            z6 = z15;
                            z5 = z16;
                            z = z5;
                            z2 = z6;
                            z3 = false;
                            e.g.a.i.d dVar252 = dVar20;
                            z4 = false;
                            while (!z4) {
                            }
                            i5 = i4;
                            if (dVar23 != null) {
                            }
                            if (z10) {
                            }
                            ArrayList<e.g.a.i.d> arrayList42222 = bVar2.f1288h;
                            if (bVar2.q) {
                            }
                            e.g.a.i.d dVar262222 = null;
                            float f52222 = 0.0f;
                            i12 = 0;
                            while (i12 < size) {
                            }
                            aVar = aVar4;
                            if (dVar22 != null) {
                            }
                            dVar3 = dVar23;
                            dVar2 = dVar22;
                            i9 = i7;
                            if (z2) {
                            }
                            i6 = i9;
                            int i342222 = 8;
                            int i352222 = bVar2.f1290j;
                            if (i352222 <= 0) {
                            }
                            e.g.a.i.d dVar282222 = dVar2;
                            dVar5 = dVar282222;
                            while (dVar5 != null) {
                            }
                            e.g.a.i.c cVar182222 = dVar2.Q[i3];
                            cVar3 = dVar20.Q[i3].f1295f;
                            int i382222 = i3 + 1;
                            cVar4 = dVar3.Q[i382222];
                            cVar5 = dVar21.Q[i382222].f1295f;
                            if (cVar3 != null) {
                            }
                            dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                            e.g.a.i.c[] cVarArr922222 = dVar2.Q;
                            cVar = cVarArr922222[i3];
                            if (dVar3 == null) {
                            }
                            i8 = i3 + 1;
                            cVar2 = dVar4.Q[i8];
                            e.g.a.i.c cVar1922222 = cVar.f1295f;
                            if (cVar1922222 != null) {
                            }
                            e.g.a.i.c cVar2022222 = cVar2.f1295f;
                            if (cVar2022222 != null) {
                            }
                            if (dVar21 != dVar4) {
                            }
                            if (dVar2 == dVar4) {
                            }
                            dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                        }
                    }
                    z = z5;
                    z2 = z7;
                    z3 = true;
                    e.g.a.i.d dVar2522 = dVar20;
                    z4 = false;
                    while (!z4) {
                    }
                    i5 = i4;
                    if (dVar23 != null) {
                    }
                    if (z10) {
                    }
                    ArrayList<e.g.a.i.d> arrayList422222 = bVar2.f1288h;
                    if (bVar2.q) {
                    }
                    e.g.a.i.d dVar2622222 = null;
                    float f522222 = 0.0f;
                    i12 = 0;
                    while (i12 < size) {
                    }
                    aVar = aVar4;
                    if (dVar22 != null) {
                    }
                    dVar3 = dVar23;
                    dVar2 = dVar22;
                    i9 = i7;
                    if (z2) {
                    }
                    i6 = i9;
                    int i3422222 = 8;
                    int i3522222 = bVar2.f1290j;
                    if (i3522222 <= 0) {
                    }
                    e.g.a.i.d dVar2822222 = dVar2;
                    dVar5 = dVar2822222;
                    while (dVar5 != null) {
                    }
                    e.g.a.i.c cVar1822222 = dVar2.Q[i3];
                    cVar3 = dVar20.Q[i3].f1295f;
                    int i3822222 = i3 + 1;
                    cVar4 = dVar3.Q[i3822222];
                    cVar5 = dVar21.Q[i3822222].f1295f;
                    if (cVar3 != null) {
                    }
                    dVar.d(cVar4.f1298i, cVar5.f1298i, -cVar4.d(), 5);
                    e.g.a.i.c[] cVarArr9222222 = dVar2.Q;
                    cVar = cVarArr9222222[i3];
                    if (dVar3 == null) {
                    }
                    i8 = i3 + 1;
                    cVar2 = dVar4.Q[i8];
                    e.g.a.i.c cVar19222222 = cVar.f1295f;
                    if (cVar19222222 != null) {
                    }
                    e.g.a.i.c cVar20222222 = cVar2.f1295f;
                    if (cVar20222222 != null) {
                    }
                    if (dVar21 != dVar4) {
                    }
                    if (dVar2 == dVar4) {
                    }
                    dVar.b(cVar.f1298i, gVar, cVar.d(), 0.5f, gVar2, cVar2.f1298i, dVar4.Q[i8].d(), 5);
                } else {
                    i6 = i18;
                    aVar = aVar4;
                    i5 = i4;
                }
                i18 = i6 + 1;
                eVar2 = eVar;
                arrayList3 = arrayList;
                aVar4 = aVar;
                i4 = i5;
            }
        }

        public static long b0(l.b.a.e eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.G();
        }

        public static String b1(Map<String, String> map, String str) {
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

        public static int b2(Parcel parcel, int i2) {
            parcel.writeInt(i2 | -65536);
            parcel.writeInt(0);
            return parcel.dataPosition();
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
            int Q0 = Q0(i2, rect, rect2);
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
            if (Q0 < Math.max(1, i4 - i3)) {
                return true;
            }
            return false;
        }

        public static String c0(h0.c cVar) {
            if (cVar == null) {
                return null;
            }
            return cVar.name();
        }

        public static long c1(String str) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException unused) {
                f.a.b.v.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
        }

        public static String c2(String str, String str2) {
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

        public static String d0(Uri uri) {
            if (uri == null) {
                return null;
            }
            return uri.toString();
        }

        public static f.b.a.a.a.s.v d1(p pVar) {
            Objects.requireNonNull(pVar);
            return new f.b.a.a.a.s.v();
        }

        public static void d2(Parcel parcel, int i2, int i3) {
            int n1 = n1(parcel, i2);
            if (n1 != i3) {
                String hexString = Integer.toHexString(n1);
                StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
                sb.append("Expected size ");
                sb.append(i3);
                sb.append(" got ");
                sb.append(n1);
                sb.append(" (0x");
                sb.append(hexString);
                sb.append(")");
                throw new f.b.a.c.b.m.n.b(sb.toString(), parcel);
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

        public static Drawable e0(CompoundButton compoundButton) {
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

        public static f.b.a.a.a.s.e0.a e1(f.b.a.a.a.s.e0.b bVar) {
            Objects.requireNonNull(bVar);
            return new f.b.a.a.a.s.e0.c();
        }

        public static <T extends Parcelable> void e2(Parcel parcel, T t2, int i2) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            t2.writeToParcel(parcel, i2);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
        public static e.b0.e f(byte[] bArr) {
            Throwable th;
            ObjectInputStream objectInputStream;
            IOException e2;
            e.b0.e eVar = new e.b0.e();
            if (bArr == null) {
                return eVar;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        eVar.a.add(new e.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
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
                        return eVar;
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
                return eVar;
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
            return eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00ad  */
        public static ColorStateList f0(Context context, int i2) {
            ColorStateList colorStateList;
            ColorStateList colorStateList2;
            h.a aVar;
            Object obj = e.i.b.a.a;
            Resources resources = context.getResources();
            Resources.Theme theme = context.getTheme();
            ThreadLocal<TypedValue> threadLocal = e.i.b.b.h.a;
            if (Build.VERSION.SDK_INT >= 23) {
                return resources.getColorStateList(i2, theme);
            }
            h.b bVar = new h.b(resources, theme);
            synchronized (e.i.b.b.h.c) {
                SparseArray<h.a> sparseArray = e.i.b.b.h.b.get(bVar);
                if (!(sparseArray == null || sparseArray.size() <= 0 || (aVar = sparseArray.get(i2)) == null)) {
                    if (aVar.b.equals(bVar.a.getConfiguration())) {
                        colorStateList = aVar.a;
                    } else {
                        sparseArray.remove(i2);
                    }
                }
                colorStateList = null;
            }
            if (colorStateList != null) {
                return colorStateList;
            }
            ThreadLocal<TypedValue> threadLocal2 = e.i.b.b.h.a;
            TypedValue typedValue = threadLocal2.get();
            if (typedValue == null) {
                typedValue = new TypedValue();
                threadLocal2.set(typedValue);
            }
            boolean z = true;
            resources.getValue(i2, typedValue, true);
            int i3 = typedValue.type;
            if (i3 < 28 || i3 > 31) {
                z = false;
            }
            if (!z) {
                try {
                    colorStateList2 = e.i.b.b.a.a(resources, resources.getXml(i2), theme);
                } catch (Exception unused) {
                }
                if (colorStateList2 != null) {
                    return resources.getColorStateList(i2);
                }
                synchronized (e.i.b.b.h.c) {
                    WeakHashMap<h.b, SparseArray<h.a>> weakHashMap = e.i.b.b.h.b;
                    SparseArray<h.a> sparseArray2 = weakHashMap.get(bVar);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray<>();
                        weakHashMap.put(bVar, sparseArray2);
                    }
                    sparseArray2.append(i2, new h.a(colorStateList2, bVar.a.getConfiguration()));
                }
                return colorStateList2;
            }
            colorStateList2 = null;
            if (colorStateList2 != null) {
            }
        }

        public static d0.a f1(f.b.a.a.a.f0.r rVar) {
            Objects.requireNonNull(rVar);
            return new f.b.a.a.a.f0.f(rVar);
        }

        public static void f2(Parcel parcel, int i2, int i3) {
            if (i3 >= 65535) {
                parcel.writeInt(i2 | -65536);
                parcel.writeInt(i3);
                return;
            }
            parcel.writeInt(i2 | (i3 << 16));
        }

        public static boolean g(e.i.c.d[] dVarArr, e.i.c.d[] dVarArr2) {
            if (dVarArr == null || dVarArr2 == null || dVarArr.length != dVarArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                if (!(dVarArr[i2].a == dVarArr2[i2].a && dVarArr[i2].b.length == dVarArr2[i2].b.length)) {
                    return false;
                }
            }
            return true;
        }

        public static int g0(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static e.m.a.n.b g1(ByteBuffer byteBuffer) {
            long j2;
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.BIG_ENDIAN);
            duplicate.position(duplicate.position() + 4);
            int i2 = duplicate.getShort() & 65535;
            if (i2 <= 100) {
                duplicate.position(duplicate.position() + 6);
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        j2 = -1;
                        break;
                    }
                    int i4 = duplicate.getInt();
                    duplicate.position(duplicate.position() + 4);
                    j2 = ((long) duplicate.getInt()) & 4294967295L;
                    duplicate.position(duplicate.position() + 4);
                    if (1835365473 == i4) {
                        break;
                    }
                    i3++;
                }
                if (j2 != -1) {
                    duplicate.position(duplicate.position() + ((int) (j2 - ((long) duplicate.position()))));
                    duplicate.position(duplicate.position() + 12);
                    long j3 = ((long) duplicate.getInt()) & 4294967295L;
                    for (int i5 = 0; ((long) i5) < j3; i5++) {
                        int i6 = duplicate.getInt();
                        long j4 = ((long) duplicate.getInt()) & 4294967295L;
                        duplicate.getInt();
                        if (1164798569 == i6 || 1701669481 == i6) {
                            duplicate.position((int) (j4 + j2));
                            e.m.a.n.b bVar = new e.m.a.n.b();
                            duplicate.order(ByteOrder.LITTLE_ENDIAN);
                            bVar.b(duplicate.position() + duplicate.getInt(duplicate.position()), duplicate);
                            return bVar;
                        }
                    }
                }
                throw new IOException("Cannot read metadata.");
            }
            throw new IOException("Cannot read metadata.");
        }

        public static void g2(Parcel parcel, int i2) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i2 - 4);
            parcel.writeInt(dataPosition - i2);
            parcel.setDataPosition(dataPosition);
        }

        public static void h(@RecentlyNonNull boolean z) {
            if (!z) {
                throw new IllegalArgumentException();
            }
        }

        public static Drawable h0(Context context, int i2) {
            return r0.d().f(context, i2);
        }

        @RecentlyNonNull
        public static boolean h1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            d2(parcel, i2, 4);
            return parcel.readInt() != 0;
        }

        public static void i(boolean z, Object obj) {
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
        }

        public static JSONObject i0(Throwable th) {
            if (!(th instanceof u)) {
                return new JSONObject();
            }
            u uVar = (u) th;
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

        public static List<List<byte[]>> i1(Resources resources, int i2) {
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
                            arrayList.add(E1(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(E1(resources.getStringArray(i2)));
                }
                obtainTypedArray.recycle();
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }

        public static void j(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
            if (!z) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }

        public static String j0(Throwable th) {
            if (!(th instanceof u)) {
                return "error_code_not_parsed";
            }
            JSONObject i0 = i0((u) th);
            return i0.has("errorCode") ? i0.optString("errorCode") : i0.optString("code", "error_code_not_parsed");
        }

        @RecentlyNonNull
        public static double j1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            d2(parcel, i2, 8);
            return parcel.readDouble();
        }

        public static void k(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
        }

        public static String k0(Throwable th) {
            return !(th instanceof u) ? "Call failed, unknown reason." : i0((u) th).optString("error", "Call failed, unknown reason.");
        }

        @RecentlyNonNull
        public static IBinder k1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            int n1 = n1(parcel, i2);
            int dataPosition = parcel.dataPosition();
            if (n1 == 0) {
                return null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(dataPosition + n1);
            return readStrongBinder;
        }

        public static int l(int i2) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException();
        }

        public static <T> f.b.b.f.a.u<T> l0(e.f.a.d<T> dVar) {
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

        @RecentlyNonNull
        public static int l1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            d2(parcel, i2, 4);
            return parcel.readInt();
        }

        public static int m(int i2, String str) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException(str);
        }

        public static <T> f.b.b.f.a.u<T> m0(f.b.a.c.i.h<T> hVar, l.b.a.d dVar, ScheduledExecutorService scheduledExecutorService) {
            return f.b.b.f.a.l.x(l0(new f.b.a.a.a.s.i(hVar, scheduledExecutorService))).A(dVar.t(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        }

        @RecentlyNonNull
        public static long m1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            d2(parcel, i2, 8);
            return parcel.readLong();
        }

        public static void n(@RecentlyNonNull Handler handler) {
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

        public static int n0(Throwable th) {
            f.a.b.k kVar;
            if ((th instanceof u) && (kVar = ((u) th).b) != null) {
                return kVar.a;
            }
            return 0;
        }

        @RecentlyNonNull
        public static int n1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
            return (i2 & -65536) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
        }

        @RecentlyNonNull
        public static String o(@RecentlyNonNull String str) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }

        public static int o0(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.getLayoutDirection();
            }
            if (!f668l) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f667k = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f668l = true;
            }
            Method method = f667k;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception unused2) {
                    f667k = null;
                }
            }
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [f.b.a.b.h.e$a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static <TInput, TResult, TException extends Throwable> TResult o1(int i2, TInput tinput, f.b.a.b.h.c<TInput, TResult, TException> cVar, f.b.a.b.i.r.a<TInput, TResult> aVar) {
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
                    R("CctTransportBackend", "Following redirect to: %s", url);
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

        @RecentlyNonNull
        public static String p(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }

        public static d.c p0(Throwable th) {
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
            int n0 = n0(th) / 100;
            return n0 == 5 ? d.c.RESULT_FAILED_GENERIC_5XX : n0 == 4 ? d.c.RESULT_FAILED_GENERIC_4XX : d.c.RESULT_FAILED_UNKNOWN;
        }

        public static void p1(TextView textView, int i2) {
            l(i2);
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

        public static <T> T q(T t2, Object obj) {
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static String q0(Context context, int i2) {
            if (i2 == -1) {
                return "UNKNOWN";
            }
            try {
                return context.getResources().getResourceEntryName(i2);
            } catch (Exception unused) {
                return f.a.a.a.a.t("?", i2);
            }
        }

        public static void q1(TextView textView, int i2) {
            l(i2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
            }
        }

        @EnsuresNonNull({"#1"})
        public static <T> T r(@RecentlyNonNull T t2, @RecentlyNonNull Object obj) {
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static String r0(View view) {
            try {
                return view.getContext().getResources().getResourceEntryName(view.getId());
            } catch (Exception unused) {
                return "UNKNOWN";
            }
        }

        public static boolean r1(Drawable drawable, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.setLayoutDirection(i2);
            }
            if (!f666j) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f665i = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f666j = true;
            }
            Method method = f665i;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception unused2) {
                    f665i = null;
                }
            }
            return false;
        }

        public static int s(Context context, String str) {
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

        public static e.i.b.b.b s0(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
            e.i.b.b.b bVar;
            if (D0(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i2, typedValue);
                int i4 = typedValue.type;
                if (i4 >= 28 && i4 <= 31) {
                    return new e.i.b.b.b(null, null, typedValue.data);
                }
                try {
                    bVar = e.i.b.b.b.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
                } catch (Exception unused) {
                    bVar = null;
                }
                if (bVar != null) {
                    return bVar;
                }
            }
            return new e.i.b.b.b(null, null, i3);
        }

        public static void s1(TextView textView, int i2) {
            l(i2);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i2 != fontMetricsInt) {
                textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
            }
        }

        public static void t(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
            if (!z) {
                throw new IllegalStateException(String.valueOf(obj));
            }
        }

        public static String t0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
            if (!D0(xmlPullParser, str)) {
                return null;
            }
            return typedArray.getString(i2);
        }

        public static void t1(PopupWindow popupWindow, boolean z) {
            if (Build.VERSION.SDK_INT >= 23) {
                e.i.j.e.c(popupWindow, z);
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

        public static void u(boolean z, String str) {
            if (!z) {
                throw new IllegalStateException(str);
            }
        }

        public static ShareDiagnosisViewModel.b u0(ShareDiagnosisViewModel.b bVar, h0 h0Var, w5 w5Var, boolean z, Context context) {
            return v0(bVar, h0Var, w5Var, z, f.b.b.a.a.b, context);
        }

        public static void u1(TextView textView, e.i.g.b bVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                Objects.requireNonNull(bVar);
                textView.setText((CharSequence) null);
                return;
            }
            b.a C0 = C0(textView);
            Objects.requireNonNull(bVar);
            if (C0.a(null)) {
                textView.setText(bVar);
                return;
            }
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }

        public static int v(int i2, int i3, int i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }

        public static ShareDiagnosisViewModel.b v0(ShareDiagnosisViewModel.b bVar, h0 h0Var, w5 w5Var, boolean z, f.b.b.a.l<Boolean> lVar, Context context) {
            ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.VACCINATION;
            ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.CODE;
            int ordinal = bVar.ordinal();
            boolean z2 = true;
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
                        if (!h0.d.USER_REPORT.equals(h0Var.n()) || !(!TextUtils.isEmpty(context.getString(R.string.self_report_website_url))) || !context.getResources().getBoolean(R.bool.enx_preAuthorizeAfterSelfReport) || !N0(context)) {
                            z2 = false;
                        }
                        if (z2) {
                            return ShareDiagnosisViewModel.b.PRE_AUTH;
                        }
                        return z ? bVar2 : ShareDiagnosisViewModel.b.SHARED;
                    }
                } else if (z) {
                    return bVar2;
                } else {
                    return null;
                }
            } else if (!K0(h0Var)) {
                return (w5Var != w5.DEEP_LINK && (TextUtils.isEmpty(context.getString(R.string.self_report_website_url)) ^ true) && !L0(h0Var)) ? ShareDiagnosisViewModel.b.IS_CODE_NEEDED : bVar3;
            }
            return ShareDiagnosisViewModel.b.UPLOAD;
        }

        public static void v1(TextView textView, int i2) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i2);
            } else {
                textView.setTextAppearance(textView.getContext(), i2);
            }
        }

        public static void w(Drawable drawable) {
            DrawableContainer.DrawableContainerState drawableContainerState;
            Drawable a2;
            int i2 = Build.VERSION.SDK_INT;
            drawable.clearColorFilter();
            if (i2 < 23) {
                if (drawable instanceof InsetDrawable) {
                    a2 = ((InsetDrawable) drawable).getDrawable();
                } else if (drawable instanceof e.i.c.m.b) {
                    a2 = ((e.i.c.m.b) drawable).a();
                } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        Drawable child = drawableContainerState.getChild(i3);
                        if (child != null) {
                            w(child);
                        }
                    }
                    return;
                } else {
                    return;
                }
                w(a2);
            }
        }

        public static Intent w0(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String y0 = y0(activity, activity.getComponentName());
                if (y0 == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, y0);
                try {
                    return y0(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        public static void w1(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        public static int x(RecyclerView.y yVar, e.t.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(mVar.S(view) - mVar.S(view2)) + 1;
            }
            return Math.min(rVar.l(), rVar.b(view2) - rVar.e(view));
        }

        public static Intent x0(Context context, ComponentName componentName) {
            String y0 = y0(context, componentName);
            if (y0 == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), y0);
            return y0(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
        }

        public static void x1(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static int y(RecyclerView.y yVar, e.t.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z, boolean z2) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            int max = z2 ? Math.max(0, (yVar.b() - Math.max(mVar.S(view), mVar.S(view2))) - 1) : Math.max(0, Math.min(mVar.S(view), mVar.S(view2)));
            if (!z) {
                return max;
            }
            return Math.round((((float) max) * (((float) Math.abs(rVar.b(view2) - rVar.e(view))) / ((float) (Math.abs(mVar.S(view) - mVar.S(view2)) + 1)))) + ((float) (rVar.k() - rVar.e(view))));
        }

        public static String y0(Context context, ComponentName componentName) {
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

        public static void y1(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        public static int z(RecyclerView.y yVar, e.t.a.r rVar, View view, View view2, RecyclerView.m mVar, boolean z) {
            if (mVar.z() == 0 || yVar.b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return yVar.b();
            }
            return (int) ((((float) (rVar.b(view2) - rVar.e(view))) / ((float) (Math.abs(mVar.S(view) - mVar.S(view2)) + 1))) * ((float) yVar.b()));
        }

        public static String z0(@RecentlyNonNull int i2) {
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

        public static void z1(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            f1 f1Var = f1.f882k;
            if (f1Var != null && f1Var.b == view) {
                f1.c(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                f1 f1Var2 = f1.f883l;
                if (f1Var2 != null && f1Var2.b == view) {
                    f1Var2.b();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new f1(view, charSequence);
        }
    }

    public class g extends h {
        public final PowerManager c;

        public g(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // e.b.a.m.h
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // e.b.a.m.h
        public int c() {
            return this.c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // e.b.a.m.h
        public void d() {
            m.this.A();
        }
    }

    public abstract class h {
        public BroadcastReceiver a;

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
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    m.this.f652e.unregisterReceiver(broadcastReceiver);
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
                m.this.f652e.registerReceiver(this.a, b2);
            }
        }
    }

    public class i extends h {
        public final v c;

        public i(v vVar) {
            super();
            this.c = vVar;
        }

        @Override // e.b.a.m.h
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
        @Override // e.b.a.m.h
        public int c() {
            boolean z;
            Location location;
            long j2;
            v vVar = this.c;
            v.a aVar = vVar.c;
            boolean z2 = false;
            if (!(aVar.b > System.currentTimeMillis())) {
                Location location2 = null;
                if (e.s(vVar.a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (vVar.b.isProviderEnabled("network")) {
                            location = vVar.b.getLastKnownLocation("network");
                            if (e.s(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
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
                                if (u.f695d == null) {
                                    u.f695d = new u();
                                }
                                u uVar = u.f695d;
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
                if (e.s(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            z = aVar.a;
            if (!z) {
            }
        }

        @Override // e.b.a.m.h
        public void d() {
            m.this.A();
        }
    }

    public class j extends ContentFrameLayout {
        public j(Context context) {
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
            setBackgroundDrawable(e.h0(getContext(), i2));
        }
    }

    public static final class k {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f673d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f674e;

        /* renamed from: f  reason: collision with root package name */
        public View f675f;

        /* renamed from: g  reason: collision with root package name */
        public View f676g;

        /* renamed from: h  reason: collision with root package name */
        public e.b.e.i.g f677h;

        /* renamed from: i  reason: collision with root package name */
        public e.b.e.i.e f678i;

        /* renamed from: j  reason: collision with root package name */
        public Context f679j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f680k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f681l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public k(int i2) {
            this.a = i2;
        }

        public void a(e.b.e.i.g gVar) {
            e.b.e.i.e eVar;
            e.b.e.i.g gVar2 = this.f677h;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.u(this.f678i);
                }
                this.f677h = gVar;
                if (gVar != null && (eVar = this.f678i) != null) {
                    gVar.b(eVar, gVar.a);
                }
            }
        }
    }

    public final class l implements m.a {
        public l() {
        }

        @Override // e.b.e.i.m.a
        public void b(e.b.e.i.g gVar, boolean z) {
            e.b.e.i.g k2 = gVar.k();
            boolean z2 = k2 != gVar;
            m mVar = m.this;
            if (z2) {
                gVar = k2;
            }
            k M = mVar.M(gVar);
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
            if (!mVar.A || (P = mVar.P()) == null || m.this.L) {
                return true;
            }
            P.onMenuOpened(108, gVar);
            return true;
        }
    }

    public m(Context context, Window window, k kVar, Object obj) {
        e.e.h<String, Integer> hVar;
        Integer orDefault;
        j jVar;
        this.f652e = context;
        this.f655h = kVar;
        this.f651d = obj;
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
            jVar = null;
            if (jVar != null) {
                this.N = jVar.u().f();
            }
        }
        if (this.N == -100 && (orDefault = (hVar = a0).getOrDefault(this.f651d.getClass().getName(), null)) != null) {
            this.N = orDefault.intValue();
            hVar.remove(this.f651d.getClass().getName());
        }
        if (window != null) {
            C(window);
        }
        e.b.f.k.e();
    }

    public boolean A() {
        return B(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c2, code lost:
        if (r1 != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01cb, code lost:
        if (r12.L == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        if (e.i.a.e.b(r13) == false) goto L_0x00c6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce A[ADDED_TO_REGION] */
    public final boolean B(boolean z2) {
        boolean z3;
        Configuration configuration;
        boolean z4;
        Object obj;
        int i2;
        boolean z5 = false;
        if (this.L) {
            return false;
        }
        int i3 = this.N;
        if (i3 == -100) {
            i3 = -100;
        }
        Map map = null;
        r4 = null;
        r4 = null;
        Object obj2 = null;
        Object obj3 = null;
        Configuration G2 = G(this.f652e, S(this.f652e, i3), null);
        boolean z6 = true;
        if (!this.Q && (this.f651d instanceof Activity)) {
            PackageManager packageManager = this.f652e.getPackageManager();
            if (packageManager == null) {
                z3 = false;
                configuration = this.M;
                if (configuration == null) {
                    configuration = this.f652e.getResources().getConfiguration();
                }
                int i4 = configuration.uiMode & 48;
                int i5 = G2.uiMode & 48;
                if (i4 != i5 && z2 && !z3 && this.J && (c0 || this.K)) {
                    Object obj4 = this.f651d;
                    if ((obj4 instanceof Activity) && !((Activity) obj4).isChild()) {
                        Activity activity = (Activity) this.f651d;
                        int i6 = e.i.a.c.b;
                        i2 = Build.VERSION.SDK_INT;
                        if (i2 < 28) {
                            if (i2 <= 23) {
                                new Handler(activity.getMainLooper()).post(new e.i.a.b(activity));
                            }
                            z4 = true;
                            if (!z4 || i4 == i5) {
                                z6 = z4;
                            } else {
                                Resources resources = this.f652e.getResources();
                                Configuration configuration2 = new Configuration(resources.getConfiguration());
                                configuration2.uiMode = i5 | (resources.getConfiguration().uiMode & -49);
                                resources.updateConfiguration(configuration2, null);
                                int i7 = Build.VERSION.SDK_INT;
                                if (i7 < 26 && i7 < 28) {
                                    if (i7 >= 24) {
                                        if (!e.f664h) {
                                            try {
                                                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                                e.f663g = declaredField;
                                                declaredField.setAccessible(true);
                                            } catch (NoSuchFieldException unused) {
                                            }
                                            e.f664h = true;
                                        }
                                        Field field = e.f663g;
                                        if (field != null) {
                                            try {
                                                obj = field.get(resources);
                                            } catch (IllegalAccessException unused2) {
                                                obj = null;
                                            }
                                            if (obj != null) {
                                                if (!e.b) {
                                                    try {
                                                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                        e.a = declaredField2;
                                                        declaredField2.setAccessible(true);
                                                    } catch (NoSuchFieldException unused3) {
                                                    }
                                                    e.b = true;
                                                }
                                                Field field2 = e.a;
                                                if (field2 != null) {
                                                    try {
                                                        obj2 = field2.get(obj);
                                                    } catch (IllegalAccessException unused4) {
                                                    }
                                                }
                                                if (obj2 != null) {
                                                    e.a0(obj2);
                                                }
                                            }
                                        }
                                    } else if (i7 >= 23) {
                                        if (!e.b) {
                                            try {
                                                Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                                e.a = declaredField3;
                                                declaredField3.setAccessible(true);
                                            } catch (NoSuchFieldException unused5) {
                                            }
                                            e.b = true;
                                        }
                                        Field field3 = e.a;
                                        if (field3 != null) {
                                            try {
                                                obj3 = field3.get(resources);
                                            } catch (IllegalAccessException unused6) {
                                            }
                                        }
                                        if (obj3 != null) {
                                            e.a0(obj3);
                                        }
                                    } else {
                                        if (!e.b) {
                                            try {
                                                Field declaredField4 = Resources.class.getDeclaredField("mDrawableCache");
                                                e.a = declaredField4;
                                                declaredField4.setAccessible(true);
                                            } catch (NoSuchFieldException unused7) {
                                            }
                                            e.b = true;
                                        }
                                        Field field4 = e.a;
                                        if (field4 != null) {
                                            try {
                                                map = (Map) field4.get(resources);
                                            } catch (IllegalAccessException unused8) {
                                            }
                                            if (map != null) {
                                                map.clear();
                                            }
                                        }
                                    }
                                }
                                int i8 = this.O;
                                if (i8 != 0) {
                                    this.f652e.setTheme(i8);
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        this.f652e.getTheme().applyStyle(this.O, true);
                                    }
                                }
                                if (z3) {
                                    Object obj5 = this.f651d;
                                    if (obj5 instanceof Activity) {
                                        Activity activity2 = (Activity) obj5;
                                        if (activity2 instanceof e.q.l) {
                                            if (((e.q.m) ((e.q.l) activity2).a()).b.compareTo((Enum) h.b.CREATED) >= 0) {
                                                z5 = true;
                                            }
                                        } else if (this.K) {
                                        }
                                        activity2.onConfigurationChanged(configuration2);
                                    }
                                }
                            }
                            if (z6) {
                                Object obj6 = this.f651d;
                                if (obj6 instanceof j) {
                                    ((j) obj6).x();
                                }
                            }
                            if (i3 != 0) {
                                N(this.f652e).e();
                            } else {
                                h hVar = this.R;
                                if (hVar != null) {
                                    hVar.a();
                                }
                            }
                            if (i3 != 3) {
                                Context context = this.f652e;
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
                        activity.recreate();
                        z4 = true;
                        if (!z4) {
                        }
                        z6 = z4;
                        if (z6) {
                        }
                        if (i3 != 0) {
                        }
                        if (i3 != 3) {
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
                if (i3 != 0) {
                }
                if (i3 != 3) {
                }
                return z6;
            }
            try {
                int i9 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f652e, this.f651d.getClass()), i9 >= 29 ? 269221888 : i9 >= 24 ? 786432 : 0);
                this.P = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused9) {
                this.P = false;
            }
        }
        this.Q = true;
        z3 = this.P;
        configuration = this.M;
        if (configuration == null) {
        }
        int i42 = configuration.uiMode & 48;
        int i52 = G2.uiMode & 48;
        Object obj42 = this.f651d;
        Activity activity3 = (Activity) this.f651d;
        int i62 = e.i.a.c.b;
        i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
        }
        activity3.recreate();
        z4 = true;
        if (!z4) {
        }
        z6 = z4;
        if (z6) {
        }
        if (i3 != 0) {
        }
        if (i3 != 3) {
        }
        return z6;
    }

    public final void C(Window window) {
        if (this.f653f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof f)) {
                f fVar = new f(callback);
                this.f654g = fVar;
                window.setCallback(fVar);
                c1 p2 = c1.p(this.f652e, null, b0);
                Drawable h2 = p2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                p2.b.recycle();
                this.f653f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void D(int i2, k kVar, Menu menu) {
        if (menu == null && kVar != null) {
            menu = kVar.f677h;
        }
        if ((kVar == null || kVar.m) && !this.L) {
            this.f654g.b.onPanelClosed(i2, menu);
        }
    }

    public void E(e.b.e.i.g gVar) {
        if (!this.F) {
            this.F = true;
            this.f659l.l();
            Window.Callback P2 = P();
            if (P2 != null && !this.L) {
                P2.onPanelClosed(108, gVar);
            }
            this.F = false;
        }
    }

    public void F(k kVar, boolean z2) {
        ViewGroup viewGroup;
        g0 g0Var;
        if (!z2 || kVar.a != 0 || (g0Var = this.f659l) == null || !g0Var.c()) {
            WindowManager windowManager = (WindowManager) this.f652e.getSystemService("window");
            if (!(windowManager == null || !kVar.m || (viewGroup = kVar.f674e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    D(kVar.a, kVar, null);
                }
            }
            kVar.f680k = false;
            kVar.f681l = false;
            kVar.m = false;
            kVar.f675f = null;
            kVar.o = true;
            if (this.H == kVar) {
                this.H = null;
                return;
            }
            return;
        }
        E(kVar.f677h);
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
        Object obj = this.f651d;
        boolean z5 = true;
        if (((obj instanceof h.a) || (obj instanceof r)) && (decorView = this.f653f.getDecorView()) != null && e.i.i.h.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f654g.b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & 128) == 0) {
                    z5 = false;
                }
                this.I = z5;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                k O2 = O(0);
                if (O2.m) {
                    return true;
                }
                V(O2, keyEvent);
                return true;
            }
        } else if (keyCode == 4) {
            boolean z6 = this.I;
            this.I = false;
            k O3 = O(0);
            if (!O3.m) {
                e.b.e.a aVar = this.o;
                if (aVar != null) {
                    aVar.c();
                } else {
                    Q();
                    a aVar2 = this.f656i;
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
            k O4 = O(0);
            g0 g0Var = this.f659l;
            if (g0Var == null || !g0Var.g() || ViewConfiguration.get(this.f652e).hasPermanentMenuKey()) {
                boolean z7 = O4.m;
                if (z7 || O4.f681l) {
                    F(O4, true);
                    z3 = z7;
                    if (!z3 && (audioManager = (AudioManager) this.f652e.getApplicationContext().getSystemService("audio")) != null) {
                        audioManager.playSoundEffect(0);
                        return true;
                    }
                } else if (O4.f680k) {
                    if (O4.p) {
                        O4.f680k = false;
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
                if (this.f659l.c()) {
                    z3 = this.f659l.d();
                } else if (!this.L && V(O4, keyEvent)) {
                    z3 = this.f659l.e();
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
        k O2 = O(i2);
        if (O2.f677h != null) {
            Bundle bundle = new Bundle();
            O2.f677h.w(bundle);
            if (bundle.size() > 0) {
                O2.q = bundle;
            }
            O2.f677h.z();
            O2.f677h.clear();
        }
        O2.p = true;
        O2.o = true;
        if ((i2 == 108 || i2 == 0) && this.f659l != null) {
            k O3 = O(0);
            O3.f680k = false;
            V(O3, null);
        }
    }

    public void J() {
        x xVar = this.s;
        if (xVar != null) {
            xVar.b();
        }
    }

    public final void K() {
        ViewGroup viewGroup;
        if (!this.u) {
            TypedArray obtainStyledAttributes = this.f652e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
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
                this.D = obtainStyledAttributes.getBoolean(androidx.appcompat.R$styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                L();
                this.f653f.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.f652e);
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(this.C ? R$layout.abc_screen_simple_overlay_action_mode : R$layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                    this.B = false;
                    this.A = false;
                } else if (this.A) {
                    TypedValue typedValue = new TypedValue();
                    this.f652e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new e.b.e.c(this.f652e, typedValue.resourceId) : this.f652e).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                    g0 g0Var = (g0) viewGroup.findViewById(androidx.appcompat.R$id.decor_content_parent);
                    this.f659l = g0Var;
                    g0Var.setWindowCallback(P());
                    if (this.B) {
                        this.f659l.k(109);
                    }
                    if (this.y) {
                        this.f659l.k(2);
                    }
                    if (this.z) {
                        this.f659l.k(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    n nVar = new n(this);
                    AtomicInteger atomicInteger = e.i.i.v.a;
                    v.i.u(viewGroup, nVar);
                    if (this.f659l == null) {
                        this.w = (TextView) viewGroup.findViewById(androidx.appcompat.R$id.title);
                    }
                    Method method = i1.a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R$id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f653f.findViewById(16908290);
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
                    this.f653f.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new o(this));
                    this.v = viewGroup;
                    Object obj = this.f651d;
                    CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f658k;
                    if (!TextUtils.isEmpty(title)) {
                        g0 g0Var2 = this.f659l;
                        if (g0Var2 != null) {
                            g0Var2.setWindowTitle(title);
                        } else {
                            a aVar = this.f656i;
                            if (aVar != null) {
                                aVar.q(title);
                            } else {
                                TextView textView = this.w;
                                if (textView != null) {
                                    textView.setText(title);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.v.findViewById(16908290);
                    View decorView = this.f653f.getDecorView();
                    contentFrameLayout2.f83h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    AtomicInteger atomicInteger2 = e.i.i.v.a;
                    if (v.g.c(contentFrameLayout2)) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.f652e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
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
                    this.u = true;
                    k O2 = O(0);
                    if (!this.L && O2.f677h == null) {
                        R(108);
                        return;
                    }
                    return;
                }
                StringBuilder h2 = f.a.a.a.a.h("AppCompat does not support the current theme features: { windowActionBar: ");
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

    public final void L() {
        if (this.f653f == null) {
            Object obj = this.f651d;
            if (obj instanceof Activity) {
                C(((Activity) obj).getWindow());
            }
        }
        if (this.f653f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public k M(Menu menu) {
        k[] kVarArr = this.G;
        int length = kVarArr != null ? kVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            k kVar = kVarArr[i2];
            if (kVar != null && kVar.f677h == menu) {
                return kVar;
            }
        }
        return null;
    }

    public final h N(Context context) {
        if (this.R == null) {
            if (v.f696d == null) {
                Context applicationContext = context.getApplicationContext();
                v.f696d = new v(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.R = new i(v.f696d);
        }
        return this.R;
    }

    public k O(int i2) {
        k[] kVarArr = this.G;
        if (kVarArr == null || kVarArr.length <= i2) {
            k[] kVarArr2 = new k[(i2 + 1)];
            if (kVarArr != null) {
                System.arraycopy(kVarArr, 0, kVarArr2, 0, kVarArr.length);
            }
            this.G = kVarArr2;
            kVarArr = kVarArr2;
        }
        k kVar = kVarArr[i2];
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(i2);
        kVarArr[i2] = kVar2;
        return kVar2;
    }

    public final Window.Callback P() {
        return this.f653f.getCallback();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final void Q() {
        a aVar;
        w wVar;
        K();
        if (this.A && this.f656i == null) {
            Object obj = this.f651d;
            if (obj instanceof Activity) {
                wVar = new w((Activity) this.f651d, this.B);
            } else {
                if (obj instanceof Dialog) {
                    wVar = new w((Dialog) this.f651d);
                }
                aVar = this.f656i;
                if (aVar == null) {
                    aVar.l(this.W);
                    return;
                }
                return;
            }
            this.f656i = wVar;
            aVar = this.f656i;
            if (aVar == null) {
            }
        }
    }

    public final void R(int i2) {
        this.U = (1 << i2) | this.U;
        if (!this.T) {
            View decorView = this.f653f.getDecorView();
            Runnable runnable = this.V;
            AtomicInteger atomicInteger = e.i.i.v.a;
            v.d.m(decorView, runnable);
            this.T = true;
        }
    }

    public int S(Context context, int i2) {
        h N2;
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
                        N2 = this.S;
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
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
    public final void T(k kVar, KeyEvent keyEvent) {
        int i2;
        boolean z2;
        ViewGroup.LayoutParams layoutParams;
        if (!kVar.m && !this.L) {
            if (kVar.a == 0) {
                if ((this.f652e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback P2 = P();
            if (P2 == null || P2.onMenuOpened(kVar.a, kVar.f677h)) {
                WindowManager windowManager = (WindowManager) this.f652e.getSystemService("window");
                if (windowManager != null && V(kVar, keyEvent)) {
                    ViewGroup viewGroup = kVar.f674e;
                    if (viewGroup == null || kVar.o) {
                        if (viewGroup == null) {
                            Q();
                            a aVar = this.f656i;
                            Context e2 = aVar != null ? aVar.e() : null;
                            if (e2 == null) {
                                e2 = this.f652e;
                            }
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme newTheme = e2.getResources().newTheme();
                            newTheme.setTo(e2.getTheme());
                            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
                            int i3 = typedValue.resourceId;
                            if (i3 != 0) {
                                newTheme.applyStyle(i3, true);
                            }
                            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
                            int i4 = typedValue.resourceId;
                            if (i4 == 0) {
                                i4 = R$style.Theme_AppCompat_CompactMenu;
                            }
                            newTheme.applyStyle(i4, true);
                            e.b.e.c cVar = new e.b.e.c(e2, 0);
                            cVar.getTheme().setTo(newTheme);
                            kVar.f679j = cVar;
                            TypedArray obtainStyledAttributes = cVar.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme);
                            kVar.b = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_panelBackground, 0);
                            kVar.f673d = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            kVar.f674e = new j(kVar.f679j);
                            kVar.c = 81;
                        } else if (kVar.o && viewGroup.getChildCount() > 0) {
                            kVar.f674e.removeAllViews();
                        }
                        View view = kVar.f676g;
                        if (view != null) {
                            kVar.f675f = view;
                        } else {
                            if (kVar.f677h != null) {
                                if (this.n == null) {
                                    this.n = new l();
                                }
                                l lVar = this.n;
                                if (kVar.f678i == null) {
                                    e.b.e.i.e eVar = new e.b.e.i.e(kVar.f679j, R$layout.abc_list_menu_item_layout);
                                    kVar.f678i = eVar;
                                    eVar.f782g = lVar;
                                    e.b.e.i.g gVar = kVar.f677h;
                                    gVar.b(eVar, gVar.a);
                                }
                                e.b.e.i.e eVar2 = kVar.f678i;
                                ViewGroup viewGroup2 = kVar.f674e;
                                if (eVar2.f780e == null) {
                                    eVar2.f780e = (ExpandedMenuView) eVar2.c.inflate(R$layout.abc_expanded_menu_layout, viewGroup2, false);
                                    if (eVar2.f783h == null) {
                                        eVar2.f783h = new e.a();
                                    }
                                    eVar2.f780e.setAdapter((ListAdapter) eVar2.f783h);
                                    eVar2.f780e.setOnItemClickListener(eVar2);
                                }
                                ExpandedMenuView expandedMenuView = eVar2.f780e;
                                kVar.f675f = expandedMenuView;
                            }
                            z2 = false;
                            if (z2) {
                                if (kVar.f675f != null && (kVar.f676g != null || ((e.a) kVar.f678i.a()).getCount() > 0)) {
                                    ViewGroup.LayoutParams layoutParams2 = kVar.f675f.getLayoutParams();
                                    if (layoutParams2 == null) {
                                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                    }
                                    kVar.f674e.setBackgroundResource(kVar.b);
                                    ViewParent parent = kVar.f675f.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(kVar.f675f);
                                    }
                                    kVar.f674e.addView(kVar.f675f, layoutParams2);
                                    if (!kVar.f675f.hasFocus()) {
                                        kVar.f675f.requestFocus();
                                    }
                                }
                            }
                            kVar.o = true;
                            return;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        kVar.o = true;
                        return;
                    }
                    View view2 = kVar.f676g;
                    if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        kVar.f681l = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams3.gravity = kVar.c;
                        layoutParams3.windowAnimations = kVar.f673d;
                        windowManager.addView(kVar.f674e, layoutParams3);
                        kVar.m = true;
                        return;
                    }
                    i2 = -2;
                    kVar.f681l = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams32.gravity = kVar.c;
                    layoutParams32.windowAnimations = kVar.f673d;
                    windowManager.addView(kVar.f674e, layoutParams32);
                    kVar.m = true;
                    return;
                }
                return;
            }
            F(kVar, true);
        }
    }

    public final boolean U(k kVar, int i2, KeyEvent keyEvent, int i3) {
        e.b.e.i.g gVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((kVar.f680k || V(kVar, keyEvent)) && (gVar = kVar.f677h) != null) {
            z2 = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.f659l == null) {
            F(kVar, true);
        }
        return z2;
    }

    public final boolean V(k kVar, KeyEvent keyEvent) {
        g0 g0Var;
        g0 g0Var2;
        g0 g0Var3;
        Resources.Theme theme;
        g0 g0Var4;
        if (this.L) {
            return false;
        }
        if (kVar.f680k) {
            return true;
        }
        k kVar2 = this.H;
        if (!(kVar2 == null || kVar2 == kVar)) {
            F(kVar2, false);
        }
        Window.Callback P2 = P();
        if (P2 != null) {
            kVar.f676g = P2.onCreatePanelView(kVar.a);
        }
        int i2 = kVar.a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (g0Var4 = this.f659l) != null) {
            g0Var4.f();
        }
        if (kVar.f676g == null && (!z2 || !(this.f656i instanceof t))) {
            e.b.e.i.g gVar = kVar.f677h;
            if (gVar == null || kVar.p) {
                if (gVar == null) {
                    Context context = this.f652e;
                    int i3 = kVar.a;
                    if ((i3 == 0 || i3 == 108) && this.f659l != null) {
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
                            e.b.e.c cVar = new e.b.e.c(context, 0);
                            cVar.getTheme().setTo(theme);
                            context = cVar;
                        }
                    }
                    e.b.e.i.g gVar2 = new e.b.e.i.g(context);
                    gVar2.f789e = this;
                    kVar.a(gVar2);
                    if (kVar.f677h == null) {
                        return false;
                    }
                }
                if (z2 && (g0Var3 = this.f659l) != null) {
                    if (this.m == null) {
                        this.m = new c();
                    }
                    g0Var3.a(kVar.f677h, this.m);
                }
                kVar.f677h.z();
                if (!P2.onCreatePanelMenu(kVar.a, kVar.f677h)) {
                    kVar.a(null);
                    if (z2 && (g0Var2 = this.f659l) != null) {
                        g0Var2.a(null, this.m);
                    }
                    return false;
                }
                kVar.p = false;
            }
            kVar.f677h.z();
            Bundle bundle = kVar.q;
            if (bundle != null) {
                kVar.f677h.v(bundle);
                kVar.q = null;
            }
            if (!P2.onPreparePanel(0, kVar.f676g, kVar.f677h)) {
                if (z2 && (g0Var = this.f659l) != null) {
                    g0Var.a(null, this.m);
                }
                kVar.f677h.y();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            kVar.n = z3;
            kVar.f677h.setQwertyMode(z3);
            kVar.f677h.y();
        }
        kVar.f680k = true;
        kVar.f681l = false;
        this.H = kVar;
        return true;
    }

    public final boolean W() {
        ViewGroup viewGroup;
        if (this.u && (viewGroup = this.v) != null) {
            AtomicInteger atomicInteger = e.i.i.v.a;
            if (v.g.c(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    public final void X() {
        if (this.u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int Y(e.i.i.b0 b0Var, Rect rect) {
        boolean z2;
        boolean z3;
        int i2;
        Context context;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int d2 = b0Var.d();
        ActionBarContextView actionBarContextView = this.p;
        int i4 = 8;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            boolean z4 = true;
            if (this.p.isShown()) {
                if (this.X == null) {
                    this.X = new Rect();
                    this.Y = new Rect();
                }
                Rect rect2 = this.X;
                Rect rect3 = this.Y;
                rect2.set(b0Var.b(), b0Var.d(), b0Var.c(), b0Var.a());
                ViewGroup viewGroup = this.v;
                Method method = i1.a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception unused) {
                    }
                }
                int i5 = rect2.top;
                int i6 = rect2.left;
                int i7 = rect2.right;
                e.i.i.b0 l2 = e.i.i.v.l(this.v);
                int b2 = l2 == null ? 0 : l2.b();
                int c2 = l2 == null ? 0 : l2.c();
                if (marginLayoutParams2.topMargin == i5 && marginLayoutParams2.leftMargin == i6 && marginLayoutParams2.rightMargin == i7) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i5;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i7;
                    z3 = true;
                }
                if (i5 <= 0 || this.x != null) {
                    View view = this.x;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i3 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == b2 && marginLayoutParams.rightMargin == c2))) {
                        marginLayoutParams.height = i3;
                        marginLayoutParams.leftMargin = b2;
                        marginLayoutParams.rightMargin = c2;
                        this.x.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f652e);
                    this.x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = b2;
                    layoutParams.rightMargin = c2;
                    this.v.addView(this.x, -1, layoutParams);
                }
                View view3 = this.x;
                z2 = view3 != null;
                if (z2 && view3.getVisibility() != 0) {
                    View view4 = this.x;
                    AtomicInteger atomicInteger = e.i.i.v.a;
                    if ((v.d.g(view4) & 8192) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        context = this.f652e;
                        i2 = R$color.abc_decor_view_status_guard_light;
                    } else {
                        context = this.f652e;
                        i2 = R$color.abc_decor_view_status_guard;
                    }
                    view4.setBackgroundColor(e.i.b.a.a(context, i2));
                }
                if (!this.C && z2) {
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
        View view5 = this.x;
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
        k M2;
        Window.Callback P2 = P();
        if (P2 == null || this.L || (M2 = M(gVar.k())) == null) {
            return false;
        }
        return P2.onMenuItemSelected(M2.a, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(e.b.e.i.g gVar) {
        g0 g0Var = this.f659l;
        if (g0Var == null || !g0Var.g() || (ViewConfiguration.get(this.f652e).hasPermanentMenuKey() && !this.f659l.b())) {
            k O2 = O(0);
            O2.o = true;
            F(O2, false);
            T(O2, null);
            return;
        }
        Window.Callback P2 = P();
        if (this.f659l.c()) {
            this.f659l.d();
            if (!this.L) {
                P2.onPanelClosed(108, O(0).f677h);
            }
        } else if (P2 != null && !this.L) {
            if (this.T && (1 & this.U) != 0) {
                this.f653f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            k O3 = O(0);
            e.b.e.i.g gVar2 = O3.f677h;
            if (gVar2 != null && !O3.p && P2.onPreparePanel(0, O3.f676g, gVar2)) {
                P2.onMenuOpened(108, O3.f677h);
                this.f659l.e();
            }
        }
    }

    @Override // e.b.a.l
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ((ViewGroup) this.v.findViewById(16908290)).addView(view, layoutParams);
        this.f654g.b.onContentChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x019e  */
    @Override // e.b.a.l
    public Context d(Context context) {
        Configuration configuration;
        boolean z2;
        this.J = true;
        int i2 = this.N;
        if (i2 == -100) {
            i2 = -100;
        }
        int S2 = S(context, i2);
        if (d0 && (context instanceof ContextThemeWrapper)) {
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
        if (!c0) {
            return context;
        }
        int i3 = Build.VERSION.SDK_INT;
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = new Configuration();
            configuration.fontScale = 0.0f;
            if (configuration3.diff(configuration4) != 0) {
                float f2 = configuration3.fontScale;
                float f3 = configuration4.fontScale;
                if (f2 != f3) {
                    configuration.fontScale = f3;
                }
                int i4 = configuration3.mcc;
                int i5 = configuration4.mcc;
                if (i4 != i5) {
                    configuration.mcc = i5;
                }
                int i6 = configuration3.mnc;
                int i7 = configuration4.mnc;
                if (i6 != i7) {
                    configuration.mnc = i7;
                }
                if (i3 >= 24) {
                    LocaleList locales = configuration3.getLocales();
                    LocaleList locales2 = configuration4.getLocales();
                    if (!locales.equals(locales2)) {
                        configuration.setLocales(locales2);
                        configuration.locale = configuration4.locale;
                    }
                } else if (!Objects.equals(configuration3.locale, configuration4.locale)) {
                    configuration.locale = configuration4.locale;
                }
                int i8 = configuration3.touchscreen;
                int i9 = configuration4.touchscreen;
                if (i8 != i9) {
                    configuration.touchscreen = i9;
                }
                int i10 = configuration3.keyboard;
                int i11 = configuration4.keyboard;
                if (i10 != i11) {
                    configuration.keyboard = i11;
                }
                int i12 = configuration3.keyboardHidden;
                int i13 = configuration4.keyboardHidden;
                if (i12 != i13) {
                    configuration.keyboardHidden = i13;
                }
                int i14 = configuration3.navigation;
                int i15 = configuration4.navigation;
                if (i14 != i15) {
                    configuration.navigation = i15;
                }
                int i16 = configuration3.navigationHidden;
                int i17 = configuration4.navigationHidden;
                if (i16 != i17) {
                    configuration.navigationHidden = i17;
                }
                int i18 = configuration3.orientation;
                int i19 = configuration4.orientation;
                if (i18 != i19) {
                    configuration.orientation = i19;
                }
                int i20 = configuration3.screenLayout & 15;
                int i21 = configuration4.screenLayout & 15;
                if (i20 != i21) {
                    configuration.screenLayout |= i21;
                }
                int i22 = configuration3.screenLayout & 192;
                int i23 = configuration4.screenLayout & 192;
                if (i22 != i23) {
                    configuration.screenLayout |= i23;
                }
                int i24 = configuration3.screenLayout & 48;
                int i25 = configuration4.screenLayout & 48;
                if (i24 != i25) {
                    configuration.screenLayout |= i25;
                }
                int i26 = configuration3.screenLayout & 768;
                int i27 = configuration4.screenLayout & 768;
                if (i26 != i27) {
                    configuration.screenLayout |= i27;
                }
                if (i3 >= 26) {
                    int i28 = configuration3.colorMode & 3;
                    int i29 = configuration4.colorMode & 3;
                    if (i28 != i29) {
                        configuration.colorMode |= i29;
                    }
                    int i30 = configuration3.colorMode & 12;
                    int i31 = configuration4.colorMode & 12;
                    if (i30 != i31) {
                        configuration.colorMode |= i31;
                    }
                }
                int i32 = configuration3.uiMode & 15;
                int i33 = configuration4.uiMode & 15;
                if (i32 != i33) {
                    configuration.uiMode |= i33;
                }
                int i34 = configuration3.uiMode & 48;
                int i35 = configuration4.uiMode & 48;
                if (i34 != i35) {
                    configuration.uiMode |= i35;
                }
                int i36 = configuration3.screenWidthDp;
                int i37 = configuration4.screenWidthDp;
                if (i36 != i37) {
                    configuration.screenWidthDp = i37;
                }
                int i38 = configuration3.screenHeightDp;
                int i39 = configuration4.screenHeightDp;
                if (i38 != i39) {
                    configuration.screenHeightDp = i39;
                }
                int i40 = configuration3.smallestScreenWidthDp;
                int i41 = configuration4.smallestScreenWidthDp;
                if (i40 != i41) {
                    configuration.smallestScreenWidthDp = i41;
                }
                int i42 = configuration3.densityDpi;
                int i43 = configuration4.densityDpi;
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
                        synchronized (e.i.b.b.i.a) {
                            if (!e.i.b.b.i.c) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                    e.i.b.b.i.b = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException unused3) {
                                }
                                e.i.b.b.i.c = true;
                            }
                            Method method = e.i.b.b.i.b;
                            if (method != null) {
                                try {
                                    method.invoke(theme, new Object[0]);
                                } catch (IllegalAccessException | InvocationTargetException unused4) {
                                    e.i.b.b.i.b = null;
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
    }

    @Override // e.b.a.l
    public <T extends View> T e(int i2) {
        K();
        return (T) this.f653f.findViewById(i2);
    }

    @Override // e.b.a.l
    public int f() {
        return this.N;
    }

    @Override // e.b.a.l
    public MenuInflater g() {
        if (this.f657j == null) {
            Q();
            a aVar = this.f656i;
            this.f657j = new e.b.e.f(aVar != null ? aVar.e() : this.f652e);
        }
        return this.f657j;
    }

    @Override // e.b.a.l
    public a h() {
        Q();
        return this.f656i;
    }

    @Override // e.b.a.l
    public void i() {
        LayoutInflater from = LayoutInflater.from(this.f652e);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z2 = from.getFactory2() instanceof m;
        }
    }

    @Override // e.b.a.l
    public void j() {
        Q();
        a aVar = this.f656i;
        if (aVar == null || !aVar.f()) {
            R(0);
        }
    }

    @Override // e.b.a.l
    public void k(Configuration configuration) {
        if (this.A && this.u) {
            Q();
            a aVar = this.f656i;
            if (aVar != null) {
                aVar.g(configuration);
            }
        }
        e.b.f.k a2 = e.b.f.k.a();
        Context context = this.f652e;
        synchronized (a2) {
            r0 r0Var = a2.a;
            synchronized (r0Var) {
                e.e.e<WeakReference<Drawable.ConstantState>> eVar = r0Var.f956d.get(context);
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
        this.M = new Configuration(this.f652e.getResources().getConfiguration());
        B(false);
    }

    @Override // e.b.a.l
    public void l(Bundle bundle) {
        this.J = true;
        B(false);
        L();
        Object obj = this.f651d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = e.y0(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a aVar = this.f656i;
                if (aVar == null) {
                    this.W = true;
                } else {
                    aVar.l(true);
                }
            }
            synchronized (l.c) {
                l.s(this);
                l.b.add(new WeakReference<>(this));
            }
        }
        this.M = new Configuration(this.f652e.getResources().getConfiguration());
        this.K = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // e.b.a.l
    public void m() {
        a aVar;
        h hVar;
        h hVar2;
        if (this.f651d instanceof Activity) {
            synchronized (l.c) {
                l.s(this);
            }
        }
        if (this.T) {
            this.f653f.getDecorView().removeCallbacks(this.V);
        }
        this.L = true;
        if (this.N != -100) {
            Object obj = this.f651d;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                a0.put(this.f651d.getClass().getName(), Integer.valueOf(this.N));
                aVar = this.f656i;
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
        a0.remove(this.f651d.getClass().getName());
        aVar = this.f656i;
        if (aVar != null) {
        }
        hVar = this.R;
        if (hVar != null) {
        }
        hVar2 = this.S;
        if (hVar2 == null) {
        }
    }

    @Override // e.b.a.l
    public void n(Bundle bundle) {
        K();
    }

    @Override // e.b.a.l
    public void o() {
        Q();
        a aVar = this.f656i;
        if (aVar != null) {
            aVar.o(true);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0179 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v6. Raw type applied. Possible types: java.util.WeakHashMap<android.view.View, java.lang.Boolean>, java.util.WeakHashMap */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, e.b.a.s] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [e.i.i.v$b, e.i.i.r] */
    /* JADX WARN: Type inference failed for: r6v1, types: [e.i.i.v$b, e.i.i.s] */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [e.i.i.u, e.i.i.v$b] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Unknown variable types count: 12 */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        char c2;
        ?? r2;
        e.b.f.f fVar;
        s sVar;
        if (this.Z == null) {
            String string = this.f652e.obtainStyledAttributes(androidx.appcompat.R$styleable.AppCompatTheme).getString(androidx.appcompat.R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                sVar = new s();
            } else {
                try {
                    this.Z = (s) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    sVar = new s();
                }
            }
            this.Z = sVar;
        }
        ?? r10 = this.Z;
        int i2 = h1.a;
        Objects.requireNonNull(r10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R$styleable.View, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.View_theme, 0);
        obtainStyledAttributes.recycle();
        Context cVar = (resourceId == 0 || ((context instanceof e.b.e.c) && ((e.b.e.c) context).a == resourceId)) ? context : new e.b.e.c(context, resourceId);
        str.hashCode();
        ?? r5 = 1;
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
                fVar = new e.b.f.v(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 1:
                fVar = new e.b.f.h(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 2:
                fVar = new e.b.f.r(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 3:
                fVar = r10.e(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 4:
                fVar = new e.b.f.o(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 5:
                fVar = new w(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 6:
                fVar = new e.b.f.z(cVar, attributeSet, R$attr.spinnerStyle);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 7:
                fVar = r10.d(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case '\b':
                fVar = new f0(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case '\t':
                fVar = new e.b.f.q(cVar, attributeSet, 0);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case '\n':
                fVar = r10.a(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case 11:
                fVar = r10.c(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case '\f':
                fVar = new e.b.f.l(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            case '\r':
                fVar = r10.b(cVar, attributeSet);
                r10.h(fVar, str);
                r2 = fVar;
                break;
            default:
                r2 = r10.f();
                break;
        }
        if (r2 == 0 && context != cVar) {
            r2 = 0;
            r2 = 0;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(r2, "class");
            }
            try {
                ?? r12 = r10.a;
                r12[0] = cVar;
                r12[r5] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i3 = 0;
                    while (true) {
                        String[] strArr = s.f685g;
                        if (i3 < strArr.length) {
                            View g2 = r10.g(cVar, str, strArr[i3]);
                            if (g2 != null) {
                                ?? r102 = r10.a;
                                r102[0] = r2;
                                r102[r5] = r2;
                                r2 = g2;
                            } else {
                                i3++;
                            }
                        }
                    }
                } else {
                    View g3 = r10.g(cVar, str, r2);
                    ?? r103 = r10.a;
                    r103[0] = r2;
                    r103[r5] = r2;
                    r2 = g3;
                }
            } catch (Exception unused2) {
            } finally {
                ?? r104 = r10.a;
                r104[0] = r2;
                r104[r5] = r2;
            }
        }
        if (r2 != 0) {
            Context context2 = r2.getContext();
            if (context2 instanceof ContextWrapper) {
                AtomicInteger atomicInteger = e.i.i.v.a;
                if (v.c.a(r2)) {
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes((AttributeSet) attributeSet, s.c);
                    String string2 = obtainStyledAttributes2.getString(0);
                    if (string2 != null) {
                        r2.setOnClickListener(new s.a(r2, string2));
                    }
                    obtainStyledAttributes2.recycle();
                }
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray obtainStyledAttributes3 = cVar.obtainStyledAttributes((AttributeSet) attributeSet, s.f682d);
                if (obtainStyledAttributes3.hasValue(0)) {
                    boolean z2 = obtainStyledAttributes3.getBoolean(0, false);
                    AtomicInteger atomicInteger2 = e.i.i.v.a;
                    new e.i.i.u(androidx.core.R$id.tag_accessibility_heading, Boolean.class, 28).e(r2, Boolean.valueOf(z2));
                }
                obtainStyledAttributes3.recycle();
                TypedArray obtainStyledAttributes4 = cVar.obtainStyledAttributes((AttributeSet) attributeSet, s.f683e);
                if (obtainStyledAttributes4.hasValue(0)) {
                    String string3 = obtainStyledAttributes4.getString(0);
                    AtomicInteger atomicInteger3 = e.i.i.v.a;
                    new e.i.i.s(androidx.core.R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28).e(r2, string3);
                    v.a aVar = e.i.i.v.f1560h;
                    if (string3 != null) {
                        WeakHashMap weakHashMap = aVar.b;
                        if (r2.getVisibility() != 0) {
                            r5 = 0;
                        }
                        weakHashMap.put(r2, Boolean.valueOf((boolean) r5));
                        r2.addOnAttachStateChangeListener(aVar);
                        if (v.g.b(r2)) {
                            r2.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                        }
                    } else {
                        aVar.b.remove(r2);
                        r2.removeOnAttachStateChangeListener(aVar);
                        v.d.o(r2.getViewTreeObserver(), aVar);
                    }
                }
                obtainStyledAttributes4.recycle();
                TypedArray obtainStyledAttributes5 = cVar.obtainStyledAttributes((AttributeSet) attributeSet, s.f684f);
                if (obtainStyledAttributes5.hasValue(0)) {
                    boolean z3 = obtainStyledAttributes5.getBoolean(0, false);
                    AtomicInteger atomicInteger4 = e.i.i.v.a;
                    new e.i.i.r(androidx.core.R$id.tag_screen_reader_focusable, Boolean.class, 28).e(r2, Boolean.valueOf(z3));
                }
                obtainStyledAttributes5.recycle();
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
        A();
    }

    @Override // e.b.a.l
    public void r() {
        Q();
        a aVar = this.f656i;
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
        if (this.E && i2 == 108) {
            return false;
        }
        if (this.A && i2 == 1) {
            this.A = false;
        }
        if (i2 == 1) {
            X();
            this.E = true;
            return true;
        } else if (i2 == 2) {
            X();
            this.y = true;
            return true;
        } else if (i2 == 5) {
            X();
            this.z = true;
            return true;
        } else if (i2 == 10) {
            X();
            this.C = true;
            return true;
        } else if (i2 == 108) {
            X();
            this.A = true;
            return true;
        } else if (i2 != 109) {
            return this.f653f.requestFeature(i2);
        } else {
            X();
            this.B = true;
            return true;
        }
    }

    @Override // e.b.a.l
    public void u(int i2) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f652e).inflate(i2, viewGroup);
        this.f654g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void v(View view) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f654g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void w(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f654g.b.onContentChanged();
    }

    @Override // e.b.a.l
    public void x(Toolbar toolbar) {
        if (this.f651d instanceof Activity) {
            Q();
            a aVar = this.f656i;
            if (!(aVar instanceof w)) {
                this.f657j = null;
                if (aVar != null) {
                    aVar.h();
                }
                this.f656i = null;
                if (toolbar != null) {
                    Object obj = this.f651d;
                    t tVar = new t(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : this.f658k, this.f654g);
                    this.f656i = tVar;
                    this.f654g.c = tVar.c;
                } else {
                    this.f654g.c = null;
                }
                j();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // e.b.a.l
    public void y(int i2) {
        this.O = i2;
    }

    @Override // e.b.a.l
    public final void z(CharSequence charSequence) {
        this.f658k = charSequence;
        g0 g0Var = this.f659l;
        if (g0Var != null) {
            g0Var.setWindowTitle(charSequence);
            return;
        }
        a aVar = this.f656i;
        if (aVar != null) {
            aVar.q(charSequence);
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public class f extends e.b.e.h {
        public b c;

        public f(Window.Callback callback) {
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
            e.a aVar3 = new e.a(m.this.f652e, callback);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            e.b.e.a aVar4 = mVar.o;
            if (aVar4 != null) {
                aVar4.c();
            }
            d dVar = new d(aVar3);
            mVar.Q();
            a aVar5 = mVar.f656i;
            if (aVar5 != null) {
                e.b.e.a r = aVar5.r(dVar);
                mVar.o = r;
                if (!(r == null || (kVar2 = mVar.f655h) == null)) {
                    kVar2.h(r);
                }
            }
            if (mVar.o == null) {
                mVar.J();
                e.b.e.a aVar6 = mVar.o;
                if (aVar6 != null) {
                    aVar6.c();
                }
                k kVar3 = mVar.f655h;
                if (kVar3 != null && !mVar.L) {
                    try {
                        aVar = kVar3.k(dVar);
                    } catch (AbstractMethodError unused) {
                    }
                    if (aVar == null) {
                        mVar.o = aVar;
                    } else {
                        boolean z = true;
                        if (mVar.p == null) {
                            if (mVar.D) {
                                TypedValue typedValue = new TypedValue();
                                Resources.Theme theme = mVar.f652e.getTheme();
                                theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = mVar.f652e.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    e.b.e.c cVar2 = new e.b.e.c(mVar.f652e, 0);
                                    cVar2.getTheme().setTo(newTheme);
                                    cVar = cVar2;
                                } else {
                                    cVar = mVar.f652e;
                                }
                                mVar.p = new ActionBarContextView(cVar, null);
                                PopupWindow popupWindow = new PopupWindow(cVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                                mVar.q = popupWindow;
                                e.A1(popupWindow, 2);
                                mVar.q.setContentView(mVar.p);
                                mVar.q.setWidth(-1);
                                cVar.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                                mVar.p.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, cVar.getResources().getDisplayMetrics()));
                                mVar.q.setHeight(-2);
                                mVar.r = new p(mVar);
                            } else {
                                ViewStubCompat viewStubCompat = (ViewStubCompat) mVar.v.findViewById(androidx.appcompat.R$id.action_mode_bar_stub);
                                if (viewStubCompat != null) {
                                    mVar.Q();
                                    a aVar7 = mVar.f656i;
                                    Context e2 = aVar7 != null ? aVar7.e() : null;
                                    if (e2 == null) {
                                        e2 = mVar.f652e;
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
                            e.b.e.d dVar2 = new e.b.e.d(context, actionBarContextView, dVar, z);
                            if (dVar.c(dVar2, dVar2.f736i)) {
                                dVar2.i();
                                mVar.p.f(dVar2);
                                mVar.o = dVar2;
                                if (mVar.W()) {
                                    mVar.p.setAlpha(0.0f);
                                    x b = e.i.i.v.b(mVar.p);
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
                                        AtomicInteger atomicInteger = e.i.i.v.a;
                                        v.h.c((View) mVar.p.getParent());
                                    }
                                }
                                if (mVar.q != null) {
                                    mVar.f653f.getDecorView().post(mVar.r);
                                }
                            } else {
                                mVar.o = null;
                            }
                        }
                    }
                    aVar2 = mVar.o;
                    if (!(aVar2 == null || (kVar = mVar.f655h) == null)) {
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

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return m.this.H(keyEvent) || this.b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean z;
            if (!this.b.dispatchKeyShortcutEvent(keyEvent)) {
                m mVar = m.this;
                int keyCode = keyEvent.getKeyCode();
                mVar.Q();
                a aVar = mVar.f656i;
                if (aVar == null || !aVar.i(keyCode, keyEvent)) {
                    k kVar = mVar.H;
                    if (kVar == null || !mVar.U(kVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                        if (mVar.H == null) {
                            k O = mVar.O(0);
                            mVar.V(O, keyEvent);
                            boolean U = mVar.U(O, keyEvent.getKeyCode(), keyEvent, 1);
                            O.f680k = false;
                        }
                        z = false;
                        if (!z) {
                            return true;
                        }
                        return false;
                    }
                    k kVar2 = mVar.H;
                    if (kVar2 != null) {
                        kVar2.f681l = true;
                    }
                }
                z = true;
                if (!z) {
                }
            }
            return true;
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof e.b.e.i.g)) {
                return this.b.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i2) {
            b bVar = this.c;
            if (bVar != null) {
                t.e eVar = (t.e) bVar;
                Objects.requireNonNull(eVar);
                View view = i2 == 0 ? new View(t.this.a.q()) : null;
                if (view != null) {
                    return view;
                }
            }
            return this.b.onCreatePanelView(i2);
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            this.b.onMenuOpened(i2, menu);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            if (i2 == 108) {
                mVar.Q();
                a aVar = mVar.f656i;
                if (aVar != null) {
                    aVar.c(true);
                }
            }
            return true;
        }

        public void onPanelClosed(int i2, Menu menu) {
            this.b.onPanelClosed(i2, menu);
            m mVar = m.this;
            Objects.requireNonNull(mVar);
            if (i2 == 108) {
                mVar.Q();
                a aVar = mVar.f656i;
                if (aVar != null) {
                    aVar.c(false);
                }
            } else if (i2 == 0) {
                k O = mVar.O(i2);
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
            b bVar = this.c;
            if (bVar != null) {
                t.e eVar = (t.e) bVar;
                if (i2 == 0) {
                    t tVar = t.this;
                    if (!tVar.f689d) {
                        tVar.a.f();
                        t.this.f689d = true;
                    }
                }
            }
            boolean onPreparePanel = this.b.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.x = false;
            }
            return onPreparePanel;
        }

        @Override // android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            e.b.e.i.g gVar = m.this.O(0).f677h;
            if (gVar != null) {
                this.b.onProvideKeyboardShortcuts(list, gVar, i2);
            } else {
                this.b.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (m.this.t) {
                return a(callback);
            }
            return this.b.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!m.this.t || i2 != 0) {
                return this.b.onWindowStartingActionMode(callback, i2);
            }
            return a(callback);
        }
    }
}
