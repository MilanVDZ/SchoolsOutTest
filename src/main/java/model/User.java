package model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@Entity
public class User {
    @Id
    private String login;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String passwordHash;
    private String salt;
    private boolean active;
    @OneToOne(cascade = CascadeType.DETACH)
    private Person person;

    public User() {
    }

    public User(String login, String passwordHash, boolean active, Person person) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.login = login;
        Random random = new Random();
        byte[] salt2 = new byte[16];
        random.nextBytes(salt2);
        KeySpec spec = new PBEKeySpec(passwordHash.toCharArray(), salt2, 5000, 100);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); // PBKDF2WithHmacSHA512

        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        this.salt = enc.encodeToString(salt2);
        this.passwordHash = enc.encodeToString(hash);
        this.active = active;
        this.person = person;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Random random = new Random();
        byte[] salt2 = new byte[16];
        random.nextBytes(salt2);
        KeySpec spec = new PBEKeySpec(passwordHash.toCharArray(), salt2, 50000, 100);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); // PBKDF2WithHmacSHA512
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        this.salt = enc.encodeToString(salt2);
        this.passwordHash = enc.encodeToString(hash);
    }

    public String getSalt() {
        return salt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", person=" + person +
                '}';
    }
}
