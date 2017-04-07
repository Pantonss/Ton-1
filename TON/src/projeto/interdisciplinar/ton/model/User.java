package projeto.interdisciplinar.ton.model;

import java.util.Date;

public class User {

	private int idUser;
	private String firstName;
	private String lastName;
	private String emailUser;
	private String phoneUser;
	private String cellphoneUser;
	private String adressUser;
	private String cepUser;
	private String passwordUser;
	private Date registerDate;

    public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getIdUser()
    {
        return idUser;
    }
    public void setIdUser(int pIdUser)
    {
        idUser = pIdUser;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String pFirstName)
    {
        firstName = pFirstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String pLastName)
    {
        lastName = pLastName;
    }
    public String getEmailUser()
    {
        return emailUser;
    }
    public void setEmailUser(String pEmailUser)
    {
        emailUser = pEmailUser;
    }
    public String getPhoneUser()
    {
        return phoneUser;
    }
    public void setPhoneUser(String pPhoneUser)
    {
        phoneUser = pPhoneUser;
    }
    public String getCellphoneUser()
    {
        return cellphoneUser;
    }
    public void setCellphoneUser(String pCellphoneUser)
    {
        cellphoneUser = pCellphoneUser;
    }
    public String getAdressUser()
    {
        return adressUser;
    }
    public void setAdressUser(String pAdressUser)
    {
        adressUser = pAdressUser;
    }
    public String getCepUser()
    {
        return cepUser;
    }
    public void setCepUser(String pCepUser)
    {
        cepUser = pCepUser;
    }
    public String getPasswordUser()
    {
        return passwordUser;
    }
    public void setPasswordUser(String pPasswordUser)
    {
        passwordUser = pPasswordUser;
    }



}
