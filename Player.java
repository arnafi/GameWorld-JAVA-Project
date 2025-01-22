public class Player{

    private String name;
    private int health;
    private Artifact[] inventory;
    private int numArtifacts;

    public Player(String name, int health) {

        //player name error handle
        if (name==null || name.trim().isEmpty() ) {
            System.out.println("Error: Player name cannot be null or empty");
            this.name = "Unknown";
        } 
        else {
            this.name = name;
        }

        //player health error handle
        if (health<0 || health>100) {
            System.out.println("Error: Health must be between 0 and 100");
            this.health = 100;
        } 
        else {
            this.health = health;
        }

        //defining artifacts inventory size 10 and  initialized as an empty array
        this.inventory = new Artifact[10];
        this.numArtifacts = 0;

        if (name==null || name.trim().isEmpty() || health<0 || health>100) {
            System.out.println("Warning: Default values assigned for invalid inputs");
        }
    }

    //method to get name
    public String getName() {
        return name;
    }

    //method to get health
    public int getHealth() {
        return health;
    }

    //method to get numArtifacts
    public int getNumArtifacts(){
        return numArtifacts;
    }

    //method to checked artifacts can be store or not
    public boolean collectArtifact (Artifact artifact){
        for(int i=0;i<10;i++){
            if (inventory[i]==null) {
                inventory[i]= artifact; //placing artifact into inventory
                numArtifacts++; //num Artifacts increment
                return true;
            }
        }
        System.out.println("Error: Inventory is full, cannot add more artifacts.");
        return false;

    }

    ////method to take damage
    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Error: Damage amount cannot be negative.");
        } 
        else {
            health =health - amount;
            if (health < 0){
                health = 0; //if health is in negative value this will convert the health into 0
            }         
        }
    }

    //method to print player information
    public String toString() {
        return "Player{name= '" + name + "', health=" + health +" numArtifacts= "+ numArtifacts + " }";
    }


    // for testing

    /* 
    public static void main(String[] args) {

        // Valid player
        Player player1 = new Player("Arthur", 100);
        System.out.println(player1);

        // Invalid name
        Player player2 = new Player("", 50);
        System.out.println(player2);

        // Invalid health
        Player player3 = new Player("Lancelot", -10);
        System.out.println(player3);

        // Collect artifacts
        Artifact artifact = new Artifact("Excalibur", 5, false);
        player1.collectArtifact(artifact);
        System.out.println(player1);

        // Take damage
        player1.takeDamage(30);
        System.out.println(player1);

        player1.takeDamage(100);
        System.out.println(player1);

        // Invalid damage
        player1.takeDamage(-20);
    }
        */
}
