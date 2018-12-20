/**
 * 
 */
package com.daoben.rfid.utils;


import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author 文
 *
 *         2017年2月16日下午5:26:42
 */
public class Files {
	public String fileUpload(/*HttpServletRequest request,*/MultipartFile file) throws Exception {
		if (file != null) {
			File filetoserver = new File(ReadProperties.getInstance("attr.properties").getProperty("tempPath"), file.getOriginalFilename());
			if (!filetoserver.getParentFile().exists()) {
				filetoserver.getParentFile().mkdirs();
			}
			// 上传
			file.transferTo(filetoserver);
			}
		
/*		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					File filetoserver = new File(ReadProperties.getTempPath(), file.getOriginalFilename());
					if (!filetoserver.getParentFile().exists()) {
						filetoserver.getParentFile().mkdirs();
					}
					// 上传
					file.transferTo(filetoserver);
				}
			}
		}*/
		// 获取根目录盘符
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String rootPath = "";
		if ("\\".equals(File.separator)) {
			String path = classPath.substring(1, classPath.indexOf("/WEB-INF/classes"));
			rootPath = path.substring(0, path.lastIndexOf("/"));
			rootPath = rootPath.replace("/", "\\");
		}
		
		return rootPath.substring(0, 2) + ReadProperties.getInstance("attr.properties").getProperty("tempPath") + file.getOriginalFilename();
	}

	/**
	 * @author 文
	 * @date 2017年2月16日下午5:26:42
	 * @param fileName
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public ResponseEntity<byte[]> fileDownload(String path) throws Exception {    
          
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String(file.getName().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);    
    }

}
