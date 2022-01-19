package org.matomo.sdk;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.horcrux.svg.PathParser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.internal.cache.DiskLruCache;
import org.matomo.sdk.dispatcher.DefaultDispatcher;
import org.matomo.sdk.dispatcher.DefaultPacketSender;
import org.matomo.sdk.dispatcher.DispatchMode;
import org.matomo.sdk.dispatcher.Dispatcher;
import org.matomo.sdk.dispatcher.EventCache;
import org.matomo.sdk.dispatcher.EventDiskCache;
import org.matomo.sdk.dispatcher.PacketFactory;
import org.matomo.sdk.tools.Connectivity;
import org.matomo.sdk.tools.DeviceHelper;
import timber.log.Timber;

public class Tracker {
    public static final String TAG = Matomo.tag(Tracker.class);
    public static final Pattern VALID_URLS = Pattern.compile("^(\\w+)(?:://)(.+?)$");
    public final String mApiUrl;
    public final String mDefaultApplicationBaseUrl;
    public final TrackMe mDefaultTrackMe = new TrackMe();
    public DispatchMode mDispatchMode;
    public final Dispatcher mDispatcher;
    public TrackMe mLastEvent;
    public final Matomo mMatomo;
    public final String mName;
    public boolean mOptOut;
    public SharedPreferences mPreferences;
    public final Random mRandomAntiCachingValue = new Random(new Date().getTime());
    public long mSessionStartTime = 0;
    public long mSessionTimeout = 1800000;
    public final int mSiteId;
    public final LinkedHashSet<Callback> mTrackingCallbacks = new LinkedHashSet<>();
    public final Object mTrackingLock = new Object();

    public interface Callback {
        TrackMe onTrack(TrackMe trackMe);
    }

    static {
        Pattern.compile("^[0-9a-f]{16}$");
    }

    public Tracker(Matomo matomo, TrackerBuilder trackerBuilder) {
        int[] iArr;
        DispatchMode dispatchMode;
        this.mMatomo = matomo;
        this.mApiUrl = trackerBuilder.mApiUrl;
        this.mSiteId = trackerBuilder.mSiteId;
        this.mName = trackerBuilder.mTrackerName;
        this.mDefaultApplicationBaseUrl = trackerBuilder.mApplicationBaseUrl;
        SharedPreferences sharedPreferences = matomo.mBasePreferences;
        SharedPreferences preferences = getPreferences();
        if (sharedPreferences.getBoolean("matomo.optout", false)) {
            preferences.edit().putBoolean("tracker.optout", true).apply();
            sharedPreferences.edit().remove("matomo.optout").apply();
        }
        if (sharedPreferences.contains("tracker.userid")) {
            preferences.edit().putString("tracker.userid", sharedPreferences.getString("tracker.userid", UUID.randomUUID().toString())).apply();
            sharedPreferences.edit().remove("tracker.userid").apply();
        }
        if (sharedPreferences.contains("tracker.firstvisit")) {
            preferences.edit().putLong("tracker.firstvisit", sharedPreferences.getLong("tracker.firstvisit", -1)).apply();
            sharedPreferences.edit().remove("tracker.firstvisit").apply();
        }
        if (sharedPreferences.contains("tracker.visitcount")) {
            preferences.edit().putLong("tracker.visitcount", (long) sharedPreferences.getInt("tracker.visitcount", 0)).apply();
            sharedPreferences.edit().remove("tracker.visitcount").apply();
        }
        if (sharedPreferences.contains("tracker.previousvisit")) {
            preferences.edit().putLong("tracker.previousvisit", sharedPreferences.getLong("tracker.previousvisit", -1)).apply();
            sharedPreferences.edit().remove("tracker.previousvisit").apply();
        }
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            if (entry.getKey().startsWith("downloaded:")) {
                preferences.edit().putBoolean(entry.getKey(), true).apply();
                sharedPreferences.edit().remove(entry.getKey()).apply();
            }
        }
        this.mOptOut = getPreferences().getBoolean("tracker.optout", false);
        if (this.mMatomo.mDispatcherFactory != null) {
            DefaultDispatcher defaultDispatcher = new DefaultDispatcher(new EventCache(new EventDiskCache(this)), new Connectivity(this.mMatomo.mContext), new PacketFactory(this.mApiUrl), new DefaultPacketSender());
            this.mDispatcher = defaultDispatcher;
            if (this.mDispatchMode == null) {
                String string = getPreferences().getString("tracker.dispatcher.mode", null);
                DispatchMode[] values = DispatchMode.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        dispatchMode = null;
                        break;
                    }
                    dispatchMode = values[i];
                    if (dispatchMode.key.equals(string)) {
                        break;
                    }
                    i++;
                }
                this.mDispatchMode = dispatchMode;
                if (dispatchMode == null) {
                    this.mDispatchMode = DispatchMode.ALWAYS;
                }
            }
            defaultDispatcher.mDispatchMode = this.mDispatchMode;
            this.mDefaultTrackMe.set(QueryParams.USER_ID, getPreferences().getString("tracker.userid", null));
            String string2 = getPreferences().getString("tracker.visitorid", null);
            if (string2 == null) {
                string2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
                getPreferences().edit().putString("tracker.visitorid", string2).apply();
            }
            this.mDefaultTrackMe.set(QueryParams.VISITOR_ID, string2);
            this.mDefaultTrackMe.set(QueryParams.SESSION_START, DiskLruCache.VERSION_1);
            try {
                Display defaultDisplay = ((WindowManager) this.mMatomo.getDeviceHelper().mContext.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                if (i2 == -1 || i3 == -1) {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    i3 = displayMetrics2.heightPixels;
                }
                iArr = new int[]{i2, i3};
            } catch (NullPointerException e) {
                Timber.tag(DeviceHelper.TAG).e(e, "Window service was not available from this context", new Object[0]);
                iArr = null;
            }
            this.mDefaultTrackMe.set(QueryParams.SCREEN_RESOLUTION, iArr != null ? String.format("%sx%s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])) : "unknown");
            TrackMe trackMe = this.mDefaultTrackMe;
            QueryParams queryParams = QueryParams.USER_AGENT;
            DeviceHelper deviceHelper = this.mMatomo.getDeviceHelper();
            if (deviceHelper.mPropertySource != null) {
                String property = System.getProperty("http.agent");
                if (property == null || property.startsWith("Apache-HttpClient/UNAVAILABLE (java")) {
                    if (deviceHelper.mPropertySource != null) {
                        String property2 = System.getProperty("java.vm.version");
                        property2 = property2 == null ? "0.0.0" : property2;
                        if (deviceHelper.mBuildInfo != null) {
                            property = String.format(Locale.US, "Dalvik/%s (Linux; U; Android %s; %s Build/%s)", property2, Build.VERSION.RELEASE, Build.MODEL, Build.ID);
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
                trackMe.set(queryParams, property);
                TrackMe trackMe2 = this.mDefaultTrackMe;
                QueryParams queryParams2 = QueryParams.LANGUAGE;
                this.mMatomo.getDeviceHelper();
                trackMe2.set(queryParams2, Locale.getDefault().getLanguage());
                this.mDefaultTrackMe.set(QueryParams.URL_PATH, trackerBuilder.mApplicationBaseUrl);
                return;
            }
            throw null;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracker.class != obj.getClass()) {
            return false;
        }
        Tracker tracker = (Tracker) obj;
        if (this.mSiteId == tracker.mSiteId && this.mApiUrl.equals(tracker.mApiUrl)) {
            return this.mName.equals(tracker.mName);
        }
        return false;
    }

    public SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences;
        String str;
        if (this.mPreferences == null) {
            Matomo matomo = this.mMatomo;
            synchronized (matomo.mPreferenceMap) {
                sharedPreferences = matomo.mPreferenceMap.get(this);
                if (sharedPreferences == null) {
                    try {
                        str = "org.matomo.sdk_" + PathParser.getMD5Checksum(this.mName);
                    } catch (Exception e) {
                        Timber.tag(Matomo.TAG).e(e);
                        str = "org.matomo.sdk_" + this.mName;
                    }
                    sharedPreferences = matomo.mContext.getSharedPreferences(str, 0);
                    matomo.mPreferenceMap.put(this, sharedPreferences);
                }
            }
            this.mPreferences = sharedPreferences;
        }
        return this.mPreferences;
    }

    public int hashCode() {
        return this.mName.hashCode() + (((this.mApiUrl.hashCode() * 31) + this.mSiteId) * 31);
    }

    public final void injectBaseParams(TrackMe trackMe) {
        QueryParams queryParams = QueryParams.USER_ID;
        QueryParams queryParams2 = QueryParams.URL_PATH;
        QueryParams queryParams3 = QueryParams.SITE_ID;
        int i = this.mSiteId;
        synchronized (trackMe) {
            trackMe.trySet(queryParams3, String.valueOf(i));
        }
        trackMe.trySet(QueryParams.RECORD, DiskLruCache.VERSION_1);
        trackMe.trySet(QueryParams.API_VERSION, DiskLruCache.VERSION_1);
        QueryParams queryParams4 = QueryParams.RANDOM_NUMBER;
        int nextInt = this.mRandomAntiCachingValue.nextInt(100000);
        synchronized (trackMe) {
            trackMe.trySet(queryParams4, String.valueOf(nextInt));
        }
        trackMe.trySet(QueryParams.DATETIME_OF_REQUEST, new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.US).format(new Date()));
        trackMe.trySet(QueryParams.SEND_IMAGE, "0");
        QueryParams queryParams5 = QueryParams.VISITOR_ID;
        trackMe.trySet(queryParams5, this.mDefaultTrackMe.get(queryParams5));
        trackMe.trySet(queryParams, this.mDefaultTrackMe.get(queryParams));
        String str = trackMe.get(queryParams2);
        boolean z = true;
        if (str == null) {
            str = this.mDefaultTrackMe.get(queryParams2);
        } else if (!VALID_URLS.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(this.mDefaultApplicationBaseUrl);
            if (!this.mDefaultApplicationBaseUrl.endsWith(ColorPropConverter.PATH_DELIMITER) && !str.startsWith(ColorPropConverter.PATH_DELIMITER)) {
                sb.append(ColorPropConverter.PATH_DELIMITER);
            } else if (this.mDefaultApplicationBaseUrl.endsWith(ColorPropConverter.PATH_DELIMITER) && str.startsWith(ColorPropConverter.PATH_DELIMITER)) {
                str = str.substring(1);
            }
            sb.append(str);
            str = sb.toString();
        }
        this.mDefaultTrackMe.set(queryParams2, str);
        trackMe.set(queryParams2, str);
        if (this.mLastEvent != null) {
            String str2 = trackMe.get(queryParams);
            String str3 = this.mLastEvent.get(queryParams);
            if (str2 != str3 && (str2 == null || !str2.equals(str3))) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        QueryParams queryParams6 = QueryParams.SCREEN_RESOLUTION;
        trackMe.trySet(queryParams6, this.mDefaultTrackMe.get(queryParams6));
        QueryParams queryParams7 = QueryParams.USER_AGENT;
        trackMe.trySet(queryParams7, this.mDefaultTrackMe.get(queryParams7));
        QueryParams queryParams8 = QueryParams.LANGUAGE;
        trackMe.trySet(queryParams8, this.mDefaultTrackMe.get(queryParams8));
    }

    public final void injectInitialParams(TrackMe trackMe) {
        long j;
        long j2;
        long j3;
        QueryParams queryParams = QueryParams.PREVIOUS_VISIT_TIMESTAMP;
        QueryParams queryParams2 = QueryParams.TOTAL_NUMBER_OF_VISITS;
        QueryParams queryParams3 = QueryParams.FIRST_VISIT_TIMESTAMP;
        synchronized (getPreferences()) {
            j = getPreferences().getLong("tracker.visitcount", 0) + 1;
            getPreferences().edit().putLong("tracker.visitcount", j).apply();
        }
        synchronized (getPreferences()) {
            j2 = getPreferences().getLong("tracker.firstvisit", -1);
            if (j2 == -1) {
                j2 = System.currentTimeMillis() / 1000;
                getPreferences().edit().putLong("tracker.firstvisit", j2).apply();
            }
        }
        synchronized (getPreferences()) {
            j3 = getPreferences().getLong("tracker.previousvisit", -1);
            getPreferences().edit().putLong("tracker.previousvisit", System.currentTimeMillis() / 1000).apply();
        }
        this.mDefaultTrackMe.trySet(queryParams3, j2);
        this.mDefaultTrackMe.trySet(queryParams2, j);
        if (j3 != -1) {
            this.mDefaultTrackMe.trySet(queryParams, j3);
        }
        QueryParams queryParams4 = QueryParams.SESSION_START;
        trackMe.trySet(queryParams4, this.mDefaultTrackMe.get(queryParams4));
        trackMe.trySet(queryParams3, this.mDefaultTrackMe.get(queryParams3));
        trackMe.trySet(queryParams2, this.mDefaultTrackMe.get(queryParams2));
        trackMe.trySet(queryParams, this.mDefaultTrackMe.get(queryParams));
    }
}
