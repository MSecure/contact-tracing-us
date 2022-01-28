package c.b.a.a.i.b;

import android.os.Parcel;
import c.b.a.a.d.k.o.i0;
import c.b.a.a.d.k.o.j0;
import c.b.a.a.g.a.a;
import c.b.a.a.g.a.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class g extends a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // c.b.a.a.g.a.a
    public final boolean e0(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                c.b.a.a.d.a aVar = (c.b.a.a.d.a) c.a(parcel, c.b.a.a.d.a.CREATOR);
                c cVar = (c) c.a(parcel, c.CREATOR);
                break;
            case 4:
            case 6:
                Status status = (Status) c.a(parcel, Status.CREATOR);
                break;
            case 5:
            default:
                return false;
            case 7:
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                i0 i0Var = (i0) this;
                i0Var.f3003b.post(new j0(i0Var, (n) c.a(parcel, n.CREATOR)));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
