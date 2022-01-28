package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class f implements Externalizable {
    public String b = "";
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public List<String> f3496d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3497e;

    /* renamed from: f  reason: collision with root package name */
    public String f3498f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f3499g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3500h;

    /* renamed from: i  reason: collision with root package name */
    public String f3501i = "";

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.b = objectInput.readUTF();
        this.c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3496d.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.f3497e = true;
            this.f3498f = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3500h = true;
            this.f3501i = readUTF2;
        }
        this.f3499g = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeUTF(this.c);
        int size = this.f3496d.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            objectOutput.writeUTF(this.f3496d.get(i2));
        }
        objectOutput.writeBoolean(this.f3497e);
        if (this.f3497e) {
            objectOutput.writeUTF(this.f3498f);
        }
        objectOutput.writeBoolean(this.f3500h);
        if (this.f3500h) {
            objectOutput.writeUTF(this.f3501i);
        }
        objectOutput.writeBoolean(this.f3499g);
    }
}
