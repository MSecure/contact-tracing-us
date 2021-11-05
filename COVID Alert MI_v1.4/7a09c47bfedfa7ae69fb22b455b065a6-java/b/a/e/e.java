package b.a.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final IntentSender f502b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f503c;

    /* renamed from: d  reason: collision with root package name */
    public final int f504d;

    /* renamed from: e  reason: collision with root package name */
    public final int f505e;

    public class a implements Parcelable.Creator<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(IntentSender intentSender, Intent intent, int i, int i2) {
        this.f502b = intentSender;
        this.f503c = intent;
        this.f504d = i;
        this.f505e = i2;
    }

    public e(Parcel parcel) {
        this.f502b = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f503c = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f504d = parcel.readInt();
        this.f505e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f502b, i);
        parcel.writeParcelable(this.f503c, i);
        parcel.writeInt(this.f504d);
        parcel.writeInt(this.f505e);
    }
}
