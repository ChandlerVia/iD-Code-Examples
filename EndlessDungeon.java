import java.util.Random;
import java.util.Scanner;

/* Purpose: the game puts you into a fight against a monster
 *      the you kill monsters till you die yourself, then
 *      the game tells you how many monsters you killed and
 *      keeps a scoreboard. Then it repeats and lets you
 *      play again.
 */
public class EndlessDungeon {
    public static void main(String[] args) {
        int playerHealth = 100;
        int playerAttack = 10;
        int playerDefense = 10;
        int playerDexterity = 10;
        boolean playerDodge = false;
        boolean playerDefending = false;
        int roomCount = 0;

        String[] monsters = {"Vampire", "Kraken", "Zombie",
                "T-800", "Xenomorph"};

        Scanner playerInput = new Scanner(System.in);
        Random generator = new Random();

        while(playerHealth > 0) {

            String MonsterName = monsters[generator.nextInt(5)];
            int monsterHealth = generator.nextInt(50) + 5;
            int monsterAttack = generator.nextInt(10) + 20;
            int monsterDefense = generator.nextInt(10) + 5;
            int monsterDexterity = generator.nextInt(10) + 5;
            boolean monsterDodge = false;
            boolean monsterDefending = false;

            System.out.println("*******************************");
            System.out.println(MonsterName + " has appeared!");
            System.out.println("*******************************");

            while (playerHealth > 0 && monsterHealth > 0) {
                System.out.println("Your health: " + playerHealth);
                System.out.println("Name: " + MonsterName + " Health: " + monsterHealth);
                System.out.println("Make a choice:\n1 - Attack\n2 - Defend\n3 - Dodge\n");
                int playerChoice = playerInput.nextInt();
                if (playerChoice == 1) {
                    if (monsterDodge) {
                        System.out.println(MonsterName + " dodged the attack!");
                        monsterDodge = false;
                    } else if (monsterDefending) {
                        System.out.println(MonsterName + " is defending, but took damage!");
                        monsterHealth -= playerAttack - (playerAttack * ((monsterDefense * 4) / 100));
                        monsterDefending = false;
                    } else {
                        System.out.println(MonsterName + " took a whole hit!");
                        monsterHealth -= playerAttack - (playerAttack * ((monsterDefense) / 100));
                    }
                } else if (playerChoice == 2) {
                    System.out.println("You are bracing yourself!");
                    playerDefending = true;
                } else if (playerChoice == 3) {
                    int dodgeChance = generator.nextInt(100);
                    dodgeChance += playerDexterity;
                    if (dodgeChance > 50) {
                        System.out.println("You readied yourself to dodge!");
                        playerDodge = true;
                    } else {
                        System.out.println("You fumbled.");
                    }
                } else {
                    System.out.println("You entered an invalid choice, you lose your turn.");
                }
                // TODO - ENEMY ACTION
                int monsterChoice = generator.nextInt(100);

                if (monsterChoice < 40) {
                    if (playerDodge) {
                        System.out.println("You dodged the attack!");
                    } else if (playerDefending) {
                        System.out.println("You took some damage!");
                        playerHealth -= monsterAttack - (monsterAttack * ((playerDefense * 4) / 100));
                    } else {
                        System.out.println("You took a whole hit!");
                        playerHealth -= monsterAttack - (monsterAttack * ((playerDefense) / 100));
                    }
                } else if (monsterChoice < 70) {
                    System.out.println(MonsterName + " braces itself!");
                    monsterDefending = true;
                } else {
                    int dodgeChance = generator.nextInt(100);
                    dodgeChance += monsterDexterity;
                    if (dodgeChance > 50) {
                        System.out.println(MonsterName + " gets ready to dodge!");
                        monsterDodge = true;
                    } else {
                        System.out.println(MonsterName + " fumbled.");
                    }
                }


                // TODO - WIN/LOSE
                // TODO - BIG LOOP FOR EACH MONSTER
                // TODO - BIGGER LOOP TO RESTART THE GAME
            }
            if (playerHealth > 0) {
                System.out.println("You won this battle!");
                roomCount++;
                //We won
            } else if (monsterHealth > 0) {
                System.out.println("You lost to the " + MonsterName);
                //We lost
            } else {
                System.out.println("It was a draw");
                //We tied, but technically still lost
            }
        }
        System.out.println("You cleared " + roomCount + " rooms in the dungeon! Try again!");
    }
}
