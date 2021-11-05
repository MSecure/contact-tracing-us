package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import c.b.b.b.c;
import c.b.b.c.a;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

public class FakeDiagnosisKeyDownloader {
    public static final a BASE32;
    public static final String FILE_PATTERN = "/diag_keys/sample_diagnosis_key_file_%s.zip";
    public static final SecureRandom RAND = new SecureRandom();
    public final Context context;

    static {
        a.e eVar = (a.e) a.f3352b.e();
        Character ch = eVar.f3360e;
        a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f3359d, null);
        }
        BASE32 = aVar;
    }

    public FakeDiagnosisKeyDownloader(Context context2) {
        this.context = context2;
    }

    public static String uniq() {
        byte[] bArr = new byte[4];
        RAND.nextBytes(bArr);
        return BASE32.c(bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r1 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        throw r2;
     */
    public u<c<KeyFileBatch>> download() {
        File file = new File(this.context.getFilesDir(), String.format(FILE_PATTERN, uniq()));
        try {
            InputStream openRawResource = this.context.getResources().openRawResource(R.raw.sample_diagnosis_key_file);
            e.a.a.a.a.a(openRawResource, file);
            if (openRawResource != null) {
                openRawResource.close();
            }
            return c.b.a.a.c.n.c.k1(c.x(KeyFileBatch.ofFiles(CountryCodes.DEFAULT_COUNTRY, 1, file)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
