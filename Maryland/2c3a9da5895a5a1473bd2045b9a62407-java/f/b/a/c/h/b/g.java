package f.b.a.c.h.b;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.l.l.x;
import f.b.a.c.b.l.l.y;
import f.b.a.c.e.a.a;
import f.b.a.c.e.a.c;

public abstract class g extends a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // f.b.a.c.e.a.a
    public final boolean F(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 3:
                f.b.a.c.b.a aVar = (f.b.a.c.b.a) c.a(parcel, f.b.a.c.b.a.CREATOR);
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
                x xVar = (x) this;
                xVar.b.post(new y(xVar, (n) c.a(parcel, n.CREATOR)));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
