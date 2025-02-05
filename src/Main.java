import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {

        TelefonListen teleListe = new TelefonListen();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running)
        {
            System.out.println("Menu");
            System.out.println("1. Opret ny kontakt");
            System.out.println("2. Se telefonlisten");
            System.out.println("Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {

                    case 1:

                        //Options and input

                        System.out.println("Enter name of person");
                        String name = scanner.nextLine();

                        System.out.println("enter phonenumber");
                        Integer number = scanner.nextInt();

                        //Add to teleLIst
                        teleListe.addContact(name, number);
                        System.out.println("\nContact added succesfully");

                        System.out.println(teleListe);





                        break;


                    case 2:




                        break;



                    case 3:

                        break;


                    case 4:
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