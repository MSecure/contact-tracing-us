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
        r1 = r2.f4134g;
        r3 = r2.f4131d;
        r0 = new java.lang.String(r1, r3, r2.f4133f - r3);
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
            cVar.f4131d = 0;
            cVar.f4132e = 0;
            cVar.f4133f = 0;
            cVar.f4134g = cVar.a.toCharArray();
            String c = cVar.c();
            if (c != null) {
                while (true) {
                    int i7 = cVar.c;
                    int i8 = cVar.b;
                    if (i7 == i8) {
                        break;
                    }
                    char c2 = cVar.f4134g[i7];
                    if (c2 == '\"') {
                        int i9 = i7 + 1;
                        cVar.c = i9;
                        cVar.f4131d = i9;
                        while (true) {
                            cVar.f4132e = i9;
                            int i10 = cVar.c;
                            if (i10 != cVar.b) {
                                char[] cArr = cVar.f4134g;
                                if (cArr[i10] == '\"') {
                                    do {
                                        i10++;
                                        cVar.c = i10;
                                        if (i10 >= cVar.b) {
                                            break;
                                        }
                                    } while (cVar.f4134g[i10] == ' ');
                                    char[] cArr2 = cVar.f4134g;
                                    int i11 = cVar.f4131d;
                                    str2 = new String(cArr2, i11, cVar.f4132e - i11);
                                } else {
                                    if (cArr[i10] == '\\') {
                                        cArr[i9] = cVar.b();
                                    } else {
                                        cArr[i9] = cArr[i10];
                                    }
                                    cVar.c++;
                                    i9 = cVar.f4132e + 1;
                                }
                            } else {
                                StringBuilder i12 = a.i("Unexpected end of DN: ");
                                i12.append(cVar.a);
                                throw new IllegalStateException(i12.toString());
                            }
                        }
                    } else if (c2 != '#') {
                        if (c2 == '+' || c2 == ',' || c2 == ';') {
                            str2 = "";
                        } else {
                            cVar.f4131d = i7;
                            cVar.f4132e = i7;
                            while (true) {
                                int i13 = cVar.c;
                                if (i13 >= cVar.b) {
                                    char[] cArr3 = cVar.f4134g;
                                    int i14 = cVar.f4131d;
                                    str2 = new String(cArr3, i14, cVar.f4132e - i14);
                                    break;
                                }
                                char[] cArr4 = cVar.f4134g;
                                char c3 = cArr4[i13];
                                if (c3 == ' ') {
                                    int i15 = cVar.f4132e;
                                    cVar.f4133f = i15;
                                    cVar.c = i13 + 1;
                                    cVar.f4132e = i15 + 1;
                                    cArr4[i15] = ' ';
                                    while (true) {
                                        i2 = cVar.c;
                                        i3 = cVar.b;
                                        if (i2 >= i3) {
                                            break;
                                        }
                                        char[] cArr5 = cVar.f4134g;
                                        if (cArr5[i2] != ' ') {
                                            break;
                                        }
                                        int i16 = cVar.f4132e;
                                        cVar.f4132e = i16 + 1;
                                        cArr5[i16] = ' ';
                                        cVar.c = i2 + 1;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    char[] cArr6 = cVar.f4134g;
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
                                        int i17 = cVar.f4132e;
                                        cVar.f4132e = i17 + 1;
                                        cArr4[i17] = cArr4[i13];
                                    } else {
                                        int i18 = cVar.f4132e;
                                        cVar.f4132e = i18 + 1;
                                        cArr4[i18] = cVar.b();
                                        i13 = cVar.c;
                                    }
                                    cVar.c = i13 + 1;
                                }
                            }
                            char[] cArr7 = cVar.f4134g;
                            int i19 = cVar.f4131d;
                            str2 = new String(cArr7, i19, cVar.f4132e - i19);
                        }
                    } else if (i7 + 4 < i8) {
                        cVar.f4131d = i7;
                        while (true) {
                            i7++;
                            cVar.c = i7;
                            if (i7 == cVar.b) {
                                break;
                            }
                            char[] cArr8 = cVar.f4134g;
                            if (cArr8[i7] == '+' || cArr8[i7] == ',' || cArr8[i7] == ';') {
                                break;
                            } else if (cArr8[i7] == ' ') {
                                cVar.f4132e = i7;
                                do {
                                    i7++;
                                    cVar.c = i7;
                                    if (i7 >= cVar.b) {
                                        break;
                                    }
                                } while (cVar.f4134g[i7] == ' ');
                            } else if (cArr8[i7] >= 'A' && cArr8[i7] <= 'F') {
                                cArr8[i7] = (char) (cArr8[i7] + ' ');
                            }
                        }
                        cVar.f4132e = i7;
                        int i20 = cVar.f4132e;
                        int i21 = cVar.f4131d;
                        int i22 = i20 - i21;
                        if (i22 < 5 || (i22 & 1) == 0) {
                            StringBuilder i23 = a.i("Unexpected end of DN: ");
                            i23.append(cVar.a);
                        } else {
                            int i24 = i22 / 2;
                            byte[] bArr = new byte[i24];
                            int i25 = i21 + 1;
                            for (int i26 = 0; i26 < i24; i26++) {
                                bArr[i26] = (byte) cVar.a(i25);
                                i25 += i5;
                            }
                            str2 = new String(cVar.f4134g, cVar.f4131d, i22);
                        }
                    } else {
                        StringBuilder i27 = a.i("Unexpected end of DN: ");
                        i27.append(cVar.a);
                        throw new IllegalStateException(i27.toString());
                    }
                    if ("cn".equalsIgnoreCase(c)) {
                        break;
                    }
                    int i28 = cVar.c;
                    if (i28 >= cVar.b) {
                        break;
                    }
                    char[] cArr9 = cVar.f4134g;
                    if (cArr9[i28] == ',' || cArr9[i28] == ';' || cArr9[i28] == '+') {
                        cVar.c = i28 + 1;
                        c = cVar.c();
                        if (c != null) {
                            i5 = 2;
                        } else {
                            StringBuilder i29 = a.i("Malformed DN: ");
                            i29.append(cVar.a);
                            throw new IllegalStateException(i29.toString());
                        }
                    } else {
                        StringBuilder i30 = a.i("Malformed DN: ");
                        i30.append(cVar.a);
                        throw new IllegalStateException(i30.toString());
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
                str = a.u(str, '.');
            }
            if (!str2.endsWith(".")) {
                str2 = a.u(str2, '.');
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
