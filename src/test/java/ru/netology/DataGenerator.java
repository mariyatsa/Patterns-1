package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Москва", "Тула", "Калуга", "Хабаровск", "Тверь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return  new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

    }
}

  /*  @BeforeEach
    void setUpAll(){
        faker = new Faker(new Locale("ru"));
    }
    @Test
    void shouldPreventSendRequestMultipleTimes(){
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(cardNumber);

}*/
