package java.part_2_Java_Collections_Framework.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map - карта, отображение
 * пара: ключ - значение - рассматривается как своя структура данных Entry<Тип ключа, Тип значения>
 *     класс HashMap не гарантирует никакого порядка -- использовать, когда неважен порядок
 *     Типичный пример - словарь. Где ключи - слова на каком-то языке и значение - перевод
 *     слабая сторона - внутри класса нету порядка - данные выдаются случайным образом
 *
 *     не может быть одинаковых ключей, но значения могут быть одинкаовые
 *
 *
 *     LinkedHashMap - сохраняет порядок доавления новых
 *     TreeMap - сортирует пары : ключ - значение по ключу
 */
public class CollectionHashMap {

    public static void main(String[] args) {

        // <Тип ключа, Тип значения>
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(0, "Ноль");

//        map.get();
//        map.remove();

//        System.out.println(map);
//
//        map.put(3, "Другое значение для ключа Три");
//
//        System.out.println(map);
//
//        System.out.println(map.get(1));
//        System.out.println(map.get(10));


        for (
                Map.Entry<Integer, String> entry :  // entry - своя структура данных Entry<Тип ключа, Тип значения>
                map.entrySet()) {                   // entrySet возвращает набор всех пар : ключ - значение в этой map

            System.out.println(
                    entry.getKey() // получить ключ
                    + " : "
                    + entry.getValue() // получить значение
            );
        }





    }
}
