package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i implements Externalizable {
    public boolean b;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3833f;
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f3831d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f3832e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public String f3834g = "";

    public int a() {
        return this.f3831d.size();
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
            this.f3831d.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.f3832e.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.f3833f = true;
            this.f3834g = readUTF2;
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
            objectOutput.writeInt(this.f3831d.get(i2).intValue());
        }
        int size = this.f3832e.size();
        objectOutput.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            objectOutput.writeInt(this.f3832e.get(i3).intValue());
        }
        objectOutput.writeBoolean(this.f3833f);
        if (this.f3833f) {
            objectOutput.writeUTF(this.f3834g);
        }
    }
}
