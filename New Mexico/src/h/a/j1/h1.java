package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.e.a.a;
import f.b.e.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class h1 {
    public static final Logger a = Logger.getLogger(h1.class.getName());

    public static Object a(a aVar) {
        String str;
        char c;
        String str2;
        double d2;
        String str3;
        b.G(aVar.J(), "unexpected end of JSON");
        int ordinal = aVar.U().ordinal();
        boolean z = false;
        if (ordinal != 0) {
            char c2 = '\"';
            if (ordinal == 2) {
                int i2 = aVar.f3774h;
                if (i2 == 0) {
                    i2 = aVar.d();
                }
                if (i2 == 1) {
                    aVar.V(3);
                    aVar.f3774h = 0;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    while (aVar.J()) {
                        int i3 = aVar.f3774h;
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
                                throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected a name but was ")));
                            }
                            str = aVar.S(c);
                        }
                        aVar.f3774h = 0;
                        aVar.n[aVar.m - 1] = str;
                        linkedHashMap.put(str, a(aVar));
                    }
                    boolean z2 = aVar.U() == f.b.e.a.b.END_OBJECT;
                    StringBuilder h2 = f.a.a.a.a.h("Bad token: ");
                    h2.append(aVar.x());
                    b.G(z2, h2.toString());
                    int i4 = aVar.f3774h;
                    if (i4 == 0) {
                        i4 = aVar.d();
                    }
                    if (i4 == 2) {
                        int i5 = aVar.m - 1;
                        aVar.m = i5;
                        aVar.n[i5] = null;
                        int[] iArr = aVar.o;
                        int i6 = i5 - 1;
                        iArr[i6] = iArr[i6] + 1;
                        aVar.f3774h = 0;
                        return Collections.unmodifiableMap(linkedHashMap);
                    }
                    throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected END_OBJECT but was ")));
                }
                throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected BEGIN_OBJECT but was ")));
            } else if (ordinal == 5) {
                int i7 = aVar.f3774h;
                if (i7 == 0) {
                    i7 = aVar.d();
                }
                if (i7 == 10) {
                    str2 = aVar.T();
                } else {
                    if (i7 == 8) {
                        c2 = '\'';
                    } else if (i7 != 9) {
                        if (i7 == 11) {
                            str2 = aVar.f3777k;
                            aVar.f3777k = null;
                        } else if (i7 == 15) {
                            str2 = Long.toString(aVar.f3775i);
                        } else if (i7 == 16) {
                            str2 = new String(aVar.c, aVar.f3770d, aVar.f3776j);
                            aVar.f3770d += aVar.f3776j;
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected a string but was ")));
                        }
                    }
                    str2 = aVar.S(c2);
                }
                aVar.f3774h = 0;
                int[] iArr2 = aVar.o;
                int i8 = aVar.m - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return str2;
            } else if (ordinal == 6) {
                int i9 = aVar.f3774h;
                if (i9 == 0) {
                    i9 = aVar.d();
                }
                if (i9 == 15) {
                    aVar.f3774h = 0;
                    int[] iArr3 = aVar.o;
                    int i10 = aVar.m - 1;
                    iArr3[i10] = iArr3[i10] + 1;
                    d2 = (double) aVar.f3775i;
                } else {
                    if (i9 == 16) {
                        aVar.f3777k = new String(aVar.c, aVar.f3770d, aVar.f3776j);
                        aVar.f3770d += aVar.f3776j;
                    } else {
                        if (i9 == 8 || i9 == 9) {
                            if (i9 == 8) {
                                c2 = '\'';
                            }
                            str3 = aVar.S(c2);
                        } else if (i9 == 10) {
                            str3 = aVar.T();
                        } else if (i9 != 11) {
                            throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected a double but was ")));
                        }
                        aVar.f3777k = str3;
                    }
                    aVar.f3774h = 11;
                    double parseDouble = Double.parseDouble(aVar.f3777k);
                    if (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                        throw new c("JSON forbids NaN and infinities: " + parseDouble + aVar.Q());
                    }
                    aVar.f3777k = null;
                    aVar.f3774h = 0;
                    int[] iArr4 = aVar.o;
                    int i11 = aVar.m - 1;
                    iArr4[i11] = iArr4[i11] + 1;
                    d2 = parseDouble;
                }
                return Double.valueOf(d2);
            } else if (ordinal == 7) {
                int i12 = aVar.f3774h;
                if (i12 == 0) {
                    i12 = aVar.d();
                }
                if (i12 == 5) {
                    aVar.f3774h = 0;
                    int[] iArr5 = aVar.o;
                    int i13 = aVar.m - 1;
                    iArr5[i13] = iArr5[i13] + 1;
                    z = true;
                } else if (i12 == 6) {
                    aVar.f3774h = 0;
                    int[] iArr6 = aVar.o;
                    int i14 = aVar.m - 1;
                    iArr6[i14] = iArr6[i14] + 1;
                } else {
                    throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected a boolean but was ")));
                }
                return Boolean.valueOf(z);
            } else if (ordinal == 8) {
                int i15 = aVar.f3774h;
                if (i15 == 0) {
                    i15 = aVar.d();
                }
                if (i15 == 7) {
                    aVar.f3774h = 0;
                    int[] iArr7 = aVar.o;
                    int i16 = aVar.m - 1;
                    iArr7[i16] = iArr7[i16] + 1;
                    return null;
                }
                throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected null but was ")));
            } else {
                StringBuilder h3 = f.a.a.a.a.h("Bad token: ");
                h3.append(aVar.x());
                throw new IllegalStateException(h3.toString());
            }
        } else {
            int i17 = aVar.f3774h;
            if (i17 == 0) {
                i17 = aVar.d();
            }
            if (i17 == 3) {
                aVar.V(1);
                aVar.o[aVar.m - 1] = 0;
                aVar.f3774h = 0;
                ArrayList arrayList = new ArrayList();
                while (aVar.J()) {
                    arrayList.add(a(aVar));
                }
                boolean z3 = aVar.U() == f.b.e.a.b.END_ARRAY;
                StringBuilder h4 = f.a.a.a.a.h("Bad token: ");
                h4.append(aVar.x());
                b.G(z3, h4.toString());
                int i18 = aVar.f3774h;
                if (i18 == 0) {
                    i18 = aVar.d();
                }
                if (i18 == 4) {
                    int i19 = aVar.m - 1;
                    aVar.m = i19;
                    int[] iArr8 = aVar.o;
                    int i20 = i19 - 1;
                    iArr8[i20] = iArr8[i20] + 1;
                    aVar.f3774h = 0;
                    return Collections.unmodifiableList(arrayList);
                }
                throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected END_ARRAY but was ")));
            }
            throw new IllegalStateException(f.a.a.a.a.s(aVar, f.a.a.a.a.h("Expected BEGIN_ARRAY but was ")));
        }
    }
}
