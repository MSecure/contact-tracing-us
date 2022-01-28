package e.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;

public class c implements Runnable {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertController f645d;

    public c(AlertController alertController, View view, View view2) {
        this.f645d = alertController;
        this.b = view;
        this.c = view2;
    }

    public void run() {
        AlertController.c(this.f645d.A, this.b, this.c);
    }
}
