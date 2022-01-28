package b.b.k;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

public class d implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertController f512b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlertController.b f513c;

    public d(AlertController.b bVar, AlertController alertController) {
        this.f513c = bVar;
        this.f512b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f513c.r.onClick(this.f512b.f50b, i);
        if (!this.f513c.v) {
            this.f512b.f50b.dismiss();
        }
    }
}
