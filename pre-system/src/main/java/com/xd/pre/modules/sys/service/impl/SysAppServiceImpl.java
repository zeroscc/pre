package com.xd.pre.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.pre.common.utils.R;
import com.xd.pre.modules.sys.domain.SysApp;
import com.xd.pre.modules.sys.dto.AppDTO;
import com.xd.pre.modules.sys.mapper.SysAppMapper;
import com.xd.pre.modules.sys.service.ISysAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;


/**
 * <p>
 * 系统应用表 服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
 */
@Service
public class SysAppServiceImpl extends ServiceImpl<SysAppMapper, SysApp> implements ISysAppService {


    @Resource
    private SysAppMapper sysAppMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R saveApp(AppDTO appDto) {
        SysApp sysApp = new SysApp();
        BeanUtils.copyProperties(appDto, sysApp);
        //判断code是否存在
        SysApp sysApp1 = sysAppMapper.selectByCode(sysApp.getAppCode());
        if (sysApp1 != null) {
            return R.error("应用编码已存在");
        }
       return R.ok(sysAppMapper.insert(sysApp));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateApp(AppDTO appDto) {
        SysApp sysApp = new SysApp();
        BeanUtils.copyProperties(appDto, sysApp);
        baseMapper.updateById(sysApp);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeById(Serializable id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<SysApp> selectAppList(Page page, String appName,String startTime,String endTime) {
        return sysAppMapper.selectAppListPage(page,appName,startTime,endTime);
    }


}
