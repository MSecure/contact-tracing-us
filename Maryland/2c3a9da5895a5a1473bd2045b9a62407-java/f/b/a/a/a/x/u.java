package f.b.a.a.a.x;

import android.widget.ImageView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;
import java.util.Objects;

public final /* synthetic */ class u implements r {
    public final /* synthetic */ r0 a;

    public /* synthetic */ u(r0 r0Var) {
        this.a = r0Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ImageView imageView;
        int i2;
        r0 r0Var = this.a;
        Objects.requireNonNull(r0Var);
        int ordinal = ((ExposureNotificationViewModel.a) obj).ordinal();
        if (ordinal == 0 || ordinal == 1) {
            imageView = r0Var.a0.f2128e;
            i2 = 8;
        } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
            imageView = r0Var.a0.f2128e;
            i2 = 0;
        } else {
            return;
        }
        imageView.setVisibility(i2);
    }
}
