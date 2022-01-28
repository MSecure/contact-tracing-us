package b.b.k;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

public class d implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertController f362b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlertController.b f363c;

    public d(AlertController.b bVar, AlertController alertController) {
        this.f363c = bVar;
        this.f362b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f363c.r.onClick(this.f362b.f20b, i);
        if (!this.f363c.t) {
            this.f362b.f20b.dismiss();
        }
    }
}
