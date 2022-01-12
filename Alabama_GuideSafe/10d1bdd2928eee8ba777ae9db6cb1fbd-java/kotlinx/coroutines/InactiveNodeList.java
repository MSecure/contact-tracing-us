package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
public final class InactiveNodeList implements Incomplete {
    public final NodeList list;

    public InactiveNodeList(NodeList nodeList) {
        this.list = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this.list;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return DebugKt.DEBUG ? this.list.getString("New") : super.toString();
    }
}
