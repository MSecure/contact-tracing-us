package h.a.k1.p.m;

import h.a.c1;
import h.a.j1.q0;
import h.a.j1.v;
import h.a.j1.w;
import h.a.j1.w0;
import h.a.k1.g;
import h.a.k1.h;
import h.a.k1.p.m.b;
import h.a.k1.p.m.e;
import h.a.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e;
import k.g;
import k.h;
import k.s;

public final class f implements i {
    public static final Logger a = Logger.getLogger(b.class.getName());
    public static final h b = h.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class a implements s {
        public final g b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public byte f4026d;

        /* renamed from: e  reason: collision with root package name */
        public int f4027e;

        /* renamed from: f  reason: collision with root package name */
        public int f4028f;

        /* renamed from: g  reason: collision with root package name */
        public short f4029g;

        public a(g gVar) {
            this.b = gVar;
        }

        @Override // k.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // k.s
        public long m(e eVar, long j2) {
            int i2;
            int w;
            do {
                int i3 = this.f4028f;
                if (i3 == 0) {
                    this.b.p((long) this.f4029g);
                    this.f4029g = 0;
                    if ((this.f4026d & 4) != 0) {
                        return -1;
                    }
                    i2 = this.f4027e;
                    int b2 = f.b(this.b);
                    this.f4028f = b2;
                    this.c = b2;
                    byte Q = (byte) (this.b.Q() & 255);
                    this.f4026d = (byte) (this.b.Q() & 255);
                    Logger logger = f.a;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(b.a(true, this.f4027e, this.c, Q, this.f4026d));
                    }
                    w = this.b.w() & Integer.MAX_VALUE;
                    this.f4027e = w;
                    if (Q != 9) {
                        f.a("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(Q)});
                        throw null;
                    }
                } else {
                    long m = this.b.m(eVar, Math.min(j2, (long) i3));
                    if (m == -1) {
                        return -1;
                    }
                    this.f4028f -= (int) m;
                    return m;
                }
            } while (w == i2);
            f.a("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }
    }

    public static final class b {
        public static final String[] a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        public static final String[] b = new String[64];
        public static final String[] c = new String[256];

        static {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String[] strArr = c;
                if (i3 >= strArr.length) {
                    break;
                }
                strArr[i3] = String.format("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
                i3++;
            }
            String[] strArr2 = b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i4 = 0; i4 < 1; i4++) {
                int i5 = iArr[i4];
                String[] strArr3 = b;
                strArr3[i5 | 8] = f.a.a.a.a.e(new StringBuilder(), strArr3[i5], "|PADDED");
            }
            String[] strArr4 = b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr2[i6];
                for (int i8 = 0; i8 < 1; i8++) {
                    int i9 = iArr[i8];
                    String[] strArr5 = b;
                    int i10 = i9 | i7;
                    strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                    StringBuilder sb = new StringBuilder();
                    sb.append(strArr5[i9]);
                    sb.append('|');
                    strArr5[i10 | 8] = f.a.a.a.a.e(sb, strArr5[i7], "|PADDED");
                }
            }
            while (true) {
                String[] strArr6 = b;
                if (i2 < strArr6.length) {
                    if (strArr6[i2] == null) {
                        strArr6[i2] = c[i2];
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
            String str;
            String str2;
            String str3;
            String[] strArr = a;
            String format = b2 < strArr.length ? strArr[b2] : String.format("0x%02x", Byte.valueOf(b2));
            String[] strArr2 = c;
            if (b3 == 0) {
                str = "";
            } else {
                if (!(b2 == 2 || b2 == 3)) {
                    if (b2 == 4 || b2 == 6) {
                        str = b3 == 1 ? "ACK" : strArr2[b3];
                    } else if (!(b2 == 7 || b2 == 8)) {
                        String[] strArr3 = b;
                        String str4 = b3 < strArr3.length ? strArr3[b3] : strArr2[b3];
                        if (b2 == 5 && (b3 & 4) != 0) {
                            str3 = "HEADERS";
                            str2 = "PUSH_PROMISE";
                        } else if (b2 != 0 || (b3 & 32) == 0) {
                            str = str4;
                        } else {
                            str3 = "PRIORITY";
                            str2 = "COMPRESSED";
                        }
                        str = str4.replace(str3, str2);
                    }
                }
                str = strArr2[b3];
            }
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = format;
            objArr[4] = str;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    public static final class c implements b {
        public final g b;
        public final a c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f4030d;

        public c(g gVar, int i2, boolean z) {
            this.b = gVar;
            a aVar = new a(gVar);
            this.c = aVar;
            this.f4030d = new e.a(i2, aVar);
        }

        public final void A(b.a aVar, int i2, byte b2, int i3) {
            short s = 0;
            if (i3 != 0) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.b.Q() & 255);
                }
                int w = this.b.w() & Integer.MAX_VALUE;
                List<d> d2 = d(f.c(i2 - 4, b2, s), s, b2, i3);
                g.e eVar = (g.e) aVar;
                h.a.k1.h hVar = eVar.b;
                h.a aVar2 = h.a.INBOUND;
                if (hVar.a()) {
                    Logger logger = hVar.a;
                    Level level = hVar.b;
                    logger.log(level, aVar2 + " PUSH_PROMISE: streamId=" + i3 + " promisedStreamId=" + w + " headers=" + d2);
                }
                synchronized (h.a.k1.g.this.f3938j) {
                    h.a.k1.g.this.f3936h.T(i3, a.PROTOCOL_ERROR);
                }
                return;
            }
            f.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }

        public final void N(b.a aVar, int i2, int i3) {
            if (i2 != 4) {
                f.a("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i2)});
                throw null;
            } else if (i3 != 0) {
                int w = this.b.w();
                a a = a.a(w);
                if (a != null) {
                    g.e eVar = (g.e) aVar;
                    eVar.b.e(h.a.INBOUND, i3, a);
                    c1 a2 = h.a.k1.g.z(a).a("Rst Stream");
                    c1.b bVar = a2.a;
                    boolean z = bVar == c1.b.CANCELLED || bVar == c1.b.DEADLINE_EXCEEDED;
                    synchronized (h.a.k1.g.this.f3938j) {
                        h.a.k1.f fVar = h.a.k1.g.this.m.get(Integer.valueOf(i3));
                        if (fVar != null) {
                            h.b.d dVar = fVar.m.K;
                            Objects.requireNonNull(h.b.c.a);
                            h.a.k1.g.this.k(i3, a2, a == a.REFUSED_STREAM ? v.a.REFUSED : v.a.PROCESSED, z, null, null);
                        }
                    }
                    return;
                }
                f.a("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(w)});
                throw null;
            } else {
                f.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
                throw null;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void P(b.a aVar, int i2, byte b2, int i3) {
            int w;
            if (i3 != 0) {
                f.a("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            } else if ((b2 & 1) != 0) {
                if (i2 == 0) {
                    Objects.requireNonNull((g.e) aVar);
                } else {
                    f.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    throw null;
                }
            } else if (i2 % 6 == 0) {
                h hVar = new h();
                int i4 = 0;
                while (true) {
                    short s = 7;
                    if (i4 < i2) {
                        short r = this.b.r();
                        w = this.b.w();
                        switch (r) {
                            case 1:
                            case 6:
                                s = r;
                                break;
                            case 2:
                                if (!(w == 0 || w == 1)) {
                                    f.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    throw null;
                                }
                                s = r;
                                break;
                            case 3:
                                s = 4;
                                break;
                            case 4:
                                if (w < 0) {
                                    f.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    throw null;
                                }
                                break;
                            case 5:
                                if (w < 16384 || w > 16777215) {
                                    f.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(w)});
                                    break;
                                }
                                s = r;
                                break;
                            default:
                                i4 += 6;
                        }
                        hVar.b(s, 0, w);
                        i4 += 6;
                    } else {
                        g.e eVar = (g.e) aVar;
                        eVar.b.f(h.a.INBOUND, hVar);
                        synchronized (h.a.k1.g.this.f3938j) {
                            if (hVar.a(4)) {
                                h.a.k1.g.this.B = hVar.f4036d[4];
                            }
                            boolean c2 = hVar.a(7) ? h.a.k1.g.this.f3937i.c(hVar.f4036d[7]) : false;
                            if (eVar.f3943d) {
                                h.a.k1.g.this.f3935g.b();
                                eVar.f3943d = false;
                            }
                            h.a.k1.g.this.f3936h.e(hVar);
                            if (c2) {
                                h.a.k1.g.this.f3937i.f();
                            }
                            h.a.k1.g.this.w();
                        }
                        int i5 = hVar.a & 2;
                        int i6 = -1;
                        if ((i5 != 0 ? hVar.f4036d[1] : -1) >= 0) {
                            e.a aVar2 = this.f4030d;
                            if (i5 != 0) {
                                i6 = hVar.f4036d[1];
                            }
                            aVar2.c = i6;
                            aVar2.f4018d = i6;
                            int i7 = aVar2.f4022h;
                            if (i6 >= i7) {
                                return;
                            }
                            if (i6 == 0) {
                                aVar2.a();
                                return;
                            } else {
                                aVar2.c(i7 - i6);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                f.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(w)});
                throw null;
            } else {
                f.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i2)});
                throw null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a1, code lost:
            r9 = h.a.k1.g.this;
            r10 = "Received window_update for unknown stream: " + r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        public final void V(b.a aVar, int i2, int i3) {
            h.a.k1.g gVar;
            String str;
            boolean z = true;
            if (i2 == 4) {
                long w = ((long) this.b.w()) & 2147483647L;
                int i4 = (w > 0 ? 1 : (w == 0 ? 0 : -1));
                if (i4 != 0) {
                    g.e eVar = (g.e) aVar;
                    a aVar2 = a.PROTOCOL_ERROR;
                    eVar.b.g(h.a.INBOUND, i3, w);
                    if (i4 == 0) {
                        str = "Received 0 flow control window increment.";
                        gVar = h.a.k1.g.this;
                        if (i3 != 0) {
                            c1 g2 = c1.m.g(str);
                            v.a aVar3 = v.a.PROCESSED;
                            synchronized (gVar.f3938j) {
                                h.a.k1.f remove = gVar.m.remove(Integer.valueOf(i3));
                                if (remove != null) {
                                    gVar.f3936h.T(i3, a.CANCEL);
                                    remove.m.i(g2, aVar3, false, new n0());
                                    if (!gVar.w()) {
                                        gVar.y();
                                        gVar.r(remove);
                                    }
                                }
                            }
                            return;
                        }
                    } else {
                        synchronized (h.a.k1.g.this.f3938j) {
                            if (i3 == 0) {
                                h.a.k1.g.this.f3937i.e(null, (int) w);
                                return;
                            }
                            h.a.k1.f fVar = h.a.k1.g.this.m.get(Integer.valueOf(i3));
                            if (fVar != null) {
                                h.a.k1.g.this.f3937i.e(fVar, (int) w);
                            } else if (!h.a.k1.g.this.q(i3)) {
                            }
                            z = false;
                        }
                    }
                    h.a.k1.g.i(gVar, aVar2, str);
                    return;
                }
                f.a("windowSizeIncrement was 0", new Object[0]);
                throw null;
            }
            f.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i2)});
            throw null;
        }

        public boolean c(b.a aVar) {
            c1 c1Var;
            a aVar2 = a.INVALID_STREAM;
            a aVar3 = a.PROTOCOL_ERROR;
            h.a aVar4 = h.a.INBOUND;
            boolean z = false;
            try {
                this.b.G(9);
                int b2 = f.b(this.b);
                c1 c1Var2 = null;
                if (b2 < 0 || b2 > 16384) {
                    f.a("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(b2)});
                    throw null;
                }
                byte Q = (byte) (this.b.Q() & 255);
                byte Q2 = (byte) (this.b.Q() & 255);
                int w = this.b.w() & Integer.MAX_VALUE;
                Logger logger = f.a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(b.a(true, w, b2, Q, Q2));
                }
                switch (Q) {
                    case 0:
                        boolean z2 = (Q2 & 1) != 0;
                        if (!((Q2 & 32) != 0)) {
                            short Q3 = (Q2 & 8) != 0 ? (short) (this.b.Q() & 255) : 0;
                            int c2 = f.c(b2, Q2, Q3);
                            k.g gVar = this.b;
                            g.e eVar = (g.e) aVar;
                            eVar.b.b(aVar4, w, gVar.l(), c2, z2);
                            h.a.k1.f p = h.a.k1.g.this.p(w);
                            if (p != null) {
                                long j2 = (long) c2;
                                gVar.G(j2);
                                k.e eVar2 = new k.e();
                                eVar2.h(gVar.l(), j2);
                                h.b.d dVar = p.m.K;
                                Objects.requireNonNull(h.b.c.a);
                                synchronized (h.a.k1.g.this.f3938j) {
                                    p.m.o(eVar2, z2);
                                }
                            } else if (h.a.k1.g.this.q(w)) {
                                synchronized (h.a.k1.g.this.f3938j) {
                                    h.a.k1.g.this.f3936h.T(w, aVar2);
                                }
                                gVar.p((long) c2);
                            } else {
                                h.a.k1.g.i(h.a.k1.g.this, aVar3, "Received data for unknown stream: " + w);
                                this.b.p((long) Q3);
                                return true;
                            }
                            h.a.k1.g gVar2 = h.a.k1.g.this;
                            int i2 = gVar2.q + c2;
                            gVar2.q = i2;
                            if (((float) i2) >= ((float) gVar2.f3934f) * 0.5f) {
                                synchronized (gVar2.f3938j) {
                                    h.a.k1.g gVar3 = h.a.k1.g.this;
                                    gVar3.f3936h.u(0, (long) gVar3.q);
                                }
                                h.a.k1.g.this.q = 0;
                            }
                            this.b.p((long) Q3);
                            return true;
                        }
                        f.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        throw null;
                    case 1:
                        if (w != 0) {
                            boolean z3 = (Q2 & 1) != 0;
                            short Q4 = (Q2 & 8) != 0 ? (short) (this.b.Q() & 255) : 0;
                            if ((Q2 & 32) != 0) {
                                this.b.w();
                                this.b.Q();
                                g.e eVar3 = (g.e) aVar;
                                b2 -= 5;
                            }
                            List<d> d2 = d(f.c(b2, Q2, Q4), Q4, Q2, w);
                            g.e eVar4 = (g.e) aVar;
                            h.a.k1.h hVar = eVar4.b;
                            if (hVar.a()) {
                                hVar.a.log(hVar.b, aVar4 + " HEADERS: streamId=" + w + " headers=" + d2 + " endStream=" + z3);
                            }
                            if (h.a.k1.g.this.L != Integer.MAX_VALUE) {
                                int i3 = 0;
                                long j3 = 0;
                                while (true) {
                                    ArrayList arrayList = (ArrayList) d2;
                                    if (i3 < arrayList.size()) {
                                        d dVar2 = (d) arrayList.get(i3);
                                        j3 += (long) (dVar2.b.l() + dVar2.a.l() + 32);
                                        i3++;
                                    } else {
                                        int min = (int) Math.min(j3, 2147483647L);
                                        int i4 = h.a.k1.g.this.L;
                                        if (min > i4) {
                                            c1 c1Var3 = c1.f3619l;
                                            Object[] objArr = new Object[3];
                                            objArr[0] = z3 ? "trailer" : "header";
                                            objArr[1] = Integer.valueOf(i4);
                                            objArr[2] = Integer.valueOf(min);
                                            c1Var2 = c1Var3.g(String.format("Response %s metadata larger than %d: %d", objArr));
                                        }
                                    }
                                }
                            }
                            synchronized (h.a.k1.g.this.f3938j) {
                                h.a.k1.f fVar = h.a.k1.g.this.m.get(Integer.valueOf(w));
                                if (fVar == null) {
                                    if (h.a.k1.g.this.q(w)) {
                                        h.a.k1.g.this.f3936h.T(w, aVar2);
                                    } else {
                                        z = true;
                                    }
                                } else if (c1Var2 == null) {
                                    h.b.d dVar3 = fVar.m.K;
                                    Objects.requireNonNull(h.b.c.a);
                                    fVar.m.p(d2, z3);
                                } else {
                                    if (!z3) {
                                        h.a.k1.g.this.f3936h.T(w, a.CANCEL);
                                    }
                                    fVar.m.i(c1Var2, v.a.PROCESSED, false, new n0());
                                }
                            }
                            if (!z) {
                                return true;
                            }
                            h.a.k1.g.i(h.a.k1.g.this, aVar3, "Received header for unknown stream: " + w);
                            return true;
                        }
                        f.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        throw null;
                    case 2:
                        if (b2 != 5) {
                            f.a("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(b2)});
                            throw null;
                        } else if (w != 0) {
                            this.b.w();
                            this.b.Q();
                            g.e eVar5 = (g.e) aVar;
                            return true;
                        } else {
                            f.a("TYPE_PRIORITY streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 3:
                        N(aVar, b2, w);
                        return true;
                    case 4:
                        P(aVar, b2, Q2, w);
                        return true;
                    case 5:
                        A(aVar, b2, Q2, w);
                        return true;
                    case 6:
                        v(aVar, b2, Q2, w);
                        return true;
                    case 7:
                        if (b2 < 8) {
                            f.a("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(b2)});
                            throw null;
                        } else if (w == 0) {
                            int w2 = this.b.w();
                            int w3 = this.b.w();
                            int i5 = b2 - 8;
                            a a = a.a(w3);
                            if (a != null) {
                                k.h hVar2 = k.h.f4111f;
                                if (i5 > 0) {
                                    hVar2 = this.b.n((long) i5);
                                }
                                g.e eVar6 = (g.e) aVar;
                                eVar6.b.c(aVar4, w2, a, hVar2);
                                if (a == a.ENHANCE_YOUR_CALM) {
                                    String q = hVar2.q();
                                    h.a.k1.g.R.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", eVar6, q));
                                    if ("too_many_pings".equals(q)) {
                                        h.a.k1.g.this.K.run();
                                    }
                                }
                                long j4 = (long) a.b;
                                q0.g[] gVarArr = q0.g.r;
                                q0.g gVar4 = (j4 >= ((long) gVarArr.length) || j4 < 0) ? null : gVarArr[(int) j4];
                                if (gVar4 == null) {
                                    c1Var = c1.c(q0.g.INTERNAL_ERROR.c.a.b).g("Unrecognized HTTP/2 error code: " + j4);
                                } else {
                                    c1Var = gVar4.c;
                                }
                                c1 a2 = c1Var.a("Received Goaway");
                                if (hVar2.l() > 0) {
                                    a2 = a2.a(hVar2.q());
                                }
                                h.a.k1.g gVar5 = h.a.k1.g.this;
                                Map<a, c1> map = h.a.k1.g.Q;
                                gVar5.v(w2, null, a2);
                                return true;
                            }
                            f.a("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(w3)});
                            throw null;
                        } else {
                            f.a("TYPE_GOAWAY streamId != 0", new Object[0]);
                            throw null;
                        }
                    case 8:
                        V(aVar, b2, w);
                        return true;
                    default:
                        this.b.p((long) b2);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.b.close();
        }

        public final List<d> d(int i2, short s, byte b2, int i3) {
            a aVar = this.c;
            aVar.f4028f = i2;
            aVar.c = i2;
            aVar.f4029g = s;
            aVar.f4026d = b2;
            aVar.f4027e = i3;
            e.a aVar2 = this.f4030d;
            while (!aVar2.b.J()) {
                int Q = aVar2.b.Q() & 255;
                if (Q == 128) {
                    throw new IOException("index == 0");
                } else if ((Q & 128) == 128) {
                    int g2 = aVar2.g(Q, 127) - 1;
                    if (g2 >= 0 && g2 <= e.b.length + -1) {
                        aVar2.a.add(e.b[g2]);
                    } else {
                        int b3 = aVar2.b(g2 - e.b.length);
                        if (b3 >= 0) {
                            d[] dVarArr = aVar2.f4019e;
                            if (b3 <= dVarArr.length - 1) {
                                aVar2.a.add(dVarArr[b3]);
                            }
                        }
                        StringBuilder h2 = f.a.a.a.a.h("Header index too large ");
                        h2.append(g2 + 1);
                        throw new IOException(h2.toString());
                    }
                } else if (Q == 64) {
                    k.h f2 = aVar2.f();
                    e.a(f2);
                    aVar2.e(-1, new d(f2, aVar2.f()));
                } else if ((Q & 64) == 64) {
                    aVar2.e(-1, new d(aVar2.d(aVar2.g(Q, 63) - 1), aVar2.f()));
                } else if ((Q & 32) == 32) {
                    int g3 = aVar2.g(Q, 31);
                    aVar2.f4018d = g3;
                    if (g3 < 0 || g3 > aVar2.c) {
                        StringBuilder h3 = f.a.a.a.a.h("Invalid dynamic table size update ");
                        h3.append(aVar2.f4018d);
                        throw new IOException(h3.toString());
                    }
                    int i4 = aVar2.f4022h;
                    if (g3 < i4) {
                        if (g3 == 0) {
                            aVar2.a();
                        } else {
                            aVar2.c(i4 - g3);
                        }
                    }
                } else if (Q == 16 || Q == 0) {
                    k.h f3 = aVar2.f();
                    e.a(f3);
                    aVar2.a.add(new d(f3, aVar2.f()));
                } else {
                    aVar2.a.add(new d(aVar2.d(aVar2.g(Q, 15) - 1), aVar2.f()));
                }
            }
            e.a aVar3 = this.f4030d;
            Objects.requireNonNull(aVar3);
            ArrayList arrayList = new ArrayList(aVar3.a);
            aVar3.a.clear();
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
            r12 = r13.entrySet().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
            if (r12.hasNext() == false) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a6, code lost:
            r13 = r12.next();
            h.a.j1.w0.a(r13.getValue(), new h.a.j1.u0(r13.getKey(), r10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        public final void v(b.a aVar, int i2, byte b2, int i3) {
            w0 w0Var;
            if (i2 != 8) {
                f.a("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i2)});
                throw null;
            } else if (i3 == 0) {
                int w = this.b.w();
                int w2 = this.b.w();
                boolean z = (b2 & 1) != 0;
                g.e eVar = (g.e) aVar;
                long j2 = (((long) w) << 32) | (((long) w2) & 4294967295L);
                eVar.b.d(h.a.INBOUND, j2);
                if (!z) {
                    synchronized (h.a.k1.g.this.f3938j) {
                        h.a.k1.g.this.f3936h.C(true, w, w2);
                    }
                    return;
                }
                synchronized (h.a.k1.g.this.f3938j) {
                    h.a.k1.g gVar = h.a.k1.g.this;
                    w0Var = gVar.v;
                    if (w0Var != null) {
                        long j3 = w0Var.a;
                        if (j3 == j2) {
                            gVar.v = null;
                        } else {
                            h.a.k1.g.R.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(j3), Long.valueOf(j2)));
                        }
                    } else {
                        h.a.k1.g.R.warning("Received unexpected ping ack. No ping outstanding");
                    }
                    w0Var = null;
                }
                if (w0Var != null) {
                    synchronized (w0Var) {
                        if (!w0Var.f3864d) {
                            w0Var.f3864d = true;
                            long a = w0Var.b.a(TimeUnit.NANOSECONDS);
                            w0Var.f3866f = a;
                            Map<w.a, Executor> map = w0Var.c;
                            w0Var.c = null;
                        }
                    }
                }
            } else {
                f.a("TYPE_PING streamId != 0", new Object[0]);
                throw null;
            }
        }
    }

    public static final class d implements c {
        public final k.f b;
        public final boolean c;

        /* renamed from: d  reason: collision with root package name */
        public final k.e f4031d;

        /* renamed from: e  reason: collision with root package name */
        public final e.b f4032e;

        /* renamed from: f  reason: collision with root package name */
        public int f4033f = 16384;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4034g;

        public d(k.f fVar, boolean z) {
            this.b = fVar;
            this.c = z;
            k.e eVar = new k.e();
            this.f4031d = eVar;
            this.f4032e = new e.b(eVar);
        }

        @Override // h.a.k1.p.m.c
        public synchronized void C(boolean z, int i2, int i3) {
            if (!this.f4034g) {
                c(0, 8, (byte) 6, z ? (byte) 1 : 0);
                this.b.x(i2);
                this.b.x(i3);
                this.b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public int D() {
            return this.f4033f;
        }

        @Override // h.a.k1.p.m.c
        public synchronized void F(boolean z, boolean z2, int i2, int i3, List<d> list) {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (!this.f4034g) {
                d(z, i2, list);
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void L() {
            if (this.f4034g) {
                throw new IOException("closed");
            } else if (this.c) {
                Logger logger = f.a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format(">> CONNECTION %s", f.b.e()));
                }
                this.b.a(f.b.o());
                this.b.flush();
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void R(int i2, a aVar, byte[] bArr) {
            if (this.f4034g) {
                throw new IOException("closed");
            } else if (aVar.b != -1) {
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.b.x(i2);
                this.b.x(aVar.b);
                if (bArr.length > 0) {
                    this.b.a(bArr);
                }
                this.b.flush();
            } else {
                f.d("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void T(int i2, a aVar) {
            if (this.f4034g) {
                throw new IOException("closed");
            } else if (aVar.b != -1) {
                c(i2, 4, (byte) 3, (byte) 0);
                this.b.x(aVar.b);
                this.b.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void c(int i2, int i3, byte b2, byte b3) {
            Logger logger = f.a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(b.a(false, i2, i3, b2, b3));
            }
            int i4 = this.f4033f;
            if (i3 > i4) {
                f.d("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                throw null;
            } else if ((Integer.MIN_VALUE & i2) == 0) {
                k.f fVar = this.b;
                fVar.K((i3 >>> 16) & 255);
                fVar.K((i3 >>> 8) & 255);
                fVar.K(i3 & 255);
                this.b.K(b2 & 255);
                this.b.K(b3 & 255);
                this.b.x(i2 & Integer.MAX_VALUE);
            } else {
                f.d("reserved bit set: %s", new Object[]{Integer.valueOf(i2)});
                throw null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f4034g = true;
            this.b.close();
        }

        public void d(boolean z, int i2, List<d> list) {
            int i3;
            int i4;
            if (!this.f4034g) {
                e.b bVar = this.f4032e;
                Objects.requireNonNull(bVar);
                int size = list.size();
                int i5 = 0;
                while (true) {
                    int i6 = 1;
                    if (i5 >= size) {
                        break;
                    }
                    d dVar = list.get(i5);
                    k.h n = dVar.a.n();
                    k.h hVar = dVar.b;
                    Integer num = e.c.get(n);
                    if (num != null) {
                        i4 = num.intValue() + 1;
                        if (i4 >= 2 && i4 <= 7) {
                            d[] dVarArr = e.b;
                            if (dVarArr[i4 - 1].b.equals(hVar)) {
                                i3 = i4;
                            } else if (dVarArr[i4].b.equals(hVar)) {
                                i3 = i4;
                                i4++;
                            }
                        }
                        i3 = i4;
                        i4 = -1;
                    } else {
                        i4 = -1;
                        i3 = -1;
                    }
                    if (i4 == -1) {
                        int i7 = bVar.f4024e;
                        while (true) {
                            i7 += i6;
                            d[] dVarArr2 = bVar.c;
                            if (i7 >= dVarArr2.length) {
                                break;
                            }
                            if (dVarArr2[i7].a.equals(n)) {
                                if (bVar.c[i7].b.equals(hVar)) {
                                    i4 = e.b.length + (i7 - bVar.f4024e);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i7 - bVar.f4024e) + e.b.length;
                                }
                            }
                            i6 = 1;
                        }
                    }
                    if (i4 != -1) {
                        bVar.c(i4, 127, 128);
                    } else {
                        if (i3 == -1) {
                            bVar.a.b0(64);
                            bVar.b(n);
                        } else {
                            k.h hVar2 = e.a;
                            Objects.requireNonNull(n);
                            if (!n.h(0, hVar2, 0, hVar2.l()) || d.f4017h.equals(n)) {
                                bVar.c(i3, 63, 64);
                            } else {
                                bVar.c(i3, 15, 0);
                                bVar.b(hVar);
                            }
                        }
                        bVar.b(hVar);
                        bVar.a(dVar);
                    }
                    i5++;
                }
                long j2 = this.f4031d.c;
                int min = (int) Math.min((long) this.f4033f, j2);
                long j3 = (long) min;
                int i8 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                byte b2 = i8 == 0 ? (byte) 4 : 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                c(i2, min, (byte) 1, b2);
                this.b.h(this.f4031d, j3);
                if (i8 > 0) {
                    long j4 = j2 - j3;
                    while (j4 > 0) {
                        int min2 = (int) Math.min((long) this.f4033f, j4);
                        long j5 = (long) min2;
                        j4 -= j5;
                        c(i2, min2, (byte) 9, j4 == 0 ? (byte) 4 : 0);
                        this.b.h(this.f4031d, j5);
                    }
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // h.a.k1.p.m.c
        public synchronized void e(h hVar) {
            if (!this.f4034g) {
                int i2 = this.f4033f;
                if ((hVar.a & 32) != 0) {
                    i2 = hVar.f4036d[5];
                }
                this.f4033f = i2;
                c(0, 0, (byte) 4, (byte) 1);
                this.b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void flush() {
            if (!this.f4034g) {
                this.b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void i(boolean z, int i2, k.e eVar, int i3) {
            if (!this.f4034g) {
                c(i2, i3, (byte) 0, z ? (byte) 1 : 0);
                if (i3 > 0) {
                    this.b.h(eVar, (long) i3);
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void o(h hVar) {
            if (!this.f4034g) {
                int i2 = 0;
                c(0, Integer.bitCount(hVar.a) * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (hVar.a(i2)) {
                        this.b.s(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                        this.b.x(hVar.f4036d[i2]);
                    }
                    i2++;
                }
                this.b.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // h.a.k1.p.m.c
        public synchronized void u(int i2, long j2) {
            if (this.f4034g) {
                throw new IOException("closed");
            } else if (j2 == 0 || j2 > 2147483647L) {
                f.d("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j2)});
                throw null;
            } else {
                c(i2, 4, (byte) 8, (byte) 0);
                this.b.x((int) j2);
                this.b.flush();
            }
        }
    }

    public static IOException a(String str, Object[] objArr) {
        throw new IOException(String.format(str, objArr));
    }

    public static int b(k.g gVar) {
        return (gVar.Q() & 255) | ((gVar.Q() & 255) << 16) | ((gVar.Q() & 255) << 8);
    }

    public static int c(int i2, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw new IOException(String.format("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2)));
    }

    public static IllegalArgumentException d(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public b e(k.g gVar, boolean z) {
        return new c(gVar, 4096, z);
    }
}
