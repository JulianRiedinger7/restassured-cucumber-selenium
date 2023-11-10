package models;

public class Character {
  private String name;
  private String height;
  private String mass;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;  
  private String homeworld;
  private String[] films;
  private String[] species;
  private String[] vehicles;
  private String[] starships;
  private String created;
  private String edited;
  private String url;

  public Character() {}


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHeight() {
    return this.height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getMass() {
    return this.mass;
  }

  public void setMass(String mass) {
    this.mass = mass;
  }

  public String getHair_color() {
    return this.hair_color;
  }

  public void setHair_color(String hair_color) {
    this.hair_color = hair_color;
  }

  public String getSkin_color() {
    return this.skin_color;
  }

  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color;
  }

  public String getEye_color() {
    return this.eye_color;
  }

  public void setEye_color(String eye_color) {
    this.eye_color = eye_color;
  }

  public String getBirth_year() {
    return this.birth_year;
  }

  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeworld() {
    return this.homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public String[] getFilms() {
    return this.films;
  }

  public void setFilms(String[] films) {
    this.films = films;
  }

  public String[] getSpecies() {
    return this.species;
  }

  public void setSpecies(String[] species) {
    this.species = species;
  }

  public String[] getVehicles() {
    return this.vehicles;
  }

  public void setVehicles(String[] vehicles) {
    this.vehicles = vehicles;
  }

  public String[] getStarships() {
    return this.starships;
  }

  public void setStarships(String[] starships) {
    this.starships = starships;
  }

  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getEdited() {
    return this.edited;
  }

  public void setEdited(String edited) {
    this.edited = edited;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
