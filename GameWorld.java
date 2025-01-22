import java.util.Random;

public class GameWorld {

    private Player[] players;
    private int numPlayers;
    private Artifact[] artifacts;
    private int numArtifacts;
    private Quest[] quests;
    private int numQuests;

    private static GameWorld instance;

    private GameWorld(){

        //defining players size 100 and  initialized as an empty array
        this.players = new Player[100];
        this.numPlayers = 0;

        //defining artifacts size 50 and  initialized as an empty array
        this.artifacts = new Artifact[50];
        this.numArtifacts = 0;

        //defining quest size 20 and  initialized as an empty array
        this.quests = new Quest[20];
        this.numQuests = 0;


    }

    // Get the Singleton instance
    public static GameWorld getInstance() {
        if (instance == null) {
        instance = new GameWorld();
        }
        return instance;
    }

    //resetting game world data
    public static GameWorld resetWorld() {
        GameWorld.instance = new GameWorld();
        return GameWorld.instance;
    }

    //method to add player
    public boolean addPlayer(Player player){
        for(int i=0;i<100;i++){
            if (players[i]==null) {
                players[i]= player; //placing artifact into inventory
                numPlayers++; //num Artifacts increment
                return true;
            }
        }
        System.out.println("Error: Cannot add more players to the GameWorld.");
        return false;
    }

    //method to add artifact
    public boolean addArtifact(Artifact artifact){
        for(int i=0;i<50;i++){
            if (artifacts[i]==null) {
                artifacts[i]= artifact; //placing artifact into inventory
                numArtifacts++; //num Artifacts increment
                return true;
            }
        }
        System.out.println("Error: Cannot add more artifacts to the GameWorld.");
        return false;
    }

    //method to add quest
    public boolean addQuest(Quest quest){
        for(int i=0;i<20;i++){
            if (quests[i]==null) {
                quests[i]= quest; //placing artifact into inventory
                numQuests++; //num Artifacts increment
                return true;
            }
        }
        System.out.println("Error: Cannot add more quests to the GameWorld.");
        return false;
    }
    
    //method to get random artifact
    public Artifact getRandomArtifact(){
        if (numArtifacts==0) {
            System.out.println("Error: No artifacts available in the GameWorld.");
            return null;
        }

        Random random = new Random();
        int randomArtifact = random.nextInt(numArtifacts); // to get random artifact between available artifact
        return artifacts[randomArtifact];
    }

    //method get players array copy
    public Player[] getPlayers(){
        Player[] playersCopy = new Player[numPlayers];
        System.arraycopy(players, 0, playersCopy, 0, numPlayers); //using swallow copy to copy player array
        return playersCopy;
    }

    //method get quest array copy
    public Quest[] getQuests(){
        Quest[] questsCopy = new Quest[numQuests];
        System.arraycopy(quests, 0, questsCopy, 0, numQuests); //using swallow copy to copy quest array
        return questsCopy;
    }

    /*
    public static void main(String[] args) {
        GameWorld world = GameWorld.getInstance();

        // Add players
        Player player1 = new Player("Arthur", 100);
        Player player2 = new Player("Merlin", 90);
        world.addPlayer(player1);
        world.addPlayer(player2);
        // Add artifacts
        Artifact artifact1 = new Artifact("Excalibur", 5, false);
        Artifact artifact2 = new Artifact("Pandora's Box", 4, true);
        world.addArtifact(artifact1);
        world.addArtifact(artifact2);
        // Add quests
        Quest quest1 = new Quest("Defend the Village", 5);
        Quest quest2 = new Quest("Find the Holy Grail", 7);
        world.addQuest(quest1);
        world.addQuest(quest2);
        // Get players and quests
        for (Player player : world.getPlayers()) {
        System.out.println(player);
        }
        for (Quest quest : world.getQuests()) {
        System.out.println(quest);
        }
        // Get a random artifact
        Artifact randomArtifact = world.getRandomArtifact();
        System.out.println("Random Artifact: " + randomArtifact);
        // Try adding beyond capacity
        for (int i = 0; i < 101; i++) {
        world.addPlayer(new Player("ExtraPlayer" + i, 100));
        }
    }
     */
}