import java.util.Scanner;
public class Cat extends Characters {
  
    // setters and getters
    private String name;
    private int power;
    private int HP;
    private int MAX_HP = 100;


    public void setName(String n) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cat's name: ");
        name = input.nextLine();  
    }

    public String getName() {
        return name;
    }

   
}
