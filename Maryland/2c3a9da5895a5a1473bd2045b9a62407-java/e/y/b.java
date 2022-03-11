package e.y;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.e.a;
import java.lang.reflect.Method;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f2030d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f2031e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2032f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2033g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2034h;

    /* renamed from: i  reason: collision with root package name */
    public int f2035i;

    /* renamed from: j  reason: collision with root package name */
    public int f2036j;

    /* renamed from: k  reason: collision with root package name */
    public int f2037k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2030d = new SparseIntArray();
        this.f2035i = -1;
        this.f2036j = 0;
        this.f2037k = -1;
        this.f2031e = parcel;
        this.f2032f = i2;
        this.f2033g = i3;
        this.f2036j = i2;
        this.f2034h = str;
    }

    @Override // e.y.a
    public void a() {
        int i2 = this.f2035i;
        if (i2 >= 0) {
            int i3 = this.f2030d.get(i2);
            int dataPosition = this.f2031e.dataPosition();
            this.f2031e.setDataPosition(i3);
            this.f2031e.writeInt(dataPosition - i3);
            this.f2031e.setDataPosition(dataPosition);
        }
    }

    @Override // e.y.a
    public a b() {
        Parcel parcel = this.f2031e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2036j;
        if (i2 == this.f2032f) {
            i2 = this.f2033g;
        }
        return new b(parcel, dataPosition, i2, f.a.a.a.a.e(new StringBuilder(), this.f2034h, "  "), this.a, this.b, this.c);
    }

    @Override // e.y.a
    public boolean f() {
        return this.f2031e.readInt() != 0;
    }

    @Override // e.y.a
    public byte[] g() {
        int readInt = this.f2031e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2031e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.y.a
    public CharSequence h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2031e);
    }

    @Override // e.y.a
    public boolean i(int i2) {
        while (this.f2036j < this.f2033g) {
            int i3 = this.f2037k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f2031e.setDataPosition(this.f2036j);
            int readInt = this.f2031e.readInt();
            this.f2037k = this.f2031e.readInt();
            this.f2036j += readInt;
        }
        return this.f2037k == i2;
    }

    @Override // e.y.a
    public int j() {
        return this.f2031e.readInt();
    }

    @Override // e.y.a
    public <T extends Parcelable> T l() {
        return (T) this.f2031e.readParcelable(b.class.getClassLoader());
    }

    @Override // e.y.a
    public String n() {
        return this.f2031e.readString();
    }

    @Override // e.y.a
    public void p(int i2) {
        a();
        this.f2035i = i2;
        this.f2030d.put(i2, this.f2031e.dataPosition());
        this.f2031e.writeInt(0);
        this.f2031e.writeInt(i2);
    }

    @Override // e.y.a
    public void q(boolean z) {
        this.f2031e.writeInt(z ? 1 : 0);
    }

    @Override // e.y.a
    public void r(byte[] bArr) {
        if (bArr != null) {
            this.f2031e.writeInt(bArr.length);
            this.f2031e.writeByteArray(bArr);
            return;
        }
        this.f2031e.writeInt(-1);
    }

    @Override // e.y.a
    public void s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2031e, 0);
    }

    @Override // e.y.a
    public void t(int i2) {
        this.f2031e.writeInt(i2);
    }

    @Override // e.y.a
    public void u(Parcelable parcelable) {
        this.f2031e.writeParcelable(parcelable, 0);
    }

    @Override // e.y.a
    public void v(String str) {
        this.f2031e.writeString(str);
    }
}
