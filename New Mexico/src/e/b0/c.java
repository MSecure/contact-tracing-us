package e.b0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import e.f.a;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f1065d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f1066e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1067f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1068g;

    /* renamed from: h  reason: collision with root package name */
    public final String f1069h;

    /* renamed from: i  reason: collision with root package name */
    public int f1070i;

    /* renamed from: j  reason: collision with root package name */
    public int f1071j;

    /* renamed from: k  reason: collision with root package name */
    public int f1072k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public c(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1065d = new SparseIntArray();
        this.f1070i = -1;
        this.f1071j = 0;
        this.f1072k = -1;
        this.f1066e = parcel;
        this.f1067f = i2;
        this.f1068g = i3;
        this.f1071j = i2;
        this.f1069h = str;
    }

    @Override // e.b0.b
    public void A(long j2) {
        this.f1066e.writeLong(j2);
    }

    @Override // e.b0.b
    public void B(Parcelable parcelable) {
        this.f1066e.writeParcelable(parcelable, 0);
    }

    @Override // e.b0.b
    public void C(String str) {
        this.f1066e.writeString(str);
    }

    @Override // e.b0.b
    public void D(IBinder iBinder) {
        this.f1066e.writeStrongBinder(iBinder);
    }

    @Override // e.b0.b
    public void a() {
        int i2 = this.f1070i;
        if (i2 >= 0) {
            int i3 = this.f1065d.get(i2);
            int dataPosition = this.f1066e.dataPosition();
            this.f1066e.setDataPosition(i3);
            this.f1066e.writeInt(dataPosition - i3);
            this.f1066e.setDataPosition(dataPosition);
        }
    }

    @Override // e.b0.b
    public b b() {
        Parcel parcel = this.f1066e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f1071j;
        if (i2 == this.f1067f) {
            i2 = this.f1068g;
        }
        return new c(parcel, dataPosition, i2, f.a.a.a.a.e(new StringBuilder(), this.f1069h, "  "), this.a, this.b, this.c);
    }

    @Override // e.b0.b
    public boolean g() {
        return this.f1066e.readInt() != 0;
    }

    @Override // e.b0.b
    public byte[] h() {
        int readInt = this.f1066e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1066e.readByteArray(bArr);
        return bArr;
    }

    @Override // e.b0.b
    public CharSequence i() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1066e);
    }

    @Override // e.b0.b
    public boolean j(int i2) {
        while (this.f1071j < this.f1068g) {
            int i3 = this.f1072k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1066e.setDataPosition(this.f1071j);
            int readInt = this.f1066e.readInt();
            this.f1072k = this.f1066e.readInt();
            this.f1071j += readInt;
        }
        return this.f1072k == i2;
    }

    @Override // e.b0.b
    public int k() {
        return this.f1066e.readInt();
    }

    @Override // e.b0.b
    public long m() {
        return this.f1066e.readLong();
    }

    @Override // e.b0.b
    public <T extends Parcelable> T n() {
        return (T) this.f1066e.readParcelable(c.class.getClassLoader());
    }

    @Override // e.b0.b
    public String p() {
        return this.f1066e.readString();
    }

    @Override // e.b0.b
    public IBinder r() {
        return this.f1066e.readStrongBinder();
    }

    @Override // e.b0.b
    public void u(int i2) {
        a();
        this.f1070i = i2;
        this.f1065d.put(i2, this.f1066e.dataPosition());
        this.f1066e.writeInt(0);
        this.f1066e.writeInt(i2);
    }

    @Override // e.b0.b
    public void w(boolean z) {
        this.f1066e.writeInt(z ? 1 : 0);
    }

    @Override // e.b0.b
    public void x(byte[] bArr) {
        if (bArr != null) {
            this.f1066e.writeInt(bArr.length);
            this.f1066e.writeByteArray(bArr);
            return;
        }
        this.f1066e.writeInt(-1);
    }

    @Override // e.b0.b
    public void y(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1066e, 0);
    }

    @Override // e.b0.b
    public void z(int i2) {
        this.f1066e.writeInt(i2);
    }
}
