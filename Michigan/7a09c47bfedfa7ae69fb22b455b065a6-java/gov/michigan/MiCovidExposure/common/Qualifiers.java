package gov.michigan.MiCovidExposure.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Qualifiers {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface BackgroundExecutor {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface LightweightExecutor {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ScheduledExecutor {
    }
}
