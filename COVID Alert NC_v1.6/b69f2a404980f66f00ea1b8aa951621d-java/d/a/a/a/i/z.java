package d.a.a.a.i;

import android.view.View;
import androidx.fragment.app.Fragment;
import gov.nc.dhhs.exposurenotification.onboarding.PrivacyChecklist;

/* compiled from: lambda */
public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrivacyChecklist f4785b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4786c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Fragment f4787d;

    public /* synthetic */ z(PrivacyChecklist privacyChecklist, int i, Fragment fragment) {
        this.f4785b = privacyChecklist;
        this.f4786c = i;
        this.f4787d = fragment;
    }

    public final void onClick(View view) {
        this.f4785b.d(this.f4786c, this.f4787d, view);
    }
}
