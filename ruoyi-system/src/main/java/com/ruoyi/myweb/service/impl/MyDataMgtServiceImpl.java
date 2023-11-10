package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.myweb.domain.MyImages;
import com.ruoyi.myweb.mapper.MyImagesMapper;
import com.ruoyi.myweb.mapper.MyImagetextMapper;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.utils.CountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.io.File;
import java.sql.Timestamp;

@Service
public class MyDataMgtServiceImpl implements IMyDataMgtService{
    private static String picDir = "C:\\Users\\mumu\\Desktop\\images\\";

    @Autowired
    private MyImagetextMapper myImagetextMapper;
    @Autowired
    private MyImagesMapper myImagesMapper;
    @Autowired
    private CountUtils countUtils;

    @Override
    public String getId(){
        return countUtils.getImageTextNum();
    }
    @Override
    public String insertOnePic(MultipartFile file, String masterId) {
        //保存图片到磁盘
//        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String fileName = countUtils.getImageNum() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String filePath = picDir+ fileName;
        File saveF = new File(filePath);
        System.out.println("save pic:"+filePath);
        try {
            file.transferTo(saveF);
            //插入数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyImages myImages = new MyImages();
        myImages.setMasterId(masterId);
        myImages.setName(fileName);
        myImages.setCreateTime(new Date());
        myImagesMapper.insert(myImages);
        return fileName;
    }

    @Override
    public String deleteOnePic(String name) {
        LambdaQueryWrapper<MyImages> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MyImages::getName, name);
        myImagesMapper.delete(wrapper);

        File file = new File(picDir + name);
        file.delete();
        return null;
    }
}
