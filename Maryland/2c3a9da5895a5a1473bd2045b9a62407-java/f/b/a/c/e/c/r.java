package f.b.a.c.e.c;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import f.b.a.c.f.b.a;
import java.io.FileNotFoundException;

public final class r extends u implements z0 {
    public final /* synthetic */ a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(a aVar) {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
        this.a = aVar;
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        ParcelFileDescriptor parcelFileDescriptor;
        int i4 = 0;
        if (i2 == 1) {
            a aVar = this.a;
            if (aVar.b.size() > aVar.a) {
                i4 = 1;
            }
            parcel2.writeNoException();
            ClassLoader classLoader = i0.a;
            parcel2.writeInt(i4);
        } else if (i2 == 2) {
            try {
                a aVar2 = this.a;
                int i5 = aVar2.a + 1;
                aVar2.a = i5;
                parcelFileDescriptor = ParcelFileDescriptor.open(aVar2.b.get(i5 - 1), 268435456);
            } catch (FileNotFoundException unused) {
                parcelFileDescriptor = null;
            }
            parcel2.writeNoException();
            ClassLoader classLoader2 = i0.a;
            if (parcelFileDescriptor == null) {
                parcel2.writeInt(0);
            } else {
                parcel2.writeInt(1);
                parcelFileDescriptor.writeToParcel(parcel2, 1);
            }
        } else if (i2 != 3) {
            return false;
        } else {
            parcel2.writeNoException();
            ClassLoader classLoader3 = i0.a;
            parcel2.writeInt(1);
        }
        return true;
    }
}
