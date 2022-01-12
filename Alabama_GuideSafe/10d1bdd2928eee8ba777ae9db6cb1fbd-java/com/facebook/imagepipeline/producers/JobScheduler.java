package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    public final Runnable mDoJobRunnable = new Runnable() {
        /* class com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass1 */

        public void run() {
            EncodedImage encodedImage;
            int i;
            JobScheduler jobScheduler = JobScheduler.this;
            if (jobScheduler != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                synchronized (jobScheduler) {
                    encodedImage = jobScheduler.mEncodedImage;
                    i = jobScheduler.mStatus;
                    jobScheduler.mEncodedImage = null;
                    jobScheduler.mStatus = 0;
                    jobScheduler.mJobState = JobState.RUNNING;
                    jobScheduler.mJobStartTime = uptimeMillis;
                }
                try {
                    if (JobScheduler.shouldProcess(encodedImage, i)) {
                        jobScheduler.mJobRunnable.run(encodedImage, i);
                    }
                } finally {
                    EncodedImage.closeSafely(encodedImage);
                    jobScheduler.onJobFinished();
                }
            } else {
                throw null;
            }
        }
    };
    public EncodedImage mEncodedImage = null;
    public final Executor mExecutor;
    public final JobRunnable mJobRunnable;
    public long mJobStartTime = 0;
    public JobState mJobState = JobState.IDLE;
    public long mJobSubmitTime = 0;
    public final int mMinimumJobIntervalMs;
    public int mStatus = 0;
    public final Runnable mSubmitJobRunnable = new Runnable() {
        /* class com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass2 */

        public void run() {
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.mExecutor.execute(jobScheduler.mDoJobRunnable);
        }
    };

    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
    }

    public static boolean shouldProcess(EncodedImage encodedImage, int i) {
        return BaseConsumer.isLast(i) || BaseConsumer.statusHasFlag(i, 4) || EncodedImage.isValid(encodedImage);
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public final void enqueueJob(long j) {
        if (j > 0) {
            if (AppCompatDelegateImpl.ConfigurationImplApi17.sJobStarterExecutor == null) {
                AppCompatDelegateImpl.ConfigurationImplApi17.sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.sJobStarterExecutor.schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
            return;
        }
        this.mSubmitJobRunnable.run();
    }

    public final void onJobFinished() {
        boolean z;
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                z = true;
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
                j = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(j - uptimeMillis);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r3 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        enqueueJob(r5 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        return true;
     */
    public boolean scheduleJob() {
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (!shouldProcess(this.mEncodedImage, this.mStatus)) {
                return false;
            }
            int ordinal = this.mJobState.ordinal();
            if (ordinal != 0) {
                if (ordinal == 2) {
                    this.mJobState = JobState.RUNNING_AND_PENDING;
                }
                j = 0;
            } else {
                j = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
                z = true;
            }
        }
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        EncodedImage encodedImage2;
        if (!shouldProcess(encodedImage, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.mEncodedImage;
            this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = i;
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }
}
