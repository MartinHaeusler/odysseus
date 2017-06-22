package org.odysseus.internal.util;

import static com.google.common.base.Preconditions.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtils {

	public static boolean isProxy(final Object object) {
		checkNotNull(object, "Precondition violation - argument 'object' must not be NULL!");
		return Proxy.isProxyClass(object.getClass());
	}

	@SuppressWarnings("unchecked")
	public static <T> T createProxy(final InvocationHandler handler, final Class<?>... interfaces) {
		checkNotNull(handler, "Precondition violation - argument 'handler' must not be NULL!");
		checkNotNull(interfaces, "Precondition violation - argument 'interfaces' must not be NULL!");
		checkArgument(interfaces.length > 0,
				"Precondition violation - argument 'interfaces' must specify at least one entry!");
		for (Class<?> clazz : interfaces) {
			checkArgument(clazz.isInterface(),
					"Precondition violation - argument '" + clazz.getName() + "' in 'interfaces' is not an Interface!");
		}
		Object newProxyInstance = Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(), interfaces, handler);
		return (T) newProxyInstance;
	}

	public static InvocationHandler getInvocationHandler(final Object proxy) {
		checkNotNull(proxy, "Precondition violation - argument 'proxy' must not be NULL!");
		return Proxy.getInvocationHandler(proxy);
	}

}
