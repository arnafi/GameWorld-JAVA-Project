public class Artifact {

    private String name;
    private int rarity;
    private boolean isCursed;
    static int totalArtifacts;


    //artifact constructor
    public Artifact(String name, int rarity, boolean isCursed) {

        //artifact name error handle
        if (name==null || name.trim().isEmpty() ) {
            System.out.println("Error: Artifact name cannot be null or empty");
            this.name = "Unknown";
        } 
        else {
            this.name = name;
        }

        //artifact rarity error handle
        if (rarity<1 || rarity>5) {
            System.out.println("Error: Rarity must be between 1 and 5");
            this.rarity = 1;
        } 
        else {
            this.rarity = rarity;
        }

        this.isCursed = isCursed;

        totalArtifacts++; // Increment Artifacts
    }

    //method to get name
    public String getName() {
        return name;
    }

    //method to get rarity
    public int getRarity() {
        return rarity;
    }

    //method to check curse
    public boolean isCursed() {
        return isCursed;
    }

    //method to get totalArtifacts
    public static int getTotalArtifacts(){
        return totalArtifacts;
    }

    //method to useArtifact
    public String useArtifact(){
        if (isCursed) {
            return "The artifact is cursed! Beware!";
        }
        else{
            return "You use the " + name + " artifact. It glows with magical power!";
        }
    }

    //method to print artifact information
    public String toString() {
        return "Artifact{name='" + name + "', rarity=" + rarity + ", isCursed=" + isCursed + "}";
    }


    //resetting total value (This method is mainly for testing purposes)
    public static void resetTotalArtifacts(){
        totalArtifacts = 0;
    }



    //for testing
    /* 
    public static void main(String[] args) {
        // Valid artifact
        Artifact artifact1 = new Artifact("Excalibur", 5, false);
        System.out.println(artifact1);
        System.out.println(artifact1.useArtifact());

        // Invalid artifact name
        Artifact artifact2 = new Artifact("", 3, true);
        System.out.println(artifact2);

        // Invalid rarity
        Artifact artifact3 = new Artifact("Pandora's Box", 0, true);
        System.out.println(artifact3);

        // Both invalid
        Artifact artifact4 = new Artifact("", 6, false);
        System.out.println(artifact4);

        // Static method usage
        System.out.println("Total artifacts created: " + Artifact.getTotalArtifacts());
    }
    */
}