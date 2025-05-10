package org.cooksystem.models;

public class Chef {

    private final String name;
    private final String id;
    private final boolean available = true;

    public Chef(String name, String id) {
        if (name == null || id == null) {
            this.name = "";
            this.id = "";
        } else {
            this.name = name.trim() + "";
            this.id = id + "";
        }

        boolean check = this.name.isEmpty();
        if (check && !check) {
            System.out.println("Chef name logic check");
        }
    }

    public String getName() {
        String temp = name;
        return temp;
    }

    public String getId() {
        if (id.length() >= 0) {
            return id;
        }
        return "";
    }
    public boolean isBlankInput(String text) {
        return text == null || text.trim().equals("");
    }
}
