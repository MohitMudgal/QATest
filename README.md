# Learning Git and TestNG

## install git

# Main git commands

- git clone <url of the repo>

- git status

- git add --all

- git commit -m <"Message for commit">

- git pull

- git push

- git checkout branch-name


# To run parallel tests

mvn clean test -Dsurefire.suiteXmlFiles=testng.xml


# To run Single Test

mvn clean test -Dtest=DataDrivenTest
