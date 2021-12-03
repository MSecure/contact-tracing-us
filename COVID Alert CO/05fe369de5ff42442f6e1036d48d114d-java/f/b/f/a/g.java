package f.b.f.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class g implements Externalizable {
    public i A = null;
    public boolean B;
    public i C = null;
    public boolean D;
    public i E = null;
    public boolean F;
    public i G = null;
    public String H = "";
    public int I = 0;
    public String J = "";
    public boolean K;
    public String L = "";
    public boolean M;
    public String N = "";
    public boolean O;
    public String P = "";
    public boolean Q;
    public String R = "";
    public boolean S;
    public String T = "";
    public boolean U = false;
    public List<f> V = new ArrayList();
    public List<f> W = new ArrayList();
    public boolean X = false;
    public boolean Y;
    public String Z = "";
    public boolean a0 = false;
    public boolean b;
    public boolean b0 = false;
    public i c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3502d;

    /* renamed from: e  reason: collision with root package name */
    public i f3503e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3504f;

    /* renamed from: g  reason: collision with root package name */
    public i f3505g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3506h;

    /* renamed from: i  reason: collision with root package name */
    public i f3507i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3508j;

    /* renamed from: k  reason: collision with root package name */
    public i f3509k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3510l;
    public i m = null;
    public boolean n;
    public i o = null;
    public boolean p;
    public i q = null;
    public boolean r;
    public i s = null;
    public boolean t;
    public i u = null;
    public boolean v;
    public i w = null;
    public boolean x;
    public i y = null;
    public boolean z;

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
            this.f3502d = true;
            this.f3503e = iVar2;
        }
        if (objectInput.readBoolean()) {
            i iVar3 = new i();
            iVar3.readExternal(objectInput);
            this.f3504f = true;
            this.f3505g = iVar3;
        }
        if (objectInput.readBoolean()) {
            i iVar4 = new i();
            iVar4.readExternal(objectInput);
            this.f3506h = true;
            this.f3507i = iVar4;
        }
        if (objectInput.readBoolean()) {
            i iVar5 = new i();
            iVar5.readExternal(objectInput);
            this.f3508j = true;
            this.f3509k = iVar5;
        }
        if (objectInput.readBoolean()) {
            i iVar6 = new i();
            iVar6.readExternal(objectInput);
            this.f3510l = true;
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
        this.H = objectInput.readUTF();
        this.I = objectInput.readInt();
        this.J = objectInput.readUTF();
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.K = true;
            this.L = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.M = true;
            this.N = readUTF2;
        }
        if (objectInput.readBoolean()) {
            String readUTF3 = objectInput.readUTF();
            this.O = true;
            this.P = readUTF3;
        }
        if (objectInput.readBoolean()) {
            String readUTF4 = objectInput.readUTF();
            this.Q = true;
            this.R = readUTF4;
        }
        if (objectInput.readBoolean()) {
            String readUTF5 = objectInput.readUTF();
            this.S = true;
            this.T = readUTF5;
        }
        this.U = objectInput.readBoolean();
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            f fVar = new f();
            fVar.readExternal(objectInput);
            this.V.add(fVar);
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            f fVar2 = new f();
            fVar2.readExternal(objectInput);
            this.W.add(fVar2);
        }
        this.X = objectInput.readBoolean();
        if (objectInput.readBoolean()) {
            String readUTF6 = objectInput.readUTF();
            this.Y = true;
            this.Z = readUTF6;
        }
        this.a0 = objectInput.readBoolean();
        this.b0 = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.b);
        if (this.b) {
            this.c.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3502d);
        if (this.f3502d) {
            this.f3503e.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3504f);
        if (this.f3504f) {
            this.f3505g.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3506h);
        if (this.f3506h) {
            this.f3507i.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3508j);
        if (this.f3508j) {
            this.f3509k.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3510l);
        if (this.f3510l) {
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
        objectOutput.writeUTF(this.H);
        objectOutput.writeInt(this.I);
        objectOutput.writeUTF(this.J);
        objectOutput.writeBoolean(this.K);
        if (this.K) {
            objectOutput.writeUTF(this.L);
        }
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
        int size = this.V.size();
        objectOutput.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.V.get(i2).writeExternal(objectOutput);
        }
        int size2 = this.W.size();
        objectOutput.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.W.get(i3).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.X);
        objectOutput.writeBoolean(this.Y);
        if (this.Y) {
            objectOutput.writeUTF(this.Z);
        }
        objectOutput.writeBoolean(this.a0);
        objectOutput.writeBoolean(this.b0);
    }
}
