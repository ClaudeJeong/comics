package mypkg.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/comics",
		initParams = {
				@WebInitParam(name="configFile", value ="/WEB-INF/comand.properties" )
			}
		)
public class FrontController extends HttpServlet {
//Instance	
	private static final long serialVersionUID = 1L;
	private Map<String, SuperController> ActionMap = new HashMap<String, SuperController>();

//Constructor	
    public FrontController() {
        super();
    }

 //Method
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		String configFilePath = getServletContext().getRealPath(configFile);
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}finally{
			try {
			if( fis != null) { fis.close(); } 
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()){
			String command = (String) keyIter.next();
			String className = prop.getProperty(command);
			try {
				Class<?> makeClass = Class.forName(className);
				SuperController makeInstance = (SuperController)makeClass.newInstance();
				ActionMap.put(command, makeInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public void destroy() {
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		SuperController controller = ActionMap.get(command);
		if(controller != null){
			controller.doProcess(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
