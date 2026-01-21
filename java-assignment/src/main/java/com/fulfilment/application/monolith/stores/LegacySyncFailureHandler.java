package com.fulfilment.application.monolith.stores;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.jboss.logging.Logger;

@ApplicationScoped
public class LegacySyncFailureHandler {

    private static final Logger LOG = Logger.getLogger(LegacySyncFailureHandler.class);

    void onFailure(@Observes LegacySyncFailedEvent event) {
        Store store = event.getStore();
        Exception cause = event.getCause();

        LOG.warnf(
                "Legacy sync failed for Store[id=%s, name=%s]: %s",
            store.id,
            store.name,
            cause.getMessage()
        );

        //   Email
        //    alertService.send("Legacy sync failed", buildMessage(store, cause));

        //    a retry record
        //    retryRepository.save(new StoreSyncRetry(store.id, cause));

    }
    private String buildMessage(Store store, Exception cause) {
        return String.format(
            "Store %s (id=%s) could not be synced with the legacy system. Reason: %s",
            store.name, store.id, cause.getMessage()
        );
    }
}