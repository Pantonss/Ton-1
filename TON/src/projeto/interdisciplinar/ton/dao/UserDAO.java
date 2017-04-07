package projeto.interdisciplinar.ton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.interdisciplinar.ton.interfaces.IUsuario;
import projeto.interdisciplinar.ton.model.User;
import projeto.interdisciplinar.ton.util.ExceptionUtil;

public class UserDAO implements IUsuario {

	private static String sTabela = "REGISTER_USER";
	private static String sCampos1 = "ID_USER, FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, PHONE_USER,"
			+ " CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER";
	private static String sCampos2 =  sCampos1.replaceAll(",", " = ?,") + " = ?";
	private static String sCampos3 = sCampos2.replaceAll("[A-Z_]+ =", "");
	private static String sOrdem = "ORDER BY UPPER(FIRSTNAME_USER)";

	public UserDAO() {

	}

	Connection myConnection = null;
	private User user;

	@Override
	public User createUser(User pUser) {
		User tObject=  null;

		try {

			AcessDAO acessoDAO = new AcessDAO();

			myConnection = acessoDAO.openConnection();
			//Criando o comando SQL e o comando JDBC
			String sqlRegister = "INSERT INTO "+ sTabela + " (" + sCampos1 +") VALUES (" +
			sCampos3.replaceFirst("\\?", "IDUSER_SEQ.NEXTVAL") + ")";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRegister, new String[] {"ID_USER"});

			//Colocando os parametros recebidos no JDBC
			int i = 1;
			System.out.println(sqlRegister);
			tComandoJDBC.setString(i++, pUser.getFirstName());
			tComandoJDBC.setString(i++, pUser.getLastName());
			tComandoJDBC.setString(i++, pUser.getEmailUser());
			tComandoJDBC.setString(i++, pUser.getPhoneUser());
			tComandoJDBC.setString(i++, pUser.getCellphoneUser());
			tComandoJDBC.setString(i++, pUser.getAdressUser());
			tComandoJDBC.setString(i++, pUser.getCepUser());
			tComandoJDBC.setString(i++, pUser.getPasswordUser());
			
			System.out.println("chegou" + pUser.getCellphoneUser());

			//executando o comando de gravação
			tComandoJDBC.executeUpdate();

			//Copiando o objeto para retorno
			tObject = pUser;

			//Liberando os recursos do JDBC
			tComandoJDBC.close();
		}
		 catch (SQLException | ClassNotFoundException tExcept)
		{
			 ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criação do objeto");
		}

		return tObject;
	}

}
