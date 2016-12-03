package se1app.applicationcore.kontoKomponente;

/**
 * Klasse implementiert Interface von Kontokomponente.
 * 
 * @author Lucas Anders, Lydia Pflug
 * @date 02.12.2016
 */
public interface KontoKomponenteInterface {

	/**
	 * Methode bucht Betrag von Quell- auf Zielkonto.
	 * 
	 * @param quellKontonummer
	 * @param zielKontonummer
	 * @param betrag
	 * @throws KontoNichtGefundenException
	 * @throws KontoNichtGedecktException
	 */
	void ueberweise(String quellKontonummer, String zielKontonummer, int betrag)
			throws KontoNichtGefundenException, KontoNichtGedecktException;

}
