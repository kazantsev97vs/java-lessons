package lesson_47__serialization___transient_serialVersionUID;

/**
 * Сериализация - запись объектов в файл.
 * Десериализация - получение объекта из файла (обратный процесс для сериализации)
 *
 * transient - это ключевое слово используется тогда, когда мы не хотим сериализовывать какое-то поле.
 *
 * SerialVersionUID - особенное поле, которое у нас существует в классах, которые implement-яд интерфейс Serializable:
 * private static final long serialVersionUID = 2392072499662292874L;
 * Это поле отвечает за состояние класса: если класс меняется то и поле это меняется.
 * Когда записали объект в файл, затем как-то изменили класс объекта, а после этого пытаемся прочитать объект из файла:
 * java.io.InvalidClassException: Person;
 * local class incompatible:
 * stream classdesc serialVersionUID = 2392072499662292874, local class serialVersionUID = -5207836352984595080
 *
 */
public class Serialization {

}
