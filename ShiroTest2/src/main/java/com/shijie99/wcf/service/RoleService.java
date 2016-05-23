package com.shijie99.wcf.service;

import com.shijie99.wcf.entity.Role;

public interface RoleService {
	public Role createRole(Role role);
	
	public void deleteRole(Long roleId);
	//添加角色-权限之间的关系
	public void correlationPermissions(Long roleId,Long... permissionIds);
	
	public void uncorrelationPermissions(Long roleId,Long... permissionIds);
}
