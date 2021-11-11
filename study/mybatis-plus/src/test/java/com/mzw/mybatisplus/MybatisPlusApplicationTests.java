package com.mzw.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mzw.mybatisplus.entity.Area;
import com.mzw.mybatisplus.mapper.AreaMapper;
import com.mzw.mybatisplus.service.AreaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private AreaService areaService;
    @Test
    void contextLoads() {
        Area area = new Area();
        area.setName("2t1030");
        UpdateWrapper<Area> areaUpdateWrapper = new UpdateWrapper<>();
        areaUpdateWrapper.eq(Area.COL_SCORE,65.40);
        QueryWrapper<Area> areaQueryWrapper = new QueryWrapper<>();
        String bol = "t";
        areaQueryWrapper.nested((queryWrapper)->{
            queryWrapper.ge(Area.COL_TEST,5).or().isNotNull(Area.COL_TYPE);
        }).like(bol!="",Area.COL_NAME,bol);
        List<Area> areas = areaMapper.selectList(areaQueryWrapper);
        System.out.println(areas.toString());
//        areaService.update(area,areaUpdateWrapper);
//        areaService.saveOrUpdate(area,areaUpdateWrapper);

    }

}
