package e.c.a.v;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.w.d;
import e.c.a.w.m;

public abstract class b extends c implements d {
    @Override // e.c.a.w.d
    public d k(long j, m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }
}
