public class MapGenerator {
    public static Map generateMap() {

        //generating empty map sections
        Map Cafe = new Cafe ("You've entered the cafe");
        Map Town = new Town("You've entered the town");
        Map Cage = new ChinchillaCafe("You've entered the cage");
        Map CatHouse = new CatHouse("You've entered the Cat House");
        
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
