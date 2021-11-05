package e.b.i;

import c.b.a.a.c.n.c;
import java.util.HashMap;
import java.util.Map;

public class h implements Cloneable {
    public static final Map<String, h> k = new HashMap();
    public static final String[] l;
    public static final String[] m = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};
    public static final String[] n = {"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    public static final String[] o = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
    public static final String[] p = {"pre", "plaintext", "title", "textarea"};
    public static final String[] q = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    public static final String[] r = {"input", "keygen", "object", "select", "textarea"};

    /* renamed from: b  reason: collision with root package name */
    public String f4889b;

    /* renamed from: c  reason: collision with root package name */
    public String f4890c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4891d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4892e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center"};
        l = strArr;
        for (String str : strArr) {
            h hVar = new h(str);
            k.put(hVar.f4889b, hVar);
        }
        for (String str2 : m) {
            h hVar2 = new h(str2);
            hVar2.f4891d = false;
            hVar2.f4892e = false;
            k.put(hVar2.f4889b, hVar2);
        }
        for (String str3 : n) {
            h hVar3 = k.get(str3);
            c.J1(hVar3);
            hVar3.f = true;
        }
        for (String str4 : o) {
            h hVar4 = k.get(str4);
            c.J1(hVar4);
            hVar4.f4892e = false;
        }
        for (String str5 : p) {
            h hVar5 = k.get(str5);
            c.J1(hVar5);
            hVar5.h = true;
        }
        for (String str6 : q) {
            h hVar6 = k.get(str6);
            c.J1(hVar6);
            hVar6.i = true;
        }
        for (String str7 : r) {
            h hVar7 = k.get(str7);
            c.J1(hVar7);
            hVar7.j = true;
        }
    }

    public h(String str) {
        this.f4889b = str;
        this.f4890c = c.C1(str);
    }

    public static h a(String str, f fVar) {
        c.J1(str);
        h hVar = k.get(str);
        if (hVar != null) {
            return hVar;
        }
        String b2 = fVar.b(str);
        c.H1(b2);
        String C1 = c.C1(b2);
        h hVar2 = k.get(C1);
        if (hVar2 == null) {
            h hVar3 = new h(b2);
            hVar3.f4891d = false;
            return hVar3;
        } else if (!fVar.f4884a || b2.equals(C1)) {
            return hVar2;
        } else {
            try {
                h hVar4 = (h) super.clone();
                hVar4.f4889b = b2;
                return hVar4;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return (h) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f4889b.equals(hVar.f4889b) && this.f == hVar.f && this.f4892e == hVar.f4892e && this.f4891d == hVar.f4891d && this.h == hVar.h && this.g == hVar.g && this.i == hVar.i) {
            return this.j == hVar.j;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.f4889b.hashCode() * 31) + (this.f4891d ? 1 : 0)) * 31) + (this.f4892e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0);
    }

    public String toString() {
        return this.f4889b;
    }
}
