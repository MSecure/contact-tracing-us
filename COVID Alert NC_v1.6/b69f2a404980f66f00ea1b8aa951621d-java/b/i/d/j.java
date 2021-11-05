package b.i.d;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f996a = new Object();

    public static Bundle a(e eVar) {
        Bundle bundle = new Bundle();
        IconCompat a2 = eVar.a();
        bundle.putInt("icon", a2 != null ? a2.c() : 0);
        bundle.putCharSequence("title", eVar.j);
        bundle.putParcelable("actionIntent", eVar.k);
        Bundle bundle2 = eVar.f978a != null ? new Bundle(eVar.f978a) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", eVar.f982e);
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", b(eVar.f980c));
        bundle.putBoolean("showsUserInterface", eVar.f);
        bundle.putInt("semanticAction", eVar.g);
        return bundle;
    }

    public static Bundle[] b(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        if (lVarArr.length <= 0) {
            return bundleArr;
        }
        l lVar = lVarArr[0];
        new Bundle();
        throw null;
    }
}
