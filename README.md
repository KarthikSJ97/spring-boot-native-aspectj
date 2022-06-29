# spring-boot-native-aspectj
A code example on how to configure native aspectj and eventually intercept nested & private methods

**Steps to run**
1. Clone the repository
2. Add the below command as VM option in IDE:
   1. `-javaagent:./infra/aspectjweaver-1.9.6.jar`
3. Run the server
4. Test if nested & private methods are intercepted at <http://localhost:8086/api/intercept>
5. Check console logs for better clarity
