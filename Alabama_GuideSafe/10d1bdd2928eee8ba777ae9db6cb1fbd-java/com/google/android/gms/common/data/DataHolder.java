package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
    public final int zaa;
    public final String[] zab;
    public Bundle zac;
    public final CursorWindow[] zad;
    public final int zae;
    public final Bundle zaf;
    public int[] zag;
    public boolean zai = false;
    public boolean zaj = true;

    static {
        ReactYogaConfigProvider.checkNotNull(new String[0]);
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zaa = i;
        this.zab = strArr;
        this.zad = cursorWindowArr;
        this.zae = i2;
        this.zaf = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.zai) {
                this.zai = true;
                for (int i = 0; i < this.zad.length; i++) {
                    this.zad[i].close();
                }
            }
        }
    }

    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        boolean z;
        try {
            if (this.zaj && this.zad.length > 0) {
                synchronized (this) {
                    z = this.zai;
                }
                if (!z) {
                    close();
                    String obj = toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                    sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                    sb.append(obj);
                    sb.append(")");
                    Log.e("DataBuffer", sb.toString());
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        String[] strArr = this.zab;
        if (strArr != null) {
            int zza = ReactYogaConfigProvider.zza(parcel, 1);
            parcel.writeStringArray(strArr);
            ReactYogaConfigProvider.zzb(parcel, zza);
        }
        ReactYogaConfigProvider.writeTypedArray(parcel, 2, this.zad, i, false);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zae);
        ReactYogaConfigProvider.writeBundle(parcel, 4, this.zaf, false);
        ReactYogaConfigProvider.writeInt(parcel, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.zaa);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }
}
