package e.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;
/* loaded from: classes.dex */
public class c implements Runnable {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertController f712d;

    public c(AlertController alertController, View view, View view2) {
        this.f712d = alertController;
        this.b = view;
        this.c = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.f712d.A, this.b, this.c);
    }
}
