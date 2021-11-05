package gov.michigan.MiCovidExposure.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import b.b.k.i;
import b.x.t;
import c.a.a.a.a;
import c.a.b.v;
import c.b.b.a.b;
import c.b.b.a.d;
import c.b.b.a.f;
import c.b.b.a.k;
import c.b.b.a.m;
import c.b.b.a.n;
import c.b.b.b.c;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import e.a.a.e.w;
import e.a.a.e.x;
import e.a.a.e.y;
import e.a.a.e.z;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class Uris {
    public static final Pattern BATCH_NUM_PATTERN = Pattern.compile("v1/([0-9]+)-([0-9]+)-[0-9]+.zip");
    public static final long DAYS_14_MILLIS = 1209600000;
    public static final Pattern DEFAULT_URI_PATTERN = Pattern.compile(".*example\\.com.*");
    public static final String FILE_NAME_SPLITTER = "@SpringML@";
    public static final String TAG = "Uris";
    public static final n WHITESPACE_SPLITTER;
    public String[] appendedUris;
    public final Uri baseDownloadUri;
    public final Context context;
    public final ExposureNotificationSharedPreferences prefs;
    public final Uri uploadUri;

    public final class DownloadUris extends AsyncTask<Void, Void, String> {
        public DownloadUris() {
        }

        public String doInBackground(Void... voidArr) {
            String string = Uris.this.context.getString(R.string.key_server_download_base_uri);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            try {
                URL url = new URL(string + "base-url");
                URL url2 = new URL(string + "index-file");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(httpsURLConnection.getInputStream())));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                httpsURLConnection.disconnect();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new DataInputStream(((HttpsURLConnection) url2.openConnection()).getInputStream())));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb2.append(readLine2);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            sb.append("\n");
            sb.append((CharSequence) sb2);
            return sb.toString();
        }
    }

    static {
        d a2 = k.a("\\s+");
        Matcher matcher = ((f) a2).f4657b.matcher("");
        if (matcher != null) {
            t.t(!matcher.matches(), "The pattern may not match the empty string: %s", a2);
            m mVar = new m(a2);
            b.c cVar = b.c.f4654b;
            b.d dVar = b.d.f4656c;
            if (dVar != null) {
                WHITESPACE_SPLITTER = new n(mVar, true, dVar, Integer.MAX_VALUE);
                return;
            }
            throw null;
        }
        throw null;
    }

    public Uris(Context context2) {
        this.context = context2;
        this.prefs = new ExposureNotificationSharedPreferences(context2);
        try {
            this.appendedUris = ((String) new DownloadUris().execute(new Void[0]).get()).split("\n");
        } catch (InterruptedException | ExecutionException e2) {
            e2.printStackTrace();
        }
        this.baseDownloadUri = Uri.parse(this.appendedUris[0]);
        this.uploadUri = Uri.parse(context2.getString(R.string.key_server_upload_uri));
    }

    public static /* synthetic */ c a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        return c.u(arrayList);
    }

    public static /* synthetic */ void c(b.f.a.b bVar, v vVar) {
        StringBuilder h = a.h("Error getting keyfile index.");
        h.append(vVar.getMessage());
        CustomUtility.customLogger(h.toString());
        vVar.getMessage();
        bVar.b();
    }

    private List<String> getDeltaListForDownload(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = list.indexOf(str);
        while (indexOf < list.size() - 1) {
            indexOf++;
            arrayList.add(list.get(indexOf));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    private u<String> index(String str) {
        return i.j.z(new x(this));
    }

    private u<c<KeyFileBatch>> regionBatches(String str) {
        return l.s(index(str)).t(new w(this, str), AppExecutors.getBackgroundExecutor());
    }

    public /* synthetic */ Object b(b.f.a.b bVar) {
        bVar.getClass();
        z zVar = new z(bVar);
        y yVar = new y(bVar);
        Uri build = this.baseDownloadUri.buildUpon().appendEncodedPath(this.appendedUris[1]).build();
        CustomUtility.customLogger("Getting index file from " + build);
        String str = "Getting index file from " + build;
        c.a.b.x.k kVar = new c.a.b.x.k(build.toString(), zVar, yVar);
        kVar.setShouldCache(false);
        RequestQueueSingleton.get(this.context).a(kVar);
        return kVar;
    }

    public c d(String str, String str2) {
        n nVar = WHITESPACE_SPLITTER;
        if (str2 != null) {
            m mVar = (m) nVar.f4671c;
            c.b.b.a.l lVar = new c.b.b.a.l(mVar, nVar, str2, new f.a(((f) mVar.f4668a).f4657b.matcher(str2)));
            ArrayList arrayList = new ArrayList();
            while (lVar.hasNext()) {
                arrayList.add(lVar.next());
            }
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            StringBuilder h = a.h("Index file has ");
            h.append(unmodifiableList.size());
            h.append(" lines.");
            h.append(unmodifiableList);
            h.toString();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            new ArrayList();
            ArrayList arrayList2 = new ArrayList(unmodifiableList);
            List<String> downLoadedFileList = getDownLoadedFileList();
            if (downLoadedFileList != null) {
                arrayList2.removeAll(downLoadedFileList);
                if (arrayList2.isEmpty()) {
                    arrayList2.add(unmodifiableList.get(unmodifiableList.size() - 1));
                }
            }
            long j = 9999;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                Matcher matcher = BATCH_NUM_PATTERN.matcher(str3);
                hashSet.add(str3 + FILE_NAME_SPLITTER + System.currentTimeMillis());
                j = (!matcher.matches() || matcher.group(1) == null) ? j + 10 : Long.parseLong(matcher.group(1));
                String.format("Batch number %s from indexEntry %s", Long.valueOf(j), str3);
                if (!hashMap.containsKey(Long.valueOf(j))) {
                    hashMap.put(Long.valueOf(j), new ArrayList());
                }
                ((List) hashMap.get(Long.valueOf(j))).add(this.baseDownloadUri.buildUpon().appendEncodedPath(str3).build());
            }
            setDownLoadedFileList(hashSet);
            c.a o = c.o();
            for (Map.Entry entry : hashMap.entrySet()) {
                o.a(KeyFileBatch.ofUris(str, ((Long) entry.getKey()).longValue(), (Collection) entry.getValue()));
            }
            StringBuilder h2 = a.h("Current batch size is : ");
            h2.append(o.b().size());
            CustomUtility.customLogger(h2.toString());
            o.b().size();
            return o.b();
        }
        throw null;
    }

    public List<String> getDownLoadedFileList() {
        ArrayList arrayList = new ArrayList();
        Set<String> downloadedFiles = new ExposureNotificationSharedPreferences(this.context).getDownloadedFiles(null);
        if (downloadedFiles == null) {
            return null;
        }
        for (String str : downloadedFiles) {
            if (str != null) {
                String[] split = str.split(FILE_NAME_SPLITTER);
                if (System.currentTimeMillis() - Long.parseLong(split[1]) > DAYS_14_MILLIS) {
                    String str2 = split[0];
                    downloadedFiles.remove(str);
                } else {
                    arrayList.add(split[0]);
                }
            }
        }
        new ExposureNotificationSharedPreferences(this.context).setDownloadedFiles(downloadedFiles);
        return arrayList;
    }

    public u<c<KeyFileBatch>> getDownloadFileUris(List<String> list) {
        if (hasDefaultUris()) {
            return t.N1(c.z());
        }
        StringBuilder h = a.h("Getting download URIs for ");
        h.append(list.size());
        h.append(" regions");
        CustomUtility.customLogger(h.toString());
        list.size();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(regionBatches(str));
        }
        return l.s(t.k(arrayList)).t(e.a.a.e.v.f6313a, AppExecutors.getLightweightExecutor());
    }

    public String getLastIndexFromSharedPrefernce() {
        return this.context.getSharedPreferences("com.springml.pref.LAST_INDEX", 0).getString("PREVIOUS_LAST_INDEX", "NONE");
    }

    public u<c<Uri>> getUploadUris(List<String> list) {
        c cVar;
        if (hasDefaultUris()) {
            cVar = c.z();
        } else {
            StringBuilder h = a.h("Getting diagnosis key upload URIs for ");
            h.append(list.size());
            h.append(" regions/countries.");
            CustomUtility.customLogger(h.toString());
            list.size();
            cVar = c.C(this.uploadUri);
        }
        return t.N1(cVar);
    }

    public boolean hasDefaultUris() {
        return DEFAULT_URI_PATTERN.matcher(this.baseDownloadUri.toString()).matches() || DEFAULT_URI_PATTERN.matcher(this.uploadUri.toString()).matches();
    }

    public void saveLastIndexToSharedPrefernce(String str) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences("com.springml.pref.LAST_INDEX", 0).edit();
        edit.putString("PREVIOUS_LAST_INDEX", str);
        edit.commit();
    }

    public void setDownLoadedFileList(Set<String> set) {
        Set<String> downloadedFiles = new ExposureNotificationSharedPreferences(this.context).getDownloadedFiles(null);
        if (downloadedFiles != null) {
            downloadedFiles.addAll(set);
            String str = "adding to download files list" + set;
            new ExposureNotificationSharedPreferences(this.context).setDownloadedFiles(downloadedFiles);
            return;
        }
        new ExposureNotificationSharedPreferences(this.context).setDownloadedFiles(set);
    }
}
