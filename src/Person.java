import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    int age;
    boolean hasAgeValue;
    private String address;
    boolean hasAddressValue;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.hasAgeValue = false;
        this.hasAddressValue = false;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAgeValue = true;
        this.hasAddressValue = false;
    }
    public boolean hasAge() {
        return hasAgeValue;
    }

    public boolean hasAddress() {
        return hasAddressValue;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public  String getAddress() {
        return address;
    }

    public OptionalInt getAge() {
        if(hasAgeValue) {
            return OptionalInt.of(age);
        } else {
            return  OptionalInt.empty();
        }

    }

    public void setAddress(String address) {
        this.address = address;
        this.hasAddressValue = true;
    }
    public void happyBirthday() {
        if (hasAgeValue) {
            age++;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(surname);
        if (hasAgeValue) {
            sb.append(", возраст: ").append(age);
        }
        if (hasAddressValue) {
            sb.append(", город: ").append(address);
        }
        return sb.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, hasAgeValue, hasAddressValue, address);
    }
    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        if (hasAgeValue) {
            builder.setAge(0);
        }
        if (hasAddressValue) {
            builder.setAddress(this.address);
        }
        return builder;
    }
}
