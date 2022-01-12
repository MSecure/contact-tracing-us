package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();
    public String zzm;
    public DataHolder zzn;
    public ParcelFileDescriptor zzo;
    public long zzp;
    public byte[] zzq;

    public SafeBrowsingData() {
        this.zzm = null;
        this.zzn = null;
        this.zzo = null;
        this.zzp = 0;
        this.zzq = null;
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.zzm = str;
        this.zzn = dataHolder;
        this.zzo = parcelFileDescriptor;
        this.zzp = j;
        this.zzq = bArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.zzo;
        zzj.zza(this, parcel, i);
        this.zzo = null;
    }
}
