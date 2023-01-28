// sorry guys ignore this class need to fix it
public class Setting {
    public static Room generateSetting() {

        //generating empty map sections
        Room Cafe = new Room("You've entered the cafe");
        Room Town = new Room("You've entered the town");
        Room Cage = new Room("You've entered the cage");
        Room CatHouse = new Room("You've entered the Cat House");
        
        //generating door entrances
        Door Entrance_Cafe = new Door(Entrance, Cafe);
        Door Entrance_Town = new Door(Entrance, Town);
        Door Entrance_Cage = new Door(Entrance, Cage);
        Door Entrance_CatHouse = new Door(Entrance, CatHouse);

        //generating exits
        Entrance.setExit(Entrance_Cafe);
        Cafe.setExit(Entrance_Cafe);
        
        Entrance.setExit(Entrance_Town);
        Town.setExit(Entrance_Town);
        
        Entrance.setExit(Entrance_Cage); 
        Cage.setExit(Entrance_Cage);
        
        Entrance.setExit(Entrance_CatHouse);
        CatHouse.setExit(Entrance_CatHouse);

    }
}
