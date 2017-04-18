package projeto.interdisciplinar.ton.controller;

import projeto.interdisciplinar.ton.dao.UserDAO;
import projeto.interdisciplinar.ton.model.User;

public class TestingUser {

	public static void main(String[] args) {

		// Testando inserção de usuario
		User user = new User();
		UserDAO userDAO = new UserDAO();
		Controller controller = new Controller();

	/*	user.setFirstName("João");
		user.setLastName("Jose");
		user.setEmailUser("joao.jose@gmail.com");
		user.setCpfUser("102.812.820-020");
		user.setPhoneUser("3030-2020");
		user.setCellphoneUser("99999-9999");
		user.setAdressUser("rua das limeiras, 321");
		user.setCepUser("80.240-090");
		user.setPasswordUser("123456");

		controller.createUser(user);
		System.out.println("Cadastrado...: " + user.getFirstName() + " / " + user.getLastName() + " / "
				+ user.getEmailUser() + " / " + user.getPhoneUser() + " / " + user.getCellphoneUser() + " / "
				+ user.getAdressUser() + " / " + user.getRegisterDate());

		// Tentando inserir um usuario com o mesmo email
		User user2 = new User();
		user2.setFirstName("Joao");
		user2.setLastName("Couto");
		user2.setEmailUser("joao.jose@gmail.com");
		user2.setCpfUser("102.812.820-020");
		user2.setPhoneUser("3030-5050");
		user2.setCellphoneUser("99999-9999");
		user2.setAdressUser("rua das limeiras, 321");
		user2.setCepUser("80.240-090");
		user2.setPasswordUser("123456");

		controller.createUser(user2);
		System.out.println("Cadastrado...: " + user2.getFirstName() + " / " + user2.getLastName() + " / "
				+ user2.getEmailUser() + " / " + user2.getPhoneUser() + " / " + user2.getCellphoneUser() + " / "
				+ user2.getAdressUser() + " / " + user2.getRegisterDate());*/

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

		// Atualizando objetos
		
		  System.out.println(); System.out.println("Atualizar Usuario:");
		  
		  user.setFirstName("Marcos"); 
		  user.setLastName("Mar");
		  user.setEmailUser("marcos@hotmail.com");
		  user.setPhoneUser("3003-3030"); 
		  user.setCellphoneUser("99988-9988");
		  user.setAdressUser("Rua das oliveiras, 30");
		  user.setCepUser("80.080-090"); 
		  user.setPasswordUser("123456");
		  user.setEmailUser("joao.jose@gmail.com"); 
		
		  controller.updateUser(user);
		  System.out.println("Usuario: " +
		  user.getFirstName() + " Atualizado"); 
		 

		/*
		 * System.out.println(); System.out.println("Excluindo usuario: "); if
		 * (userDAO.delete(user.getEmailUser()))
		 * System.out.println("Excluido usuario: " + user.getFirstName()); else
		 * System.out.println("Erro na remoÃ§Ã£o.. : " + user.getFirstName());
		 */
	}
}
