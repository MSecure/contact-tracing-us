package b.n;

import androidx.lifecycle.LiveData;

public class p<T> extends LiveData<T> {
    public p() {
    }

    public p(T t) {
        super(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void postValue(T t) {
        super.postValue(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T t) {
        super.setValue(t);
    }
}
