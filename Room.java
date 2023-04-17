import java.util.ArrayList;

public class Room
{
    String name;
    String description;
    ArrayList<String> exits;
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new ArrayList<String>();
    }

    /* Generate getteand setters for the names and descriptions */
    public void roomSetName(String name) {
        this.name = name;
    }
    
    public String roomGetName() {
        return this.name;
    }

    public void roomSetDesc(String description) {
        this.description = description;
    }

    public String roomGetDesc() {
        return this.description;
    }

    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit) {
        exits.add(exit);
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits() {
        String exitsList = "";
        for(int i = 0; i < exits.size(); i++) {
            exitsList += exits.get(i) + "\n";
        }

        return exitsList;
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString() {
        String listExits = listExits();

        String roomString = this.name + ": " + this.description;
        //roomString = roomString.replaceAll(".{89}", "$0\n");
        roomString += "\n\nExits:\n" + listExits;

        return roomString;
    }
}
