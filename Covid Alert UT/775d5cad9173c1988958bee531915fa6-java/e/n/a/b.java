package e.n.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import e.n.a.m0;
import java.util.ArrayList;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1670d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1671e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1672f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1673g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1674h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1675i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f1676j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1677k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f1678l;
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
        this.f1670d = parcel.createIntArray();
        this.f1671e = parcel.createIntArray();
        this.f1672f = parcel.readInt();
        this.f1673g = parcel.readString();
        this.f1674h = parcel.readInt();
        this.f1675i = parcel.readInt();
        this.f1676j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1677k = parcel.readInt();
        this.f1678l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[(size * 5)];
        if (aVar.f1745g) {
            this.c = new ArrayList<>(size);
            this.f1670d = new int[size];
            this.f1671e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                m0.a aVar2 = aVar.a.get(i2);
                int i4 = i3 + 1;
                this.b[i3] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                m mVar = aVar2.b;
                arrayList.add(mVar != null ? mVar.f1726f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1751d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1752e;
                iArr[i7] = aVar2.f1753f;
                this.f1670d[i2] = aVar2.f1754g.ordinal();
                this.f1671e[i2] = aVar2.f1755h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1672f = aVar.f1744f;
            this.f1673g = aVar.f1747i;
            this.f1674h = aVar.s;
            this.f1675i = aVar.f1748j;
            this.f1676j = aVar.f1749k;
            this.f1677k = aVar.f1750l;
            this.f1678l = aVar.m;
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
        parcel.writeIntArray(this.f1670d);
        parcel.writeIntArray(this.f1671e);
        parcel.writeInt(this.f1672f);
        parcel.writeString(this.f1673g);
        parcel.writeInt(this.f1674h);
        parcel.writeInt(this.f1675i);
        TextUtils.writeToParcel(this.f1676j, parcel, 0);
        parcel.writeInt(this.f1677k);
        TextUtils.writeToParcel(this.f1678l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
