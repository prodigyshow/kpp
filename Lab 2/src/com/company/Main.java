package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Map<String,List<Clubs>> footballClubsMap = new HashMap<String, List<Clubs>>();


        boolean exit = false;

        while (!exit) {
            System.out.print("1.Print clubs\n");
            System.out.print("2.Add club\n");
            System.out.print("3.Remove club\n");
            System.out.print("4.Read clubs from files   \n\n> ");

            Scanner myInput = new Scanner(System.in);
            int option = (int) myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Count of clubs? \n> ");
                    int n = (int) myInput.nextInt();
                    Manager.PrintMap(footballClubsMap, n);
                    System.out.println("Count of cities with same clubs is " + ( Manager.SimilarClubCount(footballClubsMap) - 2 ));
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter club name \n> ");
                    String newName = myInput.next();
                    System.out.print("Enter city \n> ");
                    String newCity = myInput.next();
                    System.out.print("Enter foundation date \n> ");
                    int newYear = (int) myInput.nextInt();

                    Clubs newClub = new Clubs(newName, newCity, newYear);

                    if(!footballClubsMap.containsKey(newCity))
                    {
                        footballClubsMap.put(newCity, new LinkedList<Clubs>());
                    }
                    footballClubsMap.get(newCity).add(newClub);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter club name \n> ");
                    String _name = myInput.next();
                    System.out.print("Enter city \n> ");
                    String _city = myInput.next();
                    System.out.print("Enter foundation date \n> ");
                    int _year = (int) myInput.nextInt();

                    Clubs clubToDelete = new Clubs(_name, _city, _year);

                    if(footballClubsMap.containsKey(_city) && footballClubsMap.get(_city).contains(clubToDelete))
                    {
                        footballClubsMap.get(_city).remove(clubToDelete);
                    }
                    else{
                        System.out.println("There is no such club");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Choose: \n 1 - All clubs\n> ");
                    int mergeOption = (int) myInput.nextInt();

                    if (mergeOption == 1)
                        footballClubsMap = Manager.ReadFromFiles(MergeOptions.ALL);

                    else{
                        footballClubsMap = Manager.ReadFromFiles(MergeOptions.COMMON);
                    }
                    System.out.println();
                    break;

                default:
                    exit = true;
                    break;
            }
        }
    }
}
