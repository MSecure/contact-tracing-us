package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzlh;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class ExposureWindow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExposureWindow> CREATOR = new zzd();
    public static final int REPORT_TYPE_CONFIRMED_CLINICAL_DIAGNOSIS = 2;
    public static final int REPORT_TYPE_CONFIRMED_TEST = 1;
    public static final int REPORT_TYPE_RECURSIVE = 4;
    public static final int REPORT_TYPE_SELF_REPORT = 3;
    private long zza;
    private final List<ScanInstance> zzb;
    private final int zzc;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public @interface ReportType {
    }

    ExposureWindow(long j, List<ScanInstance> list, int i) {
        this.zza = j;
        this.zzb = zzlh.zza(list);
        this.zzc = i;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private long zza = 0;
        private List<ScanInstance> zzb = zzlh.zza();
        private int zzc = 1;

        public Builder setDateMillisSinceEpoch(long j) {
            this.zza = j;
            return this;
        }

        public Builder setScanInstances(List<ScanInstance> list) {
            this.zzb = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public Builder setReportType(int i) {
            Preconditions.checkArgument(i > 0 && i < 5, "reportType (%s) must be >0 and <5", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public ExposureWindow build() {
            return new ExposureWindow(this.zza, this.zzb, this.zzc);
        }
    }

    public final long getDateMillisSinceEpoch() {
        return this.zza;
    }

    public final List<ScanInstance> getScanInstances() {
        return this.zzb;
    }

    public final int getReportType() {
        return this.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExposureWindow exposureWindow = (ExposureWindow) obj;
            return this.zzc == exposureWindow.zzc && this.zza == exposureWindow.zza && this.zzb.equals(exposureWindow.zzb);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc));
    }

    public final String toString() {
        long j = this.zza;
        int i = this.zzc;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 97);
        sb.append("ExposureWindow{dateMillisSinceEpoch=");
        sb.append(j);
        sb.append(", reportType=");
        sb.append(i);
        sb.append(", scanInstances=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeTypedList(parcel, 2, getScanInstances(), false);
        SafeParcelWriter.writeInt(parcel, 3, getReportType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
