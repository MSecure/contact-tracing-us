package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import b.b.k.i;
import c.a.a.a.a;
import c.a.b.v;
import c.b.a.a.c.n.c;
import c.b.b.a.b;
import c.b.b.a.d;
import c.b.b.a.f;
import c.b.b.a.k;
import c.b.b.a.m;
import c.b.b.a.n;
import c.b.b.b.c;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import d.a.a.a.g.w;
import d.a.a.a.g.x;
import d.a.a.a.g.y;
import d.a.a.a.g.z;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class Uris {
    public static final Pattern BATCH_NUM_PATTERN = Pattern.compile("v1/([0-9]+)-([0-9]+)-[0-9]+.zip");
    public static final Pattern DEFAULT_URI_PATTERN = Pattern.compile(".*example\\.com.*");
    public static final String INDEX_FILE_FORMAT = "v1/index.txt";
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
                URL url = new URL(string + "/base-url");
                URL url2 = new URL(string + "/index-file");
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
            } catch (Exception e2) {
                sb2.append(".");
                e2.printStackTrace();
            }
            sb.append("\n");
            sb.append((CharSequence) sb2);
            sb.toString();
            sb.append("\n");
            sb.append((CharSequence) sb2);
            return sb.toString();
        }
    }

    static {
        d a2 = k.a("\\s+");
        Matcher matcher = ((f) a2).f3320b.matcher("");
        if (matcher != null) {
            c.q(!matcher.matches(), "The pattern may not match the empty string: %s", a2);
            m mVar = new m(a2);
            b.c cVar = b.c.f3317b;
            b.d dVar = b.d.f3319c;
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
        this.uploadUri = Uri.parse(context2.getString(R.string.key_server_upload_uri) + "/v1/publish");
    }

    public static /* synthetic */ c.b.b.b.c a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        return c.b.b.b.c.s(arrayList);
    }

    public static /* synthetic */ void c(b.f.a.b bVar, v vVar) {
        StringBuilder g = a.g("Error getting keyfile index.");
        g.append(vVar.getMessage());
        CustomUtility.customLogger(g.toString());
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
        return i.j.b0(new w(this));
    }

    private u<c.b.b.b.c<KeyFileBatch>> regionBatches(String str) {
        return l.s(index(str)).t(new x(this, str), AppExecutors.getBackgroundExecutor());
    }

    public /* synthetic */ Object b(b.f.a.b bVar) {
        bVar.getClass();
        z zVar = new z(bVar);
        d.a.a.a.g.v vVar = new d.a.a.a.g.v(bVar);
        Uri build = this.baseDownloadUri.buildUpon().appendEncodedPath(this.appendedUris[1]).build();
        CustomUtility.customLogger("Getting index file from " + build);
        String str = "Getting index file from " + build;
        c.a.b.x.k kVar = new c.a.b.x.k(build.toString(), zVar, vVar);
        kVar.setShouldCache(false);
        RequestQueueSingleton.get(this.context).a(kVar);
        return kVar;
    }

    public c.b.b.b.c d(String str, String str2) {
        n nVar = WHITESPACE_SPLITTER;
        if (str2 != null) {
            m mVar = (m) nVar.f3334c;
            c.b.b.a.l lVar = new c.b.b.a.l(mVar, nVar, str2, new f.a(((f) mVar.f3331a).f3320b.matcher(str2)));
            ArrayList arrayList = new ArrayList();
            while (lVar.hasNext()) {
                arrayList.add(lVar.next());
            }
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            StringBuilder g = a.g("Index file has ");
            g.append(unmodifiableList.size());
            g.append(" lines.");
            g.append(unmodifiableList);
            g.toString();
            HashMap hashMap = new HashMap();
            long j = 9999;
            for (String str3 : unmodifiableList) {
                Matcher matcher = BATCH_NUM_PATTERN.matcher(str3);
                j = (!matcher.matches() || matcher.group(1) == null) ? j + 10 : Long.parseLong(matcher.group(1));
                String.format("Batch number %s from indexEntry %s", Long.valueOf(j), str3);
                if (!hashMap.containsKey(Long.valueOf(j))) {
                    hashMap.put(Long.valueOf(j), new ArrayList());
                }
                ((List) hashMap.get(Long.valueOf(j))).add(this.baseDownloadUri.buildUpon().appendEncodedPath(str3).build());
            }
            c.a p = c.b.b.b.c.p();
            for (Map.Entry entry : hashMap.entrySet()) {
                p.a(KeyFileBatch.ofUris(str, ((Long) entry.getKey()).longValue(), (Collection) entry.getValue()));
            }
            StringBuilder g2 = a.g("Current batch size is : ");
            g2.append(p.b().size());
            CustomUtility.customLogger(g2.toString());
            p.b().size();
            return p.b();
        }
        throw null;
    }

    public u<c.b.b.b.c<KeyFileBatch>> getDownloadFileUris(List<String> list) {
        if (hasDefaultUris()) {
            return c.b.a.a.c.n.c.k1(c.b.b.b.c.w());
        }
        StringBuilder g = a.g("Getting download URIs for ");
        g.append(list.size());
        g.append(" regions");
        CustomUtility.customLogger(g.toString());
        list.size();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(regionBatches(str));
        }
        return l.s(c.b.a.a.c.n.c.k(arrayList)).t(y.f4705a, AppExecutors.getLightweightExecutor());
    }

    public String getLastIndexFromSharedPrefernce() {
        return this.context.getSharedPreferences("com.springml.pref.LAST_INDEX", 0).getString("PREVIOUS_LAST_INDEX", "NONE");
    }

    public u<c.b.b.b.c<Uri>> getUploadUris(List<String> list) {
        c.b.b.b.c cVar;
        if (hasDefaultUris()) {
            cVar = c.b.b.b.c.w();
        } else {
            StringBuilder g = a.g("Getting diagnosis key upload URIs for ");
            g.append(list.size());
            g.append(" regions/countries.");
            CustomUtility.customLogger(g.toString());
            list.size();
            cVar = c.b.b.b.c.x(this.uploadUri);
        }
        return c.b.a.a.c.n.c.k1(cVar);
    }

    public boolean hasDefaultUris() {
        return DEFAULT_URI_PATTERN.matcher(this.baseDownloadUri.toString()).matches() || DEFAULT_URI_PATTERN.matcher(this.uploadUri.toString()).matches();
    }

    public void saveLastIndexToSharedPrefernce(String str) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences("com.springml.pref.LAST_INDEX", 0).edit();
        edit.putString("PREVIOUS_LAST_INDEX", str);
        edit.commit();
    }
}
