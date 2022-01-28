package com.google.android.gms.nearby.exposurenotification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;
import java.util.Locale;

public final class PackageConfiguration extends a {
    public static final Parcelable.Creator<PackageConfiguration> CREATOR = new zzm();
    public Bundle zza;

    public static final class PackageConfigurationBuilder {
        public Bundle zza;

        public final PackageConfiguration build() {
            return new PackageConfiguration(this.zza);
        }

        public final PackageConfigurationBuilder setValues(Bundle bundle) {
            this.zza = new Bundle(bundle);
            return this;
        }
    }

    public PackageConfiguration(Bundle bundle) {
        this.zza = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageConfiguration) {
            return i.j.X(this.zza, ((PackageConfiguration) obj).getValues());
        }
        return false;
    }

    public final Bundle getValues() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.p1(parcel, 1, getValues(), false);
        i.j.F1(parcel, e2);
    }
}
