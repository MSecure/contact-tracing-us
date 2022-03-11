package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements Externalizable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f3817e;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3820h;
    public String b = "";
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public List<String> f3816d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f3818f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f3819g = false;

    /* renamed from: i  reason: collision with root package name */
    public String f3821i = "";

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.b = objectInput.readUTF();
        this.c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3816d.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.f3817e = true;
            this.f3818f = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3820h = true;
            this.f3821i = readUTF2;
        }
        this.f3819g = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeUTF(this.c);
        int size = this.f3816d.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            objectOutput.writeUTF(this.f3816d.get(i2));
        }
        objectOutput.writeBoolean(this.f3817e);
        if (this.f3817e) {
            objectOutput.writeUTF(this.f3818f);
        }
        objectOutput.writeBoolean(this.f3820h);
        if (this.f3820h) {
            objectOutput.writeUTF(this.f3821i);
        }
        objectOutput.writeBoolean(this.f3819g);
    }
}
