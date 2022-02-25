package e.m.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import e.a.d.b;
import e.p.d0;

public class n implements b {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    @Override // e.a.d.b
    public void a(Context context) {
        z<?> zVar = this.a.f1651j.a;
        zVar.f1694e.c(zVar, zVar, null);
        Bundle a2 = this.a.f2e.b.a("android:support:fragments");
        if (a2 != null) {
            Parcelable parcelable = a2.getParcelable("android:support:fragments");
            z<?> zVar2 = this.a.f1651j.a;
            if (zVar2 instanceof d0) {
                zVar2.f1694e.g0(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
