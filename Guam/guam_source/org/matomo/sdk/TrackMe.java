package org.matomo.sdk;

import java.util.HashMap;

public class TrackMe {
    public final HashMap<String, String> mQueryParams;

    public TrackMe() {
        this.mQueryParams = new HashMap<>(14);
    }

    public synchronized String get(QueryParams queryParams) {
        return this.mQueryParams.get(queryParams.value);
    }

    public synchronized TrackMe set(String str, String str2) {
        if (str2 == null) {
            this.mQueryParams.remove(str);
        } else if (str2.length() > 0) {
            this.mQueryParams.put(str, str2);
        }
        return this;
    }

    public synchronized TrackMe trySet(QueryParams queryParams, String str) {
        synchronized (this) {
        }
        return this;
        if (!this.mQueryParams.containsKey(queryParams.value)) {
            set(queryParams, str);
        }
        return this;
    }

    public TrackMe(TrackMe trackMe) {
        HashMap<String, String> hashMap = new HashMap<>(14);
        this.mQueryParams = hashMap;
        hashMap.putAll(trackMe.mQueryParams);
    }

    public synchronized TrackMe set(QueryParams queryParams, String str) {
        set(queryParams.value, str);
        return this;
    }

    public synchronized TrackMe trySet(QueryParams queryParams, long j) {
        trySet(queryParams, String.valueOf(j));
        return this;
    }
}
