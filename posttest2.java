package PERT1;

import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    private String nama;
    private int harga;
    private int stok;

    // Constructor
    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk harga
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Getter dan Setter untuk stok
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "nama='" + nama + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}

public class posttest2 {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("=== Sistem Pendataan Toko Perlengkapan Billiard Sanjaya ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Daftar Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    tampilkanDaftarBarang();
                    break;
                case 3:
                    updateBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        } while (pilihan != 5);
    }

    private static void tambahBarang() {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga barang: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok barang: ");
        int stok = scanner.nextInt();

        Barang barang = new Barang(nama, harga, stok);
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.println("Daftar Barang:");
            for (Barang barang : daftarBarang) {
                System.out.println(barang);
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
                    int harga = scanner.nextInt();
                    System.out.print("Masukkan stok baru: ");
                    int stok = scanner.nextInt();

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

