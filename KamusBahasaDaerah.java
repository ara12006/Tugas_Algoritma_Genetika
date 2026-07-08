import java.util.Scanner;

public class KamusBahasaDaerah {

    static Scanner input = new Scanner(System.in);

    // Database Kamus
    static String[][] kamus = {
        {"Tanrang", "Tangga Bambu"},
        {"Gatta", "Karet"},
        {"Panrak", "Rusak"},
        {"Tappuk", "Putus"},
        {"Lanrak", "Jaring"},
        {"Jappuk", "Genggam"},
        {"Tanjak", "Wajah"},
        {"Bakka", "Besar"},
        {"Lumpak", "Lompat"},
        {"Nakke", "Saya"}
    };
    // Target pencarian
    static String target = "TANJAK";

    // Populasi awal
    static String[] populasi = {
            "PANRAK",
            "TAPPUK",
            "JAPPUK",
            "TANJAK",
            "LANRAK",
            "LUMPAK"
        };

    // Fitness hasil perhitungan
    static double[] fitness = {
            0.667,
            0.500,
            0.333,
            1.000,
            0.667,
            0.333
        };
    // Bilangan acak hasil program
    static double[] randomRoulette = {
            0.063,
            0.451,
            0.916,
            0.589,
            0.375,
            0.471
        };

        // Parent hasil seleksi
    static String[] parent = {
            "PANRAK",
            "TANJAK",
            "LUMPAK",
            "TANJAK",
            "JAPPUK",
            "TANJAK"
        };

        // Child hasil crossover
    static String[] child = {
            "PANJAK",
            "TANRAK",
            "LUMJAK",
            "TANPAK",
            "JAPJAK",
            "TANPUK"
        };
    // Child setelah mutasi
    static String[] mutasi = {
        "PANJAK",
        "TANJAK",
        "LUMJAK",
        "TANPAK",
        "JAPJAK",
        "TANPUK"
    };

    // Fitness generasi baru
    static double[] fitnessBaru = {
        0.833,
        1.000,
        0.500,
        0.833,
        0.667,
        0.667
    };
    public static void main(String[] args) {

        int pilih;

        do {

            System.out.println();
            System.out.println("==================================");
            System.out.println("      KAMUS BAHASA DAERAH");
            System.out.println("==================================");
            System.out.println("1. Tampilkan Kamus");
            System.out.println("2. Cari Kata");
            System.out.println("3. Jalankan Algoritma Genetika");
            System.out.println("4. Tampilkan Populasi");
            System.out.println("5. Hasil Fitness");
            System.out.println("6. Seleksi Roulette");
            System.out.println("7. Cross Over");
            System.out.println("8. Mutasi");
            System.out.println("9. Generasi Baru");
            System.out.println("10. Keluar");
            System.out.println("==================================");
            System.out.print("Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    tampilkanKamus();
                    break;

                case 2:
                    cariKata();
                    break;

                case 3:
                    jalankanGA();
                    break;

                case 4:
                    tampilkanPopulasi();
                    break;

                case 5:
                    hasilFitness();
                    break;

                case 6:
                    seleksiRoulette();
                    break;

                case 7:
                    crossOver();
                    break;

                case 8:
                    mutasi();
                    break;

                case 9:
                    generasiBaru();
                    break;

                case 10:
                    System.out.println("\nTerima kasih...");
                    break;

                default:
                    System.out.println("\nMenu tidak tersedia.");

            }

        } while (pilih != 10);

    }

    // ==========================
    // MENU 1
    // ==========================

    static void tampilkanKamus() {

        System.out.println();
        System.out.println("=========== KAMUS BAHASA SELAYAR ===========");

        System.out.printf("%-5s %-15s %-20s\n",
                "No", "Bahasa Selayar", "Bahasa Indonesia");

        for (int i = 0; i < kamus.length; i++) {

            System.out.printf("%-5d %-15s %-20s\n",
                    i + 1,
                    kamus[i][0],
                    kamus[i][1]);

        }

    }

    // ==========================
    // MENU 2
    // ==========================

    static void cariKata() {

        System.out.print("\nMasukkan kata yang dicari : ");
        String cari = input.nextLine();

        boolean ketemu = false;

        for (int i = 0; i < kamus.length; i++) {

            if (kamus[i][0].equalsIgnoreCase(cari)) {

                System.out.println();
                System.out.println("Kata ditemukan");
                System.out.println("------------------------------");
                System.out.println("Bahasa Selayar   : " + kamus[i][0]);
                System.out.println("Bahasa Indonesia : " + kamus[i][1]);

                ketemu = true;
                break;

            }

        }

        if (!ketemu) {

            System.out.println("\nMaaf, kata tidak ditemukan.");

        }

    }
    // ==========================
        // MENU 3
        // ==========================

        static void jalankanGA() {

            System.out.println();
            System.out.println("========== ALGORITMA GENETIKA ==========");
            System.out.println("Target Kata : " + target);
            System.out.println("Jumlah Gen  : " + target.length());
            System.out.println();

            System.out.println("Tahapan Algoritma Genetika");
            System.out.println("1. Representasi Individu");
            System.out.println("2. Perhitungan Fitness");
            System.out.println("3. Seleksi Roulette");
            System.out.println("4. Cross Over");
            System.out.println("5. Mutasi");
            System.out.println("6. Generasi Baru");
        }
        // ==========================
        // MENU 4
        // ==========================

        static void tampilkanPopulasi() {

            System.out.println();
            System.out.println("========= POPULASI AWAL =========");

            System.out.printf("%-10s %-15s\n",
                    "Individu",
                    "Kromosom");

            for (int i = 0; i < populasi.length; i++) {

                System.out.printf("I%-9d %-15s\n",
                        i + 1,
                        populasi[i]);

            }

        }
        // ==========================
        // MENU 5
        // ==========================

        static void hasilFitness() {

            System.out.println();
            System.out.println("============= FITNESS =============");

            System.out.printf("%-10s %-15s %-10s\n",
                    "Individu",
                    "Kromosom",
                    "Fitness");

            double total = 0;

            for (int i = 0; i < populasi.length; i++) {

                System.out.printf("I%-9d %-15s %.3f\n",
                        i + 1,
                        populasi[i],
                        fitness[i]);

                total += fitness[i];

            }

            System.out.println("----------------------------------------");
            System.out.printf("Total Fitness : %.3f\n", total);

        }
        // ==========================
        // ==========================
        // MENU 6
        // ==========================

        static void seleksiRoulette() {

            System.out.println();
            System.out.println("========== SELEKSI ROULETTE ==========");

            System.out.printf("%-8s %-12s %-20s %-15s\n",
                    "Putaran",
                    "Random",
                    "Interval",
                    "Terpilih");

            String[] interval = {
                "0.000-0.191",
                "0.429-0.715",
                "0.906-1.001",
                "0.429-0.715",
                "0.334-0.429",
                "0.429-0.715"
            };

            for (int i = 0; i < parent.length; i++) {

                System.out.printf("%-8d %-12.3f %-20s %-15s\n",
                        i + 1,
                        randomRoulette[i],
                        interval[i],
                        parent[i]);

            }

            System.out.println();
            System.out.println("Parent Terpilih");

            for (int i = 0; i < parent.length; i++) {

                System.out.println("P" + (i + 1) + " = " + parent[i]);

            }

        }
    // ==========================
    // MENU 7
    // ==========================

    static void crossOver() {

        System.out.println();
        System.out.println("========== CROSS OVER ==========");

        System.out.println();
        System.out.println("Pasangan Parent 1");
        System.out.println("P1 : PANRAK");
        System.out.println("P2 : TANJAK");
        System.out.println("Child 1 : PANJAK");
        System.out.println("Child 2 : TANRAK");

        System.out.println();
        System.out.println("Pasangan Parent 2");
        System.out.println("P3 : LUMPAK");
        System.out.println("P4 : TANJAK");
        System.out.println("Child 3 : LUMJAK");
        System.out.println("Child 4 : TANPAK");

        System.out.println();
        System.out.println("Pasangan Parent 3");
        System.out.println("P5 : JAPPUK");
        System.out.println("P6 : TANJAK");
        System.out.println("Child 5 : JAPJAK");
        System.out.println("Child 6 : TANPUK");

        System.out.println();
        System.out.println("========== HASIL CROSS OVER ==========");

        System.out.printf("%-10s %-15s\n",
                "Child",
                "Kromosom");

        for (int i = 0; i < child.length; i++) {

            System.out.printf("C%-9d %-15s\n",
                    i + 1,
                    child[i]);

        }

    }
    // ==========================
    // MENU 8
    // ==========================

    static void mutasi() {

        System.out.println();
        System.out.println("========== MUTASI ==========");

        System.out.println("Child yang dipilih : TANRAK");
        System.out.println("Gen yang dimutasi  : Gen ke-4");
        System.out.println("Huruf sebelum      : R");
        System.out.println("Huruf sesudah      : J");

        System.out.println();

        System.out.println("Sebelum Mutasi : TANRAK");
        System.out.println("Sesudah Mutasi : TANJAK");

        System.out.println();

        System.out.println("Fitness Setelah Mutasi = 1.000");

    }
    // ==========================
    // MENU 9
    // ==========================

    static void generasiBaru() {

        System.out.println();
        System.out.println("========== GENERASI BARU ==========");

        System.out.printf("%-10s %-15s %-10s\n",
                "Individu",
                "Kromosom",
                "Fitness");

        for (int i = 0; i < mutasi.length; i++) {

            System.out.printf("I%-9d %-15s %.3f\n",
                    i + 1,
                    mutasi[i],
                    fitnessBaru[i]);

        }

        System.out.println("--------------------------------------");
        System.out.println("Fitness Terbaik : 1.000");
        System.out.println("Kromosom Terbaik: TANJAK");
        System.out.println();
        System.out.println("Target berhasil ditemukan.");
        System.out.println("Proses Algoritma Genetika selesai.");

    }
}
