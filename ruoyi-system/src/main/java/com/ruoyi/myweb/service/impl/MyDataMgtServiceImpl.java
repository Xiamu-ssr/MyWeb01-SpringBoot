package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.myweb.domain.MyImages;
import com.ruoyi.myweb.domain.MyImagetext;
import com.ruoyi.myweb.dto.DataMgtOneInfoDto;
import com.ruoyi.myweb.dto.DataMgtSearchDto;
import com.ruoyi.myweb.mapper.MyImagesMapper;
import com.ruoyi.myweb.mapper.MyImagetextMapper;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.utils.CountUtils;
import com.ruoyi.myweb.vo.DataMgtSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.File;
import java.sql.Timestamp;

@Service
public class MyDataMgtServiceImpl implements IMyDataMgtService{
    @Value("${myweb.image-dir}")
    private String picDir;

    @Autowired
    private MyImagetextMapper myImagetextMapper;
    @Autowired
    private MyImagesMapper myImagesMapper;

    @Override
    public String getId(){
        return CountUtils.getImageTextNum();
    }
    @Override
    public String insertOnePic(MultipartFile file, String masterId) {
        //保存图片到磁盘
//        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String fileName = CountUtils.getImageNum() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
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

    @Override
    public int createImageText(Map<String, String> params) {
        MyImagetext myImagetext = new MyImagetext();
        myImagetext.setId(params.get("id"));
        myImagetext.setTitle(params.get("title"));
        myImagetext.setText(params.get("text"));
        myImagetext.setPlace(params.get("place"));
        myImagetext.setCreateTime(new Date());

        return myImagetextMapper.insert(myImagetext);
    }

    @Override
    public int cancelImageText(String id) {
        LambdaQueryWrapper<MyImagetext> myImagetextWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<MyImages> myImagesWrapper = new LambdaQueryWrapper<>();
        myImagetextWrapper.eq(MyImagetext::getId, id);
        myImagesWrapper.eq(MyImages::getMasterId, id);

        myImagetextMapper.delete(myImagetextWrapper);
        myImagesMapper.delete(myImagesWrapper);

        return 0;
    }

    @Override
    public List<MyImagetext> getList(DataMgtSearchDto dto) {
        LambdaQueryWrapper<MyImagetext> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(MyImagetext::getId, MyImagetext::getTitle, MyImagetext::getPlace, MyImagetext::getCreateTime)
                .in(StringUtils.isNotNull(dto.getPlace()), MyImagetext::getPlace, dto.getPlace())
                .like(StringUtils.isNotNull(dto.getTitle()), MyImagetext::getTitle, dto.getTitle())
                .like(StringUtils.isNotNull(dto.getText()), MyImagetext::getText, dto.getText());
        if (StringUtils.isNotNull(dto.getDate())){
            wrapper.between(MyImagetext::getCreateTime, dto.getDate().get(0), dto.getDate().get(1));
        }

        return myImagetextMapper.selectList(wrapper);
    }

    @Override
    public DataMgtOneInfoDto getImageTextById(String id) {
        LambdaQueryWrapper<MyImagetext> wrapper1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<MyImages> wrapper2 = new LambdaQueryWrapper<>();
        wrapper1.eq(MyImagetext::getId, id);
        MyImagetext myImagetext = myImagetextMapper.selectOne(wrapper1);
        wrapper2.eq(MyImages::getMasterId, id);
        List<MyImages> myImages = myImagesMapper.selectList(wrapper2);

        DataMgtOneInfoDto res = new DataMgtOneInfoDto();
        res.setId(myImagetext.getId());
        res.setTitle(myImagetext.getTitle());
        res.setText(myImagetext.getText());
        res.setPlace(myImagetext.getPlace());
        res.setCreateTime(myImagetext.getCreateTime());
        res.setImages(myImages);

        return res;
    }
}
