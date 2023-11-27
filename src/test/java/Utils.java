public class Utils {
    public static void espera(){
        int waitTime = 3500;
        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
