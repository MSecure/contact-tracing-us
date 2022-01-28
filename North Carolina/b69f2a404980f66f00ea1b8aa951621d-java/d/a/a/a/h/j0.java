package d.a.a.a.h;

import android.widget.Button;
import android.widget.TextView;
import b.n.q;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewFragment;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

/* compiled from: lambda */
public final /* synthetic */ class j0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewFragment f4729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Button f4730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f4731c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Button f4732d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f4733e;

    public /* synthetic */ j0(ShareDiagnosisViewFragment shareDiagnosisViewFragment, Button button, TextView textView, Button button2, TextView textView2) {
        this.f4729a = shareDiagnosisViewFragment;
        this.f4730b = button;
        this.f4731c = textView;
        this.f4732d = button2;
        this.f4733e = textView2;
    }

    @Override // b.n.q
    public final void a(Object obj) {
        this.f4729a.j(this.f4730b, this.f4731c, this.f4732d, this.f4733e, (PositiveDiagnosisEntity) obj);
    }
}
