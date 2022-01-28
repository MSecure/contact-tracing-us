package c.b.a.a.c.n;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import b.b.q.y0;
import c.b.a.a.e.c.w8;
import c.b.a.b.h0.d;
import c.b.a.b.h0.g;
import c.b.a.b.h0.i;
import c.b.a.b.w.c;
import c.b.b.e.a.b;
import c.b.b.e.a.j;
import c.b.b.e.a.s;
import c.b.b.e.a.u;
import c.b.c.a.i0.i1;
import c.b.c.a.i0.o0;
import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.e;
import c.b.c.a.j0.a.f1;
import c.b.c.a.j0.a.i0;
import c.b.c.a.j0.a.n;
import c.b.c.a.j0.a.q1;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.t0;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.z;
import c.b.c.a.m0.c0;
import c.b.c.a.m0.w;
import c.b.d.c2;
import c.b.d.e1;
import c.b.d.f;
import c.b.d.f0;
import c.b.d.h0;
import c.b.d.h1;
import c.b.d.j;
import c.b.d.j0;
import c.b.d.j1;
import c.b.d.j2;
import c.b.d.k;
import c.b.d.l0;
import c.b.d.l2;
import c.b.d.m;
import c.b.d.m0;
import c.b.d.m1;
import c.b.d.n0;
import c.b.d.n1;
import c.b.d.p0;
import c.b.d.p2;
import c.b.d.q2;
import c.b.d.s;
import c.b.d.t;
import c.b.d.u0;
import c.b.d.v2;
import c.b.d.w2;
import c.b.d.x;
import com.google.android.gms.nearby.connection.Payload;
import e.b.a;
import e.b.f.c;
import e.b.h.f;
import e.b.i.g;
import e.c.a.b;
import e.c.a.w.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f2493a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f2494b;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f2495c;

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f2496d;

    public static int A(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static int A0(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return y0(b2, bArr, i2, fVar);
        }
        fVar.f3854a = b2;
        return i2;
    }

    public static long A1(byte[] bArr, int i, int i2) {
        return (B1(bArr, i) >> i2) & 67108863;
    }

    public static void A2(e1 e1Var, Map<s.g, Object> map, m mVar, boolean z) {
        boolean z2 = e1Var.getDescriptorForType().p().f4179d;
        if (z) {
            TreeMap treeMap = new TreeMap(map);
            for (s.g gVar : e1Var.getDescriptorForType().n()) {
                if (gVar.t() && !treeMap.containsKey(gVar)) {
                    treeMap.put(gVar, e1Var.getField(gVar));
                }
            }
            map = treeMap;
        }
        for (Map.Entry<s.g, Object> entry : map.entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            if (!z2 || !key.p() || key.g != s.g.b.MESSAGE || key.c()) {
                f0.F(key, value, mVar);
            } else {
                mVar.n0(key.f4293c.f4132d, (e1) value);
            }
        }
        p2 unknownFields = e1Var.getUnknownFields();
        if (z2) {
            unknownFields.e(mVar);
        } else {
            unknownFields.writeTo(mVar);
        }
    }

    public static byte[] B(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long A1 = A1(bArr, 0, 0) & 67108863;
            int i = 3;
            long A12 = A1(bArr, 3, 2) & 67108611;
            long A13 = A1(bArr, 6, 4) & 67092735;
            long A14 = A1(bArr, 9, 6) & 66076671;
            long A15 = A1(bArr, 12, 8) & 1048575;
            long j = A12 * 5;
            long j2 = A13 * 5;
            long j3 = A14 * 5;
            long j4 = A15 * 5;
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
                long A16 = A1(bArr3, 0, 0) + j9;
                long A17 = A1(bArr3, i, 2) + j5;
                long A18 = A1(bArr3, 6, 4) + j6;
                long A19 = A1(bArr3, 9, 6) + j7;
                long A110 = j8 + (A1(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
                long j10 = (A110 * j) + (A19 * j2) + (A18 * j3) + (A17 * j4) + (A16 * A1);
                long j11 = (A110 * j2) + (A19 * j3) + (A18 * j4) + (A17 * A1) + (A16 * A12);
                long j12 = (A110 * j3) + (A19 * j4) + (A18 * A1) + (A17 * A12) + (A16 * A13);
                long j13 = (A19 * A1) + (A18 * A12) + (A17 * A13) + (A16 * A14);
                long j14 = A19 * A12;
                long j15 = A110 * A1;
                long j16 = j11 + (j10 >> 26);
                long j17 = j12 + (j16 >> 26);
                long j18 = (A110 * j4) + j13 + (j17 >> 26);
                long j19 = j15 + j14 + (A18 * A13) + (A17 * A14) + (A16 * A15) + (j18 >> 26);
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
            long B1 = B1(bArr, 16) + ((j40 | (j34 & j45) | (j46 << 26)) & 4294967295L);
            long B12 = B1(bArr, 20) + (((j46 >> 6) | (j47 << 20)) & 4294967295L) + (B1 >> 32);
            long j50 = B12 & 4294967295L;
            long B13 = B1(bArr, 24) + (((j47 >> 12) | (j48 << 14)) & 4294967295L) + (B12 >> 32);
            long B14 = B1(bArr, 28);
            byte[] bArr4 = new byte[16];
            j2(bArr4, B1 & 4294967295L, 0);
            j2(bArr4, j50, 4);
            j2(bArr4, B13 & 4294967295L, 8);
            j2(bArr4, (B14 + (((j48 >> 18) | (j49 << 8)) & 4294967295L) + (B13 >> 32)) & 4294967295L, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    public static int B0(int i, byte[] bArr, int i2, int i3, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int z0 = z0(bArr, i2, eVar);
        while (true) {
            zVar.c(eVar.f3542a);
            if (z0 >= i3) {
                break;
            }
            int z02 = z0(bArr, z0, eVar);
            if (i != eVar.f3542a) {
                break;
            }
            z0 = z0(bArr, z02, eVar);
        }
        return z0;
    }

    public static long B1(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    public static final void B2(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static byte[] C(byte[]... bArr) {
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

    public static int C0(int i, byte[] bArr, int i2, int i3, m0.h<?> hVar, f fVar) {
        l0 l0Var = (l0) hVar;
        int A0 = A0(bArr, i2, fVar);
        while (true) {
            l0Var.c(fVar.f3854a);
            if (A0 >= i3) {
                break;
            }
            int A02 = A0(bArr, A0, fVar);
            if (i != fVar.f3854a) {
                break;
            }
            A0 = A0(bArr, A02, fVar);
        }
        return A0;
    }

    public static String C1(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static final byte[] C2(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i3 < 0 || bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }

    public static a D(String str) {
        String str2;
        e.b.f.c cVar = new e.b.f.c();
        I1(str, "Must supply a valid URL");
        try {
            a.d dVar = cVar.f4810a;
            try {
                str2 = e.b.f.c.a(new URL(str)).toExternalForm();
            } catch (Exception unused) {
                str2 = str;
            }
            ((c.b) dVar).h(new URL(str2));
            return cVar;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(c.a.a.a.a.o("Malformed URL: ", str), e2);
        }
    }

    public static int D0(byte[] bArr, int i, e eVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            eVar.f3543b = j;
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
        eVar.f3543b = j2;
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    public static boolean D1(k kVar, p2.b bVar, c.b.d.z zVar, s.b bVar2, m1 m1Var, int i) {
        e1 e1Var;
        Object[] objArr;
        Object obj;
        x.b e2;
        Object obj2;
        int i2 = 0;
        s.g gVar = null;
        j jVar = null;
        if (!bVar2.p().f4179d || i != 11) {
            int i3 = i & 7;
            int i4 = i >>> 3;
            if (bVar2.q(i4)) {
                if ((zVar instanceof x) && (e2 = m1Var.e((x) zVar, bVar2, i4)) != null) {
                    gVar = e2.f4387a;
                    e1Var = e2.f4388b;
                    if (e1Var == null && gVar.g.f4303b == s.g.a.MESSAGE) {
                        StringBuilder g = c.a.a.a.a.g("Message-typed extension lacked default instance: ");
                        g.append(gVar.f4294d);
                        throw new IllegalStateException(g.toString());
                    }
                    if (gVar != null) {
                        if (i3 == f0.q(gVar.e(), false)) {
                            objArr = null;
                        } else if (gVar.s() && i3 == f0.q(gVar.e(), true)) {
                            objArr = 1;
                        }
                        if (i2 == 0) {
                            return bVar != null ? bVar.e(i, kVar) : kVar.J(i);
                        }
                        if (objArr != null) {
                            int l = kVar.l(kVar.y());
                            if (gVar.e() == w2.b.ENUM) {
                                while (kVar.d() > 0) {
                                    int p = kVar.p();
                                    if (gVar.f4295e.p()) {
                                        m1Var.addRepeatedField(gVar, gVar.l().k(p));
                                    } else {
                                        s.f i5 = gVar.l().i(p);
                                        if (i5 != null) {
                                            m1Var.addRepeatedField(gVar, i5);
                                        } else if (bVar != null) {
                                            bVar.h(i4, p);
                                        }
                                    }
                                }
                            } else {
                                while (kVar.d() > 0) {
                                    m1Var.addRepeatedField(gVar, w2.a(kVar, gVar.e(), m1Var.f(gVar)));
                                }
                            }
                            kVar.k(l);
                        } else {
                            int ordinal = gVar.g.ordinal();
                            if (ordinal == 9) {
                                obj = m1Var.d(kVar, zVar, gVar, e1Var);
                            } else if (ordinal == 10) {
                                obj = m1Var.b(kVar, zVar, gVar, e1Var);
                            } else if (ordinal != 13) {
                                obj = w2.a(kVar, gVar.e(), m1Var.f(gVar));
                            } else {
                                int p2 = kVar.p();
                                if (gVar.f4295e.p()) {
                                    obj = gVar.l().k(p2);
                                } else {
                                    s.f i6 = gVar.l().i(p2);
                                    if (i6 == null) {
                                        if (bVar != null) {
                                            bVar.h(i4, p2);
                                        }
                                        return true;
                                    }
                                    obj = i6;
                                }
                            }
                            if (gVar.c()) {
                                m1Var.addRepeatedField(gVar, obj);
                            } else {
                                m1Var.setField(gVar, obj);
                            }
                        }
                        return true;
                    }
                    objArr = null;
                    i2 = 1;
                    if (i2 == 0) {
                    }
                }
            } else if (m1Var.a() == m1.a.MESSAGE) {
                gVar = bVar2.l(i4);
                e1Var = null;
                if (gVar != null) {
                }
                objArr = null;
                i2 = 1;
                if (i2 == 0) {
                }
            }
            e1Var = null;
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
                    if (i2 != 0 && (zVar instanceof x)) {
                        bVar3 = m1Var.e((x) zVar, bVar2, i2);
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
                    s.g gVar2 = bVar3.f4387a;
                    if (!m1Var.hasField(gVar2)) {
                        c.b.d.z.b();
                        obj2 = new p0(bVar3.f4388b, zVar, jVar);
                    } else {
                        obj2 = m1Var.c(jVar, zVar, gVar2, bVar3.f4388b);
                    }
                    m1Var.setField(gVar2, obj2);
                } else if (bVar != null) {
                    p2.c.a c2 = p2.c.c();
                    c2.c(jVar);
                    bVar.d(i2, c2.e());
                }
            }
            return true;
        }
    }

    public static final byte[] D2(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return C2(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    @Deprecated
    public static long E(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
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

    public static int E0(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            fVar.f3855b = j;
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
        fVar.f3855b = j2;
        return i3;
    }

    public static byte[] E1(byte[] bArr, int i, c0 c0Var) {
        MessageDigest a2 = c.b.c.a.m0.a0.i.a(m2(c0Var));
        int digestLength = a2.getDigestLength();
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 <= (i - 1) / digestLength; i3++) {
            a2.reset();
            a2.update(bArr);
            a2.update(l1(BigInteger.valueOf((long) i3), 4));
            byte[] digest = a2.digest();
            System.arraycopy(digest, 0, bArr2, i2, Math.min(digest.length, i - i2));
            i2 += digest.length;
        }
        return bArr2;
    }

    public static int E2(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    public static Animator F(c.b.a.b.w.c cVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, c.C0072c.f3213a, c.b.f3211b, new c.e(f, f2, f3));
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f, (int) f2, revealInfo.f3217c, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static String F0(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static e.c.a.w.f F1(b bVar) {
        return new h(0, bVar, null);
    }

    public static int F2(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = K2("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = K2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static d G(int i) {
        if (i == 0) {
            return new i();
        }
        if (i != 1) {
            return new i();
        }
        return new c.b.a.b.h0.e();
    }

    public static float G0(float f, float f2, float f3, float f4) {
        return (float) Math.hypot((double) (f3 - f), (double) (f4 - f2));
    }

    public static String G1(String str) {
        return C1(str).trim();
    }

    public static Pair<w8, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> G2(Payload payload) {
        int type = payload.getType();
        if (type == 1) {
            w8 w8Var = new w8(null);
            w8Var.f2793b = payload.getId();
            w8Var.f2794c = payload.getType();
            w8Var.f2795d = payload.asBytes();
            return Pair.create(w8Var, null);
        } else if (type == 2) {
            String absolutePath = payload.asFile().asJavaFile() == null ? null : payload.asFile().asJavaFile().getAbsolutePath();
            w8 w8Var2 = new w8(null);
            w8Var2.f2793b = payload.getId();
            w8Var2.f2794c = payload.getType();
            w8Var2.f2796e = payload.asFile().asParcelFileDescriptor();
            w8Var2.f = absolutePath;
            w8Var2.g = payload.asFile().getSize();
            w8Var2.j = payload.getOffset();
            return Pair.create(w8Var2, null);
        } else if (type == 3) {
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                w8 w8Var3 = new w8(null);
                w8Var3.f2793b = payload.getId();
                w8Var3.f2794c = payload.getType();
                w8Var3.f2796e = createPipe[0];
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

    public static byte[] H(byte[] bArr) {
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

    public static float H0(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static void H1(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static Payload H2(Context context, w8 w8Var) {
        long j = w8Var.f2793b;
        int i = w8Var.f2794c;
        if (i == 1) {
            return Payload.zza(w8Var.f2795d, j);
        }
        if (i == 2) {
            String str = w8Var.f;
            Uri uri = w8Var.i;
            if (str == null || uri == null) {
                return Payload.zza(Payload.File.zza(w8Var.f2796e), j);
            }
            try {
                return Payload.zza(Payload.File.zza(new File(str), context.getContentResolver().openFileDescriptor(uri, "r"), w8Var.g, uri), j);
            } catch (FileNotFoundException unused) {
                String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uri, str);
                return null;
            }
        } else if (i == 3) {
            return Payload.zza(Payload.Stream.zza(w8Var.f2796e), j);
        } else {
            String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(j), Integer.valueOf(w8Var.f2794c));
            return null;
        }
    }

    public static byte[] I(String str) {
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

    public static String I0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            sb.append("0123456789abcdef".charAt(i / 16));
            sb.append("0123456789abcdef".charAt(i % 16));
        }
        return sb.toString();
    }

    public static void I1(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static Object I2(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    public static int J(byte[] bArr, int i, e eVar) {
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 > bArr.length - z0) {
            throw b0.h();
        } else if (i2 == 0) {
            eVar.f3544c = c.b.c.a.j0.a.i.f3564c;
            return z0;
        } else {
            eVar.f3544c = c.b.c.a.j0.a.i.h(bArr, z0, i2);
            return z0 + i2;
        }
    }

    public static boolean J0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void J1(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static String J2(int i, int i2, String str) {
        if (i < 0) {
            return K2("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return K2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static int K(byte[] bArr, int i, f fVar) {
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a;
        if (i2 < 0) {
            throw n0.f();
        } else if (i2 > bArr.length - A0) {
            throw n0.i();
        } else if (i2 == 0) {
            fVar.f3856c = j.f3914c;
            return A0;
        } else {
            fVar.f3856c = j.h(bArr, A0, i2);
            return A0 + i2;
        }
    }

    public static final boolean K0(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    public static void K1(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String K2(String str, Object... objArr) {
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

    public static double L(byte[] bArr, int i) {
        return Double.longBitsToDouble(P(bArr, i));
    }

    public static boolean L0(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static f.a L1(e.b.h.m mVar) {
        e.b.h.m A = mVar.A();
        e.b.h.f fVar = A instanceof e.b.h.f ? (e.b.h.f) A : null;
        if (fVar == null) {
            fVar = new e.b.h.f("");
        }
        return fVar.j;
    }

    public static void L2(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = J2(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = J2(i2, i3, "end index");
            } else {
                str = K2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static double M(byte[] bArr, int i) {
        return Double.longBitsToDouble(Q(bArr, i));
    }

    public static String M0(c.b.c.a.j0.a.i iVar) {
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

    public static PorterDuff.Mode M1(int i, PorterDuff.Mode mode) {
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

    public static boolean M2(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int N(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static String N0(j jVar) {
        return O0(new j2(jVar));
    }

    public static g N1(e.b.h.m mVar) {
        g gVar;
        e.b.h.m A = mVar.A();
        e.b.h.f fVar = A instanceof e.b.h.f ? (e.b.h.f) A : null;
        return (fVar == null || (gVar = fVar.k) == null) ? new g(new e.b.i.b()) : gVar;
    }

    public static int O(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static String O0(l2 l2Var) {
        String str;
        StringBuilder sb = new StringBuilder(l2Var.size());
        for (int i = 0; i < l2Var.size(); i++) {
            int a2 = l2Var.a(i);
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

    public static void O1(AnimatorSet animatorSet, List<Animator> list) {
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

    public static long P(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static List<String> P0(j1 j1Var) {
        ArrayList arrayList = new ArrayList();
        Q0(j1Var, "", arrayList);
        return arrayList;
    }

    public static final void P1(StringBuilder sb, int i, String str, Object obj) {
        String M0;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                P1(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                P1(sb, i, str, entry);
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
                M0 = M0(c.b.c.a.j0.a.i.j((String) obj));
            } else if (obj instanceof c.b.c.a.j0.a.i) {
                sb.append(": \"");
                M0 = M0((c.b.c.a.j0.a.i) obj);
            } else {
                if (obj instanceof y) {
                    sb.append(" {");
                    R1((y) obj, sb, i + 2);
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i4 = i + 2;
                    P1(sb, i4, "key", entry2.getKey());
                    P1(sb, i4, "value", entry2.getValue());
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
            sb.append(M0);
            sb.append('\"');
        }
    }

    public static long Q(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static void Q0(j1 j1Var, String str, List<String> list) {
        for (s.g gVar : j1Var.getDescriptorForType().n()) {
            if (gVar.t() && !j1Var.hasField(gVar)) {
                StringBuilder g = c.a.a.a.a.g(str);
                g.append(gVar.f());
                list.add(g.toString());
            }
        }
        for (Map.Entry<s.g, Object> entry : j1Var.getAllFields().entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            if (key.g.f4303b == s.g.a.MESSAGE) {
                if (key.c()) {
                    int i = 0;
                    for (j1 j1Var2 : (List) value) {
                        Q0(j1Var2, i2(str, key, i), list);
                        i++;
                    }
                } else if (j1Var.hasField(key)) {
                    Q0((j1) value, i2(str, key, -1), list);
                }
            }
        }
    }

    public static final void Q1(StringBuilder sb, int i, String str, Object obj) {
        String str2;
        String str3;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                Q1(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Q1(sb, i, str, entry);
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
                str2 = N0(j.j((String) obj));
            } else if (obj instanceof j) {
                sb.append(": \"");
                str2 = N0((j) obj);
            } else {
                if (obj instanceof j0) {
                    sb.append(" {");
                    S1((j0) obj, sb, i + 2);
                    sb.append("\n");
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i4 = i + 2;
                    Q1(sb, i4, "key", entry2.getKey());
                    Q1(sb, i4, "value", entry2.getValue());
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

    public static float R(byte[] bArr, int i) {
        return Float.intBitsToFloat(N(bArr, i));
    }

    public static long R0(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
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
    public static void R1(r0 r0Var, StringBuilder sb, int i) {
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
                    str = m(str3);
                    obj = y.i(method2, r0Var, new Object[0]);
                    P1(sb, i, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    P1(sb, i, m(str4), y.i(method3, r0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder g = c.a.a.a.a.g("get");
                    g.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(g.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = y.i(method4, r0Var, new Object[0]);
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
                                            obj2 = c.b.c.a.j0.a.i.f3564c;
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
                        z2 = ((Boolean) y.i(method5, r0Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = m(str5);
                        P1(sb, i, str, obj);
                    }
                }
            }
        }
        if (r0Var instanceof y.c) {
            Iterator<Map.Entry<y.d, Object>> k = ((y.c) r0Var).extensions.k();
            while (k.hasNext()) {
                Map.Entry<y.d, Object> next = k.next();
                if (next.getKey() != null) {
                    P1(sb, i, "[0]", next.getValue());
                } else {
                    throw null;
                }
            }
        }
        c.b.c.a.j0.a.m1 m1Var = ((y) r0Var).unknownFields;
        if (m1Var != null) {
            for (int i2 = 0; i2 < m1Var.f3607a; i2++) {
                P1(sb, i, String.valueOf(m1Var.f3608b[i2] >>> 3), m1Var.f3609c[i2]);
            }
        }
    }

    public static float S(byte[] bArr, int i) {
        return Float.intBitsToFloat(O(bArr, i));
    }

    public static int S0(int i, int i2) {
        return ((i % i2) + i2) % i2;
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
    public static void S1(h1 h1Var, StringBuilder sb, int i) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = h1Var.getClass().getDeclaredMethods();
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
                    obj = j0.invokeOrDie(method2, h1Var, new Object[0]);
                    Q1(sb, i, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    Q1(sb, i, n(str4), j0.invokeOrDie(method3, h1Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder g = c.a.a.a.a.g("get");
                    g.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(g.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = j0.invokeOrDie(method4, h1Var, new Object[0]);
                    if (method5 == null) {
                        if (obj instanceof Boolean) {
                            z = !((Boolean) obj).booleanValue();
                        } else {
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Double)) {
                                        if (obj instanceof String) {
                                            obj2 = "";
                                        } else if (obj instanceof j) {
                                            obj2 = j.f3914c;
                                        } else {
                                            z = !(obj instanceof h1) ? false : false;
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
                        z2 = ((Boolean) j0.invokeOrDie(method5, h1Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = n(str5);
                        Q1(sb, i, str, obj);
                    }
                }
            }
        }
        if (h1Var instanceof j0.b) {
            Iterator<Map.Entry<j0.c, Object>> w = ((j0.b) h1Var).f3925e.w();
            while (w.hasNext()) {
                Map.Entry<j0.c, Object> next = w.next();
                if (next.getKey() != null) {
                    Q1(sb, i, "[0]", next.getValue());
                } else {
                    throw null;
                }
            }
        }
        q2 q2Var = ((j0) h1Var).f3921b;
        if (q2Var != null) {
            for (int i2 = 0; i2 < q2Var.f4056a; i2++) {
                Q1(sb, i, String.valueOf(q2Var.f4057b[i2] >>> 3), q2Var.f4058c[i2]);
            }
        }
    }

    public static int T(f1 f1Var, byte[] bArr, int i, int i2, int i3, e eVar) {
        t0 t0Var = (t0) f1Var;
        Object e2 = t0Var.e();
        int J = t0Var.J(e2, bArr, i, i2, i3, eVar);
        t0Var.f(e2);
        eVar.f3544c = e2;
        return J;
    }

    public static int T0(long j, int i) {
        long j2 = (long) i;
        return (int) (((j % j2) + j2) % j2);
    }

    public static <T> T T1(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(c.a.a.a.a.o(str, " must not be null"));
    }

    public static int U(c2 c2Var, byte[] bArr, int i, int i2, int i3, c.b.d.f fVar) {
        n1 n1Var = (n1) c2Var;
        Object e2 = n1Var.e();
        int I = n1Var.I(e2, bArr, i, i2, i3, fVar);
        n1Var.f(e2);
        fVar.f3856c = e2;
        return I;
    }

    public static long U0(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    public static TypedValue U1(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int V(f1 f1Var, byte[] bArr, int i, int i2, e eVar) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = x0(b2, bArr, i3, eVar);
            b3 = eVar.f3542a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw b0.h();
        }
        Object e2 = f1Var.e();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        f1Var.h(e2, bArr, i3, i4, eVar);
        f1Var.f(e2);
        eVar.f3544c = e2;
        return i4;
    }

    public static <TResult> c.b.a.a.g.h<TResult> V0(TResult tresult) {
        c.b.a.a.g.a0 a0Var = new c.b.a.a.g.a0();
        a0Var.i(tresult);
        return a0Var;
    }

    public static boolean V1(Context context, int i, boolean z) {
        TypedValue U1 = U1(context, i);
        return (U1 == null || U1.type != 18) ? z : U1.data != 0;
    }

    public static int W(c2 c2Var, byte[] bArr, int i, int i2, c.b.d.f fVar) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = y0(b2, bArr, i3, fVar);
            b3 = fVar.f3854a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw n0.i();
        }
        Object e2 = c2Var.e();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        c2Var.i(e2, bArr, i3, i4, fVar);
        c2Var.f(e2);
        fVar.f3856c = e2;
        return i4;
    }

    public static KeyPair W0(w wVar) {
        ECParameterSpec b1 = b1(wVar);
        KeyPairGenerator a2 = c.b.c.a.m0.a0.j.a("EC");
        a2.initialize(b1);
        return a2.generateKeyPair();
    }

    public static int W1(Context context, int i, String str) {
        TypedValue U1 = U1(context, i);
        if (U1 != null) {
            return U1.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int X(f1<?> f1Var, int i, byte[] bArr, int i2, int i3, a0.c<?> cVar, e eVar) {
        int V = V(f1Var, bArr, i2, i3, eVar);
        while (true) {
            cVar.add(eVar.f3544c);
            if (V >= i3) {
                break;
            }
            int z0 = z0(bArr, V, eVar);
            if (i != eVar.f3542a) {
                break;
            }
            V = V(f1Var, bArr, z0, i3, eVar);
        }
        return V;
    }

    public static int X0(Context context, int i, int i2) {
        TypedValue U1 = U1(context, i);
        return U1 != null ? U1.data : i2;
    }

    public static int X1(int i, int i2) {
        int i3 = i + i2;
        if ((i ^ i3) >= 0 || (i ^ i2) < 0) {
            return i3;
        }
        throw new ArithmeticException("Addition overflows an int: " + i + " + " + i2);
    }

    public static int Y(c2<?> c2Var, int i, byte[] bArr, int i2, int i3, m0.h<?> hVar, c.b.d.f fVar) {
        int W = W(c2Var, bArr, i2, i3, fVar);
        while (true) {
            hVar.add(fVar.f3856c);
            if (W >= i3) {
                break;
            }
            int A0 = A0(bArr, W, fVar);
            if (i != fVar.f3854a) {
                break;
            }
            W = W(c2Var, bArr, A0, i3, fVar);
        }
        return W;
    }

    public static int Y0(View view, int i) {
        return W1(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static long Y1(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        throw new ArithmeticException("Addition overflows a long: " + j + " + " + j2);
    }

    public static int Z(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        c.b.c.a.j0.a.f fVar = (c.b.c.a.j0.a.f) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            z0 = D0(bArr, z0, eVar);
            fVar.c(eVar.f3543b != 0);
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static ColorStateList Z0(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a2 = b.b.l.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a2;
    }

    public static long Z1(long j, int i) {
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

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!r1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !r1(b4) && !r1(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw b0.c();
    }

    public static int a0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        c.b.d.g gVar = (c.b.d.g) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            A0 = E0(bArr, A0, fVar);
            gVar.c(fVar.f3855b != 0);
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static ColorStateList a1(Context context, y0 y0Var, int i) {
        int resourceId;
        ColorStateList a2;
        return (!y0Var.f759b.hasValue(i) || (resourceId = y0Var.f759b.getResourceId(i, 0)) == 0 || (a2 = b.b.l.a.a.a(context, resourceId)) == null) ? y0Var.c(i) : a2;
    }

    public static long a2(long j, long j2) {
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

    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!s1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !s1(b4) && !s1(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw n0.c();
    }

    public static int b0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        n nVar = (n) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            nVar.c(L(bArr, z0));
            z0 += 8;
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static ECParameterSpec b1(w wVar) {
        int ordinal = wVar.ordinal();
        if (ordinal == 0) {
            return g1("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
        }
        if (ordinal == 1) {
            return g1("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
        }
        if (ordinal == 2) {
            return g1("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + wVar);
    }

    public static int b2(int i, int i2) {
        int i3 = i - i2;
        if ((i ^ i3) >= 0 || (i ^ i2) >= 0) {
            return i3;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i + " - " + i2);
    }

    public static boolean c(byte b2) {
        return b2 >= 0;
    }

    public static int c0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        t tVar = (t) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            tVar.c(M(bArr, A0));
            A0 += 8;
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static <V> V c1(Future<V> future) {
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
        throw new IllegalStateException(y1("Future was expected to be done: %s", future));
    }

    public static long c2(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j + " - " + j2);
    }

    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    public static int d0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            zVar.c(N(bArr, z0));
            z0 += 4;
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static Drawable d1(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b2 = b.b.l.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b2;
    }

    public static int d2(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j);
    }

    public static boolean e(byte b2) {
        return b2 < -32;
    }

    public static int e0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        l0 l0Var = (l0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            l0Var.c(O(bArr, A0));
            A0 += 4;
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static ECPrivateKey e1(w wVar, byte[] bArr) {
        return (ECPrivateKey) c.b.c.a.m0.a0.k.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), b1(wVar)));
    }

    public static void e2(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof c.b.a.b.h0.g) {
            c.b.a.b.h0.g gVar = (c.b.a.b.h0.g) background;
            g.b bVar = gVar.f2982b;
            if (bVar.o != f) {
                bVar.o = f;
                gVar.z();
            }
        }
    }

    public static void f(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62 || r1(b3)) {
            throw b0.c();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static int f0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            i0Var.c(P(bArr, z0));
            z0 += 8;
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static ECPublicKey f1(w wVar, byte[] bArr, byte[] bArr2) {
        ECParameterSpec b1 = b1(wVar);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        v(eCPoint, b1.getCurve());
        return (ECPublicKey) c.b.c.a.m0.a0.k.a("EC").generatePublic(new ECPublicKeySpec(eCPoint, b1));
    }

    public static void f2(View view, c.b.a.b.h0.g gVar) {
        c.b.a.b.z.a aVar = gVar.f2982b.f2988b;
        if (aVar != null && aVar.f3306a) {
            float h1 = h1(view);
            g.b bVar = gVar.f2982b;
            if (bVar.n != h1) {
                bVar.n = h1;
                gVar.z();
            }
        }
    }

    public static void g(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62 || s1(b3)) {
            throw n0.c();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static int g0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        u0 u0Var = (u0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            u0Var.c(Q(bArr, A0));
            A0 += 8;
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static ECParameterSpec g1(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static int g2(int i, byte[] bArr, int i2, int i3, e eVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return D0(bArr, i2, eVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return z0(bArr, i2, eVar) + eVar.f3542a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = z0(bArr, i2, eVar);
                    i6 = eVar.f3542a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = g2(i6, bArr, i2, i3, eVar);
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

    public static boolean h(byte b2) {
        return b2 < -16;
    }

    public static int h0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        c.b.c.a.j0.a.w wVar = (c.b.c.a.j0.a.w) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            wVar.c(R(bArr, z0));
            z0 += 4;
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static float h1(View view) {
        float f = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f += b.i.l.m.k((View) parent);
        }
        return f;
    }

    public static int h2(int i, byte[] bArr, int i2, int i3, c.b.d.f fVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return E0(bArr, i2, fVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return A0(bArr, i2, fVar) + fVar.f3854a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = A0(bArr, i2, fVar);
                    i6 = fVar.f3854a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = h2(i6, bArr, i2, i3, fVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw n0.g();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw n0.b();
            }
        } else {
            throw n0.b();
        }
    }

    public static void i(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (r1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || r1(b4)))) {
            throw b0.c();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static int i0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        h0 h0Var = (h0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            h0Var.c(S(bArr, A0));
            A0 += 4;
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static int i1(e1 e1Var, Map<s.g, Object> map) {
        boolean z = e1Var.getDescriptorForType().p().f4179d;
        int i = 0;
        for (Map.Entry<s.g, Object> entry : map.entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            i += (!z || !key.p() || key.g != s.g.b.MESSAGE || key.c()) ? f0.i(key, value) : m.y(key.f4293c.f4132d, (e1) value);
        }
        p2 unknownFields = e1Var.getUnknownFields();
        return (z ? unknownFields.a() : unknownFields.getSerializedSize()) + i;
    }

    public static String i2(String str, s.g gVar, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (gVar.p()) {
            sb.append('(');
            sb.append(gVar.f4294d);
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

    public static void j(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (s1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || s1(b4)))) {
            throw n0.c();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static int j0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            z0 = z0(bArr, z0, eVar);
            zVar.c(c.b.c.a.j0.a.j.b(eVar.f3542a));
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static <V> u<V> j1(Throwable th) {
        return new s.a(th);
    }

    public static void j2(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    public static <V> u<List<V>> k(Iterable<? extends u<? extends V>> iterable) {
        return new j.a(c.b.b.b.c.r(iterable), true);
    }

    public static int k0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        l0 l0Var = (l0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            A0 = A0(bArr, A0, fVar);
            l0Var.c(k.b(fVar.f3854a));
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static <V> u<V> k1(V v) {
        return v == null ? (u<V>) c.b.b.e.a.s.f3411c : new c.b.b.e.a.s(v);
    }

    public static w k2(c.b.c.a.i0.m0 m0Var) {
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

    public static String l(int i, int i2, String str) {
        if (i < 0) {
            return y1("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return y1("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(c.a.a.a.a.l("negative size: ", i2));
        }
    }

    public static int l0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            z0 = D0(bArr, z0, eVar);
            i0Var.c(c.b.c.a.j0.a.j.c(eVar.f3543b));
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static byte[] l1(BigInteger bigInteger, int i) {
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

    public static w l2(c.b.c.a.i0.m0 m0Var) {
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
        StringBuilder g = c.a.a.a.a.g("unknown curve type: ");
        g.append(m0Var.name());
        throw new GeneralSecurityException(g.toString());
    }

    public static final String m(String str) {
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

    public static int m0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        u0 u0Var = (u0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            A0 = E0(bArr, A0, fVar);
            u0Var.c(k.c(fVar.f3855b));
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static boolean m1() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String m2(c0 c0Var) {
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

    public static final String n(String str) {
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

    public static int n0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        z zVar = (z) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            z0 = z0(bArr, z0, eVar);
            zVar.c(eVar.f3542a);
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static boolean n1() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static c.b.c.a.m0.x n2(c.b.c.a.i0.c0 c0Var) {
        int ordinal = c0Var.ordinal();
        if (ordinal == 1) {
            return c.b.c.a.m0.x.IEEE_P1363;
        }
        if (ordinal == 2) {
            return c.b.c.a.m0.x.DER;
        }
        StringBuilder g = c.a.a.a.a.g("unknown ECDSA encoding: ");
        g.append(c0Var.name());
        throw new GeneralSecurityException(g.toString());
    }

    public static void o(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int o0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        l0 l0Var = (l0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            A0 = A0(bArr, A0, fVar);
            l0Var.c(fVar.f3854a);
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static void o1(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static c0 o2(o0 o0Var) {
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
        StringBuilder g = c.a.a.a.a.g("unsupported hash type: ");
        g.append(o0Var.name());
        throw new GeneralSecurityException(g.toString());
    }

    public static void p(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(y1(str, Character.valueOf(c2)));
        }
    }

    public static int p0(byte[] bArr, int i, a0.c<?> cVar, e eVar) {
        i0 i0Var = (i0) cVar;
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a + z0;
        while (z0 < i2) {
            z0 = D0(bArr, z0, eVar);
            i0Var.c(eVar.f3543b);
        }
        if (z0 == i2) {
            return z0;
        }
        throw b0.h();
    }

    public static void p1(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String p2(o0 o0Var) {
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

    public static void q(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(y1(str, obj));
        }
    }

    public static int q0(byte[] bArr, int i, m0.h<?> hVar, c.b.d.f fVar) {
        u0 u0Var = (u0) hVar;
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a + A0;
        while (A0 < i2) {
            A0 = E0(bArr, A0, fVar);
            u0Var.c(fVar.f3855b);
        }
        if (A0 == i2) {
            return A0;
        }
        throw n0.i();
    }

    public static boolean q1(View view) {
        return b.i.l.m.o(view) == 1;
    }

    public static String q2(o0 o0Var) {
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

    public static int r(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = y1("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 >= 0) {
            str = y1("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(c.a.a.a.a.l("negative size: ", i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int r0(byte[] bArr, int i, e eVar) {
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 == 0) {
            eVar.f3544c = "";
            return z0;
        } else {
            eVar.f3544c = new String(bArr, z0, i2, a0.f3518a);
            return z0 + i2;
        }
    }

    public static boolean r1(byte b2) {
        return b2 > -65;
    }

    public static c.b.c.a.m0.y r2(c.b.c.a.i0.x xVar) {
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

    public static int s(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static int s0(byte[] bArr, int i, c.b.d.f fVar) {
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a;
        if (i2 < 0) {
            throw n0.f();
        } else if (i2 == 0) {
            fVar.f3856c = "";
            return A0;
        } else {
            fVar.f3856c = new String(bArr, A0, i2, m0.f3998a);
            return A0 + i2;
        }
    }

    public static boolean s1(byte b2) {
        return b2 > -65;
    }

    public static void s2(e.b.j.f fVar, e.b.h.m mVar) {
        e.b.h.m mVar2 = mVar;
        int i = 0;
        while (mVar2 != null) {
            fVar.b(mVar2, i);
            if (mVar2.h() > 0) {
                mVar2 = mVar2.g(0);
                i++;
            } else {
                while (mVar2.r() == null && i > 0) {
                    fVar.a(mVar2, i);
                    mVar2 = mVar2.f4861b;
                    i--;
                }
                fVar.a(mVar2, i);
                if (mVar2 != mVar) {
                    mVar2 = mVar2.r();
                } else {
                    return;
                }
            }
        }
    }

    public static <T> T t(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int t0(byte[] bArr, int i, e eVar) {
        int z0 = z0(bArr, i, eVar);
        int i2 = eVar.f3542a;
        if (i2 < 0) {
            throw b0.f();
        } else if (i2 == 0) {
            eVar.f3544c = "";
            return z0;
        } else {
            eVar.f3544c = q1.f3635a.a(bArr, z0, i2);
            return z0 + i2;
        }
    }

    public static void t1(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static Throwable t2(c.b.b.e.a.d0.a aVar) {
        c.b.b.e.a.b bVar = (c.b.b.e.a.b) aVar;
        if (bVar == null) {
            throw null;
        } else if (!(bVar instanceof b.i)) {
            return null;
        } else {
            Object obj = bVar.f3368b;
            if (obj instanceof b.d) {
                return ((b.d) obj).f3376a;
            }
            return null;
        }
    }

    public static <T> T u(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(y1(str, obj));
    }

    public static int u0(byte[] bArr, int i, c.b.d.f fVar) {
        int A0 = A0(bArr, i, fVar);
        int i2 = fVar.f3854a;
        if (i2 < 0) {
            throw n0.f();
        } else if (i2 == 0) {
            fVar.f3856c = "";
            return A0;
        } else {
            fVar.f3856c = v2.b(bArr, A0, i2);
            return A0 + i2;
        }
    }

    public static void u1(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static PorterDuffColorFilter u2(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static void v(ECPoint eCPoint, EllipticCurve ellipticCurve) {
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

    public static int v0(int i, byte[] bArr, int i2, int i3, c.b.c.a.j0.a.m1 m1Var, e eVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int D0 = D0(bArr, i2, eVar);
                m1Var.c(i, Long.valueOf(eVar.f3543b));
                return D0;
            } else if (i4 == 1) {
                m1Var.c(i, Long.valueOf(P(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int z0 = z0(bArr, i2, eVar);
                int i5 = eVar.f3542a;
                if (i5 < 0) {
                    throw b0.f();
                } else if (i5 <= bArr.length - z0) {
                    m1Var.c(i, i5 == 0 ? c.b.c.a.j0.a.i.f3564c : c.b.c.a.j0.a.i.h(bArr, z0, i5));
                    return z0 + i5;
                } else {
                    throw b0.h();
                }
            } else if (i4 == 3) {
                c.b.c.a.j0.a.m1 b2 = c.b.c.a.j0.a.m1.b();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int z02 = z0(bArr, i2, eVar);
                    int i8 = eVar.f3542a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = z02;
                        break;
                    }
                    int v0 = v0(i7, bArr, z02, i3, b2, eVar);
                    i7 = i8;
                    i2 = v0;
                }
                if (i2 > i3 || i7 != i6) {
                    throw b0.g();
                }
                m1Var.c(i, b2);
                return i2;
            } else if (i4 == 5) {
                m1Var.c(i, Integer.valueOf(N(bArr, i2)));
                return i2 + 4;
            } else {
                throw b0.b();
            }
        } else {
            throw b0.b();
        }
    }

    @TargetApi(20)
    public static boolean v1(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2493a == null) {
            f2493a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f2493a.booleanValue();
    }

    public static void v2(c.b.c.a.i0.f0 f0Var) {
        b1(k2(f0Var.p().n()));
        p2(f0Var.p().o());
        if (f0Var.o() != c.b.c.a.i0.x.UNKNOWN_FORMAT) {
            c.b.c.a.y.g(f0Var.n().n());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static void w(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = l(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = l(i2, i3, "end index");
            } else {
                str = y1("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static int w0(int i, byte[] bArr, int i2, int i3, q2 q2Var, c.b.d.f fVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int E0 = E0(bArr, i2, fVar);
                q2Var.c(i, Long.valueOf(fVar.f3855b));
                return E0;
            } else if (i4 == 1) {
                q2Var.c(i, Long.valueOf(Q(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int A0 = A0(bArr, i2, fVar);
                int i5 = fVar.f3854a;
                if (i5 < 0) {
                    throw n0.f();
                } else if (i5 <= bArr.length - A0) {
                    q2Var.c(i, i5 == 0 ? c.b.d.j.f3914c : c.b.d.j.h(bArr, A0, i5));
                    return A0 + i5;
                } else {
                    throw n0.i();
                }
            } else if (i4 == 3) {
                q2 b2 = q2.b();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int A02 = A0(bArr, i2, fVar);
                    int i8 = fVar.f3854a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = A02;
                        break;
                    }
                    int w0 = w0(i7, bArr, A02, i3, b2, fVar);
                    i7 = i8;
                    i2 = w0;
                }
                if (i2 > i3 || i7 != i6) {
                    throw n0.g();
                }
                q2Var.c(i, b2);
                return i2;
            } else if (i4 == 5) {
                q2Var.c(i, Integer.valueOf(O(bArr, i2)));
                return i2 + 4;
            } else {
                throw n0.b();
            }
        } else {
            throw n0.b();
        }
    }

    @TargetApi(26)
    public static boolean w1(Context context) {
        if (v1(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (f2494b == null) {
                    f2494b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!f2494b.booleanValue() || n1()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void w2(c.b.c.a.i0.z zVar) {
        o0 o0Var = o0.SHA512;
        c.b.c.a.i0.c0 o = zVar.o();
        o0 p = zVar.p();
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
                } else if (p != o0.SHA384 && p != o0Var) {
                    throw new GeneralSecurityException("Invalid ECDSA parameters");
                }
            } else if (p != o0.SHA256) {
                throw new GeneralSecurityException("Invalid ECDSA parameters");
            }
        } else {
            throw new GeneralSecurityException("unsupported signature encoding");
        }
    }

    public static byte[] x(byte[] bArr) {
        if (bArr.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[bArr.length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static int x0(int i, byte[] bArr, int i2, e eVar) {
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
                                eVar.f3542a = i9;
                                return i10;
                            }
                        }
                    }
                }
            }
            eVar.f3542a = i7 | i4;
            return i8;
        }
        eVar.f3542a = i5 | i3;
        return i6;
    }

    public static int x1(int i, int i2, float f) {
        return b.i.f.a.a(b.i.f.a.c(i2, Math.round(((float) Color.alpha(i2)) * f)), i);
    }

    public static void x2(i1 i1Var) {
        o2(i1Var.n());
    }

    public static e.b.j.c y(e.b.j.d dVar, e.b.h.i iVar) {
        e.b.j.c cVar = new e.b.j.c();
        s2(new e.b.j.a(iVar, cVar, dVar), iVar);
        return cVar;
    }

    public static int y0(int i, byte[] bArr, int i2, c.b.d.f fVar) {
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
                                fVar.f3854a = i9;
                                return i10;
                            }
                        }
                    }
                }
            }
            fVar.f3854a = i7 | i4;
            return i8;
        }
        fVar.f3854a = i5 | i3;
        return i6;
    }

    public static String y1(String str, Object... objArr) {
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

    public static void y2(c.b.c.a.i0.m1 m1Var) {
        o2(m1Var.o());
        if (m1Var.o() != m1Var.n()) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        } else if (m1Var.saltLength_ < 0) {
            throw new GeneralSecurityException("salt length is negative");
        }
    }

    public static int z(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int z0(byte[] bArr, int i, e eVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return x0(b2, bArr, i2, eVar);
        }
        eVar.f3542a = b2;
        return i2;
    }

    public static float z1(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static c.b.a.a.g.h<Void> z2(Collection<? extends c.b.a.a.g.h<?>> collection) {
        if (collection.isEmpty()) {
            return V0(null);
        }
        Iterator<? extends c.b.a.a.g.h<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (((c.b.a.a.g.h) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        c.b.a.a.g.a0 a0Var = new c.b.a.a.g.a0();
        c.b.a.a.g.k kVar = new c.b.a.a.g.k(collection.size(), a0Var);
        Iterator<? extends c.b.a.a.g.h<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            c.b.a.a.g.h hVar = (c.b.a.a.g.h) it2.next();
            hVar.d(c.b.a.a.g.j.f2858b, kVar);
            hVar.c(c.b.a.a.g.j.f2858b, kVar);
            hVar.a(c.b.a.a.g.j.f2858b, kVar);
        }
        return a0Var;
    }
}
