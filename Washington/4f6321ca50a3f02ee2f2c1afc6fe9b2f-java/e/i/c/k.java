package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import e.b.a.m;
import e.i.b.b.c;
import e.i.f.e;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public class k {
    public ConcurrentHashMap<Long, c> a = new ConcurrentHashMap<>();

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

    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, e.c[] cVarArr, int i2) {
        throw null;
    }

    public Typeface c(Context context, InputStream inputStream) {
        File p0 = m.h.p0(context);
        if (p0 == null) {
            return null;
        }
        try {
            if (!m.h.z(p0, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(p0.getPath());
            p0.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            p0.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        File p0 = m.h.p0(context);
        if (p0 == null) {
            return null;
        }
        try {
            if (!m.h.y(p0, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(p0.getPath());
            p0.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            p0.delete();
        }
    }
}
