package projeto.interdisciplinar.ton.controller;

import java.text.SimpleDateFormat;

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
           if (puser == user)
               return new DtoUser (false, "Ja foi cadastrado");
           //puser.setDataCadastro(new Date());
          User huser = userDAO.createUser(puser);
           if (huser == null)
               return new DtoUser (false, "Usuario nulo");
           else
        	   System.out.println("chegou"+ user.getCellphoneUser());
               return new DtoUser(true, "Cadastrado com sucesso");
           		
           
       }

	}
