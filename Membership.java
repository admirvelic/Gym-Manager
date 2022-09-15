public class Membership extends MembershipService{

    private int id;
    private ThisDate paidOnDate;
    private ThisDate validUntil;
    private int memberId;

    public Membership(){

    }
    public Membership(int id, ThisDate paidOnDate, ThisDate validUntil,int memberId){

        this.id = id;
        this.paidOnDate = paidOnDate;
        this.validUntil = validUntil;
        this.memberId = memberId;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThisDate getPaidOnDate() {
        return paidOnDate;
    }

    public void setPaidOnDate(ThisDate paidOnDate) {
        this.paidOnDate = paidOnDate;
    }

    public void setPaidonDate(int date){
        this.paidOnDate = new ThisDate(date);
    }

    public ThisDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(ThisDate validUntil) {
        this.validUntil = validUntil;
    }

    public void setValidUntil(int date){
        this.validUntil = new ThisDate(date);
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
