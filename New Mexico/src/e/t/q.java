package e.t;

import android.os.Bundle;
import e.t.j;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes.dex */
public abstract class q<D extends j> {

    /* loaded from: classes.dex */
    public interface a {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface b {
        String value();
    }

    public abstract D a();

    public abstract j b(D d2, Bundle bundle, o oVar, a aVar);

    public void c(Bundle bundle) {
    }

    public Bundle d() {
        return null;
    }

    public abstract boolean e();
}
