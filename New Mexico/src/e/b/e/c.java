package e.b.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;
/* loaded from: classes.dex */
public class c extends ContextWrapper {
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f793d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f794e;

    public c() {
        super(null);
    }

    public c(Context context, int i2) {
        super(context);
        this.a = i2;
    }

    public void a(Configuration configuration) {
        if (this.f794e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f793d == null) {
            this.f793d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f794e == null) {
            Configuration configuration = this.f793d;
            this.f794e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.f794e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = R$style.Theme_AppCompat_Light;
        }
        b();
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.a != i2) {
            this.a = i2;
            b();
        }
    }
}
