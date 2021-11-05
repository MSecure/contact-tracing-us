package b.x;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import androidx.annotation.RecentlyNonNull;
import b.b.k.i;
import b.b.l.a.a;
import b.b.q.y0;
import b.b0.d;
import b.b0.n;
import b.i.f.c;
import b.i.l.m;
import b.y.a.a.d;
import c.a.b.b;
import c.b.a.a.d.k.b;
import c.b.a.a.d.k.o.k;
import c.b.a.a.g.b.a1;
import c.b.a.a.g.b.b1;
import c.b.a.a.g.b.e1;
import c.b.a.a.g.b.e2;
import c.b.a.a.g.b.f1;
import c.b.a.a.g.b.i3;
import c.b.a.a.g.b.j4;
import c.b.a.a.g.b.p3;
import c.b.a.a.g.b.u;
import c.b.a.a.g.b.y;
import c.b.a.a.g.b.z0;
import c.b.a.a.g.e.w8;
import c.b.a.a.g.h.c2;
import c.b.a.a.g.h.c3;
import c.b.a.a.g.h.c4;
import c.b.a.a.g.h.e3;
import c.b.a.a.g.h.k4;
import c.b.a.a.g.h.q0;
import c.b.a.a.g.h.q3;
import c.b.a.a.g.h.t1;
import c.b.a.a.g.h.u1;
import c.b.a.a.g.h.v1;
import c.b.a.a.g.h.z1;
import c.b.a.a.j.l;
import c.b.a.b.h0.g;
import c.b.a.b.w.c;
import c.b.b.e.a.b;
import c.b.b.e.a.j;
import c.b.b.e.a.s;
import c.b.c.a.i0.i1;
import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.e;
import c.b.c.a.j0.a.i0;
import c.b.c.a.j0.a.j;
import c.b.c.a.j0.a.m1;
import c.b.c.a.j0.a.q1;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.t0;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.z;
import c.b.c.a.m0.c0;
import c.b.c.a.m0.w;
import c.b.c.a.m0.x;
import c.b.d.d2;
import c.b.d.f;
import c.b.d.f0;
import c.b.d.h0;
import c.b.d.k;
import c.b.d.k0;
import c.b.d.k1;
import c.b.d.k2;
import c.b.d.m0;
import c.b.d.m2;
import c.b.d.n0;
import c.b.d.n1;
import c.b.d.o0;
import c.b.d.o1;
import c.b.d.q2;
import c.b.d.r2;
import c.b.d.s;
import c.b.d.v0;
import c.b.d.w2;
import c.b.d.x;
import c.b.d.x2;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.w.h;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.xmlpull.v1.XmlPullParser;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f2720a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f2721b;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f2722c;

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f2723d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f2724e;

    @RecentlyNonNull
    public static String A(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static int A0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        c.b.d.t tVar = (c.b.d.t) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            tVar.c(k0(bArr, Y0));
            Y0 += 8;
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static int A1(View view, int i) {
        return B2(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static boolean A2(Context context, int i, boolean z) {
        TypedValue z2 = z2(context, i);
        return (z2 == null || z2.type != 18) ? z : z2.data != 0;
    }

    public static final void A3(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static int A4(byte[] bArr, int i, u uVar) {
        int S3 = S3(bArr, i, uVar);
        int i2 = uVar.f3424a;
        if (i2 == 0) {
            uVar.f3426c = "";
            return S3;
        }
        uVar.f3426c = new String(bArr, S3, i2, b1.f3229a);
        return S3 + i2;
    }

    public static void B(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static int B0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            zVar.c(l0(bArr, X0));
            X0 += 4;
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static ColorStateList B1(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a2 = a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a2;
    }

    public static int B2(Context context, int i, String str) {
        TypedValue z2 = z2(context, i);
        if (z2 != null) {
            return z2.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static final byte[] B3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i3 < 0 || bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }

    public static int B4(byte[] bArr, int i, c.b.a.a.g.h.n0 n0Var) {
        int U3 = U3(bArr, i, n0Var);
        int i2 = n0Var.f3967a;
        if (i2 < 0) {
            throw c2.b();
        } else if (i2 == 0) {
            n0Var.f3969c = "";
            return U3;
        } else {
            n0Var.f3969c = new String(bArr, U3, i2, u1.f4042a);
            return U3 + i2;
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T C(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static int C0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        m0 m0Var = (m0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            m0Var.c(m0(bArr, Y0));
            Y0 += 4;
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static ColorStateList C1(Context context, y0 y0Var, int i) {
        int resourceId;
        ColorStateList a2;
        return (!y0Var.f986b.hasValue(i) || (resourceId = y0Var.f986b.getResourceId(i, 0)) == 0 || (a2 = a.a(context, resourceId)) == null) ? y0Var.c(i) : a2;
    }

    public static int C2(int i, int i2) {
        int i3 = i + i2;
        if ((i ^ i3) >= 0 || (i ^ i2) < 0) {
            return i3;
        }
        throw new ArithmeticException("Addition overflows an int: " + i + " + " + i2);
    }

    public static final byte[] C3(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return B3(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static String C4(y yVar) {
        String str;
        StringBuilder sb = new StringBuilder(yVar.size());
        for (int i = 0; i < yVar.size(); i++) {
            int e2 = yVar.e(i);
            if (e2 == 34) {
                str = "\\\"";
            } else if (e2 == 39) {
                str = "\\'";
            } else if (e2 != 92) {
                switch (e2) {
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
                        if (e2 < 32 || e2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((e2 >>> 6) & 3) + 48));
                            sb.append((char) (((e2 >>> 3) & 7) + 48));
                            e2 = (e2 & 7) + 48;
                        }
                        sb.append((char) e2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @EnsuresNonNull({"#1"})
    public static <T> T D(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int D0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            i0Var.c(n0(bArr, X0));
            X0 += 8;
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static ECParameterSpec D1(w wVar) {
        int ordinal = wVar.ordinal();
        if (ordinal == 0) {
            return I1("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
        }
        if (ordinal == 1) {
            return I1("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
        }
        if (ordinal == 2) {
            return I1("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + wVar);
    }

    public static long D2(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        throw new ArithmeticException("Addition overflows a long: " + j + " + " + j2);
    }

    public static int D3(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    public static float D4(byte[] bArr, int i) {
        return Float.intBitsToFloat(n4(bArr, i));
    }

    public static <T> T E(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(b2(str, obj));
    }

    public static int E0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        v0 v0Var = (v0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            v0Var.c(o0(bArr, Y0));
            Y0 += 8;
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static <V> V E1(Future<V> future) {
        V v;
        boolean z = false;
        if (future.isDone()) {
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
        throw new IllegalStateException(b2("Future was expected to be done: %s", future));
    }

    public static long E2(long j, int i) {
        if (i != -1) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return j;
            }
            long j2 = (long) i;
            long j3 = j * j2;
            if (j3 / j2 == j) {
                return j3;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
        } else if (j != Long.MIN_VALUE) {
            return -j;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
        }
    }

    public static int E3(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = d4("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = d4("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int E4(byte[] bArr, int i, u uVar) {
        int S3 = S3(bArr, i, uVar);
        int i2 = uVar.f3424a;
        if (i2 == 0) {
            uVar.f3426c = "";
            return S3;
        }
        int i3 = S3 + i2;
        if (p3.f(bArr, S3, i3)) {
            uVar.f3426c = new String(bArr, S3, i2, b1.f3229a);
            return i3;
        }
        throw f1.e();
    }

    public static <T> T F(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int F0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        c.b.c.a.j0.a.w wVar = (c.b.c.a.j0.a.w) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            wVar.c(p0(bArr, X0));
            X0 += 4;
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static Drawable F1(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b2 = a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b2;
    }

    public static long F2(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + j2);
    }

    public static int F3(int i, byte[] bArr, int i2, int i3, u uVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return q4(bArr, i2, uVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return S3(bArr, i2, uVar) + uVar.f3424a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = S3(bArr, i2, uVar);
                    i6 = uVar.f3424a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = F3(i6, bArr, i2, i3, uVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw f1.d();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw f1.b();
            }
        } else {
            throw f1.b();
        }
    }

    public static int F4(byte[] bArr, int i, c.b.a.a.g.h.n0 n0Var) {
        int U3 = U3(bArr, i, n0Var);
        int i2 = n0Var.f3967a;
        if (i2 < 0) {
            throw c2.b();
        } else if (i2 == 0) {
            n0Var.f3969c = "";
            return U3;
        } else {
            n0Var.f3969c = k4.f3928a.c(bArr, U3, i2);
            return U3 + i2;
        }
    }

    public static void G(ECPoint eCPoint, EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            BigInteger p = ((ECFieldFp) field).getP();
            BigInteger affineX = eCPoint.getAffineX();
            BigInteger affineY = eCPoint.getAffineY();
            if (affineX == null || affineY == null) {
                throw new GeneralSecurityException("point is at infinity");
            } else if (affineX.signum() == -1 || affineX.compareTo(p) >= 0) {
                throw new GeneralSecurityException("x is out of range");
            } else if (affineY.signum() == -1 || affineY.compareTo(p) >= 0) {
                throw new GeneralSecurityException("y is out of range");
            } else if (!affineY.multiply(affineY).mod(p).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(p))) {
                throw new GeneralSecurityException("Point is not on curve");
            }
        } else {
            throw new GeneralSecurityException("Only curves over prime order fields are supported");
        }
    }

    public static int G0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        h0 h0Var = (h0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            h0Var.c(q0(bArr, Y0));
            Y0 += 4;
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static ECPrivateKey G1(w wVar, byte[] bArr) {
        return (ECPrivateKey) c.b.c.a.m0.a0.k.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), D1(wVar)));
    }

    public static int G2(int i, int i2) {
        int i3 = i - i2;
        if ((i ^ i3) >= 0 || (i ^ i2) >= 0) {
            return i3;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i + " - " + i2);
    }

    public static int G3(int i, byte[] bArr, int i2, int i3, e1<?> e1Var, u uVar) {
        a1 a1Var = (a1) e1Var;
        int S3 = S3(bArr, i2, uVar);
        while (true) {
            a1Var.h(a1Var.f3215d, uVar.f3424a);
            if (S3 >= i3) {
                break;
            }
            int S32 = S3(bArr, S3, uVar);
            if (i != uVar.f3424a) {
                break;
            }
            S3 = S3(bArr, S32, uVar);
        }
        return S3;
    }

    public static long G4(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static void H(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = l(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = l(i2, i3, "end index");
            } else {
                str = b2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static int H0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            X0 = X0(bArr, X0, eVar);
            zVar.c(j.b(eVar.f4911a));
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static ECPublicKey H1(w wVar, byte[] bArr, byte[] bArr2) {
        ECParameterSpec D1 = D1(wVar);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        G(eCPoint, D1.getCurve());
        return (ECPublicKey) c.b.c.a.m0.a0.k.a("EC").generatePublic(new ECPublicKeySpec(eCPoint, D1));
    }

    public static long H2(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j + " - " + j2);
    }

    public static int H3(int i, byte[] bArr, int i2, int i3, i3 i3Var, u uVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int q4 = q4(bArr, i2, uVar);
                i3Var.b(i, Long.valueOf(uVar.f3425b));
                return q4;
            } else if (i4 == 1) {
                i3Var.b(i, Long.valueOf(G4(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int S3 = S3(bArr, i2, uVar);
                int i5 = uVar.f3424a;
                i3Var.b(i, i5 == 0 ? y.f3474c : y.a(bArr, S3, i5));
                return S3 + i5;
            } else if (i4 == 3) {
                i3 e2 = i3.e();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int S32 = S3(bArr, i2, uVar);
                    int i8 = uVar.f3424a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = S32;
                        break;
                    }
                    int H3 = H3(i7, bArr, S32, i3, e2, uVar);
                    i7 = i8;
                    i2 = H3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw f1.d();
                }
                i3Var.b(i, e2);
                return i2;
            } else if (i4 == 5) {
                i3Var.b(i, Integer.valueOf(z4(bArr, i2)));
                return i2 + 4;
            } else {
                throw f1.b();
            }
        } else {
            throw f1.b();
        }
    }

    public static String H4(q0 q0Var) {
        String str;
        StringBuilder sb = new StringBuilder(q0Var.size());
        for (int i = 0; i < q0Var.size(); i++) {
            int c2 = q0Var.c(i);
            if (c2 == 34) {
                str = "\\\"";
            } else if (c2 == 39) {
                str = "\\'";
            } else if (c2 != 92) {
                switch (c2) {
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
                        if (c2 < 32 || c2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((c2 >>> 6) & 3) + 48));
                            sb.append((char) (((c2 >>> 3) & 7) + 48));
                            c2 = (c2 & 7) + 48;
                        }
                        sb.append((char) c2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static void I(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static int I0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        m0 m0Var = (m0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            Y0 = Y0(bArr, Y0, fVar);
            m0Var.c(k.b(fVar.f5257a));
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static ECParameterSpec I1(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static int I2(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j);
    }

    public static int I3(int i, byte[] bArr, int i2, int i3, c.b.a.a.g.h.n0 n0Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return r4(bArr, i2, n0Var);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return U3(bArr, i2, n0Var) + n0Var.f3967a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = U3(bArr, i2, n0Var);
                    i6 = n0Var.f3967a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = I3(i6, bArr, i2, i3, n0Var);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw c2.e();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw c2.c();
            }
        } else {
            throw c2.c();
        }
    }

    public static double I4(byte[] bArr, int i) {
        return Double.longBitsToDouble(G4(bArr, i));
    }

    public static byte[] J(byte[] bArr) {
        if (bArr.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[bArr.length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static int J0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            X0 = b1(bArr, X0, eVar);
            i0Var.c(j.c(eVar.f4912b));
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static PropertyValuesHolder J1(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !U1(i4)) && (!z2 || !U1(i5))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            c[] s = i.j.s(string);
            c[] s2 = i.j.s(string2);
            if (s == null && s2 == null) {
                return null;
            }
            if (s != null) {
                b.y.a.a.c cVar = new b.y.a.a.c();
                if (s2 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, cVar, s);
                } else if (i.j.e(s, s2)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, cVar, s, s2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder2;
            } else if (s2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new b.y.a.a.c(), s2);
            }
        } else {
            d dVar = i == 3 ? d.f2751a : null;
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
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : U1(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : U1(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else {
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : U1(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
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

    public static void J2(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            g gVar = (g) background;
            g.b bVar = gVar.f4261b;
            if (bVar.o != f2) {
                bVar.o = f2;
                gVar.z();
            }
        }
    }

    public static int J3(int i, byte[] bArr, int i2, int i3, z1<?> z1Var, c.b.a.a.g.h.n0 n0Var) {
        v1 v1Var = (v1) z1Var;
        int U3 = U3(bArr, i2, n0Var);
        while (true) {
            v1Var.h(n0Var.f3967a);
            if (U3 >= i3) {
                break;
            }
            int U32 = U3(bArr, U3, n0Var);
            if (i != n0Var.f3967a) {
                break;
            }
            U3 = U3(bArr, U32, n0Var);
        }
        return U3;
    }

    public static int J4(byte[] bArr, int i, u uVar) {
        int S3 = S3(bArr, i, uVar);
        int i2 = uVar.f3424a;
        if (i2 == 0) {
            uVar.f3426c = y.f3474c;
            return S3;
        }
        uVar.f3426c = y.a(bArr, S3, i2);
        return S3 + i2;
    }

    public static int K(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int K0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        v0 v0Var = (v0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            Y0 = c1(bArr, Y0, fVar);
            v0Var.c(k.c(fVar.f5258b));
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static float K1(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += m.l((View) parent);
        }
        return f2;
    }

    public static void K2(View view, g gVar) {
        c.b.a.b.z.a aVar = gVar.f4261b.f4269b;
        if (aVar != null && aVar.f4642a) {
            float K1 = K1(view);
            g.b bVar = gVar.f4261b;
            if (bVar.n != K1) {
                bVar.n = K1;
                gVar.z();
            }
        }
    }

    public static int K3(int i, byte[] bArr, int i2, int i3, c4 c4Var, c.b.a.a.g.h.n0 n0Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int r4 = r4(bArr, i2, n0Var);
                c4Var.a(i, Long.valueOf(n0Var.f3968b));
                return r4;
            } else if (i4 == 1) {
                c4Var.a(i, Long.valueOf(x4(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int U3 = U3(bArr, i2, n0Var);
                int i5 = n0Var.f3967a;
                if (i5 < 0) {
                    throw c2.b();
                } else if (i5 <= bArr.length - U3) {
                    c4Var.a(i, i5 == 0 ? q0.f4006c : q0.a(bArr, U3, i5));
                    return U3 + i5;
                } else {
                    throw c2.a();
                }
            } else if (i4 == 3) {
                c4 e2 = c4.e();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int U32 = U3(bArr, i2, n0Var);
                    int i8 = n0Var.f3967a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = U32;
                        break;
                    }
                    int K3 = K3(i7, bArr, U32, i3, e2, n0Var);
                    i7 = i8;
                    i2 = K3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw c2.e();
                }
                c4Var.a(i, e2);
                return i2;
            } else if (i4 == 5) {
                c4Var.a(i, Integer.valueOf(n4(bArr, i2)));
                return i2 + 4;
            } else {
                throw c2.c();
            }
        } else {
            throw c2.c();
        }
    }

    public static int K4(byte[] bArr, int i, c.b.a.a.g.h.n0 n0Var) {
        int U3 = U3(bArr, i, n0Var);
        int i2 = n0Var.f3967a;
        if (i2 < 0) {
            throw c2.b();
        } else if (i2 > bArr.length - U3) {
            throw c2.a();
        } else if (i2 == 0) {
            n0Var.f3969c = q0.f4006c;
            return U3;
        } else {
            n0Var.f3969c = q0.a(bArr, U3, i2);
            return U3 + i2;
        }
    }

    public static int L(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static int L0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            X0 = X0(bArr, X0, eVar);
            zVar.c(eVar.f4911a);
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static int L1(c.b.d.f1 f1Var, Map<s.g, Object> map) {
        boolean z = f1Var.getDescriptorForType().s().f5663d;
        int i = 0;
        for (Map.Entry<s.g, Object> entry : map.entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            i += (!z || !key.s() || key.f5823g != s.g.b.MESSAGE || key.e()) ? f0.i(key, value) : c.b.d.m.y(key.f5819c.f5594d, (c.b.d.f1) value);
        }
        q2 unknownFields = f1Var.getUnknownFields();
        return (z ? unknownFields.a() : unknownFields.getSerializedSize()) + i;
    }

    public static <TResult> void L2(@RecentlyNonNull Status status, TResult tresult, @RecentlyNonNull c.b.a.a.j.j<TResult> jVar) {
        if (status.t()) {
            jVar.f4109a.i(tresult);
            return;
        }
        jVar.f4109a.h(new b(status));
    }

    public static int L3(int i, byte[] bArr, int i2, u uVar) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i3 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i3 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                uVar.f3424a = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            uVar.f3424a = i7 | i4;
            return i8;
        }
        uVar.f3424a = i5 | i3;
        return i6;
    }

    public static float L4(byte[] bArr, int i) {
        return Float.intBitsToFloat(z4(bArr, i));
    }

    public static byte[] M(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long d2 = d2(bArr, 0, 0) & 67108863;
            int i = 3;
            long d22 = d2(bArr, 3, 2) & 67108611;
            long d23 = d2(bArr, 6, 4) & 67092735;
            long d24 = d2(bArr, 9, 6) & 66076671;
            long d25 = d2(bArr, 12, 8) & 1048575;
            long j = d22 * 5;
            long j2 = d23 * 5;
            long j3 = d24 * 5;
            long j4 = d25 * 5;
            int i2 = 17;
            byte[] bArr3 = new byte[17];
            long j5 = 0;
            int i3 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            while (i3 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i2, (byte) 0);
                }
                long d26 = d2(bArr3, 0, 0) + j9;
                long d27 = d2(bArr3, i, 2) + j5;
                long d28 = d2(bArr3, 6, 4) + j6;
                long d29 = d2(bArr3, 9, 6) + j7;
                long d210 = j8 + (d2(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
                long j10 = (d210 * j) + (d29 * j2) + (d28 * j3) + (d27 * j4) + (d26 * d2);
                long j11 = (d210 * j2) + (d29 * j3) + (d28 * j4) + (d27 * d2) + (d26 * d22);
                long j12 = (d210 * j3) + (d29 * j4) + (d28 * d2) + (d27 * d22) + (d26 * d23);
                long j13 = (d29 * d2) + (d28 * d22) + (d27 * d23) + (d26 * d24);
                long j14 = d29 * d22;
                long j15 = d210 * d2;
                long j16 = j11 + (j10 >> 26);
                long j17 = j12 + (j16 >> 26);
                long j18 = (d210 * j4) + j13 + (j17 >> 26);
                long j19 = j15 + j14 + (d28 * d23) + (d27 * d24) + (d26 * d25) + (j18 >> 26);
                long j20 = j19 >> 26;
                j8 = j19 & 67108863;
                long j21 = (j20 * 5) + (j10 & 67108863);
                long j22 = (j16 & 67108863) + (j21 >> 26);
                i3 += 16;
                j6 = j17 & 67108863;
                j7 = j18 & 67108863;
                i2 = 17;
                i = 3;
                j9 = j21 & 67108863;
                j5 = j22;
            }
            long j23 = j6 + (j5 >> 26);
            long j24 = j23 & 67108863;
            long j25 = j7 + (j23 >> 26);
            long j26 = j25 & 67108863;
            long j27 = j8 + (j25 >> 26);
            long j28 = j27 & 67108863;
            long j29 = ((j27 >> 26) * 5) + j9;
            long j30 = j29 >> 26;
            long j31 = j29 & 67108863;
            long j32 = (j5 & 67108863) + j30;
            long j33 = j31 + 5;
            long j34 = j33 & 67108863;
            long j35 = (j33 >> 26) + j32;
            long j36 = j24 + (j35 >> 26);
            long j37 = j26 + (j36 >> 26);
            long j38 = (j28 + (j37 >> 26)) - 67108864;
            long j39 = j38 >> 63;
            long j40 = j31 & j39;
            long j41 = j32 & j39;
            long j42 = j24 & j39;
            long j43 = j26 & j39;
            long j44 = j28 & j39;
            long j45 = ~j39;
            long j46 = j41 | (j35 & 67108863 & j45);
            long j47 = j42 | (j36 & 67108863 & j45);
            long j48 = j43 | (j37 & 67108863 & j45);
            long j49 = j44 | (j38 & j45);
            long e2 = e2(bArr, 16) + ((j40 | (j34 & j45) | (j46 << 26)) & 4294967295L);
            long e22 = e2(bArr, 20) + (((j46 >> 6) | (j47 << 20)) & 4294967295L) + (e2 >> 32);
            long j50 = e22 & 4294967295L;
            long e23 = e2(bArr, 24) + (((j47 >> 12) | (j48 << 14)) & 4294967295L) + (e22 >> 32);
            long e24 = e2(bArr, 28);
            byte[] bArr4 = new byte[16];
            R2(bArr4, e2 & 4294967295L, 0);
            R2(bArr4, j50, 4);
            R2(bArr4, e23 & 4294967295L, 8);
            R2(bArr4, (e24 + (((j48 >> 18) | (j49 << 8)) & 4294967295L) + (e23 >> 32)) & 4294967295L, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    public static int M0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        m0 m0Var = (m0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            Y0 = Y0(bArr, Y0, fVar);
            m0Var.c(fVar.f5257a);
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static <V> c.b.b.e.a.u<V> M1(Throwable th) {
        return new s.a(th);
    }

    public static int M2(int i, byte[] bArr, int i2, int i3, e eVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return b1(bArr, i2, eVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return X0(bArr, i2, eVar) + eVar.f4911a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = X0(bArr, i2, eVar);
                    i6 = eVar.f4911a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = M2(i6, bArr, i2, i3, eVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw b0.g();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw b0.b();
            }
        } else {
            throw b0.b();
        }
    }

    public static int M3(int i, byte[] bArr, int i2, c.b.a.a.g.h.n0 n0Var) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i3 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i3 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                n0Var.f3967a = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            n0Var.f3967a = i7 | i4;
            return i8;
        }
        n0Var.f3967a = i5 | i3;
        return i6;
    }

    public static boolean M4(byte b2) {
        return b2 > -65;
    }

    public static byte[] N(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (i <= Integer.MAX_VALUE - bArr2.length) {
                i += bArr2.length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    public static int N0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            X0 = b1(bArr, X0, eVar);
            i0Var.c(eVar.f4912b);
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static <V> c.b.b.e.a.u<V> N1(V v) {
        return v == null ? (c.b.b.e.a.u<V>) c.b.b.e.a.s.f4761c : new c.b.b.e.a.s(v);
    }

    public static int N2(int i, byte[] bArr, int i2, int i3, f fVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return c1(bArr, i2, fVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return Y0(bArr, i2, fVar) + fVar.f5257a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = Y0(bArr, i2, fVar);
                    i6 = fVar.f5257a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = N2(i6, bArr, i2, i3, fVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw o0.g();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw o0.b();
            }
        } else {
            throw o0.b();
        }
    }

    public static int N3(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static boolean N4(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    @Deprecated
    public static long O(@RecentlyNonNull InputStream inputStream, @RecentlyNonNull OutputStream outputStream, @RecentlyNonNull boolean z, @RecentlyNonNull int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                if (z) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused4) {
                }
            }
        }
        return j;
    }

    public static int O0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        v0 v0Var = (v0) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            Y0 = c1(bArr, Y0, fVar);
            v0Var.c(fVar.f5258b);
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static b.b0.a O1(int i) {
        if (i == 0) {
            return b.b0.a.EXPONENTIAL;
        }
        if (i == 1) {
            return b.b0.a.LINEAR;
        }
        throw new IllegalArgumentException(c.a.a.a.a.o("Could not convert ", i, " to BackoffPolicy"));
    }

    public static void O2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        parcel.setDataPosition(parcel.dataPosition() + v2(parcel, i));
    }

    public static int O3(q3<?> q3Var, int i, byte[] bArr, int i2, int i3, z1<?> z1Var, c.b.a.a.g.h.n0 n0Var) {
        int Q3 = Q3(q3Var, bArr, i2, i3, n0Var);
        while (true) {
            z1Var.add(n0Var.f3969c);
            if (Q3 >= i3) {
                break;
            }
            int U3 = U3(bArr, Q3, n0Var);
            if (i != n0Var.f3967a) {
                break;
            }
            Q3 = Q3(q3Var, bArr, U3, i3, n0Var);
        }
        return Q3;
    }

    public static final String O4(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v16, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x030a  */
    public static Animator P(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f2) {
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
                        f2(context, resources, theme, attributeSet, valueAnimator, f2, xmlPullParser);
                    } else if (name.equals("animator")) {
                        valueAnimator = f2(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            TypedArray S = i.j.S(resources2, theme2, attributeSet, b.y.a.a.a.h);
                            P(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, i.j.D(S, xmlPullParser, "ordering", 0, 0), f2);
                            S.recycle();
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
                                            TypedArray S2 = i.j.S(resources2, theme2, asAttributeSet, b.y.a.a.a.i);
                                            String E = i.j.E(S2, xmlPullParser, "propertyName", i7);
                                            int D = i.j.D(S2, xmlPullParser, "valueType", i8, 4);
                                            ArrayList arrayList3 = null;
                                            attributeSet2 = asAttributeSet;
                                            int i10 = D;
                                            while (true) {
                                                int next2 = xmlPullParser.next();
                                                if (next2 == i7 || next2 == 1) {
                                                    str = str2;
                                                    i4 = depth;
                                                } else if (xmlPullParser.getName().equals("keyframe")) {
                                                    if (i10 == 4) {
                                                        TypedArray S3 = i.j.S(resources2, theme2, Xml.asAttributeSet(xmlPullParser), b.y.a.a.a.j);
                                                        TypedValue peekValue = !i.j.K(xmlPullParser, "value") ? null : S3.peekValue(0);
                                                        i10 = (!(peekValue != null) || !U1(peekValue.type)) ? 0 : i7;
                                                        S3.recycle();
                                                    }
                                                    TypedArray S4 = i.j.S(resources2, theme2, Xml.asAttributeSet(xmlPullParser), b.y.a.a.a.j);
                                                    float C = i.j.C(S4, xmlPullParser, "fraction", 3, -1.0f);
                                                    TypedValue peekValue2 = !i.j.K(xmlPullParser, "value") ? null : S4.peekValue(0);
                                                    boolean z = peekValue2 != null;
                                                    int i11 = i10 == 4 ? (!z || !U1(peekValue2.type)) ? 0 : 3 : i10;
                                                    Keyframe ofInt = z ? i11 != 0 ? (i11 == 1 || i11 == 3) ? Keyframe.ofInt(C, i.j.D(S4, xmlPullParser, "value", 0, 0)) : null : Keyframe.ofFloat(C, i.j.C(S4, xmlPullParser, "value", 0, 0.0f)) : i11 == 0 ? Keyframe.ofFloat(C) : Keyframe.ofInt(C);
                                                    int resourceId = !i.j.K(xmlPullParser, "interpolator") ? 0 : S4.getResourceId(1, 0);
                                                    if (resourceId > 0) {
                                                        ofInt.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                                    }
                                                    S4.recycle();
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
                                                        arrayList3.add(arrayList3.size(), Z(keyframe2, 1.0f));
                                                        size++;
                                                    }
                                                }
                                                float fraction2 = keyframe.getFraction();
                                                if (fraction2 != 0.0f) {
                                                    if (fraction2 < 0.0f) {
                                                        keyframe.setFraction(0.0f);
                                                    } else {
                                                        arrayList3.add(0, Z(keyframe, 0.0f));
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
                                                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(E, keyframeArr);
                                                i5 = 3;
                                                if (i10 == 3) {
                                                    propertyValuesHolder.setEvaluator(d.f2751a);
                                                }
                                            }
                                            i2 = 1;
                                            if (propertyValuesHolder == null) {
                                                propertyValuesHolder = J1(S2, D, 0, 1, E);
                                            }
                                            if (propertyValuesHolder != null) {
                                                if (arrayList2 == null) {
                                                    arrayList2 = new ArrayList();
                                                }
                                                arrayList2.add(propertyValuesHolder);
                                            }
                                            S2.recycle();
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
                                StringBuilder h = c.a.a.a.a.h("Unknown animator name: ");
                                h.append(xmlPullParser.getName());
                                throw new RuntimeException(h.toString());
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

    public static int P0(byte[] bArr, int i, e eVar) {
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 == 0) {
            eVar.f4913c = "";
            return X0;
        } else {
            eVar.f4913c = new String(bArr, X0, i2, a0.f4885a);
            return X0 + i2;
        }
    }

    public static n P1(int i) {
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
        throw new IllegalArgumentException(c.a.a.a.a.o("Could not convert ", i, " to NetworkType"));
    }

    public static int P2(b.b0.u uVar) {
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

    public static int P3(q3 q3Var, byte[] bArr, int i, int i2, int i3, c.b.a.a.g.h.n0 n0Var) {
        e3 e3Var = (e3) q3Var;
        Object a2 = e3Var.k.a(e3Var.f3883e);
        int m = e3Var.m(a2, bArr, i, i2, i3, n0Var);
        e3Var.a(a2);
        n0Var.f3969c = a2;
        return m;
    }

    public static String P4(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    @RecentlyNonNull
    public static Bundle Q(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + v2);
        return readBundle;
    }

    public static int Q0(byte[] bArr, int i, f fVar) {
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a;
        if (i2 < 0) {
            throw o0.f();
        } else if (i2 == 0) {
            fVar.f5259c = "";
            return Y0;
        } else {
            fVar.f5259c = new String(bArr, Y0, i2, n0.f5438a);
            return Y0 + i2;
        }
    }

    public static b.b0.u Q1(int i) {
        if (i == 0) {
            return b.b0.u.ENQUEUED;
        }
        if (i == 1) {
            return b.b0.u.RUNNING;
        }
        if (i == 2) {
            return b.b0.u.SUCCEEDED;
        }
        if (i == 3) {
            return b.b0.u.FAILED;
        }
        if (i == 4) {
            return b.b0.u.BLOCKED;
        }
        if (i == 5) {
            return b.b0.u.CANCELLED;
        }
        throw new IllegalArgumentException(c.a.a.a.a.o("Could not convert ", i, " to State"));
    }

    public static String Q2(String str, s.g gVar, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (gVar.s()) {
            sb.append('(');
            sb.append(gVar.f5820d);
            sb.append(')');
        } else {
            sb.append(gVar.f());
        }
        if (i != -1) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    public static int Q3(q3 q3Var, byte[] bArr, int i, int i2, c.b.a.a.g.h.n0 n0Var) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = M3(b2, bArr, i3, n0Var);
            b3 = n0Var.f3967a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw c2.a();
        }
        Object c2 = q3Var.c();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        q3Var.g(c2, bArr, i3, i4, n0Var);
        q3Var.a(c2);
        n0Var.f3969c = c2;
        return i4;
    }

    public static final String Q4(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    @RecentlyNonNull
    public static byte[] R(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + v2);
        return createByteArray;
    }

    public static int R0(byte[] bArr, int i, e eVar) {
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 == 0) {
            eVar.f4913c = "";
            return X0;
        } else {
            eVar.f4913c = q1.f5014a.a(bArr, X0, i2);
            return X0 + i2;
        }
    }

    public static byte[] R1(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        int i2 = i + 1;
        if (byteArray.length > i2) {
            throw new GeneralSecurityException("integer too large");
        } else if (byteArray.length != i2) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
            return bArr;
        } else if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        } else {
            throw new GeneralSecurityException("integer too large");
        }
    }

    public static void R2(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    public static int R3(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    @RecentlyNonNull
    public static byte[][] S(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + v2);
        return bArr;
    }

    public static int S0(byte[] bArr, int i, f fVar) {
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a;
        if (i2 < 0) {
            throw o0.f();
        } else if (i2 == 0) {
            fVar.f5259c = "";
            return Y0;
        } else {
            fVar.f5259c = w2.b(bArr, Y0, i2);
            return Y0 + i2;
        }
    }

    public static boolean S1() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static w S2(c.b.c.a.i0.m0 m0Var) {
        int ordinal = m0Var.ordinal();
        if (ordinal == 1) {
            return w.NIST_P256;
        }
        if (ordinal == 2) {
            return w.NIST_P384;
        }
        if (ordinal == 3) {
            return w.NIST_P521;
        }
        throw new GeneralSecurityException("unknown curve type: " + m0Var);
    }

    public static int S3(byte[] bArr, int i, u uVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return L3(b2, bArr, i2, uVar);
        }
        uVar.f3424a = b2;
        return i2;
    }

    public static Animator T(c.b.a.b.w.c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, c.C0081c.f4534a, c.b.f4532b, new c.e(f2, f3, f4));
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.f4538c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static int T0(int i, byte[] bArr, int i2, int i3, m1 m1Var, e eVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int b1 = b1(bArr, i2, eVar);
                m1Var.c(i, Long.valueOf(eVar.f4912b));
                return b1;
            } else if (i4 == 1) {
                m1Var.c(i, Long.valueOf(n0(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int X0 = X0(bArr, i2, eVar);
                int i5 = eVar.f4911a;
                if (i5 < 0) {
                    throw b0.f();
                } else if (i5 <= bArr.length - X0) {
                    m1Var.c(i, i5 == 0 ? c.b.c.a.j0.a.i.f4933c : c.b.c.a.j0.a.i.g(bArr, X0, i5));
                    return X0 + i5;
                } else {
                    throw b0.h();
                }
            } else if (i4 == 3) {
                m1 b2 = m1.b();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int X02 = X0(bArr, i2, eVar);
                    int i8 = eVar.f4911a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = X02;
                        break;
                    }
                    int T0 = T0(i7, bArr, X02, i3, b2, eVar);
                    i7 = i8;
                    i2 = T0;
                }
                if (i2 > i3 || i7 != i6) {
                    throw b0.g();
                }
                m1Var.c(i, b2);
                return i2;
            } else if (i4 == 5) {
                m1Var.c(i, Integer.valueOf(l0(bArr, i2)));
                return i2 + 4;
            } else {
                throw b0.b();
            }
        } else {
            throw b0.b();
        }
    }

    @RecentlyNonNull
    public static boolean T1() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static w T2(c.b.c.a.i0.m0 m0Var) {
        int ordinal = m0Var.ordinal();
        if (ordinal == 1) {
            return w.NIST_P256;
        }
        if (ordinal == 2) {
            return w.NIST_P384;
        }
        if (ordinal == 3) {
            return w.NIST_P521;
        }
        StringBuilder h = c.a.a.a.a.h("unknown curve type: ");
        h.append(m0Var.name());
        throw new GeneralSecurityException(h.toString());
    }

    public static int T3(byte[] bArr, int i, e1<?> e1Var, u uVar) {
        a1 a1Var = (a1) e1Var;
        int S3 = S3(bArr, i, uVar);
        int i2 = uVar.f3424a + S3;
        while (S3 < i2) {
            S3 = S3(bArr, S3, uVar);
            a1Var.h(a1Var.f3215d, uVar.f3424a);
        }
        if (S3 == i2) {
            return S3;
        }
        throw f1.a();
    }

    public static c.b.a.b.h0.d U(int i) {
        if (i == 0) {
            return new c.b.a.b.h0.i();
        }
        if (i != 1) {
            return new c.b.a.b.h0.i();
        }
        return new c.b.a.b.h0.e();
    }

    public static int U0(int i, byte[] bArr, int i2, int i3, r2 r2Var, f fVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int c1 = c1(bArr, i2, fVar);
                r2Var.c(i, Long.valueOf(fVar.f5258b));
                return c1;
            } else if (i4 == 1) {
                r2Var.c(i, Long.valueOf(o0(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int Y0 = Y0(bArr, i2, fVar);
                int i5 = fVar.f5257a;
                if (i5 < 0) {
                    throw o0.f();
                } else if (i5 <= bArr.length - Y0) {
                    r2Var.c(i, i5 == 0 ? c.b.d.j.f5320c : c.b.d.j.g(bArr, Y0, i5));
                    return Y0 + i5;
                } else {
                    throw o0.i();
                }
            } else if (i4 == 3) {
                r2 b2 = r2.b();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int Y02 = Y0(bArr, i2, fVar);
                    int i8 = fVar.f5257a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = Y02;
                        break;
                    }
                    int U0 = U0(i7, bArr, Y02, i3, b2, fVar);
                    i7 = i8;
                    i2 = U0;
                }
                if (i2 > i3 || i7 != i6) {
                    throw o0.g();
                }
                r2Var.c(i, b2);
                return i2;
            } else if (i4 == 5) {
                r2Var.c(i, Integer.valueOf(m0(bArr, i2)));
                return i2 + 4;
            } else {
                throw o0.b();
            }
        } else {
            throw o0.b();
        }
    }

    public static boolean U1(int i) {
        return i >= 28 && i <= 31;
    }

    public static String U2(c0 c0Var) {
        int ordinal = c0Var.ordinal();
        if (ordinal == 0) {
            return "SHA-1";
        }
        if (ordinal == 1) {
            return "SHA-256";
        }
        if (ordinal == 2) {
            return "SHA-384";
        }
        if (ordinal == 3) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash " + c0Var);
    }

    public static int U3(byte[] bArr, int i, c.b.a.a.g.h.n0 n0Var) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return M3(b2, bArr, i2, n0Var);
        }
        n0Var.f3967a = b2;
        return i2;
    }

    @RecentlyNonNull
    public static ArrayList<Double> V(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + v2);
        return arrayList;
    }

    public static int V0(int i, byte[] bArr, int i2, e eVar) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i3 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i3 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] < 0) {
                                i8 = i10;
                            } else {
                                eVar.f4911a = i9;
                                return i10;
                            }
                        }
                    }
                }
            }
            eVar.f4911a = i7 | i4;
            return i8;
        }
        eVar.f4911a = i5 | i3;
        return i6;
    }

    public static boolean V1(View view) {
        return m.p(view) == 1;
    }

    public static x V2(c.b.c.a.i0.c0 c0Var) {
        int ordinal = c0Var.ordinal();
        if (ordinal == 1) {
            return x.IEEE_P1363;
        }
        if (ordinal == 2) {
            return x.DER;
        }
        StringBuilder h = c.a.a.a.a.h("unknown ECDSA encoding: ");
        h.append(c0Var.name());
        throw new GeneralSecurityException(h.toString());
    }

    public static int V3(byte[] bArr, int i, z1<?> z1Var, c.b.a.a.g.h.n0 n0Var) {
        v1 v1Var = (v1) z1Var;
        int U3 = U3(bArr, i, n0Var);
        int i2 = n0Var.f3967a + U3;
        while (U3 < i2) {
            U3 = U3(bArr, U3, n0Var);
            v1Var.h(n0Var.f3967a);
        }
        if (U3 == i2) {
            return U3;
        }
        throw c2.a();
    }

    @RecentlyNonNull
    public static int[] W(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + v2);
        return createIntArray;
    }

    public static int W0(int i, byte[] bArr, int i2, f fVar) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i3 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i3 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] < 0) {
                                i8 = i10;
                            } else {
                                fVar.f5257a = i9;
                                return i10;
                            }
                        }
                    }
                }
            }
            fVar.f5257a = i7 | i4;
            return i8;
        }
        fVar.f5257a = i5 | i3;
        return i6;
    }

    public static boolean W1(byte b2) {
        return b2 > -65;
    }

    public static c0 W2(c.b.c.a.i0.o0 o0Var) {
        int ordinal = o0Var.ordinal();
        if (ordinal == 2) {
            return c0.SHA384;
        }
        if (ordinal == 3) {
            return c0.SHA256;
        }
        if (ordinal == 4) {
            return c0.SHA512;
        }
        StringBuilder h = c.a.a.a.a.h("unsupported hash type: ");
        h.append(o0Var.name());
        throw new GeneralSecurityException(h.toString());
    }

    public static long W3(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    @RecentlyNonNull
    public static ArrayList<Integer> X(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + v2);
        return arrayList;
    }

    public static int X0(byte[] bArr, int i, e eVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return V0(b2, bArr, i2, eVar);
        }
        eVar.f4911a = b2;
        return i2;
    }

    public static boolean X1(byte b2) {
        return b2 > -65;
    }

    public static String X2(c.b.c.a.i0.o0 o0Var) {
        int ordinal = o0Var.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + o0Var);
    }

    public static long X3(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Out of bound index with offput: 0 and length: ");
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i = 37;
        char c2 = 0;
        if (length <= 32) {
            if (length > 16) {
                long j = ((long) (length << 1)) - 7286425919675154353L;
                long s4 = s4(bArr, 0) * -5435081209227447693L;
                long s42 = s4(bArr, 8);
                int i2 = length + 0;
                long s43 = s4(bArr, i2 - 8) * j;
                return W3(Long.rotateRight(s43, 30) + Long.rotateRight(s4 + s42, 43) + (s4(bArr, i2 - 16) * -7286425919675154353L), Long.rotateRight(s42 - 7286425919675154353L, 18) + s4 + s43, j);
            } else if (length >= 8) {
                long j2 = ((long) (length << 1)) - 7286425919675154353L;
                long s44 = s4(bArr, 0) - 7286425919675154353L;
                long s45 = s4(bArr, (length + 0) - 8);
                return W3((Long.rotateRight(s45, 37) * j2) + s44, (Long.rotateRight(s44, 25) + s45) * j2, j2);
            } else if (length >= 4) {
                return W3(((long) length) + ((((long) R3(bArr, 0)) & 4294967295L) << 3), ((long) R3(bArr, (length + 0) - 4)) & 4294967295L, ((long) (length << 1)) - 7286425919675154353L);
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                long j3 = (((long) ((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr[(length - 1) + 0] & 255) << 2))) * -4348849565147123417L);
                return (j3 ^ (j3 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j4 = ((long) (length << 1)) - 7286425919675154353L;
            long s46 = s4(bArr, 0) * -7286425919675154353L;
            long s47 = s4(bArr, 8);
            int i3 = length + 0;
            long s48 = s4(bArr, i3 - 8) * j4;
            long rotateRight = Long.rotateRight(s48, 30) + Long.rotateRight(s46 + s47, 43) + (s4(bArr, i3 - 16) * -7286425919675154353L);
            long W3 = W3(rotateRight, Long.rotateRight(-7286425919675154353L + s47, 18) + s46 + s48, j4);
            long s49 = s4(bArr, 16) * j4;
            long s410 = s4(bArr, 24);
            long s411 = (s4(bArr, i3 - 32) + rotateRight) * j4;
            return W3(((s4(bArr, i3 - 24) + W3) * j4) + Long.rotateRight(s411, 30) + Long.rotateRight(s49 + s410, 43), Long.rotateRight(s410 + s46, 18) + s49 + s411, j4);
        } else {
            long j5 = 2480279821605975764L;
            long j6 = 1390051526045402406L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long s412 = s4(bArr, 0) + 95310865018149119L;
            int i4 = length - 1;
            int i5 = ((i4 / 64) << 6) + 0;
            int i6 = i4 & 63;
            int i7 = (i5 + i6) - 63;
            int i8 = 0;
            while (true) {
                long j7 = s412 + j5 + jArr[c2];
                long j8 = j5 + jArr[1];
                long rotateRight2 = (Long.rotateRight(s4(bArr, i8 + 8) + j7, i) * -5435081209227447693L) ^ jArr2[1];
                long s413 = s4(bArr, i8 + 40) + jArr[0] + (Long.rotateRight(s4(bArr, i8 + 48) + j8, 42) * -5435081209227447693L);
                long rotateRight3 = Long.rotateRight(j6 + jArr2[0], 33) * -5435081209227447693L;
                l4(bArr, i8, jArr[1] * -5435081209227447693L, rotateRight2 + jArr2[0], jArr);
                l4(bArr, i8 + 32, rotateRight3 + jArr2[1], s4(bArr, i8 + 16) + s413, jArr2);
                int i9 = i8 + 64;
                if (i9 == i5) {
                    long j9 = ((255 & rotateRight2) << 1) - 5435081209227447693L;
                    jArr2[0] = jArr2[0] + ((long) i6);
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    long s414 = s4(bArr, i7 + 8);
                    long j10 = s413 + jArr[1];
                    long rotateRight4 = (Long.rotateRight(s414 + ((rotateRight3 + s413) + jArr[0]), 37) * j9) ^ (jArr2[1] * 9);
                    long s415 = s4(bArr, i7 + 40) + (jArr[0] * 9) + (Long.rotateRight(s4(bArr, i7 + 48) + j10, 42) * j9);
                    long rotateRight5 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j9;
                    l4(bArr, i7, jArr[1] * j9, rotateRight4 + jArr2[0], jArr);
                    l4(bArr, i7 + 32, jArr2[1] + rotateRight5, s4(bArr, i7 + 16) + s415, jArr2);
                    return W3((((s415 >>> 47) ^ s415) * -4348849565147123417L) + W3(jArr[0], jArr2[0], j9) + rotateRight4, W3(jArr[1], jArr2[1], j9) + rotateRight5, j9);
                }
                i8 = i9;
                i5 = i5;
                i6 = i6;
                j6 = rotateRight2;
                s412 = rotateRight3;
                i = 37;
                c2 = 0;
                j5 = s413;
            }
        }
    }

    @RecentlyNonNull
    public static <L> k.a<L> Y(@RecentlyNonNull L l, @RecentlyNonNull String str) {
        D(l, "Listener must not be null");
        D(str, "Listener type must not be null");
        A(str, "Listener type must not be empty");
        return new k.a<>(l, str);
    }

    public static int Y0(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return W0(b2, bArr, i2, fVar);
        }
        fVar.f5257a = b2;
        return i2;
    }

    @RecentlyNonNull
    @TargetApi(20)
    public static boolean Y1(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2720a == null) {
            f2720a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f2720a.booleanValue();
    }

    public static String Y2(c.b.c.a.i0.o0 o0Var) {
        int ordinal = o0Var.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + o0Var);
    }

    public static Pair<w8, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> Y3(Payload payload) {
        int type = payload.getType();
        if (type == 1) {
            w8 w8Var = new w8(null);
            w8Var.f3798b = payload.getId();
            w8Var.f3799c = payload.getType();
            w8Var.f3800d = payload.asBytes();
            return Pair.create(w8Var, null);
        } else if (type == 2) {
            String absolutePath = payload.asFile().asJavaFile() == null ? null : payload.asFile().asJavaFile().getAbsolutePath();
            w8 w8Var2 = new w8(null);
            w8Var2.f3798b = payload.getId();
            w8Var2.f3799c = payload.getType();
            w8Var2.f3801e = payload.asFile().asParcelFileDescriptor();
            w8Var2.f3802f = absolutePath;
            w8Var2.f3803g = payload.asFile().getSize();
            w8Var2.j = payload.getOffset();
            return Pair.create(w8Var2, null);
        } else if (type == 3) {
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                w8 w8Var3 = new w8(null);
                w8Var3.f3798b = payload.getId();
                w8Var3.f3799c = payload.getType();
                w8Var3.f3801e = createPipe[0];
                w8Var3.h = createPipe2[0];
                w8Var3.j = payload.getOffset();
                return Pair.create(w8Var3, Pair.create(createPipe[1], createPipe2[1]));
            } catch (IOException e2) {
                String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId()));
                throw e2;
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
            Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static Keyframe Z(Keyframe keyframe, float f2) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    public static int Z0(int i, byte[] bArr, int i2, int i3, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int X0 = X0(bArr, i2, eVar);
        while (true) {
            zVar.c(eVar.f4911a);
            if (X0 >= i3) {
                break;
            }
            int X02 = X0(bArr, X0, eVar);
            if (i != eVar.f4911a) {
                break;
            }
            X0 = X0(bArr, X02, eVar);
        }
        return X0;
    }

    @RecentlyNonNull
    @TargetApi(26)
    public static boolean Z1(@RecentlyNonNull Context context) {
        if (Y1(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (f2721b == null) {
                    f2721b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!f2721b.booleanValue() || T1()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static c.b.c.a.m0.y Z2(c.b.c.a.i0.x xVar) {
        int ordinal = xVar.ordinal();
        if (ordinal == 1) {
            return c.b.c.a.m0.y.UNCOMPRESSED;
        }
        if (ordinal == 2) {
            return c.b.c.a.m0.y.COMPRESSED;
        }
        if (ordinal == 3) {
            return c.b.c.a.m0.y.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        throw new GeneralSecurityException("unknown point format: " + xVar);
    }

    public static Payload Z3(Context context, w8 w8Var) {
        long j = w8Var.f3798b;
        int i = w8Var.f3799c;
        if (i == 1) {
            return Payload.zza(w8Var.f3800d, j);
        }
        if (i == 2) {
            String str = w8Var.f3802f;
            Uri uri = w8Var.i;
            if (str == null || uri == null) {
                return Payload.zza(Payload.File.zza(w8Var.f3801e), j);
            }
            try {
                return Payload.zza(Payload.File.zza(new File(str), context.getContentResolver().openFileDescriptor(uri, "r"), w8Var.f3803g, uri), j);
            } catch (FileNotFoundException unused) {
                String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uri, str);
                return null;
            }
        } else if (i == 3) {
            return Payload.zza(Payload.Stream.zza(w8Var.f3801e), j);
        } else {
            String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(j), Integer.valueOf(w8Var.f3799c));
            return null;
        }
    }

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!W1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !W1(b4) && !W1(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw b0.c();
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T a0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + v2);
        return createFromParcel;
    }

    public static int a1(int i, byte[] bArr, int i2, int i3, n0.h<?> hVar, f fVar) {
        m0 m0Var = (m0) hVar;
        int Y0 = Y0(bArr, i2, fVar);
        while (true) {
            m0Var.c(fVar.f5257a);
            if (Y0 >= i3) {
                break;
            }
            int Y02 = Y0(bArr, Y0, fVar);
            if (i != fVar.f5257a) {
                break;
            }
            Y0 = Y0(bArr, Y02, fVar);
        }
        return Y0;
    }

    public static int a2(int i, int i2, float f2) {
        return b.i.f.a.a(b.i.f.a.c(i2, Math.round(((float) Color.alpha(i2)) * f2)), i);
    }

    @RecentlyNonNull
    public static c.b.a.a.d.m.m a3(@RecentlyNonNull Object obj) {
        return new c.b.a.a.d.m.m(obj, null);
    }

    public static Object a4(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!X1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !X1(b4) && !X1(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw o0.c();
    }

    @RecentlyNonNull
    public static String b0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + v2);
        return readString;
    }

    public static int b1(byte[] bArr, int i, e eVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            eVar.f4912b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            b2 = b3;
            i3 = i5;
        }
        eVar.f4912b = j2;
        return i3;
    }

    public static String b2(String str, Object... objArr) {
        int indexOf;
        String str2;
        String valueOf = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e2) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str3, (Throwable) e2);
                    str2 = "<" + str3 + " threw " + e2.getClass().getName() + ">";
                }
            }
            objArr[i2] = str2;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static Throwable b3(c.b.b.e.a.d0.a aVar) {
        c.b.b.e.a.b bVar = (c.b.b.e.a.b) aVar;
        if (bVar == null) {
            throw null;
        } else if (!(bVar instanceof b.i)) {
            return null;
        } else {
            Object obj = bVar.f4716b;
            if (obj instanceof b.d) {
                return ((b.d) obj).f4724a;
            }
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public static <T> T b4(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            T call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }

    public static boolean c(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    public static String[] c0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + v2);
        return createStringArray;
    }

    public static int c1(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            fVar.f5258b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            b2 = b3;
            i3 = i5;
        }
        fVar.f5258b = j2;
        return i3;
    }

    public static float c2(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static PorterDuffColorFilter c3(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static String c4(int i, int i2, String str) {
        if (i < 0) {
            return d4("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return d4("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    public static <T> T[] d0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + v2);
        return tArr;
    }

    public static String d1(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static long d2(byte[] bArr, int i, int i2) {
        return (e2(bArr, i) >> i2) & 67108863;
    }

    public static void d3(c.b.c.a.i0.f0 f0Var) {
        D1(S2(f0Var.p().n()));
        X2(f0Var.p().o());
        if (f0Var.o() != c.b.c.a.i0.x.UNKNOWN_FORMAT) {
            c.b.c.a.y.g(f0Var.n().n());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String d4(String str, Object... objArr) {
        int indexOf;
        String str2;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(name2.length() + String.valueOf(sb2).length() + 9);
                    sb3.append("<");
                    sb3.append(sb2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(">");
                    str2 = sb3.toString();
                }
            }
            objArr[i2] = str2;
        }
        StringBuilder sb4 = new StringBuilder((objArr.length * 16) + str.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb4.append((CharSequence) str, i3, indexOf);
            sb4.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb4.append((CharSequence) str, i3, str.length());
        if (i < objArr.length) {
            sb4.append(" [");
            sb4.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb4.append(", ");
                sb4.append(objArr[i4]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static boolean e(byte b2) {
        return b2 < -32;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> e0(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + v2);
        return createTypedArrayList;
    }

    public static float e1(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static long e2(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    public static void e3(c.b.c.a.i0.z zVar) {
        c.b.c.a.i0.o0 o0Var = c.b.c.a.i0.o0.SHA512;
        c.b.c.a.i0.c0 o = zVar.o();
        c.b.c.a.i0.o0 p = zVar.p();
        c.b.c.a.i0.m0 n = zVar.n();
        int ordinal = o.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            int ordinal2 = n.ordinal();
            if (ordinal2 != 1) {
                if (ordinal2 != 2) {
                    if (ordinal2 != 3) {
                        throw new GeneralSecurityException("Invalid ECDSA parameters");
                    } else if (p != o0Var) {
                        throw new GeneralSecurityException("Invalid ECDSA parameters");
                    }
                } else if (p != c.b.c.a.i0.o0.SHA384 && p != o0Var) {
                    throw new GeneralSecurityException("Invalid ECDSA parameters");
                }
            } else if (p != c.b.c.a.i0.o0.SHA256) {
                throw new GeneralSecurityException("Invalid ECDSA parameters");
            }
        } else {
            throw new GeneralSecurityException("unsupported signature encoding");
        }
    }

    public static void e4(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = c4(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = c4(i2, i3, "end index");
            } else {
                str = d4("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void f(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62 || W1(b3)) {
            throw b0.c();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static byte[] f0(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr2[i] = (byte) ((bArr[i] << 1) & 254);
                if (i < 15) {
                    bArr2[i] = (byte) (bArr2[i] | ((byte) ((bArr[i + 1] >> 7) & 1)));
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }

    public static float f1(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static ValueAnimator f2(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        TypedArray S = i.j.S(resources, theme, attributeSet, b.y.a.a.a.f2738g);
        TypedArray S2 = i.j.S(resources, theme, attributeSet, b.y.a.a.a.k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long D = (long) i.j.D(S, xmlPullParser, "duration", 1, Strategy.TTL_SECONDS_DEFAULT);
        int i = 0;
        long D2 = (long) i.j.D(S, xmlPullParser, "startOffset", 2, 0);
        int D3 = i.j.D(S, xmlPullParser, "valueType", 7, 4);
        if (i.j.K(xmlPullParser, "valueFrom") && i.j.K(xmlPullParser, "valueTo")) {
            if (D3 == 4) {
                TypedValue peekValue = S.peekValue(5);
                boolean z = peekValue != null;
                int i2 = z ? peekValue.type : 0;
                TypedValue peekValue2 = S.peekValue(6);
                boolean z2 = peekValue2 != null;
                D3 = ((!z || !U1(i2)) && (!z2 || !U1(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder J1 = J1(S, D3, 5, 6, "");
            if (J1 != null) {
                valueAnimator4.setValues(J1);
            }
        }
        valueAnimator4.setDuration(D);
        valueAnimator4.setStartDelay(D2);
        valueAnimator4.setRepeatCount(i.j.D(S, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator4.setRepeatMode(i.j.D(S, xmlPullParser, "repeatMode", 4, 1));
        if (S2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String E = i.j.E(S2, xmlPullParser, "pathData", 1);
            if (E != null) {
                String E2 = i.j.E(S2, xmlPullParser, "propertyXName", 2);
                String E3 = i.j.E(S2, xmlPullParser, "propertyYName", 3);
                if (E2 == null && E3 == null) {
                    throw new InflateException(S2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path t = i.j.t(E);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(t, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                do {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(t, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = S;
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
                PropertyValuesHolder ofFloat = E2 != null ? PropertyValuesHolder.ofFloat(E2, fArr) : null;
                if (E3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(E3, fArr2);
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
                typedArray = S;
                objectAnimator.setPropertyName(i.j.E(S2, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = S;
        }
        if (!i.j.K(xmlPullParser, "interpolator")) {
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
        if (S2 != null) {
            S2.recycle();
        }
        return valueAnimator3;
    }

    @RecentlyNonNull
    public static int f3(@RecentlyNonNull Parcel parcel) {
        int readInt = parcel.readInt();
        int v2 = v2(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new c.b.a.a.d.m.o.b(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = v2 + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new c.b.a.a.d.m.o.b(c.a.a.a.a.k(54, "Size read is invalid start=", dataPosition, " end=", i), parcel);
    }

    public static void f4(Parcel parcel, int i, int i2) {
        int v2 = v2(parcel, i);
        if (v2 != i2) {
            String hexString = Integer.toHexString(v2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(v2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new c.b.a.a.d.m.o.b(sb.toString(), parcel);
        }
    }

    public static void g(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62 || X1(b3)) {
            throw o0.c();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static byte[] g0(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                int digit = Character.digit(str.charAt(i2), 16);
                int digit2 = Character.digit(str.charAt(i2 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i] = (byte) ((digit * 16) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    @SuppressLint({"LogTagMismatch"})
    public static int g1(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable("Vision", 6)) {
            return 0;
        }
        boolean isLoggable = Log.isLoggable("Vision", 3);
        String format = String.format(str, objArr);
        if (isLoggable) {
            return Log.e("Vision", format, th);
        }
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(format).length() + 2);
        sb.append(format);
        sb.append(": ");
        sb.append(valueOf);
        return Log.e("Vision", sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    public static boolean g2(c.b.d.k kVar, q2.b bVar, c.b.d.z zVar, s.b bVar2, n1 n1Var, int i) {
        c.b.d.f1 f1Var;
        Object[] objArr;
        Object obj;
        x.b e2;
        Object obj2;
        int i2 = 0;
        s.g gVar = null;
        c.b.d.j jVar = null;
        if (!bVar2.s().f5663d || i != 11) {
            int i3 = i & 7;
            int i4 = i >>> 3;
            if (bVar2.t(i4)) {
                if ((zVar instanceof c.b.d.x) && (e2 = n1Var.e((c.b.d.x) zVar, bVar2, i4)) != null) {
                    gVar = e2.f5910a;
                    f1Var = e2.f5911b;
                    if (f1Var == null && gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                        StringBuilder h = c.a.a.a.a.h("Message-typed extension lacked default instance: ");
                        h.append(gVar.f5820d);
                        throw new IllegalStateException(h.toString());
                    }
                    if (gVar != null) {
                        if (i3 == f0.q(gVar.g(), false)) {
                            objArr = null;
                        } else if (gVar.x() && i3 == f0.q(gVar.g(), true)) {
                            objArr = 1;
                        }
                        if (i2 == 0) {
                            return bVar != null ? bVar.e(i, kVar) : kVar.J(i);
                        }
                        if (objArr != null) {
                            int l = kVar.l(kVar.y());
                            if (gVar.g() == x2.b.ENUM) {
                                while (kVar.d() > 0) {
                                    int p = kVar.p();
                                    if (gVar.f5821e.s()) {
                                        n1Var.addRepeatedField(gVar, gVar.n().m(p));
                                    } else {
                                        s.f k = gVar.n().k(p);
                                        if (k != null) {
                                            n1Var.addRepeatedField(gVar, k);
                                        } else if (bVar != null) {
                                            bVar.h(i4, p);
                                        }
                                    }
                                }
                            } else {
                                while (kVar.d() > 0) {
                                    n1Var.addRepeatedField(gVar, x2.a(kVar, gVar.g(), n1Var.f(gVar)));
                                }
                            }
                            kVar.k(l);
                        } else {
                            int ordinal = gVar.f5823g.ordinal();
                            if (ordinal == 9) {
                                obj = n1Var.d(kVar, zVar, gVar, f1Var);
                            } else if (ordinal == 10) {
                                obj = n1Var.b(kVar, zVar, gVar, f1Var);
                            } else if (ordinal != 13) {
                                obj = x2.a(kVar, gVar.g(), n1Var.f(gVar));
                            } else {
                                int p2 = kVar.p();
                                if (gVar.f5821e.s()) {
                                    obj = gVar.n().m(p2);
                                } else {
                                    s.f k2 = gVar.n().k(p2);
                                    if (k2 == null) {
                                        if (bVar != null) {
                                            bVar.h(i4, p2);
                                        }
                                        return true;
                                    }
                                    obj = k2;
                                }
                            }
                            if (gVar.e()) {
                                n1Var.addRepeatedField(gVar, obj);
                            } else {
                                n1Var.setField(gVar, obj);
                            }
                        }
                        return true;
                    }
                    objArr = null;
                    i2 = 1;
                    if (i2 == 0) {
                    }
                }
            } else if (n1Var.a() == n1.a.MESSAGE) {
                gVar = bVar2.n(i4);
                f1Var = null;
                if (gVar != null) {
                }
                objArr = null;
                i2 = 1;
                if (i2 == 0) {
                }
            }
            f1Var = null;
            if (gVar != null) {
            }
            objArr = null;
            i2 = 1;
            if (i2 == 0) {
            }
        } else {
            x.b bVar3 = null;
            while (true) {
                int G = kVar.G();
                if (G == 0) {
                    break;
                } else if (G == 16) {
                    i2 = kVar.H();
                    if (i2 != 0 && (zVar instanceof c.b.d.x)) {
                        bVar3 = n1Var.e((c.b.d.x) zVar, bVar2, i2);
                    }
                } else if (G == 26) {
                    if (!(i2 == 0 || bVar3 == null)) {
                        c.b.d.z.b();
                    }
                    jVar = kVar.n();
                } else if (!kVar.J(G)) {
                    break;
                }
            }
            kVar.a(12);
            if (!(jVar == null || i2 == 0)) {
                if (bVar3 != null) {
                    s.g gVar2 = bVar3.f5910a;
                    if (!n1Var.hasField(gVar2)) {
                        c.b.d.z.b();
                        obj2 = new c.b.d.q0(bVar3.f5911b, zVar, jVar);
                    } else {
                        obj2 = n1Var.c(jVar, zVar, gVar2, bVar3.f5911b);
                    }
                    n1Var.setField(gVar2, obj2);
                } else if (bVar != null) {
                    q2.c.a c2 = q2.c.c();
                    c2.c(jVar);
                    bVar.d(i2, c2.e());
                }
            }
            return true;
        }
    }

    public static void g3(i1 i1Var) {
        W2(i1Var.n());
    }

    public static <T extends Parcelable> void g4(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static boolean h(byte b2) {
        return b2 < -16;
    }

    public static int h0(byte[] bArr, int i, e eVar) {
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 > bArr.length - X0) {
            throw b0.h();
        } else if (i2 == 0) {
            eVar.f4913c = c.b.c.a.j0.a.i.f4933c;
            return X0;
        } else {
            eVar.f4913c = c.b.c.a.j0.a.i.g(bArr, X0, i2);
            return X0 + i2;
        }
    }

    public static String h1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            sb.append("0123456789abcdef".charAt(i / 16));
            sb.append("0123456789abcdef".charAt(i % 16));
        }
        return sb.toString();
    }

    public static byte[] h2(byte[] bArr, int i, c0 c0Var) {
        MessageDigest a2 = c.b.c.a.m0.a0.i.a(U2(c0Var));
        int digestLength = a2.getDigestLength();
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 <= (i - 1) / digestLength; i3++) {
            a2.reset();
            a2.update(bArr);
            a2.update(R1(BigInteger.valueOf((long) i3), 4));
            byte[] digest = a2.digest();
            System.arraycopy(digest, 0, bArr2, i2, Math.min(digest.length, i - i2));
            i2 += digest.length;
        }
        return bArr2;
    }

    public static void h3(c.b.c.a.i0.m1 m1Var) {
        W2(m1Var.o());
        if (m1Var.o() != m1Var.n()) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        } else if (m1Var.saltLength_ < 0) {
            throw new GeneralSecurityException("salt length is negative");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e6, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f4, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0205, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0217, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L_0x0245;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x024b  */
    public static void h4(e2 e2Var, StringBuilder sb, int i) {
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = e2Var.getClass().getDeclaredMethods();
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
            String str = (String) it.next();
            String str2 = "";
            String replaceFirst = str.replaceFirst("get", str2);
            boolean z2 = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    k4(sb, i, O4(concat), z0.h(method2, e2Var, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    k4(sb, i, O4(concat2), z0.h(method3, e2Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get(replaceFirst.length() != 0 ? "set".concat(replaceFirst) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                Method method4 = (Method) hashMap.get(replaceFirst.length() != 0 ? "get".concat(replaceFirst) : new String("get"));
                Method method5 = (Method) hashMap.get(replaceFirst.length() != 0 ? "has".concat(replaceFirst) : new String("has"));
                if (method4 != null) {
                    Object h = z0.h(method4, e2Var, new Object[0]);
                    if (method5 == null) {
                        if (!(h instanceof Boolean)) {
                            if (!(h instanceof Integer)) {
                                if (!(h instanceof Float)) {
                                    if (!(h instanceof Double)) {
                                        Object obj = str2;
                                        if (!(h instanceof String)) {
                                            if (h instanceof y) {
                                                obj = y.f3474c;
                                            } else if (!(h instanceof e2)) {
                                                z = false;
                                                if (z) {
                                                    z2 = false;
                                                }
                                            } else {
                                                z = false;
                                                if (z) {
                                                }
                                            }
                                        }
                                        z = h.equals(obj);
                                        if (z) {
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        z2 = ((Boolean) z0.h(method5, e2Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        k4(sb, i, O4(concat3), h);
                    }
                }
            }
        }
        if (e2Var instanceof z0.c) {
            Iterator<Map.Entry<z0.d, Object>> c2 = ((z0.c) e2Var).zzjv.c();
            while (c2.hasNext()) {
                Map.Entry<z0.d, Object> next = c2.next();
                int i2 = next.getKey().f3487b;
                StringBuilder sb2 = new StringBuilder(13);
                sb2.append("[");
                sb2.append(i2);
                sb2.append("]");
                k4(sb, i, sb2.toString(), next.getValue());
            }
        }
        i3 i3Var = ((z0) e2Var).zzjp;
        if (i3Var != null) {
            for (int i3 = 0; i3 < i3Var.f3315a; i3++) {
                k4(sb, i, String.valueOf(i3Var.f3316b[i3] >>> 3), i3Var.f3317c[i3]);
            }
        }
    }

    public static void i(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (W1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || W1(b4)))) {
            throw b0.c();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static int i0(byte[] bArr, int i, f fVar) {
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a;
        if (i2 < 0) {
            throw o0.f();
        } else if (i2 > bArr.length - Y0) {
            throw o0.i();
        } else if (i2 == 0) {
            fVar.f5259c = c.b.d.j.f5320c;
            return Y0;
        } else {
            fVar.f5259c = c.b.d.j.g(bArr, Y0, i2);
            return Y0 + i2;
        }
    }

    public static void i1(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i);
            throw new c.b.a.a.d.m.o.b(sb.toString(), parcel);
        }
    }

    public static g.b.a.w.f i2(g.b.a.b bVar) {
        return new h(0, bVar, null);
    }

    public static c.b.a.a.j.i<Void> i3(Collection<? extends c.b.a.a.j.i<?>> collection) {
        if (collection.isEmpty()) {
            return x1(null);
        }
        Iterator<? extends c.b.a.a.j.i<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (((c.b.a.a.j.i) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        c.b.a.a.j.b0 b0Var = new c.b.a.a.j.b0();
        l lVar = new l(collection.size(), b0Var);
        Iterator<? extends c.b.a.a.j.i<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            c.b.a.a.j.i iVar = (c.b.a.a.j.i) it2.next();
            iVar.d(c.b.a.a.j.k.f4111b, lVar);
            iVar.c(c.b.a.a.j.k.f4111b, lVar);
            iVar.a(c.b.a.a.j.k.f4111b, lVar);
        }
        return b0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e3, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f1, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0202, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0214, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x0244;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024a  */
    public static void i4(c3 c3Var, StringBuilder sb, int i) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = c3Var.getClass().getDeclaredMethods();
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
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    str = Q4(concat);
                    obj = t1.h(method2, c3Var, new Object[0]);
                    p4(sb, i, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    p4(sb, i, Q4(concat2), t1.h(method3, c3Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get(substring.length() != 0 ? "set".concat(substring) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                String concat3 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                Method method4 = (Method) hashMap.get(substring.length() != 0 ? "get".concat(substring) : new String("get"));
                Method method5 = (Method) hashMap.get(substring.length() != 0 ? "has".concat(substring) : new String("has"));
                if (method4 != null) {
                    obj = t1.h(method4, c3Var, new Object[0]);
                    if (method5 == null) {
                        if (!(obj instanceof Boolean)) {
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Double)) {
                                        if (obj instanceof String) {
                                            obj2 = "";
                                        } else if (obj instanceof q0) {
                                            obj2 = q0.f4006c;
                                        } else if (!(obj instanceof c3)) {
                                            z = false;
                                            if (z) {
                                                z2 = false;
                                            }
                                        } else {
                                            z = false;
                                            if (z) {
                                            }
                                        }
                                        z = obj.equals(obj2);
                                        if (z) {
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        z2 = ((Boolean) t1.h(method5, c3Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = Q4(concat3);
                        p4(sb, i, str, obj);
                    }
                }
            }
        }
        if (c3Var instanceof t1.d) {
            Iterator<Map.Entry<t1.c, Object>> b2 = ((t1.d) c3Var).zzyg.b();
            while (b2.hasNext()) {
                Map.Entry<t1.c, Object> next = b2.next();
                int i2 = next.getKey().f4036b;
                StringBuilder sb2 = new StringBuilder(13);
                sb2.append("[");
                sb2.append(i2);
                sb2.append("]");
                p4(sb, i, sb2.toString(), next.getValue());
            }
        }
        c4 c4Var = ((t1) c3Var).zzxz;
        if (c4Var != null) {
            for (int i3 = 0; i3 < c4Var.f3852a; i3++) {
                p4(sb, i, String.valueOf(c4Var.f3853b[i3] >>> 3), c4Var.f3854c[i3]);
            }
        }
    }

    public static void j(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (X1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || X1(b4)))) {
            throw o0.c();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static double j0(byte[] bArr, int i) {
        return Double.longBitsToDouble(n0(bArr, i));
    }

    @RecentlyNonNull
    public static boolean j1(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static b.a j2(c.a.b.l lVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.f2829c;
        String str = map.get("Date");
        long l2 = str != null ? l2(str) : 0;
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
        long l22 = str3 != null ? l2(str3) : 0;
        String str4 = map.get("Last-Modified");
        long l23 = str4 != null ? l2(str4) : 0;
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
            if (l2 <= 0 || l22 < l2) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (l22 - l2);
                j3 = j4;
            }
        }
        b.a aVar = new b.a();
        aVar.f2794a = lVar.f2828b;
        aVar.f2795b = str5;
        aVar.f2799f = j4;
        aVar.f2798e = j3;
        aVar.f2796c = l2;
        aVar.f2797d = l23;
        aVar.f2800g = map;
        aVar.h = lVar.f2830d;
        return aVar;
    }

    public static void j3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull boolean z) {
        o4(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void j4(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        byte[] bArr;
        if (obj == null) {
            return;
        }
        if (obj instanceof j4) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(P4(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        j4(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i = 0; i < length2; i++) {
                            j4(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        String valueOf = String.valueOf(substring);
                        if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            j4(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        String P4 = P4(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(P4);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith("http") && str2.length() > 200) {
                str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
            }
            int length3 = str2.length();
            StringBuilder sb = new StringBuilder(length3);
            for (int i2 = 0; i2 < length3; i2++) {
                char charAt = str2.charAt(i2);
                if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            stringBuffer2.append("\"");
            stringBuffer2.append(sb2);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            stringBuffer2.append('\"');
            for (byte b2 : (byte[]) obj) {
                int i3 = b2 & 255;
                if (i3 == 92 || i3 == 34) {
                    stringBuffer2.append('\\');
                } else if (i3 < 32 || i3 >= 127) {
                    stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i3)));
                }
                stringBuffer2.append((char) i3);
            }
            stringBuffer2.append('\"');
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }

    public static <V> c.b.b.e.a.u<List<V>> k(Iterable<? extends c.b.b.e.a.u<? extends V>> iterable) {
        return new j.a(c.b.b.b.c.q(iterable), true);
    }

    public static double k0(byte[] bArr, int i) {
        return Double.longBitsToDouble(o0(bArr, i));
    }

    public static final boolean k1(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    public static String k2(Map<String, String> map, String str) {
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

    public static void k3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Bundle bundle, @RecentlyNonNull boolean z) {
        if (bundle != null) {
            int N3 = N3(parcel, i);
            parcel.writeBundle(bundle);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static final void k4(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                k4(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                k4(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(C4(y.c((String) obj)));
                sb.append('\"');
            } else if (obj instanceof y) {
                sb.append(": \"");
                sb.append(C4((y) obj));
                sb.append('\"');
            } else if (obj instanceof z0) {
                sb.append(" {");
                h4((z0) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                k4(sb, i4, "key", entry2.getKey());
                k4(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static String l(int i, int i2, String str) {
        if (i < 0) {
            return b2("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return b2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(c.a.a.a.a.n("negative size: ", i2));
        }
    }

    public static int l0(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static boolean l1(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static long l2(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException unused) {
            c.a.b.w.a("Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static void l3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z) {
        if (bArr != null) {
            int N3 = N3(parcel, i);
            parcel.writeByteArray(bArr);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static void l4(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long s4 = s4(bArr, i);
        long s42 = s4(bArr, i + 8);
        long s43 = s4(bArr, i + 16);
        long s44 = s4(bArr, i + 24);
        long j3 = j + s4;
        long rotateRight = Long.rotateRight(j2 + j3 + s44, 21);
        long j4 = s42 + j3 + s43;
        jArr[0] = j4 + s44;
        jArr[1] = Long.rotateRight(j4, 44) + rotateRight + j3;
    }

    @RecentlyNonNull
    public static int m(@RecentlyNonNull Parcel parcel) {
        return N3(parcel, 20293);
    }

    public static int m0(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static boolean m1(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static PorterDuff.Mode m2(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
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

    public static void m3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte[][] bArr, @RecentlyNonNull boolean z) {
        if (bArr != null) {
            int N3 = N3(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            for (byte[] bArr2 : bArr) {
                parcel.writeByteArray(bArr2);
            }
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static boolean m4(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
    public static b.b0.d n(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        IOException e2;
        b.b0.d dVar = new b.b0.d();
        if (bArr == null) {
            return dVar;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                    dVar.f1023a.add(new d.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
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

    public static long n0(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static boolean n1(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static void n2(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static void n3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull double d2) {
        o4(parcel, i, 8);
        parcel.writeDouble(d2);
    }

    public static int n4(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static final String o(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static long o0(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static String o1(c.b.c.a.j0.a.i iVar) {
        String str;
        StringBuilder sb = new StringBuilder(iVar.size());
        for (int i = 0; i < iVar.size(); i++) {
            int a2 = iVar.a(i);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
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
                        if (a2 < 32 || a2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static final void o2(StringBuilder sb, int i, String str, Object obj) {
        String o1;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                o2(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                o2(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                o1 = o1(c.b.c.a.j0.a.i.h((String) obj));
            } else if (obj instanceof c.b.c.a.j0.a.i) {
                sb.append(": \"");
                o1 = o1((c.b.c.a.j0.a.i) obj);
            } else {
                if (obj instanceof c.b.c.a.j0.a.y) {
                    sb.append(" {");
                    w2((c.b.c.a.j0.a.y) obj, sb, i + 2);
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i4 = i + 2;
                    o2(sb, i4, "key", entry2.getKey());
                    o2(sb, i4, "value", entry2.getValue());
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                    return;
                }
                sb.append("}");
                return;
            }
            sb.append(o1);
            sb.append('\"');
        }
    }

    public static void o3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Double> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int N3 = N3(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeDouble(list.get(i2).doubleValue());
            }
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static void o4(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static final String p(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static float p0(byte[] bArr, int i) {
        return Float.intBitsToFloat(l0(bArr, i));
    }

    public static String p1(c.b.d.j jVar) {
        return q1(new k2(jVar));
    }

    public static final void p2(StringBuilder sb, int i, String str, Object obj) {
        String str2;
        String str3;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                p2(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                p2(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                str2 = p1(c.b.d.j.h((String) obj));
            } else if (obj instanceof c.b.d.j) {
                sb.append(": \"");
                str2 = p1((c.b.d.j) obj);
            } else {
                if (obj instanceof k0) {
                    sb.append(" {");
                    x2((k0) obj, sb, i + 2);
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i4 = i + 2;
                    p2(sb, i4, "key", entry2.getKey());
                    p2(sb, i4, "value", entry2.getValue());
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else {
                    sb.append(": ");
                    str3 = obj.toString();
                    sb.append(str3);
                    return;
                }
                str3 = "}";
                sb.append(str3);
                return;
            }
            sb.append(str2);
            sb.append('\"');
        }
    }

    public static void p3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z) {
        if (iBinder != null) {
            int N3 = N3(parcel, i);
            parcel.writeStrongBinder(iBinder);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static final void p4(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                p4(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                p4(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(H4(q0.o((String) obj)));
                sb.append('\"');
            } else if (obj instanceof q0) {
                sb.append(": \"");
                sb.append(H4((q0) obj));
                sb.append('\"');
            } else if (obj instanceof t1) {
                sb.append(" {");
                i4((t1) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                p4(sb, i4, "key", entry2.getKey());
                p4(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static void q(@RecentlyNonNull boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static float q0(byte[] bArr, int i) {
        return Float.intBitsToFloat(m0(bArr, i));
    }

    public static String q1(m2 m2Var) {
        String str;
        StringBuilder sb = new StringBuilder(m2Var.size());
        for (int i = 0; i < m2Var.size(); i++) {
            int a2 = m2Var.a(i);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
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
                        if (a2 < 32 || a2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @RecentlyNonNull
    public static boolean q2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        f4(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static void q3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        o4(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static int q4(byte[] bArr, int i, u uVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            uVar.f3425b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            b2 = b3;
            i3 = i5;
        }
        uVar.f3425b = j2;
        return i3;
    }

    public static void r(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int r0(c.b.c.a.j0.a.f1 f1Var, byte[] bArr, int i, int i2, int i3, e eVar) {
        t0 t0Var = (t0) f1Var;
        Object c2 = t0Var.c();
        int J = t0Var.J(c2, bArr, i, i2, i3, eVar);
        t0Var.g(c2);
        eVar.f4913c = c2;
        return J;
    }

    public static List<String> r1(k1 k1Var) {
        ArrayList arrayList = new ArrayList();
        s1(k1Var, "", arrayList);
        return arrayList;
    }

    @RecentlyNonNull
    public static double r2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        f4(parcel, i, 8);
        return parcel.readDouble();
    }

    public static void r3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z) {
        if (iArr != null) {
            int N3 = N3(parcel, i);
            parcel.writeIntArray(iArr);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static int r4(byte[] bArr, int i, c.b.a.a.g.h.n0 n0Var) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            n0Var.f3968b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            b2 = b3;
            i3 = i5;
        }
        n0Var.f3968b = j2;
        return i3;
    }

    public static void s(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(b2(str, Character.valueOf(c2)));
        }
    }

    public static int s0(d2 d2Var, byte[] bArr, int i, int i2, int i3, f fVar) {
        o1 o1Var = (o1) d2Var;
        Object c2 = o1Var.c();
        int I = o1Var.I(c2, bArr, i, i2, i3, fVar);
        o1Var.g(c2);
        fVar.f5259c = c2;
        return I;
    }

    public static void s1(k1 k1Var, String str, List<String> list) {
        for (s.g gVar : k1Var.getDescriptorForType().p()) {
            if (gVar.y() && !k1Var.hasField(gVar)) {
                StringBuilder h = c.a.a.a.a.h(str);
                h.append(gVar.f());
                list.add(h.toString());
            }
        }
        for (Map.Entry<s.g, Object> entry : k1Var.getAllFields().entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            if (key.f5823g.f5835b == s.g.a.MESSAGE) {
                if (key.e()) {
                    int i = 0;
                    for (k1 k1Var2 : (List) value) {
                        s1(k1Var2, Q2(str, key, i), list);
                        i++;
                    }
                } else if (k1Var.hasField(key)) {
                    s1((k1) value, Q2(str, key, -1), list);
                }
            }
        }
    }

    @RecentlyNonNull
    public static IBinder s2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int v2 = v2(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (v2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + v2);
        return readStrongBinder;
    }

    public static void s3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Integer> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int N3 = N3(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static long s4(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }

    public static void t(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(b2(str, obj));
        }
    }

    public static int t0(c.b.c.a.j0.a.f1 f1Var, byte[] bArr, int i, int i2, e eVar) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = V0(b2, bArr, i3, eVar);
            b3 = eVar.f4911a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw b0.h();
        }
        Object c2 = f1Var.c();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        f1Var.h(c2, bArr, i3, i4, eVar);
        f1Var.g(c2);
        eVar.f4913c = c2;
        return i4;
    }

    public static long t1(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    @RecentlyNonNull
    public static int t2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        f4(parcel, i, 4);
        return parcel.readInt();
    }

    public static void t3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull long j) {
        o4(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void t4(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!M4(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !M4(b4) && !M4(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw c2.f();
    }

    public static void u(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static int u0(d2 d2Var, byte[] bArr, int i, int i2, f fVar) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = W0(b2, bArr, i3, fVar);
            b3 = fVar.f5257a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw o0.i();
        }
        Object c2 = d2Var.c();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        d2Var.i(c2, bArr, i3, i4, fVar);
        d2Var.g(c2);
        fVar.f5259c = c2;
        return i4;
    }

    public static int u1(int i, int i2) {
        return ((i % i2) + i2) % i2;
    }

    @RecentlyNonNull
    public static long u2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        f4(parcel, i, 8);
        return parcel.readLong();
    }

    public static void u3(c.b.d.f1 f1Var, Map<s.g, Object> map, c.b.d.m mVar, boolean z) {
        boolean z2 = f1Var.getDescriptorForType().s().f5663d;
        if (z) {
            TreeMap treeMap = new TreeMap(map);
            for (s.g gVar : f1Var.getDescriptorForType().p()) {
                if (gVar.y() && !treeMap.containsKey(gVar)) {
                    treeMap.put(gVar, f1Var.getField(gVar));
                }
            }
            map = treeMap;
        }
        for (Map.Entry<s.g, Object> entry : map.entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            if (!z2 || !key.s() || key.f5823g != s.g.b.MESSAGE || key.e()) {
                f0.F(key, value, mVar);
            } else {
                mVar.n0(key.f5819c.f5594d, (c.b.d.f1) value);
            }
        }
        q2 unknownFields = f1Var.getUnknownFields();
        if (z2) {
            unknownFields.e(mVar);
        } else {
            unknownFields.writeTo(mVar);
        }
    }

    public static void u4(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (M4(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || M4(b4)))) {
            throw c2.f();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static void v(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int v0(c.b.c.a.j0.a.f1<?> f1Var, int i, byte[] bArr, int i2, int i3, a0.c<?> cVar, e eVar) {
        int t0 = t0(f1Var, bArr, i2, i3, eVar);
        while (true) {
            cVar.add(eVar.f4913c);
            if (t0 >= i3) {
                break;
            }
            int X0 = X0(bArr, t0, eVar);
            if (i != eVar.f4911a) {
                break;
            }
            t0 = t0(f1Var, bArr, X0, i3, eVar);
        }
        return t0;
    }

    public static int v1(long j, int i) {
        long j2 = (long) i;
        return (int) (((j % j2) + j2) % j2);
    }

    @RecentlyNonNull
    public static int v2(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void v3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (parcelable != null) {
            int N3 = N3(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static void v4(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62 || M4(b3)) {
            throw c2.f();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static int w(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = b2("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 >= 0) {
            str = b2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(c.a.a.a.a.n("negative size: ", i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int w0(d2<?> d2Var, int i, byte[] bArr, int i2, int i3, n0.h<?> hVar, f fVar) {
        int u0 = u0(d2Var, bArr, i2, i3, fVar);
        while (true) {
            hVar.add(fVar.f5259c);
            if (u0 >= i3) {
                break;
            }
            int Y0 = Y0(bArr, u0, fVar);
            if (i != fVar.f5257a) {
                break;
            }
            u0 = u0(d2Var, bArr, Y0, i3, fVar);
        }
        return u0;
    }

    public static long w1(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01cb, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01dc, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ee, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x021e;
     */
    public static void w2(r0 r0Var, StringBuilder sb, int i) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = r0Var.getClass().getDeclaredMethods();
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
                    str = o(str3);
                    obj = c.b.c.a.j0.a.y.i(method2, r0Var, new Object[0]);
                    o2(sb, i, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    o2(sb, i, o(str4), c.b.c.a.j0.a.y.i(method3, r0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder h = c.a.a.a.a.h("get");
                    h.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(h.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = c.b.c.a.j0.a.y.i(method4, r0Var, new Object[0]);
                    if (method5 == null) {
                        if (obj instanceof Boolean) {
                            z = !((Boolean) obj).booleanValue();
                        } else {
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Double)) {
                                        if (obj instanceof String) {
                                            obj2 = "";
                                        } else if (obj instanceof c.b.c.a.j0.a.i) {
                                            obj2 = c.b.c.a.j0.a.i.f4933c;
                                        } else {
                                            z = !(obj instanceof r0) ? false : false;
                                        }
                                        z = obj.equals(obj2);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (z) {
                            z2 = false;
                        }
                    } else {
                        z2 = ((Boolean) c.b.c.a.j0.a.y.i(method5, r0Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = o(str5);
                        o2(sb, i, str, obj);
                    }
                }
            }
        }
        if (r0Var instanceof y.c) {
            Iterator<Map.Entry<y.d, Object>> k = ((y.c) r0Var).extensions.k();
            while (k.hasNext()) {
                Map.Entry<y.d, Object> next = k.next();
                if (next.getKey() != null) {
                    o2(sb, i, "[0]", next.getValue());
                } else {
                    throw null;
                }
            }
        }
        m1 m1Var = ((c.b.c.a.j0.a.y) r0Var).unknownFields;
        if (m1Var != null) {
            for (int i2 = 0; i2 < m1Var.f4984a; i2++) {
                o2(sb, i, String.valueOf(m1Var.f4985b[i2] >>> 3), m1Var.f4986c[i2]);
            }
        }
    }

    public static void w3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        if (str != null) {
            int N3 = N3(parcel, i);
            parcel.writeString(str);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static void w4(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void x(@RecentlyNonNull Handler handler) {
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

    public static int x0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        c.b.c.a.j0.a.f fVar = (c.b.c.a.j0.a.f) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            X0 = b1(bArr, X0, eVar);
            fVar.c(eVar.f4912b != 0);
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static <TResult> c.b.a.a.j.i<TResult> x1(TResult tresult) {
        c.b.a.a.j.b0 b0Var = new c.b.a.a.j.b0();
        b0Var.i(tresult);
        return b0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01cb, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01dc, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ee, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x021e;
     */
    public static void x2(c.b.d.i1 i1Var, StringBuilder sb, int i) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = i1Var.getClass().getDeclaredMethods();
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
                    str = p(str3);
                    obj = k0.invokeOrDie(method2, i1Var, new Object[0]);
                    p2(sb, i, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    p2(sb, i, p(str4), k0.invokeOrDie(method3, i1Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder h = c.a.a.a.a.h("get");
                    h.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(h.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = k0.invokeOrDie(method4, i1Var, new Object[0]);
                    if (method5 == null) {
                        if (obj instanceof Boolean) {
                            z = !((Boolean) obj).booleanValue();
                        } else {
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Double)) {
                                        if (obj instanceof String) {
                                            obj2 = "";
                                        } else if (obj instanceof c.b.d.j) {
                                            obj2 = c.b.d.j.f5320c;
                                        } else {
                                            z = !(obj instanceof c.b.d.i1) ? false : false;
                                        }
                                        z = obj.equals(obj2);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (z) {
                            z2 = false;
                        }
                    } else {
                        z2 = ((Boolean) k0.invokeOrDie(method5, i1Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = p(str5);
                        p2(sb, i, str, obj);
                    }
                }
            }
        }
        if (i1Var instanceof k0.b) {
            Iterator<Map.Entry<k0.c, Object>> w = ((k0.b) i1Var).f5352e.w();
            while (w.hasNext()) {
                Map.Entry<k0.c, Object> next = w.next();
                if (next.getKey() != null) {
                    p2(sb, i, "[0]", next.getValue());
                } else {
                    throw null;
                }
            }
        }
        r2 r2Var = ((k0) i1Var).f5348b;
        if (r2Var != null) {
            for (int i2 = 0; i2 < r2Var.f5782a; i2++) {
                p2(sb, i, String.valueOf(r2Var.f5783b[i2] >>> 3), r2Var.f5784c[i2]);
            }
        }
    }

    public static void x3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull String[] strArr, @RecentlyNonNull boolean z) {
        if (strArr != null) {
            int N3 = N3(parcel, i);
            parcel.writeStringArray(strArr);
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static long x4(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int y(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static int y0(byte[] bArr, int i, n0.h<?> hVar, f fVar) {
        c.b.d.g gVar = (c.b.d.g) hVar;
        int Y0 = Y0(bArr, i, fVar);
        int i2 = fVar.f5257a + Y0;
        while (Y0 < i2) {
            Y0 = c1(bArr, Y0, fVar);
            gVar.c(fVar.f5258b != 0);
        }
        if (Y0 == i2) {
            return Y0;
        }
        throw o0.i();
    }

    public static KeyPair y1(w wVar) {
        ECParameterSpec D1 = D1(wVar);
        KeyPairGenerator a2 = c.b.c.a.m0.a0.j.a("EC");
        a2.initialize(D1);
        return a2.generateKeyPair();
    }

    public static <T> T y2(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(c.a.a.a.a.q(str, " must not be null"));
    }

    public static <T extends Parcelable> void y3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (tArr != null) {
            int N3 = N3(parcel, i);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    g4(parcel, t, i2);
                }
            }
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static double y4(byte[] bArr, int i) {
        return Double.longBitsToDouble(x4(bArr, i));
    }

    @RecentlyNonNull
    public static String z(@RecentlyNonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static int z0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        c.b.c.a.j0.a.n nVar = (c.b.c.a.j0.a.n) cVar;
        int X0 = X0(bArr, i, eVar);
        int i2 = eVar.f4911a + X0;
        while (X0 < i2) {
            nVar.c(j0(bArr, X0));
            X0 += 8;
        }
        if (X0 == i2) {
            return X0;
        }
        throw b0.h();
    }

    public static int z1(Context context, int i, int i2) {
        TypedValue z2 = z2(context, i);
        return z2 != null ? z2.data : i2;
    }

    public static TypedValue z2(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static <T extends Parcelable> void z3(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int N3 = N3(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                T t = list.get(i2);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    g4(parcel, t, 0);
                }
            }
            w4(parcel, N3);
        } else if (z) {
            o4(parcel, i, 0);
        }
    }

    public static int z4(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }
}
