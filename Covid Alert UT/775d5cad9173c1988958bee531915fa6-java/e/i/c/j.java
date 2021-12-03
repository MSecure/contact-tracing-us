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
import e.i.b.b.d;
import e.i.b.b.e;
import e.i.f.l;
import java.io.IOException;
import java.io.InputStream;

public class j extends l {
    @Override // e.i.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        try {
            e[] eVarArr = dVar.a;
            int length = eVarArr.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                e eVar = eVarArr[i4];
                try {
                    Font.Builder weight = new Font.Builder(resources, eVar.f1484f).setWeight(eVar.b);
                    if (!eVar.c) {
                        i5 = 0;
                    }
                    Font build = weight.setSlant(i5).setTtcIndex(eVar.f1483e).setFontVariationSettings(eVar.f1482d).build();
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
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // e.i.c.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = lVarArr.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                l lVar = lVarArr[i4];
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(lVar.a, "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        try {
                            Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(lVar.c);
                            if (!lVar.f1511d) {
                                i5 = 0;
                            }
                            Font build = weight.setSlant(i5).setTtcIndex(lVar.b).build();
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
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // e.i.c.l
    public Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // e.i.c.l
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
