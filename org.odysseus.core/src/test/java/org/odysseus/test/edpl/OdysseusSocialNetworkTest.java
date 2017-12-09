package org.odysseus.test.edpl;

import static com.google.common.base.Preconditions.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.odysseus.api.MutatorSelector;
import org.odysseus.api.Odysseus;
import org.odysseus.api.RepositoryConnector;
import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.spi.module.SocialNetworkModule;
import org.odysseus.spi.module.mutators.AddCommentToPostMutator;
import org.odysseus.spi.module.mutators.AddFriendMutator;
import org.odysseus.spi.module.mutators.AddReactionToPostMutator;
import org.odysseus.spi.module.mutators.AddUserMutator;
import org.odysseus.spi.module.mutators.ChildBirthMutator;
import org.odysseus.spi.module.mutators.CreateGroupMutator;
import org.odysseus.spi.module.mutators.CreatePostMutator;
import org.odysseus.spi.module.mutators.JoinGroupMutator;
import org.odysseus.spi.module.mutators.MarriageMutator;
import org.odysseus.spi.module.mutators.SharePostMutator;
import org.odysseus.spi.module.mutators.UploadMediaFileMutator;

import com.google.common.io.Files;

public class OdysseusSocialNetworkTest {

	@Test
	public void canInstantiateOdysseus() {
		Odysseus odysseus = Odysseus.newInstance();
		checkNotNull(odysseus);
	}

	@Test
	public void canDetectConfigurationIssues() {
		Odysseus odysseus = Odysseus.newInstance();
		checkNotNull(odysseus);
		try {
			odysseus.runSimulation();
			fail();
		} catch (OdysseusConfigurationException expected) {
			// pass
		}
	}

	@Test
	public void canGenerateSimpleModel() {
		Odysseus odysseus = Odysseus.newInstance();
		odysseus.moduleConfig().setActiveModule(SocialNetworkModule.class);
		ResourceSet resourceSet = new ResourceSetImpl();
		File tempDir = Files.createTempDir();
		tempDir.deleteOnExit();
		try {
			File tempFile = new File(tempDir, "test.xmi");
			tempFile.deleteOnExit();
			tempFile.createNewFile();
			Resource resource = resourceSet.createResource(URI.createFileURI(tempFile.getAbsolutePath()));
			RepositoryConnector repo = odysseus.createResourceConnector(resource, false);
			odysseus.repositoryConfig().setConnector(repo);
			odysseus.simulationConfig().stopAfterIterions(50);
			odysseus.simulationConfig().setMutatorSelector(MutatorSelector.baseLikelyhood());
			odysseus.randomGeneratorConfig().setRandomSeed("MODELS2017");
			odysseus.runSimulation();
			// afterwards, print the model
			System.out.println(FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				FileUtils.deleteDirectory(tempDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	@Ignore("this is for manual testing")
	public void generateLargeModel() {
		Odysseus odysseus = Odysseus.newInstance();
		odysseus.moduleConfig().setActiveModule(SocialNetworkModule.class);
		ResourceSet resourceSet = new ResourceSetImpl();
		File tempDir = Files.createTempDir();
		tempDir.deleteOnExit();
		try {
			File tempFile = new File(tempDir, "test.xmi");
			tempFile.deleteOnExit();
			tempFile.createNewFile();
			Resource resource = resourceSet.createResource(URI.createFileURI(tempFile.getAbsolutePath()));
			RepositoryConnector repo = odysseus.createResourceConnector(resource, false);
			odysseus.repositoryConfig().setConnector(repo);
			odysseus.simulationConfig().setFlushInterval(10_000);
			odysseus.simulationConfig().stopAfterIterions(200_000);
			odysseus.simulationConfig().setMutatorSelector(MutatorSelector.baseLikelyhood());
			odysseus.randomGeneratorConfig().setRandomSeed("MODELS2017");
			odysseus.runSimulation();
			// afterwards, print the model
			String xmi = FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8);
			System.out.println(StringUtils.abbreviate(xmi, 3000));
			System.out.println("TEMP DIR IS AT: " + tempDir.getAbsolutePath());
			System.out.println("PRESS ENTER TO EXIT");
			try (Scanner scanner = new Scanner(System.in)) {
				scanner.nextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				FileUtils.deleteDirectory(tempDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	@Ignore("this is for manual testing")
	public void canGenerateDenseModel() {
		Odysseus odysseus = Odysseus.newInstance();
		odysseus.moduleConfig().setActiveModule(SocialNetworkModule.class);
		ResourceSet resourceSet = new ResourceSetImpl();
		File tempDir = Files.createTempDir();
		tempDir.deleteOnExit();
		try {
			File tempFile = new File(tempDir, "test.xmi");
			tempFile.deleteOnExit();
			tempFile.createNewFile();
			Resource resource = resourceSet.createResource(URI.createFileURI(tempFile.getAbsolutePath()));
			RepositoryConnector repo = odysseus.createResourceConnector(resource, true);
			odysseus.repositoryConfig().setConnector(repo);
			odysseus.simulationConfig().setFlushInterval(10_000);
			odysseus.simulationConfig().setStopCriterion(context -> {
				if (context.getIteration() % 1000 != 0) {
					return false;
				}
				long count = context.countInstancesOf(EcorePackage.Literals.EOBJECT, true);
				System.out.println("EObjects: " + count);
				return count >= 200_000;
			});
			odysseus.simulationConfig().setMutatorSelector(MutatorSelector.baseLikelyhood()
					//
					.likelyhood(AddCommentToPostMutator.class, 10)
					//
					.likelyhood(AddFriendMutator.class, 10)
					//
					.likelyhood(AddReactionToPostMutator.class, 20)
					//
					.likelyhood(AddUserMutator.class, 5)
					//
					.likelyhood(ChildBirthMutator.class, 1)
					//
					.likelyhood(CreateGroupMutator.class, 3)
					//
					.likelyhood(CreatePostMutator.class, 14)
					//
					.likelyhood(JoinGroupMutator.class, 4)
					//
					.likelyhood(MarriageMutator.class, 2)
					//
					.likelyhood(SharePostMutator.class, 8)
					//
					.likelyhood(UploadMediaFileMutator.class, 5));
			odysseus.randomGeneratorConfig().setRandomSeed("MODELS2017");
			odysseus.runSimulation();
			// afterwards, print the model
			String xmi = FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8);
			System.out.println(StringUtils.abbreviate(xmi, 3000));
			System.out.println("TEMP DIR IS AT: " + tempDir.getAbsolutePath());
			System.out.println("PRESS ENTER TO EXIT");
			try (Scanner scanner = new Scanner(System.in)) {
				scanner.nextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				FileUtils.deleteDirectory(tempDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
