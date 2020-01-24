package com.simple.message;

import java.time.Instant;

public class SimpleMessage implements Indexable {

    private Long id;
    private Instant timestamp = Instant.now();
    private String message;

    @Override
    public Long getId() {
        return this.id;
    }

    public SimpleMessage setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public SimpleMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
