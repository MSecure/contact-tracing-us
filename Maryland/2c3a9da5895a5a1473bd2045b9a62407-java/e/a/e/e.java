package e.a.e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();
    public final IntentSender b;
    public final Intent c;

    /* renamed from: d  reason: collision with root package name */
    public final int f641d;

    /* renamed from: e  reason: collision with root package name */
    public final int f642e;

    public class a implements Parcelable.Creator<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i2) {
            return new e[i2];
        }
    }

    public e(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.b = intentSender;
        this.c = intent;
        this.f641d = i2;
        this.f642e = i3;
    }

    public e(Parcel parcel) {
        this.b = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.c = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f641d = parcel.readInt();
        this.f642e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, i2);
        parcel.writeParcelable(this.c, i2);
        parcel.writeInt(this.f641d);
        parcel.writeInt(this.f642e);
    }
}
