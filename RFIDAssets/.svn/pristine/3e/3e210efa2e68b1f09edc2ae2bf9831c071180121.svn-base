/**
 * 
 */
package com.daoben.rfid.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

import com.daoben.rfid.utils.Files;
import com.daoben.rfid.utils.ReadProperties;

/**
 * @author 文
 *
 * 2017年2月17日上午10:00:07
 */
public class ReadPropertiesTest {

	@Test
	public void read() throws Exception {
		
		System.out.println(ReadProperties.getInstance("attr.properties").getProperty("tempPath"));
/*		FileInputStream fis = new FileInputStream("C:\\TEMP\\1.jpg");
		System.out.println(fis);
		MockMultipartFile file = new MockMultipartFile("file","1.jpg","image/jpeg",fis);
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest() ;
		 request.addFile(file);
		System.out.println(new Files().fileUpload(file));*/
	}
	

	
}
