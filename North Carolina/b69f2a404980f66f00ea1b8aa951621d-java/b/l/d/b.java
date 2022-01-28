package b.l.d;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import b.l.d.z;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f1248b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f1249c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1250d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1251e;
    public final int f;
    public final String g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    public static class a implements Parcelable.Creator<b> {
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
        this.f1248b = parcel.createIntArray();
        this.f1249c = parcel.createStringArrayList();
        this.f1250d = parcel.createIntArray();
        this.f1251e = parcel.createIntArray();
        this.f = parcel.readInt();
        this.g = parcel.readString();
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
        int size = aVar.f1365a.size();
        this.f1248b = new int[(size * 5)];
        if (aVar.g) {
            this.f1249c = new ArrayList<>(size);
            this.f1250d = new int[size];
            this.f1251e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                z.a aVar2 = aVar.f1365a.get(i2);
                int i4 = i3 + 1;
                this.f1248b[i3] = aVar2.f1370a;
                ArrayList<String> arrayList = this.f1249c;
                Fragment fragment = aVar2.f1371b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f1248b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f1372c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1373d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1374e;
                iArr[i7] = aVar2.f;
                this.f1250d[i2] = aVar2.g.ordinal();
                this.f1251e[i2] = aVar2.h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f = aVar.f;
            this.g = aVar.i;
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
        parcel.writeIntArray(this.f1248b);
        parcel.writeStringList(this.f1249c);
        parcel.writeIntArray(this.f1250d);
        parcel.writeIntArray(this.f1251e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
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
