import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<String>> TelephoneDirectory = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (!TelephoneDirectory.containsKey(surname))
            TelephoneDirectory.put(surname, new ArrayList<String>());

        TelephoneDirectory.get(surname).add(phoneNumber);
    }

    public void get(String surname) {
        if (TelephoneDirectory.containsKey(surname))
            System.out.println(TelephoneDirectory.get(surname));
        else
            System.out.println("Для данной фамилии отсутствует номер телефона");
    }
}