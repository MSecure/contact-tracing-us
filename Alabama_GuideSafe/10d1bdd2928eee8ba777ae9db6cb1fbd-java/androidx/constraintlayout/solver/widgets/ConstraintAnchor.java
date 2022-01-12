package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {
    public HashSet<ConstraintAnchor> mDependents = null;
    public int mGoneMargin = -1;
    public int mMargin = 0;
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r6.mOwner.hasBaseline == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r4 != r10) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r4 != r10) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006f, code lost:
        if (r4 != r2) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0074 A[RETURN] */
    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        boolean z2;
        if (constraintAnchor == null) {
            reset();
            return true;
        }
        if (!z) {
            Type type = Type.CENTER_Y;
            Type type2 = Type.CENTER_X;
            Type type3 = Type.BASELINE;
            Type type4 = constraintAnchor.mType;
            Type type5 = this.mType;
            if (type4 != type5) {
                switch (type5.ordinal()) {
                    case 0:
                    case 5:
                    case 7:
                    case 8:
                        z2 = false;
                        break;
                    case 1:
                    case 3:
                        z2 = type4 == Type.LEFT || type4 == Type.RIGHT;
                        if (constraintAnchor.mOwner instanceof Guideline) {
                            if (!z2) {
                            }
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = type4 == Type.TOP || type4 == Type.BOTTOM;
                        if (!(constraintAnchor.mOwner instanceof Guideline)) {
                            z2 = z3;
                            break;
                        } else if (!z3) {
                        }
                        break;
                    case 6:
                        if (type4 != type3) {
                            if (type4 != type2) {
                            }
                        }
                        z2 = false;
                        break;
                    default:
                        throw new AssertionError(this.mType.name());
                }
                if (!z2) {
                }
            } else if (type5 == type3) {
                if (constraintAnchor.mOwner.hasBaseline) {
                }
                z2 = false;
                if (!z2) {
                    return false;
                }
            }
            z2 = true;
            if (!z2) {
            }
        }
        this.mTarget = constraintAnchor;
        if (constraintAnchor.mDependents == null) {
            constraintAnchor.mDependents = new HashSet<>();
        }
        this.mTarget.mDependents.add(this);
        if (i > 0) {
            this.mMargin = i;
        } else {
            this.mMargin = 0;
        }
        this.mGoneMargin = i2;
        return true;
    }

    public int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.mVisibility == 8) {
            return 0;
        }
        int i = this.mGoneMargin;
        if (i <= -1 || (constraintAnchor = this.mTarget) == null || constraintAnchor.mOwner.mVisibility != 8) {
            return this.mMargin;
        }
        return i;
    }

    public boolean hasCenteredDependents() {
        ConstraintAnchor constraintAnchor;
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            ConstraintAnchor next = it.next();
            switch (next.mType.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    constraintAnchor = null;
                    break;
                case 1:
                    constraintAnchor = next.mOwner.mRight;
                    break;
                case 2:
                    constraintAnchor = next.mOwner.mBottom;
                    break;
                case 3:
                    constraintAnchor = next.mOwner.mLeft;
                    break;
                case 4:
                    constraintAnchor = next.mOwner.mTop;
                    break;
                default:
                    throw new AssertionError(next.mType.name());
            }
            if (constraintAnchor.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isConnected() {
        return this.mTarget != null;
    }

    public void reset() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.mDependents) == null)) {
            hashSet.remove(this);
        }
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
    }

    public void resetSolverVariable() {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable.reset();
        }
    }

    public String toString() {
        return this.mOwner.mDebugName + ColorPropConverter.PACKAGE_DELIMITER + this.mType.toString();
    }
}
