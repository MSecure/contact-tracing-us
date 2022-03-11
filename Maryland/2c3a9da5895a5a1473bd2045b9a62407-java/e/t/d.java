package e.t;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.MultiInstanceInvalidationService;
import e.t.c;

public abstract class d extends Binder implements IInterface {
    public d() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            int m = ((MultiInstanceInvalidationService.b) this).m(c.a.k(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(m);
            return true;
        } else if (i2 == 2) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            ((MultiInstanceInvalidationService.b) this).E(c.a.k(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        } else if (i2 == 3) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            ((MultiInstanceInvalidationService.b) this).k(parcel.readInt(), parcel.createStringArray());
            return true;
        } else if (i2 != 1598968902) {
            return super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
    }
}
