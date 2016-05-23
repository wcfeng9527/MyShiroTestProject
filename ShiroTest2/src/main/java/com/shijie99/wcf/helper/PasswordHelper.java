package com.shijie99.wcf.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.shijie99.wcf.entity.User;

public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String algorithmName = "md5";

	private final int hashIterations = 2;

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName,
									user.getUsername(), 
									ByteSource.Util.bytes(user.getCredentialsSalt()),
									hashIterations).toHex();
		user.setPassword(newPassword);
	}
}
