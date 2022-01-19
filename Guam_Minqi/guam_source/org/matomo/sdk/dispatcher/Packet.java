package org.matomo.sdk.dispatcher;

import org.json.JSONObject;

public class Packet {
    public final int mEventCount;
    public final JSONObject mPostData;
    public final String mTargetURL;

    public Packet(String str) {
        this.mTargetURL = str;
        this.mPostData = null;
        this.mEventCount = 1;
        System.currentTimeMillis();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Packet(");
        if (this.mPostData != null) {
            sb.append("type=POST, data=");
            sb.append(this.mPostData);
        } else {
            sb.append("type=GET, data=");
            sb.append(this.mTargetURL);
        }
        sb.append(")");
        return sb.toString();
    }

    public Packet(String str, JSONObject jSONObject, int i) {
        this.mTargetURL = str;
        this.mPostData = jSONObject;
        this.mEventCount = i;
        System.currentTimeMillis();
    }
}
