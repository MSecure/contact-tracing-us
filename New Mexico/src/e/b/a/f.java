package e.b.a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController b;
    public final /* synthetic */ AlertController.b c;

    public f(AlertController.b bVar, AlertController alertController) {
        this.c = bVar;
        this.b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.c.p.onClick(this.b.b, i2);
        if (!this.c.s) {
            this.b.b.dismiss();
        }
    }
}
