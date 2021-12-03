package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
import java.util.Locale;

public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new o();
    public Bundle b;

    public f(Bundle bundle) {
        this.b = bundle;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return m.e.W(this.b, ((f) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.b);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        m.e.R1(parcel, 1, this.b, false);
        m.e.g2(parcel, b2);
    }
}
