package e.j.g;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import e.b.a.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public static final Comparator<byte[]> a = new a();

    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i3 = bArr3.length;
                i2 = bArr4.length;
            } else {
                for (int i4 = 0; i4 < bArr3.length; i4++) {
                    if (bArr3[i4] != bArr4[i4]) {
                        i3 = bArr3[i4];
                        i2 = bArr4[i4];
                    }
                }
                return 0;
            }
            return (i3 == 1 ? 1 : 0) - (i2 == 1 ? 1 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[LOOP:1: B:14:0x004b->B:27:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0094 A[EDGE_INSN: B:75:0x0094->B:29:0x0094 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static k a(Context context, e eVar, CancellationSignal cancellationSignal) {
        Cursor cursor;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = eVar.a;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(f.a.a.a.a.x("No package found for authority: ", str));
        } else if (resolveContentProvider.packageName.equals(eVar.b)) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, a);
            List<List<byte[]>> list = eVar.f1591d;
            if (list == null) {
                list = m.e.o1(resources, 0);
            }
            int i2 = 0;
            while (true) {
                cursor = null;
                if (i2 >= list.size()) {
                    resolveContentProvider = null;
                    break;
                }
                ArrayList arrayList2 = new ArrayList(list.get(i2));
                Collections.sort(arrayList2, a);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                        }
                    }
                    z = true;
                    if (!z) {
                        break;
                    }
                    i2++;
                }
                z = false;
                if (!z) {
                }
            }
            if (resolveContentProvider == null) {
                return new k(1, null);
            }
            String str2 = resolveContentProvider.authority;
            ArrayList arrayList3 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str2).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
            try {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.c}, null, cancellationSignal);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    arrayList3 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex("file_id");
                    int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                    int columnIndex5 = cursor.getColumnIndex("font_weight");
                    int columnIndex6 = cursor.getColumnIndex("font_italic");
                    while (cursor.moveToNext()) {
                        arrayList3.add(new l(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, columnIndex != -1 ? cursor.getInt(columnIndex) : 0));
                    }
                }
                return new k(0, (l[]) arrayList3.toArray(new l[0]));
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else {
            StringBuilder j2 = f.a.a.a.a.j("Found content provider ", str, ", but package was not ");
            j2.append(eVar.b);
            throw new PackageManager.NameNotFoundException(j2.toString());
        }
    }
}
