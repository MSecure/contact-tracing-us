package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to parse class signature: <E:Ljava/lang/Object;><TE> */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzoa extends zzoj {
    public final zznx<E> zza;
    public final int zza$com$google$android$gms$internal$nearby$zznu;
    public int zzb;

    public zzoa(zznx<E> zznx, int i) {
        int size = zznx.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(ReactYogaConfigProvider.zza(i, size, "index"));
        }
        this.zza$com$google$android$gms$internal$nearby$zznu = size;
        this.zzb = i;
        this.zza = zznx;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza$com$google$android$gms$internal$nearby$zznu;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (this.zzb < this.zza$com$google$android$gms$internal$nearby$zznu) {
            int i = this.zzb;
            this.zzb = i + 1;
            return this.zza.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (this.zzb > 0) {
            int i = this.zzb - 1;
            this.zzb = i;
            return this.zza.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }
}
