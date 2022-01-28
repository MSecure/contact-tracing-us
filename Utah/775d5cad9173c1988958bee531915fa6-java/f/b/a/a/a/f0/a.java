package f.b.a.a.a.f0;

import f.b.a.a.a.f0.k;
import f.b.a.a.a.f0.l;
import f.b.b.a.g;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class a implements g {
    public final /* synthetic */ n a;

    public /* synthetic */ a(n nVar) {
        this.a = nVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(this.a);
        if (jSONObject == null) {
            n.f2219e.c("Invalid jsonObj, using default remote configs");
        } else {
            l.a q = l.q();
            try {
                if (jSONObject.has("enpa_metric_notification_count_v1_sampling_prob")) {
                    str = "enpa_metric_date_exposure_v1_sampling_prob";
                    ((k.b) q).f2210d = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_sampling_prob"));
                } else {
                    str = "enpa_metric_date_exposure_v1_sampling_prob";
                }
                if (jSONObject.has("enpa_metric_notification_count_v1_prio_epsilon")) {
                    ((k.b) q).c = Double.valueOf(jSONObject.getDouble("enpa_metric_notification_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_sampling_prob")) {
                    ((k.b) q).b = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_interaction_count_v1_prio_epsilon")) {
                    ((k.b) q).a = Double.valueOf(jSONObject.getDouble("enpa_metric_interaction_count_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v2_sampling_prob")) {
                    ((k.b) q).f2212f = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_risk_histogram_v2_prio_epsilon")) {
                    ((k.b) q).f2211e = Double.valueOf(jSONObject.getDouble("enpa_metric_risk_histogram_v2_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_code_verified_v1_sampling_prob")) {
                    ((k.b) q).f2214h = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_code_verified_v1_prio_epsilon")) {
                    ((k.b) q).f2213g = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_code_verified_with_report_type_v2_sampling_prob")) {
                    ((k.b) q).f2216j = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_with_report_type_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_code_verified_with_report_type_v2_prio_epsilon")) {
                    ((k.b) q).f2215i = Double.valueOf(jSONObject.getDouble("enpa_metric_code_verified_with_report_type_v2_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_v1_sampling_prob")) {
                    ((k.b) q).f2218l = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_v1_prio_epsilon")) {
                    ((k.b) q).f2217k = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_with_report_type_v2_sampling_prob")) {
                    ((k.b) q).n = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_with_report_type_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_with_report_type_v2_prio_epsilon")) {
                    ((k.b) q).m = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_with_report_type_v2_prio_epsilon"));
                }
                if (jSONObject.has(str)) {
                    ((k.b) q).p = Double.valueOf(jSONObject.getDouble(str));
                }
                if (jSONObject.has("enpa_metric_date_exposure_v1_prio_epsilon")) {
                    ((k.b) q).o = Double.valueOf(jSONObject.getDouble("enpa_metric_date_exposure_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_vaccine_status_v1_sampling_prob")) {
                    ((k.b) q).r = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_vaccine_status_v1_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_keys_uploaded_vaccine_status_v1_prio_epsilon")) {
                    ((k.b) q).q = Double.valueOf(jSONObject.getDouble("enpa_metric_keys_uploaded_vaccine_status_v1_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_secondary_attack_v2_sampling_prob")) {
                    ((k.b) q).t = Double.valueOf(jSONObject.getDouble("enpa_metric_secondary_attack_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_secondary_attack_v2_prio_epsilon")) {
                    ((k.b) q).s = Double.valueOf(jSONObject.getDouble("enpa_metric_secondary_attack_v2_prio_epsilon"));
                }
                if (jSONObject.has("enpa_metric_periodic_exposure_notification_biweekly_v2_sampling_prob")) {
                    ((k.b) q).v = Double.valueOf(jSONObject.getDouble("enpa_metric_periodic_exposure_notification_biweekly_v2_sampling_prob"));
                }
                if (jSONObject.has("enpa_metric_periodic_exposure_notification_biweekly_v2_prio_epsilon")) {
                    ((k.b) q).u = Double.valueOf(jSONObject.getDouble("enpa_metric_periodic_exposure_notification_biweekly_v2_prio_epsilon"));
                }
                return q.a();
            } catch (JSONException e2) {
                n.f2219e.d("Failed to parse remote config json, using defaults", e2);
            }
        }
        return n.f2220f;
    }
}
