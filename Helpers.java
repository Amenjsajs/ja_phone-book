package phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helpers {
    public static String getFullName(String str) {
        return str.substring(str.indexOf(" ") + 1);
    }

    public static String[] loadData(String path) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            list.add(currentLine);
        }
        reader.close();
        return list.toArray(new String[0]);
    }

    public static HashMap<String, String> createHashTable(String[] elements) {
        HashMap<String, String> hashMap = new HashMap<>();
        String name;
        String phone;
        for (String item : elements) {
            name = getFullName(item);
            phone = item.replace(name, "").trim();
            hashMap.put(name, phone);
        }
        return hashMap;
    }

    public static String getTaskTime(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalTime time = LocalTime.ofInstant(instant, ZoneId.of("GMT+0"));

        String nano = String.valueOf(time.getNano());
        nano = "0".repeat(9 - nano.length()) + nano;

        return String.format("%d min. %d sec. %.3s ms.", time.getMinute(), time.getSecond(), nano);
    }
}
