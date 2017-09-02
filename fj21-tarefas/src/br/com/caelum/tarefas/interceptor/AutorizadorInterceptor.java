package br.com.caelum.tarefas.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import br.com.caelum.tarefas.model.Usuario;

public class AutorizadorInterceptor implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Usuario usuarioLogado = (Usuario) invocation.getInvocationContext().getSession().get("usuarioLogado");
		if(usuarioLogado == null) {
			return "naoLogado";
		}
		
		return invocation.invoke();
	}

}
