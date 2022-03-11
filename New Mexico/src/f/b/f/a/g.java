package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements Externalizable {
    public boolean B;
    public boolean D;
    public boolean F;
    public boolean H;
    public boolean M;
    public boolean O;
    public boolean Q;
    public boolean S;
    public boolean U;
    public boolean a0;
    public boolean b;

    /* renamed from: d */
    public boolean f3822d;

    /* renamed from: f */
    public boolean f3824f;

    /* renamed from: h */
    public boolean f3826h;

    /* renamed from: j */
    public boolean f3828j;

    /* renamed from: l */
    public boolean f3830l;
    public boolean n;
    public boolean p;
    public boolean r;
    public boolean t;
    public boolean v;
    public boolean x;
    public boolean z;
    public i c = null;

    /* renamed from: e */
    public i f3823e = null;

    /* renamed from: g */
    public i f3825g = null;

    /* renamed from: i */
    public i f3827i = null;

    /* renamed from: k */
    public i f3829k = null;
    public i m = null;
    public i o = null;
    public i q = null;
    public i s = null;
    public i u = null;
    public i w = null;
    public i y = null;
    public i A = null;
    public i C = null;
    public i E = null;
    public i G = null;
    public i I = null;
    public String J = "";
    public int K = 0;
    public String L = "";
    public String N = "";
    public String P = "";
    public String R = "";
    public String T = "";
    public String V = "";
    public boolean W = false;
    public List<f> X = new ArrayList();
    public List<f> Y = new ArrayList();
    public boolean Z = false;
    public String b0 = "";
    public boolean c0 = false;
    public boolean d0 = false;

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            i iVar = new i();
            iVar.readExternal(objectInput);
            this.b = true;
            this.c = iVar;
        }
        if (objectInput.readBoolean()) {
            i iVar2 = new i();
            iVar2.readExternal(objectInput);
            this.f3822d = true;
            this.f3823e = iVar2;
        }
        if (objectInput.readBoolean()) {
            i iVar3 = new i();
            iVar3.readExternal(objectInput);
            this.f3824f = true;
            this.f3825g = iVar3;
        }
        if (objectInput.readBoolean()) {
            i iVar4 = new i();
            iVar4.readExternal(objectInput);
            this.f3826h = true;
            this.f3827i = iVar4;
        }
        if (objectInput.readBoolean()) {
            i iVar5 = new i();
            iVar5.readExternal(objectInput);
            this.f3828j = true;
            this.f3829k = iVar5;
        }
        if (objectInput.readBoolean()) {
            i iVar6 = new i();
            iVar6.readExternal(objectInput);
            this.f3830l = true;
            this.m = iVar6;
        }
        if (objectInput.readBoolean()) {
            i iVar7 = new i();
            iVar7.readExternal(objectInput);
            this.n = true;
            this.o = iVar7;
        }
        if (objectInput.readBoolean()) {
            i iVar8 = new i();
            iVar8.readExternal(objectInput);
            this.p = true;
            this.q = iVar8;
        }
        if (objectInput.readBoolean()) {
            i iVar9 = new i();
            iVar9.readExternal(objectInput);
            this.r = true;
            this.s = iVar9;
        }
        if (objectInput.readBoolean()) {
            i iVar10 = new i();
            iVar10.readExternal(objectInput);
            this.t = true;
            this.u = iVar10;
        }
        if (objectInput.readBoolean()) {
            i iVar11 = new i();
            iVar11.readExternal(objectInput);
            this.v = true;
            this.w = iVar11;
        }
        if (objectInput.readBoolean()) {
            i iVar12 = new i();
            iVar12.readExternal(objectInput);
            this.x = true;
            this.y = iVar12;
        }
        if (objectInput.readBoolean()) {
            i iVar13 = new i();
            iVar13.readExternal(objectInput);
            this.z = true;
            this.A = iVar13;
        }
        if (objectInput.readBoolean()) {
            i iVar14 = new i();
            iVar14.readExternal(objectInput);
            this.B = true;
            this.C = iVar14;
        }
        if (objectInput.readBoolean()) {
            i iVar15 = new i();
            iVar15.readExternal(objectInput);
            this.D = true;
            this.E = iVar15;
        }
        if (objectInput.readBoolean()) {
            i iVar16 = new i();
            iVar16.readExternal(objectInput);
            this.F = true;
            this.G = iVar16;
        }
        if (objectInput.readBoolean()) {
            i iVar17 = new i();
            iVar17.readExternal(objectInput);
            this.H = true;
            this.I = iVar17;
        }
        this.J = objectInput.readUTF();
        this.K = objectInput.readInt();
        this.L = objectInput.readUTF();
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.M = true;
            this.N = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.O = true;
            this.P = readUTF2;
        }
        if (objectInput.readBoolean()) {
            String readUTF3 = objectInput.readUTF();
            this.Q = true;
            this.R = readUTF3;
        }
        if (objectInput.readBoolean()) {
            String readUTF4 = objectInput.readUTF();
            this.S = true;
            this.T = readUTF4;
        }
        if (objectInput.readBoolean()) {
            String readUTF5 = objectInput.readUTF();
            this.U = true;
            this.V = readUTF5;
        }
        this.W = objectInput.readBoolean();
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            f fVar = new f();
            fVar.readExternal(objectInput);
            this.X.add(fVar);
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            f fVar2 = new f();
            fVar2.readExternal(objectInput);
            this.Y.add(fVar2);
        }
        this.Z = objectInput.readBoolean();
        if (objectInput.readBoolean()) {
            String readUTF6 = objectInput.readUTF();
            this.a0 = true;
            this.b0 = readUTF6;
        }
        this.c0 = objectInput.readBoolean();
        this.d0 = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.b);
        if (this.b) {
            this.c.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3822d);
        if (this.f3822d) {
            this.f3823e.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3824f);
        if (this.f3824f) {
            this.f3825g.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3826h);
        if (this.f3826h) {
            this.f3827i.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3828j);
        if (this.f3828j) {
            this.f3829k.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3830l);
        if (this.f3830l) {
            this.m.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.n);
        if (this.n) {
            this.o.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.p);
        if (this.p) {
            this.q.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.r);
        if (this.r) {
            this.s.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.t);
        if (this.t) {
            this.u.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.v);
        if (this.v) {
            this.w.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.x);
        if (this.x) {
            this.y.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.z);
        if (this.z) {
            this.A.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.B);
        if (this.B) {
            this.C.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.D);
        if (this.D) {
            this.E.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.F);
        if (this.F) {
            this.G.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.H);
        if (this.H) {
            this.I.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.J);
        objectOutput.writeInt(this.K);
        objectOutput.writeUTF(this.L);
        objectOutput.writeBoolean(this.M);
        if (this.M) {
            objectOutput.writeUTF(this.N);
        }
        objectOutput.writeBoolean(this.O);
        if (this.O) {
            objectOutput.writeUTF(this.P);
        }
        objectOutput.writeBoolean(this.Q);
        if (this.Q) {
            objectOutput.writeUTF(this.R);
        }
        objectOutput.writeBoolean(this.S);
        if (this.S) {
            objectOutput.writeUTF(this.T);
        }
        objectOutput.writeBoolean(this.U);
        if (this.U) {
            objectOutput.writeUTF(this.V);
        }
        objectOutput.writeBoolean(this.W);
        int size = this.X.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.X.get(i2).writeExternal(objectOutput);
        }
        int size2 = this.Y.size();
        objectOutput.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.Y.get(i3).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.Z);
        objectOutput.writeBoolean(this.a0);
        if (this.a0) {
            objectOutput.writeUTF(this.b0);
        }
        objectOutput.writeBoolean(this.c0);
        objectOutput.writeBoolean(this.d0);
    }
}
