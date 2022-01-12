package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zas> CREATOR = new zav();
    public final int zaa;
    public IBinder zab;
    public ConnectionResult zac;
    public boolean zad;
    public boolean zae;

    public zas(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zaa = i;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = z;
        this.zae = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zas)) {
            return false;
        }
        zas zas = (zas) obj;
        return this.zac.equals(zas.zac) && ReactYogaConfigProvider.equal(zaa(), zas.zaa());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zaa);
        ReactYogaConfigProvider.writeIBinder(parcel, 2, this.zab, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, this.zac, i, false);
        ReactYogaConfigProvider.writeBoolean(parcel, 4, this.zad);
        ReactYogaConfigProvider.writeBoolean(parcel, 5, this.zae);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public final IAccountAccessor zaa() {
        IBinder iBinder = this.zab;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }
}
