package b.i.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import b.i.e.b.c;
import b.i.e.b.d;
import b.i.i.b;
import java.io.IOException;

public class i extends j {
    @Override // b.i.f.j
    public Typeface a(Context context, c cVar, Resources resources, int i) {
        d[] dVarArr = cVar.f1029a;
        int length = dVarArr.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            d dVar = dVarArr[i3];
            try {
                Font.Builder weight = new Font.Builder(resources, dVar.f).setWeight(dVar.f1031b);
                if (!dVar.f1032c) {
                    i4 = 0;
                }
                Font build = weight.setSlant(i4).setTtcIndex(dVar.f1034e).setFontVariationSettings(dVar.f1033d).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i3++;
        }
        if (builder == null) {
            return null;
        }
        int i5 = (i & 1) != 0 ? 700 : 400;
        if ((i & 2) != 0) {
            i2 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
    }

    @Override // b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        int length = fVarArr.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            b.f fVar = fVarArr[i3];
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(fVar.f1087a, "r", cancellationSignal);
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fVar.f1089c);
                        if (!fVar.f1090d) {
                            i4 = 0;
                        }
                        Font build = weight.setSlant(i4).setTtcIndex(fVar.f1088b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else if (openFileDescriptor == null) {
                    i3++;
                }
                openFileDescriptor.close();
            } catch (IOException unused) {
            }
            i3++;
        }
        if (builder == null) {
            return null;
        }
        int i5 = (i & 1) != 0 ? 700 : 400;
        if ((i & 2) != 0) {
            i2 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
        throw th;
    }

    @Override // b.i.f.j
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // b.i.f.j
    public b.f f(b.f[] fVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
