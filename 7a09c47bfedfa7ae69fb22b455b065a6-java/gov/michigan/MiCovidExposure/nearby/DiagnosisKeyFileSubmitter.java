package gov.michigan.MiCovidExposure.nearby;

import android.content.Context;
import b.x.t;
import c.b.b.b.e;
import c.b.b.c.a;
import c.b.b.e.a.u;
import g.a.a.a.b;
import g.b.a.c;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.common.TaskToFutureAdapter;
import gov.michigan.MiCovidExposure.network.KeyFileBatch;
import gov.michigan.MiCovidExposure.network.KeyFileConstants;
import gov.michigan.MiCovidExposure.proto.TEKSignatureList;
import gov.michigan.MiCovidExposure.proto.TemporaryExposureKey;
import gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyExport;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
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
    public static final a BASE16 = a.f4694c.e();
    public static final a BASE64 = a.f4692a;
    public static final c PROVIDE_KEYS_TIMEOUT = c.i(60);
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
            e<File> w = ((KeyFileBatch) it.next()).files().listIterator();
            while (w.hasNext()) {
                w.next().delete();
            }
        }
    }

    private void logBatch(KeyFileBatch keyFileBatch) {
        keyFileBatch.batchNum();
        keyFileBatch.files().size();
        e<File> w = keyFileBatch.files().listIterator();
        int i = 1;
        while (w.hasNext()) {
            File next = w.next();
            try {
                FileContent readFile = readFile(next);
                String str = "File " + i + " has signature:\n" + readFile.signature;
                readFile.export.getKeysCount();
                for (TemporaryExposureKey temporaryExposureKey : readFile.export.getKeysList()) {
                    BASE16.c(temporaryExposureKey.getKeyData().w());
                    BASE64.c(temporaryExposureKey.getKeyData().w());
                    temporaryExposureKey.getRollingStartIntervalNumber();
                    temporaryExposureKey.getRollingPeriod();
                    temporaryExposureKey.getTransmissionRiskLevel();
                }
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
        g.a.a.a.c.a aVar = new g.a.a.a.c.a();
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
        }
        return TaskToFutureAdapter.getFutureWithTimeout(this.client.provideDiagnosisKeys2(arrayList), PROVIDE_KEYS_TIMEOUT.s(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
    }

    public u<?> submitFiles(List<KeyFileBatch> list, String str) {
        if (list.isEmpty()) {
            return t.N1(null);
        }
        StringBuilder h = c.a.a.a.a.h("Providing  ");
        h.append(list.size());
        h.append(" diagnosis key batches to google play services.");
        CustomUtility.customLogger(h.toString());
        list.size();
        u<?> submitBatches = submitBatches(list, str);
        submitBatches.b(new e.a.a.d.a(list), AppExecutors.getBackgroundExecutor());
        return submitBatches;
    }
}
