package com.ruoyi.myweb.service;

import com.ruoyi.myweb.dto.DataMgtOneInfoDto;
import com.ruoyi.myweb.dto.DataMgtSearchDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * imy数据管理服务
 *
 * @author mumu
 * @date 2023/11/09
 */
public interface IMyDataMgtService {

    public String getId();

    /**
     * 插入一张图片
     *
     * @param file     文件
     * @param masterId 主id
     * @return {@link String}
     */
    public String insertOnePic(MultipartFile file, String masterId);

    /**
     * 删除一张图片
     *
     * @param name 名称
     * @return {@link String}
     */
    public String deleteOnePic(String name);

    /**
     * 创建图像文本
     *
     * @param params params
     * @return {@link String}
     */
    public int createImageText(Map<String,String> params);

    /**
     * 取消图像文本
     *
     * @param id id
     * @return int
     */
    public int cancelImageText(String id);


    public List<Map<String, String>> getList(DataMgtSearchDto dto);

    public DataMgtOneInfoDto getImageTextById(String id);
}
