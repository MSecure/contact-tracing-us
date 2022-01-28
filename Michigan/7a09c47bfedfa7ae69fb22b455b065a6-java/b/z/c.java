package b.z;

import android.os.Parcel;
import android.util.SparseIntArray;
import b.e.a;
import java.lang.reflect.Method;

public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f2790d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f2791e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2792f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2793g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public c(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2790d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f2791e = parcel;
        this.f2792f = i2;
        this.f2793g = i3;
        this.j = i2;
        this.h = str;
    }

    @Override // b.z.b
    public void a() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.f2790d.get(i2);
            int dataPosition = this.f2791e.dataPosition();
            this.f2791e.setDataPosition(i3);
            this.f2791e.writeInt(dataPosition - i3);
            this.f2791e.setDataPosition(dataPosition);
        }
    }

    @Override // b.z.b
    public b b() {
        Parcel parcel = this.f2791e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f2792f) {
            i2 = this.f2793g;
        }
        return new c(parcel, dataPosition, i2, this.h + "  ", this.f2787a, this.f2788b, this.f2789c);
    }

    @Override // b.z.b
    public boolean i(int i2) {
        while (this.j < this.f2793g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f2791e.setDataPosition(this.j);
            int readInt = this.f2791e.readInt();
            this.k = this.f2791e.readInt();
            this.j += readInt;
        }
        return this.k == i2;
    }

    @Override // b.z.b
    public int j() {
        return this.f2791e.readInt();
    }

    @Override // b.z.b
    public String m() {
        return this.f2791e.readString();
    }

    @Override // b.z.b
    public void q(int i2) {
        a();
        this.i = i2;
        this.f2790d.put(i2, this.f2791e.dataPosition());
        this.f2791e.writeInt(0);
        this.f2791e.writeInt(i2);
    }

    @Override // b.z.b
    public void s(byte[] bArr) {
        if (bArr != null) {
            this.f2791e.writeInt(bArr.length);
            this.f2791e.writeByteArray(bArr);
            return;
        }
        this.f2791e.writeInt(-1);
    }
}
