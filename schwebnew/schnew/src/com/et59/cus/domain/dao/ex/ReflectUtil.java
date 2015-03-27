package com.et59.cus.domain.dao.ex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.log4j.Logger;
/**
 * 
 * <p>Title: ReflectUtil.java</p>
 * <p>Description: 反射</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-29 上午10:28:18
 * @version 2.0
 *
 */
public class ReflectUtil {

    private static final Logger log = Logger.getLogger(ReflectUtil.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setFieldValue(Object target, String fname, Class ftype,
            Object fvalue) {
        if (target == null
                || fname == null
                || "".equals(fname)
                || (fvalue != null && !ftype.isAssignableFrom(fvalue.getClass()))) {
            return;
        }
        Class clazz = target.getClass();
        try {
            Method method = clazz.getDeclaredMethod("set"
                    + Character.toUpperCase(fname.charAt(0))
                    + fname.substring(1), ftype);
            if (!Modifier.isPublic(method.getModifiers())) {
                method.setAccessible(true);
            }
            method.invoke(target, fvalue);

        } catch (Exception me) {
            if (log.isDebugEnabled()) {
               // log.debug("me异常-------->:"+me);
            }
            try {
                Field field = clazz.getDeclaredField(fname);
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
                field.set(target, fvalue);
            } catch (Exception fe) {
                if (log.isDebugEnabled()) {
                    log.debug("fe----------->"+fe);
                }
            }
        }
    }
}
