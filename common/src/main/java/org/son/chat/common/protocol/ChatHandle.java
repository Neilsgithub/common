package org.son.chat.common.protocol;

import java.io.UnsupportedEncodingException;

import org.son.chat.common.net.core.coder.IHandle;
import org.son.chat.common.net.core.coder.IcoderCtx;

/**
 * 简单聊天业务处理
 * @author solq
 */
public class ChatHandle implements IHandle<String, byte[]> {

	@Override
	public byte[] encode(String value, IcoderCtx ctx) {
		try {
			return value.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String decode(byte[] value, IcoderCtx ctx) {
		try {
			return new String(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean verify(Object value, IcoderCtx ctx) {
		// 测试不做验证
		return true;
	}

	@Override
	public void handle(String value, IcoderCtx ctx) {
		System.out.println("接收到信息 : " + value);

	}

}
