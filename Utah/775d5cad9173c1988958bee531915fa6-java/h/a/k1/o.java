package h.a.k1;

import f.b.b.c.a;
import h.a.j1.a3;
import h.a.k1.p.m.d;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class o {
    static {
        Logger.getLogger(o.class.getName());
    }

    public static byte[][] a(List<d> list) {
        int size = list.size() * 2;
        byte[][] bArr = new byte[size][];
        int i2 = 0;
        for (d dVar : list) {
            int i3 = i2 + 1;
            bArr[i2] = dVar.a.o();
            i2 = i3 + 1;
            bArr[i3] = dVar.b.o();
        }
        Logger logger = a3.a;
        int i4 = 0;
        while (i4 < size) {
            byte[] bArr2 = bArr[i4];
            int i5 = i4 + 1;
            byte[] bArr3 = bArr[i5];
            if (a3.a(bArr2, a3.b)) {
                for (byte b : bArr3) {
                    if (b == 44) {
                        ArrayList arrayList = new ArrayList(size + 10);
                        for (int i6 = 0; i6 < i4; i6++) {
                            arrayList.add(bArr[i6]);
                        }
                        while (i4 < size) {
                            byte[] bArr4 = bArr[i4];
                            byte[] bArr5 = bArr[i4 + 1];
                            if (!a3.a(bArr4, a3.b)) {
                                arrayList.add(bArr4);
                                arrayList.add(bArr5);
                            } else {
                                int i7 = 0;
                                for (int i8 = 0; i8 <= bArr5.length; i8++) {
                                    if (i8 == bArr5.length || bArr5[i8] == 44) {
                                        byte[] a = a.a.a(new String(bArr5, i7, i8 - i7, f.b.b.a.d.a));
                                        arrayList.add(bArr4);
                                        arrayList.add(a);
                                        i7 = i8 + 1;
                                    }
                                }
                            }
                            i4 += 2;
                        }
                        return (byte[][]) arrayList.toArray(new byte[0][]);
                    }
                }
                bArr[i5] = a.a.a(new String(bArr3, f.b.b.a.d.a));
            }
            i4 += 2;
        }
        return bArr;
    }
}
