package com.facebook.jni;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

public class DestructorThread {
    public static final DestructorList sDestructorList = new DestructorList();
    public static final DestructorStack sDestructorStack = new DestructorStack();
    public static final ReferenceQueue sReferenceQueue = new ReferenceQueue();
    public static final Thread sThread;

    public static abstract class Destructor extends PhantomReference<Object> {
        public Destructor next;
        public Destructor previous;

        public abstract void destruct();

        public Destructor(Object obj) {
            super(obj, DestructorThread.sReferenceQueue);
            DestructorThread.sDestructorStack.push(this);
        }

        public Destructor() {
            super(null, DestructorThread.sReferenceQueue);
        }
    }

    public static class DestructorList {
        public final Destructor mHead;

        public DestructorList() {
            Terminus terminus = new Terminus();
            this.mHead = terminus;
            terminus.next = new Terminus();
            this.mHead.next.previous = this.mHead;
        }

        public static void drop(Destructor destructor) {
            destructor.next.previous = destructor.previous;
            destructor.previous.next = destructor.next;
        }

        public void enqueue(Destructor destructor) {
            destructor.next = this.mHead.next;
            this.mHead.next = destructor;
            destructor.next.previous = destructor;
            destructor.previous = this.mHead;
        }
    }

    public static class DestructorStack {
        public final AtomicReference<Destructor> mHead;

        public DestructorStack() {
            this.mHead = new AtomicReference<>();
        }

        public void push(Destructor destructor) {
            Destructor destructor2;
            do {
                destructor2 = this.mHead.get();
                destructor.next = destructor2;
            } while (!this.mHead.compareAndSet(destructor2, destructor));
        }

        public void transferAllToList() {
            Destructor andSet = this.mHead.getAndSet(null);
            while (andSet != null) {
                Destructor destructor = andSet.next;
                DestructorThread.sDestructorList.enqueue(andSet);
                andSet = destructor;
            }
        }
    }

    public static class Terminus extends Destructor {
        public Terminus() {
            super();
        }

        @Override // com.facebook.jni.DestructorThread.Destructor
        public void destruct() {
            throw new IllegalStateException("Cannot destroy Terminus Destructor.");
        }
    }

    static {
        AnonymousClass1 r0 = new Thread("HybridData DestructorThread") {
            /* class com.facebook.jni.DestructorThread.AnonymousClass1 */

            /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:3|5)(1:6)|4) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
            /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:4:0x001a, LOOP_START, SYNTHETIC, Splitter:B:0:0x0000] */
            public void run() {
                while (true) {
                    Destructor destructor = (Destructor) DestructorThread.sReferenceQueue.remove();
                    destructor.destruct();
                    if (destructor.previous == null) {
                        DestructorThread.sDestructorStack.transferAllToList();
                    }
                    DestructorList.drop(destructor);
                }
            }
        };
        sThread = r0;
        r0.start();
    }
}
