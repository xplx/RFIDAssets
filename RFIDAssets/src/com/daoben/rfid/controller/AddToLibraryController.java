/**
 * 
 */
package com.daoben.rfid.controller;


import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.daoben.rfid.model.AssetInLibrary;
import com.daoben.rfid.model.AssetInfo;
import com.daoben.rfid.service.IntoTheLibraryService;
import com.daoben.rfid.utils.Files;
import com.daoben.rfid.utils.ResponsePWFactory;

/**
 * @author 文
 *
 * 2017年2月15日上午11:05:26
 */

@Controller
@RequestMapping("/toLibrary")
public class AddToLibraryController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IntoTheLibraryService intoTheLibraryService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	
	/**
	 * 
	 * @Title: wen  
	 * @Description: 设备盘点 
	 * @param @param 
	 * @param @return    list  
	 * @return String    返回类型  
	 * @date 2017年2月17日 上午9:23:31
	 */
	
	
	@ResponseBody
	@RequestMapping(value ="/toCategoryPage",produces = "text/json;charset=UTF-8")
	public String toCategoryPage() {
		try {
			List<Map<String, Integer>> countAssetList = intoTheLibraryService.countAsset();
			System.out.println(responsePWFactory.responseMap("true", "获取设备盘点列表成功", countAssetList, null));
			return responsePWFactory.responseMap("true", "获取设备盘点列表成功", countAssetList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取设备盘点列表失败哦", e, null);
		}
	}
	/**
	 * 
	 * @Title: wen  
	 * @Description: 资产详细  
	 * @param @param assetType
	 * @param @return    list 
	 * @return String    返回类型  
	 * @date 2017年2月17日 上午9:23:31
	 */
	@ResponseBody
	@RequestMapping(value ="/getAssetList",produces = "text/json;charset=UTF-8")
	public String getAssetList(String assetType) throws Exception {
		log.info(assetType);

		try {
			List<Map<Object, Object>> AssetList = intoTheLibraryService.findByAssetType(assetType);
			List<Map<Object, Object>> findByAssetType2 = intoTheLibraryService.findByAssetType2();

		for (Map<Object, Object> map : AssetList) {
			map.put("pType", "0");
			for (Map<Object, Object> map2 : findByAssetType2) {
				if (map.get("TAG_ID")==map2.get("TAG_ID")||map.get("TAG_ID").equals(map2.get("TAG_ID"))) 
					map.put("pType", "1");
			}
		}
			return responsePWFactory.responseMap("true", "获取详细列表成功", AssetList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取详细列表失败", null, null);
		}

	}
	/**
	 * 
	 * @Title: wen  
	 * @Description: 资产入库  
	 * @param @param rfid_Labelnum,assetInLibrary,request,username
	 * @param @return      
	 * @return String    返回类型  
	 * @date 2017年2月17日 上午9:23:31
	 */
	@ResponseBody
	@RequestMapping(value ="/addToLibrary",produces = "text/json;charset=UTF-8")
	public String addToLibrary(String rfid_Labelnum, AssetInLibrary assetInLibrary,MultipartFile file,String username) throws Exception {
		log.info(rfid_Labelnum);

		try {
			Map<String, String> map = intoTheLibraryService.findByRfidLabelnum(rfid_Labelnum);
			if (intoTheLibraryService.findByTagId(map.get("TAG_ID"))==null||intoTheLibraryService.findByTagId(map.get("TAG_ID")).isEmpty()) {
				
				log.info(map);
				assetInLibrary.setRfid_Assetnum(map.get("RFID_LABELNUM"));
				assetInLibrary.setAsset_Name(map.get("ASSET_NAME"));
				assetInLibrary.setAsset_Type(map.get("ASSET_TYPE"));
				assetInLibrary.setImage_Path(new Files().fileUpload( file));
				assetInLibrary.setTag_Id(map.get("TAG_ID"));
				assetInLibrary.setIn_Time(new Timestamp(new Date().getTime()));
				assetInLibrary.setUser_Name(username);
				int i = intoTheLibraryService.insertAsset(assetInLibrary);
				return responsePWFactory.responseMap("true", "添加成功", i, null);
			} else {
				assetInLibrary.setImage_Path(new Files().fileUpload( file));
				assetInLibrary.setTag_Id(map.get("TAG_ID"));
				assetInLibrary.setIn_Time(new Timestamp(new Date().getTime()));
				assetInLibrary.setUser_Name(username);
				intoTheLibraryService.updateAsset(assetInLibrary);
				return responsePWFactory.responseMap("true", "添加成功", null, null);
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return responsePWFactory.responseMap("false", "已提交，待审核", null, null);
		}
	}

	@ResponseBody
	@RequestMapping(value ="download",produces = "text/json;charset=UTF-8")
	public String download() throws Exception {
		try {
			ResponseEntity<byte[]> download = new Files().fileDownload("E:/RFID/pic/temp/1.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "失败";
		}
		return "成功";
	    }
	}
	

