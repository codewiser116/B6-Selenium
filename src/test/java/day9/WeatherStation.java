package day9;

public class WeatherStation {

    /*

    String mood = sad, happy
    double tempInCelcius =
    String weather = rainy, sunny, cloudy
    boolean isWindy =

    1. mood = happy, temp > 10, weather = sunny, its Windy = return String (Hooray)
    2. mood = happy, temp < 10, weather = sunny, its windy = return String (Ok)
                                weather = rainy, its windy = return String (Cry)
                     temp = 10, return (Ok)
    3. mood = sad, temp > 20, weather = cloudy, its not windy = return String (Ok)
    4. mood = sad, temp <  10, weather = sunny, its windy = return String (Cry)

    if mood = null, return "Ok"
    if instead of Celcius, user provides fahrenheit > 50 ==> "Error"
    it is case sensitive
    if any other value is given instead of our values => "Error"
    is there range in temp? (-50 to +50), if out of range => "Error"
    do you want me to throw CustomException pr print Error, return => "Error"
     */


    /*
        Write a method which reverses a String
     */

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("apple");
        System.out.println(str.reverse());
    }











}
