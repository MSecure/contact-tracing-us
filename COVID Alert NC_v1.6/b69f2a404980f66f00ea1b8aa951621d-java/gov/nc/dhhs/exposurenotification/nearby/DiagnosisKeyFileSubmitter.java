package gov.nc.dhhs.exposurenotification.nearby;

import android.content.Context;
import c.b.b.b.e;
import c.b.b.c.a;
import c.b.b.e.a.u;
import e.a.a.a.b;
import e.c.a.c;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import gov.nc.dhhs.exposurenotification.network.KeyFileBatch;
import gov.nc.dhhs.exposurenotification.network.KeyFileConstants;
import gov.nc.dhhs.exposurenotification.proto.TEKSignatureList;
import gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExport;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DiagnosisKeyFileSubmitter {
    public static final a BASE16 = a.f3353c.e();
    public static final a BASE64 = a.f3351a;
    public static final c PROVIDE_KEYS_TIMEOUT = c.g(60);
    public static final String TAG = "KeyFileSubmitter";
    public final ExposureNotificationClientWrapper client;

    public static class FileContent {
        public final TemporaryExposureKeyExport export;
        public final String header;
        public final TEKSignatureList signature;

        public FileContent(String str, TemporaryExposureKeyExport temporaryExposureKeyExport, TEKSignatureList tEKSignatureList) {
            this.export = temporaryExposureKeyExport;
            this.header = str;
            this.signature = tEKSignatureList;
        }
    }

    public DiagnosisKeyFileSubmitter(Context context) {
        this.client = ExposureNotificationClientWrapper.get(context);
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e<File> u = ((KeyFileBatch) it.next()).files().listIterator();
            while (u.hasNext()) {
                u.next().delete();
            }
        }
    }

    private void logBatch(KeyFileBatch keyFileBatch) {
        keyFileBatch.batchNum();
        keyFileBatch.files().size();
        e<File> u = keyFileBatch.files().listIterator();
        int i = 1;
        while (u.hasNext()) {
            File next = u.next();
            try {
                FileContent readFile = readFile(next);
                String str = "File " + i + " has signature:\n" + readFile.signature;
                readFile.export.getKeysCount();
                i++;
            } catch (IOException e2) {
                CustomUtility.customLogger("Failed to read or parse file " + next + " : " + e2.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to read or parse file ");
                sb.append(next);
                sb.toString();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r6.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004c, code lost:
        r1 = move-exception;
     */
    private FileContent readFile(File file) {
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry(KeyFileConstants.SIG_FILENAME);
        ZipEntry entry2 = zipFile.getEntry(KeyFileConstants.EXPORT_FILENAME);
        byte[] d2 = b.d(zipFile.getInputStream(entry));
        InputStream inputStream = zipFile.getInputStream(entry2);
        e.a.a.a.c.a aVar = new e.a.a.a.c.a();
        b.c(inputStream, aVar);
        byte[] b2 = aVar.b();
        byte[] copyOf = Arrays.copyOf(b2, 16);
        byte[] copyOfRange = Arrays.copyOfRange(b2, 16, b2.length);
        FileContent fileContent = new FileContent(new String(copyOf), TemporaryExposureKeyExport.parseFrom(copyOfRange), TEKSignatureList.parseFrom(d2));
        zipFile.close();
        return fileContent;
    }

    private u<?> submitBatches(List<KeyFileBatch> list, String str) {
        list.size();
        CustomUtility.customLogger("Combining [" + list.size() + "] key file batches into a single submission to provideDiagnosisKeys().");
        ArrayList arrayList = new ArrayList();
        for (KeyFileBatch keyFileBatch : list) {
            arrayList.addAll(keyFileBatch.files());
            logBatch(keyFileBatch);
        }
        return TaskToFutureAdapter.getFutureWithTimeout(this.client.provideDiagnosisKeys2(arrayList), PROVIDE_KEYS_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
    }

    public u<?> submitFiles(List<KeyFileBatch> list, String str) {
        if (list.isEmpty()) {
            return c.b.a.a.c.n.c.k1(null);
        }
        StringBuilder g = c.a.a.a.a.g("Providing  ");
        g.append(list.size());
        g.append(" diagnosis key batches to google play services.");
        CustomUtility.customLogger(g.toString());
        list.size();
        u<?> submitBatches = submitBatches(list, str);
        submitBatches.b(new d.a.a.a.f.a(list), AppExecutors.getBackgroundExecutor());
        return submitBatches;
    }
}
