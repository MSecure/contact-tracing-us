package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.RealmFieldType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class ColumnInfo {
    public final Map<String, ColumnDetails> columnKeysFromColumnNames;
    public final Map<String, ColumnDetails> columnkeysFromJavaFieldNames;
    public final Map<String, String> javaFieldNameToInternalNames;
    public final boolean mutable;

    public static final class ColumnDetails {
        public final long columnKey;
        public final RealmFieldType columnType;
        public final String linkedClassName;

        public ColumnDetails(Property property) {
            RealmFieldType realmFieldType;
            long nativeGetColumnKey = Property.nativeGetColumnKey(property.nativePtr);
            int nativeGetType = Property.nativeGetType(property.nativePtr);
            int i = nativeGetType & -65;
            switch (i) {
                case 0:
                    realmFieldType = RealmFieldType.INTEGER;
                    break;
                case 1:
                    realmFieldType = RealmFieldType.BOOLEAN;
                    break;
                case 2:
                    realmFieldType = RealmFieldType.STRING;
                    break;
                case 3:
                    realmFieldType = RealmFieldType.BINARY;
                    break;
                case 4:
                    realmFieldType = RealmFieldType.DATE;
                    break;
                case 5:
                    realmFieldType = RealmFieldType.FLOAT;
                    break;
                case 6:
                    realmFieldType = RealmFieldType.DOUBLE;
                    break;
                case 7:
                    realmFieldType = RealmFieldType.OBJECT;
                    break;
                default:
                    switch (i) {
                        case 128:
                            realmFieldType = RealmFieldType.INTEGER_LIST;
                            break;
                        case 129:
                            realmFieldType = RealmFieldType.BOOLEAN_LIST;
                            break;
                        case 130:
                            realmFieldType = RealmFieldType.STRING_LIST;
                            break;
                        case 131:
                            realmFieldType = RealmFieldType.BINARY_LIST;
                            break;
                        case 132:
                            realmFieldType = RealmFieldType.DATE_LIST;
                            break;
                        case 133:
                            realmFieldType = RealmFieldType.FLOAT_LIST;
                            break;
                        case 134:
                            realmFieldType = RealmFieldType.DOUBLE_LIST;
                            break;
                        case 135:
                            realmFieldType = RealmFieldType.LIST;
                            break;
                        case 136:
                            realmFieldType = RealmFieldType.LINKING_OBJECTS;
                            break;
                        default:
                            throw new IllegalArgumentException(String.format(Locale.US, "Unsupported property type: '%d'", Integer.valueOf(nativeGetType)));
                    }
            }
            String nativeGetLinkedObjectName = Property.nativeGetLinkedObjectName(property.nativePtr);
            this.columnKey = nativeGetColumnKey;
            this.columnType = realmFieldType;
            this.linkedClassName = nativeGetLinkedObjectName;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ColumnDetails[");
            sb.append(this.columnKey);
            sb.append(", ");
            sb.append(this.columnType);
            sb.append(", ");
            return GeneratedOutlineSupport.outline12(sb, this.linkedClassName, "]");
        }
    }

    public ColumnInfo(int i, boolean z) {
        this.columnkeysFromJavaFieldNames = new HashMap(i);
        this.columnKeysFromColumnNames = new HashMap(i);
        this.javaFieldNameToInternalNames = new HashMap(i);
        this.mutable = z;
    }

    public final long addColumnDetails(String str, String str2, OsObjectSchemaInfo osObjectSchemaInfo) {
        Property property = new Property(OsObjectSchemaInfo.nativeGetProperty(osObjectSchemaInfo.nativePtr, str2));
        ColumnDetails columnDetails = new ColumnDetails(property);
        this.columnkeysFromJavaFieldNames.put(str, columnDetails);
        this.columnKeysFromColumnNames.put(str2, columnDetails);
        this.javaFieldNameToInternalNames.put(str, str2);
        return Property.nativeGetColumnKey(property.nativePtr);
    }

    public abstract void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2);

    public void copyFrom(ColumnInfo columnInfo) {
        if (!this.mutable) {
            throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
        } else if (columnInfo != null) {
            this.columnkeysFromJavaFieldNames.clear();
            this.columnkeysFromJavaFieldNames.putAll(columnInfo.columnkeysFromJavaFieldNames);
            this.columnKeysFromColumnNames.clear();
            this.columnKeysFromColumnNames.putAll(columnInfo.columnKeysFromColumnNames);
            this.javaFieldNameToInternalNames.clear();
            this.javaFieldNameToInternalNames.putAll(columnInfo.javaFieldNameToInternalNames);
            copy(columnInfo, this);
        } else {
            throw new NullPointerException("Attempt to copy null ColumnInfo");
        }
    }

    public ColumnDetails getColumnDetails(String str) {
        return this.columnkeysFromJavaFieldNames.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnInfo[");
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("mutable=");
        outline15.append(this.mutable);
        sb.append(outline15.toString());
        sb.append(",");
        boolean z = false;
        if (this.columnkeysFromJavaFieldNames != null) {
            sb.append("JavaFieldNames=[");
            boolean z2 = false;
            for (Map.Entry<String, ColumnDetails> entry : this.columnkeysFromJavaFieldNames.entrySet()) {
                if (z2) {
                    sb.append(",");
                }
                sb.append(entry.getKey());
                sb.append("->");
                sb.append(entry.getValue());
                z2 = true;
            }
            sb.append("]");
        }
        if (this.columnKeysFromColumnNames != null) {
            sb.append(", InternalFieldNames=[");
            for (Map.Entry<String, ColumnDetails> entry2 : this.columnKeysFromColumnNames.entrySet()) {
                if (z) {
                    sb.append(",");
                }
                sb.append(entry2.getKey());
                sb.append("->");
                sb.append(entry2.getValue());
                z = true;
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}
