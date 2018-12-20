package com.daoben.rfid.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.AssetTagInfoMapper;
import com.daoben.rfid.model.AssetTagInfo;

/**
 * @author wxp
 *
 */
@Service
public class AssetTagInfoService {

	@Resource
	AssetTagInfoMapper aTagInfoMapper;

	/**
	 * @author wxp 查询所有标签信息
	 */
	public List<AssetTagInfo> selectAllTagInfo() {

		return aTagInfoMapper.selectAllTagInfo();

	}

	/**
	 * @author wxp 根据标签的ID号查询报警标签的信息
	 */
	public List<AssetTagInfo> selectTagInfoWarn(String tagId) {

		return aTagInfoMapper.selectTagInfoWarn(tagId);

	}

	/**
	 * @author wxp 根据标签的ID号查询标签的信息
	 */
	public List<AssetTagInfo> selectByTagId(String tag_Id) {

		return aTagInfoMapper.selectByTagId(tag_Id);

	}

	/**
	 * @author wxp 根据标签的ID号查询标签的信息
	 */
	public Timestamp selectByTagIdTime(String tag_Id) {

		return aTagInfoMapper.selectByTagIdTime(tag_Id);

	}

	/**
	 * @author wxp 插入标签的ID号信息
	 */
	public int insertPartTagInfo(AssetTagInfo record) {

		return aTagInfoMapper.insertPartTagInfo(record);

	}

	/**
	 * @author wxp 更新标签的ID号信息
	 */
	public int updatePartByTagId(AssetTagInfo record) {

		return aTagInfoMapper.updatePartByTagId(record);

	}

	/**
	 * @author wxp 更新标签的ID号信息
	 */
	public int updatePartLoseTagId(String tag_id) {

		return aTagInfoMapper.updatePartLoseTagId(tag_id);

	}
	
	/**
	 * @author wxp 更新标签所有的ID号信息
	 */
	public int updateAllTagIdInfo(List<String> tag_id) {

		return aTagInfoMapper.updateAllTagIdInfo(tag_id);

	}

	/**
	 * @author wxp 更新标签的ID号信息
	 */
	public int deleteByTagId(String tag_id) {

		return aTagInfoMapper.deleteByTagId(tag_id);

	}
}
