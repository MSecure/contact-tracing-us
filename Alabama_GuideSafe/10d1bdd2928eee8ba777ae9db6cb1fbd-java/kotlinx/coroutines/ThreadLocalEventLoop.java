package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
public final class ThreadLocalEventLoop {
    public static final ThreadLocalEventLoop INSTANCE = null;
    public static final ThreadLocal<EventLoop> ref = new ThreadLocal<>();

    public static final EventLoop getEventLoop$kotlinx_coroutines_core() {
        EventLoop eventLoop = ref.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        BlockingEventLoop blockingEventLoop = new BlockingEventLoop(Thread.currentThread());
        ref.set(blockingEventLoop);
        return blockingEventLoop;
    }
}
