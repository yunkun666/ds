package cn.com.mapper.apdcn.custom;

import java.util.List;

import cn.com.mapper.apdcn.mbg.MBGDsSystemFunctionWriteMapper;
import cn.com.mapper.apdcn.pojo.DsSystemFunction;
import cn.com.mapper.apdcn.vo.DsSystemFunctionVO;
import cn.com.mapper.system.vo.MenuPowerVO;

public interface DsSystemFunctionWriteMapper extends MBGDsSystemFunctionWriteMapper {
	
	List<DsSystemFunctionVO> getListVO(DsSystemFunctionVO vo);

	int getListVOCount(DsSystemFunctionVO vo);

	List<DsSystemFunction> getList(DsSystemFunction vo);

	int getListCount(DsSystemFunction vo);

	List<DsSystemFunctionVO> getPList(DsSystemFunctionVO tf);

	List<DsSystemFunctionVO> getNodeList(DsSystemFunctionVO vo);

	List<DsSystemFunctionVO> getVOList(DsSystemFunctionVO vo);

	List<MenuPowerVO> getSuperMenuPowerList(MenuPowerVO menuPowerVO);

	List<MenuPowerVO> getAgentMenuPowerList(MenuPowerVO menuPowerVO);

	List<MenuPowerVO> getSellerMenuPowerList(MenuPowerVO menuPowerVO);

	List<MenuPowerVO> getMenuPowerListByRoleId(MenuPowerVO menuPowerVO);
}