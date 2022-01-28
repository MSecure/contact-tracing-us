package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.android.volley.Response;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExposureConfigurations.kt */
public final class ExposureConfigurations$refresh$1$responseListener$1<T> implements Response.Listener<JSONObject> {
    public final /* synthetic */ CallbackToFutureAdapter$Completer $completer;
    public final /* synthetic */ ExposureConfigurations$refresh$1 this$0;

    public ExposureConfigurations$refresh$1$responseListener$1(ExposureConfigurations$refresh$1 exposureConfigurations$refresh$1, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.this$0 = exposureConfigurations$refresh$1;
        this.$completer = callbackToFutureAdapter$Completer;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.android.volley.Response.Listener
    public void onResponse(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("DailySummariesConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("attenuationDurationThresholds");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
            }
            this.this$0.this$0.prefs.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.ATTENUATION_DURATION_THRESHOLDS", new Gson().toJson(arrayList)).commit();
            JSONArray jSONArray2 = jSONObject3.getJSONArray("attenuationBucketWeights");
            ArrayList arrayList2 = new ArrayList();
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.add(Double.valueOf(jSONArray2.getDouble(i2)));
            }
            this.this$0.this$0.prefs.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.ATTENUATION_BUCKET_WEIGHTS", new Gson().toJson(arrayList2)).commit();
            JSONArray jSONArray3 = jSONObject3.getJSONArray("reportTypeWeights");
            ArrayList arrayList3 = new ArrayList();
            int length3 = jSONArray3.length();
            for (int i3 = 0; i3 < length3; i3++) {
                arrayList3.add(Double.valueOf(jSONArray3.getDouble(i3)));
            }
            this.this$0.this$0.prefs.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.REPORT_TYPE_WEIGHTS", new Gson().toJson(arrayList3)).commit();
            JSONArray jSONArray4 = jSONObject3.getJSONArray("infectiousnessWeights");
            ArrayList arrayList4 = new ArrayList();
            int length4 = jSONArray4.length();
            for (int i4 = 0; i4 < length4; i4++) {
                arrayList4.add(Double.valueOf(jSONArray4.getDouble(i4)));
            }
            this.this$0.this$0.prefs.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.INFECTIOUSNESS_WEIGHTS", new Gson().toJson(arrayList4)).commit();
            JSONArray jSONArray5 = jSONObject3.getJSONArray("daysSinceOnsetToInfectiousness");
            HashMap hashMap = new HashMap();
            int length5 = jSONArray5.length();
            for (int i5 = 0; i5 < length5; i5++) {
                JSONArray jSONArray6 = jSONArray5.getJSONArray(i5);
                hashMap.put(Integer.valueOf(jSONArray6.getInt(0)), Integer.valueOf(jSONArray6.getInt(1)));
            }
            this.this$0.this$0.prefs.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.DAYS_SINCE_ONSET_TO_INFECTIOUSNESS", new Gson().toJson(hashMap)).commit();
            this.this$0.this$0.prefs.sharedPreferences.edit().putInt("ExposureNotificationSharedPreferences.INFECTIOUSNESS_WHEN_DAY_SINCE_ONSET_MISSING", Integer.valueOf(jSONObject3.getInt("infectiousnessWhenDaysSinceOnsetMissing")).intValue()).commit();
            this.this$0.this$0.prefs.sharedPreferences.edit().putInt("ExposureNotificationSharedPreferences.REPORT_TYPE_WHEN_MISSING", Integer.valueOf(jSONObject3.getInt("reportTypeWhenMissing")).intValue()).commit();
            this.this$0.this$0.prefs.sharedPreferences.edit().putInt("ExposureNotificationSharedPreferences.TRIGGER_THRESHOLD_WEIGHTED_DURATION", Integer.valueOf(jSONObject2.getInt("triggerThresholdWeightedDuration")).intValue()).commit();
            this.$completer.set(null);
        } catch (JSONException e) {
            Log.e("ExposureConfigurations", "Failed to parse configuration: " + e);
            this.$completer.setCancelled();
        }
    }
}
