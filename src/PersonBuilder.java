public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private boolean hasAgeValue = false;
    private String address;

    public PersonBuilder setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if ((surname == null || surname.isEmpty())) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {

        this.age = age;
        this.hasAgeValue = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {


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
