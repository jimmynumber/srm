/*
 * -------------------------------------------------------
 * @FileName Function.java
 * @Description function接口
 * @Author 00418053
 * @Copyright www.want-want.com Ltd. All rights reserved.
 * 注意：本内容仅限于旺旺集团内部传阅，禁止外泄以及用于其他商业目的
 * -------------------------------------------------------
 */
package com.want.srm.utils;

public interface Function<T, E> {

	public T callback(E e);

}