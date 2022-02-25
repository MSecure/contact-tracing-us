package f.b.c.f;

import f.b.c.j.a;
import f.b.c.j.b;
import f.b.c.j.c;
import f.b.c.j.d;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class s implements d, c {
    public final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> a = new HashMap();
    public Queue<a<?>> b = new ArrayDeque();
    public final Executor c;

    public s(Executor executor) {
        this.c = executor;
    }
}
