package e.p;

import androidx.lifecycle.LiveData;

public class q<T> extends LiveData<T> {
    public q() {
    }

    public q(T t) {
        super(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void j(T t) {
        super.j(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void l(T t) {
        super.l(t);
    }
}
