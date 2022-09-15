import java.util.Scanner;

public class Menu {
    Scanner scanner=new Scanner(System.in);
    public  Menu(){

    }
    public void startMenu(){
        System.out.println("============================================================");
        System.out.println("Select action:");
        System.out.println("(1) Check membership");
        System.out.println("(2) Manage members");
        System.out.println("(3) Manage memberships");
        System.out.println("============================================================");

        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input){
            case 1:
                checkMembershipMenu();
                break;

            case 2:
                manageMembersMenu();
                break;

            case 3:
                manageMembershipsMenu();
                break;

            default:
                System.out.println("You entered the wrong value");
                break;
        }
        startMenu();
    }

    private void checkMembershipMenu(){
        int id;
        System.out.println("============================================================");
        System.out.println("Please enter ID number of a member you want to check membership for:");
        System.out.println("============================================================");
        id = scanner.nextInt();
        scanner.nextLine();

        Member member = new Member().fetchMember(id);
        boolean membershipStatus = member.checkMembership(member);
        if (membershipStatus){
        new Membership().fetchMembership(member.getMembershipId());
        }
    }

    private void manageMembersMenu(){
        int input;
        System.out.println("============================================================");
        System.out.println("Select action:");
        System.out.println("(1) See all members");
        System.out.println("(2) Add member");
        System.out.println("(3) Update member");
        System.out.println("(4) Delete member");
        System.out.println("(5) Go back");
        System.out.println("============================================================");
        input = scanner.nextInt();
        scanner.nextLine();

        switch (input){
            case 1:
                new Member().fetchMembers();
                break;

            case 2:
                new Member().addMember();
                break;

            case 3:
                System.out.println("Please enter the ID number of a member you want to update:");
                int updateId = scanner.nextInt();
                scanner.nextLine();
                new Member().updateMember(updateId);
                break;

            case 4:
                System.out.println("Please enter the ID number of a member you want to delete:");
                int deleteId = scanner.nextInt();
                scanner.nextLine();
                new Member().deleteMember(deleteId);
                break;

            case 5:
                startMenu();
                break;

            default:
                System.out.println("You entered the wrong value");
                break;
        }
        manageMembersMenu();
    }


    private void manageMembershipsMenu(){
        int input;
        System.out.println("============================================================");
        System.out.println("Select action:");
        System.out.println("(1) See all memberships");
        System.out.println("(2) Add membership");
        System.out.println("(3) Update membership");
        System.out.println("(4) Delete membership");
        System.out.println("(5) Go back");
        System.out.println("============================================================");
        input = scanner.nextInt();
        scanner.nextLine();
        switch (input){
            case 1:
                new Membership().fetchMemberships();
                break;

            case 2:
                new Membership().addMembership();
                break;

            case 3:
                System.out.println("Please enter the ID number of a membership you want to update:");
                int updateId = scanner.nextInt();
                scanner.nextLine();
                new Membership().updateMembership(updateId);
                break;

            case 4:
                System.out.println("Please enter the ID number of a membership you want to delete:");
                int deleteId = scanner.nextInt();
                scanner.nextLine();
                new Membership().deleteMembership(deleteId);
                break;

            case 5:
                startMenu();
                break;

            default:
                System.out.println("You entered the wrong value");
                break;
        }
        manageMembershipsMenu();
    }
}
