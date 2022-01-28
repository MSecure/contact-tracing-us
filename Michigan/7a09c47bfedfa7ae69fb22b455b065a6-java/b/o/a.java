package b.o;

import android.annotation.SuppressLint;
import android.app.Application;

public class a extends x {
    @SuppressLint({"StaticFieldLeak"})
    public Application mApplication;

    public a(Application application) {
        this.mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
