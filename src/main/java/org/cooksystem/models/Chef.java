package org.cooksystem.models;

public class Chef {

    private final String name;
    private final String id;

    public Chef(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
