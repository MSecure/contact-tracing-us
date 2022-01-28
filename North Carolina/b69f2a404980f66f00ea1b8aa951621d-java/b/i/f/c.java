package b.i.f;

import android.graphics.Path;
import b.b.k.i;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public char f1052a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f1053b;

    public c(char c2, float[] fArr) {
        this.f1052a = c2;
        this.f1053b = fArr;
    }

    public c(c cVar) {
        this.f1052a = cVar.f1052a;
        float[] fArr = cVar.f1053b;
        this.f1053b = i.j.A(fArr, 0, fArr.length);
    }

    public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d2;
        double d3;
        double radians = Math.toRadians((double) f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d4 = (double) f;
        double d5 = (double) f2;
        double d6 = (d5 * sin) + (d4 * cos);
        double d7 = d4;
        double d8 = (double) f5;
        double d9 = d6 / d8;
        double d10 = (double) f6;
        double d11 = ((d5 * cos) + (((double) (-f)) * sin)) / d10;
        double d12 = d5;
        double d13 = (double) f4;
        double d14 = ((d13 * sin) + (((double) f3) * cos)) / d8;
        double d15 = ((d13 * cos) + (((double) (-f3)) * sin)) / d10;
        double d16 = d9 - d14;
        double d17 = d11 - d15;
        double d18 = (d9 + d14) / 2.0d;
        double d19 = (d11 + d15) / 2.0d;
        double d20 = (d17 * d17) + (d16 * d16);
        if (d20 != 0.0d) {
            double d21 = (1.0d / d20) - 0.25d;
            if (d21 < 0.0d) {
                float sqrt = (float) (Math.sqrt(d20) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
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
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
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
            int i2 = 0;
            while (i2 < ceil) {
                double d36 = atan2 + d35;
                double sin4 = Math.sin(d36);
                double cos4 = Math.cos(d36);
                double d37 = (((d8 * cos2) * cos4) + d26) - (d30 * sin4);
                double d38 = (d33 * sin4) + (d8 * sin2 * cos4) + d27;
                double d39 = (d29 * sin4) - (d30 * cos4);
                double d40 = (cos4 * d33) + (sin4 * d32);
                double d41 = d36 - atan2;
                double tan = Math.tan(d41 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d41)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d31 * sqrt3) + d7), (float) ((d34 * sqrt3) + d12), (float) (d37 - (sqrt3 * d39)), (float) (d38 - (sqrt3 * d40)), (float) d37, (float) d38);
                i2++;
                atan2 = d36;
                cos2 = cos2;
                d32 = d32;
                d34 = d40;
                ceil = ceil;
                d8 = d8;
                d31 = d39;
                d7 = d37;
                d12 = d38;
                d35 = d35;
                d26 = d26;
            }
        }
    }

    public static void b(c[] cVarArr, Path path) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        char c2;
        float f;
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
        c[] cVarArr2 = cVarArr;
        int i4 = 6;
        float[] fArr2 = new float[6];
        char c3 = 'm';
        int i5 = 0;
        char c4 = 'm';
        int i6 = 0;
        while (i6 < cVarArr2.length) {
            char c5 = cVarArr2[i6].f1052a;
            float[] fArr3 = cVarArr2[i6].f1053b;
            float f20 = fArr2[i5];
            float f21 = fArr2[1];
            float f22 = fArr2[2];
            float f23 = fArr2[3];
            float f24 = fArr2[4];
            float f25 = fArr2[5];
            switch (c5) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = i4;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f24, f25);
                    f20 = f24;
                    f22 = f20;
                    f21 = f25;
                    f23 = f21;
                default:
                    i = 2;
                    break;
            }
            float f26 = f24;
            float f27 = f25;
            float f28 = f20;
            float f29 = f21;
            int i7 = i5;
            while (i7 < fArr3.length) {
                if (c5 != 'A') {
                    if (c5 != 'C') {
                        if (c5 == 'H') {
                            i2 = i7;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i6;
                            int i8 = i2 + 0;
                            path.lineTo(fArr[i8], f29);
                            f28 = fArr[i8];
                        } else if (c5 == 'Q') {
                            i2 = i7;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i6;
                            int i9 = i2 + 0;
                            int i10 = i2 + 1;
                            int i11 = i2 + 2;
                            int i12 = i2 + 3;
                            path.quadTo(fArr[i9], fArr[i10], fArr[i11], fArr[i12]);
                            f2 = fArr[i9];
                            f = fArr[i10];
                            f28 = fArr[i11];
                            f29 = fArr[i12];
                        } else if (c5 == 'V') {
                            i2 = i7;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i6;
                            int i13 = i2 + 0;
                            path.lineTo(f28, fArr[i13]);
                            f29 = fArr[i13];
                        } else if (c5 != 'a') {
                            if (c5 != 'c') {
                                if (c5 == 'h') {
                                    i2 = i7;
                                    int i14 = i2 + 0;
                                    path.rLineTo(fArr3[i14], 0.0f);
                                    f28 += fArr3[i14];
                                } else if (c5 != 'q') {
                                    if (c5 == 'v') {
                                        i2 = i7;
                                        f10 = f29;
                                        int i15 = i2 + 0;
                                        path.rLineTo(0.0f, fArr3[i15]);
                                        f11 = fArr3[i15];
                                    } else if (c5 != 'L') {
                                        if (c5 == 'M') {
                                            i2 = i7;
                                            int i16 = i2 + 0;
                                            float f30 = fArr3[i16];
                                            int i17 = i2 + 1;
                                            float f31 = fArr3[i17];
                                            if (i2 > 0) {
                                                path.lineTo(fArr3[i16], fArr3[i17]);
                                                f28 = f30;
                                                f29 = f31;
                                            } else {
                                                path.moveTo(fArr3[i16], fArr3[i17]);
                                                f26 = f30;
                                                f27 = f31;
                                            }
                                        } else if (c5 == 'S') {
                                            i2 = i7;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f12 = (f29 * 2.0f) - f23;
                                                f13 = (f28 * 2.0f) - f22;
                                            } else {
                                                f13 = f28;
                                                f12 = f29;
                                            }
                                            int i18 = i2 + 0;
                                            int i19 = i2 + 1;
                                            int i20 = i2 + 2;
                                            int i21 = i2 + 3;
                                            path.cubicTo(f13, f12, fArr3[i18], fArr3[i19], fArr3[i20], fArr3[i21]);
                                            float f32 = fArr3[i18];
                                            float f33 = fArr3[i19];
                                            f4 = fArr3[i20];
                                            f3 = fArr3[i21];
                                            f22 = f32;
                                            f23 = f33;
                                            f28 = f4;
                                            f29 = f3;
                                        } else if (c5 == 'T') {
                                            i2 = i7;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f14 = (f28 * 2.0f) - f22;
                                                f15 = (f29 * 2.0f) - f23;
                                            } else {
                                                f14 = f28;
                                                f15 = f29;
                                            }
                                            int i22 = i2 + 0;
                                            int i23 = i2 + 1;
                                            path.quadTo(f14, f15, fArr3[i22], fArr3[i23]);
                                            f23 = f15;
                                            f22 = f14;
                                            fArr = fArr3;
                                            c2 = c5;
                                            i3 = i6;
                                            f28 = fArr3[i22];
                                            f29 = fArr3[i23];
                                        } else if (c5 == 'l') {
                                            i2 = i7;
                                            f10 = f29;
                                            int i24 = i2 + 0;
                                            int i25 = i2 + 1;
                                            path.rLineTo(fArr3[i24], fArr3[i25]);
                                            f28 += fArr3[i24];
                                            f11 = fArr3[i25];
                                        } else if (c5 == c3) {
                                            i2 = i7;
                                            int i26 = i2 + 0;
                                            f28 += fArr3[i26];
                                            int i27 = i2 + 1;
                                            f29 += fArr3[i27];
                                            if (i2 > 0) {
                                                path.rLineTo(fArr3[i26], fArr3[i27]);
                                            } else {
                                                path.rMoveTo(fArr3[i26], fArr3[i27]);
                                                f27 = f29;
                                                f26 = f28;
                                            }
                                        } else if (c5 != 's') {
                                            if (c5 == 't') {
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f18 = f28 - f22;
                                                    f19 = f29 - f23;
                                                } else {
                                                    f19 = 0.0f;
                                                    f18 = 0.0f;
                                                }
                                                int i28 = i7 + 0;
                                                int i29 = i7 + 1;
                                                path.rQuadTo(f18, f19, fArr3[i28], fArr3[i29]);
                                                float f34 = f18 + f28;
                                                float f35 = f19 + f29;
                                                f28 += fArr3[i28];
                                                f29 += fArr3[i29];
                                                f23 = f35;
                                                f22 = f34;
                                            }
                                            i2 = i7;
                                        } else {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f16 = f29 - f23;
                                                f17 = f28 - f22;
                                            } else {
                                                f17 = 0.0f;
                                                f16 = 0.0f;
                                            }
                                            int i30 = i7 + 0;
                                            int i31 = i7 + 1;
                                            int i32 = i7 + 2;
                                            int i33 = i7 + 3;
                                            i2 = i7;
                                            f5 = f29;
                                            path.rCubicTo(f17, f16, fArr3[i30], fArr3[i31], fArr3[i32], fArr3[i33]);
                                            f8 = fArr3[i30] + f28;
                                            f7 = fArr3[i31] + f5;
                                            f6 = f28 + fArr3[i32];
                                            f9 = fArr3[i33];
                                        }
                                        f28 = f26;
                                        f29 = f27;
                                    } else {
                                        i2 = i7;
                                        int i34 = i2 + 0;
                                        int i35 = i2 + 1;
                                        path.lineTo(fArr3[i34], fArr3[i35]);
                                        f28 = fArr3[i34];
                                        f29 = fArr3[i35];
                                    }
                                    f29 = f10 + f11;
                                } else {
                                    i2 = i7;
                                    f5 = f29;
                                    int i36 = i2 + 0;
                                    int i37 = i2 + 1;
                                    int i38 = i2 + 2;
                                    int i39 = i2 + 3;
                                    path.rQuadTo(fArr3[i36], fArr3[i37], fArr3[i38], fArr3[i39]);
                                    f8 = fArr3[i36] + f28;
                                    f7 = fArr3[i37] + f5;
                                    float f36 = f28 + fArr3[i38];
                                    float f37 = fArr3[i39];
                                    f6 = f36;
                                    f9 = f37;
                                }
                                fArr = fArr3;
                                c2 = c5;
                                i3 = i6;
                            } else {
                                i2 = i7;
                                f5 = f29;
                                int i40 = i2 + 2;
                                int i41 = i2 + 3;
                                int i42 = i2 + 4;
                                int i43 = i2 + 5;
                                path.rCubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i40], fArr3[i41], fArr3[i42], fArr3[i43]);
                                f8 = fArr3[i40] + f28;
                                f7 = fArr3[i41] + f5;
                                f6 = f28 + fArr3[i42];
                                f9 = fArr3[i43];
                            }
                            f3 = f5 + f9;
                            f22 = f8;
                            f23 = f7;
                            f4 = f6;
                            f28 = f4;
                            f29 = f3;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i6;
                        } else {
                            i2 = i7;
                            int i44 = i2 + 5;
                            int i45 = i2 + 6;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i6;
                            a(path, f28, f29, fArr3[i44] + f28, fArr3[i45] + f29, fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                            f28 += fArr[i44];
                            f29 += fArr[i45];
                        }
                        i7 = i2 + i;
                        c4 = c2;
                        c5 = c4;
                        fArr3 = fArr;
                        i6 = i3;
                        c3 = 'm';
                        i5 = 0;
                    } else {
                        i2 = i7;
                        fArr = fArr3;
                        c2 = c5;
                        i3 = i6;
                        int i46 = i2 + 2;
                        int i47 = i2 + 3;
                        int i48 = i2 + 4;
                        int i49 = i2 + 5;
                        path.cubicTo(fArr[i2 + 0], fArr[i2 + 1], fArr[i46], fArr[i47], fArr[i48], fArr[i49]);
                        float f38 = fArr[i48];
                        float f39 = fArr[i49];
                        f2 = fArr[i46];
                        f28 = f38;
                        f29 = f39;
                        f = fArr[i47];
                    }
                    f22 = f2;
                    f23 = f;
                    i7 = i2 + i;
                    c4 = c2;
                    c5 = c4;
                    fArr3 = fArr;
                    i6 = i3;
                    c3 = 'm';
                    i5 = 0;
                } else {
                    i2 = i7;
                    fArr = fArr3;
                    c2 = c5;
                    i3 = i6;
                    int i50 = i2 + 5;
                    int i51 = i2 + 6;
                    a(path, f28, f29, fArr[i50], fArr[i51], fArr[i2 + 0], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f, fArr[i2 + 4] != 0.0f);
                    f28 = fArr[i50];
                    f29 = fArr[i51];
                }
                f23 = f29;
                f22 = f28;
                i7 = i2 + i;
                c4 = c2;
                c5 = c4;
                fArr3 = fArr;
                i6 = i3;
                c3 = 'm';
                i5 = 0;
            }
            fArr2[i5] = f28;
            fArr2[1] = f29;
            fArr2[2] = f22;
            fArr2[3] = f23;
            fArr2[4] = f26;
            fArr2[5] = f27;
            i6++;
            i4 = 6;
            c3 = 'm';
            c4 = cVarArr[i6].f1052a;
            cVarArr2 = cVarArr;
        }
    }
}
