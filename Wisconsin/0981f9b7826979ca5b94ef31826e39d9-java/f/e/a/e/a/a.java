package f.e.a.e.a;

import f.e.a.c;
import java.net.ProtocolException;

public final class a {
    public final c a;
    public final int b;
    public final String c;

    public a(c cVar, int i2, String str) {
        this.a = cVar;
        this.b = i2;
        this.c = str;
    }

    public static a a(String str) {
        String str2;
        c cVar = c.HTTP_1_0;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt != 0) {
                if (charAt == 1) {
                    cVar = c.HTTP_1_1;
                } else {
                    throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
                }
            }
        } else if (str.startsWith("ICY ")) {
            i2 = 4;
        } else {
            throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
                }
                return new a(cVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
            }
        } else {
            throw new ProtocolException(f.a.a.a.a.t("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == c.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.b);
        if (this.c != null) {
            sb.append(' ');
            sb.append(this.c);
        }
        return sb.toString();
    }
}
