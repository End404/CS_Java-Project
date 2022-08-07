
/*
    2.9 Profile 环境切换
 */


package org.javaboy.ioc;

public class DataSource {
    private String url;
    private String username;
    private String passworld;

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", passworld='" + passworld + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }
}
