package f.b.a.c.e.c;

import android.os.Parcel;
import android.os.Parcelable;

public final class j0 {
    public static final ClassLoader a = j0.class.getClassLoader();

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
