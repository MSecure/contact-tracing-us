package b.l.d;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import b.l.d.i0;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f1970b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f1971c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1972d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1973e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1974f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1975g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    public class a implements Parcelable.Creator<b> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.f1970b = parcel.createIntArray();
        this.f1971c = parcel.createStringArrayList();
        this.f1972d = parcel.createIntArray();
        this.f1973e = parcel.createIntArray();
        this.f1974f = parcel.readInt();
        this.f1975g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.f2035a.size();
        this.f1970b = new int[(size * 5)];
        if (aVar.f2041g) {
            this.f1971c = new ArrayList<>(size);
            this.f1972d = new int[size];
            this.f1973e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                i0.a aVar2 = aVar.f2035a.get(i2);
                int i4 = i3 + 1;
                this.f1970b[i3] = aVar2.f2042a;
                ArrayList<String> arrayList = this.f1971c;
                Fragment fragment = aVar2.f2043b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f1970b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f2044c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f2045d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f2046e;
                iArr[i7] = aVar2.f2047f;
                this.f1972d[i2] = aVar2.f2048g.ordinal();
                this.f1973e[i2] = aVar2.h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1974f = aVar.f2040f;
            this.f1975g = aVar.i;
            this.h = aVar.t;
            this.i = aVar.j;
            this.j = aVar.k;
            this.k = aVar.l;
            this.l = aVar.m;
            this.m = aVar.n;
            this.n = aVar.o;
            this.o = aVar.p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1970b);
        parcel.writeStringList(this.f1971c);
        parcel.writeIntArray(this.f1972d);
        parcel.writeIntArray(this.f1973e);
        parcel.writeInt(this.f1974f);
        parcel.writeString(this.f1975g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
