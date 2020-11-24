package webapp;

import webapp.utils.UserDto;

public class WebAppHelper {


    private WebAppHelper(){

    }

    public static UserDto loginInformation;

    // REST API Calls
    public static final String RestApiUrl = "http://localhost:8080";

    public static final String RestApiSecurity ="/security";

    public static final String RestApiLogin = "/login";

    public static final String RestApiUser= "/user";

    public static final String RestApiAddUser = "/addUser";

    public static final String RestApiRemoveUser = "/removeUser";

    public static final String RestApiAddProject = "/addProject";

    public static final String RestApiRemoveProject = "/removeProject";

    public static final String RestApiUpdateUser = "/updateUser";

    public static final String RestApiUpdateProject = "/updateProject";

    public static final String RestApiAddUserToProject = "/addUserToProject";

    public static final String RestApiRemoveUserFromProject = "/removeUserFromProject";

    public static final String RestApiGetProject = "/getProject";

    public static final String RestApiGetUser = "/getUser";

    public static final String RestApiTasks = "/tasks";

    public static final String RestApiGetTaskList = "/list";

}
