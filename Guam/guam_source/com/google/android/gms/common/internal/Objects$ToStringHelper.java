package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class Objects$ToStringHelper {
    public final List<String> zza = new ArrayList();
    public final Object zzb;

    public Objects$ToStringHelper(Object obj, zzu zzu) {
        ReactYogaConfigProvider.checkNotNull(obj);
        this.zzb = obj;
    }

    @RecentlyNonNull
    public final Objects$ToStringHelper add(@RecentlyNonNull String str, Object obj) {
        List<String> list = this.zza;
        ReactYogaConfigProvider.checkNotNull(str);
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    @RecentlyNonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.zzb.getClass().getSimpleName());
        sb.append('{');
        int size = this.zza.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.zza.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
