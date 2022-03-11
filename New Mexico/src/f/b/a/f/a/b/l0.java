package f.b.a.f.a.b;

import android.os.ParcelFileDescriptor;
import f.b.a.c.b.o.b;
import f.b.a.f.a.e.r;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public final class l0 {
    public final r<v3> a;

    public l0(r<v3> rVar) {
        this.a = rVar;
    }

    public final InputStream a(int i2, String str, String str2, int i3) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) b.k(this.a.a().g(i2, str, str2, i3));
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor() != null) {
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            }
            throw new z0(String.format("Corrupted ParcelFileDescriptor, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i2), str, str2, Integer.valueOf(i3)), i2);
        } catch (InterruptedException e2) {
            throw new z0("Extractor was interrupted while waiting for chunk file.", e2, i2);
        } catch (ExecutionException e3) {
            throw new z0(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i2), str, str2, Integer.valueOf(i3)), e3, i2);
        }
    }
}
