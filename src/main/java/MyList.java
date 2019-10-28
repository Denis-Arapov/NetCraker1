import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Список на основе двусвязного списка хранящий элементы с типом Т
 *
 * @param <T> Тип хранимых элементов
 */
public class MyList<T> {
    /**
     * Перый элемент списка
     */
    private Node<T> first;
    /**
     * Последний элемент списка
     */
    private Node<T> last;
    /**
     * Текущая длинна списка
     */
    private int size = 0;

    public MyList() {

    }

    /**
     * Метод добавляет ячейку в лист
     *
     * @param data Данные записываемые в ячейку
     */
    public void add(T data) {
        if (size == 0) {
            first = new Node<T>(data);
            last = first;
        } else {
            last.setNext(new Node<T>(data));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
        size++;
    }

    /**
     * @param index Индекс возвращаемого элемента
     * @return Возвращает элемент с индексом index
     */
    public T get(int index) {
        if (size / 2 > index) {
            Node<T> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getData();
        } else {
            Node<T> temp = last;
            for (int i = 0; i < size - index - 1; i++) {
                temp = temp.getPrev();
            }
            return temp.getData();
        }
    }

    /**
     * Присваивает элементу с индексом index значение data
     *
     * @param index индекс по которому присваивается значение
     * @param data  Присваиваемое значение
     */
    public void set(int index, T data) {
        if (size / 2 > index) {
            Node<T> temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setData(data);
        } else {
            Node<T> temp = last;
            for (int i = 0; i < size - index - 1; i++) {
                temp = temp.getPrev();
            }
            temp.setData(data);
        }
    }

    /**
     * Удаляет элемент по индексу
     *
     * @param index Индек по которому удаляется элемент
     * @return Возвращает удалённый элемент
     */
    public T remove(int index) {
        if (index == 0) {
            Node<T> temp = first;
            first = first.getNext();
            size--;
            return temp.getData();
        }
        if (index == size - 1) {
            Node<T> temp = last;
            last = last.getPrev();
            size--;
            return temp.getData();
        }
        if (size / 2 > index) {
            Node<T> temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            size--;
            return temp.getData();
        } else {
            Node<T> temp = last;
            for (int i = 0; i < size - index - 1; i++) {
                temp = temp.getPrev();
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            size--;
            return temp.getData();
        }

    }

    /**
     * Вставляет элемент data в список по индексу index
     *
     * @param index Индекс по которому вставляется элемент
     * @param data  Вставляемый элемент
     */
    public void insert(int index, T data) {
        if (index == size - 1) {
            add(data);
        } else if (index == 0) {
            first.setPrev(new Node<T>(data));
            Node<T> temp = first;
            first.getPrev().setNext(first);
            first = first.getPrev();
            first.setNext(temp);
        } else if (size / 2 > index) {
            Node<T> temp = first.getNext();
            for (int i = 1; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node<T> ins = new Node<T>(data);
            ins.setPrev(temp.getPrev());
            ins.setNext(temp);
            temp.setPrev(ins);
            temp.getPrev().setNext(ins);


        } else {
            Node<T> temp = last.getPrev();
            for (int i = 1; i < size - index - 1; i++) {
                temp = temp.getPrev();
            }
            Node<T> ins = new Node<T>(data);
            ins.setNext(temp);
            ins.setPrev(temp.getPrev());
            temp.getPrev().setNext(ins);
            temp.setPrev(ins);

            int a = 5;
            Node<T> ab = first;
        }
        size++;
    }

    /**
     * @return Возвращает размер массива
     */
    public int getSize() {
        return size;
    }
}

