import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AdventureMap mainMap = new AdventureMap();

        String[] roomNames = new String[7];
        roomNames[0] = "Guest Room";
        roomNames[1] = "Library";
        roomNames[2] = "Kitchen";
        roomNames[3] = "Study";
        roomNames[4] = "Holodeck";
        roomNames[5] = "Trophy Room";
        roomNames[6] = "Bedroom";

        Boolean validInput;
        String userInput = "study";

        System.out.println("\nWelcome to the Adkins house! Entering the study room. To leave the house, please type exit to jump out of the nearest window.\n");
        
        //* Guest Room: A room filled with numerous torture devices. Who said anything about welcome guests? :: Kitchen
        Room guestRoom = new Room("Guest Room", "A room filled with numerous torture devices. Who said anything about welcome guests?");
        guestRoom.addExit("Kitchen");
        mainMap.addRoom(guestRoom);

        //* Library: Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you! :: Holodeck, Trophy Room, Study
        Room Library = new Room("Library", "Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you!");
        Library.addExit("Holodeck");
        Library.addExit("Trophy Room");
        Library.addExit("Study");
        mainMap.addRoom(Library);

        //* Kitchen: This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway. :: Study, Guest Room
        Room Kitchen = new Room("Kitchen", "This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway.");
        Kitchen.addExit("Study");
        Kitchen.addExit("Guest Room");
        mainMap.addRoom(Kitchen);

        //* Study: Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms. :: Kitchen, Library, Bedroom
        Room Study = new Room("Study", "Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms.");
        Study.addExit("Kitchen");
        Study.addExit("Library");
        Study.addExit("Bedroom");
        mainMap.addRoom(Study);

        //* Holodeck: A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library. :: Library
        Room Holodeck = new Room("Holodeck", "A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library.");
        Holodeck.addExit("Library");
        mainMap.addRoom(Holodeck);

        //* Trophy Room: Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to. :: Bedroom, Library
        Room trophyRoom = new Room("Trophy Room", "Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to.");
        trophyRoom.addExit("Bedroom");
        trophyRoom.addExit("Library");
        mainMap.addRoom(trophyRoom);

        //* Bedroom: A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom. :: Study, Trophy Room
        Room Bedroom = new Room("Bedroom", "A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom.");
        Bedroom.addExit("Study");
        Bedroom.addExit("Trophy Room");
        mainMap.addRoom(Bedroom);


        /*
         * Create a scanner, put the inital room (entrance) to study
         * While the user's input is not exit, continue to traverse the map. 
         * If there is an invalid selection, then print out "Invalid exit."
         * After you are done selecting, print out "Please choose an exit" and get next exit
         */

        do {
            validInput = false;
            
            //System.out.println(mainMap.getRoom("Guest room").toString());
            System.out.println("\n" + mainMap.getRoom(userInput).toString());
            
            while (!validInput) {
                System.out.println("Please choose an exit");
                userInput = scnr.nextLine();
                for (int i = 0; i < 7; i++) {
                    if (userInput.equalsIgnoreCase(roomNames[i]) || userInput.equalsIgnoreCase("exit")) {
                        validInput = true;
                    }
                }
                if (!validInput) {
                    System.out.println("Invalid exit.");
                }
            }
        } while (!userInput.equalsIgnoreCase("exit"));
    }
}
