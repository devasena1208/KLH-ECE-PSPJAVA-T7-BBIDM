import java.util.Scanner;

class BloodBankSystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String donorNames[] = new String[10];
        String donorGroups[] = new String[10];

        String bloodGroups[] = {
            "A+", "A-", "B+", "B-",
            "AB+", "AB-", "O+", "O-"
        };

        int bloodUnits[] = {5, 3, 4, 2, 3, 1, 6, 2};

        int donorCount = 0;
        int choice;

        do
        {
            System.out.println("----- BLOOD BANK SYSTEM -----");
            System.out.println("1. Add Donor");
            System.out.println("2. View Blood Inventory");
            System.out.println("3. Find Suitable Donor");
            System.out.println("4. Update Blood Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    if(donorCount < 10)
                    {
                        System.out.print("Enter donor name: ");
                        donorNames[donorCount] = sc.nextLine();

                        System.out.print("Enter blood group: ");
                        donorGroups[donorCount] = sc.nextLine();

                        donorCount++;

                        System.out.println("Donor added successfully.");
                    }
                    else
                    {
                        System.out.println("Donor storage is full.");
                    }
                    break;

                case 2:
                    System.out.println("----- BLOOD INVENTORY -----");

                    for(int i = 0; i < 8; i++)
                    {
                        System.out.println(
                            bloodGroups[i] + " : "
                            + bloodUnits[i] + " units"
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter required blood group: ");
                    String requiredGroup = sc.nextLine();

                    boolean found = false;

                    for(int i = 0; i < donorCount; i++)
                    {
                        if(donorGroups[i] == requiredGroup)
                        {
                            System.out.println(
                                "Suitable donor: "
                                + donorNames[i]
                            );

                            found = true;
                        }
                    }

                    if(found == false)
                    {
                        System.out.println("No suitable donor found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter blood group: ");
                    String updateGroup = sc.nextLine();

                    System.out.print("Enter units to add: ");
                    int units = sc.nextInt();

                    boolean updated = false;

                    for(int i = 0; i < 8; i++)
                    {
                        if(bloodGroups[i]==updateGroup)
                        {
                            bloodUnits[i] =
                                bloodUnits[i] + units;

                            System.out.println(
                                "Updated stock: "
                                + bloodUnits[i] + " units"
                            );

                            updated = true;
                            break;
                        }
                    }

                    if(updated == false)
                    {
                        System.out.println("Invalid blood group.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while(choice != 5);

        sc.close();
    }
}


