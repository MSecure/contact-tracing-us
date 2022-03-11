package f.b.a.a.a.t;

import android.util.Log;
import f.b.a.a.a.t.b0;
import f.b.a.a.a.t.r;
import f.b.b.a.g;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class b implements g {
    public final /* synthetic */ y a;

    public /* synthetic */ b(y yVar) {
        this.a = yVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str;
        JSONException e2;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(this.a);
        if (jSONObject == null) {
            Log.e("PrioRemoteConfig", "Invalid jsonObj, using default remote configs");
        } else {
            b0.a l2 = b0.l();
            try {
                if (jSONObject.has("enpa_enabled")) {
                    str = "PrioRemoteConfig";
                    try {
                        ((r.b) l2).a = Boolean.valueOf(jSONObject.getBoolean("enpa_enabled"));
                    } catch (JSONException e3) {
                        e2 = e3;
                        Log.e(str, "Failed to parse remote config json, using defaults", e2);
                        return y.f2317g;
                    }
                }
                if (jSONObject.has("enpa_collection_frequency")) {
                    ((r.b) l2).b = Long.valueOf(jSONObject.getLong("enpa_collection_frequency"));
                }
                if (jSONObject.has("device_attestation_required")) {
                    ((r.b) l2).c = Boolean.valueOf(jSONObject.getBoolean("device_attestation_required"));
                }
                if (jSONObject.has("enpa_metric_notification_count_v1_sampling_prob")) {
                    ((r.b) l2).f2304g = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_notification_count_v1_prio_epsilon")) {
                    ((r.b) l2).f2303f = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_sampling_prob")) {
                    ((r.b) l2).f2302e = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_prio_epsilon")) {
                    ((r.b) l2).f2301d = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v2_sampling_prob")) {
                    ((r.b) l2).f2306i = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v2_prio_epsilon")) {
                    ((r.b) l2).f2305h = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v2_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_code_verified_v1_sampling_prob")) {
                    ((r.b) l2).f2308k = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_code_verified_v1_prio_epsilon")) {
                    ((r.b) l2).f2307j = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_v1_sampling_prob")) {
                    ((r.b) l2).m = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_v1_prio_epsilon")) {
                    ((r.b) l2).f2309l = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_v1_prio_epsilon"));
                }
                if (jSONObject.has("certificate_pha")) {
                    String string = jSONObject.getString("certificate_pha");
                    Objects.requireNonNull(string, "Null phaCertificate");
                    ((r.b) l2).n = string;
                }
                if (jSONObject.has("certificate_facilitator")) {
                    String string2 = jSONObject.getString("certificate_facilitator");
                    Objects.requireNonNull(string2, "Null facilitatorCertificate");
                    ((r.b) l2).o = string2;
                }
                if (jSONObject.has("encryption_key_id_pha")) {
                    String string3 = jSONObject.getString("encryption_key_id_pha");
                    Objects.requireNonNull(string3, "Null phaEncryptionKeyId");
                    ((r.b) l2).p = string3;
                }
                if (jSONObject.has("encryption_key_id_facilitator")) {
                    String string4 = jSONObject.getString("encryption_key_id_facilitator");
                    Objects.requireNonNull(string4, "Null facilitatorEncryptionKeyId");
                    ((r.b) l2).q = string4;
                }
                return l2.a();
            } catch (JSONException e4) {
                e2 = e4;
                str = "PrioRemoteConfig";
                Log.e(str, "Failed to parse remote config json, using defaults", e2);
                return y.f2317g;
            }
        }
        return y.f2317g;
    }
}
