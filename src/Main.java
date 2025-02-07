import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {

        TelefonListen teleListe = new TelefonListen();
        Scanner scanner = new Scanner(System.in);

        teleListe.loadContactFromFile("TelefonFile.txt");

        boolean running = true;

        while (running)
        {
            System.out.println("Peytons Telefon Liste");
            System.out.println("Menu");
            System.out.println("1. Opret ny kontakt");
            System.out.println("2. Søg på person");
            System.out.println("3. Se telefonlisten");
            System.out.println("4. Slet kontakt");
            System.out.println("5. Check om en person er på listen?");
            System.out.println("6. Vis alle navne på listen");
            System.out.println("7. Gem kontakter i fil");
            System.out.println("Exit");

            String input = scanner.nextLine();

            int choice;

            try
            {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid number, please write a number");
                continue;
        }


            switch (choice)
            {
                case 1:

                    //Options and input

                    System.out.println("Enter name of person: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter phonenumber: ");
                    String number = scanner.nextLine();

                    //Add to teleList
                    teleListe.addContact(name.trim(), number);
                    System.out.println("\nContact added succesfully");
                    System.out.println(teleListe);

                    teleListe.saveToFile("TelefonFile.txt");

                    break;
                case 2:
                    System.out.println("Søg på navn");
                    String searchName = scanner.nextLine();


                    teleListe.getNumber(searchName);
                    System.out.println("Phone number of " + searchName + " is " + teleListe.getNumber(searchName));


                    break;

                case 3:

                    System.out.println(teleListe);
                    break;


                case 4:

                    System.out.println("Who would you like to delete?");
                    String contactName = scanner.nextLine();

                    teleListe.deleteContact(contactName);
                    System.out.println("\n" + contactName + " has been deleted. Here is a updated list:");

                    System.out.println(teleListe);
                    break;

                case 5:
                    System.out.println("Who would you like to check? ");
                    String nameOfPerson = scanner.nextLine();

                    teleListe.findContainsContact(nameOfPerson);
                    //teleListe.findContact(nameOfPerson);


                    break;

                case 6:

                    System.out.println(teleListe.showNames());
                    break;

                case 7:

                    System.out.println("Enter the filename you wish");
                    String filename = scanner.nextLine();
                    teleListe.saveToFile(filename);

                    break;





                case 8:
                    // Exit the program
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
                    break;
            }

        }




    }
}