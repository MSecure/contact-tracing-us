package e.b.f;

import c.a.b.o;
import c.b.a.a.c.n.c;
import e.b.h.d;
import e.b.h.f;
import e.b.h.i;
import e.b.h.m;
import e.b.h.p;
import e.b.i.g;
import e.b.i.h;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4806a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f4807b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4808a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4809b;

        public a(String str, boolean z) {
            this.f4808a = str;
            this.f4809b = z;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f4806a.matcher(str);
        if (matcher.find()) {
            return e(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static String c() {
        StringBuilder b2 = e.b.g.b.b();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = f4807b;
            b2.append(cArr[random.nextInt(cArr.length)]);
        }
        return e.b.g.b.j(b2);
    }

    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018d, code lost:
        if (r7 == null) goto L_0x019d;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static f d(InputStream inputStream, String str, String str2, g gVar) {
        Object[] objArr;
        a aVar;
        f fVar;
        p pVar;
        if (inputStream == null) {
            return new f(str2);
        }
        char c2 = 32768;
        e.b.g.a a2 = e.b.g.a.a(inputStream, 32768, 0);
        a2.mark(32768);
        ?? r6 = 1;
        c.u1(true, "maxSize must be 0 (unlimited) or larger");
        int i = 5119;
        e.b.g.a a3 = e.b.g.a.a(a2, 32768, 5119);
        if (a3 != null) {
            c.u1(true, "maxSize must be 0 (unlimited) or larger");
            byte[] bArr = new byte[5119];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5119);
            while (true) {
                int read = a3.read(bArr);
                if (read == -1) {
                    break;
                } else if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                } else {
                    i -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                    r6 = r6;
                    c2 = c2;
                }
            }
            ByteBuffer wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            if (a2.read() == -1) {
                Object[] objArr2 = r6 == true ? 1 : 0;
                Object[] objArr3 = r6 == true ? 1 : 0;
                Object[] objArr4 = r6 == true ? 1 : 0;
                objArr = objArr2;
            } else {
                objArr = null;
            }
            a2.reset();
            wrap.mark();
            byte[] bArr2 = new byte[4];
            if (wrap.remaining() >= 4) {
                wrap.get(bArr2);
                wrap.rewind();
            }
            if ((bArr2[0] == 0 && bArr2[r6] == 0 && bArr2[2] == -2 && bArr2[3] == -1) || (bArr2[0] == -1 && bArr2[r6] == -2 && bArr2[2] == 0 && bArr2[3] == 0)) {
                aVar = new a("UTF-32", false);
            } else if ((bArr2[0] == -2 && bArr2[r6] == -1) || (bArr2[0] == -1 && bArr2[r6] == -2)) {
                aVar = new a("UTF-16", false);
            } else {
                if (bArr2[0] == -17) {
                    char c3 = r6 == true ? 1 : 0;
                    char c4 = r6 == true ? 1 : 0;
                    char c5 = r6 == true ? 1 : 0;
                    if (bArr2[c3] == -69 && bArr2[2] == -65) {
                        aVar = new a(o.DEFAULT_PARAMS_ENCODING, r6);
                    }
                }
                aVar = null;
            }
            String str3 = aVar != null ? aVar.f4808a : str;
            if (str3 == null) {
                try {
                    CharBuffer decode = Charset.forName(o.DEFAULT_PARAMS_ENCODING).decode(wrap);
                    if (decode.hasArray()) {
                        fVar = gVar.f4886a.d(new CharArrayReader(decode.array()), str2, gVar);
                    } else {
                        fVar = gVar.f4886a.d(new StringReader(decode.toString()), str2, gVar);
                    }
                    Iterator it = fVar.N("meta[http-equiv=content-type], meta[charset]").iterator();
                    String str4 = null;
                    while (it.hasNext()) {
                        i iVar = (i) it.next();
                        if (iVar.o("http-equiv")) {
                            str4 = b(iVar.c("content"));
                        }
                        if (str4 == null && iVar.o("charset")) {
                            str4 = iVar.c("charset");
                        }
                        if (str4 != null) {
                            break;
                        }
                    }
                    if (str4 == null && fVar.h() > 0) {
                        m g = fVar.g(0);
                        if (g instanceof p) {
                            pVar = (p) g;
                        } else {
                            if (g instanceof d) {
                                d dVar = (d) g;
                                if (dVar.E()) {
                                    pVar = dVar.D();
                                }
                            }
                            pVar = null;
                        }
                        if (pVar != null && pVar.B().equalsIgnoreCase("xml")) {
                            str4 = pVar.c("encoding");
                        }
                    }
                    String e2 = e(str4);
                    if (e2 != null && !e2.equalsIgnoreCase(o.DEFAULT_PARAMS_ENCODING)) {
                        str3 = e2.trim().replaceAll("[\"']", "");
                    }
                } catch (e.b.d e3) {
                    throw ((IOException) e3.getCause());
                }
            } else {
                c.I1(str3, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            }
            fVar = null;
            if (fVar == null) {
                if (str3 == null) {
                    str3 = o.DEFAULT_PARAMS_ENCODING;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a2, str3), 32768);
                if (aVar != null && aVar.f4809b) {
                    c.t1(bufferedReader.skip(1) == 1);
                }
                try {
                    fVar = gVar.f4886a.d(bufferedReader, str2, gVar);
                    Charset forName = Charset.forName(str3);
                    fVar.j.f4835c = forName;
                    if (!forName.canEncode()) {
                        Charset forName2 = Charset.forName(o.DEFAULT_PARAMS_ENCODING);
                        fVar.m = true;
                        f.a aVar2 = fVar.j;
                        aVar2.f4835c = forName2;
                        f.a.EnumC0115a aVar3 = aVar2.i;
                        if (aVar3 == f.a.EnumC0115a.html) {
                            e.b.j.c N = fVar.N("meta[charset]");
                            i iVar2 = N.isEmpty() ? null : (i) N.get(0);
                            if (iVar2 != null) {
                                iVar2.D("charset", fVar.j.f4835c.displayName());
                            } else {
                                i P = fVar.P("head", fVar);
                                if (P != null) {
                                    i iVar3 = new i(h.a("meta", c.N1(P).f4888c), P.f(), null);
                                    P.B(iVar3);
                                    iVar3.D("charset", fVar.j.f4835c.displayName());
                                }
                            }
                            Iterator it2 = fVar.N("meta[name=charset]").iterator();
                            while (it2.hasNext()) {
                                ((i) it2.next()).y();
                            }
                        } else if (aVar3 == f.a.EnumC0115a.xml) {
                            m mVar = fVar.i().get(0);
                            if (mVar instanceof p) {
                                p pVar2 = (p) mVar;
                                if (pVar2.B().equals("xml")) {
                                    pVar2.d("encoding", fVar.j.f4835c.displayName());
                                    if (pVar2.c("version") != null) {
                                        pVar2.d("version", "1.0");
                                    }
                                } else {
                                    p pVar3 = new p("xml", false);
                                    pVar3.d("version", "1.0");
                                    pVar3.d("encoding", fVar.j.f4835c.displayName());
                                    c.J1(pVar3);
                                    fVar.b(0, pVar3);
                                }
                            } else {
                                p pVar4 = new p("xml", false);
                                pVar4.d("version", "1.0");
                                pVar4.d("encoding", fVar.j.f4835c.displayName());
                                c.J1(pVar4);
                                fVar.b(0, pVar4);
                            }
                        }
                    }
                } catch (e.b.d e4) {
                    throw ((IOException) e4.getCause());
                }
            }
            a2.close();
            return fVar;
        }
        throw null;
    }

    public static String e(String str) {
        if (!(str == null || str.length() == 0)) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
