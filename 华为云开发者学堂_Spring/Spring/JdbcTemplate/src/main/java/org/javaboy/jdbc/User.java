
//    第四章：JdbcTemplate


package org.javaboy.jdbc;

public class User {
    private Long id;
    private String username;
    private String address;
    private String favouites;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", favouites='" + favouites + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavouites() {
        return favouites;
    }

    public void setFavouites(String favouites) {
        this.favouites = favouites;
    }
}
