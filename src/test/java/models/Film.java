package models;

public class Film {
  private String title;
  private String episode_id;
  private String opening_crawl;
  private String director;
  private String producer;
  private String release_date;
  private String[] characters;
  private String[] planets;
  private String[] starships;
  private String[] vehicles;
  private String[] species;
  private String created;
  private String edited;
  private String url;

  public Film() {}


  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getEpisode_id() {
    return this.episode_id;
  }

  public void setEpisode_id(String episode_id) {
    this.episode_id = episode_id;
  }

  public String getOpening_crawl() {
    return this.opening_crawl;
  }

  public void setOpening_crawl(String opening_crawl) {
    this.opening_crawl = opening_crawl;
  }

  public String getDirector() {
    return this.director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getProducer() {
    return this.producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public String getRelease_date() {
    return this.release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String[] getCharacters() {
    return this.characters;
  }

  public void setCharacters(String[] characters) {
    this.characters = characters;
  }

  public String[] getPlanets() {
    return this.planets;
  }

  public void setPlanets(String[] planets) {
    this.planets = planets;
  }

  public String[] getStarships() {
    return this.starships;
  }

  public void setStarships(String[] starships) {
    this.starships = starships;
  }

  public String[] getVehicles() {
    return this.vehicles;
  }

  public void setVehicles(String[] vehicles) {
    this.vehicles = vehicles;
  }

  public String[] getSpecies() {
    return this.species;
  }

  public void setSpecies(String[] species) {
    this.species = species;
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
