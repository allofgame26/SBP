import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<String>> aturan = new HashMap<>();
    private static final List<String> faktaAwal = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiAturan();
        inisialisasiFaktaAwal();

        List<String> faktaBaru = new ArrayList<>();
        while (true) {
            boolean adaPerubahan = false;
            for (String aturanKey : aturan.keySet()) {
                List<String> premis = aturan.get(aturanKey);
                boolean semuaPremisBenar = true;
                for (String premisItem : premis) {
                    if (!faktaAwal.contains(premisItem) && !faktaBaru.contains(premisItem)) {
                        semuaPremisBenar = false;
                        break;
                    }
                }

                if (semuaPremisBenar) {
                    String kesimpulan = aturanKey;
                    if (!faktaAwal.contains(kesimpulan) && !faktaBaru.contains(kesimpulan)) {
                        faktaBaru.add(kesimpulan);
                        adaPerubahan = true;
                        System.out.println("Menambahkan fakta baru: " + kesimpulan);
                    }
                }
            }

            if (!adaPerubahan) {
                break;
            }
        }

        System.out.println("Fakta akhir: " + faktaAwal);
        System.out.println("Fakta akhir: " + faktaBaru);

        if (faktaBaru.contains("K")) {
            System.out.println("Kesimpulan: K bernilai benar");
        } else {
            System.out.println("Kesimpulan: K tidak bernilai benar");
        }
    }

    private static void inisialisasiAturan() {
        aturan.put("C", List.of("A", "B"));
        aturan.put("D", List.of("C"));
        aturan.put("F", List.of("A", "E"));
        aturan.put("G", List.of("A"));
        aturan.put("D", List.of("F", "G"));
        aturan.put("H", List.of("G", "E"));
        aturan.put("I", List.of("C", "H"));
        aturan.put("J", List.of("I", "A"));
        aturan.put("J", List.of("G"));
        aturan.put("K", List.of("J"));
    }

    private static void inisialisasiFaktaAwal() {
        faktaAwal.add("A");
        faktaAwal.add("E");
    }
}
