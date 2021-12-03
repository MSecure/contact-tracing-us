package e.s;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final UUID b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1841d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1842e;

    public class a implements Parcelable.Creator<f> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    public f(Parcel parcel) {
        this.b = UUID.fromString(parcel.readString());
        this.c = parcel.readInt();
        this.f1841d = parcel.readBundle(f.class.getClassLoader());
        this.f1842e = parcel.readBundle(f.class.getClassLoader());
    }

    public f(e eVar) {
        this.b = eVar.f1836g;
        this.c = eVar.c.f1850d;
        this.f1841d = eVar.f1833d;
        Bundle bundle = new Bundle();
        this.f1842e = bundle;
        eVar.f1835f.b(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeBundle(this.f1841d);
        parcel.writeBundle(this.f1842e);
    }
}
