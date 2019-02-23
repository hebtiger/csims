package jsf;

import jpa.entities.OtnServiceInfo;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.OtnServiceInfoFacade;

import java.io.Serializable;
import java.util.List;
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

@Named("otnServiceInfoController")
@SessionScoped
public class OtnServiceInfoController implements Serializable {

    private OtnServiceInfo current;
    private DataModel items = null;
    @EJB
    private jpa.session.OtnServiceInfoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
private DataModel netRing1=null;
    private DataModel netRing2=null;
    private DataModel netRing3=null;
    private List allRings=null;
    public OtnServiceInfoController() {
    }

    /**
     * @return the netRing1
     */
    public DataModel getNetRing1() {
       if(netRing1==null){
           return new ListDataModel(getFacade().findByNetRing("环一"));
       }
        return netRing1;
    }

    /**
     * @param netRing1 the netRing1 to set
     */
    public void setNetRing1(DataModel netRing1) {
        this.netRing1 = netRing1;
    }

    /**
     * @return the netRing2
     */
    public DataModel getNetRing2() {
        if(netRing2==null){
           return new ListDataModel(getFacade().findByNetRing("环二"));
       }
        return netRing2;
    }

    /**
     * @param netRing2 the netRing2 to set
     */
    public void setNetRing2(DataModel netRing2) {
        this.netRing2 = netRing2;
    }

    /**
     * @return the netRing3
     */
    public DataModel getNetRing3() {
        if(netRing3==null){
           return new ListDataModel(getFacade().findByNetRing("环三"));
       }
        return netRing3;
    }

    /**
     * @param netRing3 the netRing3 to set
     */
    public void setNetRing3(DataModel netRing3) {
        this.netRing3 = netRing3;
    }

    /**
     * @return the allRings
     */
    public List getAllRings() {
       if(allRings==null){
           allRings.add(netRing1);
           allRings.add(netRing2);
           allRings.add(netRing3);
       }
       return allRings;
    }

    /**
     * @param allRings the allRings to set
     */
    public void setAllRings(List allRings) {
        this.allRings = allRings;
    }

    public OtnServiceInfo getSelected() {
        if (current == null) {
            current = new OtnServiceInfo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private OtnServiceInfoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(100) {

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
        current = (OtnServiceInfo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new OtnServiceInfo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("OtnServiceInfoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (OtnServiceInfo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("OtnServiceInfoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (OtnServiceInfo) getItems().getRowData();
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
        recreateModel();
        return "List";
//        if (selectedItemIndex >= 0) {
//            return "View";
//        } else {
//            // all items were removed - go back to list
//            recreateModel();
//            return "List";
//        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("OtnServiceInfoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/OtnServiceInfo_Bundle").getString("PersistenceErrorOccured"));
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

    public OtnServiceInfo getOtnServiceInfo(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = OtnServiceInfo.class)
    public static class OtnServiceInfoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OtnServiceInfoController controller = (OtnServiceInfoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "otnServiceInfoController");
            return controller.getOtnServiceInfo(getKey(value));
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
            if (object instanceof OtnServiceInfo) {
                OtnServiceInfo o = (OtnServiceInfo) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OtnServiceInfo.class.getName());
            }
        }

    }

}
