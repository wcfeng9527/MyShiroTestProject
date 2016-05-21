package com.shijie99.wcf.shiro.test;

import java.security.Key;

import junit.framework.Assert;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

/**
 * 加密Test
 * @author Administrator
 *
 */
public class CryptographyTest {
	
	@Test
	public void test(){
		String str = "hello";
		String str1 = "123";
		String md5 = new Md5Hash(str, str1, 2).toString();
		System.out.println(md5);
		
		DefaultHashService hashService = new DefaultHashService();
		hashService.setHashAlgorithmName("SHA-512");
		hashService.setPrivateSalt(new SimpleByteSource("123"));
		hashService.setGeneratePublicSalt(true);
		//用于生成公盐，默认就这个
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
		//生成Hash值的迭代次数
		hashService.setHashIterations(1);
		
		HashRequest request = new HashRequest.Builder()
								.setAlgorithmName("MD5")
								.setSource(ByteSource.Util.bytes("hello"))
								.setSalt(ByteSource.Util.bytes("123"))
								.setIterations(2)
								.build();
		String hex = hashService.computeHash(request).toHex();
		System.out.println(hex);
	}
	
	@Test
	public void AESTest(){
		AesCipherService aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(128);
		//生成key
		Key key = aesCipherService.generateNewKey();
		String text = "hello";
		//加密
		String encrptTesxt = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
		//解密
		String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptTesxt), key.getEncoded()).getBytes());
		Assert.assertEquals(text, text2);
	}
}
