/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

/**
 *
 * @author PC
 */
public class User {

    private String username;
    private String password;
    private boolean enabled;
    private String fullname;
    private String photo = "photo.png";
    private boolean manager;

    // Constructor không tham số
    public User() {
        // photo đã có giá trị mặc định là "photo.png"
    }

    // Constructor đầy đủ tham số
    public User(String username, String password, boolean enabled, String fullname, String photo, boolean manager) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.fullname = fullname;
        this.photo = (photo == null || photo.isEmpty()) ? "photo.png" : photo;
        this.manager = manager;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và Setter cho enabled
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // Getter và Setter cho fullname
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // Getter và Setter cho photo
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = (photo == null || photo.isEmpty()) ? "photo.png" : photo;
    }

    // Getter và Setter cho manager
    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    // toString
    @Override
    public String toString() {
        return "User{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", enabled=" + enabled
                + ", fullname='" + fullname + '\''
                + ", photo='" + photo + '\''
                + ", manager=" + manager
                + '}';
    }

    // equals và hashCode (tuỳ chọn)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (enabled != user.enabled) {
            return false;
        }
        if (manager != user.manager) {
            return false;
        }
        if (username != null ? !username.equals(user.username) : user.username != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }
        if (fullname != null ? !fullname.equals(user.fullname) : user.fullname != null) {
            return false;
        }
        return photo != null ? photo.equals(user.photo) : user.photo == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (manager ? 1 : 0);
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String username;
        private String password;
        private boolean enabled;
        private String fullname;
        private String photo = "photo.png";
        private boolean manager;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder photo(String photo) {
            this.photo = (photo == null || photo.isEmpty()) ? "photo.png" : photo;
            return this;
        }

        public Builder manager(boolean manager) {
            this.manager = manager;
            return this;
        }

        public User build() {
            return new User(username, password, enabled, fullname, photo, manager);
        }
    }
}
