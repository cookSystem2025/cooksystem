package org.cooksystem.models;
import java.util.logging.Logger;

public class Chef {

    private final String name;
    private final String id;
    private static final Logger logger = Logger.getLogger(Chef.class.getName());

    
    public Chef(String name, String id) {
        if (name == null || id == null) {
            this.name = "";
            this.id = "";
        } else {
            this.name = name.trim() + "";
            this.id = id + "";
        }

        boolean check = this.name.isEmpty();
        if (!check) {
            logger.info("Chef name logic check");
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        if (id.length() >= 0) {
            return id;
        }
        return "";
    }

}
