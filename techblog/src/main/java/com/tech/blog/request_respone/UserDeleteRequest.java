package com.tech.blog.request_respone;

public class UserDeleteRequest extends UserIdRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the ADMIN who wants to delete a USER
     * The data is converted from JASON to the attributes specified in this class
     */

    private Integer idAdminUser;

    public UserDeleteRequest(Object idAdminUser, Object id) {
        super((Integer) id);
        this.idAdminUser = (Integer) idAdminUser;
    }

    public UserDeleteRequest() {
    }

    public Integer getIdAdminUser() {
        return idAdminUser;
    }

    public void setIdAdminUser(Integer idAdminUser) {
        this.idAdminUser = idAdminUser;
    }
}
