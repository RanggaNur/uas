public class dtransaksi{
private double kuantiti;
private dataBarang dbB;

public dtransaksi(dataBarang dbB, double kuantiti)
	{
	this.dbB=dbB;
	this.kuantiti=kuantiti;
	}
public dataBarang getBarang(){
	return  dbB;
	}
public double getKuantiti(){
	return kuantiti;
	}
public double htgSubTotal(){
	return dbB.getHargaJual()*kuantiti;
	}
}