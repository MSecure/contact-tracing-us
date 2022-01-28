package e.b.h;

import c.b.a.a.c.n.c;
import e.b.g.b;
import e.b.h.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class a implements Map.Entry<String, String>, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f4824e = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* renamed from: b  reason: collision with root package name */
    public String f4825b;

    /* renamed from: c  reason: collision with root package name */
    public String f4826c;

    /* renamed from: d  reason: collision with root package name */
    public b f4827d;

    public a(String str, String str2, b bVar) {
        c.J1(str);
        String trim = str.trim();
        c.H1(trim);
        this.f4825b = trim;
        this.f4826c = str2;
        this.f4827d = bVar;
    }

    public static boolean b(String str, String str2, f.a aVar) {
        if (aVar.i == f.a.EnumC0115a.html) {
            if (str2 == null) {
                return true;
            }
            if ("".equals(str2) || str2.equalsIgnoreCase(str)) {
                if (Arrays.binarySearch(f4824e, str) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(Appendable appendable, f.a aVar) {
        String str = this.f4825b;
        String str2 = this.f4826c;
        appendable.append(str);
        if (!b(str, str2, aVar)) {
            appendable.append("=\"");
            if (str2 == null) {
                str2 = "";
            }
            j.c(appendable, str2, aVar, true, false, false);
            appendable.append('\"');
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f4825b;
        if (str == null ? aVar.f4825b != null : !str.equals(aVar.f4825b)) {
            return false;
        }
        String str2 = this.f4826c;
        String str3 = aVar.f4826c;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Map.Entry
    public String getKey() {
        return this.f4825b;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Map.Entry
    public String getValue() {
        String str = this.f4826c;
        return str == null ? "" : str;
    }

    public int hashCode() {
        String str = this.f4825b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4826c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Map.Entry
    public String setValue(String str) {
        String str2 = str;
        String str3 = this.f4826c;
        b bVar = this.f4827d;
        if (bVar != null) {
            str3 = bVar.o(this.f4825b);
            int s = this.f4827d.s(this.f4825b);
            if (s != -1) {
                this.f4827d.f4831d[s] = str2;
            }
        }
        this.f4826c = str2;
        return str3 == null ? "" : str3;
    }

    public String toString() {
        StringBuilder b2 = b.b();
        try {
            a(b2, new f("").j);
            return b.j(b2);
        } catch (IOException e2) {
            throw new e.b.c(e2);
        }
    }
}
