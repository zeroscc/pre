package com.xd.pre.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xd.pre.modules.sys.domain.SysApp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
 */
@Repository
public interface SysAppMapper extends BaseMapper<SysApp> {

    IPage<SysApp> selectAppListPage(IPage<SysApp> page, @Param("appName") String appName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    SysApp selectByCode(@Param("appCode") String appCode);

}
