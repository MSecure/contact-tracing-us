package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class Table implements NativeObject {
    public static final int CLASS_NAME_MAX_LENGTH;
    public static final String TABLE_PREFIX;
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final NativeContext context;
    public final long nativeTableRefPtr;
    public final OsSharedRealm sharedRealm;

    static {
        String nativeGetTablePrefix = Util.nativeGetTablePrefix();
        TABLE_PREFIX = nativeGetTablePrefix;
        CLASS_NAME_MAX_LENGTH = 63 - nativeGetTablePrefix.length();
    }

    public Table(OsSharedRealm osSharedRealm, long j) {
        NativeContext nativeContext = osSharedRealm.context;
        this.context = nativeContext;
        this.sharedRealm = osSharedRealm;
        this.nativeTableRefPtr = j;
        nativeContext.addReference(this);
    }

    public static String getClassNameForTable(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(TABLE_PREFIX)) {
            return str;
        }
        return str.substring(TABLE_PREFIX.length());
    }

    public static String getTableNameForClass(String str) {
        if (str == null) {
            return null;
        }
        return GeneratedOutlineSupport.outline12(new StringBuilder(), TABLE_PREFIX, str);
    }

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native long nativeAddColumnLink(long j, int i, String str, long j2);

    private native long nativeAddPrimitiveListColumn(long j, int i, String str, boolean z);

    private native void nativeAddSearchIndex(long j, long j2);

    private native void nativeClear(long j, boolean z);

    private native void nativeConvertColumnToNotNullable(long j, long j2, boolean z);

    private native void nativeConvertColumnToNullable(long j, long j2, boolean z);

    private native long nativeCountDouble(long j, long j2, double d);

    private native long nativeCountFloat(long j, long j2, float f);

    private native long nativeCountLong(long j, long j2, long j3);

    private native long nativeCountString(long j, long j2, String str);

    private native long nativeFindFirstBool(long j, long j2, boolean z);

    private native long nativeFindFirstDouble(long j, long j2, double d);

    private native long nativeFindFirstFloat(long j, long j2, float f);

    public static native long nativeFindFirstInt(long j, long j2, long j3);

    public static native long nativeFindFirstNull(long j, long j2);

    public static native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeFindFirstTimestamp(long j, long j2, long j3);

    public static native long nativeFreeze(long j, long j2);

    private native boolean nativeGetBoolean(long j, long j2, long j3);

    private native byte[] nativeGetByteArray(long j, long j2, long j3);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnKey(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native String[] nativeGetColumnNames(long j);

    private native int nativeGetColumnType(long j, long j2);

    private native double nativeGetDouble(long j, long j2, long j3);

    public static native long nativeGetFinalizerPtr();

    private native float nativeGetFloat(long j, long j2, long j3);

    private native long nativeGetLink(long j, long j2, long j3);

    private native long nativeGetLinkTarget(long j, long j2);

    private native long nativeGetLong(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native String nativeGetString(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2, long j3);

    private native boolean nativeHasSameSchema(long j, long j2);

    private native boolean nativeHasSearchIndex(long j, long j2);

    public static native void nativeIncrementLong(long j, long j2, long j3, long j4);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private native boolean nativeIsNull(long j, long j2, long j3);

    private native boolean nativeIsNullLink(long j, long j2, long j3);

    private native boolean nativeIsValid(long j);

    private native void nativeMoveLastOver(long j, long j2);

    public static native void nativeNullifyLink(long j, long j2, long j3);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveSearchIndex(long j, long j2);

    private native void nativeRenameColumn(long j, long j2, String str);

    public static native void nativeSetBoolean(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeSetByteArray(long j, long j2, long j3, byte[] bArr, boolean z);

    public static native void nativeSetDouble(long j, long j2, long j3, double d, boolean z);

    public static native void nativeSetFloat(long j, long j2, long j3, float f, boolean z);

    public static native void nativeSetLink(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetLong(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetNull(long j, long j2, long j3, boolean z);

    public static native void nativeSetString(long j, long j2, long j3, String str, boolean z);

    public static native void nativeSetTimestamp(long j, long j2, long j3, long j4, boolean z);

    private native long nativeSize(long j);

    private native long nativeWhere(long j);

    public static void throwDuplicatePrimaryKeyException(Object obj) {
        throw new RealmPrimaryKeyConstraintException("Value already exists: " + obj);
    }

    public long addColumn(RealmFieldType realmFieldType, String str, boolean z) {
        if (str.length() <= 63) {
            switch (realmFieldType.ordinal()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return nativeAddColumn(this.nativeTableRefPtr, realmFieldType.getNativeValue(), str, z);
                case 7:
                case 8:
                case 9:
                default:
                    throw new IllegalArgumentException("Unsupported type: " + realmFieldType);
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    return nativeAddPrimitiveListColumn(this.nativeTableRefPtr, realmFieldType.getNativeValue() - 128, str, z);
            }
        } else {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    public void addSearchIndex(long j) {
        checkImmutable();
        nativeAddSearchIndex(this.nativeTableRefPtr, j);
    }

    public void checkImmutable() {
        OsSharedRealm osSharedRealm = this.sharedRealm;
        if (osSharedRealm != null && !osSharedRealm.isInTransaction()) {
            throw new IllegalStateException("Cannot modify managed objects outside of a write transaction.");
        }
    }

    public void clear(boolean z) {
        checkImmutable();
        nativeClear(this.nativeTableRefPtr, z);
    }

    public String getClassName() {
        String classNameForTable = getClassNameForTable(getName());
        if (!Util.isEmptyString(classNameForTable)) {
            return classNameForTable;
        }
        throw new IllegalStateException("This object class is no longer part of the schema for the Realm file. It is therefor not possible to access the schema name.");
    }

    public long getColumnKey(String str) {
        if (str != null) {
            return nativeGetColumnKey(this.nativeTableRefPtr, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public String getColumnName(long j) {
        return nativeGetColumnName(this.nativeTableRefPtr, j);
    }

    public String[] getColumnNames() {
        return nativeGetColumnNames(this.nativeTableRefPtr);
    }

    public RealmFieldType getColumnType(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativeTableRefPtr, j));
    }

    public Table getLinkTarget(long j) {
        return new Table(this.sharedRealm, nativeGetLinkTarget(this.nativeTableRefPtr, j));
    }

    public String getName() {
        return nativeGetName(this.nativeTableRefPtr);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativeTableRefPtr;
    }

    public UncheckedRow getUncheckedRow(long j) {
        return UncheckedRow.getByRowKey(this.context, this, j);
    }

    public UncheckedRow getUncheckedRowByPointer(long j) {
        return new UncheckedRow(this.context, this, j);
    }

    public boolean hasSearchIndex(long j) {
        return nativeHasSearchIndex(this.nativeTableRefPtr, j);
    }

    public boolean isValid() {
        long j = this.nativeTableRefPtr;
        return j != 0 && nativeIsValid(j);
    }

    public void moveLastOver(long j) {
        checkImmutable();
        nativeMoveLastOver(this.nativeTableRefPtr, j);
    }

    public native long nativeGetRowPtr(long j, long j2);

    public void removeColumn(long j) {
        String className = getClassName();
        String nativeGetColumnName = nativeGetColumnName(this.nativeTableRefPtr, j);
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, getClassName());
        nativeRemoveColumn(this.nativeTableRefPtr, j);
        if (nativeGetColumnName.equals(primaryKeyForObject)) {
            OsObjectStore.setPrimaryKeyForObject(this.sharedRealm, className, null);
        }
    }

    public void removeSearchIndex(long j) {
        checkImmutable();
        nativeRemoveSearchIndex(this.nativeTableRefPtr, j);
    }

    public void renameColumn(long j, String str) {
        if (str.length() <= 63) {
            String nativeGetColumnName = nativeGetColumnName(this.nativeTableRefPtr, j);
            String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, getClassName());
            nativeRenameColumn(this.nativeTableRefPtr, j, str);
            if (nativeGetColumnName.equals(primaryKeyForObject)) {
                try {
                    OsObjectStore.setPrimaryKeyForObject(this.sharedRealm, getClassName(), str);
                } catch (Exception e) {
                    nativeRenameColumn(this.nativeTableRefPtr, j, nativeGetColumnName);
                    throw new RuntimeException(e);
                }
            }
        } else {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    public void setLong(long j, long j2, long j3, boolean z) {
        checkImmutable();
        nativeSetLong(this.nativeTableRefPtr, j, j2, j3, z);
    }

    public String toString() {
        long nativeGetColumnCount = nativeGetColumnCount(this.nativeTableRefPtr);
        String name = getName();
        StringBuilder sb = new StringBuilder("The Table ");
        if (name != null && !name.isEmpty()) {
            sb.append(getName());
            sb.append(" ");
        }
        sb.append("contains ");
        sb.append(nativeGetColumnCount);
        sb.append(" columns: ");
        String[] nativeGetColumnNames = nativeGetColumnNames(this.nativeTableRefPtr);
        int length = nativeGetColumnNames.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            String str = nativeGetColumnNames[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(str);
            i++;
            z = false;
        }
        sb.append(".");
        sb.append(" And ");
        sb.append(nativeSize(this.nativeTableRefPtr));
        sb.append(" rows.");
        return sb.toString();
    }

    public TableQuery where() {
        return new TableQuery(this.context, this, nativeWhere(this.nativeTableRefPtr));
    }
}
