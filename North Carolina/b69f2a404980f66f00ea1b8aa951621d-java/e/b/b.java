package e.b;

import java.io.IOException;

public class b extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public int f4802b;

    /* renamed from: c  reason: collision with root package name */
    public String f4803c;

    public b(String str, int i, String str2) {
        super(str);
        this.f4802b = i;
        this.f4803c = str2;
    }

    public String toString() {
        return super.toString() + ". Status=" + this.f4802b + ", URL=" + this.f4803c;
    }
}
