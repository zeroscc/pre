package com.xd.pre.modules.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.pre.common.utils.R;
import com.xd.pre.log.annotation.SysOperaLog;
import com.xd.pre.modules.sys.dto.AppDTO;
import com.xd.pre.modules.sys.service.ISysAppService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 * <p>
 * 系统应用表 前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
 */
@RestController
@RequestMapping("/app")
public class SysAppController {

    @Resource
    private ISysAppService appService;

    /**
     * 获取应用列表
     *
     * @return
     */
    @GetMapping
//    @PreAuthorize("hasAuthority('sys:app:view')")
    public R getappList(Page page, @RequestParam String appName, @RequestParam String time) {
        String startTime=null;
        String endTime=null;

        if (time != null && !"".equals(time)) {
            String[] times = time.split(",");
            Date dateStartTime = new Date(times[0]);
            Date dateEndTime = new Date(times[1]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTime= sdf.format(dateStartTime);
            endTime= sdf.format(dateEndTime);
        }

        return R.ok(appService.selectAppList(page,appName,startTime,endTime));
    }

    /**
     * 保存应用以及菜单权限
     *
     * @param appDto
     * @return
     */
    @SysOperaLog(descrption = "保存应用")
    @PostMapping
//    @PreAuthorize("hasAuthority('sys:app:add')")
    public R save(@RequestBody AppDTO appDto) {
        return appService.saveApp(appDto);
    }

    /**
     * 更新应用
     * @param appDto
     * @return
     */
    @SysOperaLog(descrption = "更新应用")
    @PutMapping
//    @PreAuthorize("hasAuthority('sys:app:update')")
    public R update(@RequestBody AppDTO appDto) {
        return R.ok(appService.updateApp(appDto));
    }

    /**
     * 删除应用以及权限
     * @param appId
     * @return
     */
    @SysOperaLog(descrption = "删除应用以及权限")
    @DeleteMapping("/{appId}")
//    @PreAuthorize("hasAuthority('sys:app:delete')")
    public R delete(@PathVariable("appId") Integer appId) {
        return R.ok(appService.removeById(appId));
    }

    @SysOperaLog(descrption = "批量删除应用")
    @DeleteMapping("/batch")
//    @PreAuthorize("hasAuthority('sys:app:delete')")
    public R deleteBatch( String ids) {
        System.out.println("访问");
        System.out.println(ids);
        String[] split = ids.split(",");
        int[] idsa = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println("ids[1] = " + idsa[1]);
        System.out.println(Collections.singleton(idsa));
        return R.ok(appService.removeByIds(Collections.singleton(idsa)));
    }

}

