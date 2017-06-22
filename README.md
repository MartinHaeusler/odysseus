# Odysseus
Odysseus is a generic generator for synthetic EMF instance models. Using an appropriate *Module*, you can generate an instance model for any Ecore metamodel. The generator has the following properties:

  - **Deterministic:** It produces the same output model for the same input parameters.
  - **Scalable:** It can generate models of any size. The termination condition is configurable.
  - **Domain-Aware:** It will respect domain constraints beyond syntactical correctness for more realistic output models.
  - **Variability:** You can tweak the initial random seed to produce an infinite number of different output models.
  - **Modularity:** New modules can easily be added. Look at the definition of the Odysseus Module SPI for details.
  - **Evolutionary:** Models are generated step by step, and every evolution step is observable. The generator is not a "black box".
  
# Installation
Sorry, no maven repository for this project yet. Download the sources and run `./gradlew build` to produce the output `JAR` files. Add them to your project as needed. You will need at least the Odysseus SPI, the Odysseus Core and at least one Odysseus Module (e.g. the social network module).

# Usage
Basically you create a new instance of the `Odysseus` class, configure it, and run it. Here's a snippet to get you started (using the social network module):

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
