/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum_modul_2;

/**
 *
 * @author khoirul-06990
 */
import java.util.Scanner;
public class proses {
        String nama, npm;
        String[] mata_kuliah = new String[2];
        int[] nilai_ets = new int[2];
        int[] nilai_eas = new int[2];
        int nilai_akhir;
    private static class node extends proses
    {
//        String nama, npm;
//        String[] mata_kuliah = new String[2];
//        int[] nilai_ets = new int[2];
//        int[] nilai_eas = new int[2];
//        int nilai_akhir;
        
        node next;
    
        node(String nama, String npm, String[] mata_kuliah, int[] nilai_ets, int[]nilai_eas,int akhir)
        {
            this.nama = nama;
            this.npm = npm;
            this.mata_kuliah[0] = mata_kuliah[0];
            this.mata_kuliah[1] = mata_kuliah[1];
            this.nilai_ets[0] = nilai_ets[0];
            this.nilai_ets[1] = nilai_ets[1];
            this.nilai_eas[0] = nilai_eas[0];
            this.nilai_eas[1] = nilai_eas[1];
            this.nilai_akhir  = akhir;
            this.next = null;
        }
    }
    
    node simpul;
    
    public int akhir(int[] nilai_ets, int[]nilai_eas)
    {
        int b = 0, c = 0, d;
        for(int i = 0; i<nilai_ets.length; i++)
        {
            b = b + nilai_ets[i];    
            c = c + nilai_eas[i];
        }
        
        d = ((b/2)+(c/2))/2;
        return d;
    }
   
    
    void tambah(proses list, String nama, String npm, String[] mata_kuliah, int[] nilai_ets, int[]nilai_eas, int nilai_akhir)
    {
        node mahasiswa = new node(nama,npm,mata_kuliah,nilai_ets,nilai_eas,nilai_akhir);
        if (list.simpul ==null)
        {
            list.simpul = mahasiswa;
        }
        else
        {
            mahasiswa.next = list.simpul.next;
            list.simpul.next = mahasiswa;
        }
    }
    
    void hapus(proses list)
    {
        node hilang = list.simpul;
        if (hilang.next == null)
        {
            hilang.next = null;
            System.out.println("data kosong");
        }
        else
        {
            hilang.next = hilang.next.next;
            hilang.next = null;
        }
    }
    
    void cetak(proses list)
    {
        node view = list.simpul;
        while(view != null)
        {
            System.out.println("nama : "+view.nama);
            System.out.println("npm : "+view.npm);
            System.out.println("mata kuliah pertama : "+view.mata_kuliah[0]);
            System.out.println("mata kuliah kedua : "+view.mata_kuliah[1]);
            System.out.println("nilai ets pertama : "+view.nilai_ets[0]);
            System.out.println("nilai ets kedua : "+view.nilai_ets[1]);
            System.out.println("nilai eas pertama : "+view.nilai_eas[0]);
            System.out.println("nilai eas kedua : "+view.nilai_eas[1]);
            System.out.println("nilai akhir : "+view.nilai_akhir);
            view = view.next;
        }
    }
    public void main()
    {
        proses proses=new proses();
        Scanner input = new Scanner(System.in);
        int pilih;
       do{
           System.out.println("");
           System.out.println("1. masukan data     2. hapus data       3. view");
           System.out.println("");
           System.out.println("masukan pilihan anda");
           pilih = input.nextInt();

            switch (pilih)
            {
                case 1: 
                    System.out.println("");
                    System.out.println("=== Input Data ===");
                    System.out.println("");
                    System.out.println("masukan nama : ");
                    proses.nama = input.next();
                    System.out.println("masukan npm : ");
                    proses.npm = input.next();
                    System.out.println("masukan nama mata kuliah : ");
                    System.out.println("");
                    for(int i=0; i<2; i++)
                    {
                        System.out.println("mata kuliah ke-"+(i+1));
                        String ets = input.next();
                        proses.mata_kuliah[i] = ets;
                    }
                    System.out.println("masukan nilai ets : ");
                    System.out.println("");
                    for(int i=0; i<2; i++)
                    {
                        System.out.println("nilai ets "+proses.mata_kuliah[i]);
                        int ets = input.nextInt();
                        proses.nilai_ets[i] = ets;
                    }
                    System.out.println("masukan nilai eas : ");
                    System.out.println("");
                    for(int i=0; i<2; i++)
                    {
                        System.out.println("nilai eas "+proses.mata_kuliah[i]);
                        int eas = input.nextInt();
                        proses.nilai_eas[i] = eas;
                    }
                    proses.nilai_akhir = proses.akhir(proses.nilai_ets, proses.nilai_eas);
                    proses.tambah(proses, proses.nama, proses.npm, proses.mata_kuliah, proses.nilai_ets, proses.nilai_eas, proses.nilai_akhir);
                    System.out.println("==================");
                    break;

                case 2 :
                    System.out.println("");
                    System.out.println("=== Hapus Data ===");
                    System.out.println("");
                    proses.hapus(proses);
                    System.out.println("==================");

                    break;

                case 3 :
                    System.out.println("");
                    System.out.println("=== List Data ===");
                    System.out.println("");
                    proses.cetak(proses);
                    System.out.println("==================");
                    break;
            }
       }
        while(pilih!=4);
    }
}
