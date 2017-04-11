package projeto.interdisciplinar.ton.controller;

import projeto.interdisciplinar.ton.dao.UserDAO;
import projeto.interdisciplinar.ton.model.User;

public class TestingUser {

	public static void main(String[] args) {

		// Testando inserção de usuario
		User user = new User();
		UserDAO userDAO = new UserDAO();
		Controller controller = new Controller();

		user.setFirstName("João");
		user.setLastName("Jose");
		user.setEmailUser("joao.jose@gmail.com");
		user.setPhoneUser("3030-2020");
		user.setCellphoneUser("99999-9999");
		user.setAdressUser("rua das limeiras, 321");
		user.setCepUser("80.240-090");
		user.setPasswordUser("123456");

		controller.createUser(user);

		if (userDAO != null) {
			System.out.println("Cadastrado...: " + user.getFirstName() + " / " + user.getLastName() + " / " + user.getEmailUser()
					+ " / " + user.getPhoneUser() + " / " + user.getCellphoneUser() + " / " + user.getAdressUser()
					+ " / " + user.getRegisterDate());
		}

		// Testando recuperação de dados
		System.out.println();
		System.out.println("Recuperando objetos...:");
		User user1 = userDAO.recoveryUser("joao.jose@gmail.com");
		if (user1 != null)
			System.out.println("Recuperado...:" + user1.getFirstName() + " / " + user1.getLastName() + " / "
					+ user1.getEmailUser() + " / " + user1.getPhoneUser() + " / " + user1.getCellphoneUser() + " / "
					+ user1.getAdressUser() + " / " + user1.getRegisterDate());
		else
			System.out.println("Erro na recuperação...:" + user1);
	
		
		
		//Atualizando objetos
		System.out.println();
		System.out.println("Atualizar Usuario");
		
	}
	
		

}
