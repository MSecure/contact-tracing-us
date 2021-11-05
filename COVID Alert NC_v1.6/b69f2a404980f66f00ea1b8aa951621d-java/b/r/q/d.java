package b.r.q;

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

    /* renamed from: a  reason: collision with root package name */
    public final String f1686a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f1687b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f1688c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0039d> f1689d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1690a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1691b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1692c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1693d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1694e;
        public final String f;
        public final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.f1690a = str;
            this.f1691b = str2;
            this.f1693d = z;
            this.f1694e = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.f1692c = i3;
            this.f = str3;
            this.g = i2;
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
            if (this.f1694e != aVar.f1694e || !this.f1690a.equals(aVar.f1690a) || this.f1693d != aVar.f1693d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f) != null && !str3.equals(aVar.f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f) != null && !str2.equals(this.f)) {
                return false;
            }
            int i = this.g;
            if (i == 0 || i != aVar.g || ((str = this.f) == null ? aVar.f == null : str.equals(aVar.f))) {
                return this.f1692c == aVar.f1692c;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f1690a.hashCode() * 31) + this.f1692c) * 31) + (this.f1693d ? 1231 : 1237)) * 31) + this.f1694e;
        }

        public String toString() {
            StringBuilder g2 = c.a.a.a.a.g("Column{name='");
            g2.append(this.f1690a);
            g2.append('\'');
            g2.append(", type='");
            g2.append(this.f1691b);
            g2.append('\'');
            g2.append(", affinity='");
            g2.append(this.f1692c);
            g2.append('\'');
            g2.append(", notNull=");
            g2.append(this.f1693d);
            g2.append(", primaryKeyPosition=");
            g2.append(this.f1694e);
            g2.append(", defaultValue='");
            g2.append(this.f);
            g2.append('\'');
            g2.append('}');
            return g2.toString();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1695a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1696b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1697c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f1698d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f1699e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f1695a = str;
            this.f1696b = str2;
            this.f1697c = str3;
            this.f1698d = Collections.unmodifiableList(list);
            this.f1699e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1695a.equals(bVar.f1695a) && this.f1696b.equals(bVar.f1696b) && this.f1697c.equals(bVar.f1697c) && this.f1698d.equals(bVar.f1698d)) {
                return this.f1699e.equals(bVar.f1699e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f1696b.hashCode();
            int hashCode2 = this.f1697c.hashCode();
            int hashCode3 = this.f1698d.hashCode();
            return this.f1699e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f1695a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("ForeignKey{referenceTable='");
            g.append(this.f1695a);
            g.append('\'');
            g.append(", onDelete='");
            g.append(this.f1696b);
            g.append('\'');
            g.append(", onUpdate='");
            g.append(this.f1697c);
            g.append('\'');
            g.append(", columnNames=");
            g.append(this.f1698d);
            g.append(", referenceColumnNames=");
            g.append(this.f1699e);
            g.append('}');
            return g.toString();
        }
    }

    public static class c implements Comparable<c> {

        /* renamed from: b  reason: collision with root package name */
        public final int f1700b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1701c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1702d;

        /* renamed from: e  reason: collision with root package name */
        public final String f1703e;

        public c(int i, int i2, String str, String str2) {
            this.f1700b = i;
            this.f1701c = i2;
            this.f1702d = str;
            this.f1703e = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i = this.f1700b - cVar2.f1700b;
            return i == 0 ? this.f1701c - cVar2.f1701c : i;
        }
    }

    /* renamed from: b.r.q.d$d  reason: collision with other inner class name */
    public static class C0039d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1704a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1705b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f1706c;

        public C0039d(String str, boolean z, List<String> list) {
            this.f1704a = str;
            this.f1705b = z;
            this.f1706c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0039d.class != obj.getClass()) {
                return false;
            }
            C0039d dVar = (C0039d) obj;
            if (this.f1705b == dVar.f1705b && this.f1706c.equals(dVar.f1706c)) {
                return this.f1704a.startsWith("index_") ? dVar.f1704a.startsWith("index_") : this.f1704a.equals(dVar.f1704a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1706c.hashCode() + ((((this.f1704a.startsWith("index_") ? -1184239155 : this.f1704a.hashCode()) * 31) + (this.f1705b ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("Index{name='");
            g.append(this.f1704a);
            g.append('\'');
            g.append(", unique=");
            g.append(this.f1705b);
            g.append(", columns=");
            g.append(this.f1706c);
            g.append('}');
            return g.toString();
        }
    }

    public d(String str, Map<String, a> map, Set<b> set, Set<C0039d> set2) {
        this.f1686a = str;
        this.f1687b = Collections.unmodifiableMap(map);
        this.f1688c = Collections.unmodifiableSet(set);
        this.f1689d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* JADX INFO: finally extract failed */
    public static d a(b.u.a.b bVar, String str) {
        int i;
        int i2;
        List<c> list;
        int i3;
        b.u.a.g.a aVar = (b.u.a.g.a) bVar;
        Cursor e2 = aVar.e(c.a.a.a.a.p("PRAGMA table_info(`", str, "`)"));
        HashMap hashMap = new HashMap();
        try {
            if (e2.getColumnCount() > 0) {
                int columnIndex = e2.getColumnIndex("name");
                int columnIndex2 = e2.getColumnIndex("type");
                int columnIndex3 = e2.getColumnIndex("notnull");
                int columnIndex4 = e2.getColumnIndex("pk");
                int columnIndex5 = e2.getColumnIndex("dflt_value");
                while (e2.moveToNext()) {
                    String string = e2.getString(columnIndex);
                    hashMap.put(string, new a(string, e2.getString(columnIndex2), e2.getInt(columnIndex3) != 0, e2.getInt(columnIndex4), e2.getString(columnIndex5), 2));
                    columnIndex = columnIndex;
                }
            }
            e2.close();
            HashSet hashSet = new HashSet();
            Cursor e3 = aVar.e("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = e3.getColumnIndex("id");
                int columnIndex7 = e3.getColumnIndex("seq");
                int columnIndex8 = e3.getColumnIndex("table");
                int columnIndex9 = e3.getColumnIndex("on_delete");
                int columnIndex10 = e3.getColumnIndex("on_update");
                List<c> b2 = b(e3);
                int count = e3.getCount();
                int i4 = 0;
                while (i4 < count) {
                    e3.moveToPosition(i4);
                    if (e3.getInt(columnIndex7) != 0) {
                        i = columnIndex6;
                        i3 = columnIndex7;
                        list = b2;
                        i2 = count;
                    } else {
                        int i5 = e3.getInt(columnIndex6);
                        i = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i3 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) b2).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.f1700b == i5) {
                                arrayList.add(cVar.f1702d);
                                arrayList2.add(cVar.f1703e);
                            }
                            b2 = b2;
                            count = count;
                        }
                        list = b2;
                        i2 = count;
                        hashSet.add(new b(e3.getString(columnIndex8), e3.getString(columnIndex9), e3.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i4++;
                    columnIndex6 = i;
                    columnIndex7 = i3;
                    b2 = list;
                    count = i2;
                }
                e3.close();
                Cursor e4 = aVar.e("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = e4.getColumnIndex("name");
                    int columnIndex12 = e4.getColumnIndex("origin");
                    int columnIndex13 = e4.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (e4.moveToNext()) {
                                if ("c".equals(e4.getString(columnIndex12))) {
                                    String string2 = e4.getString(columnIndex11);
                                    boolean z = true;
                                    if (e4.getInt(columnIndex13) != 1) {
                                        z = false;
                                    }
                                    C0039d c2 = c(aVar, string2, z);
                                    if (c2 != null) {
                                        hashSet3.add(c2);
                                    }
                                }
                            }
                            e4.close();
                            hashSet2 = hashSet3;
                            return new d(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new d(str, hashMap, hashSet, hashSet2);
                } finally {
                    e4.close();
                }
            } catch (Throwable th) {
                e3.close();
                throw th;
            }
        } catch (Throwable th2) {
            e2.close();
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
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static C0039d c(b.u.a.b bVar, String str, boolean z) {
        Cursor e2 = ((b.u.a.g.a) bVar).e(c.a.a.a.a.p("PRAGMA index_xinfo(`", str, "`)"));
        try {
            int columnIndex = e2.getColumnIndex("seqno");
            int columnIndex2 = e2.getColumnIndex("cid");
            int columnIndex3 = e2.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (e2.moveToNext()) {
                        if (e2.getInt(columnIndex2) >= 0) {
                            int i = e2.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), e2.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    C0039d dVar = new C0039d(str, z, arrayList);
                    e2.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            e2.close();
        }
    }

    public boolean equals(Object obj) {
        Set<C0039d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f1686a;
        if (str == null ? dVar.f1686a != null : !str.equals(dVar.f1686a)) {
            return false;
        }
        Map<String, a> map = this.f1687b;
        if (map == null ? dVar.f1687b != null : !map.equals(dVar.f1687b)) {
            return false;
        }
        Set<b> set2 = this.f1688c;
        if (set2 == null ? dVar.f1688c != null : !set2.equals(dVar.f1688c)) {
            return false;
        }
        Set<C0039d> set3 = this.f1689d;
        if (set3 == null || (set = dVar.f1689d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f1686a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f1687b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f1688c;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("TableInfo{name='");
        g.append(this.f1686a);
        g.append('\'');
        g.append(", columns=");
        g.append(this.f1687b);
        g.append(", foreignKeys=");
        g.append(this.f1688c);
        g.append(", indices=");
        g.append(this.f1689d);
        g.append('}');
        return g.toString();
    }
}
