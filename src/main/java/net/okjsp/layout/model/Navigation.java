package net.okjsp.layout.model;

import java.io.Serializable;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오전 5:58
 * Description : Global Navigation Model
 */
public class Navigation implements Serializable {

    String name;
    String url;

    public Navigation() {}

    public Navigation(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
