import java.util.HashMap;
import java.util.Map;

public class TelefonListen
{

    public TelefonListen()
    {}

    Map<String, Integer> telefonList = new HashMap();

    public TelefonListen(Map<String, Integer> telefonList)
    {
        this.telefonList = telefonList;
    }



    public void addContact(String name, Integer number)
    {
        telefonList.put(name, number);
    }

    public Map<String, Integer> getTeleList()
    {
        return telefonList;
    }

    @Override
    public String toString()
    {
        String result = "";

        // Enhanced for loop to iterate over the map entries
        for (Map.Entry<String, Integer> entry : telefonList.entrySet()) {
            result += "Name: " + entry.getKey() + ", Number: " + entry.getValue() + "\n";
        }

        return result;
    }


}
