//Pog
import core.data.*;
public class StationRunner{

  public static void main(){
    DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
    //ds.printUsageString();
    ds.load();

    WeatherStation[] allstns = ds.fetchArray("WeatherStation", "station/station_name", "station/station_id", "station/state", "station/latitude", "station/longitude");
    //System.out.println("\nTotal stations: " + allstns.length);

    
    double southernMost = 1e9;
    int index = 0;
    double coldestTemp = 1e9;
    double warmestTemp = -1e9;
    String coldName = "";
    String warmName = "";
    
    for (int i = 0; i < allstns.length; i++) {
      //System.out.println(allstns[i].latitude);
      if(Math.abs(allstns[i].latitude) < southernMost) {
        southernMost = allstns[i].latitude;
        index = i;
      }
    }
    System.out.println("\nThe Southern most weather station is " + allstns[index].name +  " at a latitude of " + Math.abs(allstns[index].latitude) + "\n");

    WeatherStation.filterByState(allstns, "IA");

    for (int i = 0; i < 50; /*allstns.length;*/ i++) {
      Observation ob3 = allstns[i].currentWeather(allstns[i].id, i);
      if (ob3 == null) {
        System.out.println("Station at index " + i + " did not have all required properties.");
      } else {
        System.out.println(ob3);
        if (ob3.temperature > warmestTemp) {
          warmestTemp = ob3.temperature;
          warmName = ob3.location;
        }
        if (ob3.temperature < coldestTemp) {
          coldestTemp = ob3.temperature;
          coldName = ob3.location;
        }
      }
    }
    System.out.println("\nThe coldest temperature is " + coldestTemp + " °F at " + coldName + "\n\nThe warmest temperature is " + warmestTemp + " °F at " + warmName );
  }
}