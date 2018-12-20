package com.daoben.rfid.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.AssetCheck;
import com.daoben.rfid.model.AssetInfo;
import com.daoben.rfid.model.SelectTime;
import com.daoben.rfid.reader.ReaderFunction;
import com.daoben.rfid.service.AssetInventoryService;
import com.daoben.rfid.utils.Files;
import com.daoben.rfid.utils.ResponsePWFactory;
import com.google.gson.Gson;

/**
 * 
 * @author leon.chen
 *
 * @date 2017年2月16日 下午4:12:17
 */
// 资产盘查
@RequestMapping(value = "/AssetInventory", produces = "text/json;charset=UTF-8")
@Controller
public class AssetInventoryController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private AssetInventoryService assetInventoryService;
	@Resource
	private ResponsePWFactory responsePWFactory;
	@Resource
	private ReaderFunction readerFunction;
	/**
	 * 
	 * @Title: leon.chen
	 * @Description: 资产盘查详细
	 * @param @param
	 *            tagId
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月17日 上午9:23:31
	 */
	@ResponseBody
	@RequestMapping("/findAssetInventoryData")
	public String findAssetInventoryData(String asset_type) {
		String returnData = null;
		try {
			int i = assetInventoryService.insertCheck(); 
			List<Map<String, String>> list = assetInventoryService.findAssetInventoryData(asset_type);
			returnData = responsePWFactory.responseMap("true", "资产盘查查询成功", list, null);
		} catch (Exception e) {
			returnData = responsePWFactory.responseMap("false", "资产盘查查询失败", null, null);
		}
		log.info(returnData);
		return returnData;
	}

	/**
	 * 
	 * @Title: leon.chen
	 * @Description: 资产盘查类型
	 * @param @param
	 *            tagId
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月17日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping("/findAssetTypeData")
	public String findAssetTypeData() {
		String returnData = null;
		try {			
			List<Map<String, String>> list = assetInventoryService.findAssetTypeData();
			returnData = responsePWFactory.responseMap("true", "资产盘查查查询成功", list, null);
		} catch (Exception e) {
			returnData = responsePWFactory.responseMap("false", "资产盘查查查询失败", null, null);
		}
		return returnData;
	}

	/**
	 * 
	 * @Title: wen
	 * @Description: 加载图片
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return file 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/download", produces = "text/json;charset=UTF-8")
	public ResponseEntity<byte[]> download(String tagId) throws Exception {
		String path = assetInventoryService.findByTagid(tagId);
		return new Files().fileDownload(path);
	}
	/**
	 * 
	 * @Title: wen
	 * @Description: 检查提交
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCheck", produces = "text/json;charset=UTF-8")
	public String UpdateCheck(String tagId,String CHECK_STATE,String CHECK_DETIL,String USER_NAME){
		
		try {
			AssetCheck assetCheck = new AssetCheck(tagId, Integer.parseInt(CHECK_STATE), CHECK_DETIL, USER_NAME,null);
			int i = assetInventoryService.updateCheck(assetCheck);
			return responsePWFactory.responseMap("true", "提交成功", i, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "提交失败", null, null);
		}
	}
	
	/**
	 * 
	 * @Title: wen
	 * @Description:到入库盘点
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/tofindIn", produces = "text/json;charset=UTF-8")
	public String tofindIn(String beginTime, String endTime){
		try {
			SelectTime st = new SelectTime(beginTime, endTime,null,null,null);
			List<Map<String,Object>> in = assetInventoryService.inByType(st);
			
			return responsePWFactory.responseMap("true", "获取入库状态设备成功", in, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取入库状态设备失败", null, null);
		}	
	}
	/**
	 * 
	 * @Title: wen
	 * @Description:待入库盘点
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/findNotIn", produces = "text/json;charset=UTF-8")
	public String findNotIn(){
		try {
			List<Map<String, Object>> in = assetInventoryService.findNotIn();
			
			return responsePWFactory.responseMap("true", "获取入库状态设备成功", in, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取入库状态设备失败", null, null);
		}	
	}
	/**
	 * 
	 * @Title: wen
	 * @Description:待入库确认
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/updateNotInToIn", produces = "text/json;charset=UTF-8")
	public String updateNotInToIn(String list){
		try {

			int i = assetInventoryService.updateNotInToIn(Arrays.asList(list.split(",")));
			
			return responsePWFactory.responseMap("true", "获取入库状态设备成功", i, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取入库状态设备失败", null, null);
		}	
	}
	/**
	 * 
	 * @Title: wen
	 * @Description:入库盘点
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/findIn", produces = "text/json;charset=UTF-8")
	public String findIn(String beginTime, String endTime){
		try {
			SelectTime st = new SelectTime(beginTime, endTime, null,null,null);
			List<Map<String, Object>> in = assetInventoryService.findIn(st);
			
			return responsePWFactory.responseMap("true", "获取入库状态设备成功", in, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取入库状态设备失败", null, null);
		}	
	}
	/**
	 * 
	 * @Title: wen
	 * @Description:到出库盘点
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/tofindOut", produces = "text/json;charset=UTF-8")
	public String tofindOut(String beginTime, String endTime){
		try {
			SelectTime st = new SelectTime(beginTime, endTime,null,null,null);
			List<Map<String,Object>> in = assetInventoryService.outByType(st);
			
			return responsePWFactory.responseMap("true", "获取入库状态设备成功", in, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取入库状态设备失败", null, null);
		}	
	}
	/**
	 * 
	 * @Title: wen
	 * @Description:chu库盘点
	 * @param @param
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @date 2017年2月21日 上午9:24:34
	 */
	@ResponseBody
	@RequestMapping(value = "/findOut", produces = "text/json;charset=UTF-8")
	public String findOut(String beginTime, String endTime){
		try {
			SelectTime st = new SelectTime(beginTime, endTime,null,null,null);
			List<Map<String, Object>> out = assetInventoryService.findOut(st);
			return responsePWFactory.responseMap("true", "获取出库状态设备成功", out, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取出库状态设备失败", null, null);
		}	
	}
	//条件查询
	@ResponseBody
	@RequestMapping(value = "/deviceQuery", produces = "text/json;charset=UTF-8")
	public String deviceQuery(String equipment){
		try {
			Gson json = new Gson();
			AssetInfo info = json.fromJson(equipment, AssetInfo.class);
			System.out.println(info);
			List<Map<String, Object>> out = assetInventoryService.deviceQuery(info);
			System.out.println(out);
			return responsePWFactory.responseMap("true", "获取成功", out, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取失败", null, null);
		}	
	}
}
