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

public class d {
    public final String a;
    public final Map<String, a> b;
    public final Set<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0052d> f1737d;

    public static class a {
        public final String a;
        public final String b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1738d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1739e;

        /* renamed from: f  reason: collision with root package name */
        public final String f1740f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1741g;

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.a = str;
            this.b = str2;
            this.f1738d = z;
            this.f1739e = i2;
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
            this.f1740f = str3;
            this.f1741g = i3;
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
            if (this.f1739e != aVar.f1739e || !this.a.equals(aVar.a) || this.f1738d != aVar.f1738d) {
                return false;
            }
            if (this.f1741g == 1 && aVar.f1741g == 2 && (str3 = this.f1740f) != null && !str3.equals(aVar.f1740f)) {
                return false;
            }
            if (this.f1741g == 2 && aVar.f1741g == 1 && (str2 = aVar.f1740f) != null && !str2.equals(this.f1740f)) {
                return false;
            }
            int i2 = this.f1741g;
            return (i2 == 0 || i2 != aVar.f1741g || ((str = this.f1740f) == null ? aVar.f1740f == null : str.equals(aVar.f1740f))) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.c) * 31) + (this.f1738d ? 1231 : 1237)) * 31) + this.f1739e;
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("Column{name='");
            i2.append(this.a);
            i2.append('\'');
            i2.append(", type='");
            i2.append(this.b);
            i2.append('\'');
            i2.append(", affinity='");
            i2.append(this.c);
            i2.append('\'');
            i2.append(", notNull=");
            i2.append(this.f1738d);
            i2.append(", primaryKeyPosition=");
            i2.append(this.f1739e);
            i2.append(", defaultValue='");
            i2.append(this.f1740f);
            i2.append('\'');
            i2.append('}');
            return i2.toString();
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f1742d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f1743e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f1742d = Collections.unmodifiableList(list);
            this.f1743e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.f1742d.equals(bVar.f1742d)) {
                return this.f1743e.equals(bVar.f1743e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.f1742d.hashCode();
            return this.f1743e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("ForeignKey{referenceTable='");
            i2.append(this.a);
            i2.append('\'');
            i2.append(", onDelete='");
            i2.append(this.b);
            i2.append('\'');
            i2.append(", onUpdate='");
            i2.append(this.c);
            i2.append('\'');
            i2.append(", columnNames=");
            i2.append(this.f1742d);
            i2.append(", referenceColumnNames=");
            i2.append(this.f1743e);
            i2.append('}');
            return i2.toString();
        }
    }

    public static class c implements Comparable<c> {
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1744d;

        /* renamed from: e  reason: collision with root package name */
        public final String f1745e;

        public c(int i2, int i3, String str, String str2) {
            this.b = i2;
            this.c = i3;
            this.f1744d = str;
            this.f1745e = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i2 = this.b - cVar2.b;
            return i2 == 0 ? this.c - cVar2.c : i2;
        }
    }

    /* renamed from: e.t.p.d$d  reason: collision with other inner class name */
    public static class C0052d {
        public final String a;
        public final boolean b;
        public final List<String> c;

        public C0052d(String str, boolean z, List<String> list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0052d.class != obj.getClass()) {
                return false;
            }
            C0052d dVar = (C0052d) obj;
            if (this.b == dVar.b && this.c.equals(dVar.c)) {
                return this.a.startsWith("index_") ? dVar.a.startsWith("index_") : this.a.equals(dVar.a);
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.b ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("Index{name='");
            i2.append(this.a);
            i2.append('\'');
            i2.append(", unique=");
            i2.append(this.b);
            i2.append(", columns=");
            i2.append(this.c);
            i2.append('}');
            return i2.toString();
        }
    }

    public d(String str, Map<String, a> map, Set<b> set, Set<C0052d> set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.f1737d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* JADX INFO: finally extract failed */
    public static d a(e.v.a.b bVar, String str) {
        int i2;
        int i3;
        List<c> list;
        int i4;
        e.v.a.f.a aVar = (e.v.a.f.a) bVar;
        Cursor t = aVar.t(f.a.a.a.a.d("PRAGMA table_info(`", str, "`)"));
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
                                arrayList.add(cVar.f1744d);
                                arrayList2.add(cVar.f1745e);
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
                                    C0052d c2 = c(aVar, t3.getString(columnIndex11), t3.getInt(columnIndex13) == 1);
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

    public static C0052d c(e.v.a.b bVar, String str, boolean z) {
        Cursor t = ((e.v.a.f.a) bVar).t(f.a.a.a.a.d("PRAGMA index_xinfo(`", str, "`)"));
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
                    C0052d dVar = new C0052d(str, z, arrayList);
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
        Set<C0052d> set;
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
        Set<C0052d> set3 = this.f1737d;
        if (set3 == null || (set = dVar.f1737d) == null) {
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
        StringBuilder i2 = f.a.a.a.a.i("TableInfo{name='");
        i2.append(this.a);
        i2.append('\'');
        i2.append(", columns=");
        i2.append(this.b);
        i2.append(", foreignKeys=");
        i2.append(this.c);
        i2.append(", indices=");
        i2.append(this.f1737d);
        i2.append('}');
        return i2.toString();
    }
}
