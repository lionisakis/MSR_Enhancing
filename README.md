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

 ## Data Collection  
Data sources are the Java projects that use Apache Maven as a build automation tool from the Github repositories. Data are collected with the help of the code of the [Katharina Gorjatschev thesis paper repository](https://github.com/gorjatschev/applying-apis) 

## Process Delta
* Use of Filter in [Application.java](https://github.com/lionisakis/MSR_Enhancing/blob/main/process/src/main/java/de/uni_koblenz/gorjatschev/applyingapis/Application.java) file \n
Following are the filter used in data collection and filter may change according to requirement. \n <center style="padding: 40px"><img width="70%" src="https://github.com/lionisakis/MSR_Enhancing/blob/main/Image/filter1.jpg" title="Filter used in experiment" /> </center>
## Findings:
## Implementation of this repository :
### Hardware requirements: 
### Software requirements: 
**Validation:** 
