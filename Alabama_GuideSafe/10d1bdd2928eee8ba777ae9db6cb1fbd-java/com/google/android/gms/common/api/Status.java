package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new zzb();
    @RecentlyNonNull
    public static final Status RESULT_CANCELED = new Status(16, null);
    @RecentlyNonNull
    public static final Status RESULT_INTERRUPTED = new Status(14, null);
    @RecentlyNonNull
    public static final Status RESULT_SUCCESS = new Status(0, null);
    @RecentlyNonNull
    public static final Status RESULT_TIMEOUT = new Status(15, null);
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public final PendingIntent zze;
    public final ConnectionResult zzf;

    public Status(int i, int i2, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.zzb != status.zzb || this.zzc != status.zzc || !ReactYogaConfigProvider.equal(this.zzd, status.zzd) || !ReactYogaConfigProvider.equal(this.zze, status.zze) || !ReactYogaConfigProvider.equal(this.zzf, status.zzf)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.Result
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf});
    }

    @RecentlyNonNull
    public final boolean isSuccess() {
        return this.zzc <= 0;
    }

    @RecentlyNonNull
    public final String toString() {
        Objects$ToStringHelper stringHelper = ReactYogaConfigProvider.toStringHelper(this);
        String str = this.zzd;
        if (str == null) {
            str = ReactYogaConfigProvider.getStatusCodeString(this.zzc);
        }
        stringHelper.add("statusCode", str);
        stringHelper.add("resolution", this.zze);
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zzc);
        ReactYogaConfigProvider.writeString(parcel, 2, this.zzd, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, this.zze, i, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, this.zzf, i, false);
        ReactYogaConfigProvider.writeInt(parcel, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.zzb);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public Status(@RecentlyNonNull int i, String str) {
        this.zzb = 1;
        this.zzc = i;
        this.zzd = str;
        this.zze = null;
        this.zzf = null;
    }

    public Status(@RecentlyNonNull int i, String str, PendingIntent pendingIntent) {
        this.zzb = 1;
        this.zzc = i;
        this.zzd = str;
        this.zze = null;
        this.zzf = null;
    }
}
