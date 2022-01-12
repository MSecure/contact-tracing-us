package org.matomo.sdk;

import java.net.MalformedURLException;
import java.net.URL;

public class TrackerBuilder {
    public String mApiUrl;
    public String mApplicationBaseUrl;
    public int mSiteId;
    public String mTrackerName;

    public TrackerBuilder(String str, int i, String str2) {
        try {
            new URL(str);
            this.mApiUrl = str;
            this.mSiteId = i;
            this.mTrackerName = str2;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackerBuilder.class != obj.getClass()) {
            return false;
        }
        TrackerBuilder trackerBuilder = (TrackerBuilder) obj;
        return this.mSiteId == trackerBuilder.mSiteId && this.mApiUrl.equals(trackerBuilder.mApiUrl) && this.mTrackerName.equals(trackerBuilder.mTrackerName);
    }

    public int hashCode() {
        return this.mTrackerName.hashCode() + (((this.mApiUrl.hashCode() * 31) + this.mSiteId) * 31);
    }
}
