package com.shijie99.wcf.service;

import com.shijie99.wcf.entity.Permission;

public interface PermissionService {
	public Permission createPermission(Permission permission);
	
	public void deletePermission(Long permisssionId);
}
