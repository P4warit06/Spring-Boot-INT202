package sit.practies.services;

import org.springframework.stereotype.Service;
import sit.practies.entitys.Profile;

@Service
public class RegisterService {
    private Profile profile;

    public Profile setProfile(String username, String email) {
        if (profile != null) {
            return this.profile;
        }
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setEmail(email);

        this.profile = profile;
        return profile;
    }
    public Profile getProfile() {
        return profile;
    }
}
