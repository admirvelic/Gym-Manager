import java.util.Scanner;

public class ManagerService {

    public boolean checkMembership(Member member, Membership membership){

        int memberMembershipId = member.getMembershipId();
        int memberId = member.getId();
        int membershipMemberId = membership.getMemberId();
        int membershipId = membership.getId();

        if(memberMembershipId == membershipId && memberId == membershipMemberId){
            ThisDate date = new ThisDate();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter date you want to check membership for:(format: 01_01_2022");
            int dateToCheckFor =date.daysSinceChrist(new ThisDate(scanner.nextInt()));
            scanner.nextLine();
            int validUntil =date.daysSinceChrist(membership.getValidUntil());
            if(validUntil > dateToCheckFor ){
                System.out.println("Membership is valid");
            }else {
                System.out.println("Membership not valid");
            }

        }
        return false;
    }

}
