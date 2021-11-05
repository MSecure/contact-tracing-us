package c.a.a.a;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import e.c.a.w.e;
import e.c.a.w.j;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class a {
    public static int a(int i, int i2, int i3, int i4) {
        return ((i * i2) + i3) * i4;
    }

    public static int b(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String c(String str, j jVar) {
        return str + jVar;
    }

    public static String d(e eVar, StringBuilder sb) {
        sb.append(eVar.getClass().getName());
        return sb.toString();
    }

    public static String e(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder f(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        return sb;
    }

    public static StringBuilder g(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder h(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static long i(long j, long j2, long j3, long j4) {
        return ((j * j2) + j3) * j4;
    }

    public static String j(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String k(String str, char c2) {
        return str + c2;
    }

    public static String l(String str, int i) {
        return str + i;
    }

    public static String m(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String n(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String o(String str, String str2) {
        return str + str2;
    }

    public static String p(String str, String str2, String str3) {
        return str + str2 + str3;
    }
}
