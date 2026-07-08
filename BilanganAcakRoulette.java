import java.util.Random;

public class BilanganAcakRoulette {

    public static void main(String[] args) {

        Random random = new Random();

        System.out.println("=== Bilangan Acak Seleksi Roulette ===");

        for (int i = 1; i <= 6; i++) {
            double r = random.nextDouble(); // 0.0 - 1.0
            System.out.printf("r%d = %.3f\n", i, r);
        }

    }

}