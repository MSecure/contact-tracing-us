package e.m.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import e.m.a.m0;
import java.util.ArrayList;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1398d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1399e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1400f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1401g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1402h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1403i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f1404j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1405k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f1406l;
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
        this.f1398d = parcel.createIntArray();
        this.f1399e = parcel.createIntArray();
        this.f1400f = parcel.readInt();
        this.f1401g = parcel.readString();
        this.f1402h = parcel.readInt();
        this.f1403i = parcel.readInt();
        this.f1404j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1405k = parcel.readInt();
        this.f1406l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[(size * 5)];
        if (aVar.f1472g) {
            this.c = new ArrayList<>(size);
            this.f1398d = new int[size];
            this.f1399e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                m0.a aVar2 = aVar.a.get(i2);
                int i4 = i3 + 1;
                this.b[i3] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                m mVar = aVar2.b;
                arrayList.add(mVar != null ? mVar.f1453f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1478d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1479e;
                iArr[i7] = aVar2.f1480f;
                this.f1398d[i2] = aVar2.f1481g.ordinal();
                this.f1399e[i2] = aVar2.f1482h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1400f = aVar.f1471f;
            this.f1401g = aVar.f1474i;
            this.f1402h = aVar.s;
            this.f1403i = aVar.f1475j;
            this.f1404j = aVar.f1476k;
            this.f1405k = aVar.f1477l;
            this.f1406l = aVar.m;
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
        parcel.writeIntArray(this.f1398d);
        parcel.writeIntArray(this.f1399e);
        parcel.writeInt(this.f1400f);
        parcel.writeString(this.f1401g);
        parcel.writeInt(this.f1402h);
        parcel.writeInt(this.f1403i);
        TextUtils.writeToParcel(this.f1404j, parcel, 0);
        parcel.writeInt(this.f1405k);
        TextUtils.writeToParcel(this.f1406l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
