package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.e.a.a;
import f.b.e.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

public final class h1 {
    public static final Logger a = Logger.getLogger(h1.class.getName());

    public static Object a(a aVar) {
        String str;
        char c;
        String str2;
        double d2;
        String str3;
        b.F(aVar.J(), "unexpected end of JSON");
        int ordinal = aVar.U().ordinal();
        boolean z = false;
        if (ordinal != 0) {
            char c2 = '\"';
            if (ordinal == 2) {
                int i2 = aVar.f3456h;
                if (i2 == 0) {
                    i2 = aVar.d();
                }
                if (i2 == 1) {
                    aVar.V(3);
                    aVar.f3456h = 0;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    while (aVar.J()) {
                        int i3 = aVar.f3456h;
                        if (i3 == 0) {
                            i3 = aVar.d();
                        }
                        if (i3 == 14) {
                            str = aVar.T();
                        } else {
                            if (i3 == 12) {
                                c = '\'';
                            } else if (i3 == 13) {
                                c = '\"';
                            } else {
                                throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected a name but was ")));
                            }
                            str = aVar.S(c);
                        }
                        aVar.f3456h = 0;
                        aVar.n[aVar.m - 1] = str;
                        linkedHashMap.put(str, a(aVar));
                    }
                    boolean z2 = aVar.U() == f.b.e.a.b.END_OBJECT;
                    StringBuilder i4 = f.a.a.a.a.i("Bad token: ");
                    i4.append(aVar.x());
                    b.F(z2, i4.toString());
                    int i5 = aVar.f3456h;
                    if (i5 == 0) {
                        i5 = aVar.d();
                    }
                    if (i5 == 2) {
                        int i6 = aVar.m - 1;
                        aVar.m = i6;
                        aVar.n[i6] = null;
                        int[] iArr = aVar.o;
                        int i7 = i6 - 1;
                        iArr[i7] = iArr[i7] + 1;
                        aVar.f3456h = 0;
                        return Collections.unmodifiableMap(linkedHashMap);
                    }
                    throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected END_OBJECT but was ")));
                }
                throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected BEGIN_OBJECT but was ")));
            } else if (ordinal == 5) {
                int i8 = aVar.f3456h;
                if (i8 == 0) {
                    i8 = aVar.d();
                }
                if (i8 == 10) {
                    str2 = aVar.T();
                } else {
                    if (i8 == 8) {
                        c2 = '\'';
                    } else if (i8 != 9) {
                        if (i8 == 11) {
                            str2 = aVar.f3459k;
                            aVar.f3459k = null;
                        } else if (i8 == 15) {
                            str2 = Long.toString(aVar.f3457i);
                        } else if (i8 == 16) {
                            str2 = new String(aVar.c, aVar.f3452d, aVar.f3458j);
                            aVar.f3452d += aVar.f3458j;
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected a string but was ")));
                        }
                    }
                    str2 = aVar.S(c2);
                }
                aVar.f3456h = 0;
                int[] iArr2 = aVar.o;
                int i9 = aVar.m - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return str2;
            } else if (ordinal == 6) {
                int i10 = aVar.f3456h;
                if (i10 == 0) {
                    i10 = aVar.d();
                }
                if (i10 == 15) {
                    aVar.f3456h = 0;
                    int[] iArr3 = aVar.o;
                    int i11 = aVar.m - 1;
                    iArr3[i11] = iArr3[i11] + 1;
                    d2 = (double) aVar.f3457i;
                } else {
                    if (i10 == 16) {
                        aVar.f3459k = new String(aVar.c, aVar.f3452d, aVar.f3458j);
                        aVar.f3452d += aVar.f3458j;
                    } else {
                        if (i10 == 8 || i10 == 9) {
                            if (i10 == 8) {
                                c2 = '\'';
                            }
                            str3 = aVar.S(c2);
                        } else if (i10 == 10) {
                            str3 = aVar.T();
                        } else if (i10 != 11) {
                            throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected a double but was ")));
                        }
                        aVar.f3459k = str3;
                    }
                    aVar.f3456h = 11;
                    double parseDouble = Double.parseDouble(aVar.f3459k);
                    if (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                        throw new c("JSON forbids NaN and infinities: " + parseDouble + aVar.Q());
                    }
                    aVar.f3459k = null;
                    aVar.f3456h = 0;
                    int[] iArr4 = aVar.o;
                    int i12 = aVar.m - 1;
                    iArr4[i12] = iArr4[i12] + 1;
                    d2 = parseDouble;
                }
                return Double.valueOf(d2);
            } else if (ordinal == 7) {
                int i13 = aVar.f3456h;
                if (i13 == 0) {
                    i13 = aVar.d();
                }
                if (i13 == 5) {
                    aVar.f3456h = 0;
                    int[] iArr5 = aVar.o;
                    int i14 = aVar.m - 1;
                    iArr5[i14] = iArr5[i14] + 1;
                    z = true;
                } else if (i13 == 6) {
                    aVar.f3456h = 0;
                    int[] iArr6 = aVar.o;
                    int i15 = aVar.m - 1;
                    iArr6[i15] = iArr6[i15] + 1;
                } else {
                    throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected a boolean but was ")));
                }
                return Boolean.valueOf(z);
            } else if (ordinal == 8) {
                int i16 = aVar.f3456h;
                if (i16 == 0) {
                    i16 = aVar.d();
                }
                if (i16 == 7) {
                    aVar.f3456h = 0;
                    int[] iArr7 = aVar.o;
                    int i17 = aVar.m - 1;
                    iArr7[i17] = iArr7[i17] + 1;
                    return null;
                }
                throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected null but was ")));
            } else {
                StringBuilder i18 = f.a.a.a.a.i("Bad token: ");
                i18.append(aVar.x());
                throw new IllegalStateException(i18.toString());
            }
        } else {
            int i19 = aVar.f3456h;
            if (i19 == 0) {
                i19 = aVar.d();
            }
            if (i19 == 3) {
                aVar.V(1);
                aVar.o[aVar.m - 1] = 0;
                aVar.f3456h = 0;
                ArrayList arrayList = new ArrayList();
                while (aVar.J()) {
                    arrayList.add(a(aVar));
                }
                boolean z3 = aVar.U() == f.b.e.a.b.END_ARRAY;
                StringBuilder i20 = f.a.a.a.a.i("Bad token: ");
                i20.append(aVar.x());
                b.F(z3, i20.toString());
                int i21 = aVar.f3456h;
                if (i21 == 0) {
                    i21 = aVar.d();
                }
                if (i21 == 4) {
                    int i22 = aVar.m - 1;
                    aVar.m = i22;
                    int[] iArr8 = aVar.o;
                    int i23 = i22 - 1;
                    iArr8[i23] = iArr8[i23] + 1;
                    aVar.f3456h = 0;
                    return Collections.unmodifiableList(arrayList);
                }
                throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected END_ARRAY but was ")));
            }
            throw new IllegalStateException(f.a.a.a.a.t(aVar, f.a.a.a.a.i("Expected BEGIN_ARRAY but was ")));
        }
    }
}
