package b.b.p;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import b.b.i;

public class c extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public int f470a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f471b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f472c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f473d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f474e;

    public c() {
        super(null);
    }

    public c(Context context, int i) {
        super(context);
        this.f470a = i;
    }

    public void a(Configuration configuration) {
        if (this.f474e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f473d == null) {
            this.f473d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f471b == null) {
            this.f471b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f471b.setTo(theme);
            }
        }
        this.f471b.applyStyle(this.f470a, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        if (this.f474e == null) {
            Configuration configuration = this.f473d;
            this.f474e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.f474e;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f472c == null) {
            this.f472c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f472c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f471b;
        if (theme != null) {
            return theme;
        }
        if (this.f470a == 0) {
            this.f470a = i.Theme_AppCompat_Light;
        }
        b();
        return this.f471b;
    }

    public void setTheme(int i) {
        if (this.f470a != i) {
            this.f470a = i;
            b();
        }
    }
}
