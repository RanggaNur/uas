import java.util.*;
public class Transaksi
{
	private String id;
	private static Vector <dtransaksi> dtr=new Vector<dtransaksi>();
	
	public Transaksi(String id){
		this.id = id;
	}

	public String getID()
	{
		return id;
	}
	
	public static void tambah(dtransaksi dtrs)
	{
	
	}
	
	
	public void cetakTrans()
	{
		System.out.println("");
		System.out.println("Toko Shoes Line");
		System.out.println("ID TR#: " + id);
		System.out.println("---------------------------------------------------");
		System.out.println("ID Barang \t Nama \t Harga \t Jumlah \t Subtotal");
	}
}