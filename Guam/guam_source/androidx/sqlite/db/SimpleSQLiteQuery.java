package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public final Object[] mBindArgs = null;
    public final String mQuery;

    public SimpleSQLiteQuery(String str) {
        this.mQuery = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Object[] objArr = this.mBindArgs;
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                if (obj == null) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindNull(i);
                } else if (obj instanceof byte[]) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindBlob(i, (byte[]) obj);
                } else if (obj instanceof Float) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindDouble(i, (double) ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindDouble(i, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindLong(i, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindLong(i, (long) ((Integer) obj).intValue());
                } else if (obj instanceof Short) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindLong(i, (long) ((Short) obj).shortValue());
                } else if (obj instanceof Byte) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindLong(i, (long) ((Byte) obj).byteValue());
                } else if (obj instanceof String) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindString(i, (String) obj);
                } else if (obj instanceof Boolean) {
                    ((FrameworkSQLiteProgram) supportSQLiteProgram).mDelegate.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }
}
