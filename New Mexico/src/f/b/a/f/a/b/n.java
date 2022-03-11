package f.b.a.f.a.b;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class n extends k<List<String>> {
    public final /* synthetic */ s c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(s sVar, f.b.a.f.a.h.n<List<String>> nVar) {
        super(sVar, nVar);
        this.c = sVar;
    }

    @Override // f.b.a.f.a.b.k, f.b.a.f.a.e.h0
    public final void n(List<Bundle> list) {
        this.b.f3289d.c(this.a);
        s.f3287g.d("onGetSessionStates", new Object[0]);
        s sVar = this.c;
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : list) {
            d1 d1Var = sVar.b;
            m2 m2Var = sVar.c;
            ArrayList arrayList2 = new ArrayList();
            c0 c0Var = c0.a;
            ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
            HashMap hashMap = new HashMap();
            int size = stringArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = stringArrayList.get(i2);
                hashMap.put(str, AssetPackState.i(bundle, str, d1Var, m2Var, c0Var));
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                hashMap.put(str2, AssetPackState.h(str2, 4, 0, 0, 0, 0.0d, 1, "", ""));
            }
            bundle.getLong("total_bytes_to_download");
            AssetPackState assetPackState = (AssetPackState) hashMap.values().iterator().next();
            if (assetPackState == null) {
                s.f3287g.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            int d2 = assetPackState.d();
            boolean z = true;
            if (!(d2 == 1 || d2 == 7 || d2 == 2 || d2 == 3)) {
                z = false;
            }
            if (z) {
                arrayList.add(assetPackState.c());
            }
        }
        this.a.b(arrayList);
    }
}
