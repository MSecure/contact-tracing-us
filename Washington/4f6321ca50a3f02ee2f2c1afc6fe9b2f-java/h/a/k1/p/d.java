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

public final class d implements HostnameVerifier {
    public static final d a = new d();
    public static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static List<String> a(X509Certificate x509Certificate, int i2) {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null) {
                    if (list.size() >= 2) {
                        Integer num = (Integer) list.get(0);
                        if (num != null) {
                            if (num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                                arrayList.add(str);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0121, code lost:
        r1 = r2.f3884g;
        r3 = r2.f3881d;
        r0 = new java.lang.String(r1, r3, r2.f3883f - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b6, code lost:
        throw new java.lang.IllegalStateException(r14.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x020b  */
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
            cVar.f3881d = 0;
            cVar.f3882e = 0;
            cVar.f3883f = 0;
            cVar.f3884g = cVar.a.toCharArray();
            String c = cVar.c();
            if (c != null) {
                while (true) {
                    int i7 = cVar.c;
                    int i8 = cVar.b;
                    if (i7 == i8) {
                        break;
                    }
                    char c2 = cVar.f3884g[i7];
                    if (c2 == '\"') {
                        int i9 = i7 + 1;
                        cVar.c = i9;
                        cVar.f3881d = i9;
                        while (true) {
                            cVar.f3882e = i9;
                            int i10 = cVar.c;
                            if (i10 != cVar.b) {
                                char[] cArr = cVar.f3884g;
                                if (cArr[i10] == '\"') {
                                    do {
                                        i10++;
                                        cVar.c = i10;
                                        if (i10 >= cVar.b) {
                                            break;
                                        }
                                    } while (cVar.f3884g[i10] == ' ');
                                    char[] cArr2 = cVar.f3884g;
                                    int i11 = cVar.f3881d;
                                    str2 = new String(cArr2, i11, cVar.f3882e - i11);
                                } else {
                                    if (cArr[i10] == '\\') {
                                        cArr[i9] = cVar.b();
                                    } else {
                                        cArr[i9] = cArr[i10];
                                    }
                                    cVar.c++;
                                    i9 = cVar.f3882e + 1;
                                }
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
                            cVar.f3881d = i7;
                            cVar.f3882e = i7;
                            while (true) {
                                int i12 = cVar.c;
                                if (i12 >= cVar.b) {
                                    char[] cArr3 = cVar.f3884g;
                                    int i13 = cVar.f3881d;
                                    str2 = new String(cArr3, i13, cVar.f3882e - i13);
                                    break;
                                }
                                char[] cArr4 = cVar.f3884g;
                                char c3 = cArr4[i12];
                                if (c3 == ' ') {
                                    int i14 = cVar.f3882e;
                                    cVar.f3883f = i14;
                                    cVar.c = i12 + 1;
                                    cVar.f3882e = i14 + 1;
                                    cArr4[i14] = ' ';
                                    while (true) {
                                        i2 = cVar.c;
                                        i3 = cVar.b;
                                        if (i2 >= i3) {
                                            break;
                                        }
                                        char[] cArr5 = cVar.f3884g;
                                        if (cArr5[i2] != ' ') {
                                            break;
                                        }
                                        int i15 = cVar.f3882e;
                                        cVar.f3882e = i15 + 1;
                                        cArr5[i15] = ' ';
                                        cVar.c = i2 + 1;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    char[] cArr6 = cVar.f3884g;
                                    if (cArr6[i2] == ',' || cArr6[i2] == '+' || cArr6[i2] == ';') {
                                        break;
                                    }
                                } else if (c3 == ';') {
                                    break;
                                } else {
                                    if (c3 != '\\') {
                                        if (c3 == '+' || c3 == ',') {
                                            break;
                                        }
                                        int i16 = cVar.f3882e;
                                        cVar.f3882e = i16 + 1;
                                        cArr4[i16] = cArr4[i12];
                                    } else {
                                        int i17 = cVar.f3882e;
                                        cVar.f3882e = i17 + 1;
                                        cArr4[i17] = cVar.b();
                                        i12 = cVar.c;
                                    }
                                    cVar.c = i12 + 1;
                                }
                            }
                            char[] cArr7 = cVar.f3884g;
                            int i18 = cVar.f3881d;
                            str2 = new String(cArr7, i18, cVar.f3882e - i18);
                        }
                    } else if (i7 + 4 < i8) {
                        cVar.f3881d = i7;
                        while (true) {
                            i7++;
                            cVar.c = i7;
                            if (i7 == cVar.b) {
                                break;
                            }
                            char[] cArr8 = cVar.f3884g;
                            if (cArr8[i7] == '+' || cArr8[i7] == ',' || cArr8[i7] == ';') {
                                break;
                            } else if (cArr8[i7] == ' ') {
                                cVar.f3882e = i7;
                                do {
                                    i7++;
                                    cVar.c = i7;
                                    if (i7 >= cVar.b) {
                                        break;
                                    }
                                } while (cVar.f3884g[i7] == ' ');
                            } else if (cArr8[i7] >= 'A' && cArr8[i7] <= 'F') {
                                cArr8[i7] = (char) (cArr8[i7] + ' ');
                            }
                        }
                        cVar.f3882e = i7;
                        int i19 = cVar.f3882e;
                        int i20 = cVar.f3881d;
                        int i21 = i19 - i20;
                        if (i21 < 5 || (i21 & 1) == 0) {
                            StringBuilder h3 = a.h("Unexpected end of DN: ");
                            h3.append(cVar.a);
                        } else {
                            int i22 = i21 / 2;
                            byte[] bArr = new byte[i22];
                            int i23 = i20 + 1;
                            for (int i24 = 0; i24 < i22; i24++) {
                                bArr[i24] = (byte) cVar.a(i23);
                                i23 += i5;
                            }
                            str2 = new String(cVar.f3884g, cVar.f3881d, i21);
                        }
                    } else {
                        StringBuilder h4 = a.h("Unexpected end of DN: ");
                        h4.append(cVar.a);
                        throw new IllegalStateException(h4.toString());
                    }
                    if ("cn".equalsIgnoreCase(c)) {
                        break;
                    }
                    int i25 = cVar.c;
                    if (i25 >= cVar.b) {
                        break;
                    }
                    char[] cArr9 = cVar.f3884g;
                    if (cArr9[i25] == ',' || cArr9[i25] == ';' || cArr9[i25] == '+') {
                        cVar.c = i25 + 1;
                        c = cVar.c();
                        if (c != null) {
                            i5 = 2;
                        } else {
                            StringBuilder h5 = a.h("Malformed DN: ");
                            h5.append(cVar.a);
                            throw new IllegalStateException(h5.toString());
                        }
                    } else {
                        StringBuilder h6 = a.h("Malformed DN: ");
                        h6.append(cVar.a);
                        throw new IllegalStateException(h6.toString());
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
                str = a.p(str, '.');
            }
            if (!str2.endsWith(".")) {
                str2 = a.p(str2, '.');
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

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return b(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
