package projeto.interdisciplinar.ton.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import projeto.interdisciplinar.ton.dao.UserDAO;
import projeto.interdisciplinar.ton.dto.DtoUser;
import projeto.interdisciplinar.ton.model.User;

public class Controller {

	private UserDAO userDAO = new UserDAO();
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	User user = new User();

	public class controller {

	}

	public DtoUser createUser(User puser) {
		if (puser == null)
			return new DtoUser(false, "Usuario inexistente");
		user = new User();
		userDAO = new UserDAO();
		user.setRegisterDate(new Date());
		if (user.getEmailUser() == puser.getEmailUser())
			return new DtoUser(false, "Usuario Ja foi cadastrado");
		else
		puser.setRegisterDate(new Date());
		puser = userDAO.createUser(puser);
		return new DtoUser(true, "Cadastrado com sucesso");

	}

	public DtoUser updateUser(User puser) {
		if (puser == null)
			return new DtoUser(false, "Erro ao atualizar");
		user = new User();
		UserDAO userDao = new UserDAO();

		User tuser = userDao.updateUser(puser);
		if (tuser == null)
			return new DtoUser(false, "Erro ao atualizar");
		else
			return new DtoUser(true, "Atualizado com sucesso");
	}

}
