package e.a.a.e;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: lambda */
public final /* synthetic */ class l implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader.KeySubmission f6296a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONArray f6297b;

    public /* synthetic */ l(DiagnosisKeyUploader.KeySubmission keySubmission, JSONArray jSONArray) {
        this.f6296a = keySubmission;
        this.f6297b = jSONArray;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return DiagnosisKeyUploader.c(this.f6296a, this.f6297b, (JSONObject) obj);
    }
}
