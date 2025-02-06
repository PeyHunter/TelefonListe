import java.util.HashMap;
import java.util.Map;

public class TelefonListen
{
    Map<String, String> telefonList = new HashMap<>();

    public TelefonListen()
    {
    }

    public TelefonListen(Map<String, String> telefonList)
    {
        this.telefonList = telefonList;
    }


    public Map<String, String> getTeleList()
    {
        return telefonList;
    }


    public void addContact(String name, String number)
    {
        String formattedName = capitalizeFirstAndLastName(name.trim());
        telefonList.put(formattedName, number);
    }

    public void findContact(String name)
    {
        String formattedName = capitalizeFirstAndLastName(name.trim());

        boolean found = false;
        for (String contactName : telefonList.keySet())
        {
            if (contactName.toLowerCase().equals(formattedName.toLowerCase()))
            {
                found = true;
                break;
            }
        }

        if(found)
        {
            System.out.println("Yes, " + formattedName + " is on contact list");
        }
        else
        {
            System.out.println("No, this person is not on the contact list" + "\n");
        }
    }


/////
    public void deleteContact(String name)
    {
        if (name != null && !name.isEmpty())
        {

            boolean contactDeleted = false;
            for (Map.Entry<String, String> entry : telefonList.entrySet())
            {
                String formattedName = capitalizeFirstAndLastName(name.trim());
                String fullName = entry.getKey();
                if (fullName.toLowerCase().contains(formattedName.toLowerCase()))
                {
                    telefonList.remove(fullName);
                    contactDeleted = true;
                    break;
                }
            }

            if (!contactDeleted)
            {
                System.out.println("No such person is found for deletion");
            } else
            {
                System.out.println("No such person is in the list");
            }
        }
    }


/////
    public String showNames()
    {
        StringBuilder names = new StringBuilder();
        for (String name : telefonList.keySet())
        {
            names.append(name).append("\n");
        }
        return names.toString();
    }


        public String getNumber (String name)
        {
            String formattedName = capitalizeFirstAndLastName(name.trim());
            return telefonList.get(formattedName);
        }


        public String capitalizeFirstAndLastName (String name)
        {
            if (name == null || name.isEmpty())
            {
                return name;
            }
            String[] parts = name.split(" ");

            for (int i = 0; i < parts.length; i++)
            {
                parts[i] = capitalizeFirstLetter(parts[i]);
            }
            return String.join(" ", parts);
        }

        public String capitalizeFirstLetter (String name)
        {
            if (name == null || name.isEmpty())
            {
                return name;
            }
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }


        public String searchedName (String name)
        {
            for (Map.Entry<String, String> entry : telefonList.entrySet())
            {
                String fullName = capitalizeFirstAndLastName(entry.getKey());
                String number = entry.getValue();

                if (fullName.toLowerCase().startsWith(name.toLowerCase()))
                {
                    return "Searched name: " + name + ", Phone number: " + number;
                }
            }
            return "Contact not found.";
        }


        @Override
        public String toString ()
        {
            String result = "";

            for (Map.Entry<String, String> entry : telefonList.entrySet())
            {
                result += "Name: " + entry.getKey() + ", Number: " + entry.getValue() + "\n";
            }
            return result;
        }

    }


