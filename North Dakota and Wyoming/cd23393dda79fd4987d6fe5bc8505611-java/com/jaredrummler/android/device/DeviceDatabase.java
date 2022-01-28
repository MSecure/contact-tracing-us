package com.jaredrummler.android.device;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.jaredrummler.android.device.DeviceName;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeviceDatabase extends SQLiteOpenHelper {
    private static final String COLUMN_CODENAME = "codename";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_NAME = "name";
    private static final String NAME = "android-devices.db";
    private static final String TABLE_DEVICES = "devices";
    private static final int VERSION = 1;
    private final Context context;
    private final File file;

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public DeviceDatabase(Context context2) {
        super(context2, NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.context = context2.getApplicationContext();
        File databasePath = context2.getDatabasePath(NAME);
        this.file = databasePath;
        if (!databasePath.exists()) {
            create();
        }
    }

    public String query(String str, String str2) {
        String[] strArr;
        String str3;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String[] strArr2 = {"name"};
        String str4 = null;
        if (str != null && str2 != null) {
            strArr = new String[]{str, str2};
            str3 = "codename LIKE ? OR model LIKE ?";
        } else if (str != null) {
            str3 = "codename LIKE ?";
            strArr = new String[]{str};
        } else {
            if (str2 != null) {
                strArr = new String[]{str2};
                str3 = "model LIKE ?";
            }
            return str4;
        }
        Cursor query = readableDatabase.query(TABLE_DEVICES, strArr2, str3, strArr, null, null, null);
        if (query.moveToFirst()) {
            str4 = query.getString(query.getColumnIndexOrThrow("name"));
        }
        close(query);
        close(readableDatabase);
        return str4;
    }

    public DeviceName.DeviceInfo queryToDevice(String str, String str2) {
        String[] strArr;
        String str3;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String[] strArr2 = {"name", COLUMN_CODENAME, COLUMN_MODEL};
        DeviceName.DeviceInfo deviceInfo = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str3 = "codename LIKE ? OR model LIKE ?";
            strArr = new String[]{str, str2};
        } else if (!TextUtils.isEmpty(str)) {
            str3 = "codename LIKE ?";
            strArr = new String[]{str};
        } else {
            if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str2};
                str3 = "model LIKE ?";
            }
            return deviceInfo;
        }
        Cursor query = readableDatabase.query(TABLE_DEVICES, strArr2, str3, strArr, null, null, null);
        if (query.moveToFirst()) {
            deviceInfo = new DeviceName.DeviceInfo(query.getString(query.getColumnIndexOrThrow("name")), query.getString(query.getColumnIndexOrThrow(COLUMN_CODENAME)), query.getString(query.getColumnIndexOrThrow(COLUMN_MODEL)));
        }
        close(query);
        close(readableDatabase);
        return deviceInfo;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i) {
            return;
        }
        if (this.context.deleteDatabase(NAME) || this.file.delete() || !this.file.exists()) {
            create();
        }
    }

    private void create() throws SQLException {
        try {
            getReadableDatabase();
            close();
            transferDatabaseAsset();
        } catch (IOException e) {
            throw new SQLException("Error creating android-devices.db database", e);
        }
    }

    private void transferDatabaseAsset() throws IOException {
        InputStream open = this.context.getAssets().open(NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                close(fileOutputStream);
                close(open);
                return;
            }
        }
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
