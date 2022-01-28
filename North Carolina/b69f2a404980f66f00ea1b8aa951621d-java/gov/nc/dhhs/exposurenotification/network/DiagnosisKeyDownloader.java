package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import android.net.Uri;
import b.b.k.i;
import b.f.a.b;
import c.a.b.f;
import c.a.b.l;
import c.a.b.o;
import c.a.b.q;
import c.a.b.v;
import c.b.b.b.c;
import c.b.b.c.a;
import c.b.b.e.a.p;
import c.b.b.e.a.s;
import c.b.b.e.a.u;
import d.a.a.a.g.e;
import d.a.a.a.g.g;
import d.a.a.a.g.h;
import d.a.a.a.g.j;
import e.c.a.c;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DiagnosisKeyDownloader {
    public static final a BASE32;
    public static final c DOWNLOAD_ALL_FILES_TIMEOUT = c.b(c.b.a.a.c.n.c.Z1(30, 60), 0);
    public static final String FILE_PATTERN = "/diag_keys/%s/keys_%s.zip";
    public static p<c.b.b.b.c<KeyFileBatch>> LOG_OUTCOME = new p<c.b.b.b.c<KeyFileBatch>>() {
        /* class gov.nc.dhhs.exposurenotification.network.DiagnosisKeyDownloader.AnonymousClass1 */

        @Override // c.b.b.e.a.p
        public void onFailure(Throwable th) {
        }

        public void onSuccess(c.b.b.b.c<KeyFileBatch> cVar) {
        }
    };
    public static final int MAX_RETRIES = 3;
    public static final SecureRandom RAND = new SecureRandom();
    public static final float RETRY_BACKOFF = 1.0f;
    public static final c SINGLE_FILE_TIMEOUT = c.k(30);
    public static final String TAG = "KeyDownloader";
    public final Context context;
    public final CountryCodes countries;
    public final RequestQueueWrapper queue;
    public final Uris uris;

    public static class BatchFile {
        public final KeyFileBatch batch;
        public final File file;

        public BatchFile(KeyFileBatch keyFileBatch, File file2) {
            this.batch = keyFileBatch;
            this.file = file2;
        }
    }

    public static class ByteArrayRequest extends o<byte[]> {
        public final q.b<byte[]> listener;

        public ByteArrayRequest(Uri uri, q.b<byte[]> bVar, q.a aVar) {
            super(0, uri.toString(), aVar);
            this.listener = bVar;
            setRetryPolicy(new f((int) DiagnosisKeyDownloader.SINGLE_FILE_TIMEOUT.p(), 3, 1.0f));
        }

        public void deliverResponse(byte[] bArr) {
            this.listener.a(bArr);
        }

        @Override // c.a.b.o
        public q<byte[]> parseNetworkResponse(l lVar) {
            if (lVar.f2217a < 400) {
                return new q<>(lVar.f2218b, i.j.K0(lVar));
            }
            return new q<>(new v(lVar));
        }
    }

    static {
        a.e eVar = (a.e) a.f3352b.e();
        Character ch = eVar.f3360e;
        a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f3359d, null);
        }
        BASE32 = aVar;
    }

    public DiagnosisKeyDownloader(Context context2) {
        this.context = context2;
        this.countries = new CountryCodes(context2);
        this.uris = new Uris(context2);
        this.queue = RequestQueueWrapper.wrapping(RequestQueueSingleton.get(context2));
    }

    public DiagnosisKeyDownloader(Context context2, CountryCodes countryCodes, Uris uris2, RequestQueueWrapper requestQueueWrapper) {
        this.context = context2;
        this.countries = countryCodes;
        this.uris = uris2;
        this.queue = requestQueueWrapper;
    }

    private u<BatchFile> downloadAndSave(KeyFileBatch keyFileBatch, Uri uri, String str, int i) {
        return c.b.b.e.a.l.s(downloadFile(uri)).u(new e(this, keyFileBatch, str, i), AppExecutors.getBackgroundExecutor());
    }

    private u<byte[]> downloadFile(Uri uri) {
        return i.j.b0(new h(this, uri));
    }

    public static /* synthetic */ void e(Uri uri, b bVar, byte[] bArr) {
        String str = "Keyfile " + uri + " successfully downloaded " + bArr.length + " bytes.";
        bVar.a(bArr);
    }

    public static /* synthetic */ void f(Uri uri, b bVar, v vVar) {
        String str = "Error getting keyfile " + uri;
        bVar.b();
    }

    /* access modifiers changed from: private */
    public c.b.b.b.c<KeyFileBatch> groupAsBatches(List<BatchFile> list) {
        HashMap hashMap = new HashMap();
        for (BatchFile batchFile : list) {
            if (!hashMap.containsKey(batchFile.batch)) {
                hashMap.put(batchFile.batch, new ArrayList());
            }
            ((List) hashMap.get(batchFile.batch)).add(batchFile.file);
        }
        c.a p = c.b.b.b.c.p();
        for (Map.Entry entry : hashMap.entrySet()) {
            p.a(((KeyFileBatch) entry.getKey()).copyWith((List) entry.getValue()));
        }
        return p.b();
    }

    /* access modifiers changed from: private */
    /* renamed from: initiateDownloads */
    public u<List<BatchFile>> b(List<KeyFileBatch> list, String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        for (KeyFileBatch keyFileBatch : list) {
            c.b.b.b.e<Uri> u = keyFileBatch.uris().listIterator();
            while (u.hasNext()) {
                arrayList.add(downloadAndSave(keyFileBatch, u.next(), str, i));
                i++;
            }
        }
        return c.b.a.a.c.n.c.k(arrayList);
    }

    public static String randDirname() {
        byte[] bArr = new byte[8];
        RAND.nextBytes(bArr);
        return BASE32.c(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: saveKeyFile */
    public u<BatchFile> c(KeyFileBatch keyFileBatch, byte[] bArr, String str, int i) {
        File file = new File(this.context.getFilesDir(), String.format(FILE_PATTERN, str, Integer.valueOf(i)));
        try {
            e.a.a.a.a.c(file, bArr);
            return c.b.a.a.c.n.c.k1(new BatchFile(keyFileBatch, file));
        } catch (IOException e2) {
            return new s.a(e2);
        }
    }

    public /* synthetic */ Object d(Uri uri, b bVar) {
        String str = "Downloading keyfile file from " + uri;
        ByteArrayRequest byteArrayRequest = new ByteArrayRequest(uri, new j(uri, bVar), new d.a.a.a.g.f(uri, bVar));
        this.queue.add(byteArrayRequest);
        return byteArrayRequest;
    }

    public u<c.b.b.b.c<KeyFileBatch>> download() {
        c.b.b.e.a.l v = c.b.b.e.a.l.s(this.uris.getDownloadFileUris(this.countries.getExposureRelevantCountryCodes())).u(new d.a.a.a.g.i(this, randDirname()), AppExecutors.getBackgroundExecutor()).t(new g(this), AppExecutors.getBackgroundExecutor()).v(DOWNLOAD_ALL_FILES_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
        p<c.b.b.b.c<KeyFileBatch>> pVar = LOG_OUTCOME;
        c.b.b.e.a.v lightweightExecutor = AppExecutors.getLightweightExecutor();
        if (pVar != null) {
            v.b(new c.b.b.e.a.q(v, pVar), lightweightExecutor);
            return v;
        }
        throw null;
    }
}
