package f.b.a.f.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class d extends b {
    public final /* synthetic */ List c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f3205d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f3206e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(s sVar, n nVar, List list, n nVar2) {
        super(nVar);
        this.f3206e = sVar;
        this.c = list;
        this.f3205d = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        List<String> list = this.c;
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        try {
            s sVar = this.f3206e;
            sVar.f3289d.n.i(sVar.a, arrayList, s.h(), new l(this.f3206e, this.f3205d));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "cancelDownloads(%s)", this.c);
        }
    }
}
