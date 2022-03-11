package f.b.a.a.a.v;

import android.widget.ImageView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;

public final /* synthetic */ class w implements r {
    public final /* synthetic */ ImageView a;

    public /* synthetic */ w(ImageView imageView) {
        this.a = imageView;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        int i2;
        ImageView imageView = this.a;
        ExposureNotificationViewModel exposureNotificationViewModel = t0.Z;
        int ordinal = ((ExposureNotificationViewModel.a) obj).ordinal();
        if (ordinal == 0 || ordinal == 1) {
            i2 = 8;
        } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
            i2 = 0;
        } else {
            return;
        }
        imageView.setVisibility(i2);
    }
}
