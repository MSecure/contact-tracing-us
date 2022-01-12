package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
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

public class TableInfo {
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static class Column {
        public final int affinity;
        public final String defaultValue;
        public final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
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
            this.affinity = i3;
            this.defaultValue = str3;
            this.mCreatedFrom = i2;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || Column.class != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.mCreatedFrom == 1 && column.mCreatedFrom == 2 && (str3 = this.defaultValue) != null && !str3.equals(column.defaultValue)) {
                return false;
            }
            if (this.mCreatedFrom == 2 && column.mCreatedFrom == 1 && (str2 = column.defaultValue) != null && !str2.equals(this.defaultValue)) {
                return false;
            }
            int i = this.mCreatedFrom;
            if (i == 0 || i != column.mCreatedFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : str.equals(column.defaultValue))) {
                return this.affinity == column.affinity;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Column{name='");
            outline17.append(this.name);
            outline17.append('\'');
            outline17.append(", type='");
            outline17.append(this.type);
            outline17.append('\'');
            outline17.append(", affinity='");
            outline17.append(this.affinity);
            outline17.append('\'');
            outline17.append(", notNull=");
            outline17.append(this.notNull);
            outline17.append(", primaryKeyPosition=");
            outline17.append(this.primaryKeyPosition);
            outline17.append(", defaultValue='");
            outline17.append(this.defaultValue);
            outline17.append('\'');
            outline17.append('}');
            return outline17.toString();
        }
    }

    public static class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ForeignKey.class != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.onDelete.hashCode();
            int hashCode2 = this.onUpdate.hashCode();
            int hashCode3 = this.columnNames.hashCode();
            return this.referenceColumnNames.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.referenceTable.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("ForeignKey{referenceTable='");
            outline17.append(this.referenceTable);
            outline17.append('\'');
            outline17.append(", onDelete='");
            outline17.append(this.onDelete);
            outline17.append('\'');
            outline17.append(", onUpdate='");
            outline17.append(this.onUpdate);
            outline17.append('\'');
            outline17.append(", columnNames=");
            outline17.append(this.columnNames);
            outline17.append(", referenceColumnNames=");
            outline17.append(this.referenceColumnNames);
            outline17.append('}');
            return outline17.toString();
        }
    }

    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        public final String mFrom;
        public final int mId;
        public final int mSequence;
        public final String mTo;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.mId = i;
            this.mSequence = i2;
            this.mFrom = str;
            this.mTo = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            ForeignKeyWithSequence foreignKeyWithSequence2 = foreignKeyWithSequence;
            int i = this.mId - foreignKeyWithSequence2.mId;
            return i == 0 ? this.mSequence - foreignKeyWithSequence2.mSequence : i;
        }
    }

    public static class Index {
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String str, boolean z, List<String> list) {
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Index.class != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                return false;
            }
            if (this.name.startsWith("index_")) {
                return index.name.startsWith("index_");
            }
            return this.name.equals(index.name);
        }

        public int hashCode() {
            int i;
            if (this.name.startsWith("index_")) {
                i = -1184239155;
            } else {
                i = this.name.hashCode();
            }
            return this.columns.hashCode() + (((i * 31) + (this.unique ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Index{name='");
            outline17.append(this.name);
            outline17.append('\'');
            outline17.append(", unique=");
            outline17.append(this.unique);
            outline17.append(", columns=");
            outline17.append(this.columns);
            outline17.append('}');
            return outline17.toString();
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> set3;
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.indices = set3;
    }

    /* JADX INFO: finally extract failed */
    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        int i;
        int i2;
        List<ForeignKeyWithSequence> list;
        int i3;
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
        Cursor query = frameworkSQLiteDatabase.query(GeneratedOutlineSupport.outline11("PRAGMA table_info(`", str, "`)"));
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    hashMap.put(string, new Column(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                    columnIndex = columnIndex;
                }
            }
            query.close();
            HashSet hashSet = new HashSet();
            Cursor query2 = frameworkSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = query2.getColumnIndex("id");
                int columnIndex7 = query2.getColumnIndex("seq");
                int columnIndex8 = query2.getColumnIndex("table");
                int columnIndex9 = query2.getColumnIndex("on_delete");
                int columnIndex10 = query2.getColumnIndex("on_update");
                List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query2);
                int count = query2.getCount();
                int i4 = 0;
                while (i4 < count) {
                    query2.moveToPosition(i4);
                    if (query2.getInt(columnIndex7) != 0) {
                        i = columnIndex6;
                        i3 = columnIndex7;
                        list = readForeignKeyFieldMappings;
                        i2 = count;
                    } else {
                        int i5 = query2.getInt(columnIndex6);
                        i = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i3 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) readForeignKeyFieldMappings).iterator();
                        while (it.hasNext()) {
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) it.next();
                            if (foreignKeyWithSequence.mId == i5) {
                                arrayList.add(foreignKeyWithSequence.mFrom);
                                arrayList2.add(foreignKeyWithSequence.mTo);
                            }
                            readForeignKeyFieldMappings = readForeignKeyFieldMappings;
                            count = count;
                        }
                        list = readForeignKeyFieldMappings;
                        i2 = count;
                        hashSet.add(new ForeignKey(query2.getString(columnIndex8), query2.getString(columnIndex9), query2.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i4++;
                    columnIndex6 = i;
                    columnIndex7 = i3;
                    readForeignKeyFieldMappings = list;
                    count = i2;
                }
                query2.close();
                Cursor query3 = frameworkSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = query3.getColumnIndex("name");
                    int columnIndex12 = query3.getColumnIndex("origin");
                    int columnIndex13 = query3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (query3.moveToNext()) {
                                if ("c".equals(query3.getString(columnIndex12))) {
                                    String string2 = query3.getString(columnIndex11);
                                    boolean z = true;
                                    if (query3.getInt(columnIndex13) != 1) {
                                        z = false;
                                    }
                                    Index readIndex = readIndex(frameworkSQLiteDatabase, string2, z);
                                    if (readIndex != null) {
                                        hashSet3.add(readIndex);
                                    }
                                }
                            }
                            query3.close();
                            hashSet2 = hashSet3;
                            return new TableInfo(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new TableInfo(str, hashMap, hashSet, hashSet2);
                } finally {
                    query3.close();
                }
            } catch (Throwable th) {
                query2.close();
                throw th;
            }
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    public static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        Cursor query = ((FrameworkSQLiteDatabase) supportSQLiteDatabase).query(GeneratedOutlineSupport.outline11("PRAGMA index_xinfo(`", str, "`)"));
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (query.moveToNext()) {
                        if (query.getInt(columnIndex2) >= 0) {
                            int i = query.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), query.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    Index index = new Index(str, z, arrayList);
                    query.close();
                    return index;
                }
            }
            return null;
        } finally {
            query.close();
        }
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || TableInfo.class != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = this.name;
        if (str == null ? tableInfo.name != null : !str.equals(tableInfo.name)) {
            return false;
        }
        Map<String, Column> map = this.columns;
        if (map == null ? tableInfo.columns != null : !map.equals(tableInfo.columns)) {
            return false;
        }
        Set<ForeignKey> set2 = this.foreignKeys;
        if (set2 == null ? tableInfo.foreignKeys != null : !set2.equals(tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set3 = this.indices;
        if (set3 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Column> map = this.columns;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<ForeignKey> set = this.foreignKeys;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("TableInfo{name='");
        outline17.append(this.name);
        outline17.append('\'');
        outline17.append(", columns=");
        outline17.append(this.columns);
        outline17.append(", foreignKeys=");
        outline17.append(this.foreignKeys);
        outline17.append(", indices=");
        outline17.append(this.indices);
        outline17.append('}');
        return outline17.toString();
    }
}
