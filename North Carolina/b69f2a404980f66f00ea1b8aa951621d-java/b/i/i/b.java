package b.i.i;

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
import android.os.Handler;
import b.b.k.i;
import b.e.h;
import b.i.i.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b.e.f<String, Typeface> f1073a = new b.e.f<>(16);

    /* renamed from: b  reason: collision with root package name */
    public static final c f1074b = new c("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1075c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final h<String, ArrayList<c.AbstractC0022c<g>>> f1076d = new h<>();

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f1077e = new d();

    public class a implements Callable<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1078a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1079b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f1080c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1081d;

        public a(Context context, a aVar, int i, String str) {
            this.f1078a = context;
            this.f1079b = aVar;
            this.f1080c = i;
            this.f1081d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public g call() {
            g b2 = b.b(this.f1078a, this.f1079b, this.f1080c);
            Typeface typeface = b2.f1092a;
            if (typeface != null) {
                b.f1073a.b(this.f1081d, typeface);
            }
            return b2;
        }
    }

    /* renamed from: b.i.i.b$b  reason: collision with other inner class name */
    public class C0021b implements c.AbstractC0022c<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.i.e.b.g f1082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f1083b;

        public C0021b(b.i.e.b.g gVar, Handler handler) {
            this.f1082a = gVar;
            this.f1083b = handler;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.i.i.c.AbstractC0022c
        public void a(g gVar) {
            b.i.e.b.g gVar2;
            int i;
            g gVar3 = gVar;
            if (gVar3 == null) {
                gVar2 = this.f1082a;
                i = 1;
            } else {
                i = gVar3.f1093b;
                if (i == 0) {
                    this.f1082a.b(gVar3.f1092a, this.f1083b);
                    return;
                }
                gVar2 = this.f1082a;
            }
            gVar2.a(i, this.f1083b);
        }
    }

    public class c implements c.AbstractC0022c<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1084a;

        public c(String str) {
            this.f1084a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r0 >= r1.size()) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r1.get(r0).a(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            r0 = 0;
         */
        /* renamed from: b */
        public void a(g gVar) {
            synchronized (b.f1075c) {
                ArrayList<c.AbstractC0022c<g>> arrayList = b.f1076d.get(this.f1084a);
                if (arrayList != null) {
                    b.f1076d.remove(this.f1084a);
                }
            }
        }
    }

    public class d implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i2 = bArr3.length;
                i = bArr4.length;
            } else {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i2 = bArr3[i3];
                        i = bArr4[i3];
                    }
                }
                return 0;
            }
            return (i2 == 1 ? 1 : 0) - (i == 1 ? 1 : 0);
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f1085a;

        /* renamed from: b  reason: collision with root package name */
        public final f[] f1086b;

        public e(int i, f[] fVarArr) {
            this.f1085a = i;
            this.f1086b = fVarArr;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f1087a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1088b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1089c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1090d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1091e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            if (uri != null) {
                this.f1087a = uri;
                this.f1088b = i;
                this.f1089c = i2;
                this.f1090d = z;
                this.f1091e = i3;
                return;
            }
            throw null;
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f1092a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1093b;

        public g(Typeface typeface, int i) {
            this.f1092a = typeface;
            this.f1093b = i;
        }
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [b.i.i.b$f[], android.database.Cursor] */
    public static e a(Context context, CancellationSignal cancellationSignal, a aVar) {
        Cursor cursor;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = aVar.f1068a;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(c.a.a.a.a.o("No package found for authority: ", str));
        } else if (resolveContentProvider.packageName.equals(aVar.f1069b)) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, f1077e);
            List<List<byte[]>> list = aVar.f1071d;
            if (list == null) {
                list = i.j.O0(resources, aVar.f1072e);
            }
            int i = 0;
            while (true) {
                cursor = 0;
                if (i >= list.size()) {
                    resolveContentProvider = cursor;
                    break;
                }
                ArrayList arrayList2 = new ArrayList(list.get(i));
                Collections.sort(arrayList2, f1077e);
                if (arrayList.size() == arrayList2.size()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            z = true;
                            break;
                        } else if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                z = false;
                if (z) {
                    break;
                }
                i++;
            }
            if (resolveContentProvider == null) {
                return new e(1, cursor);
            }
            String str2 = resolveContentProvider.authority;
            ArrayList arrayList3 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str2).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
            try {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f1070c}, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    arrayList3 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex("file_id");
                    int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                    int columnIndex5 = cursor.getColumnIndex("font_weight");
                    int columnIndex6 = cursor.getColumnIndex("font_italic");
                    while (cursor.moveToNext()) {
                        arrayList3.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, columnIndex != -1 ? cursor.getInt(columnIndex) : 0));
                    }
                }
                return new e(0, (f[]) arrayList3.toArray(new f[0]));
            } finally {
                if (cursor != 0) {
                    cursor.close();
                }
            }
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + aVar.f1069b);
        }
    }

    public static g b(Context context, a aVar, int i) {
        try {
            e a2 = a(context, null, aVar);
            int i2 = a2.f1085a;
            int i3 = -3;
            if (i2 == 0) {
                Typeface b2 = b.i.f.d.f1054a.b(context, null, a2.f1086b, i);
                if (b2 != null) {
                    i3 = 0;
                }
                return new g(b2, i3);
            }
            if (i2 == 1) {
                i3 = -2;
            }
            return new g(null, i3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        r3 = b.i.i.b.f1074b;
        r4 = new b.i.i.b.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        if (r3 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r3.a(new b.i.i.d(r3, r1, new android.os.Handler(), r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        throw null;
     */
    public static Typeface c(Context context, a aVar, b.i.e.b.g gVar, Handler handler, boolean z, int i, int i2) {
        String str = aVar.f + "-" + i2;
        Typeface a2 = f1073a.a(str);
        if (a2 != null) {
            if (gVar != null) {
                gVar.d(a2);
            }
            return a2;
        } else if (!z || i != -1) {
            a aVar2 = new a(context, aVar, i2, str);
            if (z) {
                try {
                    return ((g) f1074b.b(aVar2, i)).f1092a;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                C0021b bVar = gVar == null ? null : new C0021b(gVar, handler);
                synchronized (f1075c) {
                    ArrayList<c.AbstractC0022c<g>> orDefault = f1076d.getOrDefault(str, null);
                    if (orDefault != null) {
                        if (bVar != null) {
                            orDefault.add(bVar);
                        }
                        return null;
                    } else if (bVar != null) {
                        ArrayList<c.AbstractC0022c<g>> arrayList = new ArrayList<>();
                        arrayList.add(bVar);
                        f1076d.put(str, arrayList);
                    }
                }
            }
        } else {
            g b2 = b(context, aVar, i2);
            if (gVar != null) {
                int i3 = b2.f1093b;
                if (i3 == 0) {
                    gVar.b(b2.f1092a, handler);
                } else {
                    gVar.a(i3, handler);
                }
            }
            return b2.f1092a;
        }
    }

    public static Map<Uri, ByteBuffer> d(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.f1091e == 0) {
                Uri uri = fVar.f1087a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, i.j.B0(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
