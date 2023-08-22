package helpers;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FormData {
    Faker faker = new Faker();
    Random random = new Random();
    Map<String, List<String>> statesAndCities = Map.of(
        "NCR",           List.of("Delhi", "Gurgaon", "Noida"),
        "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
        "Haryana",       List.of("Karnal", "Panipat"),
        "Rajasthan",     List.of("Jaipur", "Jaiselmer")
    );

    public final String firstName      = generateFirstName();
    public final String lastName       = generateLastName();
    public final String studentName    = generateStudentName();
    public final String email          = generateEmail();
    public final String gender         = generateGender();
    public final String mobile         = generateMobile();
    public final String dateOfBirth    = generateDateOfBirth();
    public final String subjects       = generateSubjects();
    public final String pictureName    = generatePictureName();
    public final String currentAddress = generateCurrentAddress();
    public final String state          = generateState();
    public final String city           = generateCity(state);
    public final String stateAndCityExpected = state + " " + city;

    private FormData() {
    }

    public static FormData generate() {
        return new FormData();
    }

    private String generateFirstName() {
        return faker.name().firstName();
    }

    private String generateLastName() {
        return faker.name().lastName();
    }

    private String generateStudentName() {
        return firstName + " " + lastName;
    }

    private String generateEmail() {
        return faker.internet().emailAddress();
    }

    private String generateGender() {
        return faker.expression("#{options.option 'Male','Female','Other'}");
    }

    private String generateMobile() {
        return faker.regexify("[0-9]{10}");
    }

    private String generateDateOfBirth() {
        int minAge = 10;
        int maxAge = 100;
        String generationPattern = "dd MM yyyy";
        String requiredPattern = "dd MMMM,yyyy";
        Locale locale = Locale.ENGLISH;
        String generatedDate = faker.date().birthday(minAge, maxAge, generationPattern);
        DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern(generationPattern);
        DateTimeFormatter monthFullName = DateTimeFormatter.ofPattern(requiredPattern, locale);
        LocalDate date = LocalDate.parse(generatedDate, originalFormatter);
        return date.format(monthFullName);
    }

    private String generateSubjects() {
        return "com"; // Due to COMputer science
    }

    private String generatePictureName() {
        return "selenium.png";
    }

    private String generateCurrentAddress() {
        return faker.address().fullAddress();
    }

    private String generateState() {
        List<String> keysList = new ArrayList<>(statesAndCities.keySet());
        return randomElementFrom(keysList);
    }

    private String generateCity(String state) {
        List<String> cities = statesAndCities.get(state);
        return randomElementFrom(cities);
    }

    private String randomElementFrom(List<String> list) {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
