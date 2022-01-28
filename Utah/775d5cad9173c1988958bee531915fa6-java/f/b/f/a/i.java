package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class i implements Externalizable {
    public boolean b;
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f3576d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f3577e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f3578f;

    /* renamed from: g  reason: collision with root package name */
    public String f3579g = "";

    public int a() {
        return this.f3576d.size();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.b = true;
            this.c = readUTF;
        }
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3576d.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.f3577e.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3578f = true;
            this.f3579g = readUTF2;
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.b);
        if (this.b) {
            objectOutput.writeUTF(this.c);
        }
        int a = a();
        objectOutput.writeInt(a);
        for (int i2 = 0; i2 < a; i2++) {
            objectOutput.writeInt(this.f3576d.get(i2).intValue());
        }
        int size = this.f3577e.size();
        objectOutput.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            objectOutput.writeInt(this.f3577e.get(i3).intValue());
        }
        objectOutput.writeBoolean(this.f3578f);
        if (this.f3578f) {
            objectOutput.writeUTF(this.f3579g);
        }
    }
}
