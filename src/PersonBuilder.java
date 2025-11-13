public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private boolean hasAgeValue = false;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        this.hasAgeValue = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия обязательны для заполнения");
        }
        if (hasAgeValue && age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        Person person = new Person(name, surname);
        if (hasAgeValue) {
            person.age = age;
            person.hasAgeValue = true;
        }
        if (address != null) {
            person.setAddress(address);
            person.hasAddressValue = true;
        }
        return person;


    }
}
