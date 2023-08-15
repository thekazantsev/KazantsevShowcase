package helpers;

import java.util.Random;

public class FormData {
    public String firstName = randomChooser(new String[]{"Sasha", "Zhenya", "Valya"});
    public String lastName = randomChooser(new String[]{"Kim", "Jong", "Lee"});
    public String studentName = firstName + " " + lastName;
    public String email = randomChooser(new String[]{"user@mail.ru", "user@gmail.com"});
    public String gender = randomChooser(new String[]{"Male", "Female", "Other"});
    public String mobile = randomChooser(new String[]{"9144154627", "9144154628", "9144154629"});
    public String dateOfBirth = randomChooser(new String[]{"20 October,1984", "02 April,1979", "10 June,1991"});
    public String subjects = "com";
    public String pictureName = "selenium.png";
    public String currentAddress = "Planet Earth";
    public String state = "Uttar Pradesh";
    public String city = "Lucknow";
    public String stateAndCityExpected = state + " " + city;

    public static FormData generate() {
        return new FormData();
    }

    private String randomChooser(String[] strings) {
        Random random = new Random();
        int randomIndex = random.nextInt(strings.length);
        return strings[randomIndex];
    }
}
