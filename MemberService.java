import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService extends ManagerService{
    private final ArrayList<Member> members = new ArrayList<Member>();
    Scanner scanner = new Scanner(System.in);

    private boolean uniqueId(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return false;
            }
        }
        return true;
    }


    private boolean uniqueMembershipId(int membershipId) {
        for (Member member : members) {
            if (member.getMembershipId() == membershipId) {
                return false;
            }
        }
        return true;
    }


    public Member fetchMember(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                System.out.println("============================================================");
                System.out.println("INFO of a member with " + id + "ID number");
                System.out.println("First name: " + member.getFirstName());
                System.out.println("Last name: " + member.getLastName());
                System.out.println("Age: " + member.getAge());
                System.out.println("Membership ID: " + member.getMembershipId());
                System.out.println("============================================================");
                return member;
            }
        }
        System.out.println("You've entered nonexistent members ID");
        return null;
    }


    public List<Member> fetchMembers() {
        System.out.println("List of Members:");
        for (Member member : members) {
            System.out.println("============================================================");
            System.out.println("Member ID: " + member.getId());
            System.out.println("First name: " + member.getFirstName());
            System.out.println("Last name: " + member.getLastName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Membership ID: " + member.getMembershipId());
            System.out.println("============================================================");
        }
        return this.members;
    }


    public Member addMember() {
        int id = 0;
        System.out.println("============================================================");
        System.out.println("You are entering new members info!");
        boolean ture = true;
        while (ture) {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
            if (uniqueId(id)) {
                break;
            }
            System.out.println("You've entered ID number that already exists, please try again!");
        }
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        int membershipId = 0;
        while (ture) {
            System.out.print("Enter membership ID: ");
            membershipId = scanner.nextInt();
            scanner.nextLine();
            if (uniqueMembershipId(membershipId)) {
                break;
            }
            System.out.println("You've entered membership ID number that is connected to the to other member, please try again!");
        }
        System.out.println("============================================================");
        Member member = new Member(id, firstName, lastName, age, membershipId);
        members.add(member);
        return member;
    }


    public Member updateMember(int id) {
        Member member = fetchMember(id);
        System.out.println("============================================================");
        System.out.println("Enter the number paired with the value you want to update.");
        System.out.println("(1)---members ID");
        System.out.println("(2)---first name");
        System.out.println("(3)---last name");
        System.out.println("(4)---members age");
        System.out.println("(5)---membership ID");
        System.out.println();


        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                int newId = 0;
                boolean ture = true;
                while (ture) {
                    System.out.print("Enter new ID: ");
                    newId = scanner.nextInt();
                    scanner.nextLine();
                    if (uniqueId(newId)) {
                        break;
                    }
                    System.out.println("You've entered ID number that already exists, please try again!");
                }
                member.setId(newId);
                break;

            case 2:
                System.out.println("Enter new first name: ");
                String newFirstName = scanner.nextLine();
                member.setFirstName(newFirstName);
                break;

            case 3:
                System.out.println("Enter new last name: ");
                String newLastName = scanner.nextLine();
                member.setLastName(newLastName);
                break;

            case 4:
                System.out.println("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                member.setAge(newAge);
                break;

            case 5:
                System.out.println("Enter new membership ID: ");
                int newMembershipId = scanner.nextInt();
                scanner.nextLine();
                member.setMembership(newMembershipId);
                break;
        }
        System.out.println("============================================================");
        return member;
    }

    void deleteMember(int id) {
        Member member = fetchMember(id);
        members.remove(member);
        System.out.println("You have deleted member that had " + id + "ID number");
    }
}

