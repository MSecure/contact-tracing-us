package e.t;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final UUID b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1926d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1927e;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    public f(Parcel parcel) {
        this.b = UUID.fromString(parcel.readString());
        this.c = parcel.readInt();
        this.f1926d = parcel.readBundle(f.class.getClassLoader());
        this.f1927e = parcel.readBundle(f.class.getClassLoader());
    }

    public f(e eVar) {
        this.b = eVar.f1921g;
        this.c = eVar.c.f1935d;
        this.f1926d = eVar.f1918d;
        Bundle bundle = new Bundle();
        this.f1927e = bundle;
        eVar.f1920f.b(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeBundle(this.f1926d);
        parcel.writeBundle(this.f1927e);
    }
}
