public class Companion {

    private String name;
    private String role;
    private String ablity;
    private int power;
    private Player owner;

    public Companion( String name , String role , int power , Player owner){

        //companion name error handle
        if (name==null || name.trim().isEmpty() ) {
            System.out.println("Error: Companion name cannot be null or empty");
            this.name = "Unknown";
        } 
        else {
            this.name = name;
        }

        //companion role error handle
        if (role==null || role.trim().isEmpty() ) {
            System.out.println("Error: Companion role should be a Mage, Warrior, or Healer");
            this.role = "Unknown Role Type";
            this.ablity = "rolls around on the ground..."; //setting ability for unknown role 
        } 
        else {
            this.role = role;
        }

        //companion power error handle
        if (power<1 || power>100) {
            System.out.println("Error: Power must be between 1 and 100");
            this.power = 1;
        } 
        else {
            this.power = power;
        }

        //owner error handle
        if (owner == null) {
            System.out.println("Error: Companion must be assigned to a valid Player");
            this.owner = new Player("Default Player", 100);
        } 
        else {
            this.owner = owner;
        }

        if (name==null || name.trim().isEmpty() || role==null || role.trim().isEmpty() || power<1 || power>100 || owner == null) {
            System.out.println("Warning: Default values assigned for invalid inputs");
        }


    }

    //method to get name
    public String getName() {
        return name;
    }

    //method to get role
    public String getRole() {
        return role;
    }

    //method to get power
    public int getPower() {
        return power;
    }
    //method to get Owner
    public Player getOwner(){
        return owner;
    }

    //to use companion ability
    public String useAbility(){
        if (role.toLowerCase().equals("mage")) {
            return role + " casts a fireball!";
        }
        else if (role.toLowerCase().equals("warrior")) {
            return role + " swings a mighty sword!";
        }
        else if (role.toLowerCase().equals("healer")) {
            return role + " heals the party!";
        }
        else{
            return name + " rolls around on the ground...";
        }
        
    }

    //method to print companion information
    public String toString() {
        return "Companion{name='" + name + "', role='" + role + "', power=" + power + ", owner=" + owner.getName()+ "}";
    }


    /* 
    //for test
    public static void main(String[] args) {
        Player player = new Player("Arthur", 100);

        // Valid companion
        Companion companion1 = new Companion("Merlin", "Mage", 80, player);
        System.out.println(companion1);
        System.out.println(companion1.useAbility());

        // Invalid name
        Companion companion2 = new Companion("", "Warrior", 50, player);
        System.out.println(companion2);

        // Invalid role
        Companion companion3 = new Companion("Lancelot", "", 70, player);
        System.out.println(companion3);
        System.out.println(companion3.useAbility());

        // Invalid power
        Companion companion4 = new Companion("Galahad", "Healer", 150, player);
        System.out.println(companion4);

        // Null owner
        Companion companion5 = new Companion("Tristan", "Mage", 60, null);
        System.out.println(companion5);
    }
    */

}