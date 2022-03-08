package de.uni_koblenz.gorjatschev.applyingapis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

 import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * This java project collects Java repositories from GitHub, selects a part of
 * them based on their declared dependencies and parses them.
 * 
 * This class contains the main method of this project with all its customizable
 * parameters (except for the GitHub PAT which can be found in
 * {@code RepositoriesPicker}).
 */
public class Application {
     	private static final Logger log = Utils.getLogger();
        private static final boolean COLLECT_REPOSITORIES = true;
        private static final boolean GET_DEPENDENCIES_OF_COLLECTED_REPOSITORIES = true;
        private static final boolean GET_MCR_TAGS_OF_COLLECTED_REPOSITORIES = true;
        private static final boolean SELECT_REPOSITORIES = true;
        private static final boolean PARSE_REPOSITORIES = true;
        private static final boolean COLLECT_API_CATEGORIES = true;
        private static final boolean DOWNLOAD_JARS = true;
        private static final int STARS_LIMIT = 100; // at least 100 stars
        private static final int CONTRIBUTOR_LIMIT = 2; // at least 2 contributors
        private static final int COMMITS_LIMIT = 100; // at least 100 commits
        private static final int DEPENDENCIES_LIMIT = 15; // at most 30 dependencies
        private static final int FILES_LIMIT = 200; // at most 1000 files
        private static final List<String> DEPENDENCIES = List.of(); // can be left empty

        /**
         * Runs everything that is needed according to the chosen parameters in the
         * {@code Application} class.
         * 
         * @param args
         * @throws IllegalStateException
         * @throws IOException
         * @throws InterruptedException
         */
        public static void main(String[] args) throws IllegalStateException, IOException, InterruptedException {
                long startTime = System.currentTimeMillis();
                // Collect all Java GitHub repositories that use Maven and meet the limit
                // conditions
                if (COLLECT_REPOSITORIES) {
                        RepositoriesPicker.collectRepositories(STARS_LIMIT, CONTRIBUTOR_LIMIT, COMMITS_LIMIT);
                }
//                // // Collect the dependencies of the collected repositories such that they
//                // // can be used for a separate analysis of all dependencies
//                if (GET_DEPENDENCIES_OF_COLLECTED_REPOSITORIES) {
//                        RepositoriesPicker.getDependenciesOfCollectedRepositories();
//                }
//                // // Collect the MCR tags of all used dependencies in the collected repositories
//                // // and assign them to the repositories
//                if (GET_MCR_TAGS_OF_COLLECTED_REPOSITORIES) {
//                        RepositoriesPicker.getMcrTagsOfDependenciesOfCollectedRepositories();
//                }
                // // Select repositories out of the collected repositories based on their
                // // declared dependencies and the dependencies limit and files limit
                if (SELECT_REPOSITORIES) {
                        RepositoriesPicker.selectRepositories(DEPENDENCIES, DEPENDENCIES_LIMIT, FILES_LIMIT);
                }
                // // Parse the selected repositories
                
                log.info("Successful.");
                long stopTime = System.currentTimeMillis();
                Duration d = Duration.ofMillis(stopTime - startTime);
                log.info("Execution took " + d.toHours() + " hour(s), " + d.toMinutesPart() + " minute(s) and " + d.toSecondsPart() + " second(s).");

        }

}
