package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: CoroutineContext.kt */
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    public static final Key Key = new Key(null);
    public final long id;

    /* compiled from: CoroutineContext.kt */
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public CoroutineId(long j) {
        super(Key);
        this.id = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineId) && this.id == ((CoroutineId) obj).id;
        }
        return true;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.coroutines.CoroutineContext, java.lang.Object] */
    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("CoroutineId(");
        outline17.append(this.id);
        outline17.append(')');
        return outline17.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlinx.coroutines.ThreadContextElement
    public String updateThreadContext(CoroutineContext coroutineContext) {
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int lastIndexOf$default = StringsKt__StringNumberConversionsKt.lastIndexOf$default(name, " @", 0, false, 6);
        if (lastIndexOf$default < 0) {
            lastIndexOf$default = name.length();
        }
        StringBuilder sb = new StringBuilder(9 + lastIndexOf$default + 10);
        String substring = name.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append("coroutine");
        sb.append('#');
        sb.append(this.id);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }
}
