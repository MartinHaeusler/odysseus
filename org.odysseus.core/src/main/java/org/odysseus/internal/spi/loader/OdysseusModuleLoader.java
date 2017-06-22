package org.odysseus.internal.spi.loader;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;

import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.spi.OdysseusModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class OdysseusModuleLoader {

	private static final Logger LOG = LoggerFactory.getLogger(OdysseusModuleLoader.class);

	private static List<OdysseusModule> loadedModules = null;

	public static synchronized List<OdysseusModule> loadModules() {
		if (loadedModules != null) {
			return loadedModules;
		}
		LOG.info("Scanning classpath for Odysseus Modules...");
		ServiceLoader<OdysseusModule> loader = ServiceLoader.load(OdysseusModule.class);
		List<OdysseusModule> modules = Lists.newArrayList(loader);
		SetMultimap<String, OdysseusModule> qualifiedNameToModule = HashMultimap.create();
		SetMultimap<String, OdysseusModule> simpleNameToModule = HashMultimap.create();
		if (LOG.isInfoEnabled()) {
			List<String> moduleNames = Lists.newArrayList();
			for (OdysseusModule module : modules) {
				String moduleName = null;
				try {
					moduleName = module.getSimpleName();
					if (moduleName == null) {
						moduleName = module.getClass().getName();
					} else {
						moduleName += " (" + module.getQualifiedName() + "@" + module.getVersion() + ")";
					}
					moduleNames.add(moduleName);
					qualifiedNameToModule.put(module.getQualifiedName(), module);
					simpleNameToModule.put(module.getSimpleName(), module);
				} catch (Throwable t) {
					moduleNames.add(module.getClass().getName() + " [faulty: '" + t.toString() + "']");
				}
			}
			for (String qualifiedName : qualifiedNameToModule.keySet()) {
				Set<OdysseusModule> sameNameModules = qualifiedNameToModule.get(qualifiedName);
				if (sameNameModules.size() > 1) {
					LOG.warn("WARNING: " + sameNameModules.size() + " modules share the same qualified name of '"
							+ qualifiedName
							+ "'! This might lead to errors in module resolution. Please remove old versions and duplicates. The conflicting modules are: "
							+ modulesToString(sameNameModules));
				}
			}
			for (String simpleName : simpleNameToModule.keySet()) {
				Set<OdysseusModule> sameNameModules = simpleNameToModule.get(simpleName);
				if (sameNameModules.size() > 1) {
					LOG.warn("WARNING: " + sameNameModules.size() + " modules share the same simple name of '"
							+ simpleName
							+ "'! This might lead to errors in module resolution. Please remove old versions and duplicates. The conflicting modules are: "
							+ modulesToString(sameNameModules));
				}
			}
			if (modules.isEmpty() == false) {
				LOG.info("Found " + modules.size() + " Odysseus Modules: " + moduleNames.toString());
			}
		}
		if (modules.isEmpty()) {
			LOG.warn("WARNING: No Odysseus Modules were detected on your classpath!");
		}
		loadedModules = Collections.unmodifiableList(modules);
		return loadedModules;
	}

	public static synchronized OdysseusModule loadModule(final String module) {
		checkNotNull(module, "Precondition violation - argument 'module' must not be NULL!");
		List<OdysseusModule> allModules = loadModules();
		LOG.info("Searching for module '" + module + "'...");
		Set<OdysseusModule> candidateModules = Sets.newHashSet();
		// first pass: search by qualified name
		for (OdysseusModule m : allModules) {
			if (m.getQualifiedName().equals(module)) {
				candidateModules.add(m);
			}
		}
		if (candidateModules.size() == 1) {
			OdysseusModule m = Iterables.getOnlyElement(candidateModules);
			LOG.info("Search for module '" + module + "' resulted in matching module " + moduleToString(m));
			return m;
		} else if (candidateModules.size() > 1) {
			throw new OdysseusConfigurationException("The given module name '" + module
					+ "' matches several modules and is therefore ambiguous. The matching modules are: "
					+ modulesToString(candidateModules));
		}
		// second pass: search by class name
		for (OdysseusModule m : allModules) {
			if (m.getClass().getName().equals(module)) {
				candidateModules.add(m);
			}
		}
		if (candidateModules.size() == 1) {
			OdysseusModule m = Iterables.getOnlyElement(candidateModules);
			LOG.info("Search for module '" + module + "' resulted in matching module " + moduleToString(m));
			return m;
		} else if (candidateModules.size() > 1) {
			throw new OdysseusConfigurationException("The given module name '" + module
					+ "' matches several modules and is therefore ambiguous. The matching modules are: "
					+ modulesToString(candidateModules));
		}
		// third pass: search by simple name
		for (OdysseusModule m : allModules) {
			if (m.getSimpleName().equals(module)) {
				candidateModules.add(m);
			}
		}
		if (candidateModules.size() == 1) {
			OdysseusModule m = Iterables.getOnlyElement(candidateModules);
			LOG.info("Search for module '" + module + "' resulted in matching module " + moduleToString(m));
			return m;
		} else if (candidateModules.size() > 1) {
			throw new OdysseusConfigurationException("The given module name '" + module
					+ "' matches several modules and is therefore ambiguous. The matching modules are: "
					+ modulesToString(candidateModules));
		} else {
			throw new OdysseusConfigurationException("None of the " + allModules.size()
					+ " loaded modules matched the requested module '" + module + "'!");
		}
	}

	private static String moduleToString(final OdysseusModule module) {
		try {
			String moduleName = module.getSimpleName();
			if (moduleName == null) {
				moduleName = module.getClass().getName();
			} else {
				moduleName += " (" + module.getQualifiedName() + "@" + module.getVersion() + ")";
			}
			return moduleName;
		} catch (Throwable t) {
			return module.getClass().getName() + " [faulty: '" + t.toString() + "']";
		}
	}

	private static String modulesToString(final Iterable<OdysseusModule> modules) {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		String separator = "";
		for (OdysseusModule module : modules) {
			builder.append(separator);
			separator = ", ";
			builder.append(moduleToString(module));
		}
		builder.append(" ]");
		return builder.toString();
	}

}
