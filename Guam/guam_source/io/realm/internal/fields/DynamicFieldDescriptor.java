package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DynamicFieldDescriptor extends FieldDescriptor {
    public final Table table;

    public DynamicFieldDescriptor(Table table2, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str, set, set2);
        this.table = table2;
    }

    @Override // io.realm.internal.fields.FieldDescriptor
    public void compileFieldDescription(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        Table table2 = this.table;
        String str = null;
        String str2 = null;
        RealmFieldType realmFieldType = null;
        for (int i = 0; i < size; i++) {
            str2 = list.get(i);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            str = table2.getClassName();
            long columnKey = table2.getColumnKey(str2);
            if (columnKey >= 0) {
                realmFieldType = table2.getColumnType(columnKey);
                if (i < size - 1) {
                    verifyColumnType(str, str2, realmFieldType, this.validInternalColumnTypes);
                    table2 = table2.getLinkTarget(columnKey);
                }
                jArr[i] = columnKey;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", str2, str));
            }
        }
        setCompilationResults(str, str2, realmFieldType, jArr, new long[size]);
    }
}
