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
    public List<String> f3561d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3562e;

    /* renamed from: f  reason: collision with root package name */
    public String f3563f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f3564g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3565h;

    /* renamed from: i  reason: collision with root package name */
    public String f3566i = "";

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.b = objectInput.readUTF();
        this.c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3561d.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.f3562e = true;
            this.f3563f = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3565h = true;
            this.f3566i = readUTF2;
        }
        this.f3564g = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeUTF(this.c);
        int size = this.f3561d.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            objectOutput.writeUTF(this.f3561d.get(i2));
        }
        objectOutput.writeBoolean(this.f3562e);
        if (this.f3562e) {
            objectOutput.writeUTF(this.f3563f);
        }
        objectOutput.writeBoolean(this.f3565h);
        if (this.f3565h) {
            objectOutput.writeUTF(this.f3566i);
        }
        objectOutput.writeBoolean(this.f3564g);
    }
}
