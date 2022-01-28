package b.i.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import b.b.k.i;
import b.i.e.b.c;
import b.i.i.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Long, c> f1763a = new ConcurrentHashMap<>();

    public class a implements b<b.f> {
        public a(j jVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.i.f.j.b
        public int a(b.f fVar) {
            return fVar.f1793c;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.i.f.j.b
        public boolean b(b.f fVar) {
            return fVar.f1794d;
        }
    }

    public interface b<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T e(T[] tArr, int i, b<T> bVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(bVar.a(t2) - i2) * 2) + (bVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public abstract Typeface a(Context context, c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i);

    public Typeface c(Context context, InputStream inputStream) {
        File I = i.j.I(context);
        if (I == null) {
            return null;
        }
        try {
            if (!i.j.p(I, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(I.getPath());
            I.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            I.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File I = i.j.I(context);
        if (I == null) {
            return null;
        }
        try {
            if (!i.j.o(I, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(I.getPath());
            I.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            I.delete();
        }
    }

    public b.f f(b.f[] fVarArr, int i) {
        return (b.f) e(fVarArr, i, new a(this));
    }
}
