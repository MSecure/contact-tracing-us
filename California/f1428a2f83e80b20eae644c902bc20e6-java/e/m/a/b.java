package e.m.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import e.m.a.l0;
import java.util.ArrayList;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1562d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1563e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1564f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1565g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1566h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1567i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f1568j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1569k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f1570l;
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
        this.f1562d = parcel.createIntArray();
        this.f1563e = parcel.createIntArray();
        this.f1564f = parcel.readInt();
        this.f1565g = parcel.readString();
        this.f1566h = parcel.readInt();
        this.f1567i = parcel.readInt();
        this.f1568j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1569k = parcel.readInt();
        this.f1570l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[(size * 5)];
        if (aVar.f1639g) {
            this.c = new ArrayList<>(size);
            this.f1562d = new int[size];
            this.f1563e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                l0.a aVar2 = aVar.a.get(i2);
                int i4 = i3 + 1;
                this.b[i3] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                l lVar = aVar2.b;
                arrayList.add(lVar != null ? lVar.f1620f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1645d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1646e;
                iArr[i7] = aVar2.f1647f;
                this.f1562d[i2] = aVar2.f1648g.ordinal();
                this.f1563e[i2] = aVar2.f1649h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1564f = aVar.f1638f;
            this.f1565g = aVar.f1641i;
            this.f1566h = aVar.s;
            this.f1567i = aVar.f1642j;
            this.f1568j = aVar.f1643k;
            this.f1569k = aVar.f1644l;
            this.f1570l = aVar.m;
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
        parcel.writeIntArray(this.f1562d);
        parcel.writeIntArray(this.f1563e);
        parcel.writeInt(this.f1564f);
        parcel.writeString(this.f1565g);
        parcel.writeInt(this.f1566h);
        parcel.writeInt(this.f1567i);
        TextUtils.writeToParcel(this.f1568j, parcel, 0);
        parcel.writeInt(this.f1569k);
        TextUtils.writeToParcel(this.f1570l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
