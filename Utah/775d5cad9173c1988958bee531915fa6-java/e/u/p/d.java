package e.u.p;

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

public class d {
    public final String a;
    public final Map<String, a> b;
    public final Set<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0058d> f2012d;

    public static class a {
        public final String a;
        public final String b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2013d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2014e;

        /* renamed from: f  reason: collision with root package name */
        public final String f2015f;

        /* renamed from: g  reason: collision with root package name */
        public final int f2016g;

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.a = str;
            this.b = str2;
            this.f2013d = z;
            this.f2014e = i2;
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
            this.f2015f = str3;
            this.f2016g = i3;
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
            if (this.f2014e != aVar.f2014e || !this.a.equals(aVar.a) || this.f2013d != aVar.f2013d) {
                return false;
            }
            if (this.f2016g == 1 && aVar.f2016g == 2 && (str3 = this.f2015f) != null && !str3.equals(aVar.f2015f)) {
                return false;
            }
            if (this.f2016g == 2 && aVar.f2016g == 1 && (str2 = aVar.f2015f) != null && !str2.equals(this.f2015f)) {
                return false;
            }
            int i2 = this.f2016g;
            return (i2 == 0 || i2 != aVar.f2016g || ((str = this.f2015f) == null ? aVar.f2015f == null : str.equals(aVar.f2015f))) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.c) * 31) + (this.f2013d ? 1231 : 1237)) * 31) + this.f2014e;
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
            h2.append(this.f2013d);
            h2.append(", primaryKeyPosition=");
            h2.append(this.f2014e);
            h2.append(", defaultValue='");
            h2.append(this.f2015f);
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
        public final List<String> f2017d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f2018e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f2017d = Collections.unmodifiableList(list);
            this.f2018e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.f2017d.equals(bVar.f2017d)) {
                return this.f2018e.equals(bVar.f2018e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.f2017d.hashCode();
            return this.f2018e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31);
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
            h2.append(this.f2017d);
            h2.append(", referenceColumnNames=");
            h2.append(this.f2018e);
            h2.append('}');
            return h2.toString();
        }
    }

    public static class c implements Comparable<c> {
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2019d;

        /* renamed from: e  reason: collision with root package name */
        public final String f2020e;

        public c(int i2, int i3, String str, String str2) {
            this.b = i2;
            this.c = i3;
            this.f2019d = str;
            this.f2020e = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i2 = this.b - cVar2.b;
            return i2 == 0 ? this.c - cVar2.c : i2;
        }
    }

    /* renamed from: e.u.p.d$d  reason: collision with other inner class name */
    public static class C0058d {
        public final String a;
        public final boolean b;
        public final List<String> c;

        public C0058d(String str, boolean z, List<String> list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0058d.class != obj.getClass()) {
                return false;
            }
            C0058d dVar = (C0058d) obj;
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

    public d(String str, Map<String, a> map, Set<b> set, Set<C0058d> set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.f2012d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* JADX INFO: finally extract failed */
    public static d a(e.w.a.b bVar, String str) {
        int i2;
        int i3;
        List<c> list;
        int i4;
        e.w.a.f.a aVar = (e.w.a.f.a) bVar;
        Cursor t = aVar.t(f.a.a.a.a.c("PRAGMA table_info(`", str, "`)"));
        HashMap hashMap = new HashMap();
        try {
            if (t.getColumnCount() > 0) {
                int columnIndex = t.getColumnIndex("name");
                int columnIndex2 = t.getColumnIndex("type");
                int columnIndex3 = t.getColumnIndex("notnull");
                int columnIndex4 = t.getColumnIndex("pk");
                int columnIndex5 = t.getColumnIndex("dflt_value");
                while (t.moveToNext()) {
                    String string = t.getString(columnIndex);
                    hashMap.put(string, new a(string, t.getString(columnIndex2), t.getInt(columnIndex3) != 0, t.getInt(columnIndex4), t.getString(columnIndex5), 2));
                    columnIndex = columnIndex;
                }
            }
            t.close();
            HashSet hashSet = new HashSet();
            Cursor t2 = aVar.t("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = t2.getColumnIndex("id");
                int columnIndex7 = t2.getColumnIndex("seq");
                int columnIndex8 = t2.getColumnIndex("table");
                int columnIndex9 = t2.getColumnIndex("on_delete");
                int columnIndex10 = t2.getColumnIndex("on_update");
                List<c> b2 = b(t2);
                int count = t2.getCount();
                int i5 = 0;
                while (i5 < count) {
                    t2.moveToPosition(i5);
                    if (t2.getInt(columnIndex7) != 0) {
                        i2 = columnIndex6;
                        i4 = columnIndex7;
                        list = b2;
                        i3 = count;
                    } else {
                        int i6 = t2.getInt(columnIndex6);
                        i2 = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i4 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) b2).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.b == i6) {
                                arrayList.add(cVar.f2019d);
                                arrayList2.add(cVar.f2020e);
                            }
                            b2 = b2;
                            count = count;
                        }
                        list = b2;
                        i3 = count;
                        hashSet.add(new b(t2.getString(columnIndex8), t2.getString(columnIndex9), t2.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i5++;
                    columnIndex6 = i2;
                    columnIndex7 = i4;
                    b2 = list;
                    count = i3;
                }
                t2.close();
                Cursor t3 = aVar.t("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = t3.getColumnIndex("name");
                    int columnIndex12 = t3.getColumnIndex("origin");
                    int columnIndex13 = t3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (t3.moveToNext()) {
                                if ("c".equals(t3.getString(columnIndex12))) {
                                    C0058d c2 = c(aVar, t3.getString(columnIndex11), t3.getInt(columnIndex13) == 1);
                                    if (c2 != null) {
                                        hashSet3.add(c2);
                                    }
                                }
                            }
                            t3.close();
                            hashSet2 = hashSet3;
                            return new d(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new d(str, hashMap, hashSet, hashSet2);
                } finally {
                    t3.close();
                }
            } catch (Throwable th) {
                t2.close();
                throw th;
            }
        } catch (Throwable th2) {
            t.close();
            throw th2;
        }
    }

    public static List<c> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static C0058d c(e.w.a.b bVar, String str, boolean z) {
        Cursor t = ((e.w.a.f.a) bVar).t(f.a.a.a.a.c("PRAGMA index_xinfo(`", str, "`)"));
        try {
            int columnIndex = t.getColumnIndex("seqno");
            int columnIndex2 = t.getColumnIndex("cid");
            int columnIndex3 = t.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (t.moveToNext()) {
                        if (t.getInt(columnIndex2) >= 0) {
                            int i2 = t.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i2), t.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    C0058d dVar = new C0058d(str, z, arrayList);
                    t.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            t.close();
        }
    }

    public boolean equals(Object obj) {
        Set<C0058d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.a;
        if (str == null ? dVar.a != null : !str.equals(dVar.a)) {
            return false;
        }
        Map<String, a> map = this.b;
        if (map == null ? dVar.b != null : !map.equals(dVar.b)) {
            return false;
        }
        Set<b> set2 = this.c;
        if (set2 == null ? dVar.c != null : !set2.equals(dVar.c)) {
            return false;
        }
        Set<C0058d> set3 = this.f2012d;
        if (set3 == null || (set = dVar.f2012d) == null) {
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
        h2.append(this.f2012d);
        h2.append('}');
        return h2.toString();
    }
}
