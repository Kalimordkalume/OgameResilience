package com.kalume.ogame.domain;

import java.util.ArrayList;

/**
 * Profile
 */
public class Profile {
    private int profileId;
    private String profileName;
    private ArrayList<Planet> planets;

    public Profile(int profileId, String profileName) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.planets = new ArrayList<>(0);
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

}
