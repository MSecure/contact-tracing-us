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
    public boolean f3511d;

    /* renamed from: e  reason: collision with root package name */
    public String f3512e = "";

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f3513f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f3514g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public boolean f3515h;

    /* renamed from: i  reason: collision with root package name */
    public String f3516i = "";

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.b = true;
            this.c = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3511d = true;
            this.f3512e = readUTF2;
        }
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3513f.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.f3514g.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            String readUTF3 = objectInput.readUTF();
            this.f3515h = true;
            this.f3516i = readUTF3;
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.b);
        if (this.b) {
            objectOutput.writeUTF(this.c);
        }
        objectOutput.writeBoolean(this.f3511d);
        if (this.f3511d) {
            objectOutput.writeUTF(this.f3512e);
        }
        int size = this.f3513f.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            objectOutput.writeInt(this.f3513f.get(i2).intValue());
        }
        int size2 = this.f3514g.size();
        objectOutput.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            objectOutput.writeInt(this.f3514g.get(i3).intValue());
        }
        objectOutput.writeBoolean(this.f3515h);
        if (this.f3515h) {
            objectOutput.writeUTF(this.f3516i);
        }
    }
}
