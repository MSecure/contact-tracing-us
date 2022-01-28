package e.r;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final UUID b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1566d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1567e;

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
        this.f1566d = parcel.readBundle(f.class.getClassLoader());
        this.f1567e = parcel.readBundle(f.class.getClassLoader());
    }

    public f(e eVar) {
        this.b = eVar.f1561g;
        this.c = eVar.c.f1575d;
        this.f1566d = eVar.f1558d;
        Bundle bundle = new Bundle();
        this.f1567e = bundle;
        eVar.f1560f.b(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeBundle(this.f1566d);
        parcel.writeBundle(this.f1567e);
    }
}
