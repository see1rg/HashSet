
import java.util.ArrayList;
import java.util.Objects;

public class Passport {
    private String number;
    private String surname;
    private String name;
    private String middleName;
    private String birthday;
    private static ArrayList<Passport> passport = new ArrayList<>();


    public Passport(String number, String surname, String name, String middleName, String birthday) {
        if (number == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        } else {
            this.number = number;
        }
        this.surname = surname;
        if (name == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        } else {
            this.name = name;
        }
        if (middleName == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        } else {
            this.middleName = middleName;
        }
        if (birthday == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        } else {
            this.birthday = birthday;
        }
    }


    public static Passport findThePassport(String i) {
        for (Passport passport : passport) {
            if (Objects.equals(i, passport.getNumber())) {
                return passport;
            }
        }
        return null;
    }

    public static void addPassport(Passport type) throws Exception {
        if (type.getName() == null || type.getSurname() == null) {
            throw new Exception("Заполните данные паспорта полностью.");
        } else {
            passport.add(type);
        }
    }

    String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (name == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        }

        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (name == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        }
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Поле не может быть пустым!");
        }
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static ArrayList<Passport> getPassport() {
        return passport;
    }

    public static void setPassport(ArrayList<Passport> passport) {
        Passport.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport passport)) return false;

        if (!getNumber().equals(passport.getNumber())) return false;
        if (getSurname() != null ? !getSurname().equals(passport.getSurname()) : passport.getSurname() != null)
            return false;
        if (!getName().equals(passport.getName())) return false;
        if (!getMiddleName().equals(passport.getMiddleName())) return false;
        return getBirthday().equals(passport.getBirthday());
    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getBirthday().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number='" + number + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
