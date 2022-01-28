package c.b.a.b.h0;

public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public float f4260a = -1.0f;

    @Override // c.b.a.b.h0.d
    public void a(m mVar, float f2, float f3, float f4) {
        mVar.e(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = (double) f4;
        double d3 = (double) f3;
        mVar.d((float) (Math.sin(Math.toRadians((double) f2)) * d2 * d3), (float) (Math.sin(Math.toRadians((double) (90.0f - f2))) * d2 * d3));
    }
}
