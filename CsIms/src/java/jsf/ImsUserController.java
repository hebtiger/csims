package jsf;

import jpa.entities.ImsUser;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.ImsUserFacade;
import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("imsUserController")
@SessionScoped
public class ImsUserController implements Serializable {

    private String name = "";
    private String password = "";
    private boolean superadmin;
    private boolean admin;

    private ImsUser current;
    private DataModel items = null;
    @EJB
    private jpa.session.ImsUserFacade ejbFacade;
   
    private PaginationHelper pagination;
   
    private int selectedItemIndex;

    public ImsUserController() {
    }

    //验证用户是否登录
    public String verifyUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map session = fc.getExternalContext().getSessionMap();
        for (ImsUser user : getFacade().findAll()) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                session.put("name", name);
                System.out.println("登录用户属于" + user.getUserGroup());
                if (user.getUserGroup().getGroupName().equalsIgnoreCase("superadmin")) {
                    // System.out.println("登录用户属于"+user.getUserGroup());
                    setSuperadmin(true);
                }
                if (user.getUserGroup().getGroupName().equalsIgnoreCase("admin")) {
                    setAdmin(true);

                }
                return "index";
            }
        }
        return "login";
    }

    /**
     * @return the superadmin
     * 是否为超级管理员
     */
    public boolean isSuperadmin() {
        return superadmin;
    }

    /**
     * @param superadmin the superadmin to set
     * 设置为超级管理员
     */
    public void setSuperadmin(boolean superadmin) {
        this.superadmin = superadmin;
    }

    /**
     * @return the admin
     * 是否为管理员
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     * 设置为管理员
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public ImsUser getSelected() {
        if (current == null) {
            current = new ImsUser();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ImsUserFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (ImsUser) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ImsUser();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ImsUserCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ImsUser) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ImsUserUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ImsUser) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ImsUserDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public ImsUser getImsUser(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ImsUser.class)
    public static class ImsUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImsUserController controller = (ImsUserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imsUserController");
            return controller.getImsUser(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ImsUser) {
                ImsUser o = (ImsUser) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ImsUser.class.getName());
            }
        }

    }

}
