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
    public final int[] f1561d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1562e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1563f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1564g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1565h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1566i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f1567j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1568k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f1569l;
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
        this.f1561d = parcel.createIntArray();
        this.f1562e = parcel.createIntArray();
        this.f1563f = parcel.readInt();
        this.f1564g = parcel.readString();
        this.f1565h = parcel.readInt();
        this.f1566i = parcel.readInt();
        this.f1567j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1568k = parcel.readInt();
        this.f1569l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[(size * 5)];
        if (aVar.f1638g) {
            this.c = new ArrayList<>(size);
            this.f1561d = new int[size];
            this.f1562e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                l0.a aVar2 = aVar.a.get(i2);
                int i4 = i3 + 1;
                this.b[i3] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                l lVar = aVar2.b;
                arrayList.add(lVar != null ? lVar.f1619f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1644d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1645e;
                iArr[i7] = aVar2.f1646f;
                this.f1561d[i2] = aVar2.f1647g.ordinal();
                this.f1562e[i2] = aVar2.f1648h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1563f = aVar.f1637f;
            this.f1564g = aVar.f1640i;
            this.f1565h = aVar.s;
            this.f1566i = aVar.f1641j;
            this.f1567j = aVar.f1642k;
            this.f1568k = aVar.f1643l;
            this.f1569l = aVar.m;
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
        parcel.writeIntArray(this.f1561d);
        parcel.writeIntArray(this.f1562e);
        parcel.writeInt(this.f1563f);
        parcel.writeString(this.f1564g);
        parcel.writeInt(this.f1565h);
        parcel.writeInt(this.f1566i);
        TextUtils.writeToParcel(this.f1567j, parcel, 0);
        parcel.writeInt(this.f1568k);
        TextUtils.writeToParcel(this.f1569l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
