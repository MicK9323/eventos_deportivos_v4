package interfaces;

public interface reciboDAO {
	public String registrarPago( String numFicha, Double monto );
	public String consultarPago( String numFicha );
}
