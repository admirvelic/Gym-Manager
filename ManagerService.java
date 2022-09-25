import java.util.Scanner;

public class ManagerService {

    public boolean checkMembership(Member member){

        int memberMembershipId = member.getMembershipId();
        int memberId = member.getId();
        Membership membership = new MembershipService().fetchMembership(memberMembershipId);
        int membershipMemberId = membership.getMemberId();

        if(membership==null){
            System.out.println("Member dose not have a valid membership");
            return false;
        }else if(membershipMemberId == memberId ){

            System.out.println("Member has a valid membership");
            return true;
        }
        return false;
    }

}
