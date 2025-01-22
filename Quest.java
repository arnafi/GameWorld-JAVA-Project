public class Quest {

    private String description;
    private int difficulty;
    private Companion[] companions;
    private int numCompanions;

    public Quest(String description , int difficulty){

        //description error handle
        if (description==null || description.trim().isEmpty() ) {
            System.out.println("Error: Quest description cannot be null or empty");
            this.description = "Unnamed Quest";
        } 
        else {
            this.description = description;
        }

        //difficulty error handle
        if (difficulty<1 || difficulty>10) {
            System.out.println("Error: Difficulty must be between 1 and 10");
            this.difficulty = 1;
        } 
        else {
            this.difficulty = difficulty;
        }

        //defining companions size 5 and  initialized as an empty array
        this.companions = new Companion[5];
        this.numCompanions = 0;

        
    }

    
    //method to get description
    public String getDescription() {
        return description;
    }

    //method to get difficulty
    public int getDifficulty(){
        return difficulty;
    }

    //method to get number of companions
    public int getNumCompanions(){
        return numCompanions;
    }

    //method to add required companions
    public boolean addRequiredCompanion(Companion companion){
        for(int i=0;i<5;i++){
            if (companions[i]==null) {
                companions[i]= companion; //placing companion into companions
                numCompanions++; //num companion increment
                return true;
            }
        }
        System.out.println("Error: Cannot add more companions to this quest");
        return false;
    }

    //method to check can player do the quest
    public boolean canComplete(Player player){

        int totalPower = 0; // at first declearing total power as 0
        for(int i = 0;i<numCompanions;i++){
            totalPower = totalPower + companions[i].getPower(); //adding all companions power
        }

        if ((difficulty/2) > numCompanions || totalPower < (difficulty * 10) || player.getNumArtifacts()< numCompanions) { //checking all requirments for quest
            return false;
        }
        return true;
    }

    //method to attemp quest
    public String attemptQuest(Player player){
        if (canComplete(player)) {
            return "Quest completed successfully! " + description;
        }
        else{
            player.takeDamage(difficulty*10);
            return "Quest failed! The player has taken damage.";
        }
    }

    ////method to print information
    public String toString(){
        return "Quest{description='" + description + "', difficulty=" + difficulty + ", numCompanions=" + numCompanions + "}";
    }



    /* 
    //for test
    public static void main(String[] args) {
        Player player = new Player("Arthur", 100);

        // Valid quest
        Quest quest = new Quest("Defend the Village", 5);
        System.out.println(quest);

        // Add required companions
        Companion mage = new Companion("Merlin", "Mage", 80, player);
        Companion warrior = new Companion("Lancelot", "Warrior", 70, player);
        quest.addRequiredCompanion(mage);
        quest.addRequiredCompanion(warrior);

        // Check if the quest can be completed
        System.out.println("Can complete quest: " + quest.canComplete(player)); // false
        player.collectArtifact(new Artifact("Magic Wand", 5, false));
        player.collectArtifact(new Artifact("Shield", 5, false));
        System.out.println("Can complete quest: " + quest.canComplete(player)); // true

        // Attempt the quest
        System.out.println(quest.attemptQuest(player));
    }
    */
}