package projeto.interdisciplinar.ton.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.interdisciplinar.ton.interfaces.IUsuario;
import projeto.interdisciplinar.ton.model.User;
import projeto.interdisciplinar.ton.util.ExceptionUtil;

public class UserDAO implements IUsuario {

	private static String sTabela = "REGISTER_USER";
	private static String sCampos1 = "ID_USER, FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, CPF_USER, PHONE_USER,"
			+ " CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER, REGISTER_DATE";
	private static String sCampos4 = "FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, PHONE_USER,"
			+ " CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER, REGISTER_DATE";
	private static String sCampos5 = "FIRSTNAME_USER = ?, LASTNAME_USER = ?, EMAIL_USER = ?, CPF_USER = ?, PHONE_USER = ?,"
			+ " CELLPHONE_USER = ?, ADRESS_USER = ?, CEP_USER = ?, PASSWORD_USER = ?";
	private static String sCampos2 = sCampos1.replaceAll(",", " = ?,") + " = ?";
	private static String sCampos3 = sCampos2.replaceAll("[A-Z_]+ =", "");
	private static String sOrdem = "ORDER BY UPPER(FIRSTNAME_USER)";

	public UserDAO() {

	}

	Connection myConnection = null;
	private User user;

	@Override
	public User createUser(User pUser) {
		User tObject = null;

		try {

			AcessDAO acessoDAO = new AcessDAO();

			myConnection = acessoDAO.openConnection();
			// Criando o comando SQL e o comando JDBC
			String sqlRegister = "INSERT INTO " + sTabela + " (" + sCampos1 + ") VALUES ("
					+ sCampos3.replaceFirst("\\?", "IDUSER_SEQ.NEXTVAL") + ")";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRegister, new String[] { "ID_USER" });

			// Colocando os parametros recebidos no JDBC
			int i = 1;
			System.out.println(sqlRegister + pUser);
			tComandoJDBC.setString(i++, pUser.getFirstName());
			tComandoJDBC.setString(i++, pUser.getLastName());
			tComandoJDBC.setString(i++, pUser.getEmailUser());
			tComandoJDBC.setString(i++, pUser.getCpfUser());
			tComandoJDBC.setString(i++, pUser.getPhoneUser());
			tComandoJDBC.setString(i++, pUser.getCellphoneUser());
			tComandoJDBC.setString(i++, pUser.getAdressUser());
			tComandoJDBC.setString(i++, pUser.getCepUser());
			tComandoJDBC.setString(i++, pUser.getPasswordUser());
			tComandoJDBC.setDate(i++, new java.sql.Date(pUser.getRegisterDate().getTime()));

			// executando o comando de gravaÁ„o
			tComandoJDBC.executeUpdate();

			// Copiando o objeto para retorno
			tObject = pUser;

			// Liberando os recursos do JDBC
			tComandoJDBC.close();
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criaÁ„o do objeto");
		}

		return tObject;
	}

	public User recoveryUser(String emailUser){
		
		User tObject = null;
		
		try{
			AcessDAO acessoDAO = new AcessDAO();
			myConnection = acessoDAO.openConnection();
			
			
			//Criando comando sql e jdbc
			String sqlRecovery = "SELECT " +sCampos4+ " FROM " + sTabela + " WHERE EMAIL_USER = ?";
			System.out.println(""+sqlRecovery);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRecovery);
			
			
			//Colocando o parametro recebido no JDBC
			tComandoJDBC.setString(1, emailUser);
			
			//Executando o comando e salvando o ResulSet para processar
			ResultSet tResultSet = tComandoJDBC.executeQuery();
			
			//Verificando se um registro foi lido
			if (tResultSet.next())
			{
				//Salvando o objeto para retornar
				tObject = carregarObjeto(tResultSet);
			}
			
			//liberando os recursos jdbc
			tResultSet.close();
			tComandoJDBC.close();
			
		}
		catch (SQLException | ClassNotFoundException tExcept)
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de recuperaÁ„o do objeto");
		}
		return tObject;
		
	}

	// Metodo para atualizaÁ„o de usuario
	public User updateUser(User puser) {
		User tObject = null;

		try {

			// iniciando objeto de conex„o
			AcessDAO acessoDAO = new AcessDAO();
			myConnection = acessoDAO.openConnection();

			// Criando comando sql e jdbc
			String sqlUpdate = "UPDATE " + sTabela + " SET " + sCampos2 + " WHERE EMAIL_USER = ?";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlUpdate);
			System.out.println("Comando: " + sqlUpdate);

			// Colocando os parametros recebidos no jdbc
			int i = 1;
			
			tComandoJDBC.setInt(i++, puser.getIdUser());
			tComandoJDBC.setString(i++, puser.getFirstName());
			tComandoJDBC.setString(i++, puser.getLastName());
			tComandoJDBC.setString(i++, puser.getEmailUser());
			tComandoJDBC.setString(i++, puser.getCpfUser());
			tComandoJDBC.setString(i++, puser.getPhoneUser());
			tComandoJDBC.setString(i++, puser.getCellphoneUser());
			tComandoJDBC.setString(i++, puser.getAdressUser());
			tComandoJDBC.setString(i++, puser.getCepUser());
			tComandoJDBC.setString(i++, puser.getPasswordUser());
			tComandoJDBC.setDate(i++, (Date) puser.getRegisterDate());
			tComandoJDBC.setString(i++, puser.getEmailUser());
			
			

			// executando o comando de gravaÁ„o

			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o objeto para retorno
				tObject = puser;
			}

			tComandoJDBC.close();
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m√©todo de atualiza√ß√£o do objeto");
		}

		// Retornando o objeto
		return tObject;

	}
	 public boolean delete(String email)
	    {
	        try
	        {
	        	
	        	AcessDAO acessDAO = new AcessDAO();
	        	myConnection = acessDAO.openConnection();
	            // Criando o comando SQL e o comando JDBC
	            String sqlDelete = "DELETE " + sTabela + " WHERE EMAIL_USER = ?" ;
	            PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlDelete);

	            // Colocando o par√¢metro recebido no comando JDBC
	            tComandoJDBC.setString(1, email);

	            // Executando o comando de remo√ß√£o e salvando o n√∫mero de registros removidos
	            int tQtdeReg = tComandoJDBC.executeUpdate();

	            // Liberando os recursos JDBC
	            tComandoJDBC.close();

	            // Verificando se um registro foi removido
	            if (tQtdeReg == 1)
	            {
	                // Indicado que a remo√ß√£o foi efetuado com sucesso
	                return true;
	            }
	        }
	        catch (SQLException | ClassNotFoundException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m√©todo de remo√ß√£o do objeto");
	        }

	        // Se chegou nesse ponto a remo√ß√£o n√£o foi efetuada
	        return false;
	    }

	private User carregarObjeto(ResultSet tResultSet) throws SQLException {
		// Criando um novo objeto para armazenar as informa√ß√µes lidas
		User user = new User();

		// Recuperando as informa√ß√µes do ResultSet e colocando no objeto
		// criado
		user.setFirstName(tResultSet.getString("FIRSTNAME_USER"));
		user.setLastName(tResultSet.getString("LASTNAME_USER"));
		user.setEmailUser(tResultSet.getString("EMAIL_USER"));
		user.setPhoneUser(tResultSet.getString("PHONE_USER"));
		user.setCellphoneUser(tResultSet.getString("CELLPHONE_USER"));
		user.setAdressUser(tResultSet.getString("ADRESS_USER"));
		user.setCepUser(tResultSet.getString("CEP_USER"));
		user.setPasswordUser(tResultSet.getString("PASSWORD_USER"));
		user.setRegisterDate(tResultSet.getDate("REGISTER_DATE"));

		return user;
	}
}
