import core.data.*;

public class Welcome01 {
   public static Observation getData(String id) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id.toUpperCase() + ".xml").load(); 
      ds.setCacheTimeout(15 * 60);  
      ds.load();
      
      //ds.printUsageString();


      /*
      String location = ds.fetchString("location");
      String weather = ds.fetchString("weather");
      String timeStamp = ds.fetchString("observation_time_rfc822");
      double temperature = ds.fetchFloat("temp_f");

      Observation o1 = new Observation(location, weather, timeStamp, temperature);
      */

      Observation ob1 = ds.fetch("Observation", "temp_f", "weather", "relative_humidity");   
      return ob1;

   }
}
