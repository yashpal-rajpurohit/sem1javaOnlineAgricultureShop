/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

/**
 *
 * @author albus
 */import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="fileUploadValidator")
public class FileUploadValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Part file = (Part) value;

		FacesMessage message=null;

        try {

        	if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() )
        		message=new FacesMessage("Select a valid file");
        	else if(!((file.getContentType().endsWith("jpg") || file.getContentType().endsWith("png") || file.getContentType().endsWith("jpeg"))) )
        		message=new FacesMessage("Select jpg jpeg or png file ");
        	
        	if (message!=null && !message.getDetail().isEmpty())
        		{
        			message.setSeverity(FacesMessage.SEVERITY_ERROR);
        			throw new ValidatorException(message );
        		}

        } catch (Exception ex) {
               throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }

	}

}
