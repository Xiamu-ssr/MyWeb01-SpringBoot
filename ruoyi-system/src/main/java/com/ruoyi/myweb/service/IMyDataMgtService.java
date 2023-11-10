package com.ruoyi.myweb.service;

import org.springframework.web.multipart.MultipartFile;

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
}
