package mypkg.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.util.MyFileUpload;

import com.oreilly.servlet.MultipartRequest;

@WebServlet(urlPatterns = { "/ComicsCtrl" }, initParams = {
		@WebInitParam(name = "configFile", value = "/WEB-INF/commandList.properties") })
public class FrontController extends HttpServlet implements SuperController {
	// Instance
	private static final long serialVersionUID = 1L;
	private Map<String, SuperController> actionMap = new HashMap<String, SuperController>();

	// Method
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");

		Properties prop = new Properties();
		FileInputStream fis = null;
		String configFilePath = getServletContext().getRealPath(configFile);
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);

			try {
				Class<?> realClass = Class.forName(handlerClassName);
				SuperController ClassInstance = (SuperController) realClass.newInstance();
				actionMap.put(command, ClassInstance);
				//System.out.println("키값 : " + actionMap.keySet() + "이동 클래스 : " + actionMap.values());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String command = request.getParameter("command");
		ServletContext context = getServletContext();
		//System.out.println("getServletContext();는 머지 ?" + context);
		if (command == null) {
			String uploadedPath = context.getRealPath("/upload");
			//System.out.println("getRealPath(/upload);는 머지? " + uploadedPath);

			MultipartRequest multi = MyFileUpload.getMulti(request, uploadedPath);
			if (multi != null) {

				command = multi.getParameter("command");
				request.setAttribute("multi", multi);
				request.setAttribute("uploadedPath", uploadedPath);
			}
		}
		SuperController controller = actionMap.get(command);
		if( controller != null){
			//System.out.println(controller.toString() + " 가 호출됨");
			controller.doProcess(request, response);
		}
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
