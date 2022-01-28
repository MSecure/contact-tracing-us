package e.y;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.e.a;
import java.lang.reflect.Method;

public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f1846d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f1847e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1848f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1849g;

    /* renamed from: h  reason: collision with root package name */
    public final String f1850h;

    /* renamed from: i  reason: collision with root package name */
    public int f1851i;

    /* renamed from: j  reason: collision with root package name */
    public int f1852j;

    /* renamed from: k  reason: collision with root package name */
    public int f1853k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public c(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1846d = new SparseIntArray();
        this.f1851i = -1;
        this.f1852j = 0;
        this.f1853k = -1;
        this.f1847e = parcel;
        this.f1848f = i2;
        this.f1849g = i3;
        this.f1852j = i2;
        this.f1850h = str;
    }

    @Override // e.y.b
    public void A(long j2) {
        this.f1847e.writeLong(j2);
    }

    @Override // e.y.b
    public void B(Parcelable parcelable) {
        this.f1847e.writeParcelable(parcelable, 0);
    }

    @Override // e.y.b
    public void C(String str) {
        this.f1847e.writeString(str);
    }

    @Override // e.y.b
    public void D(IBinder iBinder) {
        this.f1847e.writeStrongBinder(iBinder);
    }

    @Override // e.y.b
    public void a() {
        int i2 = this.f1851i;
        if (i2 >= 0) {
            int i3 = this.f1846d.get(i2);
            int dataPosition = this.f1847e.dataPosition();
            this.f1847e.setDataPosition(i3);
            this.f1847e.writeInt(dataPosition - i3);
            this.f1847e.setDataPosition(dataPosition);
        }
    }

    @Override // e.y.b
    public b b() {
        Parcel parcel = this.f1847e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f1852j;
        if (i2 == this.f1848f) {
            i2 = this.f1849g;
        }
        return new c(parcel, dataPosition, i2, f.a.a.a.a.f(new StringBuilder(), this.f1850h, "  "), this.a, this.b, this.c);
    }

    @Override // e.y.b
    public boolean g() {
        return this.f1847e.readInt() != 0;
    }

    @Override // e.y.b
    public byte[] h() {
        int readInt = this.f1847e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1847e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.y.b
    public CharSequence i() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1847e);
    }

    @Override // e.y.b
    public boolean j(int i2) {
        while (this.f1852j < this.f1849g) {
            int i3 = this.f1853k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1847e.setDataPosition(this.f1852j);
            int readInt = this.f1847e.readInt();
            this.f1853k = this.f1847e.readInt();
            this.f1852j += readInt;
        }
        return this.f1853k == i2;
    }

    @Override // e.y.b
    public int k() {
        return this.f1847e.readInt();
    }

    @Override // e.y.b
    public long m() {
        return this.f1847e.readLong();
    }

    @Override // e.y.b
    public <T extends Parcelable> T n() {
        return (T) this.f1847e.readParcelable(c.class.getClassLoader());
    }

    @Override // e.y.b
    public String p() {
        return this.f1847e.readString();
    }

    @Override // e.y.b
    public IBinder r() {
        return this.f1847e.readStrongBinder();
    }

    @Override // e.y.b
    public void u(int i2) {
        a();
        this.f1851i = i2;
        this.f1846d.put(i2, this.f1847e.dataPosition());
        this.f1847e.writeInt(0);
        this.f1847e.writeInt(i2);
    }

    @Override // e.y.b
    public void w(boolean z) {
        this.f1847e.writeInt(z ? 1 : 0);
    }

    @Override // e.y.b
    public void x(byte[] bArr) {
        if (bArr != null) {
            this.f1847e.writeInt(bArr.length);
            this.f1847e.writeByteArray(bArr);
            return;
        }
        this.f1847e.writeInt(-1);
    }

    @Override // e.y.b
    public void y(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1847e, 0);
    }

    @Override // e.y.b
    public void z(int i2) {
        this.f1847e.writeInt(i2);
    }
}
