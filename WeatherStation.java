import core.data.*;
public class WeatherStation {
  public String name, id, state;
  public double latitude, longitude;

  WeatherStation(String name, String id, String state, double latitude, double longitude) {
    this.name = name;
    this.id = id;
    this.state = state;
    this.latitude = latitude;
    this.longitude = longitude;
  }


  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isLocatedInState(String inputState) {
    return (inputState.toLowerCase()).equals(state.toLowerCase());
  }

  public static void filterByState(WeatherStation[] allstns, String stateID) {
    for (int i = 0; i < allstns.length; i++) {
       if ((allstns[i].state).toLowerCase() == stateID.toLowerCase()){
         System.out.println("Station at index " + i + " is in " + stateID);
       }
    }
  }

  public String toString(){
    return "Weather Station: " + name + " (" + id.toUpperCase() + ").";
  }

  public Observation currentWeather(String id, int i) {
    DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id.toUpperCase() + ".xml").load();
    ds.load();
    //ds.printUsageString();
    Observation ob1;
    try  {
      ob1 = ds.fetch("Observation", "temp_f", "location");
    }
    catch(Exception e) {
      ob1 = null;
    }
    return ob1;
  }
}