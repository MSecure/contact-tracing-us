package e.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;

public class e implements Runnable {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertController f649d;

    public e(AlertController alertController, View view, View view2) {
        this.f649d = alertController;
        this.b = view;
        this.c = view2;
    }

    public void run() {
        AlertController.c(this.f649d.f25g, this.b, this.c);
    }
}
