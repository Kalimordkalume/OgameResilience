package com.kalume.ogame.domain;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID id;
    private String userName;
    private String email;

    private ArrayList<Profile> profiles;

    public User(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public void addProfile(Profile profile) {
        if (profiles == null) {
            profiles = new ArrayList<>();
        }
        profiles.add(profile);
    }

    public void removeProfile(Profile profile) {
        if (profiles != null) {
            profiles.remove(profile);
        }
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
