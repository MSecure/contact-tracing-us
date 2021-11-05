package b.x;

import android.os.Parcel;
import android.util.SparseIntArray;
import b.e.a;
import java.lang.reflect.Method;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f1882d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f1883e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1882d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f1883e = parcel;
        this.f = i2;
        this.g = i3;
        this.j = i2;
        this.h = str;
    }

    @Override // b.x.a
    public void a() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.f1882d.get(i2);
            int dataPosition = this.f1883e.dataPosition();
            this.f1883e.setDataPosition(i3);
            this.f1883e.writeInt(dataPosition - i3);
            this.f1883e.setDataPosition(dataPosition);
        }
    }

    @Override // b.x.a
    public a b() {
        Parcel parcel = this.f1883e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f) {
            i2 = this.g;
        }
        return new b(parcel, dataPosition, i2, this.h + "  ", this.f1879a, this.f1880b, this.f1881c);
    }

    @Override // b.x.a
    public boolean h(int i2) {
        while (this.j < this.g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1883e.setDataPosition(this.j);
            int readInt = this.f1883e.readInt();
            this.k = this.f1883e.readInt();
            this.j += readInt;
        }
        return this.k == i2;
    }

    @Override // b.x.a
    public void l(int i2) {
        a();
        this.i = i2;
        this.f1882d.put(i2, this.f1883e.dataPosition());
        this.f1883e.writeInt(0);
        this.f1883e.writeInt(i2);
    }
}
