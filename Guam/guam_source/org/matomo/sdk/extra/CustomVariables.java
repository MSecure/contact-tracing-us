package org.matomo.sdk.extra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.matomo.sdk.Matomo;

public class CustomVariables {
    public final Map<String, JSONArray> mVars = new ConcurrentHashMap();

    static {
        Matomo.tag(CustomVariables.class);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.mVars);
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }
}
