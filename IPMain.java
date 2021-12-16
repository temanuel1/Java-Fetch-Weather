import core.data.*;
public class IPMain {
  public static void main(){
    DataSource ds = DataSource.connect("https://data.ct.gov/api/views/ie4x-b4yb/rows.xml").load(); 
    ds.setCacheTimeout(15 * 60);  
    ds.load();

    // Array of Connecticut DSS Township Enrollment Count (By Gender)
    Township[] tshps = ds.fetchArray("Township", "row/row/township", "row/row/gender", "row/row/count");

    int maleTotal = 0;
    int femaleTotal = 0;
  
    for (int i = 0; i < tshps.length; i++) {
      if ((tshps[i].gender).equals("M")) {
        maleTotal += tshps[i].count;
      } else {
        femaleTotal += tshps[i].count;
      }
    }
    System.out.println("There are " + maleTotal + " males and " + femaleTotal + " females enrolled in DSS services in Connecticut.");
  
  }
}