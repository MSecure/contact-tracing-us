package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
import io.realm.internal.fields.FieldDescriptor;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class RealmObjectSchema {
    public static final Map<Class<?>, FieldMetaData> SUPPORTED_LINKED_FIELDS;
    public static final Map<Class<?>, FieldMetaData> SUPPORTED_SIMPLE_FIELDS;
    public final BaseRealm realm;
    public final RealmSchema schema;
    public final Table table;

    public static final class DynamicColumnIndices extends ColumnInfo {
        public DynamicColumnIndices(Table table) {
            super(0, false);
        }

        @Override // io.realm.internal.ColumnInfo
        public void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot copy");
        }

        @Override // io.realm.internal.ColumnInfo
        public void copyFrom(ColumnInfo columnInfo) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        @Override // io.realm.internal.ColumnInfo
        public ColumnInfo.ColumnDetails getColumnDetails(String str) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getColumnDetails'");
        }
    }

    public static final class FieldMetaData {
        public final boolean defaultNullable;
        public final RealmFieldType fieldType;
        public final RealmFieldType listType;

        public FieldMetaData(RealmFieldType realmFieldType, RealmFieldType realmFieldType2, boolean z) {
            this.fieldType = realmFieldType;
            this.listType = realmFieldType2;
            this.defaultNullable = z;
        }
    }

    public interface Function {
        void apply(DynamicRealmObject dynamicRealmObject);
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(String.class, new FieldMetaData(RealmFieldType.STRING, RealmFieldType.STRING_LIST, true));
        hashMap.put(Short.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Short.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Integer.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Integer.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Long.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Long.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Float.TYPE, new FieldMetaData(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, false));
        hashMap.put(Float.class, new FieldMetaData(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, true));
        hashMap.put(Double.TYPE, new FieldMetaData(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, false));
        hashMap.put(Double.class, new FieldMetaData(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, true));
        hashMap.put(Boolean.TYPE, new FieldMetaData(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, false));
        hashMap.put(Boolean.class, new FieldMetaData(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, true));
        hashMap.put(Byte.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Byte.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(byte[].class, new FieldMetaData(RealmFieldType.BINARY, RealmFieldType.BINARY_LIST, true));
        hashMap.put(Date.class, new FieldMetaData(RealmFieldType.DATE, RealmFieldType.DATE_LIST, true));
        SUPPORTED_SIMPLE_FIELDS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(RealmObject.class, new FieldMetaData(RealmFieldType.OBJECT, null, false));
        hashMap2.put(RealmList.class, new FieldMetaData(RealmFieldType.LIST, null, false));
        SUPPORTED_LINKED_FIELDS = Collections.unmodifiableMap(hashMap2);
    }

    public RealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table2, ColumnInfo columnInfo) {
        this.schema = realmSchema;
        this.realm = baseRealm;
        this.table = table2;
    }

    public static void checkLegalName(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (str.contains(".")) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        } else if (str.length() > 63) {
            throw new IllegalArgumentException("Field name is currently limited to max 63 characters.");
        }
    }

    public abstract RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr);

    public abstract RealmObjectSchema addPrimaryKey(String str);

    public abstract RealmObjectSchema addRealmListField(String str, Class<?> cls);

    public void checkFieldExists(String str) {
        if (this.table.getColumnKey(str) == -1) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Field name doesn't exist on object '");
            outline17.append(getClassName());
            outline17.append("': ");
            outline17.append(str);
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    public String getClassName() {
        return this.table.getClassName();
    }

    public long getColumnKey(String str) {
        long columnKey = this.table.getColumnKey(str);
        if (columnKey != -1) {
            return columnKey;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field name '%s' does not exist on schema for '%s'", str, getClassName()));
    }

    public abstract FieldDescriptor getFieldDescriptors(String str, RealmFieldType... realmFieldTypeArr);

    public abstract RealmObjectSchema removeField(String str);

    public abstract RealmObjectSchema removePrimaryKey();

    public abstract RealmObjectSchema renameField(String str, String str2);

    public abstract RealmObjectSchema transform(Function function);
}
