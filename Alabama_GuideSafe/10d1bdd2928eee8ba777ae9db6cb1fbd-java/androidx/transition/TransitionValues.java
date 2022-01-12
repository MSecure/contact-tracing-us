package androidx.transition;

import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("TransitionValues@");
        outline17.append(Integer.toHexString(hashCode()));
        outline17.append(":\n");
        StringBuilder outline19 = GeneratedOutlineSupport.outline19(outline17.toString(), "    view = ");
        outline19.append(this.view);
        outline19.append("\n");
        String outline10 = GeneratedOutlineSupport.outline10(outline19.toString(), "    values:");
        for (String str : this.values.keySet()) {
            outline10 = outline10 + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return outline10;
    }

    public TransitionValues(View view2) {
        this.view = view2;
    }
}
