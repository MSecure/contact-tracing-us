package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class h implements Externalizable {
    public List<g> b = new ArrayList();

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            g gVar = new g();
            gVar.readExternal(objectInput);
            this.b.add(gVar);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        int size = this.b.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.b.get(i2).writeExternal(objectOutput);
        }
    }
}
