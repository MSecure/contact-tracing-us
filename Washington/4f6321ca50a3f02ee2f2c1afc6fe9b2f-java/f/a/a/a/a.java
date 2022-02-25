package f.a.a.a;

import androidx.recyclerview.widget.RecyclerView;
import f.b.a.a.a.n.b0;
import f.b.a.a.a.t.c;
import f.b.c.k.u.l;
import l.b.a.w.e;
import l.b.a.w.j;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class a {
    public static float a(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static int b(int i2, int i3, int i4, int i5) {
        return ((i2 * i3) / i4) + i5;
    }

    public static String c(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String d(String str, j jVar) {
        return str + jVar;
    }

    public static String e(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String f(e eVar, StringBuilder sb) {
        sb.append(eVar.getClass().getName());
        return sb.toString();
    }

    public static String g(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder h(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder i(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder j(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder k(String str, e eVar, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(eVar);
        sb.append(str2);
        return sb;
    }

    public static boolean l(b0 b0Var, int i2, c cVar, int i3) {
        return cVar.a(i3, b0Var.b().get(i2).b());
    }

    public static String m(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.A());
        return sb.toString();
    }

    public static String n(l lVar, StringBuilder sb, String str) {
        sb.append(lVar.c());
        sb.append(str);
        sb.append(lVar.n());
        return sb.toString();
    }

    public static String o(f.b.e.a.a aVar, StringBuilder sb) {
        sb.append(aVar.Z());
        sb.append(aVar.V());
        return sb.toString();
    }

    public static String p(String str, char c) {
        return str + c;
    }

    public static String q(String str, int i2) {
        return str + i2;
    }

    public static String r(String str, int i2, String str2) {
        return str + i2 + str2;
    }

    public static String s(String str, e.m.a.l lVar, String str2) {
        return str + lVar + str2;
    }

    public static String t(String str, String str2) {
        return str + str2;
    }
}
