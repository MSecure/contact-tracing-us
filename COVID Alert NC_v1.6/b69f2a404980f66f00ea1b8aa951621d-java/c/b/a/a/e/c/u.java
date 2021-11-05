package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import java.io.FileNotFoundException;

public final class u extends a implements m1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyFileProvider f2745a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
        this.f2745a = diagnosisKeyFileProvider;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        ParcelFileDescriptor parcelFileDescriptor;
        if (i == 1) {
            boolean zza = this.f2745a.zza();
            parcel2.writeNoException();
            s1.c(parcel2, zza);
        } else if (i == 2) {
            try {
                parcelFileDescriptor = ParcelFileDescriptor.open(this.f2745a.zzb(), 268435456);
            } catch (FileNotFoundException unused) {
                parcelFileDescriptor = null;
            }
            parcel2.writeNoException();
            s1.e(parcel2, parcelFileDescriptor);
        } else if (i != 3) {
            return false;
        } else {
            parcel2.writeNoException();
            s1.c(parcel2, true);
        }
        return true;
    }
}
