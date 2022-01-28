package c.b.a.b.x;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

public class j extends RecyclerView.q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f4589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f4590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f4591c;

    public j(g gVar, v vVar, MaterialButton materialButton) {
        this.f4591c = gVar;
        this.f4589a = vVar;
        this.f4590b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f4590b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager e2 = this.f4591c.e();
        int i1 = i < 0 ? e2.i1() : e2.k1();
        this.f4591c.f4577f = this.f4589a.a(i1);
        this.f4590b.setText(this.f4589a.f4623a.f4539b.B(i1).f4611c);
    }
}
