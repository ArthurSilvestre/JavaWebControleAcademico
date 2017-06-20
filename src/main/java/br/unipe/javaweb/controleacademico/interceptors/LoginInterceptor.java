package br.unipe.javaweb.controleacademico.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	   @Override 
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{

	       HttpSession session = request.getSession();
	       String url = request.getRequestURI(); 
	       String tipo_usuario = session.getAttribute("usuario_autenticado").toString();
	       
	       if (url.equals("/ControleAcademico/")) return true;
	       
	       if ((session.getAttribute("usuario_autenticado") != null) && (tipo_usuario != null)) { 
	    	  
	    	   if (tipo_usuario.equals("Administrador")) {
	    		   if ((url.equals("/ControleAcademico/curso/listar"))      || 
    				   (url.equals("/ControleAcademico/disciplina/listar")) || 
    				   (url.equals("/ControleAcademico/turma/listar"))      || 
    				   (url.equals("/ControleAcademico/aluno/listar"))      || 
    				   (url.equals("/ControleAcademico/professor/listar")))
	    			   return true;
	    	   }
		        
	    	   if (tipo_usuario.equals("Aluno")) {
	    		   if ((url.equals("/ControleAcademico/aluno/notas")) || 
    				   (url.equals("/ControleAcademico/aluno/historico")))
	    			   return true;
	    	   }
		        
	    	   if (tipo_usuario.equals("Professor")) {
	    		   if (url.equals("/ControleAcademico/professor/disciplinas"))
	    			   return true;
	    	   }		       
	    	   
	       }
	       
	       response.sendRedirect("/");

	       return false;
	   } 
}
