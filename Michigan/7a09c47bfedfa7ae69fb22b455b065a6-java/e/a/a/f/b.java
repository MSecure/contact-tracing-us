package e.a.a.f;

import android.widget.TextView;
import android.widget.ViewSwitcher;
import b.o.q;
import gov.michigan.MiCovidExposure.notify.NotifyHomeFragment;
import gov.michigan.MiCovidExposure.notify.PositiveDiagnosisEntityAdapter;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class b implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewSwitcher f6321a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositiveDiagnosisEntityAdapter f6322b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f6323c;

    public /* synthetic */ b(ViewSwitcher viewSwitcher, PositiveDiagnosisEntityAdapter positiveDiagnosisEntityAdapter, TextView textView) {
        this.f6321a = viewSwitcher;
        this.f6322b = positiveDiagnosisEntityAdapter;
        this.f6323c = textView;
    }

    @Override // b.o.q
    public final void a(Object obj) {
        NotifyHomeFragment.j(this.f6321a, this.f6322b, this.f6323c, (List) obj);
    }
}
