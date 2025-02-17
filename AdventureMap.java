import java.util.HashMap;

public class AdventureMap {

    HashMap<String, Room> map;

    public AdventureMap() {
        map = new HashMap<>();

    }

    /**
     * Adds a room to the AdventureMap
     * The name associated in the room must be lowercase
     * @param room Room to be added to the AdventureMap
     */
    public void addRoom(Room room) {
        map.put(room.roomGetName().toLowerCase(), room);

    }

    /**
     * Returns the Room assocaited with the string name given
     * @param roomName the name of the room to be returned, room name must be valid
     * @return the Room object assocaited with the name, the name will be in lowercase
    */
    public Room getRoom(String roomName) {
        
        return map.get(roomName.toLowerCase());
    }
}
