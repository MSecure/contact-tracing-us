package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult> {
    public static final Executor IMMEDIATE_EXECUTOR;
    public static Task<Boolean> TASK_FALSE = new Task<>(Boolean.FALSE);
    public static Task<?> TASK_NULL = new Task<>((Object) null);
    public static Task<Boolean> TASK_TRUE = new Task<>(Boolean.TRUE);
    public boolean cancelled;
    public boolean complete;
    public List<Continuation<TResult, Void>> continuations = new ArrayList();
    public Exception error;
    public boolean errorHasBeenObserved;
    public final Object lock = new Object();
    public TResult result;
    public UnobservedErrorNotifier unobservedErrorNotifier;

    static {
        BoltsExecutors boltsExecutors = BoltsExecutors.INSTANCE;
        ExecutorService executorService = boltsExecutors.background;
        IMMEDIATE_EXECUTOR = boltsExecutors.immediate;
        Executor executor = AndroidExecutors.INSTANCE.uiThread;
        new Task(true);
    }

    public Task() {
    }

    public static <TResult> Task<TResult> call(final Callable<TResult> callable, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                /* class bolts.Task.AnonymousClass4 */
                public final /* synthetic */ CancellationToken val$ct = null;

                /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: bolts.TaskCompletionSource */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    try {
                        TaskCompletionSource.this.setResult(callable.call());
                    } catch (CancellationException unused) {
                        TaskCompletionSource.this.setCancelled();
                    } catch (Exception e) {
                        TaskCompletionSource.this.setError(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setError(new ExecutorException(e));
        }
        return taskCompletionSource.task;
    }

    public static <TResult> Task<TResult> forError(Exception exc) {
        boolean z;
        Task<TResult> task = new Task<>();
        synchronized (task.lock) {
            z = false;
            if (!task.complete) {
                task.complete = true;
                task.error = exc;
                task.errorHasBeenObserved = false;
                task.lock.notifyAll();
                task.runContinuations();
                z = true;
            }
        }
        if (z) {
            return task;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        if (tresult == null) {
            return (Task<TResult>) TASK_NULL;
        }
        if (tresult instanceof Boolean) {
            return tresult.booleanValue() ? (Task<TResult>) TASK_TRUE : (Task<TResult>) TASK_FALSE;
        }
        Task<TResult> task = new Task<>();
        if (task.trySetResult(tresult)) {
            return task;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    /* JADX DEBUG: Type inference failed for r7v3. Raw type applied. Possible types: bolts.Task<TResult>, bolts.Task<TContinuationResult> */
    public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        boolean z;
        final Executor executor = IMMEDIATE_EXECUTOR;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            synchronized (this.lock) {
                z = this.complete;
            }
            if (!z) {
                this.continuations.add(new Continuation<TResult, Void>(this) {
                    /* class bolts.Task.AnonymousClass10 */
                    public final /* synthetic */ CancellationToken val$ct = null;

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // bolts.Continuation
                    public Void then(Task task) throws Exception {
                        TaskCompletionSource taskCompletionSource = taskCompletionSource;
                        Continuation continuation = continuation;
                        try {
                            executor.execute(new Runnable(continuation, task) {
                                /* class bolts.Task.AnonymousClass14 */
                                public final /* synthetic */ CancellationToken val$ct = null;

                                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.TaskCompletionSource */
                                /* JADX WARN: Multi-variable type inference failed */
                                public void run() {
                                    try {
                                        TaskCompletionSource.this.setResult(continuation.then(this));
                                    } catch (CancellationException unused) {
                                        TaskCompletionSource.this.setCancelled();
                                    } catch (Exception e) {
                                        TaskCompletionSource.this.setError(e);
                                    }
                                }
                            });
                            return null;
                        } catch (Exception e) {
                            taskCompletionSource.setError(new ExecutorException(e));
                            return null;
                        }
                    }
                });
            }
        }
        if (z) {
            try {
                executor.execute(new Runnable() {
                    /* class bolts.Task.AnonymousClass14 */
                    public final /* synthetic */ CancellationToken val$ct = null;

                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.TaskCompletionSource */
                    /* JADX WARN: Multi-variable type inference failed */
                    public void run() {
                        try {
                            TaskCompletionSource.this.setResult(continuation.then(this));
                        } catch (CancellationException unused) {
                            TaskCompletionSource.this.setCancelled();
                        } catch (Exception e) {
                            TaskCompletionSource.this.setError(e);
                        }
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }
        return (Task<TResult>) taskCompletionSource.task;
    }

    public Exception getError() {
        Exception exc;
        synchronized (this.lock) {
            if (this.error != null) {
                this.errorHasBeenObserved = true;
                if (this.unobservedErrorNotifier != null) {
                    this.unobservedErrorNotifier.task = null;
                    this.unobservedErrorNotifier = null;
                }
            }
            exc = this.error;
        }
        return exc;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.lock) {
            z = getError() != null;
        }
        return z;
    }

    public final void runContinuations() {
        synchronized (this.lock) {
            for (Continuation<TResult, Void> continuation : this.continuations) {
                try {
                    continuation.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.continuations = null;
        }
    }

    public boolean trySetCancelled() {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.cancelled = true;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public boolean trySetResult(TResult tresult) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.result = tresult;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public Task(TResult tresult) {
        trySetResult(tresult);
    }

    public Task(boolean z) {
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }
}
