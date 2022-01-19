package androidx.core.os;

public final class CancellationSignal {
    public boolean mCancelInProgress;
    public boolean mIsCanceled;
    public OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
    }
}
