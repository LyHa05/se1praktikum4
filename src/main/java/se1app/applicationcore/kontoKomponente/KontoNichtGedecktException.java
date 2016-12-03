package se1app.applicationcore.kontoKomponente;

/**
 * Klasse fuer Exception mit nicht gedecktem Konto.
 * @author Lucas Anders, Lydia Pflug
 * @sate 02.12.2016
 */

public class KontoNichtGedecktException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public KontoNichtGedecktException(String kontoNr) {
		super("Konto mit der Nummer " + kontoNr + " ist nicht gedeckt.");
	}

}
