package e.m.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import e.a.d.b;
import e.p.d0;

public class q implements b {
    public final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    @Override // e.a.d.b
    public void a(Context context) {
        c0<?> c0Var = this.a.f1678k.a;
        c0Var.f1585e.c(c0Var, c0Var, null);
        Bundle a2 = this.a.f2e.b.a("android:support:fragments");
        if (a2 != null) {
            Parcelable parcelable = a2.getParcelable("android:support:fragments");
            c0<?> c0Var2 = this.a.f1678k.a;
            if (c0Var2 instanceof d0) {
                c0Var2.f1585e.g0(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
