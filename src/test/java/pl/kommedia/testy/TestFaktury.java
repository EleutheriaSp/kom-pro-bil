package pl.kommedia.testy;

import pl.kommedia.sprzedaz.dao.FakturyBil;
import pl.kommedia.sprzedaz.dao.FakturyBil.KryteriaFakturyBil;
import pl.kommedia.sprzedaz.jpa.FakturaBil;
import pl.kompro.uslugi.Utrwalacz;

public class TestFaktury {
	
	public static void main( String[] args){
		(new TestFaktury()).start();
	}

	private void start(){
		FakturyBil fd= new FakturyBil( Utrwalacz.manager());
		KryteriaFakturyBil kryteria = fd.odbKryteriaFaktury();
		
		for( FakturaBil faktura: kryteria.odbFaktury()){
			System.err.println( "Faktura: "+ faktura.odbNumer());
		}
	}

}
