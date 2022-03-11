package f.b.a.c.e.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class c {
    public static final /* synthetic */ int a = 0;

    static {
        c.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
