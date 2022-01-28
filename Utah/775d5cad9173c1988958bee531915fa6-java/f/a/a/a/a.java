package f.a.a.a;

import androidx.recyclerview.widget.RecyclerView;
import e.n.a.m;
import f.b.a.a.a.b0.e1;
import f.b.a.a.a.h0.c;
import f.b.c.k.u.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import l.b.a.x.e;
import l.b.a.x.j;
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

    public static ArrayList l(int i2, HashMap hashMap, ArrayList arrayList, int i3, String str) {
        hashMap.put(Integer.valueOf(i2), arrayList);
        ArrayList arrayList2 = new ArrayList(i3);
        arrayList2.add(str);
        return arrayList2;
    }

    public static String m(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.A());
        return sb.toString();
    }

    public static ArrayList n(ArrayList arrayList, String str, int i2, HashMap hashMap, ArrayList arrayList2, int i3) {
        arrayList.add(str);
        hashMap.put(Integer.valueOf(i2), arrayList2);
        return new ArrayList(i3);
    }

    public static void o(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static boolean p(e1 e1Var, int i2, c cVar, int i3) {
        return cVar.a(i3, e1Var.b().get(i2).b());
    }

    public static String q(l lVar, StringBuilder sb, String str) {
        sb.append(lVar.c());
        sb.append(str);
        sb.append(lVar.n());
        return sb.toString();
    }

    public static String r(f.b.e.a.a aVar, StringBuilder sb) {
        sb.append(aVar.U());
        sb.append(aVar.Q());
        return sb.toString();
    }

    public static String s(String str, char c) {
        return str + c;
    }

    public static String t(String str, int i2) {
        return str + i2;
    }

    public static String u(String str, int i2, String str2) {
        return str + i2 + str2;
    }

    public static String v(String str, m mVar, String str2) {
        return str + mVar + str2;
    }

    public static String w(String str, String str2) {
        return str + str2;
    }
}
