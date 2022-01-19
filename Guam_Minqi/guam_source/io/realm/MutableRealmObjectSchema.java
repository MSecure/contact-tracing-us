package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.RealmObjectSchema;
import io.realm.internal.CheckedRow;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsResults;
import io.realm.internal.Table;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.fields.FieldDescriptor;
import java.util.Locale;

public class MutableRealmObjectSchema extends RealmObjectSchema {
    public MutableRealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table) {
        super(baseRealm, realmSchema, table, new RealmObjectSchema.DynamicColumnIndices(table));
    }

    public static boolean containsAttribute(FieldAttribute[] fieldAttributeArr, FieldAttribute fieldAttribute) {
        if (!(fieldAttributeArr == null || fieldAttributeArr.length == 0)) {
            for (FieldAttribute fieldAttribute2 : fieldAttributeArr) {
                if (fieldAttribute2 == fieldAttribute) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a0 A[Catch:{ Exception -> 0x00a8 }] */
    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        Exception e;
        FieldAttribute fieldAttribute = FieldAttribute.PRIMARY_KEY;
        RealmObjectSchema.FieldMetaData fieldMetaData = RealmObjectSchema.SUPPORTED_SIMPLE_FIELDS.get(cls);
        boolean z = true;
        boolean z2 = false;
        if (fieldMetaData == null) {
            if (RealmObjectSchema.SUPPORTED_LINKED_FIELDS.containsKey(cls)) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Use addRealmObjectField() instead to add fields that link to other RealmObjects: ", str));
            } else if (RealmModel.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format(Locale.US, "Use 'addRealmObjectField()' instead to add fields that link to other RealmObjects: %s(%s)", str, cls));
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Realm doesn't support this field type: %s(%s)", str, cls));
            }
        } else if (!containsAttribute(fieldAttributeArr, fieldAttribute) || this.realm.configuration != null) {
            RealmObjectSchema.checkLegalName(str);
            checkFieldNameIsAvailable(str);
            boolean z3 = fieldMetaData.defaultNullable;
            if (containsAttribute(fieldAttributeArr, FieldAttribute.REQUIRED)) {
                z3 = false;
            }
            long addColumn = this.table.addColumn(fieldMetaData.fieldType, str, z3);
            try {
                if (fieldAttributeArr.length > 0) {
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.INDEXED)) {
                        addIndex(str);
                    } else {
                        z = false;
                    }
                    try {
                        if (containsAttribute(fieldAttributeArr, fieldAttribute)) {
                            addPrimaryKey(str);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z2 = z;
                        try {
                            long columnKey = getColumnKey(str);
                            if (z2) {
                            }
                            throw ((RuntimeException) e);
                        } catch (Exception e3) {
                            this.table.removeColumn(addColumn);
                            throw e3;
                        }
                    }
                }
                return this;
            } catch (Exception e4) {
                e = e4;
                long columnKey2 = getColumnKey(str);
                if (z2) {
                    this.table.removeSearchIndex(columnKey2);
                }
                throw ((RuntimeException) e);
            }
        } else {
            throw null;
        }
    }

    public RealmObjectSchema addIndex(String str) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        long columnKey = getColumnKey(str);
        if (!this.table.hasSearchIndex(columnKey)) {
            this.table.addSearchIndex(columnKey);
            return this;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline8(str, " already has an index."));
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addPrimaryKey(String str) {
        if (this.realm.configuration != null) {
            RealmObjectSchema.checkLegalName(str);
            checkFieldExists(str);
            String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
            if (primaryKeyForObject == null) {
                long columnKey = getColumnKey(str);
                if (this.table.getColumnType(getColumnKey(str)) != RealmFieldType.STRING && !this.table.hasSearchIndex(columnKey)) {
                    this.table.addSearchIndex(columnKey);
                }
                OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, getClassName(), str);
                return this;
            }
            throw new IllegalStateException(String.format(Locale.ENGLISH, "Field '%s' has been already defined as primary key.", primaryKeyForObject));
        }
        throw null;
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addRealmListField(String str, Class<?> cls) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldNameIsAvailable(str);
        RealmObjectSchema.FieldMetaData fieldMetaData = RealmObjectSchema.SUPPORTED_SIMPLE_FIELDS.get(cls);
        if (fieldMetaData != null) {
            this.table.addColumn(fieldMetaData.listType, str, fieldMetaData.defaultNullable);
            return this;
        } else if (cls.equals(RealmObjectSchema.class) || RealmModel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Use 'addRealmListField(String name, RealmObjectSchema schema)' instead to add lists that link to other RealmObjects: ", str));
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "RealmList does not support lists with this type: %s(%s)", str, cls));
        }
    }

    public final void checkFieldNameIsAvailable(String str) {
        if (this.table.getColumnKey(str) != -1) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Field already exists in '");
            outline15.append(getClassName());
            outline15.append("': ");
            outline15.append(str);
            throw new IllegalArgumentException(outline15.toString());
        }
    }

    @Override // io.realm.RealmObjectSchema
    public FieldDescriptor getFieldDescriptors(String str, RealmFieldType... realmFieldTypeArr) {
        return FieldDescriptor.createStandardFieldDescriptor(new SchemaConnector(this.schema), this.table, str, realmFieldTypeArr);
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema removeField(String str) {
        this.realm.checkNotInSync();
        RealmObjectSchema.checkLegalName(str);
        if (this.table.getColumnKey(str) != -1) {
            long columnKey = getColumnKey(str);
            String className = getClassName();
            if (str.equals(OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, className))) {
                OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, className, str);
            }
            this.table.removeColumn(columnKey);
            return this;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline8(str, " does not exist."));
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema removePrimaryKey() {
        this.realm.checkNotInSync();
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
        if (primaryKeyForObject != null) {
            long columnKey = this.table.getColumnKey(primaryKeyForObject);
            if (this.table.hasSearchIndex(columnKey)) {
                this.table.removeSearchIndex(columnKey);
            }
            OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, getClassName(), null);
            return this;
        }
        throw new IllegalStateException(getClassName() + " doesn't have a primary key.");
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema renameField(String str, String str2) {
        this.realm.checkNotInSync();
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        RealmObjectSchema.checkLegalName(str2);
        checkFieldNameIsAvailable(str2);
        this.table.renameColumn(getColumnKey(str), str2);
        return this;
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema transform(RealmObjectSchema.Function function) {
        OsResults createSnapshot = OsResults.createFromQuery(this.realm.sharedRealm, this.table.where(), new DescriptorOrdering()).createSnapshot();
        long size = createSnapshot.size();
        if (size <= 2147483647L) {
            int size2 = (int) createSnapshot.size();
            for (int i = 0; i < size2; i++) {
                DynamicRealmObject dynamicRealmObject = new DynamicRealmObject(this.realm, new CheckedRow(createSnapshot.getUncheckedRow(i)));
                if (RealmObject.isValid(dynamicRealmObject)) {
                    function.apply(dynamicRealmObject);
                }
            }
            return this;
        }
        throw new UnsupportedOperationException(GeneratedOutlineSupport.outline6("Too many results to iterate: ", size));
    }
}
