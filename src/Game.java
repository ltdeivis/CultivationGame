import java.util.Scanner;

public class Game {
    private Human player;

    public Game() {
        init();
    }

    private void init() {
        player = new Human();
    }

    public void gameLoop() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayStats();

            System.out.println("Attempt Break Through(1)  |  Cultivate(2)");
            int answer = Integer.valueOf(scanner.nextLine());

            if (answer == 2) {
                System.out.println("How many years would you like to cultivate for?");
                System.out.print("Years to cultivate : ");
                int cultivateLoops = Integer.valueOf(scanner.nextLine());

                for(int i = 0; i < cultivateLoops; i++) {
                    player.cultivate(1);
                    displayStats();
                    Thread.sleep(700);
                }

                System.out.println("You've left secluded cultivation");
            } else {
                System.out.println("Atempting a breakthrough...");
                Thread.sleep(3500);
                if(player.breakthrough()) {
                    System.out.println("You've broken through to the " + player.getCultivationStage());
                } else {
                    System.out.println("You've failed to breakthrough and suffered cultivation dissonance");
                }
                System.out.println("Press any key to continue...");
                scanner.nextLine();
            }
        }
    }

    private void displayStats() {
        for(int i = 0; i < 25; i++) {
            System.out.println();
        }
        
        System.out.println("====================");
        System.out.println("Cultivation : " + player.getCultivationStage());
        System.out.println("Age         : " + player.getAge());
        System.out.println();
        System.out.println("Health : " + player.getHealth() + "   (+"+player.getHealthInc()+")");
        System.out.println("Qi     : " + player.getQiAmount()+"/"+player.getQiCapacity() + "   (+"+player.getQiAmountInc()+")");
        System.out.println();
        System.out.println("Qi Pwr      : " + player.getQiIntensity() + "   (+0)");
        System.out.println("Strengh     : " + player.getStrengh() + "   (+"+player.getStrenghInc()+")");
        System.out.println("Agility     : " + player.getAgility() + "   (+"+player.getAgilityInc()+")");
        System.out.println("Inteligence : " + player.getInteligence() + "   (+"+player.getInteligenceInc()+")");
        System.out.println("Durability  : " + player.getDurability() + "   (+"+player.getDurabilityInc()+")");
        System.out.println("Talent      : " + player.getTalent() + "   (+"+player.getTalentInc()+")");
        System.out.println();
        System.out.println("Breakthrough Qi Requirement : " + player.getBreakthroughQiReq());
        System.out.println("====================");
    }
}
