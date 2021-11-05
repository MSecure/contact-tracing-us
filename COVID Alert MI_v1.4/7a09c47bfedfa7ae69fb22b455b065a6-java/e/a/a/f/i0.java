package e.a.a.f;

import android.widget.Button;
import android.widget.TextView;
import b.o.q;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisViewFragment;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class i0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f6338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Button f6339b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f6340c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Button f6341d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f6342e;

    public /* synthetic */ i0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, Button button, TextView textView, Button button2, TextView textView2) {
        this.f6338a = shareDiagnosisViewFragment;
        this.f6339b = button;
        this.f6340c = textView;
        this.f6341d = button2;
        this.f6342e = textView2;
    }

    @Override // b.o.q
    public final void a(Object obj) {
        this.f6338a.j(this.f6339b, this.f6340c, this.f6341d, this.f6342e, (PositiveDiagnosisEntity) obj);
    }
}
