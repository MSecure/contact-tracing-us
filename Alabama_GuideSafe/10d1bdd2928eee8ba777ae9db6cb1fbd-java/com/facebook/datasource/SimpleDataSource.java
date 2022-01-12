package com.facebook.datasource;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setFailure(Throwable th) {
        if (th != null) {
            return super.setFailure(th);
        }
        throw null;
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float f) {
        return super.setProgress(f);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setResult(T t, boolean z) {
        if (t != null) {
            return super.setResult(t, z);
        }
        throw null;
    }
}
