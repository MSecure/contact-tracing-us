package e.t.p;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.os.CancellationSignal;
import e.t.g;
import e.v.a.e;
import e.v.a.f.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;

public class b {
    /* JADX INFO: finally extract failed */
    public static void a(e.v.a.b bVar) {
        ArrayList arrayList = new ArrayList();
        Cursor d2 = ((a) bVar).d(new e.v.a.a("SELECT name FROM sqlite_master WHERE type = 'trigger'"));
        while (d2.moveToNext()) {
            try {
                arrayList.add(d2.getString(0));
            } catch (Throwable th) {
                d2.close();
                throw th;
            }
        }
        d2.close();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("room_fts_content_sync_")) {
                ((a) bVar).b.execSQL(f.a.a.a.a.t("DROP TRIGGER IF EXISTS ", str));
            }
        }
    }

    public static Cursor b(g gVar, e eVar, boolean z, CancellationSignal cancellationSignal) {
        Cursor k2 = gVar.k(eVar, cancellationSignal);
        if (z && (k2 instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) k2;
            int count = abstractWindowedCursor.getCount();
            int numRows = abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count;
            if (Build.VERSION.SDK_INT < 23 || numRows < count) {
                try {
                    MatrixCursor matrixCursor = new MatrixCursor(abstractWindowedCursor.getColumnNames(), abstractWindowedCursor.getCount());
                    while (abstractWindowedCursor.moveToNext()) {
                        Object[] objArr = new Object[abstractWindowedCursor.getColumnCount()];
                        for (int i2 = 0; i2 < abstractWindowedCursor.getColumnCount(); i2++) {
                            int type = abstractWindowedCursor.getType(i2);
                            if (type == 0) {
                                objArr[i2] = null;
                            } else if (type == 1) {
                                objArr[i2] = Long.valueOf(abstractWindowedCursor.getLong(i2));
                            } else if (type == 2) {
                                objArr[i2] = Double.valueOf(abstractWindowedCursor.getDouble(i2));
                            } else if (type == 3) {
                                objArr[i2] = abstractWindowedCursor.getString(i2);
                            } else if (type == 4) {
                                objArr[i2] = abstractWindowedCursor.getBlob(i2);
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                        matrixCursor.addRow(objArr);
                    }
                    return matrixCursor;
                } finally {
                    abstractWindowedCursor.close();
                }
            }
        }
        return k2;
    }

    public static int c(File file) {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60, 4, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i2 = allocate.getInt();
                channel.close();
                return i2;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
