import java.util.*;
public class ManageUser
{
	public static Vector<UserLogin> dataUser = new Vector<UserLogin>();
	public static Scanner Scn = new Scanner(System.in);
	
	
	public static void MenuAdmin() //menu admin
	{
		//boolean halamanAdmin = false;
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("===================================");
			System.out.println("     Menu Admin    ");
			System.out.println("   Toko Shoes Line ");
			System.out.println("===================================");
			System.out.println("1. Barang");
			System.out.println("2. Laporan Penjualan");
			System.out.println("3. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-3): ");
			Pilihan = Scn.nextInt();
			switch(Pilihan)
			{
				case 1 : ManageBarang.Buah();
				break;
				case 2 : ManageBarang.reportPenjualan();
				break;
			}
		}while(Pilihan < 3);
	}
	
	public static void MenuKasir() //menu kasir
	{
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("====================================");
			System.out.println("     Menu Kasir    ");
			System.out.println("   Toko Shoes Line ");
			System.out.println("====================================");
			System.out.println("1. Penjualan");
			System.out.println("2. Lihat Data Barang");
			System.out.println("3. Lihat Penjualan Barang");
			System.out.println("4. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-4) : ");
			Pilihan = Scn.nextInt();
			switch(Pilihan)
			{
				case 1 : ManageBarang.penjualan();
				break;
				case 2 : ManageBarang.LihatBarang();
				break;
				case 3 : ManageBarang.cetakTransaksi();
				break;
			}
		}while(Pilihan < 4);
		
	}
	
	
	public static void main(String[] args)
	{
		dataUser.add(new UserLogin("Aldi","123","Admin"));
		dataUser.add(new UserLogin("Adi","321","Kasir"));
		int Pilihan = 0;
		boolean loginSukses = false;
		if(!cekPass())
		{
			loginSukses = true;
		}
	}
	
	public static boolean cekPass() // Cek User dan Password
	{
		boolean Benar = false;
		//String userLgn = "";
		//String passLgn = "";
		int i = 0;
		do
		{
			
			System.out.println();
			System.out.println("-------Login--------");
			System.out.println();
			System.out.print("Masukkan Username : ");
			String userLgn = Scn.next();
			System.out.print("Masukkan Password : ");
			String passLgn = Scn.next();
			System.out.println();
			int a = 0;
			int idx = -1;
			do
			{
				if(dataUser.elementAt(a).checkPassUser(userLgn, passLgn, "Admin"))
				{
					System.out.println("\"Selamat Anda Login Sebagai Admin\"");
					Benar = true;
					MenuAdmin();
				}
				else if(dataUser.elementAt(a).checkPassUser(userLgn, passLgn, "Kasir"))
				{
					System.out.println("\"Selamat Anda Login Sebagai Kasir\"");
					Benar = true;
					MenuKasir();
				}
				a++;
			}while(a < dataUser.size());
			i++;
		}while((Benar = true));
		System.out.println("");
		System.out.println("======================================");
		System.out.println("\"Maaf Anda Tidak Berhasil Login\"");
		System.out.println("======================================");
		return Benar;
	}
}