package d.a.a.a.g;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyUploader;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: lambda */
public final /* synthetic */ class k implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader.KeySubmission f4681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONArray f4682b;

    public /* synthetic */ k(DiagnosisKeyUploader.KeySubmission keySubmission, JSONArray jSONArray) {
        this.f4681a = keySubmission;
        this.f4682b = jSONArray;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return DiagnosisKeyUploader.b(this.f4681a, this.f4682b, (JSONObject) obj);
    }
}
