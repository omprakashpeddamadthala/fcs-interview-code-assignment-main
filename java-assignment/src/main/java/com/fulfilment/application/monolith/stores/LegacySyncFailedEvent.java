package com.fulfilment.application.monolith.stores;

public class LegacySyncFailedEvent {
    private final Store store;
    private final Exception cause;

    public LegacySyncFailedEvent(Store store, Exception cause) {
        this.store = store;
        this.cause = cause;
    }

    public Store getStore() {
        return store;
    }

    public Exception getCause() {
        return cause;
    }
}
