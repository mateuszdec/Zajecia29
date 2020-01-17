package org.javastart.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<EmailAddress> emailAddresses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Project> projects = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void addEmailAddress(EmailAddress emailAddress) {
        emailAddresses.add(emailAddress);
        emailAddress.setUser(this);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getUsers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", emailAddresses=" + emailAddresses +
                '}';
    }


}
