package e.q;

import androidx.lifecycle.LiveData;

public class s<T> extends LiveData<T> {
    public s() {
    }

    public s(T t) {
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
