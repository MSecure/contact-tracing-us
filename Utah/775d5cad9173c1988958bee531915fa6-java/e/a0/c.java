package e.a0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.e.a;
import java.lang.reflect.Method;

public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f640d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f641e;

    /* renamed from: f  reason: collision with root package name */
    public final int f642f;

    /* renamed from: g  reason: collision with root package name */
    public final int f643g;

    /* renamed from: h  reason: collision with root package name */
    public final String f644h;

    /* renamed from: i  reason: collision with root package name */
    public int f645i;

    /* renamed from: j  reason: collision with root package name */
    public int f646j;

    /* renamed from: k  reason: collision with root package name */
    public int f647k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public c(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f640d = new SparseIntArray();
        this.f645i = -1;
        this.f646j = 0;
        this.f647k = -1;
        this.f641e = parcel;
        this.f642f = i2;
        this.f643g = i3;
        this.f646j = i2;
        this.f644h = str;
    }

    @Override // e.a0.b
    public void A(long j2) {
        this.f641e.writeLong(j2);
    }

    @Override // e.a0.b
    public void B(Parcelable parcelable) {
        this.f641e.writeParcelable(parcelable, 0);
    }

    @Override // e.a0.b
    public void C(String str) {
        this.f641e.writeString(str);
    }

    @Override // e.a0.b
    public void D(IBinder iBinder) {
        this.f641e.writeStrongBinder(iBinder);
    }

    @Override // e.a0.b
    public void a() {
        int i2 = this.f645i;
        if (i2 >= 0) {
            int i3 = this.f640d.get(i2);
            int dataPosition = this.f641e.dataPosition();
            this.f641e.setDataPosition(i3);
            this.f641e.writeInt(dataPosition - i3);
            this.f641e.setDataPosition(dataPosition);
        }
    }

    @Override // e.a0.b
    public b b() {
        Parcel parcel = this.f641e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f646j;
        if (i2 == this.f642f) {
            i2 = this.f643g;
        }
        return new c(parcel, dataPosition, i2, f.a.a.a.a.e(new StringBuilder(), this.f644h, "  "), this.a, this.b, this.c);
    }

    @Override // e.a0.b
    public boolean g() {
        return this.f641e.readInt() != 0;
    }

    @Override // e.a0.b
    public byte[] h() {
        int readInt = this.f641e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f641e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.a0.b
    public CharSequence i() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f641e);
    }

    @Override // e.a0.b
    public boolean j(int i2) {
        while (this.f646j < this.f643g) {
            int i3 = this.f647k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f641e.setDataPosition(this.f646j);
            int readInt = this.f641e.readInt();
            this.f647k = this.f641e.readInt();
            this.f646j += readInt;
        }
        return this.f647k == i2;
    }

    @Override // e.a0.b
    public int k() {
        return this.f641e.readInt();
    }

    @Override // e.a0.b
    public long m() {
        return this.f641e.readLong();
    }

    @Override // e.a0.b
    public <T extends Parcelable> T n() {
        return (T) this.f641e.readParcelable(c.class.getClassLoader());
    }

    @Override // e.a0.b
    public String p() {
        return this.f641e.readString();
    }

    @Override // e.a0.b
    public IBinder r() {
        return this.f641e.readStrongBinder();
    }

    @Override // e.a0.b
    public void u(int i2) {
        a();
        this.f645i = i2;
        this.f640d.put(i2, this.f641e.dataPosition());
        this.f641e.writeInt(0);
        this.f641e.writeInt(i2);
    }

    @Override // e.a0.b
    public void w(boolean z) {
        this.f641e.writeInt(z ? 1 : 0);
    }

    @Override // e.a0.b
    public void x(byte[] bArr) {
        if (bArr != null) {
            this.f641e.writeInt(bArr.length);
            this.f641e.writeByteArray(bArr);
            return;
        }
        this.f641e.writeInt(-1);
    }

    @Override // e.a0.b
    public void y(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f641e, 0);
    }

    @Override // e.a0.b
    public void z(int i2) {
        this.f641e.writeInt(i2);
    }
}
