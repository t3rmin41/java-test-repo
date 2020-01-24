package com.simple.collection;

import com.simple.message.Indexable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MessageCollection {

    private Instant createdAt = Instant.now();
    private String name;
    private List<Indexable> messages = new ArrayList<>();

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public MessageCollection setName(String name) {
        this.name = name;
        return this;
    }

    public List<Indexable> getMessages() {
        return messages;
    }
}
