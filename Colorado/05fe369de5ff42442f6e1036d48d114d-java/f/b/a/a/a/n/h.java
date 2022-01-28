package f.b.a.a.a.n;

import android.database.Cursor;
import android.net.Uri;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import f.b.a.a.a.b0.k0;
import f.b.a.a.a.b0.m0;
import f.b.a.a.a.i.e0.a;
import f.b.b.a.g;
import f.b.b.a.r;
import f.b.b.b.b;
import f.b.b.b.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ r a;
    public final /* synthetic */ o b;

    public /* synthetic */ h(r rVar, o oVar) {
        this.a = rVar;
        this.b = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        Uri uri;
        ArrayList<Uri> arrayList;
        r rVar = this.a;
        o oVar = this.b;
        String str = (String) obj;
        Objects.requireNonNull(rVar);
        r.f2265f.a("Index content is " + str);
        r rVar2 = r.f2266g;
        Objects.requireNonNull(rVar2);
        Objects.requireNonNull(str);
        Iterator<String> a2 = rVar2.c.a(rVar2, str);
        ArrayList arrayList2 = new ArrayList();
        while (a2.hasNext()) {
            arrayList2.add(a2.next());
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList2);
        a aVar = r.f2265f;
        StringBuilder i2 = f.a.a.a.a.i("Index file has ");
        i2.append(unmodifiableList.size());
        i2.append(" lines.");
        aVar.a(i2.toString());
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : unmodifiableList) {
            arrayList3.add(oVar.a().buildUpon().appendEncodedPath(str2).build());
        }
        m0 m0Var = rVar.a;
        Uri b2 = oVar.b();
        k0 k0Var = (k0) m0Var.a;
        Objects.requireNonNull(k0Var);
        i t = i.t("SELECT mostRecentSuccessfulDownload FROM DownloadServerEntity WHERE indexUri = ?", 1);
        String b0 = m.h.b0(b2);
        if (b0 == null) {
            t.J(1);
        } else {
            t.L(1, b0);
        }
        k0Var.a.b();
        Cursor b3 = b.b(k0Var.a, t, false, null);
        try {
            if (b3.moveToFirst()) {
                String string = b3.getString(0);
                if (string != null) {
                    uri = Uri.parse(string);
                    if (uri != null) {
                        boolean contains = arrayList3.contains(uri);
                        arrayList = arrayList3;
                        if (contains) {
                            arrayList = arrayList3.subList(arrayList3.indexOf(uri) + 1, arrayList3.size());
                        }
                    }
                    f.b.b.b.a<Object> aVar2 = c.c;
                    f.b.a.c.b.o.b.y(4, "initialCapacity");
                    Object[] objArr = new Object[4];
                    int i3 = 0;
                    for (Uri uri2 : arrayList) {
                        if (!arrayList.isEmpty()) {
                            m mVar = new m(oVar.b(), uri2, null, uri2.equals(arrayList.get(arrayList.size() - 1)));
                            int i4 = i3 + 1;
                            if (objArr.length < i4) {
                                objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i4));
                            }
                            objArr[i3] = mVar;
                            i3 = i4;
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                    r.f2265f.a(String.format("Uris for server [%s]: [%s]", oVar.b(), c.p(objArr, i3)));
                    return c.p(objArr, i3);
                }
            }
            uri = null;
            if (uri != null) {
            }
            f.b.b.b.a<Object> aVar22 = c.c;
            f.b.a.c.b.o.b.y(4, "initialCapacity");
            Object[] objArr2 = new Object[4];
            int i32 = 0;
            while (r3.hasNext()) {
            }
            r.f2265f.a(String.format("Uris for server [%s]: [%s]", oVar.b(), c.p(objArr2, i32)));
            return c.p(objArr2, i32);
        } finally {
            b3.close();
            t.Q();
        }
    }
}
