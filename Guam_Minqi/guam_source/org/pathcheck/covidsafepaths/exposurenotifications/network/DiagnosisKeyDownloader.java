package org.pathcheck.covidsafepaths.exposurenotifications.network;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.io.FileUtils;
import org.threeten.bp.Duration;

public class DiagnosisKeyDownloader {
    public static final BaseEncoding BASE32;
    public static final SecureRandom RAND = new SecureRandom();
    public static final Duration TIMEOUT = Duration.ofSeconds(600);
    public final Context context;
    public final DownloadManager downloadManager;
    public final ConcurrentMap<Long, Download> downloadMap = new ConcurrentHashMap();
    public final BroadcastReceiver downloadStatusReceiver = new BroadcastReceiver() {
        /* class org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKeyDownloader.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b2, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
            if (r0 != null) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ba, code lost:
            r10.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bd, code lost:
            throw r1;
         */
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("extra_download_id", -1);
                if (longExtra != -1 && DiagnosisKeyDownloader.this.downloadMap.containsKey(Long.valueOf(longExtra))) {
                    Download download = DiagnosisKeyDownloader.this.downloadMap.get(Long.valueOf(longExtra));
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor query2 = DiagnosisKeyDownloader.this.downloadManager.query(query);
                    if (query2.moveToFirst()) {
                        if (8 == query2.getInt(query2.getColumnIndex("status"))) {
                            try {
                                InputStream openInputStream = context.getContentResolver().openInputStream(DiagnosisKeyDownloader.this.downloadManager.getUriForDownloadedFile(download.downloadId));
                                File file = new File(context.getFilesDir(), String.format("/diag_keys/%s/keys_%s.pb", download.dir, Long.valueOf(longExtra)));
                                FileUtils.copyInputStreamToFile(openInputStream, file);
                                download.fileFuture.set(new BatchFile(download.batch, file, null));
                                DiagnosisKeyDownloader.this.downloadManager.remove(longExtra);
                                if (openInputStream != null) {
                                    openInputStream.close();
                                }
                            } catch (IOException | NullPointerException e) {
                                download.fileFuture.setException(e);
                            }
                        } else {
                            download.fileFuture.setException(new FileNotFoundException());
                        }
                    }
                    DiagnosisKeyDownloader.this.downloadMap.remove(Long.valueOf(longExtra));
                }
            }
        }
    };
    public FutureCallback<ImmutableList<KeyFileBatch>> logOutcome = new FutureCallback<ImmutableList<KeyFileBatch>>(this) {
        /* class org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKeyDownloader.AnonymousClass2 */

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            Log.e("KeyDownloader", "Key file download failed.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(ImmutableList<KeyFileBatch> immutableList) {
            Log.i("KeyDownloader", "Key file download succeeded.");
        }
    };
    public final Uris uris;

    public static class BatchFile {
        public final KeyFileBatch batch;
        public final File file;

        public BatchFile(KeyFileBatch keyFileBatch, File file2, AnonymousClass1 r3) {
            this.batch = keyFileBatch;
            this.file = file2;
        }
    }

    public static class Download {
        public final KeyFileBatch batch;
        public final String dir;
        public final long downloadId;
        public final SettableFuture<BatchFile> fileFuture = new SettableFuture<>();

        public Download(KeyFileBatch keyFileBatch, long j, String str, AnonymousClass1 r5) {
            this.batch = keyFileBatch;
            this.downloadId = j;
            this.dir = str;
        }
    }

    static {
        BaseEncoding.StandardBaseEncoding standardBaseEncoding = (BaseEncoding.StandardBaseEncoding) BaseEncoding.BASE32.lowerCase();
        Character ch = standardBaseEncoding.paddingChar;
        BaseEncoding baseEncoding = standardBaseEncoding;
        if (ch != null) {
            baseEncoding = standardBaseEncoding.newInstance(standardBaseEncoding.alphabet, null);
        }
        BASE32 = baseEncoding;
    }

    public DiagnosisKeyDownloader(Context context2) {
        this.context = context2;
        this.downloadManager = (DownloadManager) context2.getSystemService("download");
        this.uris = new Uris();
    }

    public final ImmutableList<KeyFileBatch> groupAsBatches(List<BatchFile> list) {
        HashMap hashMap = new HashMap();
        for (BatchFile batchFile : list) {
            if (batchFile != null) {
                if (!hashMap.containsKey(batchFile.batch)) {
                    hashMap.put(batchFile.batch, new ArrayList());
                }
                ((List) hashMap.get(batchFile.batch)).add(batchFile.file);
            }
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            KeyFileBatch keyFileBatch = (KeyFileBatch) entry.getKey();
            List list2 = (List) entry.getValue();
            if (keyFileBatch != null) {
                AutoValue_KeyFileBatch autoValue_KeyFileBatch = (AutoValue_KeyFileBatch) keyFileBatch;
                builder.add(new AutoValue_KeyFileBatch(autoValue_KeyFileBatch.region, autoValue_KeyFileBatch.batchNum, ImmutableList.copyOf((Collection) list2), autoValue_KeyFileBatch.uris));
            } else {
                throw null;
            }
        }
        return builder.build();
    }

    /* renamed from: initiateDownloads */
    public final ListenableFuture<List<BatchFile>> lambda$download$0$DiagnosisKeyDownloader(List<KeyFileBatch> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (KeyFileBatch keyFileBatch : list) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Start ");
            AutoValue_KeyFileBatch autoValue_KeyFileBatch = (AutoValue_KeyFileBatch) keyFileBatch;
            outline15.append(autoValue_KeyFileBatch.uris.size());
            outline15.append(" key file downloads.");
            Log.i("KeyDownloader", outline15.toString());
            ArrayList arrayList2 = new ArrayList();
            UnmodifiableListIterator<Uri> listIterator = autoValue_KeyFileBatch.uris.listIterator();
            while (listIterator.hasNext()) {
                long enqueue = this.downloadManager.enqueue(new DownloadManager.Request((Uri) listIterator.next()).setNotificationVisibility(0).setMimeType("application/octet-stream").setTitle("Exposure Notifications Check").setDescription("Exposure Notifications Check"));
                Download download = new Download(keyFileBatch, enqueue, str, null);
                arrayList2.add(download.fileFuture);
                this.downloadMap.put(Long.valueOf(enqueue), download);
            }
            arrayList.addAll(arrayList2);
        }
        return new CollectionFuture.ListFuture(ImmutableList.copyOf((Iterable) arrayList), false);
    }

    public /* synthetic */ void lambda$download$1$DiagnosisKeyDownloader() {
        this.context.unregisterReceiver(this.downloadStatusReceiver);
    }
}
