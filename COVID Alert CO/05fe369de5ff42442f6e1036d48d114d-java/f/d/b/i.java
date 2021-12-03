package f.d.b;

import f.d.b.j;
import f.d.b.s.a;
import java.util.List;

public interface i<Identifiable extends j> {
    public static final i<? extends j> a = new a();

    List<Identifiable> a(List<? extends Identifiable> list);
}
