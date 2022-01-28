package androidx.fragment.app;

public class FragmentController {
    public final FragmentHostCallback<?> mHost;

    public FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }
}
