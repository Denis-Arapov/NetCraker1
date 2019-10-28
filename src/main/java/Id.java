/**
 * Класс который имеет метод создания уникального ID
 */
public class Id {

    /**
     * Последний возвращённый ID
     */
    static int id = 0;

    /**
     * @return Возвращает уникальный ID
     */
    static public int getid() {
        return id++;
    }
}
