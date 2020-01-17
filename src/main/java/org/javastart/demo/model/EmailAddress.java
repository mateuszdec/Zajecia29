package org.javastart.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmailAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    @ManyToOne
    private User user;

    public EmailAddress() {
    }

    public EmailAddress(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", user=" + user.getFirstName() +
                '}';
    }
}
