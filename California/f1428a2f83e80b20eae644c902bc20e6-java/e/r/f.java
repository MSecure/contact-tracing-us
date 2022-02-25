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
    public final Bundle f1736d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1737e;

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
        this.f1736d = parcel.readBundle(f.class.getClassLoader());
        this.f1737e = parcel.readBundle(f.class.getClassLoader());
    }

    public f(e eVar) {
        this.b = eVar.f1731g;
        this.c = eVar.c.f1745d;
        this.f1736d = eVar.f1728d;
        Bundle bundle = new Bundle();
        this.f1737e = bundle;
        eVar.f1730f.b(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeBundle(this.f1736d);
        parcel.writeBundle(this.f1737e);
    }
}
