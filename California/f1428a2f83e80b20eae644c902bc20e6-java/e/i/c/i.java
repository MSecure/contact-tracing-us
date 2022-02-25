package e.i.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import e.i.b.b.c;
import e.i.b.b.d;
import e.i.f.e;
import java.io.IOException;
import java.io.InputStream;

public class i extends k {
    @Override // e.i.c.k
    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        d[] dVarArr = cVar.a;
        int length = dVarArr.length;
        int i3 = 0;
        FontFamily.Builder builder = null;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 >= length) {
                break;
            }
            d dVar = dVarArr[i4];
            try {
                Font.Builder weight = new Font.Builder(resources, dVar.f1421f).setWeight(dVar.b);
                if (!dVar.c) {
                    i5 = 0;
                }
                Font build = weight.setSlant(i5).setTtcIndex(dVar.f1420e).setFontVariationSettings(dVar.f1419d).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i4++;
        }
        if (builder == null) {
            return null;
        }
        int i6 = (i2 & 1) != 0 ? 700 : 400;
        if ((i2 & 2) != 0) {
            i3 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
    }

    @Override // e.i.c.k
    public Typeface b(Context context, CancellationSignal cancellationSignal, e.c[] cVarArr, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        int length = cVarArr.length;
        int i3 = 0;
        FontFamily.Builder builder = null;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 >= length) {
                break;
            }
            e.c cVar = cVarArr[i4];
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(cVar.a, "r", cancellationSignal);
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(cVar.c);
                        if (!cVar.f1447d) {
                            i5 = 0;
                        }
                        Font build = weight.setSlant(i5).setTtcIndex(cVar.b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else if (openFileDescriptor == null) {
                    i4++;
                }
                openFileDescriptor.close();
            } catch (IOException unused) {
            }
            i4++;
        }
        if (builder == null) {
            return null;
        }
        int i6 = (i2 & 1) != 0 ? 700 : 400;
        if ((i2 & 2) != 0) {
            i3 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
        throw th;
    }

    @Override // e.i.c.k
    public Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // e.i.c.k
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
