package c.b.a.b.x;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

public class j extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f3260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f3262c;

    public j(g gVar, v vVar, MaterialButton materialButton) {
        this.f3262c = gVar;
        this.f3260a = vVar;
        this.f3261b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f3261b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager e2 = this.f3262c.e();
        int i1 = i < 0 ? e2.i1() : e2.k1();
        this.f3262c.f = this.f3260a.a(i1);
        this.f3261b.setText(this.f3260a.f3289a.f3218b.v(i1).f3280c);
    }
}
