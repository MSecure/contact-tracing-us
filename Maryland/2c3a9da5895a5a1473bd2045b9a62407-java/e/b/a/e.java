package e.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;

public class e implements Runnable {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertController f656d;

    public e(AlertController alertController, View view, View view2) {
        this.f656d = alertController;
        this.b = view;
        this.c = view2;
    }

    public void run() {
        AlertController.c(this.f656d.f21g, this.b, this.c);
    }
}
