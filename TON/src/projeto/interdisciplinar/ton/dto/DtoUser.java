package projeto.interdisciplinar.ton.dto;

import java.util.List;

import projeto.interdisciplinar.ton.model.User;


public class DtoUser extends DtoAbstract{

	/**
	 * @param pOK
	 * @param pMensagem
	 */
	/*atributos normais */
	private User user;
	private List<User> list;

		/*Construtores de classe*/

	public DtoUser(boolean pOK, String pMensagem) {
		super(pOK, pMensagem);
	}

	public DtoUser(boolean pOK, String pMensagem, User pUser) {
		super(pOK, pMensagem);
		user = pUser;
	}
	   public DtoUser(boolean pOk, String pMensagem, List<User> pList)
	    {
	        super(pOk, pMensagem);
	        list = pList;
	    }


	   /* metodos de acesso*/
	   public User getUser()
	    {
	        return user;
	    }

	    public void setUser(User pUser)
	    {
	        user = pUser;
	    }

	    public List<User> getList()
	    {
	        return list;
	    }

	    public void setList(List<User> pList)
	    {
	        list = pList;
	    }

}
