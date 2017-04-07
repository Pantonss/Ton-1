package projeto.interdisciplinar.ton.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import projeto.interdisciplinar.ton.controller.Controller;
import projeto.interdisciplinar.ton.dao.UserDAO;
import projeto.interdisciplinar.ton.dto.DtoUser;
import projeto.interdisciplinar.ton.model.User;


@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4698942402238559412L;
	/**
	 *
	 */
	private User user;
	private UserDAO userDAO;
	private Controller userController;
	private boolean statusRegister;

	public UserBean() {
		user = new User();
		userController = new Controller();
		userDAO = new UserDAO();

	}

	public String createUser() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		userController = new Controller();
		DtoUser dtoUser= userController.createUser(user);
		if (!contexto.getMessageList().isEmpty()) {
			return "CadastrarUsuario";
		}
		if (dtoUser.taOK()) {
			user = dtoUser.getUser();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dtoUser.getpMensagem(), null));
			userController = new Controller();
			/*statusCpf = true;
			statuslistarDoador = true;*/
			statusRegister = true;
			/*statusAtualizar = false;
			statusExcluir = false;*/
		} else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, dtoUser.getpMensagem(), null));
		}

		user = new User();
		return "CadastrarUsuario";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Controller getUserController() {
		return userController;
	}

	public void setUserController(Controller userController) {
		this.userController = userController;
	}

	public boolean isStatusRegister() {
		return statusRegister;
	}

	public void setStatusRegister(boolean statusRegister) {
		this.statusRegister = statusRegister;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
