public class TestGameWorld {

    public static void main(String[] args) {
        // Test Player Class
        System.out.println("Testing Player Class...");
        Player player1 = new Player("Arthur", 100);
        Player player2 = new Player("", -10); // Invalid name and health
        System.out.println(player1); // Valid player
        System.out.println(player2); // Default values for invalid inputs
        player1.takeDamage(20); // Valid damage
        System.out.println("After taking 20 damage: " + player1);
        player1.takeDamage(-5); // Invalid damage
        player1.takeDamage(100); // Excessive damage
        System.out.println("After excessive damage: " + player1);

        // Test Artifact Class
        System.out.println("\nTesting Artifact Class...");
        Artifact artifact1 = new Artifact("Excalibur", 5, false);
        Artifact artifact2 = new Artifact("", 0, true); // Invalid name and rarity
        System.out.println(artifact1);
        System.out.println(artifact2);
        System.out.println(artifact1.useArtifact());
        System.out.println(artifact2.useArtifact());

        // Add artifacts to player
        System.out.println("\nTesting Artifact Collection...");
        player1.collectArtifact(artifact1);
        player1.collectArtifact(artifact2);
        System.out.println("Player after collecting artifacts: " + player1);

        // Test Companion Class
        System.out.println("\nTesting Companion Class...");
        Companion companion1 = new Companion("Merlin", "Mage", 80, player1);
        Companion companion2 = new Companion("", "Healer", 150, player1); // Invalid name and power
        Companion companion3 = new Companion("Galahad", "", 50, null); // Invalid role and owner
        System.out.println(companion1);
        System.out.println(companion2);
        System.out.println(companion3);
        System.out.println(companion1.useAbility());
        System.out.println(companion3.useAbility());

        // Test Quest Class
        System.out.println("\nTesting Quest Class...");
        Quest quest1 = new Quest("Defend the Village", 5);
        Quest quest2 = new Quest("", 15); // Invalid description and difficulty
        System.out.println(quest1);
        System.out.println(quest2);
        quest1.addRequiredCompanion(companion1);
        quest1.addRequiredCompanion(companion2);
        System.out.println("Quest after adding companions: " + quest1);

        System.out.println("Can complete quest: " + quest1.canComplete(player1)); // Check requirements
        player1.collectArtifact(new Artifact("Magic Shield", 4, false));
        System.out.println("Can complete quest after artifact: " + quest1.canComplete(player1));
        System.out.println(quest1.attemptQuest(player1));

        // Test GameWorld Class
        System.out.println("\nTesting GameWorld Class...");
        GameWorld world = GameWorld.getInstance();
        world.addPlayer(player1);
        world.addPlayer(player2);
        world.addArtifact(artifact1);
        world.addArtifact(artifact2);
        world.addQuest(quest1);

        System.out.println("Players in GameWorld: ");
        for (Player player : world.getPlayers()) {
            System.out.println(player);
        }

        System.out.println("Quests in GameWorld: ");
        for (Quest quest : world.getQuests()) {
            System.out.println(quest);
        }

        Artifact randomArtifact = world.getRandomArtifact();
        System.out.println("Random artifact: " + randomArtifact);

        // Singleton behavior test
        GameWorld anotherWorld = GameWorld.getInstance();
        System.out.println("Is GameWorld singleton? " + (world == anotherWorld));
    }
}
