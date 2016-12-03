package se1app.applicationcore.kontoKomponente;

/**
 * Klasse fuer Exception fuer nicht gefundene Konten.
 * @author Lucas Anders, Lydia Pflug
 * @sate 02.12.2016
 */

public class KontoNichtGefundenException extends Exception {

	private static final long serialVersionUID = 1L;

	public KontoNichtGefundenException(String kontoNr) {
		super("Konto mit der Nummer " + kontoNr + " konnte nicht gefunden werden.");
	}
}
