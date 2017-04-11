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

	public class controller
	{



	}

	   public DtoUser createUser(User puser) {
           user = new User();
           userDAO = new UserDAO();
           
           puser.setRegisterDate(new Date());
           if (puser.getEmailUser() == user.getEmailUser())
               return new DtoUser (false, "Email já cadastrado");
		System.out.println("email ja cadastrado");
          User huser = userDAO.createUser(puser);
           if (huser == null)
               return new DtoUser (false, "Usuario nulo");
           else
        	   if (puser.getEmailUser() != user.getEmailUser())
        	   System.out.println("Cadastrado sucesso");
        	   System.out.println("chegou"+ user);
               return new DtoUser(true, "Cadastrado com sucesso");
               
           		
           
       }

	}
