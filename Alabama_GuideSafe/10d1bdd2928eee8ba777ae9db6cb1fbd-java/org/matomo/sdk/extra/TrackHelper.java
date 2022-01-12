package org.matomo.sdk.extra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.matomo.sdk.Matomo;
import org.matomo.sdk.QueryParams;
import org.matomo.sdk.TrackMe;
import org.matomo.sdk.Tracker;
import org.matomo.sdk.dispatcher.DefaultDispatcher;
import timber.log.Timber;

public class TrackHelper {
    public final TrackMe mBaseTrackMe = new TrackMe();

    public static abstract class BaseEvent {
        public final TrackHelper mBaseBuilder;

        public BaseEvent(TrackHelper trackHelper) {
            this.mBaseBuilder = trackHelper;
        }

        public abstract TrackMe build();

        public void with(Tracker tracker) {
            TrackMe build = build();
            synchronized (tracker.mTrackingLock) {
                if (System.currentTimeMillis() - tracker.mSessionStartTime > tracker.mSessionTimeout) {
                    tracker.mSessionStartTime = System.currentTimeMillis();
                    tracker.injectInitialParams(build);
                }
                tracker.injectBaseParams(build);
                Iterator<Tracker.Callback> it = tracker.mTrackingCallbacks.iterator();
                while (it.hasNext()) {
                    Tracker.Callback next = it.next();
                    build = next.onTrack(build);
                    if (build == null) {
                        Timber.tag(Tracker.TAG).d("Tracking aborted by %s", next);
                        return;
                    }
                }
                tracker.mLastEvent = build;
                if (!tracker.mOptOut) {
                    ((DefaultDispatcher) tracker.mDispatcher).submit(build);
                    Timber.tag(Tracker.TAG).d("Event added to the queue: %s", build);
                } else {
                    Timber.tag(Tracker.TAG).d("Event omitted due to opt out: %s", build);
                }
            }
        }
    }

    public static class EventBuilder extends BaseEvent {
        public final String mAction;
        public final String mCategory;
        public String mName;
        public Float mValue;

        public EventBuilder(TrackHelper trackHelper, String str, String str2) {
            super(trackHelper);
            this.mCategory = str;
            this.mAction = str2;
        }

        @Override // org.matomo.sdk.extra.TrackHelper.BaseEvent
        public TrackMe build() {
            TrackMe trackMe = new TrackMe(this.mBaseBuilder.mBaseTrackMe);
            trackMe.set(QueryParams.URL_PATH, (String) null);
            trackMe.set(QueryParams.EVENT_CATEGORY, this.mCategory);
            trackMe.set(QueryParams.EVENT_ACTION, this.mAction);
            trackMe.set(QueryParams.EVENT_NAME, this.mName);
            Float f = this.mValue;
            if (f != null) {
                QueryParams queryParams = QueryParams.EVENT_VALUE;
                float floatValue = f.floatValue();
                synchronized (trackMe) {
                    trackMe.set(queryParams, Float.toString(floatValue));
                }
            }
            return trackMe;
        }
    }

    public static class Screen extends BaseEvent {
        public final Map<Integer, String> mCustomDimensions = new HashMap();
        public final CustomVariables mCustomVariables = new CustomVariables();
        public final String mPath;
        public String mTitle;

        public Screen(TrackHelper trackHelper, String str) {
            super(trackHelper);
            this.mPath = str;
        }

        @Override // org.matomo.sdk.extra.TrackHelper.BaseEvent
        public TrackMe build() {
            if (this.mPath != null) {
                TrackMe trackMe = new TrackMe(this.mBaseBuilder.mBaseTrackMe);
                trackMe.set(QueryParams.URL_PATH, this.mPath);
                trackMe.set(QueryParams.ACTION_NAME, this.mTitle);
                trackMe.set(QueryParams.CAMPAIGN_NAME, (String) null);
                trackMe.set(QueryParams.CAMPAIGN_KEYWORD, (String) null);
                if (this.mCustomVariables.mVars.size() > 0) {
                    trackMe.set(QueryParams.SCREEN_SCOPE_CUSTOM_VARIABLES, this.mCustomVariables.toString());
                }
                for (Map.Entry<Integer, String> entry : this.mCustomDimensions.entrySet()) {
                    CustomDimension.setDimension(trackMe, entry.getKey().intValue(), entry.getValue());
                }
                return trackMe;
            }
            throw new IllegalArgumentException("Screen tracking requires a non-empty path");
        }
    }

    static {
        Matomo.tag(TrackHelper.class);
    }
}
