package e.n.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import e.a.d.b;
import e.q.h0;

public class q implements b {
    public final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    @Override // e.a.d.b
    public void a(Context context) {
        b0<?> b0Var = this.a.f1766k.a;
        b0Var.f1680e.b(b0Var, b0Var, null);
        Bundle a2 = this.a.f2e.b.a("android:support:fragments");
        if (a2 != null) {
            Parcelable parcelable = a2.getParcelable("android:support:fragments");
            b0<?> b0Var2 = this.a.f1766k.a;
            if (b0Var2 instanceof h0) {
                b0Var2.f1680e.d0(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
