package e.b;

import java.io.IOException;

public class e extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public String f4804b;

    /* renamed from: c  reason: collision with root package name */
    public String f4805c;

    public e(String str, String str2, String str3) {
        super(str);
        this.f4804b = str2;
        this.f4805c = str3;
    }

    public String toString() {
        return super.toString() + ". Mimetype=" + this.f4804b + ", URL=" + this.f4805c;
    }
}
