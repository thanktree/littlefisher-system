package com.littlefisher.core.biz.framework.service;

import java.util.List;

import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.biz.framework.request.AddSystemParamRequest;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.biz.framework.request.UpdateSystemParamRequest;

/**
 * Description: 系统信息参数
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemParamService {

    /**
     * Description: 根据条件查询
     *
     * @param req req
     * @return List<SystemParamDto>
     */
    List<SystemParamDto> getSystemParamList4PagerByCond(GetSystemParamList4PagerByCondRequest req);

    /**
     * Description: 根据key值查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    SystemParamDto getSystemParamByKey(String paramKey);

    /**
     * Description: 根据id查询系统参数
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    SystemParamDto getSystemParamById(Long systemParamId);

    /**
     * Description: 新增系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamDto addSystemParam(AddSystemParamRequest request);

    /**
     * Description: 根据key删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    int deleteSystemParamByKey(String paramKey);

    /**
     * Description: 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    int deleteSystemParamById(Long systemParamId);

    /**
     * Description: 修改系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamDto updateSystemParam(UpdateSystemParamRequest request);
}
