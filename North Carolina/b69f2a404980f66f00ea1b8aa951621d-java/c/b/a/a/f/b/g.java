package c.b.a.a.f.b;

import android.os.Parcel;
import c.b.a.a.c.k.o.l0;
import c.b.a.a.c.k.o.m0;
import c.b.a.a.e.a.a;
import c.b.a.a.e.a.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class g extends a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // c.b.a.a.e.a.a
    public boolean h0(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                c.b.a.a.c.a aVar = (c.b.a.a.c.a) c.a(parcel, c.b.a.a.c.a.CREATOR);
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
                l0 l0Var = (l0) this;
                l0Var.f2382b.post(new m0(l0Var, (n) c.a(parcel, n.CREATOR)));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
