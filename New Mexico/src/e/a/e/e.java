package e.a.e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();
    public final IntentSender b;
    public final Intent c;

    /* renamed from: d  reason: collision with root package name */
    public final int f652d;

    /* renamed from: e  reason: collision with root package name */
    public final int f653e;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i2) {
            return new e[i2];
        }
    }

    public e(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.b = intentSender;
        this.c = intent;
        this.f652d = i2;
        this.f653e = i3;
    }

    public e(Parcel parcel) {
        this.b = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.c = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f652d = parcel.readInt();
        this.f653e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, i2);
        parcel.writeParcelable(this.c, i2);
        parcel.writeInt(this.f652d);
        parcel.writeInt(this.f653e);
    }
}
