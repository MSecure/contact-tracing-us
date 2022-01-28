package c.b.a.a.g.b;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class h4 implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public f4<?, ?> f3306b;

    /* renamed from: c  reason: collision with root package name */
    public Object f3307c;

    /* renamed from: d  reason: collision with root package name */
    public List<Object> f3308d = new ArrayList();

    public final byte[] a() {
        c();
        byte[] bArr = new byte[0];
        ByteBuffer.wrap(bArr, 0, 0).order(ByteOrder.LITTLE_ENDIAN);
        b();
        return bArr;
    }

    public final void b() {
        if (this.f3307c == null) {
            Iterator<Object> it = this.f3308d.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final int c() {
        if (this.f3307c == null) {
            Iterator<Object> it = this.f3308d.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }

    @Override // java.lang.Object
    public final Object clone() {
        Object obj;
        h4 h4Var = new h4();
        h4Var.f3306b = null;
        try {
            if (this.f3308d == null) {
                h4Var.f3308d = null;
            } else {
                h4Var.f3308d.addAll(this.f3308d);
            }
            if (this.f3307c != null) {
                if (this.f3307c instanceof j4) {
                    obj = (j4) ((j4) this.f3307c).clone();
                } else if (this.f3307c instanceof byte[]) {
                    obj = ((byte[]) this.f3307c).clone();
                } else {
                    int i = 0;
                    if (this.f3307c instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f3307c;
                        byte[][] bArr2 = new byte[bArr.length][];
                        h4Var.f3307c = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f3307c instanceof boolean[]) {
                        obj = ((boolean[]) this.f3307c).clone();
                    } else if (this.f3307c instanceof int[]) {
                        obj = ((int[]) this.f3307c).clone();
                    } else if (this.f3307c instanceof long[]) {
                        obj = ((long[]) this.f3307c).clone();
                    } else if (this.f3307c instanceof float[]) {
                        obj = ((float[]) this.f3307c).clone();
                    } else if (this.f3307c instanceof double[]) {
                        obj = ((double[]) this.f3307c).clone();
                    } else if (this.f3307c instanceof j4[]) {
                        j4[] j4VarArr = (j4[]) this.f3307c;
                        j4[] j4VarArr2 = new j4[j4VarArr.length];
                        h4Var.f3307c = j4VarArr2;
                        while (i < j4VarArr.length) {
                            j4VarArr2[i] = (j4) j4VarArr[i].clone();
                            i++;
                        }
                    }
                }
                h4Var.f3307c = obj;
            }
            return h4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h4)) {
            return false;
        }
        h4 h4Var = (h4) obj;
        if (this.f3307c == null || h4Var.f3307c == null) {
            List<Object> list2 = this.f3308d;
            if (list2 != null && (list = h4Var.f3308d) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(a(), h4Var.a());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            throw null;
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(a()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
