package POSTTEST;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Barang {
    protected final String nama;
    protected int harga;
    protected int stok;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public abstract void tambahBarang();

    public void tampilkanDetail() {
        System.out.println("Detail Barang:");
        System.out.println("Nama: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}

final class Elektronik extends Barang {
    private final String merek;

    public Elektronik(String nama, int harga, int stok, String merek) {
        super(nama, harga, stok);
        this.merek = merek;
    }

    public String getMerek() {
        return merek;
    }

    @Override
    public void tambahBarang() {
        System.out.println("Method tambahBarang dari class Elektronik dipanggil");
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Merek: " + merek);
    }
}

final class BolaBilliard extends Barang {
    private final String jenisBola;

    public BolaBilliard(String nama, int harga, int stok, String jenisBola) {
        super(nama, harga, stok);
        this.jenisBola = jenisBola;
    }

    public String getJenisBola() {
        return jenisBola;
    }

    @Override
    public void tambahBarang() {
        System.out.println("Method tambahBarang dari class BolaBilliard dipanggil");
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Jenis Bola: " + jenisBola);
    }
}

public class posttest5 {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("=== Sistem Pendataan Toko Perlengkapan Billiard Sanjaya ===");
            System.out.println("1. Tambah Barang Elektronik");
            System.out.println("2. Tambah Barang Bola Billiard");
            System.out.println("3. Tampilkan Daftar Barang");
            System.out.println("4. Update Barang");
            System.out.println("5. Hapus Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    tambahBarangElektronik();
                    break;
                case 2:
                    tambahBarangBolaBilliard();
                    break;
                case 3:
                    tampilkanDaftarBarang();
                    break;
                case 4:
                    updateBarang();
                    break;
                case 5:
                    hapusBarang();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        } while (pilihan != 6);
    }

    private static void tambahBarangElektronik() {
        System.out.print("Masukkan nama barang elektronik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga barang: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan stok barang: ");
        int stok = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan merek elektronik: ");
        String merek = scanner.nextLine();

        Elektronik elektronik = new Elektronik(nama, harga, stok, merek);
        daftarBarang.add(elektronik);
        System.out.println("Barang elektronik berhasil ditambahkan!");
    }

    private static void tambahBarangBolaBilliard() {
        System.out.print("Masukkan nama bola billiard: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga barang: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan stok barang: ");
        int stok = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jenis bola billiard: ");
        String jenisBola = scanner.nextLine();

        BolaBilliard bolaBilliard = new BolaBilliard(nama, harga, stok, jenisBola);
        daftarBarang.add(bolaBilliard);
        System.out.println("Bola billiard berhasil ditambahkan!");
    }

    private static void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.println("Daftar Barang:");
            for (Barang barang : daftarBarang) {
                barang.tampilkanDetail();
            }
        }
    }

    private static void updateBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.print("Masukkan nama barang yang ingin diupdate: ");
            String nama = scanner.nextLine();
            boolean ditemukan = false;

            for (Barang barang : daftarBarang) {
                if (barang.getNama().equalsIgnoreCase(nama)) {
                    System.out.print("Masukkan harga baru: ");
                    int harga = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan stok baru: ");
                    int stok = Integer.parseInt(scanner.nextLine());

                    barang.setHarga(harga);
                    barang.setStok(stok);
                    ditemukan = true;
                    System.out.println("Barang berhasil diupdate!");
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Barang tidak ditemukan.");
            }
        }
    }

    private static void hapusBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.print("Masukkan nama barang yang ingin dihapus: ");
            String nama = scanner.nextLine();
            boolean ditemukan = false;
            for (int i = 0; i < daftarBarang.size(); i++) {
                if (daftarBarang.get(i).getNama().equalsIgnoreCase(nama)) {
                    daftarBarang.remove(i);
                    ditemukan = true;
                    System.out.println("Barang berhasil dihapus!");
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Barang tidak ditemukan.");
            }
        }
    }
}
