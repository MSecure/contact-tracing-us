package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    public int TABLE_SIZE = 128;
    public GoalVariableAccessor accessor = new GoalVariableAccessor(this);
    public SolverVariable[] arrayGoals = new SolverVariable[128];
    public int numGoals = 0;
    public SolverVariable[] sortArray = new SolverVariable[128];

    public class GoalVariableAccessor implements Comparable {
        public SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.id - ((SolverVariable) obj).id;
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17(str);
                    outline17.append(this.variable.goalStrengthVector[i]);
                    outline17.append(" ");
                    str = outline17.toString();
                }
            }
            StringBuilder outline19 = GeneratedOutlineSupport.outline19(str, "] ");
            outline19.append(this.variable);
            return outline19.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.variable = solverVariable;
        Arrays.fill(solverVariable.goalStrengthVector, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public final void addToGoal(SolverVariable solverVariable) {
        int i;
        int i2 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i3 = this.numGoals;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.numGoals = i4;
        if (i4 > 1 && solverVariableArr3[i4 - 1].id > solverVariable.id) {
            int i5 = 0;
            while (true) {
                i = this.numGoals;
                if (i5 >= i) {
                    break;
                }
                this.sortArray[i5] = this.arrayGoals[i5];
                i5++;
            }
            Arrays.sort(this.sortArray, 0, i, new Comparator<SolverVariable>(this) {
                /* class androidx.constraintlayout.solver.PriorityGoalRow.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.id - solverVariable2.id;
                }
            });
            for (int i6 = 0; i6 < this.numGoals; i6++) {
                this.arrayGoals[i6] = this.sortArray[i6];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r8 < r4) goto L_0x0057;
     */
    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.numGoals; i2++) {
            SolverVariable[] solverVariableArr = this.arrayGoals;
            SolverVariable solverVariable = solverVariableArr[i2];
            if (!zArr[solverVariable.id]) {
                GoalVariableAccessor goalVariableAccessor = this.accessor;
                goalVariableAccessor.variable = solverVariable;
                int i3 = 8;
                boolean z = true;
                if (i != -1) {
                    SolverVariable solverVariable2 = solverVariableArr[i];
                    if (goalVariableAccessor != null) {
                        while (true) {
                            if (i3 < 0) {
                                break;
                            }
                            float f = solverVariable2.goalStrengthVector[i3];
                            float f2 = goalVariableAccessor.variable.goalStrengthVector[i3];
                            if (f2 == f) {
                                i3--;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    } else {
                        throw null;
                    }
                } else if (goalVariableAccessor != null) {
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        float f3 = goalVariableAccessor.variable.goalStrengthVector[i3];
                        if (f3 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            break;
                        } else if (f3 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            break;
                        } else {
                            i3--;
                        }
                    }
                    if (!z) {
                    }
                } else {
                    throw null;
                }
                i = i2;
            }
        }
        if (i == -1) {
            return null;
        }
        return this.arrayGoals[i];
    }

    public final void removeGoal(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.numGoals) {
            if (this.arrayGoals[i] == solverVariable) {
                while (true) {
                    int i2 = this.numGoals;
                    if (i < i2 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    } else {
                        this.numGoals = i2 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        StringBuilder outline19 = GeneratedOutlineSupport.outline19("", " goal -> (");
        outline19.append(this.constantValue);
        outline19.append(") : ");
        String sb = outline19.toString();
        for (int i = 0; i < this.numGoals; i++) {
            this.accessor.variable = this.arrayGoals[i];
            StringBuilder outline17 = GeneratedOutlineSupport.outline17(sb);
            outline17.append(this.accessor);
            outline17.append(" ");
            sb = outline17.toString();
        }
        return sb;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public void updateFromRow(ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                SolverVariable variable = arrayRowVariables.getVariable(i);
                float variableValue = arrayRowVariables.getVariableValue(i);
                GoalVariableAccessor goalVariableAccessor = this.accessor;
                goalVariableAccessor.variable = variable;
                boolean z2 = true;
                if (variable.inGoal) {
                    for (int i2 = 0; i2 < 9; i2++) {
                        float[] fArr = goalVariableAccessor.variable.goalStrengthVector;
                        fArr[i2] = (solverVariable.goalStrengthVector[i2] * variableValue) + fArr[i2];
                        if (Math.abs(fArr[i2]) < 1.0E-4f) {
                            goalVariableAccessor.variable.goalStrengthVector[i2] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        PriorityGoalRow.this.removeGoal(goalVariableAccessor.variable);
                    }
                    z2 = false;
                } else {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float f = solverVariable.goalStrengthVector[i3];
                        if (f != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            float f2 = f * variableValue;
                            if (Math.abs(f2) < 1.0E-4f) {
                                f2 = 0.0f;
                            }
                            goalVariableAccessor.variable.goalStrengthVector[i3] = f2;
                        } else {
                            goalVariableAccessor.variable.goalStrengthVector[i3] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    addToGoal(variable);
                }
                this.constantValue = (arrayRow.constantValue * variableValue) + this.constantValue;
            }
            removeGoal(solverVariable);
        }
    }
}
