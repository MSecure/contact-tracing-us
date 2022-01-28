package kotlin.jvm.internal;

/* compiled from: Lambda.kt */
public abstract class Lambda<R> implements Object<R> {
    public Lambda(int i) {
    }

    public String toString() {
        if (Reflection.factory != null) {
            String obj = getClass().getGenericInterfaces()[0].toString();
            if (obj.startsWith("kotlin.jvm.functions.")) {
                obj = obj.substring(21);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "Reflection.renderLambdaToString(this)");
            return obj;
        }
        throw null;
    }
}
