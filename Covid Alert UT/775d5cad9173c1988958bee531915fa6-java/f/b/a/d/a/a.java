package f.b.a.d.a;

import f.b.a.a.a.f0.q;
import f.b.a.d.a.h0;
import f.b.a.d.a.q;
import f.b.b.a.g;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class a implements g {
    public final /* synthetic */ s a;

    public /* synthetic */ a(s sVar) {
        this.a = sVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        s sVar = this.a;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(sVar);
        if (jSONObject == null) {
            ((q) sVar.f2828e).a.c("Invalid jsonObj, using default remote configs");
        } else {
            h0.a f2 = h0.f();
            try {
                if (jSONObject.has("enpa_enabled")) {
                    ((q.b) f2).a = Boolean.valueOf(jSONObject.getBoolean("enpa_enabled"));
                }
                if (jSONObject.has("enpa_collection_frequency")) {
                    ((q.b) f2).b = Long.valueOf(jSONObject.getLong("enpa_collection_frequency"));
                }
                if (jSONObject.has("device_attestation_required")) {
                    ((q.b) f2).c = Boolean.valueOf(jSONObject.getBoolean("device_attestation_required"));
                }
                if (jSONObject.has("certificate_pha")) {
                    String string = jSONObject.getString("certificate_pha");
                    Objects.requireNonNull(string, "Null phaCertificate");
                    ((q.b) f2).f2819d = string;
                }
                if (jSONObject.has("certificate_facilitator")) {
                    String string2 = jSONObject.getString("certificate_facilitator");
                    Objects.requireNonNull(string2, "Null facilitatorCertificate");
                    ((q.b) f2).f2820e = string2;
                }
                if (jSONObject.has("encryption_key_id_pha")) {
                    String string3 = jSONObject.getString("encryption_key_id_pha");
                    Objects.requireNonNull(string3, "Null phaEncryptionKeyId");
                    ((q.b) f2).f2821f = string3;
                }
                if (jSONObject.has("encryption_key_id_facilitator")) {
                    String string4 = jSONObject.getString("encryption_key_id_facilitator");
                    Objects.requireNonNull(string4, "Null facilitatorEncryptionKeyId");
                    ((q.b) f2).f2822g = string4;
                }
                return f2.a();
            } catch (JSONException e2) {
                ((f.b.a.a.a.f0.q) sVar.f2828e).a.d("Failed to parse remote config json, using defaults", e2);
            }
        }
        return s.f2826g;
    }
}
