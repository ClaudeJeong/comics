package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MyFileUpload {

	public static MultipartRequest getMulti( HttpServletRequest request, String UploadedPath ){
		
		String encType = "UTF-8";
		int sizeLimit = 20* 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, UploadedPath, sizeLimit, encType, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multi;
	}
}
