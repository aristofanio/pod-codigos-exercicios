package pod.q1.node3;

/**
 * Responsável por fazer a consulta no BD
 * 
 * @author arigarcia
 *
 */
public interface JdbcConnect {
	/**
	 * Realiza uma consulta no banco de dados
	 * 
	 * @param params
	 * @return
	 */
	String query(String params);
}
