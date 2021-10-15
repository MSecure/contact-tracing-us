package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import c.b.a.a.g.e.na;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ExposureWindow extends a {
    public static final Parcelable.Creator<ExposureWindow> CREATOR = new zzl();
    public long zza;
    public final List<ScanInstance> zzb;
    @ReportType
    public final int zzc;
    @Infectiousness
    public final int zzd;
    @CalibrationConfidence
    public final int zze;

    public static class Builder {
        public long zza = 0;
        public List<ScanInstance> zzb = na.w();
        @ReportType
        public int zzc = 1;
        @Infectiousness
        public int zzd = 1;
        @CalibrationConfidence
        public int zze = 0;

        public ExposureWindow build() {
            return new ExposureWindow(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setCalibrationConfidence(@CalibrationConfidence int i) {
            t.D(zzg.zza(i), String.format(Locale.getDefault(), "calibrationConfidence (%d) is invalid", Integer.valueOf(i)));
            this.zze = i;
            return this;
        }

        public Builder setDateMillisSinceEpoch(long j) {
            this.zza = j;
            return this;
        }

        public Builder setInfectiousness(@Infectiousness int i) {
            t.D(zzi.zza(i), String.format(Locale.getDefault(), "infectiousness (%d) is invalid", Integer.valueOf(i)));
            this.zzd = i;
            return this;
        }

        public Builder setReportType(@ReportType int i) {
            t.u(i > 0 && i < 5, "reportType (%d) is not allowed", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public Builder setScanInstances(List<ScanInstance> list) {
            t.C(list);
            this.zzb = list;
            return this;
        }
    }

    public ExposureWindow(long j, List<ScanInstance> list, @ReportType int i, @Infectiousness int i2, @CalibrationConfidence int i3) {
        this.zza = j;
        this.zzb = na.q(list);
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ExposureWindow.class == obj.getClass()) {
            ExposureWindow exposureWindow = (ExposureWindow) obj;
            return this.zzc == exposureWindow.zzc && this.zza == exposureWindow.zza && this.zzb.equals(exposureWindow.zzb) && this.zzd == exposureWindow.zzd && this.zze == exposureWindow.zze;
        }
    }

    @CalibrationConfidence
    public final int getCalibrationConfidence() {
        return this.zze;
    }

    public final long getDateMillisSinceEpoch() {
        return this.zza;
    }

    @Infectiousness
    public final int getInfectiousness() {
        return this.zzd;
    }

    @ReportType
    public final int getReportType() {
        return this.zzc;
    }

    public final List<ScanInstance> getScanInstances() {
        return this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze)});
    }

    public final String toString() {
        long j = this.zza;
        int i = this.zzc;
        String valueOf = String.valueOf(this.zzb);
        int i2 = this.zzd;
        int i3 = this.zze;
        StringBuilder sb = new StringBuilder(valueOf.length() + 160);
        sb.append("ExposureWindow{dateMillisSinceEpoch=");
        sb.append(j);
        sb.append(", reportType=");
        sb.append(i);
        sb.append(", scanInstances=");
        sb.append(valueOf);
        sb.append(", infectiousness=");
        sb.append(i2);
        sb.append(", calibrationConfidence=");
        sb.append(i3);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.t3(parcel, 1, getDateMillisSinceEpoch());
        t.z3(parcel, 2, getScanInstances(), false);
        t.q3(parcel, 3, getReportType());
        t.q3(parcel, 4, getInfectiousness());
        t.q3(parcel, 5, getCalibrationConfidence());
        t.w4(parcel, m);
    }
}
