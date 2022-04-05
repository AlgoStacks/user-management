package com.as.usermanagement.model;

public class User {

    private String userId;

    private String userHandleName;

    private String firstName;

    private String lastName;

    private String emailId;

    private Gender gender;

    private String about;

    //TODO
    //Identify the proper user and relation
    //private String education;

    //TODO
    //Check if this title is needed in our scenario
    //MR/MRS/MISS
    private UserTitle userTitle;

    //Profile headline(Profession or to specify any certificates)
    private String headline;

    //TODO
    //Identify this field use
    private String currentWorkProfession;

    //TODO
    //Identify the below scenario implementation
    // student/professional
    private UserType userType;

    //Graduation Year will appear only when user is student
    private String graduationYear;

    //YearsOfExperience will appear only when user is professional
    private String yearsOfExperience;

    private String website;

    //(linkedInUrl,gitHub,facebook)
    private String socialWebsite;

    private String profileCompletionPercentage;

    private String dateOfBirth;

    //for internationalization
    private PrefferedLanguage prefferedLanguage;

    private String timezone;

    private boolean isMobileNoVerified;

    private boolean isEmailIdVerified;

    //blocked/Unblocked
    private boolean isActive;

    private boolean isActivated;

    private boolean isDeleted;

    private String totalActiveSession;

    private String disablePublicProfile;

    private int coins;

    private String language;

    private String mobileNo;

}
