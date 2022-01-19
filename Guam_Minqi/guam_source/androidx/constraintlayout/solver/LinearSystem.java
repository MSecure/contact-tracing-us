package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    public static int POOL_SIZE = 1000;
    public int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean[] mAlreadyTestedCandidates;
    public final Cache mCache;
    public Row mGoal;
    public int mMaxColumns;
    public int mMaxRows;
    public int mNumColumns;
    public int mNumRows;
    public SolverVariable[] mPoolVariables;
    public int mPoolVariablesCount;
    public ArrayRow[] mRows;
    public Row mTempGoal;
    public HashMap<String, SolverVariable> mVariables;
    public int mVariablesID;
    public boolean newgraphOptimizer;

    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);
    }

    public class ValuesRow extends ArrayRow {
        public ValuesRow(LinearSystem linearSystem, Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this, this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public final SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type);
            solverVariable.mType = type;
        } else {
            solverVariable.reset();
            solverVariable.mType = type;
        }
        int i = this.mPoolVariablesCount;
        int i2 = POOL_SIZE;
        if (i >= i2) {
            int i3 = i2 * 2;
            POOL_SIZE = i3;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i3);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = solverVariable;
        return solverVariable;
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                createRow.constantValue = (float) ((-i) + i2);
            }
        } else if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.constantValue = (float) i;
        } else if (f >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.constantValue = (float) (-i2);
        } else {
            float f2 = 1.0f - f;
            createRow.variables.put(solverVariable, f2 * 1.0f);
            createRow.variables.put(solverVariable2, f2 * -1.0f);
            createRow.variables.put(solverVariable3, -1.0f * f);
            createRow.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                createRow.constantValue = (((float) i2) * f) + (((float) (-i)) * f2);
            }
        }
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        boolean z;
        boolean z2;
        boolean z3;
        SolverVariable pickPivotInVariables;
        boolean z4;
        boolean z5;
        SolverVariable.Type type = SolverVariable.Type.UNRESTRICTED;
        boolean z6 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (!arrayRow.isSimpleDefinition) {
            if (this.mRows.length != 0) {
                boolean z7 = false;
                while (!z7) {
                    int currentSize = arrayRow.variables.getCurrentSize();
                    for (int i = 0; i < currentSize; i++) {
                        SolverVariable variable = arrayRow.variables.getVariable(i);
                        if (variable.definitionId != -1 || variable.isFinalValue) {
                            arrayRow.variablesToUpdate.add(variable);
                        }
                    }
                    if (arrayRow.variablesToUpdate.size() > 0) {
                        Iterator<SolverVariable> it = arrayRow.variablesToUpdate.iterator();
                        while (it.hasNext()) {
                            SolverVariable next = it.next();
                            if (next.isFinalValue) {
                                arrayRow.updateFromFinalVariable(next, true);
                            } else {
                                arrayRow.updateFromRow(this.mRows[next.definitionId], true);
                            }
                        }
                        arrayRow.variablesToUpdate.clear();
                    } else {
                        z7 = true;
                    }
                }
            }
            if (!(arrayRow.variable == null && arrayRow.constantValue == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && arrayRow.variables.getCurrentSize() == 0)) {
                float f = arrayRow.constantValue;
                if (f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    arrayRow.constantValue = f * -1.0f;
                    arrayRow.variables.invert();
                }
                int currentSize2 = arrayRow.variables.getCurrentSize();
                float f2 = 0.0f;
                float f3 = 0.0f;
                SolverVariable solverVariable = null;
                SolverVariable solverVariable2 = null;
                boolean z8 = false;
                boolean z9 = false;
                for (int i2 = 0; i2 < currentSize2; i2++) {
                    float variableValue = arrayRow.variables.getVariableValue(i2);
                    SolverVariable variable2 = arrayRow.variables.getVariable(i2);
                    if (variable2.mType == type) {
                        if (solverVariable == null) {
                            z5 = arrayRow.isNew(variable2);
                        } else if (f2 > variableValue) {
                            z5 = arrayRow.isNew(variable2);
                        } else if (!z8 && arrayRow.isNew(variable2)) {
                            z8 = true;
                            f2 = variableValue;
                            solverVariable = variable2;
                        }
                        z8 = z5;
                        f2 = variableValue;
                        solverVariable = variable2;
                    } else if (solverVariable == null && variableValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        if (solverVariable2 == null) {
                            z4 = arrayRow.isNew(variable2);
                        } else if (f3 > variableValue) {
                            z4 = arrayRow.isNew(variable2);
                        } else if (!z9 && arrayRow.isNew(variable2)) {
                            z9 = true;
                            f3 = variableValue;
                            solverVariable2 = variable2;
                        }
                        z9 = z4;
                        f3 = variableValue;
                        solverVariable2 = variable2;
                    }
                }
                if (solverVariable == null) {
                    solverVariable = solverVariable2;
                }
                if (solverVariable == null) {
                    z2 = true;
                } else {
                    arrayRow.pivot(solverVariable);
                    z2 = false;
                }
                if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.isSimpleDefinition = true;
                }
                if (z2) {
                    if (this.mNumColumns + 1 >= this.mMaxColumns) {
                        increaseTableSize();
                    }
                    SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
                    int i3 = this.mVariablesID + 1;
                    this.mVariablesID = i3;
                    this.mNumColumns++;
                    acquireSolverVariable.id = i3;
                    this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
                    arrayRow.variable = acquireSolverVariable;
                    addRow(arrayRow);
                    ArrayRow arrayRow2 = (ArrayRow) this.mTempGoal;
                    if (arrayRow2 != null) {
                        arrayRow2.variable = null;
                        arrayRow2.variables.clear();
                        for (int i4 = 0; i4 < arrayRow.variables.getCurrentSize(); i4++) {
                            arrayRow2.variables.add(arrayRow.variables.getVariable(i4), arrayRow.variables.getVariableValue(i4), true);
                        }
                        optimize(this.mTempGoal);
                        if (acquireSolverVariable.definitionId == -1) {
                            if (arrayRow.variable == acquireSolverVariable && (pickPivotInVariables = arrayRow.pickPivotInVariables(null, acquireSolverVariable)) != null) {
                                arrayRow.pivot(pickPivotInVariables);
                            }
                            if (!arrayRow.isSimpleDefinition) {
                                arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                            }
                            this.mNumRows--;
                        }
                        z3 = true;
                    } else {
                        throw null;
                    }
                } else {
                    z3 = false;
                }
                SolverVariable solverVariable3 = arrayRow.variable;
                if (solverVariable3 == null || (solverVariable3.mType != type && arrayRow.constantValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                    z6 = false;
                }
                if (z6) {
                    z = z3;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            z = false;
        }
        if (!z) {
            addRow(arrayRow);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i));
            return null;
        }
        ArrayRow createRow = createRow();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            createRow.constantValue = (float) i;
        }
        if (!z) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
        } else {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
        }
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            ArrayRow[] arrayRowArr = this.mRows;
            int i = this.mNumRows;
            if (arrayRowArr[i] != null) {
                this.mCache.optimizedArrayRowPool.release(arrayRowArr[i]);
            }
        } else {
            ArrayRow[] arrayRowArr2 = this.mRows;
            int i2 = this.mNumRows;
            if (arrayRowArr2[i2] != null) {
                this.mCache.arrayRowPool.release(arrayRowArr2[i2]);
            }
        }
        ArrayRow[] arrayRowArr3 = this.mRows;
        int i3 = this.mNumRows;
        arrayRowArr3[i3] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i3;
        this.mNumRows = i3 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    public final void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        acquireSolverVariable.id = i2;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[i2] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.mSolverVariable;
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable();
                solverVariable = constraintAnchor.mSolverVariable;
            }
            int i = solverVariable.id;
            if (i == -1 || i > this.mVariablesID || this.mCache.mIndexedVariables[i] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                int i2 = this.mVariablesID + 1;
                this.mVariablesID = i2;
                this.mNumColumns++;
                solverVariable.id = i2;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = (ArrayRow) this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this, this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRow.variable = null;
                arrayRow.variables.clear();
                arrayRow.constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                arrayRow.isSimpleDefinition = false;
            }
        } else {
            arrayRow = (ArrayRow) this.mCache.arrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRow.variable = null;
                arrayRow.variables.clear();
                arrayRow.constantValue = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                arrayRow.isSimpleDefinition = false;
            }
        }
        SolverVariable.uniqueErrorId++;
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).mSolverVariable;
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public final void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
    }

    public void minimizeGoal(Row row) throws Exception {
        float f;
        int i;
        boolean z;
        SolverVariable.Type type = SolverVariable.Type.UNRESTRICTED;
        int i2 = 0;
        while (true) {
            int i3 = this.mNumRows;
            f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            i = 1;
            if (i2 >= i3) {
                z = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2].variable.mType != type && arrayRowArr[i2].constantValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i4 = 0;
            while (!z2) {
                i4 += i;
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                int i8 = 0;
                while (i7 < this.mNumRows) {
                    ArrayRow arrayRow = this.mRows[i7];
                    if (arrayRow.variable.mType != type && !arrayRow.isSimpleDefinition && arrayRow.constantValue < f) {
                        int i9 = i;
                        while (i9 < this.mNumColumns) {
                            SolverVariable solverVariable = this.mCache.mIndexedVariables[i9];
                            float f3 = arrayRow.variables.get(solverVariable);
                            if (f3 > f) {
                                for (int i10 = 0; i10 < 9; i10++) {
                                    float f4 = solverVariable.strengthVector[i10] / f3;
                                    if ((f4 < f2 && i10 == i8) || i10 > i8) {
                                        i8 = i10;
                                        f2 = f4;
                                        i5 = i7;
                                        i6 = i9;
                                    }
                                }
                            }
                            i9++;
                            f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        }
                    }
                    i7++;
                    f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    i = 1;
                }
                if (i5 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i5];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i6]);
                    SolverVariable solverVariable2 = arrayRow2.variable;
                    solverVariable2.definitionId = i5;
                    solverVariable2.updateReferencesWithNewDefinition(arrayRow2);
                } else {
                    z2 = true;
                }
                if (i4 > this.mNumColumns / 2) {
                    z2 = true;
                }
                f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                i = 1;
            }
        }
        optimize(row);
        computeValues();
    }

    public final int optimize(Row row) {
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            SolverVariable solverVariable = ((ArrayRow) row).variable;
            if (solverVariable != null) {
                this.mAlreadyTestedCandidates[solverVariable.id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i3 = pivotCandidate.id;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    ArrayRow arrayRow = this.mRows[i5];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.variables.contains(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable2 = arrayRow2.variable;
                    solverVariable2.definitionId = i4;
                    solverVariable2.updateReferencesWithNewDefinition(arrayRow2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public final void releaseRows() {
        int i = 0;
        if (OPTIMIZED_ENGINE) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i < arrayRowArr.length) {
                    ArrayRow arrayRow = arrayRowArr[i];
                    if (arrayRow != null) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow);
                    }
                    this.mRows[i] = null;
                    i++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i < arrayRowArr2.length) {
                    ArrayRow arrayRow2 = arrayRowArr2[i];
                    if (arrayRow2 != null) {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i] = null;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void reset() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        Pools$SimplePool<SolverVariable> pools$SimplePool = cache.solverVariablePool;
        SolverVariable[] solverVariableArr2 = this.mPoolVariables;
        int i2 = this.mPoolVariablesCount;
        if (pools$SimplePool != null) {
            if (i2 > solverVariableArr2.length) {
                i2 = solverVariableArr2.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                SolverVariable solverVariable2 = solverVariableArr2[i3];
                int i4 = pools$SimplePool.mPoolSize;
                Object[] objArr = pools$SimplePool.mPool;
                if (i4 < objArr.length) {
                    objArr[i4] = solverVariable2;
                    pools$SimplePool.mPoolSize = i4 + 1;
                }
            }
            this.mPoolVariablesCount = 0;
            Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
            HashMap<String, SolverVariable> hashMap = this.mVariables;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.mVariablesID = 0;
            this.mGoal.clear();
            this.mNumColumns = 1;
            for (int i5 = 0; i5 < this.mNumRows; i5++) {
                this.mRows[i5].used = false;
            }
            releaseRows();
            this.mNumRows = 0;
            if (OPTIMIZED_ENGINE) {
                this.mTempGoal = new ValuesRow(this, this.mCache);
            } else {
                this.mTempGoal = new ArrayRow(this.mCache);
            }
        } else {
            throw null;
        }
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        if (i2 == -1) {
            solverVariable.setFinalValue(this, (float) i);
        } else if (i2 != -1) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i;
            } else {
                ArrayRow createRow = createRow();
                if (i < 0) {
                    createRow.constantValue = (float) (i * -1);
                    createRow.variables.put(solverVariable, 1.0f);
                } else {
                    createRow.constantValue = (float) i;
                    createRow.variables.put(solverVariable, -1.0f);
                }
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.variable = solverVariable;
            float f = (float) i;
            solverVariable.computedValue = f;
            createRow2.constantValue = f;
            createRow2.isSimpleDefinition = true;
            addConstraint(createRow2);
        }
    }
}
