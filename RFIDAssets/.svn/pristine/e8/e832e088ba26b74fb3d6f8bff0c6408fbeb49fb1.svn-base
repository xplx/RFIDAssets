package com.daoben.rfid.utils;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.stereotype.Repository;
import com.sun.jna.Function;

@Repository
public class AcquireTimeStamp {
	static private Date date;// 系统时间时间
	static private Timestamp timestamp;// 获取时间戳

	/**
	 * @author wxp 获取当前系统时间戳
	 */
	public Timestamp getTimeStamp() {
		date = new Date();
		timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

	/**
	 * @param tag_Id
	 * @return 
	 * {@link Function} ：将整形转换成字符串
	 */
	public String getString(int tag_Id) {

		String Stag_Id = new Integer(tag_Id).toString();
		
		return Stag_Id;
	}
}
