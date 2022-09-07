public class Member {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int membershipId;

    public Member(int id, String firstName, String lastName, int age, int membershipId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.membershipId = membershipId;
    }

    public void setMembership(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMembershipId() {
        return membershipId;
    }
}
