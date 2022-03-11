package e.a.e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0010a();
    public final int b;
    public final Intent c;

    /* renamed from: e.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0010a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(int i2, Intent intent) {
        this.b = i2;
        this.c = intent;
    }

    public a(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ActivityResult{resultCode=");
        int i2 = this.b;
        h2.append(i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK");
        h2.append(", data=");
        h2.append(this.c);
        h2.append('}');
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c == null ? 0 : 1);
        Intent intent = this.c;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }
}
