package f.b.a.a.a.y;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import f.b.a.a.a.v.p;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class a implements g {
    public final /* synthetic */ CountryCheckingWorker a;

    public /* synthetic */ a(CountryCheckingWorker countryCheckingWorker) {
        this.a = countryCheckingWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        CountryCheckingWorker countryCheckingWorker = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(countryCheckingWorker);
        CountryCheckingWorker.f435i.d("Failure to check country code", exc);
        countryCheckingWorker.f439h.k(p.d.TASK_COUNTRY_CHECKING, exc);
        return new ListenableWorker.a.C0003a();
    }
}
