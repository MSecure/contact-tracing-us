package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.Row {
    public float constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public boolean isSimpleDefinition = false;
    public boolean used;
    public SolverVariable variable = null;
    public ArrayRowVariables variables;
    public ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();

    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i);

        float getVariableValue(int i);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z);

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
    }

    public ArrayRow addError(LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.constantValue = (float) i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.constantValue = (float) i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public final boolean isNew(SolverVariable solverVariable) {
        return solverVariable.usageInRowCount <= 1;
    }

    public final SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < currentSize; i++) {
            float variableValue = this.variables.getVariableValue(i);
            if (variableValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                SolverVariable variable2 = this.variables.getVariable(i);
                if ((zArr == null || !zArr[variable2.id]) && variable2 != solverVariable && (((type = variable2.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable2;
                }
            }
        }
        return solverVariable2;
    }

    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * -1.0f;
        this.variable = solverVariable;
        if (remove != 1.0f) {
            this.constantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    public String toString() {
        String str;
        boolean z;
        float variableValue;
        int i;
        if (this.variable == null) {
            str = "0";
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("");
            outline17.append(this.variable);
            str = outline17.toString();
        }
        String outline10 = GeneratedOutlineSupport.outline10(str, " = ");
        if (this.constantValue != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17(outline10);
            outline172.append(this.constantValue);
            outline10 = outline172.toString();
            z = true;
        } else {
            z = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable2 = this.variables.getVariable(i2);
            if (!(variable2 == null || (variableValue = this.variables.getVariableValue(i2)) == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                String solverVariable = variable2.toString();
                if (!z) {
                    if (variableValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        outline10 = GeneratedOutlineSupport.outline10(outline10, "- ");
                    }
                    outline10 = variableValue == 1.0f ? GeneratedOutlineSupport.outline10(outline10, solverVariable) : outline10 + variableValue + " " + solverVariable;
                    z = true;
                } else if (i > 0) {
                    outline10 = GeneratedOutlineSupport.outline10(outline10, " + ");
                    if (variableValue == 1.0f) {
                    }
                    z = true;
                } else {
                    outline10 = GeneratedOutlineSupport.outline10(outline10, " - ");
                }
                variableValue *= -1.0f;
                if (variableValue == 1.0f) {
                }
                z = true;
            }
        }
        return !z ? GeneratedOutlineSupport.outline10(outline10, "0.0") : outline10;
    }

    public void updateFromFinalVariable(SolverVariable solverVariable, boolean z) {
        if (solverVariable.isFinalValue) {
            float f = this.variables.get(solverVariable);
            this.constantValue = (solverVariable.computedValue * f) + this.constantValue;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
        }
    }

    public void updateFromRow(ArrayRow arrayRow, boolean z) {
        float use = this.variables.use(arrayRow, z);
        this.constantValue = (arrayRow.constantValue * use) + this.constantValue;
        if (z) {
            arrayRow.variable.removeFromRow(this);
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        float f;
        int i = solverVariable.strength;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
            this.variables.put(solverVariable, f);
        }
        f = 1.0f;
        this.variables.put(solverVariable, f);
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }
}
