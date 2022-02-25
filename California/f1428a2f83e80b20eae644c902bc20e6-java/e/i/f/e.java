package e.i.f;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import e.b.a.m;
import e.e.f;
import e.e.h;
import e.i.f.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class e {
    public static final f<String, Typeface> a = new f<>(16);
    public static final f b = new f("fonts", 10, 10000);
    public static final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final h<String, ArrayList<f.c<d>>> f1445d = new h<>();

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f1446e = new a();

    public class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
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

    public static class b {
        public final int a;
        public final c[] b;

        public b(int i2, c[] cVarArr) {
            this.a = i2;
            this.b = cVarArr;
        }
    }

    public static class c {
        public final Uri a;
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1447d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1448e;

        public c(Uri uri, int i2, int i3, boolean z, int i4) {
            Objects.requireNonNull(uri);
            this.a = uri;
            this.b = i2;
            this.c = i3;
            this.f1447d = z;
            this.f1448e = i4;
        }
    }

    public static final class d {
        public final Typeface a;
        public final int b;

        public d(Typeface typeface, int i2) {
            this.a = typeface;
            this.b = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [e.i.f.e$c[], android.database.Cursor] */
    public static b a(Context context, CancellationSignal cancellationSignal, a aVar) {
        Cursor cursor;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = aVar.a;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(f.a.a.a.a.t("No package found for authority: ", str));
        } else if (resolveContentProvider.packageName.equals(aVar.b)) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, f1446e);
            List<List<byte[]>> list = aVar.f1442d;
            if (list == null) {
                list = m.h.P0(resources, 0);
            }
            int i2 = 0;
            while (true) {
                cursor = 0;
                if (i2 >= list.size()) {
                    resolveContentProvider = cursor;
                    break;
                }
                ArrayList arrayList2 = new ArrayList(list.get(i2));
                Collections.sort(arrayList2, f1446e);
                if (arrayList.size() == arrayList2.size()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList.size()) {
                            z = true;
                            break;
                        } else if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                z = false;
                if (z) {
                    break;
                }
                i2++;
            }
            if (resolveContentProvider == null) {
                return new b(1, cursor);
            }
            String str2 = resolveContentProvider.authority;
            ArrayList arrayList3 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str2).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
            try {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c}, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    arrayList3 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex("file_id");
                    int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                    int columnIndex5 = cursor.getColumnIndex("font_weight");
                    int columnIndex6 = cursor.getColumnIndex("font_italic");
                    while (cursor.moveToNext()) {
                        arrayList3.add(new c(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, columnIndex != -1 ? cursor.getInt(columnIndex) : 0));
                    }
                }
                return new b(0, (c[]) arrayList3.toArray(new c[0]));
            } finally {
                if (cursor != 0) {
                    cursor.close();
                }
            }
        } else {
            StringBuilder j2 = f.a.a.a.a.j("Found content provider ", str, ", but package was not ");
            j2.append(aVar.b);
            throw new PackageManager.NameNotFoundException(j2.toString());
        }
    }

    public static d b(Context context, a aVar, int i2) {
        try {
            b a2 = a(context, null, aVar);
            int i3 = a2.a;
            int i4 = -3;
            if (i3 == 0) {
                Typeface b2 = e.i.c.d.a.b(context, null, a2.b, i2);
                if (b2 != null) {
                    i4 = 0;
                }
                return new d(b2, i4);
            }
            if (i3 == 1) {
                i4 = -2;
            }
            return new d(null, i4);
        } catch (PackageManager.NameNotFoundException unused) {
            return new d(null, -1);
        }
    }
}
