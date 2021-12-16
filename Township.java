public class Township {
  public String gender, townshipName;
  public int count;

  public Township(String townshipName, String gender, int count) {
    this.townshipName = townshipName;
    this.gender = gender;
    this.count = count;
  }

  public String toString() {
    return "The " + townshipName + " township has " + count + " " + gender + "s enrolled in Connecticut's DSS Services.";
  }
}