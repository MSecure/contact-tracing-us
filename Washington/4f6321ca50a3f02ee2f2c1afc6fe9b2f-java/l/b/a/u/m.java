package l.b.a.u;

public enum m {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    public boolean a(boolean z, boolean z2, boolean z3) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return !z || !z2;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return !z2 && !z3;
    }
}
