package f.b.a.a.a.m;

import android.database.Cursor;
import android.net.Uri;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.h0;
import f.b.b.a.g;
import f.b.b.a.r;
import f.b.b.b.a;
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
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        Uri uri;
        ArrayList<Uri> arrayList;
        r rVar = this.a;
        o oVar = this.b;
        String str = (String) obj;
        Objects.requireNonNull(rVar);
        r rVar2 = r.f2170f;
        Objects.requireNonNull(rVar2);
        Objects.requireNonNull(str);
        Iterator<String> a2 = rVar2.c.a(rVar2, str);
        ArrayList arrayList2 = new ArrayList();
        while (a2.hasNext()) {
            arrayList2.add(a2.next());
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList2);
        unmodifiableList.size();
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : unmodifiableList) {
            arrayList3.add(oVar.a().buildUpon().appendEncodedPath(str2).build());
        }
        h0 h0Var = rVar.a;
        Uri b2 = oVar.b();
        f0 f0Var = (f0) h0Var.a;
        Objects.requireNonNull(f0Var);
        i v = i.v("SELECT mostRecentSuccessfulDownload FROM DownloadServerEntity WHERE indexUri = ?", 1);
        String Z = m.h.Z(b2);
        if (Z == null) {
            v.N(1);
        } else {
            v.P(1, Z);
        }
        f0Var.a.b();
        Cursor b3 = b.b(f0Var.a, v, false, null);
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
                    a<Object> aVar = c.c;
                    f.b.a.c.b.o.b.z(4, "initialCapacity");
                    Object[] objArr = new Object[4];
                    int i2 = 0;
                    for (Uri uri2 : arrayList) {
                        if (!arrayList.isEmpty()) {
                            m mVar = new m(oVar.b(), uri2, null, uri2.equals(arrayList.get(arrayList.size() - 1)));
                            int i3 = i2 + 1;
                            if (objArr.length < i3) {
                                objArr = Arrays.copyOf(objArr, b.AbstractC0104b.b(objArr.length, i3));
                            }
                            objArr[i2] = mVar;
                            i2 = i3;
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                    String.format("Uris for server [%s]: [%s]", oVar.b(), c.p(objArr, i2));
                    return c.p(objArr, i2);
                }
            }
            uri = null;
            if (uri != null) {
            }
            a<Object> aVar2 = c.c;
            f.b.a.c.b.o.b.z(4, "initialCapacity");
            Object[] objArr2 = new Object[4];
            int i22 = 0;
            while (r3.hasNext()) {
            }
            String.format("Uris for server [%s]: [%s]", oVar.b(), c.p(objArr2, i22));
            return c.p(objArr2, i22);
        } finally {
            b3.close();
            v.V();
        }
    }
}
