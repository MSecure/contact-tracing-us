package f.b.a.f.a.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    static {
        x.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
