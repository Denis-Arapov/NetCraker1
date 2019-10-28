import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        MyList<Person> list = new MyList<Person>();
        Person person;
        int index;
        try {
            while (true) {
                System.out.println("Что сделать с массивом \n 1 добавить элемент \n 2 вернуль элемент по индексу \n 3 удалить элемент по индексу " +
                        "\n 4 вставить элемент по индексу \n 5 изменить элемент по индексу \n 6 Вывести массив");
                int n = Integer.parseInt(reader.readLine());
                switch (n) {
                    case (1):
                        person = inputPerson();
                        list.add(person);
                        break;
                    case (2):
                        System.out.println("Введите индекс");
                        index = Integer.parseInt(reader.readLine());
                        if (list.getSize() > index)
                            System.out.println(list.get(index).toString());
                        else
                            break;
                        break;
                    case (3):
                        System.out.println("Введите индекс");
                        index = Integer.parseInt(reader.readLine());
                        if (list.getSize() > index)
                            System.out.println(list.remove(index).toString());
                        else
                            break;
                        break;
                    case (4):
                        System.out.println("Введите индекс");
                        index = Integer.parseInt(reader.readLine());
                        person = inputPerson();
                        if (list.getSize() > index)
                            list.insert(index, person);
                        else
                            break;
                        break;
                    case (5):
                        System.out.println("Введите индекс");
                        index = Integer.parseInt(reader.readLine());
                        person = inputPerson();
                        if (list.getSize() > index)
                            list.set(index, person);
                        else
                            break;
                        break;
                    case 6:
                        for (int i = 0; i < list.getSize(); i++) {
                            System.out.println(list.get(i).toString());
                        }
                        break;
                    default:
                        System.out.println("Введённое значение некорректно");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public Person inputPerson() {
        try {
            System.out.println("Введите Фио");
            String fio = reader.readLine();
            System.out.println("Введите год рождения");
            int year = Integer.parseInt(reader.readLine());
            System.out.println("Введите месяц");
            int month = Integer.parseInt(reader.readLine());
            System.out.println("Введите день");
            int day = Integer.parseInt(reader.readLine());
            Calendar data = new GregorianCalendar(year, month, day);
            System.out.println("Введите пол");
            boolean gender = Boolean.parseBoolean(reader.readLine());
            return new Person(fio, data, gender);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


