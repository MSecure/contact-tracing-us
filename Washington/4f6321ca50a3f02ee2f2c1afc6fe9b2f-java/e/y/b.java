package e.y;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.e.a;
import java.lang.reflect.Method;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f1997d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f1998e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1999f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2000g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2001h;

    /* renamed from: i  reason: collision with root package name */
    public int f2002i;

    /* renamed from: j  reason: collision with root package name */
    public int f2003j;

    /* renamed from: k  reason: collision with root package name */
    public int f2004k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1997d = new SparseIntArray();
        this.f2002i = -1;
        this.f2003j = 0;
        this.f2004k = -1;
        this.f1998e = parcel;
        this.f1999f = i2;
        this.f2000g = i3;
        this.f2003j = i2;
        this.f2001h = str;
    }

    @Override // e.y.a
    public void a() {
        int i2 = this.f2002i;
        if (i2 >= 0) {
            int i3 = this.f1997d.get(i2);
            int dataPosition = this.f1998e.dataPosition();
            this.f1998e.setDataPosition(i3);
            this.f1998e.writeInt(dataPosition - i3);
            this.f1998e.setDataPosition(dataPosition);
        }
    }

    @Override // e.y.a
    public a b() {
        Parcel parcel = this.f1998e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2003j;
        if (i2 == this.f1999f) {
            i2 = this.f2000g;
        }
        return new b(parcel, dataPosition, i2, f.a.a.a.a.e(new StringBuilder(), this.f2001h, "  "), this.a, this.b, this.c);
    }

    @Override // e.y.a
    public boolean f() {
        return this.f1998e.readInt() != 0;
    }

    @Override // e.y.a
    public byte[] g() {
        int readInt = this.f1998e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1998e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.y.a
    public CharSequence h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1998e);
    }

    @Override // e.y.a
    public boolean i(int i2) {
        while (this.f2003j < this.f2000g) {
            int i3 = this.f2004k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1998e.setDataPosition(this.f2003j);
            int readInt = this.f1998e.readInt();
            this.f2004k = this.f1998e.readInt();
            this.f2003j += readInt;
        }
        return this.f2004k == i2;
    }

    @Override // e.y.a
    public int j() {
        return this.f1998e.readInt();
    }

    @Override // e.y.a
    public <T extends Parcelable> T l() {
        return (T) this.f1998e.readParcelable(b.class.getClassLoader());
    }

    @Override // e.y.a
    public String n() {
        return this.f1998e.readString();
    }

    @Override // e.y.a
    public void p(int i2) {
        a();
        this.f2002i = i2;
        this.f1997d.put(i2, this.f1998e.dataPosition());
        this.f1998e.writeInt(0);
        this.f1998e.writeInt(i2);
    }

    @Override // e.y.a
    public void q(boolean z) {
        this.f1998e.writeInt(z ? 1 : 0);
    }

    @Override // e.y.a
    public void r(byte[] bArr) {
        if (bArr != null) {
            this.f1998e.writeInt(bArr.length);
            this.f1998e.writeByteArray(bArr);
            return;
        }
        this.f1998e.writeInt(-1);
    }

    @Override // e.y.a
    public void s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1998e, 0);
    }

    @Override // e.y.a
    public void t(int i2) {
        this.f1998e.writeInt(i2);
    }

    @Override // e.y.a
    public void u(Parcelable parcelable) {
        this.f1998e.writeParcelable(parcelable, 0);
    }

    @Override // e.y.a
    public void v(String str) {
        this.f1998e.writeString(str);
    }
}
