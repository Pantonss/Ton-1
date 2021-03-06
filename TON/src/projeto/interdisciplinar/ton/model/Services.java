package projeto.interdisciplinar.ton.model;

import java.util.Date;

public class Services {

    private int idService;
	private String nameService;
	private String descriptionService;
	private String cnpjCpfUser;
	private Categories categoryService;
	private Subcategories subcategoryService;
	private String emailService;
	private String phoneService;
	private String cellphoneService;
	private String adressService;
	private String cepService;
	private boolean homeCare;
	private String passwordservice;
	private Date registerDate;
	
    public int getIdService()
    {
        return idService;
    }
    public void setIdService(int pIdService)
    {
        idService = pIdService;
    }
    public String getNameService()
    {
        return nameService;
    }
    public void setNameService(String pNameService)
    {
        nameService = pNameService;
    }
    public String getDescriptionService()
    {
        return descriptionService;
    }
    public void setDescriptionService(String pDescriptionService)
    {
        descriptionService = pDescriptionService;
    }
    public String getCnpjCpfUser()
    {
        return cnpjCpfUser;
    }
    public void setCnpjCpfUser(String pCnpjCpfUser)
    {
        cnpjCpfUser = pCnpjCpfUser;
    }
    public Categories getCategoryService()
    {
        return categoryService;
    }
    public void setCategoryService(Categories pCategoryService)
    {
        categoryService = pCategoryService;
    }
    public Subcategories getSubcategoryService()
    {
        return subcategoryService;
    }
    public void setSubcategoryService(Subcategories pSubcategoryService)
    {
        subcategoryService = pSubcategoryService;
    }
    public String getEmailService()
    {
        return emailService;
    }
    public void setEmailService(String pEmailService)
    {
        emailService = pEmailService;
    }
    public String getPhoneService()
    {
        return phoneService;
    }
    public void setPhoneService(String pPhoneService)
    {
        phoneService = pPhoneService;
    }
    public String getCellphoneService()
    {
        return cellphoneService;
    }
    public void setCellphoneService(String pCellphoneService)
    {
        cellphoneService = pCellphoneService;
    }
    public String getAdressService()
    {
        return adressService;
    }
    public void setAdressService(String pAdressService)
    {
        adressService = pAdressService;
    }
    public String getCepService()
    {
        return cepService;
    }
    public void setCepService(String pCepService)
    {
        cepService = pCepService;
    }
    public boolean getHomeCare()
    {
        return homeCare;
    }
    public void setHomeCare(boolean pHomeCare)
    {
        homeCare = pHomeCare;
    }
    public String getPasswordservice()
    {
        return passwordservice;
    }
    public void setPasswordservice(String pPasswordservice)
    {
        passwordservice = pPasswordservice;
    }
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



}
