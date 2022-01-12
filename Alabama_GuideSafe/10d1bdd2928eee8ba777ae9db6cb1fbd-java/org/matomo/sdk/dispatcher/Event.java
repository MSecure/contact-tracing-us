package org.matomo.sdk.dispatcher;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.net.URLEncoder;
import java.util.Map;
import org.matomo.sdk.Matomo;
import timber.log.Timber;

public class Event {
    public static final String TAG = Matomo.tag(Event.class);
    public final String mQuery;
    public final long mTimestamp;

    public Event(long j, String str) {
        this.mTimestamp = j;
        this.mQuery = str;
    }

    public static String urlEncodeUTF8(String str) {
        try {
            return URLEncoder.encode(str, RNCWebViewManager.HTML_ENCODING).replaceAll("\\+", "%20");
        } catch (Exception e) {
            Timber.tag(TAG).e(e, "Cannot encode %s", str);
            return "";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Event.class != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        return this.mTimestamp == event.mTimestamp && this.mQuery.equals(event.mQuery);
    }

    public int hashCode() {
        long j = this.mTimestamp;
        return this.mQuery.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    public String toString() {
        return this.mQuery;
    }

    public Event(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(100);
        sb.append('?');
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(urlEncodeUTF8(entry.getKey()));
            sb.append('=');
            sb.append(urlEncodeUTF8(entry.getValue()));
            sb.append('&');
        }
        String substring = sb.substring(0, sb.length() - 1);
        this.mTimestamp = System.currentTimeMillis();
        this.mQuery = substring;
    }
}
