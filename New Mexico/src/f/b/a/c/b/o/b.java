package f.b.a.c.b.o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$attr;
import com.mikepenz.aboutlibraries.R$style;
import com.mikepenz.aboutlibraries.R$styleable;
import e.b.a.m;
import e.b.f.c1;
import e.j.j.v;
import e.r.f0;
import f.a.a.a.a;
import f.a.b.k;
import f.a.b.u;
import f.b.a.c.e.c.p2;
import f.b.a.c.e.c.r2;
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.a.c.i.i;
import f.b.a.c.i.j;
import f.b.a.e.j.c;
import f.b.a.e.v.g;
import f.b.a.f.a.a.d;
import f.b.a.f.a.e.o;
import f.b.a.f.a.e.p;
import f.b.a.f.a.e.q;
import f.b.a.f.a.h.r;
import f.b.b.a.t;
import f.b.b.f.a.a0;
import f.b.b.f.a.d;
import f.b.b.f.a.w;
import f.b.b.f.a.y;
import f.b.c.f.d;
import f.b.c.f.f;
import f.b.c.k.u.l;
import f.b.c.n.e;
import f.b.d.a.s;
import f.b.g.b0;
import f.b.g.c0;
import f.b.g.d0;
import f.b.g.e1;
import f.b.g.j1;
import f.b.g.k0;
import f.b.g.l1;
import f.b.g.p1;
import f.b.g.r1;
import f.b.g.s1;
import f.b.g.t0;
import f.b.g.v0;
import f.b.g.w1;
import f.b.g.x;
import f.b.g.y1;
import f.b.g.z;
import f.d.b.s.g;
import g.b.a.c.b.c;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static Boolean a;
    public static Boolean b;
    public static Boolean c;

    /* renamed from: d */
    public static Boolean f2759d;

    /* renamed from: e */
    public static Boolean f2760e;

    /* renamed from: f */
    public static d f2761f;

    /* renamed from: g */
    public static Thread f2762g;

    public static <T> T A(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static float A0(String[] strArr, int i2) {
        float parseFloat = Float.parseFloat(strArr[i2]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static int A1(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    public static <T> T B(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(t.b(str, obj));
    }

    public static Map<Integer, List<String>> B0() {
        HashMap hashMap = new HashMap(286);
        ArrayList arrayList = new ArrayList(25);
        arrayList.add("US");
        arrayList.add("AG");
        arrayList.add("AI");
        arrayList.add("AS");
        arrayList.add("BB");
        arrayList.add("BM");
        arrayList.add("BS");
        arrayList.add("CA");
        arrayList.add("DM");
        arrayList.add("DO");
        arrayList.add("GD");
        arrayList.add("GU");
        arrayList.add("JM");
        arrayList.add("KN");
        arrayList.add("KY");
        arrayList.add("LC");
        arrayList.add("MP");
        arrayList.add("MS");
        arrayList.add("PR");
        arrayList.add("SX");
        arrayList.add("TC");
        arrayList.add("TT");
        arrayList.add("VC");
        arrayList.add("VG");
        ArrayList n = a.n(arrayList, "VI", 1, hashMap, arrayList, 2);
        n.add("RU");
        n.add("KZ");
        hashMap.put(7, n);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add("EG");
        hashMap.put(36, a.l(34, hashMap, a.l(33, hashMap, a.l(32, hashMap, a.l(31, hashMap, a.l(30, hashMap, a.l(27, hashMap, a.l(20, hashMap, arrayList2, 1, "ZA"), 1, "GR"), 1, "NL"), 1, "BE"), 1, "FR"), 1, "ES"), 1, "HU"));
        ArrayList arrayList3 = new ArrayList(2);
        arrayList3.add("IT");
        arrayList3.add("VA");
        hashMap.put(43, a.l(41, hashMap, a.l(40, hashMap, a.l(39, hashMap, arrayList3, 1, "RO"), 1, "CH"), 1, "AT"));
        ArrayList arrayList4 = new ArrayList(4);
        arrayList4.add("GB");
        arrayList4.add("GG");
        arrayList4.add("IM");
        arrayList4.add("JE");
        hashMap.put(44, arrayList4);
        ArrayList arrayList5 = new ArrayList(1);
        arrayList5.add("DK");
        hashMap.put(46, a.l(45, hashMap, arrayList5, 1, "SE"));
        ArrayList arrayList6 = new ArrayList(2);
        arrayList6.add("NO");
        arrayList6.add("SJ");
        hashMap.put(60, a.l(58, hashMap, a.l(57, hashMap, a.l(56, hashMap, a.l(55, hashMap, a.l(54, hashMap, a.l(53, hashMap, a.l(52, hashMap, a.l(51, hashMap, a.l(49, hashMap, a.l(48, hashMap, a.l(47, hashMap, arrayList6, 1, "PL"), 1, "DE"), 1, "PE"), 1, "MX"), 1, "CU"), 1, "AR"), 1, "BR"), 1, "CL"), 1, "CO"), 1, "VE"), 1, "MY"));
        ArrayList arrayList7 = new ArrayList(3);
        arrayList7.add("AU");
        arrayList7.add("CC");
        ArrayList n2 = a.n(arrayList7, "CX", 61, hashMap, arrayList7, 1);
        ArrayList n3 = a.n(n2, "ID", 62, hashMap, n2, 1);
        ArrayList n4 = a.n(n3, "PH", 63, hashMap, n3, 1);
        ArrayList n5 = a.n(n4, "NZ", 64, hashMap, n4, 1);
        ArrayList n6 = a.n(n5, "SG", 65, hashMap, n5, 1);
        ArrayList n7 = a.n(n6, "TH", 66, hashMap, n6, 1);
        ArrayList n8 = a.n(n7, "JP", 81, hashMap, n7, 1);
        ArrayList n9 = a.n(n8, "KR", 82, hashMap, n8, 1);
        ArrayList n10 = a.n(n9, "VN", 84, hashMap, n9, 1);
        ArrayList n11 = a.n(n10, "CN", 86, hashMap, n10, 1);
        ArrayList n12 = a.n(n11, "TR", 90, hashMap, n11, 1);
        ArrayList n13 = a.n(n12, "IN", 91, hashMap, n12, 1);
        ArrayList n14 = a.n(n13, "PK", 92, hashMap, n13, 1);
        ArrayList n15 = a.n(n14, "AF", 93, hashMap, n14, 1);
        ArrayList n16 = a.n(n15, "LK", 94, hashMap, n15, 1);
        ArrayList n17 = a.n(n16, "MM", 95, hashMap, n16, 1);
        ArrayList n18 = a.n(n17, "IR", 98, hashMap, n17, 1);
        ArrayList n19 = a.n(n18, "SS", 211, hashMap, n18, 2);
        n19.add("MA");
        n19.add("EH");
        hashMap.put(212, n19);
        ArrayList arrayList8 = new ArrayList(1);
        arrayList8.add("DZ");
        hashMap.put(261, a.l(260, hashMap, a.l(258, hashMap, a.l(257, hashMap, a.l(256, hashMap, a.l(255, hashMap, a.l(254, hashMap, a.l(253, hashMap, a.l(252, hashMap, a.l(251, hashMap, a.l(250, hashMap, a.l(249, hashMap, a.l(248, hashMap, a.l(247, hashMap, a.l(246, hashMap, a.l(245, hashMap, a.l(244, hashMap, a.l(243, hashMap, a.l(242, hashMap, a.l(241, hashMap, a.l(240, hashMap, a.l(239, hashMap, a.l(238, hashMap, a.l(237, hashMap, a.l(236, hashMap, a.l(235, hashMap, a.l(234, hashMap, a.l(233, hashMap, a.l(232, hashMap, a.l(231, hashMap, a.l(230, hashMap, a.l(229, hashMap, a.l(228, hashMap, a.l(227, hashMap, a.l(226, hashMap, a.l(225, hashMap, a.l(224, hashMap, a.l(223, hashMap, a.l(222, hashMap, a.l(221, hashMap, a.l(220, hashMap, a.l(218, hashMap, a.l(216, hashMap, a.l(213, hashMap, arrayList8, 1, "TN"), 1, "LY"), 1, "GM"), 1, "SN"), 1, "MR"), 1, "ML"), 1, "GN"), 1, "CI"), 1, "BF"), 1, "NE"), 1, "TG"), 1, "BJ"), 1, "MU"), 1, "LR"), 1, "SL"), 1, "GH"), 1, "NG"), 1, "TD"), 1, "CF"), 1, "CM"), 1, "CV"), 1, "ST"), 1, "GQ"), 1, "GA"), 1, "CG"), 1, "CD"), 1, "AO"), 1, "GW"), 1, "IO"), 1, "AC"), 1, "SC"), 1, "SD"), 1, "RW"), 1, "ET"), 1, "SO"), 1, "DJ"), 1, "KE"), 1, "TZ"), 1, "UG"), 1, "BI"), 1, "MZ"), 1, "ZM"), 1, "MG"));
        ArrayList arrayList9 = new ArrayList(2);
        arrayList9.add("RE");
        arrayList9.add("YT");
        hashMap.put(269, a.l(268, hashMap, a.l(267, hashMap, a.l(266, hashMap, a.l(265, hashMap, a.l(264, hashMap, a.l(263, hashMap, a.l(262, hashMap, arrayList9, 1, "ZW"), 1, "NA"), 1, "MW"), 1, "LS"), 1, "BW"), 1, "SZ"), 1, "KM"));
        ArrayList arrayList10 = new ArrayList(2);
        arrayList10.add("SH");
        arrayList10.add("TA");
        hashMap.put(357, a.l(356, hashMap, a.l(355, hashMap, a.l(354, hashMap, a.l(353, hashMap, a.l(352, hashMap, a.l(351, hashMap, a.l(350, hashMap, a.l(299, hashMap, a.l(298, hashMap, a.l(297, hashMap, a.l(291, hashMap, a.l(290, hashMap, arrayList10, 1, "ER"), 1, "AW"), 1, "FO"), 1, "GL"), 1, "GI"), 1, "PT"), 1, "LU"), 1, "IE"), 1, "IS"), 1, "AL"), 1, "MT"), 1, "CY"));
        ArrayList arrayList11 = new ArrayList(2);
        arrayList11.add("FI");
        arrayList11.add("AX");
        hashMap.put(509, a.l(508, hashMap, a.l(507, hashMap, a.l(506, hashMap, a.l(505, hashMap, a.l(504, hashMap, a.l(503, hashMap, a.l(502, hashMap, a.l(501, hashMap, a.l(500, hashMap, a.l(423, hashMap, a.l(421, hashMap, a.l(420, hashMap, a.l(389, hashMap, a.l(387, hashMap, a.l(386, hashMap, a.l(385, hashMap, a.l(383, hashMap, a.l(382, hashMap, a.l(381, hashMap, a.l(380, hashMap, a.l(378, hashMap, a.l(377, hashMap, a.l(376, hashMap, a.l(375, hashMap, a.l(374, hashMap, a.l(373, hashMap, a.l(372, hashMap, a.l(371, hashMap, a.l(370, hashMap, a.l(359, hashMap, a.l(358, hashMap, arrayList11, 1, "BG"), 1, "LT"), 1, "LV"), 1, "EE"), 1, "MD"), 1, "AM"), 1, "BY"), 1, "AD"), 1, "MC"), 1, "SM"), 1, "UA"), 1, "RS"), 1, "ME"), 1, "XK"), 1, "HR"), 1, "SI"), 1, "BA"), 1, "MK"), 1, "CZ"), 1, "SK"), 1, "LI"), 1, "FK"), 1, "BZ"), 1, "GT"), 1, "SV"), 1, "HN"), 1, "NI"), 1, "CR"), 1, "PA"), 1, "PM"), 1, "HT"));
        ArrayList arrayList12 = new ArrayList(3);
        arrayList12.add("GP");
        arrayList12.add("BL");
        ArrayList n20 = a.n(arrayList12, "MF", 590, hashMap, arrayList12, 1);
        ArrayList n21 = a.n(n20, "BO", 591, hashMap, n20, 1);
        ArrayList n22 = a.n(n21, "GY", 592, hashMap, n21, 1);
        ArrayList n23 = a.n(n22, "EC", 593, hashMap, n22, 1);
        ArrayList n24 = a.n(n23, "GF", 594, hashMap, n23, 1);
        ArrayList n25 = a.n(n24, "PY", 595, hashMap, n24, 1);
        ArrayList n26 = a.n(n25, "MQ", 596, hashMap, n25, 1);
        ArrayList n27 = a.n(n26, "SR", 597, hashMap, n26, 1);
        ArrayList n28 = a.n(n27, "UY", 598, hashMap, n27, 2);
        n28.add("CW");
        n28.add("BQ");
        hashMap.put(599, n28);
        ArrayList arrayList13 = new ArrayList(1);
        arrayList13.add("TL");
        hashMap.put(998, a.l(996, hashMap, a.l(995, hashMap, a.l(994, hashMap, a.l(993, hashMap, a.l(992, hashMap, a.l(979, hashMap, a.l(977, hashMap, a.l(976, hashMap, a.l(975, hashMap, a.l(974, hashMap, a.l(973, hashMap, a.l(972, hashMap, a.l(971, hashMap, a.l(970, hashMap, a.l(968, hashMap, a.l(967, hashMap, a.l(966, hashMap, a.l(965, hashMap, a.l(964, hashMap, a.l(963, hashMap, a.l(962, hashMap, a.l(961, hashMap, a.l(960, hashMap, a.l(888, hashMap, a.l(886, hashMap, a.l(883, hashMap, a.l(882, hashMap, a.l(881, hashMap, a.l(880, hashMap, a.l(878, hashMap, a.l(870, hashMap, a.l(856, hashMap, a.l(855, hashMap, a.l(853, hashMap, a.l(852, hashMap, a.l(850, hashMap, a.l(808, hashMap, a.l(800, hashMap, a.l(692, hashMap, a.l(691, hashMap, a.l(690, hashMap, a.l(689, hashMap, a.l(688, hashMap, a.l(687, hashMap, a.l(686, hashMap, a.l(685, hashMap, a.l(683, hashMap, a.l(682, hashMap, a.l(681, hashMap, a.l(680, hashMap, a.l(679, hashMap, a.l(678, hashMap, a.l(677, hashMap, a.l(676, hashMap, a.l(675, hashMap, a.l(674, hashMap, a.l(673, hashMap, a.l(672, hashMap, a.l(670, hashMap, arrayList13, 1, "NF"), 1, "BN"), 1, "NR"), 1, "PG"), 1, "TO"), 1, "SB"), 1, "VU"), 1, "FJ"), 1, "PW"), 1, "WF"), 1, "CK"), 1, "NU"), 1, "WS"), 1, "KI"), 1, "NC"), 1, "TV"), 1, "PF"), 1, "TK"), 1, "FM"), 1, "MH"), 1, "001"), 1, "001"), 1, "KP"), 1, "HK"), 1, "MO"), 1, "KH"), 1, "LA"), 1, "001"), 1, "001"), 1, "BD"), 1, "001"), 1, "001"), 1, "001"), 1, "TW"), 1, "001"), 1, "MV"), 1, "LB"), 1, "JO"), 1, "SY"), 1, "IQ"), 1, "KW"), 1, "SA"), 1, "YE"), 1, "OM"), 1, "PS"), 1, "AE"), 1, "IL"), 1, "BH"), 1, "QA"), 1, "BT"), 1, "MN"), 1, "NP"), 1, "001"), 1, "TJ"), 1, "TM"), 1, "AZ"), 1, "GE"), 1, "KG"), 1, "UZ"));
        return hashMap;
    }

    public static long B1(p pVar, InputStream inputStream, OutputStream outputStream, long j2) {
        byte[] bArr = new byte[16384];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format("%x", Integer.valueOf(readInt)));
            throw new o(valueOf.length() != 0 ? "Unexpected magic=".concat(valueOf) : new String("Unexpected magic="));
        }
        int read = dataInputStream.read();
        if (read == 4) {
            long j3 = 0;
            while (true) {
                long j4 = j2 - j3;
                try {
                    int read2 = dataInputStream.read();
                    if (read2 == -1) {
                        throw new IOException("Patch file overrun");
                    } else if (read2 == 0) {
                        return j3;
                    } else {
                        switch (read2) {
                            case 247:
                                read2 = dataInputStream.readUnsignedShort();
                                S1(bArr, dataInputStream, outputStream, read2, j4);
                                break;
                            case 248:
                                read2 = dataInputStream.readInt();
                                S1(bArr, dataInputStream, outputStream, read2, j4);
                                break;
                            case 249:
                                long readUnsignedShort = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    N1(bArr, pVar, outputStream, readUnsignedShort, read2, j4);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 250:
                                read2 = dataInputStream.readUnsignedShort();
                                N1(bArr, pVar, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j4);
                                break;
                            case 251:
                                read2 = dataInputStream.readInt();
                                N1(bArr, pVar, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j4);
                                break;
                            case 252:
                                long readInt2 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    N1(bArr, pVar, outputStream, readInt2, read2, j4);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 253:
                                read2 = dataInputStream.readUnsignedShort();
                                N1(bArr, pVar, outputStream, (long) dataInputStream.readInt(), read2, j4);
                                break;
                            case 254:
                                read2 = dataInputStream.readInt();
                                N1(bArr, pVar, outputStream, (long) dataInputStream.readInt(), read2, j4);
                                break;
                            case 255:
                                long readLong = dataInputStream.readLong();
                                read2 = dataInputStream.readInt();
                                N1(bArr, pVar, outputStream, readLong, read2, j4);
                                break;
                            default:
                                S1(bArr, dataInputStream, outputStream, read2, j4);
                                break;
                        }
                        j3 += (long) read2;
                    }
                } finally {
                    outputStream.flush();
                }
            }
        } else {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Unexpected version=");
            sb.append(read);
            throw new o(sb.toString());
        }
    }

    public static <T> T C(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int C0(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static <T> h<T> C1(h<T> hVar, long j2) {
        i iVar = new i();
        p2 p2Var = new f.b.a.c.i.d() { // from class: f.b.a.c.e.c.p2
            @Override // f.b.a.c.i.d
            public final void a(h hVar2) {
                i iVar2 = i.this;
                if (hVar2.o()) {
                    iVar2.b(hVar2.l());
                    return;
                }
                Exception k2 = hVar2.k();
                if (k2 != null) {
                    iVar2.a(k2);
                } else {
                    iVar2.a(new IllegalStateException("Failed task has null exception"));
                }
            }
        };
        c0 c0Var = (c0) hVar;
        Objects.requireNonNull(c0Var);
        c0Var.c(j.a, p2Var);
        new r2(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: f.b.a.c.e.c.q2
            @Override // java.lang.Runnable
            public final void run() {
                i iVar2 = i.this;
                if (!iVar2.a.n()) {
                    iVar2.a(new TimeoutException("Timed out."));
                }
            }
        }, j2);
        return iVar.a;
    }

    public static int D(int i2, int i3) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(l(i2, i3, "index"));
    }

    public static <V> V D0(Future<V> future) {
        V v;
        H(future.isDone(), "Future was expected to be done: %s", future);
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public static <TResult> TResult D1(h<TResult> hVar) {
        if (hVar.o()) {
            return hVar.l();
        }
        if (hVar.m()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(hVar.k());
    }

    public static void E(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? l(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? l(i3, i4, "end index") : t.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static Drawable E0(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable i0;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (i0 = m.e.i0(context, resourceId)) == null) ? typedArray.getDrawable(i2) : i0;
    }

    public static Object E1(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i2);
        throw new NullPointerException(sb.toString());
    }

    public static void F(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static JSONObject F0(Throwable th) {
        if (!(th instanceof u)) {
            return new JSONObject();
        }
        u uVar = (u) th;
        k kVar = uVar.b;
        if (kVar == null || kVar.b == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(new String(uVar.b.b, StandardCharsets.UTF_8));
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static String F1(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master") || replaceFirst.equals("base-main")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.").replace(".config.master", str);
                str2 = ".config.main";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static void G(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static f0.b G0(e.o.a.m mVar, f0.b bVar) {
        c a2 = ((g.b.a.c.b.b) u0(mVar, g.b.a.c.b.b.class)).a();
        Objects.requireNonNull(a2);
        return a2.a(mVar, mVar.f1812g, bVar);
    }

    public static String G1(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public static void H(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(t.b(str, obj));
        }
    }

    public static p1 H0(s sVar) {
        return sVar.u().h("__local_write_time__").x();
    }

    public static String H1(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", sb3.length() != 0 ? "Exception during lenientFormat for ".concat(sb3) : new String("Exception during lenientFormat for "), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 9 + name2.length());
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i3] = sb;
            i3++;
        }
        StringBuilder sb5 = new StringBuilder((length * 16) + str.length());
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i2 >= length2 || (indexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb5.append((CharSequence) str, i4, indexOf);
            i2++;
            sb5.append(objArr[i2]);
            i4 = indexOf + 2;
        }
        sb5.append((CharSequence) str, i4, str.length());
        if (i2 < length2) {
            sb5.append(" [");
            int i5 = i2 + 1;
            sb5.append(objArr[i2]);
            while (i5 < objArr.length) {
                sb5.append(", ");
                i5++;
                sb5.append(objArr[i5]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }

    public static int I(int i2, int i3) {
        return e.j.c.a.c(i2, (Color.alpha(i2) * i3) / 255);
    }

    public static float I0(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            AtomicInteger atomicInteger = v.a;
            f2 += v.i.i((View) parent);
        }
        return f2;
    }

    public static String I1(List<File> list) {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File file : list) {
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
    }

    public static f.b.c.f.d<?> J(String str, String str2) {
        f.b.c.n.a aVar = new f.b.c.n.a(str, str2);
        d.b a2 = f.b.c.f.d.a(e.class);
        a2.c = 1;
        a2.c(new f(aVar) { // from class: f.b.c.f.c
            public final Object a;

            {
                this.a = r1;
            }

            @Override // f.b.c.f.f
            public Object a(e eVar) {
                return this.a;
            }
        });
        return a2.b();
    }

    public static final String J0(Context context, String str) {
        j.k.b.e.c(context, "$this$getStringResourceByName");
        j.k.b.e.c(str, "aString");
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return "";
        }
        String string = context.getString(identifier);
        j.k.b.e.b(string, "getString(resId)");
        return string;
    }

    public static void J1(PackageManager packageManager, ComponentName componentName, int i2) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 516);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i3 = 0;
                    loop0: while (true) {
                        if (i3 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i3];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i4 = 0; i4 < length; i4++) {
                                componentInfo = componentInfoArr2[i4];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i3++;
                    }
                    if (componentInfo != null) {
                        if (componentInfo.isEnabled()) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static Animator K(f.b.a.e.j.c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, (Property<f.b.a.e.j.c, V>) c.C0093c.a, (TypeEvaluator) c.b.b, (Object[]) new c.e[]{new c.e(f2, f3, f4)});
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static final int K0(Context context, int i2) {
        j.k.b.e.c(context, "$this$getSupportColor");
        return e.j.b.a.a(context, i2);
    }

    public static boolean K1(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static f.b.a.e.v.d L(int i2) {
        if (i2 == 0) {
            return new f.b.a.e.v.i();
        }
        if (i2 != 1) {
            return new f.b.a.e.v.i();
        }
        return new f.b.a.e.v.e();
    }

    public static TextView L0(Toolbar toolbar, CharSequence charSequence) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    public static String L1(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        sb.append(":");
        sb.append(str3);
        return sb.toString();
    }

    public static int M(byte[] bArr, int i2, f.b.g.f fVar) {
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 > bArr.length - h0) {
            throw d0.h();
        } else if (i3 == 0) {
            fVar.c = f.b.g.j.c;
            return h0;
        } else {
            fVar.c = f.b.g.j.m(bArr, h0, i3);
            return h0 + i3;
        }
    }

    public static final int M0(Context context, int i2) {
        j.k.b.e.c(context, "$this$getThemeColor");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return 0;
        }
        int i3 = typedValue.resourceId;
        return i3 != 0 ? e.j.b.a.a(context, i3) : typedValue.data;
    }

    public static <T> void M1(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int N(int i2, byte[] bArr, int i3, int i4, z.c<?, ?> cVar, z.e<?, ?> eVar, r1<s1, s1> r1Var, f.b.g.f fVar) {
        z.d dVar;
        Object g2;
        int i5;
        int i6;
        Object obj;
        Object obj2;
        long j2;
        int i7;
        int i8;
        int i9;
        c0.i iVar;
        f.b.g.v<z.d> vVar = cVar.extensions;
        int i10 = i2 >>> 3;
        z.d dVar2 = eVar.f3987d;
        Object obj3 = null;
        if (!dVar2.f3985e || !dVar2.f3986f) {
            y1 y1Var = dVar2.f3984d;
            if (y1Var == y1.ENUM) {
                i6 = h0(bArr, i3, fVar);
                if (eVar.f3987d.b.findValueByNumber(fVar.a) == null) {
                    Object obj4 = cVar.unknownFields;
                    Object obj5 = obj4;
                    if (obj4 == s1.f3937f) {
                        s1 e2 = s1.e();
                        cVar.unknownFields = e2;
                        obj5 = e2;
                    }
                    int i11 = fVar.a;
                    Class<?> cls = l1.a;
                    Object obj6 = obj5;
                    if (obj5 == null) {
                        obj6 = r1Var.m();
                    }
                    r1Var.e(obj6 == 1 ? 1 : 0, i10, (long) i11);
                    return i6;
                }
            } else {
                switch (y1Var.ordinal()) {
                    case 0:
                        obj = Double.valueOf(Double.longBitsToDouble(P(bArr, i3)));
                        obj3 = obj;
                        i3 += 8;
                        break;
                    case 1:
                        obj2 = Float.valueOf(Float.intBitsToFloat(O(bArr, i3)));
                        obj3 = obj2;
                        i3 += 4;
                        break;
                    case 2:
                    case 3:
                        i7 = j0(bArr, i3, fVar);
                        j2 = fVar.b;
                        obj3 = Long.valueOf(j2);
                        i3 = i7;
                        break;
                    case 4:
                    case 12:
                        i6 = h0(bArr, i3, fVar);
                        break;
                    case 5:
                    case 15:
                        obj = Long.valueOf(P(bArr, i3));
                        obj3 = obj;
                        i3 += 8;
                        break;
                    case 6:
                    case 14:
                        obj2 = Integer.valueOf(O(bArr, i3));
                        obj3 = obj2;
                        i3 += 4;
                        break;
                    case 7:
                        i3 = j0(bArr, i3, fVar);
                        obj3 = Boolean.valueOf(fVar.b != 0);
                        break;
                    case 8:
                        i8 = d0(bArr, i3, fVar);
                        i3 = i8;
                        obj3 = fVar.c;
                        break;
                    case 9:
                        i8 = Q(e1.c.a(eVar.c.getClass()), bArr, i3, i4, (i10 << 3) | 4, fVar);
                        i3 = i8;
                        obj3 = fVar.c;
                        break;
                    case 10:
                        i8 = R(e1.c.a(eVar.c.getClass()), bArr, i3, i4, fVar);
                        i3 = i8;
                        obj3 = fVar.c;
                        break;
                    case 11:
                        i8 = M(bArr, i3, fVar);
                        i3 = i8;
                        obj3 = fVar.c;
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 16:
                        i3 = h0(bArr, i3, fVar);
                        i5 = f.b.g.k.b(fVar.a);
                        obj3 = Integer.valueOf(i5);
                        break;
                    case 17:
                        i7 = j0(bArr, i3, fVar);
                        j2 = f.b.g.k.c(fVar.b);
                        obj3 = Long.valueOf(j2);
                        i3 = i7;
                        break;
                }
                dVar = eVar.f3987d;
                if (!dVar.f3985e) {
                    vVar.a(dVar, obj3);
                } else {
                    int ordinal = dVar.f3984d.ordinal();
                    if ((ordinal == 9 || ordinal == 10) && (g2 = vVar.g(eVar.f3987d)) != null) {
                        obj3 = f.b.g.c0.c(g2, obj3);
                    }
                    vVar.o(eVar.f3987d, obj3);
                }
                return i3;
            }
            i5 = fVar.a;
            i3 = i6;
            obj3 = Integer.valueOf(i5);
            dVar = eVar.f3987d;
            if (!dVar.f3985e) {
            }
            return i3;
        }
        switch (dVar2.f3984d.ordinal()) {
            case 0:
                c0.i oVar = new f.b.g.o();
                i9 = U(bArr, i3, oVar, fVar);
                iVar = oVar;
                break;
            case 1:
                c0.i xVar = new x();
                i9 = X(bArr, i3, xVar, fVar);
                iVar = xVar;
                break;
            case 2:
            case 3:
                c0.i k0Var = new k0();
                i9 = b0(bArr, i3, k0Var, fVar);
                iVar = k0Var;
                break;
            case 4:
            case 12:
                c0.i b0Var = new b0();
                i9 = a0(bArr, i3, b0Var, fVar);
                iVar = b0Var;
                break;
            case 5:
            case 15:
                c0.i k0Var2 = new k0();
                i9 = W(bArr, i3, k0Var2, fVar);
                iVar = k0Var2;
                break;
            case 6:
            case 14:
                c0.i b0Var2 = new b0();
                i9 = V(bArr, i3, b0Var2, fVar);
                iVar = b0Var2;
                break;
            case 7:
                c0.i hVar = new f.b.g.h();
                i9 = T(bArr, i3, hVar, fVar);
                iVar = hVar;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                StringBuilder h2 = a.h("Type cannot be packed: ");
                h2.append(eVar.f3987d.f3984d);
                throw new IllegalStateException(h2.toString());
            case 13:
                b0 b0Var3 = new b0();
                int a0 = a0(bArr, i3, b0Var3, fVar);
                s1 s1Var = cVar.unknownFields;
                if (s1Var != s1.f3937f) {
                    obj3 = s1Var;
                }
                s1 s1Var2 = (s1) l1.y(i10, b0Var3, eVar.f3987d.b, obj3, r1Var);
                if (s1Var2 != null) {
                    cVar.unknownFields = s1Var2;
                }
                vVar.o(eVar.f3987d, b0Var3);
                return a0;
            case 16:
                c0.i b0Var4 = new b0();
                i9 = Y(bArr, i3, b0Var4, fVar);
                iVar = b0Var4;
                break;
            case 17:
                c0.i k0Var3 = new k0();
                i9 = Z(bArr, i3, k0Var3, fVar);
                iVar = k0Var3;
                break;
        }
        vVar.o(eVar.f3987d, iVar);
        return i9;
    }

    public static final int N0(Context context, int i2, int i3) {
        j.k.b.e.c(context, "$this$getThemeColor");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return i3;
        }
        if (typedValue.resourceId == 0) {
            return typedValue.data;
        }
        Resources resources = context.getResources();
        int i4 = typedValue.resourceId;
        Resources.Theme theme = context.getTheme();
        ThreadLocal<TypedValue> threadLocal = e.j.b.b.h.a;
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i4, theme) : resources.getColor(i4);
    }

    public static void N1(byte[] bArr, p pVar, OutputStream outputStream, long j2, int i2, long j3) {
        InputStream d2;
        int i3 = i2;
        if (i3 < 0) {
            throw new IOException("copyLength negative");
        } else if (j2 >= 0) {
            long j4 = (long) i3;
            if (j4 <= j3) {
                try {
                    q qVar = new q(pVar, j2, j4);
                    synchronized (qVar) {
                        d2 = qVar.d(0, qVar.c());
                    }
                    while (i3 > 0) {
                        int min = Math.min(i3, 16384);
                        int i4 = 0;
                        while (i4 < min) {
                            int read = d2.read(bArr, i4, min - i4);
                            if (read != -1) {
                                i4 += read;
                            } else {
                                throw new IOException("truncated input stream");
                            }
                        }
                        outputStream.write(bArr, 0, min);
                        i3 -= min;
                    }
                    d2.close();
                } catch (EOFException e2) {
                    throw new IOException("patch underrun", e2);
                }
            } else {
                throw new IOException("Output length overrun");
            }
        } else {
            throw new IOException("inputOffset negative");
        }
    }

    public static int O(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static String O0(long j2) {
        Locale locale = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            return f.b.a.e.l.d0.c("yMMMd", locale).format(new Date(j2));
        }
        AtomicReference<f.b.a.e.l.c0> atomicReference = f.b.a.e.l.d0.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(f.b.a.e.l.d0.e());
        return dateInstance.format(new Date(j2));
    }

    public static boolean O1(int i2) {
        return i2 == 2 || i2 == 7 || i2 == 3;
    }

    public static long P(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static void P0(boolean z, String str, Object... objArr) {
        if (!z) {
            r0(str, objArr);
            throw null;
        }
    }

    public static Object[] P1(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            E1(objArr[i3], i3);
        }
        return objArr;
    }

    public static int Q(j1 j1Var, byte[] bArr, int i2, int i3, int i4, f.b.g.f fVar) {
        v0 v0Var = (v0) j1Var;
        Object g2 = v0Var.g();
        int K = v0Var.K(g2, bArr, i2, i3, i4, fVar);
        v0Var.i(g2);
        fVar.c = g2;
        return K;
    }

    public static int Q0(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static long Q1(byte[] bArr, int i2) {
        return ((long) ((A1(bArr, i2 + 2) << 16) | A1(bArr, i2))) & 4294967295L;
    }

    public static int R(j1 j1Var, byte[] bArr, int i2, int i3, f.b.g.f fVar) {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = g0(b2, bArr, i4, fVar);
            b3 = fVar.a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw d0.h();
        }
        Object g2 = j1Var.g();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        j1Var.e(g2, bArr, i4, i5, fVar);
        j1Var.i(g2);
        fVar.c = g2;
        return i5;
    }

    public static <V> f.b.b.f.a.u<V> R0(V v) {
        return v == null ? (f.b.b.f.a.u<V>) f.b.b.f.a.s.c : new f.b.b.f.a.s(v);
    }

    public static <ResultT> ResultT R1(r<ResultT> rVar) {
        if (rVar.e()) {
            return rVar.d();
        }
        throw new ExecutionException(rVar.c());
    }

    public static int S(j1<?> j1Var, int i2, byte[] bArr, int i3, int i4, c0.i<?> iVar, f.b.g.f fVar) {
        int R = R(j1Var, bArr, i3, i4, fVar);
        while (true) {
            iVar.add(fVar.c);
            if (R >= i4) {
                break;
            }
            int h0 = h0(bArr, R, fVar);
            if (i2 != fVar.a) {
                break;
            }
            R = R(j1Var, bArr, h0, i4, fVar);
        }
        return R;
    }

    @RecentlyNonNull
    public static boolean S0() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static void S1(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i2, long j2) {
        if (i2 < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i2) <= j2) {
            while (i2 > 0) {
                try {
                    int min = Math.min(i2, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i2 -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }

    public static int T(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        f.b.g.h hVar = (f.b.g.h) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            h0 = j0(bArr, h0, fVar);
            hVar.i(fVar.b != 0);
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean T0(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static boolean T1(int i2, int i3) {
        if (i2 == 5) {
            if (i3 != 5) {
                return true;
            }
            i2 = 5;
        }
        if (i2 == 6) {
            if (i3 != 6 && i3 != 5) {
                return true;
            }
            i2 = 6;
        }
        if (i2 == 4 && i3 != 4) {
            return true;
        }
        if (i2 == 3 && (i3 == 2 || i3 == 7 || i3 == 1 || i3 == 8)) {
            return true;
        }
        if (i2 == 2) {
            return i3 == 1 || i3 == 8;
        }
        return false;
    }

    public static int U(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        f.b.g.o oVar = (f.b.g.o) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            oVar.i(Double.longBitsToDouble(P(bArr, h0)));
            h0 += 8;
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean U0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static void U1(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? W1(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? W1(i3, i4, "end index") : H1("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static int V(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        b0 b0Var = (b0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            b0Var.i(O(bArr, h0));
            h0 += 4;
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean V0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static boolean V1(int i2) {
        return i2 == 5 || i2 == 6 || i2 == 4;
    }

    public static int W(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        k0 k0Var = (k0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            k0Var.i(P(bArr, h0));
            h0 += 8;
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean W0(View view) {
        AtomicInteger atomicInteger = v.a;
        return v.e.d(view) == 1;
    }

    public static String W1(int i2, int i3, String str) {
        if (i2 < 0) {
            return H1("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return H1("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int X(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        x xVar = (x) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            xVar.i(Float.intBitsToFloat(O(bArr, h0)));
            h0 += 4;
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean X0(byte b2) {
        return b2 > -65;
    }

    public static int Y(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        b0 b0Var = (b0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            h0 = h0(bArr, h0, fVar);
            b0Var.i(f.b.g.k.b(fVar.a));
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static boolean Y0(s sVar) {
        s g2 = sVar.u().g("__type__", null);
        return g2 != null && "server_timestamp".equals(g2.w());
    }

    public static int Z(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        k0 k0Var = (k0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            h0 = j0(bArr, h0, fVar);
            k0Var.i(f.b.g.k.c(fVar.b));
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    @RecentlyNonNull
    public static boolean Z0(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (a == null) {
            a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (!X0(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !X0(b4) && !X0(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw d0.c();
    }

    public static int a0(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        b0 b0Var = (b0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            h0 = h0(bArr, h0, fVar);
            b0Var.i(fVar.a);
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    @RecentlyNonNull
    public static boolean a1(@RecentlyNonNull Context context) {
        if (Z0(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (b == null) {
                    b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!b.booleanValue() || S0()) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(byte b2) {
        return b2 >= 0;
    }

    public static int b0(byte[] bArr, int i2, c0.i<?> iVar, f.b.g.f fVar) {
        k0 k0Var = (k0) iVar;
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a + h0;
        while (h0 < i3) {
            h0 = j0(bArr, h0, fVar);
            k0Var.i(fVar.b);
        }
        if (h0 == i3) {
            return h0;
        }
        throw d0.h();
    }

    public static int b1(int i2, int i3, float f2) {
        return e.j.c.a.a(e.j.c.a.c(i3, Math.round(((float) Color.alpha(i3)) * f2)), i2);
    }

    public static boolean c(byte b2) {
        return b2 < -32;
    }

    public static l c0(String str) {
        List list;
        int length = str.length();
        P0(length >= 2, "Invalid path \"%s\"", str);
        if (length == 2) {
            P0(str.charAt(0) == 1 && str.charAt(1) == 1, "Non-empty path \"%s\" had length 2", str);
            list = Collections.emptyList();
        } else {
            int length2 = str.length() - 2;
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = str.indexOf(1, i2);
                if (indexOf < 0 || indexOf > length2) {
                    throw new IllegalArgumentException(a.c("Invalid encoded resource path: \"", str, "\""));
                }
                int i3 = indexOf + 1;
                char charAt = str.charAt(i3);
                if (charAt == 1) {
                    String substring = str.substring(i2, indexOf);
                    if (sb.length() != 0) {
                        sb.append(substring);
                        substring = sb.toString();
                        sb.setLength(0);
                    }
                    arrayList.add(substring);
                } else if (charAt == 16) {
                    sb.append(str.substring(i2, indexOf));
                    sb.append((char) 0);
                } else if (charAt == 17) {
                    sb.append(str.substring(i2, i3));
                } else {
                    throw new IllegalArgumentException(a.c("Invalid encoded resource path: \"", str, "\""));
                }
                i2 = indexOf + 2;
            }
            list = arrayList;
        }
        return l.r(list);
    }

    public static float c1(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static void d(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || X0(b3)) {
            throw d0.c();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static int d0(byte[] bArr, int i2, f.b.g.f fVar) {
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 == 0) {
            fVar.c = "";
            return h0;
        } else {
            fVar.c = new String(bArr, h0, i3, f.b.g.c0.a);
            return h0 + i3;
        }
    }

    public static w d1(ExecutorService executorService) {
        if (executorService instanceof w) {
            return (w) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new a0((ScheduledExecutorService) executorService) : new f.b.b.f.a.z(executorService);
    }

    public static boolean e(byte b2) {
        return b2 < -16;
    }

    public static int e0(byte[] bArr, int i2, f.b.g.f fVar) {
        int h0 = h0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 == 0) {
            fVar.c = "";
            return h0;
        } else {
            fVar.c = w1.b(bArr, h0, i3);
            return h0 + i3;
        }
    }

    public static View e1(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "viewHolder");
        return null;
    }

    public static void f(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (X0(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || X0(b4)))) {
            throw d0.c();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static int f0(int i2, byte[] bArr, int i3, int i4, s1 s1Var, f.b.g.f fVar) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int j0 = j0(bArr, i3, fVar);
                s1Var.f(i2, Long.valueOf(fVar.b));
                return j0;
            } else if (i5 == 1) {
                s1Var.f(i2, Long.valueOf(P(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int h0 = h0(bArr, i3, fVar);
                int i6 = fVar.a;
                if (i6 < 0) {
                    throw d0.f();
                } else if (i6 <= bArr.length - h0) {
                    s1Var.f(i2, i6 == 0 ? f.b.g.j.c : f.b.g.j.m(bArr, h0, i6));
                    return h0 + i6;
                } else {
                    throw d0.h();
                }
            } else if (i5 == 3) {
                s1 e2 = s1.e();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int h02 = h0(bArr, i3, fVar);
                    int i9 = fVar.a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = h02;
                        break;
                    }
                    i3 = f0(i8, bArr, h02, i4, e2, fVar);
                    i8 = i9;
                }
                if (i3 > i4 || i8 != i7) {
                    throw d0.g();
                }
                s1Var.f(i2, e2);
                return i3;
            } else if (i5 == 5) {
                s1Var.f(i2, Integer.valueOf(O(bArr, i3)));
                return i3 + 4;
            } else {
                throw d0.b();
            }
        } else {
            throw d0.b();
        }
    }

    public static List f1(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "viewHolder");
        return null;
    }

    public static <V> void g(f.b.b.f.a.u<V> uVar, f.b.b.f.a.p<? super V> pVar, Executor executor) {
        Objects.requireNonNull(pVar);
        uVar.a(new f.b.b.f.a.q(uVar, pVar), executor);
    }

    public static int g0(int i2, byte[] bArr, int i3, f.b.g.f fVar) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i4 = b2 << 7;
        } else {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i5 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i5 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] < 0) {
                                i9 = i11;
                            } else {
                                fVar.a = i10;
                                return i11;
                            }
                        }
                    }
                }
            }
            fVar.a = i8 | i5;
            return i9;
        }
        fVar.a = i6 | i4;
        return i7;
    }

    public static PorterDuff.Mode g1(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static List<Integer> h(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new f.b.b.e.a(iArr);
    }

    public static int h0(byte[] bArr, int i2, f.b.g.f fVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return g0(b2, bArr, i3, fVar);
        }
        fVar.a = b2;
        return i3;
    }

    public static void h1(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            j2 = Math.max(j2, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j2);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static final <Item extends f.d.b.k<? extends RecyclerView.b0>> void i(f.d.b.r.c<Item> cVar, RecyclerView.b0 b0Var, View view) {
        j.k.b.e.c(cVar, "$this$attachToView");
        j.k.b.e.c(b0Var, "viewHolder");
        j.k.b.e.c(view, "view");
        if (cVar instanceof f.d.b.r.a) {
            view.setOnClickListener(new f.d.b.s.e(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.d) {
            view.setOnLongClickListener(new f.d.b.s.f(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.i) {
            view.setOnTouchListener(new g(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.b) {
            ((f.d.b.r.b) cVar).c(view, b0Var);
        }
    }

    public static int i0(int i2, byte[] bArr, int i3, int i4, c0.i<?> iVar, f.b.g.f fVar) {
        b0 b0Var = (b0) iVar;
        int h0 = h0(bArr, i3, fVar);
        while (true) {
            b0Var.i(fVar.a);
            if (h0 >= i4) {
                break;
            }
            int h02 = h0(bArr, h0, fVar);
            if (i2 != fVar.a) {
                break;
            }
            h0 = h0(bArr, h02, fVar);
        }
        return h0;
    }

    public static final void i1(StringBuilder sb, int i2, String str, Object obj) {
        String o0;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                i1(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                i1(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                o0 = o0(f.b.g.j.n((String) obj));
            } else if (obj instanceof f.b.g.j) {
                sb.append(": \"");
                o0 = o0((f.b.g.j) obj);
            } else {
                if (obj instanceof z) {
                    sb.append(" {");
                    j1((z) obj, sb, i2 + 2);
                    sb.append("\n");
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i5 = i2 + 2;
                    i1(sb, i5, "key", entry2.getKey());
                    i1(sb, i5, "value", entry2.getValue());
                    sb.append("\n");
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                    return;
                }
                sb.append("}");
                return;
            }
            sb.append(o0);
            sb.append('\"');
        }
    }

    public static <TResult> TResult j(h<TResult> hVar) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            m.e.r(hVar, "Task must not be null");
            if (hVar.n()) {
                return (TResult) D1(hVar);
            }
            f.b.a.c.i.k kVar = new f.b.a.c.i.k(null);
            Executor executor = j.b;
            hVar.g(executor, kVar);
            hVar.e(executor, kVar);
            hVar.b(executor, kVar);
            kVar.a.await();
            return (TResult) D1(hVar);
        }
        throw new IllegalStateException("Must not be called on the main application thread");
    }

    public static int j0(byte[] bArr, int i2, f.b.g.f fVar) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 >= 0) {
            fVar.b = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            i4++;
            byte b3 = bArr[i4];
            i5 += 7;
            j3 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            b2 = b3;
        }
        fVar.b = j3;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ca, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x021d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01db, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x021d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ed, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x021d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x021d, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void j1(t0 t0Var, StringBuilder sb, int i2) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = t0Var.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String substring = str2.startsWith("get") ? str2.substring(3) : str2;
            boolean z2 = true;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String str3 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 4);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    str = n(str3);
                    obj = z.invokeOrDie(method2, t0Var, new Object[0]);
                    i1(sb, i2, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    i1(sb, i2, n(str4), z.invokeOrDie(method3, t0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder h2 = a.h("get");
                    h2.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(h2.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = z.invokeOrDie(method4, t0Var, new Object[0]);
                    if (method5 == null) {
                        if (obj instanceof Boolean) {
                            z = !((Boolean) obj).booleanValue();
                        } else if (!(obj instanceof Integer)) {
                            if (!(obj instanceof Float)) {
                                if (!(obj instanceof Double)) {
                                    if (obj instanceof String) {
                                        obj2 = "";
                                    } else if (obj instanceof f.b.g.j) {
                                        obj2 = f.b.g.j.c;
                                    } else {
                                        z = !(obj instanceof t0) ? false : false;
                                    }
                                    z = obj.equals(obj2);
                                }
                            }
                        }
                        if (z) {
                            z2 = false;
                        }
                    } else {
                        z2 = ((Boolean) z.invokeOrDie(method5, t0Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = n(str5);
                        i1(sb, i2, str, obj);
                    }
                }
            }
        }
        if (t0Var instanceof z.c) {
            Iterator<Map.Entry<z.d, Object>> l2 = ((z.c) t0Var).extensions.l();
            while (l2.hasNext()) {
                Map.Entry<z.d, Object> next = l2.next();
                StringBuilder h3 = a.h("[");
                h3.append(next.getKey().c);
                h3.append("]");
                i1(sb, i2, h3.toString(), next.getValue());
            }
        }
        s1 s1Var = ((z) t0Var).unknownFields;
        if (s1Var != null) {
            for (int i3 = 0; i3 < s1Var.a; i3++) {
                i1(sb, i2, String.valueOf(s1Var.b[i3] >>> 3), s1Var.c[i3]);
            }
        }
    }

    public static <ResultT> ResultT k(r<ResultT> rVar) {
        boolean z;
        Objects.requireNonNull(rVar, "Task must not be null");
        synchronized (rVar.a) {
            z = rVar.c;
        }
        if (z) {
            return (ResultT) R1(rVar);
        }
        f.b.a.f.a.h.s sVar = new f.b.a.f.a.h.s();
        Executor executor = f.b.a.f.a.h.e.b;
        rVar.b(executor, sVar);
        rVar.a(executor, sVar);
        sVar.a.await();
        return (ResultT) R1(rVar);
    }

    public static float k0(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static Executor k1(Executor executor, f.b.b.f.a.b<?> bVar) {
        Objects.requireNonNull(executor);
        return executor == f.b.b.f.a.k.INSTANCE ? executor : new y(executor, bVar);
    }

    public static String l(int i2, int i3, String str) {
        if (i2 < 0) {
            return t.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return t.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(a.u("negative size: ", i3));
    }

    public static final void l0(View view, int... iArr) {
        j.k.b.e.c(view, "$this$doOnApplySystemWindowInsets");
        j.k.b.e.c(iArr, "gravities");
        view.setOnApplyWindowInsetsListener(new f.d.a.f.c(iArr, new f.d.a.f.a(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom())));
        j.k.b.e.c(view, "$this$requestApplyInsetsWhenAttached");
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new f.d.a.f.d());
        }
    }

    public static TypedValue l1(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static final void m(List<? extends f.d.b.r.c<? extends f.d.b.k<? extends RecyclerView.b0>>> list, RecyclerView.b0 b0Var) {
        j.k.b.e.c(list, "$this$bind");
        j.k.b.e.c(b0Var, "viewHolder");
        Iterator<? extends f.d.b.r.c<? extends f.d.b.k<? extends RecyclerView.b0>>> it = list.iterator();
        while (it.hasNext()) {
            f.d.b.r.c cVar = (f.d.b.r.c) it.next();
            View a2 = cVar.a(b0Var);
            if (a2 != null) {
                i(cVar, b0Var, a2);
            }
            List<View> b2 = cVar.b(b0Var);
            if (b2 != null) {
                for (View view : b2) {
                    i(cVar, b0Var, view);
                }
            }
        }
    }

    public static <B extends f.b.c.k.u.a<B>> String m0(B b2) {
        StringBuilder sb = new StringBuilder();
        int n = b2.n();
        for (int i2 = 0; i2 < n; i2++) {
            if (sb.length() > 0) {
                sb.append((char) 1);
                sb.append((char) 1);
            }
            String i3 = b2.i(i2);
            int length = i3.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = i3.charAt(i4);
                if (charAt == 0) {
                    sb.append((char) 1);
                    charAt = 16;
                } else if (charAt == 1) {
                    sb.append((char) 1);
                    charAt = 17;
                }
                sb.append(charAt);
            }
        }
        sb.append((char) 1);
        sb.append((char) 1);
        return sb.toString();
    }

    public static boolean m1(Context context, int i2, boolean z) {
        TypedValue l1 = l1(context, i2);
        return (l1 == null || l1.type != 18) ? z : l1.data != 0;
    }

    public static final String n(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static boolean n0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int n1(Context context, int i2, String str) {
        TypedValue l1 = l1(context, i2);
        if (l1 != null) {
            return l1.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static void o(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static String o0(f.b.g.j jVar) {
        String str;
        StringBuilder sb = new StringBuilder(jVar.size());
        for (int i2 = 0; i2 < jVar.size(); i2++) {
            int i3 = jVar.i(i2);
            if (i3 == 34) {
                str = "\\\"";
            } else if (i3 == 39) {
                str = "\\'";
            } else if (i3 != 92) {
                switch (i3) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (i3 < 32 || i3 > 126) {
                            sb.append('\\');
                            sb.append((char) (((i3 >>> 6) & 3) + 48));
                            sb.append((char) (((i3 >>> 3) & 7) + 48));
                            i3 = (i3 & 7) + 48;
                        }
                        sb.append((char) i3);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static Object o1(Context context, int[] iArr, int i2, int i3, j.k.a.b bVar, int i4) {
        int[] iArr2;
        if ((i4 & 1) != 0) {
            iArr2 = R$styleable.AboutLibraries;
            j.k.b.e.b(iArr2, "R.styleable.AboutLibraries");
        } else {
            iArr2 = null;
        }
        if ((i4 & 2) != 0) {
            i2 = R$attr.aboutLibrariesStyle;
        }
        if ((i4 & 4) != 0) {
            i3 = R$style.AboutLibrariesStyle;
        }
        j.k.b.e.c(context, "$this$resolveStyledValue");
        j.k.b.e.c(iArr2, "attrs");
        j.k.b.e.c(bVar, "resolver");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr2, i2, i3);
        j.k.b.e.b(obtainStyledAttributes, "obtainStyledAttributes(n…efStyleAttr, defStyleRes)");
        Object d2 = bVar.d(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return d2;
    }

    public static void p(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static final Boolean p0(Context context, Boolean bool, String str) {
        j.k.b.e.c(context, "$this$extractBooleanBundleOrResource");
        j.k.b.e.c(str, "resName");
        if (bool != null) {
            return bool;
        }
        String J0 = J0(context, str);
        if (J0.length() > 0) {
            try {
                return Boolean.valueOf(Boolean.parseBoolean(J0));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void p1(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof f.b.a.e.v.g) {
            f.b.a.e.v.g gVar = (f.b.a.e.v.g) background;
            g.b bVar = gVar.b;
            if (bVar.o != f2) {
                bVar.o = f2;
                gVar.z();
            }
        }
    }

    public static void q(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Character.valueOf(c2)));
        }
    }

    public static final String q0(Context context, String str, String str2) {
        j.k.b.e.c(context, "$this$extractStringBundleOrResource");
        j.k.b.e.c(str2, "resName");
        if (str != null) {
            return str;
        }
        String J0 = J0(context, str2);
        if (J0.length() > 0) {
            return J0;
        }
        return null;
    }

    public static void q1(View view, f.b.a.e.v.g gVar) {
        f.b.a.e.n.a aVar = gVar.b.b;
        if (aVar != null && aVar.a) {
            float I0 = I0(view);
            g.b bVar = gVar.b;
            if (bVar.n != I0) {
                bVar.n = I0;
                gVar.z();
            }
        }
    }

    public static void r(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Integer.valueOf(i2)));
        }
    }

    public static AssertionError r0(String str, Object... objArr) {
        StringBuilder h2 = a.h("INTERNAL ASSERTION FAILED: ");
        h2.append(String.format(str, objArr));
        throw new AssertionError(h2.toString());
    }

    public static int r1(int i2, byte[] bArr, int i3, int i4, f.b.g.f fVar) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return j0(bArr, i3, fVar);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return h0(bArr, i3, fVar) + fVar.a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = h0(bArr, i3, fVar);
                    i7 = fVar.a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = r1(i7, bArr, i3, i4, fVar);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw d0.g();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw d0.b();
            }
        } else {
            throw d0.b();
        }
    }

    public static void s(boolean z, String str, long j2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Long.valueOf(j2)));
        }
    }

    public static int s0(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        int i2 = (d2 > d3 ? 1 : (d2 == d3 ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (!Double.isNaN(d3)) {
            return -1;
        }
        return !Double.isNaN(d2) ? 1 : 0;
    }

    public static int s1(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    public static void t(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, obj));
        }
    }

    public static <TResult> h<TResult> t0(TResult tresult) {
        f.b.a.c.i.c0 c0Var = new f.b.a.c.i.c0();
        c0Var.r(tresult);
        return c0Var;
    }

    public static final String[] t1(Field[] fieldArr) {
        j.k.b.e.c(fieldArr, "$this$toStringArray");
        ArrayList arrayList = new ArrayList(fieldArr.length);
        for (Field field : fieldArr) {
            arrayList.add(field.getName());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String str = (String) next;
            j.k.b.e.b(str, "it");
            if (j.n.h.a(str, "define_", false)) {
                arrayList2.add(next);
            }
        }
        Object[] array = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static void u(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, obj, obj2));
        }
    }

    public static <T> T u0(Object obj, Class<T> cls) {
        if (obj instanceof g.b.b.a) {
            return cls.cast(obj);
        }
        if (obj instanceof g.b.b.b) {
            return (T) u0(((g.b.b.b) obj).e(), cls);
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", obj.getClass(), g.b.b.a.class, g.b.b.b.class));
    }

    public static f.b.b.a.k u1(Object obj) {
        return new f.b.b.a.k(obj.getClass().getSimpleName(), null);
    }

    public static void v(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static Application v0(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
            if (context2 instanceof Application) {
                return (Application) context2;
            }
        }
        throw new IllegalStateException("Could not find an Application in the given context: " + context);
    }

    public static <I, O> f.b.b.f.a.u<O> v1(f.b.b.f.a.u<I> uVar, f.b.b.a.g<? super I, ? extends O> gVar, Executor executor) {
        int i2 = f.b.b.f.a.d.f3445k;
        Objects.requireNonNull(gVar);
        d.b bVar = new d.b(uVar, gVar);
        uVar.a(bVar, k1(executor, bVar));
        return bVar;
    }

    public static int w(int i2, int i3) {
        String str;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str = t.b("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 >= 0) {
            str = t.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException(a.u("negative size: ", i3));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int w0(Context context, int i2, int i3) {
        TypedValue l1 = l1(context, i2);
        return l1 != null ? l1.data : i3;
    }

    public static PorterDuffColorFilter w1(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static Object x(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(a.u("at index ", i2));
    }

    public static int x0(View view, int i2) {
        return n1(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static void x1(boolean z, String str, Object obj) {
        if (!z) {
            throw new f.b.b.a.w(t.b(str, obj));
        }
    }

    public static void y(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static ColorStateList y0(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList g0;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (g0 = m.e.g0(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : g0;
    }

    public static int y1(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    public static int z(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    public static ColorStateList z0(Context context, c1 c1Var, int i2) {
        int resourceId;
        ColorStateList g0;
        return (!c1Var.b.hasValue(i2) || (resourceId = c1Var.b.getResourceId(i2, 0)) == 0 || (g0 = m.e.g0(context, resourceId)) == null) ? c1Var.c(i2) : g0;
    }

    public static int z1(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = H1("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str2 = H1("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }
}
