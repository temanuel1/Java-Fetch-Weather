public class Observation {
  public String location, weather, timeStamp;
  public double temperature, relHum;

  public Observation(String location, String weather, String timeStamp, double temperature) {
    this.location = location;
    this.weather = weather;
    this.timeStamp = timeStamp;
    this.temperature = temperature;
  }

  public Observation(double temperature, String weather, double relHum) {
    this.temperature = temperature;
    this.weather = weather;
    this.relHum = relHum;
  }

  public Observation(double temperature, String location) {
    this.temperature = temperature;
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public String getWeather() {
    return weather;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public double getTemperature() {
    return temperature;
  }

  public boolean colderThan(Observation ob2) {
    return this.temperature < ob2.temperature;
  }

  public String toString() {
   /*return "\nOn " + timeStamp + ", in " + location + ", the temperature was " + temperature + " °F and the weather was " + weather + ".";*/
   return "Temp: " + temperature + " °F. Location: " + location + ".";
   /*
   return "Temp: " + temperature + " °F. Weather: " + weather + ". Relative Humidity: " + relHum + "%";
   */
  }
}