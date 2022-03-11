package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes.dex */
public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new o();
    public Bundle b;

    public f(Bundle bundle) {
        this.b = bundle;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return m.e.X(this.b, ((f) obj).b);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.Z1(parcel, 1, this.b, false);
        m.e.o2(parcel, j2);
    }
}
