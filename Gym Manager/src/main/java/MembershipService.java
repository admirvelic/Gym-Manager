import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembershipService {


    Scanner scanner = new Scanner(System.in);

    private ArrayList<Membership> memberships = new ArrayList<Membership>();

    private boolean uniqueId(int id) {
        for (int i = 0; i < memberships.size(); i++) {
            if (memberships.get(i).getId() == id) {
                return false;
            }
        }
        return true;
    }

    private boolean uniqueMemberId(int memeberId) {
        for (int i = 0; i < memberships.size(); i++) {
            if (memberships.get(i).getMemberId() == memeberId) {
                return false;
            }
        }
        return true;
    }

    public Membership fetchMembership(int id) {
        for (int i = 0; i < this.memberships.size(); i++) {
            Membership membership = this.memberships.get(i);
            if (membership.getId() == id) {
                System.out.println("============================================================");
                System.out.println("INFO of a membership with " + id + "ID number");
                System.out.println("Paid on date: " + membership.getPaidOnDate());
                System.out.println("Valid until: " + membership.getValidUntil());
                System.out.println("Members ID: " + membership.getMemberId());
                System.out.println("============================================================");
                return membership;
            }
        }
        System.out.println("You've enterd nonexistent membership ID");
        return null;
    }


    public List<Membership> fetchMemberships() {
        System.out.println("List of Memberships:");
        for (int i = 0; i < memberships.size(); i++) {
            System.out.println("============================================================");
            System.out.println("No" + (i + 1) + " membership");
            System.out.println("Membership ID: " + memberships.get(i).getId());
            System.out.println("Paid on date: " + memberships.get(i).getPaidOnDate());
            System.out.println("Valid until: " + memberships.get(i).getValidUntil());
            System.out.println("Member ID: " + memberships.get(i).getMemberId());
            System.out.println("============================================================");
        }
        return this.memberships;
    }


    public Membership addMembership() {

        System.out.println("============================================================");
        System.out.println("You are entering new membership info!");
        boolean ture = true;
        int id = 0;
        while (ture) {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
            if (uniqueId(id)) {
                break;
            }
            System.out.println("You've enterd ID number that already exists, please try again!");
        }
        System.out.print("Enter date it's paid on: ");
        int getDate =scanner.nextInt();
        scanner.nextLine();
        ThisDate paidOnDate = new ThisDate(getDate);
        System.out.print("Enter date it's valid to: ");
        getDate =scanner.nextInt();
        scanner.nextLine();
        ThisDate validUntil = new ThisDate(getDate);

        int memberId = 0;
        while (true) {
            System.out.print("Enter member ID: ");
            memberId = scanner.nextInt();
            scanner.nextLine();
            if (uniqueMemberId(memberId)) {
                break;
            }
            System.out.println("You've enterd member ID number that already has membership, please try again!");
        }


        System.out.println("============================================================");
        Membership membership = new Membership(id, paidOnDate, validUntil, memberId);
        return membership;
    }


    Membership updateMembership(int id) {
        Membership membership = fetchMembership(id);
        System.out.println("============================================================");
        System.out.println("Enter the number paired with the value you want to update.");
        System.out.println("(1)---membership ID");
        System.out.println("(2)---paid on date");
        System.out.println("(3)---valid until");
        System.out.println("(4)---member ID");
        System.out.println();


        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println("Enter new ID: ");
                int newId = scanner.nextInt();
                scanner.nextLine();
                membership.setId(newId);
                break;

            case 2:
                System.out.println("Enter new date: ");
                int date = scanner.nextInt();
                ThisDate newPaidOnDate = new ThisDate(date);
                scanner.nextLine();
                membership.setPaidOnDate(newPaidOnDate);
                break;

            case 3:
                System.out.println("Enter new date: ");
                date = scanner.nextInt();
                scanner.nextLine();
                membership.setValidUntil(date);
                break;

            case 4:
                System.out.println("Enter new member ID: ");
                int newMemberID = scanner.nextInt();
                scanner.nextLine();
                membership.setMemberId(newMemberID);
                break;

                default:
                    System.out.println("You have enterd the wrong value");
                    System.out.println("============================================================");
                    return null;
        }
        System.out.println("============================================================");
        return membership;
    }

    void deleteMembership(int id) {
        Membership membership = fetchMembership(id);
        memberships.remove(membership);
        System.out.println("You have deleted membership that had " + id + "ID number");
    }
}
