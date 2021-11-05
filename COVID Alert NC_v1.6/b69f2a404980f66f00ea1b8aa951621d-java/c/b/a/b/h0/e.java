package c.b.a.b.h0;

public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public float f2981a = -1.0f;

    @Override // c.b.a.b.h0.d
    public void a(m mVar, float f, float f2, float f3) {
        mVar.e(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d2 = (double) f3;
        double d3 = (double) f2;
        mVar.d((float) (Math.sin(Math.toRadians((double) f)) * d2 * d3), (float) (Math.sin(Math.toRadians((double) (90.0f - f))) * d2 * d3));
    }
}
