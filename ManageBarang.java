import java.text.SimpleDateFormat;
import java.util.*;
public class ManageBarang
{
	public static Vector<dataBarang> dbBarang = new Vector<dataBarang>();
	public static Vector<UserLogin> dataUser = new Vector<UserLogin>();
	public static Vector<dtransaksi> dtr = new Vector<dtransaksi>();
	public static Scanner Scn = new Scanner(System.in);
	public static Transaksi tr;
	/*public static Vector idTrans = new Vector();
	public static Vector idBarang = new Vector();
	public static Vector hargaJual = new Vector();
	public static Vector nmBarang = new Vector();*/
	public static String idTrans;
	public static String idBarang;
	public static int hargaJual;
	public static double totTrans;
	public static String cetakHasil="";
	public static String hasilReport;
	public static Vector <Double>subTotal = new Vector<Double>();
	public static Vector <Double>Total = new Vector<Double>();
	public static Vector kuantiti = new Vector();
	
	public static void Buah() //menu buah
	{
		dbBarang.add(new dataBarang("B001","Adidas",900000));
		dbBarang.add(new dataBarang("B002","Converse",150000));
		dbBarang.add(new dataBarang("B003","Nike",450000));
		dbBarang.add(new dataBarang("B004","Puma",200000));
		dbBarang.add(new dataBarang("B005","Specs",300000));
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("=========================================");
			System.out.println("     Toko Shoes Line     ");
			System.out.println("=========================================");
			System.out.println();
			System.out.println("1. Tambah Barang");
			System.out.println("2. Lihat Barang");
			System.out.println("3. Update Barang");
			System.out.println("4. Cari Barang");
			System.out.println("5. Hapus Barang");
			System.out.println("6. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-6): ");
			Pilihan = Scn.nextInt();
			System.out.println();
			switch(Pilihan)
			{
				case 1 : TambahBarang();
				break;
				case 2 : LihatBarang();
				break;
				case 3 : UpdateBarang();
				break;
				case 4 : Cari();
				break;
				case 5 : HapusBarang();
				break;
			}
		}while(Pilihan < 6);
	}
		
	public static void TambahBarang() //tambah buah
	{
		System.out.println();
		System.out.println("=========================================");
		System.out.println("     Tambah Data Barang Baru     ");
		int index = 0;
		String ID = "";
		boolean valid = false;
		do
		{
			System.out.print("ID Barang   : ");
			ID = Scn.next();
			index = cariIdxID(ID,dbBarang);
			if(index != - 1)
			{
				System.out.println("ID " + ID + " Sudah ada dalam Tabel Barang");
			}
			else
			{
				valid = true;
			}
		}
		while(!valid);
		System.out.print("Masukkan Nama Barang \t : ");
		String nmBarang = Scn.next();
		System.out.print("Masukkan Harga Barang \t : Rp. ");
		int hgBarang = Scn.nextInt();
		dbBarang.add(new dataBarang(ID, nmBarang, hgBarang));
	}
	
	public static void LihatBarang() //lihat buah
	{
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("No. ID\t\tNama\t\tHarga Beli\t\tHarga Jual");
		System.out.println("==================================================================");
		int i = 0;
		for(dataBarang vBarang : dbBarang)
		{
			System.out.println((i+1) + ".  " + vBarang.getId() + "\t" + vBarang.getNamaBarang() + "\t\tRp. " + vBarang.getHargaBarang() + "\t\tRp. " + vBarang.getHargaJual());
			i++;
		}
		System.out.println("==================================================================");
	}
	
	public static void HapusBarang() //hapus buah
	{
		int idx = -1;
		int i = 0;
		System.out.println();
		System.out.println("=========================================");
		System.out.println("     Hapus Data Barang     ");
		System.out.print("Masukkan ID Barang yang akan dihapus \t: ");
		String ID = Scn.next();
		do
		{
			if(dbBarang.elementAt(i).getId().equals(ID))
			{
				idx = i;
			}
			i++;
		}while((i < dbBarang.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(ID + " Tidak ada ditemukan");
		}
		else
		{
			System.out.print("Apakah Barang " + ID + " akan dihapus (Y / T) : ");
			String Hapus = Scn.next();
			if(Hapus.equalsIgnoreCase("Y"))
			{
				dbBarang.removeElementAt(idx);
				System.out.println("Barang " + ID + " Berhasil dihapus");
				System.out.println("=========================================");
			}
		}
	}
	
	public static int cariIdxID(String Key, Vector<dataBarang> dbBarang) //cari id
	{
		int idx = -1;
		int i = 0;
		while((i < dbBarang.size()) && (idx == -1))
		{
			if(dbBarang.elementAt(i).getId().equals(Key))
			{
				idx = i;
			}
				i++;
		}
		return idx;
	}
	
	public static int cariIdxNama(String Key, Vector<dataBarang> dbBarang) //cari id nama
	{
		int idx = -1;
		int i = 0;
		while((i < dbBarang.size()) && (idx == -1))
		{
			if(dbBarang.elementAt(i).getNamaBarang().equals(Key))
			{
				idx = i;
			}
				i++;
		}
		return idx;
	}
	
	public static void penjualan() //transaksi
	{
		int index = 0; 
		String namaBarang = "";
		String Trans = "";
		String Tambah = "";
		int jml = 0 ;
		double Ttl = 0;
			System.out.println("");
			System.out.println("=======================================");
			System.out.print("TR#");
			Trans = Scn.next();
			tr = new Transaksi(Trans);
			cetakHasil="";
			do
			{
				System.out.print("Nama Barang   : ");
				namaBarang = Scn.next();
				index = cariIdxNama(namaBarang,dbBarang);
				if(index != - 1)
				{
					String id = dbBarang.elementAt(index).getId();
					double hargaBeli = dbBarang.elementAt(index).getHargaJual();
					dataBarang dbB = new dataBarang(id, namaBarang, hargaBeli);
					System.out.print("Kuantitas : ");
					double q = Scn.nextDouble();
					dtransaksi dtr = new dtransaksi(dbB, q);
					tr.tambah(dtr);
					cetakHasil+=dbB.getId()+ "\t\t" + dbB.getNamaBarang() + "\t" + dbB.getHargaJual() + "\t" + dtr.getKuantiti() + "\t" + dtr.htgSubTotal() +"\n";
					System.out.println("============================================================");
					totTrans+=dtr.htgSubTotal();
					System.out.print("Apakah Ada Transaksi Lagi ? : ");
					Tambah = Scn.next();
				}
				else
				{
					System.out.println("Nama " + namaBarang + " Tidak ada dalam Tabel Buah");
				}
			}while(Tambah.equalsIgnoreCase("Y"));
			System.out.println("==============================================================================");
			hasilReport += ("\n" + "ID Transaksi : TR#" + Trans + "\n" + "==================================================================" + "\n" + "No. ID\t\tNama\tHarga Beli\tKuantiti\tSub Total" + "\n" + "==================================================================" + "\n" + cetakHasil + "\nOmmset : Rp. " + totTrans + "\n");
			System.out.println();
	}
	
	public static void cetakTransaksi() //Lap. KASIR
	{
		tr.cetakTrans();
		System.out.println(cetakHasil);
		System.out.println("---------------------------------");
		System.out.println("Total Transaksi : Rp. " + totTrans);
	}
	
	public static void reportPenjualan() //Lap. ADMIN
	{
		System.out.println(hasilReport);
		System.out.println();
	}
	
	public static int cariBarang(String Key, Vector<dataBarang> dbBarang) //cari Barang
	{
		int idx = -1;
		int i = 0;
		while((i < dbBarang.size()) && (idx == -1))
		{
			if(dbBarang.elementAt(i).getNamaBarang().equals(Key))
			{
				idx = i;
			}
				i++;
		}
		return idx;
	}
	
	public static void Cari()
	{
		System.out.print("Masukkan Nama Barang : ");
		String cari = Scn.next();
		System.out.println("==================================================================");
		System.out.println("No. ID\t\tNama\t\tHarga Beli\t\tHarga Jual");
		System.out.println("==================================================================");
		for(int i=0;i<dbBarang.size();i++)
		{	
			if (dbBarang.elementAt(i).getNamaBarang().equalsIgnoreCase(cari))
			{
			System.out.println(dbBarang.elementAt(i).getId() + " \t\t " + dbBarang.elementAt(i).getNamaBarang() + " \t\t " + dbBarang.elementAt(i).getHargaBarang() + " \t " + dbBarang.elementAt(i).getHargaJual());
			}
		}
	}
	
	public static void UpdateBarang() //update
	{
		int idx = -1;
		int i = 0;
		System.out.println();
		System.out.println("=======================================");
		System.out.println("     Update Barang     ");
		System.out.print("Masukkan nama barang yang akan diubah \t: ");
		String nama = Scn.next();
		do
		{
			if(dbBarang.elementAt(i).getNamaBarang().equals(nama))
			{
				idx = i;
			}
			i++;
		}while((i < dbBarang.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(nama + " Tidak ditemukan");
		}
		else
		{
			System.out.print("Masukkan Harga Baru : ");
			double harga = Scn.nextDouble();
			dbBarang.elementAt(idx).setHarga(harga);
			dbBarang.elementAt(idx).setJual(harga + (harga*0.1));
			System.out.println("Harga " + nama + " Berhasil diganti");
		}
	}
}