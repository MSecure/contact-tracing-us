package f.b.a.a.a.r;

import android.util.Log;
import f.b.a.a.a.r.a0;
import f.b.a.a.a.r.q;
import f.b.b.a.g;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class b implements g {
    public final /* synthetic */ x a;

    public /* synthetic */ b(x xVar) {
        this.a = xVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(this.a);
        if (jSONObject == null) {
            Log.e("PrioRemoteConfig", "Invalid jsonObj, using default remote configs");
        } else {
            a0.a h2 = a0.h();
            try {
                if (jSONObject.has("enpa_enabled")) {
                    ((q.b) h2).a = Boolean.valueOf(jSONObject.getBoolean("enpa_enabled"));
                }
                if (jSONObject.has("enpa_collection_frequency")) {
                    ((q.b) h2).b = Long.valueOf(jSONObject.getLong("enpa_collection_frequency"));
                }
                if (jSONObject.has("device_attestation_required")) {
                    ((q.b) h2).c = Boolean.valueOf(jSONObject.getBoolean("device_attestation_required"));
                }
                if (jSONObject.has("enpa_metric_notification_count_v1_sampling_prob")) {
                    ((q.b) h2).f2220g = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_notification_count_v1_prio_epsilon")) {
                    ((q.b) h2).f2219f = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_sampling_prob")) {
                    ((q.b) h2).f2218e = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_prio_epsilon")) {
                    ((q.b) h2).f2217d = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v1_sampling_prob")) {
                    ((q.b) h2).f2222i = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v1_prio_epsilon")) {
                    ((q.b) h2).f2221h = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v1_prio_epsilon"));
                }
                if (jSONObject.has("certificate_pha")) {
                    String string = jSONObject.getString("certificate_pha");
                    Objects.requireNonNull(string, "Null phaCertificate");
                    ((q.b) h2).f2223j = string;
                }
                if (jSONObject.has("certificate_facilitator")) {
                    String string2 = jSONObject.getString("certificate_facilitator");
                    Objects.requireNonNull(string2, "Null facilitatorCertificate");
                    ((q.b) h2).f2224k = string2;
                }
                if (jSONObject.has("encryption_key_id_pha")) {
                    String string3 = jSONObject.getString("encryption_key_id_pha");
                    Objects.requireNonNull(string3, "Null phaEncryptionKeyId");
                    ((q.b) h2).f2225l = string3;
                }
                if (jSONObject.has("encryption_key_id_facilitator")) {
                    String string4 = jSONObject.getString("encryption_key_id_facilitator");
                    Objects.requireNonNull(string4, "Null facilitatorEncryptionKeyId");
                    ((q.b) h2).m = string4;
                }
                return h2.a();
            } catch (JSONException e2) {
                Log.e("PrioRemoteConfig", "Failed to parse remote config json, using defaults", e2);
            }
        }
        return x.f2233g;
    }
}
