package f.b.a.d.l;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

public class l extends RecyclerView.r {
    public final /* synthetic */ x a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ i c;

    public l(i iVar, x xVar, MaterialButton materialButton) {
        this.c = iVar;
        this.a = xVar;
        this.b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(RecyclerView recyclerView, int i2) {
        if (i2 == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void b(RecyclerView recyclerView, int i2, int i3) {
        LinearLayoutManager z0 = this.c.z0();
        int l1 = i2 < 0 ? z0.l1() : z0.n1();
        this.c.a0 = this.a.p(l1);
        MaterialButton materialButton = this.b;
        x xVar = this.a;
        materialButton.setText(xVar.f2644d.b.v(l1).u(xVar.c));
    }
}
