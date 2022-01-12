package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.lang.annotation.Annotation;

public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    public static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17(ColorPropConverter.PREFIX_RESOURCE);
        outline17.append(SkipCallbackExecutor.class.getName());
        outline17.append("()");
        return outline17.toString();
    }
}
