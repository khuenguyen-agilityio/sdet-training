package helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private static ThreadLocal<Storage> storage = new ThreadLocal<>();
    //***general***
    private Map<String, Object> mapStorage;

    public static Storage getStorage() {
        return storage.get();
    }

    public static void instantiateStorage() {
        storage.set(new Storage());
        storage.get().mapStorage = new HashMap<>();
    }

    public void saveValue(String key, String value) {
        mapStorage.put(key, value);
    }

    public String getValue(String key) {
        return (String) mapStorage.get(key);
    }

    public void saveObjectValue(String key, Object value) {
        mapStorage.put(key, value);
    }

    public Object getObject(String key) {
        return mapStorage.get(key);
    }
}
