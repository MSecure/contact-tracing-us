package e.o.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import e.o.a.m0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList<String> c;

    /* renamed from: d */
    public final int[] f1755d;

    /* renamed from: e */
    public final int[] f1756e;

    /* renamed from: f */
    public final int f1757f;

    /* renamed from: g */
    public final String f1758g;

    /* renamed from: h */
    public final int f1759h;

    /* renamed from: i */
    public final int f1760i;

    /* renamed from: j */
    public final CharSequence f1761j;

    /* renamed from: k */
    public final int f1762k;

    /* renamed from: l */
    public final CharSequence f1763l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.f1755d = parcel.createIntArray();
        this.f1756e = parcel.createIntArray();
        this.f1757f = parcel.readInt();
        this.f1758g = parcel.readString();
        this.f1759h = parcel.readInt();
        this.f1760i = parcel.readInt();
        this.f1761j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1762k = parcel.readInt();
        this.f1763l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[size * 5];
        if (aVar.f1830g) {
            this.c = new ArrayList<>(size);
            this.f1755d = new int[size];
            this.f1756e = new int[size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                m0.a aVar2 = aVar.a.get(i3);
                int i4 = i2 + 1;
                this.b[i2] = aVar2.a;
                ArrayList<String> arrayList = this.c;
                m mVar = aVar2.b;
                arrayList.add(mVar != null ? mVar.f1811f : null);
                int[] iArr = this.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1836d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1837e;
                i2 = i7 + 1;
                iArr[i7] = aVar2.f1838f;
                this.f1755d[i3] = aVar2.f1839g.ordinal();
                this.f1756e[i3] = aVar2.f1840h.ordinal();
            }
            this.f1757f = aVar.f1829f;
            this.f1758g = aVar.f1832i;
            this.f1759h = aVar.s;
            this.f1760i = aVar.f1833j;
            this.f1761j = aVar.f1834k;
            this.f1762k = aVar.f1835l;
            this.f1763l = aVar.m;
            this.m = aVar.n;
            this.n = aVar.o;
            this.o = aVar.p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.f1755d);
        parcel.writeIntArray(this.f1756e);
        parcel.writeInt(this.f1757f);
        parcel.writeString(this.f1758g);
        parcel.writeInt(this.f1759h);
        parcel.writeInt(this.f1760i);
        TextUtils.writeToParcel(this.f1761j, parcel, 0);
        parcel.writeInt(this.f1762k);
        TextUtils.writeToParcel(this.f1763l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
