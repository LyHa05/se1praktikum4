package se1app.applicationcore.util;

import java.io.Serializable;

public class KontoNrTyp implements Serializable {

	private static final String KONTO_NR_PATTERN = "^[0-9]*";

    private String kontoNr;

    public KontoNrTyp(String kontoNr)
    {
        if (!istKontoNrGueltig(kontoNr))
        {
            throw new IllegalArgumentException(kontoNr + "ist keine gueltige Kontonummer");
        }
        this.kontoNr = kontoNr;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public static boolean istKontoNrGueltig(String kontoNr) {
        return kontoNr.matches(KONTO_NR_PATTERN);
    }
    
    @Override
    public String toString() {
    	return kontoNr;
    }

//	public static void main(String[] args) {
//		KontoNrTyp knt = new KontoNrTyp("0123");
//		System.out.println(knt.toString());
//	}
}
