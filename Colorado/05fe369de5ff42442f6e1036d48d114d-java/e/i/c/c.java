package e.i.c;

import android.graphics.Path;
import e.b.a.m;

public class c {
    public char a;
    public float[] b;

    public c(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }

    public c(c cVar) {
        this.a = cVar.a;
        float[] fArr = cVar.b;
        this.b = m.h.x(fArr, 0, fArr.length);
    }

    public static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
        double d2;
        double d3;
        double radians = Math.toRadians((double) f8);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d4 = (double) f2;
        double d5 = (double) f3;
        double d6 = (d5 * sin) + (d4 * cos);
        double d7 = d4;
        double d8 = (double) f6;
        double d9 = d6 / d8;
        double d10 = (double) f7;
        double d11 = ((d5 * cos) + (((double) (-f2)) * sin)) / d10;
        double d12 = d5;
        double d13 = (double) f5;
        double d14 = ((d13 * sin) + (((double) f4) * cos)) / d8;
        double d15 = ((d13 * cos) + (((double) (-f4)) * sin)) / d10;
        double d16 = d9 - d14;
        double d17 = d11 - d15;
        double d18 = (d9 + d14) / 2.0d;
        double d19 = (d11 + d15) / 2.0d;
        double d20 = (d17 * d17) + (d16 * d16);
        if (d20 != 0.0d) {
            double d21 = (1.0d / d20) - 0.25d;
            if (d21 < 0.0d) {
                float sqrt = (float) (Math.sqrt(d20) / 1.99999d);
                a(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d21);
            double d22 = d16 * sqrt2;
            double d23 = sqrt2 * d17;
            if (z == z2) {
                d3 = d18 - d23;
                d2 = d19 + d22;
            } else {
                d3 = d18 + d23;
                d2 = d19 - d22;
            }
            double atan2 = Math.atan2(d11 - d2, d9 - d3);
            double atan22 = Math.atan2(d15 - d2, d14 - d3) - atan2;
            int i2 = 0;
            int i3 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i3 >= 0)) {
                atan22 = i3 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d24 = d3 * d8;
            double d25 = d2 * d10;
            double d26 = (d24 * cos) - (d25 * sin);
            double d27 = (d25 * cos) + (d24 * sin);
            int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
            double cos2 = Math.cos(radians);
            double sin2 = Math.sin(radians);
            double cos3 = Math.cos(atan2);
            double sin3 = Math.sin(atan2);
            double d28 = -d8;
            double d29 = d28 * cos2;
            double d30 = d10 * sin2;
            double d31 = (d29 * sin3) - (d30 * cos3);
            double d32 = d28 * sin2;
            double d33 = d10 * cos2;
            double d34 = (cos3 * d33) + (sin3 * d32);
            double d35 = atan22 / ((double) ceil);
            double d36 = atan2;
            while (i2 < ceil) {
                double d37 = d36 + d35;
                double sin4 = Math.sin(d37);
                double cos4 = Math.cos(d37);
                double d38 = (((d8 * cos2) * cos4) + d26) - (d30 * sin4);
                double d39 = (d33 * sin4) + (d8 * sin2 * cos4) + d27;
                double d40 = (d29 * sin4) - (d30 * cos4);
                double d41 = (cos4 * d33) + (sin4 * d32);
                double d42 = d37 - d36;
                double tan = Math.tan(d42 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d42)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d31 * sqrt3) + d7), (float) ((d34 * sqrt3) + d12), (float) (d38 - (sqrt3 * d40)), (float) (d39 - (sqrt3 * d41)), (float) d38, (float) d39);
                i2++;
                d33 = d33;
                d32 = d32;
                ceil = ceil;
                cos2 = cos2;
                d36 = d37;
                d8 = d8;
                d34 = d41;
                d31 = d40;
                d7 = d38;
                d12 = d39;
                d35 = d35;
                d26 = d26;
            }
        }
    }

    public static void b(c[] cVarArr, Path path) {
        int i2;
        int i3;
        int i4;
        float[] fArr;
        char c;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        c[] cVarArr2 = cVarArr;
        float[] fArr2 = new float[6];
        char c2 = 'm';
        char c3 = 0;
        char c4 = 'm';
        int i5 = 0;
        while (i5 < cVarArr2.length) {
            char c5 = cVarArr2[i5].a;
            float[] fArr3 = cVarArr2[i5].b;
            float f21 = fArr2[c3];
            float f22 = fArr2[1];
            float f23 = fArr2[2];
            float f24 = fArr2[3];
            float f25 = fArr2[4];
            float f26 = fArr2[5];
            switch (c5) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f25, f26);
                    f21 = f25;
                    f23 = f21;
                    f22 = f26;
                    f24 = f22;
                default:
                    i2 = 2;
                    break;
            }
            float f27 = f25;
            float f28 = f26;
            float f29 = f21;
            float f30 = f22;
            int i6 = 0;
            while (i6 < fArr3.length) {
                if (c5 != 'A') {
                    if (c5 != 'C') {
                        if (c5 == 'H') {
                            i3 = i6;
                            fArr = fArr3;
                            c = c5;
                            i4 = i5;
                            int i7 = i3 + 0;
                            path.lineTo(fArr[i7], f30);
                            f29 = fArr[i7];
                        } else if (c5 == 'Q') {
                            i3 = i6;
                            fArr = fArr3;
                            c = c5;
                            i4 = i5;
                            int i8 = i3 + 0;
                            int i9 = i3 + 1;
                            int i10 = i3 + 2;
                            int i11 = i3 + 3;
                            path.quadTo(fArr[i8], fArr[i9], fArr[i10], fArr[i11]);
                            f3 = fArr[i8];
                            f2 = fArr[i9];
                            f29 = fArr[i10];
                            f30 = fArr[i11];
                        } else if (c5 == 'V') {
                            i3 = i6;
                            fArr = fArr3;
                            c = c5;
                            i4 = i5;
                            int i12 = i3 + 0;
                            path.lineTo(f29, fArr[i12]);
                            f30 = fArr[i12];
                        } else if (c5 != 'a') {
                            if (c5 != 'c') {
                                if (c5 == 'h') {
                                    i3 = i6;
                                    int i13 = i3 + 0;
                                    path.rLineTo(fArr3[i13], 0.0f);
                                    f29 += fArr3[i13];
                                } else if (c5 != 'q') {
                                    if (c5 == 'v') {
                                        i3 = i6;
                                        f11 = f30;
                                        int i14 = i3 + 0;
                                        path.rLineTo(0.0f, fArr3[i14]);
                                        f12 = fArr3[i14];
                                    } else if (c5 != 'L') {
                                        if (c5 == 'M') {
                                            i3 = i6;
                                            int i15 = i3 + 0;
                                            float f31 = fArr3[i15];
                                            int i16 = i3 + 1;
                                            float f32 = fArr3[i16];
                                            if (i3 > 0) {
                                                path.lineTo(fArr3[i15], fArr3[i16]);
                                                f29 = f31;
                                                f30 = f32;
                                            } else {
                                                path.moveTo(fArr3[i15], fArr3[i16]);
                                                f27 = f31;
                                                f28 = f32;
                                            }
                                        } else if (c5 == 'S') {
                                            i3 = i6;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f13 = (f30 * 2.0f) - f24;
                                                f14 = (f29 * 2.0f) - f23;
                                            } else {
                                                f14 = f29;
                                                f13 = f30;
                                            }
                                            int i17 = i3 + 0;
                                            int i18 = i3 + 1;
                                            int i19 = i3 + 2;
                                            int i20 = i3 + 3;
                                            path.cubicTo(f14, f13, fArr3[i17], fArr3[i18], fArr3[i19], fArr3[i20]);
                                            float f33 = fArr3[i17];
                                            float f34 = fArr3[i18];
                                            f5 = fArr3[i19];
                                            f4 = fArr3[i20];
                                            f23 = f33;
                                            f24 = f34;
                                            f29 = f5;
                                            f30 = f4;
                                        } else if (c5 == 'T') {
                                            i3 = i6;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f15 = (f29 * 2.0f) - f23;
                                                f16 = (f30 * 2.0f) - f24;
                                            } else {
                                                f15 = f29;
                                                f16 = f30;
                                            }
                                            int i21 = i3 + 0;
                                            int i22 = i3 + 1;
                                            path.quadTo(f15, f16, fArr3[i21], fArr3[i22]);
                                            f24 = f16;
                                            f23 = f15;
                                            fArr = fArr3;
                                            c = c5;
                                            i4 = i5;
                                            f29 = fArr3[i21];
                                            f30 = fArr3[i22];
                                        } else if (c5 == 'l') {
                                            i3 = i6;
                                            f11 = f30;
                                            int i23 = i3 + 0;
                                            int i24 = i3 + 1;
                                            path.rLineTo(fArr3[i23], fArr3[i24]);
                                            f29 += fArr3[i23];
                                            f12 = fArr3[i24];
                                        } else if (c5 == c2) {
                                            i3 = i6;
                                            int i25 = i3 + 0;
                                            f29 += fArr3[i25];
                                            int i26 = i3 + 1;
                                            f30 += fArr3[i26];
                                            if (i3 > 0) {
                                                path.rLineTo(fArr3[i25], fArr3[i26]);
                                            } else {
                                                path.rMoveTo(fArr3[i25], fArr3[i26]);
                                                f28 = f30;
                                                f27 = f29;
                                            }
                                        } else if (c5 != 's') {
                                            if (c5 == 't') {
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f19 = f29 - f23;
                                                    f20 = f30 - f24;
                                                } else {
                                                    f20 = 0.0f;
                                                    f19 = 0.0f;
                                                }
                                                int i27 = i6 + 0;
                                                int i28 = i6 + 1;
                                                path.rQuadTo(f19, f20, fArr3[i27], fArr3[i28]);
                                                float f35 = f19 + f29;
                                                float f36 = f20 + f30;
                                                f29 += fArr3[i27];
                                                f30 += fArr3[i28];
                                                f24 = f36;
                                                f23 = f35;
                                            }
                                            i3 = i6;
                                        } else {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f17 = f30 - f24;
                                                f18 = f29 - f23;
                                            } else {
                                                f18 = 0.0f;
                                                f17 = 0.0f;
                                            }
                                            int i29 = i6 + 0;
                                            int i30 = i6 + 1;
                                            int i31 = i6 + 2;
                                            int i32 = i6 + 3;
                                            i3 = i6;
                                            f6 = f30;
                                            path.rCubicTo(f18, f17, fArr3[i29], fArr3[i30], fArr3[i31], fArr3[i32]);
                                            f9 = fArr3[i29] + f29;
                                            f8 = fArr3[i30] + f6;
                                            f7 = f29 + fArr3[i31];
                                            f10 = fArr3[i32];
                                        }
                                        f29 = f27;
                                        f30 = f28;
                                    } else {
                                        i3 = i6;
                                        int i33 = i3 + 0;
                                        int i34 = i3 + 1;
                                        path.lineTo(fArr3[i33], fArr3[i34]);
                                        f29 = fArr3[i33];
                                        f30 = fArr3[i34];
                                    }
                                    f30 = f11 + f12;
                                } else {
                                    i3 = i6;
                                    f6 = f30;
                                    int i35 = i3 + 0;
                                    int i36 = i3 + 1;
                                    int i37 = i3 + 2;
                                    int i38 = i3 + 3;
                                    path.rQuadTo(fArr3[i35], fArr3[i36], fArr3[i37], fArr3[i38]);
                                    f9 = fArr3[i35] + f29;
                                    f8 = fArr3[i36] + f6;
                                    float f37 = f29 + fArr3[i37];
                                    float f38 = fArr3[i38];
                                    f7 = f37;
                                    f10 = f38;
                                }
                                fArr = fArr3;
                                c = c5;
                                i4 = i5;
                            } else {
                                i3 = i6;
                                f6 = f30;
                                int i39 = i3 + 2;
                                int i40 = i3 + 3;
                                int i41 = i3 + 4;
                                int i42 = i3 + 5;
                                path.rCubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i39], fArr3[i40], fArr3[i41], fArr3[i42]);
                                f9 = fArr3[i39] + f29;
                                f8 = fArr3[i40] + f6;
                                f7 = f29 + fArr3[i41];
                                f10 = fArr3[i42];
                            }
                            f4 = f6 + f10;
                            f23 = f9;
                            f24 = f8;
                            f5 = f7;
                            f29 = f5;
                            f30 = f4;
                            fArr = fArr3;
                            c = c5;
                            i4 = i5;
                        } else {
                            i3 = i6;
                            int i43 = i3 + 5;
                            int i44 = i3 + 6;
                            fArr = fArr3;
                            c = c5;
                            i4 = i5;
                            a(path, f29, f30, fArr3[i43] + f29, fArr3[i44] + f30, fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                            f29 += fArr[i43];
                            f30 += fArr[i44];
                        }
                        i6 = i3 + i2;
                        c4 = c;
                        c5 = c4;
                        fArr3 = fArr;
                        i5 = i4;
                        c2 = 'm';
                    } else {
                        i3 = i6;
                        fArr = fArr3;
                        c = c5;
                        i4 = i5;
                        int i45 = i3 + 2;
                        int i46 = i3 + 3;
                        int i47 = i3 + 4;
                        int i48 = i3 + 5;
                        path.cubicTo(fArr[i3 + 0], fArr[i3 + 1], fArr[i45], fArr[i46], fArr[i47], fArr[i48]);
                        float f39 = fArr[i47];
                        float f40 = fArr[i48];
                        f3 = fArr[i45];
                        f29 = f39;
                        f30 = f40;
                        f2 = fArr[i46];
                    }
                    f23 = f3;
                    f24 = f2;
                    i6 = i3 + i2;
                    c4 = c;
                    c5 = c4;
                    fArr3 = fArr;
                    i5 = i4;
                    c2 = 'm';
                } else {
                    i3 = i6;
                    fArr = fArr3;
                    c = c5;
                    i4 = i5;
                    int i49 = i3 + 5;
                    int i50 = i3 + 6;
                    a(path, f29, f30, fArr[i49], fArr[i50], fArr[i3 + 0], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3] != 0.0f, fArr[i3 + 4] != 0.0f);
                    f29 = fArr[i49];
                    f30 = fArr[i50];
                }
                f24 = f30;
                f23 = f29;
                i6 = i3 + i2;
                c4 = c;
                c5 = c4;
                fArr3 = fArr;
                i5 = i4;
                c2 = 'm';
            }
            fArr2[0] = f29;
            fArr2[1] = f30;
            fArr2[2] = f23;
            fArr2[3] = f24;
            fArr2[4] = f27;
            fArr2[5] = f28;
            i5++;
            c4 = cVarArr[i5].a;
            c2 = 'm';
            c3 = 0;
            cVarArr2 = cVarArr;
        }
    }
}
