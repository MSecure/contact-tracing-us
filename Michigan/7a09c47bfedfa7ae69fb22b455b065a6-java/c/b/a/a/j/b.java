package c.b.a.a.j;

public final class b extends IllegalStateException {
    public b(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(i<?> iVar) {
        boolean z;
        String str;
        b0 b0Var = (b0) iVar;
        synchronized (b0Var.f4101a) {
            z = b0Var.f4103c;
        }
        if (!z) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception e2 = iVar.e();
        if (e2 != null) {
            str = "failure";
        } else if (iVar.g()) {
            String valueOf = String.valueOf(iVar.f());
            StringBuilder sb = new StringBuilder(valueOf.length() + 7);
            sb.append("result ");
            sb.append(valueOf);
            str = sb.toString();
        } else {
            str = b0Var.f4104d ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new b(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), e2);
    }
}
