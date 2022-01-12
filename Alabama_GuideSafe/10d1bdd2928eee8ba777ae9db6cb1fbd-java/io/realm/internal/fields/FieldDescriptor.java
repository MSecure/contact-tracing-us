package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.SchemaConnector;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class FieldDescriptor {
    public static final Set<RealmFieldType> ALL_LINK_FIELD_TYPES;
    public static final Pattern FIELD_SEPARATOR = Pattern.compile("\\.");
    public static final Set<RealmFieldType> NO_LINK_FIELD_TYPE = Collections.emptySet();
    public static final Set<RealmFieldType> OBJECT_LINK_FIELD_TYPE;
    public static final Set<RealmFieldType> SIMPLE_LINK_FIELD_TYPES;
    public long[] columnKeys;
    public final List<String> fields;
    public String finalColumnName;
    public RealmFieldType finalColumnType;
    public long[] nativeTablePointers;
    public final Set<RealmFieldType> validFinalColumnTypes;
    public final Set<RealmFieldType> validInternalColumnTypes;

    public interface SchemaProxy {
    }

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(RealmFieldType.OBJECT);
        hashSet.add(RealmFieldType.LIST);
        hashSet.add(RealmFieldType.LINKING_OBJECTS);
        ALL_LINK_FIELD_TYPES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(RealmFieldType.OBJECT);
        hashSet2.add(RealmFieldType.LIST);
        SIMPLE_LINK_FIELD_TYPES = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet(1);
        hashSet3.add(RealmFieldType.LIST);
        Collections.unmodifiableSet(hashSet3);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add(RealmFieldType.OBJECT);
        OBJECT_LINK_FIELD_TYPE = Collections.unmodifiableSet(hashSet4);
    }

    public FieldDescriptor(String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        List<String> list;
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Invalid query: field name is empty");
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != str.length() - 1) {
            if (lastIndexOf > -1) {
                list = Arrays.asList(FIELD_SEPARATOR.split(str));
            } else {
                list = Collections.singletonList(str);
            }
            this.fields = list;
            if (list.size() > 0) {
                this.validInternalColumnTypes = set;
                this.validFinalColumnTypes = set2;
                return;
            }
            throw new IllegalArgumentException("Invalid query: Empty field descriptor");
        }
        throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
    }

    public static FieldDescriptor createFieldDescriptor(SchemaProxy schemaProxy, Table table, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        FieldDescriptor fieldDescriptor;
        if (schemaProxy != null) {
            if (((SchemaConnector) schemaProxy).schema.columnIndices != null) {
                String className = table.getClassName();
                if (set == null) {
                    set = ALL_LINK_FIELD_TYPES;
                }
                fieldDescriptor = new CachedFieldDescriptor(schemaProxy, className, str, set, set2);
                return fieldDescriptor;
            }
        }
        if (set == null) {
            set = SIMPLE_LINK_FIELD_TYPES;
        }
        fieldDescriptor = new DynamicFieldDescriptor(table, str, set, set2);
        return fieldDescriptor;
    }

    public static FieldDescriptor createStandardFieldDescriptor(SchemaProxy schemaProxy, Table table, String str, RealmFieldType... realmFieldTypeArr) {
        return createFieldDescriptor(schemaProxy, table, str, null, new HashSet(Arrays.asList(realmFieldTypeArr)));
    }

    public abstract void compileFieldDescription(List<String> list);

    public final void compileIfNecessary() {
        if (this.finalColumnType == null) {
            compileFieldDescription(this.fields);
        }
    }

    public final long[] getColumnKeys() {
        compileIfNecessary();
        long[] jArr = this.columnKeys;
        return Arrays.copyOf(jArr, jArr.length);
    }

    public final void setCompilationResults(String str, String str2, RealmFieldType realmFieldType, long[] jArr, long[] jArr2) {
        Set<RealmFieldType> set = this.validFinalColumnTypes;
        if (set != null && set.size() > 0) {
            verifyColumnType(str, str2, realmFieldType, this.validFinalColumnTypes);
        }
        this.finalColumnName = str2;
        this.finalColumnType = realmFieldType;
        this.columnKeys = jArr;
        this.nativeTablePointers = jArr2;
    }

    public final void verifyColumnType(String str, String str2, RealmFieldType realmFieldType, Set<RealmFieldType> set) {
        if (!set.contains(realmFieldType)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' in class '%s' is of invalid type '%s'.", str2, str, realmFieldType.toString()));
        }
    }
}
