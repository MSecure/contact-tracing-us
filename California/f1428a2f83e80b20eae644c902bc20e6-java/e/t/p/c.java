package e.t.p;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class c {
    public final String a;
    public final Map<String, a> b;
    public final Set<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f1889d;

    public static class a {
        public final String a;
        public final String b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1890d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1891e;

        /* renamed from: f  reason: collision with root package name */
        public final String f1892f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1893g;

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.a = str;
            this.b = str2;
            this.f1890d = z;
            this.f1891e = i2;
            int i4 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i4 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i4 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i4 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.c = i4;
            this.f1892f = str3;
            this.f1893g = i3;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1891e != aVar.f1891e || !this.a.equals(aVar.a) || this.f1890d != aVar.f1890d) {
                return false;
            }
            if (this.f1893g == 1 && aVar.f1893g == 2 && (str3 = this.f1892f) != null && !str3.equals(aVar.f1892f)) {
                return false;
            }
            if (this.f1893g == 2 && aVar.f1893g == 1 && (str2 = aVar.f1892f) != null && !str2.equals(this.f1892f)) {
                return false;
            }
            int i2 = this.f1893g;
            return (i2 == 0 || i2 != aVar.f1893g || ((str = this.f1892f) == null ? aVar.f1892f == null : str.equals(aVar.f1892f))) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.c) * 31) + (this.f1890d ? 1231 : 1237)) * 31) + this.f1891e;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("Column{name='");
            h2.append(this.a);
            h2.append('\'');
            h2.append(", type='");
            h2.append(this.b);
            h2.append('\'');
            h2.append(", affinity='");
            h2.append(this.c);
            h2.append('\'');
            h2.append(", notNull=");
            h2.append(this.f1890d);
            h2.append(", primaryKeyPosition=");
            h2.append(this.f1891e);
            h2.append(", defaultValue='");
            h2.append(this.f1892f);
            h2.append('\'');
            h2.append('}');
            return h2.toString();
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f1894d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f1895e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f1894d = Collections.unmodifiableList(list);
            this.f1895e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.f1894d.equals(bVar.f1894d)) {
                return this.f1895e.equals(bVar.f1895e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.f1894d.hashCode();
            return this.f1895e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("ForeignKey{referenceTable='");
            h2.append(this.a);
            h2.append('\'');
            h2.append(", onDelete='");
            h2.append(this.b);
            h2.append('\'');
            h2.append(", onUpdate='");
            h2.append(this.c);
            h2.append('\'');
            h2.append(", columnNames=");
            h2.append(this.f1894d);
            h2.append(", referenceColumnNames=");
            h2.append(this.f1895e);
            h2.append('}');
            return h2.toString();
        }
    }

    /* renamed from: e.t.p.c$c  reason: collision with other inner class name */
    public static class C0053c implements Comparable<C0053c> {
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1896d;

        /* renamed from: e  reason: collision with root package name */
        public final String f1897e;

        public C0053c(int i2, int i3, String str, String str2) {
            this.b = i2;
            this.c = i3;
            this.f1896d = str;
            this.f1897e = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(C0053c cVar) {
            C0053c cVar2 = cVar;
            int i2 = this.b - cVar2.b;
            return i2 == 0 ? this.c - cVar2.c : i2;
        }
    }

    public static class d {
        public final String a;
        public final boolean b;
        public final List<String> c;

        public d(String str, boolean z, List<String> list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.b == dVar.b && this.c.equals(dVar.c)) {
                return this.a.startsWith("index_") ? dVar.a.startsWith("index_") : this.a.equals(dVar.a);
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.b ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("Index{name='");
            h2.append(this.a);
            h2.append('\'');
            h2.append(", unique=");
            h2.append(this.b);
            h2.append(", columns=");
            h2.append(this.c);
            h2.append('}');
            return h2.toString();
        }
    }

    public c(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.f1889d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* JADX INFO: finally extract failed */
    public static c a(e.v.a.b bVar, String str) {
        int i2;
        int i3;
        List<C0053c> list;
        int i4;
        e.v.a.f.a aVar = (e.v.a.f.a) bVar;
        Cursor v = aVar.v(f.a.a.a.a.c("PRAGMA table_info(`", str, "`)"));
        HashMap hashMap = new HashMap();
        try {
            if (v.getColumnCount() > 0) {
                int columnIndex = v.getColumnIndex("name");
                int columnIndex2 = v.getColumnIndex("type");
                int columnIndex3 = v.getColumnIndex("notnull");
                int columnIndex4 = v.getColumnIndex("pk");
                int columnIndex5 = v.getColumnIndex("dflt_value");
                while (v.moveToNext()) {
                    String string = v.getString(columnIndex);
                    hashMap.put(string, new a(string, v.getString(columnIndex2), v.getInt(columnIndex3) != 0, v.getInt(columnIndex4), v.getString(columnIndex5), 2));
                    columnIndex = columnIndex;
                }
            }
            v.close();
            HashSet hashSet = new HashSet();
            Cursor v2 = aVar.v("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = v2.getColumnIndex("id");
                int columnIndex7 = v2.getColumnIndex("seq");
                int columnIndex8 = v2.getColumnIndex("table");
                int columnIndex9 = v2.getColumnIndex("on_delete");
                int columnIndex10 = v2.getColumnIndex("on_update");
                List<C0053c> b2 = b(v2);
                int count = v2.getCount();
                int i5 = 0;
                while (i5 < count) {
                    v2.moveToPosition(i5);
                    if (v2.getInt(columnIndex7) != 0) {
                        i2 = columnIndex6;
                        i4 = columnIndex7;
                        list = b2;
                        i3 = count;
                    } else {
                        int i6 = v2.getInt(columnIndex6);
                        i2 = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i4 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) b2).iterator();
                        while (it.hasNext()) {
                            C0053c cVar = (C0053c) it.next();
                            if (cVar.b == i6) {
                                arrayList.add(cVar.f1896d);
                                arrayList2.add(cVar.f1897e);
                            }
                            b2 = b2;
                            count = count;
                        }
                        list = b2;
                        i3 = count;
                        hashSet.add(new b(v2.getString(columnIndex8), v2.getString(columnIndex9), v2.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i5++;
                    columnIndex6 = i2;
                    columnIndex7 = i4;
                    b2 = list;
                    count = i3;
                }
                v2.close();
                Cursor v3 = aVar.v("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = v3.getColumnIndex("name");
                    int columnIndex12 = v3.getColumnIndex("origin");
                    int columnIndex13 = v3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (v3.moveToNext()) {
                                if ("c".equals(v3.getString(columnIndex12))) {
                                    d c2 = c(aVar, v3.getString(columnIndex11), v3.getInt(columnIndex13) == 1);
                                    if (c2 != null) {
                                        hashSet3.add(c2);
                                    }
                                }
                            }
                            v3.close();
                            hashSet2 = hashSet3;
                            return new c(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new c(str, hashMap, hashSet, hashSet2);
                } finally {
                    v3.close();
                }
            } catch (Throwable th) {
                v2.close();
                throw th;
            }
        } catch (Throwable th2) {
            v.close();
            throw th2;
        }
    }

    public static List<C0053c> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new C0053c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static d c(e.v.a.b bVar, String str, boolean z) {
        Cursor v = ((e.v.a.f.a) bVar).v(f.a.a.a.a.c("PRAGMA index_xinfo(`", str, "`)"));
        try {
            int columnIndex = v.getColumnIndex("seqno");
            int columnIndex2 = v.getColumnIndex("cid");
            int columnIndex3 = v.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (v.moveToNext()) {
                        if (v.getInt(columnIndex2) >= 0) {
                            int i2 = v.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i2), v.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z, arrayList);
                    v.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            v.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.a;
        if (str == null ? cVar.a != null : !str.equals(cVar.a)) {
            return false;
        }
        Map<String, a> map = this.b;
        if (map == null ? cVar.b != null : !map.equals(cVar.b)) {
            return false;
        }
        Set<b> set2 = this.c;
        if (set2 == null ? cVar.c != null : !set2.equals(cVar.c)) {
            return false;
        }
        Set<d> set3 = this.f1889d;
        if (set3 == null || (set = cVar.f1889d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.c;
        if (set != null) {
            i2 = set.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("TableInfo{name='");
        h2.append(this.a);
        h2.append('\'');
        h2.append(", columns=");
        h2.append(this.b);
        h2.append(", foreignKeys=");
        h2.append(this.c);
        h2.append(", indices=");
        h2.append(this.f1889d);
        h2.append('}');
        return h2.toString();
    }
}
