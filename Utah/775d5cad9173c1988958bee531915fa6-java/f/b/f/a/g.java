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
    public boolean H;
    public i I = null;
    public String J = "";
    public int K = 0;
    public String L = "";
    public boolean M;
    public String N = "";
    public boolean O;
    public String P = "";
    public boolean Q;
    public String R = "";
    public boolean S;
    public String T = "";
    public boolean U;
    public String V = "";
    public boolean W = false;
    public List<f> X = new ArrayList();
    public List<f> Y = new ArrayList();
    public boolean Z = false;
    public boolean a0;
    public boolean b;
    public String b0 = "";
    public i c = null;
    public boolean c0 = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3567d;
    public boolean d0 = false;

    /* renamed from: e  reason: collision with root package name */
    public i f3568e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3569f;

    /* renamed from: g  reason: collision with root package name */
    public i f3570g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3571h;

    /* renamed from: i  reason: collision with root package name */
    public i f3572i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3573j;

    /* renamed from: k  reason: collision with root package name */
    public i f3574k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3575l;
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
            this.f3567d = true;
            this.f3568e = iVar2;
        }
        if (objectInput.readBoolean()) {
            i iVar3 = new i();
            iVar3.readExternal(objectInput);
            this.f3569f = true;
            this.f3570g = iVar3;
        }
        if (objectInput.readBoolean()) {
            i iVar4 = new i();
            iVar4.readExternal(objectInput);
            this.f3571h = true;
            this.f3572i = iVar4;
        }
        if (objectInput.readBoolean()) {
            i iVar5 = new i();
            iVar5.readExternal(objectInput);
            this.f3573j = true;
            this.f3574k = iVar5;
        }
        if (objectInput.readBoolean()) {
            i iVar6 = new i();
            iVar6.readExternal(objectInput);
            this.f3575l = true;
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
        objectOutput.writeBoolean(this.f3567d);
        if (this.f3567d) {
            this.f3568e.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3569f);
        if (this.f3569f) {
            this.f3570g.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3571h);
        if (this.f3571h) {
            this.f3572i.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3573j);
        if (this.f3573j) {
            this.f3574k.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f3575l);
        if (this.f3575l) {
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
