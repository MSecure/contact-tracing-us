package b.a.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0006a();

    /* renamed from: b  reason: collision with root package name */
    public final int f500b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f501c;

    /* renamed from: b.a.e.a$a  reason: collision with other inner class name */
    public class C0006a implements Parcelable.Creator<a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(int i, Intent intent) {
        this.f500b = i;
        this.f501c = intent;
    }

    public a(Parcel parcel) {
        this.f500b = parcel.readInt();
        this.f501c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder h = c.a.a.a.a.h("ActivityResult{resultCode=");
        int i = this.f500b;
        h.append(i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK");
        h.append(", data=");
        h.append(this.f501c);
        h.append('}');
        return h.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f500b);
        parcel.writeInt(this.f501c == null ? 0 : 1);
        Intent intent = this.f501c;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
