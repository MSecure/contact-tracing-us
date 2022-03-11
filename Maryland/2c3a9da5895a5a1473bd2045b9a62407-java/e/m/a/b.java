package e.m.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import e.m.a.o0;
import java.util.ArrayList;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1575d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1576e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1577f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1578g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1579h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1580i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f1581j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1582k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f1583l;
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
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.f1575d = parcel.createIntArray();
        this.f1576e = parcel.createIntArray();
        this.f1577f = parcel.readInt();
        this.f1578g = parcel.readString();
        this.f1579h = parcel.readInt();
        this.f1580i = parcel.readInt();
        this.f1581j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1582k = parcel.readInt();
        this.f1583l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[(size * 5)];
        if (aVar.f1666g) {
            this.c = new ArrayList<>(size);
            this.f1575d = new int[size];
            this.f1576e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                o0.a aVar2 = aVar.a.get(i2);
                int i4 = i3 + 1;
                this.b[i3] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                l lVar = aVar2.b;
                arrayList.add(lVar != null ? lVar.f1631f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1672d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1673e;
                iArr[i7] = aVar2.f1674f;
                this.f1575d[i2] = aVar2.f1675g.ordinal();
                this.f1576e[i2] = aVar2.f1676h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1577f = aVar.f1665f;
            this.f1578g = aVar.f1668i;
            this.f1579h = aVar.s;
            this.f1580i = aVar.f1669j;
            this.f1581j = aVar.f1670k;
            this.f1582k = aVar.f1671l;
            this.f1583l = aVar.m;
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
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.f1575d);
        parcel.writeIntArray(this.f1576e);
        parcel.writeInt(this.f1577f);
        parcel.writeString(this.f1578g);
        parcel.writeInt(this.f1579h);
        parcel.writeInt(this.f1580i);
        TextUtils.writeToParcel(this.f1581j, parcel, 0);
        parcel.writeInt(this.f1582k);
        TextUtils.writeToParcel(this.f1583l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
