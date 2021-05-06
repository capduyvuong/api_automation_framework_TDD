package Information;

public class CustomerInfo {
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    /*
        {
      "first_name": "Giang",
      "last_name": "Nguyen",
      "email": "test84965708094@gmail.com",
      "mobile": "84965708094",
      "gender": "male",
      "dob": "2000-09-20",
      "external_id": "JA123",
      "created_on": "2020-09-20T10:00:00",
      "created_by": "ja q7",
      "registered_store": "JAECOM",
      "group": "Group",
      "address": "Address",
      "district": "district",
      "city": "City",
      "member_type": "member_type",
      "description": "description",
      "residential_type": "residential_type",
      "acquisition_channel": "acquisition_channel",
      "source_of_customers": "source_of_customers",
      "reference_name": "reference_name",
      "reference_email": "reference_email",
      "reference_mobile": "reference_mobile",
      "waiver_skill": "Waiver_Skill",
      "social_account": "Social_account",
      "family_member": [
        {
          "name": "Giang",
          "email": "test123@gmail.com",
          "mobile": "84965708090",
          "gender": "male",
          "dob": "2000-09-20",
          "waiver_relationship": "waiver_relationship"
        },
        {
          "name": "Giang",
          "email": "test123@gmail.com",
          "mobile": "84965708090",
          "gender": "male",
          "dob": "2000-09-20",
          "waiver_relationship": "waiver_relationship"
        }
      ]
    }
         */
    public String firstName;

}
