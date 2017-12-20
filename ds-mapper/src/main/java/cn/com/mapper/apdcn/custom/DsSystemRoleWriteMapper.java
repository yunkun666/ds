package cn.com.mapper.apdcn.custom;

import java.util.List;

import cn.com.mapper.apdcn.mbg.MBGDsSystemRoleWriteMapper;
import cn.com.mapper.apdcn.vo.DsSystemRoleVO;

public interface DsSystemRoleWriteMapper extends MBGDsSystemRoleWriteMapper {
	
	List<DsSystemRoleVO> getListVO(DsSystemRoleVO vo);

	int getListVOCount(DsSystemRoleVO vo);
}