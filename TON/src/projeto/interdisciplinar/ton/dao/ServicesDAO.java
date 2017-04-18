package projeto.interdisciplinar.ton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.interdisciplinar.ton.interfaces.IServices;
import projeto.interdisciplinar.ton.model.Services;
import projeto.interdisciplinar.ton.util.ExceptionUtil;

public class ServicesDAO implements IServices {

	private static String sTabela = "REGISTER_SERVICES";
	private static String sCampos1 = "ID_SERVICES, NAME_SERVICE, CNPJ_CPF_SERVICE, CATEGORY_SERVICE, SUBCATEGORY_SERVICE,"
			+ " EMAIL_SERVICE, PHONE_SERVICE, CELLPHONE_SERVICE, ADRESS_SERVICE, CEP_SERVICE, HOMECARE_SERVICE, "
			+ "PASSWORD_SERVICE, REGISTER_DATE";
	private static String sCampos4 = "FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, PHONE_USER,"
			+ " CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER, REGISTER_DATE";
	private static String sCampos2 = sCampos1.replaceAll(",", " = ?,") + " = ?";
	private static String sCampos3 = sCampos2.replaceAll("[A-Z_]+ =", "");
	private static String sOrdem = "ORDER BY UPPER(NAME_SERVICE)";

	Connection myConnection = null;

	@Override
	public Services createService(Services service) {

		Services tObject = null;
		
		try {

			AcessDAO acessDAO = new AcessDAO();

			myConnection = acessDAO.openConnection();

			// Criando comando sql
			String sqlRegister = "INSERT INTO " + sTabela + " (" + sCampos1 + ") VALUES ("
					+ sCampos3.replaceFirst("\\?", "IDSERVICE_SEQ.NEXTVAL") + ")";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRegister, new String[] { "ID_SERVICE" });

			int i = 1;
			tComandoJDBC.setString(i++, service.getNameService());
			tComandoJDBC.setString(i++, service.getDescriptionService());
			tComandoJDBC.setString(i++, service.getCnpjCpfUser());
			tComandoJDBC.setObject(i++, service.getCategoryService());
			tComandoJDBC.setObject(i++, service.getSubcategoryService());
			tComandoJDBC.setString(i++, service.getEmailService());
			tComandoJDBC.setString(i++, service.getPhoneService());
			tComandoJDBC.setString(i++, service.getCellphoneService());
			tComandoJDBC.setString(i++, service.getAdressService());
			tComandoJDBC.setString(i++, service.getCepService());
			tComandoJDBC.setString(i++, service.getHomeCare() ? "SIM" : "NAO");
			tComandoJDBC.setString(i++, service.getPasswordservice());

			// executando o comando de gravação
			tComandoJDBC.executeUpdate();

			// Copiando o objeto para retorno
			tObject = service;

			// Liberando os recursos do JDBC
			tComandoJDBC.close();

		} catch (SQLException | ClassNotFoundException tExcept) {

			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criação do objeto");
		}

		return tObject;
	}

}
