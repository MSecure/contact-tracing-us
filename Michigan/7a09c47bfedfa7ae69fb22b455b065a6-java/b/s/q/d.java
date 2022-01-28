package b.s.q;

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
    public final String f2556a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f2557b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f2558c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0049d> f2559d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f2560a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2561b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2562c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2563d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2564e;

        /* renamed from: f  reason: collision with root package name */
        public final String f2565f;

        /* renamed from: g  reason: collision with root package name */
        public final int f2566g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.f2560a = str;
            this.f2561b = str2;
            this.f2563d = z;
            this.f2564e = i;
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
            this.f2562c = i3;
            this.f2565f = str3;
            this.f2566g = i2;
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
            if (this.f2564e != aVar.f2564e || !this.f2560a.equals(aVar.f2560a) || this.f2563d != aVar.f2563d) {
                return false;
            }
            if (this.f2566g == 1 && aVar.f2566g == 2 && (str3 = this.f2565f) != null && !str3.equals(aVar.f2565f)) {
                return false;
            }
            if (this.f2566g == 2 && aVar.f2566g == 1 && (str2 = aVar.f2565f) != null && !str2.equals(this.f2565f)) {
                return false;
            }
            int i = this.f2566g;
            if (i == 0 || i != aVar.f2566g || ((str = this.f2565f) == null ? aVar.f2565f == null : str.equals(aVar.f2565f))) {
                return this.f2562c == aVar.f2562c;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f2560a.hashCode() * 31) + this.f2562c) * 31) + (this.f2563d ? 1231 : 1237)) * 31) + this.f2564e;
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("Column{name='");
            h.append(this.f2560a);
            h.append('\'');
            h.append(", type='");
            h.append(this.f2561b);
            h.append('\'');
            h.append(", affinity='");
            h.append(this.f2562c);
            h.append('\'');
            h.append(", notNull=");
            h.append(this.f2563d);
            h.append(", primaryKeyPosition=");
            h.append(this.f2564e);
            h.append(", defaultValue='");
            h.append(this.f2565f);
            h.append('\'');
            h.append('}');
            return h.toString();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f2567a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2568b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2569c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f2570d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f2571e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f2567a = str;
            this.f2568b = str2;
            this.f2569c = str3;
            this.f2570d = Collections.unmodifiableList(list);
            this.f2571e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2567a.equals(bVar.f2567a) && this.f2568b.equals(bVar.f2568b) && this.f2569c.equals(bVar.f2569c) && this.f2570d.equals(bVar.f2570d)) {
                return this.f2571e.equals(bVar.f2571e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f2568b.hashCode();
            int hashCode2 = this.f2569c.hashCode();
            int hashCode3 = this.f2570d.hashCode();
            return this.f2571e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f2567a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("ForeignKey{referenceTable='");
            h.append(this.f2567a);
            h.append('\'');
            h.append(", onDelete='");
            h.append(this.f2568b);
            h.append('\'');
            h.append(", onUpdate='");
            h.append(this.f2569c);
            h.append('\'');
            h.append(", columnNames=");
            h.append(this.f2570d);
            h.append(", referenceColumnNames=");
            h.append(this.f2571e);
            h.append('}');
            return h.toString();
        }
    }

    public static class c implements Comparable<c> {

        /* renamed from: b  reason: collision with root package name */
        public final int f2572b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2573c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2574d;

        /* renamed from: e  reason: collision with root package name */
        public final String f2575e;

        public c(int i, int i2, String str, String str2) {
            this.f2572b = i;
            this.f2573c = i2;
            this.f2574d = str;
            this.f2575e = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i = this.f2572b - cVar2.f2572b;
            return i == 0 ? this.f2573c - cVar2.f2573c : i;
        }
    }

    /* renamed from: b.s.q.d$d  reason: collision with other inner class name */
    public static class C0049d {

        /* renamed from: a  reason: collision with root package name */
        public final String f2576a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2577b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f2578c;

        public C0049d(String str, boolean z, List<String> list) {
            this.f2576a = str;
            this.f2577b = z;
            this.f2578c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0049d.class != obj.getClass()) {
                return false;
            }
            C0049d dVar = (C0049d) obj;
            if (this.f2577b == dVar.f2577b && this.f2578c.equals(dVar.f2578c)) {
                return this.f2576a.startsWith("index_") ? dVar.f2576a.startsWith("index_") : this.f2576a.equals(dVar.f2576a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2578c.hashCode() + ((((this.f2576a.startsWith("index_") ? -1184239155 : this.f2576a.hashCode()) * 31) + (this.f2577b ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("Index{name='");
            h.append(this.f2576a);
            h.append('\'');
            h.append(", unique=");
            h.append(this.f2577b);
            h.append(", columns=");
            h.append(this.f2578c);
            h.append('}');
            return h.toString();
        }
    }

    public d(String str, Map<String, a> map, Set<b> set, Set<C0049d> set2) {
        this.f2556a = str;
        this.f2557b = Collections.unmodifiableMap(map);
        this.f2558c = Collections.unmodifiableSet(set);
        this.f2559d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* JADX INFO: finally extract failed */
    public static d a(b.w.a.b bVar, String str) {
        int i;
        int i2;
        List<c> list;
        int i3;
        b.w.a.g.a aVar = (b.w.a.g.a) bVar;
        Cursor d2 = aVar.d(c.a.a.a.a.c("PRAGMA table_info(`", str, "`)"));
        HashMap hashMap = new HashMap();
        try {
            if (d2.getColumnCount() > 0) {
                int columnIndex = d2.getColumnIndex("name");
                int columnIndex2 = d2.getColumnIndex("type");
                int columnIndex3 = d2.getColumnIndex("notnull");
                int columnIndex4 = d2.getColumnIndex("pk");
                int columnIndex5 = d2.getColumnIndex("dflt_value");
                while (d2.moveToNext()) {
                    String string = d2.getString(columnIndex);
                    hashMap.put(string, new a(string, d2.getString(columnIndex2), d2.getInt(columnIndex3) != 0, d2.getInt(columnIndex4), d2.getString(columnIndex5), 2));
                    columnIndex = columnIndex;
                }
            }
            d2.close();
            HashSet hashSet = new HashSet();
            Cursor d3 = aVar.d("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = d3.getColumnIndex("id");
                int columnIndex7 = d3.getColumnIndex("seq");
                int columnIndex8 = d3.getColumnIndex("table");
                int columnIndex9 = d3.getColumnIndex("on_delete");
                int columnIndex10 = d3.getColumnIndex("on_update");
                List<c> b2 = b(d3);
                int count = d3.getCount();
                int i4 = 0;
                while (i4 < count) {
                    d3.moveToPosition(i4);
                    if (d3.getInt(columnIndex7) != 0) {
                        i = columnIndex6;
                        i3 = columnIndex7;
                        list = b2;
                        i2 = count;
                    } else {
                        int i5 = d3.getInt(columnIndex6);
                        i = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i3 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) b2).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.f2572b == i5) {
                                arrayList.add(cVar.f2574d);
                                arrayList2.add(cVar.f2575e);
                            }
                            b2 = b2;
                            count = count;
                        }
                        list = b2;
                        i2 = count;
                        hashSet.add(new b(d3.getString(columnIndex8), d3.getString(columnIndex9), d3.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i4++;
                    columnIndex6 = i;
                    columnIndex7 = i3;
                    b2 = list;
                    count = i2;
                }
                d3.close();
                Cursor d4 = aVar.d("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = d4.getColumnIndex("name");
                    int columnIndex12 = d4.getColumnIndex("origin");
                    int columnIndex13 = d4.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (d4.moveToNext()) {
                                if ("c".equals(d4.getString(columnIndex12))) {
                                    String string2 = d4.getString(columnIndex11);
                                    boolean z = true;
                                    if (d4.getInt(columnIndex13) != 1) {
                                        z = false;
                                    }
                                    C0049d c2 = c(aVar, string2, z);
                                    if (c2 != null) {
                                        hashSet3.add(c2);
                                    }
                                }
                            }
                            d4.close();
                            hashSet2 = hashSet3;
                            return new d(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new d(str, hashMap, hashSet, hashSet2);
                } finally {
                    d4.close();
                }
            } catch (Throwable th) {
                d3.close();
                throw th;
            }
        } catch (Throwable th2) {
            d2.close();
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

    public static C0049d c(b.w.a.b bVar, String str, boolean z) {
        Cursor d2 = ((b.w.a.g.a) bVar).d(c.a.a.a.a.c("PRAGMA index_xinfo(`", str, "`)"));
        try {
            int columnIndex = d2.getColumnIndex("seqno");
            int columnIndex2 = d2.getColumnIndex("cid");
            int columnIndex3 = d2.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (d2.moveToNext()) {
                        if (d2.getInt(columnIndex2) >= 0) {
                            int i = d2.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), d2.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    C0049d dVar = new C0049d(str, z, arrayList);
                    d2.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            d2.close();
        }
    }

    public boolean equals(Object obj) {
        Set<C0049d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f2556a;
        if (str == null ? dVar.f2556a != null : !str.equals(dVar.f2556a)) {
            return false;
        }
        Map<String, a> map = this.f2557b;
        if (map == null ? dVar.f2557b != null : !map.equals(dVar.f2557b)) {
            return false;
        }
        Set<b> set2 = this.f2558c;
        if (set2 == null ? dVar.f2558c != null : !set2.equals(dVar.f2558c)) {
            return false;
        }
        Set<C0049d> set3 = this.f2559d;
        if (set3 == null || (set = dVar.f2559d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f2556a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f2557b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f2558c;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder h = c.a.a.a.a.h("TableInfo{name='");
        h.append(this.f2556a);
        h.append('\'');
        h.append(", columns=");
        h.append(this.f2557b);
        h.append(", foreignKeys=");
        h.append(this.f2558c);
        h.append(", indices=");
        h.append(this.f2559d);
        h.append('}');
        return h.toString();
    }
}
