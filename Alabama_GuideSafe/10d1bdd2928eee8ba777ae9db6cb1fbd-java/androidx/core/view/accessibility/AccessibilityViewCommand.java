package androidx.core.view.accessibility;

import android.os.Bundle;

public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {
        public Bundle mBundle;
    }

    public static final class SetProgressArguments extends CommandArguments {
    }
}
