package h.a.k1.p;

import f.a.a.a.a;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public final class d implements HostnameVerifier {
    public static final d a = new d();
    public static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static List<String> a(X509Certificate x509Certificate, int i2) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (!(list == null || list.size() < 2 || (num = (Integer) list.get(0)) == null || num.intValue() != i2 || (str = (String) list.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ea, code lost:
        if (r2.f4454g[r0] != ' ') goto L_0x01ed;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ed, code lost:
        r1 = r2.f4454g;
        r3 = r2.f4451d;
        r0 = new java.lang.String(r1, r3, r2.f4452e - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a4, code lost:
        r14 = f.a.a.a.a.h("Unexpected end of DN: ");
        r14.append(r2.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b6, code lost:
        throw new java.lang.IllegalStateException(r14.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01de, code lost:
        r0 = r0 + 1;
        r2.c = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e4, code lost:
        if (r0 >= r2.b) goto L_0x01ed;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x020b  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean b(String str, X509Certificate x509Certificate) {
        String str2;
        int i2;
        int i3;
        if (b.matcher(str).matches()) {
            List<String> a2 = a(x509Certificate, 7);
            int size = a2.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!str.equalsIgnoreCase(a2.get(i4))) {
                }
            }
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int i5 = 2;
        List<String> a3 = a(x509Certificate, 2);
        int size2 = a3.size();
        int i6 = 0;
        boolean z = false;
        while (i6 < size2) {
            if (!c(lowerCase, a3.get(i6))) {
                i6++;
                z = true;
            }
        }
        if (!z) {
            c cVar = new c(x509Certificate.getSubjectX500Principal());
            cVar.c = 0;
            cVar.f4451d = 0;
            cVar.f4452e = 0;
            cVar.f4453f = 0;
            cVar.f4454g = cVar.a.toCharArray();
            String c = cVar.c();
            if (c != null) {
                while (true) {
                    int i7 = cVar.c;
                    int i8 = cVar.b;
                    if (i7 == i8) {
                        break;
                    }
                    char c2 = cVar.f4454g[i7];
                    if (c2 == '\"') {
                        int i9 = i7 + 1;
                        cVar.c = i9;
                        cVar.f4451d = i9;
                        while (true) {
                            cVar.f4452e = i9;
                            int i10 = cVar.c;
                            if (i10 != cVar.b) {
                                char[] cArr = cVar.f4454g;
                                if (cArr[i10] == '\"') {
                                    break;
                                }
                                if (cArr[i10] == '\\') {
                                    cArr[i9] = cVar.b();
                                } else {
                                    cArr[i9] = cArr[i10];
                                }
                                cVar.c++;
                                i9 = cVar.f4452e + 1;
                            } else {
                                StringBuilder h2 = a.h("Unexpected end of DN: ");
                                h2.append(cVar.a);
                                throw new IllegalStateException(h2.toString());
                            }
                        }
                    } else if (c2 != '#') {
                        if (c2 == '+' || c2 == ',' || c2 == ';') {
                            str2 = "";
                        } else {
                            cVar.f4451d = i7;
                            cVar.f4452e = i7;
                            while (true) {
                                int i11 = cVar.c;
                                if (i11 >= cVar.b) {
                                    char[] cArr2 = cVar.f4454g;
                                    int i12 = cVar.f4451d;
                                    str2 = new String(cArr2, i12, cVar.f4452e - i12);
                                    break;
                                }
                                char[] cArr3 = cVar.f4454g;
                                char c3 = cArr3[i11];
                                if (c3 == ' ') {
                                    int i13 = cVar.f4452e;
                                    cVar.f4453f = i13;
                                    cVar.c = i11 + 1;
                                    cVar.f4452e = i13 + 1;
                                    cArr3[i13] = ' ';
                                    while (true) {
                                        i2 = cVar.c;
                                        i3 = cVar.b;
                                        if (i2 >= i3) {
                                            break;
                                        }
                                        char[] cArr4 = cVar.f4454g;
                                        if (cArr4[i2] != ' ') {
                                            break;
                                        }
                                        int i14 = cVar.f4452e;
                                        cVar.f4452e = i14 + 1;
                                        cArr4[i14] = ' ';
                                        cVar.c = i2 + 1;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    char[] cArr5 = cVar.f4454g;
                                    if (cArr5[i2] == ',' || cArr5[i2] == '+' || cArr5[i2] == ';') {
                                        break;
                                    }
                                } else if (c3 == ';') {
                                    break;
                                } else {
                                    if (c3 != '\\') {
                                        if (c3 == '+' || c3 == ',') {
                                            break;
                                        }
                                        int i15 = cVar.f4452e;
                                        cVar.f4452e = i15 + 1;
                                        cArr3[i15] = cArr3[i11];
                                    } else {
                                        int i16 = cVar.f4452e;
                                        cVar.f4452e = i16 + 1;
                                        cArr3[i16] = cVar.b();
                                        i11 = cVar.c;
                                    }
                                    cVar.c = i11 + 1;
                                }
                            }
                            char[] cArr6 = cVar.f4454g;
                            int i17 = cVar.f4451d;
                            str2 = new String(cArr6, i17, cVar.f4452e - i17);
                        }
                    } else if (i7 + 4 < i8) {
                        cVar.f4451d = i7;
                        while (true) {
                            i7++;
                            cVar.c = i7;
                            if (i7 == cVar.b) {
                                break;
                            }
                            char[] cArr7 = cVar.f4454g;
                            if (cArr7[i7] == '+' || cArr7[i7] == ',' || cArr7[i7] == ';') {
                                break;
                            } else if (cArr7[i7] == ' ') {
                                cVar.f4452e = i7;
                                do {
                                    i7++;
                                    cVar.c = i7;
                                    if (i7 >= cVar.b) {
                                        break;
                                    }
                                } while (cVar.f4454g[i7] == ' ');
                            } else if (cArr7[i7] >= 'A' && cArr7[i7] <= 'F') {
                                cArr7[i7] = (char) (cArr7[i7] + ' ');
                            }
                        }
                        cVar.f4452e = i7;
                        int i18 = cVar.f4452e;
                        int i19 = cVar.f4451d;
                        int i20 = i18 - i19;
                        if (i20 < 5 || (i20 & 1) == 0) {
                            break;
                        }
                        int i21 = i20 / 2;
                        byte[] bArr = new byte[i21];
                        int i22 = i19 + 1;
                        for (int i23 = 0; i23 < i21; i23++) {
                            bArr[i23] = (byte) cVar.a(i22);
                            i22 += i5;
                        }
                        str2 = new String(cVar.f4454g, cVar.f4451d, i20);
                    } else {
                        StringBuilder h3 = a.h("Unexpected end of DN: ");
                        h3.append(cVar.a);
                        throw new IllegalStateException(h3.toString());
                    }
                    if ("cn".equalsIgnoreCase(c)) {
                        break;
                    }
                    int i24 = cVar.c;
                    if (i24 >= cVar.b) {
                        break;
                    }
                    char[] cArr8 = cVar.f4454g;
                    if (cArr8[i24] == ',' || cArr8[i24] == ';' || cArr8[i24] == '+') {
                        cVar.c = i24 + 1;
                        c = cVar.c();
                        if (c != null) {
                            i5 = 2;
                        } else {
                            StringBuilder h4 = a.h("Malformed DN: ");
                            h4.append(cVar.a);
                            throw new IllegalStateException(h4.toString());
                        }
                    } else {
                        StringBuilder h5 = a.h("Malformed DN: ");
                        h5.append(cVar.a);
                        throw new IllegalStateException(h5.toString());
                    }
                }
                if (str2 != null) {
                    return c(lowerCase, str2);
                }
            }
            str2 = null;
            if (str2 != null) {
            }
        }
        return false;
        return true;
    }

    public final boolean c(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = a.t(str, '.');
            }
            if (!str2.endsWith(".")) {
                str2 = a.t(str2, '.');
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return b(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
