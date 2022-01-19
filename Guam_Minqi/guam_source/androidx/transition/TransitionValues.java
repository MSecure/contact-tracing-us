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
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("TransitionValues@");
        outline15.append(Integer.toHexString(hashCode()));
        outline15.append(":\n");
        String outline8 = GeneratedOutlineSupport.outline8(outline15.toString() + "    view = " + this.view + "\n", "    values:");
        for (String str : this.values.keySet()) {
            outline8 = outline8 + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return outline8;
    }

    public TransitionValues(View view2) {
        this.view = view2;
    }
}
