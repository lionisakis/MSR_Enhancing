# MSR_III : Enhance (Research) Assignment
**Note: This is a repository containing the code and results for a research question extended from a research paper, as a part of the MSR course 2021/22 at UniKo, CS department, SoftLang Team**
 
## Names of team/members
 
**Team:** Romeo
 
**Members:** Aishwarya Saravanan, Emmanouil Georgios Lionis, Prem Kumar Karki 
 
## Baseline study :
 
**Research Question:**  Can we reliably label combined API usage to be necessary, convenient, unnecessary,
problematic, or such?
 
**Steps followed:** Determining the labels, Sampling for project and scope, avoid that subjects need to be experts in several APIs, conduct the experiment and evaluate each others work. 
 
**Input data:** 5 respoitories for each team member to work on, sampled based on the popularity of repositories. 

**Output data:** 15 CSV files conataining labels for the dependencies present in each of the selected repository. 

**Labels used:** 
* Depedendent combined API usage
   * Compile Dependence
   * Provided Dependence
   * Runtime Dependence
   * Test Dependence
   * Managed Dependence
* Independent combined API usage
   * Separably Independent 
   * Meaningfully Independent

More infromation about labeling: https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html

 ## Data Collection  
Data sources are the Java projects that use Apache Maven as a build automation tool from the Github repositories. Data are collected with the help of the code of the [Katharina Gorjatschev thesis paper repository](https://github.com/gorjatschev/applying-apis) 

## Process
* **Use of Filter in [Application.java](https://github.com/lionisakis/MSR_Enhancing/blob/main/process/src/main/java/de/uni_koblenz/gorjatschev/applyingapis/Application.java) file** <br>
Following are the filter used in data collection and filter may change according to requirement. <br> <center style="padding: 40px"><img width="70%" src="https://github.com/lionisakis/MSR_Enhancing/blob/main/Image/filter1.jpg" title="Filter used in experiment" /> </center> 
* Repositories of were selected from collected repositories for manual labelling task.
### Manual Labelling 
* First check the POM.xml and list the APIs which were listed in dependecny tag.
* Check the Maven Repositories of each listed API and label the type of dependency exist between those APIs.
* Check the each code files of the repositories for import of APIs whether there is exist of meaningful independence or not.
* If the APIs are not used in any code file together then the APIs are seperable independence.

### Validation: ###
* Cross validation were done to check if they had the same results for complete manual labelling tasks for all team members.


## Visualisation: 
The findings have been visaulised using the visualisation.py file which has resulted in providing insights into the dominant labels present in each of the repositories that have two or more dependencies. (The resulting graphs can be found in the images folder)


## Finding:
* Almost in all repositories have Compile and Test dependencies

* Provided, Runtime and Managed dependencies were rarely used.

* Meaningful independence is less than Separable independence

* Junit is the most used Test API



## Implementation of this repository :
### Hardware requirements: 
OS : Windows (Used for process), MscOS, Linux (any OS in this would work) Minimum RAM : 4GB Minimum Storage : As the output is a collection of CSV files, minimum of 500MB - 1GB should be suitable
### Software requirements: 
We used the Eclipse IDE for processing Java files. Any IDE that can execute maven projects in Java language would be suitable for this. The version of Java must be the 11th edition (Java 11). Also, there is need for a GitHub access token in the file RepositoriesPicker.java file. In other words, one has to replace the USERNAME_AND_TOKEN in the file with the generated username and token from Github. 

For running the python files we used Visual Studio Code. Any suitable IDE that can run python files, should also be suitable. (Python 3.9.6)

Also, you need a connection with a network so you can access the online Maven site that gives more information about each repository and its API.
