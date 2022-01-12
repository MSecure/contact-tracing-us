package org.matomo.sdk.dispatcher;

import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingDeque;
import org.matomo.sdk.Matomo;
import timber.log.Timber;

public class EventCache {
    public static final String TAG = Matomo.tag(EventCache.class);
    public final EventDiskCache mDiskCache;
    public final LinkedBlockingDeque<Event> mQueue = new LinkedBlockingDeque<>();

    public EventCache(EventDiskCache eventDiskCache) {
        this.mDiskCache = eventDiskCache;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.util.concurrent.LinkedBlockingDeque<org.matomo.sdk.dispatcher.Event> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean updateState(boolean z) {
        ArrayList arrayList;
        if (z) {
            EventDiskCache eventDiskCache = this.mDiskCache;
            synchronized (eventDiskCache) {
                arrayList = new ArrayList();
                if (eventDiskCache.mMaxAge >= 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (!eventDiskCache.mEventContainer.isEmpty()) {
                        File poll = eventDiskCache.mEventContainer.poll();
                        if (poll != null) {
                            arrayList.addAll(eventDiskCache.readEventFile(poll));
                            if (!poll.delete()) {
                                Timber.tag(EventDiskCache.TAG).e("Failed to delete cache container %s", poll.getPath());
                            }
                        }
                    }
                    eventDiskCache.checkCacheLimits();
                    Timber.tag(EventDiskCache.TAG).d("Uncaching of %d events took %dms", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                this.mQueue.offerFirst(listIterator.previous());
            }
            Timber.tag(TAG).d("Switched state to ONLINE, uncached %d events from disk.", Integer.valueOf(arrayList.size()));
        } else if (!this.mQueue.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            this.mQueue.drainTo(arrayList2);
            EventDiskCache eventDiskCache2 = this.mDiskCache;
            synchronized (eventDiskCache2) {
                if (eventDiskCache2.mMaxAge >= 0) {
                    if (!arrayList2.isEmpty()) {
                        eventDiskCache2.checkCacheLimits();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        File writeEventFile = eventDiskCache2.writeEventFile(arrayList2);
                        if (writeEventFile != null) {
                            eventDiskCache2.mEventContainer.add(writeEventFile);
                            eventDiskCache2.mCurrentSize += writeEventFile.length();
                        }
                        Timber.tag(EventDiskCache.TAG).d("Caching of %d events took %dms (%s)", Integer.valueOf(arrayList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), writeEventFile);
                    }
                }
            }
            Timber.tag(TAG).d("Switched state to OFFLINE, caching %d events to disk.", Integer.valueOf(arrayList2.size()));
        }
        return z && !this.mQueue.isEmpty();
    }
}
