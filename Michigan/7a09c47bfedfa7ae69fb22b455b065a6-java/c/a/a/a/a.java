package c.a.a.a;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import g.b.a.w.e;
import g.b.a.w.j;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class a {
    public static int a(int i, int i2, int i3, int i4) {
        return ((i * i2) + i3) * i4;
    }

    public static int b(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String c(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String d(String str, j jVar) {
        return str + jVar;
    }

    public static String e(e eVar, StringBuilder sb) {
        sb.append(eVar.getClass().getName());
        return sb.toString();
    }

    public static String f(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder g(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        return sb;
    }

    public static StringBuilder h(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder i(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static long j(long j, long j2, long j3, long j4) {
        return ((j * j2) + j3) * j4;
    }

    public static String k(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static String l(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.A());
        return sb.toString();
    }

    public static String m(String str, char c2) {
        return str + c2;
    }

    public static String n(String str, int i) {
        return str + i;
    }

    public static String o(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String p(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String q(String str, String str2) {
        return str + str2;
    }
}
