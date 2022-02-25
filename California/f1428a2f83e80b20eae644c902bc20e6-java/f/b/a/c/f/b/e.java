package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
import java.util.Locale;

public final class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new n();
    public Bundle b;

    public e(Bundle bundle) {
        this.b = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return m.h.U(this.b, ((e) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.b);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.x1(parcel, 1, this.b, false);
        m.h.M1(parcel, H1);
    }
}
