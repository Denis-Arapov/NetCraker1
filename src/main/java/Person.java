import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Класс описывающий человека
 */
public class Person {
    /**
     * Фио человека
     */
    String fio;
    /**
     * ID человека
     */
    int id;
    /**
     * Дата рождения человека хранимая в поле класса Calendar
     */
    Calendar date;
    /**
     * Пол человека 1 - мужчина, 0 - женщина
     */
    boolean gender;

    /**
     * Конструктор класса Person, по мимо принимаемых параметров задаёт ID равное ID предыдущего человека +1
     *
     * @param fio    ФИО
     * @param date   Дата рождения типа Calendar
     * @param gender Пол человека 1 - мужчина, 0 - женщина
     */
    public Person(String fio, Calendar date, boolean gender) {
        this.fio = fio;
        this.id = Id.getid();
        this.date = date;
        this.gender = gender;
    }

    /**
     * @return Возвращает дату рождения человека
     */
    public int getAge() {
        Calendar date = new GregorianCalendar();
        return date.get(Calendar.YEAR) - this.date.get(Calendar.YEAR);
    }

    /**
     * @return Возвращает ФИО
     */
    public String getFio() {
        return fio;
    }

    /**
     * @return Возвращает ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return Возвращает пол человека
     */
    public String getGender() {
        if (this.gender == true)
            return "Man";
        else
            return "Woman";
    }

    /**
     * @return Возвращает строку в формате fio + id + возраст + пол
     */
    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", id=" + id +
                ", date=" + getAge() +
                ", gender=" + getGender() +
                '}';
    }
}
