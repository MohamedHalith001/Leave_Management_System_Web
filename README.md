# Leave_Management_System_Web Project (JSP/Servlet)

Leave Management System is a application can be used to automate the workflows of leave requests and their approvals of a corporate network.

### Feature 1 : Login

* Uses a common login for both admin and employee

* Verifies the login credentials and redirects to the pages accordingly.

Classes : LoginValidator.java ==>  boolean adminVerification(User), boolean employeeVerification(User)

**Tested and passed all the TestCases**

### Feature 2 : Logout

* Logged in user should be able to logout from his account

## Module : Employee

### Feature 3: Apply for Leave

* Employee can login to his account and apply for leave with necessary details.

Classes : LeaveRequestManager.java ==> addRequest(LeaveRequest)

**Tested and passed all the TestCases**

### Feature 4: Cancel a request

* Employee can view and cancel any applied leave requests.

Classes : LeaveRequestManager.java  ==> cancelRequest(int)

**Tested and passed all the TestCases**

### Feature 5: View status of applied request

* Using this feature, employee can view the current status of his/her applied leave requests.

Classes: LeaveRequestManager.java ==> displayRequests()

**Tested and passed all the TestCases**

## Module : Admin

### Feature 6: View the leave requests

*  Can view the leave requests of the employee and can approve or deny those leave requests.

**Tested and passed all the TestCases**

### Feature 7: Approve leave request

* Admin can approve the leave requests if he wants to.

Classes : LeaveRequestManager.java ==> approveRequest(int)

### Feature 8: Approve leave request

* Admin can reject the leave requests if he needs to.

Classes : LeaveRequestManager.java ==> rejectRequest(int)
