package f.b.a.a.a.z;

import android.widget.ImageView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.t;
import java.util.Objects;

public final /* synthetic */ class h0 implements t {
    public final /* synthetic */ d1 a;

    public /* synthetic */ h0(d1 d1Var) {
        this.a = d1Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        ImageView imageView;
        int i2;
        d1 d1Var = this.a;
        Objects.requireNonNull(d1Var);
        int ordinal = ((ExposureNotificationViewModel.b) obj).ordinal();
        if (ordinal == 0 || ordinal == 1) {
            imageView = d1Var.a0.f2239e;
            i2 = 8;
        } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
            imageView = d1Var.a0.f2239e;
            i2 = 0;
        } else {
            return;
        }
        imageView.setVisibility(i2);
    }
}
