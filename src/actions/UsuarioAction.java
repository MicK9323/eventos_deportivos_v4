package actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.AdminDTO;
import services.AdminService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class UsuarioAction extends ActionSupport {
	private AdminDTO user;
	private AdminDTO admin;
	private String mensaje;
//	private Map<String, Object> sesion = ActionContext.getContext().getSession();
	
	@Action(value="/iniciarSesion",results= {
			@Result(name="login",location="/organizadores.jsp"),
			@Result(name="error",location="/index.jsp")
	})
	public String iniciarSesion() {
		admin = new AdminService().iniciarSesion(user);
		if(admin != null && admin.isEstado()==true) {
			return "login";
		}else {
			if(admin == null)
				mensaje = "Credenciales Incorrectas";
			else if(admin != null && !admin.isEstado()==true)
				mensaje = "Usuario no habilitado";
			return "error";
		}
	}	
	
	public AdminDTO getUser() {
		return user;
	}
	public void setUser(AdminDTO user) {
		this.user = user;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public AdminDTO getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	
}
