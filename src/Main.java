public class Main {

    public static void main(String[] args) {
        System.out.println("Test");

        Game game = new Game();

        try {
            game.gameLoop();
        } catch (Exception e) {
            return;
        }
    }
}