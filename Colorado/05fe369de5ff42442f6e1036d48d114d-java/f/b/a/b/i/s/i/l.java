package f.b.a.b.i.s.i;

import android.database.Cursor;
import f.b.a.b.b;
import f.b.a.b.i.s.i.t;
import java.util.ArrayList;

public final /* synthetic */ class l implements t.b {
    public static final l a = new l();

    @Override // f.b.a.b.i.s.i.t.b
    public Object a(Object obj) {
        Cursor cursor = (Cursor) obj;
        b bVar = t.f2565f;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }
}
