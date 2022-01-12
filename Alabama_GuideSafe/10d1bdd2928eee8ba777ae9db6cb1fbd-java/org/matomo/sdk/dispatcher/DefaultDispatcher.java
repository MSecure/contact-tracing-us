package org.matomo.sdk.dispatcher;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.facebook.react.devsupport.DevServerHelper;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.matomo.sdk.Matomo;
import org.matomo.sdk.TrackMe;
import org.matomo.sdk.tools.Connectivity;
import timber.log.Timber;

public class DefaultDispatcher implements Dispatcher {
    public static final String TAG = Matomo.tag(DefaultDispatcher.class);
    public final Connectivity mConnectivity;
    public boolean mDispatchGzipped = false;
    public volatile long mDispatchInterval = 120000;
    public volatile DispatchMode mDispatchMode = DispatchMode.ALWAYS;
    public List<Packet> mDryRunTarget = null;
    public final EventCache mEventCache;
    public volatile boolean mForcedBlocking = false;
    public final Runnable mLoop = new Runnable() {
        /* class org.matomo.sdk.dispatcher.DefaultDispatcher.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0400, code lost:
            if (r4 != false) goto L_0x0407;
         */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0265 A[SYNTHETIC, Splitter:B:104:0x0265] */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0309 A[SYNTHETIC, Splitter:B:141:0x0309] */
        /* JADX WARNING: Removed duplicated region for block: B:154:0x0331  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x0337  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x036e  */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x038c  */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x03db A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x0354 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x021f A[SYNTHETIC, Splitter:B:81:0x021f] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0236  */
        public void run() {
            List list;
            boolean z;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Exception e;
            BufferedReader bufferedReader;
            Throwable th2;
            Throwable th3;
            BufferedWriter bufferedWriter;
            GZIPOutputStream gZIPOutputStream;
            Throwable th4;
            OutputStream outputStream;
            Throwable th5;
            Packet packet;
            DefaultDispatcher.this.mRetryCounter = 0;
            while (DefaultDispatcher.this.mRunning) {
                boolean z2 = true;
                try {
                    long j = DefaultDispatcher.this.mDispatchInterval;
                    if (DefaultDispatcher.this.mRetryCounter > 1) {
                        j += Math.min(((long) DefaultDispatcher.this.mRetryCounter) * DefaultDispatcher.this.mDispatchInterval, DefaultDispatcher.this.mDispatchInterval * 5);
                    }
                    DefaultDispatcher.this.mSleepToken.tryAcquire(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    Timber.tag(DefaultDispatcher.TAG).e(e2);
                }
                DefaultDispatcher defaultDispatcher = DefaultDispatcher.this;
                if (defaultDispatcher.mEventCache.updateState(DefaultDispatcher.access$500(defaultDispatcher))) {
                    ArrayList arrayList = new ArrayList();
                    DefaultDispatcher.this.mEventCache.mQueue.drainTo(arrayList);
                    Timber.tag(DefaultDispatcher.TAG).d("Drained %s events.", Integer.valueOf(arrayList.size()));
                    PacketFactory packetFactory = DefaultDispatcher.this.mPacketFactory;
                    HttpURLConnection httpURLConnection2 = null;
                    if (packetFactory != null) {
                        if (arrayList.isEmpty()) {
                            list = Collections.emptyList();
                        } else if (arrayList.size() == 1) {
                            Packet buildPacketForGet = packetFactory.buildPacketForGet((Event) arrayList.get(0));
                            if (buildPacketForGet == null) {
                                list = Collections.emptyList();
                            } else {
                                list = Collections.singletonList(buildPacketForGet);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList((int) Math.ceil((((double) arrayList.size()) * 1.0d) / 20.0d));
                            int i = 0;
                            while (i < arrayList.size()) {
                                int i2 = i + 20;
                                List<Event> subList = arrayList.subList(i, Math.min(i2, arrayList.size()));
                                if (subList.size() == 1) {
                                    packet = packetFactory.buildPacketForGet((Event) subList.get(0));
                                } else {
                                    if (!subList.isEmpty()) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            JSONArray jSONArray = new JSONArray();
                                            for (Event event : subList) {
                                                jSONArray.put(event.mQuery);
                                            }
                                            jSONObject.put("requests", jSONArray);
                                            packet = new Packet(packetFactory.mApiUrl, jSONObject, subList.size());
                                        } catch (JSONException e3) {
                                            Timber.tag(PacketFactory.TAG).w(e3, "Cannot create json object:\n%s", TextUtils.join(", ", subList));
                                        }
                                    }
                                    packet = null;
                                }
                                if (packet != null) {
                                    arrayList2.add(packet);
                                }
                                i = i2;
                            }
                            list = arrayList2;
                        }
                        Iterator it = list.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Packet packet2 = (Packet) it.next();
                            DefaultDispatcher defaultDispatcher2 = DefaultDispatcher.this;
                            if (defaultDispatcher2.mDryRunTarget != null) {
                                Timber.tag(DefaultDispatcher.TAG).d("DryRun, stored HttpRequest, now %d.", Integer.valueOf(DefaultDispatcher.this.mDryRunTarget.size()));
                                z = DefaultDispatcher.this.mDryRunTarget.add(packet2);
                            } else {
                                DefaultPacketSender defaultPacketSender = (DefaultPacketSender) defaultDispatcher2.mPacketSender;
                                if (defaultPacketSender != null) {
                                    try {
                                        httpURLConnection = (HttpURLConnection) new URL(packet2.mTargetURL).openConnection();
                                        try {
                                            Timber.tag(DefaultPacketSender.TAG).v("Connection is open to %s", httpURLConnection.getURL().toExternalForm());
                                            Timber.tag(DefaultPacketSender.TAG).v("Sending: %s", packet2);
                                            httpURLConnection.setConnectTimeout((int) defaultPacketSender.mTimeout);
                                            httpURLConnection.setReadTimeout((int) defaultPacketSender.mTimeout);
                                            if (packet2.mPostData != null) {
                                                httpURLConnection.setDoOutput(true);
                                                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                                                httpURLConnection.setRequestProperty("charset", "utf-8");
                                                String jSONObject2 = packet2.mPostData.toString();
                                                if (defaultPacketSender.mGzip) {
                                                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    try {
                                                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                                        try {
                                                            gZIPOutputStream.write(jSONObject2.getBytes(Charset.forName("UTF8")));
                                                            gZIPOutputStream.close();
                                                            try {
                                                                outputStream = httpURLConnection.getOutputStream();
                                                                try {
                                                                    outputStream.write(byteArrayOutputStream.toByteArray());
                                                                    try {
                                                                        outputStream.close();
                                                                    } catch (IOException e4) {
                                                                        Timber.tag(DefaultPacketSender.TAG).d(e4, "Failed to close output stream after writing gzipped POST data.", new Object[0]);
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th5 = th6;
                                                                    if (outputStream != null) {
                                                                        try {
                                                                            outputStream.close();
                                                                        } catch (IOException e5) {
                                                                            Timber.tag(DefaultPacketSender.TAG).d(e5, "Failed to close output stream after writing gzipped POST data.", new Object[0]);
                                                                        }
                                                                    }
                                                                    throw th5;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th5 = th7;
                                                                outputStream = null;
                                                                if (outputStream != null) {
                                                                }
                                                                throw th5;
                                                            }
                                                        } catch (Throwable th8) {
                                                            th4 = th8;
                                                            if (gZIPOutputStream != null) {
                                                                gZIPOutputStream.close();
                                                            }
                                                            throw th4;
                                                        }
                                                    } catch (Throwable th9) {
                                                        th4 = th9;
                                                        gZIPOutputStream = null;
                                                        if (gZIPOutputStream != null) {
                                                        }
                                                        throw th4;
                                                    }
                                                } else {
                                                    try {
                                                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), RNCWebViewManager.HTML_ENCODING));
                                                        try {
                                                            bufferedWriter.write(jSONObject2);
                                                            try {
                                                                bufferedWriter.close();
                                                            } catch (IOException e6) {
                                                                Timber.tag(DefaultPacketSender.TAG).d(e6, "Failed to close output stream after writing POST data.", new Object[0]);
                                                            }
                                                        } catch (Throwable th10) {
                                                            th3 = th10;
                                                            if (bufferedWriter != null) {
                                                            }
                                                            throw th3;
                                                        }
                                                    } catch (Throwable th11) {
                                                        th3 = th11;
                                                        bufferedWriter = null;
                                                        if (bufferedWriter != null) {
                                                            try {
                                                                bufferedWriter.close();
                                                            } catch (IOException e7) {
                                                                Timber.tag(DefaultPacketSender.TAG).d(e7, "Failed to close output stream after writing POST data.", new Object[0]);
                                                            }
                                                        }
                                                        throw th3;
                                                    }
                                                }
                                            } else {
                                                httpURLConnection.setDoOutput(false);
                                            }
                                            int responseCode = httpURLConnection.getResponseCode();
                                            Timber.tag(DefaultPacketSender.TAG).v("Transmission finished (code=%d).", Integer.valueOf(responseCode));
                                            boolean z3 = responseCode == 204 || responseCode == 200;
                                            if (z3) {
                                                InputStream inputStream = httpURLConnection.getInputStream();
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e8) {
                                                        Timber.tag(DefaultPacketSender.TAG).d(e8, "Failed to close the error stream.", new Object[0]);
                                                    }
                                                }
                                            } else {
                                                StringBuilder sb = new StringBuilder();
                                                try {
                                                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                                                    while (true) {
                                                        try {
                                                            String readLine = bufferedReader.readLine();
                                                            if (readLine != null) {
                                                                sb.append(readLine);
                                                            } else {
                                                                try {
                                                                    break;
                                                                } catch (IOException e9) {
                                                                    Timber.tag(DefaultPacketSender.TAG).d(e9, "Failed to close the error stream.", new Object[0]);
                                                                }
                                                            }
                                                        } catch (Throwable th12) {
                                                            th2 = th12;
                                                            if (bufferedReader != null) {
                                                                try {
                                                                    bufferedReader.close();
                                                                } catch (IOException e10) {
                                                                    Timber.tag(DefaultPacketSender.TAG).d(e10, "Failed to close the error stream.", new Object[0]);
                                                                }
                                                            }
                                                            throw th2;
                                                        }
                                                    }
                                                    bufferedReader.close();
                                                    Timber.tag(DefaultPacketSender.TAG).w("Transmission failed (code=%d, reason=%s)", Integer.valueOf(responseCode), sb.toString());
                                                } catch (Throwable th13) {
                                                    th2 = th13;
                                                    bufferedReader = null;
                                                    if (bufferedReader != null) {
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            httpURLConnection.disconnect();
                                            z = z3;
                                        } catch (Exception e11) {
                                            e = e11;
                                            try {
                                                Timber.tag(DefaultPacketSender.TAG).e(e, "Transmission failed unexpectedly.", new Object[0]);
                                                if (httpURLConnection != null) {
                                                }
                                                z = false;
                                                if (!z) {
                                                }
                                                Timber.tag(DefaultDispatcher.TAG).d("Dispatched %d events.", Integer.valueOf(i3));
                                                if (i3 < arrayList.size()) {
                                                }
                                                synchronized (DefaultDispatcher.this.mThreadControl) {
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                httpURLConnection2 = httpURLConnection;
                                                httpURLConnection = httpURLConnection2;
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th15) {
                                            th = th15;
                                            if (httpURLConnection != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e12) {
                                        e = e12;
                                        httpURLConnection = null;
                                        Timber.tag(DefaultPacketSender.TAG).e(e, "Transmission failed unexpectedly.", new Object[0]);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        z = false;
                                        if (!z) {
                                        }
                                        Timber.tag(DefaultDispatcher.TAG).d("Dispatched %d events.", Integer.valueOf(i3));
                                        if (i3 < arrayList.size()) {
                                        }
                                        synchronized (DefaultDispatcher.this.mThreadControl) {
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        httpURLConnection = httpURLConnection2;
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    throw null;
                                }
                            }
                            if (!z) {
                                Timber.tag(DefaultDispatcher.TAG).d("Failure while trying to send packet", new Object[0]);
                                DefaultDispatcher.this.mRetryCounter++;
                                break;
                            }
                            i3 += packet2.mEventCount;
                            DefaultDispatcher.this.mRetryCounter = 0;
                            if (!DefaultDispatcher.access$500(DefaultDispatcher.this)) {
                                Timber.tag(DefaultDispatcher.TAG).d("Disconnected during dispatch loop", new Object[0]);
                                break;
                            }
                        }
                        Timber.tag(DefaultDispatcher.TAG).d("Dispatched %d events.", Integer.valueOf(i3));
                        if (i3 < arrayList.size()) {
                            Timber.tag(DefaultDispatcher.TAG).d("Unable to send all events, requeueing %d events", Integer.valueOf(arrayList.size() - i3));
                            EventCache eventCache = DefaultDispatcher.this.mEventCache;
                            List<Event> subList2 = arrayList.subList(i3, arrayList.size());
                            if (eventCache != null) {
                                for (Event event2 : subList2) {
                                    eventCache.mQueue.offerFirst(event2);
                                }
                                DefaultDispatcher defaultDispatcher3 = DefaultDispatcher.this;
                                defaultDispatcher3.mEventCache.updateState(DefaultDispatcher.access$500(defaultDispatcher3));
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        throw null;
                    }
                }
                synchronized (DefaultDispatcher.this.mThreadControl) {
                    if (!DefaultDispatcher.this.mForcedBlocking) {
                        EventCache eventCache2 = DefaultDispatcher.this.mEventCache;
                        if (eventCache2.mQueue.isEmpty()) {
                            EventDiskCache eventDiskCache = eventCache2.mDiskCache;
                            synchronized (eventDiskCache) {
                                if (!eventDiskCache.mDelayedClear) {
                                    eventDiskCache.checkCacheLimits();
                                    eventDiskCache.mDelayedClear = true;
                                }
                                boolean isEmpty = eventDiskCache.mEventContainer.isEmpty();
                            }
                        }
                        z2 = false;
                        if (!z2 && DefaultDispatcher.this.mDispatchInterval >= 0) {
                        }
                    }
                    DefaultDispatcher.this.mRunning = false;
                    return;
                }
            }
        }
    };
    public final PacketFactory mPacketFactory;
    public final PacketSender mPacketSender;
    public volatile int mRetryCounter = 0;
    public volatile boolean mRunning = false;
    public final Semaphore mSleepToken = new Semaphore(0);
    public final Object mThreadControl = new Object();
    public volatile int mTimeOut = DevServerHelper.HTTP_CONNECT_TIMEOUT_MS;

    public DefaultDispatcher(EventCache eventCache, Connectivity connectivity, PacketFactory packetFactory, PacketSender packetSender) {
        this.mConnectivity = connectivity;
        this.mEventCache = eventCache;
        this.mPacketFactory = packetFactory;
        this.mPacketSender = packetSender;
        DefaultPacketSender defaultPacketSender = (DefaultPacketSender) packetSender;
        defaultPacketSender.mGzip = this.mDispatchGzipped;
        defaultPacketSender.mTimeout = (long) this.mTimeOut;
    }

    public static boolean access$500(DefaultDispatcher defaultDispatcher) {
        Connectivity.Type type;
        Connectivity.Type type2 = Connectivity.Type.WIFI;
        NetworkInfo activeNetworkInfo = defaultDispatcher.mConnectivity.mConnectivityManager.getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
            return false;
        }
        int ordinal = defaultDispatcher.mDispatchMode.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                return false;
            }
            NetworkInfo activeNetworkInfo2 = defaultDispatcher.mConnectivity.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo2 == null) {
                type = Connectivity.Type.NONE;
            } else if (activeNetworkInfo2.getType() == 1) {
                type = type2;
            } else {
                type = Connectivity.Type.MOBILE;
            }
            if (type != type2) {
                return false;
            }
        }
        return true;
    }

    public void submit(TrackMe trackMe) {
        HashMap hashMap;
        EventCache eventCache = this.mEventCache;
        synchronized (trackMe) {
            hashMap = new HashMap(trackMe.mQueryParams);
        }
        eventCache.mQueue.add(new Event(hashMap));
        if (this.mDispatchInterval != -1) {
            synchronized (this.mThreadControl) {
                if (!this.mRunning) {
                    this.mRunning = true;
                    Thread thread = new Thread(this.mLoop);
                    thread.setPriority(1);
                    thread.setName("Matomo-default-dispatcher");
                    thread.start();
                }
            }
        }
    }
}
