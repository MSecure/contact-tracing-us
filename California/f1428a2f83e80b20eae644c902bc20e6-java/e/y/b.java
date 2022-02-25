package e.y;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.e.a;
import java.lang.reflect.Method;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f1998d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f1999e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2000f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2001g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2002h;

    /* renamed from: i  reason: collision with root package name */
    public int f2003i;

    /* renamed from: j  reason: collision with root package name */
    public int f2004j;

    /* renamed from: k  reason: collision with root package name */
    public int f2005k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1998d = new SparseIntArray();
        this.f2003i = -1;
        this.f2004j = 0;
        this.f2005k = -1;
        this.f1999e = parcel;
        this.f2000f = i2;
        this.f2001g = i3;
        this.f2004j = i2;
        this.f2002h = str;
    }

    @Override // e.y.a
    public void a() {
        int i2 = this.f2003i;
        if (i2 >= 0) {
            int i3 = this.f1998d.get(i2);
            int dataPosition = this.f1999e.dataPosition();
            this.f1999e.setDataPosition(i3);
            this.f1999e.writeInt(dataPosition - i3);
            this.f1999e.setDataPosition(dataPosition);
        }
    }

    @Override // e.y.a
    public a b() {
        Parcel parcel = this.f1999e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2004j;
        if (i2 == this.f2000f) {
            i2 = this.f2001g;
        }
        return new b(parcel, dataPosition, i2, f.a.a.a.a.e(new StringBuilder(), this.f2002h, "  "), this.a, this.b, this.c);
    }

    @Override // e.y.a
    public boolean f() {
        return this.f1999e.readInt() != 0;
    }

    @Override // e.y.a
    public byte[] g() {
        int readInt = this.f1999e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1999e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.y.a
    public CharSequence h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1999e);
    }

    @Override // e.y.a
    public boolean i(int i2) {
        while (this.f2004j < this.f2001g) {
            int i3 = this.f2005k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1999e.setDataPosition(this.f2004j);
            int readInt = this.f1999e.readInt();
            this.f2005k = this.f1999e.readInt();
            this.f2004j += readInt;
        }
        return this.f2005k == i2;
    }

    @Override // e.y.a
    public int j() {
        return this.f1999e.readInt();
    }

    @Override // e.y.a
    public <T extends Parcelable> T l() {
        return (T) this.f1999e.readParcelable(b.class.getClassLoader());
    }

    @Override // e.y.a
    public String n() {
        return this.f1999e.readString();
    }

    @Override // e.y.a
    public void p(int i2) {
        a();
        this.f2003i = i2;
        this.f1998d.put(i2, this.f1999e.dataPosition());
        this.f1999e.writeInt(0);
        this.f1999e.writeInt(i2);
    }

    @Override // e.y.a
    public void q(boolean z) {
        this.f1999e.writeInt(z ? 1 : 0);
    }

    @Override // e.y.a
    public void r(byte[] bArr) {
        if (bArr != null) {
            this.f1999e.writeInt(bArr.length);
            this.f1999e.writeByteArray(bArr);
            return;
        }
        this.f1999e.writeInt(-1);
    }

    @Override // e.y.a
    public void s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1999e, 0);
    }

    @Override // e.y.a
    public void t(int i2) {
        this.f1999e.writeInt(i2);
    }

    @Override // e.y.a
    public void u(Parcelable parcelable) {
        this.f1999e.writeParcelable(parcelable, 0);
    }

    @Override // e.y.a
    public void v(String str) {
        this.f1999e.writeString(str);
    }
}
