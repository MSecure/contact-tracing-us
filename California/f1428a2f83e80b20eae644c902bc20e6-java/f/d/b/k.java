package f.d.b;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import java.util.List;

public interface k<VH extends RecyclerView.b0> extends j {
    m<VH> a();

    void c(VH vh);

    boolean d(VH vh);

    void g(VH vh, List<? extends Object> list);

    int h();

    void i(VH vh);

    boolean isEnabled();

    void j(VH vh);
}
