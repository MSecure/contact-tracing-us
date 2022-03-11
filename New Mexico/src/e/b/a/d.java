package e.b.a;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;
/* loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public d(AlertController alertController, View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AlertController.c(absListView, this.a, this.b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
