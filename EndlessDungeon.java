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

        String[] monsters = {"Vampire", "Kraken", "Zombie",
                "T-800", "Xenomorph"};

        Scanner playerInput = new Scanner(System.in);
        Random generator = new Random();

        String MonsterName = monsters[generator.nextInt(5)];
        int monsterHealth = generator.nextInt(10) + 5;
        int monsterAttack = generator.nextInt(10) + 5;
        int monsterDefense = generator.nextInt(10) + 5;
        int monsterDexterity = generator.nextInt(10) + 5;
        boolean monsterDodge = false;
        boolean monsterDefending = false;

        while( playerHealth > 0 && monsterHealth > 0){
            System.out.println("Make a choice:\n1 - Attack\n2 - Defend\n3 - Dodge\n");
            int playerChoice = playerInput.nextInt();
            if(playerChoice == 1){
                if(monsterDodge){
                    System.out.println(MonsterName + " dodged the attack!");
                    monsterDodge = false;
                }
                else if(monsterDefending){
                    monsterHealth -= playerAttack - (playerAttack * ((monsterDefense * 4) / 100));
                    monsterDefending = false;
                }
                else{
                    monsterHealth -= playerAttack - (playerAttack * ((monsterDefense) / 100));
                }
            }
            else if(playerChoice == 2){
                playerDefending = true;
            }
            else if(playerChoice == 3){
                int dodgeChance = generator.nextInt(100);
                dodgeChance += playerDexterity;
                if(dodgeChance > 50){
                    playerDodge = true;
                }
                else{
                    System.out.println("You fumbled.");
                }
            }
            else{
                System.out.println("You entered an invalid choice, you lose your turn.");
            }
            // TODO - ENEMY ACTION
            // TODO - WIN/LOSE
            // TODO - BIG LOOP FOR EACH MONSTER
            // TODO - BIGGER LOOP TO RESTART THE GAME
        }

    }
}
