# Rajeev_Repository
# **demo : Spring Boot project** 
# This roject use the Spring Boot with in built Tomcat 

# Main Commands which run from Command prompt - where your pom file exist

# **mvn package**

# **mvn spring-boot: run**    (This will start the Tomcat on your local command prompt. Please run from the folder which has pom file)


-------------   Git Commands Below ----------------------
First Time pushing Code to Git Repository:
1.	Create the git repository in the Git Lab browser
Example: https://github.com/rajeevchaturvedi2007/demo-repository-rajeev
2.	Copy the Clone URL of the git project
Example: https://github.com/rajeevchaturvedi2007/demo-repository-rajeev.git
3.	Create a folder in your C: Drive 
Example: c:/temp
4.	Now open the Git Bash Command prompt and go inside the /temp folder
a.	Example: c:/temp:
5.	Now run the command – git clone cloneURL
a.	This command will create a folder inside the folder from which you run this command. The name of the folder will be the name of the git repository
b.	Example: c:/temp/demo-repository-rajeev
6.	Now copy the whole source code which you want to push to the Git Repository
7.	Now, go to folder (created in step 5) in the Git Bash Command prompt
a.	Example: c:/temp/ demo-repository-rajeev> Here all your source Code including all files etc.
8.	No time to push all the code into the git repository from the Git Bash Command prompt inside the correct folder – where all your source code
a.	git add –all
b.	git commit -m “Initial Message »
c.	git push -u origin master
d.	git status
The code is success fully push or inserted in your git repository, check it in the git repository. 

Create the feature_1234 branch and push the code from master branch to feature_1234
1.	Go to git repository on the browser
2.	You can see there- master branch with drop down option
3.	In drop down, give new branch name – example: feature_1234
4.	Feature branch created success fully
5.	Go to Git Bash Command Prompt – inside the folder where all source code – which you want to move to feature branch. This is currently pointing to master branch
Example: c:/temp/demo-repository-rajeev
6.	Run the following commands:
a.	git fetch && git checkout feature_1234
Now your code is pointing to the feature_1234 branch
Very Important: If you give command : code . from Git Bash Command Prompt, it will open the project in the Visual Code



Push Changes to Git Repository
Suppose , you are in feature branch in the Git Bash Command Prompt and make changes in the file and want to push changes to the feature branch of the repository
On Git Bash Command prompt, run the below command
1.	git add –all
2.	git commit -m “some message”
3.	git push -u origin feature_1234  (in case of master , use master branch name)
4.	git status

Other important command:
Git init
Git add . (First time commit)



https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/
