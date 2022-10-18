package com.xd.pre.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.pre.common.utils.R;
import com.xd.pre.modules.sys.domain.SysApp;
import com.xd.pre.modules.sys.domain.SysMenu;
import com.xd.pre.modules.sys.domain.SysApp;
import com.xd.pre.modules.sys.dto.AppDTO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统应用表 服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
 */
public interface ISysAppService extends IService<SysApp> {

    /**
     * 保存应用
     * @param appDto
     * @return
     */
    R saveApp(AppDTO appDto);

    /**
     * 更新应用
     * @param appDto
     * @return
     */
    boolean updateApp(AppDTO appDto);

    /**
     * 根据主键删除应用
     * @param id
     * @return
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 获取应用列表
     * @return
     */
    IPage<SysApp> selectAppList(Page page,String appName,String startTime,String endTime);

}
