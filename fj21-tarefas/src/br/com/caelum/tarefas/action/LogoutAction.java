package br.com.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("default")
public class LogoutAction {

	@Action(value="logout", results= {
			@Result(name="ok", type="redirectAction", 
					params= {"actionName","login"})
	}, interceptorRefs= {
			@InterceptorRef("seguranca")
	})
	public String logout() {
		SessionMap sessao = (SessionMap)ActionContext.getContext().get(ActionContext.SESSION);
		sessao.invalidate();
		return "ok";
	}
}
