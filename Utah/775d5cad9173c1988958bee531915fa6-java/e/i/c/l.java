package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import e.b.a.m;
import e.i.b.b.d;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public class l {
    public ConcurrentHashMap<Long, d> a = new ConcurrentHashMap<>();

    public interface a<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T e(T[] tArr, int i2, a<T> aVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.a(t2) - i3) * 2) + (aVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, e.i.f.l[] lVarArr, int i2) {
        throw null;
    }

    public Typeface c(Context context, InputStream inputStream) {
        File B0 = m.e.B0(context);
        if (B0 == null) {
            return null;
        }
        try {
            if (!m.e.C(B0, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(B0.getPath());
            B0.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            B0.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        File B0 = m.e.B0(context);
        if (B0 == null) {
            return null;
        }
        try {
            if (!m.e.B(B0, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(B0.getPath());
            B0.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            B0.delete();
        }
    }
}
