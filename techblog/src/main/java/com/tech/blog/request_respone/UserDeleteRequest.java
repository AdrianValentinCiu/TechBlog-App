package com.tech.blog.request_respone;

public class UserDeleteRequest extends UserIdRequest {
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
