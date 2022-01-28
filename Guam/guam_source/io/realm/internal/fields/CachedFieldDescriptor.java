package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.SchemaConnector;
import io.realm.internal.ColumnInfo;
import io.realm.internal.fields.FieldDescriptor;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CachedFieldDescriptor extends FieldDescriptor {
    public final String className;
    public final FieldDescriptor.SchemaProxy schema;

    public CachedFieldDescriptor(FieldDescriptor.SchemaProxy schemaProxy, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, set2);
        this.className = str;
        this.schema = schemaProxy;
    }

    @Override // io.realm.internal.fields.FieldDescriptor
    public void compileFieldDescription(List<String> list) {
        long j;
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = null;
        RealmFieldType realmFieldType = null;
        String str2 = this.className;
        int i = 0;
        while (i < size) {
            str = list.get(i);
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            ColumnInfo.ColumnDetails columnDetails = ((SchemaConnector) this.schema).schema.getColumnInfo(str2).getColumnDetails(str);
            if (columnDetails != null) {
                RealmFieldType realmFieldType2 = columnDetails.columnType;
                if (i < size - 1) {
                    verifyColumnType(str2, str, realmFieldType2, this.validInternalColumnTypes);
                    str2 = columnDetails.linkedClassName;
                }
                jArr[i] = columnDetails.columnKey;
                if (realmFieldType2 != RealmFieldType.LINKING_OBJECTS) {
                    j = 0;
                } else {
                    j = ((SchemaConnector) this.schema).schema.getTable(columnDetails.linkedClassName).nativeTableRefPtr;
                }
                jArr2[i] = j;
                i++;
                realmFieldType = realmFieldType2;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in class '%s'.", str, str2));
            }
        }
        setCompilationResults(str2, str, realmFieldType, jArr, jArr2);
    }
}
