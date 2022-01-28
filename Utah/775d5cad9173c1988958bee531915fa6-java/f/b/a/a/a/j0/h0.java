package f.b.a.a.a.j0;

import android.widget.ImageView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.q.t;
import java.util.Objects;

public final /* synthetic */ class h0 implements t {
    public final /* synthetic */ b1 a;

    public /* synthetic */ h0(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        ImageView imageView;
        int i2;
        b1 b1Var = this.a;
        Objects.requireNonNull(b1Var);
        int ordinal = ((ExposureNotificationViewModel.b) obj).ordinal();
        if (ordinal == 0 || ordinal == 1) {
            imageView = b1Var.b0.f2437e;
            i2 = 8;
        } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
            imageView = b1Var.b0.f2437e;
            i2 = 0;
        } else {
            return;
        }
        imageView.setVisibility(i2);
    }
}
