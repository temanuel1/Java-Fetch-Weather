  class Main {
    public static void main(String[] args) {

    //System.out.println("hi");
    boolean firstColder = (Welcome01.getData("tjsj")).colderThan(Welcome01.getData("nstu"));
  
    WeatherStation w1 = new WeatherStation("Luis Muñoz Marín International Airport", "tjsj", "Puerto Rico", 65.9956, 18.4339);
    //System.out.println(w1);

    System.out.println("\nFirst station: " + Welcome01.getData("tjsj") + "\n\nSecond station: " + Welcome01.getData("nstu") + "\n\nIt is " + firstColder + " that the first station is colder than the second station.");

    
    StationRunner.main();

    

    } 
  }