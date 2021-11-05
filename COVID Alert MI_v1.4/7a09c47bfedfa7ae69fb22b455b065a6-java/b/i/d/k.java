package b.i.d;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1689a = new Object();

    public static Bundle a(f fVar) {
        Bundle bundle = new Bundle();
        IconCompat a2 = fVar.a();
        bundle.putInt("icon", a2 != null ? a2.c() : 0);
        bundle.putCharSequence("title", fVar.j);
        bundle.putParcelable("actionIntent", fVar.k);
        Bundle bundle2 = fVar.f1665a != null ? new Bundle(fVar.f1665a) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", fVar.f1669e);
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", b(fVar.f1667c));
        bundle.putBoolean("showsUserInterface", fVar.f1670f);
        bundle.putInt("semanticAction", fVar.f1671g);
        return bundle;
    }

    public static Bundle[] b(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        if (mVarArr.length <= 0) {
            return bundleArr;
        }
        m mVar = mVarArr[0];
        new Bundle();
        throw null;
    }
}
