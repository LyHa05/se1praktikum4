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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kontoNr == null) ? 0 : kontoNr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KontoNrTyp other = (KontoNrTyp) obj;
		if (kontoNr == null) {
			if (other.kontoNr != null)
				return false;
		} else if (!kontoNr.equals(other.kontoNr))
			return false;
		return true;
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
