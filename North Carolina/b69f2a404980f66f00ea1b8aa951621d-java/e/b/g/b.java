package e.b.g;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import c.b.a.a.c.n.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f4822a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};

    /* renamed from: b  reason: collision with root package name */
    public static final Stack<StringBuilder> f4823b = new Stack<>();

    public static void a(StringBuilder sb, String str, boolean z) {
        int length = str.length();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!(codePointAt == 32 || codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13 || codePointAt == 160)) {
                if (!(codePointAt == 8203 || codePointAt == 173)) {
                    sb.appendCodePoint(codePointAt);
                    z3 = false;
                    z2 = true;
                }
            } else if ((!z || z2) && !z3) {
                sb.append(' ');
                z3 = true;
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static StringBuilder b() {
        StringBuilder sb;
        synchronized (f4823b) {
            sb = f4823b.empty() ? new StringBuilder((int) RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) : f4823b.pop();
        }
        return sb;
    }

    public static boolean c(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean e(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!g(str.codePointAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean f(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static String h(Collection collection, String str) {
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        String obj = it.next().toString();
        if (!it.hasNext()) {
            return obj;
        }
        StringBuilder b2 = b();
        b2.append(obj);
        while (it.hasNext()) {
            b2.append(str);
            b2.append(it.next());
        }
        return j(b2);
    }

    public static String i(int i) {
        if (i >= 0) {
            String[] strArr = f4822a;
            if (i < strArr.length) {
                return strArr[i];
            }
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = ' ';
            }
            return String.valueOf(cArr);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String j(StringBuilder sb) {
        c.J1(sb);
        String sb2 = sb.toString();
        if (sb.length() > 8192) {
            sb = new StringBuilder((int) RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        } else {
            sb.delete(0, sb.length());
        }
        synchronized (f4823b) {
            f4823b.push(sb);
            while (f4823b.size() > 8) {
                f4823b.pop();
            }
        }
        return sb2;
    }

    public static String k(String str, String str2) {
        try {
            try {
                return l(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            return new URL(str2).toExternalForm();
        }
    }

    public static URL l(URL url, String str) {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            StringBuilder g = a.g("/");
            g.append(url.getFile());
            url = new URL(protocol, host, port, g.toString());
        }
        return new URL(url, str);
    }
}
